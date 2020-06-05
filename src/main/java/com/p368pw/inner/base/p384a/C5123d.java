package com.p368pw.inner.base.p384a;

import com.p368pw.inner.base.p387d.C5162b;
import com.p368pw.inner.base.p387d.C5188f;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.C5207q;
import com.tencent.mid.sotrage.StorageInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.pw.inner.base.a.d */
public class C5123d {
    /* renamed from: A */
    private String f16680A;
    /* renamed from: B */
    private String f16681B;
    /* renamed from: C */
    private String f16682C;
    /* renamed from: D */
    private String f16683D;
    /* renamed from: E */
    private String f16684E;
    /* renamed from: F */
    private String f16685F;
    /* renamed from: G */
    private String f16686G;
    /* renamed from: H */
    private int f16687H;
    /* renamed from: I */
    private int f16688I;
    /* renamed from: J */
    private int f16689J;
    /* renamed from: K */
    private int f16690K;
    /* renamed from: L */
    private List<String> f16691L;
    /* renamed from: M */
    private int f16692M;
    /* renamed from: N */
    private int f16693N;
    /* renamed from: O */
    private int f16694O;
    /* renamed from: P */
    private int f16695P;
    /* renamed from: Q */
    private int f16696Q;
    /* renamed from: R */
    private int f16697R;
    /* renamed from: S */
    private int f16698S;
    /* renamed from: T */
    private String f16699T;
    /* renamed from: U */
    private long f16700U;
    /* renamed from: V */
    private boolean f16701V;
    /* renamed from: W */
    private int f16702W;
    /* renamed from: X */
    private int f16703X;
    /* renamed from: Y */
    private int f16704Y;
    /* renamed from: Z */
    private String f16705Z;
    /* renamed from: a */
    private int f16706a = 0;
    /* renamed from: aa */
    private int f16707aa;
    /* renamed from: ab */
    private int f16708ab;
    /* renamed from: ac */
    private int f16709ac;
    /* renamed from: b */
    private int f16710b = 3;
    /* renamed from: c */
    private int f16711c = 5;
    /* renamed from: d */
    private int f16712d = 1;
    /* renamed from: e */
    private int f16713e = 100;
    /* renamed from: f */
    private int f16714f = 200;
    /* renamed from: g */
    private String f16715g;
    /* renamed from: h */
    private int f16716h;
    /* renamed from: i */
    private int f16717i;
    /* renamed from: j */
    private String f16718j;
    /* renamed from: k */
    private String f16719k;
    /* renamed from: l */
    private String f16720l;
    /* renamed from: m */
    private String f16721m;
    /* renamed from: n */
    private String f16722n;
    /* renamed from: o */
    private int f16723o;
    /* renamed from: p */
    private int f16724p;
    /* renamed from: q */
    private int f16725q;
    /* renamed from: r */
    private int f16726r;
    /* renamed from: s */
    private int f16727s;
    /* renamed from: t */
    private int f16728t;
    /* renamed from: u */
    private int f16729u;
    /* renamed from: v */
    private int f16730v;
    /* renamed from: w */
    private int f16731w;
    /* renamed from: x */
    private int f16732x;
    /* renamed from: y */
    private int f16733y;
    /* renamed from: z */
    private String f16734z;

    public C5123d(String str) {
        String str2 = str;
        boolean z = false;
        String str3 = "";
        this.f16715g = str3;
        this.f16716h = 300;
        this.f16717i = 501;
        this.f16718j = str3;
        String str4 = "4";
        this.f16719k = str4;
        this.f16720l = str3;
        this.f16721m = str3;
        this.f16722n = str3;
        this.f16723o = 0;
        this.f16724p = 1;
        this.f16725q = 0;
        this.f16726r = 10;
        this.f16727s = 6;
        this.f16728t = 6;
        this.f16729u = 0;
        this.f16730v = 0;
        this.f16731w = 0;
        this.f16732x = 110;
        this.f16733y = 120;
        this.f16734z = "下载看看";
        this.f16680A = "亲，您真的不想下载安装体验下嘛~";
        this.f16681B = "马上安装";
        this.f16682C = "亲，您真的不想安装体验下嘛~";
        this.f16683D = "打开体验";
        this.f16684E = "动动手指，打开体验下吧!";
        this.f16685F = "立即查看";
        this.f16686G = "亲～ 点击查看有惊喜哦~";
        this.f16687H = 6;
        this.f16688I = 6;
        this.f16689J = 1;
        this.f16690K = 1;
        this.f16691L = null;
        this.f16692M = 8;
        this.f16693N = 6;
        this.f16694O = 100;
        this.f16695P = 30;
        this.f16696Q = 1;
        this.f16697R = 12;
        this.f16698S = 1;
        this.f16700U = 1;
        this.f16701V = false;
        this.f16708ab = 1;
        this.f16709ac = 10;
        try {
            if (C5207q.m21476a((CharSequence) str)) {
                C5205o.m21462a("策略解析失败，json is empty.");
                return;
            }
            this.f16705Z = str2;
            String b = C5162b.m21305a().mo26771b(str2);
            StringBuilder sb = new StringBuilder();
            sb.append("sty jsonstr = ");
            sb.append(b);
            C5205o.m21462a(sb.toString());
            JSONObject jSONObject = new JSONObject(b);
            int optInt = jSONObject.optJSONObject("res_status").optInt("resp_code");
            if (optInt != 200) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("策略解析失败，code error:");
                sb2.append(optInt);
                C5205o.m21462a(sb2.toString());
                return;
            }
            JSONObject optJSONObject = new JSONObject(jSONObject.optString("body")).optJSONObject("service_343");
            if (optJSONObject == null) {
                C5205o.m21462a("策略解析失败，serviceObject is null.");
                return;
            }
            this.f16702W = optJSONObject.optInt("group_id", 0);
            this.f16703X = optJSONObject.optInt("plan_id", 0);
            JSONArray optJSONArray = optJSONObject.optJSONArray("configs");
            if (optJSONArray != null) {
                if (optJSONArray.length() != 0) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(0);
                    this.f16706a = optJSONObject2.optInt("bo", 1);
                    this.f16693N = optJSONObject2.optInt("vt", 2);
                    this.f16710b = optJSONObject2.optInt("sr", 3);
                    this.f16711c = optJSONObject2.optInt("su", 5);
                    this.f16712d = optJSONObject2.optInt("tc", 0);
                    this.f16713e = optJSONObject2.optInt("te", 100);
                    this.f16714f = optJSONObject2.optInt("tg", 200);
                    this.f16715g = optJSONObject2.optString("tgurl", str3);
                    this.f16716h = optJSONObject2.optInt("th", 300);
                    this.f16717i = optJSONObject2.optInt("tv", 501);
                    this.f16718j = optJSONObject2.optString("tvurl", str3);
                    String optString = optJSONObject2.optString("tvp", str4);
                    if (C5207q.m21478b((CharSequence) optString)) {
                        this.f16719k = optString;
                    }
                    this.f16720l = optJSONObject2.optString("tvic", str3);
                    this.f16721m = optJSONObject2.optString("tvtt", str3);
                    this.f16722n = optJSONObject2.optString("tvdes", str3);
                    this.f16704Y = optJSONObject2.optInt("config_id", 0);
                    this.f16723o = optJSONObject2.optInt("ct", 0);
                    this.f16724p = optJSONObject2.optInt("cn", 1);
                    this.f16725q = optJSONObject2.optInt("ts", 0);
                    this.f16726r = optJSONObject2.optInt("cu", 10);
                    this.f16727s = optJSONObject2.optInt("cv", 6);
                    this.f16728t = optJSONObject2.optInt("cw", 6);
                    this.f16729u = optJSONObject2.optInt("ds", 8);
                    this.f16730v = optJSONObject2.optInt("at", 0);
                    this.f16731w = optJSONObject2.optInt("ac", 0);
                    this.f16732x = optJSONObject2.optInt("fc", 110);
                    this.f16733y = optJSONObject2.optInt("fe", 120);
                    this.f16734z = optJSONObject2.optString("wda");
                    this.f16680A = optJSONObject2.optString("wdb");
                    this.f16681B = optJSONObject2.optString("wea");
                    this.f16682C = optJSONObject2.optString("web");
                    this.f16683D = optJSONObject2.optString("wfa");
                    this.f16684E = optJSONObject2.optString("wfb");
                    this.f16685F = optJSONObject2.optString("wga");
                    this.f16686G = optJSONObject2.optString("wgb");
                    this.f16687H = optJSONObject2.optInt("ka", 10);
                    this.f16688I = optJSONObject2.optInt("kb", 0);
                    this.f16689J = optJSONObject2.optInt("cc1", 2);
                    this.f16690K = optJSONObject2.optInt("cc2", 2);
                    String optString2 = optJSONObject2.optString("tcb");
                    if (C5207q.m21478b((CharSequence) optString2)) {
                        this.f16691L = new ArrayList(Arrays.asList(optString2.split(StorageInterface.KEY_SPLITER)));
                    }
                    this.f16692M = optJSONObject2.optInt("la", 8);
                    this.f16694O = optJSONObject2.optInt("vr", 100);
                    this.f16695P = optJSONObject2.optInt("shdc", 30);
                    this.f16696Q = optJSONObject2.optInt("km", 1);
                    this.f16697R = optJSONObject2.optInt("kn", 12);
                    this.f16698S = optJSONObject2.optInt("ko", 2);
                    this.f16699T = optJSONObject2.optString("txf", null);
                    this.f16700U = optJSONObject2.optLong("txfd", 1);
                    if (optJSONObject2.optInt("txc", 0) == 1) {
                        z = true;
                    }
                    this.f16701V = z;
                    this.f16707aa = optJSONObject2.optInt("vv", 1);
                    this.f16708ab = optJSONObject2.optInt("txdlt", 1);
                    this.f16709ac = optJSONObject2.optInt("shrp", 10);
                    C5205o.m21462a("策略解析成功");
                }
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: A */
    public String mo26673A() {
        return this.f16734z;
    }

    /* renamed from: B */
    public String mo26674B() {
        return this.f16680A;
    }

    /* renamed from: C */
    public String mo26675C() {
        return this.f16681B;
    }

    /* renamed from: D */
    public String mo26676D() {
        return this.f16682C;
    }

    /* renamed from: E */
    public String mo26677E() {
        return this.f16683D;
    }

    /* renamed from: F */
    public String mo26678F() {
        return this.f16684E;
    }

    /* renamed from: G */
    public String mo26679G() {
        return this.f16685F;
    }

    /* renamed from: H */
    public String mo26680H() {
        return this.f16686G;
    }

    /* renamed from: I */
    public int mo26681I() {
        return this.f16687H;
    }

    /* renamed from: J */
    public int mo26682J() {
        return this.f16688I;
    }

    /* renamed from: K */
    public int mo26683K() {
        return this.f16689J;
    }

    /* renamed from: L */
    public int mo26684L() {
        return this.f16690K;
    }

    /* renamed from: M */
    public int mo26685M() {
        return this.f16692M;
    }

    /* renamed from: N */
    public int mo26686N() {
        return this.f16693N;
    }

    /* renamed from: O */
    public int mo26687O() {
        return this.f16694O;
    }

    /* renamed from: P */
    public int mo26688P() {
        return this.f16696Q;
    }

    /* renamed from: Q */
    public int mo26689Q() {
        return this.f16697R;
    }

    /* renamed from: R */
    public int mo26690R() {
        return this.f16698S;
    }

    /* renamed from: S */
    public String mo26691S() {
        return this.f16699T;
    }

    /* renamed from: T */
    public long mo26692T() {
        return this.f16700U;
    }

    /* renamed from: U */
    public boolean mo26693U() {
        return this.f16701V;
    }

    /* renamed from: V */
    public String mo26694V() {
        return this.f16705Z;
    }

    /* renamed from: W */
    public String mo26695W() {
        return this.f16722n;
    }

    /* renamed from: X */
    public int mo26696X() {
        return this.f16707aa;
    }

    /* renamed from: a */
    public boolean mo26697a() {
        if (C5188f.m21377a((Collection) this.f16691L)) {
            return false;
        }
        return this.f16691L.contains("video_end");
    }

    /* renamed from: b */
    public int mo26698b() {
        return this.f16708ab;
    }

    /* renamed from: c */
    public int mo26699c() {
        if (this.f16709ac < 0) {
            this.f16709ac = 0;
        }
        if (this.f16709ac > 100) {
            this.f16709ac = 100;
        }
        return this.f16709ac;
    }

    /* renamed from: d */
    public int mo26700d() {
        return this.f16710b;
    }

    /* renamed from: e */
    public int mo26701e() {
        return this.f16711c;
    }

    /* renamed from: f */
    public int mo26702f() {
        return this.f16713e;
    }

    /* renamed from: g */
    public int mo26703g() {
        return this.f16714f;
    }

    /* renamed from: h */
    public String mo26704h() {
        return this.f16715g;
    }

    /* renamed from: i */
    public int mo26705i() {
        return this.f16716h;
    }

    /* renamed from: j */
    public int mo26706j() {
        return this.f16717i;
    }

    /* renamed from: k */
    public String mo26707k() {
        return this.f16718j;
    }

    /* renamed from: l */
    public String mo26708l() {
        return this.f16720l;
    }

    /* renamed from: m */
    public String mo26709m() {
        return this.f16721m;
    }

    /* renamed from: n */
    public String mo26710n() {
        return this.f16719k;
    }

    /* renamed from: o */
    public int mo26711o() {
        return this.f16702W;
    }

    /* renamed from: p */
    public int mo26712p() {
        return this.f16703X;
    }

    /* renamed from: q */
    public int mo26713q() {
        return this.f16704Y;
    }

    /* renamed from: r */
    public int mo26714r() {
        return this.f16723o;
    }

    /* renamed from: s */
    public int mo26715s() {
        return this.f16724p;
    }

    /* renamed from: t */
    public int mo26716t() {
        return this.f16725q;
    }

    /* renamed from: u */
    public int mo26717u() {
        return this.f16726r;
    }

    /* renamed from: v */
    public int mo26718v() {
        return this.f16727s;
    }

    /* renamed from: w */
    public int mo26719w() {
        return this.f16728t;
    }

    /* renamed from: x */
    public int mo26720x() {
        return this.f16729u;
    }

    /* renamed from: y */
    public int mo26721y() {
        return this.f16732x;
    }

    /* renamed from: z */
    public int mo26722z() {
        return this.f16733y;
    }
}
