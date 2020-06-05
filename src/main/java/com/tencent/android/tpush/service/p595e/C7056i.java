package com.tencent.android.tpush.service.p595e;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.android.tpush.C6860a;
import com.tencent.android.tpush.TypeStr;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushProvider;
import com.tencent.android.tpush.common.C6901c;
import com.tencent.android.tpush.common.C6914l;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.common.MobileType;
import com.tencent.android.tpush.data.RegisterEntity;
import com.tencent.android.tpush.encrypt.C6931a;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.p579a.C6862b;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.service.C6973b;
import com.tencent.android.tpush.service.XGPushServiceV4;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.service.channel.security.TpnsSecurity;
import com.tencent.android.tpush.service.p588a.C6971a;
import com.tencent.android.tpush.service.p594d.C7046a;
import com.tencent.android.tpush.stat.p596a.C7066c;
import com.tencent.bigdata.dataacquisition.CustomDeviceInfos;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import com.tencent.p605ep.commonbase.api.ConfigManager.OEM;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.service.e.i */
public class C7056i {
    /* renamed from: a */
    static List<String> f23439a = new ArrayList();
    /* renamed from: b */
    private static long f23440b = 0;
    /* renamed from: c */
    private static long f23441c = 0;
    /* renamed from: d */
    private static int f23442d = -1;
    /* renamed from: e */
    private static String f23443e = null;

    /* renamed from: a */
    public static String m30177a(Context context) {
        return context != null ? context.getPackageName() : "";
    }

    /* renamed from: b */
    public static void m30191b(Context context) {
        String str = "last_reportAppList_time";
        if (f23440b <= 0) {
            f23440b = C7055h.m30167a(context, str, -1);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f23440b > 259200000) {
            f23440b = currentTimeMillis;
            JSONArray o = m30221o(context);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ap_ls", o);
                C7046a.m30125a(context, "app_list", jSONObject);
            } catch (JSONException unused) {
            }
            C7055h.m30171b(context, str, f23440b);
        }
    }

    /* renamed from: c */
    public static void m30198c(Context context) {
        try {
            int i = C7051d.m30147a(context) ? 1 : 0;
            String str = "notification_st";
            if (f23442d < 0) {
                f23442d = C7053f.m30156b(context, str, -1);
            }
            String str2 = "last_reportNotification_time";
            if (f23441c <= 0) {
                f23441c = C7055h.m30167a(context, str2, -1);
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i != f23442d || currentTimeMillis - f23441c <= 259200000) {
                f23442d = i;
                f23441c = currentTimeMillis;
                C7055h.m30171b(context, str2, f23441c);
                C7053f.m30153a(context, str, i);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("nf_st", f23442d);
                C7046a.m30125a(context, str, jSONObject);
            }
        } catch (Throwable th) {
            C6864a.m29302d(Constants.LogTag, "reportNotificationStatus", th);
        }
    }

    /* renamed from: a */
    public static String m30175a() {
        try {
            return TpnsSecurity.generateLocalSocketServieName(C6973b.m29776f());
        } catch (Exception e) {
            C6864a.m29302d(Constants.ServiceLogTag, "getSocketName", e);
            return null;
        }
    }

    /* renamed from: b */
    public static String m30188b() {
        String a = m30175a();
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        sb.append("V4");
        return C6931a.m29598a(sb.toString());
    }

    /* renamed from: c */
    public static String m30196c() {
        String a = m30175a();
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        sb.append("V4.Slave");
        return C6931a.m29598a(sb.toString());
    }

    /* renamed from: d */
    public static String m30200d(Context context) {
        String b = m30188b();
        String token = CacheManager.getToken(context);
        if (C6914l.m29521c(token) || "0".equals(token)) {
            return b;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(b);
        sb.append(token);
        return sb.toString();
    }

    /* renamed from: e */
    public static List<ResolveInfo> m30205e(Context context) {
        if (context != null) {
            try {
                HashMap hashMap = new HashMap();
                PackageManager packageManager = context.getPackageManager();
                List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(new Intent("android.intent.action"), 32);
                queryIntentActivities.addAll(packageManager.queryIntentActivities(new Intent(""), 32));
                queryIntentActivities.addAll(packageManager.queryBroadcastReceivers(new Intent(Constants.ACTION_SDK_INSTALL), 512));
                for (ResolveInfo resolveInfo : queryIntentActivities) {
                    hashMap.put(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo);
                }
                return new ArrayList(hashMap.values());
            } catch (Exception e) {
                C6864a.m29302d(Constants.ServiceLogTag, "getLocalPushAppsInfo", e);
            }
        }
        return null;
    }

    /* renamed from: a */
    public static boolean m30181a(Context context, Long l) {
        return l.longValue() > 0 && l.longValue() == XGPushConfig.getChannelId(context);
    }

    /* renamed from: a */
    public static List<String> m30179a(Context context, List<String> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (m30215i(context, (String) list.get(i))) {
                arrayList.clear();
                arrayList.add(list.get(i));
                return arrayList;
            }
            if (m30182a(context, (String) list.get(i))) {
                arrayList.add(list.get(i));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static boolean m30182a(Context context, String str) {
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME)).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    public static List<String> m30189b(Context context, Long l) {
        ArrayList arrayList = new ArrayList();
        try {
            for (ResolveInfo resolveInfo : context.getPackageManager().queryBroadcastReceivers(new Intent(Constants.ACTION_SDK_INSTALL), 512)) {
                String str = resolveInfo.activityInfo.applicationInfo.packageName;
                try {
                    Object a = m30174a(context.createPackageContext(str, 0), XGPushConfig.TPUSH_ACCESS_CHANNAL, (Object) null);
                    if (a != null && l.toString().equals(a.toString())) {
                        arrayList.add(str);
                    }
                } catch (Exception unused) {
                }
            }
        } catch (Throwable unused2) {
        }
        return arrayList;
    }

    /* renamed from: b */
    public static List<String> m30190b(Context context, List<Long> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Long c : list) {
            List c2 = m30197c(context, c);
            c2.removeAll(arrayList);
            arrayList.addAll(c2);
        }
        return arrayList;
    }

    /* renamed from: c */
    public static List<String> m30197c(Context context, Long l) {
        ArrayList arrayList = new ArrayList();
        try {
            for (ResolveInfo resolveInfo : context.getPackageManager().queryBroadcastReceivers(new Intent(Constants.ACTION_SDK_INSTALL), 512)) {
                String str = resolveInfo.activityInfo.applicationInfo.packageName;
                try {
                    Object a = m30174a(context.createPackageContext(str, 0), XGPushConfig.TPUSH_ACCESS_ID, (Object) null);
                    if (a != null && l.toString().equals(a.toString())) {
                        arrayList.add(str);
                    }
                } catch (Exception unused) {
                }
            }
        } catch (Throwable unused2) {
        }
        return arrayList;
    }

    /* renamed from: a */
    private static Object m30174a(Context context, String str, Object obj) {
        ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        if (applicationInfo != null) {
            Object obj2 = applicationInfo.metaData.get(str);
            if (obj2 != null) {
                return obj2;
            }
        }
        return obj;
    }

    /* renamed from: d */
    public static List<String> m30202d() {
        if (f23439a.isEmpty()) {
            f23439a.add("com.jingdong.app.mall");
            f23439a.add("com.ifeng.news2");
        }
        return f23439a;
    }

    /* renamed from: a */
    public static boolean m30186a(String str) {
        return m30202d().contains(str);
    }

    /* renamed from: f */
    public static void m30208f(Context context) {
        String str = "/";
        String str2 = "pullUpServerConfigPkgs error exec cmd:";
        String str3 = Constants.ServiceLogTag;
        try {
            Map<String, String> map = C6971a.m29749a(context).f23140K;
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("am startservice -n ");
                    sb.append((String) entry.getKey());
                    sb.append(str);
                    sb.append((String) entry.getValue());
                    String sb2 = sb.toString();
                    Process exec = Runtime.getRuntime().exec(sb2);
                    int waitFor = exec.waitFor();
                    if (waitFor != 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("am startservice --user 0 -n ");
                        sb3.append((String) entry.getKey());
                        sb3.append(str);
                        sb3.append((String) entry.getValue());
                        sb2 = sb3.toString();
                        exec = Runtime.getRuntime().exec(sb2);
                        waitFor = exec.waitFor();
                    }
                    if (waitFor != 0) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(str2);
                        sb4.append(sb2);
                        sb4.append(",exitValud:");
                        sb4.append(exec.exitValue());
                        C6864a.m29308i(str3, sb4.toString());
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    static boolean m30192b(Context context, String str) {
        if (str == null) {
            return false;
        }
        for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME)).getRunningAppProcesses()) {
            if (runningAppProcessInfo != null && runningAppProcessInfo.processName != null && runningAppProcessInfo.processName.startsWith(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: g */
    public static void m30210g(Context context) {
        try {
            JSONArray jSONArray = C6971a.m29749a(context).f23139J;
            if (jSONArray != null) {
                if (jSONArray.length() != 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        m30180a(context, jSONArray.optJSONObject(i));
                    }
                    return;
                }
            }
            C6864a.m29306g("Util", "pullupOtherServiceByProviderAndActivity no running");
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("pullupOtherServiceByProviderAndActivity");
            sb.append(th);
            C6864a.m29308i(Constants.ServiceLogTag, sb.toString());
        }
    }

    /* renamed from: a */
    public static void m30180a(final Context context, JSONObject jSONObject) {
        if (jSONObject != null) {
            String str = "";
            final String optString = jSONObject.optString(ArgKey.KEY_NAME, str);
            if (!m30194b(optString) && !m30192b(context, optString)) {
                StringBuilder sb = new StringBuilder();
                sb.append("pullUpOtherServiceByProviderAndActivityJSONOject ");
                sb.append(optString);
                C6864a.m29306g("Util", sb.toString());
                String optString2 = jSONObject.optString("intent", str);
                if (!m30194b(optString2)) {
                    try {
                        Intent intent = new Intent(optString2);
                        intent.setFlags(268435456);
                        context.startActivity(intent);
                    } catch (Throwable unused) {
                    }
                }
                final String optString3 = jSONObject.optString("url", str);
                if (!m30194b(optString3)) {
                    C6901c.m29459a().mo33106a(new Runnable() {
                        public void run() {
                            try {
                                if (!C7056i.m30192b(context, optString)) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("content://");
                                    sb.append(optString3);
                                    C6862b.m29275a(context, Uri.parse(sb.toString()));
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    }, 2000);
                }
            }
        }
    }

    /* renamed from: h */
    public static void m30212h(Context context) {
        C6860a.m29257b(context);
        String str = "Util";
        if (m30186a(context.getPackageName())) {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getPackageName());
            sb.append(" ingore.");
            C6864a.m29306g(str, sb.toString());
            return;
        }
        try {
            if (m30214i(context) >= 2) {
                C6864a.m29306g(str, "more than two XGV3 service running");
            } else {
                m30229w(context);
                m30230x(context);
            }
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("pullUpXGServiceByRemoteService");
            sb2.append(th);
            C6864a.m29308i(Constants.ServiceLogTag, sb2.toString());
        }
        m30210g(context);
        m30208f(context);
    }

    /* renamed from: w */
    private static void m30229w(Context context) {
        String str = "/";
        String str2 = "pull up error exec cmd:";
        List<ResolveInfo> e = m30205e(context);
        if (m30214i(context) < 2) {
            String str3 = Constants.ServiceLogTag;
            if (e != null) {
                int i = 0;
                for (ResolveInfo resolveInfo : e) {
                    i++;
                    if ("oppo".equals(C6914l.m29516b())) {
                        if (i > 2) {
                            return;
                        }
                    } else if (i > 4) {
                        return;
                    }
                    String str4 = resolveInfo.activityInfo.applicationInfo.packageName;
                    if (!m30194b(str4) && !context.getPackageName().equals(str4) && !m30203d(context, str4)) {
                        if (m30214i(context) < 2) {
                            try {
                                StringBuilder sb = new StringBuilder();
                                sb.append("am startservice -n ");
                                sb.append(str4);
                                sb.append(str);
                                sb.append(XGPushServiceV4.class.getName());
                                String sb2 = sb.toString();
                                Process exec = Runtime.getRuntime().exec(sb2);
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("pull up pullUpXGServiceByRemoteService ");
                                sb3.append(str4);
                                C6864a.m29298c(str3, sb3.toString());
                                int waitFor = exec.waitFor();
                                if (waitFor != 0) {
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append("am startservice --user 0 -n ");
                                    sb4.append(str4);
                                    sb4.append(str);
                                    sb4.append(XGPushServiceV4.class.getName());
                                    sb2 = sb4.toString();
                                    exec = Runtime.getRuntime().exec(sb2);
                                    waitFor = exec.waitFor();
                                }
                                if (waitFor != 0) {
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append(str2);
                                    sb5.append(sb2);
                                    sb5.append(",exitValud:");
                                    sb5.append(exec.exitValue());
                                    C6864a.m29308i(str3, sb5.toString());
                                }
                            } catch (Throwable th) {
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append(str2);
                                sb6.append(th);
                                C6864a.m29308i(str3, sb6.toString());
                            }
                        } else {
                            return;
                        }
                    }
                }
            } else {
                C6864a.m29305f(str3, "pullupXGServices  with null content");
            }
        }
    }

    /* renamed from: x */
    private static void m30230x(final Context context) {
        if (m30214i(context) < 2) {
            C6901c.m29459a().mo33106a(new Runnable() {
                public void run() {
                    if (C7056i.m30214i(context) < 2) {
                        List<ResolveInfo> e = C7056i.m30205e(context);
                        int i = 0;
                        String str = Constants.ServiceLogTag;
                        if (e != null) {
                            for (ResolveInfo resolveInfo : e) {
                                i++;
                                if ("oppo".equals(C6914l.m29516b())) {
                                    if (i > 2) {
                                        return;
                                    }
                                } else if (i > 4) {
                                    return;
                                }
                                String str2 = resolveInfo.activityInfo.applicationInfo.packageName;
                                if (!C7056i.m30194b(str2) && !context.getPackageName().equals(str2) && !C7056i.m30203d(context, str2) && C7056i.m30199c(context, str2)) {
                                    try {
                                        if (C7056i.m30214i(context) < 2) {
                                            StringBuilder sb = new StringBuilder();
                                            sb.append("pull up by provider ");
                                            sb.append(str2);
                                            C6864a.m29298c(str, sb.toString());
                                            StringBuilder sb2 = new StringBuilder();
                                            sb2.append("content://");
                                            sb2.append(str2);
                                            sb2.append(XGPushProvider.AUTH_PRIX);
                                            sb2.append("/");
                                            sb2.append(TypeStr.pullupxg.getStr());
                                            C6862b.m29275a(context, Uri.parse(sb2.toString()));
                                            Thread.sleep(200);
                                        } else {
                                            return;
                                        }
                                    } catch (Throwable th) {
                                        StringBuilder sb3 = new StringBuilder();
                                        sb3.append("pull up by provider error");
                                        sb3.append(th);
                                        C6864a.m29308i(str, sb3.toString());
                                    }
                                }
                            }
                        } else {
                            C6864a.m29305f(str, "pullupXGServices  with null content");
                        }
                    }
                }
            }, 2000);
        }
    }

    /* renamed from: i */
    public static int m30214i(Context context) {
        int i;
        int i2 = 0;
        try {
            List<RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME)).getRunningServices(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            if (runningServices != null && runningServices.size() > 0) {
                String name = XGPushServiceV4.class.getName();
                for (RunningServiceInfo runningServiceInfo : runningServices) {
                    if (name.equals(runningServiceInfo.service.getClassName())) {
                        i2++;
                    }
                }
            }
        } catch (Throwable th) {
            C6864a.m29302d(Constants.ServiceLogTag, "checkXGServiceV3IsRunningByPkgName", th);
        }
        return i;
    }

    /* renamed from: c */
    public static boolean m30199c(Context context, String str) {
        try {
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(new Intent(context.createPackageContext(str, 0), XGPushServiceV4.class), 0);
            if (queryIntentServices != null) {
                if (!queryIntentServices.isEmpty()) {
                    for (ResolveInfo resolveInfo : queryIntentServices) {
                        if (resolveInfo.serviceInfo.processName.contains("xg_service")) {
                            return true;
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* renamed from: d */
    public static boolean m30203d(Context context, String str) {
        String str2 = Constants.ServiceLogTag;
        try {
            List<RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME)).getRunningServices(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            if (runningServices != null && runningServices.size() > 0) {
                String name = XGPushServiceV4.class.getName();
                for (RunningServiceInfo runningServiceInfo : runningServices) {
                    if (name.equals(runningServiceInfo.service.getClassName())) {
                        String packageName = runningServiceInfo.service.getPackageName();
                        if (C7066c.m30262b(packageName) && packageName.equals(str)) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("isSurvive srvPkg :");
                            sb.append(packageName);
                            C6864a.m29298c(str2, sb.toString());
                            return true;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            C6864a.m29302d(str2, "checkXGServiceV3IsRunningByPkgName", th);
        }
        return false;
    }

    /* renamed from: e */
    public static List<ResolveInfo> m30206e(Context context, String str) {
        String str2 = Constants.ServiceLogTag;
        List<ResolveInfo> list = null;
        if (context != null) {
            try {
                list = context.getPackageManager().queryIntentServices(new Intent(str), 512);
                return list;
            } catch (Exception e) {
                C6864a.m29302d(str2, "getLocalPushServicesInfo", e);
                return list;
            }
        } else {
            C6864a.m29308i(str2, "getLocalPushServicesInfo the context == null");
            return null;
        }
    }

    /* renamed from: f */
    public static boolean m30209f(Context context, String str) {
        if (!C6914l.m29521c(str) && context != null) {
            try {
                List<ResolveInfo> e = m30205e(context);
                if (e != null) {
                    for (ResolveInfo resolveInfo : e) {
                        if (str.equals(resolveInfo.activityInfo.packageName)) {
                            return true;
                        }
                    }
                }
            } catch (Exception e2) {
                C6864a.m29302d(Constants.ServiceLogTag, "isLocalApp", e2);
            }
        }
        return false;
    }

    /* renamed from: g */
    public static boolean m30211g(Context context, String str) {
        if (!C6914l.m29521c(str) && context != null) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(Constants.RPC_SUFFIX);
                List e = m30206e(context, sb.toString());
                if (e == null || e.size() > 0) {
                    return true;
                }
            } catch (Exception e2) {
                C6864a.m29302d(Constants.ServiceLogTag, "isPkgHasRemoteService", e2);
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m30183a(Context context, String str, long j) {
        return m30184a(context, str, j, false);
    }

    /* renamed from: a */
    private static boolean m30184a(Context context, String str, long j, boolean z) {
        PackageManager packageManager = context.getPackageManager();
        boolean z2 = false;
        try {
            packageManager.getPackageInfo(str, 0);
        } catch (Exception e) {
            if (m30209f(context, str) || m30211g(context, str)) {
                return true;
            }
            if (z) {
                try {
                    List registerInfo = CacheManager.getRegisterInfo(context);
                    if (registerInfo != null) {
                        Iterator it = registerInfo.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            RegisterEntity registerEntity = (RegisterEntity) it.next();
                            if (registerEntity.accessId == j) {
                                try {
                                    packageManager.getPackageInfo(registerEntity.packageName, 0);
                                    break;
                                } catch (Exception unused) {
                                    continue;
                                }
                            }
                        }
                    }
                } catch (Exception unused2) {
                    C6864a.m29302d(Constants.ServiceLogTag, "isAppInstalled", e);
                }
            }
        }
        z2 = true;
        return z2;
    }

    /* renamed from: h */
    public static boolean m30213h(Context context, String str) {
        if (context != null) {
            List<String> registerInfos = CacheManager.getRegisterInfos(context);
            if (registerInfos != null) {
                for (String equals : registerInfos) {
                    if (equals.equals(str) && !context.getPackageName().equals(str)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m30194b(String str) {
        return str == null || str.length() == 0 || str.trim().length() == 0;
    }

    /* renamed from: e */
    public static int m30204e() {
        return VERSION.SDK_INT;
    }

    /* renamed from: j */
    public static boolean m30216j(Context context) {
        List registerInfos = CacheManager.getRegisterInfos(context);
        return registerInfos != null && registerInfos.size() > 0;
    }

    /* renamed from: k */
    public static byte m30217k(Context context) {
        byte type = MobileType.UNKNOWN.getType();
        if (context == null) {
            return type;
        }
        try {
            String simOperator = CustomDeviceInfos.getSimOperator(context);
            if (simOperator == null) {
                return type;
            }
            if (!simOperator.equals("46000") && !simOperator.equals("46002") && !simOperator.equals("46007")) {
                if (!simOperator.equals("46020")) {
                    if (!simOperator.equals("46001")) {
                        if (!simOperator.equals("46006")) {
                            if (simOperator.equals("46003") || simOperator.equals("46005")) {
                                return MobileType.TELCOM.getType();
                            }
                            return type;
                        }
                    }
                    return MobileType.UNICOM.getType();
                }
            }
            return MobileType.CHINAMOBILE.getType();
        } catch (Exception e) {
            C6864a.m29302d(Constants.ServiceLogTag, "getIsp", e);
            return type;
        }
    }

    /* renamed from: l */
    public static String m30218l(Context context) {
        String str = "";
        if (context != null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.getType() == 1) {
                    return m30219m(context);
                }
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(m30217k(context));
                sb.append(DeviceInfos.getNetworkType(context));
                return sb.toString();
            } catch (Exception e) {
                C6864a.m29302d(Constants.ServiceLogTag, "getKey", e);
            }
        }
        return str;
    }

    /* renamed from: m */
    public static String m30219m(Context context) {
        String wiFiBBSID = CustomDeviceInfos.getWiFiBBSID(context);
        if (wiFiBBSID != null && wiFiBBSID.length() != 0) {
            return wiFiBBSID;
        }
        String ip = CustomDeviceInfos.getIp(context);
        return (ip == null || ip.length() == 0) ? "0" : ip;
    }

    /* renamed from: c */
    public static long m30195c(String str) {
        if (str == null || str.equals("0")) {
            return 0;
        }
        String trim = str.trim();
        long[] jArr = new long[4];
        String str2 = ".";
        int indexOf = trim.indexOf(str2);
        int i = indexOf + 1;
        int indexOf2 = trim.indexOf(str2, i);
        int i2 = indexOf2 + 1;
        int indexOf3 = trim.indexOf(str2, i2);
        try {
            jArr[3] = Long.parseLong(trim.substring(0, indexOf));
            jArr[2] = Long.parseLong(trim.substring(i, indexOf2));
            jArr[1] = Long.parseLong(trim.substring(i2, indexOf3));
            jArr[0] = Long.parseLong(trim.substring(indexOf3 + 1));
        } catch (Throwable th) {
            for (int i3 = 0; i3 < jArr.length; i3++) {
                jArr[i3] = 0;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("service Util@@parseIpAddress(");
            sb.append(trim);
            sb.append(")");
            C6864a.m29302d(Constants.LogTag, sb.toString(), th);
        }
        return (jArr[0] << 24) + (jArr[1] << 16) + (jArr[2] << 8) + jArr[3];
    }

    /* renamed from: a */
    public static String m30176a(long j) {
        StringBuffer stringBuffer = new StringBuffer("");
        stringBuffer.append(String.valueOf(255 & j));
        String str = ".";
        stringBuffer.append(str);
        stringBuffer.append(String.valueOf((65535 & j) >>> 8));
        stringBuffer.append(str);
        stringBuffer.append(String.valueOf((16777215 & j) >>> 16));
        stringBuffer.append(str);
        stringBuffer.append(String.valueOf(j >>> 24));
        return stringBuffer.toString();
    }

    /* renamed from: d */
    public static String m30201d(String str) {
        if (C6973b.m29776f() != null) {
            try {
                return TpnsSecurity.getEncryptAPKSignature(C6973b.m29776f().createPackageContext(str, 0));
            } catch (NameNotFoundException e) {
                C6864a.m29302d(Constants.LogTag, "+++ getAppCert exception.", e);
            }
        }
        return "";
    }

    /* renamed from: a */
    public static Intent m30173a(int i, String str, int i2) {
        Intent intent = new Intent(Constants.ACTION_FEEDBACK);
        if (!(str == null || str.length() == 0)) {
            intent.setPackage(str);
        }
        intent.putExtra(Constants.FEEDBACK_TAG, i2);
        intent.putExtra(Constants.FEEDBACK_ERROR_CODE, i);
        return intent;
    }

    /* renamed from: a */
    public static boolean m30185a(Intent intent) {
        String str = MessageKey.MSG_ACCEPT_TIME_MIN;
        String str2 = MessageKey.MSG_ACCEPT_TIME_HOUR;
        String str3 = MessageKey.MSG_ACCEPT_TIME;
        try {
            JSONObject jSONObject = new JSONObject(Rijndael.decrypt(intent.getStringExtra(MessageKey.MSG_CONTENT)));
            if (jSONObject.isNull(str3)) {
                return true;
            }
            String string = jSONObject.getString(str3);
            JSONArray jSONArray = new JSONArray(string);
            if (jSONArray.length() == 0) {
                return true;
            }
            Calendar instance = Calendar.getInstance();
            long longExtra = intent.getLongExtra(MessageKey.MSG_SERVER_TIME, 0);
            long longExtra2 = intent.getLongExtra(MessageKey.MSG_TIME_GAP, 0);
            int i = (longExtra > 0 ? 1 : (longExtra == 0 ? 0 : -1));
            if (!(i == 0 || longExtra2 == 0 || i != 0)) {
                instance.setTimeInMillis(System.currentTimeMillis() - longExtra2);
            }
            int i2 = (instance.get(11) * 60) + instance.get(12);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject2 = new JSONObject(jSONArray.getString(i3));
                JSONObject jSONObject3 = new JSONObject(jSONObject2.getString(MessageKey.MSG_ACCEPT_TIME_START));
                int intValue = (Integer.valueOf(jSONObject3.getString(str2)).intValue() * 60) + Integer.valueOf(jSONObject3.getString(str)).intValue();
                JSONObject jSONObject4 = new JSONObject(jSONObject2.getString(MessageKey.MSG_ACCEPT_TIME_END));
                int intValue2 = (Integer.valueOf(jSONObject4.getString(str2)).intValue() * 60) + Integer.valueOf(jSONObject4.getString(str)).intValue();
                if (intValue <= i2 && i2 <= intValue2) {
                    return true;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(" discurd the msg due to time not accepted! acceptTime = ");
            sb.append(string);
            sb.append(" , curTime= ");
            sb.append(i2);
            C6864a.m29308i("Utils", sb.toString());
            return false;
        } catch (Throwable th) {
            C6864a.m29302d(Constants.ServiceLogTag, "checkAcceptTime", th);
            return true;
        }
    }

    /* renamed from: b */
    public static long m30187b(Intent intent) {
        String str = MessageKey.MSG_ACCEPT_TIME;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
            String stringExtra = intent.getStringExtra(MessageKey.MSG_DATE);
            if (m30194b(stringExtra)) {
                stringExtra = simpleDateFormat.format(new Date());
            }
            long time = simpleDateFormat.parse(stringExtra).getTime();
            JSONObject jSONObject = new JSONObject(Rijndael.decrypt(intent.getStringExtra(MessageKey.MSG_CONTENT)));
            if (jSONObject.isNull(str)) {
                return time;
            }
            String string = jSONObject.getString(str);
            JSONArray jSONArray = new JSONArray(string);
            if (jSONArray.length() == 0) {
                return time;
            }
            int i = 0;
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject2 = new JSONObject(new JSONObject(jSONArray.getString(i2)).getString(MessageKey.MSG_ACCEPT_TIME_START));
                int intValue = (Integer.valueOf(jSONObject2.getString(MessageKey.MSG_ACCEPT_TIME_HOUR)).intValue() * 60) + Integer.valueOf(jSONObject2.getString(MessageKey.MSG_ACCEPT_TIME_MIN)).intValue();
                if (intValue < i || i == 0) {
                    i = intValue;
                }
            }
            long j = time + (((long) (i * 60)) * 1000);
            long longExtra = intent.getLongExtra(MessageKey.MSG_SERVER_TIME, 0);
            long longExtra2 = intent.getLongExtra(MessageKey.MSG_TIME_GAP, 0);
            int i3 = (longExtra > 0 ? 1 : (longExtra == 0 ? 0 : -1));
            if (!(i3 == 0 || longExtra2 == 0 || i3 != 0)) {
                j += longExtra2;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("get acceptTime = ");
            sb.append(string);
            sb.append(" , acceptBeginTime= ");
            sb.append(j);
            C6864a.m29303e("Utils", sb.toString());
            return j;
        } catch (Throwable th) {
            C6864a.m29302d(Constants.ServiceLogTag, "getAcceptBeginTime", th);
            return 0;
        }
    }

    /* renamed from: n */
    public static String m30220n(Context context) {
        if (context == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
        if (resolveActivity == null || resolveActivity.activityInfo == null || resolveActivity.activityInfo.packageName.equals("android")) {
            return null;
        }
        return resolveActivity.activityInfo.packageName;
    }

    /* renamed from: e */
    private static boolean m30207e(String str) {
        if (m30194b(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (!lowerCase.contains(".lbe.") && !lowerCase.contains(".qihoo360.") && !lowerCase.contains("jinshan.") && !lowerCase.contains(".qqpimsecure") && !lowerCase.contains(".phonoalbumshoushou") && !lowerCase.contains(".netqin.") && !lowerCase.contains(".kms.") && !lowerCase.contains(".avg.") && !lowerCase.contains(".am321.") && !lowerCase.contains("safe") && !lowerCase.contains("security") && !lowerCase.contains("clean")) {
            return false;
        }
        return true;
    }

    /* renamed from: o */
    public static JSONArray m30221o(Context context) {
        JSONArray jSONArray = new JSONArray();
        try {
            Map recentTasks = CustomDeviceInfos.getRecentTasks(context);
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                Map runningAppProces = CustomDeviceInfos.getRunningAppProces(context);
                List<ResolveInfo> e = m30205e(context);
                HashMap hashMap = new HashMap();
                if (e != null && e.size() > 0) {
                    for (ResolveInfo resolveInfo : e) {
                        if (resolveInfo.activityInfo != null) {
                            hashMap.put(resolveInfo.activityInfo.packageName, Integer.valueOf(1));
                        }
                    }
                }
                for (PackageInfo packageInfo : CustomDeviceInfos.getInstalledPackages(context)) {
                    JSONObject jSONObject = new JSONObject();
                    ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                    String str = "1";
                    if ((packageInfo.applicationInfo.flags & 1) != 0) {
                        if (m30207e(applicationInfo.packageName)) {
                            jSONObject.put("s", str);
                        }
                    }
                    String charSequence = packageManager.getApplicationLabel(packageInfo.applicationInfo).toString();
                    if (charSequence != null) {
                        jSONObject.put("n", charSequence);
                    }
                    if (applicationInfo.packageName != null) {
                        jSONObject.put("pn", applicationInfo.packageName);
                    }
                    if (packageInfo.versionName != null) {
                        jSONObject.put("av", packageInfo.versionName);
                    }
                    if (runningAppProces.containsKey(applicationInfo.packageName)) {
                        jSONObject.put("rn", str);
                    }
                    if (hashMap.containsKey(applicationInfo.packageName)) {
                        jSONObject.put("xg", str);
                    }
                    jSONObject.put("fit", packageInfo.firstInstallTime / 1000);
                    jSONObject.put("lut", packageInfo.lastUpdateTime / 1000);
                    jSONObject.put("fg", packageInfo.applicationInfo.flags);
                    if (recentTasks.containsKey(applicationInfo.packageName)) {
                        jSONObject.put("rt", 1);
                    }
                    jSONArray.put(jSONObject);
                }
            }
        } catch (Throwable th) {
            C6864a.m29302d(Constants.LogTag, "failed to get app.", th);
        }
        return jSONArray;
    }

    /* renamed from: p */
    public static JSONArray m30222p(Context context) {
        JSONArray jSONArray = new JSONArray();
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                Map runningAppProces = CustomDeviceInfos.getRunningAppProces(context);
                List<ResolveInfo> e = m30205e(context);
                HashMap hashMap = new HashMap();
                if (e != null && e.size() > 0) {
                    for (ResolveInfo resolveInfo : e) {
                        if (resolveInfo.activityInfo != null) {
                            hashMap.put(resolveInfo.activityInfo.packageName, Integer.valueOf(1));
                        }
                    }
                }
                for (PackageInfo packageInfo : CustomDeviceInfos.getInstalledPackages(context)) {
                    JSONObject jSONObject = new JSONObject();
                    ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                    if (runningAppProces.containsKey(applicationInfo.packageName) || hashMap.containsKey(applicationInfo.packageName)) {
                        String str = "1";
                        if ((packageInfo.applicationInfo.flags & 1) != 0) {
                            if (m30207e(applicationInfo.packageName)) {
                                jSONObject.put("s", str);
                            }
                        }
                        String charSequence = packageManager.getApplicationLabel(packageInfo.applicationInfo).toString();
                        if (charSequence != null) {
                            jSONObject.put("n", charSequence);
                        }
                        if (applicationInfo.packageName != null) {
                            jSONObject.put(com.p522qq.p523e.comm.constants.Constants.PORTRAIT, applicationInfo.packageName);
                        }
                        if (packageInfo.versionName != null) {
                            jSONObject.put("v", packageInfo.versionName);
                        }
                        if (runningAppProces.containsKey(applicationInfo.packageName)) {
                            jSONObject.put("r", str);
                        }
                        if (hashMap.containsKey(applicationInfo.packageName)) {
                            jSONObject.put("xg", str);
                        }
                        jSONArray.put(jSONObject);
                    }
                }
            }
        } catch (Throwable th) {
            C6864a.m29302d(Constants.LogTag, "failed to get app.", th);
        }
        return jSONArray;
    }

    /* renamed from: a */
    public static String m30178a(String str, int i) {
        int length = str.length();
        if (length >= i) {
            return str;
        }
        for (int i2 = 0; i2 < i - length; i2++) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" ");
            str = sb.toString();
        }
        return str;
    }

    /* renamed from: q */
    public static boolean m30223q(Context context) {
        try {
            ApplicationInfo r = m30224r(context);
            String str = Constants.LogTag;
            if (r == null) {
                C6864a.m29309j(str, "Failed to init due to null ApplicationInfo.");
                return false;
            } else if (r.icon != 0) {
                return true;
            } else {
                C6864a.m29309j(str, "Failed to get Application icon in AndroidManifest.xml, You App maybe can not show notification, Please add Application icon in AndroidManifest.xml");
                return false;
            }
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: r */
    public static ApplicationInfo m30224r(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
        } catch (Exception e) {
            C6864a.m29304e(Constants.LogTag, "Failed to get Application info", e);
            return null;
        }
    }

    /* renamed from: s */
    public static boolean m30225s(Context context) {
        return m30215i(context, context.getPackageName());
    }

    /* renamed from: i */
    public static boolean m30215i(Context context, String str) {
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME)).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(str) && runningAppProcessInfo.importance == 100) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m30193b(Context context, String str, long j) {
        return m30184a(context, str, j, false);
    }

    /* renamed from: t */
    public static String m30226t(Context context) {
        if (TextUtils.isEmpty(f23443e)) {
            int myPid = Process.myPid();
            Iterator it = ((ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME)).getRunningAppProcesses().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                RunningAppProcessInfo runningAppProcessInfo = (RunningAppProcessInfo) it.next();
                if (myPid == runningAppProcessInfo.pid) {
                    f23443e = runningAppProcessInfo.processName;
                    break;
                }
            }
        }
        return f23443e;
    }

    /* renamed from: u */
    public static void m30227u(Context context) {
        try {
            String t = m30226t(context);
            if (!t.contains(":xg_service_v")) {
                return;
            }
            if (!OEM.HUAWEI.equalsIgnoreCase(Build.MANUFACTURER)) {
                Process.killProcess(Process.myPid());
                return;
            }
            String str = Constants.ServiceLogTag;
            StringBuilder sb = new StringBuilder();
            sb.append("serviceSafeExit @ ");
            sb.append(t);
            C6864a.m29298c(str, sb.toString());
            XGPushServiceV4.m29691b().stopSelf();
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x005e A[SYNTHETIC, Splitter:B:27:0x005e] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0068 A[SYNTHETIC, Splitter:B:32:0x0068] */
    /* renamed from: v */
    public static boolean m30228v(android.content.Context r8) {
        /*
        java.lang.String r0 = "MainService finallocalSocket.close()"
        java.lang.String r1 = "MainService localSocket.close()"
        java.lang.String r2 = "TPush"
        r3 = 0
        java.lang.String r4 = m30188b()     // Catch:{ all -> 0x0055 }
        android.net.LocalServerSocket r5 = new android.net.LocalServerSocket     // Catch:{ all -> 0x0055 }
        r5.<init>(r4)     // Catch:{ all -> 0x0055 }
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0056 }
        r6.<init>()     // Catch:{ all -> 0x0056 }
        java.lang.String r7 = "MainService : socketName: "
        r6.append(r7)     // Catch:{ all -> 0x0056 }
        r6.append(r4)     // Catch:{ all -> 0x0056 }
        java.lang.String r4 = r6.toString()     // Catch:{ all -> 0x0056 }
        com.tencent.android.tpush.p580b.C6864a.m29293b(r2, r4)     // Catch:{ all -> 0x0056 }
        java.lang.String r8 = m30200d(r8)     // Catch:{ all -> 0x0056 }
        android.net.LocalServerSocket r4 = new android.net.LocalServerSocket     // Catch:{ all -> 0x0056 }
        r4.<init>(r8)     // Catch:{ all -> 0x0056 }
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0053 }
        r3.<init>()     // Catch:{ all -> 0x0053 }
        java.lang.String r6 = "MainService not Alive: socketFinalName: "
        r3.append(r6)     // Catch:{ all -> 0x0053 }
        r3.append(r8)     // Catch:{ all -> 0x0053 }
        java.lang.String r8 = r3.toString()     // Catch:{ all -> 0x0053 }
        com.tencent.android.tpush.p580b.C6864a.m29293b(r2, r8)     // Catch:{ all -> 0x0053 }
        r8 = 0
        r5.close()     // Catch:{ all -> 0x0046 }
        goto L_0x004a
    L_0x0046:
        r3 = move-exception
        com.tencent.android.tpush.p580b.C6864a.m29302d(r2, r1, r3)
    L_0x004a:
        r4.close()     // Catch:{ all -> 0x004e }
        goto L_0x0052
    L_0x004e:
        r1 = move-exception
        com.tencent.android.tpush.p580b.C6864a.m29302d(r2, r0, r1)
    L_0x0052:
        return r8
    L_0x0053:
        r3 = r4
        goto L_0x0056
    L_0x0055:
        r5 = r3
    L_0x0056:
        java.lang.String r8 = "MainService is Alive"
        com.tencent.android.tpush.p580b.C6864a.m29286a(r2, r8)     // Catch:{ all -> 0x0071 }
        r8 = 1
        if (r5 == 0) goto L_0x0066
        r5.close()     // Catch:{ all -> 0x0062 }
        goto L_0x0066
    L_0x0062:
        r4 = move-exception
        com.tencent.android.tpush.p580b.C6864a.m29302d(r2, r1, r4)
    L_0x0066:
        if (r3 == 0) goto L_0x0070
        r3.close()     // Catch:{ all -> 0x006c }
        goto L_0x0070
    L_0x006c:
        r1 = move-exception
        com.tencent.android.tpush.p580b.C6864a.m29302d(r2, r0, r1)
    L_0x0070:
        return r8
    L_0x0071:
        r8 = move-exception
        if (r5 == 0) goto L_0x007c
        r5.close()     // Catch:{ all -> 0x0078 }
        goto L_0x007c
    L_0x0078:
        r4 = move-exception
        com.tencent.android.tpush.p580b.C6864a.m29302d(r2, r1, r4)
    L_0x007c:
        if (r3 == 0) goto L_0x0086
        r3.close()     // Catch:{ all -> 0x0082 }
        goto L_0x0086
    L_0x0082:
        r1 = move-exception
        com.tencent.android.tpush.p580b.C6864a.m29302d(r2, r0, r1)
    L_0x0086:
        throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.service.p595e.C7056i.m30228v(android.content.Context):boolean");
    }
}
