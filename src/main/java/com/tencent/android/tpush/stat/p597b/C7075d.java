package com.tencent.android.tpush.stat.p597b;

import android.text.TextUtils;
import com.tencent.android.tpush.service.p595e.C7056i;
import com.tencent.mid.api.MidEntity;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.stat.b.d */
public class C7075d {
    /* renamed from: a */
    private String f23523a = null;
    /* renamed from: b */
    private String f23524b = null;
    /* renamed from: c */
    private String f23525c = null;
    /* renamed from: d */
    private String f23526d = "0";
    /* renamed from: e */
    private long f23527e = 0;
    /* renamed from: f */
    private int f23528f = 0;
    /* renamed from: g */
    private long f23529g = 0;

    /* renamed from: a */
    public long mo34181a() {
        return this.f23529g;
    }

    /* renamed from: a */
    public void mo34182a(long j) {
        this.f23529g = j;
    }

    /* renamed from: b */
    public long mo34183b() {
        return this.f23527e;
    }

    /* renamed from: b */
    public void mo34184b(long j) {
        this.f23527e = j;
    }

    /* renamed from: c */
    public boolean mo34187c() {
        return C7074c.m30319a(this.f23526d);
    }

    /* renamed from: a */
    public static C7075d m30322a(String str) {
        String str2 = "guid";
        String str3 = "ver";
        String str4 = "ts";
        String str5 = "mid";
        String str6 = MidEntity.TAG_MAC;
        String str7 = "imsi";
        String str8 = MidEntity.TAG_IMEI;
        C7075d dVar = new C7075d();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull(str8)) {
                    dVar.mo34186c(jSONObject.getString(str8));
                }
                if (!jSONObject.isNull(str7)) {
                    dVar.mo34189d(jSONObject.getString(str7));
                }
                if (!jSONObject.isNull(str6)) {
                    dVar.mo34191e(jSONObject.getString(str6));
                }
                if (!jSONObject.isNull(str5)) {
                    dVar.mo34185b(jSONObject.getString(str5));
                }
                if (!jSONObject.isNull(str4)) {
                    dVar.mo34184b(jSONObject.getLong(str4));
                }
                if (!jSONObject.isNull(str3)) {
                    dVar.f23528f = jSONObject.optInt(str3, 0);
                }
                if (!jSONObject.isNull(str2)) {
                    dVar.f23529g = jSONObject.optLong(str2, 0);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return dVar;
    }

    public String toString() {
        return mo34188d().toString();
    }

    /* renamed from: a */
    private void m30323a(JSONObject jSONObject, String str, String str2) {
        if (jSONObject != null && !C7056i.m30194b(str) && !C7056i.m30194b(str2)) {
            try {
                jSONObject.put(str, str2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public JSONObject mo34188d() {
        JSONObject jSONObject = new JSONObject();
        try {
            m30323a(jSONObject, MidEntity.TAG_IMEI, this.f23523a);
            m30323a(jSONObject, "imsi", this.f23524b);
            m30323a(jSONObject, MidEntity.TAG_MAC, this.f23525c);
            m30323a(jSONObject, "mid", this.f23526d);
            try {
                jSONObject.put("guid", this.f23529g);
            } catch (Throwable unused) {
            }
            jSONObject.put("ts", this.f23527e);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* renamed from: e */
    public String mo34190e() {
        return this.f23526d;
    }

    /* renamed from: b */
    public void mo34185b(String str) {
        this.f23526d = str;
    }

    /* renamed from: c */
    public void mo34186c(String str) {
        this.f23523a = str;
    }

    /* renamed from: d */
    public void mo34189d(String str) {
        this.f23524b = str;
    }

    /* renamed from: e */
    public void mo34191e(String str) {
        this.f23525c = str;
    }
}
