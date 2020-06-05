package com.alipay.sdk.p121b;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.sys.C1536b;
import com.alipay.sdk.util.C1542e;
import com.alipay.sdk.util.C1549k;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.alipay.sdk.b.a */
public final class C1508a {
    /* renamed from: h */
    private static C1508a f3865h;
    /* renamed from: a */
    public boolean f3866a = false;
    /* renamed from: b */
    private int f3867b = 3500;
    /* renamed from: c */
    private String f3868c = "https://h5.m.taobao.com/mlapp/olist.html";
    /* renamed from: d */
    private int f3869d = 10;
    /* renamed from: e */
    private boolean f3870e = true;
    /* renamed from: f */
    private boolean f3871f = true;
    /* renamed from: g */
    private List<C1509a> f3872g = null;

    /* renamed from: com.alipay.sdk.b.a$a */
    public static final class C1509a {
        /* renamed from: a */
        public final String f3873a;
        /* renamed from: b */
        public final int f3874b;
        /* renamed from: c */
        public final String f3875c;

        public C1509a(String str, int i, String str2) {
            this.f3873a = str;
            this.f3874b = i;
            this.f3875c = str2;
        }

        /* renamed from: a */
        public static C1509a m4485a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new C1509a(jSONObject.optString("pn"), jSONObject.optInt("v", 0), jSONObject.optString("pk"));
        }

        /* renamed from: a */
        public static List<C1509a> m4486a(JSONArray jSONArray) {
            if (jSONArray == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                C1509a a = m4485a(jSONArray.optJSONObject(i));
                if (a != null) {
                    arrayList.add(a);
                }
            }
            return arrayList;
        }

        /* renamed from: a */
        public static JSONObject m4488a(C1509a aVar) {
            if (aVar == null) {
                return null;
            }
            try {
                return new JSONObject().put("pn", aVar.f3873a).put("v", aVar.f3874b).put("pk", aVar.f3875c);
            } catch (JSONException e) {
                C1542e.m4633a(e);
                return null;
            }
        }

        /* renamed from: a */
        public static JSONArray m4487a(List<C1509a> list) {
            if (list == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (C1509a a : list) {
                jSONArray.put(m4488a(a));
            }
            return jSONArray;
        }

        public String toString() {
            return String.valueOf(m4488a(this));
        }
    }

    /* renamed from: a */
    public int mo12153a() {
        int i = this.f3867b;
        String str = "";
        if (i < 1000 || i > 20000) {
            C1542e.m4631a(str, "DynamicConfig::getJumpTimeout(default) >3500");
            return 3500;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("DynamicConfig::getJumpTimeout >");
        sb.append(this.f3867b);
        C1542e.m4631a(str, sb.toString());
        return this.f3867b;
    }

    /* renamed from: b */
    public boolean mo12155b() {
        return this.f3870e;
    }

    /* renamed from: c */
    public boolean mo12156c() {
        return this.f3871f;
    }

    /* renamed from: d */
    public String mo12157d() {
        return this.f3868c;
    }

    /* renamed from: e */
    public int mo12158e() {
        return this.f3869d;
    }

    /* renamed from: f */
    public List<C1509a> mo12159f() {
        return this.f3872g;
    }

    /* renamed from: g */
    public static C1508a m4475g() {
        if (f3865h == null) {
            f3865h = new C1508a();
            f3865h.m4476h();
        }
        return f3865h;
    }

    /* renamed from: h */
    private void m4476h() {
        m4473a(C1549k.m4656b(C1536b.m4608a().mo12202b(), "alipay_cashier_dynamic_config", null));
    }

    /* renamed from: a */
    private void m4473a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f3867b = jSONObject.optInt("timeout", 3500);
                this.f3868c = jSONObject.optString("tbreturl", "https://h5.m.taobao.com/mlapp/olist.html").trim();
                this.f3869d = jSONObject.optInt("configQueryInterval", 10);
                this.f3872g = C1509a.m4486a(jSONObject.optJSONArray("launchAppSwitch"));
                this.f3870e = jSONObject.optBoolean("scheme_pay_2", true);
                this.f3871f = jSONObject.optBoolean("intercept_batch", true);
            } catch (Throwable th) {
                C1542e.m4633a(th);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m4477i() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("timeout", mo12153a());
            jSONObject.put("tbreturl", mo12157d());
            jSONObject.put("configQueryInterval", mo12158e());
            jSONObject.put("launchAppSwitch", C1509a.m4487a(mo12159f()));
            jSONObject.put("scheme_pay_2", mo12155b());
            jSONObject.put("intercept_batch", mo12156c());
            C1549k.m4655a(C1536b.m4608a().mo12202b(), "alipay_cashier_dynamic_config", jSONObject.toString());
        } catch (Exception e) {
            C1542e.m4633a(e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m4474b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("st_sdk_config");
                if (optJSONObject != null) {
                    this.f3867b = optJSONObject.optInt("timeout", 3500);
                    this.f3868c = optJSONObject.optString("tbreturl", "https://h5.m.taobao.com/mlapp/olist.html").trim();
                    this.f3869d = optJSONObject.optInt("configQueryInterval", 10);
                    this.f3872g = C1509a.m4486a(optJSONObject.optJSONArray("launchAppSwitch"));
                    this.f3870e = optJSONObject.optBoolean("scheme_pay_2", true);
                    this.f3871f = optJSONObject.optBoolean("intercept_batch", true);
                } else {
                    C1542e.m4635c("msp", "config is null");
                }
            } catch (Throwable th) {
                C1542e.m4633a(th);
            }
        }
    }

    /* renamed from: a */
    public void mo12154a(Context context) {
        new Thread(new C1510b(this, context)).start();
    }
}
