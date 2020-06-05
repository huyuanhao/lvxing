package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.engine.cache.DiskCache.C1660a;
import java.io.File;

/* renamed from: com.bumptech.glide.load.engine.cache.d */
public class DiskLruCacheFactory implements C1660a {
    /* renamed from: a */
    private final long f4544a;
    /* renamed from: b */
    private final C1664a f4545b;

    /* compiled from: DiskLruCacheFactory */
    /* renamed from: com.bumptech.glide.load.engine.cache.d$a */
    public interface C1664a {
        /* renamed from: a */
        File mo12778a();
    }

    public DiskLruCacheFactory(C1664a aVar, long j) {
        this.f4544a = j;
        this.f4545b = aVar;
    }

    /* renamed from: a */
    public DiskCache mo12787a() {
        File a = this.f4545b.mo12778a();
        if (a == null) {
            return null;
        }
        if (a.mkdirs() || (a.exists() && a.isDirectory())) {
            return DiskLruCacheWrapper.m5553a(a, this.f4544a);
        }
        return null;
    }
}
