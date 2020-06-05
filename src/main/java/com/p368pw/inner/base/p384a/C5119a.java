package com.p368pw.inner.base.p384a;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.p368pw.inner.C5233e;
import com.p368pw.inner.C5237f;
import com.p368pw.inner.base.p387d.C5162b;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.p369a.C4875b;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.pw.inner.base.a.a */
public class C5119a {
    /* renamed from: a */
    private int f16663a;
    /* renamed from: b */
    private String f16664b;
    /* renamed from: c */
    private C4875b f16665c;
    /* renamed from: d */
    private C5121c f16666d;
    /* renamed from: e */
    private int f16667e = 2;
    /* renamed from: f */
    private int f16668f = 0;

    public C5119a(String str, int i, String str2) {
        if (TextUtils.isEmpty(str)) {
            m21141a(i, str2);
            C5205o.m21462a("res is empty");
            return;
        }
        String b = C5162b.m21305a().mo26772b(str, true);
        StringBuilder sb = new StringBuilder();
        sb.append("jsonstr=");
        sb.append(b);
        C5205o.m21462a(sb.toString());
        JSONObject jSONObject = new JSONObject(b);
        this.f16663a = jSONObject.optInt("code", 0);
        this.f16664b = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE, "");
        if (this.f16663a == 200) {
            this.f16665c = new C4875b(str);
            C5237f.m21589d(C5233e.m21559b(), str);
            C5237f.m21574a(C5233e.m21559b(), this.f16665c);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("placements");
                if (optJSONArray == null || optJSONArray.length() <= 0) {
                    this.f16666d = new C5121c(i);
                } else {
                    this.f16666d = new C5121c(optJSONArray.optJSONObject(0).toString());
                }
            }
        }
    }

    /* renamed from: a */
    private void m21141a(int i, String str) {
        C5205o.m21462a("没有获取到服务器配置，使用客户端默认的");
        this.f16663a = 200;
        this.f16664b = "";
        this.f16665c = new C4875b(i, str);
        this.f16666d = new C5121c(i);
        C5237f.m21574a(C5233e.m21559b(), this.f16665c);
    }

    /* renamed from: a */
    public C4875b mo26664a() {
        return this.f16665c;
    }

    /* renamed from: b */
    public C5121c mo26665b() {
        return this.f16666d;
    }
}
