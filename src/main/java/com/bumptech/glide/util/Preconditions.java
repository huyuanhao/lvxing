package com.bumptech.glide.util;

import android.text.TextUtils;
import java.util.Collection;

/* renamed from: com.bumptech.glide.util.i */
public final class Preconditions {
    /* renamed from: a */
    public static void m6142a(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    /* renamed from: a */
    public static <T> T m6138a(T t) {
        return m6139a(t, "Argument must not be null");
    }

    /* renamed from: a */
    public static <T> T m6139a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* renamed from: a */
    public static String m6140a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException("Must not be null or empty");
    }

    /* renamed from: a */
    public static <T extends Collection<Y>, Y> T m6141a(T t) {
        if (!t.isEmpty()) {
            return t;
        }
        throw new IllegalArgumentException("Must not be empty.");
    }
}
