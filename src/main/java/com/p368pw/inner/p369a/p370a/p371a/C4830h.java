package com.p368pw.inner.p369a.p370a.p371a;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.p368pw.inner.base.p387d.C5162b;
import com.p368pw.inner.base.p387d.C5205o;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.pw.inner.a.a.a.h */
public class C4830h {
    /* renamed from: a */
    private int f15553a;
    /* renamed from: b */
    private String f15554b;
    /* renamed from: c */
    private int f15555c;
    /* renamed from: d */
    private List<C4829g> f15556d;
    /* renamed from: e */
    private String f15557e;

    public C4830h(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                C5205o.m21462a("rp em");
                return;
            }
            this.f15557e = str;
            String b = C5162b.m21305a().mo26772b(str, true);
            StringBuilder sb = new StringBuilder();
            sb.append("rp jsonstr = ");
            sb.append(b);
            C5205o.m21462a(sb.toString());
            JSONObject jSONObject = new JSONObject(b);
            this.f15553a = jSONObject.optInt("code", 0);
            this.f15554b = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE, "");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.f15555c = optJSONObject.optInt("offer_size", 0);
                JSONArray optJSONArray = optJSONObject.optJSONArray("offers");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.f15556d = new ArrayList();
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        this.f15556d.add(new C4829g(optJSONArray.get(i).toString()));
                    }
                }
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: a */
    public int mo25836a() {
        return this.f15553a;
    }

    /* renamed from: b */
    public List<C4829g> mo25837b() {
        return this.f15556d;
    }

    /* renamed from: c */
    public String mo25838c() {
        return this.f15557e;
    }
}
