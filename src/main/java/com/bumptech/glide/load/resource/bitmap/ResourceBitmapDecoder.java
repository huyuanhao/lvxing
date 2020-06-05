package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.p137a.BitmapPool;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;

public class ResourceBitmapDecoder implements ResourceDecoder<Uri, Bitmap> {
    private final BitmapPool bitmapPool;
    private final ResourceDrawableDecoder drawableDecoder;

    public ResourceBitmapDecoder(ResourceDrawableDecoder resourceDrawableDecoder, BitmapPool eVar) {
        this.drawableDecoder = resourceDrawableDecoder;
        this.bitmapPool = eVar;
    }

    public boolean handles(Uri uri, Options fVar) {
        return "android.resource".equals(uri.getScheme());
    }

    public Resource<Bitmap> decode(Uri uri, int i, int i2, Options fVar) {
        Resource decode = this.drawableDecoder.decode(uri, i, i2, fVar);
        if (decode == null) {
            return null;
        }
        return DrawableToBitmapConverter.convert(this.bitmapPool, (Drawable) decode.get(), i, i2);
    }
}
