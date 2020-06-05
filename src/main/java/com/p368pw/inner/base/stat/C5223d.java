package com.p368pw.inner.base.stat;

import androidx.core.app.NotificationCompat;
import com.p368pw.inner.C5228c;
import com.p368pw.inner.base.C5114a.C5118b;
import com.p368pw.inner.base.p387d.C5162b;
import com.p368pw.inner.base.p387d.C5194l;
import com.tencent.stat.common.DeviceInfo;
import org.json.JSONObject;

/* renamed from: com.pw.inner.base.stat.d */
public class C5223d extends C5118b {
    /* renamed from: a */
    private int f16978a = 6;
    /* renamed from: b */
    private String f16979b;
    /* renamed from: c */
    private String f16980c;
    /* renamed from: d */
    private String f16981d;
    /* renamed from: e */
    private String f16982e;
    /* renamed from: f */
    private int f16983f;
    /* renamed from: g */
    private String f16984g;
    /* renamed from: h */
    private int f16985h;
    /* renamed from: i */
    private String f16986i;
    /* renamed from: j */
    private String f16987j;

    /* renamed from: d */
    private String m21513d() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appkey", this.f16979b);
            jSONObject.put("pkg", this.f16980c);
            jSONObject.put("placement_id", this.f16981d);
            jSONObject.put(DeviceInfo.TAG_ANDROID_ID, this.f16982e);
            jSONObject.put("adsource", this.f16983f);
            jSONObject.put("adpkg", this.f16984g);
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, this.f16985h);
            jSONObject.put("offerid", this.f16986i);
            jSONObject.put("requestid", this.f16987j);
            return C5162b.m21305a().mo26770a(jSONObject.toString(), true);
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: e */
    private String m21514e() {
        return C5228c.m21539a("https://tain.zzpolarb.com/api/v1/event/cb");
    }

    /* renamed from: a */
    public C5223d mo26899a(int i) {
        this.f16983f = i;
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo25762a() {
        return C5194l.m21436e(m21514e()).mo26816h(m21513d()).mo26814b(this.f16978a).mo26813a();
    }

    /* renamed from: b */
    public C5223d mo26900b(int i) {
        this.f16985h = i;
        return this;
    }

    /* renamed from: c */
    public C5223d mo26901c(String str) {
        this.f16979b = str;
        return this;
    }

    /* renamed from: d */
    public C5223d mo26902d(String str) {
        this.f16980c = str;
        return this;
    }

    /* renamed from: e */
    public C5223d mo26903e(String str) {
        this.f16981d = str;
        return this;
    }

    /* renamed from: f */
    public C5223d mo26904f(String str) {
        this.f16982e = str;
        return this;
    }

    /* renamed from: g */
    public C5223d mo26905g(String str) {
        this.f16984g = str;
        return this;
    }

    /* renamed from: h */
    public C5223d mo26906h(String str) {
        this.f16986i = str;
        return this;
    }

    /* renamed from: i */
    public C5223d mo26907i(String str) {
        this.f16987j = str;
        return this;
    }
}
