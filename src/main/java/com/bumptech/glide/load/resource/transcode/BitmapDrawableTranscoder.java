package com.bumptech.glide.load.resource.transcode;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.p137a.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.LazyBitmapDrawableResource;
import com.bumptech.glide.util.Preconditions;

public class BitmapDrawableTranscoder implements ResourceTranscoder<Bitmap, BitmapDrawable> {
    private final Resources resources;

    public BitmapDrawableTranscoder(Context context) {
        this(context.getResources());
    }

    @Deprecated
    public BitmapDrawableTranscoder(Resources resources2, BitmapPool eVar) {
        this(resources2);
    }

    public BitmapDrawableTranscoder(Resources resources2) {
        this.resources = (Resources) Preconditions.m6138a(resources2);
    }

    public Resource<BitmapDrawable> transcode(Resource<Bitmap> uVar, Options fVar) {
        return LazyBitmapDrawableResource.obtain(this.resources, uVar);
    }
}
