package com.bumptech.glide.p131c.p133b;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.bumptech.glide.load.DataSource;

/* renamed from: com.bumptech.glide.c.b.h */
public class ViewAnimationFactory<R> implements TransitionFactory<R> {
    /* renamed from: a */
    private final C1614a f4217a;
    /* renamed from: b */
    private Transition<R> f4218b;

    /* compiled from: ViewAnimationFactory */
    /* renamed from: com.bumptech.glide.c.b.h$a */
    private static class C1612a implements C1614a {
        /* renamed from: a */
        private final int f4219a;

        C1612a(int i) {
            this.f4219a = i;
        }

        /* renamed from: a */
        public Animation mo12513a(Context context) {
            return AnimationUtils.loadAnimation(context, this.f4219a);
        }
    }

    public ViewAnimationFactory(int i) {
        this((C1614a) new C1612a(i));
    }

    ViewAnimationFactory(C1614a aVar) {
        this.f4217a = aVar;
    }

    /* renamed from: a */
    public Transition<R> mo12507a(DataSource dataSource, boolean z) {
        if (dataSource == DataSource.MEMORY_CACHE || !z) {
            return NoTransition.m5071b();
        }
        if (this.f4218b == null) {
            this.f4218b = new ViewTransition(this.f4217a);
        }
        return this.f4218b;
    }
}
