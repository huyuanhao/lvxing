package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

public class GifDrawableTransformation implements Transformation<GifDrawable> {
    private final Transformation<Bitmap> wrapped;

    public GifDrawableTransformation(Transformation<Bitmap> iVar) {
        this.wrapped = (Transformation) Preconditions.m6138a(iVar);
    }

    public Resource<GifDrawable> transform(Context context, Resource<GifDrawable> uVar, int i, int i2) {
        GifDrawable gifDrawable = (GifDrawable) uVar.get();
        BitmapResource bitmapResource = new BitmapResource(gifDrawable.getFirstFrame(), Glide.m5169a(context).mo12528a());
        Resource transform = this.wrapped.transform(context, bitmapResource, i, i2);
        if (!bitmapResource.equals(transform)) {
            bitmapResource.recycle();
        }
        gifDrawable.setFrameTransformation(this.wrapped, (Bitmap) transform.get());
        return uVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GifDrawableTransformation)) {
            return false;
        }
        return this.wrapped.equals(((GifDrawableTransformation) obj).wrapped);
    }

    public int hashCode() {
        return this.wrapped.hashCode();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.wrapped.updateDiskCacheKey(messageDigest);
    }
}
