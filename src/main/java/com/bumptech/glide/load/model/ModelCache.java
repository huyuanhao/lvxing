package com.bumptech.glide.load.model;

import com.bumptech.glide.util.C1772j;
import com.bumptech.glide.util.LruCache;
import java.util.Queue;

/* renamed from: com.bumptech.glide.load.model.l */
public class ModelCache<A, B> {
    /* renamed from: a */
    private final LruCache<C1724a<A>, B> f4790a;

    /* compiled from: ModelCache */
    /* renamed from: com.bumptech.glide.load.model.l$a */
    static final class C1724a<A> {
        /* renamed from: a */
        private static final Queue<C1724a<?>> f4792a = C1772j.m6153a(0);
        /* renamed from: b */
        private int f4793b;
        /* renamed from: c */
        private int f4794c;
        /* renamed from: d */
        private A f4795d;

        /* renamed from: a */
        static <A> C1724a<A> m5881a(A a, int i, int i2) {
            C1724a<A> aVar;
            synchronized (f4792a) {
                aVar = (C1724a) f4792a.poll();
            }
            if (aVar == null) {
                aVar = new C1724a<>();
            }
            aVar.m5882b(a, i, i2);
            return aVar;
        }

        private C1724a() {
        }

        /* renamed from: b */
        private void m5882b(A a, int i, int i2) {
            this.f4795d = a;
            this.f4794c = i;
            this.f4793b = i2;
        }

        /* renamed from: a */
        public void mo12975a() {
            synchronized (f4792a) {
                f4792a.offer(this);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1724a)) {
                return false;
            }
            C1724a aVar = (C1724a) obj;
            if (this.f4794c == aVar.f4794c && this.f4793b == aVar.f4793b && this.f4795d.equals(aVar.f4795d)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.f4793b * 31) + this.f4794c) * 31) + this.f4795d.hashCode();
        }
    }

    public ModelCache() {
        this(250);
    }

    public ModelCache(long j) {
        this.f4790a = new LruCache<C1724a<A>, B>(j) {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo12799a(C1724a<A> aVar, B b) {
                aVar.mo12975a();
            }
        };
    }

    /* renamed from: a */
    public B mo12972a(A a, int i, int i2) {
        C1724a a2 = C1724a.m5881a(a, i, i2);
        B b = this.f4790a.mo13229b(a2);
        a2.mo12975a();
        return b;
    }

    /* renamed from: a */
    public void mo12973a(A a, int i, int i2, B b) {
        this.f4790a.mo13230b(C1724a.m5881a(a, i, i2), b);
    }
}
