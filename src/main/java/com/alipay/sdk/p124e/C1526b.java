package com.alipay.sdk.p124e;

import android.text.TextUtils;
import com.alipay.sdk.util.C1542e;
import org.json.JSONObject;

/* renamed from: com.alipay.sdk.e.b */
public final class C1526b {
    /* renamed from: a */
    private final String f3895a;
    /* renamed from: b */
    private final String f3896b;

    public C1526b(String str, String str2) {
        this.f3895a = str;
        this.f3896b = str2;
    }

    /* renamed from: a */
    public String mo12176a() {
        return this.f3895a;
    }

    /* renamed from: b */
    public String mo12177b() {
        return this.f3896b;
    }

    /* renamed from: c */
    public JSONObject mo12178c() {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(this.f3896b)) {
            return null;
        }
        try {
            jSONObject = new JSONObject(this.f3896b);
        } catch (Exception e) {
            C1542e.m4633a(e);
            jSONObject = null;
        }
        return jSONObject;
    }

    public String toString() {
        return String.format("<Letter envelop=%s body=%s>", new Object[]{this.f3895a, this.f3896b});
    }
}
