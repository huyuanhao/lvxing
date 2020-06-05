package com.kwad.sdk.contentalliance.detail.photo.p314c;

import android.view.View;
import com.kwad.sdk.core.p333g.C4145c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.core.response.p342b.C4325d;

/* renamed from: com.kwad.sdk.contentalliance.detail.photo.c.e */
public class C3940e extends C3936a {
    /* renamed from: d */
    private long f13288d;
    /* renamed from: e */
    private C3942f f13289e;

    /* renamed from: com.kwad.sdk.contentalliance.detail.photo.c.e$a */
    public interface C3941a {
        /* renamed from: a */
        void mo23415a(AdTemplate adTemplate, long j);
    }

    /* renamed from: i */
    private void m16334i() {
        for (C3941a a : this.f13125b.f13130d) {
            a.mo23415a(this.f13125b.f13133g, (long) this.f13125b.f13132f);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23338a() {
        super.mo23338a();
        this.f13288d = C4325d.m17680i(C4324c.m17669f(this.f13125b.f13133g));
        this.f13289e.setCommentCount(C4325d.m17683l(C4324c.m17669f(this.f13125b.f13133g)));
        this.f13289e.setOnClickListener(this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo23339b() {
        super.mo23339b();
        this.f13289e = (C3942f) this.f13286c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo23340c() {
        super.mo23340c();
        this.f13289e.setOnClickListener(null);
    }

    /* renamed from: h */
    public C3942f mo23408g() {
        return new C3942f(mo24770p());
    }

    public void onClick(View view) {
        if (this.f13125b != null) {
            m16334i();
            C4145c.m17171e(this.f13125b.f13133g, (long) this.f13125b.f13132f);
        }
    }
}
