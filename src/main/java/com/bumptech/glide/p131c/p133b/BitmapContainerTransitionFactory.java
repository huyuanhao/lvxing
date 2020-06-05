package com.bumptech.glide.p131c.p133b;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.p131c.p133b.Transition.C1611a;

/* renamed from: com.bumptech.glide.c.b.a */
public abstract class BitmapContainerTransitionFactory<R> implements TransitionFactory<R> {
    /* renamed from: a */
    private final TransitionFactory<Drawable> f4205a;

    /* compiled from: BitmapContainerTransitionFactory */
    /* renamed from: com.bumptech.glide.c.b.a$a */
    private final class C1608a implements Transition<R> {
        /* renamed from: b */
        private final Transition<Drawable> f4207b;

        C1608a(Transition<Drawable> fVar) {
            this.f4207b = fVar;
        }

        /* renamed from: a */
        public boolean mo12508a(R r, C1611a aVar) {
            return this.f4207b.mo12508a(new BitmapDrawable(aVar.mo12512b().getResources(), BitmapContainerTransitionFactory.this.mo12506a(r)), aVar);
        }
    }

    /* renamed from: a */
    public abstract Bitmap mo12506a(R r);

    public BitmapContainerTransitionFactory(TransitionFactory<Drawable> gVar) {
        this.f4205a = gVar;
    }

    /* renamed from: a */
    public Transition<R> mo12507a(DataSource dataSource, boolean z) {
        return new C1608a(this.f4205a.mo12507a(dataSource, z));
    }
}
