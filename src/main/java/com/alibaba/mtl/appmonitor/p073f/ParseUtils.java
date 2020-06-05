package com.alibaba.mtl.appmonitor.p073f;

/* renamed from: com.alibaba.mtl.appmonitor.f.a */
public class ParseUtils {
    /* renamed from: a */
    public static int m3588a(String str) {
        if (StringUtils.m3589a(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
            }
        }
        return 0;
    }
}
