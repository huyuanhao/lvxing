package com.kwad.sdk.contentalliance.detail.photo.p314c;

import android.view.View;
import com.kwad.sdk.core.p333g.C4145c;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.core.response.p342b.C4325d;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.kwad.sdk.contentalliance.detail.photo.c.g */
public class C3943g extends C3936a {
    /* renamed from: d */
    private long f13291d;
    /* renamed from: e */
    private C3945h f13292e;
    /* renamed from: f */
    private long f13293f = 0;

    /* renamed from: com.kwad.sdk.contentalliance.detail.photo.c.g$a */
    public static class C3944a {
        /* renamed from: a */
        private static Set<Long> f13294a = new HashSet();

        /* renamed from: a */
        public static void m16349a(long j) {
            f13294a.add(Long.valueOf(j));
        }

        /* renamed from: b */
        public static void m16350b(long j) {
            f13294a.remove(Long.valueOf(j));
        }

        /* renamed from: c */
        public static boolean m16351c(long j) {
            return f13294a.contains(Long.valueOf(j));
        }
    }

    /* renamed from: q */
    private long m16342q() {
        long k = C4325d.m17682k(C4324c.m17669f(this.f13125b.f13133g));
        if (k < 0) {
            k = 0;
        }
        return C3944a.m16351c(this.f13291d) ? k + 1 : k;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23338a() {
        super.mo23338a();
        this.f13291d = C4325d.m17680i(C4324c.m17669f(this.f13125b.f13133g));
        this.f13293f = m16342q();
        this.f13292e.mo23449a(C3944a.m16351c(this.f13291d) ? 2 : 1, this.f13293f);
        this.f13292e.setOnClickListener(this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo23339b() {
        super.mo23339b();
        this.f13292e = (C3945h) this.f13286c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo23340c() {
        super.mo23340c();
        this.f13292e.setOnClickListener(null);
        this.f13292e.mo23451b();
    }

    /* renamed from: h */
    public C3945h mo23408g() {
        return new C3945h(mo24770p());
    }

    /* renamed from: i */
    public void mo23447i() {
        if (!this.f13292e.mo23450a()) {
            this.f13292e.setLikeState(2);
            C3945h hVar = this.f13292e;
            long j = this.f13293f + 1;
            this.f13293f = j;
            hVar.setLikeCount(j);
            C3944a.m16349a(this.f13291d);
            C4145c.m17158a(this.f13125b.f13133g, (long) this.f13125b.f13132f, 1, 1);
            return;
        }
        C4145c.m17158a(this.f13125b.f13133g, (long) this.f13125b.f13132f, 2, 1);
    }

    public void onClick(View view) {
        if (this.f13292e.mo23450a()) {
            this.f13292e.setLikeState(1);
            C3945h hVar = this.f13292e;
            long j = this.f13293f - 1;
            this.f13293f = j;
            hVar.setLikeCount(j);
            C3944a.m16350b(this.f13291d);
            C4145c.m17167c(this.f13125b.f13133g, (long) this.f13125b.f13132f);
            return;
        }
        this.f13292e.setLikeState(2);
        C3945h hVar2 = this.f13292e;
        long j2 = this.f13293f + 1;
        this.f13293f = j2;
        hVar2.setLikeCount(j2);
        C3944a.m16349a(this.f13291d);
        C4145c.m17158a(this.f13125b.f13133g, (long) this.f13125b.f13132f, 1, 2);
    }
}
