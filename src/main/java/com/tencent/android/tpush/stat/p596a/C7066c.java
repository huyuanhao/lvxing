package com.tencent.android.tpush.stat.p596a;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Process;
import com.tencent.android.tpush.data.RegisterEntity;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.service.p595e.C7052e;
import com.tencent.android.tpush.service.p595e.C7056i;
import com.tencent.android.tpush.stat.C7070b;
import com.tencent.mid.core.Constants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpHost;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.stat.a.c */
public class C7066c {
    /* renamed from: a */
    private static String f23484a;
    /* renamed from: b */
    private static String f23485b;
    /* renamed from: c */
    private static String f23486c;
    /* renamed from: d */
    private static Random f23487d;
    /* renamed from: e */
    private static Map<Long, String> f23488e = new HashMap(10);
    /* renamed from: f */
    private static String f23489f = "";
    /* renamed from: g */
    private static C7067d f23490g = null;
    /* renamed from: h */
    private static String f23491h = null;
    /* renamed from: i */
    private static long f23492i = -1;
    /* renamed from: j */
    private static int f23493j = 0;
    /* renamed from: k */
    private static String f23494k = "__MTA_FIRST_ACTIVATE__";
    /* renamed from: l */
    private static int f23495l = -1;

    /* renamed from: d */
    private static synchronized Random m30265d() {
        Random random;
        synchronized (C7066c.class) {
            if (f23487d == null) {
                f23487d = new Random();
            }
            random = f23487d;
        }
        return random;
    }

    /* renamed from: a */
    public static String m30255a(Context context, long j) {
        try {
            if (f23488e.containsKey(Long.valueOf(j))) {
                return (String) f23488e.get(Long.valueOf(j));
            }
            if (context != null) {
                List<ResolveInfo> e = C7056i.m30205e(context);
                if (e != null) {
                    for (ResolveInfo resolveInfo : e) {
                        String str = resolveInfo.activityInfo.packageName;
                        if (str != null) {
                            RegisterEntity registerInfoByPkgName = CacheManager.getRegisterInfoByPkgName(str);
                            if (registerInfoByPkgName != null && registerInfoByPkgName.accessId == j) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(registerInfoByPkgName.xgSDKVersion);
                                sb.append("");
                                String sb2 = sb.toString();
                                f23488e.put(Long.valueOf(registerInfoByPkgName.accessId), sb2);
                                return sb2;
                            }
                        }
                    }
                }
            }
            return "0";
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static String m30254a(Context context) {
        try {
            return String.valueOf(4.03f);
        } catch (Throwable unused) {
            return "0";
        }
    }

    /* renamed from: a */
    public static int m30250a() {
        return m30265d().nextInt(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    /* renamed from: a */
    public static byte[] m30258a(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length * 2);
        while (true) {
            int read = gZIPInputStream.read(bArr2);
            if (read != -1) {
                byteArrayOutputStream.write(bArr2, 0, read);
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayInputStream.close();
                gZIPInputStream.close();
                byteArrayOutputStream.close();
                return byteArray;
            }
        }
    }

    /* renamed from: b */
    public static HttpHost m30261b(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (context.getPackageManager().checkPermission(Constants.PERMISSION_ACCESS_NETWORK_STATE, context.getPackageName()) != 0) {
                return null;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            if (activeNetworkInfo.getTypeName() != null && activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                return null;
            }
            String extraInfo = activeNetworkInfo.getExtraInfo();
            if (extraInfo == null) {
                return null;
            }
            if (!extraInfo.equals("cmwap") && !extraInfo.equals("3gwap")) {
                if (!extraInfo.equals("uniwap")) {
                    if (extraInfo.equals("ctwap")) {
                        return new HttpHost("10.0.0.200", 80);
                    }
                    String defaultHost = Proxy.getDefaultHost();
                    if (defaultHost != null && defaultHost.trim().length() > 0) {
                        return new HttpHost(defaultHost, Proxy.getDefaultPort());
                    }
                    return null;
                }
            }
            return new HttpHost("10.0.0.172", 80);
        } catch (Throwable th) {
            f23490g.mo34170b(th);
        }
    }

    /* renamed from: b */
    public static String m30260b(Context context, long j) {
        return C7052e.m30148a(context).mo34151a(j);
    }

    /* renamed from: b */
    public static synchronized C7067d m30259b() {
        C7067d dVar;
        synchronized (C7066c.class) {
            if (f23490g == null) {
                f23490g = new C7067d("XgStat");
                f23490g.mo34167a(true);
            }
            dVar = f23490g;
        }
        return dVar;
    }

    /* renamed from: c */
    public static long m30263c() {
        try {
            Calendar instance = Calendar.getInstance();
            instance.set(11, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            instance.set(14, 0);
            return instance.getTimeInMillis() + 86400000;
        } catch (Throwable th) {
            f23490g.mo34170b(th);
            return System.currentTimeMillis() + 86400000;
        }
    }

    /* renamed from: a */
    public static Long m30253a(String str, String str2, int i, int i2, Long l) {
        if (!(str == null || str2 == null)) {
            if (str2.equalsIgnoreCase(".") || str2.equalsIgnoreCase("|")) {
                StringBuilder sb = new StringBuilder();
                sb.append("\\");
                sb.append(str2);
                str2 = sb.toString();
            }
            String[] split = str.split(str2);
            if (split.length == i2) {
                try {
                    Long valueOf = Long.valueOf(0);
                    for (String valueOf2 : split) {
                        valueOf = Long.valueOf(((long) i) * (valueOf.longValue() + Long.valueOf(valueOf2).longValue()));
                    }
                    return valueOf;
                } catch (NumberFormatException unused) {
                }
            }
        }
        return l;
    }

    /* renamed from: a */
    public static long m30252a(String str) {
        return m30253a(str, ".", 100, 3, Long.valueOf(0)).longValue();
    }

    /* renamed from: b */
    public static boolean m30262b(String str) {
        return (str == null || str.trim().length() == 0) ? false : true;
    }

    /* renamed from: c */
    public static String m30264c(Context context) {
        try {
            if (f23491h != null) {
                return f23491h;
            }
            int myPid = Process.myPid();
            Iterator it = ((ActivityManager) context.getSystemService(com.tencent.android.tpush.common.Constants.FLAG_ACTIVITY_NAME)).getRunningAppProcesses().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                RunningAppProcessInfo runningAppProcessInfo = (RunningAppProcessInfo) it.next();
                if (runningAppProcessInfo.pid == myPid) {
                    f23491h = runningAppProcessInfo.processName;
                    break;
                }
            }
            return f23491h;
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static String m30256a(Context context, String str) {
        if (C7070b.m30307e()) {
            if (f23491h == null) {
                f23491h = m30264c(context);
            }
            if (f23491h != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("_");
                sb.append(f23491h);
                return sb.toString();
            }
        }
        return str;
    }

    /* renamed from: d */
    public static boolean m30266d(Context context) {
        if (f23492i < 0) {
            f23492i = C7068e.m30283a(context, "mta.qq.com.checktime", 0);
        }
        return Math.abs(System.currentTimeMillis() - f23492i) > 86400000;
    }

    /* renamed from: e */
    public static void m30267e(Context context) {
        f23492i = System.currentTimeMillis();
        C7068e.m30287b(context, "mta.qq.com.checktime", f23492i);
    }

    /* renamed from: a */
    public static int m30251a(Context context, boolean z) {
        if (z) {
            f23493j = m30268f(context);
        }
        return f23493j;
    }

    /* renamed from: f */
    public static int m30268f(Context context) {
        return C7068e.m30282a(context, "mta.qq.com.difftime", 0);
    }

    /* renamed from: a */
    public static void m30257a(Context context, int i) {
        f23493j = i;
        C7068e.m30286b(context, "mta.qq.com.difftime", i);
    }
}
