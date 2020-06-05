package com.p530ss.android.socialbase.downloader.p569m;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.p003os.EnvironmentCompat;
import com.tencent.p605ep.commonbase.api.ConfigManager.OEM;

/* compiled from: RomUtils */
/* renamed from: com.ss.android.socialbase.downloader.m.i */
public class C6792i {
    /* renamed from: a */
    public static String f22434a;
    /* renamed from: b */
    private static String f22435b;
    /* renamed from: c */
    private static String f22436c;
    /* renamed from: d */
    private static String f22437d;

    /* renamed from: a */
    public static boolean m28929a() {
        return m28930a("EMUI");
    }

    /* renamed from: b */
    public static boolean m28932b() {
        return m28930a("MIUI");
    }

    /* renamed from: c */
    public static boolean m28933c() {
        return m28930a("VIVO");
    }

    /* renamed from: d */
    public static boolean m28934d() {
        return m28930a("OPPO");
    }

    /* renamed from: e */
    public static boolean m28935e() {
        return m28930a("SAMSUNG");
    }

    /* renamed from: f */
    public static String m28936f() {
        if (f22435b == null) {
            m28930a("");
        }
        return f22435b;
    }

    /* renamed from: g */
    public static String m28937g() {
        if (f22436c == null) {
            m28930a("");
        }
        return f22436c;
    }

    /* renamed from: h */
    public static String m28938h() {
        if (f22434a == null) {
            m28930a("");
        }
        return f22434a;
    }

    /* renamed from: a */
    public static boolean m28930a(String str) {
        String str2 = f22435b;
        if (str2 != null) {
            return str2.equals(str);
        }
        String b = m28931b("ro.miui.ui.version.name");
        f22436c = b;
        if (!TextUtils.isEmpty(b)) {
            f22435b = "MIUI";
            f22434a = "com.xiaomi.market";
        } else {
            String b2 = m28931b("ro.build.version.emui");
            f22436c = b2;
            if (!TextUtils.isEmpty(b2)) {
                f22435b = "EMUI";
                f22434a = "com.huawei.appmarket";
            } else {
                String b3 = m28931b("ro.build.version.opporom");
                f22436c = b3;
                if (!TextUtils.isEmpty(b3)) {
                    f22435b = "OPPO";
                    f22434a = "com.oppo.market";
                } else {
                    String b4 = m28931b("ro.vivo.os.version");
                    f22436c = b4;
                    if (!TextUtils.isEmpty(b4)) {
                        f22435b = "VIVO";
                        f22434a = "com.bbk.appstore";
                    } else {
                        String b5 = m28931b("ro.smartisan.version");
                        f22436c = b5;
                        if (!TextUtils.isEmpty(b5)) {
                            f22435b = "SMARTISAN";
                            f22434a = "com.smartisanos.appstore";
                        } else {
                            String b6 = m28931b("ro.gn.sv.version");
                            f22436c = b6;
                            if (!TextUtils.isEmpty(b6)) {
                                f22435b = "QIONEE";
                                f22434a = "com.gionee.aora.market";
                            } else {
                                String b7 = m28931b("ro.lenovo.lvp.version");
                                f22436c = b7;
                                if (!TextUtils.isEmpty(b7)) {
                                    f22435b = "LENOVO";
                                    f22434a = "com.lenovo.leos.appstore";
                                } else {
                                    String str3 = "SAMSUNG";
                                    if (m28939i().toUpperCase().contains(str3)) {
                                        f22435b = str3;
                                        f22434a = "com.sec.android.app.samsungapps";
                                    } else {
                                        String upperCase = m28939i().toUpperCase();
                                        String str4 = OEM.ZTE;
                                        if (upperCase.contains(str4)) {
                                            f22435b = str4;
                                            f22434a = "zte.com.market";
                                        } else {
                                            String str5 = "NUBIA";
                                            if (m28939i().toLowerCase().contains(str5)) {
                                                f22435b = str5;
                                                f22434a = "cn.nubia.neostore";
                                            } else {
                                                f22436c = Build.DISPLAY;
                                                String str6 = "FLYME";
                                                if (f22436c.toUpperCase().contains(str6)) {
                                                    f22435b = str6;
                                                    f22434a = "com.meizu.mstore";
                                                } else {
                                                    f22436c = EnvironmentCompat.MEDIA_UNKNOWN;
                                                    f22435b = Build.MANUFACTURER.toUpperCase();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return f22435b.equals(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003f A[SYNTHETIC, Splitter:B:14:0x003f] */
    /* renamed from: b */
    public static java.lang.String m28931b(java.lang.String r4) {
        /*
        r0 = 0
        java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ all -> 0x003c }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x003c }
        r2.<init>()     // Catch:{ all -> 0x003c }
        java.lang.String r3 = "getprop "
        r2.append(r3)     // Catch:{ all -> 0x003c }
        r2.append(r4)     // Catch:{ all -> 0x003c }
        java.lang.String r4 = r2.toString()     // Catch:{ all -> 0x003c }
        java.lang.Process r4 = r1.exec(r4)     // Catch:{ all -> 0x003c }
        java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x003c }
        java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x003c }
        java.io.InputStream r4 = r4.getInputStream()     // Catch:{ all -> 0x003c }
        r2.<init>(r4)     // Catch:{ all -> 0x003c }
        r4 = 1024(0x400, float:1.435E-42)
        r1.<init>(r2, r4)     // Catch:{ all -> 0x003c }
        java.lang.String r4 = r1.readLine()     // Catch:{ all -> 0x003a }
        r1.close()     // Catch:{ all -> 0x003a }
        r1.close()     // Catch:{ IOException -> 0x0035 }
        goto L_0x0039
    L_0x0035:
        r0 = move-exception
        r0.printStackTrace()
    L_0x0039:
        return r4
        goto L_0x003d
    L_0x003c:
        r1 = r0
    L_0x003d:
        if (r1 == 0) goto L_0x0047
        r1.close()     // Catch:{ IOException -> 0x0043 }
        goto L_0x0047
    L_0x0043:
        r4 = move-exception
        r4.printStackTrace()
    L_0x0047:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.downloader.p569m.C6792i.m28931b(java.lang.String):java.lang.String");
    }

    /* renamed from: i */
    public static final String m28939i() {
        return Build.MANUFACTURER == null ? "" : Build.MANUFACTURER.trim();
    }

    /* renamed from: j */
    public static boolean m28940j() {
        m28942l();
        return "V10".equals(f22437d);
    }

    /* renamed from: k */
    public static boolean m28941k() {
        m28942l();
        return "V11".equals(f22437d);
    }

    /* renamed from: l */
    private static void m28942l() {
        if (f22437d == null) {
            try {
                f22437d = m28931b("ro.miui.ui.version.name");
            } catch (Exception e) {
                e.printStackTrace();
            }
            String str = f22437d;
            if (str == null) {
                str = "";
            }
            f22437d = str;
        }
    }
}
