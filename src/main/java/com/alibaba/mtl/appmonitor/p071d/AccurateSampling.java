package com.alibaba.mtl.appmonitor.p071d;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.alibaba.mtl.appmonitor.d.c */
public class AccurateSampling extends AbstractSampling<JSONObject> {
    /* renamed from: b */
    private Map<String, AccurateSampleCondition> f3208b = new HashMap();

    public AccurateSampling(int i) {
        super(i);
    }

    /* renamed from: b */
    public void mo11635b(JSONObject jSONObject) {
        mo11631a(jSONObject);
    }

    /* renamed from: a */
    public Boolean mo11634a(int i, Map<String, String> map) {
        if (map != null) {
            Map<String, AccurateSampleCondition> map2 = this.f3208b;
            if (map2 != null) {
                for (String str : map2.keySet()) {
                    if (!((AccurateSampleCondition) this.f3208b.get(str)).mo11633a((String) map.get(str))) {
                        return null;
                    }
                }
                return Boolean.valueOf(mo11632a(i));
            }
        }
        return null;
    }
}
