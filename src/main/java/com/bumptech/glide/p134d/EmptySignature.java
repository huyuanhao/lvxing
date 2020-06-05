package com.bumptech.glide.p134d;

import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.d.b */
public final class EmptySignature implements Key {
    /* renamed from: b */
    private static final EmptySignature f4260b = new EmptySignature();

    public String toString() {
        return "EmptySignature";
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
    }

    /* renamed from: a */
    public static EmptySignature m5168a() {
        return f4260b;
    }

    private EmptySignature() {
    }
}
