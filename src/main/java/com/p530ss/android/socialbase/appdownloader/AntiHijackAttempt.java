package com.p530ss.android.socialbase.appdownloader;

import android.text.TextUtils;
import org.json.JSONObject;

/* renamed from: com.ss.android.socialbase.appdownloader.a */
public class AntiHijackAttempt {
    /* renamed from: a */
    public String f21477a;
    /* renamed from: b */
    public int f21478b = -1;
    /* renamed from: c */
    public String f21479c;
    /* renamed from: d */
    public String f21480d;
    /* renamed from: e */
    public String f21481e;

    /* renamed from: a */
    public String mo31451a() {
        return mo31453b().toString();
    }

    /* renamed from: b */
    public JSONObject mo31453b() {
        JSONObject jSONObject = new JSONObject();
        mo31452a(jSONObject);
        return jSONObject;
    }

    /* renamed from: a */
    public void mo31452a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("anti_plan_type", this.f21477a);
                jSONObject.put("error_code", String.valueOf(this.f21478b));
                jSONObject.put("error_msg", this.f21479c);
                jSONObject.put("real_device_plan", this.f21480d);
                jSONObject.put("device_plans", this.f21481e);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public static AntiHijackAttempt m26588a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        AntiHijackAttempt aVar = new AntiHijackAttempt();
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar.f21481e = jSONObject.optString("device_plans", null);
            aVar.f21480d = jSONObject.optString("real_device_plan", null);
            aVar.f21479c = jSONObject.optString("error_msg", null);
            aVar.f21477a = jSONObject.optString("anti_plan_type", null);
            String optString = jSONObject.optString("error_code");
            if (TextUtils.isEmpty(optString)) {
                aVar.f21478b = -1;
            } else {
                aVar.f21478b = Integer.parseInt(optString);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return aVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AntiHijackAttempt{anti_plan_type='");
        sb.append(this.f21477a);
        sb.append('\'');
        sb.append(", error_code=");
        sb.append(this.f21478b);
        sb.append(", error_msg='");
        sb.append(this.f21479c);
        sb.append('\'');
        sb.append(", real_device_plan='");
        sb.append(this.f21480d);
        sb.append('\'');
        sb.append(", device_plans='");
        sb.append(this.f21481e);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
