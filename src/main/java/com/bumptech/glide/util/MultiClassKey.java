package com.bumptech.glide.util;

/* renamed from: com.bumptech.glide.util.h */
public class MultiClassKey {
    /* renamed from: a */
    private Class<?> f4919a;
    /* renamed from: b */
    private Class<?> f4920b;
    /* renamed from: c */
    private Class<?> f4921c;

    public MultiClassKey() {
    }

    public MultiClassKey(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        mo13238a(cls, cls2, cls3);
    }

    /* renamed from: a */
    public void mo13238a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        this.f4919a = cls;
        this.f4920b = cls2;
        this.f4921c = cls3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MultiClassKey{first=");
        sb.append(this.f4919a);
        sb.append(", second=");
        sb.append(this.f4920b);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MultiClassKey hVar = (MultiClassKey) obj;
        return this.f4919a.equals(hVar.f4919a) && this.f4920b.equals(hVar.f4920b) && C1772j.m6156a((Object) this.f4921c, (Object) hVar.f4921c);
    }

    public int hashCode() {
        int hashCode = ((this.f4919a.hashCode() * 31) + this.f4920b.hashCode()) * 31;
        Class<?> cls = this.f4921c;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }
}
