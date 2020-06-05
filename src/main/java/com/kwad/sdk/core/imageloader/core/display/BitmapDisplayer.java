package com.kwad.sdk.core.imageloader.core.display;

import android.graphics.Bitmap;
import com.kwad.sdk.core.imageloader.core.assist.LoadedFrom;
import com.kwad.sdk.core.imageloader.core.imageaware.ImageAware;

public interface BitmapDisplayer {
    void display(Bitmap bitmap, ImageAware imageAware, LoadedFrom loadedFrom);
}
