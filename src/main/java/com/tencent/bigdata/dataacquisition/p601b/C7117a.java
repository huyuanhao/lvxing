package com.tencent.bigdata.dataacquisition.p601b;

import android.content.Context;
import android.util.Log;

/* renamed from: com.tencent.bigdata.dataacquisition.b.a */
public class C7117a {
    /* renamed from: a */
    private static boolean f23638a = false;

    /* renamed from: a */
    public static void m30514a(Object obj) {
        if (f23638a) {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(obj);
            Log.w("DataAcq", sb.toString());
        }
    }

    /* renamed from: a */
    public static void m30515a(String str, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(str);
        Log.e("DataAcq", sb.toString(), th);
    }

    /* renamed from: a */
    public static boolean m30516a(Context context, String str) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Throwable th) {
            m30515a("checkPermission error", th);
            return false;
        }
    }

    /* renamed from: b */
    public static void m30517b(Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(obj);
        Log.e("DataAcq", sb.toString());
    }
}
