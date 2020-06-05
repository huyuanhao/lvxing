package com.qiyukf.nimlib.p469e;

import android.os.Handler;
import android.util.SparseArray;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p412c.C5361a;

/* renamed from: com.qiyukf.nimlib.e.a */
public final class C5805a {
    /* renamed from: e */
    private static C5805a f18461e;
    /* renamed from: a */
    private final SparseArray<C5824k> f18462a = new SparseArray<>();
    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final C5809c f18463b = new C5809c(this.f18465d);
    /* renamed from: c */
    private final C5821j f18464c = new C5821j();
    /* renamed from: d */
    private final Handler f18465d = C5361a.m22014b();

    private C5805a() {
    }

    /* renamed from: a */
    public static Object m23310a(C5817i iVar) {
        m23313b();
        return f18461e.m23316d(iVar);
    }

    /* renamed from: a */
    public static void m23311a() {
        f18461e = new C5805a();
    }

    /* renamed from: a */
    public static void m23312a(String str, Object obj) {
        m23313b();
        final C5817i iVar = new C5817i();
        iVar.f18480a.f18486a = str;
        iVar.mo28114a(new Object[]{obj});
        C5805a aVar = f18461e;
        StringBuilder sb = new StringBuilder("on notify: ");
        sb.append(iVar);
        C5264a.m21617a("InvocationMgr", sb.toString());
        aVar.f18465d.post(new Runnable() {
            public final void run() {
                C5805a.this.f18463b.mo28105b(iVar);
            }
        });
    }

    /* renamed from: b */
    private static void m23313b() {
        if (f18461e == null) {
            throw new IllegalStateException("SDK not inited!");
        }
    }

    /* renamed from: b */
    public static boolean m23314b(C5817i iVar) {
        m23313b();
        return f18461e.m23317e(iVar);
    }

    /* renamed from: c */
    public static void m23315c(C5817i iVar) {
        final C5824k kVar;
        m23313b();
        C5805a aVar = f18461e;
        StringBuilder sb = new StringBuilder("execution result: ");
        sb.append(iVar);
        C5264a.m21617a("InvocationMgr", sb.toString());
        synchronized (aVar.f18462a) {
            kVar = (C5824k) aVar.f18462a.get(iVar.mo28119c());
            aVar.f18462a.remove(iVar.mo28119c());
        }
        if (kVar != null) {
            kVar.mo28131a(iVar.f18481b.f18488a, iVar.f18481b.f18489b);
            aVar.f18464c.mo28127d(iVar);
            aVar.f18465d.post(new Runnable() {
                public final void run() {
                    kVar.mo28130a();
                }
            });
        }
    }

    /* renamed from: d */
    private Object m23316d(C5817i iVar) {
        C5824k kVar;
        if (this.f18463b.mo28104a(iVar)) {
            return null;
        }
        if (iVar.mo28120d()) {
            return this.f18464c.mo28124a(iVar);
        }
        synchronized (this.f18462a) {
            kVar = new C5824k(iVar);
            this.f18462a.put(iVar.mo28119c(), kVar);
            this.f18464c.mo28125b(iVar);
        }
        return kVar;
    }

    /* renamed from: e */
    private boolean m23317e(C5817i iVar) {
        synchronized (this.f18462a) {
            if (this.f18462a.get(iVar.mo28119c()) == null) {
                return false;
            }
            this.f18462a.remove(iVar.mo28119c());
            try {
                this.f18464c.mo28126c(iVar);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
    }
}
