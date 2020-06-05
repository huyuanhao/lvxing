package com.ali.auth.third.core.util;

import java.io.Closeable;

/* renamed from: com.ali.auth.third.core.util.c */
public class C1038c {
    /* renamed from: a */
    private static final String f2084a = C1038c.class.getSimpleName();

    /* renamed from: a */
    public static void m1988a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }
}
