package com.tencent.bugly.crashreport.common.info;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import androidx.core.p003os.EnvironmentCompat;
import com.tencent.bugly.proguard.C7226an;
import com.tencent.bugly.proguard.C7232aq;
import com.tencent.mid.sotrage.StorageInterface;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Locale;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.common.info.b */
public class C7175b {
    /* renamed from: a */
    private static final String[] f24046a = {"/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb"};
    /* renamed from: b */
    private static final String[] f24047b = {"com.ami.duosupdater.ui", "com.ami.launchmetro", "com.ami.syncduosservices", "com.bluestacks.home", "com.bluestacks.windowsfilemanager", "com.bluestacks.settings", "com.bluestacks.bluestackslocationprovider", "com.bluestacks.appsettings", "com.bluestacks.bstfolder", "com.bluestacks.BstCommandProcessor", "com.bluestacks.s2p", "com.bluestacks.setup", "com.kaopu001.tiantianserver", "com.kpzs.helpercenter", "com.kaopu001.tiantianime", "com.android.development_settings", "com.android.development", "com.android.customlocale2", "com.genymotion.superuser", "com.genymotion.clipboardproxy", "com.uc.xxzs.keyboard", "com.uc.xxzs", "com.blue.huang17.agent", "com.blue.huang17.launcher", "com.blue.huang17.ime", "com.microvirt.guide", "com.microvirt.market", "com.microvirt.memuime", "cn.itools.vm.launcher", "cn.itools.vm.proxy", "cn.itools.vm.softkeyboard", "cn.itools.avdmarket", "com.syd.IME", "com.bignox.app.store.hd", "com.bignox.launcher", "com.bignox.app.phone", "com.bignox.app.noxservice", "com.android.noxpush", "com.haimawan.push", "me.haima.helpcenter", "com.windroy.launcher", "com.windroy.superuser", "com.windroy.launcher", "com.windroy.ime", "com.android.flysilkworm", "com.android.emu.inputservice", "com.tiantian.ime", "com.microvirt.launcher", "me.le8.androidassist", "com.vphone.helper", "com.vphone.launcher", "com.duoyi.giftcenter.giftcenter"};
    /* renamed from: c */
    private static final String[] f24048c = {"/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/qemud", "/dev/qemu_pipe", "/dev/socket/baseband_genyd", "/dev/socket/genyd"};
    /* renamed from: d */
    private static String f24049d = null;
    /* renamed from: e */
    private static String f24050e = null;

    /* renamed from: a */
    public static String m30817a(Context context) {
        return "null";
    }

    /* renamed from: b */
    public static String m30820b(Context context) {
        return "null";
    }

    /* renamed from: d */
    public static String m30824d(Context context) {
        return "null";
    }

    /* renamed from: a */
    public static String m30816a() {
        try {
            return Build.MODEL;
        } catch (Throwable th) {
            if (!C7226an.m31142a(th)) {
                th.printStackTrace();
            }
            return "fail";
        }
    }

    /* renamed from: b */
    public static String m30819b() {
        try {
            return VERSION.RELEASE;
        } catch (Throwable th) {
            if (!C7226an.m31142a(th)) {
                th.printStackTrace();
            }
            return "fail";
        }
    }

    /* renamed from: c */
    public static int m30821c() {
        try {
            return VERSION.SDK_INT;
        } catch (Throwable th) {
            if (!C7226an.m31142a(th)) {
                th.printStackTrace();
            }
            return -1;
        }
    }

    /* renamed from: c */
    public static String m30822c(Context context) {
        String str;
        String str2 = "fail";
        if (context == null) {
            return str2;
        }
        try {
            String string = Secure.getString(context.getContentResolver(), "android_id");
            if (string == null) {
                str = "null";
            } else {
                str = string.toLowerCase();
            }
        } catch (Throwable th) {
            if (!C7226an.m31142a(th)) {
                C7226an.m31141a("Failed to get Android ID.", new Object[0]);
            }
            str = str2;
        }
        return str;
    }

    /* renamed from: e */
    public static String m30825e(Context context) {
        String str = "fail";
        if (context == null) {
            return str;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                str = telephonyManager.getSimSerialNumber();
                if (str == null) {
                    str = "null";
                }
            }
        } catch (Throwable unused) {
            C7226an.m31141a("Failed to get SIM serial number.", new Object[0]);
        }
        return str;
    }

    /* renamed from: d */
    public static String m30823d() {
        try {
            return Build.SERIAL;
        } catch (Throwable unused) {
            C7226an.m31141a("Failed to get hardware serial number.", new Object[0]);
            return "fail";
        }
    }

    /* renamed from: e */
    public static boolean m30826e() {
        try {
            if (Environment.getExternalStorageState().equals("mounted")) {
                return true;
            }
        } catch (Throwable th) {
            if (!C7226an.m31142a(th)) {
                th.printStackTrace();
            }
        }
        return false;
    }

    /* renamed from: a */
    public static String m30818a(Context context, boolean z) {
        String str = null;
        String str2 = "fail";
        if (z) {
            try {
                String b = C7232aq.m31205b(context, "ro.product.cpu.abilist");
                if (C7232aq.m31196a(b) || b.equals(str2)) {
                    b = C7232aq.m31205b(context, "ro.product.cpu.abi");
                }
                if (!C7232aq.m31196a(b)) {
                    if (!b.equals(str2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("ABI list: ");
                        sb.append(b);
                        C7226an.m31143b(C7175b.class, sb.toString(), new Object[0]);
                        str = b.split(StorageInterface.KEY_SPLITER)[0];
                    }
                }
            } catch (Throwable th) {
                if (!C7226an.m31142a(th)) {
                    th.printStackTrace();
                }
                return str2;
            }
        }
        if (str == null) {
            str = System.getProperty("os.arch");
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("");
        sb2.append(str);
        return sb2.toString();
    }

    /* renamed from: f */
    public static long m30827f() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (!C7226an.m31142a(th)) {
                th.printStackTrace();
            }
            return -1;
        }
    }

    /* renamed from: g */
    public static long m30829g() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (!C7226an.m31142a(th)) {
                th.printStackTrace();
            }
            return -1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0084 A[Catch:{ all -> 0x00aa }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0089 A[SYNTHETIC, Splitter:B:49:0x0089] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0099 A[SYNTHETIC, Splitter:B:56:0x0099] */
    /* renamed from: h */
    public static long m30831h() {
        /*
        java.lang.String r0 = "/proc/meminfo"
        r1 = 0
        java.io.FileReader r2 = new java.io.FileReader     // Catch:{ all -> 0x007a }
        r2.<init>(r0)     // Catch:{ all -> 0x007a }
        java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ all -> 0x0075 }
        r3 = 2048(0x800, float:2.87E-42)
        r0.<init>(r2, r3)     // Catch:{ all -> 0x0075 }
        java.lang.String r1 = r0.readLine()     // Catch:{ all -> 0x0073 }
        if (r1 != 0) goto L_0x0034
        r3 = -1
        r0.close()     // Catch:{ IOException -> 0x001b }
        goto L_0x0025
    L_0x001b:
        r0 = move-exception
        boolean r1 = com.tencent.bugly.proguard.C7226an.m31142a(r0)
        if (r1 != 0) goto L_0x0025
        r0.printStackTrace()
    L_0x0025:
        r2.close()     // Catch:{ IOException -> 0x0029 }
        goto L_0x0033
    L_0x0029:
        r0 = move-exception
        boolean r1 = com.tencent.bugly.proguard.C7226an.m31142a(r0)
        if (r1 != 0) goto L_0x0033
        r0.printStackTrace()
    L_0x0033:
        return r3
    L_0x0034:
        java.lang.String r3 = ":\\s+"
        r4 = 2
        java.lang.String[] r1 = r1.split(r3, r4)     // Catch:{ all -> 0x0073 }
        r3 = 1
        r1 = r1[r3]     // Catch:{ all -> 0x0073 }
        java.lang.String r1 = r1.toLowerCase()     // Catch:{ all -> 0x0073 }
        java.lang.String r3 = "kb"
        java.lang.String r4 = ""
        java.lang.String r1 = r1.replace(r3, r4)     // Catch:{ all -> 0x0073 }
        java.lang.String r1 = r1.trim()     // Catch:{ all -> 0x0073 }
        long r3 = java.lang.Long.parseLong(r1)     // Catch:{ all -> 0x0073 }
        r5 = 1024(0x400, double:5.06E-321)
        long r3 = r3 * r5
        r0.close()     // Catch:{ IOException -> 0x005a }
        goto L_0x0064
    L_0x005a:
        r0 = move-exception
        boolean r1 = com.tencent.bugly.proguard.C7226an.m31142a(r0)
        if (r1 != 0) goto L_0x0064
        r0.printStackTrace()
    L_0x0064:
        r2.close()     // Catch:{ IOException -> 0x0068 }
        goto L_0x0072
    L_0x0068:
        r0 = move-exception
        boolean r1 = com.tencent.bugly.proguard.C7226an.m31142a(r0)
        if (r1 != 0) goto L_0x0072
        r0.printStackTrace()
    L_0x0072:
        return r3
    L_0x0073:
        r1 = move-exception
        goto L_0x007e
    L_0x0075:
        r0 = move-exception
        r7 = r1
        r1 = r0
        r0 = r7
        goto L_0x007e
    L_0x007a:
        r0 = move-exception
        r2 = r1
        r1 = r0
        r0 = r2
    L_0x007e:
        boolean r3 = com.tencent.bugly.proguard.C7226an.m31142a(r1)     // Catch:{ all -> 0x00aa }
        if (r3 != 0) goto L_0x0087
        r1.printStackTrace()     // Catch:{ all -> 0x00aa }
    L_0x0087:
        if (r0 == 0) goto L_0x0097
        r0.close()     // Catch:{ IOException -> 0x008d }
        goto L_0x0097
    L_0x008d:
        r0 = move-exception
        boolean r1 = com.tencent.bugly.proguard.C7226an.m31142a(r0)
        if (r1 != 0) goto L_0x0097
        r0.printStackTrace()
    L_0x0097:
        if (r2 == 0) goto L_0x00a7
        r2.close()     // Catch:{ IOException -> 0x009d }
        goto L_0x00a7
    L_0x009d:
        r0 = move-exception
        boolean r1 = com.tencent.bugly.proguard.C7226an.m31142a(r0)
        if (r1 != 0) goto L_0x00a7
        r0.printStackTrace()
    L_0x00a7:
        r0 = -2
        return r0
    L_0x00aa:
        r1 = move-exception
        if (r0 == 0) goto L_0x00bb
        r0.close()     // Catch:{ IOException -> 0x00b1 }
        goto L_0x00bb
    L_0x00b1:
        r0 = move-exception
        boolean r3 = com.tencent.bugly.proguard.C7226an.m31142a(r0)
        if (r3 != 0) goto L_0x00bb
        r0.printStackTrace()
    L_0x00bb:
        if (r2 == 0) goto L_0x00cb
        r2.close()     // Catch:{ IOException -> 0x00c1 }
        goto L_0x00cb
    L_0x00c1:
        r0 = move-exception
        boolean r2 = com.tencent.bugly.proguard.C7226an.m31142a(r0)
        if (r2 != 0) goto L_0x00cb
        r0.printStackTrace()
    L_0x00cb:
        throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.C7175b.m30831h():long");
    }

    /* JADX WARNING: Removed duplicated region for block: B:82:0x0102 A[Catch:{ all -> 0x0128 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0107 A[SYNTHETIC, Splitter:B:84:0x0107] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0117 A[SYNTHETIC, Splitter:B:91:0x0117] */
    /* renamed from: i */
    public static long m30833i() {
        /*
        java.lang.String r0 = ""
        java.lang.String r1 = "kb"
        java.lang.String r2 = ":\\s+"
        java.lang.String r3 = "/proc/meminfo"
        r4 = 0
        java.io.FileReader r5 = new java.io.FileReader     // Catch:{ all -> 0x00f9 }
        r5.<init>(r3)     // Catch:{ all -> 0x00f9 }
        java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ all -> 0x00f6 }
        r6 = 2048(0x800, float:2.87E-42)
        r3.<init>(r5, r6)     // Catch:{ all -> 0x00f6 }
        r3.readLine()     // Catch:{ all -> 0x00f4 }
        java.lang.String r4 = r3.readLine()     // Catch:{ all -> 0x00f4 }
        r6 = -1
        if (r4 != 0) goto L_0x003d
        r3.close()     // Catch:{ IOException -> 0x0024 }
        goto L_0x002e
    L_0x0024:
        r0 = move-exception
        boolean r1 = com.tencent.bugly.proguard.C7226an.m31142a(r0)
        if (r1 != 0) goto L_0x002e
        r0.printStackTrace()
    L_0x002e:
        r5.close()     // Catch:{ IOException -> 0x0032 }
        goto L_0x003c
    L_0x0032:
        r0 = move-exception
        boolean r1 = com.tencent.bugly.proguard.C7226an.m31142a(r0)
        if (r1 != 0) goto L_0x003c
        r0.printStackTrace()
    L_0x003c:
        return r6
    L_0x003d:
        r8 = 2
        java.lang.String[] r4 = r4.split(r2, r8)     // Catch:{ all -> 0x00f4 }
        r9 = 1
        r4 = r4[r9]     // Catch:{ all -> 0x00f4 }
        java.lang.String r4 = r4.toLowerCase()     // Catch:{ all -> 0x00f4 }
        java.lang.String r4 = r4.replace(r1, r0)     // Catch:{ all -> 0x00f4 }
        java.lang.String r4 = r4.trim()     // Catch:{ all -> 0x00f4 }
        r10 = 0
        long r12 = java.lang.Long.parseLong(r4)     // Catch:{ all -> 0x00f4 }
        r14 = 1024(0x400, double:5.06E-321)
        long r12 = r12 * r14
        long r12 = r12 + r10
        java.lang.String r4 = r3.readLine()     // Catch:{ all -> 0x00f4 }
        if (r4 != 0) goto L_0x007f
        r3.close()     // Catch:{ IOException -> 0x0066 }
        goto L_0x0070
    L_0x0066:
        r0 = move-exception
        boolean r1 = com.tencent.bugly.proguard.C7226an.m31142a(r0)
        if (r1 != 0) goto L_0x0070
        r0.printStackTrace()
    L_0x0070:
        r5.close()     // Catch:{ IOException -> 0x0074 }
        goto L_0x007e
    L_0x0074:
        r0 = move-exception
        boolean r1 = com.tencent.bugly.proguard.C7226an.m31142a(r0)
        if (r1 != 0) goto L_0x007e
        r0.printStackTrace()
    L_0x007e:
        return r6
    L_0x007f:
        java.lang.String[] r4 = r4.split(r2, r8)     // Catch:{ all -> 0x00f4 }
        r4 = r4[r9]     // Catch:{ all -> 0x00f4 }
        java.lang.String r4 = r4.toLowerCase()     // Catch:{ all -> 0x00f4 }
        java.lang.String r4 = r4.replace(r1, r0)     // Catch:{ all -> 0x00f4 }
        java.lang.String r4 = r4.trim()     // Catch:{ all -> 0x00f4 }
        long r10 = java.lang.Long.parseLong(r4)     // Catch:{ all -> 0x00f4 }
        java.lang.Long.signum(r10)
        long r10 = r10 * r14
        long r12 = r12 + r10
        java.lang.String r4 = r3.readLine()     // Catch:{ all -> 0x00f4 }
        if (r4 != 0) goto L_0x00be
        r3.close()     // Catch:{ IOException -> 0x00a5 }
        goto L_0x00af
    L_0x00a5:
        r0 = move-exception
        boolean r1 = com.tencent.bugly.proguard.C7226an.m31142a(r0)
        if (r1 != 0) goto L_0x00af
        r0.printStackTrace()
    L_0x00af:
        r5.close()     // Catch:{ IOException -> 0x00b3 }
        goto L_0x00bd
    L_0x00b3:
        r0 = move-exception
        boolean r1 = com.tencent.bugly.proguard.C7226an.m31142a(r0)
        if (r1 != 0) goto L_0x00bd
        r0.printStackTrace()
    L_0x00bd:
        return r6
    L_0x00be:
        java.lang.String[] r2 = r4.split(r2, r8)     // Catch:{ all -> 0x00f4 }
        r2 = r2[r9]     // Catch:{ all -> 0x00f4 }
        java.lang.String r2 = r2.toLowerCase()     // Catch:{ all -> 0x00f4 }
        java.lang.String r0 = r2.replace(r1, r0)     // Catch:{ all -> 0x00f4 }
        java.lang.String r0 = r0.trim()     // Catch:{ all -> 0x00f4 }
        long r0 = java.lang.Long.parseLong(r0)     // Catch:{ all -> 0x00f4 }
        long r0 = r0 * r14
        long r12 = r12 + r0
        r3.close()     // Catch:{ IOException -> 0x00db }
        goto L_0x00e5
    L_0x00db:
        r0 = move-exception
        boolean r1 = com.tencent.bugly.proguard.C7226an.m31142a(r0)
        if (r1 != 0) goto L_0x00e5
        r0.printStackTrace()
    L_0x00e5:
        r5.close()     // Catch:{ IOException -> 0x00e9 }
        goto L_0x00f3
    L_0x00e9:
        r0 = move-exception
        boolean r1 = com.tencent.bugly.proguard.C7226an.m31142a(r0)
        if (r1 != 0) goto L_0x00f3
        r0.printStackTrace()
    L_0x00f3:
        return r12
    L_0x00f4:
        r0 = move-exception
        goto L_0x00fc
    L_0x00f6:
        r0 = move-exception
        r3 = r4
        goto L_0x00fc
    L_0x00f9:
        r0 = move-exception
        r3 = r4
        r5 = r3
    L_0x00fc:
        boolean r1 = com.tencent.bugly.proguard.C7226an.m31142a(r0)     // Catch:{ all -> 0x0128 }
        if (r1 != 0) goto L_0x0105
        r0.printStackTrace()     // Catch:{ all -> 0x0128 }
    L_0x0105:
        if (r3 == 0) goto L_0x0115
        r3.close()     // Catch:{ IOException -> 0x010b }
        goto L_0x0115
    L_0x010b:
        r0 = move-exception
        boolean r1 = com.tencent.bugly.proguard.C7226an.m31142a(r0)
        if (r1 != 0) goto L_0x0115
        r0.printStackTrace()
    L_0x0115:
        if (r5 == 0) goto L_0x0125
        r5.close()     // Catch:{ IOException -> 0x011b }
        goto L_0x0125
    L_0x011b:
        r0 = move-exception
        boolean r1 = com.tencent.bugly.proguard.C7226an.m31142a(r0)
        if (r1 != 0) goto L_0x0125
        r0.printStackTrace()
    L_0x0125:
        r0 = -2
        return r0
    L_0x0128:
        r0 = move-exception
        if (r3 == 0) goto L_0x0139
        r3.close()     // Catch:{ IOException -> 0x012f }
        goto L_0x0139
    L_0x012f:
        r1 = move-exception
        boolean r2 = com.tencent.bugly.proguard.C7226an.m31142a(r1)
        if (r2 != 0) goto L_0x0139
        r1.printStackTrace()
    L_0x0139:
        if (r5 == 0) goto L_0x0149
        r5.close()     // Catch:{ IOException -> 0x013f }
        goto L_0x0149
    L_0x013f:
        r1 = move-exception
        boolean r2 = com.tencent.bugly.proguard.C7226an.m31142a(r1)
        if (r2 != 0) goto L_0x0149
        r1.printStackTrace()
    L_0x0149:
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.C7175b.m30833i():long");
    }

    /* renamed from: j */
    public static long m30835j() {
        if (!m30826e()) {
            return 0;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (!C7226an.m31142a(th)) {
                th.printStackTrace();
            }
            return -2;
        }
    }

    /* renamed from: k */
    public static long m30837k() {
        if (!m30826e()) {
            return 0;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (!C7226an.m31142a(th)) {
                th.printStackTrace();
            }
            return -2;
        }
    }

    /* renamed from: l */
    public static String m30839l() {
        try {
            return Locale.getDefault().getCountry();
        } catch (Throwable th) {
            if (!C7226an.m31142a(th)) {
                th.printStackTrace();
            }
            return "fail";
        }
    }

    /* renamed from: m */
    public static String m30842m() {
        try {
            return Build.BRAND;
        } catch (Throwable th) {
            if (!C7226an.m31142a(th)) {
                th.printStackTrace();
            }
            return "fail";
        }
    }

    /* renamed from: f */
    public static String m30828f(Context context) {
        String str;
        String str2 = EnvironmentCompat.MEDIA_UNKNOWN;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            if (activeNetworkInfo.getType() == 1) {
                str = "WIFI";
            } else {
                if (activeNetworkInfo.getType() == 0) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        int networkType = telephonyManager.getNetworkType();
                        switch (networkType) {
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
                                str = "iDen";
                                break;
                            case 12:
                                str = "EVDO_B";
                                break;
                            case 13:
                                str = "LTE";
                                break;
                            case 14:
                                str = "eHRPD";
                                break;
                            case 15:
                                str = "HSPA+";
                                break;
                            default:
                                StringBuilder sb = new StringBuilder();
                                sb.append("MOBILE(");
                                sb.append(networkType);
                                sb.append(")");
                                str = sb.toString();
                                break;
                        }
                    }
                }
                return str2;
            }
            str2 = str;
            return str2;
        } catch (Exception e) {
            if (!C7226an.m31142a(e)) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: g */
    public static String m30830g(Context context) {
        String b = C7232aq.m31205b(context, "ro.miui.ui.version.name");
        String str = "fail";
        if (C7232aq.m31196a(b) || b.equals(str)) {
            String b2 = C7232aq.m31205b(context, "ro.build.version.emui");
            if (C7232aq.m31196a(b2) || b2.equals(str)) {
                String b3 = C7232aq.m31205b(context, "ro.lenovo.series");
                if (C7232aq.m31196a(b3) || b3.equals(str)) {
                    String b4 = C7232aq.m31205b(context, "ro.build.nubia.rom.name");
                    if (C7232aq.m31196a(b4) || b4.equals(str)) {
                        String b5 = C7232aq.m31205b(context, "ro.meizu.product.model");
                        String str2 = "ro.build.display.id";
                        if (C7232aq.m31196a(b5) || b5.equals(str)) {
                            String b6 = C7232aq.m31205b(context, "ro.build.version.opporom");
                            if (C7232aq.m31196a(b6) || b6.equals(str)) {
                                String b7 = C7232aq.m31205b(context, "ro.vivo.os.build.display.id");
                                if (C7232aq.m31196a(b7) || b7.equals(str)) {
                                    String b8 = C7232aq.m31205b(context, "ro.aa.romver");
                                    String str3 = "/";
                                    if (C7232aq.m31196a(b8) || b8.equals(str)) {
                                        String b9 = C7232aq.m31205b(context, "ro.lewa.version");
                                        if (C7232aq.m31196a(b9) || b9.equals(str)) {
                                            String b10 = C7232aq.m31205b(context, "ro.gn.gnromvernumber");
                                            if (C7232aq.m31196a(b10) || b10.equals(str)) {
                                                String b11 = C7232aq.m31205b(context, "ro.build.tyd.kbstyle_version");
                                                if (C7232aq.m31196a(b11) || b11.equals(str)) {
                                                    StringBuilder sb = new StringBuilder();
                                                    sb.append(C7232aq.m31205b(context, "ro.build.fingerprint"));
                                                    sb.append(str3);
                                                    sb.append(C7232aq.m31205b(context, "ro.build.rom.id"));
                                                    return sb.toString();
                                                }
                                                StringBuilder sb2 = new StringBuilder();
                                                sb2.append("dido/");
                                                sb2.append(b11);
                                                return sb2.toString();
                                            }
                                            StringBuilder sb3 = new StringBuilder();
                                            sb3.append("amigo/");
                                            sb3.append(b10);
                                            sb3.append(str3);
                                            sb3.append(C7232aq.m31205b(context, str2));
                                            return sb3.toString();
                                        }
                                        StringBuilder sb4 = new StringBuilder();
                                        sb4.append("tcl/");
                                        sb4.append(b9);
                                        sb4.append(str3);
                                        sb4.append(C7232aq.m31205b(context, str2));
                                        return sb4.toString();
                                    }
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append("htc/");
                                    sb5.append(b8);
                                    sb5.append(str3);
                                    sb5.append(C7232aq.m31205b(context, "ro.build.description"));
                                    return sb5.toString();
                                }
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append("vivo/FUNTOUCH/");
                                sb6.append(b7);
                                return sb6.toString();
                            }
                            StringBuilder sb7 = new StringBuilder();
                            sb7.append("Oppo/COLOROS/");
                            sb7.append(b6);
                            return sb7.toString();
                        }
                        StringBuilder sb8 = new StringBuilder();
                        sb8.append("Meizu/FLYME/");
                        sb8.append(C7232aq.m31205b(context, str2));
                        return sb8.toString();
                    }
                    StringBuilder sb9 = new StringBuilder();
                    sb9.append("Zte/NUBIA/");
                    sb9.append(b4);
                    sb9.append("_");
                    sb9.append(C7232aq.m31205b(context, "ro.build.nubia.rom.code"));
                    return sb9.toString();
                }
                String b12 = C7232aq.m31205b(context, "ro.build.version.incremental");
                StringBuilder sb10 = new StringBuilder();
                sb10.append("Lenovo/VIBE/");
                sb10.append(b12);
                return sb10.toString();
            }
            StringBuilder sb11 = new StringBuilder();
            sb11.append("HuaWei/EMOTION/");
            sb11.append(b2);
            return sb11.toString();
        }
        StringBuilder sb12 = new StringBuilder();
        sb12.append("XiaoMi/MIUI/");
        sb12.append(b);
        return sb12.toString();
    }

    /* renamed from: h */
    public static String m30832h(Context context) {
        return C7232aq.m31205b(context, "ro.board.platform");
    }

    /* renamed from: n */
    public static boolean m30843n() {
        boolean z;
        String[] strArr = f24046a;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            } else if (new File(strArr[i]).exists()) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        boolean z2 = Build.TAGS != null && Build.TAGS.contains("test-keys");
        if (z2 || z) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0092 A[SYNTHETIC, Splitter:B:43:0x0092] */
    /* renamed from: o */
    public static java.lang.String m30845o() {
        /*
        java.lang.String r0 = "/sys/block/mmcblk0/device/cid"
        java.lang.String r1 = "/sys/block/mmcblk0/device/name"
        java.lang.String r2 = ","
        java.lang.String r3 = "/sys/block/mmcblk0/device/type"
        r4 = 0
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x008f }
        r5.<init>()     // Catch:{ all -> 0x008f }
        java.io.File r6 = new java.io.File     // Catch:{ all -> 0x008f }
        r6.<init>(r3)     // Catch:{ all -> 0x008f }
        boolean r6 = r6.exists()     // Catch:{ all -> 0x008f }
        if (r6 == 0) goto L_0x0030
        java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ all -> 0x008f }
        java.io.FileReader r7 = new java.io.FileReader     // Catch:{ all -> 0x008f }
        r7.<init>(r3)     // Catch:{ all -> 0x008f }
        r6.<init>(r7)     // Catch:{ all -> 0x008f }
        java.lang.String r3 = r6.readLine()     // Catch:{ all -> 0x008d }
        if (r3 == 0) goto L_0x002c
        r5.append(r3)     // Catch:{ all -> 0x008d }
    L_0x002c:
        r6.close()     // Catch:{ all -> 0x008d }
        goto L_0x0031
    L_0x0030:
        r6 = r4
    L_0x0031:
        r5.append(r2)     // Catch:{ all -> 0x008d }
        java.io.File r3 = new java.io.File     // Catch:{ all -> 0x008d }
        r3.<init>(r1)     // Catch:{ all -> 0x008d }
        boolean r3 = r3.exists()     // Catch:{ all -> 0x008d }
        if (r3 == 0) goto L_0x0056
        java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ all -> 0x008d }
        java.io.FileReader r7 = new java.io.FileReader     // Catch:{ all -> 0x008d }
        r7.<init>(r1)     // Catch:{ all -> 0x008d }
        r3.<init>(r7)     // Catch:{ all -> 0x008d }
        java.lang.String r1 = r3.readLine()     // Catch:{ all -> 0x008b }
        if (r1 == 0) goto L_0x0052
        r5.append(r1)     // Catch:{ all -> 0x008b }
    L_0x0052:
        r3.close()     // Catch:{ all -> 0x008b }
        goto L_0x0057
    L_0x0056:
        r3 = r6
    L_0x0057:
        r5.append(r2)     // Catch:{ all -> 0x008b }
        java.io.File r1 = new java.io.File     // Catch:{ all -> 0x008b }
        r1.<init>(r0)     // Catch:{ all -> 0x008b }
        boolean r1 = r1.exists()     // Catch:{ all -> 0x008b }
        if (r1 == 0) goto L_0x0079
        java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x008b }
        java.io.FileReader r2 = new java.io.FileReader     // Catch:{ all -> 0x008b }
        r2.<init>(r0)     // Catch:{ all -> 0x008b }
        r1.<init>(r2)     // Catch:{ all -> 0x008b }
        java.lang.String r0 = r1.readLine()     // Catch:{ all -> 0x0089 }
        if (r0 == 0) goto L_0x007a
        r5.append(r0)     // Catch:{ all -> 0x0089 }
        goto L_0x007a
    L_0x0079:
        r1 = r3
    L_0x007a:
        java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x0089 }
        if (r1 == 0) goto L_0x0088
        r1.close()     // Catch:{ IOException -> 0x0084 }
        goto L_0x0088
    L_0x0084:
        r1 = move-exception
        com.tencent.bugly.proguard.C7226an.m31142a(r1)
    L_0x0088:
        return r0
    L_0x0089:
        r3 = r1
        goto L_0x0090
        goto L_0x0090
    L_0x008d:
        r3 = r6
        goto L_0x0090
    L_0x008f:
        r3 = r4
    L_0x0090:
        if (r3 == 0) goto L_0x009a
        r3.close()     // Catch:{ IOException -> 0x0096 }
        goto L_0x009a
    L_0x0096:
        r0 = move-exception
        com.tencent.bugly.proguard.C7226an.m31142a(r0)
    L_0x009a:
        return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.C7175b.m30845o():java.lang.String");
    }

    /* renamed from: i */
    public static String m30834i(Context context) {
        StringBuilder sb = new StringBuilder();
        String str = "ro.genymotion.version";
        String b = C7232aq.m31205b(context, str);
        String str2 = "\n";
        String str3 = "|";
        if (b != null) {
            sb.append(str);
            sb.append(str3);
            sb.append(b);
            sb.append(str2);
        }
        String str4 = "androVM.vbox_dpi";
        String b2 = C7232aq.m31205b(context, str4);
        if (b2 != null) {
            sb.append(str4);
            sb.append(str3);
            sb.append(b2);
            sb.append(str2);
        }
        String str5 = "qemu.sf.fake_camera";
        String b3 = C7232aq.m31205b(context, str5);
        if (b3 != null) {
            sb.append(str5);
            sb.append(str3);
            sb.append(b3);
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x008f A[SYNTHETIC, Splitter:B:34:0x008f] */
    /* renamed from: j */
    public static java.lang.String m30836j(android.content.Context r6) {
        /*
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r1 = f24049d
        java.lang.String r2 = "ro.secure"
        if (r1 != 0) goto L_0x0011
        java.lang.String r1 = com.tencent.bugly.proguard.C7232aq.m31205b(r6, r2)
        f24049d = r1
    L_0x0011:
        java.lang.String r1 = f24049d
        java.lang.String r3 = "\n"
        java.lang.String r4 = "|"
        if (r1 == 0) goto L_0x0027
        r0.append(r2)
        r0.append(r4)
        java.lang.String r1 = f24049d
        r0.append(r1)
        r0.append(r3)
    L_0x0027:
        java.lang.String r1 = f24050e
        java.lang.String r2 = "ro.debuggable"
        if (r1 != 0) goto L_0x0033
        java.lang.String r6 = com.tencent.bugly.proguard.C7232aq.m31205b(r6, r2)
        f24050e = r6
    L_0x0033:
        java.lang.String r6 = f24050e
        if (r6 == 0) goto L_0x0045
        r0.append(r2)
        r0.append(r4)
        java.lang.String r6 = f24050e
        r0.append(r6)
        r0.append(r3)
    L_0x0045:
        r6 = 0
        java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x0086 }
        java.io.FileReader r2 = new java.io.FileReader     // Catch:{ all -> 0x0086 }
        java.lang.String r3 = "/proc/self/status"
        r2.<init>(r3)     // Catch:{ all -> 0x0086 }
        r1.<init>(r2)     // Catch:{ all -> 0x0086 }
    L_0x0052:
        java.lang.String r6 = r1.readLine()     // Catch:{ all -> 0x0084 }
        if (r6 == 0) goto L_0x0060
        java.lang.String r2 = "TracerPid:"
        boolean r2 = r6.startsWith(r2)     // Catch:{ all -> 0x0084 }
        if (r2 == 0) goto L_0x0052
    L_0x0060:
        if (r6 == 0) goto L_0x0077
        r2 = 10
        java.lang.String r6 = r6.substring(r2)     // Catch:{ all -> 0x0084 }
        java.lang.String r6 = r6.trim()     // Catch:{ all -> 0x0084 }
        java.lang.String r2 = "tracer_pid"
        r0.append(r2)     // Catch:{ all -> 0x0084 }
        r0.append(r4)     // Catch:{ all -> 0x0084 }
        r0.append(r6)     // Catch:{ all -> 0x0084 }
    L_0x0077:
        java.lang.String r6 = r0.toString()     // Catch:{ all -> 0x0084 }
        r1.close()     // Catch:{ IOException -> 0x007f }
        goto L_0x0083
    L_0x007f:
        r0 = move-exception
        com.tencent.bugly.proguard.C7226an.m31142a(r0)
    L_0x0083:
        return r6
    L_0x0084:
        r6 = move-exception
        goto L_0x008a
    L_0x0086:
        r1 = move-exception
        r5 = r1
        r1 = r6
        r6 = r5
    L_0x008a:
        com.tencent.bugly.proguard.C7226an.m31142a(r6)     // Catch:{ all -> 0x009c }
        if (r1 == 0) goto L_0x0097
        r1.close()     // Catch:{ IOException -> 0x0093 }
        goto L_0x0097
    L_0x0093:
        r6 = move-exception
        com.tencent.bugly.proguard.C7226an.m31142a(r6)
    L_0x0097:
        java.lang.String r6 = r0.toString()
        return r6
    L_0x009c:
        r6 = move-exception
        if (r1 == 0) goto L_0x00a7
        r1.close()     // Catch:{ IOException -> 0x00a3 }
        goto L_0x00a7
    L_0x00a3:
        r0 = move-exception
        com.tencent.bugly.proguard.C7226an.m31142a(r0)
    L_0x00a7:
        throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.C7175b.m30836j(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a7 A[Catch:{ IOException -> 0x00ab }] */
    /* renamed from: k */
    public static java.lang.String m30838k(android.content.Context r8) {
        /*
        java.lang.String r8 = "/sys/class/power_supply/battery/capacity"
        java.lang.String r0 = "/sys/class/power_supply/usb/online"
        java.lang.String r1 = "\n"
        java.lang.String r2 = "/sys/class/power_supply/ac/online"
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>()
        r4 = 0
        java.io.File r5 = new java.io.File     // Catch:{ all -> 0x00a4 }
        r5.<init>(r2)     // Catch:{ all -> 0x00a4 }
        boolean r5 = r5.exists()     // Catch:{ all -> 0x00a4 }
        java.lang.String r6 = "|"
        if (r5 == 0) goto L_0x003e
        java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ all -> 0x00a4 }
        java.io.FileReader r7 = new java.io.FileReader     // Catch:{ all -> 0x00a4 }
        r7.<init>(r2)     // Catch:{ all -> 0x00a4 }
        r5.<init>(r7)     // Catch:{ all -> 0x00a4 }
        java.lang.String r2 = r5.readLine()     // Catch:{ all -> 0x003b }
        if (r2 == 0) goto L_0x0036
        java.lang.String r4 = "ac_online"
        r3.append(r4)     // Catch:{ all -> 0x003b }
        r3.append(r6)     // Catch:{ all -> 0x003b }
        r3.append(r2)     // Catch:{ all -> 0x003b }
    L_0x0036:
        r5.close()     // Catch:{ all -> 0x003b }
        r4 = r5
        goto L_0x003e
    L_0x003b:
        r4 = r5
        goto L_0x00a5
    L_0x003e:
        r3.append(r1)     // Catch:{ all -> 0x00a4 }
        java.io.File r2 = new java.io.File     // Catch:{ all -> 0x00a4 }
        r2.<init>(r0)     // Catch:{ all -> 0x00a4 }
        boolean r2 = r2.exists()     // Catch:{ all -> 0x00a4 }
        if (r2 == 0) goto L_0x006e
        java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x00a4 }
        java.io.FileReader r5 = new java.io.FileReader     // Catch:{ all -> 0x00a4 }
        r5.<init>(r0)     // Catch:{ all -> 0x00a4 }
        r2.<init>(r5)     // Catch:{ all -> 0x00a4 }
        java.lang.String r0 = r2.readLine()     // Catch:{ all -> 0x006c }
        if (r0 == 0) goto L_0x0067
        java.lang.String r4 = "usb_online"
        r3.append(r4)     // Catch:{ all -> 0x006c }
        r3.append(r6)     // Catch:{ all -> 0x006c }
        r3.append(r0)     // Catch:{ all -> 0x006c }
    L_0x0067:
        r2.close()     // Catch:{ all -> 0x006c }
        r4 = r2
        goto L_0x006e
    L_0x006c:
        r4 = r2
        goto L_0x00a5
    L_0x006e:
        r3.append(r1)     // Catch:{ all -> 0x00a4 }
        java.io.File r0 = new java.io.File     // Catch:{ all -> 0x00a4 }
        r0.<init>(r8)     // Catch:{ all -> 0x00a4 }
        boolean r0 = r0.exists()     // Catch:{ all -> 0x00a4 }
        if (r0 == 0) goto L_0x009d
        java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ all -> 0x00a4 }
        java.io.FileReader r1 = new java.io.FileReader     // Catch:{ all -> 0x00a4 }
        r1.<init>(r8)     // Catch:{ all -> 0x00a4 }
        r0.<init>(r1)     // Catch:{ all -> 0x00a4 }
        java.lang.String r8 = r0.readLine()     // Catch:{ all -> 0x009b }
        if (r8 == 0) goto L_0x0097
        java.lang.String r1 = "battery_capacity"
        r3.append(r1)     // Catch:{ all -> 0x009b }
        r3.append(r6)     // Catch:{ all -> 0x009b }
        r3.append(r8)     // Catch:{ all -> 0x009b }
    L_0x0097:
        r0.close()     // Catch:{ all -> 0x009b }
        goto L_0x009e
    L_0x009b:
        r4 = r0
        goto L_0x00a5
    L_0x009d:
        r0 = r4
    L_0x009e:
        if (r0 == 0) goto L_0x00af
        r0.close()     // Catch:{ IOException -> 0x00ab }
        goto L_0x00af
    L_0x00a5:
        if (r4 == 0) goto L_0x00af
        r4.close()     // Catch:{ IOException -> 0x00ab }
        goto L_0x00af
    L_0x00ab:
        r8 = move-exception
        com.tencent.bugly.proguard.C7226an.m31142a(r8)
    L_0x00af:
        java.lang.String r8 = r3.toString()
        return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.C7175b.m30838k(android.content.Context):java.lang.String");
    }

    /* renamed from: l */
    public static String m30840l(Context context) {
        StringBuilder sb = new StringBuilder();
        String str = "gsm.sim.state";
        String b = C7232aq.m31205b(context, str);
        String str2 = "|";
        if (b != null) {
            sb.append(str);
            sb.append(str2);
            sb.append(b);
        }
        sb.append("\n");
        String str3 = "gsm.sim.state2";
        String b2 = C7232aq.m31205b(context, str3);
        if (b2 != null) {
            sb.append(str3);
            sb.append(str2);
            sb.append(b2);
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x003e A[SYNTHETIC, Splitter:B:19:0x003e] */
    /* renamed from: m */
    public static long m30841m(android.content.Context r7) {
        /*
        r7 = 0
        r0 = 0
        r1 = 0
        java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x0034 }
        java.io.FileReader r3 = new java.io.FileReader     // Catch:{ all -> 0x0034 }
        java.lang.String r4 = "/proc/uptime"
        r3.<init>(r4)     // Catch:{ all -> 0x0034 }
        r2.<init>(r3)     // Catch:{ all -> 0x0034 }
        java.lang.String r1 = r2.readLine()     // Catch:{ all -> 0x0035 }
        if (r1 == 0) goto L_0x002b
        java.lang.String r3 = " "
        java.lang.String[] r1 = r1.split(r3)     // Catch:{ all -> 0x0035 }
        r1 = r1[r7]     // Catch:{ all -> 0x0035 }
        long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0035 }
        r5 = 1000(0x3e8, double:4.94E-321)
        long r3 = r3 / r5
        float r3 = (float) r3     // Catch:{ all -> 0x0035 }
        float r7 = java.lang.Float.parseFloat(r1)     // Catch:{ all -> 0x0035 }
        float r3 = r3 - r7
        r0 = r3
    L_0x002b:
        r2.close()     // Catch:{ IOException -> 0x002f }
        goto L_0x0041
    L_0x002f:
        r7 = move-exception
        com.tencent.bugly.proguard.C7226an.m31142a(r7)
        goto L_0x0041
    L_0x0034:
        r2 = r1
    L_0x0035:
        java.lang.String r1 = "Failed to get boot time of device."
        java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ all -> 0x0043 }
        com.tencent.bugly.proguard.C7226an.m31141a(r1, r7)     // Catch:{ all -> 0x0043 }
        if (r2 == 0) goto L_0x0041
        r2.close()     // Catch:{ IOException -> 0x002f }
    L_0x0041:
        long r0 = (long) r0
        return r0
    L_0x0043:
        r7 = move-exception
        if (r2 == 0) goto L_0x004e
        r2.close()     // Catch:{ IOException -> 0x004a }
        goto L_0x004e
    L_0x004a:
        r0 = move-exception
        com.tencent.bugly.proguard.C7226an.m31142a(r0)
    L_0x004e:
        throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.C7175b.m30841m(android.content.Context):long");
    }

    /* renamed from: n */
    public static boolean m30844n(Context context) {
        return (m30846o(context) == null && m30847p() == null) ? false : true;
    }

    /* renamed from: o */
    public static String m30846o(Context context) {
        PackageManager packageManager = context.getPackageManager();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            String[] strArr = f24047b;
            if (i >= strArr.length) {
                break;
            }
            try {
                packageManager.getPackageInfo(strArr[i], 1);
                arrayList.add(Integer.valueOf(i));
            } catch (NameNotFoundException unused) {
            }
            i++;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList.toString();
    }

    /* renamed from: p */
    public static String m30847p() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            String[] strArr = f24048c;
            if (i >= strArr.length) {
                break;
            }
            if (i == 0) {
                if (!new File(strArr[i]).exists()) {
                    arrayList.add(Integer.valueOf(i));
                }
            } else if (new File(strArr[i]).exists()) {
                arrayList.add(Integer.valueOf(i));
            }
            i++;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList.toString();
    }

    /* renamed from: p */
    public static boolean m30848p(Context context) {
        return (((m30850q(context) | m30851r()) | m30852s()) | m30849q()) > 0;
    }

    /* renamed from: q */
    public static int m30849q() {
        try {
            Method method = Class.forName("android.app.ActivityManagerNative").getMethod("getDefault", new Class[0]);
            method.setAccessible(true);
            if (method.invoke(null, new Object[0]).getClass().getName().startsWith("$Proxy")) {
                return 256;
            }
            return 0;
        } catch (Exception unused) {
            return 256;
        }
    }

    /* renamed from: q */
    public static int m30850q(Context context) {
        int i;
        PackageManager packageManager = context.getPackageManager();
        try {
            packageManager.getInstallerPackageName("de.robv.android.xposed.installer");
            i = 1;
        } catch (Exception unused) {
            i = 0;
        }
        try {
            packageManager.getInstallerPackageName("com.saurik.substrate");
            return i | 2;
        } catch (Exception unused2) {
            return i;
        }
    }

    /* renamed from: r */
    public static int m30851r() {
        try {
            throw new Exception("detect hook");
        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            int length = stackTrace.length;
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                StackTraceElement stackTraceElement = stackTrace[i3];
                String str = "de.robv.android.xposed.XposedBridge";
                if (stackTraceElement.getClassName().equals(str) && stackTraceElement.getMethodName().equals("main")) {
                    i |= 4;
                }
                if (stackTraceElement.getClassName().equals(str) && stackTraceElement.getMethodName().equals("handleHookedMethod")) {
                    i |= 8;
                }
                if (stackTraceElement.getClassName().equals("com.saurik.substrate.MS$2") && stackTraceElement.getMethodName().equals("invoked")) {
                    i |= 16;
                }
                if (stackTraceElement.getClassName().equals("com.android.internal.os.ZygoteInit")) {
                    i2++;
                    if (i2 == 2) {
                        i |= 32;
                    }
                }
            }
            return i;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x009f A[SYNTHETIC, Splitter:B:35:0x009f] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ab A[SYNTHETIC, Splitter:B:42:0x00ab] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b7 A[SYNTHETIC, Splitter:B:49:0x00b7] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00be A[SYNTHETIC, Splitter:B:54:0x00be] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:46:0x00b2=Splitter:B:46:0x00b2, B:39:0x00a6=Splitter:B:39:0x00a6, B:32:0x009a=Splitter:B:32:0x009a} */
    /* renamed from: s */
    public static int m30852s() {
        /*
        r0 = 0
        r1 = 0
        java.util.HashSet r2 = new java.util.HashSet     // Catch:{ UnsupportedEncodingException -> 0x00af, FileNotFoundException -> 0x00a3, IOException -> 0x0097, all -> 0x0094 }
        r2.<init>()     // Catch:{ UnsupportedEncodingException -> 0x00af, FileNotFoundException -> 0x00a3, IOException -> 0x0097, all -> 0x0094 }
        java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ UnsupportedEncodingException -> 0x00af, FileNotFoundException -> 0x00a3, IOException -> 0x0097, all -> 0x0094 }
        java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ UnsupportedEncodingException -> 0x00af, FileNotFoundException -> 0x00a3, IOException -> 0x0097, all -> 0x0094 }
        java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ UnsupportedEncodingException -> 0x00af, FileNotFoundException -> 0x00a3, IOException -> 0x0097, all -> 0x0094 }
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ UnsupportedEncodingException -> 0x00af, FileNotFoundException -> 0x00a3, IOException -> 0x0097, all -> 0x0094 }
        r6.<init>()     // Catch:{ UnsupportedEncodingException -> 0x00af, FileNotFoundException -> 0x00a3, IOException -> 0x0097, all -> 0x0094 }
        java.lang.String r7 = "/proc/"
        r6.append(r7)     // Catch:{ UnsupportedEncodingException -> 0x00af, FileNotFoundException -> 0x00a3, IOException -> 0x0097, all -> 0x0094 }
        int r7 = android.os.Process.myPid()     // Catch:{ UnsupportedEncodingException -> 0x00af, FileNotFoundException -> 0x00a3, IOException -> 0x0097, all -> 0x0094 }
        r6.append(r7)     // Catch:{ UnsupportedEncodingException -> 0x00af, FileNotFoundException -> 0x00a3, IOException -> 0x0097, all -> 0x0094 }
        java.lang.String r7 = "/maps"
        r6.append(r7)     // Catch:{ UnsupportedEncodingException -> 0x00af, FileNotFoundException -> 0x00a3, IOException -> 0x0097, all -> 0x0094 }
        java.lang.String r6 = r6.toString()     // Catch:{ UnsupportedEncodingException -> 0x00af, FileNotFoundException -> 0x00a3, IOException -> 0x0097, all -> 0x0094 }
        r5.<init>(r6)     // Catch:{ UnsupportedEncodingException -> 0x00af, FileNotFoundException -> 0x00a3, IOException -> 0x0097, all -> 0x0094 }
        java.lang.String r6 = "utf-8"
        r4.<init>(r5, r6)     // Catch:{ UnsupportedEncodingException -> 0x00af, FileNotFoundException -> 0x00a3, IOException -> 0x0097, all -> 0x0094 }
        r3.<init>(r4)     // Catch:{ UnsupportedEncodingException -> 0x00af, FileNotFoundException -> 0x00a3, IOException -> 0x0097, all -> 0x0094 }
    L_0x0032:
        java.lang.String r1 = r3.readLine()     // Catch:{ UnsupportedEncodingException -> 0x0092, FileNotFoundException -> 0x0090, IOException -> 0x008e }
        if (r1 == 0) goto L_0x0059
        java.lang.String r4 = ".so"
        boolean r4 = r1.endsWith(r4)     // Catch:{ UnsupportedEncodingException -> 0x0092, FileNotFoundException -> 0x0090, IOException -> 0x008e }
        if (r4 != 0) goto L_0x0049
        java.lang.String r4 = ".jar"
        boolean r4 = r1.endsWith(r4)     // Catch:{ UnsupportedEncodingException -> 0x0092, FileNotFoundException -> 0x0090, IOException -> 0x008e }
        if (r4 != 0) goto L_0x0049
        goto L_0x0032
    L_0x0049:
        java.lang.String r4 = " "
        int r4 = r1.lastIndexOf(r4)     // Catch:{ UnsupportedEncodingException -> 0x0092, FileNotFoundException -> 0x0090, IOException -> 0x008e }
        int r4 = r4 + 1
        java.lang.String r1 = r1.substring(r4)     // Catch:{ UnsupportedEncodingException -> 0x0092, FileNotFoundException -> 0x0090, IOException -> 0x008e }
        r2.add(r1)     // Catch:{ UnsupportedEncodingException -> 0x0092, FileNotFoundException -> 0x0090, IOException -> 0x008e }
        goto L_0x0032
    L_0x0059:
        java.util.Iterator r1 = r2.iterator()     // Catch:{ UnsupportedEncodingException -> 0x0092, FileNotFoundException -> 0x0090, IOException -> 0x008e }
    L_0x005d:
        boolean r2 = r1.hasNext()     // Catch:{ UnsupportedEncodingException -> 0x0092, FileNotFoundException -> 0x0090, IOException -> 0x008e }
        if (r2 == 0) goto L_0x0085
        java.lang.Object r2 = r1.next()     // Catch:{ UnsupportedEncodingException -> 0x0092, FileNotFoundException -> 0x0090, IOException -> 0x008e }
        r4 = r2
        java.lang.String r4 = (java.lang.String) r4     // Catch:{ UnsupportedEncodingException -> 0x0092, FileNotFoundException -> 0x0090, IOException -> 0x008e }
        java.lang.String r4 = r4.toLowerCase()     // Catch:{ UnsupportedEncodingException -> 0x0092, FileNotFoundException -> 0x0090, IOException -> 0x008e }
        java.lang.String r5 = "xposed"
        boolean r4 = r4.contains(r5)     // Catch:{ UnsupportedEncodingException -> 0x0092, FileNotFoundException -> 0x0090, IOException -> 0x008e }
        if (r4 == 0) goto L_0x0078
        r0 = r0 | 64
    L_0x0078:
        java.lang.String r2 = (java.lang.String) r2     // Catch:{ UnsupportedEncodingException -> 0x0092, FileNotFoundException -> 0x0090, IOException -> 0x008e }
        java.lang.String r4 = "com.saurik.substrate"
        boolean r2 = r2.contains(r4)     // Catch:{ UnsupportedEncodingException -> 0x0092, FileNotFoundException -> 0x0090, IOException -> 0x008e }
        if (r2 == 0) goto L_0x005d
        r0 = r0 | 128(0x80, float:1.794E-43)
        goto L_0x005d
    L_0x0085:
        r3.close()     // Catch:{ IOException -> 0x0089 }
        goto L_0x00ba
    L_0x0089:
        r1 = move-exception
        r1.printStackTrace()
        goto L_0x00ba
    L_0x008e:
        r1 = move-exception
        goto L_0x009a
    L_0x0090:
        r1 = move-exception
        goto L_0x00a6
    L_0x0092:
        r1 = move-exception
        goto L_0x00b2
    L_0x0094:
        r0 = move-exception
        r3 = r1
        goto L_0x00bc
    L_0x0097:
        r2 = move-exception
        r3 = r1
        r1 = r2
    L_0x009a:
        r1.printStackTrace()     // Catch:{ all -> 0x00bb }
        if (r3 == 0) goto L_0x00ba
        r3.close()     // Catch:{ IOException -> 0x0089 }
        goto L_0x00ba
    L_0x00a3:
        r2 = move-exception
        r3 = r1
        r1 = r2
    L_0x00a6:
        r1.printStackTrace()     // Catch:{ all -> 0x00bb }
        if (r3 == 0) goto L_0x00ba
        r3.close()     // Catch:{ IOException -> 0x0089 }
        goto L_0x00ba
    L_0x00af:
        r2 = move-exception
        r3 = r1
        r1 = r2
    L_0x00b2:
        r1.printStackTrace()     // Catch:{ all -> 0x00bb }
        if (r3 == 0) goto L_0x00ba
        r3.close()     // Catch:{ IOException -> 0x0089 }
    L_0x00ba:
        return r0
    L_0x00bb:
        r0 = move-exception
    L_0x00bc:
        if (r3 == 0) goto L_0x00c6
        r3.close()     // Catch:{ IOException -> 0x00c2 }
        goto L_0x00c6
    L_0x00c2:
        r1 = move-exception
        r1.printStackTrace()
    L_0x00c6:
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.C7175b.m30852s():int");
    }
}
