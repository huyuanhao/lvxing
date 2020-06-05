package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.p137a.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;

public class BitmapDrawableDecoder<DataType> implements ResourceDecoder<DataType, BitmapDrawable> {
    private final ResourceDecoder<DataType, Bitmap> decoder;
    private final Resources resources;

    public BitmapDrawableDecoder(Context context, ResourceDecoder<DataType, Bitmap> gVar) {
        this(context.getResources(), gVar);
    }

    @Deprecated
    public BitmapDrawableDecoder(Resources resources2, BitmapPool eVar, ResourceDecoder<DataType, Bitmap> gVar) {
        this(resources2, gVar);
    }

    public BitmapDrawableDecoder(Resources resources2, ResourceDecoder<DataType, Bitmap> gVar) {
        this.resources = (Resources) Preconditions.m6138a(resources2);
        this.decoder = (ResourceDecoder) Preconditions.m6138a(gVar);
    }

    public boolean handles(DataType datatype, Options fVar) throws IOException {
        return this.decoder.handles(datatype, fVar);
    }

    public Resource<BitmapDrawable> decode(DataType datatype, int i, int i2, Options fVar) throws IOException {
        return LazyBitmapDrawableResource.obtain(this.resources, this.decoder.decode(datatype, i, i2, fVar));
    }
}
