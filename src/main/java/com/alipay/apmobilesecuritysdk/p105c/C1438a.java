package com.alipay.apmobilesecuritysdk.p105c;

import android.content.Context;
import android.os.Build;
import com.alipay.p109b.p110a.p111a.p115c.C1471a;
import com.alipay.p109b.p110a.p111a.p115c.C1474d;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* renamed from: com.alipay.apmobilesecuritysdk.c.a */
public final class C1438a {
    /* renamed from: a */
    public static synchronized void m4167a(Context context, String str, String str2, String str3) {
        synchronized (C1438a.class) {
            C1471a b = m4170b(context, str, str2, str3);
            StringBuilder sb = new StringBuilder();
            sb.append(context.getFilesDir().getAbsolutePath());
            sb.append("/log/ap");
            String sb2 = sb.toString();
            String format = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(format);
            sb3.append(".log");
            C1474d.m4294a(sb2, sb3.toString(), b.toString());
        }
    }

    /* renamed from: a */
    public static synchronized void m4168a(String str) {
        synchronized (C1438a.class) {
            C1474d.m4293a(str);
        }
    }

    /* renamed from: a */
    public static synchronized void m4169a(Throwable th) {
        synchronized (C1438a.class) {
            C1474d.m4295a(th);
        }
    }

    /* renamed from: b */
    private static C1471a m4170b(Context context, String str, String str2, String str3) {
        String str4;
        try {
            str4 = context.getPackageName();
        } catch (Throwable unused) {
            str4 = "";
        }
        C1471a aVar = new C1471a(Build.MODEL, str4, "APPSecuritySDK-ALIPAYSDK", "3.3.0.1905151001", str, str2, str3);
        return aVar;
    }
}
