package com.tencent.p607mm.opensdk.utils;

/* renamed from: com.tencent.mm.opensdk.utils.d */
public final class C7339d {
    /* renamed from: a */
    public static boolean m31635a(int i) {
        return i == 36 || i == 46;
    }

    /* renamed from: b */
    public static boolean m31636b(String str) {
        return str == null || str.length() <= 0;
    }

    /* renamed from: c */
    public static int m31637c(String str) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    return Integer.parseInt(str);
                }
            } catch (Exception unused) {
            }
        }
        return 0;
    }
}
