package com.p368pw.inner.appwall;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.p368pw.inner.C5228c;
import com.p368pw.inner.C5233e;
import com.p368pw.inner.C5238g;
import com.p368pw.inner.base.C5114a;
import com.p368pw.inner.base.p387d.C5162b;
import com.p368pw.inner.base.p387d.C5191i;
import com.p368pw.inner.base.p387d.C5194l;
import com.p368pw.inner.base.p387d.C5205o;
import com.tencent.stat.common.DeviceInfo;
import org.json.JSONObject;

/* renamed from: com.pw.inner.appwall.e */
public class C5002e extends C5114a<C5001d> {
    /* renamed from: a */
    private String f16276a;
    /* renamed from: b */
    private String f16277b;
    /* renamed from: c */
    private String f16278c;
    /* renamed from: d */
    private String f16279d;
    /* renamed from: e */
    private int f16280e;
    /* renamed from: f */
    private String f16281f;
    /* renamed from: g */
    private int f16282g;
    /* renamed from: h */
    private int f16283h;
    /* renamed from: i */
    private int f16284i = 6;

    public C5002e(Context context, String str, String str2, int i, String str3, int i2, int i3) {
        this.f16276a = str;
        this.f16277b = C5238g.m21604a(context);
        this.f16278c = str2;
        this.f16279d = C5191i.m21387a(context);
        this.f16280e = i;
        this.f16281f = str3;
        this.f16282g = i2;
        this.f16283h = i3;
    }

    /* renamed from: a */
    private String m20932a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("requestid", this.f16276a);
            jSONObject.put("appkey", this.f16277b);
            jSONObject.put("placement_id", this.f16278c);
            jSONObject.put(DeviceInfo.TAG_ANDROID_ID, this.f16279d);
            jSONObject.put("adsource", this.f16280e);
            jSONObject.put("adpkg", this.f16281f);
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, this.f16282g);
            jSONObject.put("scoreType", this.f16283h);
            jSONObject.put("sdk_version_code", 30132);
            jSONObject.put("app_version_code", C5191i.m21402f(context));
            StringBuilder sb = new StringBuilder();
            sb.append("act up str = ");
            sb.append(jSONObject.toString());
            C5205o.m21462a(sb.toString());
            return C5162b.m21305a().mo26770a(jSONObject.toString(), true);
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return "";
        }
    }

    /* renamed from: d */
    private String m20933d() {
        return C5228c.m21539a("https://tain.zzpolarb.com/api/v1/apw/event");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C5001d mo25765b(String str) {
        return new C5001d(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo25762a() {
        return C5194l.m21436e(m20933d()).mo26816h(m20932a(C5233e.m21559b())).mo26814b(this.f16284i).mo26813a();
    }
}
