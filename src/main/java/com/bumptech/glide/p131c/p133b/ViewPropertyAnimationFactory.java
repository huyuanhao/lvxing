package com.bumptech.glide.p131c.p133b;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.p131c.p133b.ViewPropertyTransition.C1613a;

/* renamed from: com.bumptech.glide.c.b.i */
public class ViewPropertyAnimationFactory<R> implements TransitionFactory<R> {
    /* renamed from: a */
    private final C1613a f4220a;
    /* renamed from: b */
    private ViewPropertyTransition<R> f4221b;

    public ViewPropertyAnimationFactory(C1613a aVar) {
        this.f4220a = aVar;
    }

    /* renamed from: a */
    public Transition<R> mo12507a(DataSource dataSource, boolean z) {
        if (dataSource == DataSource.MEMORY_CACHE || !z) {
            return NoTransition.m5071b();
        }
        if (this.f4221b == null) {
            this.f4221b = new ViewPropertyTransition<>(this.f4220a);
        }
        return this.f4221b;
    }
}
