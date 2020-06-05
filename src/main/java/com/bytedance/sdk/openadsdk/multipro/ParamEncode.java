package com.bytedance.sdk.openadsdk.multipro;

import android.text.TextUtils;
import android.util.Base64;

/* renamed from: com.bytedance.sdk.openadsdk.multipro.c */
public class ParamEncode {
    /* renamed from: a */
    public static String m11819a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return Base64.encodeToString(str.getBytes(), 10);
    }

    /* renamed from: b */
    public static String m11820b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return new String(Base64.decode(str, 10));
    }
}
