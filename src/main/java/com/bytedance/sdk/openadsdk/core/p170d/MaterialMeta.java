package com.bytedance.sdk.openadsdk.core.p170d;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.widget.webview.WebViewPool;
import com.bytedance.sdk.openadsdk.core.widget.webview.p179a.TTDynamic;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import com.tencent.p605ep.commonbase.software.AppEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.core.d.k */
public class MaterialMeta {
    /* renamed from: A */
    private Map<String, Object> f7401A;
    /* renamed from: B */
    private C2227a f7402B;
    /* renamed from: C */
    private boolean f7403C;
    /* renamed from: D */
    private int f7404D;
    /* renamed from: E */
    private String f7405E;
    /* renamed from: F */
    private int f7406F = -200;
    /* renamed from: G */
    private int f7407G = 0;
    /* renamed from: H */
    private ClickArea f7408H = new ClickArea();
    /* renamed from: I */
    private AdSlot f7409I;
    /* renamed from: J */
    private int f7410J;
    /* renamed from: K */
    private int f7411K = 1;
    /* renamed from: L */
    private String f7412L;
    /* renamed from: M */
    private int f7413M = 0;
    /* renamed from: N */
    private int f7414N = 0;
    /* renamed from: O */
    private int f7415O = 0;
    /* renamed from: P */
    private JSONObject f7416P;
    /* renamed from: a */
    private int f7417a;
    /* renamed from: b */
    private Image f7418b;
    /* renamed from: c */
    private Image f7419c;
    /* renamed from: d */
    private String f7420d;
    /* renamed from: e */
    private List<Image> f7421e = new ArrayList();
    /* renamed from: f */
    private String f7422f;
    /* renamed from: g */
    private List<String> f7423g = new ArrayList();
    /* renamed from: h */
    private List<String> f7424h = new ArrayList();
    /* renamed from: i */
    private String f7425i;
    /* renamed from: j */
    private String f7426j;
    /* renamed from: k */
    private String f7427k;
    /* renamed from: l */
    private String f7428l = "0";
    /* renamed from: m */
    private C2222b f7429m;
    /* renamed from: n */
    private DeepLink f7430n;
    /* renamed from: o */
    private int f7431o;
    /* renamed from: p */
    private String f7432p;
    /* renamed from: q */
    private String f7433q;
    /* renamed from: r */
    private List<FilterWord> f7434r = new ArrayList();
    /* renamed from: s */
    private int f7435s = 0;
    /* renamed from: t */
    private long f7436t;
    /* renamed from: u */
    private int f7437u;
    /* renamed from: v */
    private VideoInfo f7438v;
    /* renamed from: w */
    private boolean f7439w;
    /* renamed from: x */
    private boolean f7440x;
    /* renamed from: y */
    private boolean f7441y;
    /* renamed from: z */
    private DownConfig f7442z;

    /* compiled from: MaterialMeta */
    /* renamed from: com.bytedance.sdk.openadsdk.core.d.k$a */
    public static class C2227a {
        /* renamed from: a */
        private String f7443a;
        /* renamed from: b */
        private String f7444b;
        /* renamed from: c */
        private String f7445c;
        /* renamed from: d */
        private String f7446d;
        /* renamed from: e */
        private String f7447e;
        /* renamed from: f */
        private String f7448f;
        /* renamed from: g */
        private String f7449g;

        /* renamed from: a */
        public String mo15513a() {
            return this.f7448f;
        }

        /* renamed from: a */
        public void mo15514a(String str) {
            this.f7448f = str;
        }

        /* renamed from: b */
        public String mo15515b() {
            return this.f7443a;
        }

        /* renamed from: b */
        public void mo15516b(String str) {
            this.f7443a = str;
        }

        /* renamed from: c */
        public String mo15517c() {
            return this.f7444b;
        }

        /* renamed from: c */
        public void mo15518c(String str) {
            this.f7444b = str;
        }

        /* renamed from: d */
        public String mo15519d() {
            return this.f7445c;
        }

        /* renamed from: d */
        public void mo15520d(String str) {
            this.f7445c = str;
        }

        /* renamed from: e */
        public String mo15521e() {
            return this.f7446d;
        }

        /* renamed from: e */
        public void mo15522e(String str) {
            this.f7446d = str;
        }

        /* renamed from: f */
        public String mo15523f() {
            return this.f7447e;
        }

        /* renamed from: f */
        public void mo15524f(String str) {
            this.f7447e = str;
        }

        /* renamed from: g */
        public String mo15525g() {
            return this.f7449g;
        }

        /* renamed from: g */
        public void mo15526g(String str) {
            this.f7449g = str;
        }
    }

    /* renamed from: a */
    public int mo15439a() {
        return this.f7413M;
    }

    /* renamed from: a */
    public void mo15440a(int i) {
        this.f7413M = i;
    }

    /* renamed from: b */
    public boolean mo15465b() {
        return this.f7413M == 1;
    }

    /* renamed from: c */
    public int mo15466c() {
        return this.f7404D;
    }

    /* renamed from: b */
    public void mo15460b(int i) {
        this.f7404D = i;
    }

    /* renamed from: d */
    public String mo15471d() {
        return this.f7405E;
    }

    /* renamed from: a */
    public void mo15451a(String str) {
        this.f7405E = str;
    }

    /* renamed from: e */
    public int mo15475e() {
        return this.f7415O;
    }

    /* renamed from: c */
    public void mo15467c(int i) {
        this.f7415O = i;
    }

    /* renamed from: f */
    public int mo15479f() {
        return this.f7414N;
    }

    /* renamed from: d */
    public void mo15472d(int i) {
        this.f7414N = i;
    }

    /* renamed from: g */
    public int mo15482g() {
        return this.f7411K;
    }

    /* renamed from: e */
    public void mo15476e(int i) {
        this.f7411K = i;
    }

    /* renamed from: h */
    public int mo15485h() {
        return this.f7407G;
    }

    /* renamed from: f */
    public void mo15480f(int i) {
        this.f7407G = i;
    }

    /* renamed from: i */
    public ClickArea mo15489i() {
        return this.f7408H;
    }

    /* renamed from: a */
    public void mo15445a(ClickArea dVar) {
        this.f7408H = dVar;
    }

    /* renamed from: j */
    public AdSlot mo15492j() {
        return this.f7409I;
    }

    /* renamed from: a */
    public void mo15442a(AdSlot adSlot) {
        this.f7409I = adSlot;
    }

    /* renamed from: k */
    public boolean mo15496k() {
        return mo15497l() == 1;
    }

    /* renamed from: l */
    public int mo15497l() {
        DownConfig gVar = this.f7442z;
        if (gVar == null) {
            return 0;
        }
        return gVar.mo15394g();
    }

    /* renamed from: m */
    public int mo15499m() {
        return this.f7410J;
    }

    /* renamed from: g */
    public void mo15483g(int i) {
        this.f7410J = i;
    }

    /* renamed from: n */
    public int mo15500n() {
        return this.f7406F;
    }

    /* renamed from: h */
    public void mo15486h(int i) {
        this.f7406F = i;
    }

    /* renamed from: af */
    private int m9332af() {
        DownConfig gVar = this.f7442z;
        if (gVar == null) {
            return 0;
        }
        return gVar.mo15388d();
    }

    /* renamed from: o */
    public boolean mo15501o() {
        VideoInfo rVar = this.f7438v;
        return rVar == null || rVar.mo15608l() != 1;
    }

    /* renamed from: p */
    public boolean mo15502p() {
        VideoInfo rVar = this.f7438v;
        return rVar != null && rVar.mo15609m() == 1;
    }

    /* renamed from: q */
    public boolean mo15503q() {
        return this.f7403C;
    }

    /* renamed from: r */
    public boolean mo15504r() {
        return mo15503q() && mo15466c() == 1;
    }

    /* renamed from: a */
    public void mo15454a(boolean z) {
        this.f7403C = z;
    }

    /* renamed from: s */
    public boolean mo15505s() {
        return mo15506t() == 1;
    }

    /* renamed from: t */
    public int mo15506t() {
        DownConfig gVar = this.f7442z;
        if (gVar == null) {
            return 1;
        }
        return gVar.mo15382a();
    }

    /* renamed from: u */
    public boolean mo15507u() {
        DownConfig gVar = this.f7442z;
        return gVar != null && gVar.mo15387c();
    }

    /* renamed from: v */
    public int mo15508v() {
        DownConfig gVar = this.f7442z;
        if (gVar == null) {
            return 1;
        }
        return gVar.mo15390e();
    }

    /* renamed from: w */
    public int mo15509w() {
        DownConfig gVar = this.f7442z;
        if (gVar == null) {
            return 0;
        }
        return gVar.mo15392f();
    }

    /* renamed from: x */
    public C2227a mo15510x() {
        return this.f7402B;
    }

    /* renamed from: a */
    public void mo15449a(C2227a aVar) {
        this.f7402B = aVar;
        WebViewPool.m10920a().mo16393b();
        TTDynamic.m10864a(this);
    }

    /* renamed from: y */
    public DownConfig mo15511y() {
        return this.f7442z;
    }

    /* renamed from: a */
    public void mo15447a(DownConfig gVar) {
        this.f7442z = gVar;
    }

    /* renamed from: z */
    public VideoInfo mo15512z() {
        return this.f7438v;
    }

    /* renamed from: a */
    public void mo15450a(VideoInfo rVar) {
        this.f7438v = rVar;
    }

    /* renamed from: b */
    public void mo15462b(String str) {
        this.f7432p = str;
    }

    /* renamed from: A */
    public String mo15413A() {
        return this.f7432p;
    }

    /* renamed from: B */
    public int mo15414B() {
        return this.f7417a;
    }

    /* renamed from: i */
    public void mo15490i(int i) {
        this.f7417a = i;
    }

    /* renamed from: C */
    public Image mo15415C() {
        return this.f7418b;
    }

    /* renamed from: a */
    public void mo15448a(Image jVar) {
        this.f7418b = jVar;
    }

    /* renamed from: D */
    public Image mo15416D() {
        return this.f7419c;
    }

    /* renamed from: b */
    public void mo15461b(Image jVar) {
        this.f7419c = jVar;
    }

    /* renamed from: E */
    public String mo15417E() {
        return this.f7420d;
    }

    /* renamed from: c */
    public void mo15469c(String str) {
        this.f7420d = str;
    }

    /* renamed from: F */
    public List<Image> mo15418F() {
        return this.f7421e;
    }

    /* renamed from: c */
    public void mo15468c(Image jVar) {
        this.f7421e.add(jVar);
    }

    /* renamed from: G */
    public String mo15419G() {
        return this.f7422f;
    }

    /* renamed from: d */
    public void mo15473d(String str) {
        this.f7422f = str;
    }

    /* renamed from: H */
    public List<String> mo15420H() {
        return this.f7423g;
    }

    /* renamed from: I */
    public List<String> mo15421I() {
        return this.f7424h;
    }

    /* renamed from: J */
    public String mo15422J() {
        return this.f7425i;
    }

    /* renamed from: e */
    public void mo15477e(String str) {
        this.f7425i = str;
    }

    /* renamed from: K */
    public String mo15423K() {
        return this.f7426j;
    }

    /* renamed from: f */
    public void mo15481f(String str) {
        this.f7426j = str;
    }

    /* renamed from: L */
    public String mo15424L() {
        return this.f7427k;
    }

    /* renamed from: g */
    public void mo15484g(String str) {
        this.f7427k = str;
    }

    /* renamed from: M */
    public String mo15425M() {
        return this.f7428l;
    }

    /* renamed from: h */
    public void mo15487h(String str) {
        this.f7428l = str;
    }

    /* renamed from: N */
    public C2222b mo15426N() {
        return this.f7429m;
    }

    /* renamed from: a */
    public void mo15444a(C2222b bVar) {
        this.f7429m = bVar;
    }

    /* renamed from: O */
    public DeepLink mo15427O() {
        return this.f7430n;
    }

    /* renamed from: a */
    public void mo15446a(DeepLink fVar) {
        this.f7430n = fVar;
    }

    /* renamed from: P */
    public String mo15428P() {
        return this.f7433q;
    }

    /* renamed from: i */
    public void mo15491i(String str) {
        this.f7433q = str;
    }

    /* renamed from: Q */
    public int mo15429Q() {
        return this.f7431o;
    }

    /* renamed from: j */
    public void mo15493j(int i) {
        this.f7431o = i;
    }

    /* renamed from: R */
    public List<FilterWord> mo15430R() {
        return this.f7434r;
    }

    /* renamed from: a */
    public void mo15443a(FilterWord filterWord) {
        this.f7434r.add(filterWord);
    }

    /* renamed from: S */
    public long mo15431S() {
        return this.f7436t;
    }

    /* renamed from: a */
    public void mo15441a(long j) {
        this.f7436t = j;
    }

    /* renamed from: T */
    public int mo15432T() {
        return this.f7437u;
    }

    /* renamed from: k */
    public void mo15495k(int i) {
        this.f7437u = i;
    }

    /* renamed from: U */
    public boolean mo15433U() {
        return this.f7439w;
    }

    /* renamed from: b */
    public void mo15464b(boolean z) {
        this.f7439w = z;
    }

    /* renamed from: V */
    public boolean mo15434V() {
        return this.f7440x;
    }

    /* renamed from: c */
    public void mo15470c(boolean z) {
        this.f7440x = z;
    }

    /* renamed from: W */
    public boolean mo15435W() {
        return this.f7441y;
    }

    /* renamed from: d */
    public void mo15474d(boolean z) {
        this.f7441y = z;
    }

    /* renamed from: X */
    public Map<String, Object> mo15436X() {
        return this.f7401A;
    }

    /* renamed from: a */
    public void mo15452a(Map<String, Object> map) {
        this.f7401A = map;
    }

    /* renamed from: Y */
    public JSONObject mo15437Y() {
        return this.f7416P;
    }

    /* renamed from: a */
    public void mo15453a(JSONObject jSONObject) {
        this.f7416P = jSONObject;
    }

    /* renamed from: Z */
    public String mo15438Z() {
        return this.f7412L;
    }

    /* renamed from: j */
    public void mo15494j(String str) {
        this.f7412L = str;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MaterialMeta kVar = (MaterialMeta) obj;
        if (!this.f7428l.equals(kVar.f7428l) || !this.f7433q.equals(kVar.f7433q)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (this.f7428l.hashCode() * 31) + this.f7433q.hashCode();
    }

    /* renamed from: aa */
    public boolean mo15455aa() {
        if (this.f7421e.isEmpty()) {
            return false;
        }
        if (this.f7431o == 4 && this.f7421e.size() < 3) {
            return false;
        }
        for (Image d : this.f7421e) {
            if (!d.mo15412d()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: ab */
    public int mo15456ab() {
        DownConfig gVar = this.f7442z;
        if (gVar == null) {
            return -1;
        }
        return gVar.mo15384b();
    }

    /* renamed from: ac */
    public boolean mo15457ac() {
        return mo15458ad() == 1;
    }

    /* renamed from: ad */
    public int mo15458ad() {
        return this.f7435s;
    }

    /* renamed from: l */
    public void mo15498l(int i) {
        this.f7435s = i;
    }

    /* renamed from: b */
    public void mo15463b(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f7417a = 4;
            this.f7428l = jSONObject.optString("id");
            this.f7432p = jSONObject.optString(ArgKey.KEY_SOURCE);
            this.f7429m = new C2222b();
            this.f7429m.mo15349d(jSONObject.optString("pkg_name"));
            this.f7429m.mo15347c(jSONObject.optString(ArgKey.KEY_NAME));
            this.f7429m.mo15344b(jSONObject.optString("download_url"));
        }
    }

    /* renamed from: ae */
    public JSONObject mo15459ae() {
        String str = "is_playable";
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("interaction_type", mo15414B());
            jSONObject.put("target_url", mo15417E());
            jSONObject.put("ad_id", mo15425M());
            jSONObject.put(ArgKey.KEY_SOURCE, mo15413A());
            jSONObject.put("screenshot", mo15433U());
            jSONObject.put("dislike_control", mo15458ad());
            jSONObject.put("play_bar_show_time", mo15500n());
            jSONObject.put(str, mo15503q());
            jSONObject.put("playable_type", mo15466c());
            jSONObject.put("playable_style", mo15471d());
            jSONObject.put("play_bar_style", mo15485h());
            jSONObject.put("if_block_lp", mo15439a());
            Image C = mo15415C();
            String str2 = "width";
            String str3 = "height";
            String str4 = "url";
            if (C != null) {
                if (!TextUtils.isEmpty(C.mo15406a())) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(str4, C.mo15406a());
                    jSONObject2.put(str3, C.mo15411c());
                    jSONObject2.put(str2, C.mo15409b());
                    jSONObject.put("icon", jSONObject2);
                }
            }
            Image D = mo15416D();
            if (D != null && !TextUtils.isEmpty(D.mo15406a())) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(str4, D.mo15406a());
                jSONObject3.put(str3, D.mo15411c());
                jSONObject3.put(str2, D.mo15409b());
                jSONObject.put("cover_image", jSONObject3);
            }
            JSONObject Y = mo15437Y();
            if (Y != null) {
                jSONObject.put("session_params", Y);
            }
            ClickArea i = mo15489i();
            if (i != null) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("click_upper_content_area", i.f7331a);
                jSONObject4.put("click_upper_non_content_area", i.f7332b);
                jSONObject4.put("click_lower_content_area", i.f7333c);
                jSONObject4.put("click_lower_non_content_area", i.f7334d);
                jSONObject4.put("click_button_area", i.f7335e);
                jSONObject4.put("click_video_area", i.f7336f);
                jSONObject.put("click_area", jSONObject4);
            }
            AdSlot j = mo15492j();
            if (j != null) {
                jSONObject.put("adslot", j.toJsonObj());
            }
            List<Image> F = mo15418F();
            if (F != null) {
                JSONArray jSONArray = new JSONArray();
                for (Image jVar : F) {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put(str4, jVar.mo15406a());
                    jSONObject5.put(str3, jVar.mo15411c());
                    jSONObject5.put(str2, jVar.mo15409b());
                    jSONArray.put(jSONObject5);
                }
                jSONObject.put("image", jSONArray);
            }
            List<String> H = mo15420H();
            if (H != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (String put : H) {
                    jSONArray2.put(put);
                }
                jSONObject.put("show_url", jSONArray2);
            }
            List<String> I = mo15421I();
            if (I != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (String put2 : I) {
                    jSONArray3.put(put2);
                }
                jSONObject.put("click_url", jSONArray3);
            }
            jSONObject.put("phone_num", mo15419G());
            jSONObject.put("title", mo15422J());
            jSONObject.put("description", mo15423K());
            jSONObject.put("ext", mo15428P());
            jSONObject.put("image_mode", mo15429Q());
            jSONObject.put(str, mo15503q());
            jSONObject.put("intercept_flag", mo15499m());
            jSONObject.put("button_text", mo15424L());
            jSONObject.put("ad_logo", mo15482g());
            jSONObject.put("video_adaptation", mo15479f());
            jSONObject.put("feed_video_opentype", mo15475e());
            C2222b N = mo15426N();
            if (N != null) {
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("app_name", N.mo15345c());
                jSONObject6.put("package_name", N.mo15348d());
                jSONObject6.put("download_url", N.mo15342b());
                jSONObject6.put("score", N.mo15350e());
                jSONObject6.put("comment_num", N.mo15351f());
                jSONObject6.put("quick_app_url", N.mo15339a());
                jSONObject6.put("app_size", N.mo15352g());
                jSONObject.put("app", jSONObject6);
            }
            DeepLink O = mo15427O();
            if (O != null) {
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put("deeplink_url", O.mo15376a());
                jSONObject7.put("fallback_url", O.mo15379b());
                jSONObject7.put("fallback_type", O.mo15381c());
                jSONObject.put("deep_link", jSONObject7);
            }
            List<FilterWord> R = mo15430R();
            if (R != null) {
                JSONArray jSONArray4 = new JSONArray();
                for (FilterWord b : R) {
                    JSONObject b2 = m9333b(b);
                    if (b2 != null) {
                        jSONArray4.put(b2);
                    }
                }
                jSONObject.put("filter_words", jSONArray4);
            }
            jSONObject.put("count_down", mo15432T());
            jSONObject.put("expiration_time", mo15431S());
            VideoInfo z = mo15512z();
            if (z != null) {
                jSONObject.put("video", z.mo15607k());
            }
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("auto_open", mo15508v());
            jSONObject8.put("download_mode", mo15509w());
            jSONObject8.put("support_multiple", m9332af());
            jSONObject8.put("download_type", mo15456ab());
            jSONObject8.put("auto_control", mo15497l());
            jSONObject8.put("if_suspend_download", mo15506t());
            jSONObject.put("download_conf", jSONObject8);
            if (mo15436X() != null) {
                JSONObject jSONObject9 = new JSONObject();
                Set<Entry> entrySet = mo15436X().entrySet();
                if (entrySet != null && !entrySet.isEmpty()) {
                    for (Entry entry : entrySet) {
                        jSONObject9.put((String) entry.getKey(), entry.getValue());
                    }
                }
                jSONObject.put("media_ext", jSONObject9);
            }
            C2227a x = mo15510x();
            if (x != null) {
                JSONObject jSONObject10 = new JSONObject();
                jSONObject10.put("id", x.mo15515b());
                jSONObject10.put("md5", x.mo15517c());
                jSONObject10.put(str4, x.mo15519d());
                jSONObject10.put("data", x.mo15521e());
                jSONObject10.put("diff_data", x.mo15523f());
                jSONObject10.put(AppEntity.KEY_VERSION_STR, x.mo15513a());
                jSONObject10.put("dynamic_creative", x.mo15525g());
                jSONObject.put("tpl_info", jSONObject10);
            }
            jSONObject.put("market_url", mo15438Z());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* renamed from: b */
    private JSONObject m9333b(FilterWord filterWord) {
        if (filterWord == null) {
            return null;
        }
        try {
            if (filterWord.isValid()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", filterWord.getId());
                jSONObject.put(ArgKey.KEY_NAME, filterWord.getName());
                jSONObject.put("is_selected", filterWord.getIsSelected());
                if (filterWord.hasSecondOptions()) {
                    JSONArray jSONArray = new JSONArray();
                    for (FilterWord b : filterWord.getOptions()) {
                        jSONArray.put(m9333b(b));
                    }
                    if (jSONArray.length() > 0) {
                        jSONObject.put("options", jSONArray);
                    }
                }
                return jSONObject;
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
