package com.bytedance.sdk.openadsdk.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener;
import com.bytedance.sdk.openadsdk.component.reward.FullScreenVideoController;
import com.bytedance.sdk.openadsdk.component.reward.FullScreenVideoLoadManager;
import com.bytedance.sdk.openadsdk.component.reward.top.ITopListener;
import com.bytedance.sdk.openadsdk.core.AdInfoFactory;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.SingleAppData;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.INativeVideoController.C2324a;
import com.bytedance.sdk.openadsdk.downloadnew.TTDownloadFactory;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.multipro.MultiGlobalInfo;
import com.bytedance.sdk.openadsdk.p165c.AdEventManager;
import com.bytedance.sdk.openadsdk.p198i.TTExecutor;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.ResourceHelp;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import com.bytedance.sdk.openadsdk.utils.UIUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;

public class TTFullScreenVideoActivity extends TTBaseVideoActivity {
    /* renamed from: aG */
    private static FullScreenVideoAdInteractionListener f6568aG;
    /* access modifiers changed from: private */
    /* renamed from: aF */
    public FullScreenVideoAdInteractionListener f6569aF;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mo14902J();
        if (m8147a(bundle)) {
            mo14901I();
            mo14829d();
            mo14903K();
            mo14810a();
            mo14854u();
            mo14858y();
            if (this.f6508q != null) {
                this.f6444Q = ToolUtils.m12018d(this.f6508q.mo15428P());
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: I */
    public void mo14901I() {
        if (this.f6508q == null) {
            finish();
            return;
        }
        String str = "tt_activity_full_video";
        if (this.f6508q.mo15485h() == 0) {
            setContentView(ResourceHelp.m11936f(this, str));
        } else if (this.f6508q.mo15485h() == 1) {
            setContentView(ResourceHelp.m11936f(this, "tt_activity_full_video_newstyle"));
        } else if (this.f6508q.mo15485h() == 3) {
            setContentView(ResourceHelp.m11936f(this, "tt_activity_full_video_new_bar_3_style"));
        } else {
            setContentView(ResourceHelp.m11936f(this, str));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getPlayBarStyle=");
        sb.append(this.f6508q.mo15485h());
        C2564t.m12220b("report-5", sb.toString());
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        f6568aG = this.f6569aF;
        try {
            bundle.putString("material_meta", this.f6508q != null ? this.f6508q.mo15459ae().toString() : null);
            bundle.putString("multi_process_meta_md5", this.f6510s);
            bundle.putLong("video_current", this.f6428A == null ? this.f6512u : this.f6428A.mo15989m());
            bundle.putString("video_cache_url", this.f6513v);
            bundle.putInt("orientation", this.f6514w);
            bundle.putBoolean("is_mute", this.f6440M);
            bundle.putString("rit_scene", this.f6469ac);
            bundle.putBoolean("has_show_skip_btn", this.f6447T.get());
        } catch (Throwable unused) {
        }
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m8151d(final String str) {
        TTExecutor.m11692a().mo16804a((Runnable) new Runnable() {
            public void run() {
                try {
                    TTFullScreenVideoActivity.this.mo14820b(1).executeFullVideoCallback(TTFullScreenVideoActivity.this.f6510s, str);
                } catch (Throwable th) {
                    C2564t.m12223c("TTFullScreenVideoActivity", "executeFullVideoCallback execute throw Exception : ", th);
                }
            }
        }, 5);
    }

    /* renamed from: J */
    private void mo14902J() {
        Intent intent = getIntent();
        if (intent != null) {
            this.f6511t = intent.getBooleanExtra("show_download_bar", true);
            this.f6513v = intent.getStringExtra("video_cache_url");
            this.f6514w = intent.getIntExtra("orientation", 2);
            this.f6469ac = intent.getStringExtra("rit_scene");
            this.f6483aq = intent.getBooleanExtra("is_verity_playable", false);
        }
    }

    /* renamed from: a */
    private boolean m8147a(Bundle bundle) {
        String str = "TTFullScreenVideoActivity";
        String str2 = "multi_process_meta_md5";
        if (MultiGlobalInfo.m11808b()) {
            Intent intent = getIntent();
            if (intent != null) {
                String stringExtra = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
                this.f6510s = intent.getStringExtra(str2);
                if (stringExtra != null) {
                    try {
                        this.f6508q = AdInfoFactory.m9163a(new JSONObject(stringExtra));
                    } catch (Exception e) {
                        C2564t.m12223c(str, "initData MultiGlobalInfo throws ", e);
                    }
                }
            }
            if (this.f6508q != null && this.f6508q.mo15414B() == 4) {
                this.f6429B = TTDownloadFactory.m11071a(this.f6495d, this.f6508q, "fullscreen_interstitial_ad");
            }
        } else {
            this.f6508q = SingleAppData.m10160a().mo15937c();
            this.f6569aF = SingleAppData.m10160a().mo15939e();
            this.f6429B = SingleAppData.m10160a().mo15940f();
            SingleAppData.m10160a().mo15941g();
        }
        if (bundle != null) {
            if (this.f6569aF == null) {
                this.f6569aF = f6568aG;
                f6568aG = null;
            }
            try {
                String string = bundle.getString("material_meta");
                this.f6510s = bundle.getString(str2);
                this.f6513v = bundle.getString("video_cache_url");
                this.f6514w = bundle.getInt("orientation", 2);
                this.f6440M = bundle.getBoolean("is_mute");
                this.f6469ac = bundle.getString("rit_scene");
                this.f6508q = AdInfoFactory.m9163a(new JSONObject(string));
                this.f6447T.set(bundle.getBoolean("has_show_skip_btn"));
                if (this.f6447T.get()) {
                    if (this.f6493b != null) {
                        this.f6493b.setShowSkip(true);
                    }
                    mo14905M();
                }
            } catch (Throwable unused) {
            }
            if (this.f6429B == null) {
                this.f6429B = TTDownloadFactory.m11071a(this.f6495d, this.f6508q, "rewarded_video");
            }
        }
        boolean z = false;
        if (this.f6508q == null) {
            C2564t.m12226e(str, "mMaterialMeta is null , no data to display ,the TTFullScreenVideoActivity finished !!");
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

    /* renamed from: K */
    private void mo14903K() {
        if (this.f6508q == null) {
            C2564t.m12226e("TTFullScreenVideoActivity", "mMaterialMeta is null , no data to display ,the TTFullScreenVideoActivity finished !!");
            finish();
            return;
        }
        if (this.f6508q.mo15503q() && this.f6508q.mo15466c() == 1) {
            mo14812a(getApplicationContext());
        }
        this.f6482ap = 8;
        this.f6444Q = ToolUtils.m12018d(this.f6508q.mo15428P());
        this.f6442O = this.f6508q.mo15429Q();
        this.f6435H = this.f6508q.mo15425M();
        this.f6436I = this.f6508q.mo15428P();
        this.f6441N = (int) mo14806G();
        this.f6437J = 5;
        this.f6440M = InternalContainer.m10069h().mo15777b(this.f6444Q);
        this.f6438K = 2955;
        mo14837k();
        mo14817a(this.f6440M);
        mo14836j();
        mo14849p();
        mo14835i();
        mo14838l();
        mo14834h();
        mo14833g();
        mo14814a("fullscreen_endcard");
        mo14904L();
        mo14823b("fullscreen_interstitial_ad");
        mo14840n();
    }

    /* renamed from: L */
    private void mo14904L() {
        if (this.f6499h != null) {
            this.f6499h.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    TTFullScreenVideoActivity.this.m8143R();
                    TTFullScreenVideoActivity.this.m8144S();
                    TTFullScreenVideoActivity.this.finish();
                }
            });
        }
        if (this.f6493b != null) {
            this.f6493b.setListener(new ITopListener() {
                /* renamed from: a */
                public void mo14931a(View view) {
                    HashMap hashMap = new HashMap();
                    if (!TextUtils.isEmpty(TTFullScreenVideoActivity.this.f6469ac)) {
                        hashMap.put("rit_scene", TTFullScreenVideoActivity.this.f6469ac);
                    }
                    hashMap.put("play_type", Integer.valueOf(ToolUtils.m11990a(TTFullScreenVideoActivity.this.f6428A, TTFullScreenVideoActivity.this.f6515x)));
                    String str = "fullscreen_interstitial_ad";
                    TTFullScreenVideoActivity.this.mo14815a(str, "feed_break", (Map<String, Object>) hashMap);
                    TTFullScreenVideoActivity.this.mo14815a(str, "skip", null);
                    if (MultiGlobalInfo.m11808b()) {
                        TTFullScreenVideoActivity.this.m8151d("onSkippedVideo");
                    } else if (TTFullScreenVideoActivity.this.f6569aF != null) {
                        TTFullScreenVideoActivity.this.f6569aF.onSkippedVideo();
                    }
                    if (TTFullScreenVideoActivity.this.mo14921O()) {
                        TTFullScreenVideoActivity.this.mo14803D();
                    } else {
                        TTFullScreenVideoActivity.this.finish();
                    }
                }

                /* renamed from: b */
                public void mo14932b(View view) {
                    TTFullScreenVideoActivity tTFullScreenVideoActivity = TTFullScreenVideoActivity.this;
                    tTFullScreenVideoActivity.f6440M = !tTFullScreenVideoActivity.f6440M;
                    if (TTFullScreenVideoActivity.this.f6428A != null && TTFullScreenVideoActivity.this.f6508q != null && TTFullScreenVideoActivity.this.f6508q.mo15466c() != 1) {
                        TTFullScreenVideoActivity.this.f6428A.mo15975c(TTFullScreenVideoActivity.this.f6440M);
                    } else if (TTFullScreenVideoActivity.this.f6508q != null && TTFullScreenVideoActivity.this.f6508q.mo15503q() && TTFullScreenVideoActivity.this.f6508q.mo15466c() == 1) {
                        TTFullScreenVideoActivity tTFullScreenVideoActivity2 = TTFullScreenVideoActivity.this;
                        tTFullScreenVideoActivity2.mo14828c(tTFullScreenVideoActivity2.f6440M);
                    }
                }

                /* renamed from: c */
                public void mo14933c(View view) {
                    TTFullScreenVideoActivity.this.mo14807H();
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: O */
    public boolean mo14921O() {
        return InternalContainer.m10069h().mo15795j(String.valueOf(this.f6444Q)) == 2;
    }

    /* renamed from: a */
    public boolean mo14908a(long j, boolean z) {
        Map map;
        if (this.f6428A == null) {
            this.f6428A = new FullScreenVideoController(this.f6495d, this.f6504m, this.f6508q);
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
                TTFullScreenVideoActivity.this.mo14923Q();
                if (TTFullScreenVideoActivity.this.mo14921O()) {
                    TTFullScreenVideoActivity.this.mo14850q();
                } else {
                    TTFullScreenVideoActivity.this.finish();
                }
            }

            /* renamed from: b */
            public void mo14914b(long j, int i) {
                if (!TTFullScreenVideoActivity.this.mo14851r()) {
                    if (TTFullScreenVideoActivity.this.f6428A != null) {
                        TTFullScreenVideoActivity.this.f6428A.mo15988l();
                    }
                    C2564t.m12226e("TTFullScreenVideoActivity", "onError、、、、、、、、");
                    if (TTFullScreenVideoActivity.this.mo14921O()) {
                        TTFullScreenVideoActivity.this.mo14850q();
                        HashMap hashMap = new HashMap();
                        hashMap.put("vbtt_skip_type", Integer.valueOf(1));
                        TTFullScreenVideoActivity.this.mo14816a("fullscreen_interstitial_ad", (Map<String, Object>) hashMap);
                    } else {
                        TTFullScreenVideoActivity.this.finish();
                    }
                }
            }

            /* renamed from: a */
            public void mo14911a() {
                C2564t.m12220b("TTFullScreenVideoActivity", "onTimeOut、、、、、、、、");
                if (TTFullScreenVideoActivity.this.mo14921O()) {
                    TTFullScreenVideoActivity.this.mo14850q();
                } else {
                    TTFullScreenVideoActivity.this.finish();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("vbtt_skip_type", Integer.valueOf(0));
                TTFullScreenVideoActivity.this.mo14816a("fullscreen_interstitial_ad", (Map<String, Object>) hashMap);
                if (TTFullScreenVideoActivity.this.f6428A != null) {
                    TTFullScreenVideoActivity.this.f6428A.mo15988l();
                }
            }

            /* renamed from: a */
            public void mo14913a(long j, long j2) {
                TTFullScreenVideoActivity tTFullScreenVideoActivity = TTFullScreenVideoActivity.this;
                long j3 = j / 1000;
                tTFullScreenVideoActivity.f6441N = (int) (tTFullScreenVideoActivity.mo14806G() - ((double) j3));
                TTFullScreenVideoActivity.this.mo14925e((int) j3);
                if (TTFullScreenVideoActivity.this.f6441N >= 0 && TTFullScreenVideoActivity.this.f6493b != null) {
                    TTFullScreenVideoActivity.this.f6493b.setShowCountDown(true);
                    TTFullScreenVideoActivity.this.f6493b.mo15164a((CharSequence) String.valueOf(TTFullScreenVideoActivity.this.f6441N), (CharSequence) null);
                }
                if (TTFullScreenVideoActivity.this.f6441N <= 0) {
                    C2564t.m12220b("TTFullScreenVideoActivity", "onProgressUpdate、、、、、、、、");
                    if (TTFullScreenVideoActivity.this.mo14921O()) {
                        TTFullScreenVideoActivity.this.mo14850q();
                    } else {
                        TTFullScreenVideoActivity.this.finish();
                    }
                }
                if ((TTFullScreenVideoActivity.this.f6451X.get() || TTFullScreenVideoActivity.this.f6449V.get()) && TTFullScreenVideoActivity.this.mo14851r()) {
                    TTFullScreenVideoActivity.this.f6428A.mo15984h();
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
            AdEventManager.m8389a(this.f6495d, this.f6508q, "fullscreen_interstitial_ad", map);
            mo14906N();
        }
        return a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo14925e(int i) {
        if (InternalContainer.m10069h().mo15778b(String.valueOf(this.f6444Q))) {
            if (!this.f6447T.getAndSet(true) && this.f6493b != null) {
                this.f6493b.setShowSkip(true);
            }
            if (i <= 5) {
                mo14909d(5 - i);
                if (this.f6493b != null) {
                    this.f6493b.setSkipEnable(false);
                    return;
                }
                return;
            }
            mo14905M();
        } else if (i >= 5) {
            if (!this.f6447T.getAndSet(true) && this.f6493b != null) {
                this.f6493b.setShowSkip(true);
            }
            mo14905M();
        }
    }

    /* renamed from: M */
    private void mo14905M() {
        if (this.f6493b != null) {
            this.f6493b.mo15164a((CharSequence) null, (CharSequence) "跳过");
            this.f6493b.setSkipEnable(true);
        }
    }

    /* renamed from: d */
    private void mo14909d(int i) {
        if (this.f6493b != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append("s后可跳过");
            this.f6493b.mo15164a((CharSequence) null, (CharSequence) new SpannableStringBuilder(sb.toString()));
        }
    }

    /* renamed from: a */
    public void mo14924a(View view, int i, int i2, int i3, int i4) {
        if (MultiGlobalInfo.m11808b()) {
            m8151d("onAdVideoBarClick");
            return;
        }
        FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.f6569aF;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onAdVideoBarClick();
        }
    }

    /* renamed from: N */
    public void mo14906N() {
        if (MultiGlobalInfo.m11808b()) {
            m8151d("onAdShow");
            return;
        }
        FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.f6569aF;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onAdShow();
        }
    }

    /* renamed from: P */
    public void mo14922P() {
        if (MultiGlobalInfo.m11808b()) {
            m8151d("onAdVideoBarClick");
            return;
        }
        FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.f6569aF;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onAdVideoBarClick();
        }
    }

    /* renamed from: f */
    public void mo14926f(int i) {
        if (i == 10002) {
            mo14923Q();
        }
    }

    public void finish() {
        if (MultiGlobalInfo.m11808b()) {
            m8151d("onAdClose");
        } else {
            FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.f6569aF;
            if (fullScreenVideoAdInteractionListener != null) {
                fullScreenVideoAdInteractionListener.onAdClose();
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
            m8151d("recycleRes");
        }
        if (this.f6569aF != null) {
            this.f6569aF = null;
        }
        if (this.f6434G != null) {
            for (Entry entry : this.f6434G.entrySet()) {
                if (entry.getValue() != null) {
                    ((ITTDownloadAdapter) entry.getValue()).mo16518d();
                }
            }
        }
        if (TextUtils.isEmpty(this.f6513v)) {
            FullScreenVideoLoadManager.m8697a(InternalContainer.m10059a()).mo15118b();
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
        f6568aG = null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: Q */
    public void mo14923Q() {
        if (MultiGlobalInfo.m11808b()) {
            m8151d("onVideoComplete");
            return;
        }
        FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.f6569aF;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onVideoComplete();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: R */
    public void m8143R() {
        HashMap hashMap = new HashMap();
        if (this.f6508q != null && this.f6508q.mo15503q() && this.f6508q.mo15466c() == 1) {
            hashMap.put("duration", Long.valueOf(System.currentTimeMillis() - this.f6485as));
        }
        AdEventManager.m8415n(this.f6495d, this.f6508q, "fullscreen_interstitial_ad", "click_close", hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: S */
    public void m8144S() {
        if (this.f6508q != null && this.f6496e != null && this.f6508q.mo15503q()) {
            Bitmap a = UIUtils.m12052a((WebView) this.f6496e);
            if (a != null) {
                UIUtils.m12057a(InternalContainer.m10059a(), this.f6508q, "fullscreen_interstitial_ad", "playable_show_status", a);
            }
        }
    }
}
