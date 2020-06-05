package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.cache.MemoryCache.C1665a;
import com.bumptech.glide.util.LruCache;

/* renamed from: com.bumptech.glide.load.engine.cache.f */
public class LruResourceCache extends LruCache<Key, Resource<?>> implements MemoryCache {
    /* renamed from: a */
    private C1665a f4551a;

    /* renamed from: a */
    public /* synthetic */ Resource mo12795a(Key cVar) {
        return (Resource) super.mo13231c(cVar);
    }

    /* renamed from: b */
    public /* bridge */ /* synthetic */ Resource mo12800b(Key cVar, Resource uVar) {
        return (Resource) super.mo13230b(cVar, uVar);
    }

    public LruResourceCache(long j) {
        super(j);
    }

    /* renamed from: a */
    public void mo12798a(C1665a aVar) {
        this.f4551a = aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo12799a(Key cVar, Resource<?> uVar) {
        C1665a aVar = this.f4551a;
        if (aVar != null && uVar != null) {
            aVar.mo12802b(uVar);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo12794a(Resource<?> uVar) {
        if (uVar == null) {
            return super.mo12794a(null);
        }
        return uVar.getSize();
    }

    /* renamed from: a */
    public void mo12796a(int i) {
        if (i >= 40) {
            mo13226a();
        } else if (i >= 20 || i == 15) {
            mo13227a(mo13228b() / 2);
        }
    }
}
