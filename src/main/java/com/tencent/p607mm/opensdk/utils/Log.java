package com.tencent.p607mm.opensdk.utils;

/* renamed from: com.tencent.mm.opensdk.utils.Log */
public class Log {
    private static ILog logImpl;

    /* renamed from: d */
    public static void m31626d(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog == null) {
            android.util.Log.d(str, str2);
        } else {
            iLog.mo35799d(str, str2);
        }
    }

    /* renamed from: e */
    public static void m31627e(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog == null) {
            android.util.Log.e(str, str2);
        } else {
            iLog.mo35800e(str, str2);
        }
    }

    /* renamed from: i */
    public static void m31628i(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog == null) {
            android.util.Log.i(str, str2);
        } else {
            iLog.mo35801i(str, str2);
        }
    }

    public static void setLogImpl(ILog iLog) {
        logImpl = iLog;
    }

    /* renamed from: v */
    public static void m31629v(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog == null) {
            android.util.Log.v(str, str2);
        } else {
            iLog.mo35802v(str, str2);
        }
    }

    /* renamed from: w */
    public static void m31630w(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog == null) {
            android.util.Log.w(str, str2);
        } else {
            iLog.mo35803w(str, str2);
        }
    }
}
