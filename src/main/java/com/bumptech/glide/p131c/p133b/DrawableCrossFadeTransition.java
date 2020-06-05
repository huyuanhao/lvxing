package com.bumptech.glide.p131c.p133b;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import com.bumptech.glide.p131c.p133b.Transition.C1611a;

/* renamed from: com.bumptech.glide.c.b.d */
public class DrawableCrossFadeTransition implements Transition<Drawable> {
    /* renamed from: a */
    private final int f4213a;
    /* renamed from: b */
    private final boolean f4214b;

    public DrawableCrossFadeTransition(int i, boolean z) {
        this.f4213a = i;
        this.f4214b = z;
    }

    /* renamed from: a */
    public boolean mo12508a(Drawable drawable, C1611a aVar) {
        Drawable a = aVar.mo12476a();
        if (a == null) {
            a = new ColorDrawable(0);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{a, drawable});
        transitionDrawable.setCrossFadeEnabled(this.f4214b);
        transitionDrawable.startTransition(this.f4213a);
        aVar.mo12477b(transitionDrawable);
        return true;
    }
}
