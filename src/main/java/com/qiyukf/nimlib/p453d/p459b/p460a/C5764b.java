package com.qiyukf.nimlib.p453d.p459b.p460a;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.nimlib.p453d.p454a.p456b.C5753a;
import com.qiyukf.nimlib.p453d.p454a.p458d.C5760b;
import com.tencent.mid.core.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* renamed from: com.qiyukf.nimlib.d.b.a.b */
public final class C5764b {
    /* renamed from: a */
    private static synchronized long m23164a() {
        long j;
        synchronized (C5764b.class) {
            j = 0;
            try {
                String a = m23168a(new File("/proc/meminfo"), "MemTotal");
                if (!TextUtils.isEmpty(a)) {
                    String upperCase = a.toUpperCase(Locale.US);
                    j = upperCase.endsWith("KB") ? m23165a(upperCase, "KB", 1024) : upperCase.endsWith("MB") ? m23165a(upperCase, "MB", 1048576) : upperCase.endsWith("GB") ? m23165a(upperCase, "GB", 1073741824) : -1;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                StringBuilder sb = new StringBuilder("getTotalMemory error=");
                sb.append(th.getMessage());
                C5753a.m23146c(sb.toString());
            }
        }
        return j;
    }

    /* renamed from: a */
    private static long m23165a(String str, String str2, int i) {
        return Long.parseLong(str.split(str2)[0].trim()) * ((long) i);
    }

    /* renamed from: a */
    private static C5763a m23166a(Context context, PackageInfo packageInfo, PackageManager packageManager) {
        String str = null;
        if (context == null || packageInfo == null) {
            return null;
        }
        String str2 = packageInfo.packageName;
        String str3 = packageInfo.versionName;
        if (packageManager != null) {
            str = packageManager.getApplicationLabel(packageInfo.applicationInfo).toString();
        }
        if (TextUtils.isEmpty(str)) {
            try {
                str = context.getResources().getString(packageInfo.applicationInfo.labelRes);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = packageInfo.packageName;
        }
        return new C5763a(str2, str, str3);
    }

    /* renamed from: a */
    static C5766d m23167a(Context context) {
        String str = Build.BRAND;
        String str2 = Build.MODEL;
        String c = m23170c(context);
        m23169b(context);
        long[] jArr = new long[2];
        if ("mounted".equals(Environment.getExternalStorageState())) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            if (VERSION.SDK_INT >= 18) {
                long blockSizeLong = statFs.getBlockSizeLong();
                long blockCountLong = statFs.getBlockCountLong();
                long availableBlocksLong = statFs.getAvailableBlocksLong();
                jArr[0] = blockCountLong * blockSizeLong;
                jArr[1] = blockSizeLong * availableBlocksLong;
            } else {
                long blockSize = (long) statFs.getBlockSize();
                long availableBlocks = (long) statFs.getAvailableBlocks();
                jArr[0] = ((long) statFs.getBlockCount()) * blockSize;
                jArr[1] = blockSize * availableBlocks;
            }
        } else {
            jArr[0] = 0;
            jArr[1] = 0;
        }
        long j = jArr[0];
        long a = m23164a();
        int i = VERSION.SDK_INT;
        String a2 = C5769g.m23185a();
        Locale locale = context.getResources().getConfiguration().locale;
        String language = locale.getLanguage();
        String country = locale.getCountry();
        StringBuilder sb = new StringBuilder();
        sb.append(language);
        sb.append("_");
        sb.append(country);
        C5766d dVar = new C5766d(str, str2, c, j, a, "android", i, a2, sb.toString(), TimeZone.getDefault().getDisplayName(false, 0));
        return dVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003a, code lost:
            r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003b, code lost:
            r4.printStackTrace();
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004b A[SYNTHETIC, Splitter:B:27:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0052 A[SYNTHETIC, Splitter:B:31:0x0052] */
    /* renamed from: a */
    private static java.lang.String m23168a(java.io.File r4, java.lang.String r5) {
        /*
        boolean r0 = r4.exists()
        r1 = 0
        if (r0 == 0) goto L_0x005b
        java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0044, all -> 0x0041 }
        java.io.FileReader r2 = new java.io.FileReader     // Catch:{ Exception -> 0x0044, all -> 0x0041 }
        r2.<init>(r4)     // Catch:{ Exception -> 0x0044, all -> 0x0041 }
        r4 = 1024(0x400, float:1.435E-42)
        r0.<init>(r2, r4)     // Catch:{ Exception -> 0x0044, all -> 0x0041 }
    L_0x0013:
        java.lang.String r4 = r0.readLine()     // Catch:{ Exception -> 0x003f }
        if (r4 == 0) goto L_0x0036
        java.lang.String r2 = "\\s*:\\s*"
        java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)     // Catch:{ Exception -> 0x003f }
        r3 = 2
        java.lang.String[] r4 = r2.split(r4, r3)     // Catch:{ Exception -> 0x003f }
        if (r4 == 0) goto L_0x0013
        int r2 = r4.length     // Catch:{ Exception -> 0x003f }
        r3 = 1
        if (r2 <= r3) goto L_0x0013
        r2 = 0
        r2 = r4[r2]     // Catch:{ Exception -> 0x003f }
        boolean r2 = r2.equals(r5)     // Catch:{ Exception -> 0x003f }
        if (r2 == 0) goto L_0x0013
        r4 = r4[r3]     // Catch:{ Exception -> 0x003f }
        r1 = r4
    L_0x0036:
        r0.close()     // Catch:{ IOException -> 0x003a }
        goto L_0x005b
    L_0x003a:
        r4 = move-exception
        r4.printStackTrace()
        goto L_0x005b
    L_0x003f:
        r4 = move-exception
        goto L_0x0046
    L_0x0041:
        r4 = move-exception
        r0 = r1
        goto L_0x0050
    L_0x0044:
        r4 = move-exception
        r0 = r1
    L_0x0046:
        r4.printStackTrace()     // Catch:{ all -> 0x004f }
        if (r0 == 0) goto L_0x005b
        r0.close()     // Catch:{ IOException -> 0x003a }
        goto L_0x005b
    L_0x004f:
        r4 = move-exception
    L_0x0050:
        if (r0 == 0) goto L_0x005a
        r0.close()     // Catch:{ IOException -> 0x0056 }
        goto L_0x005a
    L_0x0056:
        r5 = move-exception
        r5.printStackTrace()
    L_0x005a:
        throw r4
    L_0x005b:
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.p453d.p459b.p460a.C5764b.m23168a(java.io.File, java.lang.String):java.lang.String");
    }

    /* renamed from: b */
    public static String m23169b(Context context) {
        String str;
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        if (wifiManager == null) {
            return null;
        }
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        if (packageManager == null) {
            str = "getActiveMacAddress pm null, fuck!";
        } else {
            if (packageManager.checkPermission(Constants.PERMISSION_ACCESS_WIFI_STATE, context.getApplicationContext().getPackageName()) != 0) {
                str = "getActiveMacAddress without permission!";
            } else {
                try {
                    WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                    if (connectionInfo != null) {
                        return connectionInfo.getMacAddress();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    StringBuilder sb = new StringBuilder("getActiveMacAddress error, e=");
                    sb.append(th.getMessage());
                    C5753a.m23146c(sb.toString());
                }
                return null;
            }
        }
        C5753a.m23146c(str);
        return null;
    }

    /* renamed from: c */
    public static String m23170c(Context context) {
        String str;
        if (context == null) {
            return null;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            str = "getIMEI tm null, fuck!";
        } else if (!C5760b.m23157a(context, Constants.PERMISSION_READ_PHONE_STATE)) {
            str = "getIMEI without permission!";
        } else {
            try {
                return telephonyManager.getDeviceId();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        C5753a.m23146c(str);
        return null;
    }

    /* renamed from: d */
    static C5763a m23171d(Context context) {
        PackageInfo packageInfo;
        String str;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            str = "getAppInfo pm null, fuck!";
        } else {
            try {
                packageInfo = packageManager.getPackageInfo(context.getPackageName(), 16384);
            } catch (Throwable th) {
                th.printStackTrace();
                packageInfo = null;
            }
            if (packageInfo != null) {
                return m23166a(context, packageInfo, packageManager);
            }
            str = "getAppInfo pi null!";
        }
        C5753a.m23146c(str);
        return null;
    }

    /* renamed from: e */
    static C5768f m23172e(Context context) {
        try {
            if (context.getApplicationContext().getPackageManager() == null) {
                C5753a.m23146c("getOperatorInfo pm null, fuck!");
                return null;
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                C5753a.m23146c("getOperatorInfo TelephonyManager null, fuck!");
                return null;
            } else if (telephonyManager.getSimState() != 5) {
                C5753a.m23146c("getOperatorInfo SIM CARD not ready!");
                return null;
            } else {
                String str = "UNKNOWN";
                switch (telephonyManager.getNetworkType()) {
                    case 1:
                        str = "GPRS";
                        break;
                    case 2:
                        str = "EDGE";
                        break;
                    case 3:
                        str = "UMTS";
                        break;
                    case 4:
                        str = "CDMA";
                        break;
                    case 5:
                        str = "EVDO_0";
                        break;
                    case 6:
                        str = "EVDO_A";
                        break;
                    case 7:
                        str = "1xRTT";
                        break;
                    case 8:
                        str = "HSDPA";
                        break;
                    case 9:
                        str = "HSUPA";
                        break;
                    case 10:
                        str = "HSPA";
                        break;
                    case 11:
                        str = "IDEN";
                        break;
                    case 12:
                        str = "EVDO_B";
                        break;
                    case 13:
                        str = "LTE";
                        break;
                    case 14:
                        str = "EHRPD";
                        break;
                    case 15:
                        str = "HSPAP";
                        break;
                    case 16:
                        str = "GSM";
                        break;
                    case 17:
                        str = "TD_SCDMA";
                        break;
                    case 18:
                        str = "IWLAN";
                        break;
                }
                String str2 = str;
                String networkOperatorName = telephonyManager.getNetworkOperatorName();
                String networkCountryIso = telephonyManager.getNetworkCountryIso();
                String networkOperator = telephonyManager.getNetworkOperator();
                if (networkOperator == null) {
                    C5753a.m23146c("getOperatorInfo get network operator null!");
                    return null;
                }
                C5768f fVar = new C5768f(Integer.parseInt(networkOperator.substring(0, 3)), Integer.parseInt(networkOperator.substring(3)), str2, networkOperatorName, networkCountryIso);
                return fVar;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b0 A[Catch:{ all -> 0x0126 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x011d A[ADDED_TO_REGION, Catch:{ all -> 0x0126 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x011a A[EDGE_INSN: B:74:0x011a->B:65:0x011a ?: BREAK  
EDGE_INSN: B:74:0x011a->B:65:0x011a ?: BREAK  
EDGE_INSN: B:74:0x011a->B:65:0x011a ?: BREAK  
EDGE_INSN: B:74:0x011a->B:65:0x011a ?: BREAK  
EDGE_INSN: B:74:0x011a->B:65:0x011a ?: BREAK  
EDGE_INSN: B:74:0x011a->B:65:0x011a ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x011a A[EDGE_INSN: B:74:0x011a->B:65:0x011a ?: BREAK  
EDGE_INSN: B:74:0x011a->B:65:0x011a ?: BREAK  
EDGE_INSN: B:74:0x011a->B:65:0x011a ?: BREAK  
EDGE_INSN: B:74:0x011a->B:65:0x011a ?: BREAK  
EDGE_INSN: B:74:0x011a->B:65:0x011a ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x011a A[EDGE_INSN: B:74:0x011a->B:65:0x011a ?: BREAK  
EDGE_INSN: B:74:0x011a->B:65:0x011a ?: BREAK  
EDGE_INSN: B:74:0x011a->B:65:0x011a ?: BREAK  
EDGE_INSN: B:74:0x011a->B:65:0x011a ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x011a A[EDGE_INSN: B:74:0x011a->B:65:0x011a ?: BREAK  
EDGE_INSN: B:74:0x011a->B:65:0x011a ?: BREAK  
EDGE_INSN: B:74:0x011a->B:65:0x011a ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x011a A[EDGE_INSN: B:74:0x011a->B:65:0x011a ?: BREAK  
EDGE_INSN: B:74:0x011a->B:65:0x011a ?: BREAK  , SYNTHETIC] */
    /* renamed from: f */
    static com.qiyukf.nimlib.p453d.p459b.p460a.C5765c m23173f(android.content.Context r9) {
        /*
        r0 = 0
        android.content.Context r1 = r9.getApplicationContext()     // Catch:{ all -> 0x0126 }
        android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch:{ all -> 0x0126 }
        if (r1 != 0) goto L_0x0011
        java.lang.String r9 = "getCellInfo pm null, fuck!"
        com.qiyukf.nimlib.p453d.p454a.p456b.C5753a.m23146c(r9)     // Catch:{ all -> 0x0126 }
        return r0
    L_0x0011:
        java.lang.String r2 = "phone"
        java.lang.Object r2 = r9.getSystemService(r2)     // Catch:{ all -> 0x0126 }
        android.telephony.TelephonyManager r2 = (android.telephony.TelephonyManager) r2     // Catch:{ all -> 0x0126 }
        if (r2 != 0) goto L_0x0021
        java.lang.String r9 = "getCellInfo TelephonyManager null, fuck!"
        com.qiyukf.nimlib.p453d.p454a.p456b.C5753a.m23146c(r9)     // Catch:{ all -> 0x0126 }
        return r0
    L_0x0021:
        int r3 = r2.getSimState()     // Catch:{ all -> 0x0126 }
        r4 = 5
        if (r3 == r4) goto L_0x002e
        java.lang.String r9 = "getCellInfo SIM CARD not ready!"
        com.qiyukf.nimlib.p453d.p454a.p456b.C5753a.m23146c(r9)     // Catch:{ all -> 0x0126 }
        return r0
    L_0x002e:
        java.lang.String r3 = r2.getNetworkOperator()     // Catch:{ all -> 0x0126 }
        if (r3 != 0) goto L_0x003a
        java.lang.String r9 = "getCellInfo get network operator null!"
        com.qiyukf.nimlib.p453d.p454a.p456b.C5753a.m23146c(r9)     // Catch:{ all -> 0x0126 }
        return r0
    L_0x003a:
        android.content.Context r9 = r9.getApplicationContext()     // Catch:{ all -> 0x0126 }
        java.lang.String r9 = r9.getPackageName()     // Catch:{ all -> 0x0126 }
        java.lang.String r3 = "android.permission.ACCESS_COARSE_LOCATION"
        int r3 = r1.checkPermission(r3, r9)     // Catch:{ all -> 0x0126 }
        r4 = 0
        r5 = 1
        if (r3 != 0) goto L_0x004e
        r3 = 1
        goto L_0x004f
    L_0x004e:
        r3 = 0
    L_0x004f:
        java.lang.String r6 = "android.permission.ACCESS_FINE_LOCATION"
        int r9 = r1.checkPermission(r6, r9)     // Catch:{ all -> 0x0126 }
        if (r9 != 0) goto L_0x0058
        r4 = 1
    L_0x0058:
        r9 = -1
        if (r3 != 0) goto L_0x0064
        if (r4 == 0) goto L_0x005e
        goto L_0x0064
    L_0x005e:
        java.lang.String r1 = "getCellInfo without permission!"
    L_0x0060:
        com.qiyukf.nimlib.p453d.p454a.p456b.C5753a.m23146c(r1)     // Catch:{ all -> 0x0126 }
        goto L_0x0096
    L_0x0064:
        int r1 = r2.getPhoneType()     // Catch:{ all -> 0x0126 }
        r4 = 2
        if (r1 != r4) goto L_0x007c
        android.telephony.CellLocation r1 = r2.getCellLocation()     // Catch:{ all -> 0x0126 }
        android.telephony.cdma.CdmaCellLocation r1 = (android.telephony.cdma.CdmaCellLocation) r1     // Catch:{ all -> 0x0126 }
        if (r1 == 0) goto L_0x0096
        int r4 = r1.getBaseStationId()     // Catch:{ all -> 0x0126 }
        int r1 = r1.getNetworkId()     // Catch:{ all -> 0x0126 }
        goto L_0x0098
    L_0x007c:
        int r1 = r2.getPhoneType()     // Catch:{ all -> 0x0126 }
        if (r1 != r5) goto L_0x0093
        android.telephony.CellLocation r1 = r2.getCellLocation()     // Catch:{ all -> 0x0126 }
        android.telephony.gsm.GsmCellLocation r1 = (android.telephony.gsm.GsmCellLocation) r1     // Catch:{ all -> 0x0126 }
        if (r1 == 0) goto L_0x0096
        int r4 = r1.getCid()     // Catch:{ all -> 0x0126 }
        int r1 = r1.getLac()     // Catch:{ all -> 0x0126 }
        goto L_0x0098
    L_0x0093:
        java.lang.String r1 = "getCellInfo phone type NONE!"
        goto L_0x0060
    L_0x0096:
        r1 = -1
        r4 = -1
    L_0x0098:
        if (r3 == 0) goto L_0x011a
        int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0126 }
        r5 = 17
        if (r3 < r5) goto L_0x011a
        java.util.List r2 = r2.getAllCellInfo()     // Catch:{ all -> 0x0126 }
        java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0126 }
        r3 = -1
        r5 = -1
    L_0x00aa:
        boolean r6 = r2.hasNext()     // Catch:{ all -> 0x0126 }
        if (r6 == 0) goto L_0x011a
        java.lang.Object r6 = r2.next()     // Catch:{ all -> 0x0126 }
        android.telephony.CellInfo r6 = (android.telephony.CellInfo) r6     // Catch:{ all -> 0x0126 }
        boolean r7 = r6 instanceof android.telephony.CellInfoCdma     // Catch:{ all -> 0x0126 }
        if (r7 == 0) goto L_0x00cd
        android.telephony.CellInfoCdma r6 = (android.telephony.CellInfoCdma) r6     // Catch:{ all -> 0x0126 }
        android.telephony.CellIdentityCdma r3 = r6.getCellIdentity()     // Catch:{ all -> 0x0126 }
        int r3 = r3.getBasestationId()     // Catch:{ all -> 0x0126 }
        android.telephony.CellSignalStrengthCdma r5 = r6.getCellSignalStrength()     // Catch:{ all -> 0x0126 }
        int r5 = r5.getCdmaDbm()     // Catch:{ all -> 0x0126 }
        goto L_0x0117
    L_0x00cd:
        boolean r7 = r6 instanceof android.telephony.CellInfoWcdma     // Catch:{ all -> 0x0126 }
        if (r7 == 0) goto L_0x00ea
        android.telephony.CellInfoWcdma r6 = (android.telephony.CellInfoWcdma) r6     // Catch:{ all -> 0x0126 }
        int r7 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0126 }
        r8 = 18
        if (r7 < r8) goto L_0x0117
        android.telephony.CellIdentityWcdma r3 = r6.getCellIdentity()     // Catch:{ all -> 0x0126 }
        int r3 = r3.getCid()     // Catch:{ all -> 0x0126 }
        android.telephony.CellSignalStrengthWcdma r5 = r6.getCellSignalStrength()     // Catch:{ all -> 0x0126 }
        int r5 = r5.getDbm()     // Catch:{ all -> 0x0126 }
        goto L_0x0117
    L_0x00ea:
        boolean r7 = r6 instanceof android.telephony.CellInfoGsm     // Catch:{ all -> 0x0126 }
        if (r7 == 0) goto L_0x0101
        android.telephony.CellInfoGsm r6 = (android.telephony.CellInfoGsm) r6     // Catch:{ all -> 0x0126 }
        android.telephony.CellIdentityGsm r3 = r6.getCellIdentity()     // Catch:{ all -> 0x0126 }
        int r3 = r3.getCid()     // Catch:{ all -> 0x0126 }
        android.telephony.CellSignalStrengthGsm r5 = r6.getCellSignalStrength()     // Catch:{ all -> 0x0126 }
        int r5 = r5.getDbm()     // Catch:{ all -> 0x0126 }
        goto L_0x0117
    L_0x0101:
        boolean r7 = r6 instanceof android.telephony.CellInfoLte     // Catch:{ all -> 0x0126 }
        if (r7 == 0) goto L_0x0117
        android.telephony.CellInfoLte r6 = (android.telephony.CellInfoLte) r6     // Catch:{ all -> 0x0126 }
        android.telephony.CellIdentityLte r3 = r6.getCellIdentity()     // Catch:{ all -> 0x0126 }
        int r3 = r3.getCi()     // Catch:{ all -> 0x0126 }
        android.telephony.CellSignalStrengthLte r5 = r6.getCellSignalStrength()     // Catch:{ all -> 0x0126 }
        int r5 = r5.getDbm()     // Catch:{ all -> 0x0126 }
    L_0x0117:
        if (r4 != r3) goto L_0x00aa
        goto L_0x011b
    L_0x011a:
        r5 = -1
    L_0x011b:
        if (r4 == r9) goto L_0x0125
        if (r1 == r9) goto L_0x0125
        com.qiyukf.nimlib.d.b.a.c r9 = new com.qiyukf.nimlib.d.b.a.c     // Catch:{ all -> 0x0126 }
        r9.m49945init(r4, r1, r5)     // Catch:{ all -> 0x0126 }
        return r9
    L_0x0125:
        return r0
    L_0x0126:
        r9 = move-exception
        r9.printStackTrace()
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.p453d.p459b.p460a.C5764b.m23173f(android.content.Context):com.qiyukf.nimlib.d.b.a.c");
    }

    /* renamed from: g */
    static List<C5763a> m23174g(Context context) {
        if (((ActivityManager) context.getSystemService(com.tencent.android.tpush.common.Constants.FLAG_ACTIVITY_NAME)) == null) {
            return null;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        try {
            List<PackageInfo> installedPackages = packageManager.getInstalledPackages(0);
            if (installedPackages != null) {
                if (!installedPackages.isEmpty()) {
                    ArrayList arrayList = new ArrayList(installedPackages.size());
                    for (PackageInfo packageInfo : installedPackages) {
                        if (!TextUtils.isEmpty(packageInfo.packageName) && !packageInfo.packageName.startsWith("com.android") && !packageInfo.packageName.startsWith("com.oppo")) {
                            String str = packageInfo.packageName;
                            StringBuilder sb = new StringBuilder("com.");
                            sb.append(Build.BRAND.toLowerCase());
                            if (!str.startsWith(sb.toString())) {
                                arrayList.add(m23166a(context, packageInfo, packageManager));
                            }
                        }
                    }
                    return arrayList;
                }
            }
            return null;
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder("get installed app info list error, e=");
            sb2.append(th.getMessage());
            C5753a.m23146c(sb2.toString());
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: h */
    public static String m23175h(Context context) {
        try {
            return Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable th) {
            th.printStackTrace();
            StringBuilder sb = new StringBuilder("get android id error, e=");
            sb.append(th.getMessage());
            C5753a.m23146c(sb.toString());
            return null;
        }
    }

    /* renamed from: i */
    public static int m23176i(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 1).versionCode;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append(Thread.currentThread().getId());
            sb.append(e.getMessage());
            C5264a.m21622c("get package name fail,threadId = {}, e={}", sb.toString());
            return -1;
        }
    }
}
