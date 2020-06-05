package com.alibaba.baichuan.trade.biz.auth;

import com.alibaba.baichuan.trade.common.utils.C1224a;
import com.alibaba.baichuan.trade.common.utils.C1229c;
import com.alibaba.baichuan.trade.common.utils.p064a.C1225a;
import org.json.JSONObject;

/* renamed from: com.alibaba.baichuan.trade.biz.auth.b */
public class C1145b {
    /* renamed from: a */
    private String f2361a;
    /* renamed from: b */
    private long f2362b;
    /* renamed from: c */
    private long f2363c;

    /* renamed from: com.alibaba.baichuan.trade.biz.auth.b$a */
    private static class C1147a {
        /* renamed from: a */
        public static C1145b f2364a = new C1145b();
    }

    private C1145b() {
        this.f2361a = "";
        this.f2362b = -1;
        this.f2363c = -1;
        m2231c();
    }

    /* renamed from: a */
    public static C1145b m2230a() {
        return C1147a.f2364a;
    }

    /* renamed from: c */
    private void m2231c() {
        JSONObject a = C1229c.m2423a(C1225a.m2411b("BC_AuthToken"));
        if (a != null) {
            this.f2361a = C1229c.m2420a(a, "AuthToken");
            this.f2362b = C1229c.m2425b(a, "TokenExpires").longValue();
            this.f2363c = C1229c.m2425b(a, "RefreshTime").longValue();
        }
    }

    /* renamed from: d */
    private String m2232d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("AuthToken", this.f2361a);
            jSONObject.put("TokenExpires", this.f2362b);
            jSONObject.put("RefreshTime", this.f2363c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* renamed from: a */
    public synchronized void mo10661a(String str, long j) {
        String str2 = "alibc";
        StringBuilder sb = new StringBuilder();
        sb.append("setToken ");
        sb.append(str);
        C1224a.m2406d(str2, sb.toString());
        this.f2361a = str;
        this.f2362b = System.currentTimeMillis() + (j * 1000);
        this.f2363c = System.currentTimeMillis();
        C1225a.m2413c("BC_AuthToken", m2230a().m2232d());
    }

    /* renamed from: b */
    public String mo10662b() {
        return this.f2361a;
    }
}
