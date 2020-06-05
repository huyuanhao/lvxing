package com.tencent.bugly.crashreport.common.info;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Process;
import androidx.core.p003os.EnvironmentCompat;
import com.tencent.bugly.C7121b;
import com.tencent.bugly.crashreport.C7162a;
import com.tencent.bugly.proguard.C7226an;
import com.tencent.bugly.proguard.C7232aq;
import com.tencent.mid.sotrage.StorageInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.common.info.a */
public class C7174a {
    /* renamed from: an */
    private static C7174a f23962an;
    /* renamed from: A */
    public boolean f23963A;
    /* renamed from: B */
    public String f23964B;
    /* renamed from: C */
    public String f23965C;
    /* renamed from: D */
    public String f23966D;
    /* renamed from: E */
    public boolean f23967E;
    /* renamed from: F */
    public boolean f23968F;
    /* renamed from: G */
    public Boolean f23969G;
    /* renamed from: H */
    public Boolean f23970H;
    /* renamed from: I */
    public HashMap<String, String> f23971I;
    /* renamed from: J */
    public boolean f23972J;
    /* renamed from: K */
    public List<String> f23973K;
    /* renamed from: L */
    public boolean f23974L;
    /* renamed from: M */
    public C7162a f23975M;
    /* renamed from: N */
    public SharedPreferences f23976N;
    /* renamed from: O */
    private final Context f23977O;
    /* renamed from: P */
    private String f23978P;
    /* renamed from: Q */
    private String f23979Q;
    /* renamed from: R */
    private String f23980R;
    /* renamed from: S */
    private String f23981S;
    /* renamed from: T */
    private String f23982T;
    /* renamed from: U */
    private String f23983U;
    /* renamed from: V */
    private String f23984V;
    /* renamed from: W */
    private String f23985W;
    /* renamed from: X */
    private String f23986X;
    /* renamed from: Y */
    private long f23987Y;
    /* renamed from: Z */
    private long f23988Z;
    /* renamed from: a */
    public final long f23989a;
    /* renamed from: aA */
    private final Object f23990aA;
    /* renamed from: aB */
    private final Object f23991aB;
    /* renamed from: aC */
    private final Object f23992aC;
    /* renamed from: aD */
    private final Object f23993aD;
    /* renamed from: aE */
    private final Object f23994aE;
    /* renamed from: aF */
    private final Object f23995aF;
    /* renamed from: aa */
    private long f23996aa;
    /* renamed from: ab */
    private String f23997ab;
    /* renamed from: ac */
    private String f23998ac;
    /* renamed from: ad */
    private Map<String, PlugInBean> f23999ad;
    /* renamed from: ae */
    private boolean f24000ae;
    /* renamed from: af */
    private String f24001af;
    /* renamed from: ag */
    private String f24002ag;
    /* renamed from: ah */
    private Boolean f24003ah;
    /* renamed from: ai */
    private String f24004ai;
    /* renamed from: aj */
    private String f24005aj;
    /* renamed from: ak */
    private String f24006ak;
    /* renamed from: al */
    private Map<String, PlugInBean> f24007al;
    /* renamed from: am */
    private Map<String, PlugInBean> f24008am;
    /* renamed from: ao */
    private int f24009ao;
    /* renamed from: ap */
    private int f24010ap;
    /* renamed from: aq */
    private Map<String, String> f24011aq;
    /* renamed from: ar */
    private Map<String, String> f24012ar;
    /* renamed from: as */
    private Map<String, String> f24013as;
    /* renamed from: at */
    private boolean f24014at;
    /* renamed from: au */
    private String f24015au;
    /* renamed from: av */
    private String f24016av;
    /* renamed from: aw */
    private String f24017aw;
    /* renamed from: ax */
    private String f24018ax;
    /* renamed from: ay */
    private String f24019ay;
    /* renamed from: az */
    private final Object f24020az;
    /* renamed from: b */
    public final String f24021b;
    /* renamed from: c */
    public final byte f24022c;
    /* renamed from: d */
    public String f24023d;
    /* renamed from: e */
    public final String f24024e;
    /* renamed from: f */
    public String f24025f;
    /* renamed from: g */
    public String f24026g;
    /* renamed from: h */
    public boolean f24027h = true;
    /* renamed from: i */
    public final String f24028i = "com.tencent.bugly";
    /* renamed from: j */
    public final String f24029j = "3.1.0";
    /* renamed from: k */
    public final String f24030k;
    /* renamed from: l */
    public final String f24031l;
    /* renamed from: m */
    public final String f24032m;
    /* renamed from: n */
    public final String f24033n;
    /* renamed from: o */
    public long f24034o;
    /* renamed from: p */
    public String f24035p;
    /* renamed from: q */
    public String f24036q;
    /* renamed from: r */
    public String f24037r;
    /* renamed from: s */
    public String f24038s;
    /* renamed from: t */
    public String f24039t;
    /* renamed from: u */
    public List<String> f24040u;
    /* renamed from: v */
    public String f24041v;
    /* renamed from: w */
    public long f24042w;
    /* renamed from: x */
    public long f24043x;
    /* renamed from: y */
    public long f24044y;
    /* renamed from: z */
    public long f24045z;

    /* renamed from: c */
    public String mo34584c() {
        return "3.1.0";
    }

    private C7174a(Context context) {
        String str = "";
        this.f24030k = str;
        String str2 = EnvironmentCompat.MEDIA_UNKNOWN;
        this.f23980R = str2;
        this.f23981S = str2;
        this.f23982T = str;
        this.f24034o = 0;
        this.f23983U = null;
        this.f23984V = null;
        this.f23985W = null;
        this.f23986X = null;
        this.f23987Y = -1;
        this.f23988Z = -1;
        this.f23996aa = -1;
        this.f23997ab = null;
        this.f23998ac = null;
        this.f23999ad = null;
        this.f24000ae = true;
        this.f24001af = null;
        this.f24035p = null;
        this.f24036q = null;
        this.f24002ag = null;
        this.f24037r = null;
        this.f24003ah = null;
        this.f24004ai = null;
        this.f24005aj = null;
        this.f24006ak = null;
        this.f24038s = null;
        this.f24039t = null;
        this.f24007al = null;
        this.f24008am = null;
        this.f24040u = null;
        this.f24009ao = -1;
        this.f24010ap = -1;
        this.f24011aq = new HashMap();
        this.f24012ar = new HashMap();
        this.f24013as = new HashMap();
        this.f24014at = true;
        this.f24041v = str2;
        this.f24042w = 0;
        this.f24043x = 0;
        this.f24044y = 0;
        this.f24045z = 0;
        this.f23963A = false;
        this.f23964B = null;
        this.f23965C = null;
        this.f23966D = null;
        this.f23967E = false;
        this.f23968F = false;
        this.f23969G = null;
        this.f23970H = null;
        this.f23971I = new HashMap<>();
        this.f24015au = null;
        this.f24016av = null;
        this.f24017aw = null;
        this.f24018ax = null;
        this.f24019ay = null;
        this.f23972J = true;
        this.f23973K = new ArrayList();
        this.f23974L = false;
        this.f23975M = null;
        this.f24020az = new Object();
        this.f23990aA = new Object();
        this.f23991aB = new Object();
        this.f23992aC = new Object();
        this.f23993aD = new Object();
        this.f23994aE = new Object();
        this.f23995aF = new Object();
        this.f23989a = System.currentTimeMillis();
        this.f23977O = C7232aq.m31172a(context);
        this.f24022c = 1;
        m30755b(context);
        this.f24023d = AppInfo.m30738a(context);
        this.f24024e = AppInfo.m30739a(context, Process.myPid());
        this.f24031l = C7175b.m30842m();
        this.f24032m = C7175b.m30816a();
        this.f24036q = AppInfo.m30744c(context);
        StringBuilder sb = new StringBuilder();
        sb.append("Android ");
        sb.append(C7175b.m30819b());
        sb.append(",level ");
        sb.append(C7175b.m30821c());
        this.f24033n = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f24032m);
        sb2.append(";");
        sb2.append(this.f24033n);
        this.f24021b = sb2.toString();
        m30756c(context);
        try {
            if (!context.getDatabasePath("bugly_db_").exists()) {
                this.f23968F = true;
                C7226an.m31147c("App is first time to be installed on the device.", new Object[0]);
            }
        } catch (Throwable th) {
            if (C7121b.f23665c) {
                th.printStackTrace();
            }
        }
        this.f23976N = C7232aq.m31173a("BUGLY_COMMON_VALUES", context);
        C7226an.m31147c("com info create end", new Object[0]);
    }

    /* renamed from: b */
    private void m30755b(Context context) {
        PackageInfo b = AppInfo.m30743b(context);
        if (b != null) {
            try {
                this.f24035p = b.versionName;
                this.f23964B = this.f24035p;
                this.f23965C = Integer.toString(b.versionCode);
            } catch (Throwable th) {
                if (!C7226an.m31142a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* renamed from: c */
    private void m30756c(Context context) {
        Map d = AppInfo.m30745d(context);
        if (d != null) {
            try {
                this.f24040u = AppInfo.m30741a(d);
                String str = (String) d.get("BUGLY_APPID");
                if (str != null) {
                    this.f24002ag = str;
                    mo34586c("APP_ID", this.f24002ag);
                }
                String str2 = (String) d.get("BUGLY_APP_VERSION");
                if (str2 != null) {
                    this.f24035p = str2;
                }
                String str3 = (String) d.get("BUGLY_APP_CHANNEL");
                if (str3 != null) {
                    this.f24037r = str3;
                }
                String str4 = (String) d.get("BUGLY_ENABLE_DEBUG");
                if (str4 != null) {
                    this.f23963A = str4.equalsIgnoreCase("true");
                }
                String str5 = (String) d.get("com.tencent.rdm.uuid");
                if (str5 != null) {
                    this.f23966D = str5;
                }
            } catch (Throwable th) {
                if (!C7226an.m31142a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    public boolean mo34579a() {
        return this.f24014at;
    }

    /* renamed from: a */
    public void mo34578a(boolean z) {
        this.f24014at = z;
        C7162a aVar = this.f23975M;
        if (aVar != null) {
            aVar.setNativeIsAppForeground(z);
        }
    }

    /* renamed from: a */
    public static synchronized C7174a m30753a(Context context) {
        C7174a aVar;
        synchronized (C7174a.class) {
            if (f23962an == null) {
                f23962an = new C7174a(context);
            }
            aVar = f23962an;
        }
        return aVar;
    }

    /* renamed from: b */
    public static synchronized C7174a m30754b() {
        C7174a aVar;
        synchronized (C7174a.class) {
            aVar = f23962an;
        }
        return aVar;
    }

    /* renamed from: d */
    public void mo34587d() {
        synchronized (this.f24020az) {
            this.f23978P = UUID.randomUUID().toString();
        }
    }

    /* renamed from: e */
    public String mo34589e() {
        String str;
        synchronized (this.f24020az) {
            if (this.f23978P == null) {
                mo34587d();
            }
            str = this.f23978P;
        }
        return str;
    }

    /* renamed from: f */
    public String mo34591f() {
        if (!C7232aq.m31196a(this.f24025f)) {
            return this.f24025f;
        }
        return this.f24002ag;
    }

    /* renamed from: a */
    public void mo34576a(String str) {
        this.f24002ag = str;
        mo34586c("APP_ID", str);
    }

    /* renamed from: g */
    public String mo34593g() {
        String str;
        synchronized (this.f23994aE) {
            str = this.f23980R;
        }
        return str;
    }

    /* renamed from: b */
    public void mo34581b(String str) {
        synchronized (this.f23994aE) {
            if (str == null) {
                str = "10000";
            }
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(str);
            this.f23980R = sb.toString();
        }
    }

    /* renamed from: b */
    public void mo34583b(boolean z) {
        this.f24000ae = z;
    }

    /* renamed from: h */
    public String mo34595h() {
        String str = this.f23979Q;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(mo34598k());
        String str2 = "|";
        sb.append(str2);
        sb.append(mo34600m());
        sb.append(str2);
        sb.append(mo34601n());
        this.f23979Q = sb.toString();
        return this.f23979Q;
    }

    /* renamed from: c */
    public void mo34585c(String str) {
        this.f23979Q = str;
        synchronized (this.f23995aF) {
            this.f24012ar.put("E8", str);
        }
    }

    /* renamed from: i */
    public synchronized String mo34596i() {
        return this.f23981S;
    }

    /* renamed from: d */
    public synchronized void mo34588d(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(str);
        this.f23981S = sb.toString();
    }

    /* renamed from: j */
    public synchronized String mo34597j() {
        return this.f23982T;
    }

    /* renamed from: e */
    public synchronized void mo34590e(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(str);
        this.f23982T = sb.toString();
    }

    /* renamed from: k */
    public String mo34598k() {
        if (!this.f24000ae) {
            return "";
        }
        if (this.f23983U == null) {
            this.f23983U = C7175b.m30817a(this.f23977O);
        }
        return this.f23983U;
    }

    /* renamed from: l */
    public String mo34599l() {
        if (!this.f24000ae) {
            return "";
        }
        String str = this.f23984V;
        if (str == null || !str.contains(":")) {
            this.f23984V = C7175b.m30824d(this.f23977O);
        }
        return this.f23984V;
    }

    /* renamed from: m */
    public String mo34600m() {
        if (!this.f24000ae) {
            return "";
        }
        if (this.f23985W == null) {
            this.f23985W = C7175b.m30820b(this.f23977O);
        }
        return this.f23985W;
    }

    /* renamed from: n */
    public String mo34601n() {
        if (!this.f24000ae) {
            return "";
        }
        if (this.f23986X == null) {
            this.f23986X = C7175b.m30822c(this.f23977O);
        }
        return this.f23986X;
    }

    /* renamed from: o */
    public long mo34602o() {
        if (this.f23987Y <= 0) {
            this.f23987Y = C7175b.m30827f();
        }
        return this.f23987Y;
    }

    /* renamed from: p */
    public long mo34603p() {
        if (this.f23988Z <= 0) {
            this.f23988Z = C7175b.m30831h();
        }
        return this.f23988Z;
    }

    /* renamed from: q */
    public long mo34604q() {
        if (this.f23996aa <= 0) {
            this.f23996aa = C7175b.m30835j();
        }
        return this.f23996aa;
    }

    /* renamed from: r */
    public String mo34605r() {
        if (this.f23997ab == null) {
            this.f23997ab = C7175b.m30818a(this.f23977O, true);
        }
        return this.f23997ab;
    }

    /* renamed from: s */
    public String mo34606s() {
        if (this.f23998ac == null) {
            this.f23998ac = C7175b.m30832h(this.f23977O);
        }
        return this.f23998ac;
    }

    /* renamed from: a */
    public void mo34577a(String str, String str2) {
        if (str != null && str2 != null) {
            synchronized (this.f23990aA) {
                this.f23971I.put(str, str2);
            }
        }
    }

    /* renamed from: t */
    public String mo34607t() {
        try {
            Map all = this.f23977O.getSharedPreferences("BuglySdkInfos", 0).getAll();
            if (!all.isEmpty()) {
                synchronized (this.f23990aA) {
                    for (Entry entry : all.entrySet()) {
                        try {
                            this.f23971I.put(entry.getKey(), entry.getValue().toString());
                        } catch (Throwable th) {
                            C7226an.m31142a(th);
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            C7226an.m31142a(th2);
        }
        if (this.f23971I.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Entry entry2 : this.f23971I.entrySet()) {
            sb.append("[");
            sb.append((String) entry2.getKey());
            sb.append(StorageInterface.KEY_SPLITER);
            sb.append((String) entry2.getValue());
            sb.append("] ");
        }
        mo34586c("SDK_INFO", sb.toString());
        return sb.toString();
    }

    /* renamed from: u */
    public String mo34608u() {
        if (this.f24019ay == null) {
            this.f24019ay = AppInfo.m30746e(this.f23977O);
        }
        return this.f24019ay;
    }

    /* renamed from: v */
    public synchronized Map<String, PlugInBean> mo34609v() {
        if (this.f23999ad != null) {
            if (this.f23999ad.size() > 0) {
                HashMap hashMap = new HashMap(this.f23999ad.size());
                hashMap.putAll(this.f23999ad);
                return hashMap;
            }
        }
        return null;
    }

    /* renamed from: w */
    public String mo34610w() {
        if (this.f24001af == null) {
            this.f24001af = C7175b.m30839l();
        }
        return this.f24001af;
    }

    /* renamed from: x */
    public Boolean mo34611x() {
        if (this.f24003ah == null) {
            this.f24003ah = Boolean.valueOf(C7175b.m30843n());
        }
        return this.f24003ah;
    }

    /* renamed from: y */
    public String mo34612y() {
        if (this.f24004ai == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(C7175b.m30830g(this.f23977O));
            this.f24004ai = sb.toString();
            C7226an.m31141a("ROM ID: %s", this.f24004ai);
        }
        return this.f24004ai;
    }

    /* renamed from: z */
    public String mo34613z() {
        if (this.f24005aj == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(C7175b.m30825e(this.f23977O));
            this.f24005aj = sb.toString();
            C7226an.m31141a("SIM serial number: %s", this.f24005aj);
        }
        return this.f24005aj;
    }

    /* renamed from: A */
    public String mo34555A() {
        if (this.f24006ak == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(C7175b.m30823d());
            this.f24006ak = sb.toString();
            C7226an.m31141a("Hardware serial number: %s", this.f24006ak);
        }
        return this.f24006ak;
    }

    /* renamed from: B */
    public Map<String, String> mo34556B() {
        synchronized (this.f23991aB) {
            if (this.f24011aq.size() <= 0) {
                return null;
            }
            HashMap hashMap = new HashMap(this.f24011aq);
            return hashMap;
        }
    }

    /* renamed from: f */
    public String mo34592f(String str) {
        String str2;
        if (C7232aq.m31196a(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(str);
            C7226an.m31148d("key should not be empty %s", sb.toString());
            return null;
        }
        synchronized (this.f23991aB) {
            str2 = (String) this.f24011aq.remove(str);
        }
        return str2;
    }

    /* renamed from: C */
    public void mo34557C() {
        synchronized (this.f23991aB) {
            this.f24011aq.clear();
        }
    }

    /* renamed from: g */
    public String mo34594g(String str) {
        String str2;
        if (C7232aq.m31196a(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(str);
            C7226an.m31148d("key should not be empty %s", sb.toString());
            return null;
        }
        synchronized (this.f23991aB) {
            str2 = (String) this.f24011aq.get(str);
        }
        return str2;
    }

    /* renamed from: b */
    public void mo34582b(String str, String str2) {
        if (C7232aq.m31196a(str) || C7232aq.m31196a(str2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(str);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            sb2.append(str2);
            C7226an.m31148d("key&value should not be empty %s %s", sb.toString(), sb2.toString());
            return;
        }
        synchronized (this.f23991aB) {
            this.f24011aq.put(str, str2);
        }
    }

    /* renamed from: D */
    public int mo34558D() {
        int size;
        synchronized (this.f23991aB) {
            size = this.f24011aq.size();
        }
        return size;
    }

    /* renamed from: E */
    public Set<String> mo34559E() {
        Set<String> keySet;
        synchronized (this.f23991aB) {
            keySet = this.f24011aq.keySet();
        }
        return keySet;
    }

    /* renamed from: F */
    public Map<String, String> mo34560F() {
        synchronized (this.f23995aF) {
            if (this.f24012ar.size() <= 0) {
                return null;
            }
            HashMap hashMap = new HashMap(this.f24012ar);
            return hashMap;
        }
    }

    /* renamed from: c */
    public void mo34586c(String str, String str2) {
        if (C7232aq.m31196a(str) || C7232aq.m31196a(str2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(str);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            sb2.append(str2);
            C7226an.m31148d("server key&value should not be empty %s %s", sb.toString(), sb2.toString());
            return;
        }
        synchronized (this.f23992aC) {
            this.f24013as.put(str, str2);
        }
    }

    /* renamed from: G */
    public Map<String, String> mo34561G() {
        synchronized (this.f23992aC) {
            if (this.f24013as.size() <= 0) {
                return null;
            }
            HashMap hashMap = new HashMap(this.f24013as);
            return hashMap;
        }
    }

    /* renamed from: a */
    public void mo34575a(int i) {
        synchronized (this.f23993aD) {
            int i2 = this.f24009ao;
            if (i2 != i) {
                this.f24009ao = i;
                C7226an.m31141a("user scene tag %d changed to tag %d", Integer.valueOf(i2), Integer.valueOf(this.f24009ao));
            }
        }
    }

    /* renamed from: H */
    public int mo34562H() {
        int i;
        synchronized (this.f23993aD) {
            i = this.f24009ao;
        }
        return i;
    }

    /* renamed from: b */
    public void mo34580b(int i) {
        int i2 = this.f24010ap;
        if (i2 != i) {
            this.f24010ap = i;
            C7226an.m31141a("server scene tag %d changed to tag %d", Integer.valueOf(i2), Integer.valueOf(this.f24010ap));
        }
    }

    /* renamed from: I */
    public int mo34563I() {
        return this.f24010ap;
    }

    /* renamed from: J */
    public synchronized Map<String, PlugInBean> mo34564J() {
        Map<String, PlugInBean> map;
        map = this.f24007al;
        if (this.f24008am != null) {
            map.putAll(this.f24008am);
        }
        return map;
    }

    /* renamed from: K */
    public int mo34565K() {
        return C7175b.m30821c();
    }

    /* renamed from: L */
    public String mo34566L() {
        if (this.f24015au == null) {
            this.f24015au = C7175b.m30845o();
        }
        return this.f24015au;
    }

    /* renamed from: M */
    public String mo34567M() {
        if (this.f24016av == null) {
            this.f24016av = C7175b.m30834i(this.f23977O);
        }
        return this.f24016av;
    }

    /* renamed from: N */
    public String mo34568N() {
        if (this.f24017aw == null) {
            this.f24017aw = C7175b.m30836j(this.f23977O);
        }
        return this.f24017aw;
    }

    /* renamed from: O */
    public String mo34569O() {
        return C7175b.m30838k(this.f23977O);
    }

    /* renamed from: P */
    public String mo34570P() {
        if (this.f24018ax == null) {
            this.f24018ax = C7175b.m30840l(this.f23977O);
        }
        return this.f24018ax;
    }

    /* renamed from: Q */
    public long mo34571Q() {
        return C7175b.m30841m(this.f23977O);
    }

    /* renamed from: R */
    public boolean mo34572R() {
        if (this.f23969G == null) {
            this.f23969G = Boolean.valueOf(C7175b.m30844n(this.f23977O));
            StringBuilder sb = new StringBuilder();
            sb.append("Is it a virtual machine? ");
            sb.append(this.f23969G);
            C7226an.m31141a(sb.toString(), new Object[0]);
        }
        return this.f23969G.booleanValue();
    }

    /* renamed from: S */
    public boolean mo34573S() {
        if (this.f23970H == null) {
            this.f23970H = Boolean.valueOf(C7175b.m30848p(this.f23977O));
            StringBuilder sb = new StringBuilder();
            sb.append("Does it has hook frame? ");
            sb.append(this.f23970H);
            C7226an.m31141a(sb.toString(), new Object[0]);
        }
        return this.f23970H.booleanValue();
    }

    /* renamed from: T */
    public String mo34574T() {
        if (this.f24026g == null) {
            this.f24026g = AppInfo.m30748g(this.f23977O);
            StringBuilder sb = new StringBuilder();
            sb.append("Beacon channel ");
            sb.append(this.f24026g);
            C7226an.m31141a(sb.toString(), new Object[0]);
        }
        return this.f24026g;
    }
}
