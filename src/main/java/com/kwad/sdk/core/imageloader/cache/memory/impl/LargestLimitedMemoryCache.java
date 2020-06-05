package com.kwad.sdk.core.imageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.kwad.sdk.core.imageloader.cache.memory.LimitedMemoryCache;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LargestLimitedMemoryCache extends LimitedMemoryCache {
    private final Map<Bitmap, Integer> valueSizes = Collections.synchronizedMap(new HashMap());

    public LargestLimitedMemoryCache(int i) {
        super(i);
    }

    public void clear() {
        this.valueSizes.clear();
        super.clear();
    }

    /* access modifiers changed from: protected */
    public Reference<Bitmap> createReference(Bitmap bitmap) {
        return new WeakReference(bitmap);
    }

    /* access modifiers changed from: protected */
    public int getSize(Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    public boolean put(String str, Bitmap bitmap) {
        if (!super.put(str, bitmap)) {
            return false;
        }
        this.valueSizes.put(bitmap, Integer.valueOf(getSize(bitmap)));
        return true;
    }

    public Bitmap remove(String str) {
        Bitmap bitmap = super.get(str);
        if (bitmap != null) {
            this.valueSizes.remove(bitmap);
        }
        return super.remove(str);
    }

    /* access modifiers changed from: protected */
    public Bitmap removeNext() {
        Bitmap bitmap;
        Set<Entry> entrySet = this.valueSizes.entrySet();
        synchronized (this.valueSizes) {
            bitmap = null;
            Integer num = null;
            for (Entry entry : entrySet) {
                if (bitmap == null) {
                    bitmap = (Bitmap) entry.getKey();
                    num = (Integer) entry.getValue();
                } else {
                    Integer num2 = (Integer) entry.getValue();
                    if (num2.intValue() > num.intValue()) {
                        bitmap = (Bitmap) entry.getKey();
                        num = num2;
                    }
                }
            }
        }
        this.valueSizes.remove(bitmap);
        return bitmap;
    }
}
