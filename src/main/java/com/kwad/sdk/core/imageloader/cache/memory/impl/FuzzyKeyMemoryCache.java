package com.kwad.sdk.core.imageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.kwad.sdk.core.imageloader.cache.memory.MemoryCache;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public class FuzzyKeyMemoryCache implements MemoryCache {
    private final MemoryCache cache;
    private final Comparator<String> keyComparator;

    public FuzzyKeyMemoryCache(MemoryCache memoryCache, Comparator<String> comparator) {
        this.cache = memoryCache;
        this.keyComparator = comparator;
    }

    public void clear() {
        this.cache.clear();
    }

    public Bitmap get(String str) {
        return this.cache.get(str);
    }

    public Collection<String> keys() {
        return this.cache.keys();
    }

    public boolean put(String str, Bitmap bitmap) {
        synchronized (this.cache) {
            String str2 = null;
            Iterator it = this.cache.keys().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String str3 = (String) it.next();
                if (this.keyComparator.compare(str, str3) == 0) {
                    str2 = str3;
                    break;
                }
            }
            if (str2 != null) {
                this.cache.remove(str2);
            }
        }
        return this.cache.put(str, bitmap);
    }

    public Bitmap remove(String str) {
        return this.cache.remove(str);
    }
}
