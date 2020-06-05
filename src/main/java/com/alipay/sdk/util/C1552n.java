package com.alipay.sdk.util;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.app.EnvUtils;
import com.alipay.sdk.p120a.C1489a;

/* renamed from: com.alipay.sdk.util.n */
public class C1552n {
    /* renamed from: a */
    public static String m4664a(Context context) {
        if (EnvUtils.m4395a()) {
            return "https://mobilegw.alipaydev.com/mgw.htm";
        }
        if (context == null) {
            return C1489a.f3786a;
        }
        String str = C1489a.f3786a;
        if (TextUtils.isEmpty(str)) {
            str = C1489a.f3786a;
        }
        return str;
    }
}
