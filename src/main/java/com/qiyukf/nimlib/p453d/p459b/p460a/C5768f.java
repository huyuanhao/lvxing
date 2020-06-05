package com.qiyukf.nimlib.p453d.p459b.p460a;

import com.qiyukf.nimlib.p453d.p459b.C5762a;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.qiyukf.nimlib.d.b.a.f */
public final class C5768f implements C5762a {
    /* renamed from: a */
    private int f18370a;
    /* renamed from: b */
    private int f18371b;
    /* renamed from: c */
    private String f18372c;
    /* renamed from: d */
    private String f18373d;
    /* renamed from: e */
    private String f18374e;

    C5768f(int i, int i2, String str, String str2, String str3) {
        this.f18370a = i;
        this.f18371b = i2;
        this.f18372c = str;
        this.f18373d = str2;
        this.f18374e = str3;
    }

    /* renamed from: a */
    public final JSONObject mo28034a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mnc", this.f18371b);
            jSONObject.put("mcc", this.f18370a);
            jSONObject.put("raido_tech", this.f18372c);
            jSONObject.put("carrier_name", this.f18373d);
            jSONObject.put("iso_cc", this.f18374e);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("OperatorInfo{mcc=");
        sb.append(this.f18370a);
        sb.append(", mnc=");
        sb.append(this.f18371b);
        sb.append(", networkType='");
        sb.append(this.f18372c);
        sb.append('\'');
        sb.append(", networkOperatorName='");
        sb.append(this.f18373d);
        sb.append('\'');
        sb.append(", networkCountryIso='");
        sb.append(this.f18374e);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
