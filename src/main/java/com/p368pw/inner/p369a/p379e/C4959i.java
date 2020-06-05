package com.p368pw.inner.p369a.p379e;

import android.text.TextUtils;
import com.p368pw.inner.base.p387d.C5205o;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.pw.inner.a.e.i */
public class C4959i {
    /* renamed from: a */
    private JSONArray f16099a;
    /* renamed from: b */
    private JSONArray f16100b;
    /* renamed from: c */
    private JSONArray f16101c;
    /* renamed from: d */
    private JSONArray f16102d;
    /* renamed from: e */
    private JSONArray f16103e;
    /* renamed from: f */
    private JSONArray f16104f;
    /* renamed from: g */
    private JSONArray f16105g;
    /* renamed from: h */
    private JSONArray f16106h;
    /* renamed from: i */
    private JSONArray f16107i;
    /* renamed from: j */
    private JSONArray f16108j;
    /* renamed from: k */
    private JSONArray f16109k;
    /* renamed from: l */
    private JSONArray f16110l;
    /* renamed from: m */
    private JSONArray f16111m;
    /* renamed from: n */
    private JSONArray f16112n;
    /* renamed from: o */
    private JSONArray f16113o;
    /* renamed from: p */
    private JSONArray f16114p;
    /* renamed from: q */
    private JSONArray f16115q;
    /* renamed from: r */
    private JSONArray f16116r;
    /* renamed from: s */
    private JSONArray f16117s;
    /* renamed from: t */
    private JSONArray f16118t;
    /* renamed from: u */
    private JSONArray f16119u;
    /* renamed from: v */
    private JSONArray f16120v;

    public C4959i(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                C5205o.m21462a("vs em");
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("vs jsonstr = ");
            sb.append(str);
            C5205o.m21462a(sb.toString());
            JSONObject jSONObject = new JSONObject(str);
            this.f16099a = jSONObject.optJSONArray("video_request_url");
            this.f16100b = jSONObject.optJSONArray("video_imp_urls");
            this.f16101c = jSONObject.optJSONArray("video_start_urls");
            this.f16102d = jSONObject.optJSONArray("video_25_urls");
            this.f16103e = jSONObject.optJSONArray("video_50_urls");
            this.f16104f = jSONObject.optJSONArray("video_75_urls");
            this.f16105g = jSONObject.optJSONArray("video_end_urls");
            this.f16106h = jSONObject.optJSONArray("video_end_iml_urls");
            this.f16107i = jSONObject.optJSONArray("video_skip_url");
            this.f16108j = jSONObject.optJSONArray("video_banner_url");
            this.f16109k = jSONObject.optJSONArray("video_land_urls");
            this.f16110l = jSONObject.optJSONArray("video_install_start_url");
            this.f16111m = jSONObject.optJSONArray("video_install_end_url");
            this.f16112n = jSONObject.optJSONArray("video_download_start_url");
            this.f16113o = jSONObject.getJSONArray("video_download_end_url");
            this.f16114p = jSONObject.optJSONArray("video_mute_urls");
            this.f16115q = jSONObject.optJSONArray("video_unmute_urls");
            this.f16116r = jSONObject.optJSONArray("video_pause_urls");
            this.f16117s = jSONObject.optJSONArray("video_unpause_urls");
            this.f16118t = jSONObject.optJSONArray("video_fullscreen_urls");
            this.f16119u = jSONObject.optJSONArray("video_exitfullscreen_urls");
            this.f16120v = jSONObject.optJSONArray("video_prefill_url");
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: a */
    public JSONArray mo26250a() {
        return this.f16099a;
    }

    /* renamed from: b */
    public JSONArray mo26251b() {
        return this.f16100b;
    }

    /* renamed from: c */
    public JSONArray mo26252c() {
        return this.f16101c;
    }

    /* renamed from: d */
    public JSONArray mo26253d() {
        return this.f16102d;
    }

    /* renamed from: e */
    public JSONArray mo26254e() {
        return this.f16103e;
    }

    /* renamed from: f */
    public JSONArray mo26255f() {
        return this.f16104f;
    }

    /* renamed from: g */
    public JSONArray mo26256g() {
        return this.f16105g;
    }

    /* renamed from: h */
    public JSONArray mo26257h() {
        return this.f16106h;
    }

    /* renamed from: i */
    public JSONArray mo26258i() {
        return this.f16107i;
    }

    /* renamed from: j */
    public JSONArray mo26259j() {
        return this.f16108j;
    }

    /* renamed from: k */
    public JSONArray mo26260k() {
        return this.f16109k;
    }

    /* renamed from: l */
    public JSONArray mo26261l() {
        return this.f16110l;
    }

    /* renamed from: m */
    public JSONArray mo26262m() {
        return this.f16111m;
    }

    /* renamed from: n */
    public JSONArray mo26263n() {
        return this.f16112n;
    }

    /* renamed from: o */
    public JSONArray mo26264o() {
        return this.f16113o;
    }

    /* renamed from: p */
    public JSONArray mo26265p() {
        return this.f16114p;
    }

    /* renamed from: q */
    public JSONArray mo26266q() {
        return this.f16115q;
    }

    /* renamed from: r */
    public JSONArray mo26267r() {
        return this.f16116r;
    }

    /* renamed from: s */
    public JSONArray mo26268s() {
        return this.f16117s;
    }

    /* renamed from: t */
    public JSONArray mo26269t() {
        return this.f16118t;
    }

    /* renamed from: u */
    public JSONArray mo26270u() {
        return this.f16119u;
    }

    /* renamed from: v */
    public JSONArray mo26271v() {
        return this.f16120v;
    }
}
