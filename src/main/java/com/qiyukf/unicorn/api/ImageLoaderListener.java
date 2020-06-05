package com.qiyukf.unicorn.api;

import android.graphics.Bitmap;
import java.io.Serializable;

public interface ImageLoaderListener extends Serializable {
    void onLoadComplete(Bitmap bitmap);

    void onLoadFailed(Throwable th);
}
