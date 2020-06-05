package com.kwad.sdk.core.videocache;

import com.kwad.sdk.core.p319c.C4065b;
import java.lang.Thread.State;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.kwad.sdk.core.videocache.k */
class C4363k {
    /* renamed from: a */
    private final C4367m f14299a;
    /* renamed from: b */
    private final C4332a f14300b;
    /* renamed from: c */
    private final Object f14301c = new Object();
    /* renamed from: d */
    private final Object f14302d = new Object();
    /* renamed from: e */
    private final AtomicInteger f14303e;
    /* renamed from: f */
    private volatile Thread f14304f;
    /* renamed from: g */
    private volatile boolean f14305g;
    /* renamed from: h */
    private volatile int f14306h = -1;

    /* renamed from: com.kwad.sdk.core.videocache.k$a */
    private class C4365a implements Runnable {
        private C4365a() {
        }

        public void run() {
            C4363k.this.m17814e();
        }
    }

    public C4363k(C4367m mVar, C4332a aVar) {
        this.f14299a = (C4367m) C4362j.m17805a(mVar);
        this.f14300b = (C4332a) C4362j.m17805a(aVar);
        this.f14303e = new AtomicInteger();
    }

    /* renamed from: b */
    private void m17810b() {
        int i = this.f14303e.get();
        if (i >= 1) {
            this.f14303e.set(0);
            StringBuilder sb = new StringBuilder();
            sb.append("Error reading source ");
            sb.append(i);
            sb.append(" times");
            throw new ProxyCacheException(sb.toString());
        }
    }

    /* renamed from: b */
    private void m17811b(long j, long j2) {
        mo24527a(j, j2);
        synchronized (this.f14301c) {
            this.f14301c.notifyAll();
        }
    }

    /* renamed from: c */
    private synchronized void m17812c() {
        boolean z = (this.f14304f == null || this.f14304f.getState() == State.TERMINATED) ? false : true;
        if (!this.f14305g && !this.f14300b.mo24487d() && !z) {
            C4365a aVar = new C4365a();
            StringBuilder sb = new StringBuilder();
            sb.append("Source reader for ");
            sb.append(this.f14299a);
            this.f14304f = new Thread(aVar, sb.toString());
            this.f14304f.start();
        }
    }

    /* renamed from: d */
    private void m17813d() {
        synchronized (this.f14301c) {
            try {
                this.f14301c.wait(1000);
            } catch (InterruptedException e) {
                throw new ProxyCacheException("Waiting source data is interrupted!", e);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0039, code lost:
            r2 = r2 + ((long) r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            m17811b(r2, r0);
     */
    /* renamed from: e */
    public void m17814e() {
        /*
        r8 = this;
        r0 = -1
        r2 = 0
        com.kwad.sdk.core.videocache.a r4 = r8.f14300b     // Catch:{ all -> 0x0049 }
        long r2 = r4.mo24483a()     // Catch:{ all -> 0x0049 }
        com.kwad.sdk.core.videocache.m r4 = r8.f14299a     // Catch:{ all -> 0x0049 }
        r4.mo24518a(r2)     // Catch:{ all -> 0x0049 }
        com.kwad.sdk.core.videocache.m r4 = r8.f14299a     // Catch:{ all -> 0x0049 }
        long r0 = r4.mo24517a()     // Catch:{ all -> 0x0049 }
        r4 = 8192(0x2000, float:1.14794E-41)
        byte[] r4 = new byte[r4]     // Catch:{ all -> 0x0049 }
    L_0x0019:
        com.kwad.sdk.core.videocache.m r5 = r8.f14299a     // Catch:{ all -> 0x0049 }
        int r5 = r5.mo24516a(r4)     // Catch:{ all -> 0x0049 }
        r6 = -1
        if (r5 == r6) goto L_0x0042
        java.lang.Object r6 = r8.f14302d     // Catch:{ all -> 0x0049 }
        monitor-enter(r6)     // Catch:{ all -> 0x0049 }
        boolean r7 = r8.m17817h()     // Catch:{ all -> 0x003f }
        if (r7 == 0) goto L_0x0033
        monitor-exit(r6)     // Catch:{ all -> 0x003f }
        r8.m17818i()
        r8.m17811b(r2, r0)
        return
    L_0x0033:
        com.kwad.sdk.core.videocache.a r7 = r8.f14300b     // Catch:{ all -> 0x003f }
        r7.mo24484a(r4, r5)     // Catch:{ all -> 0x003f }
        monitor-exit(r6)     // Catch:{ all -> 0x003f }
        long r5 = (long) r5
        long r2 = r2 + r5
        r8.m17811b(r2, r0)     // Catch:{ all -> 0x0049 }
        goto L_0x0019
    L_0x003f:
        r4 = move-exception
        monitor-exit(r6)     // Catch:{ all -> 0x003f }
        throw r4     // Catch:{ all -> 0x0049 }
    L_0x0042:
        r8.m17816g()     // Catch:{ all -> 0x0049 }
        r8.m17815f()     // Catch:{ all -> 0x0049 }
        goto L_0x0052
    L_0x0049:
        r4 = move-exception
        java.util.concurrent.atomic.AtomicInteger r5 = r8.f14303e     // Catch:{ all -> 0x0059 }
        r5.incrementAndGet()     // Catch:{ all -> 0x0059 }
        r8.mo24528a(r4)     // Catch:{ all -> 0x0059 }
    L_0x0052:
        r8.m17818i()
        r8.m17811b(r2, r0)
        return
    L_0x0059:
        r4 = move-exception
        r8.m17818i()
        r8.m17811b(r2, r0)
        throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.videocache.C4363k.m17814e():void");
    }

    /* renamed from: f */
    private void m17815f() {
        this.f14306h = 100;
        mo24503a(this.f14306h);
    }

    /* renamed from: g */
    private void m17816g() {
        synchronized (this.f14302d) {
            if (!m17817h() && this.f14300b.mo24483a() == this.f14299a.mo24517a()) {
                this.f14300b.mo24486c();
            }
        }
    }

    /* renamed from: h */
    private boolean m17817h() {
        return Thread.currentThread().isInterrupted() || this.f14305g;
    }

    /* renamed from: i */
    private void m17818i() {
        try {
            this.f14299a.mo24519b();
        } catch (ProxyCacheException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error closing source ");
            sb.append(this.f14299a);
            mo24528a((Throwable) new ProxyCacheException(sb.toString(), e));
        }
    }

    /* renamed from: a */
    public int mo24525a(byte[] bArr, long j, int i) {
        C4366l.m17827a(bArr, j, i);
        while (!this.f14300b.mo24487d() && this.f14300b.mo24483a() < ((long) i) + j && !this.f14305g) {
            m17812c();
            m17813d();
            m17810b();
        }
        int a = this.f14300b.mo24482a(bArr, j, i);
        if (this.f14300b.mo24487d() && this.f14306h != 100) {
            this.f14306h = 100;
            mo24503a(100);
        }
        return a;
    }

    /* renamed from: a */
    public void mo24526a() {
        synchronized (this.f14302d) {
            String str = "ProxyCache";
            StringBuilder sb = new StringBuilder();
            sb.append("Shutdown proxy for ");
            sb.append(this.f14299a);
            C4065b.m16863a(str, sb.toString());
            try {
                this.f14305g = true;
                if (this.f14304f != null) {
                    this.f14304f.interrupt();
                }
                this.f14300b.mo24485b();
            } catch (ProxyCacheException e) {
                mo24528a((Throwable) e);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo24503a(int i) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo24527a(long j, long j2) {
        boolean z = true;
        int i = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        int i2 = i == 0 ? 100 : (int) ((((float) j) / ((float) j2)) * 100.0f);
        boolean z2 = i2 != this.f14306h;
        if (i < 0) {
            z = false;
        }
        if (z && z2) {
            mo24503a(i2);
        }
        this.f14306h = i2;
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo24528a(Throwable th) {
        String str = "ProxyCache";
        if (th instanceof InterruptedProxyCacheException) {
            C4065b.m16863a(str, "ProxyCache is interrupted");
        } else {
            C4065b.m16869d(str, "ProxyCache error");
        }
    }
}
