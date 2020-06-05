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
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener;
import com.bytedance.sdk.openadsdk.activity.TTRewardExpressVideoActivity;
import com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.SingleAppData;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.downloadnew.TTDownloadFactory;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.multipro.MultiGlobalInfo;
import com.bytedance.sdk.openadsdk.multipro.aidl.BinderPool;
import com.bytedance.sdk.openadsdk.multipro.aidl.p201a.RewardAdVideoListenerManagerImpl;
import com.bytedance.sdk.openadsdk.multipro.aidl.p202b.RewardVideoListenerImpl;
import com.bytedance.sdk.openadsdk.p198i.TTExecutor;
import com.bytedance.sdk.openadsdk.utils.ActivityUtil;
import com.bytedance.sdk.openadsdk.utils.ActivityUtil.C2540a;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.DigestUtils;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.component.reward.j */
class TTRewardVideoAdImpl implements TTRewardVideoAd {
    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final Context f6991a;
    /* renamed from: b */
    private final MaterialMeta f6992b;
    /* renamed from: c */
    private final AdSlot f6993c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public RewardAdInteractionListener f6994d;
    /* renamed from: e */
    private ITTDownloadAdapter f6995e;
    /* renamed from: f */
    private boolean f6996f = true;
    /* renamed from: g */
    private boolean f6997g;
    /* renamed from: h */
    private String f6998h;
    /* renamed from: i */
    private String f6999i;
    /* renamed from: j */
    private AtomicBoolean f7000j = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    /* renamed from: k */
    public String f7001k;

    TTRewardVideoAdImpl(Context context, MaterialMeta kVar, AdSlot adSlot) {
        this.f6991a = context;
        this.f6992b = kVar;
        this.f6993c = adSlot;
        if (getInteractionType() == 4) {
            this.f6995e = TTDownloadFactory.m11071a(this.f6991a, this.f6992b, "rewarded_video");
        }
        this.f6997g = false;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6992b.hashCode());
        sb.append(this.f6992b.mo15459ae().toString());
        this.f7001k = DigestUtils.m12169a(sb.toString());
    }

    /* renamed from: a */
    public void mo15160a(String str) {
        if (!this.f7000j.get()) {
            this.f6997g = true;
            this.f6998h = str;
        }
    }

    public void setRewardAdInteractionListener(RewardAdInteractionListener rewardAdInteractionListener) {
        this.f6994d = rewardAdInteractionListener;
        m8796a(0);
    }

    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        ITTDownloadAdapter aVar = this.f6995e;
        if (aVar != null) {
            aVar.mo16509a(tTAppDownloadListener);
        }
    }

    public int getInteractionType() {
        MaterialMeta kVar = this.f6992b;
        if (kVar == null) {
            return -1;
        }
        return kVar.mo15414B();
    }

    public void setShowDownLoadBar(boolean z) {
        this.f6996f = z;
    }

    public int getRewardVideoAdType() {
        MaterialMeta kVar = this.f6992b;
        if (kVar == null) {
            return -1;
        }
        if (kVar.mo15503q() && this.f6992b.mo15466c() == 1) {
            return 2;
        }
        if (!this.f6992b.mo15503q() || this.f6992b.mo15466c() != 0) {
            return 0;
        }
        return 1;
    }

    public void showRewardVideoAd(Activity activity) {
        Intent intent;
        String str = "TTRewardVideoAdImpl";
        if (activity != 0 && activity.isFinishing()) {
            C2564t.m12226e(str, "showRewardVideoAd error1: activity is finishing");
        } else if (Looper.getMainLooper() != Looper.myLooper()) {
            C2564t.m12226e(str, "showRewardVideoAd error2: not main looper");
            throw new IllegalStateException("不能在子线程调用 TTRewardVideoAd.showRewardVideoAd");
        } else if (!this.f7000j.get()) {
            this.f7000j.set(true);
            MaterialMeta kVar = this.f6992b;
            if (!(kVar == null || kVar.mo15512z() == null)) {
                Context context = activity == 0 ? this.f6991a : activity;
                if (context == 0) {
                    context = InternalContainer.m10059a();
                }
                if (this.f6992b.mo15510x() != null) {
                    intent = new Intent(context, TTRewardExpressVideoActivity.class);
                } else {
                    intent = new Intent(context, TTRewardVideoActivity.class);
                }
                if (activity == 0) {
                    intent.addFlags(268435456);
                }
                intent.putExtra("reward_name", this.f6993c.getRewardName());
                intent.putExtra("reward_amount", this.f6993c.getRewardAmount());
                intent.putExtra("media_extra", this.f6993c.getMediaExtra());
                intent.putExtra("user_id", this.f6993c.getUserID());
                intent.putExtra("show_download_bar", this.f6996f);
                intent.putExtra("orientation", this.f6993c.getOrientation());
                if (!TextUtils.isEmpty(this.f6999i)) {
                    intent.putExtra("rit_scene", this.f6999i);
                }
                if (this.f6997g) {
                    intent.putExtra("video_cache_url", this.f6998h);
                }
                if (MultiGlobalInfo.m11808b()) {
                    intent.putExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA, this.f6992b.mo15459ae().toString());
                    intent.putExtra("multi_process_meta_md5", this.f7001k);
                } else {
                    SingleAppData.m10160a().mo15941g();
                    SingleAppData.m10160a().mo15932a(this.f6992b);
                    SingleAppData.m10160a().mo15931a(this.f6994d);
                    SingleAppData.m10160a().mo15933a(this.f6995e);
                    this.f6994d = null;
                }
                ActivityUtil.m12108a(context, intent, new C2540a() {
                    /* renamed from: a */
                    public void mo14890a() {
                    }

                    /* renamed from: a */
                    public void mo14891a(Throwable th) {
                        C2564t.m12223c("TTRewardVideoAdImpl", "show reward video error: ", th);
                    }
                });
                if (!TextUtils.isEmpty(this.f6992b.mo15428P())) {
                    try {
                        String optString = new JSONObject(this.f6992b.mo15428P()).optString("rit", null);
                        AdSlot b = RewardVideoLoadManager.m8752a(this.f6991a).mo15142b(optString);
                        RewardVideoLoadManager.m8752a(this.f6991a).mo15141a(optString);
                        if (b != null) {
                            if (!this.f6997g || TextUtils.isEmpty(this.f6998h)) {
                                RewardVideoLoadManager.m8752a(this.f6991a).mo15139a(b);
                            } else {
                                RewardVideoLoadManager.m8752a(this.f6991a).mo15144b(b);
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    public Map<String, Object> getMediaExtraInfo() {
        MaterialMeta kVar = this.f6992b;
        if (kVar != null) {
            return kVar.mo15436X();
        }
        return null;
    }

    public void showRewardVideoAd(Activity activity, RitScenes ritScenes, String str) {
        if (ritScenes == null) {
            C2564t.m12226e("TTRewardVideoAdImpl", "The param ritScenes can not be null!");
            return;
        }
        if (ritScenes == RitScenes.CUSTOMIZE_SCENES) {
            this.f6999i = str;
        } else {
            this.f6999i = ritScenes.getScenesName();
        }
        showRewardVideoAd(activity);
    }

    /* renamed from: a */
    private void m8796a(final int i) {
        if (MultiGlobalInfo.m11808b()) {
            TTExecutor.m11692a().mo16804a((Runnable) new Runnable() {
                public void run() {
                    BinderPool a = BinderPool.m11776a(TTRewardVideoAdImpl.this.f6991a);
                    if (i == 0 && TTRewardVideoAdImpl.this.f6994d != null) {
                        String str = "MultiProcess";
                        C2564t.m12220b(str, "start registerRewardVideoListener ! ");
                        RewardVideoListenerImpl dVar = new RewardVideoListenerImpl(TTRewardVideoAdImpl.this.f6994d);
                        IListenerManager asInterface = RewardAdVideoListenerManagerImpl.asInterface(a.mo16858a(0));
                        if (asInterface != null) {
                            try {
                                asInterface.registerRewardVideoListener(TTRewardVideoAdImpl.this.f7001k, dVar);
                                C2564t.m12220b(str, "end registerRewardVideoListener ! ");
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
