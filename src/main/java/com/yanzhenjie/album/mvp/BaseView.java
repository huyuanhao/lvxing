package com.yanzhenjie.album.mvp;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.yanzhenjie.album.mvp.BasePresenter;

/* renamed from: com.yanzhenjie.album.mvp.b */
public abstract class BaseView<Presenter extends BasePresenter> {
    /* renamed from: a */
    private C7766d f26338a;
    /* renamed from: b */
    private Presenter f26339b;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo37633a(Menu menu) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo37634a(MenuItem menuItem) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo37696b() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo37697c() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo37699d() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo37703e() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public boolean mo37708h() {
        return false;
    }

    public BaseView(Activity activity, Presenter presenter) {
        this((C7766d) new ActivitySource(activity), presenter);
    }

    private BaseView(C7766d dVar, Presenter presenter) {
        this.f26338a = dVar;
        this.f26339b = presenter;
        this.f26338a.mo37681a();
        mo37705f();
        this.f26338a.mo37685a((C7767a) new C7767a() {
            /* renamed from: a */
            public void mo37712a() {
                BaseView.this.mo37693a().mo37680h();
            }

            /* renamed from: a */
            public void mo37713a(MenuItem menuItem) {
                BaseView.this.m33595b(menuItem);
            }
        });
        mo37693a().getLifecycle().addObserver(new BaseView$2(this));
    }

    /* renamed from: a */
    public final Presenter mo37693a() {
        return this.f26339b;
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m33599l() {
        mo37696b();
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m33600m() {
        mo37697c();
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m33601n() {
        mo37699d();
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m33602o() {
        mo37709i();
        mo37703e();
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: f */
    public final void mo37705f() {
        Menu c = this.f26338a.mo37689c();
        if (c != null) {
            mo37633a(c);
        }
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: g */
    public final MenuInflater mo37706g() {
        return this.f26338a.mo37687b();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m33595b(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            mo37634a(menuItem);
        } else if (!mo37708h()) {
            mo37693a().mo37680h();
        }
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: i */
    public final void mo37709i() {
        this.f26338a.mo37691e();
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: d */
    public final void mo37700d(int i) {
        this.f26338a.mo37682a(i);
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo37694a(Drawable drawable) {
        this.f26338a.mo37683a(drawable);
    }

    /* renamed from: c */
    public final void mo37698c(String str) {
        this.f26338a.mo37686a((CharSequence) str);
    }

    /* renamed from: d */
    public final void mo37701d(String str) {
        this.f26338a.mo37688b(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public Context mo37710j() {
        return this.f26338a.mo37690d();
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public Resources mo37711k() {
        return mo37710j().getResources();
    }

    /* renamed from: e */
    public final Drawable mo37702e(int i) {
        return ContextCompat.getDrawable(this.f26338a.mo37690d(), i);
    }

    /* renamed from: f */
    public final int mo37704f(int i) {
        return ContextCompat.getColor(this.f26338a.mo37690d(), i);
    }

    /* renamed from: a */
    public void mo37695a(CharSequence charSequence) {
        Toast.makeText(mo37710j(), charSequence, 1).show();
    }

    /* renamed from: g */
    public void mo37707g(int i) {
        Toast.makeText(mo37710j(), i, 1).show();
    }
}
