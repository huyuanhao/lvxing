package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.p137a.BitmapPool;
import com.bumptech.glide.util.C1772j;
import com.bumptech.glide.util.Preconditions;

public class BitmapResource implements Initializable, Resource<Bitmap> {
    private final Bitmap bitmap;
    private final BitmapPool bitmapPool;

    public static BitmapResource obtain(Bitmap bitmap2, BitmapPool eVar) {
        if (bitmap2 == null) {
            return null;
        }
        return new BitmapResource(bitmap2, eVar);
    }

    public BitmapResource(Bitmap bitmap2, BitmapPool eVar) {
        this.bitmap = (Bitmap) Preconditions.m6139a(bitmap2, "Bitmap must not be null");
        this.bitmapPool = (BitmapPool) Preconditions.m6139a(eVar, "BitmapPool must not be null");
    }

    public Class<Bitmap> getResourceClass() {
        return Bitmap.class;
    }

    public Bitmap get() {
        return this.bitmap;
    }

    public int getSize() {
        return C1772j.m6147a(this.bitmap);
    }

    public void recycle() {
        this.bitmapPool.put(this.bitmap);
    }

    public void initialize() {
        this.bitmap.prepareToDraw();
    }
}
