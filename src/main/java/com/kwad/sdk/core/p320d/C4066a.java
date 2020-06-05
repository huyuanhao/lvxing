package com.kwad.sdk.core.p320d;

import android.app.Activity;
import android.view.View;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.reward.C4527a;
import com.kwad.sdk.reward.p351a.C4528a;

/* renamed from: com.kwad.sdk.core.d.a */
public abstract class C4066a<T extends C4527a> extends Activity {
    /* renamed from: a */
    protected Presenter f13674a;
    /* renamed from: b */
    protected T f13675b;
    /* renamed from: c */
    protected View f13676c;

    /* renamed from: c */
    private void m16871c() {
        T t = this.f13675b;
        if (t != null) {
            for (C4528a a : t.f14757a) {
                a.mo24813a();
            }
        }
    }

    /* renamed from: d */
    private void m16872d() {
        T t = this.f13675b;
        if (t != null) {
            for (C4528a b : t.f14757a) {
                b.mo24814b();
            }
        }
    }

    /* renamed from: e */
    private void m16873e() {
        T t = this.f13675b;
        if (t != null) {
            for (C4528a c : t.f14757a) {
                c.mo24815c();
            }
        }
    }

    /* renamed from: f */
    private void m16874f() {
        T t = this.f13675b;
        if (t != null) {
            for (C4528a d : t.f14757a) {
                d.mo24816d();
            }
        }
    }

    /* renamed from: a */
    public abstract T mo23723a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23724a(View view) {
        this.f13676c = view;
        this.f13675b = mo23723a();
        if (this.f13674a == null) {
            this.f13674a = mo23725b();
            this.f13674a.mo24761a(this.f13676c);
        }
        this.f13674a.mo24763a((Object) this.f13675b);
        m16871c();
    }

    /* renamed from: b */
    public abstract Presenter mo23725b();

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        m16874f();
        T t = this.f13675b;
        if (t != null) {
            t.mo23367a();
        }
        Presenter presenter = this.f13674a;
        if (presenter != null) {
            presenter.mo24765k();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        m16873e();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        m16872d();
    }
}
