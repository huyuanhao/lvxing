package com.p368pw.inner.base.p384a;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.p368pw.inner.C5228c;
import com.p368pw.inner.C5233e;
import com.p368pw.inner.C5237f;
import com.p368pw.inner.C5238g;
import com.p368pw.inner.base.C5114a;
import com.p368pw.inner.base.p387d.C5162b;
import com.p368pw.inner.base.p387d.C5191i;
import com.p368pw.inner.base.p387d.C5194l;
import com.p368pw.inner.base.p387d.C5205o;
import com.tencent.mid.api.MidEntity;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import org.json.JSONObject;

/* renamed from: com.pw.inner.base.a.b */
public class C5120b extends C5114a<C5119a> {
    /* renamed from: a */
    private int f16669a;
    /* renamed from: b */
    private String f16670b;
    /* renamed from: c */
    private String f16671c;
    /* renamed from: d */
    private int f16672d = 6;

    public C5120b(int i, String str, String str2) {
        this.f16669a = i;
        this.f16670b = str;
        this.f16671c = str2;
    }

    /* renamed from: b */
    private JSONObject m21144b(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ads_placement", this.f16670b);
            jSONObject.put("instime", this.f16671c);
        } catch (Exception e) {
            C5205o.m21464a((Throwable) e);
        }
        return jSONObject;
    }

    /* renamed from: c */
    private JSONObject m21145c(Context context) {
        String str = "";
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ip", C5191i.m21421x(context));
            jSONObject.put("android_id", C5191i.m21387a(context));
            jSONObject.put("os", 1);
            jSONObject.put("os_version", String.valueOf(VERSION.SDK_INT));
            jSONObject.put("width", C5191i.m21384a(context, 1));
            jSONObject.put("height", C5191i.m21384a(context, 2));
            jSONObject.put("local", C5191i.m21399d(context));
            jSONObject.put("lang", C5191i.m21409l(context));
            jSONObject.put("ua", C5191i.m21397c(context));
            jSONObject.put("net_type", C5191i.m21418u(context));
            jSONObject.put("brand", Build.BRAND);
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("carrier_code", C5191i.m21410m(context));
            jSONObject.put("carrier_name", C5191i.m21411n(context));
            jSONObject.put(MidEntity.TAG_MAC, C5191i.m21420w(context));
            jSONObject.put(MidEntity.TAG_IMEI, C5191i.m21416s(context));
            jSONObject.put("imsi", C5191i.m21417t(context));
            jSONObject.put("idfa", str);
            jSONObject.put("idfv", str);
            jSONObject.put("ios_uuid", str);
            jSONObject.put("media", 1);
            jSONObject.put("density", String.valueOf(C5191i.m21412o(context)));
            jSONObject.put("lon", C5191i.m21414q(context));
            jSONObject.put("lat", C5191i.m21413p(context));
            jSONObject.put("cell", C5191i.m21419v(context));
            jSONObject.put("is_dplink", 1);
            jSONObject.put("is_mraidjs", 0);
            jSONObject.put("manu_facturer", Build.MANUFACTURER);
        } catch (Exception e) {
            C5205o.m21464a((Throwable) e);
        }
        return jSONObject;
    }

    /* renamed from: d */
    private String m21146d() {
        return C5228c.m21539a(C5194l.m21428a("https://place.zzpolarb.com/app/place"));
    }

    /* renamed from: d */
    private JSONObject m21147d(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_key", C5238g.m21604a(context));
            jSONObject.put(ArgKey.KEY_APP_ID, context.getPackageName());
            jSONObject.put("app_name", C5191i.m21406i(context));
            jSONObject.put("app_version", String.valueOf(C5191i.m21402f(context)));
            jSONObject.put("app_version_name", C5191i.m21404g(context));
            jSONObject.put("app_channel", C5237f.m21578b(context));
        } catch (Exception e) {
            C5205o.m21464a((Throwable) e);
        }
        return jSONObject;
    }

    /* renamed from: e */
    private JSONObject m21148e(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdk_name", "win_2.7.2");
            jSONObject.put("sdk_version", 30132);
            jSONObject.put("sdk_time", System.currentTimeMillis());
            jSONObject.put("sdk_type", this.f16669a);
        } catch (Exception e) {
            C5205o.m21464a((Throwable) e);
        }
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C5119a mo25765b(String str) {
        return new C5119a(str, this.f16669a, this.f16670b);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo25762a() {
        return C5194l.m21436e(m21146d()).mo26816h(mo26667a(C5233e.m21559b())).mo26815c(this.f16672d).mo26812a(this.f16672d).mo26813a();
    }

    /* renamed from: a */
    public String mo26667a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("protocol_ver", 1);
            jSONObject.put("ads_info", m21144b(context));
            jSONObject.put("device_info", m21145c(context));
            jSONObject.put("app_info", m21147d(context));
            jSONObject.put("sdk_info", m21148e(context));
            StringBuilder sb = new StringBuilder();
            sb.append("req ad str = ");
            sb.append(jSONObject.toString());
            C5205o.m21462a(sb.toString());
            return C5162b.m21305a().mo26770a(jSONObject.toString(), true);
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return "";
        }
    }
}
