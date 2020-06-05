package com.bytedance.sdk.p145a.p147b;

import com.bytedance.sdk.p145a.p147b.p148a.C1876c;
import com.bytedance.sdk.p145a.p147b.p148a.p150b.RealConnection;
import com.bytedance.sdk.p145a.p147b.p148a.p150b.RouteDatabase;
import com.bytedance.sdk.p145a.p147b.p148a.p150b.StreamAllocation;
import com.bytedance.sdk.p145a.p147b.p148a.p150b.StreamAllocation.C1875a;
import com.bytedance.sdk.p145a.p147b.p148a.p155g.Platform;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.bytedance.sdk.a.b.m */
public final class ConnectionPool {
    /* renamed from: c */
    static final /* synthetic */ boolean f5910c = (!ConnectionPool.class.desiredAssertionStatus());
    /* renamed from: d */
    private static final Executor f5911d;
    /* renamed from: a */
    final RouteDatabase f5912a;
    /* renamed from: b */
    boolean f5913b;
    /* renamed from: e */
    private final int f5914e;
    /* renamed from: f */
    private final long f5915f;
    /* renamed from: g */
    private final Runnable f5916g;
    /* renamed from: h */
    private final Deque<RealConnection> f5917h;

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 60, TimeUnit.SECONDS, new SynchronousQueue(), C1876c.m6959a("OkHttp ConnectionPool", true));
        f5911d = threadPoolExecutor;
    }

    public ConnectionPool() {
        this(5, 5, TimeUnit.MINUTES);
    }

    public ConnectionPool(int i, long j, TimeUnit timeUnit) {
        this.f5916g = new Runnable() {
            /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
            /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x002b */
            public void run() {
                /*
                r6 = this;
            L_0x0000:
                com.bytedance.sdk.a.b.m r0 = com.bytedance.sdk.p145a.p147b.ConnectionPool.this
                long r1 = java.lang.System.nanoTime()
                long r0 = r0.mo14009a(r1)
                r2 = -1
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 != 0) goto L_0x0011
                return
            L_0x0011:
                r2 = 0
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 <= 0) goto L_0x0000
                r2 = 1000000(0xf4240, double:4.940656E-318)
                long r4 = r0 / r2
                long r2 = r2 * r4
                long r0 = r0 - r2
                com.bytedance.sdk.a.b.m r2 = com.bytedance.sdk.p145a.p147b.ConnectionPool.this
                monitor-enter(r2)
                com.bytedance.sdk.a.b.m r3 = com.bytedance.sdk.p145a.p147b.ConnectionPool.this     // Catch:{ InterruptedException -> 0x002b }
                int r1 = (int) r0     // Catch:{ InterruptedException -> 0x002b }
                r3.wait(r4, r1)     // Catch:{ InterruptedException -> 0x002b }
                goto L_0x002b
            L_0x0029:
                r0 = move-exception
                goto L_0x002d
            L_0x002b:
                monitor-exit(r2)     // Catch:{ all -> 0x0029 }
                goto L_0x0000
            L_0x002d:
                monitor-exit(r2)     // Catch:{ all -> 0x0029 }
                throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.p145a.p147b.ConnectionPool.C19281.run():void");
            }
        };
        this.f5917h = new ArrayDeque();
        this.f5912a = new RouteDatabase();
        this.f5914e = i;
        this.f5915f = timeUnit.toNanos(j);
        if (j <= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("keepAliveDuration <= 0: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public RealConnection mo14010a(Address aVar, StreamAllocation gVar, Route dVar) {
        if (f5910c || Thread.holdsLock(this)) {
            for (RealConnection cVar : this.f5917h) {
                if (cVar.mo13693a(aVar, dVar)) {
                    gVar.mo13714a(cVar, true);
                    return cVar;
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Socket mo14011a(Address aVar, StreamAllocation gVar) {
        if (f5910c || Thread.holdsLock(this)) {
            for (RealConnection cVar : this.f5917h) {
                if (cVar.mo13693a(aVar, null) && cVar.mo13698d() && cVar != gVar.mo13717b()) {
                    return gVar.mo13713a(cVar);
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo14012a(RealConnection cVar) {
        if (f5910c || Thread.holdsLock(this)) {
            if (!this.f5913b) {
                this.f5913b = true;
                f5911d.execute(this.f5916g);
            }
            this.f5917h.add(cVar);
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo14013b(RealConnection cVar) {
        if (!f5910c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (cVar.f5355a || this.f5914e == 0) {
            this.f5917h.remove(cVar);
            return true;
        } else {
            notifyAll();
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public long mo14009a(long j) {
        synchronized (this) {
            long j2 = Long.MIN_VALUE;
            RealConnection cVar = null;
            int i = 0;
            int i2 = 0;
            for (RealConnection cVar2 : this.f5917h) {
                if (m7452a(cVar2, j) > 0) {
                    i2++;
                } else {
                    i++;
                    long j3 = j - cVar2.f5359e;
                    if (j3 > j2) {
                        cVar = cVar2;
                        j2 = j3;
                    }
                }
            }
            if (j2 < this.f5915f) {
                if (i <= this.f5914e) {
                    if (i > 0) {
                        long j4 = this.f5915f - j2;
                        return j4;
                    } else if (i2 > 0) {
                        long j5 = this.f5915f;
                        return j5;
                    } else {
                        this.f5913b = false;
                        return -1;
                    }
                }
            }
            this.f5917h.remove(cVar);
            C1876c.m6962a(cVar.mo13696b());
            return 0;
        }
    }

    /* renamed from: a */
    private int m7452a(RealConnection cVar, long j) {
        List<Reference<StreamAllocation>> list = cVar.f5358d;
        int i = 0;
        while (i < list.size()) {
            Reference reference = (Reference) list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                C1875a aVar = (C1875a) reference;
                StringBuilder sb = new StringBuilder();
                sb.append("A connection to ");
                sb.append(cVar.mo13689a().mo13969a().mo13639a());
                sb.append(" was leaked. Did you forget to close a response body?");
                Platform.m7295b().mo13873a(sb.toString(), aVar.f5397a);
                list.remove(i);
                cVar.f5355a = true;
                if (list.isEmpty()) {
                    cVar.f5359e = j - this.f5915f;
                    return 0;
                }
            }
        }
        return list.size();
    }
}
