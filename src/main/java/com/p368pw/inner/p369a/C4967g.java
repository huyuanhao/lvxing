package com.p368pw.inner.p369a;

import com.p368pw.inner.base.p387d.C5205o;
import com.tencent.mid.core.Constants.ERROR;
import org.json.JSONObject;

/* renamed from: com.pw.inner.a.g */
public class C4967g {
    /* renamed from: a */
    private String f16146a;
    /* renamed from: b */
    private String f16147b;
    /* renamed from: c */
    private String f16148c;
    /* renamed from: d */
    private int f16149d;
    /* renamed from: e */
    private int f16150e;
    /* renamed from: f */
    private String f16151f;
    @Deprecated
    /* renamed from: g */
    private int f16152g;
    /* renamed from: h */
    private int f16153h;
    /* renamed from: i */
    private int f16154i;
    /* renamed from: j */
    private int f16155j = 2;
    /* renamed from: k */
    private int f16156k = 0;
    /* renamed from: l */
    private C4911e f16157l;

    public C4967g(int i, String str) {
        String str2 = "";
        try {
            this.f16146a = str2;
            this.f16147b = ERROR.CMD_FORMAT_ERROR;
            this.f16148c = str2;
            this.f16149d = 10;
            this.f16150e = 5;
            this.f16151f = str2;
            this.f16152g = 20;
            this.f16153h = 1;
            this.f16154i = 1;
            this.f16155j = 2;
            this.f16156k = 0;
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    public C4967g(JSONObject jSONObject) {
        String str = "";
        if (jSONObject != null) {
            try {
                this.f16146a = jSONObject.optString("th_appkey", str);
                this.f16147b = jSONObject.optString("th_placement_id", str);
                this.f16148c = jSONObject.optString("th_secrect", str);
                this.f16149d = jSONObject.optInt("th_priority", 0);
                this.f16150e = jSONObject.optInt("ads_source", 0);
                this.f16151f = jSONObject.optString("th_placement_type", str);
                this.f16152g = jSONObject.optInt("skip_time", 20);
                this.f16153h = jSONObject.optInt("click_area_type", 2);
                this.f16154i = jSONObject.optInt("click_area_type_ve", 1);
                this.f16155j = jSONObject.optInt("tx_video_policy", 2);
                this.f16156k = jSONObject.optInt("tx_video_native_priority", 0);
            } catch (Throwable th) {
                C5205o.m21464a(th);
            }
        }
    }

    /* renamed from: a */
    public String mo26294a() {
        return this.f16146a;
    }

    /* renamed from: a */
    public void mo26295a(int i) {
        this.f16149d = i;
    }

    /* renamed from: a */
    public void mo26296a(C4911e eVar) {
        this.f16157l = eVar;
    }

    /* renamed from: a */
    public void mo26297a(String str) {
        this.f16146a = str;
    }

    /* renamed from: b */
    public String mo26298b() {
        return this.f16147b;
    }

    /* renamed from: b */
    public void mo26299b(int i) {
        this.f16150e = i;
    }

    /* renamed from: b */
    public void mo26300b(String str) {
        this.f16147b = str;
    }

    /* renamed from: c */
    public String mo26301c() {
        return this.f16148c;
    }

    /* renamed from: c */
    public void mo26302c(int i) {
        this.f16152g = i;
    }

    /* renamed from: d */
    public int mo26303d() {
        return this.f16149d;
    }

    /* renamed from: d */
    public void mo26304d(int i) {
        this.f16153h = i;
    }

    /* renamed from: e */
    public int mo26305e() {
        return this.f16150e;
    }

    /* renamed from: e */
    public void mo26306e(int i) {
        this.f16154i = i;
    }

    /* renamed from: f */
    public int mo26307f() {
        return this.f16153h;
    }

    /* renamed from: g */
    public int mo26308g() {
        return this.f16154i;
    }

    /* renamed from: h */
    public C4911e mo26309h() {
        return this.f16157l;
    }

    /* renamed from: i */
    public int mo26310i() {
        return this.f16155j;
    }
}
