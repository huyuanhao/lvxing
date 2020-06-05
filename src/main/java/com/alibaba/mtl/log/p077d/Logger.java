package com.alibaba.mtl.log.p077d;

import android.os.Process;
import android.util.Log;
import com.tencent.mid.sotrage.StorageInterface;

/* renamed from: com.alibaba.mtl.log.d.i */
public class Logger {
    /* renamed from: a */
    private static String f3404a = "UTAnalytics:";
    /* renamed from: b */
    private static boolean f3405b = false;
    /* renamed from: c */
    private static boolean f3406c = false;

    /* renamed from: a */
    public static boolean m3836a() {
        return f3405b;
    }

    /* renamed from: b */
    public static boolean m3837b() {
        return f3406c;
    }

    /* renamed from: a */
    public static void m3835a(boolean z) {
        f3406c = z;
    }

    /* renamed from: a */
    public static void m3833a(String str, Object... objArr) {
        if (f3406c) {
            StringBuilder sb = new StringBuilder();
            sb.append(f3404a);
            sb.append(str);
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("pid:");
            sb3.append(Process.myPid());
            sb3.append(" ");
            if (objArr != null) {
                for (int i = 0; i < objArr.length; i++) {
                    if (objArr[i] != null) {
                        String obj = objArr[i].toString();
                        if (obj.endsWith(":") || obj.endsWith(": ")) {
                            sb3.append(obj);
                        } else {
                            sb3.append(obj);
                            sb3.append(StorageInterface.KEY_SPLITER);
                        }
                    }
                }
            }
            Log.d(sb2, sb3.toString());
        }
    }

    /* renamed from: a */
    public static void m3832a(String str, Object obj, Throwable th) {
        if (m3837b() || m3836a()) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(f3404a);
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(obj);
            sb3.append("");
            Log.w(sb2, sb3.toString(), th);
        }
    }

    /* renamed from: a */
    public static void m3831a(String str, Object obj) {
        if (m3837b() || m3836a()) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(f3404a);
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(obj);
            sb3.append("");
            Log.w(sb2, sb3.toString());
        }
    }

    /* renamed from: a */
    public static void m3834a(String str, String... strArr) {
        if (f3406c) {
            StringBuilder sb = new StringBuilder();
            sb.append(f3404a);
            sb.append(str);
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("pid:");
            sb3.append(Process.myPid());
            sb3.append(" ");
            if (strArr != null) {
                for (int i = 0; i < strArr.length; i++) {
                    if (strArr[i] != null) {
                        String str2 = strArr[i];
                        if (str2.endsWith(":") || str2.endsWith(": ")) {
                            sb3.append(str2);
                        } else {
                            sb3.append(str2);
                            sb3.append(StorageInterface.KEY_SPLITER);
                        }
                    }
                }
            }
            Log.i(sb2, sb3.toString());
        }
    }
}
