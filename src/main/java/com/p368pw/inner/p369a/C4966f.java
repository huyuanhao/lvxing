package com.p368pw.inner.p369a;

import com.p368pw.inner.base.p387d.C5205o;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.pw.inner.a.f */
public class C4966f {
    /* renamed from: a */
    private String f16142a;
    /* renamed from: b */
    private int f16143b;
    /* renamed from: c */
    private String f16144c;
    /* renamed from: d */
    private ArrayList<C4967g> f16145d;

    public C4966f(int i, String str) {
        this.f16145d = new ArrayList<>();
        this.f16142a = str;
        this.f16144c = "";
        this.f16145d.add(new C4967g(i, str));
        this.f16143b = 10;
    }

    public C4966f(JSONObject jSONObject) {
        String str = "placement_type";
        String str2 = "priority";
        String str3 = "placement_id";
        try {
            String str4 = "";
            if (jSONObject.has(str3)) {
                this.f16142a = jSONObject.optString(str3, str4);
            }
            if (jSONObject.has(str2)) {
                this.f16143b = jSONObject.optInt(str2, 0);
            }
            if (jSONObject.has(str)) {
                this.f16144c = jSONObject.optString(str, str4);
            }
            this.f16145d = new ArrayList<>();
            JSONArray optJSONArray = jSONObject.optJSONArray("th_placements");
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.f16145d.add(new C4967g(optJSONArray.optJSONObject(i)));
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: a */
    public String mo26292a() {
        return this.f16142a;
    }

    /* renamed from: b */
    public ArrayList<C4967g> mo26293b() {
        return this.f16145d;
    }
}
