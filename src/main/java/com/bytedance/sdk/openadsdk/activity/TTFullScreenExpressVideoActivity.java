package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.bytedance.sdk.openadsdk.AdSlot.Builder;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener;
import com.bytedance.sdk.openadsdk.component.reward.FullScreenVideoController;
import com.bytedance.sdk.openadsdk.component.reward.view.FullRewardExpressView;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.EmptyView.C2202a;
import com.bytedance.sdk.openadsdk.core.nativeexpress.ExpressClickCreativeListener;
import com.bytedance.sdk.openadsdk.core.nativeexpress.ExpressClickListener;
import com.bytedance.sdk.openadsdk.core.nativeexpress.ExpressVideoListener;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.INativeVideoController.C2324a;
import com.bytedance.sdk.openadsdk.downloadnew.TTDownloadFactory;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.p165c.AdEventManager;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import com.bytedance.sdk.openadsdk.utils.UIUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class TTFullScreenExpressVideoActivity extends TTFullScreenVideoActivity implements ExpressAdInteractionListener, ExpressVideoListener {
    /* renamed from: aF */
    FullRewardExpressView f6555aF;
    /* renamed from: aG */
    FrameLayout f6556aG;
    /* renamed from: aH */
    long f6557aH;
    /* renamed from: aI */
    ITTDownloadAdapter f6558aI;
    /* renamed from: aJ */
    String f6559aJ = "fullscreen_interstitial_ad";
    /* renamed from: aK */
    Handler f6560aK;
    /* renamed from: aL */
    boolean f6561aL = false;
    /* renamed from: aM */
    boolean f6562aM = false;

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo14823b(String str) {
    }

    public void onAdClicked(View view, int i) {
    }

    public void onAdShow(View view, int i) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: I */
    public void mo14901I() {
        if (this.f6508q == null) {
            finish();
            return;
        }
        this.f6492az = false;
        this.f6508q.mo15460b(2);
        super.mo14901I();
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo14829d() {
        super.mo14829d();
        int d = ToolUtils.m12018d(this.f6508q.mo15428P());
        boolean z = false;
        boolean z2 = this.f6508q.mo15429Q() == 15;
        float a = mo14808a((Activity) this);
        float b = mo14819b((Activity) this);
        if (a > b) {
            z = true;
        }
        if (z2 != z) {
            float f = a + b;
            b = f - b;
            a = f - b;
        }
        if (UIUtils.m12075b((Activity) this)) {
            int b2 = UIUtils.m12068b((Context) this, UIUtils.m12092i(this));
            if (z2) {
                a -= (float) b2;
            } else {
                b -= (float) b2;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("screen height:");
        sb.append(a);
        sb.append(", width:");
        sb.append(b);
        C2564t.m12226e("TTFullScreenExpressVideoActivity", sb.toString());
        this.f6555aF = new FullRewardExpressView(this, this.f6508q, new Builder().setCodeId(String.valueOf(d)).setExpressViewAcceptedSize(b, a).build(), this.f6559aJ);
        this.f6555aF.setExpressVideoListenerProxy(this);
        this.f6555aF.setExpressInteractionListener(this);
        mo14907a((NativeExpressView) this.f6555aF, this.f6508q);
        this.f6556aG = this.f6555aF.getVideoFrameLayout();
        this.f6504m.addView(this.f6555aF, new LayoutParams(-1, -1));
        mo14830d(true);
        this.f6555aF.mo15878h();
    }

    /* renamed from: f */
    private void m8116f(boolean z) {
        if (this.f6493b != null) {
            this.f6493b.setShowSkip(z);
            this.f6493b.setShowSound(z);
            this.f6493b.setShowCountDown(z);
            this.f6493b.setShowDislike(z);
        }
        if (z) {
            UIUtils.m12059a((View) this.f6494c, 0);
            UIUtils.m12059a((View) this.f6484ar, 0);
            return;
        }
        UIUtils.m12059a((View) this.f6494c, 4);
        UIUtils.m12059a((View) this.f6484ar, 8);
    }

    /* renamed from: a */
    public boolean mo14908a(long j, boolean z) {
        this.f6556aG = this.f6555aF.getVideoFrameLayout();
        if (this.f6428A == null) {
            this.f6428A = new FullScreenVideoController(this.f6495d, this.f6556aG, this.f6508q);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("dynamic_show_type", Integer.valueOf(this.f6555aF.mo15883m()));
        if (!TextUtils.isEmpty(this.f6469ac)) {
            hashMap.put("rit_scene", this.f6469ac);
        }
        this.f6428A.mo15963a((Map<String, Object>) hashMap);
        this.f6428A.mo15959a((C2324a) new C2324a() {
            /* renamed from: a */
            public void mo14912a(long j, int i) {
                TTFullScreenExpressVideoActivity tTFullScreenExpressVideoActivity = TTFullScreenExpressVideoActivity.this;
                tTFullScreenExpressVideoActivity.f6562aM = true;
                tTFullScreenExpressVideoActivity.mo14923Q();
                if (TTFullScreenExpressVideoActivity.this.mo14921O()) {
                    TTFullScreenExpressVideoActivity.this.mo14850q();
                } else {
                    TTFullScreenExpressVideoActivity.this.finish();
                }
            }

            /* renamed from: b */
            public void mo14914b(long j, int i) {
                if (!TTFullScreenExpressVideoActivity.this.mo14851r()) {
                    if (TTFullScreenExpressVideoActivity.this.f6428A != null) {
                        TTFullScreenExpressVideoActivity.this.f6428A.mo15988l();
                    }
                    C2564t.m12226e("TTFullScreenExpressVideoActivity", "onError、、、、、、、、");
                    if (TTFullScreenExpressVideoActivity.this.mo14921O()) {
                        TTFullScreenExpressVideoActivity.this.mo14850q();
                        HashMap hashMap = new HashMap();
                        hashMap.put("vbtt_skip_type", Integer.valueOf(1));
                        TTFullScreenExpressVideoActivity.this.mo14816a("fullscreen_interstitial_ad", (Map<String, Object>) hashMap);
                    } else {
                        TTFullScreenExpressVideoActivity.this.finish();
                    }
                    TTFullScreenExpressVideoActivity.this.f6561aL = true;
                }
            }

            /* renamed from: a */
            public void mo14911a() {
                C2564t.m12220b("TTFullScreenExpressVideoActivity", "onTimeOut、、、、、、、、");
                if (TTFullScreenExpressVideoActivity.this.mo14921O()) {
                    TTFullScreenExpressVideoActivity.this.mo14850q();
                } else {
                    TTFullScreenExpressVideoActivity.this.finish();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("vbtt_skip_type", Integer.valueOf(0));
                TTFullScreenExpressVideoActivity.this.mo14816a("fullscreen_interstitial_ad", (Map<String, Object>) hashMap);
                if (TTFullScreenExpressVideoActivity.this.f6428A != null) {
                    TTFullScreenExpressVideoActivity.this.f6428A.mo15988l();
                }
            }

            /* renamed from: a */
            public void mo14913a(long j, long j2) {
                TTFullScreenExpressVideoActivity tTFullScreenExpressVideoActivity = TTFullScreenExpressVideoActivity.this;
                tTFullScreenExpressVideoActivity.f6557aH = j;
                long j3 = j / 1000;
                tTFullScreenExpressVideoActivity.f6441N = (int) (tTFullScreenExpressVideoActivity.mo14806G() - ((double) j3));
                if (TTFullScreenExpressVideoActivity.this.f6555aF.mo15883m()) {
                    TTFullScreenExpressVideoActivity.this.mo14925e((int) j3);
                    if (TTFullScreenExpressVideoActivity.this.f6441N >= 0 && TTFullScreenExpressVideoActivity.this.f6493b != null) {
                        TTFullScreenExpressVideoActivity.this.f6493b.setShowCountDown(true);
                        TTFullScreenExpressVideoActivity.this.f6493b.mo15164a((CharSequence) String.valueOf(TTFullScreenExpressVideoActivity.this.f6441N), (CharSequence) null);
                    }
                }
                if (TTFullScreenExpressVideoActivity.this.f6441N <= 0) {
                    C2564t.m12220b("TTFullScreenExpressVideoActivity", "onProgressUpdate、、、、、、、、");
                    if (TTFullScreenExpressVideoActivity.this.mo14921O()) {
                        TTFullScreenExpressVideoActivity.this.mo14850q();
                    } else {
                        TTFullScreenExpressVideoActivity.this.finish();
                    }
                }
                if ((TTFullScreenExpressVideoActivity.this.f6451X.get() || TTFullScreenExpressVideoActivity.this.f6449V.get()) && TTFullScreenExpressVideoActivity.this.mo14851r()) {
                    TTFullScreenExpressVideoActivity.this.f6428A.mo15984h();
                }
            }
        });
        String g = this.f6508q.mo15512z() != null ? this.f6508q.mo15512z().mo15603g() : null;
        if (this.f6513v != null) {
            File file = new File(this.f6513v);
            if (file.exists() && file.length() > 0) {
                g = this.f6513v;
                this.f6515x = true;
            }
        }
        String str = g;
        StringBuilder sb = new StringBuilder();
        sb.append("videoUrl:");
        sb.append(str);
        C2564t.m12226e("wzj", sb.toString());
        if (this.f6428A == null) {
            return false;
        }
        boolean a = this.f6428A.mo15965a(str, this.f6508q.mo15425M(), this.f6556aG.getWidth(), this.f6556aG.getHeight(), null, this.f6508q.mo15428P(), j, this.f6440M);
        if (a && !z) {
            AdEventManager.m8389a(this.f6495d, this.f6508q, "fullscreen_interstitial_ad", (Map<String, Object>) hashMap);
            mo14906N();
        }
        return a;
    }

    /* renamed from: e */
    public void mo14910e(boolean z) {
        if (this.f6440M != z && this.f6493b != null) {
            this.f6493b.mo15165b();
        }
    }

    /* renamed from: J */
    public void mo14902J() {
        if (this.f6493b != null) {
            this.f6493b.mo15163a();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (!this.f6555aF.mo15883m()) {
            m8116f(false);
        }
        UIUtils.m12053a((Activity) this);
        FullRewardExpressView fullRewardExpressView = this.f6555aF;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.mo15879i();
        }
    }

    /* renamed from: d */
    public void mo14909d(int i) {
        if (i != 1) {
            String str = "onPause throw Exception :";
            String str2 = "TTFullScreenExpressVideoActivity";
            if (i == 2) {
                try {
                    if (mo14851r()) {
                        this.f6428A.mo15984h();
                    }
                } catch (Throwable th) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(th.getMessage());
                    C2564t.m12226e(str2, sb.toString());
                }
            } else if (i == 3) {
                try {
                    if (mo14852s()) {
                        this.f6428A.mo15986j();
                    }
                } catch (Throwable th2) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(th2.getMessage());
                    C2564t.m12226e(str2, sb2.toString());
                }
            } else if (i != 4) {
                if (i == 5 && !mo14851r() && !mo14852s()) {
                    mo14908a(0, false);
                }
            } else if (this.f6428A != null) {
                this.f6428A.mo15987k();
                this.f6428A = null;
            }
        } else if (!mo14851r() && !mo14852s()) {
            mo14908a(0, false);
        }
    }

    /* renamed from: K */
    public long mo14903K() {
        return this.f6557aH;
    }

    /* renamed from: L */
    public int mo14904L() {
        if (this.f6561aL) {
            return 4;
        }
        if (this.f6562aM) {
            return 5;
        }
        if (mo14853t()) {
            return 1;
        }
        if (mo14851r()) {
            return 2;
        }
        if (mo14852s()) {
        }
        return 3;
    }

    /* renamed from: M */
    public void mo14905M() {
        mo14807H();
    }

    /* renamed from: N */
    public void mo14906N() {
        super.mo14906N();
        FullRewardExpressView fullRewardExpressView = this.f6555aF;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.mo15872g();
        }
    }

    public void onRenderFail(View view, String str, int i) {
        this.f6492az = true;
        mo14832f();
        if (this.f6560aK == null) {
            this.f6560aK = new Handler(Looper.getMainLooper());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("onRenderFail、、、code:");
        sb.append(i);
        C2564t.m12220b("TTFullScreenExpressVideoActivity", sb.toString());
        this.f6560aK.post(new Runnable() {
            public void run() {
                TTFullScreenExpressVideoActivity.this.mo14850q();
            }
        });
    }

    public void onRenderSuccess(View view, float f, float f2) {
        if (this.f6508q.mo15466c() != 1 || !this.f6508q.mo15503q()) {
            if (this.f6555aF.mo15883m()) {
                m8116f(true);
            }
            mo14830d(false);
            this.f6492az = true;
            mo14832f();
            if (!mo14908a(this.f6512u, false)) {
                mo14850q();
                HashMap hashMap = new HashMap();
                hashMap.put("vbtt_skip_type", Integer.valueOf(1));
                mo14816a(this.f6559aJ, (Map<String, Object>) hashMap);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        Handler handler = this.f6560aK;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        FullRewardExpressView fullRewardExpressView = this.f6555aF;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.mo15881k();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo14907a(NativeExpressView nativeExpressView, MaterialMeta kVar) {
        if (nativeExpressView != null && this.f6508q != null) {
            this.f6558aI = m8115a(kVar);
            ITTDownloadAdapter aVar = this.f6558aI;
            if (aVar != null) {
                aVar.mo16513b();
                if (nativeExpressView.getContext() != null && (nativeExpressView.getContext() instanceof Activity)) {
                    this.f6558aI.mo16507a((Activity) nativeExpressView.getContext());
                }
            }
            AdEventManager.m8392a(kVar);
            EmptyView a = m8114a((ViewGroup) nativeExpressView);
            if (a == null) {
                a = new EmptyView(this.f6495d, nativeExpressView);
                nativeExpressView.addView(a);
            }
            ITTDownloadAdapter aVar2 = this.f6558aI;
            if (aVar2 != null) {
                aVar2.mo16508a((View) a);
            }
            a.setCallback(new C2202a() {
                /* renamed from: a */
                public void mo14917a(View view) {
                }

                /* renamed from: a */
                public void mo14918a(boolean z) {
                    if (TTFullScreenExpressVideoActivity.this.f6558aI == null) {
                        return;
                    }
                    if (z) {
                        if (TTFullScreenExpressVideoActivity.this.f6558aI != null) {
                            TTFullScreenExpressVideoActivity.this.f6558aI.mo16513b();
                        }
                    } else if (TTFullScreenExpressVideoActivity.this.f6558aI != null) {
                        TTFullScreenExpressVideoActivity.this.f6558aI.mo16516c();
                    }
                }

                /* renamed from: a */
                public void mo14916a() {
                    if (TTFullScreenExpressVideoActivity.this.f6558aI != null) {
                        TTFullScreenExpressVideoActivity.this.f6558aI.mo16504a();
                    }
                }

                /* renamed from: b */
                public void mo14919b() {
                    if (TTFullScreenExpressVideoActivity.this.f6558aI != null) {
                        TTFullScreenExpressVideoActivity.this.f6558aI.mo16518d();
                    }
                }
            });
            Context context = this.f6495d;
            String str = this.f6559aJ;
            C20364 r2 = new ExpressClickListener(context, kVar, str, ToolUtils.m11991a(str)) {
                /* renamed from: a */
                public void mo14920a(View view, int i, int i2, int i3, int i4) {
                    super.mo14920a(view, i, i2, i3, i4);
                    TTFullScreenExpressVideoActivity.this.mo14924a(view, i, i2, i3, i4);
                }
            };
            r2.mo15277a((View) nativeExpressView);
            r2.mo15283a(this.f6558aI);
            String str2 = "rit_scene";
            if (!TextUtils.isEmpty(this.f6469ac)) {
                HashMap hashMap = new HashMap();
                hashMap.put(str2, this.f6469ac);
                r2.mo15284a((Map) hashMap);
            }
            this.f6555aF.setClickListener(r2);
            Context context2 = this.f6495d;
            String str3 = this.f6559aJ;
            C20375 r4 = new ExpressClickCreativeListener(context2, kVar, str3, ToolUtils.m11991a(str3)) {
                /* renamed from: a */
                public void mo14920a(View view, int i, int i2, int i3, int i4) {
                    super.mo14920a(view, i, i2, i3, i4);
                    TTFullScreenExpressVideoActivity.this.mo14924a(view, i, i2, i3, i4);
                }
            };
            r4.mo15277a((View) nativeExpressView);
            r4.mo15283a(this.f6558aI);
            if (!TextUtils.isEmpty(this.f6469ac)) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put(str2, this.f6469ac);
                r4.mo15284a((Map) hashMap2);
            }
            this.f6555aF.setClickCreativeListener(r4);
            a.setNeedCheckingShow(false);
        }
    }

    /* renamed from: a */
    private ITTDownloadAdapter m8115a(MaterialMeta kVar) {
        if (kVar.mo15414B() == 4) {
            return TTDownloadFactory.m11071a(this.f6495d, kVar, this.f6559aJ);
        }
        return null;
    }

    /* renamed from: a */
    private EmptyView m8114a(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }
}
