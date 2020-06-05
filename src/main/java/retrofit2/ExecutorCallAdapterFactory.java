package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import retrofit2.CallAdapter.C8624a;

/* renamed from: retrofit2.g */
final class ExecutorCallAdapterFactory extends C8624a {
    /* renamed from: a */
    final Executor f29341a;

    /* compiled from: ExecutorCallAdapterFactory */
    /* renamed from: retrofit2.g$a */
    static final class C8629a<T> implements C8623b<T> {
        /* renamed from: a */
        final Executor f29344a;
        /* renamed from: b */
        final C8623b<T> f29345b;

        C8629a(Executor executor, C8623b<T> bVar) {
            this.f29344a = executor;
            this.f29345b = bVar;
        }

        /* renamed from: a */
        public void mo41290a(final C8625d<T> dVar) {
            C8662o.m37637a(dVar, "callback == null");
            this.f29345b.mo41290a(new C8625d<T>() {
                /* renamed from: a */
                public void mo41284a(C8623b<T> bVar, final C8658l<T> lVar) {
                    C8629a.this.f29344a.execute(new Runnable() {
                        public void run() {
                            if (C8629a.this.f29345b.mo41292c()) {
                                dVar.mo41283a((C8623b<T>) C8629a.this, (Throwable) new IOException("Canceled"));
                            } else {
                                dVar.mo41284a((C8623b<T>) C8629a.this, lVar);
                            }
                        }
                    });
                }

                /* renamed from: a */
                public void mo41283a(C8623b<T> bVar, final Throwable th) {
                    C8629a.this.f29344a.execute(new Runnable() {
                        public void run() {
                            dVar.mo41283a((C8623b<T>) C8629a.this, th);
                        }
                    });
                }
            });
        }

        /* renamed from: a */
        public C8658l<T> mo41289a() throws IOException {
            return this.f29345b.mo41289a();
        }

        /* renamed from: b */
        public void mo41291b() {
            this.f29345b.mo41291b();
        }

        /* renamed from: c */
        public boolean mo41292c() {
            return this.f29345b.mo41292c();
        }

        /* renamed from: d */
        public C8623b<T> clone() {
            return new C8629a(this.f29344a, this.f29345b.mo41293d());
        }
    }

    ExecutorCallAdapterFactory(Executor executor) {
        this.f29341a = executor;
    }

    /* renamed from: a */
    public CallAdapter<?, ?> mo41288a(Type type, Annotation[] annotationArr, Retrofit mVar) {
        if (m37500a(type) != C8623b.class) {
            return null;
        }
        final Type e = C8662o.m37651e(type);
        return new CallAdapter<Object, C8623b<?>>() {
            /* renamed from: a */
            public Type mo41287a() {
                return e;
            }

            /* renamed from: b */
            public C8623b<Object> mo41286a(C8623b<Object> bVar) {
                return new C8629a(ExecutorCallAdapterFactory.this.f29341a, bVar);
            }
        };
    }
}
