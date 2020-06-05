package com.p368pw.inner.base;

import com.p368pw.inner.base.p386c.C5143a;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.C5208r;

/* renamed from: com.pw.inner.base.a */
public abstract class C5114a<T> {
    /* renamed from: a */
    private boolean f16657a = false;
    /* renamed from: b */
    private C5117a f16658b = null;

    /* renamed from: com.pw.inner.base.a$a */
    public interface C5117a<T> {
        /* renamed from: a */
        void mo26344a(T t);
    }

    /* renamed from: com.pw.inner.base.a$b */
    public static abstract class C5118b extends C5114a<String> {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String mo25765b(String str) {
            return str;
        }
    }

    /* renamed from: a */
    public abstract String mo25762a();

    /* renamed from: a */
    public void mo26658a(final C5117a<T> aVar) {
        this.f16657a = true;
        this.f16658b = aVar;
        C5208r.m21482b(new Runnable() {
            public void run() {
                final Object b = C5114a.this.mo26659b();
                if (aVar != null) {
                    C5208r.m21479a(new Runnable() {
                        public void run() {
                            try {
                                aVar.mo26344a(b);
                            } catch (Throwable th) {
                                C5205o.m21464a(th);
                            }
                        }
                    });
                }
            }
        });
    }

    /* renamed from: b */
    public T mo26659b() {
        if (!C5208r.m21481a()) {
            String a = mo25762a();
            if (this.f16657a && this.f16658b == null) {
                return null;
            }
            try {
                return mo25765b(a);
            } catch (Throwable th) {
                C5205o.m21462a("解析数据异常");
                C5205o.m21464a(th);
                return null;
            }
        } else {
            C5205o.m21461a();
            throw new C5143a(2, "can't run task on main thread.");
        }
    }

    /* renamed from: b */
    public abstract T mo25765b(String str);

    /* renamed from: c */
    public void mo26660c() {
        mo26658a(null);
    }
}
