package com.qiyukf.nimlib.p469e;

import android.os.Handler;
import android.util.SparseArray;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p412c.C5361a;
import com.qiyukf.nimlib.p429a.p448e.C5705a;
import com.qiyukf.nimlib.p429a.p448e.C5707b;
import com.qiyukf.nimlib.p429a.p448e.C5712c;
import com.qiyukf.nimlib.sdk.AbortableFuture;
import com.qiyukf.nimlib.sdk.auth.AuthService;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.qiyukf.nimlib.sdk.msg.SystemMessageService;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.qiyukf.nimlib.e.j */
public final class C5821j {
    /* renamed from: a */
    private final Map<String, C5823a> f18490a = new HashMap();
    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final SparseArray<C5814f> f18491b = new SparseArray<>();
    /* renamed from: c */
    private final Handler f18492c = C5361a.m22013a().mo27316a("bg_executor");

    /* renamed from: com.qiyukf.nimlib.e.j$a */
    private static class C5823a {
        /* renamed from: a */
        private final Map<String, Method> f18495a = new HashMap();
        /* renamed from: b */
        private C5816h f18496b;

        public C5823a(Class<?> cls, Class<? extends C5816h> cls2) {
            Method[] declaredMethods;
            for (Method method : cls.getDeclaredMethods()) {
                this.f18495a.put(method.getName(), method);
            }
            try {
                this.f18496b = (C5816h) cls2.newInstance();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        /* renamed from: a */
        public final Object mo28129a(C5817i iVar) {
            return ((Method) this.f18495a.get(iVar.mo28115a())).invoke(this.f18496b, iVar.f18480a.f18487b);
        }
    }

    public C5821j() {
        m23346a(AuthService.class, C5705a.class);
        m23346a(MsgService.class, C5707b.class);
        m23346a(SystemMessageService.class, C5712c.class);
    }

    /* renamed from: a */
    private void m23346a(Class<?> cls, Class<? extends C5816h> cls2) {
        this.f18490a.put(cls.getSimpleName(), new C5823a(cls, cls2));
    }

    /* renamed from: a */
    public final Object mo28124a(C5817i iVar) {
        String str = "execute ";
        String str2 = "TransEx";
        C5823a aVar = (C5823a) this.f18490a.get(iVar.f18480a.f18486a.substring(0, iVar.f18480a.f18486a.indexOf(47)));
        if (aVar == null) {
            return null;
        }
        C5816h.m23332a(iVar);
        try {
            r7 = iVar;
            StringBuilder sb = new StringBuilder(str);
            sb.append(iVar);
            C5264a.m21617a(str2, sb.toString());
            r7 = aVar.mo28129a(iVar);
            r7 = r7;
            return r7;
        } catch (Throwable th) {
            th = th;
            if ((th instanceof InvocationTargetException) && th.getCause() != null) {
                th = th.getCause();
            }
            StringBuilder sb2 = new StringBuilder(str);
            sb2.append(r7);
            sb2.append(" exception");
            C5264a.m21619a(str2, sb2.toString(), th);
            r7.f18481b.f18488a = 1000;
            r7.f18481b.f18489b = th;
            C5805a.m23315c(r7);
            return null;
        } finally {
            C5816h.m23331a();
        }
    }

    /* renamed from: b */
    public final void mo28125b(final C5817i iVar) {
        this.f18492c.post(new Runnable() {
            public final void run() {
                Object a = C5821j.this.mo28124a(iVar);
                if (a instanceof C5814f) {
                    synchronized (C5821j.this.f18491b) {
                        C5821j.this.f18491b.put(iVar.mo28119c(), (C5814f) a);
                    }
                }
            }
        });
    }

    /* renamed from: c */
    public final void mo28126c(C5817i iVar) {
        AbortableFuture abortableFuture;
        StringBuilder sb = new StringBuilder("abort ");
        sb.append(iVar);
        C5264a.m21617a("TransEx", sb.toString());
        synchronized (this.f18491b) {
            abortableFuture = (AbortableFuture) this.f18491b.get(iVar.mo28119c());
            this.f18491b.remove(iVar.mo28119c());
        }
        if (abortableFuture != null) {
            abortableFuture.abort();
        }
    }

    /* renamed from: d */
    public final void mo28127d(C5817i iVar) {
        synchronized (this.f18491b) {
            this.f18491b.remove(iVar.mo28119c());
        }
    }
}
