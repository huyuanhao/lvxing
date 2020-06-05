package com.bytedance.sdk.openadsdk.p185f.p186a;

import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.f.a.c */
public class LoadAdNoRspLog extends LogStatsBase<LoadAdNoRspLog> {
    /* renamed from: a */
    private long f8642a;
    /* renamed from: b */
    private long f8643b;

    /* renamed from: a */
    public LoadAdNoRspLog mo16588a(long j) {
        this.f8642a = j;
        return this;
    }

    /* renamed from: b */
    public LoadAdNoRspLog mo16589b(long j) {
        this.f8643b = j;
        return this;
    }

    /* renamed from: a */
    public JSONObject mo16587a() {
        JSONObject a = super.mo16587a();
        try {
            a.put("c_process_time", this.f8642a);
            a.put("s_process_time", this.f8643b);
        } catch (Exception unused) {
        }
        return a;
    }
}
