package com.qiyukf.nimlib.p453d.p459b.p461b;

import android.text.TextUtils;
import com.qiyukf.nimlib.p453d.p459b.C5762a;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.qiyukf.nimlib.d.b.b.a */
public final class C5770a implements C5762a {
    /* renamed from: a */
    String f18377a;
    /* renamed from: b */
    String f18378b;
    /* renamed from: c */
    int f18379c;
    /* renamed from: d */
    int f18380d;
    /* renamed from: e */
    int f18381e;
    /* renamed from: f */
    String f18382f;

    C5770a(String str, String str2) {
        this.f18377a = str;
        this.f18378b = str2;
    }

    /* renamed from: a */
    public static JSONArray m23189a(List<C5770a> list) {
        if (list != null && !list.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (C5770a aVar : list) {
                if (aVar.m23190b()) {
                    jSONArray.put(aVar.mo28034a());
                }
            }
            if (jSONArray.length() > 0) {
                return jSONArray;
            }
        }
        return null;
    }

    /* renamed from: b */
    private boolean m23190b() {
        return !TextUtils.isEmpty(this.f18377a) && !this.f18377a.equals("00:00:00:00:00:00");
    }

    /* renamed from: a */
    public final JSONObject mo28034a() {
        if (!m23190b()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("bssid", this.f18377a);
            jSONObject.put("ssid", this.f18378b);
            jSONObject.put("strength_type", 2);
            jSONObject.put("strength", this.f18379c);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("NIMWifiInfo{bssid='");
        sb.append(this.f18377a);
        sb.append('\'');
        sb.append(",ssid='");
        sb.append(this.f18378b);
        sb.append('\'');
        sb.append(",rssi=");
        sb.append(this.f18379c);
        sb.append(",frequency=");
        sb.append(this.f18380d);
        sb.append(",speed=");
        sb.append(this.f18381e);
        sb.append(",ip='");
        sb.append(this.f18382f);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
