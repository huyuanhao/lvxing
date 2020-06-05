package com.ksad.lottie.p302c;

import android.util.JsonReader;
import com.ksad.lottie.C3703d;
import com.ksad.lottie.model.p305a.C3743a;
import com.ksad.lottie.model.p305a.C3744b;
import com.ksad.lottie.model.p305a.C3745c;
import com.ksad.lottie.model.p305a.C3746d;
import com.ksad.lottie.model.p305a.C3748f;
import com.ksad.lottie.model.p305a.C3749g;
import com.ksad.lottie.model.p305a.C3750h;
import com.ksad.lottie.model.p305a.C3752j;
import com.ksad.lottie.p303d.C3709f;
import com.ksad.lottie.p304e.C3717a;
import java.util.List;

/* renamed from: com.ksad.lottie.c.n */
public class C3689n {
    /* renamed from: a */
    public static C3744b m15294a(JsonReader jsonReader, C3703d dVar) {
        return m15295a(jsonReader, dVar, true);
    }

    /* renamed from: a */
    public static C3744b m15295a(JsonReader jsonReader, C3703d dVar, boolean z) {
        return new C3744b(m15297a(jsonReader, z ? C3709f.m15387a() : 1.0f, dVar, C3694s.f12584a));
    }

    /* renamed from: a */
    static C3745c m15296a(JsonReader jsonReader, C3703d dVar, int i) {
        return new C3745c(m15298a(jsonReader, dVar, (C3686k<T>) new C3697v<T>(i)));
    }

    /* renamed from: a */
    private static <T> List<C3717a<T>> m15297a(JsonReader jsonReader, float f, C3703d dVar, C3686k<T> kVar) {
        return C3668ab.m15262a(jsonReader, dVar, f, kVar);
    }

    /* renamed from: a */
    private static <T> List<C3717a<T>> m15298a(JsonReader jsonReader, C3703d dVar, C3686k<T> kVar) {
        return C3668ab.m15262a(jsonReader, dVar, 1.0f, kVar);
    }

    /* renamed from: b */
    static C3746d m15299b(JsonReader jsonReader, C3703d dVar) {
        return new C3746d(m15298a(jsonReader, dVar, (C3686k<T>) C3700y.f12586a));
    }

    /* renamed from: c */
    static C3748f m15300c(JsonReader jsonReader, C3703d dVar) {
        return new C3748f(m15297a(jsonReader, C3709f.m15387a(), dVar, C3675ai.f12579a));
    }

    /* renamed from: d */
    static C3749g m15301d(JsonReader jsonReader, C3703d dVar) {
        return new C3749g(m15298a(jsonReader, dVar, (C3686k<T>) C3679d.f12580a));
    }

    /* renamed from: e */
    static C3750h m15302e(JsonReader jsonReader, C3703d dVar) {
        return new C3750h(m15297a(jsonReader, C3709f.m15387a(), dVar, C3680e.f12581a));
    }

    /* renamed from: f */
    static C3752j m15303f(JsonReader jsonReader, C3703d dVar) {
        return new C3752j(m15298a(jsonReader, dVar, (C3686k<T>) C3693r.f12583a));
    }

    /* renamed from: g */
    static C3743a m15304g(JsonReader jsonReader, C3703d dVar) {
        return new C3743a(m15298a(jsonReader, dVar, (C3686k<T>) C3691p.f12582a));
    }
}
