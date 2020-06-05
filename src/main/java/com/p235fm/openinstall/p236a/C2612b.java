package com.p235fm.openinstall.p236a;

import android.text.TextUtils;
import com.tencent.p605ep.commonbase.api.ConfigManager.OEM;
import java.io.Serializable;
import org.json.JSONObject;

/* renamed from: com.fm.openinstall.a.b */
public class C2612b implements Serializable {
    /* renamed from: a */
    private String f9468a;
    /* renamed from: b */
    private String f9469b;
    /* renamed from: c */
    private String f9470c;

    public C2612b() {
        String str = "";
        this.f9468a = str;
        this.f9469b = str;
        this.f9470c = str;
    }

    /* renamed from: d */
    public static C2612b m12714d(String str) {
        C2612b bVar = new C2612b();
        if (TextUtils.isEmpty(str)) {
            return bVar;
        }
        JSONObject jSONObject = new JSONObject(str);
        String str2 = OEM.MARKET;
        if (jSONObject.has(str2)) {
            bVar.mo17109a(jSONObject.optString(str2));
        }
        String str3 = "channelCode";
        if (jSONObject.has(str3)) {
            bVar.mo17111b(jSONObject.optString(str3));
        }
        String str4 = "bind";
        if (jSONObject.has(str4)) {
            bVar.mo17112c(jSONObject.optString(str4));
        }
        return bVar;
    }

    /* renamed from: a */
    public String mo17108a() {
        return this.f9469b;
    }

    /* renamed from: a */
    public void mo17109a(String str) {
        this.f9468a = str;
    }

    /* renamed from: b */
    public String mo17110b() {
        return this.f9470c;
    }

    /* renamed from: b */
    public void mo17111b(String str) {
        this.f9469b = str;
    }

    /* renamed from: c */
    public void mo17112c(String str) {
        this.f9470c = str;
    }
}
