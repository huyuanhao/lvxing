package com.bytedance.sdk.openadsdk.p165c;

import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.NetApi;
import com.bytedance.sdk.openadsdk.core.p174h.SdkSwitch;
import com.bytedance.sdk.openadsdk.p165c.AdEventThread.C2086a;
import com.bytedance.sdk.openadsdk.p165c.AdEventThread.C2087b;
import com.bytedance.sdk.openadsdk.p185f.p187b.LogUploaderImpl.C2424a;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.c.o */
public class StatsEventThread extends AdEventThread<C2424a> {
    /* renamed from: m */
    private NetApi<AdEvent> f6815m;

    public StatsEventThread(String str, String str2, AdEventRepertory eVar, NetApi pVar, C2087b bVar, C2086a aVar) {
        super(str, str2, eVar, pVar, bVar, aVar);
        this.f6815m = InternalContainer.m10067f();
        this.f6764l = true;
    }

    /* renamed from: a */
    public AdEventUploadResult mo15014a(List<C2424a> list) {
        if (this.f6815m == null) {
            this.f6815m = InternalContainer.m10067f();
        }
        if (list == null || list.size() == 0 || !SdkSwitch.m9757a()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            for (C2424a aVar : list) {
                jSONArray.put(aVar.f8664b);
            }
            jSONObject.put("stats_list", jSONArray);
        } catch (Exception unused) {
        }
        return this.f6815m.mo15914a(jSONObject);
    }
}
