package com.tmsdk.module.coin;

import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public final class TmsLog {
    /* renamed from: bA */
    private static boolean f25895bA = true;

    /* renamed from: a */
    static void m32937a(int i, String str, String str2) {
        if (f25895bA) {
            if (str2 == null) {
                str2 = "(null)";
            }
            StringBuilder sb = new StringBuilder();
            sb.append("TMSDK_");
            sb.append(str);
            Log.println(i, sb.toString(), str2);
        }
    }

    /* renamed from: b */
    static void m32938b(String str, String str2) {
        FileOutputStream fileOutputStream;
        if (f25895bA) {
            FileOutputStream fileOutputStream2 = null;
            try {
                if ("mounted".equals(Environment.getExternalStorageState())) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(Environment.getExternalStorageDirectory());
                    sb.append("/");
                    sb.append(str);
                    File file = new File(sb.toString());
                    if (!file.exists()) {
                        file.getAbsoluteFile().getParentFile().mkdirs();
                        file.createNewFile();
                    }
                    fileOutputStream = new FileOutputStream(file, false);
                    try {
                        fileOutputStream.write(str2.getBytes());
                    } catch (Throwable unused) {
                        fileOutputStream2 = fileOutputStream;
                    }
                } else {
                    fileOutputStream = null;
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused2) {
                    }
                }
            } catch (Throwable unused3) {
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
            }
        }
    }

    /* renamed from: d */
    public static void m32939d(String str, String str2) {
        m32937a(3, str, str2);
    }

    /* renamed from: e */
    public static void m32940e(String str, String str2) {
        m32937a(6, str, str2);
    }

    /* renamed from: e */
    public static void m32941e(String str, String str2, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(th.getMessage());
        m32937a(6, str, sb.toString());
    }

    /* renamed from: f */
    public static void m32942f(String str, String str2) {
        m32938b(str, str2);
    }

    /* renamed from: i */
    public static void m32943i(String str, String str2) {
        m32937a(4, str, str2);
    }

    public static void setLogEnable(boolean z) {
        f25895bA = z;
    }

    /* renamed from: v */
    public static void m32944v(String str, String str2) {
        m32937a(2, str, str2);
    }

    /* renamed from: w */
    public static void m32945w(String str, String str2) {
        m32937a(5, str, str2);
    }
}
