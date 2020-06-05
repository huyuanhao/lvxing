package okio;

import android.support.p000v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: AsyncTimeout */
/* renamed from: okio.a */
public class C8520a extends C8548s {
    /* renamed from: a */
    private static final long f29004a = TimeUnit.SECONDS.toMillis(60);
    @Nullable
    /* renamed from: b */
    static C8520a f29005b;
    /* renamed from: d */
    private static final long f29006d = TimeUnit.MILLISECONDS.toNanos(f29004a);
    /* renamed from: e */
    private boolean f29007e;
    @Nullable
    /* renamed from: f */
    private C8520a f29008f;
    /* renamed from: g */
    private long f29009g;

    /* compiled from: AsyncTimeout */
    /* renamed from: okio.a$a */
    private static final class C8523a extends Thread {
        C8523a() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r1.mo40424a();
     */
        public void run() {
            /*
            r3 = this;
        L_0x0000:
            java.lang.Class<okio.a> r0 = okio.C8520a.class
            monitor-enter(r0)     // Catch:{ InterruptedException -> 0x0000 }
            okio.a r1 = okio.C8520a.m36702e()     // Catch:{ all -> 0x0019 }
            if (r1 != 0) goto L_0x000b
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            goto L_0x0000
        L_0x000b:
            okio.a r2 = okio.C8520a.f29005b     // Catch:{ all -> 0x0019 }
            if (r1 != r2) goto L_0x0014
            r1 = 0
            okio.C8520a.f29005b = r1     // Catch:{ all -> 0x0019 }
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            return
        L_0x0014:
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            r1.mo40424a()     // Catch:{ InterruptedException -> 0x0000 }
            goto L_0x0000
        L_0x0019:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            throw r1     // Catch:{ InterruptedException -> 0x0000 }
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.C8520a.C8523a.run():void");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo40424a() {
    }

    /* renamed from: c */
    public final void mo40710c() {
        if (!this.f29007e) {
            long n_ = mo40808n_();
            boolean o_ = mo40809o_();
            if (n_ != 0 || o_) {
                this.f29007e = true;
                m36699a(this, n_, o_);
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    /* renamed from: a */
    private static synchronized void m36699a(C8520a aVar, long j, boolean z) {
        Class<C8520a> cls = C8520a.class;
        synchronized (cls) {
            if (f29005b == null) {
                f29005b = new C8520a();
                new C8523a().start();
            }
            long nanoTime = System.nanoTime();
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i != 0 && z) {
                aVar.f29009g = Math.min(j, aVar.mo40805d() - nanoTime) + nanoTime;
            } else if (i != 0) {
                aVar.f29009g = j + nanoTime;
            } else if (z) {
                aVar.f29009g = aVar.mo40805d();
            } else {
                throw new AssertionError();
            }
            long b = aVar.m36701b(nanoTime);
            C8520a aVar2 = f29005b;
            while (true) {
                if (aVar2.f29008f == null) {
                    break;
                } else if (b < aVar2.f29008f.m36701b(nanoTime)) {
                    break;
                } else {
                    aVar2 = aVar2.f29008f;
                }
            }
            aVar.f29008f = aVar2.f29008f;
            aVar2.f29008f = aVar;
            if (aVar2 == f29005b) {
                cls.notify();
            }
        }
    }

    /* renamed from: m_ */
    public final boolean mo40711m_() {
        if (!this.f29007e) {
            return false;
        }
        this.f29007e = false;
        return m36700a(this);
    }

    /* renamed from: a */
    private static synchronized boolean m36700a(C8520a aVar) {
        synchronized (C8520a.class) {
            for (C8520a aVar2 = f29005b; aVar2 != null; aVar2 = aVar2.f29008f) {
                if (aVar2.f29008f == aVar) {
                    aVar2.f29008f = aVar.f29008f;
                    aVar.f29008f = null;
                    return false;
                }
            }
            return true;
        }
    }

    /* renamed from: b */
    private long m36701b(long j) {
        return this.f29009g - j;
    }

    /* renamed from: a */
    public final C8546q mo40706a(final C8546q qVar) {
        return new C8546q() {
            /* renamed from: a_ */
            public void mo40231a_(C8525c cVar, long j) throws IOException {
                C8550t.m36938a(cVar.f29018b, 0, j);
                while (true) {
                    long j2 = 0;
                    if (j > 0) {
                        C8543n nVar = cVar.f29017a;
                        while (true) {
                            if (j2 >= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                                break;
                            }
                            j2 += (long) (nVar.f29048c - nVar.f29047b);
                            if (j2 >= j) {
                                j2 = j;
                                break;
                            }
                            nVar = nVar.f29051f;
                        }
                        C8520a.this.mo40710c();
                        try {
                            qVar.mo40231a_(cVar, j2);
                            j -= j2;
                            C8520a.this.mo40708a(true);
                        } catch (IOException e) {
                            throw C8520a.this.mo40709b(e);
                        } catch (Throwable th) {
                            C8520a.this.mo40708a(false);
                            throw th;
                        }
                    } else {
                        return;
                    }
                }
            }

            public void flush() throws IOException {
                C8520a.this.mo40710c();
                try {
                    qVar.flush();
                    C8520a.this.mo40708a(true);
                } catch (IOException e) {
                    throw C8520a.this.mo40709b(e);
                } catch (Throwable th) {
                    C8520a.this.mo40708a(false);
                    throw th;
                }
            }

            public void close() throws IOException {
                C8520a.this.mo40710c();
                try {
                    qVar.close();
                    C8520a.this.mo40708a(true);
                } catch (IOException e) {
                    throw C8520a.this.mo40709b(e);
                } catch (Throwable th) {
                    C8520a.this.mo40708a(false);
                    throw th;
                }
            }

            /* renamed from: a */
            public C8548s mo40271a() {
                return C8520a.this;
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("AsyncTimeout.sink(");
                sb.append(qVar);
                sb.append(")");
                return sb.toString();
            }
        };
    }

    /* renamed from: a */
    public final C8547r mo40707a(final C8547r rVar) {
        return new C8547r() {
            /* renamed from: a */
            public long mo40202a(C8525c cVar, long j) throws IOException {
                C8520a.this.mo40710c();
                try {
                    long a = rVar.mo40202a(cVar, j);
                    C8520a.this.mo40708a(true);
                    return a;
                } catch (IOException e) {
                    throw C8520a.this.mo40709b(e);
                } catch (Throwable th) {
                    C8520a.this.mo40708a(false);
                    throw th;
                }
            }

            public void close() throws IOException {
                try {
                    rVar.close();
                    C8520a.this.mo40708a(true);
                } catch (IOException e) {
                    throw C8520a.this.mo40709b(e);
                } catch (Throwable th) {
                    C8520a.this.mo40708a(false);
                    throw th;
                }
            }

            /* renamed from: a */
            public C8548s mo40203a() {
                return C8520a.this;
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("AsyncTimeout.source(");
                sb.append(rVar);
                sb.append(")");
                return sb.toString();
            }
        };
    }

    /* access modifiers changed from: final */
    /* renamed from: a */
    public final void mo40708a(boolean z) throws IOException {
        if (mo40711m_() && z) {
            throw mo40423a((IOException) null);
        }
    }

    /* access modifiers changed from: final */
    /* renamed from: b */
    public final IOException mo40709b(IOException iOException) throws IOException {
        if (!mo40711m_()) {
            return iOException;
        }
        return mo40423a(iOException);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public IOException mo40423a(@Nullable IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    @Nullable
    /* renamed from: e */
    static C8520a m36702e() throws InterruptedException {
        Class<C8520a> cls = C8520a.class;
        C8520a aVar = f29005b.f29008f;
        C8520a aVar2 = null;
        if (aVar == null) {
            long nanoTime = System.nanoTime();
            cls.wait(f29004a);
            if (f29005b.f29008f == null && System.nanoTime() - nanoTime >= f29006d) {
                aVar2 = f29005b;
            }
            return aVar2;
        }
        long b = aVar.m36701b(System.nanoTime());
        if (b > 0) {
            long j = b / 1000000;
            cls.wait(j, (int) (b - (1000000 * j)));
            return null;
        }
        f29005b.f29008f = aVar.f29008f;
        aVar.f29008f = null;
        return aVar;
    }
}
