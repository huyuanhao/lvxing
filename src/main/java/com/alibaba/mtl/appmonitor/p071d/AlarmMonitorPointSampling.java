package com.alibaba.mtl.appmonitor.p071d;

import com.alibaba.mtl.log.p077d.Logger;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.alibaba.mtl.appmonitor.d.e */
public class AlarmMonitorPointSampling extends MonitorPointSampling {
    /* renamed from: c */
    private int f3211c;
    /* renamed from: d */
    private int f3212d;

    /* renamed from: a */
    public /* bridge */ /* synthetic */ boolean mo11641a(int i, Map map) {
        return super.mo11641a(i, map);
    }

    public AlarmMonitorPointSampling(String str, int i, int i2) {
        super(str, 0);
        this.f3211c = i;
        this.f3212d = i2;
    }

    /* renamed from: a */
    public boolean mo11640a(int i, Boolean bool, Map<String, String> map) {
        Logger.m3833a("AlarmMonitorPointSampling", "samplingSeed:", Integer.valueOf(i), "isSuccess:", bool, "successSampling:", Integer.valueOf(this.f3211c), "failSampling:", Integer.valueOf(this.f3212d));
        if (!(this.f3221b == null || map == null)) {
            for (AccurateSampling a : this.f3221b) {
                Boolean a2 = a.mo11634a(i, map);
                if (a2 != null) {
                    return a2.booleanValue();
                }
            }
        }
        return mo11642a(i, bool.booleanValue());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo11642a(int i, boolean z) {
        boolean z2 = true;
        if (z) {
            if (i >= this.f3211c) {
                z2 = false;
            }
            return z2;
        }
        if (i >= this.f3212d) {
            z2 = false;
        }
        return z2;
    }

    /* renamed from: b */
    public void mo11643b(JSONObject jSONObject) {
        String str = "failSampling";
        super.mo11643b(jSONObject);
        this.f3211c = this.f3202a;
        this.f3212d = this.f3202a;
        try {
            Integer valueOf = Integer.valueOf(jSONObject.getInt("successSampling"));
            if (valueOf != null) {
                this.f3211c = valueOf.intValue();
            }
            Integer valueOf2 = Integer.valueOf(jSONObject.getInt(str));
            if (valueOf2 != null) {
                this.f3212d = valueOf2.intValue();
            }
            Logger.m3833a("AlarmMonitorPointSampling", "[updateSelfSampling]", jSONObject, "successSampling:", valueOf, str, valueOf2);
        } catch (Exception unused) {
        }
    }
}
