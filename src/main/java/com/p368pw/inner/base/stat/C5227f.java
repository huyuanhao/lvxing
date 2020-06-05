package com.p368pw.inner.base.stat;

import android.content.Context;
import com.p368pw.inner.C5228c;
import com.p368pw.inner.C5233e;
import com.p368pw.inner.C5238g;
import com.p368pw.inner.base.C5114a.C5118b;
import com.p368pw.inner.base.p387d.C5162b;
import com.p368pw.inner.base.p387d.C5191i;
import com.p368pw.inner.base.p387d.C5194l;
import com.p368pw.inner.base.p387d.C5205o;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import com.tencent.stat.common.DeviceInfo;
import org.json.JSONObject;

/* renamed from: com.pw.inner.base.stat.f */
public class C5227f extends C5118b {
    /* renamed from: a */
    private String f17019a;
    /* renamed from: b */
    private int f17020b;
    /* renamed from: c */
    private int f17021c;
    /* renamed from: d */
    private String f17022d;
    /* renamed from: e */
    private String f17023e;
    /* renamed from: f */
    private String f17024f;
    /* renamed from: g */
    private String f17025g;
    /* renamed from: h */
    private String f17026h;
    /* renamed from: i */
    private String f17027i;
    /* renamed from: j */
    private String f17028j;
    /* renamed from: k */
    private String f17029k;
    /* renamed from: l */
    private String f17030l;
    /* renamed from: m */
    private int f17031m = 60;

    /* renamed from: a */
    private String m21533a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appkey", C5238g.m21604a(C5233e.m21559b()));
            jSONObject.put(DeviceInfo.TAG_ANDROID_ID, this.f17019a);
            jSONObject.put("adsource", this.f17020b);
            jSONObject.put("placement_type", this.f17021c);
            jSONObject.put("adpkg", this.f17022d);
            jSONObject.put("appname", this.f17023e);
            jSONObject.put(ArgKey.KEY_DESC, this.f17024f);
            jSONObject.put("icon", this.f17025g);
            jSONObject.put("image", this.f17026h);
            jSONObject.put("videourl", this.f17027i);
            jSONObject.put("downurl", this.f17028j);
            jSONObject.put("actparam", this.f17029k);
            jSONObject.put("actparam2", this.f17030l);
            StringBuilder sb = new StringBuilder();
            sb.append("up ss str = ");
            sb.append(jSONObject.toString());
            C5205o.m21462a(sb.toString());
            return C5162b.m21305a().mo26770a(jSONObject.toString(), true);
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return "";
        }
    }

    /* renamed from: d */
    private String m21534d() {
        return C5228c.m21539a("https://tain.zzpolarb.com/api/v1/retain/infos/in");
    }

    /* renamed from: a */
    public C5227f mo26912a(int i, int i2) {
        this.f17019a = C5191i.m21387a(C5233e.m21559b());
        this.f17020b = i;
        this.f17021c = i2;
        return this;
    }

    /* renamed from: a */
    public C5227f mo26913a(String str, String str2) {
        this.f17029k = str;
        this.f17030l = str2;
        return this;
    }

    /* renamed from: a */
    public C5227f mo26914a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f17022d = str;
        this.f17023e = str2;
        this.f17024f = str3;
        this.f17025g = str4;
        this.f17026h = str5;
        this.f17027i = str6;
        this.f17028j = str7;
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo25762a() {
        return C5194l.m21436e(m21534d()).mo26816h(m21533a(C5233e.m21559b())).mo26814b(this.f17031m).mo26813a();
    }
}
