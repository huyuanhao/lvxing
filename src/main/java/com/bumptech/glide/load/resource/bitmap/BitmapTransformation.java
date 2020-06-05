package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.p137a.BitmapPool;
import com.bumptech.glide.util.C1772j;

public abstract class BitmapTransformation implements Transformation<Bitmap> {
    public abstract Bitmap transform(BitmapPool eVar, Bitmap bitmap, int i, int i2);

    public final Resource<Bitmap> transform(Context context, Resource<Bitmap> uVar, int i, int i2) {
        if (C1772j.m6155a(i, i2)) {
            BitmapPool a = Glide.m5169a(context).mo12528a();
            Bitmap bitmap = (Bitmap) uVar.get();
            if (i == Integer.MIN_VALUE) {
                i = bitmap.getWidth();
            }
            if (i2 == Integer.MIN_VALUE) {
                i2 = bitmap.getHeight();
            }
            Bitmap transform = transform(a, bitmap, i, i2);
            if (bitmap.equals(transform)) {
                return uVar;
            }
            return BitmapResource.obtain(transform, a);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot apply transformation on width: ");
        sb.append(i);
        sb.append(" or height: ");
        sb.append(i2);
        sb.append(" less than or equal to zero and not Target.SIZE_ORIGINAL");
        throw new IllegalArgumentException(sb.toString());
    }
}
