package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.p170d.DynamicClickInfo;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.p170d.RenderInfo;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.INativeVideoController.C2325b;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.INativeVideoController.C2326c;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.C2322a;
import com.bytedance.sdk.openadsdk.multipro.p203b.VideoControllerDataModel;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.C2566w;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import com.bytedance.sdk.openadsdk.utils.UIUtils;

public class NativeExpressVideoView extends NativeExpressView implements ExpressVideoListener, C2325b, C2326c {
    /* renamed from: a */
    int f7763a = 1;
    /* renamed from: b */
    boolean f7764b = false;
    /* renamed from: c */
    boolean f7765c = true;
    /* renamed from: d */
    int f7766d;
    /* renamed from: t */
    private ExpressVideoView f7767t;
    /* access modifiers changed from: private */
    /* renamed from: u */
    public VideoControllerDataModel f7768u;
    /* renamed from: v */
    private long f7769v;
    /* renamed from: w */
    private long f7770w;

    /* renamed from: M */
    public void mo14905M() {
    }

    public NativeExpressVideoView(Context context, MaterialMeta kVar, AdSlot adSlot, String str) {
        super(context, kVar, adSlot, str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo15183a() {
        this.f7792m = new FrameLayout(this.f7785f);
        this.f7766d = ToolUtils.m12018d(this.f7790k.mo15428P());
        mo15867a(this.f7766d);
        m9936n();
        addView(this.f7792m, new LayoutParams(-1, -1));
        super.mo15183a();
        getWebView().setBackgroundColor(0);
    }

    /* renamed from: n */
    private void m9936n() {
        try {
            this.f7768u = new VideoControllerDataModel();
            this.f7767t = new ExpressVideoView(this.f7785f, this.f7790k, this.f7788i);
            this.f7767t.setShouldCheckNetChange(false);
            this.f7767t.setControllerStatusCallBack(new C2322a() {
                /* renamed from: a */
                public void mo15052a(boolean z, long j, long j2, long j3, boolean z2) {
                    NativeExpressVideoView.this.f7768u.f9080a = z;
                    NativeExpressVideoView.this.f7768u.f9084e = j;
                    NativeExpressVideoView.this.f7768u.f9085f = j2;
                    NativeExpressVideoView.this.f7768u.f9086g = j3;
                    NativeExpressVideoView.this.f7768u.f9083d = z2;
                }
            });
            this.f7767t.setVideoAdLoadListener(this);
            this.f7767t.setVideoAdInteractionListener(this);
            String str = "splash_ad";
            if ("embeded_ad".equals(this.f7788i)) {
                this.f7767t.setIsAutoPlay(this.f7764b ? this.f7789j.isAutoPlay() : this.f7765c);
            } else if (str.equals(this.f7788i)) {
                this.f7767t.setIsAutoPlay(true);
            } else {
                this.f7767t.setIsAutoPlay(this.f7765c);
            }
            if (str.equals(this.f7788i)) {
                this.f7767t.setIsQuiet(true);
            } else {
                this.f7767t.setIsQuiet(InternalContainer.m10069h().mo15774a(this.f7766d));
            }
            this.f7767t.mo15858d();
        } catch (Exception unused) {
            this.f7767t = null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo15867a(int i) {
        int c = InternalContainer.m10069h().mo15779c(i);
        if (3 == c) {
            this.f7764b = false;
            this.f7765c = false;
        } else if (1 == c && C2566w.m12245d(this.f7785f)) {
            this.f7764b = false;
            this.f7765c = true;
        } else if (2 == c) {
            if (C2566w.m12246e(this.f7785f) || C2566w.m12245d(this.f7785f)) {
                this.f7764b = false;
                this.f7765c = true;
            }
        } else if (4 == c) {
            this.f7764b = true;
        }
    }

    public VideoControllerDataModel getVideoModel() {
        return this.f7768u;
    }

    public void setCanInterruptVideoPlay(boolean z) {
        ExpressVideoView expressVideoView = this.f7767t;
        if (expressVideoView != null) {
            expressVideoView.setCanInterruptVideoPlay(z);
        }
    }

    private void setShowAdInteractionView(boolean z) {
        ExpressVideoView expressVideoView = this.f7767t;
        if (expressVideoView != null) {
            expressVideoView.setShowAdInteractionView(z);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo15186b() {
        super.mo15186b();
        this.f7787h.mo16401a((ExpressVideoListener) this);
    }

    /* renamed from: a */
    public void mo15185a(RenderInfo mVar) {
        if (mVar != null && mVar.mo15532a()) {
            m9934b(mVar);
        }
        super.mo15185a(mVar);
    }

    /* renamed from: b */
    private void m9934b(final RenderInfo mVar) {
        if (mVar != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                m9935c(mVar);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        NativeExpressVideoView.this.m9935c(mVar);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m9935c(RenderInfo mVar) {
        if (mVar != null) {
            double d = mVar.mo15537d();
            double e = mVar.mo15539e();
            double f = mVar.mo15541f();
            double g = mVar.mo15543g();
            int a = (int) UIUtils.m12048a(this.f7785f, (float) d);
            int a2 = (int) UIUtils.m12048a(this.f7785f, (float) e);
            int a3 = (int) UIUtils.m12048a(this.f7785f, (float) f);
            int a4 = (int) UIUtils.m12048a(this.f7785f, (float) g);
            StringBuilder sb = new StringBuilder();
            sb.append("videoWidth:");
            sb.append(f);
            String str = "ExpressView";
            C2564t.m12220b(str, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("videoHeight:");
            sb2.append(g);
            C2564t.m12220b(str, sb2.toString());
            LayoutParams layoutParams = (LayoutParams) this.f7792m.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LayoutParams(a3, a4);
            }
            layoutParams.width = a3;
            layoutParams.height = a4;
            layoutParams.topMargin = a2;
            layoutParams.leftMargin = a;
            this.f7792m.setLayoutParams(layoutParams);
            this.f7792m.removeAllViews();
            this.f7792m.addView(this.f7767t);
            this.f7767t.mo16094a(0, true, false);
            setShowAdInteractionView(false);
        }
    }

    /* renamed from: e */
    public void mo14910e(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("onMuteVideo,mute:");
        sb.append(z);
        C2564t.m12220b("NativeExpressVideoView", sb.toString());
        ExpressVideoView expressVideoView = this.f7767t;
        if (expressVideoView != null && expressVideoView.getNativeVideoController() != null) {
            this.f7767t.getNativeVideoController().mo15975c(z);
        }
    }

    /* renamed from: J */
    public void mo14902J() {
        C2564t.m12220b("NativeExpressVideoView", "onSkipVideo");
    }

    /* renamed from: d */
    public void mo14909d(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("onChangeVideoState,stateType:");
        sb.append(i);
        C2564t.m12220b("NativeExpressVideoView", sb.toString());
        if (i == 1) {
            this.f7767t.mo16094a(0, true, false);
        } else if (i == 2 || i == 3) {
            this.f7767t.setCanInterruptVideoPlay(true);
            this.f7767t.performClick();
        } else if (i == 4) {
            this.f7767t.getNativeVideoController().mo15988l();
        } else if (i == 5) {
            this.f7767t.mo16094a(0, true, false);
        }
    }

    /* renamed from: a */
    public void mo15184a(int i, DynamicClickInfo iVar) {
        if (!(i == -1 || iVar == null)) {
            if (i == 4 && this.f7788i == "draw_ad") {
                ExpressVideoView expressVideoView = this.f7767t;
                if (expressVideoView != null) {
                    expressVideoView.performClick();
                }
                return;
            }
            super.mo15184a(i, iVar);
        }
    }

    /* renamed from: K */
    public long mo14903K() {
        return this.f7769v;
    }

    /* renamed from: L */
    public int mo14904L() {
        if (this.f7767t.getNativeVideoController().mo15999w()) {
            return 1;
        }
        return this.f7763a;
    }

    /* renamed from: e */
    public void mo15050e() {
        C2564t.m12220b("NativeExpressVideoView", "onVideoAdStartPlay");
        if (this.f7791l != null) {
            this.f7791l.onVideoAdStartPlay();
        }
        this.f7763a = 2;
    }

    /* renamed from: d */
    public void mo15048d() {
        C2564t.m12220b("NativeExpressVideoView", "onVideoAdPaused");
        if (this.f7791l != null) {
            this.f7791l.onVideoAdPaused();
        }
        this.f7793n = true;
        this.f7763a = 3;
    }

    /* renamed from: c */
    public void mo15047c() {
        C2564t.m12220b("NativeExpressVideoView", "onVideoAdContinuePlay");
        if (this.f7791l != null) {
            this.f7791l.onVideoAdContinuePlay();
        }
        this.f7793n = false;
        this.f7763a = 2;
    }

    /* renamed from: a */
    public void mo15046a(long j, long j2) {
        if (this.f7791l != null) {
            this.f7791l.onProgressUpdate(j, j2);
        }
        int i = this.f7763a;
        if (!(i == 5 || i == 3 || j <= this.f7769v)) {
            this.f7763a = 2;
        }
        this.f7769v = j;
        this.f7770w = j2;
    }

    /* renamed from: d_ */
    public void mo15049d_() {
        C2564t.m12220b("NativeExpressVideoView", "onVideoComplete");
        if (this.f7791l != null) {
            this.f7791l.onVideoAdComplete();
        }
        this.f7763a = 5;
    }

    /* renamed from: f */
    public void mo15051f() {
        C2564t.m12220b("NativeExpressVideoView", "onVideoLoad");
        if (this.f7791l != null) {
            this.f7791l.onVideoLoad();
        }
    }

    /* renamed from: a */
    public void mo15045a(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("onVideoError,errorCode:");
        sb.append(i);
        sb.append(",extraCode:");
        sb.append(i2);
        C2564t.m12220b("NativeExpressVideoView", sb.toString());
        if (this.f7791l != null) {
            this.f7791l.onVideoError(i, i2);
        }
        this.f7769v = this.f7770w;
        this.f7763a = 4;
    }
}
