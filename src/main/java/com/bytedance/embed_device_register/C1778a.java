package com.bytedance.embed_device_register;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.bytedance.embed_device_register.a */
final class C1778a {
    /* renamed from: a */
    private static final AtomicBoolean f4926a = new AtomicBoolean(false);
    /* renamed from: b */
    private static String f4927b = "";

    /* renamed from: a */
    static String m6168a(SharedPreferences sharedPreferences) {
        if (f4926a.compareAndSet(false, true)) {
            String str = "cdid";
            f4927b = sharedPreferences.getString(str, "");
            if (TextUtils.isEmpty(f4927b)) {
                f4927b = UUID.randomUUID().toString();
                sharedPreferences.edit().putString(str, f4927b).apply();
            }
        }
        return f4927b;
    }
}
