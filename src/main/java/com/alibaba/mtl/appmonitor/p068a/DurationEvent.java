package com.alibaba.mtl.appmonitor.p068a;

import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureValue;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.mtl.appmonitor.model.Metric;
import com.alibaba.mtl.appmonitor.model.MetricRepo;
import com.alibaba.mtl.appmonitor.p070c.BalancedPool;
import com.alibaba.mtl.log.p077d.Logger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.alibaba.mtl.appmonitor.a.c */
public class DurationEvent extends Event {
    /* renamed from: a */
    private static final Long f3145a = Long.valueOf(300000);
    /* renamed from: b */
    private Metric f3146b;
    /* renamed from: c */
    private MeasureValueSet f3147c;
    /* renamed from: d */
    private DimensionValueSet f3148d;
    /* renamed from: i */
    private Map<String, MeasureValue> f3149i;
    /* renamed from: j */
    private Long f3150j;

    /* renamed from: a */
    public boolean mo11551a() {
        long currentTimeMillis = System.currentTimeMillis();
        List b = this.f3146b.mo11755g().mo11713b();
        if (b != null) {
            int size = b.size();
            for (int i = 0; i < size; i++) {
                Measure measure = (Measure) b.get(i);
                if (measure != null) {
                    double doubleValue = measure.mo11698a() != null ? measure.mo11698a().doubleValue() : (double) f3145a.longValue();
                    MeasureValue measureValue = (MeasureValue) this.f3149i.get(measure.mo11700b());
                    if (measureValue != null && !measureValue.mo11726c() && ((double) currentTimeMillis) - measureValue.mo11728e() > doubleValue) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public void mo11550a(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f3149i.isEmpty()) {
            this.f3150j = Long.valueOf(currentTimeMillis);
        }
        this.f3149i.put(str, (MeasureValue) BalancedPool.m3491a().mo11627a(MeasureValue.class, Double.valueOf((double) currentTimeMillis), Double.valueOf((double) (currentTimeMillis - this.f3150j.longValue()))));
    }

    /* renamed from: b */
    public boolean mo11553b(String str) {
        MeasureValue measureValue = (MeasureValue) this.f3149i.get(str);
        if (measureValue != null) {
            double currentTimeMillis = (double) System.currentTimeMillis();
            Logger.m3833a("DurationEvent", "statEvent consumeTime. module:", this.f3151e, " monitorPoint:", this.f3152f, " measureName:", str, " time:", Double.valueOf(currentTimeMillis - measureValue.mo11728e()));
            measureValue.mo11725b(currentTimeMillis - measureValue.mo11728e());
            measureValue.mo11723a(true);
            this.f3147c.mo11737a(str, measureValue);
            if (this.f3146b.mo11755g().mo11712a(this.f3147c)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void mo11549a(DimensionValueSet dimensionValueSet) {
        DimensionValueSet dimensionValueSet2 = this.f3148d;
        if (dimensionValueSet2 == null) {
            this.f3148d = dimensionValueSet;
        } else {
            dimensionValueSet2.mo11684a(dimensionValueSet);
        }
    }

    /* renamed from: b */
    public MeasureValueSet mo11552b() {
        return this.f3147c;
    }

    /* renamed from: e */
    public DimensionValueSet mo11554e() {
        return this.f3148d;
    }

    /* renamed from: d */
    public void mo11546d() {
        super.mo11546d();
        this.f3146b = null;
        this.f3150j = null;
        for (MeasureValue a : this.f3149i.values()) {
            BalancedPool.m3491a().mo11628a(a);
        }
        this.f3149i.clear();
        if (this.f3147c != null) {
            BalancedPool.m3491a().mo11628a(this.f3147c);
            this.f3147c = null;
        }
        if (this.f3148d != null) {
            BalancedPool.m3491a().mo11628a(this.f3148d);
            this.f3148d = null;
        }
    }

    /* renamed from: a */
    public void mo11548a(Object... objArr) {
        super.mo11548a(objArr);
        if (this.f3149i == null) {
            this.f3149i = new HashMap();
        }
        this.f3146b = MetricRepo.m3683a().mo11758a(this.f3151e, this.f3152f);
        if (this.f3146b.mo11754f() != null) {
            this.f3148d = (DimensionValueSet) BalancedPool.m3491a().mo11627a(DimensionValueSet.class, new Object[0]);
            this.f3146b.mo11754f().mo11677b(this.f3148d);
        }
        this.f3147c = (MeasureValueSet) BalancedPool.m3491a().mo11627a(MeasureValueSet.class, new Object[0]);
    }
}
