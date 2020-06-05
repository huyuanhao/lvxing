package com.p368pw.inner.p369a.p379e;

import android.text.TextUtils;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.C5207q;
import com.p368pw.inner.p369a.p370a.p373c.C4839a;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.pw.inner.a.e.h */
public class C4958h {
    /* renamed from: A */
    private String f16051A;
    /* renamed from: B */
    private String f16052B;
    /* renamed from: C */
    private String f16053C;
    /* renamed from: D */
    private String f16054D;
    /* renamed from: E */
    private int f16055E;
    /* renamed from: F */
    private String f16056F;
    /* renamed from: G */
    private String f16057G;
    /* renamed from: H */
    private String f16058H;
    /* renamed from: I */
    private String f16059I;
    /* renamed from: J */
    private C4959i f16060J;
    /* renamed from: K */
    private String f16061K;
    /* renamed from: L */
    private String f16062L;
    /* renamed from: M */
    private String f16063M;
    /* renamed from: N */
    private JSONArray f16064N;
    /* renamed from: O */
    private JSONArray f16065O;
    /* renamed from: P */
    private int f16066P;
    /* renamed from: Q */
    private int f16067Q;
    /* renamed from: R */
    private String f16068R;
    /* renamed from: S */
    private String f16069S;
    /* renamed from: T */
    private int f16070T;
    /* renamed from: U */
    private String f16071U;
    /* renamed from: V */
    private int f16072V = -1;
    /* renamed from: a */
    private String f16073a;
    /* renamed from: b */
    private int f16074b;
    /* renamed from: c */
    private int f16075c;
    /* renamed from: d */
    private boolean f16076d = false;
    /* renamed from: e */
    private String f16077e;
    /* renamed from: f */
    private String f16078f;
    /* renamed from: g */
    private int f16079g;
    /* renamed from: h */
    private long f16080h;
    /* renamed from: i */
    private String f16081i;
    /* renamed from: j */
    private String f16082j;
    /* renamed from: k */
    private int f16083k;
    /* renamed from: l */
    private int f16084l;
    /* renamed from: m */
    private String f16085m;
    /* renamed from: n */
    private String f16086n;
    /* renamed from: o */
    private String f16087o;
    /* renamed from: p */
    private int f16088p;
    /* renamed from: q */
    private int f16089q;
    /* renamed from: r */
    private int f16090r;
    /* renamed from: s */
    private String f16091s;
    /* renamed from: t */
    private String f16092t;
    /* renamed from: u */
    private String f16093u;
    /* renamed from: v */
    private int f16094v;
    /* renamed from: w */
    private int f16095w;
    /* renamed from: x */
    private int f16096x;
    /* renamed from: y */
    private int f16097y;
    /* renamed from: z */
    private int f16098z;

    public C4958h() {
    }

    public C4958h(String str) {
        String str2 = "";
        try {
            if (TextUtils.isEmpty(str)) {
                C5205o.m21462a("vb em");
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("vb jsonstr = ");
            sb.append(str);
            C5205o.m21462a(sb.toString());
            JSONObject jSONObject = new JSONObject(str);
            this.f16077e = jSONObject.optString("video_title", str2);
            this.f16078f = jSONObject.optString("video_url", str2);
            this.f16079g = jSONObject.optInt("video_length", 0);
            this.f16080h = jSONObject.optLong("video_size", 0);
            this.f16081i = jSONObject.optString("video_resolution", str2);
            this.f16082j = jSONObject.optString("video_cover", str2);
            this.f16083k = jSONObject.optInt("video_end_type", 0);
            this.f16084l = jSONObject.optInt("video_sound", 0);
            this.f16085m = jSONObject.optString("video_end_url", str2);
            this.f16086n = jSONObject.optString("video_end_html", str2);
            this.f16087o = jSONObject.optString("video_end_zip", str2);
            this.f16088p = jSONObject.optInt("video_end_control", 0);
            this.f16089q = jSONObject.optInt("video_play_type", 0);
            this.f16090r = jSONObject.optInt("video_is_reward", 0);
            this.f16091s = jSONObject.optString("video_reward_amount", str2);
            this.f16092t = jSONObject.optString("video_reward_name", str2);
            this.f16093u = jSONObject.optString("video_reward_currency", str2);
            this.f16094v = jSONObject.optInt("video_callback_method");
            this.f16095w = jSONObject.optInt("video_skip_time", 0);
            this.f16096x = jSONObject.optInt("video_finish_time", 0);
            this.f16097y = jSONObject.optInt("video_load_type", 0);
            this.f16098z = jSONObject.optInt("video_cache_timeout", 0);
            this.f16051A = jSONObject.optString("video_banner_url", str2);
            this.f16052B = jSONObject.optString("video_camp_id", str2);
            this.f16053C = jSONObject.optString("video_click_url", str2);
            this.f16054D = jSONObject.optString("video_appid", str2);
            this.f16055E = jSONObject.optInt("video_app_type", 0);
            this.f16056F = jSONObject.optString("video_button_desc", str2);
            this.f16057G = jSONObject.optString("video_icon", str2);
            this.f16058H = jSONObject.optString("video_desc", str2);
            this.f16059I = jSONObject.optString("video_app_name", str2);
            this.f16063M = jSONObject.optString("ad_choice", str2);
            JSONObject optJSONObject = jSONObject.optJSONObject("video_monitor_urls");
            if (optJSONObject != null) {
                this.f16060J = new C4959i(optJSONObject.toString());
            }
            this.f16061K = C5207q.m21477b(jSONObject.optString("video_jump_web_url", str2));
            this.f16062L = jSONObject.optString("video_deep_url", str2);
            this.f16064N = jSONObject.optJSONArray("video_imps");
            this.f16065O = jSONObject.optJSONArray("video_clicks");
            this.f16066P = jSONObject.optInt("s_placement_type");
            this.f16067Q = jSONObject.optInt("s_ads_source");
            this.f16068R = jSONObject.optString("s_act_param");
            this.f16069S = jSONObject.optString("s_act_param2");
            this.f16070T = jSONObject.optInt("adsource");
            this.f16071U = jSONObject.optString("offerid", str2);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: a */
    public C4958h mo26211a(int i) {
        this.f16072V = i;
        return this;
    }

    /* renamed from: a */
    public C4958h mo26212a(String str) {
        this.f16078f = str;
        return this;
    }

    /* renamed from: a */
    public C4958h mo26213a(boolean z) {
        this.f16076d = z;
        return this;
    }

    /* renamed from: a */
    public String mo26214a() {
        return this.f16078f;
    }

    /* renamed from: b */
    public int mo26215b() {
        return this.f16083k;
    }

    /* renamed from: b */
    public C4958h mo26216b(int i) {
        this.f16070T = i;
        return this;
    }

    /* renamed from: b */
    public C4958h mo26217b(String str) {
        this.f16052B = str;
        return this;
    }

    /* renamed from: c */
    public C4958h mo26218c(int i) {
        this.f16074b = i;
        return this;
    }

    /* renamed from: c */
    public C4958h mo26219c(String str) {
        this.f16053C = str;
        return this;
    }

    /* renamed from: c */
    public String mo26220c() {
        return this.f16085m;
    }

    /* renamed from: d */
    public C4958h mo26221d(int i) {
        this.f16075c = i;
        return this;
    }

    /* renamed from: d */
    public C4958h mo26222d(String str) {
        this.f16054D = str;
        return this;
    }

    /* renamed from: d */
    public String mo26223d() {
        return this.f16086n;
    }

    /* renamed from: e */
    public C4958h mo26224e(String str) {
        this.f16056F = str;
        return this;
    }

    /* renamed from: e */
    public String mo26225e() {
        return this.f16052B;
    }

    /* renamed from: f */
    public C4958h mo26226f(String str) {
        this.f16057G = str;
        return this;
    }

    /* renamed from: f */
    public String mo26227f() {
        return this.f16053C;
    }

    /* renamed from: g */
    public C4958h mo26228g(String str) {
        this.f16058H = str;
        return this;
    }

    /* renamed from: g */
    public String mo26229g() {
        return C5207q.m21478b((CharSequence) this.f16054D) ? this.f16054D : C4839a.m19864a(this.f16072V);
    }

    /* renamed from: h */
    public C4958h mo26230h(String str) {
        this.f16059I = str;
        return this;
    }

    /* renamed from: h */
    public String mo26231h() {
        return this.f16057G;
    }

    /* renamed from: i */
    public C4958h mo26232i(String str) {
        this.f16061K = str;
        return this;
    }

    /* renamed from: i */
    public String mo26233i() {
        return this.f16058H;
    }

    /* renamed from: j */
    public C4958h mo26234j(String str) {
        this.f16062L = str;
        return this;
    }

    /* renamed from: j */
    public String mo26235j() {
        return this.f16059I;
    }

    /* renamed from: k */
    public C4958h mo26236k(String str) {
        this.f16063M = str;
        return this;
    }

    /* renamed from: k */
    public C4959i mo26237k() {
        return this.f16060J;
    }

    /* renamed from: l */
    public C4958h mo26238l(String str) {
        this.f16071U = str;
        return this;
    }

    /* renamed from: l */
    public String mo26239l() {
        return this.f16061K;
    }

    /* renamed from: m */
    public C4958h mo26240m(String str) {
        this.f16073a = str;
        return this;
    }

    /* renamed from: m */
    public String mo26241m() {
        return this.f16062L;
    }

    /* renamed from: n */
    public JSONArray mo26242n() {
        return this.f16064N;
    }

    /* renamed from: o */
    public JSONArray mo26243o() {
        return this.f16065O;
    }

    /* renamed from: p */
    public String mo26244p() {
        return this.f16073a;
    }

    /* renamed from: q */
    public int mo26245q() {
        return this.f16074b;
    }

    /* renamed from: r */
    public int mo26246r() {
        return this.f16075c;
    }

    /* renamed from: s */
    public boolean mo26247s() {
        return this.f16076d;
    }

    /* renamed from: t */
    public String mo26248t() {
        return this.f16071U;
    }

    /* renamed from: u */
    public int mo26249u() {
        return this.f16070T;
    }
}
