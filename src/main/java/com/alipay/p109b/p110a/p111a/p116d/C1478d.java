package com.alipay.p109b.p110a.p111a.p116d;

import android.os.Build;
import android.os.Build.VERSION;
import java.io.File;

/* renamed from: com.alipay.b.a.a.d.d */
public class C1478d {
    /* renamed from: a */
    private static C1478d f3755a = new C1478d();

    private C1478d() {
    }

    /* renamed from: a */
    public static C1478d m4348a() {
        return f3755a;
    }

    /* renamed from: a */
    private static String m4349a(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{str, str2});
        } catch (Exception unused) {
            return str2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0055 A[Catch:{ Exception -> 0x0066 }, RETURN] */
    /* renamed from: a */
    public boolean mo12074a(android.content.Context r8) {
        /*
        r7 = this;
        r0 = 0
        java.lang.String r1 = android.os.Build.HARDWARE     // Catch:{ Exception -> 0x0066 }
        java.lang.String r2 = "goldfish"
        boolean r1 = r1.contains(r2)     // Catch:{ Exception -> 0x0066 }
        r2 = 1
        if (r1 != 0) goto L_0x0065
        java.lang.String r1 = android.os.Build.PRODUCT     // Catch:{ Exception -> 0x0066 }
        java.lang.String r3 = "sdk"
        boolean r1 = r1.contains(r3)     // Catch:{ Exception -> 0x0066 }
        if (r1 != 0) goto L_0x0065
        java.lang.String r1 = android.os.Build.FINGERPRINT     // Catch:{ Exception -> 0x0066 }
        java.lang.String r3 = "generic"
        boolean r1 = r1.contains(r3)     // Catch:{ Exception -> 0x0066 }
        if (r1 == 0) goto L_0x0021
        goto L_0x0065
    L_0x0021:
        java.lang.String r1 = "phone"
        java.lang.Object r1 = r8.getSystemService(r1)     // Catch:{ Exception -> 0x0066 }
        android.telephony.TelephonyManager r1 = (android.telephony.TelephonyManager) r1     // Catch:{ Exception -> 0x0066 }
        if (r1 == 0) goto L_0x0056
        java.lang.String r1 = r1.getDeviceId()     // Catch:{ Exception -> 0x0066 }
        if (r1 == 0) goto L_0x0052
        int r3 = r1.length()     // Catch:{ Exception -> 0x0066 }
        if (r3 != 0) goto L_0x0038
        goto L_0x0052
    L_0x0038:
        r4 = 0
    L_0x0039:
        if (r4 >= r3) goto L_0x0052
        char r5 = r1.charAt(r4)     // Catch:{ Exception -> 0x0066 }
        boolean r5 = java.lang.Character.isWhitespace(r5)     // Catch:{ Exception -> 0x0066 }
        if (r5 != 0) goto L_0x004f
        char r5 = r1.charAt(r4)     // Catch:{ Exception -> 0x0066 }
        r6 = 48
        if (r5 == r6) goto L_0x004f
        r1 = 0
        goto L_0x0053
    L_0x004f:
        int r4 = r4 + 1
        goto L_0x0039
    L_0x0052:
        r1 = 1
    L_0x0053:
        if (r1 == 0) goto L_0x0056
        return r2
    L_0x0056:
        android.content.ContentResolver r8 = r8.getContentResolver()     // Catch:{ Exception -> 0x0066 }
        java.lang.String r1 = "android_id"
        java.lang.String r8 = android.provider.Settings.Secure.getString(r8, r1)     // Catch:{ Exception -> 0x0066 }
        boolean r8 = com.alipay.p109b.p110a.p111a.p112a.C1460a.m4260a(r8)     // Catch:{ Exception -> 0x0066 }
        return r8
    L_0x0065:
        return r2
    L_0x0066:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.p109b.p110a.p111a.p116d.C1478d.mo12074a(android.content.Context):boolean");
    }

    /* renamed from: b */
    public String mo12075b() {
        return "android";
    }

    /* renamed from: c */
    public boolean mo12076c() {
        String[] strArr = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
        int i = 0;
        while (i < 5) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(strArr[i]);
                sb.append("su");
                if (new File(sb.toString()).exists()) {
                    return true;
                }
                i++;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* renamed from: d */
    public String mo12077d() {
        return Build.BOARD;
    }

    /* renamed from: e */
    public String mo12078e() {
        return Build.BRAND;
    }

    /* renamed from: f */
    public String mo12079f() {
        return Build.DEVICE;
    }

    /* renamed from: g */
    public String mo12080g() {
        return Build.DISPLAY;
    }

    /* renamed from: h */
    public String mo12081h() {
        return VERSION.INCREMENTAL;
    }

    /* renamed from: i */
    public String mo12082i() {
        return Build.MANUFACTURER;
    }

    /* renamed from: j */
    public String mo12083j() {
        return Build.MODEL;
    }

    /* renamed from: k */
    public String mo12084k() {
        return Build.PRODUCT;
    }

    /* renamed from: l */
    public String mo12085l() {
        return VERSION.RELEASE;
    }

    /* renamed from: m */
    public String mo12086m() {
        return VERSION.SDK;
    }

    /* renamed from: n */
    public String mo12087n() {
        return Build.TAGS;
    }

    /* renamed from: o */
    public String mo12088o() {
        return m4349a("ro.kernel.qemu", "0");
    }
}
