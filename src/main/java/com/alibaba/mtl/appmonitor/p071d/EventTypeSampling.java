package com.alibaba.mtl.appmonitor.p071d;

import com.alibaba.mtl.appmonitor.p068a.EventType;
import com.alibaba.mtl.appmonitor.p073f.StringUtils;
import com.alibaba.mtl.log.p077d.Logger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.alibaba.mtl.appmonitor.d.g */
class EventTypeSampling extends AbstractSampling<JSONObject> {
    /* renamed from: b */
    private EventType f3216b;
    /* renamed from: c */
    protected Map<String, ModuleSampling> f3217c;
    /* renamed from: d */
    protected int f3218d = -1;

    public EventTypeSampling(EventType fVar, int i) {
        super(i);
        this.f3216b = fVar;
        this.f3217c = Collections.synchronizedMap(new HashMap());
    }

    /* renamed from: a */
    public boolean mo11645a(int i, String str, String str2, Map<String, String> map) {
        Map<String, ModuleSampling> map2 = this.f3217c;
        if (map2 != null) {
            ModuleSampling hVar = (ModuleSampling) map2.get(str);
            if (hVar != null) {
                return hVar.mo11637a(i, str2, map);
            }
        }
        return i < this.f3202a;
    }

    /* renamed from: b */
    public void mo11647b(JSONObject jSONObject) {
        mo11631a(jSONObject);
        mo11648c(jSONObject);
        this.f3217c.clear();
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("metrics");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    String optString = jSONObject2.optString("module");
                    if (StringUtils.m3589a(optString)) {
                        ModuleSampling hVar = (ModuleSampling) this.f3217c.get(optString);
                        if (hVar == null) {
                            hVar = new ModuleSampling(optString, this.f3202a);
                            this.f3217c.put(optString, hVar);
                        }
                        hVar.mo11639b(jSONObject2);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo11648c(JSONObject jSONObject) {
        String str = "EventTypeSampling";
        Logger.m3833a(str, "[updateEventTypeTriggerCount]", this, jSONObject);
        if (jSONObject != null) {
            try {
                int optInt = jSONObject.optInt("cacheCount");
                if (optInt > 0 && this.f3216b != null) {
                    this.f3216b.mo11570b(optInt);
                }
            } catch (Throwable th) {
                Logger.m3832a(str, "updateTriggerCount", th);
            }
        }
    }

    /* renamed from: b */
    public void mo11646b(int i) {
        this.f3202a = i;
    }
}
