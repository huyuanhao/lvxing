package com.tencent.stat;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.tencent.bugly.BuglyStrategy.C7120a;
import com.tencent.mid.sotrage.StorageInterface;
import com.tencent.stat.StatConfig.CurrencyType;
import com.tencent.stat.StatMultiAccount.AccountStatus;
import com.tencent.stat.StatMultiAccount.AccountType;
import com.tencent.stat.app.api.AppInstallSourceMrg;
import com.tencent.stat.common.C7592a;
import com.tencent.stat.common.C7595b;
import com.tencent.stat.common.C7596c;
import com.tencent.stat.common.DeviceInfo;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatConstants;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.common.StatPreferences;
import com.tencent.stat.common.Util;
import com.tencent.stat.event.C7624a;
import com.tencent.stat.event.C7625b;
import com.tencent.stat.event.C7626c;
import com.tencent.stat.event.C7626c.C7627a;
import com.tencent.stat.event.C7628d;
import com.tencent.stat.event.C7629e;
import com.tencent.stat.event.C7630f;
import com.tencent.stat.event.C7631g;
import com.tencent.stat.event.C7632h;
import com.tencent.stat.event.C7633i;
import com.tencent.stat.event.C7634j;
import com.tencent.stat.event.C7635k;
import com.tencent.stat.event.C7636l;
import com.tencent.stat.event.C7638m;
import com.tencent.stat.event.C7640n;
import com.tencent.stat.event.Event;
import com.tencent.stat.event.EventType;
import com.tencent.stat.lifecycle.MtaActivityLifeCycle;
import com.tencent.stat.lifecycle.MtaActivityLifecycleCallback;
import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StatServiceImpl {
    /* access modifiers changed from: private|static */
    /* renamed from: A */
    public static List<StatActionListener> f25425A = new CopyOnWriteArrayList();
    /* access modifiers changed from: private|static|volatile */
    /* renamed from: B */
    public static volatile Runnable f25426B = null;
    /* access modifiers changed from: private|static|volatile */
    /* renamed from: C */
    public static volatile long f25427C = -1;
    /* renamed from: D */
    private static StatSpecifyReportedInfo f25428D = null;
    /* access modifiers changed from: private|static */
    /* renamed from: E */
    public static Map<AccountType, StatMultiAccount> f25429E = new ConcurrentHashMap();
    /* renamed from: a */
    static List<String> f25430a = new ArrayList();
    /* renamed from: b */
    static volatile int f25431b = 0;
    /* renamed from: c */
    static volatile long f25432c = 0;
    /* renamed from: d */
    static volatile long f25433d = 0;
    /* renamed from: e */
    private static Handler f25434e;
    /* access modifiers changed from: private|static|volatile */
    /* renamed from: f */
    public static volatile Map<C7627a, Long> f25435f = new ConcurrentHashMap();
    /* renamed from: g */
    private static volatile Map<String, Properties> f25436g = new ConcurrentHashMap();
    /* access modifiers changed from: private|static|volatile */
    /* renamed from: h */
    public static volatile Map<Integer, Integer> f25437h = new ConcurrentHashMap(10);
    /* renamed from: i */
    private static volatile long f25438i = 0;
    /* access modifiers changed from: private|static|volatile */
    /* renamed from: j */
    public static volatile long f25439j = 0;
    /* renamed from: k */
    private static volatile long f25440k = 0;
    /* renamed from: l */
    private static String f25441l;
    /* access modifiers changed from: private|static|volatile */
    /* renamed from: m */
    public static volatile int f25442m = 0;
    /* access modifiers changed from: private|static|volatile */
    /* renamed from: n */
    public static volatile String f25443n;
    /* access modifiers changed from: private|static|volatile */
    /* renamed from: o */
    public static volatile String f25444o;
    /* access modifiers changed from: private|static */
    /* renamed from: p */
    public static Map<String, Long> f25445p = new ConcurrentHashMap();
    /* renamed from: q */
    private static Map<String, Long> f25446q = new ConcurrentHashMap();
    /* access modifiers changed from: private|static */
    /* renamed from: r */
    public static StatLogger f25447r = StatCommonHelper.getLogger();
    /* renamed from: s */
    private static volatile boolean f25448s = true;
    /* access modifiers changed from: private|static */
    /* renamed from: t */
    public static Context f25449t = null;
    /* renamed from: u */
    private static long f25450u = 0;
    /* access modifiers changed from: private|static */
    /* renamed from: v */
    public static long f25451v = 0;
    /* renamed from: w */
    private static volatile boolean f25452w = false;
    /* access modifiers changed from: private|static|volatile */
    /* renamed from: x */
    public static volatile boolean f25453x = false;
    /* access modifiers changed from: private|static|volatile */
    /* renamed from: y */
    public static volatile boolean f25454y = true;
    /* access modifiers changed from: private|static */
    /* renamed from: z */
    public static Handler f25455z = null;

    /* renamed from: com.tencent.stat.StatServiceImpl$a */
    static class C7570a implements Runnable {
        /* renamed from: a */
        private Context f25562a = null;

        public C7570a(Context context) {
            this.f25562a = context;
        }

        public void run() {
            Iterator it = StatNativeCrashReport.getCrashEventsFilesList(this.f25562a).iterator();
            while (it.hasNext()) {
                final File file = (File) it.next();
                if (StatConfig.isDebugEnable() && NetworkManager.getInstance(StatServiceImpl.f25449t).isNetworkAvailable()) {
                    if (!StatServiceImpl.m32633a(file)) {
                        C7608d.m32797b(StatServiceImpl.f25449t).mo37129a(C7595b.m32752a(this.f25562a, file.getAbsolutePath()), (StatDispatchCallback) new StatDispatchCallback() {
                            public void onDispatchSuccess() {
                                file.delete();
                                StatServiceImpl.m32652c(file);
                            }

                            public void onDispatchFailure() {
                                StatServiceImpl.m32655d(file);
                            }
                        });
                    }
                }
            }
        }
    }

    /* renamed from: com.tencent.stat.StatServiceImpl$b */
    static class C7572b implements Runnable {
        /* renamed from: a */
        private Context f25565a = null;
        /* renamed from: b */
        private Map<String, Integer> f25566b = null;
        /* renamed from: c */
        private StatSpecifyReportedInfo f25567c = null;

        public C7572b(Context context, Map<String, Integer> map, StatSpecifyReportedInfo statSpecifyReportedInfo) {
            this.f25565a = context;
            this.f25567c = statSpecifyReportedInfo;
            if (map != null) {
                this.f25566b = map;
            }
        }

        /* renamed from: a */
        private Map<String, Integer> m32679a() {
            HashMap hashMap = new HashMap();
            String sDKProperty = StatConfig.getSDKProperty("__MTA_TEST_SPEED__", null);
            if (!(sDKProperty == null || sDKProperty.trim().length() == 0)) {
                for (String split : sDKProperty.split(";")) {
                    String[] split2 = split.split(StorageInterface.KEY_SPLITER);
                    if (split2 != null && split2.length == 2) {
                        String str = split2[0];
                        if (!(str == null || str.trim().length() == 0)) {
                            try {
                                hashMap.put(str, Integer.valueOf(Integer.valueOf(split2[1]).intValue()));
                            } catch (NumberFormatException e) {
                                StatServiceImpl.f25447r.mo37104e((Throwable) e);
                            }
                        }
                    }
                }
            }
            return hashMap;
        }

        public void run() {
            try {
                if (this.f25566b == null) {
                    this.f25566b = m32679a();
                }
                if (this.f25566b != null) {
                    if (this.f25566b.size() != 0) {
                        JSONArray jSONArray = new JSONArray();
                        for (Entry entry : this.f25566b.entrySet()) {
                            String str = (String) entry.getKey();
                            if (str != null) {
                                if (str.length() != 0) {
                                    if (((Integer) entry.getValue()) == null) {
                                        StatLogger e = StatServiceImpl.f25447r;
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("port is null for ");
                                        sb.append(str);
                                        e.mo37116w(sb.toString());
                                    } else {
                                        jSONArray.put(m32678a((String) entry.getKey(), ((Integer) entry.getValue()).intValue()).toJSONObject());
                                    }
                                }
                            }
                            StatServiceImpl.f25447r.mo37116w("empty domain name.");
                        }
                        if (jSONArray.length() != 0) {
                            C7633i iVar = new C7633i(this.f25565a, StatServiceImpl.getSessionID(this.f25565a, false, this.f25567c), this.f25567c);
                            iVar.mo37192a(jSONArray.toString());
                            new C7573c(iVar).mo37064a();
                            return;
                        }
                        return;
                    }
                }
                StatServiceImpl.f25447r.mo37108i("empty domain list.");
            } catch (Throwable th) {
                StatServiceImpl.f25447r.mo37104e(th);
            }
        }

        /* renamed from: a */
        private NetworkMonitor m32678a(String str, int i) {
            int i2;
            NetworkMonitor networkMonitor = new NetworkMonitor();
            Socket socket = new Socket();
            try {
                networkMonitor.setDomain(str);
                networkMonitor.setPort(i);
                long currentTimeMillis = System.currentTimeMillis();
                InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
                socket.connect(inetSocketAddress, C7120a.MAX_USERDATA_VALUE_LENGTH);
                networkMonitor.setMillisecondsConsume(System.currentTimeMillis() - currentTimeMillis);
                networkMonitor.setRemoteIp(inetSocketAddress.getAddress().getHostAddress());
                socket.close();
                try {
                    socket.close();
                } catch (Throwable th) {
                    StatServiceImpl.f25447r.mo37104e(th);
                }
                i2 = 0;
            } catch (IOException e) {
                try {
                    StatServiceImpl.f25447r.mo37104e((Throwable) e);
                    socket.close();
                } catch (Throwable th2) {
                    StatServiceImpl.f25447r.mo37104e(th2);
                }
            } catch (Throwable th3) {
                StatServiceImpl.f25447r.mo37104e(th3);
            }
            networkMonitor.setStatusCode(i2);
            return networkMonitor;
            i2 = -1;
            networkMonitor.setStatusCode(i2);
            return networkMonitor;
            throw th;
        }
    }

    /* renamed from: com.tencent.stat.StatServiceImpl$c */
    public static class C7573c {
        /* renamed from: f */
        private static volatile long f25568f;
        /* access modifiers changed from: private */
        /* renamed from: a */
        public Event f25569a;
        /* renamed from: b */
        private StatReportStrategy f25570b = null;
        /* access modifiers changed from: private */
        /* renamed from: c */
        public boolean f25571c = false;
        /* access modifiers changed from: private */
        /* renamed from: d */
        public Context f25572d = null;
        /* renamed from: e */
        private long f25573e = System.currentTimeMillis();

        public C7573c(Event event) {
            this.f25569a = event;
            this.f25570b = StatConfig.getStatSendStrategy();
            this.f25571c = event.isImportant();
            this.f25572d = event.getContext();
        }

        /* renamed from: b */
        private void m32683b() {
            if (this.f25569a.getType() == EventType.CUSTOM) {
                String str = ((C7626c) this.f25569a).mo37182a().f25794a;
                String str2 = "eventid=";
                if (StatConfig.m32594a(str)) {
                    StatLogger e = StatServiceImpl.f25447r;
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(str);
                    sb.append(" matched, report instant.");
                    e.mo37101d(sb.toString());
                    m32686d();
                    return;
                } else if (StatConfig.isEventIdInDontReportEventIdsSet(str)) {
                    StatLogger e2 = StatServiceImpl.f25447r;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str2);
                    sb2.append(str);
                    sb2.append(" In DontReportEventIdsSet, droped.");
                    e2.mo37116w(sb2.toString());
                    return;
                }
            }
            if (this.f25569a.getStatSpecifyReportedInfo() != null && this.f25569a.getStatSpecifyReportedInfo().isSendImmediately()) {
                this.f25570b = StatReportStrategy.INSTANT;
            }
            if (StatConfig.f25365j && NetworkManager.getInstance(StatServiceImpl.f25449t).isWifi()) {
                this.f25570b = StatReportStrategy.INSTANT;
            }
            if (StatConfig.isDebugEnable()) {
                StatLogger e3 = StatServiceImpl.f25447r;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("strategy=");
                sb3.append(this.f25570b.name());
                e3.mo37108i(sb3.toString());
            }
            switch (this.f25570b) {
                case INSTANT:
                    m32684c();
                    break;
                case PERIOD:
                    C7614e.m32812a(this.f25572d).mo37146a(this.f25569a, (StatDispatchCallback) null, this.f25571c, false);
                    String str3 = ",difftime=";
                    String str4 = ",nextPeriodSendTs=";
                    String str5 = "PERIOD currTime=";
                    if (StatConfig.isDebugEnable()) {
                        StatLogger e4 = StatServiceImpl.f25447r;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(str5);
                        sb4.append(this.f25573e);
                        sb4.append(str4);
                        sb4.append(StatServiceImpl.f25433d);
                        sb4.append(str3);
                        sb4.append(StatServiceImpl.f25433d - this.f25573e);
                        e4.mo37108i(sb4.toString());
                    }
                    if (StatServiceImpl.f25433d == 0) {
                        StatServiceImpl.f25433d = StatPreferences.getLong(this.f25572d, "last_period_ts", 0);
                        if (this.f25573e > StatServiceImpl.f25433d) {
                            StatServiceImpl.m32657e(this.f25572d);
                        }
                        long sendPeriodMinutes = this.f25573e + ((long) (StatConfig.getSendPeriodMinutes() * 60 * 1000));
                        if (StatServiceImpl.f25433d > sendPeriodMinutes) {
                            StatServiceImpl.f25433d = sendPeriodMinutes;
                        }
                        C7585b.m32710a(this.f25572d).mo37090a();
                    }
                    if (StatConfig.isDebugEnable()) {
                        StatLogger e5 = StatServiceImpl.f25447r;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(str5);
                        sb5.append(this.f25573e);
                        sb5.append(str4);
                        sb5.append(StatServiceImpl.f25433d);
                        sb5.append(str3);
                        sb5.append(StatServiceImpl.f25433d - this.f25573e);
                        e5.mo37108i(sb5.toString());
                    }
                    if (this.f25573e > StatServiceImpl.f25433d) {
                        StatServiceImpl.m32657e(this.f25572d);
                        break;
                    }
                    break;
                case APP_LAUNCH:
                case DEVELOPER:
                    C7614e.m32812a(this.f25572d).mo37146a(this.f25569a, (StatDispatchCallback) null, this.f25571c, false);
                    break;
                case BATCH:
                    C7614e.m32812a(this.f25572d).mo37146a(this.f25569a, (StatDispatchCallback) new StatDispatchCallback() {
                        public void onDispatchSuccess() {
                            StatServiceImpl.m32649c();
                            if (C7614e.m32827b().mo37143a() >= StatConfig.getMaxBatchReportCount()) {
                                C7614e.m32827b().mo37144a(StatConfig.getMaxBatchReportCount());
                            }
                        }

                        public void onDispatchFailure() {
                            StatServiceImpl.m32653d();
                        }
                    }, this.f25571c, true);
                    break;
                case ONLY_WIFI:
                    if (NetworkManager.getInstance(StatServiceImpl.f25449t).getNetworkType() != 1) {
                        C7614e.m32812a(this.f25572d).mo37146a(this.f25569a, (StatDispatchCallback) null, this.f25571c, false);
                        break;
                    } else {
                        m32684c();
                        break;
                    }
                case ONLY_WIFI_NO_CACHE:
                    if (StatCommonHelper.isWiFiActive(this.f25572d)) {
                        m32681a((StatDispatchCallback) new StatDispatchCallback() {
                            public void onDispatchSuccess() {
                                StatServiceImpl.m32649c();
                            }

                            public void onDispatchFailure() {
                                StatServiceImpl.m32653d();
                            }
                        });
                        break;
                    }
                    break;
                default:
                    StatLogger e6 = StatServiceImpl.f25447r;
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("Invalid stat strategy:");
                    sb6.append(StatConfig.getStatSendStrategy());
                    e6.error((Object) sb6.toString());
                    break;
            }
        }

        /* renamed from: c */
        private void m32684c() {
            if ((C7614e.m32827b().f25727a <= 0 || !StatConfig.f25367l) && this.f25569a.getType() != EventType.BACKGROUND) {
                m32681a((StatDispatchCallback) new StatDispatchCallback() {
                    public void onDispatchSuccess() {
                        StatServiceImpl.m32649c();
                        if (C7573c.this.f25569a.getType() == EventType.SESSION_ENV && StatCommonHelper.needReportApp(StatServiceImpl.f25449t)) {
                            StatServiceImpl.f25447r.mo37101d("OnceEvent report");
                            C7608d.m32797b(StatServiceImpl.f25449t).mo37128a((Event) new C7634j(StatServiceImpl.f25449t, StatServiceImpl.f25442m, null, C7573c.this.f25569a.getStatSpecifyReportedInfo()), (StatDispatchCallback) new StatDispatchCallback() {
                                public void onDispatchFailure() {
                                }

                                public void onDispatchSuccess() {
                                    StatCommonHelper.updateNextReportTime(StatServiceImpl.f25449t);
                                }
                            });
                        }
                        if (C7614e.m32827b().f25727a > 0) {
                            StatServiceImpl.commitEvents(C7573c.this.f25572d, -1);
                        }
                    }

                    public void onDispatchFailure() {
                        C7614e.m32827b().mo37146a(C7573c.this.f25569a, (StatDispatchCallback) null, C7573c.this.f25571c, true);
                        StatServiceImpl.m32653d();
                    }
                });
                return;
            }
            C7614e.m32827b().mo37146a(this.f25569a, (StatDispatchCallback) null, this.f25571c, true);
            C7614e.m32827b().mo37144a(-1);
        }

        /* renamed from: d */
        private void m32686d() {
            m32681a((StatDispatchCallback) new StatDispatchCallback() {
                public void onDispatchSuccess() {
                    StatServiceImpl.m32649c();
                }

                public void onDispatchFailure() {
                    C7614e.m32827b().mo37146a(C7573c.this.f25569a, (StatDispatchCallback) null, C7573c.this.f25571c, true);
                    StatServiceImpl.m32653d();
                }
            });
        }

        /* renamed from: a */
        private void m32681a(StatDispatchCallback statDispatchCallback) {
            C7608d.m32797b(StatServiceImpl.f25449t).mo37128a(this.f25569a, statDispatchCallback);
        }

        /* renamed from: e */
        private boolean m32687e() {
            if (StatConfig.f25363h > 0) {
                if (this.f25573e > StatServiceImpl.f25439j) {
                    StatServiceImpl.f25437h.clear();
                    StatServiceImpl.f25439j = this.f25573e + StatConfig.f25364i;
                    if (StatConfig.isDebugEnable()) {
                        StatLogger e = StatServiceImpl.f25447r;
                        StringBuilder sb = new StringBuilder();
                        sb.append("clear methodsCalledLimitMap, nextLimitCallClearTime=");
                        sb.append(StatServiceImpl.f25439j);
                        e.mo37108i(sb.toString());
                    }
                }
                Integer valueOf = Integer.valueOf(this.f25569a.getType().GetIntValue());
                Integer num = (Integer) StatServiceImpl.f25437h.get(valueOf);
                if (num != null) {
                    StatServiceImpl.f25437h.put(valueOf, Integer.valueOf(num.intValue() + 1));
                    if (num.intValue() > StatConfig.f25363h) {
                        if (StatConfig.isDebugEnable()) {
                            StatLogger e2 = StatServiceImpl.f25447r;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("event ");
                            sb2.append(this.f25569a.toJsonString());
                            sb2.append(" was discard, cause of called limit, current:");
                            sb2.append(num);
                            sb2.append(", limit:");
                            sb2.append(StatConfig.f25363h);
                            sb2.append(", period:");
                            sb2.append(StatConfig.f25364i);
                            sb2.append(" ms");
                            e2.mo37103e((Object) sb2.toString());
                        }
                        return true;
                    }
                } else {
                    StatServiceImpl.f25437h.put(valueOf, Integer.valueOf(1));
                }
            }
            return false;
        }

        /* renamed from: a */
        public void mo37064a() {
            if (!m32687e()) {
                if (StatConfig.f25371p != null) {
                    String jsonString = this.f25569a.toJsonString();
                    if (StatConfig.isDebugEnable()) {
                        StatLogger e = StatServiceImpl.f25447r;
                        StringBuilder sb = new StringBuilder();
                        sb.append("transfer event data:");
                        sb.append(jsonString);
                        e.mo37108i(sb.toString());
                    }
                    StatConfig.f25371p.onTransfer(jsonString);
                    return;
                }
                if (StatConfig.f25368m > 0 && this.f25573e >= f25568f) {
                    StatServiceImpl.flushDataToDB(this.f25572d);
                    f25568f = this.f25573e + StatConfig.f25369n;
                    if (StatConfig.isDebugEnable()) {
                        StatLogger e2 = StatServiceImpl.f25447r;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("nextFlushTime=");
                        sb2.append(f25568f);
                        e2.mo37108i(sb2.toString());
                    }
                }
                if (NetworkManager.getInstance(this.f25572d).isNetworkAvailable()) {
                    if (StatConfig.isDebugEnable()) {
                        StatLogger e3 = StatServiceImpl.f25447r;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("sendFailedCount=");
                        sb3.append(StatServiceImpl.f25431b);
                        e3.mo37108i(sb3.toString());
                    }
                    if (!StatServiceImpl.m32632a()) {
                        m32683b();
                    } else {
                        C7614e.m32812a(this.f25572d).mo37146a(this.f25569a, (StatDispatchCallback) null, this.f25571c, false);
                        if (this.f25573e - StatServiceImpl.f25432c > 1800000) {
                            StatServiceImpl.m32654d(this.f25572d);
                        }
                    }
                } else {
                    C7614e.m32812a(this.f25572d).mo37146a(this.f25569a, (StatDispatchCallback) null, this.f25571c, false);
                }
            }
        }
    }

    static {
        String str = "";
        f25441l = str;
        f25443n = str;
        f25444o = str;
    }

    public static long getAppStartupTime() {
        return f25450u;
    }

    public static void initAppContext(Application application) {
        if (application != null) {
            f25449t = application;
        }
    }

    public static long getFrontgroundStartupTime() {
        return f25451v;
    }

    /* renamed from: a */
    static boolean m32632a() {
        if (f25431b < 2) {
            return false;
        }
        f25432c = System.currentTimeMillis();
        return true;
    }

    public static Context getContext(Context context) {
        if (context == null) {
            return f25449t;
        }
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        return context;
    }

    public static void setContext(Context context) {
        if (context == null) {
            return;
        }
        if (context.getApplicationContext() != null) {
            f25449t = context.getApplicationContext();
        } else {
            f25449t = context;
        }
    }

    public static void testJavaCrash(Context context) {
        C7614e.m32812a(context).mo37150c();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005a, code lost:
            return;
     */
    /* renamed from: a */
    static synchronized void m32621a(android.content.Context r5) {
        /*
        java.lang.Class<com.tencent.stat.StatServiceImpl> r0 = com.tencent.stat.StatServiceImpl.class
        monitor-enter(r0)
        if (r5 != 0) goto L_0x0007
        monitor-exit(r0)
        return
    L_0x0007:
        android.os.Handler r1 = f25434e     // Catch:{ all -> 0x005b }
        if (r1 != 0) goto L_0x0059
        boolean r1 = m32645b(r5)     // Catch:{ all -> 0x005b }
        if (r1 != 0) goto L_0x0013
        monitor-exit(r0)
        return
    L_0x0013:
        long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x005b }
        f25450u = r1     // Catch:{ all -> 0x005b }
        setContext(r5)     // Catch:{ all -> 0x005b }
        android.content.Context r5 = getContext(r5)     // Catch:{ all -> 0x005b }
        android.os.HandlerThread r1 = new android.os.HandlerThread     // Catch:{ all -> 0x005b }
        java.lang.String r2 = "StatService"
        r1.<init>(r2)     // Catch:{ all -> 0x005b }
        r1.start()     // Catch:{ all -> 0x005b }
        android.os.Handler r2 = new android.os.Handler     // Catch:{ all -> 0x005b }
        android.os.Looper r1 = r1.getLooper()     // Catch:{ all -> 0x005b }
        r2.<init>(r1)     // Catch:{ all -> 0x005b }
        f25434e = r2     // Catch:{ all -> 0x005b }
        r1 = 0
        java.lang.String r1 = com.tencent.stat.common.StatCommonHelper.getDateString(r1)     // Catch:{ all -> 0x005b }
        f25441l = r1     // Catch:{ all -> 0x005b }
        long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x005b }
        long r3 = com.tencent.stat.StatConfig.f25364i     // Catch:{ all -> 0x005b }
        long r1 = r1 + r3
        f25439j = r1     // Catch:{ all -> 0x005b }
        m32677u()     // Catch:{ all -> 0x005b }
        com.tencent.stat.a r1 = com.tencent.stat.C7579a.m32689a(r5)     // Catch:{ all -> 0x005b }
        r1.mo37078a()     // Catch:{ all -> 0x005b }
        android.os.Handler r1 = f25434e     // Catch:{ all -> 0x005b }
        com.tencent.stat.StatServiceImpl$1 r2 = new com.tencent.stat.StatServiceImpl$1     // Catch:{ all -> 0x005b }
        r2.m53546init(r5)     // Catch:{ all -> 0x005b }
        r1.post(r2)     // Catch:{ all -> 0x005b }
    L_0x0059:
        monitor-exit(r0)
        return
    L_0x005b:
        r5 = move-exception
        monitor-exit(r0)
        throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.StatServiceImpl.m32621a(android.content.Context):void");
    }

    /* renamed from: t */
    private static void m32676t() {
        try {
            DeviceInfo b = C7614e.m32812a(f25449t).mo37149b(f25449t);
            if (b != null && b.getUserType() == 0) {
                AppInstallSourceMrg.getInstance(f25449t).reportInstallEvent();
            }
        } catch (Exception unused) {
        }
    }

    public static String fetchPageFlows() {
        List<String> list = f25430a;
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : f25430a) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("\n");
            stringBuffer.append(sb.toString());
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    static void m32630a(Thread thread, Throwable th) {
        Context context = f25449t;
        C7629e eVar = new C7629e(context, getSessionID(context, false, null), 2, th, thread, (StatSpecifyReportedInfo) null);
        if (eVar.toJsonString().length() <= 1048576) {
            m32629a(eVar);
            StatCrashReporter.getStatCrashReporter(f25449t).mo36963a(thread, th);
            return;
        }
        f25447r.mo37103e((Object) "Java Crash event exceeds the limit:1048576, droped.");
    }

    /* renamed from: a */
    static void m32631a(JSONArray jSONArray, Thread thread, String str) {
        Context context = f25449t;
        C7629e eVar = new C7629e(context, getSessionID(context, false, null), 3, jSONArray, thread, (StatSpecifyReportedInfo) null);
        eVar.mo37191b(str);
        StringBuilder sb = new StringBuilder();
        sb.append(StatCommonHelper.getTimeFormat(System.currentTimeMillis()));
        sb.append(".native");
        sb.append(".v1.crash");
        final String sb2 = sb.toString();
        C7595b.m32754a(f25449t, "mtajcrash", sb2, eVar.toJsonString());
        if ((StatConfig.isDebugEnable() || StatCrashReporter.getStatCrashReporter(f25449t).isEnableInstantReporting()) && NetworkManager.getInstance(f25449t).isNetworkAvailable()) {
            C7608d.m32797b(f25449t).mo37128a((Event) eVar, (StatDispatchCallback) new StatDispatchCallback() {
                public void onDispatchFailure() {
                }

                public void onDispatchSuccess() {
                    C7595b.m32753a(StatServiceImpl.f25449t, "mtajcrash", sb2);
                    StatServiceImpl.f25447r.debug("native crash has been reported.");
                }
            });
        }
        StatCrashReporter.getStatCrashReporter(f25449t).mo36962a(eVar.mo37188a());
        new File(str).delete();
    }

    /* renamed from: a */
    static void m32629a(C7629e eVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(StatCommonHelper.getTimeFormat(System.currentTimeMillis()));
        sb.append(".v1.crash");
        final String sb2 = sb.toString();
        C7595b.m32754a(f25449t, "mtajcrash", sb2, eVar.toJsonString());
        if ((StatConfig.isDebugEnable() || StatCrashReporter.getStatCrashReporter(f25449t).isEnableInstantReporting()) && NetworkManager.getInstance(f25449t).isNetworkAvailable()) {
            C7608d.m32797b(f25449t).mo37128a((Event) eVar, (StatDispatchCallback) new StatDispatchCallback() {
                public void onDispatchFailure() {
                }

                public void onDispatchSuccess() {
                    C7595b.m32753a(StatServiceImpl.f25449t, "mtajcrash", sb2);
                    StatServiceImpl.f25447r.debug("java crash has been reported.");
                }
            });
        }
    }

    /* renamed from: b */
    static void m32644b(Thread thread, Throwable th) {
        if (StatConfig.isEnableStatService()) {
            Context context = f25449t;
            if (context != null) {
                try {
                    m32625a(context, (StatSpecifyReportedInfo) null, true);
                    if (StatConfig.isAutoExceptionCaught()) {
                        m32630a(thread, th);
                        String str = "MtaSDK.CaughtExp";
                        Log.e(str, "MTA has caught the following uncaught exception:");
                        Log.e(str, "", th);
                        Log.e(str, "App uncaught exception end.");
                    } else {
                        f25447r.warn("crash happened, but MTA Auto Exception Caught Report is desable.");
                    }
                    flushDataToDB(f25449t);
                    if (StatConfig.m32606f() != null) {
                        StatConfig.m32606f().onMtaException(th);
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
    }

    /* renamed from: b */
    static boolean m32645b(Context context) {
        boolean z;
        long j = StatPreferences.getLong(context, StatConfig.f25358c, 0);
        long sDKLongVersion = StatCommonHelper.getSDKLongVersion(StatConstants.VERSION);
        boolean z2 = false;
        if (sDKLongVersion <= j) {
            StatLogger statLogger = f25447r;
            StringBuilder sb = new StringBuilder();
            sb.append("MTA is disable for current version:");
            sb.append(sDKLongVersion);
            sb.append(",wakeup version:");
            sb.append(j);
            statLogger.error((Object) sb.toString());
            z = false;
        } else {
            z = true;
        }
        long j2 = StatPreferences.getLong(context, StatConfig.f25359d, 0);
        if (j2 > System.currentTimeMillis()) {
            StatLogger statLogger2 = f25447r;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("MTA is disable for current time:");
            sb2.append(System.currentTimeMillis());
            sb2.append(",wakeup time:");
            sb2.append(j2);
            statLogger2.error((Object) sb2.toString());
        } else {
            z2 = z;
        }
        StatConfig.setEnableStatService(z2);
        return z2;
    }

    /* renamed from: a */
    static boolean m32634a(String str) {
        return str == null || str.length() == 0;
    }

    public static Handler getHandler(Context context) {
        if (f25434e == null) {
            synchronized (StatServiceImpl.class) {
                if (f25434e == null) {
                    if (context == null) {
                        try {
                            context = f25449t;
                        } catch (Throwable th) {
                            f25447r.error(th);
                            StatConfig.setEnableStatService(false);
                        }
                    }
                    m32621a(context);
                }
            }
        }
        return f25434e;
    }

    /* renamed from: b */
    static JSONObject m32639b() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            String str = "v";
            if (StatConfig.f25357b.f25390d != 0) {
                jSONObject2.put(str, StatConfig.f25357b.f25390d);
            }
            jSONObject.put(Integer.toString(StatConfig.f25357b.f25387a), jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            if (StatConfig.f25345a.f25390d != 0) {
                jSONObject3.put(str, StatConfig.f25345a.f25390d);
            }
            jSONObject.put(Integer.toString(StatConfig.f25345a.f25387a), jSONObject3);
        } catch (JSONException e) {
            f25447r.mo37104e((Throwable) e);
        }
        return jSONObject;
    }

    /* renamed from: a */
    static void m32624a(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (getHandler(context) != null) {
            if (StatConfig.isDebugEnable()) {
                f25447r.mo37101d("start new session.");
            }
            if (statSpecifyReportedInfo == null || f25442m == 0) {
                f25442m = StatCommonHelper.getNextSessionID();
            }
            StatConfig.m32586a(0);
            StatConfig.m32603d();
            C7640n nVar = new C7640n(context, f25442m, m32639b(), statSpecifyReportedInfo);
            String reportedAppkey = nVar.getReportedAppkey();
            if (!StatCommonHelper.isStringValid(reportedAppkey) || !StatConfig.shouldSkipSessionReport(reportedAppkey)) {
                new C7573c(nVar).mo37064a();
                m32676t();
            } else {
                StatLogger statLogger = f25447r;
                StringBuilder sb = new StringBuilder();
                sb.append("appkey :");
                sb.append(reportedAppkey);
                sb.append(" skip session report.");
                statLogger.mo37116w(sb.toString());
            }
        }
    }

    public static int getSessionID(Context context, boolean z, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        boolean z3 = z && currentTimeMillis - f25438i >= ((long) StatConfig.getSessionTimoutMillis());
        f25438i = currentTimeMillis;
        if (f25440k == 0) {
            f25440k = StatCommonHelper.getTomorrowStartMilliseconds();
        }
        if (currentTimeMillis >= f25440k) {
            f25440k = StatCommonHelper.getTomorrowStartMilliseconds();
            if (C7614e.m32812a(context).mo37149b(context).getUserType() != 1) {
                C7614e.m32812a(context).mo37149b(context).setUserType(1);
            }
            StatConfig.m32597b(0);
            f25431b = 0;
            f25441l = StatCommonHelper.getDateString(0);
            z3 = true;
        }
        String str = f25441l;
        if (StatCommonHelper.isSpecifyReportedValid(statSpecifyReportedInfo)) {
            StringBuilder sb = new StringBuilder();
            sb.append(statSpecifyReportedInfo.getAppKey());
            sb.append(f25441l);
            str = sb.toString();
        }
        if (!f25446q.containsKey(str)) {
            z3 = true;
        } else {
            z2 = false;
        }
        if (z3) {
            if (StatCommonHelper.isSpecifyReportedValid(statSpecifyReportedInfo)) {
                m32624a(context, statSpecifyReportedInfo);
            } else if (StatConfig.m32605e() < StatConfig.getMaxDaySessionNumbers()) {
                StatCommonHelper.checkFirstTimeActivate(context);
                m32624a(context, (StatSpecifyReportedInfo) null);
            } else {
                f25447r.mo37103e((Object) "Exceed StatConfig.getMaxDaySessionNumbers().");
            }
        }
        if (f25448s || z2) {
            f25446q.put(str, Long.valueOf(1));
            m32641b(context, statSpecifyReportedInfo);
        }
        if (f25448s) {
            StatCommonHelper.isSpecifyReportedValid(statSpecifyReportedInfo);
        }
        f25448s = false;
        return f25442m;
    }

    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static void m32643b(Context context, final String str, final StatSpecifyReportedInfo statSpecifyReportedInfo) {
        final String str2 = new String(str);
        final Context applicationContext = context.getApplicationContext();
        if (getHandler(applicationContext) != null) {
            f25434e.post(new Runnable() {
                /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            com.tencent.stat.StatServiceImpl.getSessionID(r3, true, r5);
     */
                public void run() {
                    /*
                    r5 = this;
                    java.util.Map r0 = com.tencent.stat.StatServiceImpl.f25445p     // Catch:{ all -> 0x00ca }
                    monitor-enter(r0)     // Catch:{ all -> 0x00ca }
                    com.tencent.stat.common.StatLogger r1 = com.tencent.stat.StatServiceImpl.f25447r     // Catch:{ all -> 0x00c7 }
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c7 }
                    r2.<init>()     // Catch:{ all -> 0x00c7 }
                    java.lang.String r3 = "inerTrackBeginPage:"
                    r2.append(r3)     // Catch:{ all -> 0x00c7 }
                    java.lang.String r3 = r4     // Catch:{ all -> 0x00c7 }
                    r2.append(r3)     // Catch:{ all -> 0x00c7 }
                    java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00c7 }
                    r1.mo37101d(r2)     // Catch:{ all -> 0x00c7 }
                    java.util.List<java.lang.String> r1 = com.tencent.stat.StatServiceImpl.f25430a     // Catch:{ all -> 0x00c7 }
                    java.lang.String r2 = r0     // Catch:{ all -> 0x00c7 }
                    r1.add(r2)     // Catch:{ all -> 0x00c7 }
                    java.util.List<java.lang.String> r1 = com.tencent.stat.StatServiceImpl.f25430a     // Catch:{ all -> 0x00c7 }
                    int r1 = r1.size()     // Catch:{ all -> 0x00c7 }
                    r2 = 40
                    if (r1 <= r2) goto L_0x0046
                    java.util.List<java.lang.String> r1 = com.tencent.stat.StatServiceImpl.f25430a     // Catch:{ all -> 0x00c7 }
                    java.util.List<java.lang.String> r2 = com.tencent.stat.StatServiceImpl.f25430a     // Catch:{ all -> 0x00c7 }
                    int r2 = r2.size()     // Catch:{ all -> 0x00c7 }
                    int r2 = r2 + -20
                    java.util.List<java.lang.String> r3 = com.tencent.stat.StatServiceImpl.f25430a     // Catch:{ all -> 0x00c7 }
                    int r3 = r3.size()     // Catch:{ all -> 0x00c7 }
                    java.util.List r1 = r1.subList(r2, r3)     // Catch:{ all -> 0x00c7 }
                    com.tencent.stat.StatServiceImpl.f25430a = r1     // Catch:{ all -> 0x00c7 }
                L_0x0046:
                    java.util.Map r1 = com.tencent.stat.StatServiceImpl.f25445p     // Catch:{ all -> 0x00c7 }
                    int r1 = r1.size()     // Catch:{ all -> 0x00c7 }
                    int r2 = com.tencent.stat.StatConfig.getMaxParallelTimmingEvents()     // Catch:{ all -> 0x00c7 }
                    if (r1 < r2) goto L_0x0076
                    com.tencent.stat.common.StatLogger r1 = com.tencent.stat.StatServiceImpl.f25447r     // Catch:{ all -> 0x00c7 }
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c7 }
                    r2.<init>()     // Catch:{ all -> 0x00c7 }
                    java.lang.String r3 = "The number of page events exceeds the maximum value "
                    r2.append(r3)     // Catch:{ all -> 0x00c7 }
                    int r3 = com.tencent.stat.StatConfig.getMaxParallelTimmingEvents()     // Catch:{ all -> 0x00c7 }
                    java.lang.String r3 = java.lang.Integer.toString(r3)     // Catch:{ all -> 0x00c7 }
                    r2.append(r3)     // Catch:{ all -> 0x00c7 }
                    java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00c7 }
                    r1.error(r2)     // Catch:{ all -> 0x00c7 }
                    monitor-exit(r0)     // Catch:{ all -> 0x00c7 }
                    return
                L_0x0076:
                    java.lang.String r1 = r0     // Catch:{ all -> 0x00c7 }
                    com.tencent.stat.StatServiceImpl.f25443n = r1     // Catch:{ all -> 0x00c7 }
                    java.util.Map r1 = com.tencent.stat.StatServiceImpl.f25445p     // Catch:{ all -> 0x00c7 }
                    java.lang.String r2 = com.tencent.stat.StatServiceImpl.f25443n     // Catch:{ all -> 0x00c7 }
                    boolean r1 = r1.containsKey(r2)     // Catch:{ all -> 0x00c7 }
                    if (r1 == 0) goto L_0x00aa
                    com.tencent.stat.common.StatLogger r1 = com.tencent.stat.StatServiceImpl.f25447r     // Catch:{ all -> 0x00c7 }
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c7 }
                    r2.<init>()     // Catch:{ all -> 0x00c7 }
                    java.lang.String r3 = "Duplicate PageID : "
                    r2.append(r3)     // Catch:{ all -> 0x00c7 }
                    java.lang.String r3 = com.tencent.stat.StatServiceImpl.f25443n     // Catch:{ all -> 0x00c7 }
                    r2.append(r3)     // Catch:{ all -> 0x00c7 }
                    java.lang.String r3 = ", onResume() repeated?"
                    r2.append(r3)     // Catch:{ all -> 0x00c7 }
                    java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00c7 }
                    r1.warn(r2)     // Catch:{ all -> 0x00c7 }
                L_0x00aa:
                    java.util.Map r1 = com.tencent.stat.StatServiceImpl.f25445p     // Catch:{ all -> 0x00c7 }
                    java.lang.String r2 = com.tencent.stat.StatServiceImpl.f25443n     // Catch:{ all -> 0x00c7 }
                    long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00c7 }
                    java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x00c7 }
                    r1.put(r2, r3)     // Catch:{ all -> 0x00c7 }
                    monitor-exit(r0)     // Catch:{ all -> 0x00c7 }
                    android.content.Context r0 = r3     // Catch:{ all -> 0x00ca }
                    r1 = 1
                    com.tencent.stat.StatSpecifyReportedInfo r2 = r5     // Catch:{ all -> 0x00ca }
                    com.tencent.stat.StatServiceImpl.getSessionID(r0, r1, r2)     // Catch:{ all -> 0x00ca }
                    goto L_0x00d7
                L_0x00c7:
                    r1 = move-exception
                    monitor-exit(r0)     // Catch:{ all -> 0x00c7 }
                    throw r1     // Catch:{ all -> 0x00ca }
                L_0x00ca:
                    r0 = move-exception
                    com.tencent.stat.common.StatLogger r1 = com.tencent.stat.StatServiceImpl.f25447r
                    r1.mo37104e(r0)
                    android.content.Context r1 = r3
                    com.tencent.stat.StatServiceImpl.m32628a(r1, r0)
                L_0x00d7:
                    return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.StatServiceImpl.C755733.run():void");
                }
            });
        }
    }

    public static void trackBeginPage(Context context, String str, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null || str == null || str.length() == 0) {
                f25447r.error((Object) "The Context or pageName of StatService.trackBeginPage() can not be null or empty!");
            } else {
                m32643b(context2, str, statSpecifyReportedInfo);
            }
        }
    }

    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static void m32642b(Context context, String str, int i, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        final String str2 = new String(str);
        final Context contextSelf = Util.getContextSelf(context);
        if (getHandler(contextSelf) != null) {
            Handler handler = f25434e;
            final String str3 = str;
            final StatSpecifyReportedInfo statSpecifyReportedInfo2 = statSpecifyReportedInfo;
            final int i2 = i;
            C755834 r0 = new Runnable() {
                public void run() {
                    Long l;
                    try {
                        StatServiceImpl.flushDataToDB(contextSelf);
                        synchronized (StatServiceImpl.f25445p) {
                            l = (Long) StatServiceImpl.f25445p.remove(str2);
                        }
                        StatLogger e = StatServiceImpl.f25447r;
                        StringBuilder sb = new StringBuilder();
                        sb.append("inerTrackEndPage:");
                        sb.append(str3);
                        sb.append(",startTime:");
                        sb.append(l);
                        e.mo37101d(sb.toString());
                        if (l != null) {
                            double currentTimeMillis = ((double) (System.currentTimeMillis() - l.longValue())) / 1000.0d;
                            if (currentTimeMillis <= 0.0d) {
                                currentTimeMillis = 0.1d;
                            }
                            double d = currentTimeMillis;
                            String i = StatServiceImpl.f25444o;
                            if (i != null && i.equals(str2)) {
                                i = "-";
                            }
                            C7635k kVar = new C7635k(contextSelf, i, str2, StatServiceImpl.getSessionID(contextSelf, false, statSpecifyReportedInfo2), d, statSpecifyReportedInfo2);
                            kVar.addCommonProperty("auto", Integer.valueOf(i2));
                            if (!str2.equals(StatServiceImpl.f25443n)) {
                                StatServiceImpl.f25447r.warn("Invalid invocation since previous onResume on diff page.");
                            }
                            new C7573c(kVar).mo37064a();
                            StatServiceImpl.f25444o = str2;
                            return;
                        }
                        StatLogger e2 = StatServiceImpl.f25447r;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Starttime for PageID:");
                        sb2.append(str2);
                        sb2.append(" not found, lost onResume()?");
                        e2.mo37103e((Object) sb2.toString());
                    } catch (Throwable th) {
                        StatServiceImpl.f25447r.mo37104e(th);
                        StatServiceImpl.m32628a(contextSelf, th);
                    }
                }
            };
            handler.post(r0);
        }
    }

    public static void trackEndPage(Context context, String str, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null || str == null || str.length() == 0) {
                f25447r.error((Object) "The Context or pageName of StatService.trackEndPage() can not be null or empty!");
            } else {
                m32642b(context2, str, 0, statSpecifyReportedInfo);
            }
        }
    }

    public static void startNewSession(Context context, final StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            final Context context2 = getContext(context);
            if (context2 == null) {
                f25447r.error((Object) "The Context of StatService.startNewSession() can not be null!");
                return;
            }
            if (getHandler(context2) != null) {
                f25434e.post(new Runnable() {
                    public void run() {
                        try {
                            StatServiceImpl.stopSession();
                            StatServiceImpl.getSessionID(context2, true, statSpecifyReportedInfo);
                        } catch (Throwable th) {
                            StatServiceImpl.f25447r.mo37104e(th);
                            StatServiceImpl.m32628a(context2, th);
                        }
                    }
                });
            }
        }
    }

    public static void stopSession() {
        f25438i = 0;
    }

    /* renamed from: a */
    static void m32625a(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo, boolean z) {
        if (statSpecifyReportedInfo == null) {
            try {
                statSpecifyReportedInfo = f25428D;
            } catch (Throwable th) {
                f25447r.mo37104e(th);
            }
        }
        StatLogger statLogger = f25447r;
        StringBuilder sb = new StringBuilder();
        sb.append("trackBackground lastForegroundTs:");
        sb.append(f25427C);
        statLogger.mo37101d(sb.toString());
        if (f25427C > 0 && StatConfig.f25373r) {
            double currentTimeMillis = ((double) ((System.currentTimeMillis() - f25427C) - StatConfig.getBackgroundDelayTimestamp())) / 1000.0d;
            if (currentTimeMillis <= 0.0d) {
                currentTimeMillis = 0.1d;
            }
            m32622a(f25449t, currentTimeMillis, statSpecifyReportedInfo, z);
        }
        f25427C = -1;
    }

    public static void trackBackground(Context context, long j, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        m32622a(context, (double) j, statSpecifyReportedInfo, false);
    }

    /* renamed from: a */
    private static void m32622a(Context context, double d, StatSpecifyReportedInfo statSpecifyReportedInfo, boolean z) {
        if (StatConfig.isEnableStatService()) {
            final Context context2 = getContext(context);
            if (context2 == null) {
                f25447r.error((Object) "The Context of StatService.trackBackground() can not be null!");
                return;
            }
            if (getHandler(context2) != null) {
                Handler handler = f25434e;
                final double d2 = d;
                final StatSpecifyReportedInfo statSpecifyReportedInfo2 = statSpecifyReportedInfo;
                final boolean z2 = z;
                C756036 r1 = new Runnable() {
                    public void run() {
                        try {
                            StatLogger e = StatServiceImpl.f25447r;
                            StringBuilder sb = new StringBuilder();
                            sb.append("trackBackground duration:");
                            sb.append(d2);
                            e.mo37108i(sb.toString());
                            StatServiceImpl.flushDataToDB(context2);
                            C7625b bVar = new C7625b(StatServiceImpl.getContext(context2), StatServiceImpl.getSessionID(context2, false, statSpecifyReportedInfo2), d2 <= 0.0d ? 0.1d : d2, statSpecifyReportedInfo2);
                            if (!z2) {
                                new C7573c(bVar).mo37064a();
                            } else {
                                C7614e.m32812a(context2).mo37146a((Event) bVar, (StatDispatchCallback) null, false, true);
                            }
                        } catch (Throwable th) {
                            StatServiceImpl.f25447r.mo37104e(th);
                            StatServiceImpl.m32628a(context2, th);
                        }
                    }
                };
                handler.post(r1);
            }
        }
    }

    public static boolean isEnableAutoMonitorActivityCycle() {
        return f25452w;
    }

    public static boolean isForeground() {
        return f25453x;
    }

    public static boolean isBackground() {
        return !f25453x;
    }

    public static void addActionListener(StatActionListener statActionListener) {
        f25425A.add(statActionListener);
    }

    public static void removeActionListener(StatActionListener statActionListener) {
        f25425A.remove(statActionListener);
    }

    /* renamed from: u */
    private static void m32677u() {
        Application application;
        try {
            if (Integer.valueOf(StatConfig.getSDKProperty("autoTm", "1")).intValue() == 1) {
                if (f25449t instanceof Application) {
                    application = (Application) f25449t;
                } else if (f25449t instanceof Activity) {
                    application = ((Activity) f25449t).getApplication();
                } else {
                    application = (Application) f25449t;
                }
                if (application != null) {
                    registerActivityLifecycleAutoStat(application, null);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void registerActivityLifecycleAutoStat(Application application, final StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (!StatConfig.isEnableAutoMonitorActivityCycle()) {
            f25447r.warn("MTA Auto Monitor Activity Cycle is disable by user!");
        } else if (!f25452w && application != null && VERSION.SDK_INT >= 14) {
            StatConfig.f25372q = true;
            f25449t = Util.getContextSelf(application);
            getHandler(f25449t);
            f25428D = statSpecifyReportedInfo;
            if (f25455z == null) {
                f25455z = new Handler();
            }
            synchronized (StatServiceImpl.class) {
                if (!f25452w) {
                    C756137 r1 = new MtaActivityLifecycleCallback() {
                        public void onActivityCreated(Activity activity, Bundle bundle) {
                        }

                        public void onActivityDestroyed(Activity activity) {
                        }

                        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                        }

                        public void onActivityStarted(Activity activity) {
                        }

                        public void onActivityStopped(Activity activity) {
                        }

                        public void onActivityResumed(Activity activity) {
                            if (StatConfig.isEnableStatService()) {
                                if (StatConfig.f25372q) {
                                    StatServiceImpl.m32643b((Context) activity, StatCommonHelper.getActivityName(activity), statSpecifyReportedInfo);
                                }
                                StatServiceImpl.f25454y = false;
                                boolean z = !StatServiceImpl.f25453x;
                                StatServiceImpl.f25453x = true;
                                if (StatServiceImpl.f25426B != null) {
                                    StatServiceImpl.f25455z.removeCallbacks(StatServiceImpl.f25426B);
                                }
                                if (z) {
                                    StatServiceImpl.f25447r.mo37108i("went foreground");
                                    StatServiceImpl.f25451v = System.currentTimeMillis();
                                    for (StatActionListener onBecameForeground : StatServiceImpl.f25425A) {
                                        try {
                                            onBecameForeground.onBecameForeground();
                                        } catch (Throwable th) {
                                            th.printStackTrace();
                                        }
                                    }
                                } else {
                                    StatServiceImpl.f25447r.mo37108i("still foreground");
                                }
                            }
                        }

                        public void onActivityPaused(Activity activity) {
                            if (StatConfig.isEnableStatService()) {
                                if (StatConfig.f25372q) {
                                    StatServiceImpl.m32642b(activity, StatCommonHelper.getActivityName(activity), 1, statSpecifyReportedInfo);
                                }
                                StatServiceImpl.f25454y = true;
                                if (StatServiceImpl.f25426B != null) {
                                    StatServiceImpl.f25455z.removeCallbacks(StatServiceImpl.f25426B);
                                }
                                StatServiceImpl.f25455z.postDelayed(StatServiceImpl.f25426B = new Runnable() {
                                    public void run() {
                                        try {
                                            if (!StatServiceImpl.f25453x || !StatServiceImpl.f25454y) {
                                                StatServiceImpl.f25447r.mo37108i("still foreground");
                                                return;
                                            }
                                            StatServiceImpl.f25447r.mo37108i("went background");
                                            for (StatActionListener onBecameBackground : StatServiceImpl.f25425A) {
                                                onBecameBackground.onBecameBackground();
                                            }
                                            StatServiceImpl.f25453x = false;
                                        } catch (Throwable th) {
                                            StatServiceImpl.f25447r.mo37104e(th);
                                        }
                                    }
                                }, StatConfig.getBackgroundDelayTimestamp());
                            }
                        }
                    };
                    try {
                        addActionListener(new StatActionListener() {
                            public void onBecameForeground() {
                                StatServiceImpl.f25427C = System.currentTimeMillis();
                            }

                            public void onBecameBackground() {
                                StatServiceImpl.m32625a(StatServiceImpl.f25449t, statSpecifyReportedInfo, C7596c.m32757a());
                            }
                        });
                        f25452w = MtaActivityLifeCycle.registerActivityLifecycleCallbacks(application, r1).booleanValue();
                        StatLogger statLogger = f25447r;
                        StringBuilder sb = new StringBuilder();
                        sb.append("enableAutoMonitorActivityCycle:");
                        sb.append(f25452w);
                        sb.append(",isAntoActivityLifecycleStat:");
                        sb.append(StatConfig.isAntoActivityLifecycleStat());
                        statLogger.mo37101d(sb.toString());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        }
    }

    public static void onResume(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        Context contextSelf = Util.getContextSelf(context);
        trackBeginPage(contextSelf, StatCommonHelper.getActivityName(contextSelf), statSpecifyReportedInfo);
    }

    public static void setEnvAttributes(Context context, Map<String, String> map) {
        if (map == null || map.size() > 512) {
            f25447r.error((Object) "The map in setEnvAttributes can't be null or its size can't exceed 512.");
            return;
        }
        try {
            C7592a.m32749a(context, map);
        } catch (JSONException e) {
            f25447r.mo37104e((Throwable) e);
        }
    }

    public static void reportEvent(Context context, final Event event, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            final Context context2 = getContext(context);
            if (context2 == null || event == null) {
                f25447r.error((Object) "context or event is null in reportEvent()");
                return;
            }
            if (getHandler(context2) != null) {
                f25434e.post(new Runnable() {
                    public void run() {
                        try {
                            new C7573c(event).mo37064a();
                        } catch (Throwable th) {
                            StatServiceImpl.f25447r.mo37104e(th);
                            StatServiceImpl.m32628a(context2, th);
                        }
                    }
                });
            }
        }
    }

    public static void reportQQ(Context context, final String str, final StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            final Context context2 = getContext(context);
            if (context2 == null) {
                f25447r.error((Object) "context is null in reportQQ()");
                return;
            }
            if (getHandler(context2) != null) {
                f25434e.post(new Runnable() {
                    public void run() {
                        String str = str;
                        if (str == null || str.trim().length() == 0) {
                            StatServiceImpl.f25447r.mo37116w("qq num is null or empty.");
                            return;
                        }
                        String str2 = str;
                        StatConfig.f25361f = str2;
                        StatServiceImpl.m32640b(context2, new StatAccount(str2), statSpecifyReportedInfo);
                    }
                });
            }
        }
    }

    public static void reportAccount(Context context, final StatAccount statAccount, final StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            final Context context2 = getContext(context);
            if (context2 == null) {
                f25447r.mo37103e((Object) "context is null in reportAccount.");
                return;
            }
            if (getHandler(context2) != null) {
                f25434e.post(new Runnable() {
                    public void run() {
                        StatAccount statAccount = statAccount;
                        if (statAccount == null || statAccount.getAccount().trim().length() == 0) {
                            StatServiceImpl.f25447r.mo37116w("account is null or empty.");
                            return;
                        }
                        StatConfig.setQQ(context2, statAccount.getAccount());
                        StatServiceImpl.m32640b(context2, statAccount, statSpecifyReportedInfo);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private|static */
    /* renamed from: h */
    public static void m32663h(Context context) {
        StatPreferences.putString(context, ".stat.multi.acc.", StatCommonHelper.multiAccountMapToJSONArray(f25429E).toString());
    }

    /* access modifiers changed from: private|static */
    /* renamed from: i */
    public static void m32665i(Context context) {
        f25429E = StatCommonHelper.multiAccounStrToMap(StatPreferences.getString(context, ".stat.multi.acc.", ""));
    }

    public static Map<AccountType, StatMultiAccount> getMultiAccount() {
        return f25429E;
    }

    public static void addMultiAccount(StatMultiAccount statMultiAccount) {
        f25429E.put(statMultiAccount.getType(), statMultiAccount);
    }

    public static void removeMultiAccount(Context context, AccountType accountType, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        StatMultiAccount statMultiAccount = (StatMultiAccount) f25429E.get(accountType);
        if (statMultiAccount != null) {
            Context context2 = getContext(context);
            statMultiAccount.setCurrentStatusType(AccountStatus.LOGOUT);
            m32663h(context2);
            m32651c(context2, statSpecifyReportedInfo);
        }
    }

    public static void clearMultiAccount() {
        f25429E.clear();
    }

    public static void reportMultiAccount(Context context, StatMultiAccount statMultiAccount, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (statMultiAccount == null) {
            f25447r.mo37103e((Object) "account is null in reportAccount.");
            return;
        }
        reportMultiAccount(context, Arrays.asList(new StatMultiAccount[]{statMultiAccount}), statSpecifyReportedInfo);
    }

    public static void reportMultiAccount(Context context, List<StatMultiAccount> list, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f25447r.mo37103e((Object) "context is null in reportAccount.");
            } else if (list == null) {
                f25447r.mo37103e((Object) "accountList is null in reportAccount.");
            } else {
                for (StatMultiAccount statMultiAccount : list) {
                    f25429E.put(statMultiAccount.getType(), statMultiAccount);
                }
                m32651c(context2, statSpecifyReportedInfo);
            }
        }
    }

    /* renamed from: c */
    private static void m32651c(final Context context, final StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (getHandler(context) != null) {
            f25434e.post(new Runnable() {
                public void run() {
                    if (StatServiceImpl.f25429E == null) {
                        StatServiceImpl.f25447r.mo37116w("multiAccount is null or empty.");
                        return;
                    }
                    try {
                        new C7573c(new C7624a(context, StatServiceImpl.getSessionID(context, false, statSpecifyReportedInfo), StatServiceImpl.f25429E, statSpecifyReportedInfo)).mo37064a();
                        StatServiceImpl.m32663h(context);
                    } catch (Throwable th) {
                        StatServiceImpl.f25447r.mo37104e(th);
                        StatServiceImpl.m32628a(context, th);
                    }
                }
            });
        }
    }

    public static void reportGameUser(Context context, final StatGameUser statGameUser, final StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            final Context context2 = getContext(context);
            if (context2 == null) {
                f25447r.error((Object) "The Context of StatService.reportGameUser() can not be null!");
                return;
            }
            if (getHandler(context2) != null) {
                f25434e.post(new Runnable() {
                    public void run() {
                        StatGameUser statGameUser = statGameUser;
                        if (statGameUser == null) {
                            StatServiceImpl.f25447r.error((Object) "The gameUser of StatService.reportGameUser() can not be null!");
                        } else if (statGameUser.getAccount() == null || statGameUser.getAccount().length() == 0) {
                            StatServiceImpl.f25447r.error((Object) "The account of gameUser on StatService.reportGameUser() can not be null or empty!");
                        } else {
                            try {
                                new C7573c(new C7630f(context2, StatServiceImpl.getSessionID(context2, false, statSpecifyReportedInfo), statGameUser, statSpecifyReportedInfo)).mo37064a();
                            } catch (Throwable th) {
                                StatServiceImpl.f25447r.mo37104e(th);
                                StatServiceImpl.m32628a(context2, th);
                            }
                        }
                    }
                });
            }
        }
    }

    public static boolean startStatService(final Context context, String str, String str2, final StatSpecifyReportedInfo statSpecifyReportedInfo) throws MtaSDkException {
        try {
            if (!StatConfig.isEnableStatService()) {
                f25447r.error((Object) "MTA StatService is disable.");
                return false;
            }
            String str3 = StatConstants.VERSION;
            if (StatConfig.isDebugEnable()) {
                StatLogger statLogger = f25447r;
                StringBuilder sb = new StringBuilder();
                sb.append("MTA SDK version, current: ");
                sb.append(str3);
                sb.append(" ,required: ");
                sb.append(str2);
                statLogger.mo37101d(sb.toString());
            }
            if (context != null) {
                if (str2 != null) {
                    if (StatCommonHelper.getSDKLongVersion(str3) < StatCommonHelper.getSDKLongVersion(str2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("MTA SDK version conflicted, current: ");
                        sb2.append(str3);
                        sb2.append(",required: ");
                        sb2.append(str2);
                        String sb3 = sb2.toString();
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(sb3);
                        sb4.append(". please delete the current SDK and download the latest one. official website: http://mta.qq.com/ or http://mta.oa.com/");
                        f25447r.error((Object) sb4.toString());
                        StatConfig.setEnableStatService(false);
                        return false;
                    }
                    String installChannel = StatConfig.getInstallChannel(context);
                    if (installChannel == null || installChannel.length() == 0) {
                        StatConfig.setInstallChannel("-");
                    }
                    if (str != null) {
                        StatConfig.setAppKey(context, str);
                    }
                    if (getHandler(context) != null) {
                        f25434e.post(new Runnable() {
                            public void run() {
                                try {
                                    StatServiceImpl.getSessionID(context, false, statSpecifyReportedInfo);
                                } catch (Throwable th) {
                                    StatServiceImpl.f25447r.mo37104e(th);
                                }
                            }
                        });
                    }
                    return true;
                }
            }
            f25447r.error((Object) "Context or mtaSdkVersion in StatService.startStatService() is null, please check it!");
            StatConfig.setEnableStatService(false);
            return false;
        } catch (Throwable th) {
            f25447r.mo37104e(th);
            return false;
        }
    }

    public static void onPause(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        Context contextSelf = Util.getContextSelf(context);
        trackEndPage(contextSelf, StatCommonHelper.getActivityName(contextSelf), statSpecifyReportedInfo);
    }

    public static void onStop(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            final Context context2 = getContext(context);
            if (getHandler(context2) != null) {
                f25434e.post(new Runnable() {
                    public void run() {
                        Context context = context2;
                        if (context == null) {
                            StatServiceImpl.f25447r.error((Object) "The Context of StatService.onStop() can not be null!");
                            return;
                        }
                        StatServiceImpl.flushDataToDB(context);
                        if (!StatServiceImpl.m32632a()) {
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if (StatCommonHelper.isBackgroundRunning(context2)) {
                                if (StatConfig.isDebugEnable()) {
                                    StatServiceImpl.f25447r.mo37108i("onStop isBackgroundRunning flushDataToDB");
                                }
                                StatServiceImpl.commitEvents(context2, -1);
                            }
                        }
                    }
                });
            }
        }
    }

    public static void onLowMemory(final Context context) {
        if (StatConfig.isEnableStatService() && getHandler(getContext(context)) != null) {
            f25434e.post(new Runnable() {
                public void run() {
                    StatServiceImpl.flushDataToDB(context);
                }
            });
        }
    }

    public static int reportError(Context context, final String str, final StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (!StatConfig.isEnableStatService()) {
            return -1;
        }
        final Context context2 = getContext(context);
        if (context2 == null) {
            f25447r.error((Object) "The Context of StatService.reportError() can not be null!");
            return 1000;
        } else if (m32634a(str)) {
            f25447r.error((Object) "The event_id of StatService.reportError() can not be null or empty.");
            return 1000;
        } else {
            if (StatCommonHelper.checkArgumentsLength(str)) {
                f25447r.error((Object) "The length of err for StatService.reportError() exceeds the limit:61440");
                return 1001;
            }
            final Thread currentThread = Thread.currentThread();
            if (getHandler(context2) != null) {
                f25434e.post(new Runnable() {
                    public void run() {
                        try {
                            C7629e eVar = new C7629e(context2, StatServiceImpl.getSessionID(context2, false, statSpecifyReportedInfo), str, 0, StatConfig.getMaxReportEventLength(), currentThread, statSpecifyReportedInfo);
                            new C7573c(eVar).mo37064a();
                        } catch (Throwable th) {
                            StatServiceImpl.f25447r.mo37104e(th);
                            StatServiceImpl.m32628a(context2, th);
                        }
                    }
                });
            }
            return 0;
        }
    }

    public static int reportException(Context context, int i, String str) {
        return reportException(context, i, "", str);
    }

    public static int reportException(Context context, int i, String str, String str2) {
        return reportException(context, i, str, str2);
    }

    public static int reportException(Context context, int i, String str, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        return reportException(context, i, -1, "", str, statSpecifyReportedInfo);
    }

    public static int reportException(Context context, int i, long j, String str, String str2, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (!StatConfig.isEnableStatService()) {
            return -1;
        }
        final Context context2 = getContext(context);
        if (context2 == null) {
            f25447r.error((Object) "The Context of StatService.reportException() can not be null!");
            return 1000;
        } else if (m32634a(str2)) {
            f25447r.error((Object) "The event_id of StatService.reportException() can not be null or empty.");
            return 1000;
        } else {
            if (StatCommonHelper.checkArgumentsLength(str, str2)) {
                f25447r.error((Object) "The length of err for StatService.reportException() exceeds the limit:61440");
                return 1001;
            }
            final Thread currentThread = Thread.currentThread();
            if (getHandler(context2) != null) {
                Handler handler = f25434e;
                final StatSpecifyReportedInfo statSpecifyReportedInfo2 = statSpecifyReportedInfo;
                final String str3 = str2;
                final int i2 = i;
                final String str4 = str;
                final long j2 = j;
                C753311 r1 = new Runnable() {
                    public void run() {
                        try {
                            C7629e eVar = new C7629e(context2, StatServiceImpl.getSessionID(context2, false, statSpecifyReportedInfo2), str3, i2, StatConfig.getMaxReportEventLength(), currentThread, statSpecifyReportedInfo2);
                            eVar.mo37190a(str4);
                            eVar.mo37189a(j2);
                            new C7573c(eVar).mo37064a();
                        } catch (Throwable th) {
                            StatServiceImpl.f25447r.mo37104e(th);
                            StatServiceImpl.m32628a(context2, th);
                        }
                    }
                };
                handler.post(r1);
            }
            return 0;
        }
    }

    /* renamed from: a */
    static void m32628a(Context context, final Throwable th) {
        if (StatConfig.isEnableStatService()) {
            final Context context2 = getContext(context);
            if (context2 == null) {
                f25447r.error((Object) "The Context of StatService.reportSdkSelfException() can not be null!");
                return;
            }
            final Thread currentThread = Thread.currentThread();
            if (getHandler(context2) != null) {
                f25434e.post(new Runnable() {
                    public void run() {
                        try {
                            if (StatConfig.isEnableStatService()) {
                                C7629e eVar = new C7629e(context2, StatServiceImpl.getSessionID(context2, false, null), 99, th, currentThread, C7632h.f25809a);
                                new C7573c(eVar).mo37064a();
                            }
                        } catch (Throwable th) {
                            StatLogger e = StatServiceImpl.f25447r;
                            StringBuilder sb = new StringBuilder();
                            sb.append("reportSdkSelfException error: ");
                            sb.append(th);
                            e.mo37103e((Object) sb.toString());
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static void m32640b(Context context, StatAccount statAccount, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        try {
            new C7573c(new C7624a(context, getSessionID(context, false, statSpecifyReportedInfo), statAccount, statSpecifyReportedInfo)).mo37064a();
        } catch (Throwable th) {
            f25447r.mo37104e(th);
            m32628a(context, th);
        }
    }

    public static int reportException(Context context, final Throwable th, final StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (!StatConfig.isEnableStatService()) {
            return -1;
        }
        final Context context2 = getContext(context);
        if (context2 == null) {
            f25447r.error((Object) "The Context of StatService.reportException() can not be null!");
            return 1000;
        } else if (th == null) {
            f25447r.error((Object) "The Throwable of StatService.reportException() can not be null or empty.");
            return 1000;
        } else {
            if (StatCommonHelper.checkArgumentsLength(th)) {
                f25447r.error((Object) "The length of err for StatService.reportException() exceeds the limit:61440");
                return 1001;
            }
            final Thread currentThread = Thread.currentThread();
            if (getHandler(context2) != null) {
                f25434e.post(new Runnable() {
                    public void run() {
                        Context context = context2;
                        C7629e eVar = new C7629e(context, StatServiceImpl.getSessionID(context, false, statSpecifyReportedInfo), 1, th, currentThread, statSpecifyReportedInfo);
                        new C7573c(eVar).mo37064a();
                    }
                });
            }
            return 0;
        }
    }

    /* renamed from: c */
    static void m32650c(Context context) {
        if (StatConfig.isEnableStatService()) {
            final Context context2 = getContext(context);
            if (getHandler(context2) != null) {
                f25434e.postDelayed(new Runnable() {
                    public void run() {
                        Context context = context2;
                        if (context == null) {
                            StatServiceImpl.f25447r.error((Object) "The Context of StatService.reportNativeCrash() can not be null!");
                            return;
                        }
                        try {
                            new Thread(new C7570a(context), "NativeCrashRepoter").start();
                        } catch (Throwable th) {
                            StatServiceImpl.f25447r.mo37104e(th);
                            StatServiceImpl.m32628a(context2, th);
                        }
                    }
                }, (long) (StatCrashReporter.getStatCrashReporter(context2).getReportDelaySecOnStart() * 1000));
            }
        }
    }

    public static int reportCustomProperty(Context context, final JSONObject jSONObject, final StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (!StatConfig.isEnableStatService()) {
            return -1;
        }
        final Context context2 = getContext(context);
        if (context2 == null) {
            f25447r.error((Object) "The Context of StatService.reportCustomProperty() can not be null!");
            return 1000;
        } else if (jSONObject == null) {
            f25447r.error((Object) "The jsonObject of StatService.reportCustomProperty() can not be null ");
            return 1000;
        } else {
            if (getHandler(context2) != null) {
                f25434e.post(new Runnable() {
                    public void run() {
                        try {
                            C7628d dVar = new C7628d(context2, StatServiceImpl.getSessionID(context2, false, statSpecifyReportedInfo), statSpecifyReportedInfo);
                            dVar.mo37187a(jSONObject);
                            new C7573c(dVar).mo37064a();
                        } catch (Throwable th) {
                            StatServiceImpl.f25447r.mo37104e(th);
                            StatServiceImpl.m32628a(context2, th);
                        }
                    }
                });
            }
            return 0;
        }
    }

    public static int trackCustomEvent(Context context, final String str, final StatSpecifyReportedInfo statSpecifyReportedInfo, final String... strArr) {
        if (!StatConfig.isEnableStatService()) {
            return -1;
        }
        final Context context2 = getContext(context);
        if (context2 == null) {
            f25447r.error((Object) "The Context of StatService.trackCustomEvent() can not be null!");
            return 1000;
        } else if (m32634a(str)) {
            f25447r.error((Object) "The event_id of StatService.trackCustomEvent() can not be null or empty.");
            return 1000;
        } else {
            if (StatCommonHelper.checkArgumentsLength(str, strArr)) {
                f25447r.error((Object) "The length of event_id/args for StatService.trackCustomEvent() exceeds the limit:61440");
                return 1001;
            }
            if (getHandler(context2) != null) {
                f25434e.post(new Runnable() {
                    public void run() {
                        try {
                            C7627a aVar = new C7627a(str, strArr, null);
                            C7626c cVar = new C7626c(context2, StatServiceImpl.getSessionID(context2, false, statSpecifyReportedInfo), aVar.f25794a, statSpecifyReportedInfo);
                            cVar.mo37182a().f25795b = aVar.f25795b;
                            new C7573c(cVar).mo37064a();
                        } catch (Throwable th) {
                            StatServiceImpl.f25447r.mo37104e(th);
                            StatServiceImpl.m32628a(context2, th);
                        }
                    }
                });
            }
            return 0;
        }
    }

    /* renamed from: d */
    static void m32654d(Context context) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f25447r.error((Object) "The Context of StatService.sendNetworkDetector() can not be null!");
                return;
            }
            try {
                C7608d.m32797b(context2).mo37128a((Event) new C7632h(context2), (StatDispatchCallback) new StatDispatchCallback() {
                    public void onDispatchSuccess() {
                        StatServiceImpl.m32649c();
                    }

                    public void onDispatchFailure() {
                        StatServiceImpl.m32653d();
                    }
                });
            } catch (Throwable th) {
                f25447r.mo37104e(th);
            }
        }
    }

    public static void trackCustomKVEvent(Context context, final String str, final Properties properties, final StatSpecifyReportedInfo statSpecifyReportedInfo) {
        StatConfig.isEnableStatService();
        final Context context2 = getContext(context);
        if (context2 == null) {
            f25447r.error((Object) "The Context of StatService.trackCustomKVEvent() can not be null!");
        }
        if (m32634a(str)) {
            f25447r.error((Object) "The event_id of StatService.trackCustomKVEvent() can not be null or empty.");
        }
        if (StatCommonHelper.checkArgumentsLength(str, properties)) {
            f25447r.error((Object) "The length of event_id/properties for StatService.trackCustomKVEvent() exceeds the limit:61440");
        }
        if (getHandler(context2) != null) {
            f25434e.post(new Runnable() {
                public void run() {
                    try {
                        C7627a aVar = new C7627a(str, null, properties);
                        C7626c cVar = new C7626c(context2, StatServiceImpl.getSessionID(context2, false, statSpecifyReportedInfo), aVar.f25794a, statSpecifyReportedInfo);
                        cVar.mo37182a().f25796c = aVar.f25796c;
                        new C7573c(cVar).mo37064a();
                    } catch (Throwable th) {
                        StatServiceImpl.f25447r.mo37104e(th);
                        StatServiceImpl.m32628a(context2, th);
                    }
                }
            });
        }
    }

    public static void trackRegAccountEvent(Context context, final String str, final StatConfig.AccountType accountType) {
        final Context context2 = getContext(context);
        if (context2 == null) {
            f25447r.error((Object) "The Context of StatService.trackRegAccountEvent() can not be null!");
        }
        if (getHandler(context2) != null) {
            f25434e.post(new Runnable() {
                public void run() {
                    try {
                        new C7573c(new C7638m(context2, StatServiceImpl.getSessionID(context2, false, null), str, accountType)).mo37064a();
                    } catch (Throwable th) {
                        StatServiceImpl.f25447r.mo37104e(th);
                        StatServiceImpl.m32628a(context2, th);
                    }
                }
            });
        }
    }

    public static void trackPayEvent(Context context, String str, String str2, double d, CurrencyType currencyType) {
        final Context context2 = getContext(context);
        if (context2 == null) {
            f25447r.error((Object) "The Context of StatService.trackRegAccountEvent() can not be null!");
        }
        if (getHandler(context2) != null) {
            Handler handler = f25434e;
            final String str3 = str;
            final String str4 = str2;
            final double d2 = d;
            final CurrencyType currencyType2 = currencyType;
            C754421 r0 = new Runnable() {
                public void run() {
                    try {
                        C7636l lVar = new C7636l(context2, StatServiceImpl.getSessionID(context2, false, null), str3, str4, d2, currencyType2);
                        new C7573c(lVar).mo37064a();
                    } catch (Throwable th) {
                        StatServiceImpl.f25447r.mo37104e(th);
                        StatServiceImpl.m32628a(context2, th);
                    }
                }
            };
            handler.post(r0);
        }
    }

    public static void setCommonKeyValueForKVEvent(String str, Properties properties) {
        if (!StatCommonHelper.isStringValid(str)) {
            f25447r.mo37103e((Object) "event_id or commonProp for setCommonKeyValueForKVEvent is invalid.");
        } else if (properties == null || properties.size() <= 0) {
            f25436g.remove(str);
        } else {
            f25436g.put(str, (Properties) properties.clone());
        }
    }

    public static Properties getCommonKeyValueForKVEvent(String str) {
        return (Properties) f25436g.get(str);
    }

    public static int trackCustomBeginEvent(Context context, final String str, StatSpecifyReportedInfo statSpecifyReportedInfo, final String... strArr) {
        if (!StatConfig.isEnableStatService()) {
            return -1;
        }
        final Context context2 = getContext(context);
        if (context2 == null) {
            f25447r.error((Object) "The Context of StatService.trackCustomBeginEvent() can not be null!");
            return 1000;
        } else if (m32634a(str)) {
            f25447r.error((Object) "The event_id of StatService.trackCustomBeginEvent() can not be null or empty.");
            return 1000;
        } else {
            if (StatCommonHelper.checkArgumentsLength(str, strArr)) {
                f25447r.error((Object) "The length of event_id/args for StatService.trackCustomBeginEvent() exceeds the limit:61440");
                return 1001;
            }
            if (getHandler(context2) != null) {
                f25434e.post(new Runnable() {
                    public void run() {
                        try {
                            C7627a aVar = new C7627a(str, strArr, null);
                            if (StatConfig.isDebugEnable()) {
                                StatLogger e = StatServiceImpl.f25447r;
                                StringBuilder sb = new StringBuilder();
                                sb.append("add begin key:");
                                sb.append(aVar.toString());
                                e.mo37108i(sb.toString());
                            }
                            if (StatServiceImpl.f25435f.containsKey(aVar)) {
                                StatLogger e2 = StatServiceImpl.f25447r;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("Duplicate CustomEvent key: ");
                                sb2.append(aVar.toString());
                                sb2.append(", trackCustomBeginEvent() repeated?");
                                e2.error((Object) sb2.toString());
                                return;
                            }
                            if (StatServiceImpl.f25435f.size() <= StatConfig.getMaxParallelTimmingEvents()) {
                                StatServiceImpl.f25435f.put(aVar, Long.valueOf(System.currentTimeMillis()));
                            } else {
                                StatLogger e3 = StatServiceImpl.f25447r;
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("The number of timedEvent exceeds the maximum value ");
                                sb3.append(Integer.toString(StatConfig.getMaxParallelTimmingEvents()));
                                e3.error((Object) sb3.toString());
                            }
                        } catch (Throwable th) {
                            StatServiceImpl.f25447r.mo37104e(th);
                            StatServiceImpl.m32628a(context2, th);
                        }
                    }
                });
            }
            return 0;
        }
    }

    public static int trackCustomEndEvent(Context context, final String str, final StatSpecifyReportedInfo statSpecifyReportedInfo, final String... strArr) {
        if (!StatConfig.isEnableStatService()) {
            return -1;
        }
        final Context context2 = getContext(context);
        if (context2 == null) {
            f25447r.error((Object) "The Context of StatService.trackCustomEndEvent() can not be null!");
            return 1000;
        } else if (m32634a(str)) {
            f25447r.error((Object) "The event_id of StatService.trackCustomEndEvent() can not be null or empty.");
            return 1000;
        } else {
            if (StatCommonHelper.checkArgumentsLength(str, strArr)) {
                f25447r.error((Object) "The length of event_id/args for StatService.trackCustomEndEvent() exceeds the limit:61440");
                return 1001;
            }
            if (getHandler(context2) != null) {
                f25434e.post(new Runnable() {
                    public void run() {
                        try {
                            C7627a aVar = new C7627a(str, strArr, null);
                            Long l = (Long) StatServiceImpl.f25435f.remove(aVar);
                            if (l != null) {
                                C7626c cVar = new C7626c(context2, StatServiceImpl.getSessionID(context2, false, statSpecifyReportedInfo), aVar.f25794a, statSpecifyReportedInfo);
                                cVar.mo37182a().f25795b = aVar.f25795b;
                                double currentTimeMillis = ((double) (System.currentTimeMillis() - l.longValue())) / 1000.0d;
                                if (currentTimeMillis <= 0.0d) {
                                    currentTimeMillis = 0.1d;
                                }
                                cVar.mo37183a(currentTimeMillis);
                                new C7573c(cVar).mo37064a();
                                return;
                            }
                            StatLogger e = StatServiceImpl.f25447r;
                            StringBuilder sb = new StringBuilder();
                            sb.append("No start time found for custom event: ");
                            sb.append(aVar.toString());
                            sb.append(", lost trackCustomBeginEvent()?");
                            e.error((Object) sb.toString());
                        } catch (Throwable th) {
                            StatServiceImpl.f25447r.mo37104e(th);
                            StatServiceImpl.m32628a(context2, th);
                        }
                    }
                });
            }
            return 0;
        }
    }

    public static int trackCustomBeginKVEvent(Context context, final String str, final Properties properties, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (!StatConfig.isEnableStatService()) {
            return -1;
        }
        final Context context2 = getContext(context);
        if (context2 == null) {
            f25447r.error((Object) "The Context of StatService.trackCustomBeginKVEvent() can not be null!");
            return 1000;
        } else if (m32634a(str)) {
            f25447r.error((Object) "The event_id of StatService.trackCustomBeginKVEvent() can not be null or empty.");
            return 1000;
        } else {
            if (StatCommonHelper.checkArgumentsLength(str, properties)) {
                f25447r.error((Object) "The length of event_id/properties for StatService.trackCustomBeginKVEvent() exceeds the limit:61440");
                return 1001;
            }
            if (getHandler(context2) != null) {
                f25434e.post(new Runnable() {
                    public void run() {
                        try {
                            C7627a aVar = new C7627a(str, null, properties);
                            if (StatConfig.isDebugEnable()) {
                                StatLogger e = StatServiceImpl.f25447r;
                                StringBuilder sb = new StringBuilder();
                                sb.append("add begin key:");
                                sb.append(aVar);
                                e.mo37108i(sb.toString());
                            }
                            if (StatServiceImpl.f25435f.containsKey(aVar)) {
                                StatLogger e2 = StatServiceImpl.f25447r;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("Duplicate CustomEvent key: ");
                                sb2.append(aVar.toString());
                                sb2.append(", trackCustomBeginKVEvent() repeated?");
                                e2.warn(sb2.toString());
                                return;
                            }
                            if (StatServiceImpl.f25435f.size() <= StatConfig.getMaxParallelTimmingEvents()) {
                                StatServiceImpl.f25435f.put(aVar, Long.valueOf(System.currentTimeMillis()));
                            } else {
                                StatLogger e3 = StatServiceImpl.f25447r;
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("The number of timedEvent exceeds the maximum value ");
                                sb3.append(Integer.toString(StatConfig.getMaxParallelTimmingEvents()));
                                e3.error((Object) sb3.toString());
                            }
                        } catch (Throwable th) {
                            StatServiceImpl.f25447r.mo37104e(th);
                            StatServiceImpl.m32628a(context2, th);
                        }
                    }
                });
            }
            return 0;
        }
    }

    public static int trackCustomEndKVEvent(Context context, final String str, final Properties properties, final StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (!StatConfig.isEnableStatService()) {
            return -1;
        }
        final Context context2 = getContext(context);
        if (context2 == null) {
            f25447r.error((Object) "The Context of StatService.trackCustomEndKVEvent() can not be null!");
            return 1000;
        } else if (m32634a(str)) {
            f25447r.error((Object) "The event_id of StatService.trackCustomEndKVEvent() can not be null or empty.");
            return 1000;
        } else {
            if (StatCommonHelper.checkArgumentsLength(str, properties)) {
                f25447r.error((Object) "The length of event_id/properties for StatService.trackCustomEndKVEvent() exceeds the limit:61440");
                return 1001;
            }
            if (getHandler(context2) != null) {
                f25434e.post(new Runnable() {
                    public void run() {
                        try {
                            C7627a aVar = new C7627a(str, null, properties);
                            Long l = (Long) StatServiceImpl.f25435f.remove(aVar);
                            if (l != null) {
                                C7626c cVar = new C7626c(context2, StatServiceImpl.getSessionID(context2, false, statSpecifyReportedInfo), aVar.f25794a, statSpecifyReportedInfo);
                                cVar.mo37182a().f25796c = aVar.f25796c;
                                double currentTimeMillis = ((double) (System.currentTimeMillis() - l.longValue())) / 1000.0d;
                                if (currentTimeMillis <= 0.0d) {
                                    currentTimeMillis = 0.1d;
                                }
                                cVar.mo37183a(currentTimeMillis);
                                new C7573c(cVar).mo37064a();
                                return;
                            }
                            StatLogger e = StatServiceImpl.f25447r;
                            StringBuilder sb = new StringBuilder();
                            sb.append("No start time found for custom event: ");
                            sb.append(aVar.toString());
                            sb.append(", lost trackCustomBeginKVEvent()?");
                            e.warn(sb.toString());
                        } catch (Throwable th) {
                            StatServiceImpl.f25447r.mo37104e(th);
                            StatServiceImpl.m32628a(context2, th);
                        }
                    }
                });
            }
            return 0;
        }
    }

    public static void reportAppMonitorStat(Context context, StatAppMonitor statAppMonitor, final StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            final Context context2 = getContext(context);
            if (context2 == null) {
                f25447r.error((Object) "The Context of StatService.reportAppMonitorStat() can not be null!");
            } else if (statAppMonitor == null) {
                f25447r.error((Object) "The StatAppMonitor of StatService.reportAppMonitorStat() can not be null!");
            } else if (statAppMonitor.getInterfaceName() == null) {
                f25447r.error((Object) "The interfaceName of StatAppMonitor on StatService.reportAppMonitorStat() can not be null!");
            } else {
                final StatAppMonitor clone = statAppMonitor.clone();
                if (getHandler(context2) != null) {
                    f25434e.post(new Runnable() {
                        public void run() {
                            try {
                                new C7573c(new C7631g(context2, StatServiceImpl.getSessionID(context2, false, statSpecifyReportedInfo), clone, statSpecifyReportedInfo)).mo37064a();
                            } catch (Throwable th) {
                                StatServiceImpl.f25447r.mo37104e(th);
                                StatServiceImpl.m32628a(context2, th);
                            }
                        }
                    });
                }
            }
        }
    }

    public static int trackCustomKVTimeIntervalEvent(Context context, String str, Properties properties, int i, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (!StatConfig.isEnableStatService()) {
            return -1;
        }
        final Context context2 = getContext(context);
        if (context2 == null) {
            f25447r.error((Object) "The Context of StatService.trackCustomKVTimeIntervalEvent() can not be null!");
            return 1000;
        } else if (m32634a(str)) {
            f25447r.error((Object) "The event_id of StatService.trackCustomKVTimeIntervalEvent() can not be null or empty.");
            return 1000;
        } else if (i <= 0) {
            f25447r.error((Object) "The intervalSecond of StatService.trackCustomTimeIntervalEvent() can must bigger than 0!");
            return 1000;
        } else {
            if (StatCommonHelper.checkArgumentsLength(str, properties)) {
                f25447r.error((Object) "The length of event_id/properties for StatService.trackCustomKVTimeIntervalEvent() exceeds the limit:61440");
                return 1001;
            }
            if (getHandler(context2) != null) {
                Handler handler = f25434e;
                final String str2 = str;
                final Properties properties2 = properties;
                final StatSpecifyReportedInfo statSpecifyReportedInfo2 = statSpecifyReportedInfo;
                final int i2 = i;
                C755128 r0 = new Runnable() {
                    public void run() {
                        try {
                            C7627a aVar = new C7627a(str2, null, properties2);
                            C7626c cVar = new C7626c(context2, StatServiceImpl.getSessionID(context2, false, statSpecifyReportedInfo2), aVar.f25794a, statSpecifyReportedInfo2);
                            cVar.mo37182a().f25796c = aVar.f25796c;
                            double d = (double) i2;
                            if (d <= 0.0d) {
                                d = 0.1d;
                            }
                            cVar.mo37183a(d);
                            new C7573c(cVar).mo37064a();
                        } catch (Throwable th) {
                            StatServiceImpl.f25447r.mo37104e(th);
                            StatServiceImpl.m32628a(context2, th);
                        }
                    }
                };
                handler.post(r0);
            }
            return 0;
        }
    }

    public static void commitEvents(Context context, final int i) {
        if (StatConfig.isEnableStatService()) {
            if (StatConfig.isDebugEnable()) {
                StatLogger statLogger = f25447r;
                StringBuilder sb = new StringBuilder();
                sb.append("commitEvents, maxNumber=");
                sb.append(i);
                statLogger.mo37108i(sb.toString());
            }
            final Context context2 = getContext(context);
            if (context2 == null) {
                f25447r.error((Object) "The Context of StatService.commitEvents() can not be null!");
            } else if (i < -1 || i == 0) {
                f25447r.error((Object) "The maxNumber of StatService.commitEvents() should be -1 or bigger than 0.");
            } else {
                if (NetworkManager.getInstance(context2).isNetworkAvailable() && getHandler(context2) != null) {
                    f25434e.post(new Runnable() {
                        public void run() {
                            try {
                                StatServiceImpl.flushDataToDB(context2);
                                C7614e.m32812a(context2).mo37144a(i);
                            } catch (Throwable th) {
                                StatServiceImpl.f25447r.mo37104e(th);
                                StatServiceImpl.m32628a(context2, th);
                            }
                        }
                    });
                }
            }
        }
    }

    public static void testSpeed(Context context) {
        m32641b(context, (StatSpecifyReportedInfo) null);
    }

    /* renamed from: b */
    static void m32641b(Context context, final StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            final Context context2 = getContext(context);
            if (context2 == null) {
                f25447r.error((Object) "The Context of StatService.testSpeed() can not be null!");
                return;
            }
            if (getHandler(context2) != null) {
                f25434e.post(new Runnable() {
                    public void run() {
                        try {
                            new Thread(new C7572b(context2, null, statSpecifyReportedInfo), "NetworkMonitorTask").start();
                        } catch (Throwable th) {
                            StatServiceImpl.f25447r.mo37104e(th);
                            StatServiceImpl.m32628a(context2, th);
                        }
                    }
                });
            }
        }
    }

    public static void testSpeed(Context context, Map<String, Integer> map, final StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            final Context context2 = getContext(context);
            if (context2 == null) {
                f25447r.error((Object) "The Context of StatService.testSpeed() can not be null!");
            } else if (map == null || map.size() == 0) {
                f25447r.error((Object) "The domainMap of StatService.testSpeed() can not be null or empty!");
            } else {
                final HashMap hashMap = new HashMap(map);
                if (getHandler(context2) != null) {
                    f25434e.post(new Runnable() {
                        public void run() {
                            try {
                                new Thread(new C7572b(context2, hashMap, statSpecifyReportedInfo), "NetworkMonitorTask").start();
                            } catch (Throwable th) {
                                StatServiceImpl.f25447r.mo37104e(th);
                                StatServiceImpl.m32628a(context2, th);
                            }
                        }
                    });
                }
            }
        }
    }

    public static void flushDataToDB(Context context) {
        if (StatConfig.isEnableStatService() && StatConfig.f25368m > 0) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f25447r.error((Object) "The Context of StatService.testSpeed() can not be null!");
            } else {
                C7614e.m32812a(context2).mo37151d();
            }
        }
    }

    public static void getFeedBackMessage(Context context, int i, int i2, StatFBDispatchCallback statFBDispatchCallback) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f25447r.error((Object) "The Context of StatService.getFeedBackMessage() can not be null!");
                return;
            }
            try {
                C7608d.m32797b(context2).mo37134b(i, i2, statFBDispatchCallback);
            } catch (Throwable th) {
                f25447r.mo37104e(th);
            }
        }
    }

    public static void postFeedBackFiles(Context context, String str, String str2, StatFBDispatchCallback statFBDispatchCallback) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f25447r.error((Object) "The Context of StatService.postFeedBackFiles() can not be null!");
                return;
            }
            try {
                C7608d.m32797b(context2).mo37135b(str, str2, statFBDispatchCallback);
            } catch (Throwable th) {
                f25447r.mo37104e(th);
            }
        }
    }

    public static void replyFeedBackMessage(Context context, String str, String str2, StatFBDispatchCallback statFBDispatchCallback) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f25447r.error((Object) "The Context of StatService.replyFeedBackMessage() can not be null!");
                return;
            }
            try {
                C7608d.m32797b(context2).mo37137c(str, str2, statFBDispatchCallback);
            } catch (Throwable th) {
                f25447r.mo37104e(th);
            }
        }
    }

    /* renamed from: a */
    static boolean m32633a(File file) {
        if (StatPreferences.getInt(f25449t, m32637b(file), 0) != 65535) {
            return false;
        }
        file.delete();
        return true;
    }

    /* renamed from: b */
    static String m32637b(File file) {
        StringBuilder sb = new StringBuilder();
        sb.append("__MTA.CRASH.FILE.SEND.CNT.");
        sb.append(file.getName());
        return sb.toString();
    }

    /* renamed from: c */
    static void m32652c(File file) {
        file.delete();
        StatPreferences.putInt(f25449t, m32637b(file), 65535);
    }

    /* renamed from: d */
    static void m32655d(File file) {
        String b = m32637b(file);
        int i = StatPreferences.getInt(f25449t, b, 0) + 1;
        if (i >= StatCrashReporter.getStatCrashReporter(f25449t).getMaxNumOfRetries()) {
            m32652c(file);
        } else {
            StatPreferences.putInt(f25449t, b, i);
        }
    }

    /* renamed from: c */
    static void m32649c() {
        f25431b = 0;
        f25432c = 0;
    }

    /* renamed from: d */
    static void m32653d() {
        f25431b++;
        f25432c = System.currentTimeMillis();
        flushDataToDB(f25449t);
    }

    /* renamed from: e */
    static void m32657e(Context context) {
        f25433d = System.currentTimeMillis() + ((long) (StatConfig.getSendPeriodMinutes() * 60000));
        StatPreferences.putLong(context, "last_period_ts", f25433d);
        commitEvents(context, -1);
    }
}
