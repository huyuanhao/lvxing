package com.pgl.sys.ces.p365a;

import android.app.Application;
import android.content.Context;
import android.os.Environment;

/* renamed from: com.pgl.sys.ces.a.a */
public class C4796a {
    /* renamed from: a */
    public static Application m19631a() {
        try {
            return (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static String m19632a(Context context) {
        String str;
        String str2 = "";
        try {
            str = context.getPackageName();
        } catch (Throwable unused) {
            str = str2;
        }
        return str == null ? str2 : str.trim();
    }

    /* renamed from: b */
    public static int m19633b(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), i).versionCode;
        } catch (Throwable unused) {
            return i;
        }
    }

    /* renamed from: b */
    public static String m19634b() {
        String str;
        try {
            str = Environment.getExternalStorageDirectory().getAbsolutePath();
        } catch (Throwable unused) {
            str = null;
        }
        return str == null ? "" : str.trim();
    }

    /* renamed from: c */
    public static String m19635c() {
        String str;
        try {
            str = Environment.getDataDirectory().getPath();
        } catch (Throwable unused) {
            str = null;
        }
        return str == null ? "" : str.trim();
    }

    /* renamed from: c */
    public static String m19636c(Context context) {
        String str;
        String str2 = "";
        try {
            str = context.getFilesDir().getAbsolutePath();
        } catch (Throwable unused) {
            str = str2;
        }
        return str == null ? str2 : str.trim();
    }

    /* renamed from: d */
    public static String m19637d(Context context) {
        String str;
        String str2 = "";
        try {
            str = context.getApplicationInfo().sourceDir;
        } catch (Throwable unused) {
            str = str2;
        }
        return str == null ? str2 : str.trim();
    }
}
