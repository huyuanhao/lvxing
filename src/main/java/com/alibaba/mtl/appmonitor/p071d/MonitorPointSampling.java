package com.alibaba.mtl.appmonitor.p071d;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.alibaba.mtl.appmonitor.d.i */
class MonitorPointSampling extends AbstractSampling<JSONObject> {
    /* renamed from: b */
    protected List<AccurateSampling> f3221b;
    /* renamed from: c */
    private String f3222c;

    public MonitorPointSampling(String str, int i) {
        super(i);
        this.f3222c = str;
    }

    /* renamed from: a */
    public boolean mo11641a(int i, Map<String, String> map) {
        List<AccurateSampling> list = this.f3221b;
        if (!(list == null || map == null)) {
            for (AccurateSampling a : list) {
                Boolean a2 = a.mo11634a(i, map);
                if (a2 != null) {
                    return a2.booleanValue();
                }
            }
        }
        return mo11632a(i);
    }

    /* renamed from: b */
    public void mo11643b(JSONObject jSONObject) {
        mo11631a(jSONObject);
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("extra");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    AccurateSampling cVar = new AccurateSampling(this.f3202a);
                    if (this.f3221b == null) {
                        this.f3221b = new ArrayList();
                    }
                    this.f3221b.add(cVar);
                    cVar.mo11635b(jSONObject2);
                }
            }
        } catch (Exception unused) {
        }
    }
}
