package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;
import java.util.Map;

/* renamed from: com.bumptech.glide.load.engine.n */
class EngineKey implements Key {
    /* renamed from: b */
    private final Object f4690b;
    /* renamed from: c */
    private final int f4691c;
    /* renamed from: d */
    private final int f4692d;
    /* renamed from: e */
    private final Class<?> f4693e;
    /* renamed from: f */
    private final Class<?> f4694f;
    /* renamed from: g */
    private final Key f4695g;
    /* renamed from: h */
    private final Map<Class<?>, Transformation<?>> f4696h;
    /* renamed from: i */
    private final Options f4697i;
    /* renamed from: j */
    private int f4698j;

    EngineKey(Object obj, Key cVar, int i, int i2, Map<Class<?>, Transformation<?>> map, Class<?> cls, Class<?> cls2, Options fVar) {
        this.f4690b = Preconditions.m6138a(obj);
        this.f4695g = (Key) Preconditions.m6139a(cVar, "Signature must not be null");
        this.f4691c = i;
        this.f4692d = i2;
        this.f4696h = (Map) Preconditions.m6138a(map);
        this.f4693e = (Class) Preconditions.m6139a(cls, "Resource class must not be null");
        this.f4694f = (Class) Preconditions.m6139a(cls2, "Transcode class must not be null");
        this.f4697i = (Options) Preconditions.m6138a(fVar);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof EngineKey)) {
            return false;
        }
        EngineKey nVar = (EngineKey) obj;
        if (!this.f4690b.equals(nVar.f4690b) || !this.f4695g.equals(nVar.f4695g) || this.f4692d != nVar.f4692d || this.f4691c != nVar.f4691c || !this.f4696h.equals(nVar.f4696h) || !this.f4693e.equals(nVar.f4693e) || !this.f4694f.equals(nVar.f4694f) || !this.f4697i.equals(nVar.f4697i)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        if (this.f4698j == 0) {
            this.f4698j = this.f4690b.hashCode();
            this.f4698j = (this.f4698j * 31) + this.f4695g.hashCode();
            this.f4698j = (this.f4698j * 31) + this.f4691c;
            this.f4698j = (this.f4698j * 31) + this.f4692d;
            this.f4698j = (this.f4698j * 31) + this.f4696h.hashCode();
            this.f4698j = (this.f4698j * 31) + this.f4693e.hashCode();
            this.f4698j = (this.f4698j * 31) + this.f4694f.hashCode();
            this.f4698j = (this.f4698j * 31) + this.f4697i.hashCode();
        }
        return this.f4698j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EngineKey{model=");
        sb.append(this.f4690b);
        sb.append(", width=");
        sb.append(this.f4691c);
        sb.append(", height=");
        sb.append(this.f4692d);
        sb.append(", resourceClass=");
        sb.append(this.f4693e);
        sb.append(", transcodeClass=");
        sb.append(this.f4694f);
        sb.append(", signature=");
        sb.append(this.f4695g);
        sb.append(", hashCode=");
        sb.append(this.f4698j);
        sb.append(", transformations=");
        sb.append(this.f4696h);
        sb.append(", options=");
        sb.append(this.f4697i);
        sb.append('}');
        return sb.toString();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }
}
