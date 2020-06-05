package okhttp3;

import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.C8417c;
import okhttp3.internal.connection.C8430c;
import okhttp3.internal.connection.C8431d;
import okhttp3.internal.connection.C8434f;
import okhttp3.internal.connection.C8434f.C8435a;
import okhttp3.internal.p701e.C8447f;

/* compiled from: ConnectionPool */
/* renamed from: okhttp3.j */
public final class C8488j {
    /* renamed from: c */
    static final /* synthetic */ boolean f28828c = (!C8488j.class.desiredAssertionStatus());
    /* renamed from: d */
    private static final Executor f28829d;
    /* renamed from: a */
    final C8431d f28830a;
    /* renamed from: b */
    boolean f28831b;
    /* renamed from: e */
    private final int f28832e;
    /* renamed from: f */
    private final long f28833f;
    /* renamed from: g */
    private final Runnable f28834g;
    /* renamed from: h */
    private final Deque<C8430c> f28835h;

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 60, TimeUnit.SECONDS, new SynchronousQueue(), C8417c.m36037a("OkHttp ConnectionPool", true));
        f28829d = threadPoolExecutor;
    }

    public C8488j() {
        this(5, 5, TimeUnit.MINUTES);
    }

    public C8488j(int i, long j, TimeUnit timeUnit) {
        this.f28834g = new Runnable() {
            /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
            /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x002b */
            public void run() {
                /*
                r6 = this;
            L_0x0000:
                okhttp3.j r0 = okhttp3.C8488j.this
                long r1 = java.lang.System.nanoTime()
                long r0 = r0.mo40460a(r1)
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
                okhttp3.j r2 = okhttp3.C8488j.this
                monitor-enter(r2)
                okhttp3.j r3 = okhttp3.C8488j.this     // Catch:{ InterruptedException -> 0x002b }
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
                throw new UnsupportedOperationException("Method not decompiled: okhttp3.C8488j.C84891.run():void");
            }
        };
        this.f28835h = new ArrayDeque();
        this.f28830a = new C8431d();
        this.f28832e = i;
        this.f28833f = timeUnit.toNanos(j);
        if (j <= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("keepAliveDuration <= 0: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    @Nullable
    /* renamed from: a */
    public C8430c mo40462a(C8357a aVar, C8434f fVar, C8367ad adVar) {
        if (f28828c || Thread.holdsLock(this)) {
            for (C8430c cVar : this.f28835h) {
                if (cVar.mo40282a(aVar, adVar)) {
                    fVar.mo40303a(cVar, true);
                    return cVar;
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: 0000 */
    @Nullable
    /* renamed from: a */
    public Socket mo40461a(C8357a aVar, C8434f fVar) {
        if (f28828c || Thread.holdsLock(this)) {
            for (C8430c cVar : this.f28835h) {
                if (cVar.mo40282a(aVar, null) && cVar.mo40288e() && cVar != fVar.mo40306c()) {
                    return fVar.mo40299a(cVar);
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo40463a(C8430c cVar) {
        if (f28828c || Thread.holdsLock(this)) {
            if (!this.f28831b) {
                this.f28831b = true;
                f28829d.execute(this.f28834g);
            }
            this.f28835h.add(cVar);
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo40464b(C8430c cVar) {
        if (!f28828c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (cVar.f28579a || this.f28832e == 0) {
            this.f28835h.remove(cVar);
            return true;
        } else {
            notifyAll();
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public long mo40460a(long j) {
        synchronized (this) {
            long j2 = Long.MIN_VALUE;
            C8430c cVar = null;
            int i = 0;
            int i2 = 0;
            for (C8430c cVar2 : this.f28835h) {
                if (m36429a(cVar2, j) > 0) {
                    i2++;
                } else {
                    i++;
                    long j3 = j - cVar2.f28583e;
                    if (j3 > j2) {
                        cVar = cVar2;
                        j2 = j3;
                    }
                }
            }
            if (j2 < this.f28833f) {
                if (i <= this.f28832e) {
                    if (i > 0) {
                        long j4 = this.f28833f - j2;
                        return j4;
                    } else if (i2 > 0) {
                        long j5 = this.f28833f;
                        return j5;
                    } else {
                        this.f28831b = false;
                        return -1;
                    }
                }
            }
            this.f28835h.remove(cVar);
            C8417c.m36042a(cVar.mo40286c());
            return 0;
        }
    }

    /* renamed from: a */
    private int m36429a(C8430c cVar, long j) {
        List<Reference<C8434f>> list = cVar.f28582d;
        int i = 0;
        while (i < list.size()) {
            Reference reference = (Reference) list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                C8435a aVar = (C8435a) reference;
                StringBuilder sb = new StringBuilder();
                sb.append("A connection to ");
                sb.append(cVar.mo40277a().mo40130a().mo40068a());
                sb.append(" was leaked. Did you forget to close a response body?");
                C8447f.m36198c().mo40324a(sb.toString(), aVar.f28619a);
                list.remove(i);
                cVar.f28579a = true;
                if (list.isEmpty()) {
                    cVar.f28583e = j - this.f28833f;
                    return 0;
                }
            }
        }
        return list.size();
    }
}
