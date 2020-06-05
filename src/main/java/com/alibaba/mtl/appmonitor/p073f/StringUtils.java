package com.alibaba.mtl.appmonitor.p073f;

/* renamed from: com.alibaba.mtl.appmonitor.f.b */
public class StringUtils {
    /* renamed from: a */
    public static boolean m3589a(String str) {
        return !m3590b(str);
    }

    /* renamed from: b */
    public static boolean m3590b(String str) {
        if (str != null) {
            int length = str.length();
            if (length != 0) {
                for (int i = 0; i < length; i++) {
                    if (!Character.isWhitespace(str.charAt(i))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
