package com.p368pw.inner.p369a.p377c;

import android.text.TextUtils;
import com.p368pw.inner.C5228c;
import com.p368pw.inner.C5233e;
import com.p368pw.inner.base.C5114a;
import com.p368pw.inner.base.p387d.C5162b;
import com.p368pw.inner.base.p387d.C5194l;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.C5207q;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.pw.inner.a.c.a */
public class C4896a extends C5114a<String> {
    /* renamed from: a */
    private String f15819a = C5233e.m21558a().mo26928c();
    /* renamed from: b */
    private String f15820b;
    /* renamed from: c */
    private int f15821c;
    /* renamed from: d */
    private String f15822d;
    /* renamed from: e */
    private String f15823e;

    public C4896a(String str, int i, String str2, String str3) {
        this.f15820b = str;
        this.f15821c = i;
        this.f15822d = str2;
        this.f15823e = str3;
    }

    /* renamed from: d */
    private String m20186d() {
        return C5228c.m21539a("https://adx-api.zzpolarb.com/api/v1/img/getbanner");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo25762a() {
        try {
            if (!C5207q.m21476a((CharSequence) this.f15822d)) {
                if (!C5207q.m21476a((CharSequence) this.f15823e)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("appkey", this.f15819a);
                    jSONObject.put("placementid", this.f15820b);
                    jSONObject.put("adsource", this.f15821c);
                    String str = "ad_pkgs";
                    String str2 = "ad_titles";
                    if (C5207q.m21478b((CharSequence) this.f15822d)) {
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(this.f15822d);
                        jSONObject.put(str, jSONArray);
                    } else {
                        JSONArray jSONArray2 = new JSONArray();
                        jSONArray2.put(this.f15823e);
                        jSONObject.put(str2, jSONArray2);
                    }
                    String a = C5194l.m21436e(m20186d()).mo26816h(C5162b.m21305a().mo26770a(jSONObject.toString(), true)).mo26814b(5).mo26813a();
                    if (TextUtils.isEmpty(a)) {
                        return null;
                    }
                    JSONObject jSONObject2 = new JSONObject(C5162b.m21305a().mo26772b(a, true));
                    int optInt = jSONObject2.optInt("code");
                    if (optInt >= 200 && optInt <= 209) {
                        JSONObject optJSONObject = jSONObject2.optJSONObject("data");
                        if (optJSONObject != null) {
                            return C5207q.m21478b((CharSequence) this.f15822d) ? optJSONObject.optJSONObject(str).toString() : optJSONObject.optJSONObject(str2).toString();
                        }
                    }
                    return null;
                }
            }
            C5205o.m21462a("pkgName和title不能同时为空");
            return null;
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo25765b(String str) {
        if (C5207q.m21476a((CharSequence) str)) {
            C5205o.m21462a("result is empty.");
            return null;
        }
        C5205o.m21462a(str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                if (!C5207q.m21476a((CharSequence) str2)) {
                    JSONObject optJSONObject = jSONObject.optJSONObject(str2);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("image", "");
                        if (!C5207q.m21476a((CharSequence) optString)) {
                            return optString;
                        }
                    }
                }
            }
        } catch (JSONException e) {
            C5205o.m21464a((Throwable) e);
        }
        return null;
    }
}
