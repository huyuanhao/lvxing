package com.bytedance.sdk.openadsdk.core.p174h;

import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import com.tencent.android.tpush.common.MessageKey;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.core.h.d */
public class DnsItem {
    /* renamed from: a */
    String f7624a;
    /* renamed from: b */
    int f7625b;
    /* renamed from: c */
    JSONArray f7626c;
    /* renamed from: d */
    List<String> f7627d = new ArrayList();
    /* renamed from: e */
    long f7628e;
    /* renamed from: f */
    volatile boolean f7629f;

    private DnsItem() {
    }

    /* renamed from: a */
    public static DnsItem m9709a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            DnsItem dVar = new DnsItem();
            dVar.mo15731a(jSONObject.optString("host"));
            dVar.mo15729a(jSONObject.optInt(MessageKey.MSG_TTL, 60));
            dVar.mo15732a(jSONObject.optJSONArray("ips"));
            dVar.mo15733a(jSONObject.optBoolean(" statsdnstime", false));
            long optLong = jSONObject.optLong("starttime", 0);
            if (optLong > 0) {
                dVar.mo15730a(optLong);
            } else {
                dVar.mo15730a(System.currentTimeMillis());
            }
            return dVar;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public String mo15728a() {
        return this.f7624a;
    }

    /* renamed from: a */
    public void mo15731a(String str) {
        this.f7624a = str;
    }

    /* renamed from: b */
    public int mo15734b() {
        return this.f7625b;
    }

    /* renamed from: a */
    public void mo15729a(int i) {
        this.f7625b = i;
    }

    /* renamed from: c */
    public JSONArray mo15735c() {
        return this.f7626c;
    }

    /* renamed from: a */
    public void mo15732a(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.f7626c = jSONArray;
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    String obj = jSONArray.get(i).toString();
                    if (ToolUtils.m12041l(obj)) {
                        this.f7627d.add(obj);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* renamed from: d */
    public boolean mo15736d() {
        return System.currentTimeMillis() - mo15738f() > ((long) (mo15734b() * 1000));
    }

    /* renamed from: e */
    public String mo15737e() {
        List<String> list = this.f7627d;
        if (list == null || list.size() == 0) {
            return null;
        }
        int random = ((int) ((Math.random() * ((double) this.f7627d.size())) + 0.5d)) - 1;
        if (random < 0) {
            random = 0;
        }
        return (String) this.f7627d.get(random);
    }

    /* renamed from: f */
    public long mo15738f() {
        return this.f7628e;
    }

    /* renamed from: a */
    public void mo15730a(long j) {
        this.f7628e = j;
    }

    /* renamed from: g */
    public boolean mo15739g() {
        return this.f7629f;
    }

    /* renamed from: a */
    public void mo15733a(boolean z) {
        this.f7629f = z;
    }

    /* renamed from: h */
    public JSONObject mo15740h() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("host", mo15728a());
            jSONObject.put(MessageKey.MSG_TTL, mo15734b());
            jSONObject.put("ips", mo15735c());
            jSONObject.put("starttime", mo15738f());
            jSONObject.put("statsdnstime", mo15739g());
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
