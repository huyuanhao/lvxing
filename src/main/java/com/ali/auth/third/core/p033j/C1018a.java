package com.ali.auth.third.core.p033j;

import android.content.Context;
import android.util.Log;
import com.ali.auth.third.core.config.C0990a;
import com.ali.auth.third.core.p024c.C0989a;
import com.ali.auth.third.core.p027f.C0999a;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: com.ali.auth.third.core.j.a */
public class C1018a {
    /* renamed from: a */
    public static void m1958a(String str, C0999a aVar, Throwable th) {
        if (m1961a()) {
            StringBuilder sb = new StringBuilder();
            String str2 = "***********************************************************\n";
            sb.append(str2);
            sb.append("错误编码 = ");
            sb.append(aVar.f1942a);
            String str3 = "\n";
            sb.append(str3);
            sb.append("错误消息 = ");
            sb.append(aVar.f1944c);
            sb.append(str3);
            sb.append("解决建议 = ");
            sb.append(aVar.f1945d);
            sb.append(str3);
            if (th != null) {
                sb.append("错误堆栈 = ");
                sb.append(Log.getStackTraceString(th));
                sb.append(str3);
            }
            sb.append(str2);
            String str4 = aVar.f1943b;
            if ("D".equals(str4)) {
                m1964b(str, sb.toString());
            } else if ("E".equals(str4)) {
                m1967d(str, sb.toString());
            } else if ("W".equals(str4)) {
                m1966c(str, sb.toString());
            } else {
                m1959a(str, sb.toString());
            }
        }
    }

    /* renamed from: a */
    public static void m1959a(String str, String str2) {
        try {
            if (m1961a()) {
                StringBuilder sb = new StringBuilder();
                sb.append("AuthSDK_");
                sb.append(str);
                String sb2 = sb.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str2);
                sb3.append(m1963b());
                Log.i(sb2, sb3.toString());
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static void m1960a(String str, String str2, Throwable th) {
        try {
            if (m1961a()) {
                StringBuilder sb = new StringBuilder();
                sb.append("AuthSDK_");
                sb.append(str);
                String sb2 = sb.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str2);
                sb3.append(m1963b());
                Log.e(sb2, sb3.toString(), th);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static boolean m1961a() {
        return C0990a.f1902a || m1962a(C0989a.m1887c());
    }

    /* renamed from: a */
    public static boolean m1962a(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: b */
    private static String m1963b() {
        StringBuilder sb = new StringBuilder("\n");
        sb.append("time =");
        sb.append(m1965c());
        return sb.toString();
    }

    /* renamed from: b */
    public static void m1964b(String str, String str2) {
        try {
            if (m1961a()) {
                StringBuilder sb = new StringBuilder();
                sb.append("AuthSDK_");
                sb.append(str);
                String sb2 = sb.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str2);
                sb3.append(m1963b());
                Log.d(sb2, sb3.toString());
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: c */
    private static String m1965c() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date(System.currentTimeMillis()));
    }

    /* renamed from: c */
    public static void m1966c(String str, String str2) {
        try {
            if (m1961a()) {
                StringBuilder sb = new StringBuilder();
                sb.append("AuthSDK_");
                sb.append(str);
                String sb2 = sb.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str2);
                sb3.append(m1963b());
                Log.w(sb2, sb3.toString());
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: d */
    public static void m1967d(String str, String str2) {
        try {
            if (m1961a()) {
                StringBuilder sb = new StringBuilder();
                sb.append("AuthSDK_");
                sb.append(str);
                String sb2 = sb.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str2);
                sb3.append(m1963b());
                Log.e(sb2, sb3.toString());
            }
        } catch (Throwable unused) {
        }
    }
}
