package com.p368pw.inner.p369a.p370a.p373c.p374a;

import android.text.TextUtils;
import com.p368pw.inner.C5228c;
import com.p368pw.inner.base.C5114a;
import com.p368pw.inner.base.p387d.C5162b;
import com.p368pw.inner.base.p387d.C5188f;
import com.p368pw.inner.base.p387d.C5194l;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.C5207q;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.pw.inner.a.a.c.a.a */
public class C4840a extends C5114a<Map<String, String>> {
    /* renamed from: a */
    private String f15599a;
    /* renamed from: b */
    private String f15600b;
    /* renamed from: c */
    private List<String> f15601c;
    /* renamed from: d */
    private List<String> f15602d;

    /* renamed from: d */
    private String m19872d() {
        return C5228c.m21539a("https://adx-api.zzpolarb.com/api/v1/img/getbanner");
    }

    /* renamed from: a */
    public C4840a mo25844a(String str) {
        this.f15599a = str;
        return this;
    }

    /* renamed from: a */
    public C4840a mo25845a(List<String> list) {
        this.f15601c = list;
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo25762a() {
        try {
            if (!C5188f.m21377a((Collection) this.f15601c) || !C5188f.m21377a((Collection) this.f15602d)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appkey", this.f15599a);
                jSONObject.put("placementid", this.f15600b);
                jSONObject.put("adsource", 5);
                String str = "ad_pkgs";
                String str2 = "ad_titles";
                if (C5188f.m21379b(this.f15601c)) {
                    JSONArray jSONArray = new JSONArray();
                    for (String put : this.f15601c) {
                        jSONArray.put(put);
                    }
                    jSONObject.put(str, jSONArray);
                } else {
                    JSONArray jSONArray2 = new JSONArray();
                    for (String put2 : this.f15602d) {
                        jSONArray2.put(put2);
                    }
                    jSONObject.put(str2, jSONArray2);
                }
                String a = C5194l.m21436e(m19872d()).mo26816h(C5162b.m21305a().mo26770a(jSONObject.toString(), true)).mo26814b(6).mo26813a();
                if (TextUtils.isEmpty(a)) {
                    C5205o.m21462a("response is empty.");
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject(C5162b.m21305a().mo26772b(a, true));
                int optInt = jSONObject2.optInt("code");
                if (optInt >= 200 && optInt <= 209) {
                    JSONObject optJSONObject = jSONObject2.optJSONObject("data");
                    if (optJSONObject != null) {
                        return C5188f.m21379b(this.f15601c) ? optJSONObject.optJSONObject(str).toString() : optJSONObject.optJSONObject(str2).toString();
                    }
                }
                return null;
            }
            C5205o.m21462a("包名和title不能同时为空");
            return null;
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: b */
    public C4840a mo25846b(List<String> list) {
        this.f15602d = list;
        return this;
    }

    /* renamed from: c */
    public C4840a mo25847c(String str) {
        this.f15600b = str;
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Map<String, String> mo25765b(String str) {
        if (C5207q.m21476a((CharSequence) str)) {
            C5205o.m21462a("result is empty.");
            return null;
        }
        C5205o.m21462a(str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            HashMap hashMap = new HashMap();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                if (!C5207q.m21476a((CharSequence) str2)) {
                    JSONObject optJSONObject = jSONObject.optJSONObject(str2);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("video", "");
                        if (!C5207q.m21476a((CharSequence) optString)) {
                            hashMap.put(str2, optString);
                        }
                    }
                }
            }
            return hashMap;
        } catch (JSONException e) {
            C5205o.m21464a((Throwable) e);
            return null;
        }
    }
}
