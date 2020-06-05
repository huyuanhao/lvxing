package com.alibaba.mtl.appmonitor.p071d;

import com.alibaba.mtl.appmonitor.model.ConfigMetric;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.Metric;
import com.alibaba.mtl.appmonitor.model.MetricRepo;
import com.alibaba.mtl.appmonitor.p073f.StringUtils;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.alibaba.mtl.appmonitor.d.h */
class ModuleSampling extends AbstractSampling<JSONObject> {
    /* renamed from: b */
    protected Map<String, MonitorPointSampling> f3219b = new HashMap();
    /* renamed from: c */
    private String f3220c;

    public ModuleSampling(String str, int i) {
        super(i);
        this.f3220c = str;
    }

    /* renamed from: a */
    public boolean mo11637a(int i, String str, Map<String, String> map) {
        Map<String, MonitorPointSampling> map2 = this.f3219b;
        if (map2 != null) {
            MonitorPointSampling iVar = (MonitorPointSampling) map2.get(str);
            if (iVar != null) {
                return iVar.mo11641a(i, map);
            }
        }
        return mo11632a(i);
    }

    /* renamed from: b */
    public void mo11639b(JSONObject jSONObject) {
        String str = "config_prefix";
        mo11631a(jSONObject);
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("monitorPoints");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    String optString = jSONObject2.optString("monitorPoint");
                    String optString2 = jSONObject2.optString("metric_comment_detail");
                    if (StringUtils.m3589a(optString)) {
                        MonitorPointSampling iVar = (MonitorPointSampling) this.f3219b.get(optString);
                        if (iVar == null) {
                            iVar = new MonitorPointSampling(optString, this.f3202a);
                            this.f3219b.put(optString, iVar);
                        }
                        iVar.mo11643b(jSONObject2);
                        Metric a = MetricRepo.m3683a().mo11758a(this.f3220c, optString);
                        if (a != null) {
                            a.mo11748a(optString2);
                        }
                        Object opt = jSONObject2.opt("measures");
                        if (opt instanceof JSONArray) {
                            JSONArray jSONArray = (JSONArray) opt;
                            MeasureSet a2 = MeasureSet.m3634a();
                            int length = jSONArray.length();
                            for (int i2 = 0; i2 < length; i2++) {
                                JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                                if (jSONObject3 != null) {
                                    String optString3 = jSONObject3.optString(ArgKey.KEY_NAME);
                                    Double valueOf = Double.valueOf(jSONObject3.optDouble(MessageKey.MSG_ACCEPT_TIME_MIN));
                                    Double valueOf2 = Double.valueOf(jSONObject3.optDouble("max"));
                                    if (!(optString3 == null || valueOf == null || valueOf2 == null)) {
                                        a2.mo11711a(new Measure(optString3, Double.valueOf(0.0d), valueOf, valueOf2));
                                    }
                                }
                            }
                            MetricRepo a3 = MetricRepo.m3683a();
                            StringBuilder sb = new StringBuilder();
                            sb.append(str);
                            sb.append(this.f3220c);
                            String sb2 = sb.toString();
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(str);
                            sb3.append(optString);
                            Metric a4 = a3.mo11758a(sb2, sb3.toString());
                            if (a4 != null) {
                                MetricRepo.m3683a().mo11760b(a4);
                            }
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append(str);
                            sb4.append(this.f3220c);
                            String sb5 = sb4.toString();
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append(str);
                            sb6.append(optString);
                            MetricRepo.m3683a().mo11759a(new ConfigMetric(sb5, sb6.toString(), a2));
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }
}
