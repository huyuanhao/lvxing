package com.kwad.sdk.core.imageloader.cache.memory;

import android.graphics.Bitmap;
import java.lang.ref.Reference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public abstract class BaseMemoryCache implements MemoryCache {
    private final Map<String, Reference<Bitmap>> softMap = Collections.synchronizedMap(new HashMap());

    public void clear() {
        this.softMap.clear();
    }

    public abstract Reference<Bitmap> createReference(Bitmap bitmap);

    public Bitmap get(String str) {
        Reference reference = (Reference) this.softMap.get(str);
        if (reference != null) {
            return (Bitmap) reference.get();
        }
        return null;
    }

    public Collection<String> keys() {
        HashSet hashSet;
        synchronized (this.softMap) {
            hashSet = new HashSet(this.softMap.keySet());
        }
        return hashSet;
    }

    public boolean put(String str, Bitmap bitmap) {
        this.softMap.put(str, createReference(bitmap));
        return true;
    }

    public Bitmap remove(String str) {
        Reference reference = (Reference) this.softMap.remove(str);
        if (reference == null) {
            return null;
        }
        return (Bitmap) reference.get();
    }
}
