package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.p137a.ArrayPool;
import com.bumptech.glide.util.C1772j;
import com.bumptech.glide.util.LruCache;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.load.engine.w */
final class ResourceCacheKey implements Key {
    /* renamed from: b */
    private static final LruCache<Class<?>, byte[]> f4727b = new LruCache<>(50);
    /* renamed from: c */
    private final ArrayPool f4728c;
    /* renamed from: d */
    private final Key f4729d;
    /* renamed from: e */
    private final Key f4730e;
    /* renamed from: f */
    private final int f4731f;
    /* renamed from: g */
    private final int f4732g;
    /* renamed from: h */
    private final Class<?> f4733h;
    /* renamed from: i */
    private final Options f4734i;
    /* renamed from: j */
    private final Transformation<?> f4735j;

    ResourceCacheKey(ArrayPool bVar, Key cVar, Key cVar2, int i, int i2, Transformation<?> iVar, Class<?> cls, Options fVar) {
        this.f4728c = bVar;
        this.f4729d = cVar;
        this.f4730e = cVar2;
        this.f4731f = i;
        this.f4732g = i2;
        this.f4735j = iVar;
        this.f4733h = cls;
        this.f4734i = fVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ResourceCacheKey)) {
            return false;
        }
        ResourceCacheKey wVar = (ResourceCacheKey) obj;
        if (this.f4732g != wVar.f4732g || this.f4731f != wVar.f4731f || !C1772j.m6156a((Object) this.f4735j, (Object) wVar.f4735j) || !this.f4733h.equals(wVar.f4733h) || !this.f4729d.equals(wVar.f4729d) || !this.f4730e.equals(wVar.f4730e) || !this.f4734i.equals(wVar.f4734i)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = (((((this.f4729d.hashCode() * 31) + this.f4730e.hashCode()) * 31) + this.f4731f) * 31) + this.f4732g;
        Transformation<?> iVar = this.f4735j;
        if (iVar != null) {
            hashCode = (hashCode * 31) + iVar.hashCode();
        }
        return (((hashCode * 31) + this.f4733h.hashCode()) * 31) + this.f4734i.hashCode();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f4728c.mo12706b(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f4731f).putInt(this.f4732g).array();
        this.f4730e.updateDiskCacheKey(messageDigest);
        this.f4729d.updateDiskCacheKey(messageDigest);
        messageDigest.update(bArr);
        Transformation<?> iVar = this.f4735j;
        if (iVar != null) {
            iVar.updateDiskCacheKey(messageDigest);
        }
        this.f4734i.updateDiskCacheKey(messageDigest);
        messageDigest.update(m5749a());
        this.f4728c.mo12705a(bArr);
    }

    /* renamed from: a */
    private byte[] m5749a() {
        byte[] bArr = (byte[]) f4727b.mo13229b(this.f4733h);
        if (bArr != null) {
            return bArr;
        }
        byte[] bytes = this.f4733h.getName().getBytes(f4426a);
        f4727b.mo13230b(this.f4733h, bytes);
        return bytes;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ResourceCacheKey{sourceKey=");
        sb.append(this.f4729d);
        sb.append(", signature=");
        sb.append(this.f4730e);
        sb.append(", width=");
        sb.append(this.f4731f);
        sb.append(", height=");
        sb.append(this.f4732g);
        sb.append(", decodedResourceClass=");
        sb.append(this.f4733h);
        sb.append(", transformation='");
        sb.append(this.f4735j);
        sb.append('\'');
        sb.append(", options=");
        sb.append(this.f4734i);
        sb.append('}');
        return sb.toString();
    }
}
