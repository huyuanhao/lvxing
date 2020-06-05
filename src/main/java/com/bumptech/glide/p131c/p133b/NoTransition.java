package com.bumptech.glide.p131c.p133b;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.p131c.p133b.Transition.C1611a;

/* renamed from: com.bumptech.glide.c.b.e */
public class NoTransition<R> implements Transition<R> {
    /* renamed from: a */
    static final NoTransition<?> f4215a = new NoTransition<>();
    /* renamed from: b */
    private static final TransitionFactory<?> f4216b = new C1610a();

    /* compiled from: NoTransition */
    /* renamed from: com.bumptech.glide.c.b.e$a */
    public static class C1610a<R> implements TransitionFactory<R> {
        /* renamed from: a */
        public Transition<R> mo12507a(DataSource dataSource, boolean z) {
            return NoTransition.f4215a;
        }
    }

    /* renamed from: a */
    public boolean mo12508a(Object obj, C1611a aVar) {
        return false;
    }

    /* renamed from: a */
    public static <R> TransitionFactory<R> m5070a() {
        return f4216b;
    }

    /* renamed from: b */
    public static <R> Transition<R> m5071b() {
        return f4215a;
    }
}
