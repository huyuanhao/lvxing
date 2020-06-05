package com.p368pw.inner.appwall;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.p368pw.inner.base.p387d.C5162b;
import com.p368pw.inner.base.p387d.C5205o;
import org.json.JSONObject;

/* renamed from: com.pw.inner.appwall.d */
public class C5001d {
    /* renamed from: a */
    private int f16268a;
    /* renamed from: b */
    private String f16269b;
    /* renamed from: c */
    private int f16270c;
    /* renamed from: d */
    private int f16271d;
    /* renamed from: e */
    private int f16272e;
    /* renamed from: f */
    private int f16273f;
    /* renamed from: g */
    private double f16274g;
    /* renamed from: h */
    private double f16275h;

    public C5001d(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                C5205o.m21462a("act up em");
                return;
            }
            String b = C5162b.m21305a().mo26772b(str, true);
            StringBuilder sb = new StringBuilder();
            sb.append("act up str = ");
            sb.append(b);
            C5205o.m21462a(sb.toString());
            JSONObject jSONObject = new JSONObject(b);
            this.f16268a = jSONObject.optInt("code", 0);
            this.f16269b = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE, "");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.f16270c = optJSONObject.optInt("actStatus");
                this.f16271d = optJSONObject.optInt("signStatus");
                this.f16272e = optJSONObject.optInt("signCoin");
                this.f16273f = optJSONObject.optInt("signCoinAdd");
                this.f16274g = optJSONObject.optDouble("f_signCoin");
                this.f16275h = optJSONObject.optDouble("f_signCoinAdd");
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: a */
    public int mo26389a() {
        return this.f16270c;
    }

    /* renamed from: b */
    public int mo26390b() {
        return this.f16271d;
    }
}
