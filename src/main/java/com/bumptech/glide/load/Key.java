package com.bumptech.glide.load;

import java.nio.charset.Charset;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.load.c */
public interface Key {
    /* renamed from: a */
    public static final Charset f4426a = Charset.forName("UTF-8");

    boolean equals(Object obj);

    int hashCode();

    void updateDiskCacheKey(MessageDigest messageDigest);
}
