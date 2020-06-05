package com.tencent.android.tpush.common;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import com.p522qq.p523e.comm.p525pi.ACTD;
import com.tencent.android.tpush.SettingsContentProvider;
import com.tencent.android.tpush.XGPush4Msdk;
import com.tencent.android.tpush.XGPushActivity;
import com.tencent.android.tpush.XGPushBaseReceiver;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.XGPushProvider;
import com.tencent.android.tpush.XGPushReceiver;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.p584d.C6927d;
import com.tencent.android.tpush.service.C6973b;
import com.tencent.android.tpush.service.C7047e;
import com.tencent.android.tpush.service.XGPushServiceV4;
import com.tencent.android.tpush.service.channel.security.TpnsSecurity;
import com.tencent.android.tpush.service.p588a.C6971a;
import com.tencent.android.tpush.service.p595e.C7056i;
import com.tencent.android.tpush.stat.C7084e;
import com.tencent.android.tpush.stat.p597b.C7075d;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import com.tencent.mid.api.MidConstants;
import com.tencent.mid.api.MidProvider;
import com.tencent.mid.sotrage.StorageInterface;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.security.auth.x500.X500Principal;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.common.l */
public class C6914l {
    /* renamed from: a */
    public static String f22990a = null;
    /* renamed from: b */
    private static AtomicBoolean f22991b = new AtomicBoolean(false);
    /* renamed from: c */
    private static boolean f22992c = false;
    /* renamed from: d */
    private static final X500Principal f22993d = new X500Principal("CN=Android Debug,O=Android,C=US");

    /* renamed from: a */
    public static String m29508a(String str) {
        String str2 = "0";
        if (str == null) {
            return str2;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                byte b2 = b & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
                if (b2 < 16) {
                    stringBuffer.append(str2);
                }
                stringBuffer.append(Integer.toHexString(b2));
            }
            return stringBuffer.toString();
        } catch (Throwable unused) {
            return str2;
        }
    }

    /* renamed from: a */
    public static void m29512a(JSONObject jSONObject, String str, String str2) {
        if (str2 != null) {
            try {
                if (str2.length() > 0) {
                    jSONObject.put(str, str2);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m29511a(JSONObject jSONObject, String str, long j) {
        if (str != null && j > 0) {
            try {
                jSONObject.put(str, j);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public static int m29505a(Context context) {
        String str = "Util";
        if (f22991b.get()) {
            return 0;
        }
        try {
            if (XGPushManager.getContext() == null) {
                XGPushManager.setContext(context);
            }
            if (C6973b.m29776f() == null) {
                C6973b.m29774d(context);
            }
            C7084e.m30402b(context);
            if (!m29527h(context)) {
                C6864a.m29309j(str, "XG is disable");
                return ReturnCode.CODE_SERVICE_DISABLED.getType();
            } else if (!TpnsSecurity.checkTpnsSecurityLibSo(context)) {
                C6864a.m29309j(str, "can not load library from so file");
                return ReturnCode.CODE_SO_ERROR.getType();
            } else if (!C6906f.m29471a()) {
                return ReturnCode.CODE_PERMISSIONS_ERROR.getType();
            } else {
                String str2 = "Maybe have not contentprovider: ";
                if (!m29514a(context, XGPushProvider.class.getName(), XGPushProvider.AUTH_PRIX)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(XGPushProvider.class.getName());
                    C6864a.m29307h(str, sb.toString());
                }
                if (!m29514a(context, SettingsContentProvider.class.getName(), ".TPUSH_PROVIDER")) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str2);
                    sb2.append(SettingsContentProvider.class.getName());
                    C6864a.m29307h(str, sb2.toString());
                }
                if (!m29514a(context, MidProvider.class.getName(), MidConstants.PROVIDER_AUTH_SUFFIX)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str2);
                    sb3.append(MidProvider.class.getName());
                    C6864a.m29307h(str, sb3.toString());
                }
                if (!m29519b("com.qq.taf.jce.JceStruct")) {
                    C6864a.m29309j(str, "please add wup-1.0.0.E-SNAPSHOT.jar in your libs");
                    return ReturnCode.CODE_JCE_ERROR.getType();
                }
                C7056i.m30223q(context);
                f22991b.set(true);
                return 0;
            }
        } catch (Throwable th) {
            C6864a.m29302d(str, "Util -> initGlobal", th);
            return -1;
        }
    }

    /* renamed from: b */
    public static boolean m29519b(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m29514a(Context context, String str, String str2) {
        try {
            for (ProviderInfo providerInfo : context.getPackageManager().queryContentProviders(null, 0, 0)) {
                if (providerInfo.name.equals(str)) {
                    String str3 = providerInfo.authority;
                    StringBuilder sb = new StringBuilder();
                    sb.append(context.getPackageName());
                    sb.append(str2);
                    if (str3.equals(sb.toString())) {
                        return true;
                    }
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Util -> initGlobal can not find provider ");
            sb2.append(str);
            sb2.append(" with authority ");
            sb2.append(context.getPackageName());
            sb2.append(str2);
            C6864a.m29306g("Util", sb2.toString());
            return false;
        } catch (Throwable th) {
            throw new RuntimeException("Package manager has died", th);
        }
    }

    /* renamed from: b */
    public static boolean m29518b(Context context) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getPackageName());
            sb.append(Constants.RPC_SUFFIX);
            List e = C7056i.m30206e(context, sb.toString());
            if (e != null && e.size() > 0) {
                return true;
            }
        } catch (Throwable th) {
            C6864a.m29302d("Util", "Util -> isAIDLConfiged", th);
        }
        return false;
    }

    /* renamed from: c */
    public static boolean m29521c(String str) {
        return str == null || str.trim().length() == 0;
    }

    /* renamed from: c */
    public static int m29520c(Context context) {
        if (context != null) {
            try {
                List<RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME)).getRunningServices(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                if (runningServices != null && runningServices.size() > 0) {
                    String name = XGPushServiceV4.class.getName();
                    for (RunningServiceInfo runningServiceInfo : runningServices) {
                        String className = runningServiceInfo.service.getClassName();
                        if (!name.equals(className)) {
                            if ("com.tencent.android.tpush.service.XGPushServiceV4".equals(className)) {
                            }
                        }
                        return runningServiceInfo.pid != 0 ? 1 : 2;
                    }
                }
            } catch (Throwable th) {
                C6864a.m29302d("Util", "getServiceStatus", th);
            }
        }
        return 0;
    }

    /* renamed from: d */
    public static void m29522d(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append("startCurrentAppService ");
        sb.append(context.getPackageName());
        C6864a.m29298c(Constants.LogTag, sb.toString());
        context.startService(new Intent(context, XGPushServiceV4.class));
    }

    /* renamed from: e */
    public static void m29524e(final Context context) {
        if (context != null) {
            try {
                if (C7056i.m30186a(context.getPackageName())) {
                    m29522d(context);
                    return;
                }
                C6973b.m29774d(context.getApplicationContext());
                C6973b.m29765a(context);
                C6864a.m29286a("Util", "Action -> start Local Service()");
                C6901c.m29459a().mo33106a(new Runnable() {
                    public void run() {
                        if (C6914l.m29520c(context) != 1) {
                            try {
                                C6973b.m29765a(context);
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    }
                }, 1500);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static boolean m29513a(Context context, BroadcastReceiver broadcastReceiver) {
        try {
            context.unregisterReceiver(broadcastReceiver);
            return true;
        } catch (Exception e) {
            C6864a.m29302d("Util", "safeUnregisterReceiver error", e);
            return false;
        }
    }

    /* renamed from: f */
    public static String m29525f(Context context) {
        String str;
        String str2 = "";
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            if (str == null) {
                return str2;
            }
            return str;
        } catch (Throwable th) {
            C6864a.m29302d("Util", "get app version error", th);
            str = str2;
        }
    }

    /* renamed from: b */
    private static void m29517b(Context context, String str) {
        if (context != null && str != null && str.trim().length() != 0) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                ComponentName componentName = new ComponentName(context.getPackageName(), str);
                if (packageManager.getComponentEnabledSetting(componentName) != 1) {
                    packageManager.setComponentEnabledSetting(componentName, 1, 1);
                }
            }
        }
    }

    /* renamed from: g */
    public static void m29526g(Context context) {
        if (context != null && !f22992c) {
            try {
                m29517b(context, XGPushServiceV4.class.getName());
                m29517b(context, XGPushActivity.class.getName());
                m29517b(context, XGPushProvider.class.getName());
                m29517b(context, SettingsContentProvider.class.getName());
                m29517b(context, MidProvider.class.getName());
                ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 2).receivers;
                int length = activityInfoArr.length;
                int i = 0;
                while (i < length) {
                    String str = activityInfoArr[i].name;
                    try {
                        Class loadClass = context.getClassLoader().loadClass(str);
                        if (XGPushBaseReceiver.class.isAssignableFrom(loadClass) || loadClass.getName().equals(XGPushReceiver.class.getName())) {
                            m29517b(context, str);
                            i++;
                        } else {
                            i++;
                        }
                    } catch (ClassNotFoundException unused) {
                    }
                }
            } catch (Exception e) {
                C6864a.m29302d("Util", "enableComponents", e);
            }
            f22992c = true;
        }
    }

    /* renamed from: a */
    public static String m29506a(long j) {
        try {
            return new SimpleDateFormat("yyyyMMdd").format(Long.valueOf(j));
        } catch (Exception e) {
            C6864a.m29302d("Util", "getDateString", e);
            return "20141111";
        }
    }

    /* renamed from: h */
    public static boolean m29527h(Context context) {
        boolean z = true;
        if (context == null) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName());
        String str = XGPushManager.ENABLE_SERVICE_SUFFIX;
        sb.append(str);
        XGPushManager.enableService = C6907g.m29479b(context, sb.toString(), XGPushManager.enableService);
        if (XGPushManager.enableService == -1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(context.getPackageName());
            sb2.append(str);
            XGPushManager.enableService = C6907g.m29479b(context, sb2.toString(), 2);
        }
        if (XGPushManager.enableService == 2 && TpnsSecurity.checkTpnsSecurityLibSo(context)) {
            String str2 = C6971a.m29749a(context).f23165x;
            if (!m29521c(str2)) {
                String[] split = Rijndael.decrypt(str2).split(StorageInterface.KEY_SPLITER);
                HashMap hashMap = new HashMap();
                for (String valueOf : split) {
                    try {
                        hashMap.put(Long.valueOf(valueOf), Long.valueOf(0));
                    } catch (NumberFormatException unused) {
                    }
                }
                if (hashMap.size() > 0) {
                    if (XGPushConfig.getAccessId(context) > 0 && hashMap.containsKey(Long.valueOf(XGPushConfig.getAccessId(context)))) {
                        XGPushManager.enableService(context, false);
                        return false;
                    } else if (XGPush4Msdk.getQQAccessId(context) > 0 && hashMap.containsKey(Long.valueOf(XGPush4Msdk.getQQAccessId(context)))) {
                        XGPushManager.enableService(context, false);
                        return false;
                    }
                }
            }
        }
        if (XGPushManager.enableService == 0) {
            z = false;
        }
        return z;
    }

    /* renamed from: i */
    public static boolean m29528i(Context context) {
        try {
            return ((PowerManager) context.getSystemService("power")).isScreenOn();
        } catch (Exception e) {
            C6864a.m29302d("Util", "Util -> isScreenOn", e);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001f A[Catch:{ Exception -> 0x0027 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0020 A[Catch:{ Exception -> 0x0027 }] */
    /* renamed from: j */
    public static int m29529j(android.content.Context r3) {
        /*
        r0 = -1
        android.content.IntentFilter r1 = new android.content.IntentFilter     // Catch:{ Exception -> 0x0027 }
        java.lang.String r2 = "android.intent.action.BATTERY_CHANGED"
        r1.<init>(r2)     // Catch:{ Exception -> 0x0027 }
        r2 = 0
        android.content.Intent r3 = r3.registerReceiver(r2, r1)     // Catch:{ Exception -> 0x0027 }
        java.lang.String r1 = "status"
        int r1 = r3.getIntExtra(r1, r0)     // Catch:{ Exception -> 0x0027 }
        r2 = 2
        if (r1 == r2) goto L_0x001c
        r2 = 5
        if (r1 != r2) goto L_0x001a
        goto L_0x001c
    L_0x001a:
        r1 = 0
        goto L_0x001d
    L_0x001c:
        r1 = 1
    L_0x001d:
        if (r1 != 0) goto L_0x0020
        return r0
    L_0x0020:
        java.lang.String r1 = "plugged"
        int r3 = r3.getIntExtra(r1, r0)     // Catch:{ Exception -> 0x0027 }
        return r3
    L_0x0027:
        r3 = move-exception
        java.lang.String r1 = "Util"
        java.lang.String r2 = "Util -> getChangedStatus"
        com.tencent.android.tpush.p580b.C6864a.m29302d(r1, r2, r3)
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.common.C6914l.m29529j(android.content.Context):int");
    }

    /* renamed from: a */
    public static void m29509a() {
        String str = "Util";
        try {
            WakeLock b = C7047e.m30136a().mo34150b();
            if (b != null) {
                if (b.isHeld()) {
                    b.release();
                }
                C6864a.m29298c(str, "stop WakeLock CPU");
            }
        } catch (Throwable th) {
            C6864a.m29302d(str, "stopWakeLock", th);
        }
    }

    /* renamed from: a */
    public static boolean m29515a(C7075d dVar) {
        return dVar != null && dVar.mo34187c();
    }

    /* renamed from: a */
    public static void m29510a(String str, Context context) {
        if (XGPushConfig.isHuaweiDebug()) {
            m29523d(str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* renamed from: d */
    public static void m29523d(java.lang.String r4) {
        /*
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.io.File r1 = android.os.Environment.getExternalStorageDirectory()
        r0.append(r1)
        java.lang.String r1 = "/google.txt"
        r0.append(r1)
        java.lang.String r0 = r0.toString()
        r1 = 0
        java.io.FileWriter r2 = new java.io.FileWriter     // Catch:{ all -> 0x003c }
        r3 = 1
        r2.<init>(r0, r3)     // Catch:{ all -> 0x003c }
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x003a }
        r0.<init>()     // Catch:{ all -> 0x003a }
        r0.append(r4)     // Catch:{ all -> 0x003a }
        java.lang.String r4 = "\r\n"
        r0.append(r4)     // Catch:{ all -> 0x003a }
        java.lang.String r4 = r0.toString()     // Catch:{ all -> 0x003a }
        r2.write(r4)     // Catch:{ all -> 0x003a }
        r2.flush()     // Catch:{ all -> 0x003a }
        r2.close()     // Catch:{ all -> 0x003a }
    L_0x0036:
        r2.close()     // Catch:{ Exception -> 0x0040 }
        goto L_0x0040
        goto L_0x003d
    L_0x003c:
        r2 = r1
    L_0x003d:
        if (r2 == 0) goto L_0x0040
        goto L_0x0036
    L_0x0040:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.common.C6914l.m29523d(java.lang.String):void");
    }

    /* renamed from: k */
    public static void m29530k(Context context) {
        try {
            if ("oppo".equals(m29516b())) {
                Intent intent = new Intent("oppo.safecenter.intent.action.CHANGE_NOTIFICATION_STATE");
                intent.putExtra("package_name", context.getPackageName());
                intent.putExtra("allow_notify", true);
                context.sendBroadcast(intent);
            }
        } catch (Throwable th) {
            String str = "openNotification";
            C6864a.m29294b(str, str, th);
        }
    }

    /* renamed from: l */
    public static void m29531l(Context context) {
        String b = m29516b();
        if (!"meizu".equals(b) && "oppo".equals(b)) {
            try {
                Intent intent = new Intent();
                intent.setClassName("com.coloros.notificationmanager", "com.coloros.notificationmanager.AppDetailPreferenceActivity");
                intent.setAction("com.coloros.notificationmanager.app.detail");
                StringBuilder sb = new StringBuilder();
                sb.append("package:");
                sb.append(context.getPackageName());
                intent.setData(Uri.parse(sb.toString()));
                intent.putExtra("pkg_name", context.getPackageName());
                intent.putExtra("app_name", m29532m(context));
                intent.putExtra("class_name", context.getPackageName());
                context.startActivity(intent);
            } catch (Throwable th) {
                C6864a.m29294b("Util", "openNotificationSettings", th);
            }
        }
    }

    /* renamed from: m */
    public static String m29532m(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i = applicationInfo.labelRes;
            return i == 0 ? applicationInfo.nonLocalizedLabel.toString() : context.getString(i);
        } catch (Throwable th) {
            C6864a.m29302d("Util", "", th);
            return null;
        }
    }

    /* renamed from: b */
    public static String m29516b() {
        String str = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str) ? str.trim().toLowerCase() : str;
    }

    /* renamed from: n */
    public static void m29533n(Context context) {
        String str = "appkey";
        String str2 = ACTD.APPID_KEY;
        String a = m29507a(context, "otherpush_config.json");
        if (!m29521c(a)) {
            try {
                JSONObject jSONObject = new JSONObject(a);
                try {
                    JSONObject optJSONObject = jSONObject.optJSONObject("xiaomi");
                    if (optJSONObject != null) {
                        C6927d.f23006a = optJSONObject.optString(str2, null);
                        C6927d.f23007b = optJSONObject.optString(str, null);
                    }
                } catch (Throwable unused) {
                }
                try {
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("meizu");
                    if (optJSONObject2 != null) {
                        C6927d.f23008c = optJSONObject2.optString(str2, null);
                        C6927d.f23009d = optJSONObject2.optString(str, null);
                    }
                } catch (Throwable unused2) {
                }
            } catch (Throwable th) {
                C6864a.m29302d("Util", "", th);
            }
        }
    }

    /* renamed from: a */
    public static String m29507a(Context context, String str) {
        if (!m29521c(f22990a)) {
            return f22990a;
        }
        try {
            InputStream open = context.getResources().getAssets().open(str);
            if (open == null) {
                return null;
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open));
            String str2 = "";
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(readLine);
                    str2 = sb.toString();
                } else {
                    f22990a = str2;
                    return f22990a;
                }
            }
        } catch (Throwable unused) {
            C6864a.m29298c("Util", "assets is null");
            return null;
        }
    }
}
