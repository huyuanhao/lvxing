package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

@Deprecated
public class BitmapDrawableTransformation implements Transformation<BitmapDrawable> {
    private final Transformation<Drawable> wrapped;

    private static Resource<Drawable> convertToDrawableResource(Resource<BitmapDrawable> uVar) {
        return uVar;
    }

    public BitmapDrawableTransformation(Transformation<Bitmap> iVar) {
        this.wrapped = (Transformation) Preconditions.m6138a(new DrawableTransformation(iVar, false));
    }

    public Resource<BitmapDrawable> transform(Context context, Resource<BitmapDrawable> uVar, int i, int i2) {
        return convertToBitmapDrawableResource(this.wrapped.transform(context, convertToDrawableResource(uVar), i, i2));
    }

    private static Resource<BitmapDrawable> convertToBitmapDrawableResource(Resource<Drawable> uVar) {
        if (uVar.get() instanceof BitmapDrawable) {
            return uVar;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Wrapped transformation unexpectedly returned a non BitmapDrawable resource: ");
        sb.append(uVar.get());
        throw new IllegalArgumentException(sb.toString());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BitmapDrawableTransformation)) {
            return false;
        }
        return this.wrapped.equals(((BitmapDrawableTransformation) obj).wrapped);
    }

    public int hashCode() {
        return this.wrapped.hashCode();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.wrapped.updateDiskCacheKey(messageDigest);
    }
}
