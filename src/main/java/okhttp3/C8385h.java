package okhttp3;

import com.tencent.bugly.beta.tinker.TinkerReport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: CipherSuite */
/* renamed from: okhttp3.h */
public final class C8385h {
    /* renamed from: A */
    public static final C8385h f28316A = m35894a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
    /* renamed from: B */
    public static final C8385h f28317B = m35894a("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
    /* renamed from: C */
    public static final C8385h f28318C = m35894a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
    /* renamed from: D */
    public static final C8385h f28319D = m35894a("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
    /* renamed from: E */
    public static final C8385h f28320E = m35894a("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
    /* renamed from: F */
    public static final C8385h f28321F = m35894a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
    /* renamed from: G */
    public static final C8385h f28322G = m35894a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
    /* renamed from: H */
    public static final C8385h f28323H = m35894a("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
    /* renamed from: I */
    public static final C8385h f28324I = m35894a("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
    /* renamed from: J */
    public static final C8385h f28325J = m35894a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
    /* renamed from: K */
    public static final C8385h f28326K = m35894a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
    /* renamed from: L */
    public static final C8385h f28327L = m35894a("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
    /* renamed from: M */
    public static final C8385h f28328M = m35894a("TLS_RSA_WITH_NULL_SHA256", 59);
    /* renamed from: N */
    public static final C8385h f28329N = m35894a("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
    /* renamed from: O */
    public static final C8385h f28330O = m35894a("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
    /* renamed from: P */
    public static final C8385h f28331P = m35894a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
    /* renamed from: Q */
    public static final C8385h f28332Q = m35894a("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
    /* renamed from: R */
    public static final C8385h f28333R = m35894a("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
    /* renamed from: S */
    public static final C8385h f28334S = m35894a("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
    /* renamed from: T */
    public static final C8385h f28335T = m35894a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
    /* renamed from: U */
    public static final C8385h f28336U = m35894a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
    /* renamed from: V */
    public static final C8385h f28337V = m35894a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
    /* renamed from: W */
    public static final C8385h f28338W = m35894a("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
    /* renamed from: X */
    public static final C8385h f28339X = m35894a("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
    /* renamed from: Y */
    public static final C8385h f28340Y = m35894a("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);
    /* renamed from: Z */
    public static final C8385h f28341Z = m35894a("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
    /* renamed from: a */
    static final Comparator<String> f28342a = new Comparator<String>() {
        /* renamed from: a */
        public int compare(String str, String str2) {
            int min = Math.min(str.length(), str2.length());
            int i = 4;
            while (true) {
                int i2 = -1;
                if (i < min) {
                    char charAt = str.charAt(i);
                    char charAt2 = str2.charAt(i);
                    if (charAt != charAt2) {
                        if (charAt >= charAt2) {
                            i2 = 1;
                        }
                        return i2;
                    }
                    i++;
                } else {
                    int length = str.length();
                    int length2 = str2.length();
                    if (length == length2) {
                        return 0;
                    }
                    if (length >= length2) {
                        i2 = 1;
                    }
                    return i2;
                }
            }
        }
    };
    /* renamed from: aA */
    public static final C8385h f28343aA = m35894a("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
    /* renamed from: aB */
    public static final C8385h f28344aB = m35894a("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
    /* renamed from: aC */
    public static final C8385h f28345aC = m35894a("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
    /* renamed from: aD */
    public static final C8385h f28346aD = m35894a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
    /* renamed from: aE */
    public static final C8385h f28347aE = m35894a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
    /* renamed from: aF */
    public static final C8385h f28348aF = m35894a("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
    /* renamed from: aG */
    public static final C8385h f28349aG = m35894a("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
    /* renamed from: aH */
    public static final C8385h f28350aH = m35894a("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
    /* renamed from: aI */
    public static final C8385h f28351aI = m35894a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
    /* renamed from: aJ */
    public static final C8385h f28352aJ = m35894a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
    /* renamed from: aK */
    public static final C8385h f28353aK = m35894a("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
    /* renamed from: aL */
    public static final C8385h f28354aL = m35894a("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
    /* renamed from: aM */
    public static final C8385h f28355aM = m35894a("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
    /* renamed from: aN */
    public static final C8385h f28356aN = m35894a("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
    /* renamed from: aO */
    public static final C8385h f28357aO = m35894a("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
    /* renamed from: aP */
    public static final C8385h f28358aP = m35894a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
    /* renamed from: aQ */
    public static final C8385h f28359aQ = m35894a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
    /* renamed from: aR */
    public static final C8385h f28360aR = m35894a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
    /* renamed from: aS */
    public static final C8385h f28361aS = m35894a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
    /* renamed from: aT */
    public static final C8385h f28362aT = m35894a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
    /* renamed from: aU */
    public static final C8385h f28363aU = m35894a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
    /* renamed from: aV */
    public static final C8385h f28364aV = m35894a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
    /* renamed from: aW */
    public static final C8385h f28365aW = m35894a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
    /* renamed from: aX */
    public static final C8385h f28366aX = m35894a("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
    /* renamed from: aY */
    public static final C8385h f28367aY = m35894a("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
    /* renamed from: aZ */
    public static final C8385h f28368aZ = m35894a("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
    /* renamed from: aa */
    public static final C8385h f28369aa = m35894a("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
    /* renamed from: ab */
    public static final C8385h f28370ab = m35894a("TLS_PSK_WITH_RC4_128_SHA", 138);
    /* renamed from: ac */
    public static final C8385h f28371ac = m35894a("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
    /* renamed from: ad */
    public static final C8385h f28372ad = m35894a("TLS_PSK_WITH_AES_128_CBC_SHA", 140);
    /* renamed from: ae */
    public static final C8385h f28373ae = m35894a("TLS_PSK_WITH_AES_256_CBC_SHA", 141);
    /* renamed from: af */
    public static final C8385h f28374af = m35894a("TLS_RSA_WITH_SEED_CBC_SHA", TinkerReport.KEY_APPLIED_PACKAGE_CHECK_SIGNATURE);
    /* renamed from: ag */
    public static final C8385h f28375ag = m35894a("TLS_RSA_WITH_AES_128_GCM_SHA256", TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL);
    /* renamed from: ah */
    public static final C8385h f28376ah = m35894a("TLS_RSA_WITH_AES_256_GCM_SHA384", TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META);
    /* renamed from: ai */
    public static final C8385h f28377ai = m35894a("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT);
    /* renamed from: aj */
    public static final C8385h f28378aj = m35894a("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);
    /* renamed from: ak */
    public static final C8385h f28379ak = m35894a("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
    /* renamed from: al */
    public static final C8385h f28380al = m35894a("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
    /* renamed from: am */
    public static final C8385h f28381am = m35894a("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);
    /* renamed from: an */
    public static final C8385h f28382an = m35894a("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
    /* renamed from: ao */
    public static final C8385h f28383ao = m35894a("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
    /* renamed from: ap */
    public static final C8385h f28384ap = m35894a("TLS_FALLBACK_SCSV", 22016);
    /* renamed from: aq */
    public static final C8385h f28385aq = m35894a("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
    /* renamed from: ar */
    public static final C8385h f28386ar = m35894a("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
    /* renamed from: as */
    public static final C8385h f28387as = m35894a("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
    /* renamed from: at */
    public static final C8385h f28388at = m35894a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
    /* renamed from: au */
    public static final C8385h f28389au = m35894a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
    /* renamed from: av */
    public static final C8385h f28390av = m35894a("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
    /* renamed from: aw */
    public static final C8385h f28391aw = m35894a("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
    /* renamed from: ax */
    public static final C8385h f28392ax = m35894a("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
    /* renamed from: ay */
    public static final C8385h f28393ay = m35894a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
    /* renamed from: az */
    public static final C8385h f28394az = m35894a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
    /* renamed from: b */
    public static final C8385h f28395b = m35894a("SSL_RSA_WITH_NULL_MD5", 1);
    /* renamed from: ba */
    public static final C8385h f28396ba = m35894a("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
    /* renamed from: bb */
    public static final C8385h f28397bb = m35894a("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
    /* renamed from: bc */
    public static final C8385h f28398bc = m35894a("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
    /* renamed from: bd */
    public static final C8385h f28399bd = m35894a("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
    /* renamed from: be */
    public static final C8385h f28400be = m35894a("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
    /* renamed from: bf */
    public static final C8385h f28401bf = m35894a("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
    /* renamed from: bg */
    public static final C8385h f28402bg = m35894a("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
    /* renamed from: bh */
    public static final C8385h f28403bh = m35894a("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
    /* renamed from: bi */
    public static final C8385h f28404bi = m35894a("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
    /* renamed from: bj */
    public static final C8385h f28405bj = m35894a("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);
    /* renamed from: bl */
    private static final Map<String, C8385h> f28406bl = new TreeMap(f28342a);
    /* renamed from: c */
    public static final C8385h f28407c = m35894a("SSL_RSA_WITH_NULL_SHA", 2);
    /* renamed from: d */
    public static final C8385h f28408d = m35894a("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
    /* renamed from: e */
    public static final C8385h f28409e = m35894a("SSL_RSA_WITH_RC4_128_MD5", 4);
    /* renamed from: f */
    public static final C8385h f28410f = m35894a("SSL_RSA_WITH_RC4_128_SHA", 5);
    /* renamed from: g */
    public static final C8385h f28411g = m35894a("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
    /* renamed from: h */
    public static final C8385h f28412h = m35894a("SSL_RSA_WITH_DES_CBC_SHA", 9);
    /* renamed from: i */
    public static final C8385h f28413i = m35894a("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
    /* renamed from: j */
    public static final C8385h f28414j = m35894a("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
    /* renamed from: k */
    public static final C8385h f28415k = m35894a("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
    /* renamed from: l */
    public static final C8385h f28416l = m35894a("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
    /* renamed from: m */
    public static final C8385h f28417m = m35894a("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
    /* renamed from: n */
    public static final C8385h f28418n = m35894a("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
    /* renamed from: o */
    public static final C8385h f28419o = m35894a("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
    /* renamed from: p */
    public static final C8385h f28420p = m35894a("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
    /* renamed from: q */
    public static final C8385h f28421q = m35894a("SSL_DH_anon_WITH_RC4_128_MD5", 24);
    /* renamed from: r */
    public static final C8385h f28422r = m35894a("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
    /* renamed from: s */
    public static final C8385h f28423s = m35894a("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
    /* renamed from: t */
    public static final C8385h f28424t = m35894a("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
    /* renamed from: u */
    public static final C8385h f28425u = m35894a("TLS_KRB5_WITH_DES_CBC_SHA", 30);
    /* renamed from: v */
    public static final C8385h f28426v = m35894a("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
    /* renamed from: w */
    public static final C8385h f28427w = m35894a("TLS_KRB5_WITH_RC4_128_SHA", 32);
    /* renamed from: x */
    public static final C8385h f28428x = m35894a("TLS_KRB5_WITH_DES_CBC_MD5", 34);
    /* renamed from: y */
    public static final C8385h f28429y = m35894a("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
    /* renamed from: z */
    public static final C8385h f28430z = m35894a("TLS_KRB5_WITH_RC4_128_MD5", 36);
    /* renamed from: bk */
    final String f28431bk;

    /* renamed from: a */
    public static synchronized C8385h m35893a(String str) {
        C8385h hVar;
        synchronized (C8385h.class) {
            hVar = (C8385h) f28406bl.get(str);
            if (hVar == null) {
                hVar = new C8385h(str);
                f28406bl.put(str, hVar);
            }
        }
        return hVar;
    }

    /* renamed from: a */
    static List<C8385h> m35892a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String a : strArr) {
            arrayList.add(m35893a(a));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private C8385h(String str) {
        if (str != null) {
            this.f28431bk = str;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    private static C8385h m35894a(String str, int i) {
        return m35893a(str);
    }

    /* renamed from: a */
    public String mo40188a() {
        return this.f28431bk;
    }

    public String toString() {
        return this.f28431bk;
    }
}
