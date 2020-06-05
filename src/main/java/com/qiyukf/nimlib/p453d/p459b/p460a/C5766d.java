package com.qiyukf.nimlib.p453d.p459b.p460a;

import com.qiyukf.nimlib.p453d.p459b.C5762a;
import com.tencent.mid.api.MidEntity;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.qiyukf.nimlib.d.b.a.d */
public final class C5766d implements C5762a {
    /* renamed from: a */
    private String f18359a;
    /* renamed from: b */
    private String f18360b;
    /* renamed from: c */
    private String f18361c;
    /* renamed from: d */
    private String f18362d;
    /* renamed from: e */
    private long f18363e;
    /* renamed from: f */
    private long f18364f;
    /* renamed from: g */
    private String f18365g;
    /* renamed from: h */
    private String f18366h;
    /* renamed from: i */
    private String f18367i;
    /* renamed from: j */
    private String f18368j;
    /* renamed from: k */
    private String f18369k;

    C5766d(String str, String str2, String str3, long j, long j2, String str4, int i, String str5, String str6, String str7) {
        this.f18359a = str;
        this.f18360b = str2;
        this.f18361c = str3;
        this.f18363e = j;
        this.f18364f = j2;
        this.f18365g = str4;
        this.f18367i = str5;
        this.f18366h = String.valueOf(i);
        this.f18368j = str6;
        this.f18369k = str7;
    }

    /* renamed from: a */
    public final JSONObject mo28034a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("brand", this.f18359a);
            jSONObject.put("model", this.f18360b);
            jSONObject.put(MidEntity.TAG_IMEI, this.f18361c);
            jSONObject.put("disk_size", this.f18363e);
            jSONObject.put("memory_size", this.f18364f);
            jSONObject.put("system_name", this.f18365g);
            jSONObject.put("system_version", this.f18366h);
            jSONObject.put("rom", this.f18367i);
            jSONObject.put("language", this.f18368j);
            jSONObject.put("timezone", this.f18369k);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DeviceInfo{brand='");
        sb.append(this.f18359a);
        sb.append('\'');
        sb.append(", model='");
        sb.append(this.f18360b);
        sb.append('\'');
        sb.append(", imei='");
        sb.append(this.f18361c);
        sb.append('\'');
        sb.append(", mac='");
        sb.append(this.f18362d);
        sb.append('\'');
        sb.append(", diskSize=");
        sb.append(this.f18363e);
        sb.append(", memorySize=");
        sb.append(this.f18364f);
        sb.append(", systemName='");
        sb.append(this.f18365g);
        sb.append('\'');
        sb.append(", systemVersion='");
        sb.append(this.f18366h);
        sb.append('\'');
        sb.append(", rom='");
        sb.append(this.f18367i);
        sb.append('\'');
        sb.append(", language='");
        sb.append(this.f18368j);
        sb.append('\'');
        sb.append(", timeZone='");
        sb.append(this.f18369k);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
