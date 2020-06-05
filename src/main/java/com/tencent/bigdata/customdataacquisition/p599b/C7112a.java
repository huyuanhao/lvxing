package com.tencent.bigdata.customdataacquisition.p599b;

import android.content.Context;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.bigdata.customdataacquisition.b.a */
public class C7112a {
    /* renamed from: a */
    private static boolean f23631a = false;

    /* renamed from: a */
    public static void m30478a(Object obj) {
        if (f23631a) {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(obj);
            Log.i("CustomDataAcq", sb.toString());
        }
    }

    /* renamed from: a */
    public static void m30479a(String str, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(str);
        Log.e("CustomDataAcq", sb.toString(), th);
    }

    /* renamed from: a */
    public static boolean m30480a(Context context, String str) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Throwable th) {
            m30479a("checkPermission error", th);
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m30481a(JSONArray jSONArray) {
        return jSONArray == null || jSONArray.length() <= 0;
    }

    /* renamed from: a */
    public static boolean m30482a(JSONObject jSONObject) {
        return jSONObject == null || jSONObject.length() <= 0;
    }

    /* renamed from: b */
    public static void m30483b(Object obj) {
        if (f23631a) {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(obj);
            Log.d("CustomDataAcq", sb.toString());
        }
    }

    /* renamed from: c */
    public static void m30484c(Object obj) {
        if (f23631a) {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(obj);
            Log.w("CustomDataAcq", sb.toString());
        }
    }

    /* renamed from: d */
    public static void m30485d(Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(obj);
        Log.e("CustomDataAcq", sb.toString());
    }
}
