package com.kwad.sdk.core.imageloader.utils;

import android.util.Log;
import com.kwad.sdk.core.imageloader.core.ImageLoader;

/* renamed from: com.kwad.sdk.core.imageloader.utils.L */
public final class C4246L {
    private static final String LOG_FORMAT = "%1$s\n%2$s";
    private static volatile boolean writeDebugLogs = false;
    private static volatile boolean writeLogs = true;

    private C4246L() {
    }

    /* renamed from: d */
    public static void m17479d(String str, Object... objArr) {
        if (writeDebugLogs) {
            log(3, null, str, objArr);
        }
    }

    @Deprecated
    public static void disableLogging() {
        writeLogs(false);
    }

    /* renamed from: e */
    public static void m17480e(String str, Object... objArr) {
        log(6, null, str, objArr);
    }

    /* renamed from: e */
    public static void m17481e(Throwable th) {
        log(6, th, null, new Object[0]);
    }

    /* renamed from: e */
    public static void m17482e(Throwable th, String str, Object... objArr) {
        log(6, th, str, objArr);
    }

    @Deprecated
    public static void enableLogging() {
        writeLogs(true);
    }

    /* renamed from: i */
    public static void m17483i(String str, Object... objArr) {
        log(4, null, str, objArr);
    }

    private static void log(int i, Throwable th, String str, Object... objArr) {
        if (writeLogs) {
            if (objArr.length > 0) {
                str = String.format(str, objArr);
            }
            if (th != null) {
                if (r3 == null) {
                    r3 = th.getMessage();
                }
                r3 = String.format(LOG_FORMAT, new Object[]{r3, Log.getStackTraceString(th)});
            }
            Log.println(i, ImageLoader.TAG, r3);
        }
    }

    /* renamed from: w */
    public static void m17484w(String str, Object... objArr) {
        log(5, null, str, objArr);
    }

    public static void writeDebugLogs(boolean z) {
        writeDebugLogs = z;
    }

    public static void writeLogs(boolean z) {
        writeLogs = z;
    }
}
