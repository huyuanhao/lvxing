package com.tencent.p605ep.commonbase.api;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

/* renamed from: com.tencent.ep.commonbase.api.Log */
public final class Log {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final String DEBUG_FILE_NAME = "/sdcard/ep_debug";
    public static final int ERROR = 6;
    public static final int FILE = 10;
    public static final int INFO = 4;
    public static final String TAG = "ep-commonbase";
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    /* renamed from: a */
    private static final boolean f24714a = false;
    /* renamed from: b */
    private static final String f24715b = "async";
    /* renamed from: c */
    private static boolean f24716c = false;
    /* renamed from: d */
    private static AbstractLog f24717d = new NullLogImpl();

    /* renamed from: a */
    private static String m31476a(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj instanceof String ? (String) obj : obj instanceof Throwable ? getStackTraceString((Throwable) obj) : obj.toString();
    }

    /* renamed from: d */
    public static void m31477d(String str, Object obj) {
        f24717d.mo35332d(str, m31476a(obj));
    }

    /* renamed from: d */
    public static void m31478d(String str, Object obj, Throwable th) {
        f24717d.mo35333d(str, m31476a(obj), th);
    }

    /* renamed from: e */
    public static void m31479e(String str, Object obj) {
        f24717d.mo35334e(str, m31476a(obj));
    }

    /* renamed from: e */
    public static void m31480e(String str, Object obj, Throwable th) {
        f24717d.mo35335e(str, m31476a(obj), th);
    }

    /* renamed from: f */
    public static void m31481f(String str, Object obj) {
        if (!f24715b.equals(str)) {
            f24717d.mo35336f(str, m31476a(obj));
        }
    }

    /* renamed from: f */
    public static void m31482f(String str, Object obj, Throwable th) {
        f24717d.mo35337f(str, m31476a(obj), th);
    }

    public static String getStackTraceString(Throwable th) {
        if (th == null) {
            return "(Null stack trace)";
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        String stringWriter2 = stringWriter.toString();
        printWriter.close();
        return stringWriter2;
    }

    /* renamed from: i */
    public static void m31483i(String str, Object obj) {
        f24717d.mo35338i(str, m31476a(obj));
    }

    /* renamed from: i */
    public static void m31484i(String str, Object obj, Throwable th) {
        f24717d.mo35339i(str, m31476a(obj), th);
    }

    public static boolean isEnable() {
        return f24716c;
    }

    public static void println(int i, String str, String str2) {
        f24717d.println(i, str, str2);
    }

    public static void setLogEnable(boolean z) {
        f24716c = z;
        f24717d = f24716c ? new LogImpl() : new NullLogImpl();
    }

    public static void setLogImpl(AbstractLog abstractLog) {
        if (f24716c) {
            f24717d = abstractLog;
        }
    }

    /* renamed from: v */
    public static void m31485v(String str, Object obj) {
        f24717d.mo35341v(str, m31476a(obj));
    }

    /* renamed from: v */
    public static void m31486v(String str, Object obj, Throwable th) {
        f24717d.mo35342v(str, m31476a(obj), th);
    }

    /* renamed from: w */
    public static void m31487w(String str, Object obj) {
        f24717d.mo35343w(str, m31476a(obj));
    }

    /* renamed from: w */
    public static void m31488w(String str, Object obj, Throwable th) {
        f24717d.mo35344w(str, m31476a(obj), th);
    }

    public static void writeLog(File file, String str) {
        f24717d.writeLog(file, str);
    }

    public static void writeLog(String str) {
        f24717d.writeLog(new File(DEBUG_FILE_NAME), str);
    }
}
