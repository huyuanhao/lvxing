package retrofit2;

import java.io.IOException;
import javax.annotation.Nullable;
import okhttp3.C8362ab;
import okhttp3.C8364ac;
import okhttp3.C8379e;
import okhttp3.C8381f;
import okhttp3.C8510v;
import okio.C8525c;
import okio.C8529e;
import okio.C8531g;
import okio.C8535k;
import okio.C8547r;

/* renamed from: retrofit2.h */
final class OkHttpCall<T> implements C8623b<T> {
    /* renamed from: a */
    private final ServiceMethod<T, ?> f29352a;
    @Nullable
    /* renamed from: b */
    private final Object[] f29353b;
    /* renamed from: c */
    private volatile boolean f29354c;
    @Nullable
    /* renamed from: d */
    private C8379e f29355d;
    @Nullable
    /* renamed from: e */
    private Throwable f29356e;
    /* renamed from: f */
    private boolean f29357f;

    /* compiled from: OkHttpCall */
    /* renamed from: retrofit2.h$a */
    static final class C8634a extends C8364ac {
        /* renamed from: a */
        IOException f29360a;
        /* renamed from: b */
        private final C8364ac f29361b;

        C8634a(C8364ac acVar) {
            this.f29361b = acVar;
        }

        /* renamed from: a */
        public C8510v mo40120a() {
            return this.f29361b.mo40120a();
        }

        /* renamed from: b */
        public long mo40121b() {
            return this.f29361b.mo40121b();
        }

        /* renamed from: c */
        public C8529e mo40122c() {
            return C8535k.m36849a((C8547r) new C8531g(this.f29361b.mo40122c()) {
                /* renamed from: a */
                public long mo40202a(C8525c cVar, long j) throws IOException {
                    try {
                        return super.mo40202a(cVar, j);
                    } catch (IOException e) {
                        C8634a.this.f29360a = e;
                        throw e;
                    }
                }
            });
        }

        public void close() {
            this.f29361b.close();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: h */
        public void mo41303h() throws IOException {
            IOException iOException = this.f29360a;
            if (iOException != null) {
                throw iOException;
            }
        }
    }

    /* compiled from: OkHttpCall */
    /* renamed from: retrofit2.h$b */
    static final class C8636b extends C8364ac {
        /* renamed from: a */
        private final C8510v f29363a;
        /* renamed from: b */
        private final long f29364b;

        C8636b(C8510v vVar, long j) {
            this.f29363a = vVar;
            this.f29364b = j;
        }

        /* renamed from: a */
        public C8510v mo40120a() {
            return this.f29363a;
        }

        /* renamed from: b */
        public long mo40121b() {
            return this.f29364b;
        }

        /* renamed from: c */
        public C8529e mo40122c() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    OkHttpCall(ServiceMethod<T, ?> nVar, @Nullable Object[] objArr) {
        this.f29352a = nVar;
        this.f29353b = objArr;
    }

    /* renamed from: e */
    public OkHttpCall<T> mo41293d() {
        return new OkHttpCall<>(this.f29352a, this.f29353b);
    }

    /* renamed from: a */
    public void mo41290a(final C8625d<T> dVar) {
        C8379e eVar;
        Throwable th;
        C8662o.m37637a(dVar, "callback == null");
        synchronized (this) {
            if (!this.f29357f) {
                this.f29357f = true;
                eVar = this.f29355d;
                th = this.f29356e;
                if (eVar == null && th == null) {
                    try {
                        C8379e f = m37524f();
                        this.f29355d = f;
                        eVar = f;
                    } catch (Throwable th2) {
                        th = th2;
                        C8662o.m37644a(th);
                        this.f29356e = th;
                    }
                }
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (th != null) {
            dVar.mo41283a((C8623b<T>) this, th);
            return;
        }
        if (this.f29354c) {
            eVar.mo40175b();
        }
        eVar.mo40174a(new C8381f() {
            /* renamed from: a */
            public void mo20009a(C8379e eVar, C8362ab abVar) {
                try {
                    try {
                        dVar.mo41284a((C8623b<T>) OkHttpCall.this, OkHttpCall.this.mo41300a(abVar));
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                } catch (Throwable th2) {
                    m37532a(th2);
                }
            }

            /* renamed from: a */
            public void mo20008a(C8379e eVar, IOException iOException) {
                m37532a(iOException);
            }

            /* renamed from: a */
            private void m37532a(Throwable th) {
                try {
                    dVar.mo41283a((C8623b<T>) OkHttpCall.this, th);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        });
    }

    /* renamed from: a */
    public C8658l<T> mo41289a() throws IOException {
        C8379e eVar;
        synchronized (this) {
            if (!this.f29357f) {
                this.f29357f = true;
                if (this.f29356e == null) {
                    eVar = this.f29355d;
                    if (eVar == null) {
                        try {
                            eVar = m37524f();
                            this.f29355d = eVar;
                        } catch (IOException | Error | RuntimeException e) {
                            C8662o.m37644a(e);
                            this.f29356e = e;
                            throw e;
                        }
                    }
                } else if (this.f29356e instanceof IOException) {
                    throw ((IOException) this.f29356e);
                } else if (this.f29356e instanceof RuntimeException) {
                    throw ((RuntimeException) this.f29356e);
                } else {
                    throw ((Error) this.f29356e);
                }
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (this.f29354c) {
            eVar.mo40175b();
        }
        return mo41300a(eVar.mo40173a());
    }

    /* renamed from: f */
    private C8379e m37524f() throws IOException {
        C8379e a = this.f29352a.mo41377a(this.f29353b);
        if (a != null) {
            return a;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C8658l<T> mo41300a(C8362ab abVar) throws IOException {
        C8364ac h = abVar.mo40097h();
        C8362ab a = abVar.mo40098i().mo40111a((C8364ac) new C8636b(h.mo40120a(), h.mo40121b())).mo40115a();
        int c = a.mo40091c();
        if (c < 200 || c >= 300) {
            try {
                return C8658l.m37592a(C8662o.m37642a(h), a);
            } finally {
                h.close();
            }
        } else if (c == 204 || c == 205) {
            h.close();
            return C8658l.m37591a(null, a);
        } else {
            C8634a aVar = new C8634a(h);
            try {
                return C8658l.m37591a(this.f29352a.mo41375a((C8364ac) aVar), a);
            } catch (RuntimeException e) {
                aVar.mo41303h();
                throw e;
            }
        }
    }

    /* renamed from: b */
    public void mo41291b() {
        C8379e eVar;
        this.f29354c = true;
        synchronized (this) {
            eVar = this.f29355d;
        }
        if (eVar != null) {
            eVar.mo40175b();
        }
    }

    /* renamed from: c */
    public boolean mo41292c() {
        boolean z = true;
        if (this.f29354c) {
            return true;
        }
        synchronized (this) {
            if (this.f29355d == null || !this.f29355d.mo40176c()) {
                z = false;
            }
        }
        return z;
    }
}
