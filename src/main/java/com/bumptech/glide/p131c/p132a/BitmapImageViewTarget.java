package com.bumptech.glide.p131c.p132a;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* renamed from: com.bumptech.glide.c.a.b */
public class BitmapImageViewTarget extends ImageViewTarget<Bitmap> {
    public BitmapImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo12474a(Bitmap bitmap) {
        ((ImageView) this.f4191a).setImageBitmap(bitmap);
    }
}
