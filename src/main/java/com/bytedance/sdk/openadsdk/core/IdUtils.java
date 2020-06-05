package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.multipro.MultiGlobalInfo;
import com.bytedance.sdk.openadsdk.utils.RomUtils;
import java.util.List;

/* renamed from: com.bytedance.sdk.openadsdk.core.j */
public class IdUtils {
    /* renamed from: a */
    private static String f7713a;
    /* renamed from: b */
    private static String f7714b;
    /* renamed from: c */
    private static String f7715c;
    /* renamed from: d */
    private static String f7716d;
    /* renamed from: e */
    private static String f7717e;
    /* renamed from: f */
    private static String f7718f;
    /* renamed from: g */
    private static String f7719g;
    /* renamed from: h */
    private static String f7720h;
    /* renamed from: i */
    private static String f7721i;
    /* renamed from: j */
    private static String f7722j;
    /* renamed from: k */
    private static boolean f7723k;

    /* renamed from: k */
    private static Context m9873k(Context context) {
        return context == null ? InternalContainer.m10059a() : context;
    }

    /* renamed from: a */
    public static String m9858a(Context context) {
        if (TextUtils.isEmpty(f7713a) && !f7723k) {
            synchronized (IdUtils.class) {
                if (!f7723k) {
                    m9874l(context);
                }
            }
        }
        try {
            if (TextUtils.isEmpty(f7713a) && MultiGlobalInfo.m11808b()) {
                f7713a = AdPreference.m9212a(m9873k(context)).mo15327b("did", (String) null);
            }
        } catch (Exception unused) {
        }
        return f7713a;
    }

    /* renamed from: b */
    public static String m9864b(Context context) {
        if (f7720h == null && !f7723k) {
            synchronized (IdUtils.class) {
                if (!f7723k) {
                    m9874l(context);
                }
            }
        }
        return f7720h;
    }

    /* renamed from: c */
    public static String m9865c(Context context) {
        if (TextUtils.isEmpty(f7714b) && !f7723k) {
            synchronized (IdUtils.class) {
                if (!f7723k) {
                    m9874l(context);
                }
            }
        }
        return f7714b;
    }

    /* renamed from: d */
    public static String m9866d(Context context) {
        TTCustomController d = GlobalInfo.m9616c().mo15672d();
        if (d != null && !d.isCanUsePhoneState()) {
            return d.getDevImei();
        }
        if (TextUtils.isEmpty(f7715c) && !f7723k) {
            synchronized (IdUtils.class) {
                if (!f7723k) {
                    m9874l(context);
                }
            }
        }
        return f7715c;
    }

    /* renamed from: e */
    public static String m9867e(Context context) {
        if (TextUtils.isEmpty(f7721i) && !f7723k) {
            synchronized (IdUtils.class) {
                if (!f7723k) {
                    m9874l(context);
                }
            }
        }
        return f7721i;
    }

    /* renamed from: f */
    public static String m9868f(Context context) {
        TTCustomController d = GlobalInfo.m9616c().mo15672d();
        if (d != null && !d.isCanUsePhoneState()) {
            return null;
        }
        if (TextUtils.isEmpty(f7718f) && !f7723k) {
            synchronized (IdUtils.class) {
                if (!f7723k) {
                    m9874l(context);
                }
            }
        }
        return f7718f;
    }

    /* renamed from: g */
    public static String m9869g(Context context) {
        TTCustomController d = GlobalInfo.m9616c().mo15672d();
        if (d != null && !d.isCanUseWifiState()) {
            return null;
        }
        if (TextUtils.isEmpty(f7716d) && !f7723k) {
            synchronized (IdUtils.class) {
                if (!f7723k) {
                    m9874l(context);
                }
            }
        }
        return f7716d;
    }

    /* renamed from: h */
    public static String m9870h(Context context) {
        TTCustomController d = GlobalInfo.m9616c().mo15672d();
        if (d != null && !d.isCanUseWifiState()) {
            return null;
        }
        if (TextUtils.isEmpty(f7717e) && !f7723k) {
            synchronized (IdUtils.class) {
                if (!f7723k) {
                    m9874l(context);
                }
            }
        }
        return f7717e;
    }

    /* renamed from: i */
    public static String m9871i(Context context) {
        if (VERSION.SDK_INT >= 28) {
            TTCustomController d = GlobalInfo.m9616c().mo15672d();
            if (d != null && !d.isCanUsePhoneState()) {
                return null;
            }
        }
        if (TextUtils.isEmpty(f7722j) && !f7723k) {
            synchronized (IdUtils.class) {
                if (!f7723k) {
                    m9874l(context);
                }
            }
        }
        return f7722j;
    }

    /* renamed from: a */
    public static void m9862a(Context context, String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(f7713a)) {
            AdPreference.m9212a(context).mo15322a("did", str);
            f7713a = str;
        }
        if (!TextUtils.isEmpty(f7713a)) {
            SecSdkHelper.m10148b(f7713a).mo15923a(f7713a);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:(2:6|7)|8|10|11|(6:17|18|19|(1:21)(1:22)|(1:24)|25)|26|27|(1:29)(1:30)|31|33) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0044 */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x004a A[Catch:{ Exception -> 0x0055 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0051 A[Catch:{ Exception -> 0x0055 }] */
    /* renamed from: l */
    private static void m9874l(android.content.Context r4) {
        /*
        boolean r0 = f7723k
        if (r0 == 0) goto L_0x0005
        return
    L_0x0005:
        android.content.Context r4 = m9873k(r4)
        if (r4 != 0) goto L_0x000c
        return
    L_0x000c:
        m9875m(r4)     // Catch:{ Exception -> 0x000f }
    L_0x000f:
        r0 = 0
        com.bytedance.sdk.openadsdk.core.h r1 = com.bytedance.sdk.openadsdk.core.GlobalInfo.m9616c()     // Catch:{ Exception -> 0x0055 }
        com.bytedance.sdk.openadsdk.TTCustomController r1 = r1.mo15672d()     // Catch:{ Exception -> 0x0055 }
        if (r1 == 0) goto L_0x0044
        boolean r2 = r1.isCanUseWifiState()     // Catch:{ Exception -> 0x0055 }
        if (r2 == 0) goto L_0x0044
        boolean r1 = r1.isCanUseLocation()     // Catch:{ Exception -> 0x0055 }
        if (r1 == 0) goto L_0x0044
        java.lang.String r1 = "wifi"
        java.lang.Object r1 = r4.getSystemService(r1)     // Catch:{ all -> 0x0044 }
        android.net.wifi.WifiManager r1 = (android.net.wifi.WifiManager) r1     // Catch:{ all -> 0x0044 }
        if (r1 == 0) goto L_0x0035
        android.net.wifi.WifiInfo r2 = r1.getConnectionInfo()     // Catch:{ all -> 0x0044 }
        goto L_0x0036
    L_0x0035:
        r2 = r0
    L_0x0036:
        if (r2 == 0) goto L_0x003e
        java.lang.String r2 = r2.getSSID()     // Catch:{ all -> 0x0044 }
        f7716d = r2     // Catch:{ all -> 0x0044 }
    L_0x003e:
        java.lang.String r1 = m9860a(r1)     // Catch:{ all -> 0x0044 }
        f7717e = r1     // Catch:{ all -> 0x0044 }
    L_0x0044:
        int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0055 }
        r2 = 28
        if (r1 < r2) goto L_0x0051
        java.lang.String r1 = android.os.Build.getSerial()     // Catch:{ Exception -> 0x0055 }
        f7722j = r1     // Catch:{ Exception -> 0x0055 }
        goto L_0x0055
    L_0x0051:
        java.lang.String r1 = android.os.Build.SERIAL     // Catch:{ Exception -> 0x0055 }
        f7722j = r1     // Catch:{ Exception -> 0x0055 }
    L_0x0055:
        r1 = 1
        java.lang.String r2 = m9859a(r4, r1)
        f7714b = r2
        com.bytedance.sdk.openadsdk.core.d r2 = com.bytedance.sdk.openadsdk.core.AdPreference.m9212a(r4)
        java.lang.String r3 = "did"
        java.lang.String r2 = r2.mo15327b(r3, r0)
        f7713a = r2
        java.lang.String r2 = m9857a()
        f7719g = r2
        long r2 = android.os.Build.TIME
        java.lang.String r2 = java.lang.String.valueOf(r2)
        f7720h = r2
        com.bytedance.sdk.openadsdk.core.d r4 = com.bytedance.sdk.openadsdk.core.AdPreference.m9212a(r4)
        java.lang.String r2 = "uuid"
        java.lang.String r4 = r4.mo15327b(r2, r0)
        f7721i = r4
        f7723k = r1
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.IdUtils.m9874l(android.content.Context):void");
    }

    /* renamed from: a */
    public static String m9860a(WifiManager wifiManager) {
        String str;
        String str2 = "02:00:00:00:00:00";
        if (wifiManager == null) {
            return str2;
        }
        try {
            List scanResults = wifiManager.getScanResults();
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (!(scanResults == null || connectionInfo == null || connectionInfo.getBSSID() == null)) {
                for (int i = 0; i < scanResults.size(); i++) {
                    ScanResult scanResult = (ScanResult) scanResults.get(i);
                    if (connectionInfo.getBSSID().equals(scanResult.BSSID)) {
                        str2 = scanResult.BSSID;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return str;
    }

    /* renamed from: j */
    public static void m9872j(Context context) {
        if (TextUtils.isEmpty(f7715c)) {
            Context k = m9873k(context);
            if (k != null) {
                try {
                    m9875m(k);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* renamed from: m */
    private static void m9875m(Context context) {
        TTCustomController d = GlobalInfo.m9616c().mo15672d();
        if (d == null || d.isCanUsePhoneState()) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                f7715c = telephonyManager.getDeviceId();
                f7718f = telephonyManager.getSubscriberId();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0028, code lost:
            if (r2.length() >= 13) goto L_0x008f;
     */
    /* renamed from: a */
    private static synchronized java.lang.String m9859a(android.content.Context r6, boolean r7) {
        /*
        java.lang.Class<com.bytedance.sdk.openadsdk.core.j> r0 = com.bytedance.sdk.openadsdk.core.IdUtils.class
        monitor-enter(r0)
        android.content.Context r6 = m9873k(r6)     // Catch:{ all -> 0x0091 }
        r1 = 0
        if (r6 != 0) goto L_0x000c
        monitor-exit(r0)
        return r1
    L_0x000c:
        android.content.ContentResolver r2 = r6.getContentResolver()     // Catch:{ Exception -> 0x0017 }
        java.lang.String r3 = "android_id"
        java.lang.String r2 = android.provider.Settings.Secure.getString(r2, r3)     // Catch:{ Exception -> 0x0017 }
        goto L_0x0018
    L_0x0017:
        r2 = r1
    L_0x0018:
        r3 = 13
        if (r2 == 0) goto L_0x002a
        java.lang.String r4 = "9774d56d682e549c"
        boolean r4 = r2.equals(r4)     // Catch:{ Exception -> 0x008f }
        if (r4 != 0) goto L_0x002a
        int r4 = r2.length()     // Catch:{ Exception -> 0x008f }
        if (r4 >= r3) goto L_0x008f
    L_0x002a:
        com.bytedance.sdk.openadsdk.core.d r6 = com.bytedance.sdk.openadsdk.core.AdPreference.m9212a(r6)     // Catch:{ Exception -> 0x008f }
        java.lang.String r4 = "openudid"
        java.lang.String r1 = r6.mo15327b(r4, r1)     // Catch:{ Exception -> 0x008f }
        boolean r4 = m9863a(r1)     // Catch:{ Exception -> 0x008f }
        if (r4 != 0) goto L_0x008e
        java.security.SecureRandom r1 = new java.security.SecureRandom     // Catch:{ Exception -> 0x008f }
        r1.<init>()     // Catch:{ Exception -> 0x008f }
        java.math.BigInteger r4 = new java.math.BigInteger     // Catch:{ Exception -> 0x008f }
        r5 = 64
        r4.<init>(r5, r1)     // Catch:{ Exception -> 0x008f }
        r1 = 16
        java.lang.String r1 = r4.toString(r1)     // Catch:{ Exception -> 0x008f }
        r4 = 0
        char r4 = r1.charAt(r4)     // Catch:{ Exception -> 0x008f }
        r5 = 45
        if (r4 != r5) goto L_0x005a
        r4 = 1
        java.lang.String r1 = r1.substring(r4)     // Catch:{ Exception -> 0x008f }
    L_0x005a:
        int r4 = r1.length()     // Catch:{ Exception -> 0x008f }
        int r3 = r3 - r4
        if (r3 <= 0) goto L_0x0077
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x008f }
        r4.<init>()     // Catch:{ Exception -> 0x008f }
    L_0x0066:
        if (r3 <= 0) goto L_0x0070
        r5 = 70
        r4.append(r5)     // Catch:{ Exception -> 0x008f }
        int r3 = r3 + -1
        goto L_0x0066
    L_0x0070:
        r4.append(r1)     // Catch:{ Exception -> 0x008f }
        java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x008f }
    L_0x0077:
        if (r7 == 0) goto L_0x0086
        java.lang.String r7 = "openudid.dat"
        java.lang.String r7 = m9861a(r7, r1)     // Catch:{ Exception -> 0x008f }
        boolean r3 = m9863a(r7)     // Catch:{ Exception -> 0x008f }
        if (r3 == 0) goto L_0x0086
        goto L_0x0087
    L_0x0086:
        r7 = r1
    L_0x0087:
        java.lang.String r1 = "openudid"
        r6.mo15322a(r1, r7)     // Catch:{ Exception -> 0x008f }
        r2 = r7
        goto L_0x008f
    L_0x008e:
        r2 = r1
    L_0x008f:
        monitor-exit(r0)
        return r2
    L_0x0091:
        r6 = move-exception
        monitor-exit(r0)
        throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.IdUtils.m9859a(android.content.Context, boolean):java.lang.String");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:11|12|13|(4:15|16|17|(2:20|(4:(2:23|24)|25|26|27)))|29|30|(2:32|33)|34|35|36) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:(2:23|24)|25|26|27) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0086 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x009b */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a6 A[SYNTHETIC, Splitter:B:42:0x00a6] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ad A[SYNTHETIC, Splitter:B:46:0x00ad] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b4 A[SYNTHETIC, Splitter:B:54:0x00b4] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00bb A[SYNTHETIC, Splitter:B:58:0x00bb] */
    /* renamed from: a */
    private static java.lang.String m9861a(java.lang.String r6, java.lang.String r7) {
        /*
        java.lang.String r0 = android.os.Environment.getExternalStorageState()
        java.lang.String r1 = "mounted"
        boolean r0 = r1.equals(r0)
        if (r0 != 0) goto L_0x000d
        return r7
    L_0x000d:
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.io.File r1 = android.os.Environment.getExternalStorageDirectory()
        java.lang.String r1 = r1.getPath()
        r0.append(r1)
        java.lang.String r1 = "/Android/data/com.snssdk.api/cache"
        r0.append(r1)
        java.lang.String r0 = r0.toString()
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        r1.append(r0)
        java.lang.String r2 = "/"
        r1.append(r2)
        r1.append(r6)
        java.lang.String r6 = r1.toString()
        r1 = 0
        java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x00b1, all -> 0x00a1 }
        r2.<init>(r0)     // Catch:{ Exception -> 0x00b1, all -> 0x00a1 }
        boolean r0 = r2.exists()     // Catch:{ Exception -> 0x00b1, all -> 0x00a1 }
        if (r0 != 0) goto L_0x004d
        boolean r0 = r2.mkdirs()     // Catch:{ Exception -> 0x00b1, all -> 0x00a1 }
        if (r0 != 0) goto L_0x004d
        return r7
    L_0x004d:
        java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x00b1, all -> 0x00a1 }
        r0.<init>(r6)     // Catch:{ Exception -> 0x00b1, all -> 0x00a1 }
        java.io.RandomAccessFile r6 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x00b1, all -> 0x00a1 }
        java.lang.String r2 = "rwd"
        r6.<init>(r0, r2)     // Catch:{ Exception -> 0x00b1, all -> 0x00a1 }
        java.nio.channels.FileChannel r2 = r6.getChannel()     // Catch:{ Exception -> 0x00b2, all -> 0x009f }
        java.nio.channels.FileLock r1 = r2.lock()     // Catch:{ Exception -> 0x00b2, all -> 0x009f }
        boolean r0 = r0.isFile()     // Catch:{ Exception -> 0x00b2, all -> 0x009f }
        java.lang.String r2 = "UTF-8"
        if (r0 == 0) goto L_0x008a
        r0 = 129(0x81, float:1.81E-43)
        byte[] r3 = new byte[r0]     // Catch:{ Exception -> 0x00b2, all -> 0x009f }
        r4 = 0
        int r5 = r6.read(r3, r4, r0)     // Catch:{ Exception -> 0x00b2, all -> 0x009f }
        if (r5 <= 0) goto L_0x008a
        if (r5 >= r0) goto L_0x008a
        java.lang.String r0 = new java.lang.String     // Catch:{ Exception -> 0x00b2, all -> 0x009f }
        r0.<init>(r3, r4, r5, r2)     // Catch:{ Exception -> 0x00b2, all -> 0x009f }
        boolean r3 = m9863a(r0)     // Catch:{ Exception -> 0x00b2, all -> 0x009f }
        if (r3 == 0) goto L_0x008a
        if (r1 == 0) goto L_0x0086
        r1.release()     // Catch:{ Exception -> 0x0086 }
    L_0x0086:
        r6.close()     // Catch:{ Exception -> 0x0089 }
    L_0x0089:
        return r0
    L_0x008a:
        byte[] r0 = r7.getBytes(r2)     // Catch:{ Exception -> 0x00b2, all -> 0x009f }
        r2 = 0
        r6.setLength(r2)     // Catch:{ Exception -> 0x00b2, all -> 0x009f }
        r6.write(r0)     // Catch:{ Exception -> 0x00b2, all -> 0x009f }
        if (r1 == 0) goto L_0x009b
        r1.release()     // Catch:{ Exception -> 0x009b }
    L_0x009b:
        r6.close()     // Catch:{ Exception -> 0x009e }
    L_0x009e:
        return r7
    L_0x009f:
        r7 = move-exception
        goto L_0x00a4
    L_0x00a1:
        r6 = move-exception
        r7 = r6
        r6 = r1
    L_0x00a4:
        if (r1 == 0) goto L_0x00ab
        r1.release()     // Catch:{ Exception -> 0x00aa }
        goto L_0x00ab
    L_0x00ab:
        if (r6 == 0) goto L_0x00b0
        r6.close()     // Catch:{ Exception -> 0x00b0 }
    L_0x00b0:
        throw r7
    L_0x00b1:
        r6 = r1
    L_0x00b2:
        if (r1 == 0) goto L_0x00b9
        r1.release()     // Catch:{ Exception -> 0x00b8 }
        goto L_0x00b9
    L_0x00b9:
        if (r6 == 0) goto L_0x00be
        r6.close()     // Catch:{ Exception -> 0x00be }
    L_0x00be:
        return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.IdUtils.m9861a(java.lang.String, java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    private static boolean m9863a(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length < 13 || length > 128) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if ((charAt < '0' || charAt > '9') && ((charAt < 'a' || charAt > 'f') && ((charAt < 'A' || charAt > 'F') && charAt != '-'))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static String m9857a() {
        StringBuilder sb = new StringBuilder();
        try {
            if (RomUtils.m11951e()) {
                sb.append("MIUI-");
            } else if (RomUtils.m11946b()) {
                sb.append("FLYME-");
            } else {
                String n = RomUtils.m11960n();
                if (RomUtils.m11944a(n)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(n)) {
                    sb.append(n);
                    sb.append("-");
                }
            }
            sb.append(VERSION.INCREMENTAL);
        } catch (Exception unused) {
        }
        return sb.toString();
    }
}
