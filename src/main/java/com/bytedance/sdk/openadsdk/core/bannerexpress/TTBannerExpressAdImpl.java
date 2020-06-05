package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd.AdInteractionListener;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.EmptyView.C2202a;
import com.bytedance.sdk.openadsdk.core.nativeexpress.ExpressAdLoadManager;
import com.bytedance.sdk.openadsdk.core.nativeexpress.ExpressAdLoadManager.C2274a;
import com.bytedance.sdk.openadsdk.core.nativeexpress.ExpressBackupListener;
import com.bytedance.sdk.openadsdk.core.nativeexpress.ExpressClickCreativeListener;
import com.bytedance.sdk.openadsdk.core.nativeexpress.ExpressClickListener;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.TTNativeExpressAdStub;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.dislike.TTAdDislikeImpl;
import com.bytedance.sdk.openadsdk.downloadnew.TTDownloadFactory;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.p165c.AdEventManager;
import com.bytedance.sdk.openadsdk.utils.C2538ak;
import com.bytedance.sdk.openadsdk.utils.C2538ak.C2539a;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import com.bytedance.sdk.openadsdk.utils.UIUtils;
import com.kwad.sdk.core.imageloader.core.download.BaseImageDownloader;
import com.tencent.bugly.BuglyStrategy.C7120a;
import discoveryAD.C7895e;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.bytedance.sdk.openadsdk.core.bannerexpress.b */
public class TTBannerExpressAdImpl extends TTNativeExpressAdStub implements C2539a {
    /* renamed from: a */
    TTDislikeDialogAbstract f7269a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public BannerExpressView f7270b;
    /* access modifiers changed from: private|final */
    /* renamed from: c */
    public final Context f7271c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public MaterialMeta f7272d;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public AdSlot f7273f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public ExpressAdInteractionListener f7274g;
    /* renamed from: h */
    private TTAppDownloadListener f7275h;
    /* access modifiers changed from: private */
    /* renamed from: i */
    public TTAdDislikeImpl f7276i;
    /* access modifiers changed from: private */
    /* renamed from: j */
    public ITTDownloadAdapter f7277j;
    /* renamed from: k */
    private C2538ak f7278k;
    /* renamed from: l */
    private int f7279l;
    /* renamed from: m */
    private DislikeInteractionCallback f7280m;
    /* renamed from: n */
    private Context f7281n;
    /* access modifiers changed from: private */
    /* renamed from: o */
    public String f7282o = "banner_ad";

    public TTBannerExpressAdImpl(Context context, MaterialMeta kVar, AdSlot adSlot) {
        this.f7271c = context;
        this.f7272d = kVar;
        this.f7273f = adSlot;
        this.f7270b = new BannerExpressView(context, kVar, adSlot);
        m9144b(this.f7270b.mo15304c(), this.f7272d);
    }

    public View getExpressAdView() {
        return this.f7270b;
    }

    public int getImageMode() {
        MaterialMeta kVar = this.f7272d;
        if (kVar == null) {
            return -1;
        }
        return kVar.mo15429Q();
    }

    public List<FilterWord> getFilterWords() {
        MaterialMeta kVar = this.f7272d;
        if (kVar == null) {
            return null;
        }
        return kVar.mo15430R();
    }

    public void setExpressInteractionListener(ExpressAdInteractionListener expressAdInteractionListener) {
        this.f7274g = expressAdInteractionListener;
        this.f7270b.mo15301a(expressAdInteractionListener);
    }

    public void setExpressInteractionListener(AdInteractionListener adInteractionListener) {
        this.f7274g = adInteractionListener;
        this.f7270b.mo15301a((ExpressAdInteractionListener) adInteractionListener);
    }

    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        this.f7275h = tTAppDownloadListener;
        ITTDownloadAdapter aVar = this.f7277j;
        if (aVar != null) {
            aVar.mo16509a(this.f7275h);
        }
    }

    public int getInteractionType() {
        MaterialMeta kVar = this.f7272d;
        if (kVar == null) {
            return -1;
        }
        return kVar.mo15414B();
    }

    public void render() {
        this.f7270b.mo15299a();
    }

    public void destroy() {
        BannerExpressView aVar = this.f7270b;
        if (aVar != null) {
            aVar.mo15303b();
        }
    }

    public void setDislikeCallback(Activity activity, DislikeInteractionCallback dislikeInteractionCallback) {
        if (dislikeInteractionCallback != null && activity != null) {
            this.f7280m = dislikeInteractionCallback;
            m9138a(activity, dislikeInteractionCallback);
        }
    }

    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        if (tTDislikeDialogAbstract == null) {
            C2564t.m12219b("dialog is null, please check");
            return;
        }
        this.f7269a = tTDislikeDialogAbstract;
        tTDislikeDialogAbstract.setMaterialMeta(this.f7272d);
        BannerExpressView aVar = this.f7270b;
        if (!(aVar == null || aVar.mo15304c() == null)) {
            this.f7270b.mo15304c().setOuterDislike(tTDislikeDialogAbstract);
        }
    }

    /* renamed from: a */
    private void m9138a(Activity activity, DislikeInteractionCallback dislikeInteractionCallback) {
        if (this.f7276i == null) {
            this.f7276i = new TTAdDislikeImpl(activity, this.f7272d);
        }
        this.f7281n = activity;
        this.f7276i.setDislikeInteractionCallback(dislikeInteractionCallback);
        BannerExpressView aVar = this.f7270b;
        if (aVar != null && aVar.mo15304c() != null) {
            this.f7270b.mo15304c().setDislike(this.f7276i);
        }
    }

    /* renamed from: a */
    private ITTDownloadAdapter m9136a(MaterialMeta kVar) {
        if (kVar.mo15414B() == 4) {
            return TTDownloadFactory.m11071a(this.f7271c, kVar, this.f7282o);
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9137a() {
        C2538ak akVar = this.f7278k;
        if (akVar != null) {
            akVar.removeCallbacksAndMessages(null);
            this.f7278k.sendEmptyMessageDelayed(112201, (long) this.f7279l);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m9142b() {
        C2538ak akVar = this.f7278k;
        if (akVar != null) {
            akVar.removeCallbacksAndMessages(null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m9143b(MaterialMeta kVar) {
        if (this.f7270b.mo15305d() != null && this.f7270b.mo15307f()) {
            m9140a(this.f7270b.mo15305d(), kVar);
            m9144b(this.f7270b.mo15305d(), kVar);
        }
    }

    /* renamed from: a */
    private void m9140a(NativeExpressView nativeExpressView, MaterialMeta kVar) {
        if (nativeExpressView != null && kVar != null) {
            if (this.f7280m != null) {
                this.f7276i.mo16453a(kVar);
                if (nativeExpressView != null) {
                    nativeExpressView.setDislike(this.f7276i);
                }
            }
            TTDislikeDialogAbstract tTDislikeDialogAbstract = this.f7269a;
            if (tTDislikeDialogAbstract != null) {
                tTDislikeDialogAbstract.setMaterialMeta(kVar);
                if (nativeExpressView != null) {
                    nativeExpressView.setOuterDislike(this.f7269a);
                }
            }
        }
    }

    /* renamed from: b */
    private void m9144b(final NativeExpressView nativeExpressView, final MaterialMeta kVar) {
        if (nativeExpressView != null && kVar != null) {
            this.f7272d = kVar;
            nativeExpressView.setBackupListener(new ExpressBackupListener() {
                /* renamed from: a */
                public boolean mo15189a(NativeExpressView nativeExpressView, int i) {
                    nativeExpressView.mo15882l();
                    BannerExpressBackupView bannerExpressBackupView = new BannerExpressBackupView(nativeExpressView.getContext());
                    bannerExpressBackupView.mo15295a(TTBannerExpressAdImpl.this.f7272d, nativeExpressView, TTBannerExpressAdImpl.this.f7277j);
                    bannerExpressBackupView.setDislikeInner(TTBannerExpressAdImpl.this.f7276i);
                    bannerExpressBackupView.setDislikeOuter(TTBannerExpressAdImpl.this.f7269a);
                    return true;
                }
            });
            this.f7277j = m9136a(kVar);
            ITTDownloadAdapter aVar = this.f7277j;
            if (aVar != null) {
                aVar.mo16513b();
                if (nativeExpressView.getContext() != null && (nativeExpressView.getContext() instanceof Activity)) {
                    this.f7277j.mo16507a((Activity) nativeExpressView.getContext());
                }
            }
            AdEventManager.m8392a(kVar);
            EmptyView a = m9134a((ViewGroup) nativeExpressView);
            if (a == null) {
                a = new EmptyView(this.f7271c, nativeExpressView);
                nativeExpressView.addView(a);
            }
            ITTDownloadAdapter aVar2 = this.f7277j;
            if (aVar2 != null) {
                aVar2.mo16508a((View) a);
            }
            a.setCallback(new C2202a() {
                /* renamed from: a */
                public void mo14918a(boolean z) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("TAG=");
                    sb.append(TTBannerExpressAdImpl.this.f7282o);
                    sb.append(",onWindowFocusChanged....hasWindowFocus=");
                    sb.append(z);
                    C2564t.m12220b("checkWebViewIsTransparent", sb.toString());
                    if (TTBannerExpressAdImpl.this.f7277j != null) {
                        if (z) {
                            if (TTBannerExpressAdImpl.this.f7277j != null) {
                                TTBannerExpressAdImpl.this.f7277j.mo16513b();
                            }
                        } else if (TTBannerExpressAdImpl.this.f7277j != null) {
                            TTBannerExpressAdImpl.this.f7277j.mo16516c();
                        }
                    }
                    String str = "TTBannerExpressAd";
                    if (z) {
                        TTBannerExpressAdImpl.this.m9137a();
                        C2564t.m12220b(str, "获得焦点，开始计时");
                        return;
                    }
                    C2564t.m12220b(str, "失去焦点，停止计时");
                    TTBannerExpressAdImpl.this.m9142b();
                }

                /* renamed from: a */
                public void mo14916a() {
                    if (TTBannerExpressAdImpl.this.f7277j != null) {
                        TTBannerExpressAdImpl.this.f7277j.mo16504a();
                    }
                }

                /* renamed from: b */
                public void mo14919b() {
                    if (TTBannerExpressAdImpl.this.f7277j != null) {
                        TTBannerExpressAdImpl.this.f7277j.mo16518d();
                    }
                }

                /* renamed from: a */
                public void mo14917a(View view) {
                    C2564t.m12220b("TTBannerExpressAd", "ExpressView SHOW");
                    HashMap hashMap = new HashMap();
                    hashMap.put("dynamic_show_type", Integer.valueOf(nativeExpressView.mo15883m()));
                    AdEventManager.m8389a(TTBannerExpressAdImpl.this.f7271c, kVar, TTBannerExpressAdImpl.this.f7282o, (Map<String, Object>) hashMap);
                    if (TTBannerExpressAdImpl.this.f7274g != null) {
                        TTBannerExpressAdImpl.this.f7274g.onAdShow(view, kVar.mo15414B());
                    }
                    if (kVar.mo15433U()) {
                        ToolUtils.m12001a(kVar, view);
                    }
                    TTBannerExpressAdImpl.this.m9137a();
                    if (!(TTBannerExpressAdImpl.this.f7863e.getAndSet(true) || TTBannerExpressAdImpl.this.f7270b == null || TTBannerExpressAdImpl.this.f7270b.mo15304c() == null)) {
                        UIUtils.m12056a(TTBannerExpressAdImpl.this.f7271c, TTBannerExpressAdImpl.this.f7272d, TTBannerExpressAdImpl.this.f7282o, (WebView) TTBannerExpressAdImpl.this.f7270b.mo15304c().getWebView());
                    }
                    if (TTBannerExpressAdImpl.this.f7270b != null && TTBannerExpressAdImpl.this.f7270b.mo15304c() != null) {
                        TTBannerExpressAdImpl.this.f7270b.mo15304c().mo15879i();
                        TTBannerExpressAdImpl.this.f7270b.mo15304c().mo15872g();
                    }
                }
            });
            ExpressClickListener eVar = new ExpressClickListener(this.f7271c, kVar, this.f7282o, 2);
            eVar.mo15277a((View) nativeExpressView);
            eVar.mo15283a(this.f7277j);
            nativeExpressView.setClickListener(eVar);
            ExpressClickCreativeListener dVar = new ExpressClickCreativeListener(this.f7271c, kVar, this.f7282o, 2);
            dVar.mo15277a((View) nativeExpressView);
            dVar.mo15283a(this.f7277j);
            nativeExpressView.setClickCreativeListener(dVar);
            ITTDownloadAdapter aVar3 = this.f7277j;
            if (aVar3 != null) {
                aVar3.mo16509a(this.f7275h);
            }
            a.setNeedCheckingShow(true);
        }
    }

    /* renamed from: a */
    private EmptyView m9134a(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }

    public Map<String, Object> getMediaExtraInfo() {
        MaterialMeta kVar = this.f7272d;
        if (kVar != null) {
            return kVar.mo15436X();
        }
        return null;
    }

    public void setSlideIntervalTime(int i) {
        if (i > 0) {
            this.f7282o = "slide_banner_ad";
            m9144b(this.f7270b.mo15304c(), this.f7272d);
            this.f7270b.mo15300a(1000);
            if (i < 30000) {
                i = C7120a.MAX_USERDATA_VALUE_LENGTH;
            } else if (i > 120000) {
                i = C7895e.f26888Cc;
            }
            this.f7279l = i;
            this.f7278k = new C2538ak(Looper.getMainLooper(), this);
        }
    }

    /* renamed from: c */
    private void m9146c() {
        ExpressAdLoadManager.m9985a(this.f7271c).mo15899a(this.f7273f, 1, null, new C2274a() {
            /* renamed from: a */
            public void mo15314a(List<MaterialMeta> list) {
                MaterialMeta kVar = list == null ? null : (MaterialMeta) list.get(0);
                TTBannerExpressAdImpl.this.f7270b.mo15302a(kVar, TTBannerExpressAdImpl.this.f7273f);
                TTBannerExpressAdImpl.this.m9143b(kVar);
                TTBannerExpressAdImpl.this.f7270b.mo15306e();
                TTBannerExpressAdImpl.this.m9137a();
            }

            /* renamed from: a */
            public void mo15313a() {
                TTBannerExpressAdImpl.this.m9137a();
            }
        }, BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT);
    }

    /* renamed from: a */
    public void mo14813a(Message message) {
        if (message.what == 112201) {
            m9146c();
        }
    }
}
