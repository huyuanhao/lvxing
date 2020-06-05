package com.bumptech.glide.p134d;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.d.c */
public final class ObjectKey implements Key {
    /* renamed from: b */
    private final Object f4261b;

    public ObjectKey(Object obj) {
        this.f4261b = Preconditions.m6138a(obj);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ObjectKey{object=");
        sb.append(this.f4261b);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ObjectKey)) {
            return false;
        }
        return this.f4261b.equals(((ObjectKey) obj).f4261b);
    }

    public int hashCode() {
        return this.f4261b.hashCode();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(this.f4261b.toString().getBytes(f4426a));
    }
}
