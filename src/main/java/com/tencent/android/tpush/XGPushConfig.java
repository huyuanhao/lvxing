package com.tencent.android.tpush;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.android.tpush.common.C6900b;
import com.tencent.android.tpush.common.C6901c;
import com.tencent.android.tpush.common.C6908h;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.p584d.C6916a;
import com.tencent.android.tpush.p584d.C6927d;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.service.channel.security.TpnsSecurity;
import com.tencent.android.tpush.service.p588a.C6971a;
import com.tencent.android.tpush.service.p595e.C7055h;
import com.tencent.android.tpush.service.p595e.C7056i;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public class XGPushConfig {
    public static final String TPUSH_ACCESS_CHANNAL = "XG_V4_CHANNEL_ID";
    public static final String TPUSH_ACCESS_ID = "XG_V2_ACCESS_ID";
    public static final String TPUSH_ACCESS_KEY = "XG_V2_ACCESS_KEY";
    public static final String TPUSH_IS_FOREIGINPUSH = "TPUSH_IS_FOREIGINPUSH";
    public static boolean _isHuaweiDebug = false;
    /* access modifiers changed from: private|static|final */
    /* renamed from: a */
    public static final String f22711a = XGPushConfig.class.getSimpleName();
    /* renamed from: b */
    private static String f22712b;
    /* renamed from: c */
    private static String f22713c;
    /* renamed from: d */
    private static long f22714d = -1;
    /* renamed from: e */
    private static long f22715e = -1;
    public static Boolean enableApplist = null;
    public static boolean enableDebug = false;
    public static Boolean enableLocation = null;
    public static Boolean enableNotification = null;
    /* renamed from: f */
    private static String f22716f;
    /* renamed from: g */
    private static Boolean f22717g = null;
    /* renamed from: h */
    private static Boolean f22718h = null;
    /* renamed from: i */
    private static SharedPreferences f22719i = null;
    public static Boolean isUsedFcmPush = null;
    public static Boolean isUsedOtherPush = null;

    public static void setForeiginPushEnable(Context context, boolean z) {
    }

    static {
        String str = "";
        f22712b = str;
        f22713c = str;
        f22716f = str;
    }

    public static synchronized long getChannelId(Context context) {
        synchronized (XGPushConfig.class) {
            if (context == null) {
                long j = f22715e;
                return j;
            } else if (f22715e != -1) {
                long j2 = f22715e;
                return j2;
            } else if (!TpnsSecurity.checkTpnsSecurityLibSo(context)) {
                long j3 = f22715e;
                return j3;
            } else {
                if (f22715e == -1) {
                    Object a = C6900b.m29455a(context, TPUSH_ACCESS_CHANNAL, (Object) null);
                    if (a != null) {
                        try {
                            f22715e = Long.valueOf(a.toString()).longValue();
                        } catch (Exception e) {
                            C6864a.m29299c(Constants.LogTag, "get channelId from getMetaData failed: ", e);
                            f22715e = -1;
                        }
                    }
                }
                if (f22715e == -1) {
                    C6864a.m29298c(Constants.LogTag, "channelId没有初始化");
                }
                long j4 = f22715e;
                return j4;
            }
        }
    }

    public static synchronized long getAccessId(Context context) {
        synchronized (XGPushConfig.class) {
            if (context == null) {
                long j = f22714d;
                return j;
            } else if (f22714d != -1) {
                long j2 = f22714d;
                return j2;
            } else if (!TpnsSecurity.checkTpnsSecurityLibSo(context)) {
                long j3 = f22714d;
                return j3;
            } else {
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                if (defaultSharedPreferences != null) {
                    String string = defaultSharedPreferences.getString(TPUSH_ACCESS_ID, null);
                    if (string != null) {
                        try {
                            f22714d = Long.valueOf(Rijndael.decrypt(string)).longValue();
                        } catch (Exception e) {
                            f22714d = -1;
                            C6864a.m29299c(f22711a, "get accessId error", e);
                        }
                    }
                }
                if (f22714d == -1) {
                    Object a = C6900b.m29455a(context, TPUSH_ACCESS_ID, (Object) null);
                    if (a != null) {
                        try {
                            f22714d = Long.valueOf(a.toString()).longValue();
                        } catch (Exception e2) {
                            C6864a.m29299c(Constants.LogTag, "get accessId from getMetaData failed: ", e2);
                            f22714d = -1;
                        }
                    }
                }
                if (f22714d == -1) {
                    C6864a.m29308i(Constants.LogTag, "accessId没有初始化");
                }
                long j4 = f22714d;
                return j4;
            }
        }
    }

    public static void setAccessId(final Context context, final long j) {
        if (context == null) {
            C6864a.m29308i(f22711a, "null  context");
            return;
        }
        f22714d = j;
        C6901c.m29459a().mo33104a((Runnable) new Runnable() {
            public void run() {
                if (TpnsSecurity.checkTpnsSecurityLibSo(context)) {
                    SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                    if (defaultSharedPreferences != null) {
                        Editor edit = defaultSharedPreferences.edit();
                        edit.putString(XGPushConfig.TPUSH_ACCESS_ID, Rijndael.encrypt(String.valueOf(j)));
                        edit.commit();
                    }
                }
            }
        });
    }

    public static synchronized String getAccessKey(Context context) {
        synchronized (XGPushConfig.class) {
            if (!C7056i.m30194b(f22716f)) {
                String str = f22716f;
                return str;
            } else if (!TpnsSecurity.checkTpnsSecurityLibSo(context)) {
                return null;
            } else {
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                if (defaultSharedPreferences != null) {
                    String string = defaultSharedPreferences.getString(TPUSH_ACCESS_KEY, null);
                    if (C7056i.m30194b(string)) {
                        f22716f = Rijndael.decrypt(string);
                    }
                }
                if (C7056i.m30194b(f22716f)) {
                    Object a = C6900b.m29455a(context, TPUSH_ACCESS_KEY, (Object) null);
                    if (a != null) {
                        f22716f = a.toString();
                    }
                }
                if (C7056i.m30194b(f22716f)) {
                    C6864a.m29308i(f22711a, "accessKey is null");
                }
                String str2 = f22716f;
                return str2;
            }
        }
    }

    public static void setAccessKey(final Context context, final String str) {
        if (context == null || str == null) {
            C6864a.m29308i(Constants.LogTag, "null context or null accessKey");
            return;
        }
        f22716f = str;
        C6901c.m29459a().mo33104a((Runnable) new Runnable() {
            public void run() {
                if (TpnsSecurity.checkTpnsSecurityLibSo(context)) {
                    SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                    if (defaultSharedPreferences != null) {
                        Editor edit = defaultSharedPreferences.edit();
                        edit.putString(XGPushConfig.TPUSH_ACCESS_KEY, Rijndael.encrypt(str));
                        edit.commit();
                    }
                }
            }
        });
    }

    public static String getToken(Context context) {
        if (context != null) {
            return CacheManager.getToken(context);
        }
        C6864a.m29308i(Constants.LogTag, "null context");
        return null;
    }

    public static void enableDebug(final Context context, final boolean z) {
        if (context != null) {
            enableDebug = z;
            C6901c.m29459a().mo33104a((Runnable) new Runnable() {
                public void run() {
                    try {
                        if (z) {
                            C6864a.m29282a(2);
                        } else {
                            C6864a.m29282a(3);
                        }
                        Context context = context;
                        StringBuilder sb = new StringBuilder();
                        sb.append("com.tencent.android.tpush.debug,");
                        sb.append(context.getPackageName());
                        C6908h.m29485b(context, sb.toString(), z ? 1 : 0);
                        Intent intent = new Intent("com.tencent.android.tpush.action.ENABLE_DEBUG.V4");
                        intent.putExtra("debugMode", z);
                        context.sendBroadcast(intent);
                    } catch (Throwable th) {
                        C6864a.m29302d(XGPushConfig.f22711a, "enableDebug ", th);
                    }
                }
            });
        }
    }

    public static boolean isEnableDebug(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append("com.tencent.android.tpush.debug,");
        sb.append(context.getPackageName());
        if (C6908h.m29480a(context, sb.toString(), 0) != 0) {
            return true;
        }
        return false;
    }

    public static void setLocationEnable(Context context, boolean z) {
        Boolean bool = enableLocation;
        if (bool == null || bool.booleanValue() != z) {
            enableLocation = Boolean.valueOf(z);
            StringBuilder sb = new StringBuilder();
            sb.append("com.tencent.android.tpush.enable_location,");
            sb.append(context.getPackageName());
            C6908h.m29485b(context, sb.toString(), (int) z);
        }
    }

    public static boolean isLocationEnable(Context context) {
        if (enableLocation == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("com.tencent.android.tpush.enable_location,");
            sb.append(context.getPackageName());
            boolean z = true;
            if (C6908h.m29480a(context, sb.toString(), 1) == 0) {
                z = false;
            }
            enableLocation = Boolean.valueOf(z);
        }
        return enableLocation.booleanValue();
    }

    public static void setReportApplistEnable(Context context, boolean z) {
        Boolean bool = enableApplist;
        if (bool == null || bool.booleanValue() != z) {
            enableApplist = Boolean.valueOf(z);
            StringBuilder sb = new StringBuilder();
            sb.append("com.tencent.android.tpush.enable_applist,");
            sb.append(context.getPackageName());
            C6908h.m29485b(context, sb.toString(), (int) z);
        }
    }

    public static boolean isReportApplistEnable(Context context) {
        if (enableApplist == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("com.tencent.android.tpush.enable_applist,");
            sb.append(context.getPackageName());
            enableApplist = Boolean.valueOf(C6908h.m29480a(context, sb.toString(), 1) != 0);
        }
        if (C6971a.m29749a(context).f23135F == -1) {
            return enableApplist.booleanValue();
        }
        return C6971a.m29749a(context).f23135F == 1;
    }

    public static void setReportNotificationStatusEnable(Context context, boolean z) {
        Boolean bool = enableNotification;
        if (bool == null || bool.booleanValue() != z) {
            enableNotification = Boolean.valueOf(z);
            StringBuilder sb = new StringBuilder();
            sb.append("com.tencent.android.tpush.enable_NOTIICATION,");
            sb.append(context.getPackageName());
            C6908h.m29485b(context, sb.toString(), (int) z);
        }
    }

    public static boolean isReportNotificationStatusEnable(Context context) {
        if (enableNotification == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("com.tencent.android.tpush.enable_NOTIICATION,");
            sb.append(context.getPackageName());
            enableNotification = Boolean.valueOf(C6908h.m29480a(context, sb.toString(), 1) != 0);
        }
        if (C6971a.m29749a(context).f23136G == -1) {
            return enableNotification.booleanValue();
        }
        return C6971a.m29749a(context).f23136G == 1;
    }

    public static List<Long> getAccessidList(Context context) {
        ArrayList arrayList = new ArrayList(2);
        if (context == null) {
            return arrayList;
        }
        long accessId = getAccessId(context);
        if (accessId > 0) {
            arrayList.add(Long.valueOf(accessId));
        }
        long qQAccessId = XGPush4Msdk.getQQAccessId(context);
        if (qQAccessId > 0) {
            arrayList.add(Long.valueOf(qQAccessId));
        }
        Object a = C6900b.m29455a(context, TPUSH_ACCESS_ID, (Object) null);
        if (a != null) {
            try {
                long longValue = Long.valueOf(a.toString()).longValue();
                if (!arrayList.contains(Long.valueOf(longValue))) {
                    arrayList.add(Long.valueOf(longValue));
                }
            } catch (Exception e) {
                C6864a.m29299c(f22711a, "get accessId from getMetaData failed: ", e);
            }
        }
        return arrayList;
    }

    public static void setInstallChannel(Context context, String str) {
        if (context != null && str != null && str.trim().length() != 0) {
            f22712b = str;
        }
    }

    public static String getInstallChannel(Context context) {
        return f22712b;
    }

    public static void setGameServer(Context context, String str) {
        if (context != null && str != null && str.trim().length() != 0) {
            f22713c = str;
        }
    }

    public static String getGameServer(Context context) {
        return f22713c;
    }

    public static void setHeartbeatIntervalMs(Context context, int i) {
        if (context != null && i >= 5000 && i < 1800000) {
            try {
                C7055h.m30170b(context, "com.tencent.android.xg.wx.HeartbeatIntervalMs", i);
            } catch (Exception e) {
                C6864a.m29302d(f22711a, "setHeartbeatIntervalMs", e);
            }
        }
    }

    public static boolean isUsedOtherPush(Context context) {
        boolean z = false;
        if (context == null) {
            return false;
        }
        if (isUsedOtherPush == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("com.tencent.android.tpush.other.push,");
            sb.append(context.getPackageName());
            if (C6908h.m29480a(context, sb.toString(), 0) != 0) {
                z = true;
            }
            isUsedOtherPush = Boolean.valueOf(z);
        }
        return isUsedOtherPush.booleanValue();
    }

    public static void enableOtherPush(Context context, boolean z) {
        if (context != null) {
            Boolean bool = isUsedOtherPush;
            if (bool == null || bool.booleanValue() != z) {
                isUsedOtherPush = Boolean.valueOf(z);
                StringBuilder sb = new StringBuilder();
                sb.append("com.tencent.android.tpush.other.push,");
                sb.append(context.getPackageName());
                C6908h.m29485b(context, sb.toString(), (int) z);
            }
        }
    }

    public static boolean isUsedFcmPush(Context context) {
        boolean z = false;
        if (context == null) {
            return false;
        }
        if (isUsedFcmPush == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("com.tencent.android.tpush.fcm,");
            sb.append(context.getPackageName());
            if (C6908h.m29480a(context, sb.toString(), 0) != 0) {
                z = true;
            }
            isUsedFcmPush = Boolean.valueOf(z);
        }
        return isUsedFcmPush.booleanValue();
    }

    public static void enableFcmPush(Context context, boolean z) {
        if (context != null) {
            Boolean bool = isUsedFcmPush;
            if (bool == null || bool.booleanValue() != z) {
                isUsedFcmPush = Boolean.valueOf(z);
                StringBuilder sb = new StringBuilder();
                sb.append("com.tencent.android.tpush.fcm,");
                sb.append(context.getPackageName());
                C6908h.m29485b(context, sb.toString(), (int) z);
            }
        }
    }

    public static void setReportDebugMode(Context context, boolean z) {
        if (context != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getPackageName());
            sb.append(".report.mode");
            C6908h.m29485b(context, sb.toString(), (int) z);
        }
    }

    public static boolean getReportDebugMode(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName());
        sb.append(".report.mode");
        if (C6908h.m29480a(context, sb.toString(), 0) != 0) {
            return true;
        }
        return false;
    }

    public static void setMiPushAppId(Context context, String str) {
        C6927d.m29570a(context, str);
    }

    public static void setMiPushAppKey(Context context, String str) {
        C6927d.m29571b(context, str);
    }

    public static void setMzPushAppId(Context context, String str) {
        C6927d.m29572c(context, str);
    }

    public static void setMzPushAppKey(Context context, String str) {
        C6927d.m29573d(context, str);
    }

    public static void setfcmSenderId(Context context, String str) {
        C6916a.m29537b(context, str);
    }

    public static boolean isForeiginPush(Context context) {
        if (f22717g == null) {
            try {
                Object a = C6900b.m29455a(context, TPUSH_IS_FOREIGINPUSH, (Object) null);
                if (a == null) {
                    f22717g = Boolean.valueOf(false);
                    return f22717g.booleanValue();
                } else if ("true".equals(a.toString())) {
                    f22717g = Boolean.valueOf(true);
                } else {
                    f22717g = Boolean.valueOf(false);
                }
            } catch (Throwable unused) {
                f22717g = Boolean.valueOf(false);
            }
        }
        return f22717g.booleanValue();
    }

    public static void setHuaweiDebug(boolean z) {
        _isHuaweiDebug = z;
    }

    public static boolean isHuaweiDebug() {
        return _isHuaweiDebug;
    }

    public static boolean isForeignWeakAlarmMode(Context context) {
        int i;
        Boolean bool = f22718h;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (PreferenceManager.getDefaultSharedPreferences(context) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("com.tencent.android.tpush.enable_FOREIGIN_XG_WEAK_ALARM,");
            sb.append(context.getPackageName());
            i = C6908h.m29480a(context, sb.toString(), -1);
        } else {
            i = -1;
        }
        boolean z = true;
        if (i == -1) {
            Object a = C6900b.m29455a(context, Constants.META_STR_FOREIGIN_XG_WEAK_ALARM, (Object) null);
            if (a != null && a.toString().equals("true")) {
                i = 1;
            }
        }
        if (i != 1) {
            z = false;
        }
        f22718h = Boolean.valueOf(z);
        return f22718h.booleanValue();
    }

    public static void setForeignWeakAlarmMode(Context context, boolean z) {
        Boolean bool = f22718h;
        if (bool == null || bool.booleanValue() != z) {
            f22718h = Boolean.valueOf(z);
            StringBuilder sb = new StringBuilder();
            sb.append("com.tencent.android.tpush.enable_FOREIGIN_XG_WEAK_ALARM,");
            sb.append(context.getPackageName());
            C6908h.m29485b(context, sb.toString(), (int) z);
        }
    }

    public static void setNotificationShowEnable(Context context, boolean z) {
        if (context != null) {
            try {
                if (f22719i == null) {
                    f22719i = context.getSharedPreferences(Constants.APP_PREF_NAME, 0);
                }
                Editor edit = f22719i.edit();
                edit.putBoolean(Constants.SETTINGS_ENABLE_SHOW_NOTIFICATION, z);
                edit.commit();
            } catch (Exception e) {
                C6864a.m29302d(f22711a, "setNotificationShowEnable", e);
            }
        }
    }

    public static boolean isNotificationShowEnable(Context context) {
        if (context != null) {
            try {
                if (f22719i == null) {
                    f22719i = context.getSharedPreferences(Constants.APP_PREF_NAME, 0);
                }
                return f22719i.getBoolean(Constants.SETTINGS_ENABLE_SHOW_NOTIFICATION, true);
            } catch (Exception e) {
                C6864a.m29302d(f22711a, "isNotificationShowEnable", e);
            }
        }
        return true;
    }
}
