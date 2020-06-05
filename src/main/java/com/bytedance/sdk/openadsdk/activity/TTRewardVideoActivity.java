package com.bytedance.sdk.openadsdk.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener;
import com.bytedance.sdk.openadsdk.component.reward.RewardVideoController;
import com.bytedance.sdk.openadsdk.component.reward.RewardVideoLoadManager;
import com.bytedance.sdk.openadsdk.component.reward.top.ITopListener;
import com.bytedance.sdk.openadsdk.core.AdInfoFactory;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.NetApi;
import com.bytedance.sdk.openadsdk.core.NetApi.C2288c;
import com.bytedance.sdk.openadsdk.core.NetApiImpl.C2296c;
import com.bytedance.sdk.openadsdk.core.Sdk;
import com.bytedance.sdk.openadsdk.core.SingleAppData;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.INativeVideoController.C2324a;
import com.bytedance.sdk.openadsdk.core.widget.CustomCommonDialog;
import com.bytedance.sdk.openadsdk.core.widget.CustomCommonDialog.C2357a;
import com.bytedance.sdk.openadsdk.downloadnew.TTDownloadFactory;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.multipro.MultiGlobalInfo;
import com.bytedance.sdk.openadsdk.p165c.AdEventManager;
import com.bytedance.sdk.openadsdk.p198i.TTExecutor;
import com.bytedance.sdk.openadsdk.utils.AdLocationUtils;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.C2566w;
import com.bytedance.sdk.openadsdk.utils.ResourceHelp;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import com.bytedance.sdk.openadsdk.utils.UIUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class TTRewardVideoActivity extends TTBaseVideoActivity {
    /* renamed from: aK */
    private static RewardAdInteractionListener f6655aK;
    /* renamed from: aF */
    private NetApi f6656aF;
    /* renamed from: aG */
    private String f6657aG;
    /* renamed from: aH */
    private int f6658aH;
    /* renamed from: aI */
    private String f6659aI;
    /* renamed from: aJ */
    private String f6660aJ;
    /* renamed from: aL */
    private AtomicBoolean f6661aL = new AtomicBoolean(false);
    /* renamed from: aN */
    protected int f6662aN;
    /* renamed from: aO */
    protected int f6663aO;
    /* renamed from: aP */
    protected RewardAdInteractionListener f6664aP;
    /* renamed from: aQ */
    protected final AtomicBoolean f6665aQ = new AtomicBoolean(false);

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mo14905M();
        if (m8258a(bundle)) {
            mo14901I();
            mo14829d();
            mo14902J();
            mo14810a();
            mo14854u();
            mo14858y();
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        f6655aK = this.f6664aP;
        try {
            bundle.putString("material_meta", this.f6508q != null ? this.f6508q.mo15459ae().toString() : null);
            bundle.putString("multi_process_meta_md5", this.f6510s);
            bundle.putLong("video_current", this.f6428A == null ? this.f6512u : this.f6428A.mo15989m());
            bundle.putString("video_cache_url", this.f6513v);
            bundle.putInt("orientation", this.f6514w);
            bundle.putBoolean("is_mute", this.f6440M);
            bundle.putBoolean("has_show_skip_btn", this.f6447T.get());
            bundle.putString("rit_scene", this.f6469ac);
        } catch (Throwable unused) {
        }
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo14961d(String str) {
        m8257a(str, false, 0, "");
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
        f6655aK = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8257a(String str, boolean z, int i, String str2) {
        TTExecutor a = TTExecutor.m11692a();
        final String str3 = str;
        final boolean z2 = z;
        final int i2 = i;
        final String str4 = str2;
        C20611 r1 = new Runnable() {
            public void run() {
                try {
                    TTRewardVideoActivity.this.mo14820b(0).executeRewardVideoCallback(TTRewardVideoActivity.this.f6510s, str3, z2, i2, str4);
                } catch (Throwable th) {
                    C2564t.m12223c("TTRewardVideoActivity", "executeRewardVideoCallback execute throw Exception : ", th);
                }
            }
        };
        a.mo16804a((Runnable) r1, 5);
    }

    /* access modifiers changed from: protected */
    /* renamed from: I */
    public void mo14901I() {
        if (this.f6508q == null) {
            finish();
            return;
        }
        String str = "tt_activity_rewardvideo";
        if (this.f6508q.mo15485h() == 0) {
            setContentView(ResourceHelp.m11936f(this, str));
        } else if (this.f6508q.mo15485h() == 1) {
            setContentView(ResourceHelp.m11936f(this, "tt_activity_reward_video_newstyle"));
        } else if (this.f6508q.mo15485h() == 3) {
            setContentView(ResourceHelp.m11936f(this, "tt_activity_rewardvideo_new_bar_3_style"));
        } else {
            setContentView(ResourceHelp.m11936f(this, str));
        }
    }

    /* renamed from: a */
    private boolean m8258a(Bundle bundle) {
        String str = "rewarded_video";
        String str2 = "TTRewardVideoActivity";
        String str3 = "multi_process_meta_md5";
        if (MultiGlobalInfo.m11808b()) {
            Intent intent = getIntent();
            if (intent != null) {
                String stringExtra = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
                this.f6510s = intent.getStringExtra(str3);
                if (stringExtra != null) {
                    try {
                        this.f6508q = AdInfoFactory.m9163a(new JSONObject(stringExtra));
                    } catch (Exception e) {
                        C2564t.m12223c(str2, "TTRewardVideoActivity MultiGlobalInfo throw ", e);
                    }
                }
            }
            if (this.f6508q != null && this.f6508q.mo15414B() == 4) {
                this.f6429B = TTDownloadFactory.m11071a(this.f6495d, this.f6508q, str);
            }
        } else {
            this.f6508q = SingleAppData.m10160a().mo15937c();
            this.f6664aP = SingleAppData.m10160a().mo15938d();
            this.f6429B = SingleAppData.m10160a().mo15940f();
            SingleAppData.m10160a().mo15941g();
        }
        if (bundle != null) {
            if (this.f6664aP == null) {
                this.f6664aP = f6655aK;
                f6655aK = null;
            }
            try {
                String string = bundle.getString("material_meta");
                this.f6510s = bundle.getString(str3);
                this.f6513v = bundle.getString("video_cache_url");
                this.f6514w = bundle.getInt("orientation", 2);
                this.f6440M = bundle.getBoolean("is_mute");
                this.f6469ac = bundle.getString("rit_scene");
                this.f6508q = AdInfoFactory.m9163a(new JSONObject(string));
                this.f6447T.set(bundle.getBoolean("has_show_skip_btn"));
                if (this.f6447T.get() && this.f6493b != null) {
                    this.f6493b.setShowSkip(true);
                    this.f6493b.mo15164a((CharSequence) null, (CharSequence) "跳过");
                    this.f6493b.setSkipEnable(true);
                }
            } catch (Throwable unused) {
            }
            if (this.f6429B == null) {
                this.f6429B = TTDownloadFactory.m11071a(this.f6495d, this.f6508q, str);
            }
        }
        boolean z = false;
        if (this.f6508q == null) {
            C2564t.m12226e(str2, "mMaterialMeta is null , no data to display ,the TTRewardVideoActivity finished !!");
            finish();
            return false;
        }
        this.f6470ad = this.f6508q.mo15485h() == 1;
        if (this.f6508q.mo15485h() == 3) {
            z = true;
        }
        this.f6471ae = z;
        if (this.f6508q != null) {
            this.f6508q.mo15512z();
        }
        return true;
    }

    /* renamed from: J */
    private void mo14902J() {
        this.f6656aF = InternalContainer.m10067f();
        if (this.f6508q == null) {
            C2564t.m12226e("TTRewardVideoActivity", "mMaterialMeta is null , no data to display ,the TTRewardVideoActivity finished !!");
            finish();
            return;
        }
        if (this.f6508q.mo15503q() && this.f6508q.mo15466c() == 1) {
            mo14812a(getApplicationContext());
        }
        this.f6482ap = 7;
        this.f6444Q = ToolUtils.m12018d(this.f6508q.mo15428P());
        this.f6440M = InternalContainer.m10069h().mo15777b(this.f6444Q);
        this.f6442O = this.f6508q.mo15429Q();
        this.f6435H = this.f6508q.mo15425M();
        this.f6436I = this.f6508q.mo15428P();
        this.f6441N = (int) mo14806G();
        this.f6437J = 7;
        this.f6438K = 2955;
        mo14837k();
        mo14817a(this.f6440M);
        mo14825c();
        mo14836j();
        mo14849p();
        mo14835i();
        mo14833g();
        mo14838l();
        mo14834h();
        mo14814a("reward_endcard");
        mo14903K();
        mo14823b("rewarded_video");
        mo14840n();
    }

    /* renamed from: K */
    private void mo14903K() {
        if (this.f6499h != null) {
            this.f6499h.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    TTRewardVideoActivity.this.m8252S();
                    TTRewardVideoActivity.this.m8253T();
                    boolean z = TTRewardVideoActivity.this.f6508q != null && TTRewardVideoActivity.this.f6508q.mo15503q() && TTRewardVideoActivity.this.f6508q.mo15466c() == 1;
                    if (z) {
                        TTRewardVideoActivity.this.mo14910e(true);
                    } else {
                        TTRewardVideoActivity.this.finish();
                    }
                }
            });
        }
        if (this.f6493b != null) {
            this.f6493b.setListener(new ITopListener() {
                /* renamed from: a */
                public void mo14931a(View view) {
                    TTRewardVideoActivity.this.mo14910e(false);
                }

                /* renamed from: b */
                public void mo14932b(View view) {
                    TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
                    tTRewardVideoActivity.f6440M = !tTRewardVideoActivity.f6440M;
                    if (TTRewardVideoActivity.this.f6428A != null && TTRewardVideoActivity.this.f6508q != null && TTRewardVideoActivity.this.f6508q.mo15466c() != 1) {
                        TTRewardVideoActivity.this.f6428A.mo15975c(TTRewardVideoActivity.this.f6440M);
                    } else if (TTRewardVideoActivity.this.f6508q != null && TTRewardVideoActivity.this.f6508q.mo15503q() && TTRewardVideoActivity.this.f6508q.mo15466c() == 1) {
                        TTRewardVideoActivity tTRewardVideoActivity2 = TTRewardVideoActivity.this;
                        tTRewardVideoActivity2.mo14828c(tTRewardVideoActivity2.f6440M);
                    }
                }

                /* renamed from: c */
                public void mo14933c(View view) {
                    TTRewardVideoActivity.this.mo14807H();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void mo14910e(final boolean z) {
        if (!InternalContainer.m10069h().mo15784d(String.valueOf(this.f6444Q))) {
            if (z) {
                finish();
            } else {
                mo14904L();
            }
        } else if (!this.f6661aL.get()) {
            this.f6451X.set(true);
            if (this.f6428A != null) {
                this.f6428A.mo15984h();
            }
            if (z) {
                mo14801B();
            }
            this.f6452Y = new CustomCommonDialog(this);
            String str = "放弃奖励";
            if (z) {
                this.f6452Y.mo16286a("试玩后才可领取奖励").mo16287b("继续试玩").mo16288c(str);
            } else {
                this.f6452Y.mo16286a("观看完整视频才能获得奖励").mo16287b("继续观看").mo16288c(str);
            }
            this.f6452Y.mo16285a((C2357a) new C2357a() {
                /* renamed from: a */
                public void mo14966a() {
                    if (TTRewardVideoActivity.this.f6428A != null) {
                        TTRewardVideoActivity.this.f6428A.mo15986j();
                    }
                    if (z) {
                        TTRewardVideoActivity.this.mo14802C();
                    }
                    TTRewardVideoActivity.this.f6452Y.dismiss();
                    TTRewardVideoActivity.this.f6451X.set(false);
                }

                /* renamed from: b */
                public void mo14967b() {
                    TTRewardVideoActivity.this.f6452Y.dismiss();
                    TTRewardVideoActivity.this.f6451X.set(false);
                    if (z) {
                        TTRewardVideoActivity.this.finish();
                    } else {
                        TTRewardVideoActivity.this.mo14904L();
                    }
                }
            }).show();
        } else if (z) {
            finish();
        } else {
            mo14904L();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: L */
    public void mo14904L() {
        if (this.f6428A != null) {
            this.f6428A.mo15988l();
        }
        String str = "rewarded_video";
        mo14815a(str, "skip", null);
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(this.f6469ac)) {
            hashMap.put("rit_scene", this.f6469ac);
        }
        hashMap.put("play_type", Integer.valueOf(ToolUtils.m11990a(this.f6428A, this.f6515x)));
        mo14815a(str, "feed_break", (Map<String, Object>) hashMap);
        mo14803D();
        if (MultiGlobalInfo.m11808b()) {
            mo14961d("onSkippedVideo");
            return;
        }
        RewardAdInteractionListener rewardAdInteractionListener = this.f6664aP;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onSkippedVideo();
        }
    }

    /* renamed from: M */
    private void mo14905M() {
        Intent intent = getIntent();
        if (intent != null) {
            this.f6657aG = intent.getStringExtra("reward_name");
            this.f6658aH = intent.getIntExtra("reward_amount", 0);
            this.f6659aI = intent.getStringExtra("media_extra");
            this.f6660aJ = intent.getStringExtra("user_id");
            this.f6511t = intent.getBooleanExtra("show_download_bar", true);
            this.f6513v = intent.getStringExtra("video_cache_url");
            this.f6514w = intent.getIntExtra("orientation", 2);
            this.f6469ac = intent.getStringExtra("rit_scene");
        }
    }

    /* renamed from: a */
    public boolean mo14908a(long j, boolean z) {
        Map map;
        if (this.f6428A == null) {
            this.f6428A = new RewardVideoController(this.f6495d, this.f6504m, this.f6508q);
        }
        String str = null;
        if (!TextUtils.isEmpty(this.f6469ac)) {
            map = new HashMap();
            map.put("rit_scene", this.f6469ac);
        } else {
            map = null;
        }
        this.f6428A.mo15963a(map);
        this.f6428A.mo15959a((C2324a) new C2324a() {
            /* renamed from: a */
            public void mo14912a(long j, int i) {
                TTRewardVideoActivity.this.mo14923Q();
                TTRewardVideoActivity.this.mo14850q();
                TTRewardVideoActivity.this.f6663aO = (int) (System.currentTimeMillis() / 1000);
                TTRewardVideoActivity.this.mo14921O();
            }

            /* renamed from: b */
            public void mo14914b(long j, int i) {
                if (MultiGlobalInfo.m11808b()) {
                    TTRewardVideoActivity.this.mo14961d("onVideoError");
                } else if (TTRewardVideoActivity.this.f6664aP != null) {
                    TTRewardVideoActivity.this.f6664aP.onVideoError();
                }
                if (!TTRewardVideoActivity.this.mo14851r()) {
                    if (TTRewardVideoActivity.this.f6428A != null) {
                        TTRewardVideoActivity.this.f6428A.mo15988l();
                    }
                    TTRewardVideoActivity.this.mo14850q();
                    HashMap hashMap = new HashMap();
                    hashMap.put("vbtt_skip_type", Integer.valueOf(1));
                    TTRewardVideoActivity.this.mo14816a("rewarded_video", (Map<String, Object>) hashMap);
                }
            }

            /* renamed from: a */
            public void mo14911a() {
                TTRewardVideoActivity.this.mo14850q();
                HashMap hashMap = new HashMap();
                hashMap.put("vbtt_skip_type", Integer.valueOf(0));
                TTRewardVideoActivity.this.mo14816a("rewarded_video", (Map<String, Object>) hashMap);
                if (TTRewardVideoActivity.this.f6428A != null) {
                    TTRewardVideoActivity.this.f6428A.mo15988l();
                }
            }

            /* renamed from: a */
            public void mo14913a(long j, long j2) {
                int i = InternalContainer.m10069h().mo15812r(String.valueOf(TTRewardVideoActivity.this.f6444Q)).f7591g;
                if (j2 > 0 && ((float) (100 * j)) / Float.valueOf((float) j2).floatValue() >= ((float) i)) {
                    TTRewardVideoActivity.this.mo14921O();
                }
                TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
                long j3 = j / 1000;
                tTRewardVideoActivity.f6441N = (int) (tTRewardVideoActivity.mo14806G() - ((double) j3));
                if (TTRewardVideoActivity.this.f6441N >= 0 && TTRewardVideoActivity.this.f6493b != null) {
                    TTRewardVideoActivity.this.f6493b.setShowCountDown(true);
                    TTRewardVideoActivity.this.f6493b.mo15164a((CharSequence) String.valueOf(TTRewardVideoActivity.this.f6441N), (CharSequence) null);
                }
                int i2 = (int) j3;
                boolean z = false;
                if (TTRewardVideoActivity.this.f6443P != -1 && i2 == TTRewardVideoActivity.this.f6443P && !TTRewardVideoActivity.this.f6665aQ.get()) {
                    TTRewardVideoActivity.this.f6494c.setVisibility(0);
                    TTRewardVideoActivity.this.f6665aQ.set(true);
                    TTRewardVideoActivity.this.mo14841o();
                }
                int g = InternalContainer.m10069h().mo15790g(String.valueOf(TTRewardVideoActivity.this.f6444Q));
                if (g != -1 && g >= 0) {
                    z = true;
                }
                if (z && i2 >= g) {
                    if (!TTRewardVideoActivity.this.f6447T.getAndSet(true) && TTRewardVideoActivity.this.f6493b != null) {
                        TTRewardVideoActivity.this.f6493b.setShowSkip(true);
                    }
                    if (TTRewardVideoActivity.this.f6493b != null) {
                        TTRewardVideoActivity.this.f6493b.mo15164a((CharSequence) null, (CharSequence) "跳过");
                        TTRewardVideoActivity.this.f6493b.setSkipEnable(true);
                    }
                }
                if (TTRewardVideoActivity.this.f6441N <= 0) {
                    TTRewardVideoActivity.this.mo14850q();
                }
                if ((TTRewardVideoActivity.this.f6451X.get() || TTRewardVideoActivity.this.f6449V.get()) && TTRewardVideoActivity.this.mo14851r()) {
                    TTRewardVideoActivity.this.f6428A.mo15984h();
                }
            }
        });
        if (this.f6508q.mo15512z() != null) {
            str = this.f6508q.mo15512z().mo15603g();
        }
        if (this.f6513v != null) {
            File file = new File(this.f6513v);
            if (file.exists() && file.length() > 0) {
                str = this.f6513v;
                this.f6515x = true;
            }
        }
        String str2 = str;
        StringBuilder sb = new StringBuilder();
        sb.append("videoUrl:");
        sb.append(str2);
        C2564t.m12226e("wzj", sb.toString());
        if (this.f6428A == null) {
            return false;
        }
        boolean a = this.f6428A.mo15965a(str2, this.f6508q.mo15425M(), this.f6504m.getWidth(), this.f6504m.getHeight(), null, this.f6508q.mo15428P(), j, this.f6440M);
        if (a && !z) {
            AdEventManager.m8389a(this.f6495d, this.f6508q, "rewarded_video", map);
            mo14906N();
            this.f6662aN = (int) (System.currentTimeMillis() / 1000);
        }
        return a;
    }

    /* renamed from: a */
    public void mo14924a(View view, int i, int i2, int i3, int i4) {
        if (MultiGlobalInfo.m11808b()) {
            mo14961d("onAdVideoBarClick");
            return;
        }
        RewardAdInteractionListener rewardAdInteractionListener = this.f6664aP;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onAdVideoBarClick();
        }
    }

    /* renamed from: N */
    public void mo14906N() {
        if (MultiGlobalInfo.m11808b()) {
            mo14961d("onAdShow");
            return;
        }
        RewardAdInteractionListener rewardAdInteractionListener = this.f6664aP;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onAdShow();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: O */
    public void mo14921O() {
        if (!this.f6661aL.get()) {
            this.f6661aL.set(true);
            if (InternalContainer.m10069h().mo15804n(String.valueOf(this.f6444Q))) {
                if (MultiGlobalInfo.m11808b()) {
                    m8257a("onRewardVerify", true, this.f6658aH, this.f6657aG);
                } else {
                    RewardAdInteractionListener rewardAdInteractionListener = this.f6664aP;
                    if (rewardAdInteractionListener != null) {
                        rewardAdInteractionListener.onRewardVerify(true, this.f6658aH, this.f6657aG);
                    }
                }
                return;
            }
            this.f6656aF.mo15920a(m8251R(), (C2288c) new C2288c() {
                /* renamed from: a */
                public void mo14968a(int i, String str) {
                    String str2 = "";
                    if (MultiGlobalInfo.m11808b()) {
                        TTRewardVideoActivity.this.m8257a("onRewardVerify", false, 0, str2);
                    } else if (TTRewardVideoActivity.this.f6664aP != null) {
                        TTRewardVideoActivity.this.f6664aP.onRewardVerify(false, 0, str2);
                    }
                }

                /* renamed from: a */
                public void mo14969a(C2296c cVar) {
                    int a = cVar.f7907c.mo15579a();
                    String b = cVar.f7907c.mo15582b();
                    if (MultiGlobalInfo.m11808b()) {
                        TTRewardVideoActivity.this.m8257a("onRewardVerify", cVar.f7906b, a, b);
                    } else if (TTRewardVideoActivity.this.f6664aP != null) {
                        TTRewardVideoActivity.this.f6664aP.onRewardVerify(cVar.f7906b, a, b);
                    }
                }
            });
        }
    }

    /* renamed from: R */
    private JSONObject m8251R() {
        JSONObject jSONObject = new JSONObject();
        float f = 0.0f;
        float f2 = AdLocationUtils.m12114a(this.f6495d) == null ? 0.0f : AdLocationUtils.m12114a(this.f6495d).f9146a;
        if (AdLocationUtils.m12114a(this.f6495d) != null) {
            f = AdLocationUtils.m12114a(this.f6495d).f9147b;
        }
        int r = this.f6428A != null ? (int) this.f6428A.mo15994r() : 0;
        try {
            jSONObject.put("oversea_version_type", 0);
            jSONObject.put("reward_name", this.f6657aG);
            jSONObject.put("reward_amount", this.f6658aH);
            jSONObject.put("network", C2566w.m12244c(this.f6495d));
            jSONObject.put("latitude", (double) f2);
            jSONObject.put("longitude", (double) f);
            jSONObject.put("sdk_version", "2.9.5.5");
            jSONObject.put("user_agent", Sdk.f7908a);
            jSONObject.put("extra", new JSONObject(this.f6436I));
            jSONObject.put("media_extra", this.f6659aI);
            jSONObject.put("video_duration", mo14806G());
            jSONObject.put("play_start_ts", this.f6662aN);
            jSONObject.put("play_end_ts", this.f6663aO);
            jSONObject.put("duration", r);
            jSONObject.put("user_id", this.f6660aJ);
            jSONObject.put("trans_id", UUID.randomUUID().toString().replace("-", ""));
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: P */
    public void mo14922P() {
        if (MultiGlobalInfo.m11808b()) {
            mo14961d("onAdVideoBarClick");
            return;
        }
        RewardAdInteractionListener rewardAdInteractionListener = this.f6664aP;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onAdVideoBarClick();
        }
    }

    /* renamed from: f */
    public void mo14926f(int i) {
        if (i == 10000) {
            mo14921O();
        } else if (i == 10001) {
            mo14923Q();
        }
    }

    public void finish() {
        if (MultiGlobalInfo.m11808b()) {
            mo14961d("onAdClose");
        } else {
            RewardAdInteractionListener rewardAdInteractionListener = this.f6664aP;
            if (rewardAdInteractionListener != null) {
                rewardAdInteractionListener.onAdClose();
            }
        }
        super.finish();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.f6434G != null) {
            for (Entry entry : this.f6434G.entrySet()) {
                if (entry.getValue() != null) {
                    ((ITTDownloadAdapter) entry.getValue()).mo16513b();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (this.f6434G != null) {
            for (Entry entry : this.f6434G.entrySet()) {
                if (entry.getValue() != null) {
                    ((ITTDownloadAdapter) entry.getValue()).mo16516c();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (MultiGlobalInfo.m11808b()) {
            mo14961d("recycleRes");
        }
        if (this.f6664aP != null) {
            this.f6664aP = null;
        }
        if (this.f6434G != null) {
            for (Entry entry : this.f6434G.entrySet()) {
                if (entry.getValue() != null) {
                    ((ITTDownloadAdapter) entry.getValue()).mo16518d();
                }
            }
        }
        if (TextUtils.isEmpty(this.f6513v)) {
            RewardVideoLoadManager.m8752a(InternalContainer.m10059a()).mo15138a();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: Q */
    public void mo14923Q() {
        if (MultiGlobalInfo.m11808b()) {
            mo14961d("onVideoComplete");
            return;
        }
        RewardAdInteractionListener rewardAdInteractionListener = this.f6664aP;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onVideoComplete();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: S */
    public void m8252S() {
        HashMap hashMap = new HashMap();
        if (this.f6508q != null && this.f6508q.mo15466c() == 1 && this.f6508q.mo15503q()) {
            hashMap.put("duration", Long.valueOf(System.currentTimeMillis() - this.f6485as));
        }
        AdEventManager.m8415n(this.f6495d, this.f6508q, "rewarded_video", "click_close", null);
    }

    /* access modifiers changed from: private */
    /* renamed from: T */
    public void m8253T() {
        if (this.f6508q != null && this.f6496e != null && this.f6508q.mo15503q()) {
            Bitmap a = UIUtils.m12052a((WebView) this.f6496e);
            if (a != null) {
                UIUtils.m12057a(InternalContainer.m10059a(), this.f6508q, "rewarded_video", "playable_show_status", a);
            }
        }
    }
}
