package com.tencent.stat;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.bugly.BuglyStrategy.C7120a;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.tencent.mid.api.MidService;
import com.tencent.p605ep.commonbase.software.AppEntity;
import com.tencent.stat.app.api.AppInstallSourceMrg;
import com.tencent.stat.common.DeviceInfo;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatConstants;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.common.StatPreferences;
import com.tencent.stat.common.Util;
import com.tencent.stat.common.X5Helper;
import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class StatConfig {
    /* renamed from: A */
    private static HashSet<String> f25319A = null;
    /* renamed from: B */
    private static HashSet<String> f25320B = new HashSet<>();
    /* renamed from: C */
    private static int f25321C = 100000;
    /* renamed from: D */
    private static int f25322D = 30;
    /* renamed from: E */
    private static int f25323E = 10;
    /* renamed from: F */
    private static int f25324F = 100;
    /* renamed from: G */
    private static int f25325G = 30;
    /* renamed from: H */
    private static int f25326H = 1;
    /* renamed from: I */
    private static String f25327I = null;
    /* renamed from: J */
    private static String f25328J;
    /* renamed from: K */
    private static String f25329K;
    /* renamed from: L */
    private static String f25330L = "mta_channel";
    /* renamed from: M */
    private static int f25331M = TinkerReport.KEY_APPLIED_VERSION_CHECK;
    /* renamed from: N */
    private static String f25332N;
    /* renamed from: O */
    private static int f25333O = 1024;
    /* renamed from: P */
    private static long f25334P = 0;
    /* renamed from: Q */
    private static long f25335Q = 300000;
    /* renamed from: R */
    private static volatile String f25336R = StatConstants.MTA_REPORT_FULL_URL;
    /* renamed from: S */
    private static int f25337S = 0;
    /* renamed from: T */
    private static volatile int f25338T = 0;
    /* renamed from: U */
    private static int f25339U = 20;
    /* renamed from: V */
    private static int f25340V = 0;
    /* renamed from: W */
    private static boolean f25341W = false;
    /* renamed from: X */
    private static int f25342X = 4096;
    /* renamed from: Y */
    private static boolean f25343Y = true;
    /* renamed from: Z */
    private static String f25344Z = null;
    /* renamed from: a */
    static C7530a f25345a = new C7530a(2);
    /* renamed from: aa */
    private static boolean f25346aa = false;
    /* renamed from: ab */
    private static StatCustomLogger f25347ab = null;
    /* renamed from: ac */
    private static StatExceptionCallBack f25348ac = null;
    /* renamed from: ad */
    private static String f25349ad = null;
    /* renamed from: ae */
    private static JSONObject f25350ae = null;
    /* renamed from: af */
    private static HashSet<String> f25351af = new HashSet<>();
    /* renamed from: ag */
    private static long f25352ag = 800;
    /* renamed from: ah */
    private static StatActionListener f25353ah = null;
    /* renamed from: ai */
    private static boolean f25354ai = true;
    /* renamed from: aj */
    private static Map<String, Object> f25355aj = new HashMap();
    /* renamed from: ak */
    private static volatile boolean f25356ak = true;
    /* renamed from: b */
    static C7530a f25357b = new C7530a(1);
    /* renamed from: c */
    static String f25358c = "__HIBERNATE__";
    /* renamed from: d */
    static String f25359d = "__HIBERNATE__TIME";
    /* renamed from: e */
    static String f25360e = "__MTA_KILL__";
    /* renamed from: f */
    static String f25361f = "";
    /* renamed from: g */
    static boolean f25362g = false;
    /* renamed from: h */
    static int f25363h = 500;
    /* renamed from: i */
    static long f25364i = 10000;
    public static boolean isAutoExceptionCaught = true;
    /* renamed from: j */
    static boolean f25365j = true;
    /* renamed from: k */
    static volatile String f25366k = StatConstants.MTA_SERVER;
    /* renamed from: l */
    static boolean f25367l = true;
    /* renamed from: m */
    static int f25368m = 0;
    /* renamed from: n */
    static long f25369n = 10000;
    /* renamed from: o */
    static int f25370o = 512;
    /* renamed from: p */
    static StatDataTransfer f25371p = null;
    /* renamed from: q */
    static boolean f25372q = false;
    /* renamed from: r */
    static boolean f25373r = true;
    /* renamed from: s */
    static boolean f25374s = true;
    /* renamed from: t */
    static long f25375t = 7;
    /* renamed from: u */
    static JSONObject f25376u = new JSONObject();
    /* access modifiers changed from: private|static */
    /* renamed from: v */
    public static StatLogger f25377v = StatCommonHelper.getLogger();
    /* renamed from: w */
    private static StatReportStrategy f25378w = StatReportStrategy.APP_LAUNCH;
    /* renamed from: x */
    private static boolean f25379x = false;
    /* renamed from: y */
    private static boolean f25380y = true;
    /* renamed from: z */
    private static int f25381z = C7120a.MAX_USERDATA_VALUE_LENGTH;

    /* renamed from: com.tencent.stat.StatConfig$AccountType */
    public enum AccountType {
        QQ,
        MAIL,
        WX,
        MOBILE,
        ELSE
    }

    /* renamed from: com.tencent.stat.StatConfig$CurrencyType */
    public enum CurrencyType {
        CNY,
        USD
    }

    /* renamed from: com.tencent.stat.StatConfig$a */
    static class C7530a {
        /* renamed from: a */
        int f25387a;
        /* renamed from: b */
        JSONObject f25388b = new JSONObject();
        /* renamed from: c */
        String f25389c = "";
        /* renamed from: d */
        int f25390d = 0;
        /* renamed from: e */
        private boolean f25391e = false;

        /* renamed from: a */
        public void mo36956a(Context context) {
            StatPreferences.putString(context, mo36955a(), mo36957b().toString());
        }

        /* renamed from: b */
        public boolean mo36958b(Context context) {
            if (this.f25391e) {
                return true;
            }
            this.f25391e = true;
            String string = StatPreferences.getString(context, mo36955a(), "");
            if (TextUtils.isEmpty(string)) {
                return false;
            }
            m32609a(string);
            return true;
        }

        /* renamed from: a */
        public String mo36955a() {
            StringBuilder sb = new StringBuilder();
            sb.append("com.tencent.mta.cfg.store");
            sb.append(this.f25387a);
            return sb.toString();
        }

        public C7530a(int i) {
            this.f25387a = i;
        }

        /* renamed from: b */
        public JSONObject mo36957b() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.f25387a);
                jSONObject.put("props", this.f25388b);
                jSONObject.put("md5sum", this.f25389c);
                jSONObject.put(AppEntity.KEY_VERSION_STR, this.f25390d);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return jSONObject;
        }

        /* renamed from: a */
        private void m32609a(String str) {
            String str2 = "";
            try {
                if (StatConfig.isDebugEnable()) {
                    StatLogger g = StatConfig.f25377v;
                    StringBuilder sb = new StringBuilder();
                    sb.append("load config begin:");
                    sb.append(str);
                    g.mo37101d(sb.toString());
                }
                JSONObject jSONObject = new JSONObject(str);
                this.f25387a = jSONObject.optInt("type");
                this.f25388b = new JSONObject(jSONObject.optString("props", str2));
                this.f25389c = jSONObject.optString("md5sum", str2);
                this.f25390d = jSONObject.optInt(AppEntity.KEY_VERSION_STR, 0);
                if (StatConfig.isDebugEnable()) {
                    StatLogger g2 = StatConfig.f25377v;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("load config end, type=");
                    sb2.append(this.f25387a);
                    sb2.append(" ,props=");
                    sb2.append(this.f25388b);
                    sb2.append(" ,version=");
                    sb2.append(this.f25390d);
                    g2.mo37101d(sb2.toString());
                }
                StatConfig.m32585a();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public String mo36959c() {
            return this.f25388b.toString();
        }
    }

    /* renamed from: a */
    static boolean m32593a(int i, int i2, int i3) {
        return i >= i2 && i <= i3;
    }

    public static StatReportStrategy getStatSendStrategy() {
        return f25378w;
    }

    public static void setStatSendStrategy(StatReportStrategy statReportStrategy) {
        f25378w = statReportStrategy;
        if (statReportStrategy != StatReportStrategy.PERIOD) {
            StatServiceImpl.f25433d = 0;
        }
        if (isDebugEnable()) {
            StatLogger statLogger = f25377v;
            StringBuilder sb = new StringBuilder();
            sb.append("Change to statSendStrategy: ");
            sb.append(statReportStrategy);
            statLogger.mo37101d(sb.toString());
        }
    }

    public static boolean isDebugEnable() {
        return f25379x;
    }

    public static void setDebugEnable(boolean z) {
        f25379x = z;
        StatCommonHelper.getLogger().setDebugEnable(z);
    }

    public static boolean isEnableStatService() {
        return f25380y;
    }

    public static void setEnableStatService(boolean z) {
        f25380y = z;
        if (!z) {
            f25377v.warn("!!!!!!MTA StatService has been disabled!!!!!!");
        }
    }

    public static int getSessionTimoutMillis() {
        return f25381z;
    }

    public static void setSessionTimoutMillis(int i) {
        if (!m32593a(i, 1000, 86400000)) {
            f25377v.error((Object) "setSessionTimoutMillis can not exceed the range of [1000, 24 * 60 * 60 * 1000].");
        } else {
            f25381z = i;
        }
    }

    /* renamed from: a */
    static boolean m32594a(String str) {
        HashSet<String> hashSet = f25319A;
        if (hashSet == null || hashSet.size() == 0 || !StatCommonHelper.isStringValid(str)) {
            return false;
        }
        return f25319A.contains(str.toLowerCase());
    }

    /* renamed from: b */
    static void m32599b(String str) {
        if (StatCommonHelper.isStringValid(str)) {
            String[] split = str.toLowerCase().split(";");
            if (split.length > 0) {
                if (f25319A == null) {
                    f25319A = new HashSet<>(split.length);
                }
                f25319A.addAll(Arrays.asList(split));
            }
        }
    }

    public static boolean isEventIdInDontReportEventIdsSet(String str) {
        HashSet<String> hashSet = f25320B;
        if (hashSet == null || hashSet.size() == 0 || !StatCommonHelper.isStringValid(str)) {
            return false;
        }
        return f25320B.contains(str.toLowerCase());
    }

    public static void updateDontReportEventIdsSet(String str) {
        if (StatCommonHelper.isStringValid(str)) {
            String[] split = str.toLowerCase().split(";");
            if (split.length > 0) {
                if (f25320B == null) {
                    f25320B = new HashSet<>(split.length);
                }
                f25320B.addAll(Arrays.asList(split));
            }
        }
    }

    /* renamed from: a */
    static void m32585a() {
        C7530a aVar = f25357b;
        if (aVar != null) {
            m32599b(aVar.f25388b.optString("__INSTANT_EI_LIST__", null));
            updateDontReportEventIdsSet(f25357b.f25388b.optString("__DONT_REPORT_EI_LIST__", null));
        }
    }

    public static int getMaxImportantDataSendRetryCount() {
        return f25324F;
    }

    public static void setMaxImportantDataSendRetryCount(int i) {
        if (i > 100) {
            f25324F = i;
        }
    }

    public static int getMaxBatchReportCount() {
        return f25325G;
    }

    public static void setMaxBatchReportCount(int i) {
        if (!m32593a(i, 2, 1000)) {
            f25377v.error((Object) "setMaxBatchReportCount can not exceed the range of [2,1000].");
        } else {
            f25325G = i;
        }
    }

    public static void setMaxSendRetryCount(int i) {
        if (!m32593a(i, 1, 1000)) {
            f25377v.error((Object) "setMaxSendRetryCount can not exceed the range of [1,1000].");
        } else {
            f25323E = i;
        }
    }

    public static int getMaxSendRetryCount() {
        return f25323E;
    }

    public static int getNumEventsCommitPerSec() {
        return f25326H;
    }

    public static void setNumEventsCommitPerSec(int i) {
        if (i > 0) {
            f25326H = i;
        }
    }

    /* renamed from: b */
    static int m32596b() {
        return f25322D;
    }

    public static int getMaxStoreEventCount() {
        return f25321C;
    }

    public static void setMaxStoreEventCount(int i) {
        if (!m32593a(i, 0, 500000)) {
            f25377v.error((Object) "setMaxStoreEventCount can not exceed the range of [0, 500000].");
        } else {
            f25321C = i;
        }
    }

    public static String getCustomProperty(Context context, String str) {
        init(context);
        return getCustomProperty(str);
    }

    public static String getCustomProperty(Context context, String str, String str2) {
        init(context);
        return getCustomProperty(str, str2);
    }

    public static String getCustomProperty(String str) {
        try {
            m32608h();
            return f25345a.f25388b.getString(str);
        } catch (Throwable th) {
            f25377v.mo37116w(th);
            return null;
        }
    }

    public static void init(Context context) {
        f25345a.mo36958b(context);
        f25357b.mo36958b(context);
        m32585a();
    }

    /* renamed from: h */
    private static void m32608h() {
        Context context = StatServiceImpl.getContext(null);
        if (context != null) {
            init(context);
        }
    }

    public static String getCustomProperty(String str, String str2) {
        try {
            m32608h();
            String string = f25345a.f25388b.getString(str);
            if (string != null) {
                return string;
            }
            return str2;
        } catch (Throwable th) {
            f25377v.mo37116w(th);
        }
    }

    public static String getSDKProperty(String str) {
        try {
            m32608h();
            return f25357b.f25388b.getString(str);
        } catch (Throwable th) {
            f25377v.mo37116w(th);
            return null;
        }
    }

    public static String getSDKProperty(String str, String str2) {
        try {
            m32608h();
            str = f25357b.f25388b.getString(str);
            if (str != null) {
                return str;
            }
            return str2;
        } catch (Throwable unused) {
            StatLogger statLogger = f25377v;
            StringBuilder sb = new StringBuilder();
            sb.append("can't find SDK Properties key:");
            sb.append(str);
            statLogger.mo37101d(sb.toString());
        }
    }

    /* renamed from: a */
    static void m32591a(Context context, JSONObject jSONObject) {
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if (str.equalsIgnoreCase(Integer.toString(f25357b.f25387a))) {
                    m32589a(context, f25357b, jSONObject.getJSONObject(str));
                    m32585a();
                } else if (str.equalsIgnoreCase(Integer.toString(f25345a.f25387a))) {
                    m32589a(context, f25345a, jSONObject.getJSONObject(str));
                } else if (str.equalsIgnoreCase("rs")) {
                    StatReportStrategy statReportStrategy = StatReportStrategy.getStatReportStrategy(jSONObject.getInt(str));
                    if (statReportStrategy != null) {
                        f25378w = statReportStrategy;
                        if (isDebugEnable()) {
                            StatLogger statLogger = f25377v;
                            StringBuilder sb = new StringBuilder();
                            sb.append("Change to ReportStrategy:");
                            sb.append(statReportStrategy.name());
                            statLogger.mo37101d(sb.toString());
                        }
                    }
                } else {
                    return;
                }
            }
        } catch (JSONException e) {
            f25377v.mo37104e((Throwable) e);
        }
    }

    /* renamed from: a */
    static void m32589a(Context context, C7530a aVar, JSONObject jSONObject) {
        String str = "m";
        String str2 = "c";
        boolean z = false;
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str3 = (String) keys.next();
                if (str3.equalsIgnoreCase("v")) {
                    int i = jSONObject.getInt(str3);
                    if (aVar.f25390d != i) {
                        z = true;
                    }
                    aVar.f25390d = i;
                } else if (str3.equalsIgnoreCase(str2)) {
                    String string = jSONObject.getString(str2);
                    if (string.length() > 0) {
                        aVar.f25388b = new JSONObject(string);
                    }
                } else if (str3.equalsIgnoreCase(str)) {
                    aVar.f25389c = jSONObject.getString(str);
                }
            }
            if (z) {
                C7614e a = C7614e.m32812a(C7608d.m32792a());
                if (a != null) {
                    a.mo37145a(aVar);
                }
                if (aVar.f25387a == f25357b.f25387a) {
                    m32592a(aVar.f25388b);
                    m32600b(aVar.f25388b);
                }
            }
            m32588a(context, aVar);
        } catch (JSONException e) {
            f25377v.mo37104e((Throwable) e);
        } catch (Throwable th) {
            f25377v.mo37104e(th);
        }
    }

    /* renamed from: a */
    static void m32592a(JSONObject jSONObject) {
        try {
            int i = jSONObject.getInt("rs");
            StatLogger statLogger = f25377v;
            StringBuilder sb = new StringBuilder();
            sb.append("updateReportStrategy:");
            sb.append(jSONObject);
            sb.append(",sendStrategy:");
            sb.append(i);
            statLogger.mo37108i(sb.toString());
            StatReportStrategy statReportStrategy = StatReportStrategy.getStatReportStrategy(i);
            if (statReportStrategy != null) {
                setStatSendStrategy(statReportStrategy);
            }
        } catch (JSONException unused) {
            if (isDebugEnable()) {
                f25377v.mo37108i("rs not found.");
            }
        }
    }

    /* renamed from: a */
    static void m32588a(Context context, C7530a aVar) throws JSONException {
        if (aVar.f25387a == f25357b.f25387a) {
            f25357b = aVar;
            m32592a(f25357b.f25388b);
            m32585a();
        } else if (aVar.f25387a == f25345a.f25387a) {
            f25345a = aVar;
        }
    }

    /* renamed from: b */
    static void m32598b(Context context, JSONObject jSONObject) {
        String str = StatConstants.VERSION;
        String str2 = "sm";
        String str3 = "";
        try {
            String optString = jSONObject.optString(f25360e);
            if (StatCommonHelper.isStringValid(optString)) {
                JSONObject jSONObject2 = new JSONObject(optString);
                if (jSONObject2.length() != 0) {
                    boolean z = false;
                    if (!jSONObject2.isNull(str2)) {
                        Object obj = jSONObject2.get(str2);
                        int i = obj instanceof Integer ? ((Integer) obj).intValue() : obj instanceof String ? Integer.valueOf((String) obj).intValue() : 0;
                        if (i > 0) {
                            if (isDebugEnable()) {
                                StatLogger statLogger = f25377v;
                                StringBuilder sb = new StringBuilder();
                                sb.append("match sleepTime:");
                                sb.append(i);
                                sb.append(" minutes");
                                statLogger.mo37108i(sb.toString());
                            }
                            StatPreferences.putLong(context, f25359d, System.currentTimeMillis() + ((long) (i * 60 * 1000)));
                            setEnableStatService(false);
                            f25377v.warn("MTA is disable for current SDK version");
                        }
                    }
                    boolean z2 = true;
                    if (m32595a(jSONObject2, "sv", str)) {
                        f25377v.mo37108i("match sdk version:3.4.7");
                        z = true;
                    }
                    if (m32595a(jSONObject2, "md", Build.MODEL)) {
                        StatLogger statLogger2 = f25377v;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("match MODEL:");
                        sb2.append(Build.MODEL);
                        statLogger2.mo37108i(sb2.toString());
                        z = true;
                    }
                    if (m32595a(jSONObject2, "av", StatCommonHelper.getCurAppVersion(context))) {
                        StatLogger statLogger3 = f25377v;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("match app version:");
                        sb3.append(StatCommonHelper.getCurAppVersion(context));
                        statLogger3.mo37108i(sb3.toString());
                        z = true;
                    }
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(Build.MANUFACTURER);
                    sb4.append(str3);
                    if (m32595a(jSONObject2, "mf", sb4.toString())) {
                        StatLogger statLogger4 = f25377v;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("match MANUFACTURER:");
                        sb5.append(Build.MANUFACTURER);
                        sb5.append(str3);
                        statLogger4.mo37108i(sb5.toString());
                        z = true;
                    }
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(VERSION.SDK_INT);
                    sb6.append(str3);
                    boolean a = m32595a(jSONObject2, "osv", sb6.toString());
                    String str4 = "match android SDK version:";
                    if (a) {
                        StatLogger statLogger5 = f25377v;
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append(str4);
                        sb7.append(VERSION.SDK_INT);
                        statLogger5.mo37108i(sb7.toString());
                        z = true;
                    }
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append(VERSION.SDK_INT);
                    sb8.append(str3);
                    if (m32595a(jSONObject2, "ov", sb8.toString())) {
                        StatLogger statLogger6 = f25377v;
                        StringBuilder sb9 = new StringBuilder();
                        sb9.append(str4);
                        sb9.append(VERSION.SDK_INT);
                        statLogger6.mo37108i(sb9.toString());
                        z = true;
                    }
                    if (m32595a(jSONObject2, DeviceInfo.TAG_IMEI, C7614e.m32812a(context).mo37149b(context).getImei())) {
                        StatLogger statLogger7 = f25377v;
                        StringBuilder sb10 = new StringBuilder();
                        sb10.append("match imei:");
                        sb10.append(C7614e.m32812a(context).mo37149b(context).getImei());
                        statLogger7.mo37108i(sb10.toString());
                        z = true;
                    }
                    if (m32595a(jSONObject2, "mid", getLocalMidOnly(context))) {
                        StatLogger statLogger8 = f25377v;
                        StringBuilder sb11 = new StringBuilder();
                        sb11.append("match mid:");
                        sb11.append(getLocalMidOnly(context));
                        statLogger8.mo37108i(sb11.toString());
                    } else {
                        z2 = z;
                    }
                    if (z2) {
                        m32587a(StatCommonHelper.getSDKLongVersion(str));
                    }
                }
            }
        } catch (Exception e) {
            f25377v.mo37104e((Throwable) e);
        }
    }

    /* renamed from: a */
    static boolean m32595a(JSONObject jSONObject, String str, String str2) {
        if (!jSONObject.isNull(str)) {
            String optString = jSONObject.optString(str);
            if (StatCommonHelper.isStringValid(str2) && StatCommonHelper.isStringValid(optString) && str2.equalsIgnoreCase(optString)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    static void m32600b(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            try {
                m32598b(C7608d.m32792a(), jSONObject);
                String string = jSONObject.getString(f25358c);
                boolean isDebugEnable = isDebugEnable();
                String str = StatConstants.VERSION;
                if (isDebugEnable) {
                    StatLogger statLogger = f25377v;
                    StringBuilder sb = new StringBuilder();
                    sb.append("hibernateVer:");
                    sb.append(string);
                    sb.append(", current version:");
                    sb.append(str);
                    statLogger.mo37101d(sb.toString());
                }
                long sDKLongVersion = StatCommonHelper.getSDKLongVersion(string);
                if (StatCommonHelper.getSDKLongVersion(str) <= sDKLongVersion) {
                    m32587a(sDKLongVersion);
                }
            } catch (JSONException unused) {
                f25377v.mo37101d("__HIBERNATE__ not found.");
            }
        }
    }

    /* renamed from: a */
    static void m32587a(long j) {
        StatPreferences.putLong(C7608d.m32792a(), f25358c, j);
        setEnableStatService(false);
        f25377v.warn("MTA is disable for current SDK version");
    }

    /* renamed from: a */
    static void m32590a(Context context, String str) {
        if (str != null) {
            StatPreferences.putString(context, "_mta_ky_tag_", Util.encode(str));
        }
    }

    /* renamed from: a */
    static String m32584a(Context context) {
        return Util.decode(StatPreferences.getString(context, "_mta_ky_tag_", null));
    }

    public static synchronized String getAppKey(Context context) {
        synchronized (StatConfig.class) {
            if (f25328J != null) {
                String str = f25328J;
                return str;
            }
            if (context != null) {
                if (f25328J == null) {
                    f25328J = StatCommonHelper.getAppKey(context);
                }
            }
            if (f25328J == null || f25328J.trim().length() == 0) {
                f25377v.mo37103e((Object) "AppKey can not be null or empty, please read Developer's Guide first!");
            }
            String str2 = f25328J;
            return str2;
        }
    }

    /* renamed from: c */
    private static boolean m32602c(String str) {
        if (str == null) {
            return false;
        }
        String str2 = f25328J;
        if (str2 == null) {
            f25328J = str;
            return true;
        } else if (str2.contains(str)) {
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(f25328J);
            sb.append("|");
            sb.append(str);
            f25328J = sb.toString();
            return true;
        }
    }

    public static void setAppKey(Context context, String str) {
        if (context == null) {
            f25377v.error((Object) "ctx in StatConfig.setAppKey() is null");
        } else if (str == null || str.length() > 256) {
            f25377v.error((Object) "appkey in StatConfig.setAppKey() is null or exceed 256 bytes");
        } else {
            if (f25328J == null) {
                f25328J = m32584a(context);
            }
            if (m32602c(str) || m32602c(StatCommonHelper.getAppKey(context))) {
                m32590a(context, f25328J);
            }
        }
    }

    @Deprecated
    public static void setAppKey(String str) {
        if (str == null) {
            f25377v.error((Object) "appkey in StatConfig.setAppKey() is null");
        } else if (str.length() > 256) {
            f25377v.error((Object) "The length of appkey cann't exceed 256 bytes.");
        } else {
            f25328J = str;
        }
    }

    public static synchronized String getInstallChannel(Context context) {
        synchronized (StatConfig.class) {
            if (f25329K != null) {
                String str = f25329K;
                return str;
            }
            String string = StatPreferences.getString(context, f25330L, "");
            if (TextUtils.isEmpty(string) || m32604d(string)) {
                string = StatCommonHelper.getInstallChannel(context);
            }
            f25329K = string;
            if (f25329K == null || f25329K.trim().length() == 0) {
                f25377v.mo37116w("installChannel can not be null or empty, please read Developer's Guide first!");
            }
            String str2 = f25329K;
            return str2;
        }
    }

    /* renamed from: d */
    private static boolean m32604d(String str) {
        return "Wechat_Sdk".equalsIgnoreCase(str) || "QQConnect".equalsIgnoreCase(str);
    }

    public static void setInstallChannel(String str) {
        if (str.length() > 128) {
            f25377v.error((Object) "the length of installChannel can not exceed the range of 128 bytes.");
            return;
        }
        if (!m32604d(str)) {
            f25329K = str;
        }
    }

    public static void setInstallChannel(Context context, String str) {
        if (str.length() > 128) {
            f25377v.error((Object) "the length of installChannel can not exceed the range of 128 bytes.");
            return;
        }
        if (!m32604d(str)) {
            f25329K = str;
            StatPreferences.putString(context, f25330L, str);
        }
    }

    public static String getQQ(Context context) {
        return StatPreferences.getString(context, "mta.acc.qq", f25361f);
    }

    public static void setQQ(Context context, String str) {
        StatPreferences.putString(context, "mta.acc.qq", str);
        f25361f = str;
    }

    public static void setSendPeriodMinutes(int i) {
        if (!m32593a(i, 1, 10080)) {
            f25377v.error((Object) "setSendPeriodMinutes can not exceed the range of [1, 7*24*60] minutes.");
        } else {
            f25331M = i;
        }
    }

    public static String getMTAPreferencesFileName() {
        return f25332N;
    }

    public static void setMTAPreferencesFileName(String str) {
        f25332N = str;
    }

    public static int getNumOfMethodsCalledLimit() {
        return f25363h;
    }

    public static void setNumOfMethodsCalledLimit(int i, long j) {
        f25363h = i;
        if (j >= 1000) {
            f25364i = j;
        }
    }

    public static long getMsPeriodForMethodsCalledLimitClear() {
        return f25364i;
    }

    public static int getSendPeriodMinutes() {
        return f25331M;
    }

    public static int getMaxParallelTimmingEvents() {
        return f25333O;
    }

    public static void setMaxParallelTimmingEvents(int i) {
        if (!m32593a(i, 1, 4096)) {
            f25377v.error((Object) "setMaxParallelTimmingEvents can not exceed the range of [1, 4096].");
        } else {
            f25333O = i;
        }
    }

    public static boolean isEnableSmartReporting() {
        return f25365j;
    }

    public static void setEnableSmartReporting(boolean z) {
        f25365j = z;
    }

    public static boolean isAutoExceptionCaught() {
        return isAutoExceptionCaught;
    }

    public static void setAutoExceptionCaught(boolean z) {
        if (m32601c()) {
            f25377v.debug("QQ Connect call setAutoExceptionCaught, passed.");
        } else {
            isAutoExceptionCaught = z;
        }
    }

    /* renamed from: c */
    static boolean m32601c() {
        try {
            for (StackTraceElement className : Thread.currentThread().getStackTrace()) {
                if (className.getClassName().startsWith("com.tencent.connect.")) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String getStatReportUrl() {
        return f25336R;
    }

    public static void setStatReportUrl(String str) {
        if (str == null || str.length() == 0) {
            f25377v.error((Object) "statReportUrl cannot be null or empty.");
            return;
        }
        f25336R = str;
        try {
            f25366k = new URI(f25336R).getHost();
        } catch (Exception e) {
            f25377v.mo37116w(e);
        }
        if (isDebugEnable()) {
            StatLogger statLogger = f25377v;
            StringBuilder sb = new StringBuilder();
            sb.append("url:");
            sb.append(f25336R);
            sb.append(", domain:");
            sb.append(f25366k);
            statLogger.mo37108i(sb.toString());
        }
    }

    public static String getStatReportHost() {
        return f25366k;
    }

    public static int getMaxSessionStatReportCount() {
        return f25337S;
    }

    public static void setMaxSessionStatReportCount(int i) {
        if (i < 0) {
            f25377v.error((Object) "maxSessionStatReportCount cannot be less than 0.");
        } else {
            f25337S = i;
        }
    }

    public static int getCurSessionStatReportCount() {
        return f25338T;
    }

    /* renamed from: a */
    static synchronized void m32586a(int i) {
        synchronized (StatConfig.class) {
            f25338T = i;
        }
    }

    public static int getMaxDaySessionNumbers() {
        return f25339U;
    }

    public static void setMaxDaySessionNumbers(int i) {
        if (i <= 0) {
            f25377v.mo37103e((Object) "maxDaySessionNumbers must be greater than 0.");
        } else {
            f25339U = i;
        }
    }

    /* renamed from: d */
    static void m32603d() {
        f25340V++;
    }

    /* renamed from: b */
    static void m32597b(int i) {
        if (i >= 0) {
            f25340V = i;
        }
    }

    /* renamed from: e */
    static int m32605e() {
        return f25340V;
    }

    public static int getMaxReportEventLength() {
        return f25342X;
    }

    public static void setMaxReportEventLength(int i) {
        if (i <= 0) {
            f25377v.error((Object) "maxReportEventLength on setMaxReportEventLength() must greater than 0.");
        } else {
            f25342X = i;
        }
    }

    public static boolean isEnableConcurrentProcess() {
        return f25343Y;
    }

    public static void setEnableConcurrentProcess(boolean z) {
        f25343Y = z;
    }

    public static String getCustomUserId(Context context) {
        if (context == null) {
            f25377v.error((Object) "Context for getCustomUid is null.");
            return null;
        }
        if (f25344Z == null) {
            try {
                f25344Z = StatPreferences.getString(context, "MTA_CUSTOM_UID", "");
            } catch (ClassCastException e) {
                f25377v.mo37104e((Throwable) e);
            }
        }
        return f25344Z;
    }

    public static void setCustomUserId(Context context, String str) {
        if (context == null) {
            f25377v.error((Object) "Context for setCustomUid is null.");
            return;
        }
        StatPreferences.putString(context, "MTA_CUSTOM_UID", str);
        f25344Z = str;
    }

    public static void setNativeCrashDebugEnable(boolean z) {
        StatNativeCrashReport.setNativeCrashDebugEnable(z);
    }

    public static void initNativeCrashReport(Context context, String str) {
        if (isEnableStatService()) {
            if (context == null) {
                f25377v.error((Object) "The Context of StatConfig.initNativeCrashReport() can not be null!");
            } else {
                StatNativeCrashReport.initNativeCrash(context, str);
            }
        }
    }

    public static String getMid(Context context) {
        return MidService.getMid(context);
    }

    public static String getLocalMidOnly(Context context) {
        return MidService.getLocalMidOnly(context);
    }

    public static void setXGProMode(boolean z) {
        f25346aa = z;
    }

    public static boolean isXGProMode() {
        return f25346aa;
    }

    public static StatCustomLogger getCustomLogger() {
        return f25347ab;
    }

    public static void setCustomLogger(StatCustomLogger statCustomLogger) {
        f25347ab = statCustomLogger;
    }

    public static boolean isReportEventsByOrder() {
        return f25367l;
    }

    public static void setReportEventsByOrder(boolean z) {
        f25367l = z;
    }

    public static int getNumEventsCachedInMemory() {
        return f25368m;
    }

    public static void setNumEventsCachedInMemory(int i) {
        if (i >= 0) {
            f25368m = i;
        }
    }

    public static long getFlushDBSpaceMS() {
        return f25369n;
    }

    public static void setFlushDBSpaceMS(long j) {
        if (j > 0) {
            f25369n = j;
        }
    }

    public static int getReportCompressedSize() {
        return f25370o;
    }

    public static void setReportCompressedSize(int i) {
        if (i > 0) {
            f25370o = i;
        }
    }

    public static StatDataTransfer getDataTransfer() {
        return f25371p;
    }

    public static void setDataTransfer(StatDataTransfer statDataTransfer) {
        f25371p = statDataTransfer;
    }

    /* renamed from: f */
    protected static StatExceptionCallBack m32606f() {
        return f25348ac;
    }

    public static void setStatExCallBack(StatExceptionCallBack statExceptionCallBack) {
        f25348ac = statExceptionCallBack;
    }

    public static String getAppVersion() {
        return f25349ad;
    }

    public static void setAppVersion(String str) {
        f25349ad = str;
    }

    public static JSONObject getCustomGlobalReportContent() {
        return f25350ae;
    }

    public static void setCustomGlobalReportContent(JSONObject jSONObject) {
        f25350ae = jSONObject;
    }

    public static void addSkipSessionReportAppkey(String str) {
        if (StatCommonHelper.isStringValid(str)) {
            f25351af.add(str);
        }
    }

    public static boolean shouldSkipSessionReport(String str) {
        return f25351af.contains(str);
    }

    public static void removeSkipSessionReportAppkey(String str) {
        f25351af.remove(str);
    }

    public static long getBackgroundDelayTimestamp() {
        return f25352ag;
    }

    public static void setBackgroundDelayTimestamp(long j) {
        if (j <= 0 || j >= 10000) {
            StringBuilder sb = new StringBuilder();
            sb.append("setBackgroundDelayTimestamp falied, timestamp:");
            sb.append(j);
            sb.append(" is invalid.");
            Log.e(StatConstants.LOG_TAG, sb.toString());
            return;
        }
        f25352ag = j;
    }

    public static void enableCommitEventAtBackground(final Context context, boolean z) {
        if (!z) {
            StatActionListener statActionListener = f25353ah;
            if (statActionListener != null) {
                StatService.removeActionListener(statActionListener);
                f25353ah = null;
            }
        } else if (f25353ah == null) {
            f25353ah = new StatActionListener() {
                public void onBecameForeground() {
                }

                public void onBecameBackground() {
                    StatService.commitEvents(context, -1);
                }
            };
            StatService.addActionListener(f25353ah);
        }
    }

    public static boolean isAntoActivityLifecycleStat() {
        return f25372q;
    }

    public static void setAntoActivityLifecycleStat(boolean z) {
        f25372q = z;
    }

    public static boolean isAutoTrackBackgroundEvent() {
        return f25373r;
    }

    public static void setAutoTrackBackgroundEvent(boolean z) {
        f25373r = z;
    }

    public static boolean isAutoTrackAppsEvent() {
        return f25374s;
    }

    public static void setAutoTrackAppsEvent(boolean z) {
        f25374s = z;
    }

    public static boolean isEnableReportWifiList() {
        return f25354ai;
    }

    public static void setEnableReportWifiList(boolean z) {
        f25354ai = z;
    }

    public static long getStoredRecordExpiredDays() {
        return f25375t;
    }

    public static void setStoredRecordExpiredDays(long j) {
        if (j > 0) {
            f25375t = j;
        }
    }

    public static void setCrashKeyValue(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            f25377v.mo37103e((Object) "setCrashKeyValue key or value not valid.");
            return;
        }
        try {
            f25376u.put(str, str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void addCrashTrackLog(String str) {
        StatTrackLog.log(str);
    }

    public static void printLog(int i, String str, String str2) {
        if (f25379x) {
            switch (i) {
                case 2:
                    Log.v(str, str2);
                    break;
                case 3:
                    Log.d(str, str2);
                    break;
                case 4:
                    Log.i(str, str2);
                    break;
                case 5:
                    Log.w(str, str2);
                    break;
                case 6:
                case 7:
                    Log.e(str, str2);
                    break;
                default:
                    Log.i(str, str2);
                    break;
            }
        }
    }

    public static JSONObject getCrashKeyValue() {
        return f25376u;
    }

    public static Map<String, Object> getCustomReportMap() {
        return f25355aj;
    }

    public static void addCustomReportKeyValue(String str, Object obj) {
        f25355aj.put(str, obj);
    }

    public static void getCustomReportKeyValue(String str) {
        if (str != null) {
            f25355aj.get(str);
        }
    }

    public static void delCustomReportKeyValue(String str) {
        if (str != null) {
            f25355aj.remove(str);
        }
    }

    public static void setTLinkStatus(boolean z) {
        AppInstallSourceMrg.setEnable(z);
    }

    public static boolean getTLinkStatus() {
        return AppInstallSourceMrg.isEnable();
    }

    public static void invokeTBSSdkOnUiThread(Context context) {
        X5Helper.initOnUiThread(context);
    }

    public static boolean isEnableAutoMonitorActivityCycle() {
        return f25356ak;
    }

    public static void setEnableAutoMonitorActivityCycle(boolean z) {
        f25356ak = z;
    }
}
