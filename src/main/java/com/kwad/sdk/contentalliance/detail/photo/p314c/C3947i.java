package com.kwad.sdk.contentalliance.detail.photo.p314c;

import android.view.View;
import com.kwad.sdk.contentalliance.detail.photo.p312a.C3894d;
import com.kwad.sdk.contentalliance.detail.photo.p312a.C3895e;
import com.kwad.sdk.core.p333g.C4145c;

/* renamed from: com.kwad.sdk.contentalliance.detail.photo.c.i */
public class C3947i extends C3936a {
    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23338a() {
        super.mo23338a();
        this.f13286c.setOnClickListener(this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo23339b() {
        super.mo23339b();
    }

    /* renamed from: h */
    public C3939d mo23408g() {
        return new C3939d(mo24770p());
    }

    public void onClick(View view) {
        if (this.f13125b != null) {
            C4145c.m17165b(this.f13125b.f13133g, (long) this.f13125b.f13132f);
            C3895e.m16184a(mo24770p(), new C3894d(this.f13125b.f13133g, (long) this.f13125b.f13132f));
        }
    }
}
