package com.tencent.mta.track;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.tencent.mta.track.exceptions.InvalidDataException;
import com.tencent.mta.track.util.C7468g;
import com.tencent.stat.StatService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class StatisticsDataAPI implements C7474w {
    public static short PROTOCOLVERSION = 1;
    public static final String VERSION = "3.4.0";
    /* renamed from: a */
    static Boolean f24839a = Boolean.valueOf(true);
    /* renamed from: b */
    private static final List f24840b = Collections.emptyList();
    /* renamed from: c */
    private static final Pattern f24841c = Pattern.compile("^((?!^distinct_id$|^original_id$|^time$|^properties$|^id$|^first_id$|^second_id$|^users$|^events$|^event$|^user_id$|^date$|^datetime$)[a-zA-Z_$][a-zA-Z\\d_$]{0,9999})$", 2);
    /* renamed from: d */
    private static final Map f24842d = new WeakHashMap();
    /* renamed from: e */
    private static final Map f24843e = new WeakHashMap();
    /* renamed from: f */
    private static String f24844f;
    /* renamed from: g */
    private static String f24845g;
    /* renamed from: u */
    private static final SimpleDateFormat f24846u = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    /* renamed from: h */
    private final DebugMode f24847h;
    /* renamed from: i */
    private int f24848i;
    /* renamed from: j */
    private int f24849j;
    /* access modifiers changed from: private */
    /* renamed from: k */
    public boolean f24850k;
    /* renamed from: l */
    private boolean f24851l;
    /* renamed from: m */
    private String f24852m;
    /* renamed from: n */
    private JSONObject f24853n;
    /* access modifiers changed from: private|final */
    /* renamed from: o */
    public final Context f24854o;
    /* access modifiers changed from: private|final */
    /* renamed from: p */
    public final C7340a f24855p;
    /* renamed from: q */
    private final Map f24856q;
    /* renamed from: r */
    private final Map f24857r;
    /* access modifiers changed from: private */
    /* renamed from: s */
    public List f24858s = new ArrayList();
    /* renamed from: t */
    private final C7349ai f24859t;
    /* renamed from: v */
    private View f24860v;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.mta.track.StatisticsDataAPI$EventType */
    enum EventType {
        TRACK("track", true, false),
        TRACK_SIGNUP("track_signup", true, false),
        PROFILE_SET("profile_set", false, true),
        PROFILE_SET_ONCE("profile_set_once", false, true),
        PROFILE_UNSET("profile_unset", false, true),
        PROFILE_INCREMENT("profile_increment", false, true),
        PROFILE_APPEND("profile_append", false, true),
        PROFILE_DELETE("profile_delete", false, true),
        REGISTER_SUPER_PROPERTIES("register_super_properties", false, false);
        
        private String eventType;
        private boolean profile;
        private boolean track;

        private EventType(String str, boolean z, boolean z2) {
            this.eventType = str;
            this.track = z;
            this.profile = z2;
        }

        /* renamed from: a */
        public String mo35831a() {
            return this.eventType;
        }

        /* renamed from: b */
        public boolean mo35832b() {
            return this.track;
        }

        /* renamed from: c */
        public boolean mo35833c() {
            return this.profile;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00ed A[Catch:{ NameNotFoundException -> 0x01dd }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01cd  */
    StatisticsDataAPI(android.content.Context r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, com.tencent.mta.track.DebugMode r9) {
        /*
        r4 = this;
        r4.<init>()
        android.content.Context r0 = r5.getApplicationContext()
        r4.f24854o = r0
        android.content.Context r0 = r5.getApplicationContext()
        java.lang.String r0 = r0.getPackageName()
        java.util.Map r1 = f24843e
        java.lang.String r2 = "中国移动"
        java.lang.String r3 = "46000"
        r1.put(r3, r2)
        java.util.Map r1 = f24843e
        java.lang.String r3 = "46002"
        r1.put(r3, r2)
        java.util.Map r1 = f24843e
        java.lang.String r3 = "46007"
        r1.put(r3, r2)
        java.util.Map r1 = f24843e
        java.lang.String r3 = "46008"
        r1.put(r3, r2)
        java.util.Map r1 = f24843e
        java.lang.String r2 = "中国联通"
        java.lang.String r3 = "46001"
        r1.put(r3, r2)
        java.util.Map r1 = f24843e
        java.lang.String r3 = "46006"
        r1.put(r3, r2)
        java.util.Map r1 = f24843e
        java.lang.String r3 = "46009"
        r1.put(r3, r2)
        java.util.Map r1 = f24843e
        java.lang.String r2 = "中国电信"
        java.lang.String r3 = "46003"
        r1.put(r3, r2)
        java.util.Map r1 = f24843e
        java.lang.String r3 = "46005"
        r1.put(r3, r2)
        java.util.Map r1 = f24843e
        java.lang.String r3 = "46011"
        r1.put(r3, r2)
        java.util.ArrayList r1 = new java.util.ArrayList
        r1.<init>()
        r4.f24858s = r1
        android.content.Context r1 = r4.f24854o     // Catch:{ Exception -> 0x006a }
        com.tencent.mta.track.util.C7468g.m32340a(r1)     // Catch:{ Exception -> 0x006a }
        goto L_0x006e
    L_0x006a:
        r1 = move-exception
        r1.printStackTrace()
    L_0x006e:
        android.content.Context r1 = r5.getApplicationContext()     // Catch:{ NameNotFoundException -> 0x01dd }
        android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch:{ NameNotFoundException -> 0x01dd }
        r2 = 128(0x80, float:1.794E-43)
        android.content.pm.ApplicationInfo r1 = r1.getApplicationInfo(r0, r2)     // Catch:{ NameNotFoundException -> 0x01dd }
        android.os.Bundle r1 = r1.metaData     // Catch:{ NameNotFoundException -> 0x01dd }
        if (r1 != 0) goto L_0x0085
        android.os.Bundle r1 = new android.os.Bundle     // Catch:{ NameNotFoundException -> 0x01dd }
        r1.<init>()     // Catch:{ NameNotFoundException -> 0x01dd }
    L_0x0085:
        f24844f = r6     // Catch:{ NameNotFoundException -> 0x01dd }
        f24845g = r7     // Catch:{ NameNotFoundException -> 0x01dd }
        r4.f24847h = r9     // Catch:{ NameNotFoundException -> 0x01dd }
        java.lang.String r6 = "com.StatisticsData.analytics.android.EnableLogging"
        r7 = 0
        boolean r6 = r1.getBoolean(r6, r7)     // Catch:{ NameNotFoundException -> 0x01dd }
        java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ NameNotFoundException -> 0x01dd }
        f24839a = r6     // Catch:{ NameNotFoundException -> 0x01dd }
        java.lang.String r6 = "com.StatisticsData.analytics.android.FlushInterval"
        r9 = 15000(0x3a98, float:2.102E-41)
        int r6 = r1.getInt(r6, r9)     // Catch:{ NameNotFoundException -> 0x01dd }
        r4.f24848i = r6     // Catch:{ NameNotFoundException -> 0x01dd }
        java.lang.String r6 = "com.StatisticsData.analytics.android.FlushBulkSize"
        r9 = 100
        int r6 = r1.getInt(r6, r9)     // Catch:{ NameNotFoundException -> 0x01dd }
        r4.f24849j = r6     // Catch:{ NameNotFoundException -> 0x01dd }
        java.lang.String r6 = "com.StatisticsData.analytics.android.AutoTrack"
        boolean r6 = r1.getBoolean(r6, r7)     // Catch:{ NameNotFoundException -> 0x01dd }
        r4.f24850k = r6     // Catch:{ NameNotFoundException -> 0x01dd }
        java.lang.String r6 = "com.StatisticsData.analytics.android.VTrack"
        r9 = 1
        boolean r6 = r1.getBoolean(r6, r9)     // Catch:{ NameNotFoundException -> 0x01dd }
        r4.f24851l = r6     // Catch:{ NameNotFoundException -> 0x01dd }
        int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ NameNotFoundException -> 0x01dd }
        r9 = 16
        java.lang.String r2 = "StatisticsDataAPI"
        if (r6 < r9) goto L_0x00df
        boolean r6 = r4.f24851l     // Catch:{ NameNotFoundException -> 0x01dd }
        if (r6 == 0) goto L_0x00df
        java.lang.String r6 = "com.StatisticsData.analytics.android.ResourcePackageName"
        java.lang.String r6 = r1.getString(r6)     // Catch:{ NameNotFoundException -> 0x01dd }
        if (r6 != 0) goto L_0x00d5
        java.lang.String r6 = r5.getPackageName()     // Catch:{ NameNotFoundException -> 0x01dd }
    L_0x00d5:
        com.tencent.mta.track.aj r9 = new com.tencent.mta.track.aj     // Catch:{ NameNotFoundException -> 0x01dd }
        android.content.Context r1 = r4.f24854o     // Catch:{ NameNotFoundException -> 0x01dd }
        r9.m53104init(r1, r6)     // Catch:{ NameNotFoundException -> 0x01dd }
        r4.f24859t = r9     // Catch:{ NameNotFoundException -> 0x01dd }
        goto L_0x00eb
    L_0x00df:
        java.lang.String r6 = "VTrack is not supported on this Android OS Version"
        android.util.Log.i(r2, r6)     // Catch:{ NameNotFoundException -> 0x01dd }
        com.tencent.mta.track.ag r6 = new com.tencent.mta.track.ag     // Catch:{ NameNotFoundException -> 0x01dd }
        r6.m53101init(r4)     // Catch:{ NameNotFoundException -> 0x01dd }
        r4.f24859t = r6     // Catch:{ NameNotFoundException -> 0x01dd }
    L_0x00eb:
        if (r8 == 0) goto L_0x00f2
        com.tencent.mta.track.ai r6 = r4.f24859t     // Catch:{ NameNotFoundException -> 0x01dd }
        r6.mo35857a(r8)     // Catch:{ NameNotFoundException -> 0x01dd }
    L_0x00f2:
        int r6 = android.os.Build.VERSION.SDK_INT
        r8 = 14
        if (r6 < r8) goto L_0x0106
        android.content.Context r6 = r5.getApplicationContext()
        android.app.Application r6 = (android.app.Application) r6
        com.tencent.mta.track.af r8 = new com.tencent.mta.track.af
        r8.m53100init(r4)
        r6.registerActivityLifecycleCallbacks(r8)
    L_0x0106:
        java.util.HashMap r6 = new java.util.HashMap
        r6.<init>()
        java.lang.String r8 = "Android"
        java.lang.String r9 = "lib"
        r6.put(r9, r8)
        java.lang.String r9 = "lib_version"
        java.lang.String r1 = "3.4.0"
        r6.put(r9, r1)
        java.lang.String r9 = "os"
        r6.put(r9, r8)
        java.lang.String r8 = android.os.Build.VERSION.RELEASE
        java.lang.String r9 = "UNKNOWN"
        if (r8 != 0) goto L_0x0126
        r8 = r9
        goto L_0x0128
    L_0x0126:
        java.lang.String r8 = android.os.Build.VERSION.RELEASE
    L_0x0128:
        java.lang.String r1 = "os_version"
        r6.put(r1, r8)
        java.lang.String r8 = android.os.Build.MANUFACTURER
        if (r8 != 0) goto L_0x0133
        r8 = r9
        goto L_0x0135
    L_0x0133:
        java.lang.String r8 = android.os.Build.MANUFACTURER
    L_0x0135:
        java.lang.String r1 = "manufacturer"
        r6.put(r1, r8)
        java.lang.String r8 = android.os.Build.MODEL
        if (r8 != 0) goto L_0x013f
        goto L_0x0141
    L_0x013f:
        java.lang.String r9 = android.os.Build.MODEL
    L_0x0141:
        java.lang.String r8 = "model"
        r6.put(r8, r9)
        android.content.Context r8 = r4.f24854o     // Catch:{ Exception -> 0x015e }
        android.content.pm.PackageManager r8 = r8.getPackageManager()     // Catch:{ Exception -> 0x015e }
        android.content.Context r9 = r4.f24854o     // Catch:{ Exception -> 0x015e }
        java.lang.String r9 = r9.getPackageName()     // Catch:{ Exception -> 0x015e }
        android.content.pm.PackageInfo r7 = r8.getPackageInfo(r9, r7)     // Catch:{ Exception -> 0x015e }
        java.lang.String r8 = "app_version"
        java.lang.String r7 = r7.versionName     // Catch:{ Exception -> 0x015e }
        r6.put(r8, r7)     // Catch:{ Exception -> 0x015e }
        goto L_0x0164
    L_0x015e:
        r7 = move-exception
        java.lang.String r8 = "Exception getting app version name"
        android.util.Log.e(r2, r8, r7)
    L_0x0164:
        android.content.res.Resources r5 = r5.getResources()
        android.util.DisplayMetrics r5 = r5.getDisplayMetrics()
        int r7 = r5.heightPixels
        java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
        java.lang.String r8 = "screen_height"
        r6.put(r8, r7)
        int r5 = r5.widthPixels
        java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
        java.lang.String r7 = "screen_width"
        r6.put(r7, r5)
        android.content.Context r5 = r4.f24854o
        java.lang.String r7 = "phone"
        java.lang.Object r5 = r5.getSystemService(r7)
        android.telephony.TelephonyManager r5 = (android.telephony.TelephonyManager) r5
        java.lang.String r5 = r5.getSimOperator()
        boolean r7 = android.text.TextUtils.isEmpty(r5)
        if (r7 != 0) goto L_0x01af
        java.util.Map r7 = f24843e
        boolean r7 = r7.containsKey(r5)
        java.lang.String r8 = "carrier"
        if (r7 == 0) goto L_0x01aa
        java.util.Map r7 = f24843e
        java.lang.Object r5 = r7.get(r5)
        r6.put(r8, r5)
        goto L_0x01af
    L_0x01aa:
        java.lang.String r5 = "其他"
        r6.put(r8, r5)
    L_0x01af:
        java.util.Map r5 = java.util.Collections.unmodifiableMap(r6)
        r4.f24856q = r5
        java.util.HashMap r5 = new java.util.HashMap
        r5.<init>()
        r4.f24857r = r5
        android.content.Context r5 = r4.f24854o
        com.tencent.mta.track.a r5 = com.tencent.mta.track.C7340a.m31664a(r5, r0)
        r4.f24855p = r5
        com.tencent.mta.track.ai r5 = r4.f24859t
        r5.mo35856a()
        boolean r5 = r4.f24851l
        if (r5 == 0) goto L_0x01d9
        com.tencent.mta.track.a r5 = r4.f24855p
        com.tencent.mta.track.h r6 = new com.tencent.mta.track.h
        com.tencent.mta.track.ai r7 = r4.f24859t
        r6.m53130init(r7)
        r5.mo35835a(r6)
    L_0x01d9:
        r4.enableAutoTrack()
        return
    L_0x01dd:
        r5 = move-exception
        java.lang.RuntimeException r6 = new java.lang.RuntimeException
        java.lang.StringBuilder r7 = new java.lang.StringBuilder
        r7.<init>()
        java.lang.String r8 = "Can't configure StatisticsDataAPI with package name "
        r7.append(r8)
        r7.append(r0)
        java.lang.String r7 = r7.toString()
        r6.<init>(r7, r5)
        throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mta.track.StatisticsDataAPI.m53092init(android.content.Context, java.lang.String, java.lang.String, java.lang.String, com.tencent.mta.track.DebugMode):void");
    }

    public void checkConfig() {
        C7349ai aiVar;
        try {
            Bundle bundle = this.f24854o.getApplicationContext().getPackageManager().getApplicationInfo(this.f24854o.getApplicationContext().getPackageName(), 128).metaData;
            if (bundle == null) {
                bundle = new Bundle();
            }
            if (VERSION.SDK_INT < 16 || !this.f24851l) {
                Log.i("StatisticsDataAPI", "VTrack is not supported on this Android OS Version");
                aiVar = new C7347ag(this);
            } else {
                String string = bundle.getString("com.StatisticsData.analytics.android.ResourcePackageName");
                if (string == null) {
                    string = this.f24854o.getPackageName();
                }
                aiVar = new C7350aj(this.f24854o, string);
            }
            this.f24855p.mo35835a(new C7377h(aiVar));
        } catch (Throwable unused) {
        }
    }

    public static StatisticsDataAPI sharedInstance(Context context) {
        StatisticsDataAPI statisticsDataAPI;
        if (context == null) {
            return null;
        }
        synchronized (f24842d) {
            statisticsDataAPI = (StatisticsDataAPI) f24842d.get(context.getApplicationContext());
            if (statisticsDataAPI == null) {
                Log.e("StatisticsDataAPI", "The static method sharedInstance(context, serverURL, configureURL, vtrackServerURL, debugMode) should be called before calling sharedInstance()");
            }
        }
        return statisticsDataAPI;
    }

    public static StatisticsDataAPI sharedInstance(Context context, String str, String str2, DebugMode debugMode) {
        StatisticsDataAPI statisticsDataAPI;
        if (context == null) {
            return null;
        }
        synchronized (f24842d) {
            Context applicationContext = context.getApplicationContext();
            statisticsDataAPI = (StatisticsDataAPI) f24842d.get(applicationContext);
            if (statisticsDataAPI == null && C7374e.m31790a(applicationContext)) {
                statisticsDataAPI = new StatisticsDataAPI(context, str, str2, null, debugMode);
                f24842d.put(applicationContext, statisticsDataAPI);
            }
        }
        return statisticsDataAPI;
    }

    public static StatisticsDataAPI instance(Context context) {
        StatisticsDataAPI statisticsDataAPI;
        if (context == null) {
            return null;
        }
        synchronized (f24842d) {
            Context applicationContext = context.getApplicationContext();
            statisticsDataAPI = (StatisticsDataAPI) f24842d.get(applicationContext);
            f24844f = "track.mta.qq.com";
            f24845g = "cloudconfig.mta.qq.com";
            DebugMode debugMode = DebugMode.DEBUG_OFF;
            if (statisticsDataAPI == null && C7374e.m31790a(applicationContext)) {
                statisticsDataAPI = new StatisticsDataAPI(context, f24844f, f24845g, null, debugMode);
                f24842d.put(applicationContext, statisticsDataAPI);
            }
        }
        return statisticsDataAPI;
    }

    public static StatisticsDataAPI instance(Context context, DebugMode debugMode) {
        StatisticsDataAPI statisticsDataAPI;
        if (context == null) {
            return null;
        }
        synchronized (f24842d) {
            Context applicationContext = context.getApplicationContext();
            statisticsDataAPI = (StatisticsDataAPI) f24842d.get(applicationContext);
            f24844f = "track.mta.qq.com";
            f24845g = "cloudconfig.mta.qq.com";
            if (statisticsDataAPI == null && C7374e.m31790a(applicationContext)) {
                statisticsDataAPI = new StatisticsDataAPI(context, f24844f, f24845g, null, debugMode);
                f24842d.put(applicationContext, statisticsDataAPI);
            }
        }
        return statisticsDataAPI;
    }

    public static StatisticsDataAPI sharedInstance(Context context, String str, String str2, String str3, DebugMode debugMode) {
        StatisticsDataAPI statisticsDataAPI;
        if (context == null) {
            return null;
        }
        synchronized (f24842d) {
            Context applicationContext = context.getApplicationContext();
            statisticsDataAPI = (StatisticsDataAPI) f24842d.get(applicationContext);
            if (statisticsDataAPI == null && C7374e.m31790a(applicationContext)) {
                StatisticsDataAPI statisticsDataAPI2 = new StatisticsDataAPI(applicationContext, str, str2, str3, debugMode);
                f24842d.put(applicationContext, statisticsDataAPI2);
                statisticsDataAPI = statisticsDataAPI2;
            }
        }
        return statisticsDataAPI;
    }

    public int getFlushInterval() {
        return this.f24848i;
    }

    public void setFlushInterval(int i) {
        this.f24848i = i;
    }

    public int getFlushBulkSize() {
        return this.f24849j;
    }

    public void setFlushBulkSize(int i) {
        this.f24849j = i;
    }

    public void enableEditingVTrack() {
        this.f24859t.mo35860b();
    }

    public void disableActivityForVTrack(String str) {
        if (str != null) {
            this.f24859t.mo35861b(str);
        }
    }

    public void enableAutoTrack() {
        this.f24850k = true;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<java.lang.String>, for r3v0, types: [java.util.List, java.util.List<java.lang.String>] */
    public void filterAutoTrackActivities(java.util.List<java.lang.String> r3) {
        /*
        r2 = this;
        if (r3 == 0) goto L_0x0038
        int r0 = r3.size()
        if (r0 != 0) goto L_0x0009
        goto L_0x0038
    L_0x0009:
        java.util.List r0 = r2.f24858s
        if (r0 != 0) goto L_0x0014
        java.util.ArrayList r0 = new java.util.ArrayList
        r0.<init>()
        r2.f24858s = r0
    L_0x0014:
        java.util.Iterator r3 = r3.iterator()
    L_0x0018:
        boolean r0 = r3.hasNext()
        if (r0 == 0) goto L_0x0038
        java.lang.Object r0 = r3.next()
        java.lang.String r0 = (java.lang.String) r0
        boolean r1 = android.text.TextUtils.isEmpty(r0)
        if (r1 != 0) goto L_0x0018
        java.util.List r1 = r2.f24858s
        boolean r1 = r1.contains(r0)
        if (r1 != 0) goto L_0x0018
        java.util.List r1 = r2.f24858s
        r1.add(r0)
        goto L_0x0018
    L_0x0038:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mta.track.StatisticsDataAPI.filterAutoTrackActivities(java.util.List):void");
    }

    public void track(String str, JSONObject jSONObject) {
        m31648a(EventType.TRACK, str, jSONObject, null);
    }

    public void track(String str) {
        m31648a(EventType.TRACK, str, null, null);
    }

    public void trackTimer(String str, TimeUnit timeUnit) {
        m31650a(str);
        synchronized (this.f24857r) {
            this.f24857r.put(str, new C7345ae(timeUnit));
        }
    }

    public void clearTrackTimer() {
        synchronized (this.f24857r) {
            this.f24857r.clear();
        }
    }

    public String getLastScreenUrl() {
        return this.f24852m;
    }

    public JSONObject getLastScreenTrackProperties() {
        return this.f24853n;
    }

    public void trackViewScreen(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str) || jSONObject != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                this.f24853n = jSONObject;
                if (!TextUtils.isEmpty(this.f24852m)) {
                    jSONObject2.put("referrer", this.f24852m);
                }
                jSONObject2.put("url", str);
                this.f24852m = str;
                if (jSONObject != null) {
                    m31654b(jSONObject, jSONObject2);
                }
                track("AppViewScreen", jSONObject2);
            } catch (JSONException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("trackViewScreen:");
                sb.append(e);
                Log.w("StatisticsDataAPI", sb.toString());
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo35809a() {
        synchronized (this.f24857r) {
            try {
                for (Entry entry : this.f24857r.entrySet()) {
                    if (entry != null) {
                        C7345ae aeVar = (C7345ae) entry.getValue();
                        if (aeVar != null) {
                            aeVar.mo35847b((aeVar.mo35848c() + System.currentTimeMillis()) - aeVar.mo35846b());
                            aeVar.mo35845a(System.currentTimeMillis());
                        }
                    }
                }
            } catch (Exception e) {
                String str = "StatisticsDataAPI";
                StringBuilder sb = new StringBuilder();
                sb.append("appEnterBackground error:");
                sb.append(e.getMessage());
                Log.i(str, sb.toString());
            }
        }
    }

    public void flush() {
        this.f24855p.mo35834a();
    }

    public boolean isDebugMode() {
        return this.f24847h.mo35806a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String mo35811b() {
        return f24844f;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public String mo35812c() {
        return f24845g;
    }

    /* renamed from: a */
    private void m31648a(EventType eventType, String str, JSONObject jSONObject, String str2) {
        C7345ae aeVar;
        JSONObject jSONObject2;
        m31649a(eventType, jSONObject);
        long currentTimeMillis = System.currentTimeMillis();
        if (str != null) {
            synchronized (this.f24857r) {
                aeVar = (C7345ae) this.f24857r.get(str);
                this.f24857r.remove(str);
            }
        } else {
            aeVar = null;
        }
        try {
            if (eventType.mo35832b()) {
                jSONObject2 = new JSONObject(this.f24856q);
                String f = C7468g.m32346f(this.f24854o);
                jSONObject2.put("wifi", f.equals("WIFI"));
                jSONObject2.put("network_type", f);
            } else if (eventType.mo35833c()) {
                jSONObject2 = new JSONObject();
            } else {
                return;
            }
            if (jSONObject != null) {
                m31654b(jSONObject, jSONObject2);
            }
            if (aeVar != null) {
                jSONObject2.put("event_duration", aeVar.mo35844a());
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("lib", "Android");
            jSONObject3.put("lib_version", VERSION);
            if (this.f24856q.containsKey("app_version")) {
                jSONObject3.put("app_version", this.f24856q.get("app_version"));
            }
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("time", currentTimeMillis);
            jSONObject4.put("type", eventType.mo35831a());
            jSONObject4.put("properties", jSONObject2);
            jSONObject4.put("lib", jSONObject3);
            if (eventType == EventType.TRACK) {
                jSONObject4.put(NotificationCompat.CATEGORY_EVENT, str);
            } else if (eventType == EventType.TRACK_SIGNUP) {
                jSONObject4.put(NotificationCompat.CATEGORY_EVENT, str);
                jSONObject4.put("original_id", str2);
            }
            JSONObject jSONObject5 = new JSONObject();
            boolean optBoolean = jSONObject2.optBoolean("binding_depolyed", true);
            if (jSONObject2.has("binding_depolyed")) {
                jSONObject3.put("lib_method", "vtrack");
                jSONObject3.put("lib_detail", jSONObject2.get("binding_trigger_id").toString());
                jSONObject4.put("parameter", jSONObject5);
                if (this.f24859t instanceof C7376g) {
                    ((C7376g) this.f24859t).mo35859a(new JSONObject(jSONObject4.toString()));
                }
                jSONObject2.remove("binding_path");
                jSONObject2.remove("binding_depolyed");
                jSONObject2.remove("binding_trigger_id");
            } else {
                jSONObject3.put("lib_method", "code");
                StackTraceElement[] stackTrace = new Exception().getStackTrace();
                if (stackTrace.length > 2) {
                    StackTraceElement stackTraceElement = stackTrace[2];
                    jSONObject3.put("lib_detail", String.format("%s##%s##%s##%s", new Object[]{stackTraceElement.getClassName(), stackTraceElement.getMethodName(), stackTraceElement.getFileName(), Integer.valueOf(stackTraceElement.getLineNumber())}));
                }
            }
            if (optBoolean && !JSONObject.NULL.equals(jSONObject2) && jSONObject2.has("binding_event_id")) {
                String str3 = (String) jSONObject2.get("binding_event_id");
                if (jSONObject5.length() > 0) {
                    Iterator keys = jSONObject5.keys();
                    Properties properties = new Properties();
                    while (keys.hasNext()) {
                        String str4 = (String) keys.next();
                        properties.put(str4, jSONObject5.getString(str4));
                    }
                    StatService.trackCustomKVEvent(this.f24854o, str3, properties);
                    return;
                }
                StatService.trackCustomKVEvent(this.f24854o, str3, null);
            }
        } catch (JSONException unused) {
            throw new InvalidDataException("Unexpteced property");
        } catch (Throwable unused2) {
        }
    }

    /* renamed from: a */
    private void m31649a(EventType eventType, JSONObject jSONObject) {
        String str = "']";
        if (jSONObject != null) {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                try {
                    Object obj = jSONObject.get(str2);
                    String str3 = "', value='";
                    if (!(obj instanceof String)) {
                        if (!(obj instanceof Number) && !(obj instanceof JSONArray) && !(obj instanceof Boolean)) {
                            if (!(obj instanceof Date)) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("The property value must be an instance of String/Number/Boolean/JSONArray. [key='");
                                sb.append(str2);
                                sb.append(str3);
                                sb.append(obj.toString());
                                sb.append(str);
                                throw new InvalidDataException(sb.toString());
                            }
                        }
                    }
                    if ((obj instanceof String) && !str2.startsWith("$") && ((String) obj).length() > 8191) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("The property value is too long. [key='");
                        sb2.append(str2);
                        sb2.append(str3);
                        sb2.append(obj.toString());
                        sb2.append(str);
                        Log.e("StatisticsDataAPI", sb2.toString());
                    }
                } catch (JSONException unused) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Unexpected property key. [key='");
                    sb3.append(str2);
                    sb3.append(str);
                    throw new InvalidDataException(sb3.toString());
                }
            }
        }
    }

    /* renamed from: a */
    private void m31650a(String str) {
        if (str == null || str.length() < 1) {
            throw new InvalidDataException("The key is empty.");
        } else if (!f24841c.matcher(str).matches()) {
            StringBuilder sb = new StringBuilder();
            sb.append("The key '");
            sb.append(str);
            sb.append("' is invalid.");
            throw new InvalidDataException(sb.toString());
        }
    }

    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static void m31654b(JSONObject jSONObject, JSONObject jSONObject2) {
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object obj = jSONObject.get(str);
            if (obj instanceof Date) {
                synchronized (f24846u) {
                    jSONObject2.put(str, f24846u.format((Date) obj));
                }
            } else {
                jSONObject2.put(str, obj);
            }
        }
    }

    public void accumulate(View view) {
        this.f24860v = view;
    }
}
