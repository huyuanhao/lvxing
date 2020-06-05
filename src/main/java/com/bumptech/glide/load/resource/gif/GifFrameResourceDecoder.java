package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.p137a.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;

public final class GifFrameResourceDecoder implements ResourceDecoder<GifDecoder, Bitmap> {
    private final BitmapPool bitmapPool;

    public boolean handles(GifDecoder gifDecoder, Options fVar) {
        return true;
    }

    public GifFrameResourceDecoder(BitmapPool eVar) {
        this.bitmapPool = eVar;
    }

    public Resource<Bitmap> decode(GifDecoder gifDecoder, int i, int i2, Options fVar) {
        return BitmapResource.obtain(gifDecoder.mo12563i(), this.bitmapPool);
    }
}
