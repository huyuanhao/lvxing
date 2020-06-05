package com.p368pw.inner.appwall;

import com.p368pw.inner.base.p387d.C5162b;
import com.p368pw.inner.base.p387d.C5205o;
import org.json.JSONObject;

/* renamed from: com.pw.inner.appwall.k */
public class C5030k {
    /* renamed from: a */
    private int f16384a = 1;
    /* renamed from: b */
    private int f16385b = 3;
    /* renamed from: c */
    private int f16386c = 10;
    /* renamed from: d */
    private String f16387d = "精选热门应用";
    /* renamed from: e */
    private String f16388e = "下载试玩应用得奖励，应用官方已认证，请放心下载体验。    每日签到应用还可领更多奖励！";
    /* renamed from: f */
    private String f16389f = "疯狂点击领奖励";
    /* renamed from: g */
    private String f16390g = "官方认证，打开试玩应用1分钟立即获取奖励!";
    /* renamed from: h */
    private String f16391h = "签到领奖励";
    /* renamed from: i */
    private String f16392i = "每天签到每天领，连续签到7天领大礼!";
    /* renamed from: j */
    private String f16393j = "立即安装";
    /* renamed from: k */
    private String f16394k = "马上打开";
    /* renamed from: l */
    private String f16395l = "立即下载";
    /* renamed from: m */
    private String f16396m = "下载领奖励";
    /* renamed from: n */
    private String f16397n = "下载后，成功安装并打开试玩1分钟，就能获取奖励！";
    /* renamed from: o */
    private int f16398o = 10;
    /* renamed from: p */
    private int f16399p = 10;
    /* renamed from: q */
    private int f16400q = 5;
    /* renamed from: r */
    private int f16401r = 6;
    /* renamed from: s */
    private int f16402s = 2;
    /* renamed from: t */
    private int f16403t = 3;
    /* renamed from: u */
    private int f16404u = 1;
    /* renamed from: v */
    private String f16405v = "正在下载，请稍等";
    /* renamed from: w */
    private String f16406w = "应用下载成功，官方已验证，请放心安装";
    /* renamed from: x */
    private int f16407x;
    /* renamed from: y */
    private int f16408y;
    /* renamed from: z */
    private int f16409z;

    public C5030k(String str) {
        if (str != null) {
            try {
                if (!"".equals(str)) {
                    JSONObject jSONObject = new JSONObject(C5162b.m21305a().mo26771b(str));
                    if (jSONObject.optJSONObject("res_status").optInt("resp_code") == 200) {
                        JSONObject optJSONObject = new JSONObject(jSONObject.optString("body")).optJSONObject("service_399");
                        if (optJSONObject != null) {
                            this.f16407x = optJSONObject.optInt("group_id", 0);
                            this.f16408y = optJSONObject.optInt("plan_id", 0);
                            JSONObject optJSONObject2 = optJSONObject.optJSONArray("configs").optJSONObject(0);
                            this.f16385b = optJSONObject2.optInt("za", 10);
                            this.f16386c = optJSONObject2.optInt("zb", 10);
                            this.f16387d = optJSONObject2.optString("zp");
                            this.f16388e = optJSONObject2.optString("zc");
                            this.f16389f = optJSONObject2.optString("zl");
                            this.f16390g = optJSONObject2.optString("zd");
                            this.f16393j = optJSONObject2.optString("ze");
                            this.f16394k = optJSONObject2.optString("zf");
                            this.f16395l = optJSONObject2.optString("zg");
                            this.f16396m = optJSONObject2.optString("zm");
                            this.f16397n = optJSONObject2.optString("zh");
                            this.f16391h = optJSONObject2.optString("zn");
                            this.f16392i = optJSONObject2.optString("zo");
                            this.f16398o = optJSONObject2.optInt("zi", 10);
                            this.f16399p = optJSONObject2.optInt("zj", 10);
                            this.f16400q = optJSONObject2.optInt("zk", 20);
                            this.f16401r = optJSONObject2.optInt("zw", 6);
                            this.f16403t = optJSONObject2.optInt("zq", 2);
                            this.f16402s = optJSONObject2.optInt("zr", 1);
                            this.f16404u = optJSONObject2.optInt("zs", 3);
                            this.f16405v = optJSONObject2.optString("zu");
                            this.f16406w = optJSONObject2.optString("zt");
                            this.f16384a = optJSONObject2.optInt("zz");
                            this.f16409z = optJSONObject2.optInt("config_id", 0);
                            C5205o.m21462a("wl sty en");
                        }
                    }
                    return;
                }
            } catch (Throwable th) {
                C5205o.m21464a(th);
            }
        }
        C5205o.m21462a("wl sty rs em");
    }

    /* renamed from: a */
    public int mo26434a() {
        return this.f16407x;
    }

    /* renamed from: b */
    public int mo26435b() {
        return this.f16408y;
    }

    /* renamed from: c */
    public int mo26436c() {
        return this.f16409z;
    }

    /* renamed from: d */
    public int mo26437d() {
        return this.f16386c;
    }

    /* renamed from: e */
    public String mo26438e() {
        return this.f16387d;
    }

    /* renamed from: f */
    public String mo26439f() {
        return this.f16388e;
    }

    /* renamed from: g */
    public String mo26440g() {
        return this.f16389f;
    }

    /* renamed from: h */
    public String mo26441h() {
        return this.f16390g;
    }

    /* renamed from: i */
    public String mo26442i() {
        return this.f16393j;
    }

    /* renamed from: j */
    public String mo26443j() {
        return this.f16394k;
    }

    /* renamed from: k */
    public String mo26444k() {
        return this.f16395l;
    }

    /* renamed from: l */
    public String mo26445l() {
        return this.f16396m;
    }

    /* renamed from: m */
    public String mo26446m() {
        return this.f16397n;
    }

    /* renamed from: n */
    public String mo26447n() {
        return this.f16391h;
    }

    /* renamed from: o */
    public String mo26448o() {
        return this.f16392i;
    }

    /* renamed from: p */
    public int mo26449p() {
        return this.f16398o;
    }

    /* renamed from: q */
    public int mo26450q() {
        return this.f16399p;
    }

    /* renamed from: r */
    public int mo26451r() {
        return this.f16400q;
    }

    /* renamed from: s */
    public int mo26452s() {
        return this.f16401r;
    }

    /* renamed from: t */
    public int mo26453t() {
        return this.f16403t;
    }

    /* renamed from: u */
    public int mo26454u() {
        return this.f16402s;
    }

    /* renamed from: v */
    public int mo26455v() {
        return this.f16404u;
    }

    /* renamed from: w */
    public String mo26456w() {
        return this.f16405v;
    }

    /* renamed from: x */
    public String mo26457x() {
        return this.f16406w;
    }

    /* renamed from: y */
    public int mo26458y() {
        return this.f16384a;
    }
}
