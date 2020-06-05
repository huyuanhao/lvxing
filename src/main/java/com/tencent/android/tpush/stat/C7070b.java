package com.tencent.android.tpush.stat;

import android.content.Context;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.service.XGPushServiceV4;
import com.tencent.android.tpush.service.p588a.C6971a;
import com.tencent.android.tpush.stat.p596a.C7066c;
import com.tencent.android.tpush.stat.p596a.C7067d;
import com.tencent.android.tpush.stat.p596a.C7068e;
import com.tencent.bugly.BuglyStrategy.C7120a;
import com.tencent.stat.common.StatConstants;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.stat.b */
public class C7070b {
    /* renamed from: a */
    static C7071a f23500a = new C7071a(2);
    /* renamed from: b */
    static C7071a f23501b = new C7071a(1);
    /* renamed from: c */
    static String f23502c = "__HIBERNATE__";
    /* renamed from: d */
    static volatile String f23503d = StatConstants.MTA_SERVER;
    /* renamed from: e */
    private static C7067d f23504e = C7066c.m30259b();
    /* renamed from: f */
    private static StatReportStrategy f23505f = StatReportStrategy.APP_LAUNCH;
    /* renamed from: g */
    private static boolean f23506g = false;
    /* renamed from: h */
    private static boolean f23507h = true;
    /* renamed from: i */
    private static volatile String f23508i = StatConstants.MTA_REPORT_FULL_URL;
    /* renamed from: j */
    private static boolean f23509j = false;
    /* renamed from: k */
    private static short f23510k = 6;
    /* renamed from: l */
    private static int f23511l = 1024;
    /* renamed from: m */
    private static int f23512m = C7120a.MAX_USERDATA_VALUE_LENGTH;
    /* renamed from: n */
    private static int f23513n = 0;
    /* renamed from: o */
    private static int f23514o = 20;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.stat.b$a */
    static class C7071a {
        /* renamed from: a */
        int f23515a;
        /* renamed from: b */
        JSONObject f23516b = new JSONObject();
        /* renamed from: c */
        String f23517c = "";
        /* renamed from: d */
        int f23518d = 0;

        public C7071a(int i) {
            this.f23515a = i;
        }
    }

    /* renamed from: a */
    public static StatReportStrategy m30294a() {
        return f23505f;
    }

    /* renamed from: a */
    public static void m30299a(StatReportStrategy statReportStrategy) {
        f23505f = statReportStrategy;
        if (m30304b()) {
            C7067d dVar = f23504e;
            StringBuilder sb = new StringBuilder();
            sb.append("Change to statSendStrategy: ");
            sb.append(statReportStrategy);
            dVar.mo34176h(sb.toString());
        }
    }

    /* renamed from: b */
    public static boolean m30304b() {
        return f23506g;
    }

    /* renamed from: c */
    public static boolean m30305c() {
        Context context = XGPushManager.getContext();
        if (context == null) {
            context = XGPushServiceV4.m29691b();
        }
        if (context == null) {
            return f23507h;
        }
        boolean z = true;
        if (!f23507h || C6971a.m29749a(context.getApplicationContext()).f23131B != 1) {
            z = false;
        }
        return z;
    }

    /* renamed from: a */
    public static void m30301a(boolean z) {
        f23507h = z;
        if (!z) {
            f23504e.mo34171c("!!!!!!MTA StatService has been disabled!!!!!!");
        }
    }

    /* renamed from: a */
    static void m30298a(Context context, JSONObject jSONObject) {
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if (str.equalsIgnoreCase(Integer.toString(f23501b.f23515a))) {
                    m30297a(context, f23501b, jSONObject.getJSONObject(str));
                } else if (str.equalsIgnoreCase(Integer.toString(f23500a.f23515a))) {
                    m30297a(context, f23500a, jSONObject.getJSONObject(str));
                }
            }
        } catch (JSONException e) {
            f23504e.mo34170b((Throwable) e);
        }
    }

    /* renamed from: a */
    static void m30297a(Context context, C7071a aVar, JSONObject jSONObject) {
        String str = "m";
        String str2 = "c";
        boolean z = false;
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str3 = (String) keys.next();
                if (str3.equalsIgnoreCase("v")) {
                    int i = jSONObject.getInt(str3);
                    if (aVar.f23518d != i) {
                        z = true;
                    }
                    aVar.f23518d = i;
                } else if (str3.equalsIgnoreCase(str2)) {
                    String string = jSONObject.getString(str2);
                    if (string.length() > 0) {
                        aVar.f23516b = new JSONObject(string);
                    }
                } else if (str3.equalsIgnoreCase(str)) {
                    aVar.f23517c = jSONObject.getString(str);
                }
            }
            if (z && aVar.f23515a == f23501b.f23515a) {
                m30300a(aVar.f23516b);
                m30302b(aVar.f23516b);
            }
            m30296a(context, aVar);
        } catch (JSONException e) {
            f23504e.mo34170b((Throwable) e);
        } catch (Throwable th) {
            f23504e.mo34170b(th);
        }
    }

    /* renamed from: a */
    static void m30300a(JSONObject jSONObject) {
        try {
            StatReportStrategy statReportStrategy = StatReportStrategy.getStatReportStrategy(jSONObject.getInt("rs"));
            if (statReportStrategy != null) {
                m30299a(statReportStrategy);
            }
        } catch (JSONException unused) {
            if (m30304b()) {
                f23504e.mo34169b((Object) "rs not found.");
            }
        }
    }

    /* renamed from: a */
    static void m30296a(Context context, C7071a aVar) {
        if (aVar.f23515a == f23501b.f23515a) {
            f23501b = aVar;
            m30300a(f23501b.f23516b);
        } else if (aVar.f23515a == f23500a.f23515a) {
            f23500a = aVar;
        }
    }

    /* renamed from: b */
    static void m30302b(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            try {
                String string = jSONObject.getString(f23502c);
                String str = "2.0.6";
                if (m30304b()) {
                    C7067d dVar = f23504e;
                    StringBuilder sb = new StringBuilder();
                    sb.append("hibernateVer:");
                    sb.append(string);
                    sb.append(", current version:");
                    sb.append(str);
                    dVar.mo34176h(sb.toString());
                }
                long a = C7066c.m30252a(string);
                if (C7066c.m30252a(str) <= a) {
                    m30295a(a);
                }
            } catch (JSONException unused) {
                f23504e.mo34176h("__HIBERNATE__ not found.");
            }
        }
    }

    /* renamed from: a */
    static void m30295a(long j) {
        C7068e.m30287b(C7082d.m30377a(), f23502c, j);
        m30301a(false);
        f23504e.mo34171c("MTA is disable for current SDK version");
    }

    /* renamed from: d */
    public static String m30306d() {
        return f23508i;
    }

    /* renamed from: e */
    public static boolean m30307e() {
        return f23509j;
    }

    /* renamed from: b */
    public static void m30303b(boolean z) {
        f23509j = z;
    }

    /* renamed from: f */
    public static int m30308f() {
        return f23511l;
    }
}
