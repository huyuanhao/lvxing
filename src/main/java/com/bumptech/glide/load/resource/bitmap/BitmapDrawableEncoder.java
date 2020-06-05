package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.p137a.BitmapPool;
import java.io.File;

public class BitmapDrawableEncoder implements ResourceEncoder<BitmapDrawable> {
    private final BitmapPool bitmapPool;
    private final ResourceEncoder<Bitmap> encoder;

    public BitmapDrawableEncoder(BitmapPool eVar, ResourceEncoder<Bitmap> hVar) {
        this.bitmapPool = eVar;
        this.encoder = hVar;
    }

    public boolean encode(Resource<BitmapDrawable> uVar, File file, Options fVar) {
        return this.encoder.encode(new BitmapResource(((BitmapDrawable) uVar.get()).getBitmap(), this.bitmapPool), file, fVar);
    }

    public EncodeStrategy getEncodeStrategy(Options fVar) {
        return this.encoder.getEncodeStrategy(fVar);
    }
}
