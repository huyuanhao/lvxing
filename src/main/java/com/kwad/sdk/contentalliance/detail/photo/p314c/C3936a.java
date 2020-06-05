package com.kwad.sdk.contentalliance.detail.photo.p314c;

import android.widget.LinearLayout;
import com.kwad.sdk.contentalliance.detail.C3872b;

/* renamed from: com.kwad.sdk.contentalliance.detail.photo.c.a */
public abstract class C3936a extends C3872b implements C3938c {
    /* renamed from: c */
    protected LinearLayout f13286c = null;
    /* renamed from: d */
    private LinearLayout f13287d;

    /* renamed from: h */
    private LinearLayout mo23444h() {
        if (this.f13286c == null) {
            this.f13286c = mo23408g();
        }
        return this.f13286c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23338a() {
        super.mo23338a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo23339b() {
        super.mo23339b();
        this.f13287d = (LinearLayout) mo24760a("ksad_photo_detail_bottom_toolbar");
        this.f13287d.addView(mo23444h());
        this.f13287d.setVisibility(0);
    }
}
