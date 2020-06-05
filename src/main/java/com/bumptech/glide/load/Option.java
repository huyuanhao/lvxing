package com.bumptech.glide.load;

import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.load.e */
public final class Option<T> {
    /* renamed from: a */
    private static final C1631a<Object> f4428a = new C1631a<Object>() {
        public void update(byte[] bArr, Object obj, MessageDigest messageDigest) {
        }
    };
    /* renamed from: b */
    private final T f4429b;
    /* renamed from: c */
    private final C1631a<T> f4430c;
    /* renamed from: d */
    private final String f4431d;
    /* renamed from: e */
    private volatile byte[] f4432e;

    /* compiled from: Option */
    /* renamed from: com.bumptech.glide.load.e$a */
    public interface C1631a<T> {
        void update(byte[] bArr, T t, MessageDigest messageDigest);
    }

    /* renamed from: a */
    public static <T> Option<T> m5383a(String str) {
        return new Option<>(str, null, m5387c());
    }

    /* renamed from: a */
    public static <T> Option<T> m5384a(String str, T t) {
        return new Option<>(str, t, m5387c());
    }

    /* renamed from: a */
    public static <T> Option<T> m5385a(String str, T t, C1631a<T> aVar) {
        return new Option<>(str, t, aVar);
    }

    private Option(String str, T t, C1631a<T> aVar) {
        this.f4431d = Preconditions.m6140a(str);
        this.f4429b = t;
        this.f4430c = (C1631a) Preconditions.m6138a(aVar);
    }

    /* renamed from: a */
    public T mo12666a() {
        return this.f4429b;
    }

    /* renamed from: a */
    public void mo12667a(T t, MessageDigest messageDigest) {
        this.f4430c.update(m5386b(), t, messageDigest);
    }

    /* renamed from: b */
    private byte[] m5386b() {
        if (this.f4432e == null) {
            this.f4432e = this.f4431d.getBytes(Key.f4426a);
        }
        return this.f4432e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Option)) {
            return false;
        }
        return this.f4431d.equals(((Option) obj).f4431d);
    }

    public int hashCode() {
        return this.f4431d.hashCode();
    }

    /* renamed from: c */
    private static <T> C1631a<T> m5387c() {
        return f4428a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Option{key='");
        sb.append(this.f4431d);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
