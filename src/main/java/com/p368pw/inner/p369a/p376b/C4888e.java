package com.p368pw.inner.p369a.p376b;

import com.p368pw.inner.base.p387d.C5194l;

/* renamed from: com.pw.inner.a.b.e */
public class C4888e {
    /* renamed from: a */
    public static C4887d m20152a(int i, C4879b bVar, int i2, int i3) {
        C4887d dVar = new C4887d(m20154a(bVar), m20153a(i), false, false, true, i2, false, i3);
        return dVar;
    }

    /* renamed from: a */
    private static String m20153a(int i) {
        String str = "https://adx-api.zzpolarb.com/static/adtemp/interstitial_climb_iconOrimg_0.html";
        if (i == 200) {
            str = "https://adx-api.zzpolarb.com/static/adtemp/interstitial_p0.html";
        } else if (i == 201) {
            str = "https://adx-api.zzpolarb.com/static/adtemp/interstitial_p1.html";
        } else if (i != 202) {
        }
        return C5194l.m21428a(str);
    }

    /* renamed from: a */
    private static String m20154a(C4879b bVar) {
        return bVar.mo25945t();
    }
}
