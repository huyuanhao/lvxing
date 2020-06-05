package com.p368pw.inner.p369a.p370a.p371a;

import android.text.TextUtils;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.C5207q;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.pw.inner.a.a.a.d */
public class C4826d {
    /* renamed from: a */
    private String f15499a;
    /* renamed from: b */
    private String f15500b;
    /* renamed from: c */
    private String f15501c;
    /* renamed from: d */
    private String f15502d;
    /* renamed from: e */
    private String f15503e;
    /* renamed from: f */
    private String f15504f;
    /* renamed from: g */
    private String f15505g;
    /* renamed from: h */
    private int f15506h;
    /* renamed from: i */
    private String f15507i;
    /* renamed from: j */
    private String f15508j;
    /* renamed from: k */
    private String f15509k;
    /* renamed from: l */
    private JSONArray f15510l;
    /* renamed from: m */
    private JSONArray f15511m;
    /* renamed from: n */
    private JSONArray f15512n;
    /* renamed from: o */
    private JSONArray f15513o;
    /* renamed from: p */
    private JSONArray f15514p;
    /* renamed from: q */
    private JSONArray f15515q;
    /* renamed from: r */
    private int f15516r;
    /* renamed from: s */
    private int f15517s;
    /* renamed from: t */
    private String f15518t;
    /* renamed from: u */
    private String f15519u;
    /* renamed from: v */
    private int f15520v;
    /* renamed from: w */
    private String f15521w;

    public C4826d(String str) {
        String str2 = "";
        try {
            if (TextUtils.isEmpty(str)) {
                C5205o.m21462a("hf em");
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("hf jsonStr = ");
            sb.append(str);
            C5205o.m21462a(sb.toString());
            JSONObject jSONObject = new JSONObject(str);
            this.f15499a = jSONObject.optString("html", str2);
            this.f15500b = jSONObject.optString("img", str2);
            this.f15501c = jSONObject.optString(ArgKey.KEY_NAME, str2);
            this.f15502d = jSONObject.optString("pkg", str2);
            this.f15503e = jSONObject.optString("icon", str2);
            this.f15504f = jSONObject.optString(ArgKey.KEY_DESC, str2);
            this.f15505g = jSONObject.optString("ad_choice", str2);
            this.f15506h = jSONObject.optInt("track_gdt", 0);
            this.f15507i = jSONObject.optString("down_url", str2);
            this.f15508j = C5207q.m21477b(jSONObject.optString(C7887a.f26867sh, str2));
            this.f15509k = jSONObject.optString("deep_url", str2);
            this.f15510l = jSONObject.optJSONArray("imps");
            this.f15511m = jSONObject.optJSONArray("clicks");
            this.f15512n = jSONObject.optJSONArray("install_start_url");
            this.f15513o = jSONObject.optJSONArray("install_end_url");
            this.f15514p = jSONObject.optJSONArray("download_start_url");
            this.f15515q = jSONObject.optJSONArray("download_end_url");
            this.f15516r = jSONObject.optInt("s_placement_type");
            this.f15517s = jSONObject.optInt("s_ads_source");
            this.f15518t = jSONObject.optString("s_act_param");
            this.f15519u = jSONObject.optString("s_act_param2");
            this.f15520v = jSONObject.optInt("adsource");
            this.f15521w = jSONObject.optString("offerid", str2);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: a */
    public String mo25769a() {
        return this.f15499a;
    }

    /* renamed from: b */
    public String mo25770b() {
        return this.f15500b;
    }

    /* renamed from: c */
    public String mo25771c() {
        return this.f15501c;
    }

    /* renamed from: d */
    public String mo25772d() {
        return this.f15502d;
    }

    /* renamed from: e */
    public String mo25773e() {
        return this.f15503e;
    }

    /* renamed from: f */
    public String mo25774f() {
        return this.f15504f;
    }

    /* renamed from: g */
    public String mo25775g() {
        return this.f15505g;
    }

    /* renamed from: h */
    public String mo25776h() {
        return this.f15507i;
    }

    /* renamed from: i */
    public String mo25777i() {
        return this.f15508j;
    }

    /* renamed from: j */
    public String mo25778j() {
        return this.f15509k;
    }

    /* renamed from: k */
    public JSONArray mo25779k() {
        return this.f15510l;
    }

    /* renamed from: l */
    public JSONArray mo25780l() {
        return this.f15511m;
    }

    /* renamed from: m */
    public JSONArray mo25781m() {
        return this.f15512n;
    }

    /* renamed from: n */
    public JSONArray mo25782n() {
        return this.f15513o;
    }

    /* renamed from: o */
    public JSONArray mo25783o() {
        return this.f15514p;
    }

    /* renamed from: p */
    public JSONArray mo25784p() {
        return this.f15515q;
    }

    /* renamed from: q */
    public int mo25785q() {
        return this.f15520v;
    }

    /* renamed from: r */
    public String mo25786r() {
        return this.f15521w;
    }
}
