package com.kwad.sdk.core.imageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.kwad.sdk.core.imageloader.cache.memory.BaseMemoryCache;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public class WeakMemoryCache extends BaseMemoryCache {
    /* access modifiers changed from: protected */
    public Reference<Bitmap> createReference(Bitmap bitmap) {
        return new WeakReference(bitmap);
    }
}
