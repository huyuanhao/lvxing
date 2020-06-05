package com.bytedance.sdk.adnet.core;

import android.os.Process;
import com.bytedance.sdk.adnet.p162e.ICache;
import com.bytedance.sdk.adnet.p162e.ICache.C1994a;
import com.bytedance.sdk.adnet.p162e.IResponseDelivery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* renamed from: com.bytedance.sdk.adnet.core.f */
class CacheDispatcher extends Thread {
    /* renamed from: a */
    private static final boolean f6229a = VNetLog.f6301a;
    /* renamed from: b */
    private final BlockingQueue<Request<?>> f6230b;
    /* access modifiers changed from: private|final */
    /* renamed from: c */
    public final BlockingQueue<Request<?>> f6231c;
    /* renamed from: d */
    private final ICache f6232d;
    /* access modifiers changed from: private|final */
    /* renamed from: e */
    public final IResponseDelivery f6233e;
    /* renamed from: f */
    private volatile boolean f6234f = false;
    /* renamed from: g */
    private final C1972a f6235g;

    /* compiled from: CacheDispatcher */
    /* renamed from: com.bytedance.sdk.adnet.core.f$a */
    private static class C1972a implements C1967a {
        /* renamed from: a */
        private final Map<String, List<Request<?>>> f6238a = new HashMap();
        /* renamed from: b */
        private final CacheDispatcher f6239b;

        C1972a(CacheDispatcher fVar) {
            this.f6239b = fVar;
        }

        /* renamed from: a */
        public void mo14305a(Request<?> request, C1982p<?> pVar) {
            List<Request> list;
            if (pVar.f6294b == null || pVar.f6294b.mo14400a()) {
                mo14304a(request);
                return;
            }
            String cacheKey = request.getCacheKey();
            synchronized (this) {
                list = (List) this.f6238a.remove(cacheKey);
            }
            if (list != null) {
                if (VNetLog.f6301a) {
                    VNetLog.m7926a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(list.size()), cacheKey);
                }
                for (Request a : list) {
                    this.f6239b.f6233e.mo14347a(a, pVar);
                }
            }
        }

        /* renamed from: a */
        public synchronized void mo14304a(Request<?> request) {
            String cacheKey = request.getCacheKey();
            List list = (List) this.f6238a.remove(cacheKey);
            if (list != null && !list.isEmpty()) {
                if (VNetLog.f6301a) {
                    VNetLog.m7926a("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(list.size()), cacheKey);
                }
                Request request2 = (Request) list.remove(0);
                this.f6238a.put(cacheKey, list);
                request2.mo14254a((C1967a) this);
                try {
                    this.f6239b.f6231c.put(request2);
                } catch (InterruptedException e) {
                    VNetLog.m7929c("Couldn't add request to queue. %s", e.toString());
                    Thread.currentThread().interrupt();
                    this.f6239b.mo14325a();
                }
            }
            return;
        }

        /* access modifiers changed from: private|declared_synchronized */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0039, code lost:
            return true;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0051, code lost:
            return false;
     */
        /* renamed from: b */
        public synchronized boolean m7834b(com.bytedance.sdk.adnet.core.Request<?> r6) {
            /*
            r5 = this;
            monitor-enter(r5)
            java.lang.String r0 = r6.getCacheKey()     // Catch:{ all -> 0x0052 }
            java.util.Map<java.lang.String, java.util.List<com.bytedance.sdk.adnet.core.Request<?>>> r1 = r5.f6238a     // Catch:{ all -> 0x0052 }
            boolean r1 = r1.containsKey(r0)     // Catch:{ all -> 0x0052 }
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x003a
            java.util.Map<java.lang.String, java.util.List<com.bytedance.sdk.adnet.core.Request<?>>> r1 = r5.f6238a     // Catch:{ all -> 0x0052 }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x0052 }
            java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x0052 }
            if (r1 != 0) goto L_0x001e
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0052 }
            r1.<init>()     // Catch:{ all -> 0x0052 }
        L_0x001e:
            java.lang.String r4 = "waiting-for-response"
            r6.addMarker(r4)     // Catch:{ all -> 0x0052 }
            r1.add(r6)     // Catch:{ all -> 0x0052 }
            java.util.Map<java.lang.String, java.util.List<com.bytedance.sdk.adnet.core.Request<?>>> r6 = r5.f6238a     // Catch:{ all -> 0x0052 }
            r6.put(r0, r1)     // Catch:{ all -> 0x0052 }
            boolean r6 = com.bytedance.sdk.adnet.core.VNetLog.f6301a     // Catch:{ all -> 0x0052 }
            if (r6 == 0) goto L_0x0038
            java.lang.String r6 = "Request for cacheKey=%s is in flight, putting on hold."
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ all -> 0x0052 }
            r1[r3] = r0     // Catch:{ all -> 0x0052 }
            com.bytedance.sdk.adnet.core.VNetLog.m7928b(r6, r1)     // Catch:{ all -> 0x0052 }
        L_0x0038:
            monitor-exit(r5)
            return r2
        L_0x003a:
            java.util.Map<java.lang.String, java.util.List<com.bytedance.sdk.adnet.core.Request<?>>> r1 = r5.f6238a     // Catch:{ all -> 0x0052 }
            r4 = 0
            r1.put(r0, r4)     // Catch:{ all -> 0x0052 }
            r6.mo14254a(r5)     // Catch:{ all -> 0x0052 }
            boolean r6 = com.bytedance.sdk.adnet.core.VNetLog.f6301a     // Catch:{ all -> 0x0052 }
            if (r6 == 0) goto L_0x0050
            java.lang.String r6 = "new request, sending to network %s"
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ all -> 0x0052 }
            r1[r3] = r0     // Catch:{ all -> 0x0052 }
            com.bytedance.sdk.adnet.core.VNetLog.m7928b(r6, r1)     // Catch:{ all -> 0x0052 }
        L_0x0050:
            monitor-exit(r5)
            return r3
        L_0x0052:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.adnet.core.CacheDispatcher.C1972a.m7834b(com.bytedance.sdk.adnet.core.Request):boolean");
        }
    }

    public CacheDispatcher(BlockingQueue<Request<?>> blockingQueue, BlockingQueue<Request<?>> blockingQueue2, ICache bVar, IResponseDelivery dVar) {
        this.f6230b = blockingQueue;
        this.f6231c = blockingQueue2;
        this.f6232d = bVar;
        this.f6233e = dVar;
        this.f6235g = new C1972a(this);
    }

    /* renamed from: a */
    public void mo14325a() {
        this.f6234f = true;
        interrupt();
    }

    public void run() {
        if (f6229a) {
            VNetLog.m7926a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f6232d.mo14337a();
        while (true) {
            try {
                m7830b();
            } catch (InterruptedException unused) {
                if (this.f6234f) {
                    Thread.currentThread().interrupt();
                    return;
                } else {
                    VNetLog.m7929c("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
                }
            }
        }
    }

    /* renamed from: b */
    private void m7830b() throws InterruptedException {
        mo14326a((Request) this.f6230b.take());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo14326a(final Request<?> request) throws InterruptedException {
        request.addMarker("cache-queue-take");
        request.mo14253a(1);
        try {
            if (request.isCanceled()) {
                request.mo14255a("cache-discard-canceled");
                request.mo14253a(2);
                return;
            }
            C1994a a = this.f6232d.mo14335a(request.getCacheKey());
            if (a == null) {
                request.addMarker("cache-miss");
                if (!this.f6235g.m7834b(request)) {
                    this.f6231c.put(request);
                }
                request.mo14253a(2);
            } else if (a.mo14400a()) {
                request.addMarker("cache-hit-expired");
                request.setCacheEntry(a);
                if (!this.f6235g.m7834b(request)) {
                    this.f6231c.put(request);
                }
                request.mo14253a(2);
            } else {
                request.addMarker("cache-hit");
                C1982p a2 = request.mo14188a(new NetworkResponse(a.f6325b, a.f6331h));
                request.addMarker("cache-hit-parsed");
                if (!a.mo14401b()) {
                    this.f6233e.mo14347a(request, a2);
                } else {
                    request.addMarker("cache-hit-refresh-needed");
                    request.setCacheEntry(a);
                    a2.f6296d = true;
                    if (!this.f6235g.m7834b(request)) {
                        this.f6233e.mo14348a(request, a2, new Runnable() {
                            public void run() {
                                try {
                                    CacheDispatcher.this.f6231c.put(request);
                                } catch (InterruptedException unused) {
                                    Thread.currentThread().interrupt();
                                }
                            }
                        });
                    } else {
                        this.f6233e.mo14347a(request, a2);
                    }
                }
                request.mo14253a(2);
            }
        } catch (Throwable th) {
            request.mo14253a(2);
            throw th;
        }
    }
}
