package com.kwad.sdk.core.view;

import android.content.Context;
import android.widget.FrameLayout;
import com.kwad.sdk.core.p319c.C4065b;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.kwad.sdk.core.view.a */
public abstract class C4370a extends FrameLayout {
    /* renamed from: a */
    private final AtomicBoolean f14313a = new AtomicBoolean(true);

    public C4370a(Context context) {
        super(context);
    }

    /* renamed from: c */
    private void m17837c() {
        if (this.f14313a.getAndSet(false)) {
            C4065b.m16867b("BasePvView", "onViewAttached");
            mo24536b();
        }
    }

    /* renamed from: d */
    private void m17838d() {
        if (!this.f14313a.getAndSet(true)) {
            C4065b.m16867b("BasePvView", "onViewDetached");
            mo24535a();
        }
    }

    /* renamed from: a */
    public abstract void mo24535a();

    /* renamed from: b */
    public abstract void mo24536b();

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m17837c();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m17838d();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        m17837c();
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        m17838d();
    }
}
