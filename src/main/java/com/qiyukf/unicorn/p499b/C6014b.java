package com.qiyukf.unicorn.p499b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.qiyukf.basesdk.p412c.C5366b;
import com.qiyukf.basesdk.p412c.C5407d;
import com.qiyukf.basesdk.p412c.p416c.C5401a;
import com.qiyukf.unicorn.p503f.p504a.p509c.C6115b;
import com.qiyukf.unicorn.p516j.C6210b;
import com.tencent.mid.sotrage.StorageInterface;
import java.security.SecureRandom;
import java.util.UUID;
import org.json.JSONObject;

/* renamed from: com.qiyukf.unicorn.b.b */
public final class C6014b {
    /* renamed from: a */
    private static Context f18820a;
    /* renamed from: b */
    private static String f18821b;

    /* renamed from: a */
    public static String m23921a() {
        return m23982s("YSF_ID_YX");
    }

    /* renamed from: a */
    public static void m23922a(int i) {
        m23950d("YSF_KEYBOARD_HEIGHT", i);
    }

    /* renamed from: a */
    public static void m23923a(long j) {
        m23955e("YSF_LAST_UPLOAD_USER", j);
    }

    /* renamed from: a */
    public static void m23924a(Context context, String str) {
        f18820a = context.getApplicationContext();
        f18821b = str;
    }

    /* renamed from: a */
    public static void m23925a(Boolean bool) {
        m23939b("IS_UN_READ_CALLBACK", bool.booleanValue());
    }

    /* renamed from: a */
    public static void m23926a(String str) {
        m23951d("YSF_ID_YX", str);
    }

    /* renamed from: a */
    public static void m23927a(String str, int i) {
        StringBuilder sb = new StringBuilder("YSF_SESSION_COUNT/");
        sb.append(str);
        m23950d(sb.toString(), i);
    }

    /* renamed from: a */
    public static void m23928a(String str, long j) {
        StringBuilder sb = new StringBuilder("YSF_SESSION_ID/");
        sb.append(str);
        m23955e(sb.toString(), j);
    }

    /* renamed from: a */
    public static void m23929a(String str, C6115b bVar) {
        String jSONObject = bVar == null ? null : bVar.mo29059b().toString();
        StringBuilder sb = new StringBuilder("YSF_EVALUATION_CONFIG/");
        sb.append(str);
        m23951d(sb.toString(), jSONObject);
    }

    /* renamed from: a */
    public static void m23930a(String str, String str2) {
        StringBuilder sb = new StringBuilder("YSF_ID_MP/");
        sb.append(str);
        m23951d(sb.toString(), str2);
    }

    /* renamed from: a */
    public static void m23931a(boolean z) {
        m23939b("YSF_EAR_PHONE_MODE", z);
    }

    /* renamed from: a */
    private static boolean m23932a(String str, boolean z) {
        return m23984t().getBoolean(str, z);
    }

    /* renamed from: b */
    public static int m23933b(int i) {
        return m23941c("YSF_KEYBOARD_HEIGHT", i);
    }

    /* renamed from: b */
    public static String m23934b() {
        String s = m23982s("YSF_ID_TK");
        if (TextUtils.isEmpty(s)) {
            return null;
        }
        String d = m23948d();
        return C6210b.m24634a(f18820a, C5401a.m22110a(s), d);
    }

    /* renamed from: b */
    public static void m23935b(String str) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            byte[] a = C6210b.m24636a(f18820a, str, m23948d());
            if (a != null) {
                str2 = C5401a.m22109a(a);
                m23951d("YSF_ID_TK", str2);
            }
        }
        str2 = null;
        m23951d("YSF_ID_TK", str2);
    }

    /* renamed from: b */
    public static void m23936b(String str, int i) {
        StringBuilder sb = new StringBuilder("YSF_SESSION_EVALUATE_STATE/");
        sb.append(str);
        m23950d(sb.toString(), i);
    }

    /* renamed from: b */
    public static void m23937b(String str, long j) {
        StringBuilder sb = new StringBuilder("KEY_YSF_MUITI_EVALUATION_TIME/");
        sb.append(str);
        m23955e(sb.toString(), j);
    }

    /* renamed from: b */
    public static void m23938b(String str, String str2) {
        StringBuilder sb = new StringBuilder("YSF_DRAFT/");
        sb.append(str);
        m23951d(sb.toString(), str2);
    }

    /* renamed from: b */
    private static void m23939b(String str, boolean z) {
        C5407d.m22128a(m23984t(), str, z);
    }

    /* renamed from: b */
    public static void m23940b(boolean z) {
        m23939b("YSF_SB_ON", z);
    }

    /* renamed from: c */
    private static int m23941c(String str, int i) {
        return m23984t().getInt(str, i);
    }

    /* renamed from: c */
    public static String m23942c() {
        return m23984t().getString("YSF_BID", "");
    }

    /* renamed from: c */
    public static void m23943c(String str) {
        m23951d("YSF_BID", str);
    }

    /* renamed from: c */
    public static void m23944c(String str, long j) {
        m23955e(str, j);
    }

    /* renamed from: c */
    public static void m23945c(String str, String str2) {
        StringBuilder sb = new StringBuilder("YSF_EVALUATION_MESSAGE_ID/");
        sb.append(str);
        m23951d(sb.toString(), str2);
    }

    /* renamed from: c */
    public static void m23946c(boolean z) {
        m23939b("YSF_TOKEN_REGISTERED", z);
    }

    /* renamed from: d */
    private static long m23947d(String str, long j) {
        try {
            r1 = str;
            r1 = m23984t().getLong(str, j);
            r1 = r1;
            return r1;
        } catch (ClassCastException unused) {
            return (long) m23984t().getInt(r1, 0);
        }
    }

    /* renamed from: d */
    public static String m23948d() {
        String str = "YSF_ID_DV";
        String s = m23982s(str);
        if (!TextUtils.isEmpty(s)) {
            return s;
        }
        String replace = UUID.randomUUID().toString().replace("-", "");
        m23951d(str, replace);
        return replace;
    }

    /* renamed from: d */
    public static String m23949d(String str) {
        StringBuilder sb = new StringBuilder("YSF_DRAFT/");
        sb.append(str);
        return m23982s(sb.toString());
    }

    /* renamed from: d */
    private static void m23950d(String str, int i) {
        C5407d.m22125a(m23984t(), str, i);
    }

    /* renamed from: d */
    private static void m23951d(String str, String str2) {
        C5407d.m22127a(m23984t(), str, str2);
    }

    /* renamed from: d */
    public static void m23952d(boolean z) {
        m23939b("YSF_STATISTICS_ON", z);
    }

    /* renamed from: e */
    public static void m23953e() {
        m23951d("YSF_ID_DV", (String) null);
    }

    /* renamed from: e */
    public static void m23954e(String str) {
        m23951d("YSF_FOREIGN_NAME", str);
    }

    /* renamed from: e */
    private static void m23955e(String str, long j) {
        C5407d.m22126a(m23984t(), str, j);
    }

    /* renamed from: f */
    public static String m23956f() {
        String str = "YSF_ID_SD";
        String s = m23982s(str);
        if (!TextUtils.isEmpty(s)) {
            return s;
        }
        String a = C5401a.m22109a(new SecureRandom().generateSeed(32));
        m23951d(str, a);
        return a;
    }

    /* renamed from: f */
    public static void m23957f(String str) {
        m23951d("YSF_CRM_DATA", str);
    }

    /* renamed from: g */
    public static String m23958g() {
        return m23982s("YSF_FOREIGN_NAME");
    }

    /* renamed from: g */
    public static void m23959g(String str) {
        m23951d("AUTH_TOKEN", str);
    }

    /* renamed from: h */
    public static long m23960h(String str) {
        StringBuilder sb = new StringBuilder("YSF_SESSION_ID/");
        sb.append(str);
        return m23947d(sb.toString(), 0);
    }

    /* renamed from: h */
    public static String m23961h() {
        return m23982s("YSF_CRM_DATA");
    }

    /* renamed from: i */
    public static int m23962i(String str) {
        StringBuilder sb = new StringBuilder("YSF_SESSION_COUNT/");
        sb.append(str);
        return m23941c(sb.toString(), 0);
    }

    /* renamed from: i */
    public static String m23963i() {
        return m23982s("AUTH_TOKEN");
    }

    /* renamed from: j */
    public static int m23964j(String str) {
        StringBuilder sb = new StringBuilder("YSF_SESSION_EVALUATE_STATE/");
        sb.append(str);
        return m23941c(sb.toString(), 0);
    }

    /* renamed from: j */
    public static boolean m23965j() {
        return m23932a("YSF_EAR_PHONE_MODE", false);
    }

    /* renamed from: k */
    public static C6115b m23966k(String str) {
        StringBuilder sb = new StringBuilder("YSF_EVALUATION_CONFIG/");
        sb.append(str);
        JSONObject a = C5366b.m22027a(m23982s(sb.toString()));
        if (a == null) {
            return null;
        }
        C6115b bVar = new C6115b();
        bVar.mo29058a(a);
        return bVar;
    }

    /* renamed from: k */
    public static Boolean m23967k() {
        return Boolean.valueOf(m23932a("IS_UN_READ_CALLBACK", false));
    }

    /* renamed from: l */
    public static long m23968l(String str) {
        StringBuilder sb = new StringBuilder("KEY_YSF_MUITI_EVALUATION_TIME/");
        sb.append(str);
        return m23947d(sb.toString(), 0);
    }

    /* renamed from: l */
    public static boolean m23969l() {
        return m23932a("YSF_SB_ON", true);
    }

    /* renamed from: m */
    public static String m23970m() {
        return m23982s("YSF_PUSH_TOKEN");
    }

    /* renamed from: m */
    public static String m23971m(String str) {
        StringBuilder sb = new StringBuilder("YSF_EVALUATION_MESSAGE_ID/");
        sb.append(str);
        return m23982s(sb.toString());
    }

    /* renamed from: n */
    public static void m23972n(String str) {
        m23951d("YSF_PUSH_TOKEN", str);
    }

    /* renamed from: n */
    public static boolean m23973n() {
        return m23932a("YSF_TOKEN_REGISTERED", true);
    }

    /* renamed from: o */
    public static String m23974o() {
        return m23982s("YSF_LAST_STAFF_ID");
    }

    /* renamed from: o */
    public static void m23975o(String str) {
        m23951d("YSF_LAST_STAFF_ID", str);
    }

    /* renamed from: p */
    public static String m23976p() {
        return m23982s("YSF_MSG_SESSION_ID");
    }

    /* renamed from: p */
    public static void m23977p(String str) {
        String sb;
        String str2 = "YSF_MSG_SESSION_ID";
        if (TextUtils.isEmpty(str)) {
            sb = null;
        } else {
            String s = m23982s(str2);
            if (TextUtils.isEmpty(s)) {
                m23951d(str2, str);
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(s);
            sb2.append(StorageInterface.KEY_SPLITER);
            sb2.append(str);
            sb = sb2.toString();
        }
        m23951d(str2, sb);
    }

    /* renamed from: q */
    public static String m23978q() {
        return m23982s("YSF_CRM_DATA_CACHE");
    }

    /* renamed from: q */
    public static void m23979q(String str) {
        m23951d("YSF_CRM_DATA_CACHE", str);
    }

    /* renamed from: r */
    public static long m23980r() {
        return m23947d("YSF_LAST_UPLOAD_USER", 0);
    }

    /* renamed from: r */
    public static long m23981r(String str) {
        return m23947d(str, -1000);
    }

    /* renamed from: s */
    private static String m23982s(String str) {
        return m23984t().getString(str, null);
    }

    /* renamed from: s */
    public static boolean m23983s() {
        return m23932a("YSF_STATISTICS_ON", false);
    }

    /* renamed from: t */
    private static SharedPreferences m23984t() {
        Context context = f18820a;
        StringBuilder sb = new StringBuilder("Unicorn.");
        sb.append(f18821b);
        return context.getSharedPreferences(sb.toString(), 0);
    }
}
