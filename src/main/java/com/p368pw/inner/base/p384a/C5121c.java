package com.p368pw.inner.base.p384a;

import android.text.TextUtils;
import com.p368pw.inner.base.p387d.C5205o;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.pw.inner.base.a.c */
public class C5121c {
    /* renamed from: a */
    private int f16673a;
    /* renamed from: b */
    private String f16674b;
    /* renamed from: c */
    private int f16675c;
    /* renamed from: d */
    private List<C5122a> f16676d;

    /* renamed from: com.pw.inner.base.a.c$a */
    public static class C5122a {
        /* renamed from: a */
        private int f16677a;
        /* renamed from: b */
        private int f16678b;
        /* renamed from: c */
        private int f16679c;

        public C5122a(int i, int i2, int i3) {
            this.f16677a = i;
            this.f16678b = i2;
            this.f16679c = i3;
        }

        /* renamed from: a */
        public int mo26670a() {
            return this.f16677a;
        }

        /* renamed from: b */
        public int mo26671b() {
            return this.f16678b;
        }

        /* renamed from: c */
        public int mo26672c() {
            return this.f16679c;
        }
    }

    public C5121c(int i) {
        this.f16675c = 1;
        this.f16676d = new ArrayList();
        this.f16673a = 200;
        this.f16674b = "";
        this.f16675c = 1;
        this.f16676d.add(new C5122a(0, 0, 0));
    }

    public C5121c(String str) {
        this.f16675c = 1;
        this.f16676d = new ArrayList();
        try {
            if (TextUtils.isEmpty(str)) {
                C5205o.m21462a("ctl rp em");
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ctl rp jsonstr = ");
            sb.append(str);
            C5205o.m21462a(sb.toString());
            JSONObject jSONObject = new JSONObject(str);
            this.f16675c = jSONObject.optInt("adReqSwitch", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("reqColList");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        this.f16676d.add(new C5122a(optJSONObject.optInt("reqT", 0), optJSONObject.optInt("reqC", 0), optJSONObject.optInt("type", 0)));
                    }
                }
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: a */
    public int mo26668a() {
        return this.f16675c;
    }

    /* renamed from: b */
    public List<C5122a> mo26669b() {
        return this.f16676d;
    }
}
