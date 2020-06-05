package com.bytedance.sdk.p145a.p147b;

import com.tencent.bugly.beta.tinker.TinkerReport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: com.bytedance.sdk.a.b.k */
public final class CipherSuite {
    /* renamed from: A */
    public static final CipherSuite f5795A = m7448a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
    /* renamed from: B */
    public static final CipherSuite f5796B = m7448a("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
    /* renamed from: C */
    public static final CipherSuite f5797C = m7448a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
    /* renamed from: D */
    public static final CipherSuite f5798D = m7448a("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
    /* renamed from: E */
    public static final CipherSuite f5799E = m7448a("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
    /* renamed from: F */
    public static final CipherSuite f5800F = m7448a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
    /* renamed from: G */
    public static final CipherSuite f5801G = m7448a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
    /* renamed from: H */
    public static final CipherSuite f5802H = m7448a("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
    /* renamed from: I */
    public static final CipherSuite f5803I = m7448a("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
    /* renamed from: J */
    public static final CipherSuite f5804J = m7448a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
    /* renamed from: K */
    public static final CipherSuite f5805K = m7448a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
    /* renamed from: L */
    public static final CipherSuite f5806L = m7448a("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
    /* renamed from: M */
    public static final CipherSuite f5807M = m7448a("TLS_RSA_WITH_NULL_SHA256", 59);
    /* renamed from: N */
    public static final CipherSuite f5808N = m7448a("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
    /* renamed from: O */
    public static final CipherSuite f5809O = m7448a("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
    /* renamed from: P */
    public static final CipherSuite f5810P = m7448a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
    /* renamed from: Q */
    public static final CipherSuite f5811Q = m7448a("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
    /* renamed from: R */
    public static final CipherSuite f5812R = m7448a("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
    /* renamed from: S */
    public static final CipherSuite f5813S = m7448a("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
    /* renamed from: T */
    public static final CipherSuite f5814T = m7448a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
    /* renamed from: U */
    public static final CipherSuite f5815U = m7448a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
    /* renamed from: V */
    public static final CipherSuite f5816V = m7448a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
    /* renamed from: W */
    public static final CipherSuite f5817W = m7448a("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
    /* renamed from: X */
    public static final CipherSuite f5818X = m7448a("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
    /* renamed from: Y */
    public static final CipherSuite f5819Y = m7448a("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);
    /* renamed from: Z */
    public static final CipherSuite f5820Z = m7448a("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
    /* renamed from: a */
    static final Comparator<String> f5821a = new Comparator<String>() {
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
    public static final CipherSuite f5822aA = m7448a("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
    /* renamed from: aB */
    public static final CipherSuite f5823aB = m7448a("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
    /* renamed from: aC */
    public static final CipherSuite f5824aC = m7448a("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
    /* renamed from: aD */
    public static final CipherSuite f5825aD = m7448a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
    /* renamed from: aE */
    public static final CipherSuite f5826aE = m7448a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
    /* renamed from: aF */
    public static final CipherSuite f5827aF = m7448a("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
    /* renamed from: aG */
    public static final CipherSuite f5828aG = m7448a("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
    /* renamed from: aH */
    public static final CipherSuite f5829aH = m7448a("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
    /* renamed from: aI */
    public static final CipherSuite f5830aI = m7448a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
    /* renamed from: aJ */
    public static final CipherSuite f5831aJ = m7448a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
    /* renamed from: aK */
    public static final CipherSuite f5832aK = m7448a("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
    /* renamed from: aL */
    public static final CipherSuite f5833aL = m7448a("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
    /* renamed from: aM */
    public static final CipherSuite f5834aM = m7448a("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
    /* renamed from: aN */
    public static final CipherSuite f5835aN = m7448a("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
    /* renamed from: aO */
    public static final CipherSuite f5836aO = m7448a("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
    /* renamed from: aP */
    public static final CipherSuite f5837aP = m7448a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
    /* renamed from: aQ */
    public static final CipherSuite f5838aQ = m7448a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
    /* renamed from: aR */
    public static final CipherSuite f5839aR = m7448a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
    /* renamed from: aS */
    public static final CipherSuite f5840aS = m7448a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
    /* renamed from: aT */
    public static final CipherSuite f5841aT = m7448a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
    /* renamed from: aU */
    public static final CipherSuite f5842aU = m7448a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
    /* renamed from: aV */
    public static final CipherSuite f5843aV = m7448a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
    /* renamed from: aW */
    public static final CipherSuite f5844aW = m7448a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
    /* renamed from: aX */
    public static final CipherSuite f5845aX = m7448a("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
    /* renamed from: aY */
    public static final CipherSuite f5846aY = m7448a("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
    /* renamed from: aZ */
    public static final CipherSuite f5847aZ = m7448a("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
    /* renamed from: aa */
    public static final CipherSuite f5848aa = m7448a("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
    /* renamed from: ab */
    public static final CipherSuite f5849ab = m7448a("TLS_PSK_WITH_RC4_128_SHA", 138);
    /* renamed from: ac */
    public static final CipherSuite f5850ac = m7448a("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
    /* renamed from: ad */
    public static final CipherSuite f5851ad = m7448a("TLS_PSK_WITH_AES_128_CBC_SHA", 140);
    /* renamed from: ae */
    public static final CipherSuite f5852ae = m7448a("TLS_PSK_WITH_AES_256_CBC_SHA", 141);
    /* renamed from: af */
    public static final CipherSuite f5853af = m7448a("TLS_RSA_WITH_SEED_CBC_SHA", TinkerReport.KEY_APPLIED_PACKAGE_CHECK_SIGNATURE);
    /* renamed from: ag */
    public static final CipherSuite f5854ag = m7448a("TLS_RSA_WITH_AES_128_GCM_SHA256", TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL);
    /* renamed from: ah */
    public static final CipherSuite f5855ah = m7448a("TLS_RSA_WITH_AES_256_GCM_SHA384", TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META);
    /* renamed from: ai */
    public static final CipherSuite f5856ai = m7448a("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT);
    /* renamed from: aj */
    public static final CipherSuite f5857aj = m7448a("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);
    /* renamed from: ak */
    public static final CipherSuite f5858ak = m7448a("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
    /* renamed from: al */
    public static final CipherSuite f5859al = m7448a("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
    /* renamed from: am */
    public static final CipherSuite f5860am = m7448a("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);
    /* renamed from: an */
    public static final CipherSuite f5861an = m7448a("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
    /* renamed from: ao */
    public static final CipherSuite f5862ao = m7448a("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
    /* renamed from: ap */
    public static final CipherSuite f5863ap = m7448a("TLS_FALLBACK_SCSV", 22016);
    /* renamed from: aq */
    public static final CipherSuite f5864aq = m7448a("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
    /* renamed from: ar */
    public static final CipherSuite f5865ar = m7448a("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
    /* renamed from: as */
    public static final CipherSuite f5866as = m7448a("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
    /* renamed from: at */
    public static final CipherSuite f5867at = m7448a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
    /* renamed from: au */
    public static final CipherSuite f5868au = m7448a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
    /* renamed from: av */
    public static final CipherSuite f5869av = m7448a("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
    /* renamed from: aw */
    public static final CipherSuite f5870aw = m7448a("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
    /* renamed from: ax */
    public static final CipherSuite f5871ax = m7448a("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
    /* renamed from: ay */
    public static final CipherSuite f5872ay = m7448a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
    /* renamed from: az */
    public static final CipherSuite f5873az = m7448a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
    /* renamed from: b */
    public static final CipherSuite f5874b = m7448a("SSL_RSA_WITH_NULL_MD5", 1);
    /* renamed from: ba */
    public static final CipherSuite f5875ba = m7448a("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
    /* renamed from: bb */
    public static final CipherSuite f5876bb = m7448a("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
    /* renamed from: bc */
    public static final CipherSuite f5877bc = m7448a("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
    /* renamed from: bd */
    public static final CipherSuite f5878bd = m7448a("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
    /* renamed from: be */
    public static final CipherSuite f5879be = m7448a("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
    /* renamed from: bf */
    public static final CipherSuite f5880bf = m7448a("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
    /* renamed from: bg */
    public static final CipherSuite f5881bg = m7448a("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
    /* renamed from: bh */
    public static final CipherSuite f5882bh = m7448a("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
    /* renamed from: bi */
    public static final CipherSuite f5883bi = m7448a("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
    /* renamed from: bk */
    private static final Map<String, CipherSuite> f5884bk = new TreeMap(f5821a);
    /* renamed from: c */
    public static final CipherSuite f5885c = m7448a("SSL_RSA_WITH_NULL_SHA", 2);
    /* renamed from: d */
    public static final CipherSuite f5886d = m7448a("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
    /* renamed from: e */
    public static final CipherSuite f5887e = m7448a("SSL_RSA_WITH_RC4_128_MD5", 4);
    /* renamed from: f */
    public static final CipherSuite f5888f = m7448a("SSL_RSA_WITH_RC4_128_SHA", 5);
    /* renamed from: g */
    public static final CipherSuite f5889g = m7448a("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
    /* renamed from: h */
    public static final CipherSuite f5890h = m7448a("SSL_RSA_WITH_DES_CBC_SHA", 9);
    /* renamed from: i */
    public static final CipherSuite f5891i = m7448a("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
    /* renamed from: j */
    public static final CipherSuite f5892j = m7448a("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
    /* renamed from: k */
    public static final CipherSuite f5893k = m7448a("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
    /* renamed from: l */
    public static final CipherSuite f5894l = m7448a("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
    /* renamed from: m */
    public static final CipherSuite f5895m = m7448a("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
    /* renamed from: n */
    public static final CipherSuite f5896n = m7448a("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
    /* renamed from: o */
    public static final CipherSuite f5897o = m7448a("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
    /* renamed from: p */
    public static final CipherSuite f5898p = m7448a("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
    /* renamed from: q */
    public static final CipherSuite f5899q = m7448a("SSL_DH_anon_WITH_RC4_128_MD5", 24);
    /* renamed from: r */
    public static final CipherSuite f5900r = m7448a("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
    /* renamed from: s */
    public static final CipherSuite f5901s = m7448a("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
    /* renamed from: t */
    public static final CipherSuite f5902t = m7448a("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
    /* renamed from: u */
    public static final CipherSuite f5903u = m7448a("TLS_KRB5_WITH_DES_CBC_SHA", 30);
    /* renamed from: v */
    public static final CipherSuite f5904v = m7448a("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
    /* renamed from: w */
    public static final CipherSuite f5905w = m7448a("TLS_KRB5_WITH_RC4_128_SHA", 32);
    /* renamed from: x */
    public static final CipherSuite f5906x = m7448a("TLS_KRB5_WITH_DES_CBC_MD5", 34);
    /* renamed from: y */
    public static final CipherSuite f5907y = m7448a("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
    /* renamed from: z */
    public static final CipherSuite f5908z = m7448a("TLS_KRB5_WITH_RC4_128_MD5", 36);
    /* renamed from: bj */
    final String f5909bj;

    /* renamed from: a */
    public static synchronized CipherSuite m7447a(String str) {
        CipherSuite kVar;
        synchronized (CipherSuite.class) {
            kVar = (CipherSuite) f5884bk.get(str);
            if (kVar == null) {
                kVar = new CipherSuite(str);
                f5884bk.put(str, kVar);
            }
        }
        return kVar;
    }

    /* renamed from: a */
    static List<CipherSuite> m7449a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String a : strArr) {
            arrayList.add(m7447a(a));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private CipherSuite(String str) {
        if (str != null) {
            this.f5909bj = str;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    private static CipherSuite m7448a(String str, int i) {
        return m7447a(str);
    }

    public String toString() {
        return this.f5909bj;
    }
}
