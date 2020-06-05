package com.p368pw.inner.p369a.p370a.p371a;

import android.text.TextUtils;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.C5207q;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.pw.inner.a.a.a.f */
public class C4828f {
    /* renamed from: A */
    private String f15522A;
    /* renamed from: a */
    private int f15523a;
    /* renamed from: b */
    private String f15524b;
    /* renamed from: c */
    private String f15525c;
    /* renamed from: d */
    private String f15526d;
    /* renamed from: e */
    private String f15527e;
    /* renamed from: f */
    private String f15528f;
    /* renamed from: g */
    private String f15529g;
    /* renamed from: h */
    private String f15530h;
    /* renamed from: i */
    private String f15531i;
    /* renamed from: j */
    private String f15532j;
    /* renamed from: k */
    private double f15533k;
    /* renamed from: l */
    private int f15534l;
    /* renamed from: m */
    private String f15535m;
    /* renamed from: n */
    private JSONArray f15536n;
    /* renamed from: o */
    private JSONArray f15537o;
    /* renamed from: p */
    private JSONArray f15538p;
    /* renamed from: q */
    private JSONArray f15539q;
    /* renamed from: r */
    private JSONArray f15540r;
    /* renamed from: s */
    private JSONArray f15541s;
    /* renamed from: t */
    private int f15542t;
    /* renamed from: u */
    private int f15543u;
    /* renamed from: v */
    private String f15544v;
    /* renamed from: w */
    private String f15545w;
    /* renamed from: x */
    private int f15546x;
    /* renamed from: y */
    private int f15547y;
    /* renamed from: z */
    private int f15548z;

    public C4828f(String str) {
        String str2 = "img";
        String str3 = "";
        try {
            if (TextUtils.isEmpty(str)) {
                C5205o.m21462a("nb em");
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("nb jsonStr = ");
            sb.append(str);
            C5205o.m21462a(sb.toString());
            JSONObject jSONObject = new JSONObject(str);
            this.f15523a = jSONObject.optInt("track_gdt", 0);
            this.f15524b = jSONObject.optString("icon", str3);
            if (jSONObject.has(str2)) {
                this.f15525c = jSONObject.optString(str2, str3);
            }
            this.f15526d = jSONObject.optString("appname", str3);
            this.f15527e = jSONObject.optString(ArgKey.KEY_DESC, str3);
            this.f15528f = jSONObject.optString("cta", str3);
            this.f15529g = jSONObject.optString("down_url", str3);
            this.f15530h = jSONObject.optString("pkg", str3);
            this.f15531i = C5207q.m21477b(jSONObject.optString(C7887a.f26867sh, str3));
            this.f15532j = jSONObject.optString("ad_choice", str3);
            this.f15535m = jSONObject.optString("deep_url", str3);
            this.f15536n = jSONObject.optJSONArray("imps");
            this.f15537o = jSONObject.optJSONArray("clicks");
            this.f15538p = jSONObject.optJSONArray("install_start_url");
            this.f15539q = jSONObject.optJSONArray("install_end_url");
            this.f15540r = jSONObject.optJSONArray("download_start_url");
            this.f15541s = jSONObject.optJSONArray("download_end_url");
            this.f15542t = jSONObject.optInt("s_placement_type");
            this.f15543u = jSONObject.optInt("s_ads_source");
            this.f15546x = jSONObject.optInt("s_retain_type");
            this.f15547y = jSONObject.optInt("s_type");
            this.f15544v = jSONObject.optString("s_act_param");
            this.f15545w = jSONObject.optString("s_act_param2");
            this.f15548z = jSONObject.optInt("adsource");
            this.f15522A = jSONObject.optString("offerid", str3);
            this.f15533k = jSONObject.optDouble("s_reward", 0.0d);
            this.f15534l = jSONObject.optInt("s_stay_time", 0);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: a */
    public String mo25808a() {
        return this.f15524b;
    }

    /* renamed from: b */
    public String mo25809b() {
        return this.f15525c;
    }

    /* renamed from: c */
    public String mo25810c() {
        return this.f15526d;
    }

    /* renamed from: d */
    public String mo25811d() {
        return this.f15527e;
    }

    /* renamed from: e */
    public String mo25812e() {
        return this.f15528f;
    }

    /* renamed from: f */
    public String mo25813f() {
        return this.f15529g;
    }

    /* renamed from: g */
    public String mo25814g() {
        return this.f15530h;
    }

    /* renamed from: h */
    public String mo25815h() {
        return this.f15531i;
    }

    /* renamed from: i */
    public String mo25816i() {
        return this.f15532j;
    }

    /* renamed from: j */
    public String mo25817j() {
        return this.f15535m;
    }

    /* renamed from: k */
    public JSONArray mo25818k() {
        return this.f15536n;
    }

    /* renamed from: l */
    public JSONArray mo25819l() {
        return this.f15537o;
    }

    /* renamed from: m */
    public JSONArray mo25820m() {
        return this.f15538p;
    }

    /* renamed from: n */
    public JSONArray mo25821n() {
        return this.f15539q;
    }

    /* renamed from: o */
    public JSONArray mo25822o() {
        return this.f15540r;
    }

    /* renamed from: p */
    public JSONArray mo25823p() {
        return this.f15541s;
    }

    /* renamed from: q */
    public int mo25824q() {
        return this.f15542t;
    }

    /* renamed from: r */
    public int mo25825r() {
        return this.f15546x;
    }

    /* renamed from: s */
    public int mo25826s() {
        return this.f15547y;
    }

    /* renamed from: t */
    public double mo25827t() {
        return this.f15533k;
    }

    /* renamed from: u */
    public int mo25828u() {
        return this.f15534l;
    }

    /* renamed from: v */
    public String mo25829v() {
        return this.f15544v;
    }

    /* renamed from: w */
    public String mo25830w() {
        return this.f15545w;
    }

    /* renamed from: x */
    public int mo25831x() {
        return this.f15548z;
    }

    /* renamed from: y */
    public String mo25832y() {
        return this.f15522A;
    }
}
