package com.qiyukf.nimlib.p453d.p459b.p460a;

import com.qiyukf.nimlib.p453d.p459b.C5762a;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.qiyukf.nimlib.d.b.a.a */
public final class C5763a implements C5762a {
    /* renamed from: a */
    private String f18353a;
    /* renamed from: b */
    private String f18354b;
    /* renamed from: c */
    private String f18355c;

    C5763a(String str, String str2, String str3) {
        this.f18353a = str;
        this.f18354b = str2;
        this.f18355c = str3;
    }

    /* renamed from: a */
    public static JSONArray m23162a(List<C5763a> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (C5763a a : list) {
            jSONArray.put(a.mo28034a());
        }
        return jSONArray;
    }

    /* renamed from: a */
    public final JSONObject mo28034a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ArgKey.KEY_APP_ID, this.f18353a);
            jSONObject.put("app_name", this.f18354b);
            jSONObject.put("app_version", this.f18355c);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AppInfo{appId='");
        sb.append(this.f18353a);
        sb.append('\'');
        sb.append(", appName='");
        sb.append(this.f18354b);
        sb.append('\'');
        sb.append(", appVersion='");
        sb.append(this.f18355c);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
