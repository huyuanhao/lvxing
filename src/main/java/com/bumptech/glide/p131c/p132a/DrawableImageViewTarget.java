package com.bumptech.glide.p131c.p132a;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* renamed from: com.bumptech.glide.c.a.c */
public class DrawableImageViewTarget extends ImageViewTarget<Drawable> {
    public DrawableImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo12474a(Drawable drawable) {
        ((ImageView) this.f4191a).setImageDrawable(drawable);
    }
}
