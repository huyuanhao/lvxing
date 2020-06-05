package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.LinearLayout;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.p306a.C3812o;
import com.kwad.sdk.p306a.C3816s;

/* renamed from: com.kwad.sdk.widget.b */
public class C4581b extends LinearLayout {
    /* renamed from: a */
    private long f14948a = 500;
    /* renamed from: b */
    private boolean f14949b;
    /* renamed from: c */
    private boolean f14950c = true;
    /* renamed from: d */
    private int f14951d;
    /* renamed from: e */
    private OnScrollChangedListener f14952e;
    /* renamed from: f */
    private ViewTreeObserver f14953f;
    /* renamed from: g */
    private C3816s f14954g;

    public C4581b(Context context) {
        super(context);
        m18568e();
    }

    public C4581b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18568e();
    }

    /* renamed from: e */
    private void m18568e() {
        this.f14954g = new C3816s(this);
        this.f14951d = C3812o.m15837h(getContext());
        this.f14950c = mo24887b();
    }

    /* renamed from: f */
    private void m18569f() {
        if (m18570g()) {
            mo24605a();
        } else {
            m18571h();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public boolean m18570g() {
        return this.f14954g.mo23212a() && ((float) Math.abs(this.f14954g.f12933a.height() - getHeight())) <= ((float) getHeight()) * 0.9f && getHeight() > 0 && getWidth() > 0 && this.f14954g.f12933a.bottom > 0 && this.f14954g.f12933a.top < this.f14951d;
    }

    /* renamed from: h */
    private void m18571h() {
        if (this.f14952e == null) {
            this.f14952e = new OnScrollChangedListener() {
                public void onScrollChanged() {
                    if (C4581b.this.m18570g()) {
                        C4581b.this.mo24605a();
                    }
                }
            };
            this.f14953f = getViewTreeObserver();
            ViewTreeObserver viewTreeObserver = this.f14953f;
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.f14952e);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo24605a() {
        mo24889d();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo24887b() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo24888c() {
        if (this.f14950c) {
            m18569f();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo24889d() {
        try {
            if (this.f14952e != null && this.f14953f != null) {
                this.f14953f.removeOnScrollChangedListener(this.f14952e);
            }
        } catch (Exception e) {
            C4065b.m16865a(e);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m18571h();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mo24889d();
        this.f14949b = false;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        boolean z = true;
        if (this.f14949b || (i3 | i4) != 0 || (i | i2) == 0) {
            z = false;
        } else {
            this.f14949b = true;
        }
        super.onSizeChanged(i, i2, i3, i4);
        if (z) {
            mo24888c();
        }
    }
}
