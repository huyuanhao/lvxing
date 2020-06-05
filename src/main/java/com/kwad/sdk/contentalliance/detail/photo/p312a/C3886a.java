package com.kwad.sdk.contentalliance.detail.photo.p312a;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.kwad.sdk.contentalliance.detail.photo.p314c.C3938c;
import com.kwad.sdk.mvp.Presenter;

/* renamed from: com.kwad.sdk.contentalliance.detail.photo.a.a */
public abstract class C3886a extends Presenter implements C3938c {
    /* renamed from: a */
    protected C3893c f13167a = null;
    /* renamed from: b */
    protected LinearLayout f13168b = null;

    /* renamed from: h */
    private LinearLayout m16161h() {
        if (this.f13168b == null) {
            this.f13168b = mo23408g();
        }
        return this.f13168b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23338a() {
        super.mo23338a();
        this.f13167a = (C3893c) mo24769o();
        this.f13168b.setOnClickListener(this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo23339b() {
        super.mo23339b();
        mo23386d_();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo23340c() {
        super.mo23340c();
        this.f13168b.setOnClickListener(null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d_ */
    public void mo23386d_() {
        ((ViewGroup) mo24768n()).addView(m16161h());
    }
}
