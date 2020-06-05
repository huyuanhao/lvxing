package com.tencent.p605ep.commonbase.utils;

import android.content.Context;
import android.graphics.Camera;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.Settings.Secure;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.util.Log;
import com.tencent.p605ep.commonbase.api.AppContext;
import com.tencent.p605ep.commonbase.utils.SdcardUtil.SizeInfo;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.List;

/* renamed from: com.tencent.ep.commonbase.utils.PhoneInfoUtil */
public final class PhoneInfoUtil {
    public static final String KEY_IMEI1 = "imei1";
    public static final String KEY_IMEI2 = "imei2";
    public static final String KEY_MEID = "meid";
    private static final String TAG = "PhoneInfoUtil";
    private static long mTotalMemorySize = -1;

    public static List<CellInfo> getAllCellInfo(TelephonyManager telephonyManager) {
        try {
            return telephonyManager.getAllCellInfo();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    public static String getAndoidId(Context context) {
        try {
            return Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getBoard() {
        return Build.BOARD;
    }

    public static String getBrand() {
        return Build.BRAND;
    }

    public static String getBuildPropByReflect(String str) {
        String str2 = "";
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class});
            method.setAccessible(true);
            String str3 = (String) method.invoke(null, new Object[]{str});
            return str3 == null ? str2 : str3;
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append(" getBuildPropByReflect: ");
            sb.append(th);
            Log.w(TAG, sb.toString());
            return str2;
        }
    }

    public static String getBuildPropFiel(String str) {
        return getBuildPropByReflect(str);
    }

    public static int getCellId() {
        int i = -1;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) AppContext.getAppContext().getApplicationContext().getSystemService("phone");
            if (telephonyManager == null) {
                return -1;
            }
            CellLocation cellLocation = telephonyManager.getCellLocation();
            if (cellLocation == null) {
                return -1;
            }
            if (cellLocation instanceof GsmCellLocation) {
                i = ((GsmCellLocation) cellLocation).getCid();
            }
            return cellLocation instanceof CdmaCellLocation ? ((CdmaCellLocation) cellLocation).getBaseStationId() : i;
        } catch (SecurityException e) {
            e.printStackTrace();
            return -1;
        } catch (Throwable th) {
            com.tencent.p605ep.commonbase.api.Log.m31479e(TAG, th);
            return -1;
        }
    }

    public static CellLocation getCellLocation(TelephonyManager telephonyManager) {
        try {
            return telephonyManager.getCellLocation();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    public static String getDevice() {
        return Build.DEVICE;
    }

    public static String getDeviceId(TelephonyManager telephonyManager) {
        try {
            return telephonyManager.getDeviceId();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    public static String getDeviceId(TelephonyManager telephonyManager, int i) {
        String str = null;
        if (VERSION.SDK_INT < 23) {
            return null;
        }
        try {
            str = telephonyManager.getDeviceId(i);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return str;
    }

    public static String getICCID() {
        try {
            return ((TelephonyManager) AppContext.getAppContext().getSystemService("phone")).getSimSerialNumber();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    public static String getIMEI() {
        String str;
        String str2 = null;
        try {
            str2 = ((TelephonyManager) AppContext.getAppContext().getSystemService("phone")).getDeviceId();
            return str2;
        } catch (SecurityException e) {
            e.printStackTrace();
            return str;
        } catch (Throwable th) {
            th.printStackTrace();
            return str2;
        }
    }

    public static String getIMSI() {
        try {
            return ((TelephonyManager) AppContext.getAppContext().getSystemService("phone")).getSubscriberId();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    public static String getIMSI(int i) {
        try {
            return ((TelephonyManager) AppContext.getAppContext().getSystemService("phone")).getSubscriberId();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:73:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x019e  */
    public static java.util.Map<java.lang.String, java.lang.String> getImeiAndMeid() {
        /*
        java.lang.String r0 = "PhoneInfoUtil"
        java.util.HashMap r1 = new java.util.HashMap
        r1.<init>()
        r2 = 0
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ SecurityException -> 0x017c, all -> 0x0170 }
        r3.<init>()     // Catch:{ SecurityException -> 0x017c, all -> 0x0170 }
        java.lang.String r4 = "android api: "
        r3.append(r4)     // Catch:{ SecurityException -> 0x017c, all -> 0x0170 }
        int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ SecurityException -> 0x017c, all -> 0x0170 }
        r3.append(r4)     // Catch:{ SecurityException -> 0x017c, all -> 0x0170 }
        java.lang.String r4 = "\n"
        r3.append(r4)     // Catch:{ SecurityException -> 0x017c, all -> 0x0170 }
        java.lang.String r3 = r3.toString()     // Catch:{ SecurityException -> 0x017c, all -> 0x0170 }
        com.tencent.p605ep.commonbase.api.Log.m31483i(r0, r3)     // Catch:{ SecurityException -> 0x017c, all -> 0x0170 }
        android.content.Context r3 = com.tencent.p605ep.commonbase.api.AppContext.getAppContext()     // Catch:{ SecurityException -> 0x017c, all -> 0x0170 }
        java.lang.String r4 = "phone"
        java.lang.Object r3 = r3.getSystemService(r4)     // Catch:{ SecurityException -> 0x017c, all -> 0x0170 }
        android.telephony.TelephonyManager r3 = (android.telephony.TelephonyManager) r3     // Catch:{ SecurityException -> 0x017c, all -> 0x0170 }
        int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ SecurityException -> 0x017c, all -> 0x0170 }
        r5 = 21
        if (r4 >= r5) goto L_0x0039
        r4 = r2
        r8 = r4
        goto L_0x0182
    L_0x0039:
        int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ SecurityException -> 0x017c, all -> 0x0170 }
        r5 = 26
        r6 = 0
        r7 = 1
        if (r4 >= r5) goto L_0x00b3
        java.lang.String r4 = r3.getDeviceId(r6)     // Catch:{ SecurityException -> 0x017c, all -> 0x0170 }
        boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ SecurityException -> 0x017c, all -> 0x0170 }
        r6 = 14
        if (r5 != 0) goto L_0x0059
        int r5 = r4.length()     // Catch:{ SecurityException -> 0x017c, all -> 0x0170 }
        if (r5 != r6) goto L_0x0056
        r5 = r2
        r8 = r4
        goto L_0x005b
    L_0x0056:
        r8 = r2
        r5 = r4
        goto L_0x005b
    L_0x0059:
        r5 = r2
        r8 = r5
    L_0x005b:
        java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ SecurityException -> 0x00ae, all -> 0x00a9 }
        r9.<init>()     // Catch:{ SecurityException -> 0x00ae, all -> 0x00a9 }
        java.lang.String r10 = "\ngetDeviceId(0): "
        r9.append(r10)     // Catch:{ SecurityException -> 0x00ae, all -> 0x00a9 }
        r9.append(r4)     // Catch:{ SecurityException -> 0x00ae, all -> 0x00a9 }
        java.lang.String r4 = r9.toString()     // Catch:{ SecurityException -> 0x00ae, all -> 0x00a9 }
        com.tencent.p605ep.commonbase.api.Log.m31483i(r0, r4)     // Catch:{ SecurityException -> 0x00ae, all -> 0x00a9 }
        java.lang.String r3 = r3.getDeviceId(r7)     // Catch:{ SecurityException -> 0x00ae, all -> 0x00a9 }
        boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ SecurityException -> 0x00ae, all -> 0x00a9 }
        if (r4 != 0) goto L_0x0084
        int r4 = r3.length()     // Catch:{ SecurityException -> 0x00ae, all -> 0x00a9 }
        if (r4 != r6) goto L_0x0082
        r4 = r2
        r8 = r3
        goto L_0x0085
    L_0x0082:
        r4 = r3
        goto L_0x0085
    L_0x0084:
        r4 = r2
    L_0x0085:
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ SecurityException -> 0x00a7, all -> 0x00a5 }
        r6.<init>()     // Catch:{ SecurityException -> 0x00a7, all -> 0x00a5 }
        java.lang.String r7 = "\ngetDeviceId(1): "
        r6.append(r7)     // Catch:{ SecurityException -> 0x00a7, all -> 0x00a5 }
        r6.append(r3)     // Catch:{ SecurityException -> 0x00a7, all -> 0x00a5 }
        java.lang.String r3 = r6.toString()     // Catch:{ SecurityException -> 0x00a7, all -> 0x00a5 }
        com.tencent.p605ep.commonbase.api.Log.m31483i(r0, r3)     // Catch:{ SecurityException -> 0x00a7, all -> 0x00a5 }
        boolean r3 = android.text.TextUtils.equals(r5, r4)     // Catch:{ SecurityException -> 0x00a7, all -> 0x00a5 }
        if (r3 == 0) goto L_0x00a2
        r4 = r8
        goto L_0x0146
    L_0x00a2:
        r2 = r5
        goto L_0x0182
    L_0x00a5:
        r3 = move-exception
        goto L_0x00ab
    L_0x00a7:
        r3 = move-exception
        goto L_0x00b0
    L_0x00a9:
        r3 = move-exception
        r4 = r2
    L_0x00ab:
        r2 = r5
        goto L_0x0173
    L_0x00ae:
        r3 = move-exception
        r4 = r2
    L_0x00b0:
        r2 = r5
        goto L_0x017f
    L_0x00b3:
        java.lang.Class r4 = r3.getClass()     // Catch:{ SecurityException -> 0x017c, all -> 0x0170 }
        java.lang.String r5 = "getMeid"
        java.lang.Class[] r8 = new java.lang.Class[r7]     // Catch:{ SecurityException -> 0x017c, all -> 0x0170 }
        java.lang.Class r9 = java.lang.Integer.TYPE     // Catch:{ SecurityException -> 0x017c, all -> 0x0170 }
        r8[r6] = r9     // Catch:{ SecurityException -> 0x017c, all -> 0x0170 }
        java.lang.reflect.Method r4 = r4.getMethod(r5, r8)     // Catch:{ SecurityException -> 0x017c, all -> 0x0170 }
        r4.setAccessible(r7)     // Catch:{ SecurityException -> 0x017c, all -> 0x0170 }
        java.lang.Object[] r5 = new java.lang.Object[r7]     // Catch:{ SecurityException -> 0x017c, all -> 0x0170 }
        java.lang.Integer r8 = java.lang.Integer.valueOf(r6)     // Catch:{ SecurityException -> 0x017c, all -> 0x0170 }
        r5[r6] = r8     // Catch:{ SecurityException -> 0x017c, all -> 0x0170 }
        java.lang.Object r4 = r4.invoke(r3, r5)     // Catch:{ SecurityException -> 0x017c, all -> 0x0170 }
        java.lang.String r4 = (java.lang.String) r4     // Catch:{ SecurityException -> 0x017c, all -> 0x0170 }
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ SecurityException -> 0x016c, all -> 0x0168 }
        r5.<init>()     // Catch:{ SecurityException -> 0x016c, all -> 0x0168 }
        java.lang.String r8 = "\napi 26+, meid: "
        r5.append(r8)     // Catch:{ SecurityException -> 0x016c, all -> 0x0168 }
        r5.append(r4)     // Catch:{ SecurityException -> 0x016c, all -> 0x0168 }
        java.lang.String r5 = r5.toString()     // Catch:{ SecurityException -> 0x016c, all -> 0x0168 }
        com.tencent.p605ep.commonbase.api.Log.m31483i(r0, r5)     // Catch:{ SecurityException -> 0x016c, all -> 0x0168 }
        java.lang.Class r5 = r3.getClass()     // Catch:{ SecurityException -> 0x016c, all -> 0x0168 }
        java.lang.String r8 = "getImei"
        java.lang.Class[] r9 = new java.lang.Class[r7]     // Catch:{ SecurityException -> 0x016c, all -> 0x0168 }
        java.lang.Class r10 = java.lang.Integer.TYPE     // Catch:{ SecurityException -> 0x016c, all -> 0x0168 }
        r9[r6] = r10     // Catch:{ SecurityException -> 0x016c, all -> 0x0168 }
        java.lang.reflect.Method r5 = r5.getMethod(r8, r9)     // Catch:{ SecurityException -> 0x016c, all -> 0x0168 }
        r5.setAccessible(r7)     // Catch:{ SecurityException -> 0x016c, all -> 0x0168 }
        java.lang.Object[] r8 = new java.lang.Object[r7]     // Catch:{ SecurityException -> 0x016c, all -> 0x0168 }
        java.lang.Integer r9 = java.lang.Integer.valueOf(r6)     // Catch:{ SecurityException -> 0x016c, all -> 0x0168 }
        r8[r6] = r9     // Catch:{ SecurityException -> 0x016c, all -> 0x0168 }
        java.lang.Object r8 = r5.invoke(r3, r8)     // Catch:{ SecurityException -> 0x016c, all -> 0x0168 }
        java.lang.String r8 = (java.lang.String) r8     // Catch:{ SecurityException -> 0x016c, all -> 0x0168 }
        java.lang.Object[] r9 = new java.lang.Object[r7]     // Catch:{ SecurityException -> 0x0162, all -> 0x015c }
        java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ SecurityException -> 0x0162, all -> 0x015c }
        r9[r6] = r7     // Catch:{ SecurityException -> 0x0162, all -> 0x015c }
        java.lang.Object r3 = r5.invoke(r3, r9)     // Catch:{ SecurityException -> 0x0162, all -> 0x015c }
        java.lang.String r3 = (java.lang.String) r3     // Catch:{ SecurityException -> 0x0162, all -> 0x015c }
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ SecurityException -> 0x0155, all -> 0x014e }
        r5.<init>()     // Catch:{ SecurityException -> 0x0155, all -> 0x014e }
        java.lang.String r6 = "\napi 26+, imei1: "
        r5.append(r6)     // Catch:{ SecurityException -> 0x0155, all -> 0x014e }
        r5.append(r8)     // Catch:{ SecurityException -> 0x0155, all -> 0x014e }
        java.lang.String r5 = r5.toString()     // Catch:{ SecurityException -> 0x0155, all -> 0x014e }
        com.tencent.p605ep.commonbase.api.Log.m31483i(r0, r5)     // Catch:{ SecurityException -> 0x0155, all -> 0x014e }
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ SecurityException -> 0x0155, all -> 0x014e }
        r5.<init>()     // Catch:{ SecurityException -> 0x0155, all -> 0x014e }
        java.lang.String r6 = "\napi 26+, imei2: "
        r5.append(r6)     // Catch:{ SecurityException -> 0x0155, all -> 0x014e }
        r5.append(r3)     // Catch:{ SecurityException -> 0x0155, all -> 0x014e }
        java.lang.String r5 = r5.toString()     // Catch:{ SecurityException -> 0x0155, all -> 0x014e }
        com.tencent.p605ep.commonbase.api.Log.m31483i(r0, r5)     // Catch:{ SecurityException -> 0x0155, all -> 0x014e }
        boolean r5 = android.text.TextUtils.equals(r8, r3)     // Catch:{ SecurityException -> 0x0155, all -> 0x014e }
        if (r5 == 0) goto L_0x014a
        r5 = r8
    L_0x0146:
        r8 = r4
        r4 = r2
        goto L_0x00a2
    L_0x014a:
        r2 = r8
        r8 = r4
        r4 = r3
        goto L_0x0182
    L_0x014e:
        r2 = move-exception
        r11 = r3
        r3 = r2
        r2 = r8
        r8 = r4
        r4 = r11
        goto L_0x0173
    L_0x0155:
        r2 = move-exception
        r11 = r3
        r3 = r2
        r2 = r8
        r8 = r4
        r4 = r11
        goto L_0x017f
    L_0x015c:
        r3 = move-exception
        r11 = r4
        r4 = r2
        r2 = r8
        r8 = r11
        goto L_0x0173
    L_0x0162:
        r3 = move-exception
        r11 = r4
        r4 = r2
        r2 = r8
        r8 = r11
        goto L_0x017f
    L_0x0168:
        r3 = move-exception
        r8 = r4
        r4 = r2
        goto L_0x0173
    L_0x016c:
        r3 = move-exception
        r8 = r4
        r4 = r2
        goto L_0x017f
    L_0x0170:
        r3 = move-exception
        r4 = r2
        r8 = r4
    L_0x0173:
        r3.printStackTrace()
        java.lang.String r5 = "getImeiAndMeid"
        com.tencent.p605ep.commonbase.api.Log.m31488w(r0, r5, r3)
        goto L_0x0182
    L_0x017c:
        r3 = move-exception
        r4 = r2
        r8 = r4
    L_0x017f:
        r3.printStackTrace()
    L_0x0182:
        boolean r3 = android.text.TextUtils.isEmpty(r8)
        if (r3 != 0) goto L_0x018d
        java.lang.String r3 = "meid"
        r1.put(r3, r8)
    L_0x018d:
        boolean r3 = android.text.TextUtils.isEmpty(r2)
        if (r3 != 0) goto L_0x0198
        java.lang.String r3 = "imei1"
        r1.put(r3, r2)
    L_0x0198:
        boolean r3 = android.text.TextUtils.isEmpty(r4)
        if (r3 != 0) goto L_0x01a3
        java.lang.String r3 = "imei2"
        r1.put(r3, r4)
    L_0x01a3:
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>()
        java.lang.String r5 = "meid: "
        r3.append(r5)
        r3.append(r8)
        java.lang.String r3 = r3.toString()
        com.tencent.p605ep.commonbase.api.Log.m31483i(r0, r3)
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>()
        java.lang.String r5 = "imei1: "
        r3.append(r5)
        r3.append(r2)
        java.lang.String r2 = r3.toString()
        com.tencent.p605ep.commonbase.api.Log.m31483i(r0, r2)
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        java.lang.String r3 = "imei2: "
        r2.append(r3)
        r2.append(r4)
        java.lang.String r2 = r2.toString()
        com.tencent.p605ep.commonbase.api.Log.m31483i(r0, r2)
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.utils.PhoneInfoUtil.getImeiAndMeid():java.util.Map");
    }

    public static String getKernelVersion(boolean z) {
        String str = TAG;
        String str2 = "";
        try {
            FileInputStream fileInputStream = new FileInputStream("/proc/version");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream), 8192);
            StringBuilder sb = new StringBuilder(str2);
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                    } else {
                        try {
                            break;
                        } catch (Throwable th) {
                            Log.e(str, str2, th);
                        }
                    }
                } catch (Throwable th2) {
                    Log.e(str, str2, th2);
                }
            }
            bufferedReader.close();
            try {
                fileInputStream.close();
            } catch (Throwable th3) {
                Log.e(str, str2, th3);
            }
            String sb2 = sb.toString();
            if (!z) {
                str2 = sb2;
            } else if (sb2 != null && !sb2.equals(str2)) {
                try {
                    String substring = sb2.substring(sb2.indexOf("version ") + 8);
                    str2 = substring.substring(0, substring.indexOf(" "));
                } catch (Throwable th4) {
                    Log.e(str, str2, th4);
                }
            }
            return str2;
        } catch (Throwable th5) {
            Log.w(str, "getKernelVersion(), exception:", th5);
            return str2;
        }
    }

    public static int getLac() {
        int i = -1;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) AppContext.getAppContext().getApplicationContext().getSystemService("phone");
            if (telephonyManager == null) {
                return -1;
            }
            CellLocation cellLocation = telephonyManager.getCellLocation();
            if (cellLocation == null) {
                return -1;
            }
            if (cellLocation instanceof GsmCellLocation) {
                i = ((GsmCellLocation) cellLocation).getLac();
            }
            return cellLocation instanceof CdmaCellLocation ? ((CdmaCellLocation) cellLocation).getNetworkId() : i;
        } catch (SecurityException e) {
            e.printStackTrace();
            return -1;
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static String getLine1Number() {
        try {
            return ((TelephonyManager) AppContext.getAppContext().getSystemService("phone")).getLine1Number();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    public static String getLine1Number(TelephonyManager telephonyManager) {
        try {
            return telephonyManager.getLine1Number();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    public static String getMSISDN() {
        return getLine1Number();
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ba A[Catch:{ Exception -> 0x00d0 }] */
    public static java.lang.String getManufacturerRomVersion() {
        /*
        r0 = 0
        java.lang.String r1 = android.os.Build.MANUFACTURER     // Catch:{ Exception -> 0x00d0 }
        boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x00d0 }
        if (r2 == 0) goto L_0x000a
        return r0
    L_0x000a:
        java.util.Locale r2 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x00d0 }
        java.lang.String r1 = r1.toLowerCase(r2)     // Catch:{ Exception -> 0x00d0 }
        java.lang.String r2 = "huawei"
        boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x00d0 }
        if (r2 == 0) goto L_0x001f
        java.lang.String r1 = "ro.build.version.emui"
        java.lang.String r0 = getBuildPropFiel(r1)     // Catch:{ Exception -> 0x00d0 }
        return r0
    L_0x001f:
        java.lang.String r2 = "xiaomi"
        boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x00d0 }
        if (r2 == 0) goto L_0x002e
        java.lang.String r1 = "ro.miui.ui.version.name"
        java.lang.String r0 = getBuildPropFiel(r1)     // Catch:{ Exception -> 0x00d0 }
        return r0
    L_0x002e:
        java.lang.String r2 = "gionee"
        boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x00d0 }
        java.lang.String r3 = "ro.build.display.id"
        if (r2 == 0) goto L_0x0049
        java.lang.String r1 = "ro.gn.extvernumber"
        java.lang.String r1 = getBuildPropFiel(r1)     // Catch:{ Exception -> 0x00d0 }
        boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x00d0 }
        if (r2 == 0) goto L_0x0048
        java.lang.String r1 = getBuildPropFiel(r3)     // Catch:{ Exception -> 0x00d0 }
    L_0x0048:
        return r1
    L_0x0049:
        java.lang.String r2 = "vivo"
        boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x00d0 }
        java.lang.String r4 = "_"
        if (r2 == 0) goto L_0x0085
        java.lang.String r1 = "ro.vivo.os.name"
        java.lang.String r1 = getBuildPropFiel(r1)     // Catch:{ Exception -> 0x00d0 }
        java.lang.String r2 = "ro.vivo.os.version"
        java.lang.String r2 = getBuildPropFiel(r2)     // Catch:{ Exception -> 0x00d0 }
        boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x00d0 }
        if (r3 != 0) goto L_0x007e
        boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x00d0 }
        if (r3 != 0) goto L_0x007e
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d0 }
        r3.<init>()     // Catch:{ Exception -> 0x00d0 }
        r3.append(r1)     // Catch:{ Exception -> 0x00d0 }
        r3.append(r4)     // Catch:{ Exception -> 0x00d0 }
        r3.append(r2)     // Catch:{ Exception -> 0x00d0 }
        java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x00d0 }
        goto L_0x0084
    L_0x007e:
        java.lang.String r1 = "ro.vivo.os.build.display.id"
        java.lang.String r0 = getBuildPropFiel(r1)     // Catch:{ Exception -> 0x00d0 }
    L_0x0084:
        return r0
    L_0x0085:
        java.lang.String r2 = "meizu"
        boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x00d0 }
        if (r2 == 0) goto L_0x0092
        java.lang.String r0 = getBuildPropFiel(r3)     // Catch:{ Exception -> 0x00d0 }
        return r0
    L_0x0092:
        java.lang.String r2 = "lenovo"
        boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x00d0 }
        if (r2 == 0) goto L_0x00c1
        java.lang.String r1 = "ro.lenovo.lvp.version"
        java.lang.String r1 = getBuildPropFiel(r1)     // Catch:{ Exception -> 0x00d0 }
        boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x00d0 }
        if (r2 != 0) goto L_0x00b3
        java.lang.String[] r1 = r1.split(r4)     // Catch:{ Exception -> 0x00d0 }
        if (r1 == 0) goto L_0x00b3
        int r2 = r1.length     // Catch:{ Exception -> 0x00d0 }
        if (r2 <= 0) goto L_0x00b3
        r2 = 0
        r1 = r1[r2]     // Catch:{ Exception -> 0x00d0 }
        goto L_0x00b4
    L_0x00b3:
        r1 = r0
    L_0x00b4:
        boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x00d0 }
        if (r2 == 0) goto L_0x00c0
        java.lang.String r1 = "ro.build.version.incremental"
        java.lang.String r1 = getBuildPropFiel(r1)     // Catch:{ Exception -> 0x00d0 }
    L_0x00c0:
        return r1
    L_0x00c1:
        java.lang.String r2 = "letv"
        boolean r1 = r1.contains(r2)     // Catch:{ Exception -> 0x00d0 }
        if (r1 == 0) goto L_0x00d6
        java.lang.String r1 = "ro.letv.eui"
        java.lang.String r0 = getBuildPropFiel(r1)     // Catch:{ Exception -> 0x00d0 }
        return r0
    L_0x00d0:
        r1 = move-exception
        java.lang.String r2 = "PhoneInfoUtil"
        android.util.Log.w(r2, r1)
    L_0x00d6:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.utils.PhoneInfoUtil.getManufacturerRomVersion():java.lang.String");
    }

    public static String getManufaturer() {
        String str = Build.MANUFACTURER;
        return str == null ? "UNKNOWN" : str;
    }

    public static String getModelName() {
        return Build.MODEL;
    }

    public static List<NeighboringCellInfo> getNeighboringCellInfo(TelephonyManager telephonyManager) {
        try {
            return telephonyManager.getNeighboringCellInfo();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    public static void getPhoneStorageSize(SizeInfo sizeInfo) {
        SdcardUtil.getSizeInfo(Environment.getDataDirectory(), sizeInfo);
    }

    public static String getRadioVersion() {
        try {
            return (String) Class.forName("android.os.Build").getMethod("getRadioVersion", new Class[0]).invoke(null, new Object[0]);
        } catch (Throwable th) {
            Log.w(TAG, th);
            return "";
        }
    }

    public static String getSimSerialNumber(TelephonyManager telephonyManager) {
        try {
            return telephonyManager.getSimSerialNumber();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    public static String getSubscriberId(TelephonyManager telephonyManager) {
        try {
            return telephonyManager.getSubscriberId();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005c, code lost:
            if (r1 != null) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x006d, code lost:
            if (r1 != null) goto L_0x005e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0057 A[Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0062, NumberFormatException -> 0x0058, all -> 0x0051, all -> 0x0075 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0068 A[Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0062, NumberFormatException -> 0x0058, all -> 0x0051, all -> 0x0075 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:24:0x0052=Splitter:B:24:0x0052, B:34:0x0063=Splitter:B:34:0x0063} */
    public static long getTotalMemery() {
        /*
        long r0 = mTotalMemorySize
        r2 = -1
        int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
        if (r4 != 0) goto L_0x0081
        java.io.File r0 = new java.io.File
        java.lang.String r1 = "/proc/meminfo"
        r0.<init>(r1)
        r1 = 0
        boolean r2 = r0.exists()
        if (r2 == 0) goto L_0x0081
        java.io.DataInputStream r2 = new java.io.DataInputStream     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0062, NumberFormatException -> 0x0058, all -> 0x0051 }
        java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0062, NumberFormatException -> 0x0058, all -> 0x0051 }
        r3.<init>(r0)     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0062, NumberFormatException -> 0x0058, all -> 0x0051 }
        r2.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0062, NumberFormatException -> 0x0058, all -> 0x0051 }
        java.lang.String r0 = r2.readLine()     // Catch:{ FileNotFoundException -> 0x004e, IOException -> 0x004b, NumberFormatException -> 0x0048, all -> 0x0045 }
        if (r0 == 0) goto L_0x003d
        java.lang.String r0 = r0.trim()     // Catch:{ FileNotFoundException -> 0x004e, IOException -> 0x004b, NumberFormatException -> 0x0048, all -> 0x0045 }
        java.lang.String r1 = "[\\s]+"
        java.lang.String[] r0 = r0.split(r1)     // Catch:{ FileNotFoundException -> 0x004e, IOException -> 0x004b, NumberFormatException -> 0x0048, all -> 0x0045 }
        r1 = 1
        r0 = r0[r1]     // Catch:{ FileNotFoundException -> 0x004e, IOException -> 0x004b, NumberFormatException -> 0x0048, all -> 0x0045 }
        long r0 = java.lang.Long.parseLong(r0)     // Catch:{ FileNotFoundException -> 0x004e, IOException -> 0x004b, NumberFormatException -> 0x0048, all -> 0x0045 }
        mTotalMemorySize = r0     // Catch:{ FileNotFoundException -> 0x004e, IOException -> 0x004b, NumberFormatException -> 0x0048, all -> 0x0045 }
        r2.close()     // Catch:{ IOException -> 0x0070 }
        goto L_0x0081
    L_0x003d:
        java.io.IOException r0 = new java.io.IOException     // Catch:{ FileNotFoundException -> 0x004e, IOException -> 0x004b, NumberFormatException -> 0x0048, all -> 0x0045 }
        java.lang.String r1 = "/proc/meminfo is empty!"
        r0.<init>(r1)     // Catch:{ FileNotFoundException -> 0x004e, IOException -> 0x004b, NumberFormatException -> 0x0048, all -> 0x0045 }
        throw r0     // Catch:{ FileNotFoundException -> 0x004e, IOException -> 0x004b, NumberFormatException -> 0x0048, all -> 0x0045 }
    L_0x0045:
        r0 = move-exception
        r1 = r2
        goto L_0x0052
    L_0x0048:
        r0 = move-exception
        r1 = r2
        goto L_0x0059
    L_0x004b:
        r0 = move-exception
        r1 = r2
        goto L_0x0063
    L_0x004e:
        r0 = move-exception
        r1 = r2
        goto L_0x006a
    L_0x0051:
        r0 = move-exception
    L_0x0052:
        r0.printStackTrace()     // Catch:{ all -> 0x0075 }
        if (r1 == 0) goto L_0x0081
        goto L_0x006f
    L_0x0058:
        r0 = move-exception
    L_0x0059:
        r0.printStackTrace()     // Catch:{ all -> 0x0075 }
        if (r1 == 0) goto L_0x0081
    L_0x005e:
        r1.close()     // Catch:{ IOException -> 0x0070 }
        goto L_0x0081
    L_0x0062:
        r0 = move-exception
    L_0x0063:
        r0.printStackTrace()     // Catch:{ all -> 0x0075 }
        if (r1 == 0) goto L_0x0081
        goto L_0x006f
    L_0x0069:
        r0 = move-exception
    L_0x006a:
        r0.printStackTrace()     // Catch:{ all -> 0x0075 }
        if (r1 == 0) goto L_0x0081
    L_0x006f:
        goto L_0x005e
    L_0x0070:
        r0 = move-exception
        r0.printStackTrace()
        goto L_0x0081
    L_0x0075:
        r0 = move-exception
        if (r1 == 0) goto L_0x0080
        r1.close()     // Catch:{ IOException -> 0x007c }
        goto L_0x0080
    L_0x007c:
        r1 = move-exception
        r1.printStackTrace()
    L_0x0080:
        throw r0
    L_0x0081:
        long r0 = mTotalMemorySize
        r2 = 0
        int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
        if (r4 <= 0) goto L_0x008a
        goto L_0x008c
    L_0x008a:
        r0 = 1
    L_0x008c:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.utils.PhoneInfoUtil.getTotalMemery():long");
    }

    public static String getVersionIncremental() {
        return VERSION.INCREMENTAL;
    }

    public static String getVersionRelease() {
        return VERSION.RELEASE;
    }

    public static void listen(TelephonyManager telephonyManager, PhoneStateListener phoneStateListener, int i) {
        telephonyManager.listen(phoneStateListener, i);
    }

    public static Camera openCamera(int i) {
        try {
            return (Camera) Class.forName("android.hardware.Camera").getMethod("open", new Class[]{Integer.TYPE}).invoke(null, new Object[]{Integer.valueOf(i)});
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
