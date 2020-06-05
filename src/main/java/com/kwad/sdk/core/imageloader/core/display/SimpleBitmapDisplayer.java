package com.kwad.sdk.core.imageloader.core.display;

import android.graphics.Bitmap;
import com.kwad.sdk.core.imageloader.core.assist.LoadedFrom;
import com.kwad.sdk.core.imageloader.core.imageaware.ImageAware;

public final class SimpleBitmapDisplayer implements BitmapDisplayer {
    public void display(Bitmap bitmap, ImageAware imageAware, LoadedFrom loadedFrom) {
        imageAware.setImageBitmap(bitmap);
    }
}
