package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.bugly.crashreport.biz.C7170b;
import com.tencent.bugly.crashreport.common.info.C7174a;
import com.tencent.bugly.crashreport.common.strategy.C7177a;
import com.tencent.bugly.proguard.C7208ac;
import com.tencent.bugly.proguard.C7211ad;
import com.tencent.bugly.proguard.C7212ae;
import com.tencent.bugly.proguard.C7219ak;
import com.tencent.bugly.proguard.C7226an;
import com.tencent.bugly.proguard.C7228ap;
import com.tencent.bugly.proguard.C7232aq;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.b */
public class C7121b {
    /* renamed from: a */
    public static boolean f23663a = true;
    /* renamed from: b */
    public static List<C8712a> f23664b = new ArrayList();
    /* renamed from: c */
    public static boolean f23665c;
    /* renamed from: d */
    private static C7212ae f23666d;
    /* renamed from: e */
    private static boolean f23667e;

    /* renamed from: a */
    private static boolean m30532a(C7174a aVar) {
        List<String> list = aVar.f24040u;
        aVar.getClass();
        return list != null && list.contains("bugly");
    }

    /* renamed from: a */
    public static synchronized void m30527a(Context context) {
        synchronized (C7121b.class) {
            m30528a(context, (BuglyStrategy) null);
        }
    }

    /* renamed from: a */
    public static synchronized void m30528a(Context context, BuglyStrategy buglyStrategy) {
        synchronized (C7121b.class) {
            if (f23667e) {
                C7226an.m31148d("[init] initial Multi-times, ignore this.", new Object[0]);
            } else if (context == null) {
                Log.w(C7226an.f24396b, "[init] context of init() is null, check it.");
            } else {
                C7174a a = C7174a.m30753a(context);
                if (m30532a(a)) {
                    f23663a = false;
                    return;
                }
                String f = a.mo34591f();
                if (f == null) {
                    Log.e(C7226an.f24396b, "[init] meta data of BUGLY_APPID in AndroidManifest.xml should be set.");
                } else {
                    m30529a(context, f, a.f23963A, buglyStrategy);
                }
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m30529a(Context context, String str, boolean z, BuglyStrategy buglyStrategy) {
        synchronized (C7121b.class) {
            if (f23667e) {
                C7226an.m31148d("[init] initial Multi-times, ignore this.", new Object[0]);
            } else if (context == null) {
                Log.w(C7226an.f24396b, "[init] context is null, check it.");
            } else if (str == null) {
                Log.e(C7226an.f24396b, "init arg 'crashReportAppID' should not be null!");
            } else {
                f23667e = true;
                if (z) {
                    f23665c = true;
                    C7226an.f24397c = true;
                    C7226an.m31148d("Bugly debug模式开启，请在发布时把isDebug关闭。 -- Running in debug model for 'isDebug' is enabled. Please disable it when you release.", new Object[0]);
                    C7226an.m31149e("--------------------------------------------------------------------------------------------", new Object[0]);
                    C7226an.m31148d("Bugly debug模式将有以下行为特性 -- The following list shows the behaviour of debug model: ", new Object[0]);
                    C7226an.m31148d("[1] 输出详细的Bugly SDK的Log -- More detailed log of Bugly SDK will be output to logcat;", new Object[0]);
                    C7226an.m31148d("[2] 每一条Crash都会被立即上报 -- Every crash caught by Bugly will be uploaded immediately.", new Object[0]);
                    C7226an.m31148d("[3] 自定义日志将会在Logcat中输出 -- Custom log will be output to logcat.", new Object[0]);
                    C7226an.m31149e("--------------------------------------------------------------------------------------------", new Object[0]);
                    C7226an.m31144b("[init] Open debug mode of Bugly.", new Object[0]);
                }
                C7226an.m31141a("[init] Bugly version: v%s", "3.1.0");
                C7226an.m31141a(" crash report start initializing...", new Object[0]);
                C7226an.m31144b("[init] Bugly start initializing...", new Object[0]);
                C7226an.m31141a("[init] Bugly complete version: v%s", "3.1.0(1.4.2)");
                Context a = C7232aq.m31172a(context);
                C7174a a2 = C7174a.m30753a(a);
                a2.mo34607t();
                C7228ap.m31156a(a);
                f23666d = C7212ae.m31042a(a, f23664b);
                C7219ak.m31090a(a);
                C7177a a3 = C7177a.m30858a(a, f23664b);
                C7208ac a4 = C7208ac.m31022a(a);
                if (m30532a(a2)) {
                    f23663a = false;
                    return;
                }
                a2.mo34576a(str);
                C7226an.m31141a("[param] Set APP ID:%s", str);
                m30530a(buglyStrategy, a2);
                C7170b.m30715a(a, buglyStrategy);
                for (int i = 0; i < f23664b.size(); i++) {
                    try {
                        if (a4.mo34769a(((C8712a) f23664b.get(i)).f23662id)) {
                            ((C8712a) f23664b.get(i)).init(a, z, buglyStrategy);
                        }
                    } catch (Throwable th) {
                        if (!C7226an.m31142a(th)) {
                            th.printStackTrace();
                        }
                    }
                }
                a3.mo34620a(buglyStrategy != null ? buglyStrategy.getAppReportDelay() : 0);
                C7226an.m31144b("[init] Bugly initialization finished.", new Object[0]);
            }
        }
    }

    /* renamed from: a */
    private static void m30530a(BuglyStrategy buglyStrategy, C7174a aVar) {
        if (buglyStrategy != null) {
            String appVersion = buglyStrategy.getAppVersion();
            if (!TextUtils.isEmpty(appVersion)) {
                if (appVersion.length() > 100) {
                    String substring = appVersion.substring(0, 100);
                    C7226an.m31148d("appVersion %s length is over limit %d substring to %s", appVersion, Integer.valueOf(100), substring);
                    appVersion = substring;
                }
                aVar.f24035p = appVersion;
                C7226an.m31141a("[param] Set App version: %s", buglyStrategy.getAppVersion());
            }
            try {
                if (buglyStrategy.isReplaceOldChannel()) {
                    String appChannel = buglyStrategy.getAppChannel();
                    if (!TextUtils.isEmpty(appChannel)) {
                        if (appChannel.length() > 100) {
                            String substring2 = appChannel.substring(0, 100);
                            C7226an.m31148d("appChannel %s length is over limit %d substring to %s", appChannel, Integer.valueOf(100), substring2);
                            appChannel = substring2;
                        }
                        f23666d.mo34782a(556, "app_channel", appChannel.getBytes(), (C7211ad) null, false);
                        aVar.f24037r = appChannel;
                    }
                } else {
                    Map a = f23666d.mo34779a(556, (C7211ad) null, true);
                    if (a != null) {
                        byte[] bArr = (byte[]) a.get("app_channel");
                        if (bArr != null) {
                            aVar.f24037r = new String(bArr);
                        }
                    }
                }
                C7226an.m31141a("[param] Set App channel: %s", aVar.f24037r);
            } catch (Exception e) {
                if (f23665c) {
                    e.printStackTrace();
                }
            }
            String appPackageName = buglyStrategy.getAppPackageName();
            if (!TextUtils.isEmpty(appPackageName)) {
                if (appPackageName.length() > 100) {
                    String substring3 = appPackageName.substring(0, 100);
                    C7226an.m31148d("appPackageName %s length is over limit %d substring to %s", appPackageName, Integer.valueOf(100), substring3);
                    appPackageName = substring3;
                }
                aVar.f24023d = appPackageName;
                C7226an.m31141a("[param] Set App package: %s", buglyStrategy.getAppPackageName());
            }
            String deviceID = buglyStrategy.getDeviceID();
            if (deviceID != null) {
                if (deviceID.length() > 100) {
                    String substring4 = deviceID.substring(0, 100);
                    C7226an.m31148d("deviceId %s length is over limit %d substring to %s", deviceID, Integer.valueOf(100), substring4);
                    deviceID = substring4;
                }
                aVar.mo34585c(deviceID);
                C7226an.m31141a("[param] Set device ID: %s", deviceID);
            }
            aVar.f24027h = buglyStrategy.isUploadProcess();
            C7228ap.f24399a = buglyStrategy.isBuglyLogUpload();
        }
    }

    /* renamed from: a */
    public static synchronized void m30531a(C8712a aVar) {
        synchronized (C7121b.class) {
            if (!f23664b.contains(aVar)) {
                f23664b.add(aVar);
            }
        }
    }
}
