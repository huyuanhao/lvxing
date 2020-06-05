package com.alibaba.mtl.appmonitor.model;

import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.p070c.Reusable;
import java.util.List;
import java.util.UUID;

/* renamed from: com.alibaba.mtl.appmonitor.model.b */
public class Metric implements Reusable {
    /* renamed from: a */
    private String f3259a;
    /* renamed from: b */
    private String f3260b;
    /* renamed from: c */
    private String f3261c;
    /* renamed from: d */
    private boolean f3262d;
    /* renamed from: e */
    private String f3263e = null;
    /* renamed from: f */
    private DimensionSet f3264f;
    /* renamed from: g */
    private MeasureSet f3265g;
    /* renamed from: h */
    private String f3266h;

    @Deprecated
    public Metric() {
    }

    public Metric(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) {
        this.f3259a = str;
        this.f3260b = str2;
        this.f3264f = dimensionSet;
        this.f3265g = measureSet;
        this.f3261c = null;
        this.f3262d = z;
    }

    /* renamed from: a */
    public synchronized String mo11747a() {
        if (this.f3266h == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UUID.randomUUID().toString());
            sb.append("$");
            sb.append(this.f3259a);
            sb.append("$");
            sb.append(this.f3260b);
            this.f3266h = sb.toString();
        }
        return this.f3266h;
    }

    /* renamed from: b */
    public void mo11750b() {
        this.f3266h = null;
    }

    /* renamed from: a */
    public boolean mo11749a(DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet) {
        DimensionSet dimensionSet = this.f3264f;
        boolean a = dimensionSet != null ? dimensionSet.mo11676a(dimensionValueSet) : true;
        MetricRepo a2 = MetricRepo.m3683a();
        StringBuilder sb = new StringBuilder();
        String str = "config_prefix";
        sb.append(str);
        sb.append(this.f3259a);
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append(this.f3260b);
        Metric a3 = a2.mo11758a(sb2, sb3.toString());
        if (a3 == null || a3.mo11755g() == null || measureValueSet == null || measureValueSet.mo11738b() == null || this.f3265g == null) {
            MeasureSet measureSet = this.f3265g;
            if (measureSet != null) {
                a = a && measureSet.mo11712a(measureValueSet);
            }
            return a;
        }
        List b = a3.mo11755g().mo11713b();
        for (String str2 : measureValueSet.mo11738b().keySet()) {
            Measure a4 = m3671a(str2, b);
            if (a4 == null) {
                a4 = m3671a(str2, this.f3265g.mo11713b());
            }
            if (a4 != null) {
                if (!a4.mo11699a(measureValueSet.mo11734a(str2))) {
                }
            }
            return false;
        }
        return a;
    }

    /* renamed from: a */
    private Measure m3671a(String str, List<Measure> list) {
        if (list != null) {
            for (Measure measure : list) {
                if (TextUtils.equals(str, measure.f3251c)) {
                    return measure;
                }
            }
        }
        return null;
    }

    /* renamed from: c */
    public String mo11751c() {
        return this.f3259a;
    }

    /* renamed from: e */
    public String mo11752e() {
        return this.f3260b;
    }

    /* renamed from: f */
    public DimensionSet mo11754f() {
        return this.f3264f;
    }

    /* renamed from: g */
    public MeasureSet mo11755g() {
        return this.f3265g;
    }

    /* renamed from: h */
    public synchronized boolean mo11756h() {
        if ("1".equalsIgnoreCase(this.f3263e)) {
            return true;
        }
        if ("0".equalsIgnoreCase(this.f3263e)) {
            return false;
        }
        return this.f3262d;
    }

    public int hashCode() {
        int i;
        String str = this.f3261c;
        int i2 = 0;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        int i3 = (i + 31) * 31;
        String str2 = this.f3259a;
        int hashCode = (i3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f3260b;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode + i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Metric bVar = (Metric) obj;
        String str = this.f3261c;
        if (str == null) {
            if (bVar.f3261c != null) {
                return false;
            }
        } else if (!str.equals(bVar.f3261c)) {
            return false;
        }
        String str2 = this.f3259a;
        if (str2 == null) {
            if (bVar.f3259a != null) {
                return false;
            }
        } else if (!str2.equals(bVar.f3259a)) {
            return false;
        }
        String str3 = this.f3260b;
        if (str3 == null) {
            if (bVar.f3260b != null) {
                return false;
            }
        } else if (!str3.equals(bVar.f3260b)) {
            return false;
        }
        return true;
    }

    /* renamed from: d */
    public void mo11546d() {
        this.f3259a = null;
        this.f3260b = null;
        this.f3261c = null;
        this.f3262d = false;
        this.f3264f = null;
        this.f3265g = null;
        this.f3266h = null;
    }

    /* renamed from: a */
    public void mo11548a(Object... objArr) {
        this.f3259a = objArr[0];
        this.f3260b = objArr[1];
        if (objArr.length > 2) {
            this.f3261c = objArr[2];
        }
    }

    /* renamed from: a */
    public synchronized void mo11748a(String str) {
        this.f3263e = str;
    }
}
