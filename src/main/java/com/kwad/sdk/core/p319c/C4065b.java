package com.kwad.sdk.core.p319c;

import android.content.Context;
import android.util.Log;
import androidx.core.p003os.EnvironmentCompat;
import java.io.File;

/* renamed from: com.kwad.sdk.core.c.b */
public class C4065b {
    /* renamed from: a */
    private static String f13670a = "[KSAdSDK_2.6.5.2]";
    /* renamed from: b */
    private static boolean f13671b = true;
    /* renamed from: c */
    private static boolean f13672c = false;
    /* renamed from: d */
    private static boolean f13673d = false;

    /* renamed from: a */
    private static String m16861a() {
        return f13670a;
    }

    /* renamed from: a */
    public static void m16862a(Context context, String str, boolean z, boolean z2, File file) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(str);
        sb.append("]");
        f13670a = sb.toString();
        f13671b = z;
        f13672c = z2;
        C4064a.m16860a(context, f13672c, file);
    }

    /* renamed from: a */
    public static void m16863a(String str, String str2) {
    }

    /* renamed from: a */
    public static void m16864a(String str, String str2, Throwable th) {
        if (f13671b) {
            Log.e(str, str2, th);
        }
    }

    /* renamed from: a */
    public static void m16865a(Throwable th) {
        if (f13671b && th != null) {
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    private static String m16866b() {
        int i;
        String str;
        if (!f13673d) {
            return "";
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length > 3) {
            str = stackTrace[3].getFileName();
            i = stackTrace[3].getLineNumber();
        } else {
            str = EnvironmentCompat.MEDIA_UNKNOWN;
            i = -1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(str);
        sb.append(':');
        sb.append(i);
        sb.append(')');
        return sb.toString();
    }

    /* renamed from: b */
    public static void m16867b(String str, String str2) {
        if (f13671b) {
            Log.i(m16861a(), m16870e(str, str2));
        }
    }

    /* renamed from: c */
    public static void m16868c(String str, String str2) {
        if (f13671b) {
            Log.w(m16861a(), m16870e(str, str2));
        }
    }

    /* renamed from: d */
    public static void m16869d(String str, String str2) {
        if (f13671b) {
            Log.e(m16861a(), m16870e(str, str2));
        }
    }

    /* renamed from: e */
    private static String m16870e(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(str);
        sb.append("]: ");
        sb.append(str2);
        sb.append(" ");
        sb.append(m16866b());
        return sb.toString();
    }
}
