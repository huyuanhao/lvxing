package com.kwad.sdk.contentalliance.home;

import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kwad.sdk.contentalliance.home.c */
public class C4011c {
    /* renamed from: a */
    private static long f13463a;
    /* renamed from: b */
    private static List<AdTemplate> f13464b = new ArrayList();

    /* renamed from: a */
    public static void m16624a(List<AdTemplate> list) {
        m16627c();
        f13463a = System.currentTimeMillis();
        f13464b.addAll(list);
    }

    /* renamed from: a */
    public static boolean m16625a() {
        if (System.currentTimeMillis() - f13463a <= 120000) {
            return !f13464b.isEmpty();
        }
        m16627c();
        return false;
    }

    /* renamed from: b */
    public static List<AdTemplate> m16626b() {
        return f13464b;
    }

    /* renamed from: c */
    public static void m16627c() {
        f13464b.clear();
    }
}
