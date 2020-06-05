package com.bytedance.embed_device_register;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import android.util.Log;
import java.util.Map;

/* renamed from: com.bytedance.embed_device_register.d */
final class C1781d {

    /* renamed from: com.bytedance.embed_device_register.d$a */
    private static class C1782a implements Runnable {
        /* renamed from: a */
        private final Runnable f4931a;
        /* renamed from: b */
        private final String f4932b;
        /* renamed from: c */
        private final String f4933c = Log.getStackTraceString(new RuntimeException("origin stacktrace"));

        C1782a(Runnable runnable, String str) {
            this.f4931a = runnable;
            this.f4932b = str;
        }

        public void run() {
            try {
                this.f4931a.run();
            } catch (Exception e) {
                e.printStackTrace();
                StringBuilder sb = new StringBuilder();
                sb.append("Thread:");
                sb.append(this.f4932b);
                sb.append(" exception\n");
                sb.append(this.f4933c);
                C1780c.m6177a("TrackerDr", sb.toString(), e);
            }
        }
    }

    /* renamed from: a */
    static boolean m6184a(Context context, String str) {
        try {
            if (context.getPackageManager().getPackageInfo(str, 128) != null) {
                return true;
            }
            return false;
        } catch (NameNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: a */
    static long m6180a(String str, long j) {
        try {
            j = Long.parseLong(str);
            return j;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return j;
        }
    }

    /* renamed from: a */
    static int m6179a(String str, int i) {
        try {
            i = Integer.parseInt(str);
            return i;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return i;
        }
    }

    /* renamed from: a */
    static void m6181a(Runnable runnable) {
        m6182a((String) null, runnable);
    }

    /* renamed from: a */
    static void m6182a(String str, Runnable runnable) {
        if (runnable != null) {
            if (TextUtils.isEmpty(str)) {
                str = "TrackerDr";
            }
            new Thread(new C1782a(runnable, str), str).start();
        }
    }

    /* renamed from: a */
    static <K, V> void m6183a(Map<K, V> map, K k, V v) {
        if (k != null && v != null) {
            map.put(k, v);
        }
    }
}
