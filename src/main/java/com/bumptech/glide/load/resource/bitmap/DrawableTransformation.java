package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;

public class DrawableTransformation implements Transformation<Drawable> {
    private final boolean isRequired;
    private final Transformation<Bitmap> wrapped;

    public Transformation<BitmapDrawable> asBitmapDrawable() {
        return this;
    }

    public DrawableTransformation(Transformation<Bitmap> iVar, boolean z) {
        this.wrapped = iVar;
        this.isRequired = z;
    }

    public Resource<Drawable> transform(Context context, Resource<Drawable> uVar, int i, int i2) {
        Drawable drawable = (Drawable) uVar.get();
        Resource convert = DrawableToBitmapConverter.convert(Glide.m5169a(context).mo12528a(), drawable, i, i2);
        if (convert != null) {
            Resource transform = this.wrapped.transform(context, convert, i, i2);
            if (!transform.equals(convert)) {
                return newDrawableResource(context, transform);
            }
            transform.recycle();
            return uVar;
        } else if (!this.isRequired) {
            return uVar;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to convert ");
            sb.append(drawable);
            sb.append(" to a Bitmap");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    private Resource<Drawable> newDrawableResource(Context context, Resource<Bitmap> uVar) {
        return LazyBitmapDrawableResource.obtain(context.getResources(), uVar);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DrawableTransformation)) {
            return false;
        }
        return this.wrapped.equals(((DrawableTransformation) obj).wrapped);
    }

    public int hashCode() {
        return this.wrapped.hashCode();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.wrapped.updateDiskCacheKey(messageDigest);
    }
}
