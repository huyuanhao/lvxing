package com.pgl.sys.ces.p365a;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.pgl.p359a.p361b.C4786d;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.TimeZone;

/* renamed from: com.pgl.sys.ces.a.c */
public class C4799c {
    /* renamed from: a */
    public static String m19643a() {
        String str;
        try {
            str = TimeZone.getDefault().getDisplayName(false, 0);
        } catch (Throwable unused) {
            str = null;
        }
        return str == null ? "" : str.trim();
    }

    /* renamed from: a */
    public static String m19644a(Context context) {
        String str;
        String str2 = "";
        try {
            str = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Throwable unused) {
            str = str2;
        }
        return str == null ? str2 : str.trim();
    }

    /* renamed from: b */
    public static String m19645b(Context context) {
        String str;
        try {
            str = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        } catch (Throwable unused) {
            str = null;
        }
        return str == null ? "" : str.trim();
    }

    /* renamed from: c */
    public static String m19646c(Context context) {
        String str;
        try {
            Locale locale = context.getResources().getConfiguration().locale;
            String language = locale.getLanguage();
            String country = locale.getCountry();
            StringBuilder sb = new StringBuilder();
            sb.append(language);
            sb.append("_");
            sb.append(country);
            str = sb.toString();
        } catch (Throwable unused) {
            str = null;
        }
        return str == null ? "" : str.trim();
    }

    /* renamed from: d */
    public static String m19647d(Context context) {
        double d;
        try {
            Class cls = Class.forName("com.android.internal.os.PowerProfile");
            Object newInstance = cls.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
            Method declaredMethod = cls.getDeclaredMethod("getAveragePower", new Class[]{String.class});
            declaredMethod.setAccessible(true);
            d = ((Double) declaredMethod.invoke(newInstance, new Object[]{"battery.capacity"})).doubleValue();
        } catch (Throwable unused) {
            d = 0.0d;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("capacity : ");
        sb.append(d);
        C4786d.m19620b(sb.toString());
        return Integer.toString((int) d);
    }
}
