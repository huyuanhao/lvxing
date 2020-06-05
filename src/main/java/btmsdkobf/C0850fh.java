package btmsdkobf;

import android.content.Context;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/* renamed from: btmsdkobf.fh */
public class C0850fh {
    /* renamed from: ob */
    public static int f984ob = 4;
    /* renamed from: oc */
    public static String f985oc = null;
    /* renamed from: od */
    public static int f986od = 80;
    /* renamed from: oe */
    public static byte f987oe = 0;
    /* renamed from: of */
    public static boolean f988of = false;
    /* renamed from: og */
    public static boolean f989og = false;
    /* renamed from: oh */
    public static byte f990oh = 4;
    /* renamed from: oi */
    public static String f991oi = "unknown";
    /* renamed from: oj */
    public static byte f992oj = 9;
    /* renamed from: ok */
    public static int f993ok = 17;

    /* renamed from: D */
    private static void m917D(String str) {
        byte b;
        if (str != null) {
            String str2 = "cmwap";
            if (str.contains(str2)) {
                f991oi = str2;
                b = 0;
            } else {
                String str3 = "cmnet";
                if (str.contains(str3)) {
                    f991oi = str3;
                    b = 1;
                } else {
                    String str4 = "3gwap";
                    if (str.contains(str4)) {
                        f991oi = str4;
                        b = 2;
                    } else {
                        String str5 = "3gnet";
                        if (str.contains(str5)) {
                            f991oi = str5;
                            b = 3;
                        } else {
                            String str6 = "uniwap";
                            if (str.contains(str6)) {
                                f991oi = str6;
                                b = 4;
                            } else {
                                String str7 = "uninet";
                                if (str.contains(str7)) {
                                    f991oi = str7;
                                    b = 5;
                                } else {
                                    String str8 = "ctwap";
                                    if (str.contains(str8)) {
                                        f991oi = str8;
                                        b = 6;
                                    } else {
                                        String str9 = "ctnet";
                                        if (str.contains(str9)) {
                                            f991oi = str9;
                                            b = 7;
                                        } else {
                                            String str10 = "#777";
                                            if (str.contains(str10)) {
                                                f991oi = str10;
                                                b = 8;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            f992oj = b;
        }
    }

    /* renamed from: I */
    private static boolean m918I(int i) {
        return i == 2 || i == 0;
    }

    /* renamed from: a */
    private static int m919a(Context context, NetworkInfo networkInfo) {
        int i = 0;
        if (networkInfo == null) {
            return 0;
        }
        try {
            if (1 != networkInfo.getType()) {
                if (networkInfo.getType() == 0) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        switch (telephonyManager.getNetworkType()) {
                            case 1:
                                i = 2;
                                break;
                            case 2:
                                i = 3;
                                break;
                            case 3:
                                i = 4;
                                break;
                            case 4:
                                i = 8;
                                break;
                            case 5:
                                i = 9;
                                break;
                            case 6:
                                i = 10;
                                break;
                            case 7:
                                i = 11;
                                break;
                            case 8:
                                i = 5;
                                break;
                            case 9:
                                i = 6;
                                break;
                            case 10:
                                i = 7;
                                break;
                            default:
                                i = 17;
                                break;
                        }
                    }
                }
            } else {
                i = 1;
            }
        } catch (Exception unused) {
        }
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x00c1 A[Catch:{ Exception -> 0x00ff }] */
    /* renamed from: t */
    public static void m920t(android.content.Context r8) {
        /*
        r0 = 0
        java.lang.String r1 = "connectivity"
        java.lang.Object r1 = r8.getSystemService(r1)     // Catch:{ NullPointerException -> 0x000e }
        android.net.ConnectivityManager r1 = (android.net.ConnectivityManager) r1     // Catch:{ NullPointerException -> 0x000e }
        android.net.NetworkInfo r1 = r1.getActiveNetworkInfo()     // Catch:{ NullPointerException -> 0x000e }
        goto L_0x000f
    L_0x000e:
        r1 = r0
    L_0x000f:
        r2 = -1
        r3 = 0
        f984ob = r3     // Catch:{ Exception -> 0x00ff }
        r4 = 4
        f990oh = r4     // Catch:{ Exception -> 0x00ff }
        if (r1 == 0) goto L_0x002d
        int r2 = r1.getType()     // Catch:{ Exception -> 0x00ff }
        java.lang.String r0 = r1.getExtraInfo()     // Catch:{ Exception -> 0x00ff }
        if (r0 != 0) goto L_0x0025
        f984ob = r3     // Catch:{ Exception -> 0x00ff }
        goto L_0x002d
    L_0x0025:
        java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x00ff }
        java.lang.String r0 = r0.toLowerCase()     // Catch:{ Exception -> 0x00ff }
    L_0x002d:
        r5 = 1
        if (r2 != r5) goto L_0x0041
        f984ob = r4     // Catch:{ Exception -> 0x00ff }
        f988of = r3     // Catch:{ Exception -> 0x00ff }
        r0 = 3
        f990oh = r0     // Catch:{ Exception -> 0x00ff }
        java.lang.String r0 = "unknown"
        f991oi = r0     // Catch:{ Exception -> 0x00ff }
        r0 = 9
        f992oj = r0     // Catch:{ Exception -> 0x00ff }
        goto L_0x00ff
    L_0x0041:
        m917D(r0)     // Catch:{ Exception -> 0x00ff }
        r2 = 2
        if (r0 != 0) goto L_0x004b
    L_0x0047:
        f984ob = r3     // Catch:{ Exception -> 0x00ff }
        goto L_0x00b7
    L_0x004b:
        java.lang.String r4 = "cmwap"
        boolean r4 = r0.contains(r4)     // Catch:{ Exception -> 0x00ff }
        java.lang.String r6 = "3gwap"
        if (r4 != 0) goto L_0x00ab
        java.lang.String r4 = "uniwap"
        boolean r4 = r0.contains(r4)     // Catch:{ Exception -> 0x00ff }
        if (r4 != 0) goto L_0x00ab
        boolean r4 = r0.contains(r6)     // Catch:{ Exception -> 0x00ff }
        if (r4 != 0) goto L_0x00ab
        java.lang.String r4 = "ctwap"
        boolean r4 = r0.contains(r4)     // Catch:{ Exception -> 0x00ff }
        if (r4 == 0) goto L_0x006c
        goto L_0x00ab
    L_0x006c:
        java.lang.String r4 = "cmnet"
        boolean r4 = r0.contains(r4)     // Catch:{ Exception -> 0x00ff }
        java.lang.String r6 = "ctnet"
        java.lang.String r7 = "3gnet"
        if (r4 != 0) goto L_0x0098
        java.lang.String r4 = "uninet"
        boolean r4 = r0.contains(r4)     // Catch:{ Exception -> 0x00ff }
        if (r4 != 0) goto L_0x0098
        boolean r4 = r0.contains(r7)     // Catch:{ Exception -> 0x00ff }
        if (r4 != 0) goto L_0x0098
        boolean r4 = r0.contains(r6)     // Catch:{ Exception -> 0x00ff }
        if (r4 == 0) goto L_0x008d
        goto L_0x0098
    L_0x008d:
        java.lang.String r4 = "#777"
        boolean r0 = r0.contains(r4)     // Catch:{ Exception -> 0x00ff }
        if (r0 == 0) goto L_0x0047
        f990oh = r2     // Catch:{ Exception -> 0x00ff }
        goto L_0x0047
    L_0x0098:
        f990oh = r5     // Catch:{ Exception -> 0x00ff }
        boolean r4 = r0.contains(r7)     // Catch:{ Exception -> 0x00ff }
        if (r4 != 0) goto L_0x00a6
        boolean r0 = r0.contains(r6)     // Catch:{ Exception -> 0x00ff }
        if (r0 == 0) goto L_0x00a8
    L_0x00a6:
        f990oh = r2     // Catch:{ Exception -> 0x00ff }
    L_0x00a8:
        f984ob = r5     // Catch:{ Exception -> 0x00ff }
        goto L_0x00b7
    L_0x00ab:
        f990oh = r5     // Catch:{ Exception -> 0x00ff }
        boolean r0 = r0.contains(r6)     // Catch:{ Exception -> 0x00ff }
        if (r0 == 0) goto L_0x00b5
        f990oh = r2     // Catch:{ Exception -> 0x00ff }
    L_0x00b5:
        f984ob = r2     // Catch:{ Exception -> 0x00ff }
    L_0x00b7:
        f988of = r3     // Catch:{ Exception -> 0x00ff }
        int r0 = f984ob     // Catch:{ Exception -> 0x00ff }
        boolean r0 = m918I(r0)     // Catch:{ Exception -> 0x00ff }
        if (r0 == 0) goto L_0x00ff
        java.lang.String r0 = android.net.Proxy.getDefaultHost()     // Catch:{ Exception -> 0x00ff }
        f985oc = r0     // Catch:{ Exception -> 0x00ff }
        int r0 = android.net.Proxy.getDefaultPort()     // Catch:{ Exception -> 0x00ff }
        f986od = r0     // Catch:{ Exception -> 0x00ff }
        java.lang.String r0 = f985oc     // Catch:{ Exception -> 0x00ff }
        if (r0 == 0) goto L_0x00d9
        java.lang.String r0 = f985oc     // Catch:{ Exception -> 0x00ff }
        java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x00ff }
        f985oc = r0     // Catch:{ Exception -> 0x00ff }
    L_0x00d9:
        java.lang.String r0 = f985oc     // Catch:{ Exception -> 0x00ff }
        if (r0 == 0) goto L_0x00fb
        java.lang.String r0 = ""
        java.lang.String r4 = f985oc     // Catch:{ Exception -> 0x00ff }
        boolean r0 = r0.equals(r4)     // Catch:{ Exception -> 0x00ff }
        if (r0 != 0) goto L_0x00fb
        f988of = r5     // Catch:{ Exception -> 0x00ff }
        f984ob = r2     // Catch:{ Exception -> 0x00ff }
        java.lang.String r0 = "10.0.0.200"
        java.lang.String r2 = f985oc     // Catch:{ Exception -> 0x00ff }
        boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x00ff }
        if (r0 == 0) goto L_0x00f8
        f987oe = r5     // Catch:{ Exception -> 0x00ff }
        goto L_0x00ff
    L_0x00f8:
        f987oe = r3     // Catch:{ Exception -> 0x00ff }
        goto L_0x00ff
    L_0x00fb:
        f988of = r3     // Catch:{ Exception -> 0x00ff }
        f984ob = r5     // Catch:{ Exception -> 0x00ff }
    L_0x00ff:
        int r8 = m919a(r8, r1)
        f993ok = r8
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0850fh.m920t(android.content.Context):void");
    }

    /* renamed from: v */
    public static void m921v(Context context) {
        if (!f989og) {
            synchronized (C0850fh.class) {
                if (!f989og) {
                    m920t(context);
                    f989og = true;
                }
            }
        }
    }
}
