package com.bumptech.glide.load.engine.p139c;

import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.p137a.BitmapPool;

/* renamed from: com.bumptech.glide.load.engine.c.a */
public final class BitmapPreFiller {
    /* renamed from: a */
    private final MemoryCache f4515a;
    /* renamed from: b */
    private final BitmapPool f4516b;
    /* renamed from: c */
    private final DecodeFormat f4517c;
    /* renamed from: d */
    private final Handler f4518d = new Handler(Looper.getMainLooper());

    public BitmapPreFiller(MemoryCache gVar, BitmapPool eVar, DecodeFormat decodeFormat) {
        this.f4515a = gVar;
        this.f4516b = eVar;
        this.f4517c = decodeFormat;
    }
}
