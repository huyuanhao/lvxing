package com.tencent.android.tpush.common;

import android.os.Build;
import android.text.TextUtils;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.common.d */
public class C6904d {
    /* renamed from: a */
    public static boolean m29466a() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "xiaomi".equals(str.trim().toLowerCase());
    }
}
