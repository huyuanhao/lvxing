package com.tencent.android.tpush.p584d;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.p584d.p585a.C6917a;
import com.tencent.android.tpush.p584d.p585a.C6918b;
import com.tencent.android.tpush.p584d.p585a.C6922c;
import com.tencent.android.tpush.p584d.p585a.C6923d;
import com.tencent.p605ep.commonbase.api.ConfigManager.OEM;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.d.d */
public class C6927d {
    /* renamed from: a */
    public static String f23006a = "";
    /* renamed from: b */
    public static String f23007b = "";
    /* renamed from: c */
    public static String f23008c = "";
    /* renamed from: d */
    public static String f23009d = "";
    /* renamed from: e */
    public static Context f23010e = null;
    /* renamed from: f */
    public static boolean f23011f = false;
    /* renamed from: g */
    private static volatile C6927d f23012g;
    /* renamed from: h */
    private static volatile C6926c f23013h;
    /* renamed from: i */
    private int f23014i = -1;

    /* renamed from: a */
    public boolean mo33132a() {
        if (f23013h == null) {
            return false;
        }
        return f23013h.mo33127d(f23010e);
    }

    private C6927d(Context context) {
        f23010e = context;
        if (f23013h == null) {
            if (XGPushConfig.isUsedFcmPush(context)) {
                f23013h = new C6917a();
                return;
            }
            String e = m29574e();
            if ("xiaomi".equals(e)) {
                f23013h = new C6923d();
            } else if (OEM.HUAWEI.equals(e)) {
                f23013h = new C6918b();
            } else if ("meizu".equals(e)) {
                f23013h = new C6922c();
            }
        }
    }

    /* renamed from: a */
    public static C6927d m29569a(Context context) {
        if (f23012g == null) {
            synchronized (C6927d.class) {
                if (f23012g == null) {
                    f23012g = new C6927d(context);
                }
            }
        }
        return f23012g;
    }

    /* renamed from: b */
    public void mo33133b() {
        if (f23013h != null && f23010e != null && f23013h.mo33127d(f23010e)) {
            f23013h.mo33124a(f23010e);
        }
    }

    /* renamed from: c */
    public void mo33134c() {
        if (f23013h != null && f23010e != null && f23013h.mo33127d(f23010e)) {
            f23013h.mo33125b(f23010e);
        }
    }

    /* renamed from: d */
    public String mo33135d() {
        if (f23013h == null || f23013h == null || !f23013h.mo33127d(f23010e)) {
            return null;
        }
        return f23013h.mo33126c(f23010e);
    }

    /* renamed from: e */
    public static String m29574e() {
        String str = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str) ? str.trim().toLowerCase() : str;
    }

    /* renamed from: a */
    public static void m29570a(Context context, String str) {
        f23006a = str;
    }

    /* renamed from: b */
    public static void m29571b(Context context, String str) {
        f23007b = str;
    }

    /* renamed from: c */
    public static void m29572c(Context context, String str) {
        f23008c = str;
    }

    /* renamed from: d */
    public static void m29573d(Context context, String str) {
        f23009d = str;
    }

    /* renamed from: f */
    public String mo33136f() {
        if (f23013h == null || f23013h == null) {
            return null;
        }
        return f23013h.mo33123a();
    }

    /* renamed from: g */
    public boolean mo33137g() {
        if (f23013h == null || f23013h == null) {
            return false;
        }
        return f23013h.mo33127d(f23010e);
    }
}
