package com.kwad.sdk.draw.view;

import android.content.Context;
import android.os.Message;
import android.view.View;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.p306a.C3817t;
import com.kwad.sdk.p306a.C3818u;
import com.kwad.sdk.p306a.C3818u.C3819a;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.kwad.sdk.draw.view.a */
public abstract class C4386a extends AdBaseFrameLayout implements C3819a {
    /* renamed from: a */
    private View f14373a = this;
    /* renamed from: b */
    private final C3818u f14374b = new C3818u(this);
    /* renamed from: c */
    private final AtomicBoolean f14375c = new AtomicBoolean(true);

    public C4386a(Context context) {
        super(context);
    }

    /* renamed from: e */
    private void mo24595e() {
        if (this.f14375c.getAndSet(false)) {
            C4065b.m16867b("BasePvView", "onViewAttached");
            this.f14374b.sendEmptyMessage(1);
            mo24579b();
        }
    }

    /* renamed from: f */
    private void m17892f() {
        if (!this.f14375c.getAndSet(true)) {
            C4065b.m16867b("BasePvView", "onViewDetached");
            this.f14374b.removeCallbacksAndMessages(null);
            mo24578a();
        }
    }

    /* renamed from: a */
    public abstract void mo24578a();

    /* renamed from: a */
    public void mo23214a(Message message) {
        if (message.what == 1) {
            if (C3817t.m15867a(this.f14373a, 70)) {
                mo24580c();
            } else {
                mo24581d();
            }
            this.f14374b.sendEmptyMessageDelayed(1, 500);
        }
    }

    /* renamed from: b */
    public abstract void mo24579b();

    /* renamed from: c */
    public abstract void mo24580c();

    /* renamed from: d */
    public abstract void mo24581d();

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        C4065b.m16867b("BasePvView", "onAttachedToWindow");
        mo24595e();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C4065b.m16867b("BasePvView", "onDetachedFromWindow");
        m17892f();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        C4065b.m16867b("BasePvView", "onFinishTemporaryDetach");
        mo24595e();
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        C4065b.m16867b("BasePvView", "onStartTemporaryDetach");
        m17892f();
    }
}
