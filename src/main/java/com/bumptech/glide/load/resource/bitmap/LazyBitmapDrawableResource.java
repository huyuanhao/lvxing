package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.p137a.BitmapPool;
import com.bumptech.glide.util.Preconditions;

public final class LazyBitmapDrawableResource implements Initializable, Resource<BitmapDrawable> {
    private final Resource<Bitmap> bitmapResource;
    private final Resources resources;

    @Deprecated
    public static LazyBitmapDrawableResource obtain(Context context, Bitmap bitmap) {
        return (LazyBitmapDrawableResource) obtain(context.getResources(), (Resource<Bitmap>) BitmapResource.obtain(bitmap, Glide.m5169a(context).mo12528a()));
    }

    @Deprecated
    public static LazyBitmapDrawableResource obtain(Resources resources2, BitmapPool eVar, Bitmap bitmap) {
        return (LazyBitmapDrawableResource) obtain(resources2, (Resource<Bitmap>) BitmapResource.obtain(bitmap, eVar));
    }

    public static Resource<BitmapDrawable> obtain(Resources resources2, Resource<Bitmap> uVar) {
        if (uVar == null) {
            return null;
        }
        return new LazyBitmapDrawableResource(resources2, uVar);
    }

    private LazyBitmapDrawableResource(Resources resources2, Resource<Bitmap> uVar) {
        this.resources = (Resources) Preconditions.m6138a(resources2);
        this.bitmapResource = (Resource) Preconditions.m6138a(uVar);
    }

    public Class<BitmapDrawable> getResourceClass() {
        return BitmapDrawable.class;
    }

    public BitmapDrawable get() {
        return new BitmapDrawable(this.resources, (Bitmap) this.bitmapResource.get());
    }

    public int getSize() {
        return this.bitmapResource.getSize();
    }

    public void recycle() {
        this.bitmapResource.recycle();
    }

    public void initialize() {
        Resource<Bitmap> uVar = this.bitmapResource;
        if (uVar instanceof Initializable) {
            ((Initializable) uVar).initialize();
        }
    }
}
