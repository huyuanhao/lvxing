package com.tencent.p605ep.commonbase.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.List;

/* renamed from: com.tencent.ep.commonbase.utils.MacUtil */
public class MacUtil {
    private static final String TAG = "MacUtil";

    public static String getMac(Context context) {
        String str;
        String str2 = TAG;
        try {
            str = getMacOld(context);
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("getMacOld, mac: ");
                sb.append(str);
                Log.i(str2, sb.toString());
                String str3 = "02:00:00:00:00:00";
                if (!TextUtils.isEmpty(str)) {
                    if (!str3.equals(str)) {
                        return str;
                    }
                }
                String sysPropByReflect = getSysPropByReflect("wifi.interface");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("interfaceName: ");
                sb2.append(sysPropByReflect);
                Log.i(str2, sb2.toString());
                if (TextUtils.isEmpty(sysPropByReflect)) {
                    sysPropByReflect = "wlan0";
                }
                String macByAPI = getMacByAPI(sysPropByReflect);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("getMacByAPI, mac: ");
                sb3.append(macByAPI);
                Log.i(str2, sb3.toString());
                if (!TextUtils.isEmpty(macByAPI) && !str3.equals(macByAPI)) {
                    return macByAPI;
                }
                String macFromFile = getMacFromFile(sysPropByReflect);
                StringBuilder sb4 = new StringBuilder();
                sb4.append("getMacFromFile, mac: ");
                sb4.append(macFromFile);
                Log.i(str2, sb4.toString());
                return macFromFile;
            } catch (Throwable th) {
                th = th;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("getMac: ");
                sb5.append(th);
                Log.w(str2, sb5.toString(), th);
                return str;
            }
        } catch (Throwable th2) {
            th = th2;
            str = "";
            StringBuilder sb52 = new StringBuilder();
            sb52.append("getMac: ");
            sb52.append(th);
            Log.w(str2, sb52.toString(), th);
            return str;
        }
    }

    private static String getMacByAPI(String str) {
        String str2 = "";
        try {
            byte[] hardwareAddress = NetworkInterface.getByName(str).getHardwareAddress();
            if (hardwareAddress == null) {
                return str2;
            }
            StringBuilder sb = new StringBuilder();
            for (byte valueOf : hardwareAddress) {
                sb.append(String.format("%02x:", new Object[]{Byte.valueOf(valueOf)}));
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            str2 = sb.toString();
            return str2;
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getMacByAPI: ");
            sb2.append(th);
            Log.w(TAG, sb2.toString(), th);
        }
    }

    private static String getMacFromFile(String str) {
        String str2 = "";
        try {
            List readLines = readLines(new File(String.format("/sys/class/net/%s/address", new Object[]{str})));
            if (readLines == null || readLines.size() != 1) {
                return str2;
            }
            String str3 = (String) readLines.get(0);
            try {
                return !TextUtils.isEmpty(str3) ? str3.trim() : str3;
            } catch (Throwable th) {
                Throwable th2 = th;
                str2 = str3;
                th = th2;
                StringBuilder sb = new StringBuilder();
                sb.append("getMacFromFile: ");
                sb.append(th);
                Log.w(TAG, sb.toString(), th);
                return str2;
            }
        } catch (Throwable th3) {
            th = th3;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getMacFromFile: ");
            sb2.append(th);
            Log.w(TAG, sb2.toString(), th);
            return str2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0030  */
    private static java.lang.String getMacOld(android.content.Context r3) {
        /*
        java.lang.String r0 = ""
        java.lang.String r1 = "wifi"
        java.lang.Object r3 = r3.getSystemService(r1)     // Catch:{ all -> 0x0015 }
        android.net.wifi.WifiManager r3 = (android.net.wifi.WifiManager) r3     // Catch:{ all -> 0x0015 }
        android.net.wifi.WifiInfo r3 = r3.getConnectionInfo()     // Catch:{ all -> 0x0015 }
        if (r3 == 0) goto L_0x002c
        java.lang.String r3 = r3.getMacAddress()     // Catch:{ all -> 0x0015 }
        goto L_0x002d
    L_0x0015:
        r3 = move-exception
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        java.lang.String r2 = "getMac exception: "
        r1.append(r2)
        r1.append(r3)
        java.lang.String r1 = r1.toString()
        java.lang.String r2 = "MacUtil"
        android.util.Log.w(r2, r1, r3)
    L_0x002c:
        r3 = r0
    L_0x002d:
        if (r3 == 0) goto L_0x0030
        goto L_0x0031
    L_0x0030:
        r3 = r0
    L_0x0031:
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.utils.MacUtil.getMacOld(android.content.Context):java.lang.String");
    }

    public static String getSysPropByReflect(String str) {
        String str2 = "";
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class});
            method.setAccessible(true);
            String str3 = (String) method.invoke(null, new Object[]{str});
            return str3 == null ? str2 : str3;
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append(" getSysPropByReflect: ");
            sb.append(th);
            Log.w(TAG, sb.toString());
            return str2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0057 A[SYNTHETIC, Splitter:B:28:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005c A[Catch:{ all -> 0x0029 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0061 A[Catch:{ all -> 0x0029 }] */
    public static java.util.List<java.lang.String> readLines(java.io.File r8) {
        /*
        java.util.ArrayList r0 = new java.util.ArrayList
        r0.<init>()
        r1 = 0
        java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x003c }
        r2.<init>(r8)     // Catch:{ all -> 0x003c }
        java.io.InputStreamReader r8 = new java.io.InputStreamReader     // Catch:{ all -> 0x0039 }
        r8.<init>(r2)     // Catch:{ all -> 0x0039 }
        java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ all -> 0x0033 }
        r3.<init>(r8)     // Catch:{ all -> 0x0033 }
    L_0x0015:
        java.lang.String r1 = r3.readLine()     // Catch:{ all -> 0x002e }
        if (r1 == 0) goto L_0x001f
        r0.add(r1)     // Catch:{ all -> 0x002e }
        goto L_0x0015
    L_0x001f:
        r2.close()     // Catch:{ all -> 0x0029 }
        r8.close()     // Catch:{ all -> 0x0029 }
        r3.close()     // Catch:{ all -> 0x0029 }
        goto L_0x0064
    L_0x0029:
        r8 = move-exception
        r8.printStackTrace()
        goto L_0x0064
    L_0x002e:
        r1 = move-exception
        r7 = r1
        r1 = r8
        r8 = r7
        goto L_0x003f
    L_0x0033:
        r3 = move-exception
        r7 = r1
        r1 = r8
        r8 = r3
        r3 = r7
        goto L_0x003f
    L_0x0039:
        r8 = move-exception
        r3 = r1
        goto L_0x003f
    L_0x003c:
        r8 = move-exception
        r2 = r1
        r3 = r2
    L_0x003f:
        java.lang.String r4 = "MacUtil"
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0065 }
        r5.<init>()     // Catch:{ all -> 0x0065 }
        java.lang.String r6 = "readLines："
        r5.append(r6)     // Catch:{ all -> 0x0065 }
        r5.append(r8)     // Catch:{ all -> 0x0065 }
        java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0065 }
        android.util.Log.w(r4, r5, r8)     // Catch:{ all -> 0x0065 }
        if (r2 == 0) goto L_0x005a
        r2.close()     // Catch:{ all -> 0x0029 }
    L_0x005a:
        if (r1 == 0) goto L_0x005f
        r1.close()     // Catch:{ all -> 0x0029 }
    L_0x005f:
        if (r3 == 0) goto L_0x0064
        r3.close()     // Catch:{ all -> 0x0029 }
    L_0x0064:
        return r0
    L_0x0065:
        r8 = move-exception
        if (r2 == 0) goto L_0x006e
        r2.close()     // Catch:{ all -> 0x006c }
        goto L_0x006e
    L_0x006c:
        r0 = move-exception
        goto L_0x0079
    L_0x006e:
        if (r1 == 0) goto L_0x0073
        r1.close()     // Catch:{ all -> 0x006c }
    L_0x0073:
        if (r3 == 0) goto L_0x007c
        r3.close()     // Catch:{ all -> 0x006c }
        goto L_0x007c
    L_0x0079:
        r0.printStackTrace()
    L_0x007c:
        throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.utils.MacUtil.readLines(java.io.File):java.util.List");
    }
}
