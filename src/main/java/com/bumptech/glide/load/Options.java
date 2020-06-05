package com.bumptech.glide.load;

import androidx.collection.ArrayMap;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.load.f */
public final class Options implements Key {
    /* renamed from: b */
    private final ArrayMap<Option<?>, Object> f4745b = new CachedHashCodeArrayMap();

    /* renamed from: a */
    public void mo12920a(Options fVar) {
        this.f4745b.putAll(fVar.f4745b);
    }

    /* renamed from: a */
    public <T> Options mo12918a(Option<T> eVar, T t) {
        this.f4745b.put(eVar, t);
        return this;
    }

    /* renamed from: a */
    public <T> T mo12919a(Option<T> eVar) {
        return this.f4745b.containsKey(eVar) ? this.f4745b.get(eVar) : eVar.mo12666a();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Options)) {
            return false;
        }
        return this.f4745b.equals(((Options) obj).f4745b);
    }

    public int hashCode() {
        return this.f4745b.hashCode();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        for (int i = 0; i < this.f4745b.size(); i++) {
            m5760a((Option) this.f4745b.keyAt(i), this.f4745b.valueAt(i), messageDigest);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Options{values=");
        sb.append(this.f4745b);
        sb.append('}');
        return sb.toString();
    }

    /* renamed from: a */
    private static <T> void m5760a(Option<T> eVar, Object obj, MessageDigest messageDigest) {
        eVar.mo12667a(obj, messageDigest);
    }
}
