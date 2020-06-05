package com.kwad.sdk.core.imageloader.core.decode;

import android.graphics.Bitmap;

public interface ImageDecoder {
    Bitmap decode(ImageDecodingInfo imageDecodingInfo);
}
