package com.alipay.p109b.p110a.p111a.p116d;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import androidx.core.app.NotificationCompat;
import androidx.core.p003os.EnvironmentCompat;
import com.alipay.p109b.p110a.p111a.p112a.C1460a;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import com.tencent.mid.core.Constants;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import com.tencent.p605ep.commonbase.software.AppEntity;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Marker;

/* renamed from: com.alipay.b.a.a.d.b */
public class C1476b {
    /* renamed from: a */
    private static C1476b f3753a = new C1476b();

    private C1476b() {
    }

    /* renamed from: a */
    public static C1476b m4299a() {
        return f3753a;
    }

    /* renamed from: a */
    private static String m4300a(BluetoothAdapter bluetoothAdapter) {
        try {
            Field declaredField = BluetoothAdapter.class.getDeclaredField("mService");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(bluetoothAdapter);
            if (obj == null) {
                return null;
            }
            Method declaredMethod = obj.getClass().getDeclaredMethod("getAddress", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(obj, new Object[0]);
            if (invoke != null && (invoke instanceof String)) {
                return (String) invoke;
            }
            return null;
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static boolean m4301a(Context context, String str) {
        return !m4302b(context, str);
    }

    /* renamed from: b */
    public static boolean m4302b(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }

    /* renamed from: p */
    public static String m4303p() {
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                        if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                            return inetAddress.getHostAddress().toString();
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    /* renamed from: r */
    public static String m4304r(Context context) {
        if (m4301a(context, Constants.PERMISSION_ACCESS_NETWORK_STATE)) {
            return "";
        }
        String str = null;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.getType() == 1) {
                    str = "WIFI";
                } else if (activeNetworkInfo.getType() == 0) {
                    int subtype = activeNetworkInfo.getSubtype();
                    if (!(subtype == 4 || subtype == 1 || subtype == 2 || subtype == 7)) {
                        if (subtype != 11) {
                            if (!(subtype == 3 || subtype == 5 || subtype == 6 || subtype == 8 || subtype == 9 || subtype == 10 || subtype == 12 || subtype == 14)) {
                                if (subtype != 15) {
                                    str = subtype == 13 ? "4G" : "UNKNOW";
                                }
                            }
                            str = "3G";
                        }
                    }
                    str = "2G";
                }
            }
        } catch (Throwable unused) {
        }
        return str;
    }

    /* renamed from: x */
    private static String m4305x() {
        String str = "02:00:00:00:00:00";
        try {
            ArrayList list = Collections.list(NetworkInterface.getNetworkInterfaces());
            if (list != null) {
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    NetworkInterface networkInterface = (NetworkInterface) it.next();
                    if (networkInterface != null && networkInterface.getName() != null && networkInterface.getName().equalsIgnoreCase("wlan0")) {
                        byte[] hardwareAddress = networkInterface.getHardwareAddress();
                        if (hardwareAddress == null) {
                            return str;
                        }
                        StringBuilder sb = new StringBuilder();
                        for (byte b : hardwareAddress) {
                            sb.append(String.format("%02X:", new Object[]{Integer.valueOf(b & DeviceInfos.NETWORK_TYPE_UNCONNECTED)}));
                        }
                        if (sb.length() > 0) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        str = sb.toString();
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0035, code lost:
            if (r2 == null) goto L_0x0038;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0020 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0027 */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0030 A[SYNTHETIC, Splitter:B:25:0x0030] */
    /* renamed from: y */
    private static java.lang.String m4306y() {
        /*
        java.lang.String r0 = "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"
        r1 = 0
        java.io.FileReader r2 = new java.io.FileReader     // Catch:{ all -> 0x002d }
        r2.<init>(r0)     // Catch:{ all -> 0x002d }
        java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ all -> 0x002e }
        r3 = 8192(0x2000, float:1.14794E-41)
        r0.<init>(r2, r3)     // Catch:{ all -> 0x002e }
        java.lang.String r1 = r0.readLine()     // Catch:{ all -> 0x002b }
        boolean r3 = com.alipay.p109b.p110a.p111a.p112a.C1460a.m4260a(r1)     // Catch:{ all -> 0x002b }
        if (r3 != 0) goto L_0x0024
        java.lang.String r1 = r1.trim()     // Catch:{ all -> 0x002b }
        r0.close()     // Catch:{ all -> 0x0020 }
    L_0x0020:
        r2.close()     // Catch:{ all -> 0x0023 }
    L_0x0023:
        return r1
    L_0x0024:
        r0.close()     // Catch:{ all -> 0x0027 }
    L_0x0027:
        r2.close()     // Catch:{ all -> 0x0038 }
        goto L_0x0038
    L_0x002b:
        r1 = r0
        goto L_0x002e
    L_0x002d:
        r2 = r1
    L_0x002e:
        if (r1 == 0) goto L_0x0035
        r1.close()     // Catch:{ all -> 0x0034 }
        goto L_0x0035
    L_0x0035:
        if (r2 == 0) goto L_0x0038
        goto L_0x0027
    L_0x0038:
        java.lang.String r0 = ""
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.p109b.p110a.p111a.p116d.C1476b.m4306y():java.lang.String");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:19|20) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            r0.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x003d */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0048 A[SYNTHETIC, Splitter:B:27:0x0048] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x004f A[SYNTHETIC, Splitter:B:31:0x004f] */
    /* renamed from: z */
    private static java.lang.String m4307z() {
        /*
        java.lang.String r0 = "/proc/cpuinfo"
        java.lang.String r1 = ""
        r2 = 0
        java.io.FileReader r3 = new java.io.FileReader     // Catch:{ all -> 0x0045 }
        r3.<init>(r0)     // Catch:{ all -> 0x0045 }
        java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ all -> 0x0043 }
        r4 = 8192(0x2000, float:1.14794E-41)
        r0.<init>(r3, r4)     // Catch:{ all -> 0x0043 }
    L_0x0011:
        java.lang.String r2 = r0.readLine()     // Catch:{ all -> 0x0041 }
        if (r2 == 0) goto L_0x003a
        boolean r4 = com.alipay.p109b.p110a.p111a.p112a.C1460a.m4260a(r2)     // Catch:{ all -> 0x0041 }
        if (r4 != 0) goto L_0x0011
        java.lang.String r4 = ":"
        java.lang.String[] r2 = r2.split(r4)     // Catch:{ all -> 0x0041 }
        if (r2 == 0) goto L_0x0011
        int r4 = r2.length     // Catch:{ all -> 0x0041 }
        r5 = 1
        if (r4 <= r5) goto L_0x0011
        r4 = 0
        r4 = r2[r4]     // Catch:{ all -> 0x0041 }
        java.lang.String r6 = "BogoMIPS"
        boolean r4 = r4.contains(r6)     // Catch:{ all -> 0x0041 }
        if (r4 == 0) goto L_0x0011
        r2 = r2[r5]     // Catch:{ all -> 0x0041 }
        java.lang.String r1 = r2.trim()     // Catch:{ all -> 0x0041 }
    L_0x003a:
        r3.close()     // Catch:{ all -> 0x003d }
    L_0x003d:
        r0.close()     // Catch:{ all -> 0x0052 }
        goto L_0x0052
    L_0x0041:
        r2 = r0
        goto L_0x0046
        goto L_0x0046
    L_0x0045:
        r3 = r2
    L_0x0046:
        if (r3 == 0) goto L_0x004d
        r3.close()     // Catch:{ all -> 0x004c }
        goto L_0x004d
    L_0x004d:
        if (r2 == 0) goto L_0x0052
        r2.close()     // Catch:{ all -> 0x0052 }
    L_0x0052:
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.p109b.p110a.p111a.p116d.C1476b.m4307z():java.lang.String");
    }

    /* renamed from: a */
    public String mo12033a(Context context) {
        String str = "";
        if (m4301a(context, Constants.PERMISSION_READ_PHONE_STATE)) {
            return str;
        }
        String str2 = null;
        if (context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    str2 = telephonyManager.getDeviceId();
                }
            } catch (Throwable unused) {
            }
        }
        if (str2 == null) {
            str2 = str;
        }
        return str2;
    }

    /* renamed from: b */
    public String mo12034b() {
        long j;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            j = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Throwable unused) {
            j = 0;
        }
        return String.valueOf(j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001f  */
    /* renamed from: b */
    public java.lang.String mo12035b(android.content.Context r3) {
        /*
        r2 = this;
        java.lang.String r0 = "android.permission.READ_PHONE_STATE"
        boolean r0 = m4301a(r3, r0)
        java.lang.String r1 = ""
        if (r0 == 0) goto L_0x000b
        return r1
    L_0x000b:
        if (r3 == 0) goto L_0x001c
        java.lang.String r0 = "phone"
        java.lang.Object r3 = r3.getSystemService(r0)     // Catch:{ all -> 0x001c }
        android.telephony.TelephonyManager r3 = (android.telephony.TelephonyManager) r3     // Catch:{ all -> 0x001c }
        if (r3 == 0) goto L_0x001c
        java.lang.String r3 = r3.getSubscriberId()     // Catch:{ all -> 0x001c }
        goto L_0x001d
    L_0x001c:
        r3 = r1
    L_0x001d:
        if (r3 != 0) goto L_0x0020
        r3 = r1
    L_0x0020:
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.p109b.p110a.p111a.p116d.C1476b.mo12035b(android.content.Context):java.lang.String");
    }

    /* renamed from: c */
    public String mo12036c() {
        long j = 0;
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                StatFs statFs = new StatFs(C1460a.m4257a().getPath());
                j = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
            }
        } catch (Throwable unused) {
        }
        return String.valueOf(j);
    }

    /* renamed from: c */
    public String mo12037c(Context context) {
        int i = 0;
        try {
            i = System.getInt(context.getContentResolver(), "airplane_mode_on", 0);
        } catch (Throwable unused) {
        }
        return i == 1 ? "1" : "0";
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:21|22) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:0|(8:1|2|3|4|5|6|7|(2:8|(3:10|11|(2:13|(2:42|15)(1:16))(0))(0)))|23|24|(2:41|43)(1:44)|(1:(0))) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
            r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0066, code lost:
            if (r2 != null) goto L_0x004c;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0049 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x004c */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005a A[SYNTHETIC, Splitter:B:32:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0061 A[SYNTHETIC, Splitter:B:36:0x0061] */
    /* renamed from: d */
    public java.lang.String mo12038d() {
        /*
        r8 = this;
        java.lang.String r0 = "0000000000000000"
        r1 = 0
        java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x0056 }
        java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0056 }
        java.lang.String r4 = "/proc/cpuinfo"
        r3.<init>(r4)     // Catch:{ all -> 0x0056 }
        r2.<init>(r3)     // Catch:{ all -> 0x0056 }
        java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x0054 }
        r3.<init>(r2)     // Catch:{ all -> 0x0054 }
        java.io.LineNumberReader r4 = new java.io.LineNumberReader     // Catch:{ all -> 0x0052 }
        r4.<init>(r3)     // Catch:{ all -> 0x0052 }
        r1 = 1
        r5 = 1
    L_0x001b:
        r6 = 100
        if (r5 >= r6) goto L_0x0046
        java.lang.String r6 = r4.readLine()     // Catch:{ all -> 0x0044 }
        if (r6 == 0) goto L_0x0046
        java.lang.String r7 = "Serial"
        int r7 = r6.indexOf(r7)     // Catch:{ all -> 0x0044 }
        if (r7 < 0) goto L_0x0041
        java.lang.String r5 = ":"
        int r5 = r6.indexOf(r5)     // Catch:{ all -> 0x0044 }
        int r5 = r5 + r1
        int r1 = r6.length()     // Catch:{ all -> 0x0044 }
        java.lang.String r1 = r6.substring(r5, r1)     // Catch:{ all -> 0x0044 }
        java.lang.String r0 = r1.trim()     // Catch:{ all -> 0x0044 }
        goto L_0x0046
    L_0x0041:
        int r5 = r5 + 1
        goto L_0x001b
    L_0x0044:
        r1 = r4
        goto L_0x0058
    L_0x0046:
        r4.close()     // Catch:{ all -> 0x0049 }
    L_0x0049:
        r3.close()     // Catch:{ all -> 0x004c }
    L_0x004c:
        r2.close()     // Catch:{ all -> 0x0050 }
        goto L_0x0069
        goto L_0x0069
        goto L_0x0058
    L_0x0054:
        r3 = r1
        goto L_0x0058
    L_0x0056:
        r2 = r1
        r3 = r2
    L_0x0058:
        if (r1 == 0) goto L_0x005f
        r1.close()     // Catch:{ all -> 0x005e }
        goto L_0x005f
    L_0x005f:
        if (r3 == 0) goto L_0x0066
        r3.close()     // Catch:{ all -> 0x0065 }
        goto L_0x0066
    L_0x0066:
        if (r2 == 0) goto L_0x0069
        goto L_0x004c
    L_0x0069:
        if (r0 != 0) goto L_0x006d
        java.lang.String r0 = ""
    L_0x006d:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.p109b.p110a.p111a.p116d.C1476b.mo12038d():java.lang.String");
    }

    /* renamed from: d */
    public String mo12039d(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            int i = audioManager.getRingerMode() == 0 ? 1 : 0;
            int streamVolume = audioManager.getStreamVolume(0);
            int streamVolume2 = audioManager.getStreamVolume(1);
            int streamVolume3 = audioManager.getStreamVolume(2);
            int streamVolume4 = audioManager.getStreamVolume(3);
            int streamVolume5 = audioManager.getStreamVolume(4);
            jSONObject.put("ringermode", String.valueOf(i));
            jSONObject.put(NotificationCompat.CATEGORY_CALL, String.valueOf(streamVolume));
            jSONObject.put("system", String.valueOf(streamVolume2));
            jSONObject.put(MessageKey.MSG_RING, String.valueOf(streamVolume3));
            jSONObject.put("music", String.valueOf(streamVolume4));
            jSONObject.put(NotificationCompat.CATEGORY_ALARM, String.valueOf(streamVolume5));
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    /* renamed from: e */
    public String mo12040e() {
        try {
            return String.valueOf(new File("/sys/devices/system/cpu/").listFiles(new C1477c(this)).length);
        } catch (Throwable unused) {
            return "1";
        }
    }

    /* renamed from: e */
    public String mo12041e(Context context) {
        String str = null;
        if (context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    str = telephonyManager.getNetworkOperatorName();
                }
            } catch (Throwable unused) {
            }
        }
        return (str == null || "null".equals(str)) ? "" : str;
    }

    /* renamed from: f */
    public String mo12042f() {
        String y = m4306y();
        return !C1460a.m4260a(y) ? y : m4307z();
    }

    /* renamed from: f */
    public String mo12043f(Context context) {
        String str = null;
        if (context != null) {
            try {
                SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
                if (sensorManager != null) {
                    List<Sensor> sensorList = sensorManager.getSensorList(-1);
                    if (sensorList != null && sensorList.size() > 0) {
                        StringBuilder sb = new StringBuilder();
                        for (Sensor sensor : sensorList) {
                            sb.append(sensor.getName());
                            sb.append(sensor.getVersion());
                            sb.append(sensor.getVendor());
                        }
                        str = C1460a.m4266e(sb.toString());
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return str == null ? "" : str;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0023 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x002a */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0035 A[SYNTHETIC, Splitter:B:27:0x0035] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x003c A[SYNTHETIC, Splitter:B:31:0x003c] */
    /* renamed from: g */
    public java.lang.String mo12044g() {
        /*
        r5 = this;
        r0 = 0
        java.io.FileReader r1 = new java.io.FileReader     // Catch:{ all -> 0x0032 }
        java.lang.String r2 = "/proc/cpuinfo"
        r1.<init>(r2)     // Catch:{ all -> 0x0032 }
        java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x0030 }
        r2.<init>(r1)     // Catch:{ all -> 0x0030 }
        java.lang.String r0 = r2.readLine()     // Catch:{ all -> 0x002e }
        java.lang.String r3 = ":\\s+"
        r4 = 2
        java.lang.String[] r0 = r0.split(r3, r4)     // Catch:{ all -> 0x002e }
        if (r0 == 0) goto L_0x0027
        int r3 = r0.length     // Catch:{ all -> 0x002e }
        r4 = 1
        if (r3 <= r4) goto L_0x0027
        r0 = r0[r4]     // Catch:{ all -> 0x002e }
        r1.close()     // Catch:{ all -> 0x0023 }
    L_0x0023:
        r2.close()     // Catch:{ all -> 0x0026 }
    L_0x0026:
        return r0
    L_0x0027:
        r1.close()     // Catch:{ all -> 0x002a }
    L_0x002a:
        r2.close()     // Catch:{ all -> 0x003f }
        goto L_0x003f
    L_0x002e:
        r0 = r2
        goto L_0x0033
        goto L_0x0033
    L_0x0032:
        r1 = r0
    L_0x0033:
        if (r1 == 0) goto L_0x003a
        r1.close()     // Catch:{ all -> 0x0039 }
        goto L_0x003a
    L_0x003a:
        if (r0 == 0) goto L_0x003f
        r0.close()     // Catch:{ all -> 0x003f }
    L_0x003f:
        java.lang.String r0 = ""
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.p109b.p110a.p111a.p116d.C1476b.mo12044g():java.lang.String");
    }

    /* renamed from: g */
    public String mo12045g(Context context) {
        JSONArray jSONArray = new JSONArray();
        if (context != null) {
            try {
                SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
                if (sensorManager != null) {
                    List<Sensor> sensorList = sensorManager.getSensorList(-1);
                    if (sensorList != null && sensorList.size() > 0) {
                        for (Sensor sensor : sensorList) {
                            if (sensor != null) {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put(ArgKey.KEY_NAME, sensor.getName());
                                jSONObject.put(AppEntity.KEY_VERSION_STR, sensor.getVersion());
                                jSONObject.put("vendor", sensor.getVendor());
                                jSONArray.put(jSONObject);
                            }
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return jSONArray.toString();
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0029 */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0034 A[SYNTHETIC, Splitter:B:20:0x0034] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003b A[SYNTHETIC, Splitter:B:24:0x003b] */
    /* renamed from: h */
    public java.lang.String mo12046h() {
        /*
        r6 = this;
        java.lang.String r0 = "/proc/meminfo"
        r1 = 0
        r2 = 0
        java.io.FileReader r4 = new java.io.FileReader     // Catch:{ all -> 0x0031 }
        r4.<init>(r0)     // Catch:{ all -> 0x0031 }
        java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ all -> 0x002f }
        r5 = 8192(0x2000, float:1.14794E-41)
        r0.<init>(r4, r5)     // Catch:{ all -> 0x002f }
        java.lang.String r1 = r0.readLine()     // Catch:{ all -> 0x002d }
        if (r1 == 0) goto L_0x0026
        java.lang.String r5 = "\\s+"
        java.lang.String[] r1 = r1.split(r5)     // Catch:{ all -> 0x002d }
        r5 = 1
        r1 = r1[r5]     // Catch:{ all -> 0x002d }
        int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ all -> 0x002d }
        long r1 = (long) r1
        r2 = r1
    L_0x0026:
        r4.close()     // Catch:{ all -> 0x0029 }
    L_0x0029:
        r0.close()     // Catch:{ all -> 0x003e }
        goto L_0x003e
    L_0x002d:
        r1 = r0
        goto L_0x0032
        goto L_0x0032
    L_0x0031:
        r4 = r1
    L_0x0032:
        if (r4 == 0) goto L_0x0039
        r4.close()     // Catch:{ all -> 0x0038 }
        goto L_0x0039
    L_0x0039:
        if (r1 == 0) goto L_0x003e
        r1.close()     // Catch:{ all -> 0x003e }
    L_0x003e:
        java.lang.String r0 = java.lang.String.valueOf(r2)
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.p109b.p110a.p111a.p116d.C1476b.mo12046h():java.lang.String");
    }

    /* renamed from: h */
    public String mo12047h(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toString(displayMetrics.widthPixels));
            sb.append(Marker.ANY_MARKER);
            sb.append(Integer.toString(displayMetrics.heightPixels));
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: i */
    public String mo12048i() {
        long j;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            j = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable unused) {
            j = 0;
        }
        return String.valueOf(j);
    }

    /* renamed from: i */
    public String mo12049i(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            StringBuilder sb = new StringBuilder();
            sb.append(displayMetrics.widthPixels);
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: j */
    public String mo12050j() {
        long j = 0;
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                j = ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
            }
        } catch (Throwable unused) {
        }
        return String.valueOf(j);
    }

    /* renamed from: j */
    public String mo12051j(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            StringBuilder sb = new StringBuilder();
            sb.append(displayMetrics.heightPixels);
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0029  */
    /* renamed from: k */
    public java.lang.String mo12052k() {
        /*
        r4 = this;
        java.lang.String r0 = ""
        android.bluetooth.BluetoothAdapter r1 = android.bluetooth.BluetoothAdapter.getDefaultAdapter()     // Catch:{ all -> 0x0014 }
        if (r1 == 0) goto L_0x000f
        boolean r2 = r1.isEnabled()     // Catch:{ all -> 0x0015 }
        if (r2 != 0) goto L_0x000f
        return r0
    L_0x000f:
        java.lang.String r2 = r1.getAddress()     // Catch:{ all -> 0x0015 }
        goto L_0x0016
    L_0x0014:
        r1 = 0
    L_0x0015:
        r2 = r0
    L_0x0016:
        if (r2 == 0) goto L_0x0020
        java.lang.String r3 = "00:00:00:00:00"
        boolean r3 = r2.endsWith(r3)
        if (r3 == 0) goto L_0x0025
    L_0x0020:
        java.lang.String r1 = m4300a(r1)     // Catch:{ all -> 0x0025 }
        goto L_0x0026
    L_0x0025:
        r1 = r2
    L_0x0026:
        if (r1 != 0) goto L_0x0029
        goto L_0x002a
    L_0x0029:
        r0 = r1
    L_0x002a:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.p109b.p110a.p111a.p116d.C1476b.mo12052k():java.lang.String");
    }

    /* renamed from: k */
    public String mo12053k(Context context) {
        String str = "";
        if (m4301a(context, Constants.PERMISSION_ACCESS_WIFI_STATE)) {
            return str;
        }
        try {
            str = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
            if (str == null || str.length() == 0 || "02:00:00:00:00:00".equals(str)) {
                return m4305x();
            }
        } catch (Throwable unused) {
        }
        return str;
    }

    /* renamed from: l */
    public String mo12054l() {
        String str;
        String str2 = "";
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            str = (String) cls.getMethod("get", new Class[]{String.class, String.class}).invoke(cls.newInstance(), new Object[]{"gsm.version.baseband", "no message"});
        } catch (Throwable unused) {
            str = str2;
        }
        return str == null ? str2 : str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001f, code lost:
            if (r3.length() == 0) goto L_0x0021;
     */
    /* renamed from: l */
    public java.lang.String mo12055l(android.content.Context r3) {
        /*
        r2 = this;
        java.lang.String r0 = "android.permission.READ_PHONE_STATE"
        boolean r0 = m4301a(r3, r0)
        java.lang.String r1 = ""
        if (r0 == 0) goto L_0x000b
        return r1
    L_0x000b:
        java.lang.String r0 = "phone"
        java.lang.Object r3 = r3.getSystemService(r0)     // Catch:{ all -> 0x0021 }
        android.telephony.TelephonyManager r3 = (android.telephony.TelephonyManager) r3     // Catch:{ all -> 0x0021 }
        java.lang.String r3 = r3.getSimSerialNumber()     // Catch:{ all -> 0x0021 }
        if (r3 == 0) goto L_0x0021
        if (r3 == 0) goto L_0x0022
        int r0 = r3.length()     // Catch:{ all -> 0x0022 }
        if (r0 != 0) goto L_0x0022
    L_0x0021:
        r3 = r1
    L_0x0022:
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.p109b.p110a.p111a.p116d.C1476b.mo12055l(android.content.Context):java.lang.String");
    }

    /* renamed from: m */
    public String mo12056m() {
        String str;
        String str2 = "";
        try {
            str = Build.SERIAL;
        } catch (Throwable unused) {
            str = str2;
        }
        return str == null ? str2 : str;
    }

    /* renamed from: m */
    public String mo12057m(Context context) {
        String str;
        String str2 = "";
        try {
            str = Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable unused) {
            str = str2;
        }
        return str == null ? str2 : str;
    }

    /* renamed from: n */
    public String mo12058n() {
        String str;
        String str2 = "";
        try {
            str = Locale.getDefault().toString();
        } catch (Throwable unused) {
            str = str2;
        }
        return str == null ? str2 : str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0030  */
    /* renamed from: n */
    public java.lang.String mo12059n(android.content.Context r4) {
        /*
        r3 = this;
        java.lang.String r0 = "android.permission.BLUETOOTH"
        boolean r0 = m4301a(r4, r0)
        java.lang.String r1 = ""
        if (r0 == 0) goto L_0x000b
        return r1
    L_0x000b:
        java.lang.String r0 = r3.mo12052k()
        if (r0 == 0) goto L_0x0022
        int r2 = r0.length()     // Catch:{ all -> 0x0031 }
        if (r2 == 0) goto L_0x0022
        java.lang.String r2 = "02:00:00:00:00:00"
        boolean r2 = r2.equals(r0)     // Catch:{ all -> 0x0031 }
        if (r2 == 0) goto L_0x0020
        goto L_0x0022
    L_0x0020:
        r4 = r0
        goto L_0x002c
    L_0x0022:
        android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ all -> 0x0031 }
        java.lang.String r2 = "bluetooth_address"
        java.lang.String r4 = android.provider.Settings.Secure.getString(r4, r2)     // Catch:{ all -> 0x0031 }
    L_0x002c:
        if (r4 != 0) goto L_0x0030
        r0 = r1
        goto L_0x0031
    L_0x0030:
        r0 = r4
    L_0x0031:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.p109b.p110a.p111a.p116d.C1476b.mo12059n(android.content.Context):java.lang.String");
    }

    /* renamed from: o */
    public String mo12060o() {
        String str;
        String str2 = "";
        try {
            str = TimeZone.getDefault().getDisplayName(false, 0);
        } catch (Throwable unused) {
            str = str2;
        }
        return str == null ? str2 : str;
    }

    /* renamed from: o */
    public String mo12061o(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return String.valueOf(telephonyManager.getNetworkType());
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0025  */
    /* renamed from: p */
    public java.lang.String mo12062p(android.content.Context r3) {
        /*
        r2 = this;
        java.lang.String r0 = "android.permission.ACCESS_WIFI_STATE"
        boolean r0 = m4301a(r3, r0)
        java.lang.String r1 = ""
        if (r0 == 0) goto L_0x000b
        return r1
    L_0x000b:
        java.lang.String r0 = "wifi"
        java.lang.Object r3 = r3.getSystemService(r0)     // Catch:{ all -> 0x0022 }
        android.net.wifi.WifiManager r3 = (android.net.wifi.WifiManager) r3     // Catch:{ all -> 0x0022 }
        boolean r0 = r3.isWifiEnabled()     // Catch:{ all -> 0x0022 }
        if (r0 == 0) goto L_0x0022
        android.net.wifi.WifiInfo r3 = r3.getConnectionInfo()     // Catch:{ all -> 0x0022 }
        java.lang.String r3 = r3.getBSSID()     // Catch:{ all -> 0x0022 }
        goto L_0x0023
    L_0x0022:
        r3 = r1
    L_0x0023:
        if (r3 != 0) goto L_0x0026
        r3 = r1
    L_0x0026:
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.p109b.p110a.p111a.p116d.C1476b.mo12062p(android.content.Context):java.lang.String");
    }

    /* renamed from: q */
    public String mo12063q() {
        try {
            long currentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
            StringBuilder sb = new StringBuilder();
            sb.append(currentTimeMillis - (currentTimeMillis % 1000));
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: q */
    public String mo12064q(Context context) {
        String str = "";
        try {
            String r = m4304r(context);
            String p = m4303p();
            if (!C1460a.m4263b(r) || !C1460a.m4263b(p)) {
                return str;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(r);
            sb.append(":");
            sb.append(m4303p());
            return sb.toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    /* renamed from: r */
    public String mo12065r() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(SystemClock.elapsedRealtime());
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: s */
    public String mo12066s() {
        String str = "00";
        try {
            StringBuilder sb = new StringBuilder();
            String[] strArr = {"/dev/qemu_pipe", "/dev/socket/qemud", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/genyd", "/dev/socket/baseband_genyd"};
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(":");
            sb.append(sb2.toString());
            for (int i = 0; i < 7; i++) {
                sb.append(new File(strArr[i]).exists() ? "1" : "0");
            }
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:9|10|11|12|13|14|7) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0032 */
    /* renamed from: s */
    public java.lang.String mo12067s(android.content.Context r8) {
        /*
        r7 = this;
        java.lang.String r0 = "keyguard"
        java.lang.Object r8 = r8.getSystemService(r0)     // Catch:{ all -> 0x0048 }
        android.app.KeyguardManager r8 = (android.app.KeyguardManager) r8     // Catch:{ all -> 0x0048 }
        boolean r8 = r8.isKeyguardSecure()     // Catch:{ all -> 0x0048 }
        r0 = 0
        if (r8 != 0) goto L_0x0013
        java.lang.String r8 = "0:0"
        return r8
    L_0x0013:
        java.lang.String r8 = "/data/system/password.key"
        java.lang.String r2 = "/data/system/gesture.key"
        java.lang.String r3 = "/data/system/gatekeeper.password.key"
        java.lang.String r4 = "/data/system/gatekeeper.gesture.key"
        java.lang.String r5 = "/data/system/gatekeeper.pattern.key"
        java.lang.String[] r8 = new java.lang.String[]{r8, r2, r3, r4, r5}     // Catch:{ all -> 0x0048 }
        r2 = 0
    L_0x0022:
        r3 = 5
        if (r2 >= r3) goto L_0x0039
        r3 = r8[r2]     // Catch:{ all -> 0x0048 }
        r4 = -1
        java.io.File r6 = new java.io.File     // Catch:{ all -> 0x0032 }
        r6.<init>(r3)     // Catch:{ all -> 0x0032 }
        long r4 = r6.lastModified()     // Catch:{ all -> 0x0032 }
    L_0x0032:
        long r0 = java.lang.Math.max(r4, r0)     // Catch:{ all -> 0x0048 }
        int r2 = r2 + 1
        goto L_0x0022
    L_0x0039:
        java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0048 }
        java.lang.String r2 = "1:"
        r8.<init>(r2)     // Catch:{ all -> 0x0048 }
        r8.append(r0)     // Catch:{ all -> 0x0048 }
        java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0048 }
        return r8
    L_0x0048:
        java.lang.String r8 = ""
        return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.p109b.p110a.p111a.p116d.C1476b.mo12067s(android.content.Context):java.lang.String");
    }

    /* renamed from: t */
    public String mo12068t() {
        String[] strArr = {"dalvik.system.Taint"};
        StringBuilder sb = new StringBuilder();
        sb.append("00");
        sb.append(":");
        for (int i = 0; i <= 0; i++) {
            try {
                Class.forName(strArr[0]);
                sb.append("1");
            } catch (Throwable unused) {
                sb.append("0");
            }
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002a A[Catch:{ all -> 0x003f }] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002d A[Catch:{ all -> 0x003f }] */
    /* renamed from: t */
    public java.lang.String mo12069t(android.content.Context r4) {
        /*
        r3 = this;
        android.content.IntentFilter r0 = new android.content.IntentFilter     // Catch:{ all -> 0x003f }
        java.lang.String r1 = "android.intent.action.BATTERY_CHANGED"
        r0.<init>(r1)     // Catch:{ all -> 0x003f }
        r1 = 0
        android.content.Intent r4 = r4.registerReceiver(r1, r0)     // Catch:{ all -> 0x003f }
        java.lang.String r0 = "level"
        r1 = -1
        int r0 = r4.getIntExtra(r0, r1)     // Catch:{ all -> 0x003f }
        java.lang.String r2 = "status"
        int r4 = r4.getIntExtra(r2, r1)     // Catch:{ all -> 0x003f }
        r1 = 2
        if (r4 == r1) goto L_0x0022
        r1 = 5
        if (r4 != r1) goto L_0x0020
        goto L_0x0022
    L_0x0020:
        r4 = 0
        goto L_0x0023
    L_0x0022:
        r4 = 1
    L_0x0023:
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x003f }
        r1.<init>()     // Catch:{ all -> 0x003f }
        if (r4 == 0) goto L_0x002d
        java.lang.String r4 = "1"
        goto L_0x002f
    L_0x002d:
        java.lang.String r4 = "0"
    L_0x002f:
        r1.append(r4)     // Catch:{ all -> 0x003f }
        java.lang.String r4 = ":"
        r1.append(r4)     // Catch:{ all -> 0x003f }
        r1.append(r0)     // Catch:{ all -> 0x003f }
        java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x003f }
        return r4
    L_0x003f:
        java.lang.String r4 = ""
        return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.p109b.p110a.p111a.p116d.C1476b.mo12069t(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0080 A[SYNTHETIC, Splitter:B:23:0x0080] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x003b A[SYNTHETIC] */
    /* renamed from: u */
    public java.lang.String mo12070u() {
        /*
        r9 = this;
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
        r1.<init>()
        java.lang.String r2 = "/system/build.prop"
        java.lang.String r3 = "ro.product.name=sdk"
        r1.put(r2, r3)
        java.lang.String r2 = "goldfish"
        java.lang.String r3 = "/proc/tty/drivers"
        r1.put(r3, r2)
        java.lang.String r3 = "/proc/cpuinfo"
        r1.put(r3, r2)
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        java.lang.String r3 = "00"
        r2.append(r3)
        java.lang.String r3 = ":"
        r2.append(r3)
        java.lang.String r2 = r2.toString()
        r0.append(r2)
        java.util.Set r2 = r1.keySet()
        java.util.Iterator r2 = r2.iterator()
    L_0x003b:
        boolean r3 = r2.hasNext()
        if (r3 == 0) goto L_0x0084
        java.lang.Object r3 = r2.next()
        java.lang.String r3 = (java.lang.String) r3
        r4 = 0
        r5 = 48
        java.io.LineNumberReader r6 = new java.io.LineNumberReader     // Catch:{ all -> 0x007b }
        java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch:{ all -> 0x007b }
        java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ all -> 0x007b }
        r8.<init>(r3)     // Catch:{ all -> 0x007b }
        r7.<init>(r8)     // Catch:{ all -> 0x007b }
        r6.<init>(r7)     // Catch:{ all -> 0x007b }
    L_0x0059:
        java.lang.String r4 = r6.readLine()     // Catch:{ all -> 0x007a }
        if (r4 == 0) goto L_0x0071
        java.lang.String r4 = r4.toLowerCase()     // Catch:{ all -> 0x007a }
        java.lang.Object r7 = r1.get(r3)     // Catch:{ all -> 0x007a }
        java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ all -> 0x007a }
        boolean r4 = r4.contains(r7)     // Catch:{ all -> 0x007a }
        if (r4 == 0) goto L_0x0059
        r5 = 49
    L_0x0071:
        r0.append(r5)
        r6.close()     // Catch:{ all -> 0x0078 }
        goto L_0x003b
        goto L_0x003b
    L_0x007a:
        r4 = r6
    L_0x007b:
        r0.append(r5)
        if (r4 == 0) goto L_0x003b
        r4.close()     // Catch:{ all -> 0x0078 }
        goto L_0x003b
    L_0x0084:
        java.lang.String r0 = r0.toString()
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.p109b.p110a.p111a.p116d.C1476b.mo12070u():java.lang.String");
    }

    /* renamed from: v */
    public String mo12071v() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("00");
        sb2.append(":");
        sb.append(sb2.toString());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str = "generic";
        linkedHashMap.put("BRAND", str);
        linkedHashMap.put("BOARD", EnvironmentCompat.MEDIA_UNKNOWN);
        linkedHashMap.put("DEVICE", str);
        linkedHashMap.put("HARDWARE", "goldfish");
        String str2 = "sdk";
        linkedHashMap.put("PRODUCT", str2);
        linkedHashMap.put("MODEL", str2);
        for (String str3 : linkedHashMap.keySet()) {
            char c = '0';
            try {
                String str4 = null;
                String str5 = (String) Build.class.getField(str3).get(null);
                String str6 = (String) linkedHashMap.get(str3);
                if (str5 != null) {
                    str4 = str5.toLowerCase();
                }
                if (str4 != null && str4.contains(str6)) {
                    c = '1';
                }
            } catch (Throwable unused) {
            }
            sb.append(c);
        }
        return sb.toString();
    }

    /* renamed from: w */
    public String mo12072w() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("00");
        sb2.append(":");
        sb.append(sb2.toString());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("ro.hardware", "goldfish");
        linkedHashMap.put("ro.kernel.qemu", "1");
        String str = "generic";
        linkedHashMap.put("ro.product.device", str);
        String str2 = "sdk";
        linkedHashMap.put("ro.product.model", str2);
        linkedHashMap.put("ro.product.brand", str);
        linkedHashMap.put("ro.product.name", str2);
        linkedHashMap.put("ro.build.fingerprint", "test-keys");
        linkedHashMap.put("ro.product.manufacturer", "unknow");
        for (String str3 : linkedHashMap.keySet()) {
            char c = '0';
            String str4 = (String) linkedHashMap.get(str3);
            String b = C1460a.m4262b(str3, "");
            if (b != null && b.contains(str4)) {
                c = '1';
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
