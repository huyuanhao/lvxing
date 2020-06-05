package com.alibaba.mtl.appmonitor.p071d;

import com.alibaba.mtl.appmonitor.p073f.StringUtils;
import com.alibaba.mtl.log.p077d.Logger;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.alibaba.mtl.appmonitor.d.d */
public class AlarmModuleSampling extends ModuleSampling {
    /* renamed from: c */
    private int f3209c = this.f3202a;
    /* renamed from: d */
    private int f3210d = this.f3202a;

    /* renamed from: a */
    public /* bridge */ /* synthetic */ boolean mo11637a(int i, String str, Map map) {
        return super.mo11637a(i, str, map);
    }

    public AlarmModuleSampling(String str, int i, int i2) {
        super(str, 0);
    }

    /* renamed from: a */
    public boolean mo11636a(int i, String str, Boolean bool, Map<String, String> map) {
        Logger.m3833a("AlarmModuleSampling", "samplingSeed:", Integer.valueOf(i), "isSuccess:", bool, "successSampling:", Integer.valueOf(this.f3209c), "failSampling:", Integer.valueOf(this.f3210d));
        if (this.f3219b != null) {
            MonitorPointSampling iVar = (MonitorPointSampling) this.f3219b.get(str);
            if (iVar != null && (iVar instanceof AlarmMonitorPointSampling)) {
                return ((AlarmMonitorPointSampling) iVar).mo11640a(i, bool, map);
            }
        }
        return mo11638a(i, bool.booleanValue());
    }

    /* renamed from: b */
    public void mo11639b(JSONObject jSONObject) {
        mo11631a(jSONObject);
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("monitorPoints");
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    String string = jSONObject2.getString("monitorPoint");
                    if (StringUtils.m3589a(string)) {
                        MonitorPointSampling iVar = (MonitorPointSampling) this.f3219b.get(string);
                        if (iVar == null) {
                            iVar = new AlarmMonitorPointSampling(string, this.f3209c, this.f3210d);
                            this.f3219b.put(string, iVar);
                        }
                        iVar.mo11643b(jSONObject2);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo11638a(int i, boolean z) {
        boolean z2 = true;
        if (z) {
            if (i >= this.f3209c) {
                z2 = false;
            }
            return z2;
        }
        if (i >= this.f3210d) {
            z2 = false;
        }
        return z2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo11631a(JSONObject jSONObject) {
        String str = "failSampling";
        super.mo11631a(jSONObject);
        this.f3209c = this.f3202a;
        this.f3210d = this.f3202a;
        try {
            Integer valueOf = Integer.valueOf(jSONObject.getInt("successSampling"));
            if (valueOf != null) {
                this.f3209c = valueOf.intValue();
            }
            Integer valueOf2 = Integer.valueOf(jSONObject.getInt(str));
            if (valueOf2 != null) {
                this.f3210d = valueOf2.intValue();
            }
            Logger.m3833a("AlarmModuleSampling", "[updateSelfSampling]", jSONObject, "successSampling:", valueOf, str);
        } catch (Exception unused) {
        }
    }
}
