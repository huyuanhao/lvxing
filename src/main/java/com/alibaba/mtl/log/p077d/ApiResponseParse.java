package com.alibaba.mtl.log.p077d;

import android.text.TextUtils;
import com.p522qq.p523e.comm.constants.Constants.KEYS;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.alibaba.mtl.log.d.a */
public class ApiResponseParse {

    /* compiled from: ApiResponseParse */
    /* renamed from: com.alibaba.mtl.log.d.a$a */
    public static class C1315a {
        /* renamed from: c */
        public static C1315a f3372c = new C1315a();
        /* renamed from: a */
        public boolean f3373a = false;
        /* renamed from: b */
        public String f3374b = null;

        /* renamed from: a */
        public boolean mo11797a() {
            return "E0102".equalsIgnoreCase(this.f3374b);
        }

        /* renamed from: b */
        public boolean mo11798b() {
            if (!"E0111".equalsIgnoreCase(this.f3374b)) {
                if (!"E0112".equalsIgnoreCase(this.f3374b)) {
                    return false;
                }
            }
            return true;
        }
    }

    /* renamed from: a */
    public static C1315a m3787a(String str) {
        String str2 = KEYS.RET;
        String str3 = "success";
        C1315a aVar = new C1315a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(str3)) {
                String string = jSONObject.getString(str3);
                if (!TextUtils.isEmpty(string) && string.equals(str3)) {
                    aVar.f3373a = true;
                }
            }
            if (jSONObject.has(str2)) {
                aVar.f3374b = jSONObject.getString(str2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return aVar;
    }
}
