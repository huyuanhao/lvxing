package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;

/* renamed from: com.bytedance.sdk.openadsdk.utils.y */
public class Predicate {
    /* renamed from: a */
    public static void m12255a(Object obj, String str) {
        if (obj == null) {
            m12259b(str);
        }
    }

    /* renamed from: a */
    public static void m12257a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            m12259b(str2);
        }
    }

    /* renamed from: a */
    public static void m12258a(boolean z, String str) {
        if (!z) {
            m12259b(str);
        }
    }

    /* renamed from: a */
    public static void m12256a(String str) {
        m12259b(str);
    }

    /* renamed from: a */
    public static void m12254a(Context context, String str) {
        if (!(context instanceof Activity)) {
            m12259b(str);
        }
    }

    /* renamed from: b */
    private static void m12259b(String str) {
        throw new IllegalArgumentException(str);
    }
}
