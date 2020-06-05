package com.tencent.p605ep.commonbase.utils;

import java.io.UnsupportedEncodingException;

/* renamed from: com.tencent.ep.commonbase.utils.StringUtil */
public class StringUtil {
    public static String assertNotNullString(String str) {
        return str == null ? "" : str;
    }

    public static byte[] getBytes(String str) {
        try {
            return str.getBytes("iso-8859-1");
        } catch (UnsupportedEncodingException unused) {
            return new byte[0];
        }
    }

    public static boolean isStringEmpty(String str) {
        return str == null || str.equals("");
    }

    public static boolean isStringNotEmpty(String str) {
        return str != null && !str.equals("");
    }
}
