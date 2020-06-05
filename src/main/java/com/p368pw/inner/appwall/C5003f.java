package com.p368pw.inner.appwall;

import android.text.TextUtils;
import com.p368pw.inner.C5233e;
import com.p368pw.inner.base.p387d.C5204n;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.C5206p;

/* renamed from: com.pw.inner.appwall.f */
public class C5003f {
    /* renamed from: a */
    private static volatile C5003f f16285a;
    /* renamed from: b */
    private C4969a f16286b;

    private C5003f() {
    }

    /* renamed from: a */
    public static C5003f m20937a() {
        if (f16285a == null) {
            synchronized (C5003f.class) {
                if (f16285a == null) {
                    f16285a = new C5003f();
                }
            }
        }
        return f16285a;
    }

    /* renamed from: d */
    private void m20938d() {
        C4969a aVar = this.f16286b;
        if (aVar != null && aVar.f16162d) {
            this.f16286b.f16163e = true;
        }
    }

    /* renamed from: e */
    private boolean m20939e() {
        C4969a aVar = this.f16286b;
        return aVar != null && aVar.f16161c && this.f16286b.f16162d && this.f16286b.f16163e && System.currentTimeMillis() - this.f16286b.f16164f >= 3000;
    }

    /* renamed from: f */
    private void m20940f() {
        try {
            C5206p.m21471a(C5233e.m21559b(), "local_aw_bean", C5204n.m21460a(this.f16286b));
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: g */
    private C4969a m20941g() {
        try {
            String b = C5206p.m21472b(C5233e.m21559b(), "local_aw_bean");
            if (!TextUtils.isEmpty(b)) {
                return (C4969a) C5204n.m21459a(b, C4969a.class);
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
        return null;
    }

    /* renamed from: h */
    private void m20942h() {
        C5206p.m21473c(C5233e.m21559b(), "local_aw_bean");
    }

    /* renamed from: a */
    public void mo26392a(C5034m mVar, int i) {
        this.f16286b = new C4969a();
        C4969a aVar = this.f16286b;
        aVar.f16159a = mVar;
        aVar.f16160b = i;
        aVar.f16161c = true;
        aVar.f16162d = false;
        aVar.f16163e = false;
    }

    /* renamed from: b */
    public void mo26393b() {
        C4969a aVar = this.f16286b;
        if (aVar != null && aVar.f16161c) {
            C4969a aVar2 = this.f16286b;
            aVar2.f16162d = true;
            aVar2.f16164f = System.currentTimeMillis();
            m20940f();
        }
    }

    /* renamed from: c */
    public void mo26394c() {
        if (this.f16286b == null) {
            this.f16286b = m20941g();
        }
        m20942h();
        if (this.f16286b != null) {
            m20938d();
            if (m20939e()) {
                C5205o.m21462a("aw fill active");
                C4970aa.m20784a().mo26319a(this.f16286b.f16159a, this.f16286b.f16160b);
            } else {
                C5205o.m21462a("aw active fail");
                if (this.f16286b.f16161c) {
                    this.f16286b.f16161c = false;
                }
            }
            this.f16286b = null;
        }
    }
}
