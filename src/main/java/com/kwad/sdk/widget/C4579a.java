package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.p306a.C3812o;
import com.kwad.sdk.p306a.C3816s;

/* renamed from: com.kwad.sdk.widget.a */
public class C4579a extends RatioFrameLayout {
    /* renamed from: a */
    private long f14940a = 500;
    /* renamed from: b */
    private boolean f14941b;
    /* renamed from: c */
    private boolean f14942c = true;
    /* renamed from: d */
    private int f14943d;
    /* renamed from: e */
    private OnScrollChangedListener f14944e;
    /* renamed from: f */
    private ViewTreeObserver f14945f;
    /* renamed from: g */
    private C3816s f14946g;

    public C4579a(Context context) {
        super(context);
        mo24610a();
    }

    public C4579a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mo24610a();
    }

    /* renamed from: a */
    private void mo24610a() {
        this.f14946g = new C3816s(this);
        this.f14943d = C3812o.m15837h(getContext());
        this.f14942c = mo24880c();
    }

    /* renamed from: f */
    private void m18560f() {
        if (m18561g()) {
            mo24612b();
        } else {
            m18562h();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public boolean m18561g() {
        return this.f14946g.mo23212a() && ((float) Math.abs(this.f14946g.f12933a.height() - getHeight())) <= ((float) getHeight()) * 0.9f && getHeight() > 0 && getWidth() > 0 && this.f14946g.f12933a.bottom > 0 && this.f14946g.f12933a.top < this.f14943d;
    }

    /* renamed from: h */
    private void m18562h() {
        if (this.f14944e == null) {
            this.f14944e = new OnScrollChangedListener() {
                public void onScrollChanged() {
                    if (C4579a.this.m18561g()) {
                        C4579a.this.mo24612b();
                    }
                }
            };
            this.f14945f = getViewTreeObserver();
            ViewTreeObserver viewTreeObserver = this.f14945f;
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.f14944e);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo24612b() {
        mo24882e();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo24880c() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo24881d() {
        if (this.f14942c) {
            m18560f();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo24882e() {
        try {
            if (this.f14944e != null && this.f14945f != null) {
                this.f14945f.removeOnScrollChangedListener(this.f14944e);
            }
        } catch (Exception e) {
            C4065b.m16865a(e);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m18562h();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mo24882e();
        this.f14941b = false;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        boolean z = true;
        if (this.f14941b || (i3 | i4) != 0 || (i | i2) == 0) {
            z = false;
        } else {
            this.f14941b = true;
        }
        super.onSizeChanged(i, i2, i3, i4);
        if (z) {
            mo24881d();
        }
    }
}
