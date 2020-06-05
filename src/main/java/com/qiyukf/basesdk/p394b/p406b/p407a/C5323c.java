package com.qiyukf.basesdk.p394b.p406b.p407a;

import com.qiyukf.basesdk.p394b.p406b.p409c.C5352f;
import com.qiyukf.basesdk.p394b.p406b.p411e.C5360a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.qiyukf.basesdk.b.b.a.c */
public final class C5323c {
    /* renamed from: a */
    private static final C5326a f17228a = new C5326a("SUCCESS");
    /* renamed from: b */
    private static final C5326a f17229b = new C5326a("CANCELED");
    /* renamed from: c */
    private List<C5329f> f17230c;
    /* renamed from: d */
    private C5352f f17231d;
    /* renamed from: e */
    private C5321a f17232e;
    /* renamed from: f */
    private Object f17233f;
    /* renamed from: g */
    private Throwable f17234g;

    /* renamed from: com.qiyukf.basesdk.b.b.a.c$a */
    private static final class C5326a {
        /* renamed from: a */
        String f17238a;

        C5326a(String str) {
            this.f17238a = str;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("ChannelFutureResult ");
            sb.append(this.f17238a);
            return sb.toString();
        }
    }

    public C5323c(C5321a aVar) {
        this.f17232e = aVar;
        this.f17231d = aVar.mo27226a().mo27262d();
    }

    /* renamed from: f */
    private void m21873f() {
        if (this.f17231d.mo27299h()) {
            m21874g();
        } else {
            C5360a.m22012a(this.f17231d, new Runnable() {
                public final void run() {
                    C5323c.this.m21874g();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m21874g() {
        List<C5329f> list = this.f17230c;
        if (list != null) {
            for (C5329f a : list) {
                a.mo27253a(this);
            }
        }
    }

    /* renamed from: a */
    public final C5321a mo27234a() {
        return this.f17232e;
    }

    /* renamed from: a */
    public final void mo27235a(final C5329f fVar) {
        if (this.f17230c == null) {
            this.f17230c = new ArrayList();
        }
        if (!this.f17230c.contains(fVar)) {
            this.f17230c.add(fVar);
            if (mo27239c()) {
                if (this.f17231d.mo27299h()) {
                    fVar.mo27253a(this);
                    return;
                }
                C5360a.m22012a(this.f17231d, new Runnable() {
                    public final void run() {
                        fVar.mo27253a(C5323c.this);
                    }
                });
            }
        }
    }

    /* renamed from: a */
    public final void mo27236a(Throwable th) {
        this.f17234g = th;
        m21873f();
    }

    /* renamed from: b */
    public final void mo27237b() {
        this.f17233f = f17228a;
        this.f17234g = null;
        m21873f();
    }

    /* renamed from: b */
    public final void mo27238b(C5329f fVar) {
        List<C5329f> list = this.f17230c;
        if (list != null) {
            list.remove(fVar);
        }
    }

    /* renamed from: c */
    public final boolean mo27239c() {
        return (this.f17233f == null && this.f17234g == null) ? false : true;
    }

    /* renamed from: d */
    public final boolean mo27240d() {
        return this.f17234g == null && this.f17233f != f17229b;
    }

    /* renamed from: e */
    public final boolean mo27241e() {
        if (mo27239c()) {
            return false;
        }
        synchronized (this) {
            if (mo27239c()) {
                return false;
            }
            this.f17233f = f17229b;
            m21873f();
            return true;
        }
    }
}
