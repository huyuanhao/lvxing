package com.bytedance.sdk.openadsdk.component.reward.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.nativeexpress.ExpressBackupListener;
import com.bytedance.sdk.openadsdk.core.nativeexpress.ExpressVideoListener;
import com.bytedance.sdk.openadsdk.core.nativeexpress.FullRewardExpressBackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.p170d.DynamicClickInfo;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.p170d.RenderInfo;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.UIUtils;

public class FullRewardExpressView extends NativeExpressView implements ExpressVideoListener {
    /* renamed from: a */
    ExpressVideoListener f7027a;
    /* renamed from: b */
    FullRewardExpressBackupView f7028b;

    public FullRewardExpressView(Context context, MaterialMeta kVar, AdSlot adSlot, String str) {
        super(context, kVar, adSlot, str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo15183a() {
        this.f7794o = true;
        this.f7792m = new FrameLayout(this.f7785f);
        addView(this.f7792m, new LayoutParams(-1, -1));
        super.mo15183a();
        getWebView().setBackgroundColor(0);
        m8834c();
    }

    /* renamed from: c */
    private void m8834c() {
        setBackupListener(new ExpressBackupListener() {
            /* renamed from: a */
            public boolean mo15189a(NativeExpressView nativeExpressView, int i) {
                nativeExpressView.mo15882l();
                FullRewardExpressView.this.f7028b = new FullRewardExpressBackupView(nativeExpressView.getContext());
                FullRewardExpressView.this.f7028b.mo15865a(FullRewardExpressView.this.f7790k, nativeExpressView, null);
                return true;
            }
        });
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo15186b() {
        super.mo15186b();
        this.f7787h.mo16401a((ExpressVideoListener) this);
    }

    public void setExpressVideoListenerProxy(ExpressVideoListener gVar) {
        this.f7027a = gVar;
    }

    /* renamed from: a */
    public void mo15185a(RenderInfo mVar) {
        if (mVar != null && mVar.mo15532a()) {
            m8833b(mVar);
        }
        super.mo15185a(mVar);
    }

    /* renamed from: b */
    private void m8833b(final RenderInfo mVar) {
        if (mVar != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                m8835c(mVar);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        FullRewardExpressView.this.m8835c(mVar);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m8835c(RenderInfo mVar) {
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
        }
    }

    /* renamed from: e */
    public void mo14910e(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("onMuteVideo,mute:");
        sb.append(z);
        C2564t.m12220b("FullRewardExpressView", sb.toString());
        ExpressVideoListener gVar = this.f7027a;
        if (gVar != null) {
            gVar.mo14910e(z);
        }
    }

    /* renamed from: J */
    public void mo14902J() {
        C2564t.m12220b("FullRewardExpressView", "onSkipVideo");
        ExpressVideoListener gVar = this.f7027a;
        if (gVar != null) {
            gVar.mo14902J();
        }
    }

    /* renamed from: d */
    public void mo14909d(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("onChangeVideoState,stateType:");
        sb.append(i);
        C2564t.m12220b("FullRewardExpressView", sb.toString());
        ExpressVideoListener gVar = this.f7027a;
        if (gVar != null) {
            gVar.mo14909d(i);
        }
    }

    /* renamed from: K */
    public long mo14903K() {
        C2564t.m12220b("FullRewardExpressView", "onGetCurrentPlayTime");
        ExpressVideoListener gVar = this.f7027a;
        if (gVar != null) {
            return gVar.mo14903K();
        }
        return 0;
    }

    /* renamed from: L */
    public int mo14904L() {
        C2564t.m12220b("FullRewardExpressView", "onGetVideoState");
        ExpressVideoListener gVar = this.f7027a;
        if (gVar != null) {
            return gVar.mo14904L();
        }
        return 0;
    }

    /* renamed from: M */
    public void mo14905M() {
        ExpressVideoListener gVar = this.f7027a;
        if (gVar != null) {
            gVar.mo14905M();
        }
    }

    /* renamed from: a */
    public void mo15184a(int i, DynamicClickInfo iVar) {
        if (!(i == -1 || iVar == null || i != 3)) {
            mo14905M();
        }
        super.mo15184a(i, iVar);
    }

    public FrameLayout getVideoFrameLayout() {
        if (mo15883m()) {
            return this.f7028b.getVideoContainer();
        }
        return this.f7792m;
    }
}
