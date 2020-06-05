package com.bytedance.sdk.openadsdk.p185f.p186a;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.IdUtils;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.p185f.p186a.LogStatsBase;
import com.bytedance.sdk.openadsdk.utils.C2566w;
import com.bytedance.sdk.openadsdk.utils.OAIDHelper;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import com.tencent.mid.api.MidEntity;
import discoveryAD.C7880W.C7881a;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.f.a.d */
public class LogStatsBase<T extends LogStatsBase> implements ILogStats {
    /* renamed from: a */
    private String f8644a;
    /* renamed from: b */
    private String f8645b;
    /* renamed from: c */
    private String f8646c;
    /* renamed from: d */
    private String f8647d = "2.9.5.5";
    /* renamed from: e */
    private String f8648e;
    /* renamed from: f */
    private long f8649f = (System.currentTimeMillis() / 1000);
    /* renamed from: g */
    private int f8650g = 0;
    /* renamed from: h */
    private String f8651h;
    /* renamed from: i */
    private int f8652i = 0;
    /* renamed from: j */
    private String f8653j;
    /* renamed from: k */
    private String f8654k;
    /* renamed from: l */
    private String f8655l;
    /* renamed from: m */
    private String f8656m;

    /* renamed from: q */
    private T m11310q() {
        return this;
    }

    /* renamed from: b */
    public static LogStatsBase<LogStatsBase> m11308b() {
        return new LogStatsBase<>();
    }

    /* renamed from: a */
    public JSONObject mo16587a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(mo16596c())) {
                jSONObject.put("type", mo16596c());
            }
            if (!TextUtils.isEmpty(mo16600e())) {
                jSONObject.put("rit", mo16600e());
            }
            if (!TextUtils.isEmpty(mo16602f())) {
                jSONObject.put("creative_id", mo16602f());
            }
            if (!TextUtils.isEmpty(mo16604g())) {
                jSONObject.put("ad_sdk_version", mo16604g());
            }
            String str = "app_version";
            if (!TextUtils.isEmpty(mo16606h())) {
                jSONObject.put(str, mo16606h());
            } else {
                jSONObject.put(str, ToolUtils.m12027f());
            }
            if (mo16607i() > 0) {
                jSONObject.put(C7881a.TIMESTAMP, mo16607i());
            }
            if (mo16609j() > 0) {
                jSONObject.put("adtype", mo16609j());
            }
            if (!TextUtils.isEmpty(mo16610k())) {
                jSONObject.put("req_id", mo16610k());
            }
            jSONObject.put("error_code", mo16611l());
            if (!TextUtils.isEmpty(mo16612m())) {
                jSONObject.put("error_msg", mo16612m());
            }
            if (!TextUtils.isEmpty(mo16613n())) {
                jSONObject.put("extra", mo16613n());
            }
            if (!TextUtils.isEmpty(mo16614o())) {
                jSONObject.put("image_url", mo16614o());
            }
            if (!TextUtils.isEmpty(mo16598d())) {
                jSONObject.put("event_extra", mo16598d());
            }
            jSONObject.put("conn_type", C2566w.m12243b(InternalContainer.m10059a()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            jSONObject.put("device_info", m11309p());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    /* renamed from: p */
    private JSONObject m11309p() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("os", 1);
            jSONObject.put(MidEntity.TAG_IMEI, IdUtils.m9866d(InternalContainer.m10059a()));
            jSONObject.put("oaid", OAIDHelper.m12248a());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* renamed from: c */
    public String mo16596c() {
        return this.f8644a;
    }

    /* renamed from: a */
    public T mo16591a(String str) {
        this.f8644a = str;
        return m11310q();
    }

    /* renamed from: d */
    public String mo16598d() {
        return this.f8656m;
    }

    /* renamed from: b */
    public T mo16593b(String str) {
        this.f8656m = str;
        return m11310q();
    }

    /* renamed from: e */
    public String mo16600e() {
        return this.f8645b;
    }

    /* renamed from: c */
    public T mo16595c(String str) {
        this.f8645b = str;
        return m11310q();
    }

    /* renamed from: f */
    public String mo16602f() {
        return this.f8646c;
    }

    /* renamed from: d */
    public T mo16597d(String str) {
        this.f8646c = str;
        return m11310q();
    }

    /* renamed from: g */
    public String mo16604g() {
        return this.f8647d;
    }

    /* renamed from: e */
    public T mo16599e(String str) {
        this.f8647d = str;
        return m11310q();
    }

    /* renamed from: h */
    public String mo16606h() {
        return this.f8648e;
    }

    /* renamed from: i */
    public long mo16607i() {
        return this.f8649f;
    }

    /* renamed from: c */
    public T mo16594c(long j) {
        this.f8649f = j;
        return m11310q();
    }

    /* renamed from: j */
    public int mo16609j() {
        return this.f8650g;
    }

    /* renamed from: a */
    public T mo16590a(int i) {
        this.f8650g = i;
        return m11310q();
    }

    /* renamed from: k */
    public String mo16610k() {
        return this.f8651h;
    }

    /* renamed from: f */
    public T mo16601f(String str) {
        this.f8651h = str;
        return m11310q();
    }

    /* renamed from: l */
    public int mo16611l() {
        return this.f8652i;
    }

    /* renamed from: b */
    public T mo16592b(int i) {
        this.f8652i = i;
        return m11310q();
    }

    /* renamed from: m */
    public String mo16612m() {
        return this.f8653j;
    }

    /* renamed from: g */
    public T mo16603g(String str) {
        this.f8653j = str;
        return m11310q();
    }

    /* renamed from: n */
    public String mo16613n() {
        return this.f8654k;
    }

    /* renamed from: h */
    public T mo16605h(String str) {
        this.f8654k = str;
        return m11310q();
    }

    /* renamed from: o */
    public String mo16614o() {
        return this.f8655l;
    }

    /* renamed from: i */
    public T mo16608i(String str) {
        this.f8655l = str;
        return m11310q();
    }
}
