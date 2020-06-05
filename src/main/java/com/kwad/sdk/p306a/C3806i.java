package com.kwad.sdk.p306a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/* renamed from: com.kwad.sdk.a.i */
public class C3806i {
    /* renamed from: a */
    public static boolean m15776a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
            if (allNetworkInfo != null) {
                for (NetworkInfo isConnected : allNetworkInfo) {
                    if (isConnected.isConnected()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m15777b(Context context) {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getNetworkInfo(1);
        } catch (Exception unused) {
            networkInfo = null;
        }
        if (networkInfo != null) {
            return networkInfo.isConnected();
        }
        return false;
    }

    /* renamed from: c */
    public static int m15778c(Context context) {
        return m15780e(context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x0097 A[Catch:{ Exception -> 0x00d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0098 A[Catch:{ Exception -> 0x00d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x009a A[Catch:{ Exception -> 0x00d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x009c A[Catch:{ Exception -> 0x00d1 }] */
    /* renamed from: d */
    public static int m15779d(android.content.Context r13) {
        /*
        r0 = 0
        if (r13 != 0) goto L_0x0004
        return r0
    L_0x0004:
        java.lang.String r1 = "phone"
        java.lang.Object r1 = r13.getSystemService(r1)     // Catch:{ Exception -> 0x00d1 }
        android.telephony.TelephonyManager r1 = (android.telephony.TelephonyManager) r1     // Catch:{ Exception -> 0x00d1 }
        if (r1 != 0) goto L_0x000f
        return r0
    L_0x000f:
        int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x00d1 }
        r3 = 22
        java.lang.String r4 = "46003"
        java.lang.String r5 = "46002"
        java.lang.String r6 = "46001"
        java.lang.String r7 = "46000"
        r8 = 2
        r9 = 3
        r10 = 1
        if (r2 < r3) goto L_0x009d
        java.lang.String r2 = r1.getSimOperator()     // Catch:{ Exception -> 0x00d1 }
        r3 = -1
        int r11 = r2.hashCode()     // Catch:{ Exception -> 0x00d1 }
        r12 = 49679502(0x2f60c8e, float:3.6153657E-37)
        if (r11 == r12) goto L_0x0088
        switch(r11) {
            case 49679470: goto L_0x0080;
            case 49679471: goto L_0x0078;
            case 49679472: goto L_0x0070;
            case 49679473: goto L_0x0068;
            default: goto L_0x0031;
        }     // Catch:{ Exception -> 0x00d1 }
    L_0x0031:
        switch(r11) {
            case 49679475: goto L_0x005d;
            case 49679476: goto L_0x0053;
            case 49679477: goto L_0x0049;
            case 49679478: goto L_0x003f;
            case 49679479: goto L_0x0035;
            default: goto L_0x0034;
        }     // Catch:{ Exception -> 0x00d1 }
    L_0x0034:
        goto L_0x0093
    L_0x0035:
        java.lang.String r11 = "46009"
        boolean r2 = r2.equals(r11)     // Catch:{ Exception -> 0x00d1 }
        if (r2 == 0) goto L_0x0093
        r2 = 6
        goto L_0x0094
    L_0x003f:
        java.lang.String r11 = "46008"
        boolean r2 = r2.equals(r11)     // Catch:{ Exception -> 0x00d1 }
        if (r2 == 0) goto L_0x0093
        r2 = 3
        goto L_0x0094
    L_0x0049:
        java.lang.String r11 = "46007"
        boolean r2 = r2.equals(r11)     // Catch:{ Exception -> 0x00d1 }
        if (r2 == 0) goto L_0x0093
        r2 = 2
        goto L_0x0094
    L_0x0053:
        java.lang.String r11 = "46006"
        boolean r2 = r2.equals(r11)     // Catch:{ Exception -> 0x00d1 }
        if (r2 == 0) goto L_0x0093
        r2 = 5
        goto L_0x0094
    L_0x005d:
        java.lang.String r11 = "46005"
        boolean r2 = r2.equals(r11)     // Catch:{ Exception -> 0x00d1 }
        if (r2 == 0) goto L_0x0093
        r2 = 8
        goto L_0x0094
    L_0x0068:
        boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x00d1 }
        if (r2 == 0) goto L_0x0093
        r2 = 7
        goto L_0x0094
    L_0x0070:
        boolean r2 = r2.equals(r5)     // Catch:{ Exception -> 0x00d1 }
        if (r2 == 0) goto L_0x0093
        r2 = 1
        goto L_0x0094
    L_0x0078:
        boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x00d1 }
        if (r2 == 0) goto L_0x0093
        r2 = 4
        goto L_0x0094
    L_0x0080:
        boolean r2 = r2.equals(r7)     // Catch:{ Exception -> 0x00d1 }
        if (r2 == 0) goto L_0x0093
        r2 = 0
        goto L_0x0094
    L_0x0088:
        java.lang.String r11 = "46011"
        boolean r2 = r2.equals(r11)     // Catch:{ Exception -> 0x00d1 }
        if (r2 == 0) goto L_0x0093
        r2 = 9
        goto L_0x0094
    L_0x0093:
        r2 = -1
    L_0x0094:
        switch(r2) {
            case 0: goto L_0x009c;
            case 1: goto L_0x009c;
            case 2: goto L_0x009c;
            case 3: goto L_0x009c;
            case 4: goto L_0x009a;
            case 5: goto L_0x009a;
            case 6: goto L_0x009a;
            case 7: goto L_0x0098;
            case 8: goto L_0x0098;
            case 9: goto L_0x0098;
            default: goto L_0x0097;
        }     // Catch:{ Exception -> 0x00d1 }
    L_0x0097:
        goto L_0x009d
    L_0x0098:
        r0 = 2
        goto L_0x009d
    L_0x009a:
        r0 = 3
        goto L_0x009d
    L_0x009c:
        r0 = 1
    L_0x009d:
        if (r0 != 0) goto L_0x00d5
        java.lang.String r2 = "android.permission.READ_PHONE_STATE"
        int r13 = androidx.core.content.ContextCompat.checkSelfPermission(r13, r2)     // Catch:{ Exception -> 0x00d1 }
        if (r13 != 0) goto L_0x00d5
        java.lang.String r13 = r1.getSubscriberId()     // Catch:{ Exception -> 0x00d1 }
        boolean r1 = android.text.TextUtils.isEmpty(r13)     // Catch:{ Exception -> 0x00d1 }
        if (r1 == 0) goto L_0x00b2
        return r0
    L_0x00b2:
        boolean r1 = r13.startsWith(r7)     // Catch:{ Exception -> 0x00d1 }
        if (r1 != 0) goto L_0x00cf
        boolean r1 = r13.startsWith(r5)     // Catch:{ Exception -> 0x00d1 }
        if (r1 == 0) goto L_0x00bf
        goto L_0x00cf
    L_0x00bf:
        boolean r1 = r13.startsWith(r6)     // Catch:{ Exception -> 0x00d1 }
        if (r1 == 0) goto L_0x00c7
        r0 = 3
        goto L_0x00d5
    L_0x00c7:
        boolean r13 = r13.startsWith(r4)     // Catch:{ Exception -> 0x00d1 }
        if (r13 == 0) goto L_0x00d5
        r0 = 2
        goto L_0x00d5
    L_0x00cf:
        r0 = 1
        goto L_0x00d5
    L_0x00d1:
        r13 = move-exception
        com.kwad.sdk.core.p319c.C4065b.m16865a(r13)
    L_0x00d5:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.p306a.C3806i.m15779d(android.content.Context):int");
    }

    /* renamed from: e */
    private static byte m15780e(Context context) {
        if (context == null || !m15776a(context)) {
            return 0;
        }
        if (m15777b(context)) {
            return 100;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
        if (telephonyManager == null) {
            return 0;
        }
        switch (telephonyManager.getNetworkType()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 3;
            case 13:
                return 4;
            default:
                return 0;
        }
    }
}
