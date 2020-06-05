package com.p368pw.inner.appwall;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.p368pw.inner.base.p387d.C5162b;
import com.p368pw.inner.base.p387d.C5205o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.pw.inner.appwall.p */
public class C5041p {
    /* renamed from: a */
    private int f16433a;
    /* renamed from: b */
    private String f16434b;
    /* renamed from: c */
    private String f16435c;
    /* renamed from: d */
    private List<C5042a> f16436d;
    /* renamed from: e */
    private HashMap<String, C5042a> f16437e;

    /* renamed from: com.pw.inner.appwall.p$a */
    public static class C5042a {
        /* renamed from: A */
        private double f16438A;
        /* renamed from: B */
        private int f16439B;
        /* renamed from: C */
        private int f16440C;
        /* renamed from: D */
        private int f16441D;
        /* renamed from: E */
        private int f16442E;
        /* renamed from: F */
        private int f16443F;
        /* renamed from: G */
        private int f16444G;
        /* renamed from: H */
        private int f16445H;
        /* renamed from: a */
        public int f16446a;
        /* renamed from: b */
        public List<Integer> f16447b;
        /* renamed from: c */
        public List<Double> f16448c;
        /* renamed from: d */
        public List<Integer> f16449d;
        /* access modifiers changed from: private */
        /* renamed from: e */
        public String f16450e;
        /* renamed from: f */
        private int f16451f = 2;
        /* renamed from: g */
        private int f16452g = 6;
        /* renamed from: h */
        private String f16453h = "下载试玩热门应用,海量奖励等你来拿！";
        /* renamed from: i */
        private String f16454i = "安装并体验应用,就能领取奖励！";
        /* renamed from: j */
        private String f16455j = "每个任务有7次签到机会,每次签到都可获奖。连续7天签到更可获得额外奖励！";
        /* renamed from: k */
        private int f16456k;
        /* renamed from: l */
        private double f16457l;
        /* renamed from: m */
        private int f16458m;
        /* renamed from: n */
        private int f16459n;
        /* renamed from: o */
        private int f16460o;
        /* renamed from: p */
        private int f16461p;
        /* renamed from: q */
        private int f16462q;
        /* renamed from: r */
        private int f16463r;
        /* renamed from: s */
        private int f16464s;
        /* renamed from: t */
        private int f16465t;
        /* renamed from: u */
        private double f16466u;
        /* renamed from: v */
        private double f16467v;
        /* renamed from: w */
        private double f16468w;
        /* renamed from: x */
        private double f16469x;
        /* renamed from: y */
        private double f16470y;
        /* renamed from: z */
        private double f16471z;

        public C5042a(String str) {
            try {
                if (TextUtils.isEmpty(str)) {
                    C5205o.m21462a("pkg cfs em");
                    return;
                }
                JSONObject jSONObject = new JSONObject(str);
                this.f16450e = jSONObject.optString("adpkg");
                this.f16451f = jSONObject.optInt("authSwitch", 2);
                this.f16452g = jSONObject.optInt("stopTime", 6);
                this.f16453h = jSONObject.optString("descDown");
                this.f16454i = jSONObject.optString("descInstall");
                this.f16455j = jSONObject.optString("descSignin");
                this.f16458m = jSONObject.optInt("actDays");
                this.f16456k = jSONObject.optInt("addiRewardTotal");
                this.f16459n = jSONObject.optInt("signinD1");
                this.f16460o = jSONObject.optInt("signinD2");
                this.f16461p = jSONObject.optInt("signinD3");
                this.f16462q = jSONObject.optInt("signinD4");
                this.f16463r = jSONObject.optInt("signinD5");
                this.f16464s = jSONObject.optInt("signinD6");
                this.f16465t = jSONObject.optInt("signinD7");
                this.f16457l = jSONObject.optDouble("f_addiRewardTotal", 0.0d);
                this.f16466u = jSONObject.optDouble("f_signinD1", 0.0d);
                this.f16467v = jSONObject.optDouble("f_signinD2", 0.0d);
                this.f16468w = jSONObject.optDouble("f_signinD3", 0.0d);
                this.f16469x = jSONObject.optDouble("f_signinD4", 0.0d);
                this.f16470y = jSONObject.optDouble("f_signinD5", 0.0d);
                this.f16471z = jSONObject.optDouble("f_signinD6", 0.0d);
                this.f16438A = jSONObject.optDouble("f_signinD7", 0.0d);
                this.f16439B = jSONObject.optInt("signinStatusD1", 0);
                this.f16440C = jSONObject.optInt("signinStatusD2", 0);
                this.f16441D = jSONObject.optInt("signinStatusD3", 0);
                this.f16442E = jSONObject.optInt("signinStatusD4", 0);
                this.f16443F = jSONObject.optInt("signinStatusD5", 0);
                this.f16444G = jSONObject.optInt("signinStatusD6", 0);
                this.f16445H = jSONObject.optInt("signinStatusD7", 0);
                this.f16446a = m21039k();
                m21040l();
                m21041m();
                m21042n();
            } catch (Throwable th) {
                C5205o.m21464a(th);
            }
        }

        /* renamed from: k */
        private int m21039k() {
            int i = this.f16439B == 1 ? 1 : 0;
            if (this.f16440C == 1) {
                i++;
            }
            if (this.f16441D == 1) {
                i++;
            }
            if (this.f16442E == 1) {
                i++;
            }
            if (this.f16443F == 1) {
                i++;
            }
            if (this.f16444G == 1) {
                i++;
            }
            return this.f16445H == 1 ? i + 1 : i;
        }

        /* renamed from: l */
        private void m21040l() {
            this.f16447b = new ArrayList();
            this.f16447b.add(Integer.valueOf(this.f16459n));
            this.f16447b.add(Integer.valueOf(this.f16460o));
            this.f16447b.add(Integer.valueOf(this.f16461p));
            this.f16447b.add(Integer.valueOf(this.f16462q));
            this.f16447b.add(Integer.valueOf(this.f16463r));
            this.f16447b.add(Integer.valueOf(this.f16464s));
            this.f16447b.add(Integer.valueOf(this.f16465t));
        }

        /* renamed from: m */
        private void m21041m() {
            this.f16448c = new ArrayList();
            this.f16448c.add(Double.valueOf(this.f16466u));
            this.f16448c.add(Double.valueOf(this.f16467v));
            this.f16448c.add(Double.valueOf(this.f16468w));
            this.f16448c.add(Double.valueOf(this.f16469x));
            this.f16448c.add(Double.valueOf(this.f16470y));
            this.f16448c.add(Double.valueOf(this.f16471z));
            this.f16448c.add(Double.valueOf(this.f16438A));
        }

        /* renamed from: n */
        private void m21042n() {
            this.f16449d = new ArrayList();
            this.f16449d.add(Integer.valueOf(this.f16439B));
            this.f16449d.add(Integer.valueOf(this.f16440C));
            this.f16449d.add(Integer.valueOf(this.f16441D));
            this.f16449d.add(Integer.valueOf(this.f16442E));
            this.f16449d.add(Integer.valueOf(this.f16443F));
            this.f16449d.add(Integer.valueOf(this.f16444G));
            this.f16449d.add(Integer.valueOf(this.f16445H));
        }

        /* renamed from: a */
        public double mo26479a(boolean z) {
            double d;
            double d2;
            int g = mo26486g();
            if (g > 7) {
                g = 7;
            }
            int i = g > 0 ? g - 1 : 0;
            if (z) {
                double intValue = (double) ((Integer) this.f16447b.get(i)).intValue();
                if (!mo26489j() && i == 6) {
                    intValue += (double) mo26484e();
                }
                if (g <= 0 || g >= 7 || !mo26488i()) {
                    return intValue;
                }
                int i2 = i + 1;
                if (i2 > 6) {
                    i2 = 6;
                }
                d = (double) ((Integer) this.f16447b.get(i2)).intValue();
                if (mo26489j() || i2 != 6) {
                    return d;
                }
                d2 = (double) mo26484e();
            } else {
                double doubleValue = ((Double) this.f16448c.get(i)).doubleValue();
                if (!mo26489j() && i == 6) {
                    doubleValue += mo26485f();
                }
                if (g <= 0 || g >= 7 || !mo26488i()) {
                    return doubleValue;
                }
                int i3 = i + 1;
                if (i3 > 6) {
                    i3 = 6;
                }
                d = ((Double) this.f16448c.get(i3)).doubleValue();
                if (mo26489j() || i3 != 6) {
                    return d;
                }
                d2 = mo26485f();
            }
            return d + d2;
        }

        /* renamed from: a */
        public int mo26480a() {
            return this.f16451f;
        }

        /* renamed from: b */
        public int mo26481b() {
            return this.f16452g;
        }

        /* renamed from: c */
        public String mo26482c() {
            return this.f16453h;
        }

        /* renamed from: d */
        public String mo26483d() {
            return this.f16454i;
        }

        /* renamed from: e */
        public int mo26484e() {
            return this.f16456k;
        }

        /* renamed from: f */
        public double mo26485f() {
            return this.f16457l;
        }

        /* renamed from: g */
        public int mo26486g() {
            return this.f16458m;
        }

        /* renamed from: h */
        public int mo26487h() {
            return this.f16445H;
        }

        /* renamed from: i */
        public boolean mo26488i() {
            int g = mo26486g();
            if (g > 7) {
                g = 7;
            }
            return g <= 0 || ((Integer) this.f16449d.get(g - 1)).intValue() != 0;
        }

        /* renamed from: j */
        public boolean mo26489j() {
            int g = mo26486g();
            boolean z = false;
            if (g <= 1) {
                return false;
            }
            if (g > 7) {
                g = 7;
            }
            int i = g - 1;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    break;
                } else if (((Integer) this.f16449d.get(i2)).intValue() == 0) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            return z;
        }
    }

    public C5041p(String str) {
        String str2 = "";
        try {
            if (TextUtils.isEmpty(str)) {
                C5205o.m21462a("aw cfs em");
                return;
            }
            String b = C5162b.m21305a().mo26772b(str, true);
            StringBuilder sb = new StringBuilder();
            sb.append("aw cfs str = ");
            sb.append(b);
            C5205o.m21462a(sb.toString());
            JSONObject jSONObject = new JSONObject(b);
            this.f16433a = jSONObject.optInt("code", 0);
            this.f16434b = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE, str2);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.f16435c = optJSONObject.optString("descSignin", str2);
                JSONArray optJSONArray = optJSONObject.optJSONArray("pkginfos");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.f16436d = new ArrayList();
                    this.f16437e = new HashMap<>();
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        C5042a aVar = new C5042a(optJSONArray.get(i).toString());
                        this.f16436d.add(aVar);
                        this.f16437e.put(aVar.f16450e, aVar);
                    }
                }
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: a */
    public HashMap<String, C5042a> mo26478a() {
        return this.f16437e;
    }
}
