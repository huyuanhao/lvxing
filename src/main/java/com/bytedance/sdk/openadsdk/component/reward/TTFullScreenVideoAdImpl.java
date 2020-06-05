package com.bytedance.sdk.openadsdk.component.reward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdConstant.RitScenes;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener;
import com.bytedance.sdk.openadsdk.activity.TTFullScreenExpressVideoActivity;
import com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.SingleAppData;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.downloadnew.TTDownloadFactory;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.multipro.MultiGlobalInfo;
import com.bytedance.sdk.openadsdk.multipro.aidl.BinderPool;
import com.bytedance.sdk.openadsdk.multipro.aidl.p201a.FullScreenVideoListenerManagerImpl;
import com.bytedance.sdk.openadsdk.multipro.aidl.p202b.FullScreenVideoListenerImpl;
import com.bytedance.sdk.openadsdk.p198i.TTExecutor;
import com.bytedance.sdk.openadsdk.utils.ActivityUtil;
import com.bytedance.sdk.openadsdk.utils.ActivityUtil.C2540a;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.DigestUtils;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.component.reward.i */
class TTFullScreenVideoAdImpl implements TTFullScreenVideoAd {
    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final Context f6976a;
    /* renamed from: b */
    private final MaterialMeta f6977b;
    /* renamed from: c */
    private final AdSlot f6978c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public FullScreenVideoAdInteractionListener f6979d;
    /* renamed from: e */
    private ITTDownloadAdapter f6980e;
    /* renamed from: f */
    private boolean f6981f = true;
    /* renamed from: g */
    private boolean f6982g;
    /* renamed from: h */
    private String f6983h;
    /* renamed from: i */
    private String f6984i;
    /* renamed from: j */
    private AtomicBoolean f6985j = new AtomicBoolean(false);
    /* renamed from: k */
    private boolean f6986k = false;
    /* access modifiers changed from: private */
    /* renamed from: l */
    public String f6987l;

    TTFullScreenVideoAdImpl(Context context, MaterialMeta kVar, AdSlot adSlot) {
        this.f6976a = context;
        this.f6977b = kVar;
        this.f6978c = adSlot;
        if (getInteractionType() == 4) {
            this.f6980e = TTDownloadFactory.m11071a(this.f6976a, this.f6977b, "fullscreen_interstitial_ad");
        }
        this.f6982g = false;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6977b.hashCode());
        sb.append(this.f6977b.mo15459ae().toString());
        this.f6987l = DigestUtils.m12169a(sb.toString());
    }

    /* renamed from: a */
    public void mo15158a(boolean z) {
        this.f6986k = z;
    }

    /* renamed from: a */
    public void mo15157a(String str) {
        if (!this.f6985j.get()) {
            this.f6982g = true;
            this.f6983h = str;
        }
    }

    public void setFullScreenVideoAdInteractionListener(FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.f6979d = fullScreenVideoAdInteractionListener;
        m8788a(1);
    }

    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        ITTDownloadAdapter aVar = this.f6980e;
        if (aVar != null) {
            aVar.mo16509a(tTAppDownloadListener);
        }
    }

    public int getInteractionType() {
        MaterialMeta kVar = this.f6977b;
        if (kVar == null) {
            return -1;
        }
        return kVar.mo15414B();
    }

    public void showFullScreenVideoAd(Activity activity) {
        Intent intent;
        String str = "TTFullScreenVideoAdImpl";
        if (activity != 0 && activity.isFinishing()) {
            C2564t.m12226e(str, "showFullScreenVideoAd error1: activity is finishing");
        } else if (Looper.getMainLooper() != Looper.myLooper()) {
            C2564t.m12226e(str, "showFullScreenVideoAd error2: not main looper");
            throw new IllegalStateException("不能在子线程调用 TTFullScreenVideoAd.showFullScreenVideoAd");
        } else if (!this.f6985j.get()) {
            this.f6985j.set(true);
            MaterialMeta kVar = this.f6977b;
            if (!(kVar == null || kVar.mo15512z() == null)) {
                Context context = activity == 0 ? this.f6976a : activity;
                if (context == 0) {
                    context = InternalContainer.m10059a();
                }
                if (this.f6977b.mo15510x() != null) {
                    intent = new Intent(context, TTFullScreenExpressVideoActivity.class);
                } else {
                    intent = new Intent(context, TTFullScreenVideoActivity.class);
                }
                if (activity == 0) {
                    intent.addFlags(268435456);
                }
                intent.putExtra("show_download_bar", this.f6981f);
                intent.putExtra("orientation", this.f6978c.getOrientation());
                intent.putExtra("is_verity_playable", this.f6986k);
                if (!TextUtils.isEmpty(this.f6984i)) {
                    intent.putExtra("rit_scene", this.f6984i);
                }
                if (this.f6982g) {
                    intent.putExtra("video_cache_url", this.f6983h);
                }
                if (MultiGlobalInfo.m11808b()) {
                    intent.putExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA, this.f6977b.mo15459ae().toString());
                    intent.putExtra("multi_process_meta_md5", this.f6987l);
                } else {
                    SingleAppData.m10160a().mo15941g();
                    SingleAppData.m10160a().mo15932a(this.f6977b);
                    SingleAppData.m10160a().mo15930a(this.f6979d);
                    SingleAppData.m10160a().mo15933a(this.f6980e);
                    this.f6979d = null;
                }
                ActivityUtil.m12108a(context, intent, new C2540a() {
                    /* renamed from: a */
                    public void mo14890a() {
                    }

                    /* renamed from: a */
                    public void mo14891a(Throwable th) {
                        C2564t.m12223c("TTFullScreenVideoAdImpl", "show full screen video error: ", th);
                    }
                });
                if (!TextUtils.isEmpty(this.f6977b.mo15428P())) {
                    try {
                        String optString = new JSONObject(this.f6977b.mo15428P()).optString("rit", null);
                        AdSlot b = FullScreenVideoLoadManager.m8697a(this.f6976a).mo15117b(optString);
                        FullScreenVideoLoadManager.m8697a(this.f6976a).mo15116a(optString);
                        if (b != null) {
                            if (!this.f6982g || TextUtils.isEmpty(this.f6983h)) {
                                FullScreenVideoLoadManager.m8697a(this.f6976a).mo15114a(b);
                            } else {
                                FullScreenVideoLoadManager.m8697a(this.f6976a).mo15119b(b);
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    public void showFullScreenVideoAd(Activity activity, RitScenes ritScenes, String str) {
        if (ritScenes == null) {
            C2564t.m12226e("TTFullScreenVideoAdImpl", "The param ritScenes can not be null!");
            return;
        }
        if (ritScenes == RitScenes.CUSTOMIZE_SCENES) {
            this.f6984i = str;
        } else {
            this.f6984i = ritScenes.getScenesName();
        }
        showFullScreenVideoAd(activity);
    }

    public void setShowDownLoadBar(boolean z) {
        this.f6981f = z;
    }

    public Map<String, Object> getMediaExtraInfo() {
        MaterialMeta kVar = this.f6977b;
        if (kVar != null) {
            return kVar.mo15436X();
        }
        return null;
    }

    public int getFullVideoAdType() {
        MaterialMeta kVar = this.f6977b;
        if (kVar == null) {
            return -1;
        }
        if (kVar.mo15503q() && this.f6977b.mo15466c() == 1) {
            return 2;
        }
        if (!this.f6977b.mo15503q() || this.f6977b.mo15466c() != 0) {
            return 0;
        }
        return 1;
    }

    /* renamed from: a */
    private void m8788a(final int i) {
        if (MultiGlobalInfo.m11808b()) {
            TTExecutor.m11692a().mo16804a((Runnable) new Runnable() {
                public void run() {
                    BinderPool a = BinderPool.m11776a(TTFullScreenVideoAdImpl.this.f6976a);
                    if (i == 1 && TTFullScreenVideoAdImpl.this.f6979d != null) {
                        String str = "MultiProcess";
                        C2564t.m12220b(str, "start registerFullScreenVideoListener ! ");
                        FullScreenVideoListenerImpl cVar = new FullScreenVideoListenerImpl(TTFullScreenVideoAdImpl.this.f6979d);
                        IListenerManager asInterface = FullScreenVideoListenerManagerImpl.asInterface(a.mo16858a(1));
                        if (asInterface != null) {
                            try {
                                asInterface.registerFullVideoListener(TTFullScreenVideoAdImpl.this.f6987l, cVar);
                                C2564t.m12220b(str, "end registerFullScreenVideoListener ! ");
                            } catch (RemoteException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }, 5);
        }
    }
}
