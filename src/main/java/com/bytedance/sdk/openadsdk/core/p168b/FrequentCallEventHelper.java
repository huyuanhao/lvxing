package com.bytedance.sdk.openadsdk.core.p168b;

import android.content.Context;
import com.bytedance.sdk.adnet.p159b.JsonStringRequest;
import com.bytedance.sdk.openadsdk.p188g.TTNetClient;
import com.tencent.qqpim.discovery.internal.protocol.C7516p;
import discoveryAD.C7880W.C7881a;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.core.b.c */
public class FrequentCallEventHelper {
    /* renamed from: a */
    public static void m9105a(Context context, String str, long j) {
        new JsonStringRequest(1, "https://i.snssdk.com/api/ad/union/sdk/stats/", m9104a(str, j), null).setRetryPolicy(TTNetClient.m11430b().mo14330a((int) C7516p.f25219Cf)).build(TTNetClient.m11428a(context).mo16657d());
    }

    /* renamed from: a */
    private static JSONObject m9104a(String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "over_freq");
            jSONObject.put("rit", str);
            jSONObject.put("ad_sdk_version", "2.9.5.5");
            jSONObject.put(C7881a.TIMESTAMP, j);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
