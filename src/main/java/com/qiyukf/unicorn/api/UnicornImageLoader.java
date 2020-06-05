package com.qiyukf.unicorn.api;

import android.graphics.Bitmap;

public interface UnicornImageLoader {
    void loadImage(String str, int i, int i2, ImageLoaderListener imageLoaderListener);

    Bitmap loadImageSync(String str, int i, int i2);
}
