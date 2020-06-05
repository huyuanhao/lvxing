package com.bumptech.glide.load.engine.cache;

import androidx.core.util.Pools.Pool;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.C1772j;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.p140a.FactoryPools;
import com.bumptech.glide.util.p140a.FactoryPools.C1764a;
import com.bumptech.glide.util.p140a.FactoryPools.C1766c;
import com.bumptech.glide.util.p140a.StateVerifier;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.bumptech.glide.load.engine.cache.h */
public class SafeKeyGenerator {
    /* renamed from: a */
    private final LruCache<Key, String> f4552a = new LruCache<>(1000);
    /* renamed from: b */
    private final Pool<C1667a> f4553b = FactoryPools.m6095a(10, (C1764a<T>) new C1764a<C1667a>() {
        /* renamed from: a */
        public C1667a mo12521b() {
            try {
                return new C1667a(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    });

    /* compiled from: SafeKeyGenerator */
    /* renamed from: com.bumptech.glide.load.engine.cache.h$a */
    private static final class C1667a implements C1766c {
        /* renamed from: a */
        final MessageDigest f4555a;
        /* renamed from: b */
        private final StateVerifier f4556b = StateVerifier.m6111a();

        C1667a(MessageDigest messageDigest) {
            this.f4555a = messageDigest;
        }

        /* renamed from: d */
        public StateVerifier mo12519d() {
            return this.f4556b;
        }
    }

    /* renamed from: a */
    public String mo12803a(Key cVar) {
        String str;
        synchronized (this.f4552a) {
            str = (String) this.f4552a.mo13229b(cVar);
        }
        if (str == null) {
            str = m5570b(cVar);
        }
        synchronized (this.f4552a) {
            this.f4552a.mo13230b(cVar, str);
        }
        return str;
    }

    /* renamed from: b */
    private String m5570b(Key cVar) {
        C1667a aVar = (C1667a) Preconditions.m6138a(this.f4553b.acquire());
        try {
            cVar.updateDiskCacheKey(aVar.f4555a);
            return C1772j.m6150a(aVar.f4555a.digest());
        } finally {
            this.f4553b.release(aVar);
        }
    }
}
