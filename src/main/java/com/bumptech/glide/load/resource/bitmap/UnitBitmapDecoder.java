package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.C1772j;

public final class UnitBitmapDecoder implements ResourceDecoder<Bitmap, Bitmap> {

    /* renamed from: com.bumptech.glide.load.resource.bitmap.UnitBitmapDecoder$NonOwnedBitmapResource */
    private static final class NonOwnedBitmapResource implements Resource<Bitmap> {
        private final Bitmap bitmap;

        public void recycle() {
        }

        NonOwnedBitmapResource(Bitmap bitmap2) {
            this.bitmap = bitmap2;
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
    }

    public boolean handles(Bitmap bitmap, Options fVar) {
        return true;
    }

    public Resource<Bitmap> decode(Bitmap bitmap, int i, int i2, Options fVar) {
        return new NonOwnedBitmapResource(bitmap);
    }
}
