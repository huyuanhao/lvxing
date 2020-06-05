package com.bytedance.sdk.p145a.p146a;

import android.support.p000v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* renamed from: com.bytedance.sdk.a.a.a */
public class AsyncTimeout extends Timeout {
    /* renamed from: a */
    static AsyncTimeout f5229a;
    /* renamed from: b */
    private static final long f5230b = TimeUnit.SECONDS.toMillis(60);
    /* renamed from: d */
    private static final long f5231d = TimeUnit.MILLISECONDS.toNanos(f5230b);
    /* renamed from: e */
    private boolean f5232e;
    /* renamed from: f */
    private AsyncTimeout f5233f;
    /* renamed from: g */
    private long f5234g;

    /* compiled from: AsyncTimeout */
    /* renamed from: com.bytedance.sdk.a.a.a$a */
    private static final class C1860a extends Thread {
        C1860a() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r1.mo13505c();
     */
        public void run() {
            /*
            r3 = this;
        L_0x0000:
            java.lang.Class<com.bytedance.sdk.a.a.a> r0 = com.bytedance.sdk.p145a.p146a.AsyncTimeout.class
            monitor-enter(r0)     // Catch:{ InterruptedException -> 0x0000 }
            com.bytedance.sdk.a.a.a r1 = com.bytedance.sdk.p145a.p146a.AsyncTimeout.m6598i_()     // Catch:{ all -> 0x0019 }
            if (r1 != 0) goto L_0x000b
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            goto L_0x0000
        L_0x000b:
            com.bytedance.sdk.a.a.a r2 = com.bytedance.sdk.p145a.p146a.AsyncTimeout.f5229a     // Catch:{ all -> 0x0019 }
            if (r1 != r2) goto L_0x0014
            r1 = 0
            com.bytedance.sdk.p145a.p146a.AsyncTimeout.f5229a = r1     // Catch:{ all -> 0x0019 }
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            return
        L_0x0014:
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            r1.mo13505c()     // Catch:{ InterruptedException -> 0x0000 }
            goto L_0x0000
        L_0x0019:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            throw r1     // Catch:{ InterruptedException -> 0x0000 }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.p145a.p146a.AsyncTimeout.C1860a.run():void");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo13505c() {
    }

    /* renamed from: a */
    public final void mo13501a() {
        if (!this.f5232e) {
            long j_ = mo13615j_();
            boolean k_ = mo13616k_();
            if (j_ != 0 || k_) {
                this.f5232e = true;
                m6595a(this, j_, k_);
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    /* renamed from: a */
    private static synchronized void m6595a(AsyncTimeout aVar, long j, boolean z) {
        Class<AsyncTimeout> cls = AsyncTimeout.class;
        synchronized (cls) {
            if (f5229a == null) {
                f5229a = new AsyncTimeout();
                new C1860a().start();
            }
            long nanoTime = System.nanoTime();
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i != 0 && z) {
                aVar.f5234g = Math.min(j, aVar.mo13611d() - nanoTime) + nanoTime;
            } else if (i != 0) {
                aVar.f5234g = j + nanoTime;
            } else if (z) {
                aVar.f5234g = aVar.mo13611d();
            } else {
                throw new AssertionError();
            }
            long b = aVar.m6597b(nanoTime);
            AsyncTimeout aVar2 = f5229a;
            while (true) {
                if (aVar2.f5233f == null) {
                    break;
                } else if (b < aVar2.f5233f.m6597b(nanoTime)) {
                    break;
                } else {
                    aVar2 = aVar2.f5233f;
                }
            }
            aVar.f5233f = aVar2.f5233f;
            aVar2.f5233f = aVar;
            if (aVar2 == f5229a) {
                cls.notify();
            }
        }
    }

    /* renamed from: b */
    public final boolean mo13504b() {
        if (!this.f5232e) {
            return false;
        }
        this.f5232e = false;
        return m6596a(this);
    }

    /* renamed from: a */
    private static synchronized boolean m6596a(AsyncTimeout aVar) {
        synchronized (AsyncTimeout.class) {
            for (AsyncTimeout aVar2 = f5229a; aVar2 != null; aVar2 = aVar2.f5233f) {
                if (aVar2.f5233f == aVar) {
                    aVar2.f5233f = aVar.f5233f;
                    aVar.f5233f = null;
                    return false;
                }
            }
            return true;
        }
    }

    /* renamed from: b */
    private long m6597b(long j) {
        return this.f5234g - j;
    }

    /* renamed from: a */
    public final Sink mo13498a(final Sink rVar) {
        return new Sink() {
            /* renamed from: a_ */
            public void mo13507a_(Buffer cVar, long j) throws IOException {
                C1868u.m6834a(cVar.f5243b, 0, j);
                while (true) {
                    long j2 = 0;
                    if (j > 0) {
                        Segment oVar = cVar.f5242a;
                        while (true) {
                            if (j2 >= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                                break;
                            }
                            j2 += (long) (oVar.f5277c - oVar.f5276b);
                            if (j2 >= j) {
                                j2 = j;
                                break;
                            }
                            oVar = oVar.f5280f;
                        }
                        AsyncTimeout.this.mo13501a();
                        try {
                            rVar.mo13507a_(cVar, j2);
                            j -= j2;
                            AsyncTimeout.this.mo13502a(true);
                        } catch (IOException e) {
                            throw AsyncTimeout.this.mo13500a(e);
                        } catch (Throwable th) {
                            AsyncTimeout.this.mo13502a(false);
                            throw th;
                        }
                    } else {
                        return;
                    }
                }
            }

            public void flush() throws IOException {
                AsyncTimeout.this.mo13501a();
                try {
                    rVar.flush();
                    AsyncTimeout.this.mo13502a(true);
                } catch (IOException e) {
                    throw AsyncTimeout.this.mo13500a(e);
                } catch (Throwable th) {
                    AsyncTimeout.this.mo13502a(false);
                    throw th;
                }
            }

            public void close() throws IOException {
                AsyncTimeout.this.mo13501a();
                try {
                    rVar.close();
                    AsyncTimeout.this.mo13502a(true);
                } catch (IOException e) {
                    throw AsyncTimeout.this.mo13500a(e);
                } catch (Throwable th) {
                    AsyncTimeout.this.mo13502a(false);
                    throw th;
                }
            }

            /* renamed from: a */
            public Timeout mo13506a() {
                return AsyncTimeout.this;
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("AsyncTimeout.sink(");
                sb.append(rVar);
                sb.append(")");
                return sb.toString();
            }
        };
    }

    /* renamed from: a */
    public final Source mo13499a(final Source sVar) {
        return new Source() {
            /* renamed from: a */
            public long mo13511a(Buffer cVar, long j) throws IOException {
                AsyncTimeout.this.mo13501a();
                try {
                    long a = sVar.mo13511a(cVar, j);
                    AsyncTimeout.this.mo13502a(true);
                    return a;
                } catch (IOException e) {
                    throw AsyncTimeout.this.mo13500a(e);
                } catch (Throwable th) {
                    AsyncTimeout.this.mo13502a(false);
                    throw th;
                }
            }

            public void close() throws IOException {
                AsyncTimeout.this.mo13501a();
                try {
                    sVar.close();
                    AsyncTimeout.this.mo13502a(true);
                } catch (IOException e) {
                    throw AsyncTimeout.this.mo13500a(e);
                } catch (Throwable th) {
                    AsyncTimeout.this.mo13502a(false);
                    throw th;
                }
            }

            /* renamed from: a */
            public Timeout mo13512a() {
                return AsyncTimeout.this;
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("AsyncTimeout.source(");
                sb.append(sVar);
                sb.append(")");
                return sb.toString();
            }
        };
    }

    /* access modifiers changed from: final */
    /* renamed from: a */
    public final void mo13502a(boolean z) throws IOException {
        if (mo13504b() && z) {
            throw mo13503b((IOException) null);
        }
    }

    /* access modifiers changed from: final */
    /* renamed from: a */
    public final IOException mo13500a(IOException iOException) throws IOException {
        if (!mo13504b()) {
            return iOException;
        }
        return mo13503b(iOException);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public IOException mo13503b(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* renamed from: i_ */
    static AsyncTimeout m6598i_() throws InterruptedException {
        Class<AsyncTimeout> cls = AsyncTimeout.class;
        AsyncTimeout aVar = f5229a.f5233f;
        AsyncTimeout aVar2 = null;
        if (aVar == null) {
            long nanoTime = System.nanoTime();
            cls.wait(f5230b);
            if (f5229a.f5233f == null && System.nanoTime() - nanoTime >= f5231d) {
                aVar2 = f5229a;
            }
            return aVar2;
        }
        long b = aVar.m6597b(System.nanoTime());
        if (b > 0) {
            long j = b / 1000000;
            cls.wait(j, (int) (b - (1000000 * j)));
            return null;
        }
        f5229a.f5233f = aVar.f5233f;
        aVar.f5233f = null;
        return aVar;
    }
}
