package com.p368pw.inner.base.stat;

import com.p368pw.inner.C5228c;
import com.p368pw.inner.C5233e;
import com.p368pw.inner.C5238g;
import com.p368pw.inner.base.C5114a.C5118b;
import com.p368pw.inner.base.p387d.C5162b;
import com.p368pw.inner.base.p387d.C5191i;
import com.p368pw.inner.base.p387d.C5194l;
import com.p368pw.inner.base.p387d.C5205o;
import com.tencent.stat.common.DeviceInfo;
import org.json.JSONObject;

/* renamed from: com.pw.inner.base.stat.c */
public class C5222c extends C5118b {
    /* renamed from: a */
    private String f16973a;
    /* renamed from: b */
    private int f16974b;
    /* renamed from: c */
    private String f16975c;
    /* renamed from: d */
    private String f16976d;
    /* renamed from: e */
    private String f16977e;

    /* renamed from: d */
    private String m21505d() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appkey", C5238g.m21604a(C5233e.m21559b()));
            jSONObject.put("placement_id", this.f16973a);
            jSONObject.put(DeviceInfo.TAG_ANDROID_ID, C5191i.m21387a(C5233e.m21559b()));
            jSONObject.put("adsource", this.f16974b);
            jSONObject.put("adpkg", this.f16975c);
            jSONObject.put("pub_uid", this.f16976d);
            jSONObject.put("pub_trans_id", this.f16977e);
            StringBuilder sb = new StringBuilder();
            sb.append("json:");
            sb.append(jSONObject.toString());
            C5205o.m21462a(sb.toString());
            return C5162b.m21305a().mo26770a(jSONObject.toString(), true);
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return "";
        }
    }

    /* renamed from: e */
    private String m21506e() {
        return C5228c.m21539a("https://tain.zzpolarb.com/api/v1/task/cb");
    }

    /* renamed from: a */
    public C5222c mo26894a(int i) {
        this.f16974b = i;
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo25762a() {
        return C5194l.m21429a(m21506e(), m21505d());
    }

    /* renamed from: c */
    public C5222c mo26895c(String str) {
        this.f16973a = str;
        return this;
    }

    /* renamed from: d */
    public C5222c mo26896d(String str) {
        this.f16975c = str;
        return this;
    }

    /* renamed from: e */
    public C5222c mo26897e(String str) {
        this.f16976d = str;
        return this;
    }

    /* renamed from: f */
    public C5222c mo26898f(String str) {
        this.f16977e = str;
        return this;
    }
}
