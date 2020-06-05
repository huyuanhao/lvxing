package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.load.engine.d */
final class DataCacheKey implements Key {
    /* renamed from: b */
    private final Key f4557b;
    /* renamed from: c */
    private final Key f4558c;

    DataCacheKey(Key cVar, Key cVar2) {
        this.f4557b = cVar;
        this.f4558c = cVar2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DataCacheKey)) {
            return false;
        }
        DataCacheKey dVar = (DataCacheKey) obj;
        if (!this.f4557b.equals(dVar.f4557b) || !this.f4558c.equals(dVar.f4558c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f4557b.hashCode() * 31) + this.f4558c.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DataCacheKey{sourceKey=");
        sb.append(this.f4557b);
        sb.append(", signature=");
        sb.append(this.f4558c);
        sb.append('}');
        return sb.toString();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.f4557b.updateDiskCacheKey(messageDigest);
        this.f4558c.updateDiskCacheKey(messageDigest);
    }
}
