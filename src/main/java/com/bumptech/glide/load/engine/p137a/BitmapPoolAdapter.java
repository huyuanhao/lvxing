package com.bumptech.glide.load.engine.p137a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

/* renamed from: com.bumptech.glide.load.engine.a.f */
public class BitmapPoolAdapter implements BitmapPool {
    public void clearMemory() {
    }

    public long getMaxSize() {
        return 0;
    }

    public void setSizeMultiplier(float f) {
    }

    public void trimMemory(int i) {
    }

    public void put(Bitmap bitmap) {
        bitmap.recycle();
    }

    public Bitmap get(int i, int i2, Config config) {
        return Bitmap.createBitmap(i, i2, config);
    }

    public Bitmap getDirty(int i, int i2, Config config) {
        return get(i, i2, config);
    }
}
