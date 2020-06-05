package com.p368pw.inner.base.p384a;

import android.content.Context;
import com.p368pw.inner.C5237f;
import com.p368pw.inner.C5238g;
import com.p368pw.inner.appwall.C5030k;
import com.p368pw.inner.base.C5114a.C5117a;
import com.p368pw.inner.base.C5139c;
import com.p368pw.inner.base.C5139c.C5141a;
import com.p368pw.inner.base.p387d.C5187e;
import com.p368pw.inner.base.p387d.C5205o;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.pw.inner.base.a.f */
public class C5125f implements C5141a {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public Set<C5128b> f16736a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public Context f16737b;
    /* access modifiers changed from: private|volatile */
    /* renamed from: c */
    public volatile C5123d f16738c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public C5030k f16739d;
    /* renamed from: e */
    private C5127a f16740e;

    /* renamed from: com.pw.inner.base.a.f$a */
    public interface C5127a {
        /* renamed from: a */
        void mo26730a();
    }

    /* renamed from: com.pw.inner.base.a.f$b */
    public interface C5128b {
        /* renamed from: a */
        void mo26731a(String str);
    }

    /* renamed from: com.pw.inner.base.a.f$c */
    private static class C5129c {
        /* access modifiers changed from: private|static */
        /* renamed from: a */
        public static C5125f f16743a = new C5125f();
    }

    /* renamed from: a */
    public static C5125f m21216a() {
        return C5129c.f16743a;
    }

    /* renamed from: a */
    private void m21217a(final Context context) {
        new C5124e("343,399").mo26658a(new C5117a<C5123d>() {
            /* renamed from: a */
            public void mo26344a(C5123d dVar) {
                C5237f.m21585c(context, dVar.mo26694V());
                C5238g.m21605a(C5125f.this.f16737b, dVar.mo26694V());
                if (C5187e.m21372a(C5125f.this.f16737b, dVar.mo26694V())) {
                    C5237f.m21572a(context, System.currentTimeMillis());
                }
                C5125f.this.f16738c = dVar;
                C5125f.this.f16739d = new C5030k(dVar.mo26694V());
                for (C5128b a : C5125f.this.f16736a) {
                    a.mo26731a(dVar.mo26694V());
                }
                C5125f.this.m21221g();
            }
        });
    }

    /* renamed from: f */
    private void m21220f() {
        try {
            if (System.currentTimeMillis() - C5237f.m21587d(this.f16737b) > 28800000) {
                String a = C5238g.m21604a(this.f16737b);
                StringBuilder sb = new StringBuilder();
                sb.append("ky ");
                sb.append(a);
                C5205o.m21462a(sb.toString());
                m21217a(this.f16737b);
                return;
            }
            C5205o.m21462a("ss rq in 8");
            m21221g();
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m21221g() {
        C5127a aVar = this.f16740e;
        if (aVar != null) {
            aVar.mo26730a();
            this.f16740e = null;
        }
    }

    /* renamed from: a */
    public void mo26724a(Context context, C5127a aVar) {
        if (this.f16736a == null) {
            this.f16736a = new HashSet();
        }
        this.f16740e = aVar;
        this.f16737b = context.getApplicationContext();
        C5139c.m21256a().mo26746a((C5141a) this);
        m21220f();
    }

    /* renamed from: b */
    public void mo26725b() {
        m21220f();
    }

    /* renamed from: c */
    public String mo26726c() {
        try {
            return C5237f.m21583c(this.f16737b);
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return "";
        }
    }

    /* renamed from: d */
    public C5123d mo26727d() {
        if (this.f16738c == null) {
            this.f16738c = new C5123d(mo26726c());
        }
        return this.f16738c;
    }

    /* renamed from: e */
    public C5030k mo26728e() {
        if (this.f16739d == null) {
            this.f16739d = new C5030k(mo26726c());
        }
        return this.f16739d;
    }
}
