package com.alibaba.mtl.appmonitor.p068a;

import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureValue;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.mtl.appmonitor.model.Metric;
import com.alibaba.mtl.appmonitor.model.MetricRepo;
import com.alibaba.mtl.appmonitor.p070c.BalancedPool;
import com.alibaba.mtl.appmonitor.p070c.ReuseJSONArray;
import com.alibaba.mtl.appmonitor.p070c.ReuseJSONObject;
import com.alibaba.mtl.log.p077d.Logger;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.alibaba.mtl.appmonitor.a.g */
public class StatEvent extends Event {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public Metric f3175a;
    /* renamed from: b */
    private Map<DimensionValueSet, C1292a> f3176b;

    /* compiled from: StatEvent */
    /* renamed from: com.alibaba.mtl.appmonitor.a.g$a */
    public class C1292a {
        /* access modifiers changed from: private */
        /* renamed from: b */
        public int f3178b = 0;
        /* access modifiers changed from: private */
        /* renamed from: c */
        public int f3179c = 0;
        /* renamed from: d */
        private List<MeasureValueSet> f3180d = new ArrayList();

        public C1292a() {
        }

        /* renamed from: a */
        public void mo11580a(MeasureValueSet measureValueSet) {
            if (measureValueSet == null) {
                return;
            }
            if (StatEvent.this.f3175a != null && StatEvent.this.f3175a.mo11756h()) {
                this.f3180d.add(m3358b(measureValueSet));
            } else if (this.f3180d.isEmpty()) {
                this.f3180d.add(m3358b(measureValueSet));
            } else {
                ((MeasureValueSet) this.f3180d.get(0)).mo11736a(measureValueSet);
            }
        }

        /* renamed from: b */
        private MeasureValueSet m3358b(MeasureValueSet measureValueSet) {
            MeasureValueSet measureValueSet2 = (MeasureValueSet) BalancedPool.m3491a().mo11627a(MeasureValueSet.class, new Object[0]);
            if (!(StatEvent.this.f3175a == null || StatEvent.this.f3175a.mo11755g() == null)) {
                List b = StatEvent.this.f3175a.mo11755g().mo11713b();
                if (b != null) {
                    int size = b.size();
                    for (int i = 0; i < size; i++) {
                        Measure measure = (Measure) b.get(i);
                        if (measure != null) {
                            MeasureValue measureValue = (MeasureValue) BalancedPool.m3491a().mo11627a(MeasureValue.class, new Object[0]);
                            MeasureValue a = measureValueSet.mo11734a(measure.mo11700b());
                            if (a.mo11724b() != null) {
                                measureValue.mo11721a(a.mo11724b().doubleValue());
                            }
                            measureValue.mo11725b(a.mo11728e());
                            measureValueSet2.mo11737a(measure.mo11700b(), measureValue);
                        }
                    }
                }
            }
            return measureValueSet2;
        }

        /* renamed from: a */
        public List<Map<String, Map<String, Double>>> mo11579a() {
            List<MeasureValueSet> list = this.f3180d;
            if (list == null || list.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = this.f3180d.size();
            for (int i = 0; i < size; i++) {
                MeasureValueSet measureValueSet = (MeasureValueSet) this.f3180d.get(i);
                if (measureValueSet != null) {
                    Map b = measureValueSet.mo11738b();
                    if (b != null && !b.isEmpty()) {
                        HashMap hashMap = new HashMap();
                        for (Entry entry : b.entrySet()) {
                            HashMap hashMap2 = new HashMap();
                            String str = (String) entry.getKey();
                            MeasureValue measureValue = (MeasureValue) entry.getValue();
                            hashMap2.put(ArgKey.KEY_VALUE, Double.valueOf(measureValue.mo11728e()));
                            if (measureValue.mo11724b() != null) {
                                hashMap2.put("offset", measureValue.mo11724b());
                            }
                            hashMap.put(str, hashMap2);
                        }
                        arrayList.add(hashMap);
                    }
                }
            }
            return arrayList;
        }

        /* renamed from: b */
        public void mo11581b() {
            this.f3178b++;
        }

        /* renamed from: c */
        public void mo11582c() {
            this.f3179c++;
        }
    }

    /* renamed from: a */
    public synchronized void mo11578a(DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet) {
        C1292a aVar;
        if (dimensionValueSet == null) {
            DimensionValueSet dimensionValueSet2 = (DimensionValueSet) BalancedPool.m3491a().mo11627a(DimensionValueSet.class, new Object[0]);
            dimensionValueSet2.mo11684a(dimensionValueSet);
            dimensionValueSet = dimensionValueSet2;
        }
        if (this.f3176b.containsKey(dimensionValueSet)) {
            aVar = (C1292a) this.f3176b.get(dimensionValueSet);
        } else {
            DimensionValueSet dimensionValueSet3 = (DimensionValueSet) BalancedPool.m3491a().mo11627a(DimensionValueSet.class, new Object[0]);
            dimensionValueSet3.mo11684a(dimensionValueSet);
            C1292a aVar2 = new C1292a();
            this.f3176b.put(dimensionValueSet3, aVar2);
            aVar = aVar2;
        }
        if (this.f3175a != null ? this.f3175a.mo11749a(dimensionValueSet, measureValueSet) : false) {
            aVar.mo11581b();
            aVar.mo11580a(measureValueSet);
        } else {
            aVar.mo11582c();
            if (this.f3175a.mo11756h()) {
                aVar.mo11580a(measureValueSet);
            }
        }
        Logger.m3833a("StatEvent", "entity  count:", Integer.valueOf(aVar.f3178b), " noise:", Integer.valueOf(aVar.f3179c));
    }

    /* renamed from: c */
    public synchronized JSONObject mo11545c() {
        JSONObject c;
        c = super.mo11545c();
        try {
            if (this.f3175a != null) {
                c.put("isCommitDetail", String.valueOf(this.f3175a.mo11756h()));
            }
            JSONArray jSONArray = (JSONArray) BalancedPool.m3491a().mo11627a(ReuseJSONArray.class, new Object[0]);
            if (this.f3176b != null) {
                for (Entry entry : this.f3176b.entrySet()) {
                    JSONObject jSONObject = (JSONObject) BalancedPool.m3491a().mo11627a(ReuseJSONObject.class, new Object[0]);
                    DimensionValueSet dimensionValueSet = (DimensionValueSet) entry.getKey();
                    C1292a aVar = (C1292a) entry.getValue();
                    Integer valueOf = Integer.valueOf(aVar.f3178b);
                    Integer valueOf2 = Integer.valueOf(aVar.f3179c);
                    jSONObject.put("count", valueOf);
                    jSONObject.put("noise", valueOf2);
                    jSONObject.put("dimensions", dimensionValueSet != null ? new JSONObject(dimensionValueSet.mo11689b()) : "");
                    List a = aVar.mo11579a();
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i = 0; i < a.size(); i++) {
                        JSONObject jSONObject2 = new JSONObject();
                        Map map = (Map) a.get(i);
                        if (map != null) {
                            Set<String> keySet = map.keySet();
                            if (keySet != null) {
                                for (String str : keySet) {
                                    if (map.get(str) != null) {
                                        jSONObject2.put(str, new JSONObject((Map) map.get(str)));
                                    } else {
                                        jSONObject2.put(str, "");
                                    }
                                }
                            }
                        }
                        jSONArray2.put(jSONObject2);
                    }
                    jSONObject.put("measures", jSONArray2);
                    jSONArray.put(jSONObject);
                }
            }
            c.put("values", jSONArray);
        } catch (Exception unused) {
        }
        return c;
    }

    /* renamed from: d */
    public synchronized void mo11546d() {
        super.mo11546d();
        this.f3175a = null;
        for (DimensionValueSet a : this.f3176b.keySet()) {
            BalancedPool.m3491a().mo11628a(a);
        }
        this.f3176b.clear();
    }

    /* renamed from: a */
    public void mo11548a(Object... objArr) {
        super.mo11548a(objArr);
        if (this.f3176b == null) {
            this.f3176b = new HashMap();
        }
        this.f3175a = MetricRepo.m3683a().mo11758a(this.f3151e, this.f3152f);
    }
}
