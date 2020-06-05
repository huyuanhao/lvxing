package com.bumptech.glide.p131c.p133b;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import com.bumptech.glide.p131c.p133b.Transition.C1611a;

/* renamed from: com.bumptech.glide.c.b.k */
public class ViewTransition<R> implements Transition<R> {
    /* renamed from: a */
    private final C1614a f4223a;

    /* compiled from: ViewTransition */
    /* renamed from: com.bumptech.glide.c.b.k$a */
    interface C1614a {
        /* renamed from: a */
        Animation mo12513a(Context context);
    }

    ViewTransition(C1614a aVar) {
        this.f4223a = aVar;
    }

    /* renamed from: a */
    public boolean mo12508a(R r, C1611a aVar) {
        View b = aVar.mo12512b();
        if (b != null) {
            b.clearAnimation();
            b.startAnimation(this.f4223a.mo12513a(b.getContext()));
        }
        return false;
    }
}
