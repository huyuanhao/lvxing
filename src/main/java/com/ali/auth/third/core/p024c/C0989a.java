package com.ali.auth.third.core.p024c;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import com.ali.auth.third.core.C0982b;
import com.ali.auth.third.core.config.AuthOption;
import com.ali.auth.third.core.config.C0990a;
import com.ali.auth.third.core.config.Environment;
import com.ali.auth.third.core.p028g.C1005b;
import com.ali.auth.third.core.p028g.p029a.C1002a;
import com.ali.auth.third.core.p030h.C1006a;
import com.ali.auth.third.core.p030h.C1012b;
import com.ali.auth.third.core.p030h.C1013c;
import com.ali.auth.third.core.p030h.C1014d;
import com.ali.auth.third.core.p030h.C1015e;
import com.ali.auth.third.core.p030h.p031a.C1008b;
import com.ali.auth.third.core.util.C1042g;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.ali.auth.third.core.c.a */
public class C0989a {
    /* renamed from: a */
    public static boolean f1886a = true;
    /* renamed from: b */
    public static boolean f1887b = false;
    /* renamed from: c */
    public static final String f1888c;
    /* renamed from: d */
    public static final String f1889d;
    /* renamed from: e */
    public static String f1890e = f1888c;
    /* renamed from: f */
    public static volatile Context f1891f;
    /* renamed from: g */
    public static C1014d f1892g;
    /* renamed from: h */
    public static C1006a f1893h;
    /* renamed from: i */
    public static C0982b f1894i;
    /* renamed from: j */
    public static AuthOption f1895j = AuthOption.NORMAL;
    /* renamed from: k */
    public static AuthOption f1896k = null;
    /* renamed from: l */
    public static String f1897l;
    /* renamed from: m */
    public static Resources f1898m;
    /* renamed from: n */
    public static final ReentrantLock f1899n = new ReentrantLock();
    /* renamed from: o */
    public static volatile C1005b f1900o = new C1002a();
    /* renamed from: p */
    public static C1012b f1901p = new C1008b();

    static {
        StringBuilder sb = new StringBuilder();
        String str = "a_";
        sb.append(str);
        sb.append(C0990a.f1903b.toString());
        sb.append("-mini");
        f1888c = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(C0990a.f1903b.toString());
        sb2.append("-std");
        f1889d = sb2.toString();
    }

    /* renamed from: a */
    public static <T> T m1882a(Class<T> cls) {
        return f1900o.mo10325a(cls, null);
    }

    /* renamed from: a */
    public static <T> T m1883a(Class<T> cls, Map<String, String> map) {
        return f1900o.mo10325a(cls, map);
    }

    /* renamed from: a */
    public static String m1884a() {
        return f1892g.mo10297b();
    }

    /* renamed from: b */
    public static Environment m1885b() {
        return C0990a.m1889b().mo10310a();
    }

    /* renamed from: b */
    public static <T> T[] m1886b(Class<T> cls) {
        return f1900o.mo10326b(cls, null);
    }

    /* renamed from: c */
    public static synchronized Context m1887c() {
        synchronized (C0989a.class) {
            if (f1891f != null) {
                Context context = f1891f;
                return context;
            }
            Application c = C1042g.m2010c();
            return c;
        }
    }

    /* renamed from: d */
    public static boolean m1888d() {
        return (f1891f == null || f1900o == null || m1886b(C1013c.class) == null || m1886b(C1014d.class) == null || m1886b(C1015e.class) == null || m1886b(C1006a.class) == null || f1892g == null || f1893h == null) ? false : true;
    }
}
