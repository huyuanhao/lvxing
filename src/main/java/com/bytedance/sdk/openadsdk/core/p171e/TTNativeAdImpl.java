package com.bytedance.sdk.openadsdk.core.p171e;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.DownloadStatusController;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener;
import com.bytedance.sdk.openadsdk.core.InteractionManager;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.p170d.Image;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.p185f.StatsLogManager;
import com.bytedance.sdk.openadsdk.p185f.p186a.LogStatsBase;
import com.bytedance.sdk.openadsdk.utils.Predicate;
import com.bytedance.sdk.openadsdk.utils.ResourceHelp;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.bytedance.sdk.openadsdk.core.e.a */
public class TTNativeAdImpl implements TTNativeAd {
    /* renamed from: a */
    private int f7499a;
    /* renamed from: g */
    protected final InteractionManager f7500g;
    /* renamed from: h */
    protected final MaterialMeta f7501h;
    /* renamed from: i */
    protected final Context f7502i;
    /* renamed from: j */
    protected TTAdDislike f7503j;
    /* renamed from: k */
    protected DownloadStatusController f7504k;
    /* renamed from: l */
    protected int f7505l;

    /* renamed from: a */
    private String m9532a(int i) {
        String str = "embeded_ad";
        return i != 1 ? i != 2 ? (i == 5 || i != 9) ? str : "draw_ad" : "interaction" : "banner_ad";
    }

    public View getAdView() {
        return null;
    }

    public TTNativeAdImpl(Context context, MaterialMeta kVar, int i) {
        Predicate.m12255a((Object) kVar, "materialMeta不能为null");
        this.f7501h = kVar;
        this.f7502i = context;
        this.f7505l = i;
        this.f7500g = new InteractionManager(this.f7502i, this, kVar, m9532a(i));
    }

    public void registerViewForInteraction(ViewGroup viewGroup, View view, AdInteractionListener adInteractionListener) {
        Predicate.m12255a((Object) viewGroup, "container不能为null");
        Predicate.m12255a((Object) view, "clickView不能为null");
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(view);
        registerViewForInteraction(viewGroup, arrayList, null, adInteractionListener);
    }

    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, AdInteractionListener adInteractionListener) {
        Predicate.m12255a((Object) viewGroup, "container不能为null");
        Predicate.m12255a((Object) list, "clickView不能为null");
        Predicate.m12258a(list.size() > 0, "clickViews数量必须大于等于1");
        registerViewForInteraction(viewGroup, list, list2, null, adInteractionListener);
    }

    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, View view, AdInteractionListener adInteractionListener) {
        Predicate.m12255a((Object) viewGroup, "container不能为null");
        Predicate.m12255a((Object) list, "clickView不能为null");
        boolean z = true;
        Predicate.m12258a(list.size() > 0, "clickViews数量必须大于等于1");
        if (list2 == null || list2.size() <= 0) {
            z = false;
        }
        m9535a(z);
        if (mo15044a()) {
            list2 = m9533a(list, list2);
        }
        this.f7500g.mo15841a(viewGroup, list, list2, view, adInteractionListener);
    }

    /* renamed from: a */
    private List<View> m9533a(List<View> list, List<View> list2) {
        LinkedList linkedList = new LinkedList();
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                linkedList.add(list.get(i));
            }
        }
        if (list2 != null && !list2.isEmpty()) {
            int size2 = list2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                linkedList.add(list2.get(i2));
            }
        }
        return linkedList;
    }

    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        Predicate.m12255a((Object) tTAppDownloadListener, "downloadListener不能为null");
        this.f7500g.mo15842a(tTAppDownloadListener);
    }

    public TTImage getVideoCoverImage() {
        MaterialMeta kVar = this.f7501h;
        if (kVar == null || kVar.mo15512z() == null) {
            return null;
        }
        return new TTImage(this.f7501h.mo15512z().mo15585a(), this.f7501h.mo15512z().mo15590b(), this.f7501h.mo15512z().mo15601f());
    }

    public Bitmap getAdLogo() {
        return BitmapFactory.decodeResource(this.f7502i.getResources(), ResourceHelp.m11934d(InternalContainer.m10059a(), "tt_ad_logo_small"));
    }

    public String getTitle() {
        if (this.f7501h.mo15426N() != null && !TextUtils.isEmpty(this.f7501h.mo15426N().mo15345c())) {
            return this.f7501h.mo15426N().mo15345c();
        }
        if (!TextUtils.isEmpty(getSource())) {
            return getSource();
        }
        return this.f7501h.mo15422J();
    }

    public String getDescription() {
        if (!TextUtils.isEmpty(this.f7501h.mo15422J())) {
            return this.f7501h.mo15422J();
        }
        return this.f7501h.mo15423K();
    }

    public String getButtonText() {
        return this.f7501h.mo15424L();
    }

    public int getAppScore() {
        if (this.f7501h.mo15426N() != null) {
            return this.f7501h.mo15426N().mo15350e();
        }
        return 0;
    }

    public int getAppCommentNum() {
        if (this.f7501h.mo15426N() != null) {
            return this.f7501h.mo15426N().mo15351f();
        }
        return 0;
    }

    public int getAppSize() {
        if (this.f7501h.mo15426N() != null) {
            return this.f7501h.mo15426N().mo15352g();
        }
        return 0;
    }

    public String getSource() {
        return this.f7501h.mo15413A();
    }

    public TTImage getIcon() {
        if (this.f7501h.mo15415C() == null) {
            return null;
        }
        return Image.m9324a(this.f7501h.mo15415C());
    }

    public List<TTImage> getImageList() {
        ArrayList arrayList = new ArrayList();
        if (this.f7501h.mo15418F() != null && !this.f7501h.mo15418F().isEmpty()) {
            for (Image a : this.f7501h.mo15418F()) {
                arrayList.add(Image.m9324a(a));
            }
        }
        return arrayList;
    }

    public int getInteractionType() {
        MaterialMeta kVar = this.f7501h;
        if (kVar == null) {
            return -1;
        }
        return kVar.mo15414B();
    }

    public int getImageMode() {
        MaterialMeta kVar = this.f7501h;
        if (kVar == null) {
            return -1;
        }
        return kVar.mo15429Q();
    }

    public List<FilterWord> getFilterWords() {
        MaterialMeta kVar = this.f7501h;
        if (kVar == null) {
            return null;
        }
        return kVar.mo15430R();
    }

    public TTAdDislike getDislikeDialog(Activity activity) {
        if (this.f7503j == null) {
            m9534a(activity);
        }
        return this.f7503j;
    }

    public TTAdDislike getDislikeDialog(final TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        if (tTDislikeDialogAbstract != null) {
            tTDislikeDialogAbstract.setMaterialMeta(this.f7501h);
            return new TTAdDislike() {
                public void setDislikeInteractionCallback(DislikeInteractionCallback dislikeInteractionCallback) {
                }

                public void showDislikeDialog() {
                    boolean z = (tTDislikeDialogAbstract.getContext() instanceof Activity) && !((Activity) tTDislikeDialogAbstract.getContext()).isFinishing();
                    if (z) {
                        tTDislikeDialogAbstract.show();
                    }
                }
            };
        }
        throw new IllegalArgumentException("dialog is null, please check");
    }

    public DownloadStatusController getDownloadStatusController() {
        if (this.f7504k == null) {
            InteractionManager nVar = this.f7500g;
            if (nVar != null) {
                final ITTDownloadAdapter a = nVar.mo15839a();
                if (a != null) {
                    this.f7504k = new DownloadStatusController() {
                        public void changeDownloadStatus() {
                            a.mo16520f();
                        }

                        public void cancelDownload() {
                            a.mo16521g();
                        }
                    };
                }
            }
        }
        return this.f7504k;
    }

    public void setActivityForDownloadApp(Activity activity) {
        if (activity != null) {
            this.f7500g.mo15840a(activity);
        }
    }

    public Map<String, Object> getMediaExtraInfo() {
        MaterialMeta kVar = this.f7501h;
        if (kVar != null) {
            return kVar.mo15436X();
        }
        return null;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=android.app.Activity, code=android.content.Context, for r3v0, types: [android.content.Context, android.app.Activity] */
    /* renamed from: a */
    private void m9534a(android.content.Context r3) {
        /*
        r2 = this;
        android.content.Context r0 = r2.f7502i
        boolean r1 = r0 instanceof android.app.Activity
        if (r1 == 0) goto L_0x0010
        android.app.Activity r0 = (android.app.Activity) r0
        boolean r0 = r0.isFinishing()
        if (r0 != 0) goto L_0x0010
        android.content.Context r3 = r2.f7502i
    L_0x0010:
        com.bytedance.sdk.openadsdk.dislike.b r0 = new com.bytedance.sdk.openadsdk.dislike.b
        com.bytedance.sdk.openadsdk.core.d.k r1 = r2.f7501h
        r0.m43956init(r3, r1)
        r2.f7503j = r0
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.p171e.TTNativeAdImpl.m9534a(android.app.Activity):void");
    }

    /* renamed from: a */
    private void m9535a(boolean z) {
        LogStatsBase c = LogStatsBase.m11308b().mo16590a(this.f7505l).mo16595c(String.valueOf(ToolUtils.m12018d(this.f7501h.mo15428P())));
        if (z) {
            StatsLogManager.m11278a().mo16577i(c);
        } else {
            StatsLogManager.m11278a().mo16578j(c);
        }
    }

    /* renamed from: a */
    private boolean mo15044a() {
        MaterialMeta kVar = this.f7501h;
        boolean z = false;
        if (kVar == null || kVar.mo15414B() == 5) {
            return false;
        }
        if (this.f7499a == 0) {
            this.f7499a = ToolUtils.m12018d(this.f7501h.mo15428P());
        }
        if (InternalContainer.m10069h().mo15782d(this.f7499a) == 1) {
            z = true;
        }
        return z;
    }
}
