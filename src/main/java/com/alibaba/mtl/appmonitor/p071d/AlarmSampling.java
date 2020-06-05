package com.alibaba.mtl.appmonitor.p071d;

import com.alibaba.mtl.appmonitor.p068a.EventType;
import com.alibaba.mtl.appmonitor.p073f.StringUtils;
import com.alibaba.mtl.log.p077d.Logger;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.alibaba.mtl.appmonitor.d.f */
public class AlarmSampling extends EventTypeSampling {
    /* renamed from: b */
    String f3213b = "AlarmSampling";
    /* renamed from: e */
    private int f3214e = 0;
    /* renamed from: f */
    private int f3215f = 0;

    /* renamed from: a */
    public /* bridge */ /* synthetic */ boolean mo11645a(int i, String str, String str2, Map map) {
        return super.mo11645a(i, str, str2, map);
    }

    public AlarmSampling(EventType fVar, int i) {
        super(fVar, i);
        this.f3214e = i;
        this.f3215f = i;
    }

    /* renamed from: a */
    public boolean mo11644a(int i, String str, String str2, Boolean bool, Map<String, String> map) {
        String str3 = this.f3213b;
        boolean z = false;
        StringBuilder sb = new StringBuilder();
        sb.append("failSampling:");
        sb.append(this.f3215f);
        Logger.m3833a(str3, "samplingSeed:", Integer.valueOf(i), "isSuccess:", bool, "successSampling:", Integer.valueOf(this.f3214e), sb.toString());
        if (this.f3217c != null) {
            ModuleSampling hVar = (ModuleSampling) this.f3217c.get(str);
            if (hVar != null && (hVar instanceof AlarmModuleSampling)) {
                return ((AlarmModuleSampling) hVar).mo11636a(i, str2, bool, map);
            }
        }
        if (bool.booleanValue()) {
            if (i < this.f3214e) {
                z = true;
            }
            return z;
        }
        if (i < this.f3215f) {
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    public void mo11647b(JSONObject jSONObject) {
        mo11631a(jSONObject);
        mo11648c(jSONObject);
        this.f3217c.clear();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("metrics");
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    String string = jSONObject2.getString("module");
                    if (StringUtils.m3589a(string)) {
                        ModuleSampling hVar = (ModuleSampling) this.f3217c.get(string);
                        if (hVar == null) {
                            hVar = new AlarmModuleSampling(string, this.f3214e, this.f3215f);
                            this.f3217c.put(string, hVar);
                        }
                        hVar.mo11639b(jSONObject2);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo11631a(JSONObject jSONObject) {
        super.mo11631a(jSONObject);
        this.f3214e = this.f3202a;
        this.f3215f = this.f3202a;
        try {
            Integer valueOf = Integer.valueOf(jSONObject.getInt("successSampling"));
            if (valueOf != null) {
                this.f3214e = valueOf.intValue();
            }
            Integer valueOf2 = Integer.valueOf(jSONObject.getInt("failSampling"));
            if (valueOf2 != null) {
                this.f3215f = valueOf2.intValue();
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    public void mo11646b(int i) {
        super.mo11646b(i);
        this.f3214e = i;
        this.f3215f = i;
    }
}
