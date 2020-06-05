package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import java.io.File;

/* renamed from: com.bumptech.glide.load.engine.cache.a */
public interface DiskCache {

    /* compiled from: DiskCache */
    /* renamed from: com.bumptech.glide.load.engine.cache.a$a */
    public interface C1660a {
        /* renamed from: a */
        DiskCache mo12787a();
    }

    /* compiled from: DiskCache */
    /* renamed from: com.bumptech.glide.load.engine.cache.a$b */
    public interface C1661b {
        /* renamed from: a */
        boolean mo12788a(File file);
    }

    /* renamed from: a */
    File mo12785a(Key cVar);

    /* renamed from: a */
    void mo12786a(Key cVar, C1661b bVar);
}
