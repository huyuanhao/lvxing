package com.p530ss.android.downloadlib.p541a.p543b;

import com.p530ss.android.downloadlib.p549e.C6587g;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AppInfo */
/* renamed from: com.ss.android.downloadlib.a.b.a */
public class C6544a {
    /* renamed from: a */
    public long f21296a;
    /* renamed from: b */
    public long f21297b;
    /* renamed from: c */
    public long f21298c;
    /* renamed from: d */
    public String f21299d;
    /* renamed from: e */
    public String f21300e;
    /* renamed from: f */
    public String f21301f;
    /* renamed from: g */
    public String f21302g;
    /* renamed from: h */
    public volatile long f21303h;

    public C6544a() {
    }

    public C6544a(long j, long j2, long j3, String str, String str2, String str3, String str4) {
        this.f21296a = j;
        this.f21297b = j2;
        this.f21298c = j3;
        this.f21299d = str;
        this.f21300e = str2;
        this.f21301f = str3;
        this.f21302g = str4;
    }

    /* renamed from: a */
    public void mo31258a() {
        this.f21303h = System.currentTimeMillis();
    }

    /* renamed from: b */
    public JSONObject mo31259b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mDownloadId", this.f21296a);
            jSONObject.put("mAdId", this.f21297b);
            jSONObject.put("mExtValue", this.f21298c);
            jSONObject.put("mPackageName", this.f21299d);
            jSONObject.put("mAppName", this.f21300e);
            jSONObject.put("mLogExtra", this.f21301f);
            jSONObject.put("mFileName", this.f21302g);
            jSONObject.put("mTimeStamp", this.f21303h);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static C6544a m26164a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        C6544a aVar = new C6544a();
        try {
            aVar.f21296a = C6587g.m26508a(jSONObject, "mDownloadId");
            aVar.f21297b = C6587g.m26508a(jSONObject, "mAdId");
            aVar.f21298c = C6587g.m26508a(jSONObject, "mExtValue");
            aVar.f21299d = jSONObject.optString("mPackageName");
            aVar.f21300e = jSONObject.optString("mAppName");
            aVar.f21301f = jSONObject.optString("mLogExtra");
            aVar.f21302g = jSONObject.optString("mFileName");
            aVar.f21303h = C6587g.m26508a(jSONObject, "mTimeStamp");
            return aVar;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
