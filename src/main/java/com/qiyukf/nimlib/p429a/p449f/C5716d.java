package com.qiyukf.nimlib.p429a.p449f;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.nimlib.p429a.p431b.C5666f;
import com.qiyukf.nimlib.p429a.p436c.C5669a;
import com.qiyukf.nimlib.p429a.p442d.C5686a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.qiyukf.nimlib.a.f.d */
public final class C5716d implements C5666f {
    /* renamed from: a */
    private final SparseArray<C5717a> f18263a = new SparseArray<>();
    /* renamed from: b */
    private final int f18264b = 0;
    /* renamed from: c */
    private final int f18265c = 1;
    /* renamed from: d */
    private AtomicInteger f18266d = new AtomicInteger(0);
    /* renamed from: e */
    private Handler f18267e = new Handler(Looper.getMainLooper());

    /* renamed from: com.qiyukf.nimlib.a.f.d$a */
    private class C5717a implements Runnable {
        /* renamed from: a */
        C5715c f18268a;

        C5717a(C5715c cVar) {
            this.f18268a = cVar;
        }

        /* renamed from: a */
        public final int mo27966a() {
            return this.f18268a.mo27955b().mo27870a().mo28234i();
        }

        public final void run() {
            C5716d.this.m22995a(this, false);
        }
    }

    /* renamed from: a */
    private C5717a m22994a(int i) {
        C5717a aVar;
        synchronized (this.f18263a) {
            aVar = (C5717a) this.f18263a.get(i);
        }
        return aVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22995a(C5717a aVar, boolean z) {
        if (m22997a("onTimeout")) {
            int a = aVar.mo27966a();
            C5717a a2 = m22994a(a);
            if (a2 != null) {
                if (a2.f18268a.mo27957c()) {
                    a2 = m22998b(a);
                }
                if (a2 != null) {
                    C5715c cVar = a2.f18268a;
                    if (z) {
                        cVar.mo27960f();
                        return;
                    }
                    cVar.mo27959e();
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m22997a(String str) {
        boolean z = true;
        if (this.f18266d.get() != 1) {
            z = false;
        }
        if (!z) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" while not running");
            C5264a.m21617a("TaskMgr", sb.toString());
        }
        return z;
    }

    /* renamed from: b */
    private C5717a m22998b(int i) {
        C5717a aVar;
        synchronized (this.f18263a) {
            aVar = (C5717a) this.f18263a.get(i);
            if (aVar != null) {
                this.f18263a.remove(i);
            }
        }
        if (aVar != null) {
            this.f18267e.removeCallbacks(aVar);
        }
        return aVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0041, code lost:
            return null;
     */
    /* renamed from: d */
    private com.qiyukf.nimlib.p429a.p449f.C5716d.C5717a m22999d(com.qiyukf.nimlib.p429a.p442d.C5686a r5) {
        /*
        r4 = this;
        android.util.SparseArray<com.qiyukf.nimlib.a.f.d$a> r0 = r4.f18263a
        monitor-enter(r0)
        android.util.SparseArray<com.qiyukf.nimlib.a.f.d$a> r1 = r4.f18263a     // Catch:{ all -> 0x0042 }
        com.qiyukf.nimlib.h.c.a r2 = r5.mo27891a()     // Catch:{ all -> 0x0042 }
        short r2 = r2.mo28234i()     // Catch:{ all -> 0x0042 }
        java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x0042 }
        com.qiyukf.nimlib.a.f.d$a r1 = (com.qiyukf.nimlib.p429a.p449f.C5716d.C5717a) r1     // Catch:{ all -> 0x0042 }
        if (r1 == 0) goto L_0x003f
        com.qiyukf.nimlib.a.f.c r2 = r1.f18268a     // Catch:{ all -> 0x0042 }
        if (r2 == 0) goto L_0x003f
        com.qiyukf.nimlib.a.f.c r2 = r1.f18268a     // Catch:{ all -> 0x0042 }
        com.qiyukf.nimlib.a.c.a r2 = r2.mo27955b()     // Catch:{ all -> 0x0042 }
        byte r2 = r2.mo27873c()     // Catch:{ all -> 0x0042 }
        com.qiyukf.nimlib.h.c.a r3 = r5.mo27891a()     // Catch:{ all -> 0x0042 }
        byte r3 = r3.mo28232g()     // Catch:{ all -> 0x0042 }
        if (r2 != r3) goto L_0x003f
        com.qiyukf.nimlib.a.f.c r2 = r1.f18268a     // Catch:{ all -> 0x0042 }
        com.qiyukf.nimlib.a.c.a r2 = r2.mo27955b()     // Catch:{ all -> 0x0042 }
        byte r2 = r2.mo27874d()     // Catch:{ all -> 0x0042 }
        byte r5 = r5.mo27895d()     // Catch:{ all -> 0x0042 }
        if (r2 != r5) goto L_0x003f
        monitor-exit(r0)     // Catch:{ all -> 0x0042 }
        return r1
    L_0x003f:
        monitor-exit(r0)     // Catch:{ all -> 0x0042 }
        r5 = 0
        return r5
    L_0x0042:
        r5 = move-exception
        monitor-exit(r0)     // Catch:{ all -> 0x0042 }
        throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.p429a.p449f.C5716d.m22999d(com.qiyukf.nimlib.a.d.a):com.qiyukf.nimlib.a.f.d$a");
    }

    /* renamed from: d */
    private List<C5717a> m23000d() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f18263a) {
            for (int i = 0; i < this.f18263a.size(); i++) {
                arrayList.add(this.f18263a.valueAt(i));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public final void mo27961a() {
        boolean compareAndSet = this.f18266d.compareAndSet(0, 1);
    }

    /* renamed from: a */
    public final void mo27854a(C5686a aVar) {
        if (m22997a("pre process")) {
            synchronized (this.f18263a) {
                C5717a d = m22999d(aVar);
                if (d != null) {
                    this.f18267e.removeCallbacks(d);
                }
            }
        }
    }

    /* renamed from: a */
    public final boolean mo27962a(C5715c cVar) {
        if (!m22997a("pend task")) {
            return false;
        }
        if (!(cVar.mo27955b() != null)) {
            return false;
        }
        C5717a aVar = new C5717a(cVar);
        synchronized (this.f18263a) {
            this.f18263a.put(aVar.mo27966a(), aVar);
            this.f18267e.postDelayed(aVar, (long) (aVar.f18268a.mo27958d() * 1000));
        }
        return true;
    }

    /* renamed from: b */
    public final void mo27963b() {
        if (this.f18266d.compareAndSet(1, 0)) {
            this.f18263a.clear();
        }
    }

    /* renamed from: b */
    public final void mo27855b(C5686a aVar) {
        if (m22997a("on processed")) {
            C5717a d = m22999d(aVar);
            if (!(d == null || d.f18268a == null)) {
                d.f18268a.mo27887a(aVar);
            }
            m22998b((int) aVar.mo27894c());
        }
    }

    /* renamed from: c */
    public final C5669a mo27964c(C5686a aVar) {
        if (!m22997a("retrieve request")) {
            return null;
        }
        C5717a d = m22999d(aVar);
        if (d == null) {
            return null;
        }
        return d.f18268a.mo27955b();
    }

    /* renamed from: c */
    public final void mo27965c() {
        if (m22997a("onLogin")) {
            for (C5717a a : m23000d()) {
                m22995a(a, true);
            }
        }
    }
}
