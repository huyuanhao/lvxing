package com.kwad.sdk.core.imageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.kwad.sdk.core.imageloader.cache.memory.MemoryCache;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class LruMemoryCache implements MemoryCache {
    private final LinkedHashMap<String, Bitmap> map;
    private final int maxSize;
    private int size;

    public LruMemoryCache(int i) {
        if (i > 0) {
            this.maxSize = i;
            this.map = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private int sizeOf(String str, Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006d, code lost:
            throw new java.lang.IllegalStateException(r0.toString());
     */
    private void trimToSize(int r4) {
        /*
        r3 = this;
    L_0x0000:
        monitor-enter(r3)
        int r0 = r3.size     // Catch:{ all -> 0x006e }
        if (r0 < 0) goto L_0x004f
        java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.map     // Catch:{ all -> 0x006e }
        boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x006e }
        if (r0 == 0) goto L_0x0011
        int r0 = r3.size     // Catch:{ all -> 0x006e }
        if (r0 != 0) goto L_0x004f
    L_0x0011:
        int r0 = r3.size     // Catch:{ all -> 0x006e }
        if (r0 <= r4) goto L_0x0030
        java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.map     // Catch:{ all -> 0x006e }
        boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x006e }
        if (r0 == 0) goto L_0x001e
        goto L_0x0030
    L_0x001e:
        java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.map     // Catch:{ all -> 0x006e }
        java.util.Set r0 = r0.entrySet()     // Catch:{ all -> 0x006e }
        java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x006e }
        java.lang.Object r0 = r0.next()     // Catch:{ all -> 0x006e }
        java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ all -> 0x006e }
        if (r0 != 0) goto L_0x0032
    L_0x0030:
        monitor-exit(r3)     // Catch:{ all -> 0x006e }
        goto L_0x004e
    L_0x0032:
        java.lang.Object r1 = r0.getKey()     // Catch:{ all -> 0x006e }
        java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x006e }
        java.lang.Object r0 = r0.getValue()     // Catch:{ all -> 0x006e }
        android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0     // Catch:{ all -> 0x006e }
        java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r2 = r3.map     // Catch:{ all -> 0x006e }
        r2.remove(r1)     // Catch:{ all -> 0x006e }
        int r2 = r3.size     // Catch:{ all -> 0x006e }
        int r0 = r3.sizeOf(r1, r0)     // Catch:{ all -> 0x006e }
        int r2 = r2 - r0
        r3.size = r2     // Catch:{ all -> 0x006e }
        monitor-exit(r3)     // Catch:{ all -> 0x006e }
        goto L_0x0000
    L_0x004e:
        return
    L_0x004f:
        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x006e }
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x006e }
        r0.<init>()     // Catch:{ all -> 0x006e }
        java.lang.Class r1 = r3.getClass()     // Catch:{ all -> 0x006e }
        java.lang.String r1 = r1.getName()     // Catch:{ all -> 0x006e }
        r0.append(r1)     // Catch:{ all -> 0x006e }
        java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
        r0.append(r1)     // Catch:{ all -> 0x006e }
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x006e }
        r4.<init>(r0)     // Catch:{ all -> 0x006e }
        throw r4     // Catch:{ all -> 0x006e }
    L_0x006e:
        r4 = move-exception
        monitor-exit(r3)     // Catch:{ all -> 0x006e }
        throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.imageloader.cache.memory.impl.LruMemoryCache.trimToSize(int):void");
    }

    public void clear() {
        trimToSize(-1);
    }

    public final Bitmap get(String str) {
        Bitmap bitmap;
        if (str != null) {
            synchronized (this) {
                bitmap = (Bitmap) this.map.get(str);
            }
            return bitmap;
        }
        throw new NullPointerException("key == null");
    }

    public Collection<String> keys() {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.map.keySet());
        }
        return hashSet;
    }

    public final boolean put(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.size += sizeOf(str, bitmap);
            Bitmap bitmap2 = (Bitmap) this.map.put(str, bitmap);
            if (bitmap2 != null) {
                this.size -= sizeOf(str, bitmap2);
            }
        }
        trimToSize(this.maxSize);
        return true;
    }

    public final Bitmap remove(String str) {
        Bitmap bitmap;
        if (str != null) {
            synchronized (this) {
                bitmap = (Bitmap) this.map.remove(str);
                if (bitmap != null) {
                    this.size -= sizeOf(str, bitmap);
                }
            }
            return bitmap;
        }
        throw new NullPointerException("key == null");
    }

    public final synchronized String toString() {
        return String.format("LruCache[maxSize=%d]", new Object[]{Integer.valueOf(this.maxSize)});
    }
}
