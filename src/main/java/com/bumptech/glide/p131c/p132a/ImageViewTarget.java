package com.bumptech.glide.p131c.p132a;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.p131c.p133b.Transition;
import com.bumptech.glide.p131c.p133b.Transition.C1611a;

/* renamed from: com.bumptech.glide.c.a.d */
public abstract class ImageViewTarget<Z> extends ViewTarget<ImageView, Z> implements C1611a {
    /* renamed from: b */
    private Animatable f4188b;

    /* renamed from: a */
    public abstract void mo12474a(Z z);

    public ImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    /* renamed from: a */
    public Drawable mo12476a() {
        return ((ImageView) this.f4191a).getDrawable();
    }

    /* renamed from: b */
    public void mo12477b(Drawable drawable) {
        ((ImageView) this.f4191a).setImageDrawable(drawable);
    }

    public void onLoadStarted(Drawable drawable) {
        super.onLoadStarted(drawable);
        m5016b((Z) null);
        mo12477b(drawable);
    }

    public void onLoadFailed(Drawable drawable) {
        super.onLoadFailed(drawable);
        m5016b((Z) null);
        mo12477b(drawable);
    }

    public void onLoadCleared(Drawable drawable) {
        super.onLoadCleared(drawable);
        Animatable animatable = this.f4188b;
        if (animatable != null) {
            animatable.stop();
        }
        m5016b((Z) null);
        mo12477b(drawable);
    }

    public void onResourceReady(Z z, Transition<? super Z> fVar) {
        if (fVar == null || !fVar.mo12508a(z, this)) {
            m5016b(z);
        } else {
            m5017c(z);
        }
    }

    public void onStart() {
        Animatable animatable = this.f4188b;
        if (animatable != null) {
            animatable.start();
        }
    }

    public void onStop() {
        Animatable animatable = this.f4188b;
        if (animatable != null) {
            animatable.stop();
        }
    }

    /* renamed from: b */
    private void m5016b(Z z) {
        mo12474a(z);
        m5017c(z);
    }

    /* renamed from: c */
    private void m5017c(Z z) {
        if (z instanceof Animatable) {
            this.f4188b = (Animatable) z;
            this.f4188b.start();
            return;
        }
        this.f4188b = null;
    }
}
