package com.bumptech.glide.util.p140a;

import android.util.Log;
import androidx.core.util.Pools.Pool;
import androidx.core.util.Pools.SynchronizedPool;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bumptech.glide.util.a.a */
public final class FactoryPools {
    /* renamed from: a */
    private static final C1767d<Object> f4900a = new C1767d<Object>() {
        /* renamed from: a */
        public void mo13203a(Object obj) {
        }
    };

    /* compiled from: FactoryPools */
    /* renamed from: com.bumptech.glide.util.a.a$a */
    public interface C1764a<T> {
        /* renamed from: b */
        T mo12521b();
    }

    /* compiled from: FactoryPools */
    /* renamed from: com.bumptech.glide.util.a.a$b */
    private static final class C1765b<T> implements Pool<T> {
        /* renamed from: a */
        private final C1764a<T> f4901a;
        /* renamed from: b */
        private final C1767d<T> f4902b;
        /* renamed from: c */
        private final Pool<T> f4903c;

        C1765b(Pool<T> pool, C1764a<T> aVar, C1767d<T> dVar) {
            this.f4903c = pool;
            this.f4901a = aVar;
            this.f4902b = dVar;
        }

        public T acquire() {
            T acquire = this.f4903c.acquire();
            if (acquire == null) {
                acquire = this.f4901a.mo12521b();
                String str = "FactoryPools";
                if (Log.isLoggable(str, 2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Created new ");
                    sb.append(acquire.getClass());
                    Log.v(str, sb.toString());
                }
            }
            if (acquire instanceof C1766c) {
                ((C1766c) acquire).mo12519d().mo13206a(false);
            }
            return acquire;
        }

        public boolean release(T t) {
            if (t instanceof C1766c) {
                ((C1766c) t).mo12519d().mo13206a(true);
            }
            this.f4902b.mo13203a(t);
            return this.f4903c.release(t);
        }
    }

    /* compiled from: FactoryPools */
    /* renamed from: com.bumptech.glide.util.a.a$c */
    public interface C1766c {
        /* renamed from: d */
        StateVerifier mo12519d();
    }

    /* compiled from: FactoryPools */
    /* renamed from: com.bumptech.glide.util.a.a$d */
    public interface C1767d<T> {
        /* renamed from: a */
        void mo13203a(T t);
    }

    /* renamed from: a */
    public static <T extends C1766c> Pool<T> m6095a(int i, C1764a<T> aVar) {
        return m6096a((Pool<T>) new SynchronizedPool<T>(i), aVar);
    }

    /* renamed from: a */
    public static <T> Pool<List<T>> m6093a() {
        return m6094a(20);
    }

    /* renamed from: a */
    public static <T> Pool<List<T>> m6094a(int i) {
        return m6097a(new SynchronizedPool(i), new C1764a<List<T>>() {
            /* renamed from: a */
            public List<T> mo12521b() {
                return new ArrayList();
            }
        }, new C1767d<List<T>>() {
            /* renamed from: a */
            public void mo13203a(List<T> list) {
                list.clear();
            }
        });
    }

    /* renamed from: a */
    private static <T extends C1766c> Pool<T> m6096a(Pool<T> pool, C1764a<T> aVar) {
        return m6097a(pool, aVar, m6098b());
    }

    /* renamed from: a */
    private static <T> Pool<T> m6097a(Pool<T> pool, C1764a<T> aVar, C1767d<T> dVar) {
        return new C1765b(pool, aVar, dVar);
    }

    /* renamed from: b */
    private static <T> C1767d<T> m6098b() {
        return f4900a;
    }
}
