package com.p368pw.inner.p369a.p370a.p371a;

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
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.pw.inner.a.a.a.a */
public class C4821a extends C5114a<C4830h> {
    /* renamed from: a */
    private int f15487a;
    /* renamed from: b */
    private int f15488b;
    /* renamed from: c */
    private int f15489c;
    /* renamed from: d */
    private int f15490d;
    /* renamed from: e */
    private int f15491e;
    /* renamed from: f */
    private String f15492f;
    /* renamed from: g */
    private int f15493g = 3;
    /* renamed from: h */
    private int f15494h = 0;
    /* renamed from: i */
    private int f15495i = 0;
    /* renamed from: j */
    private int f15496j = 1;
    /* renamed from: k */
    private JSONArray f15497k;

    public C4821a(int i, int i2, int i3, int i4, int i5, String str) {
        this.f15487a = i;
        this.f15488b = i2;
        this.f15489c = i3;
        this.f15490d = i4;
        this.f15491e = i5;
        this.f15492f = str;
    }

    /* renamed from: b */
    private JSONObject m19696b(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ads_num", this.f15487a);
            jSONObject.put("ads_width", this.f15488b);
            jSONObject.put("ads_height", this.f15489c);
            jSONObject.put("ads_type", this.f15490d);
            jSONObject.put("ads_placement", this.f15492f);
            jSONObject.put("ads_source", this.f15491e);
            jSONObject.put("ads_mode", this.f15494h);
            if (this.f15497k != null) {
                jSONObject.put("retain_type_batch", this.f15497k);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* renamed from: c */
    private JSONObject m19697c(Context context) {
        String str = "";
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ip", C5191i.m21421x(context));
            jSONObject.put("android_id", C5191i.m21387a(context));
            jSONObject.put("oaid", C5191i.m21387a(context));
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
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* renamed from: d */
    private String m19698d() {
        String str;
        StringBuilder sb;
        String str2 = "https://adx-api.zzpolarb.com";
        if (this.f15496j == 2) {
            sb = new StringBuilder();
            sb.append(str2);
            str = "/api/v1/adx/retain";
        } else {
            sb = new StringBuilder();
            sb.append(str2);
            str = "/api/v1/adx/get";
        }
        sb.append(str);
        return C5228c.m21539a(sb.toString());
    }

    /* renamed from: d */
    private JSONObject m19699d(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_key", C5238g.m21604a(context));
            jSONObject.put(ArgKey.KEY_APP_ID, context.getPackageName());
            jSONObject.put("app_name", C5191i.m21406i(context));
            jSONObject.put("app_version", String.valueOf(C5191i.m21402f(context)));
            jSONObject.put("app_version_name", C5191i.m21404g(context));
            jSONObject.put("app_channel", C5237f.m21578b(context));
            jSONObject.put("test_req", this.f15495i);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* renamed from: e */
    private JSONObject m19700e(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdk_name", "win_2.7.2");
            jSONObject.put("sdk_version", 30132);
            jSONObject.put("sdk_time", System.currentTimeMillis());
            jSONObject.put("sdk_type", this.f15490d);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* renamed from: a */
    public C4821a mo25760a(JSONArray jSONArray) {
        this.f15497k = jSONArray;
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C4830h mo25765b(String str) {
        return new C4830h(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo25762a() {
        return C5194l.m21436e(m19698d()).mo26816h(mo25763a(C5233e.m21559b())).mo26814b(this.f15493g).mo26813a();
    }

    /* renamed from: a */
    public String mo25763a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("protocol_ver", 1);
            jSONObject.put("ads_info", m19696b(context));
            jSONObject.put("device_info", m19697c(context));
            jSONObject.put("app_info", m19699d(context));
            jSONObject.put("sdk_info", m19700e(context));
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

    /* renamed from: a */
    public void mo25764a(int i) {
        if (i > 0) {
            this.f15493g = i;
        }
    }

    /* renamed from: b */
    public void mo25766b(int i) {
        this.f15494h = i;
    }

    /* renamed from: c */
    public void mo25767c(int i) {
        this.f15496j = i;
    }
}
