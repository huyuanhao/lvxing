package com.bytedance.embedapplog.p141a;

import android.content.Context;
import com.bytedance.embedapplog.AppLog;
import com.bytedance.embedapplog.p142b.C1822i;
import com.bytedance.embedapplog.p143c.C1835a;
import com.bytedance.embedapplog.p143c.C1836b;
import com.bytedance.embedapplog.util.C1856h;
import org.json.JSONObject;

/* renamed from: com.bytedance.embedapplog.a.i */
class C1809i extends C1803c {
    /* renamed from: b */
    static final long[] f5065b = {60000, 60000, 60000, 120000, 120000, 120000, 180000, 180000};
    /* renamed from: c */
    static final long[] f5066c = {180000, 180000, 360000, 360000, 540000, 540000};
    /* renamed from: d */
    private static final long[] f5067d = {10000, 10000, 20000, 20000, 60000, 6000, 180000, 180000, 540000, 540000};
    /* renamed from: e */
    private C1822i f5068e;
    /* renamed from: f */
    private C1811k f5069f;

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo13345a() {
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public String mo13349e() {
        return "r";
    }

    C1809i(Context context, C1822i iVar, C1811k kVar) {
        super(context);
        this.f5068e = iVar;
        this.f5069f = kVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public long mo13346b() {
        return this.f5068e.mo13447p() + ((long) (this.f5069f.mo13363c() ? 21600000 : 43200000));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public long[] mo13347c() {
        int o = this.f5068e.mo13446o();
        if (o == 0) {
            return f5067d;
        }
        if (o == 1) {
            return f5066c;
        }
        if (o == 2) {
            return f5065b;
        }
        C1856h.m6582a(null);
        return f5066c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public boolean mo13348d() {
        JSONObject jSONObject = new JSONObject();
        JSONObject a = this.f5068e.mo13425a();
        if (a != null) {
            jSONObject.put("magic_tag", "ss_app_log");
            jSONObject.put("header", a);
            jSONObject.put("_gen_time", System.currentTimeMillis());
            JSONObject a2 = C1835a.m6435a(C1836b.m6441a(this.f5041a, this.f5068e.mo13425a(), C1835a.m6431a().getRegisterUri(), true, AppLog.getIAppParam()), jSONObject);
            if (a2 != null) {
                String str = "";
                return this.f5068e.mo13429a(a2, a2.optString("device_id", str), a2.optString("install_id", str), a2.optString("ssid", str));
            }
        } else {
            C1856h.m6582a(null);
        }
        return false;
    }
}
