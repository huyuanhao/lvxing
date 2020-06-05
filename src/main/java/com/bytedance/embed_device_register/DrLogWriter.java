package com.bytedance.embed_device_register;

import android.util.Log;

interface DrLogWriter {

    /* renamed from: com.bytedance.embed_device_register.DrLogWriter$a */
    public static class C1777a implements DrLogWriter {
        public void logV(String str, String str2, Throwable th) {
            Log.v(str, str2, th);
        }

        public void logD(String str, String str2, Throwable th) {
            Log.d(str, str2, th);
        }

        public void logI(String str, String str2, Throwable th) {
            Log.i(str, str2, th);
        }

        public void logE(String str, String str2, Throwable th) {
            Log.e(str, str2, th);
        }

        public void logW(String str, String str2, Throwable th) {
            Log.w(str, str2, th);
        }
    }

    void logD(String str, String str2, Throwable th);

    void logE(String str, String str2, Throwable th);

    void logI(String str, String str2, Throwable th);

    void logV(String str, String str2, Throwable th);

    void logW(String str, String str2, Throwable th);
}
