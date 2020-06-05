package com.alibaba.mtl.log.p077d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.alibaba.mtl.log.UTMCStatConfig;
import com.alibaba.mtl.log.model.LogField;
import com.p620ut.device.UTDevice;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.slf4j.Marker;

/* renamed from: com.alibaba.mtl.log.d.d */
public class DeviceUtil {
    /* renamed from: a */
    private static Map<String, String> f3395a;

    /* renamed from: a */
    public static synchronized Map<String, String> m3807a(Context context) {
        synchronized (DeviceUtil.class) {
            if (f3395a != null) {
                f3395a.put(LogField.CHANNEL.toString(), AppInfoUtil.m3796c());
                f3395a.put(LogField.APPKEY.toString(), AppInfoUtil.m3799f());
                String a = PhoneInfoUtils.m3853a(context);
                String b = PhoneInfoUtils.m3854b(context);
                if (TextUtils.isEmpty(a) || TextUtils.isEmpty(b)) {
                    a = "";
                    b = "";
                }
                f3395a.put(LogField.IMEI.toString(), a);
                f3395a.put(LogField.IMSI.toString(), b);
                m3808a(f3395a, context);
                Map<String, String> map = f3395a;
                return map;
            }
            f3395a = new HashMap();
            if (context == null) {
                return null;
            }
            if (f3395a != null) {
                try {
                    String a2 = PhoneInfoUtils.m3853a(context);
                    String b2 = PhoneInfoUtils.m3854b(context);
                    if (TextUtils.isEmpty(a2) || TextUtils.isEmpty(b2)) {
                        a2 = "";
                        b2 = "";
                    }
                    f3395a.put(LogField.IMEI.toString(), a2);
                    f3395a.put(LogField.IMSI.toString(), b2);
                    f3395a.put(LogField.BRAND.toString(), Build.BRAND);
                    f3395a.put(LogField.DEVICE_MODEL.toString(), Build.MODEL);
                    f3395a.put(LogField.RESOLUTION.toString(), m3815d(context));
                    f3395a.put(LogField.CHANNEL.toString(), AppInfoUtil.m3796c());
                    f3395a.put(LogField.APPKEY.toString(), AppInfoUtil.m3799f());
                    f3395a.put(LogField.APPVERSION.toString(), m3811b(context));
                    f3395a.put(LogField.LANGUAGE.toString(), m3813c(context));
                    f3395a.put(LogField.OS.toString(), m3814d());
                    f3395a.put(LogField.OSVERSION.toString(), m3812c());
                    f3395a.put(LogField.SDKVERSION.toString(), "2.6.4.5_for_bc");
                    f3395a.put(LogField.SDKTYPE.toString(), "mini");
                    try {
                        f3395a.put(LogField.UTDID.toString(), UTDevice.getUtdid(context));
                    } catch (Throwable th) {
                        Log.e("DeviceUtil", "utdid4all jar doesn't exist, please copy the libs folder.");
                        th.printStackTrace();
                    }
                    m3808a(f3395a, context);
                } catch (Exception unused) {
                    return null;
                }
            }
            Map<String, String> map2 = f3395a;
            return map2;
        }
    }

    /* renamed from: c */
    private static String m3812c() {
        String str = VERSION.RELEASE;
        if (m3809a()) {
            String property = System.getProperty("ro.yunos.version");
            if (!TextUtils.isEmpty(property)) {
                return property;
            }
            str = m3818g();
            if (!TextUtils.isEmpty(str)) {
            }
        }
        return str;
    }

    /* renamed from: d */
    private static String m3814d() {
        return (!m3809a() || m3816e()) ? "a" : "y";
    }

    /* renamed from: a */
    private static void m3808a(Map<String, String> map, Context context) {
        String str = "Unknown";
        try {
            String[] a = NetworkUtil.m3845a(context);
            map.put(LogField.ACCESS.toString(), a[0]);
            if (a[0].equals("2G/3G")) {
                map.put(LogField.ACCESS_SUBTYPE.toString(), a[1]);
            } else {
                map.put(LogField.ACCESS_SUBTYPE.toString(), str);
            }
        } catch (Exception unused) {
            map.put(LogField.ACCESS.toString(), str);
            map.put(LogField.ACCESS_SUBTYPE.toString(), str);
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            String networkOperatorName = (telephonyManager == null || telephonyManager.getSimState() != 5) ? "" : telephonyManager.getNetworkOperatorName();
            if (TextUtils.isEmpty(networkOperatorName)) {
                networkOperatorName = str;
            }
            map.put(LogField.CARRIER.toString(), networkOperatorName);
        } catch (Exception unused2) {
        }
    }

    /* renamed from: c */
    private static String m3813c(Context context) {
        try {
            return Locale.getDefault().getLanguage();
        } catch (Throwable unused) {
            return "Unknown";
        }
    }

    /* renamed from: d */
    private static String m3815d(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            if (i > i2) {
                int i3 = i ^ i2;
                i2 ^= i3;
                i = i3 ^ i2;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(i2);
            sb.append(Marker.ANY_MARKER);
            sb.append(i);
            return sb.toString();
        } catch (Exception unused) {
            return "Unknown";
        }
    }

    /* renamed from: b */
    public static String m3811b(Context context) {
        String b = UTMCStatConfig.m3729a().mo11770b();
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        String str = "Unknown";
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo != null) {
                f3395a.put(LogField.APPVERSION.toString(), packageInfo.versionName);
                str = packageInfo.versionName;
            }
        } catch (Throwable unused) {
        }
        return str;
    }

    /* renamed from: a */
    public static boolean m3809a() {
        String str = "java.vm.name";
        try {
            if ((System.getProperty(str) == null || !System.getProperty(str).toLowerCase().contains("lemur")) && System.getProperty("ro.yunos.version") == null) {
                if (TextUtils.isEmpty(SystemProperties.m3865a("ro.yunos.build.version"))) {
                    return m3816e();
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: e */
    private static boolean m3816e() {
        return !TextUtils.isEmpty(SystemProperties.m3865a("ro.yunos.product.chip")) || !TextUtils.isEmpty(SystemProperties.m3865a("ro.yunos.hardware"));
    }

    /* renamed from: b */
    public static String m3810b() {
        String str = "false";
        String a = SystemProperties.m3866a("ro.aliyun.clouduuid", str);
        if (str.equals(a)) {
            a = SystemProperties.m3866a("ro.sys.aliyun.clouduuid", str);
        }
        return TextUtils.isEmpty(a) ? m3817f() : a;
    }

    /* renamed from: f */
    private static String m3817f() {
        try {
            return (String) Class.forName("com.yunos.baseservice.clouduuid.CloudUUID").getMethod("getCloudUUID", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: g */
    private static String m3818g() {
        try {
            Field declaredField = Build.class.getDeclaredField("YUNOS_BUILD_VERSION");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                return (String) declaredField.get(new String());
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
