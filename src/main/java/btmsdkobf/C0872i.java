package btmsdkobf;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;

/* renamed from: btmsdkobf.i */
public class C0872i {
    /* renamed from: p */
    private static Integer f1035p = null;
    /* renamed from: q */
    private static long f1036q = -1;

    /* renamed from: btmsdkobf.i$a */
    public static class C0874a {
        /* renamed from: r */
        public long f1037r;
        /* renamed from: s */
        public long f1038s;
    }

    /* renamed from: a */
    public static void m973a(C0874a aVar) {
        if (C0834ey.m874cL()) {
            m974a(Environment.getExternalStorageDirectory(), aVar);
            return;
        }
        aVar.f1037r = 0;
        aVar.f1038s = 0;
    }

    /* renamed from: a */
    public static void m974a(File file, C0874a aVar) {
        try {
            StatFs statFs = new StatFs(file.getPath());
            long blockSize = (long) statFs.getBlockSize();
            aVar.f1037r = ((long) statFs.getAvailableBlocks()) * blockSize;
            aVar.f1038s = ((long) statFs.getBlockCount()) * blockSize;
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    public static String m975b(Context context) {
        String str;
        try {
            str = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Throwable th) {
            C0848ff.m908w("PhoneInfoFetcher", th.getMessage());
            str = null;
        }
        return str == null ? "00000000000000" : str;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x002b */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* renamed from: b */
    public static java.lang.String m976b(boolean r5) {
        /*
        java.lang.String r0 = ""
        java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x0055 }
        java.lang.String r2 = "/proc/version"
        r1.<init>(r2)     // Catch:{ all -> 0x0055 }
        java.io.BufferedReader r2 = new java.io.BufferedReader
        java.io.InputStreamReader r3 = new java.io.InputStreamReader
        r3.<init>(r1)
        r4 = 8192(0x2000, float:1.14794E-41)
        r2.<init>(r3, r4)
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>(r0)
    L_0x001a:
        java.lang.String r4 = r2.readLine()     // Catch:{ all -> 0x0028 }
        if (r4 == 0) goto L_0x0024
        r3.append(r4)     // Catch:{ all -> 0x0028 }
        goto L_0x001a
    L_0x0024:
        r2.close()     // Catch:{ all -> 0x002b }
        goto L_0x002b
    L_0x0028:
        r2.close()     // Catch:{ all -> 0x002b }
    L_0x002b:
        r1.close()     // Catch:{ all -> 0x002e }
    L_0x002e:
        java.lang.String r1 = r3.toString()
        if (r5 != 0) goto L_0x0036
        r0 = r1
        goto L_0x0055
    L_0x0036:
        if (r1 == 0) goto L_0x0055
        boolean r5 = r1.equals(r0)
        if (r5 != 0) goto L_0x0055
        java.lang.String r5 = "version "
        int r5 = r1.indexOf(r5)     // Catch:{  }
        int r5 = r5 + 8
        java.lang.String r5 = r1.substring(r5)     // Catch:{  }
        java.lang.String r1 = " "
        int r1 = r5.indexOf(r1)     // Catch:{  }
        r2 = 0
        java.lang.String r0 = r5.substring(r2, r1)     // Catch:{  }
    L_0x0055:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0872i.m976b(boolean):java.lang.String");
    }

    /* renamed from: b */
    public static void m977b(C0874a aVar) {
        m974a(Environment.getDataDirectory(), aVar);
    }

    /* renamed from: c */
    public static String m978c(Context context) {
        String str;
        try {
            str = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        } catch (Throwable unused) {
            str = null;
        }
        return str == null ? "000000000000000" : str;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:15|16|17|18|19|20) */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006b, code lost:
            if (r0 == null) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x007c, code lost:
            if (r0 == null) goto L_0x007f;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x005f */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0077 A[SYNTHETIC, Splitter:B:35:0x0077] */
    /* renamed from: c */
    public static java.lang.String m979c(boolean r6) {
        /*
        if (r6 == 0) goto L_0x0007
        java.lang.String r6 = "/sys/block/mmcblk0/device/"
        java.lang.String r0 = "MMC"
        goto L_0x000b
    L_0x0007:
        java.lang.String r6 = "/sys/block/mmcblk1/device/"
        java.lang.String r0 = "SD"
    L_0x000b:
        r1 = 0
        java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x0073 }
        java.io.FileReader r3 = new java.io.FileReader     // Catch:{ all -> 0x0073 }
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0073 }
        r4.<init>()     // Catch:{ all -> 0x0073 }
        r4.append(r6)     // Catch:{ all -> 0x0073 }
        java.lang.String r5 = "type"
        r4.append(r5)     // Catch:{ all -> 0x0073 }
        java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0073 }
        r3.<init>(r4)     // Catch:{ all -> 0x0073 }
        r2.<init>(r3)     // Catch:{ all -> 0x0073 }
        java.lang.String r3 = r2.readLine()     // Catch:{ all -> 0x0071 }
        if (r3 == 0) goto L_0x0065
        java.lang.String r3 = r3.toUpperCase()     // Catch:{ all -> 0x0071 }
        boolean r0 = r3.equals(r0)     // Catch:{ all -> 0x0071 }
        if (r0 == 0) goto L_0x0065
        java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ all -> 0x0071 }
        java.io.FileReader r3 = new java.io.FileReader     // Catch:{ all -> 0x0071 }
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0071 }
        r4.<init>()     // Catch:{ all -> 0x0071 }
        r4.append(r6)     // Catch:{ all -> 0x0071 }
        java.lang.String r6 = "cid"
        r4.append(r6)     // Catch:{ all -> 0x0071 }
        java.lang.String r6 = r4.toString()     // Catch:{ all -> 0x0071 }
        r3.<init>(r6)     // Catch:{ all -> 0x0071 }
        r0.<init>(r3)     // Catch:{ all -> 0x0071 }
        java.lang.String r6 = r0.readLine()     // Catch:{ all -> 0x0063 }
        if (r6 == 0) goto L_0x0066
        java.lang.String r6 = r6.trim()     // Catch:{ all -> 0x0063 }
        r2.close()     // Catch:{ IOException -> 0x005f }
    L_0x005f:
        r0.close()     // Catch:{ IOException -> 0x0062 }
    L_0x0062:
        return r6
        goto L_0x0075
    L_0x0065:
        r0 = r1
    L_0x0066:
        r2.close()     // Catch:{ IOException -> 0x006a }
        goto L_0x006b
    L_0x006b:
        if (r0 == 0) goto L_0x007f
    L_0x006d:
        r0.close()     // Catch:{ IOException -> 0x007f }
        goto L_0x007f
    L_0x0071:
        r0 = r1
        goto L_0x0075
    L_0x0073:
        r0 = r1
        r2 = r0
    L_0x0075:
        if (r2 == 0) goto L_0x007c
        r2.close()     // Catch:{ IOException -> 0x007b }
        goto L_0x007c
    L_0x007c:
        if (r0 == 0) goto L_0x007f
        goto L_0x006d
    L_0x007f:
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0872i.m979c(boolean):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0093, code lost:
            if (android.text.TextUtils.equals(r3, r9) == false) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ee, code lost:
            if (android.text.TextUtils.equals(r6, r9) != false) goto L_0x00f6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0112  */
    /* renamed from: d */
    public static java.util.Map<java.lang.String, java.lang.String> m980d(android.content.Context r9) {
        /*
        java.util.HashMap r0 = new java.util.HashMap
        r0.<init>()
        r1 = 0
        java.lang.String r2 = "PhoneInfoFetcher"
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0031 }
        r3.<init>()     // Catch:{ all -> 0x0031 }
        java.lang.String r4 = "android api: "
        r3.append(r4)     // Catch:{ all -> 0x0031 }
        int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0031 }
        r3.append(r4)     // Catch:{ all -> 0x0031 }
        java.lang.String r4 = "\n"
        r3.append(r4)     // Catch:{ all -> 0x0031 }
        java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0031 }
        btmsdkobf.C0848ff.m907i(r2, r3)     // Catch:{ all -> 0x0031 }
        java.lang.String r2 = "phone"
        java.lang.Object r9 = r9.getSystemService(r2)     // Catch:{ all -> 0x0031 }
        android.telephony.TelephonyManager r9 = (android.telephony.TelephonyManager) r9     // Catch:{ all -> 0x0031 }
        int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0031 }
        r3 = 21
        if (r2 >= r3) goto L_0x0035
    L_0x0031:
        r2 = r1
        r6 = r2
        goto L_0x00f6
    L_0x0035:
        int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0031 }
        r3 = 26
        r4 = 0
        r5 = 1
        if (r2 >= r3) goto L_0x009a
        java.lang.Class r2 = r9.getClass()     // Catch:{ all -> 0x0031 }
        java.lang.String r3 = "getDeviceId"
        java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch:{ all -> 0x0031 }
        java.lang.Class r7 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0031 }
        r6[r4] = r7     // Catch:{ all -> 0x0031 }
        java.lang.reflect.Method r2 = r2.getMethod(r3, r6)     // Catch:{ all -> 0x0031 }
        r2.setAccessible(r5)     // Catch:{ all -> 0x0031 }
        java.lang.Object[] r3 = new java.lang.Object[r5]     // Catch:{ all -> 0x0031 }
        java.lang.Integer r6 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0031 }
        r3[r4] = r6     // Catch:{ all -> 0x0031 }
        java.lang.Object r3 = r2.invoke(r9, r3)     // Catch:{ all -> 0x0031 }
        java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0031 }
        boolean r6 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0031 }
        r7 = 14
        if (r6 != 0) goto L_0x0071
        int r6 = r3.length()     // Catch:{ all -> 0x0031 }
        if (r6 != r7) goto L_0x006f
        r6 = r3
        r3 = r1
        goto L_0x0073
    L_0x006f:
        r6 = r1
        goto L_0x0073
    L_0x0071:
        r3 = r1
        r6 = r3
    L_0x0073:
        java.lang.Object[] r8 = new java.lang.Object[r5]     // Catch:{ all -> 0x0095 }
        java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0095 }
        r8[r4] = r5     // Catch:{ all -> 0x0095 }
        java.lang.Object r9 = r2.invoke(r9, r8)     // Catch:{ all -> 0x0095 }
        java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x0095 }
        boolean r2 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x0095 }
        if (r2 != 0) goto L_0x008e
        int r2 = r9.length()     // Catch:{ all -> 0x0095 }
        if (r2 != r7) goto L_0x008f
        r6 = r9
    L_0x008e:
        r9 = r1
    L_0x008f:
        boolean r2 = android.text.TextUtils.equals(r3, r9)     // Catch:{ all -> 0x0098 }
        if (r2 == 0) goto L_0x0098
    L_0x0095:
        r2 = r6
        r6 = r3
        goto L_0x00f6
    L_0x0098:
        r1 = r9
        goto L_0x0095
    L_0x009a:
        java.lang.Class r2 = r9.getClass()     // Catch:{ all -> 0x0031 }
        java.lang.String r3 = "getMeid"
        java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch:{ all -> 0x0031 }
        java.lang.Class r7 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0031 }
        r6[r4] = r7     // Catch:{ all -> 0x0031 }
        java.lang.reflect.Method r2 = r2.getMethod(r3, r6)     // Catch:{ all -> 0x0031 }
        r2.setAccessible(r5)     // Catch:{ all -> 0x0031 }
        java.lang.Object[] r3 = new java.lang.Object[r5]     // Catch:{ all -> 0x0031 }
        java.lang.Integer r6 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0031 }
        r3[r4] = r6     // Catch:{ all -> 0x0031 }
        java.lang.Object r2 = r2.invoke(r9, r3)     // Catch:{ all -> 0x0031 }
        java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0031 }
        java.lang.Class r3 = r9.getClass()     // Catch:{ all -> 0x00f5 }
        java.lang.String r6 = "getImei"
        java.lang.Class[] r7 = new java.lang.Class[r5]     // Catch:{ all -> 0x00f5 }
        java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ all -> 0x00f5 }
        r7[r4] = r8     // Catch:{ all -> 0x00f5 }
        java.lang.reflect.Method r3 = r3.getMethod(r6, r7)     // Catch:{ all -> 0x00f5 }
        r3.setAccessible(r5)     // Catch:{ all -> 0x00f5 }
        java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ all -> 0x00f5 }
        java.lang.Integer r7 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x00f5 }
        r6[r4] = r7     // Catch:{ all -> 0x00f5 }
        java.lang.Object r6 = r3.invoke(r9, r6)     // Catch:{ all -> 0x00f5 }
        java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x00f5 }
        java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch:{ all -> 0x00f3 }
        java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x00f3 }
        r7[r4] = r5     // Catch:{ all -> 0x00f3 }
        java.lang.Object r9 = r3.invoke(r9, r7)     // Catch:{ all -> 0x00f3 }
        java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x00f3 }
        boolean r3 = android.text.TextUtils.equals(r6, r9)     // Catch:{ all -> 0x00f1 }
        if (r3 == 0) goto L_0x00f1
        goto L_0x00f6
    L_0x00f1:
        r1 = r9
        goto L_0x00f6
        goto L_0x00f6
    L_0x00f5:
        r6 = r1
    L_0x00f6:
        boolean r9 = android.text.TextUtils.isEmpty(r2)
        if (r9 != 0) goto L_0x0101
        java.lang.String r9 = "meid"
        r0.put(r9, r2)
    L_0x0101:
        boolean r9 = android.text.TextUtils.isEmpty(r6)
        if (r9 != 0) goto L_0x010c
        java.lang.String r9 = "imei1"
        r0.put(r9, r6)
    L_0x010c:
        boolean r9 = android.text.TextUtils.isEmpty(r1)
        if (r9 != 0) goto L_0x0117
        java.lang.String r9 = "imei2"
        r0.put(r9, r1)
    L_0x0117:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0872i.m980d(android.content.Context):java.util.Map");
    }

    /* renamed from: e */
    public static String m981e(Context context) {
        try {
            return Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: e */
    public static String m982e(String str) {
        String str2;
        try {
            str2 = (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class}).invoke(null, new Object[]{str});
        } catch (Throwable unused) {
            str2 = null;
        }
        return str2 == null ? "" : str2;
    }

    /* renamed from: f */
    public static int m983f(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /* renamed from: g */
    public static int m984g(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    /* renamed from: p */
    public static String m985p() {
        StringBuilder sb = new StringBuilder();
        try {
            InputStream inputStream = new ProcessBuilder(new String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"}).start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                sb.append(new String(bArr));
            }
            inputStream.close();
        } catch (IOException unused) {
            sb = new StringBuilder("N/A");
        }
        return sb.toString().trim();
    }

    /* renamed from: q */
    public static int m986q() {
        if (f1035p == null) {
            try {
                File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new FileFilter() {
                    public boolean accept(File file) {
                        return Pattern.matches("cpu[0-9]", file.getName());
                    }
                });
                if (listFiles == null) {
                    return 1;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("CPU Count: ");
                sb.append(listFiles.length);
                C0848ff.m905d("PhoneInfoFetcher", sb.toString());
                f1035p = Integer.valueOf(listFiles.length);
            } catch (Throwable unused) {
                return 1;
            }
        }
        return f1035p.intValue();
    }

    /* renamed from: r */
    public static String m987r() {
        return m976b(true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004a, code lost:
            if (r2 != null) goto L_0x0039;
     */
    /* renamed from: s */
    public static long m988s() {
        /*
        long r0 = f1036q
        r2 = -1
        int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
        if (r4 != 0) goto L_0x004d
        java.io.File r0 = new java.io.File
        java.lang.String r1 = "/proc/meminfo"
        r0.<init>(r1)
        r1 = 0
        boolean r2 = r0.exists()
        if (r2 == 0) goto L_0x004d
        java.io.DataInputStream r2 = new java.io.DataInputStream     // Catch:{ all -> 0x0049 }
        java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ all -> 0x0049 }
        r3.<init>(r0)     // Catch:{ all -> 0x0049 }
        r2.<init>(r3)     // Catch:{ all -> 0x0049 }
        java.lang.String r0 = r2.readLine()     // Catch:{ all -> 0x0047 }
        if (r0 == 0) goto L_0x003f
        java.lang.String r0 = r0.trim()     // Catch:{ all -> 0x0047 }
        java.lang.String r1 = "[\\s]+"
        java.lang.String[] r0 = r0.split(r1)     // Catch:{ all -> 0x0047 }
        r1 = 1
        r0 = r0[r1]     // Catch:{ all -> 0x0047 }
        long r0 = java.lang.Long.parseLong(r0)     // Catch:{ all -> 0x0047 }
        f1036q = r0     // Catch:{ all -> 0x0047 }
    L_0x0039:
        r2.close()     // Catch:{ IOException -> 0x003d }
        goto L_0x004d
        goto L_0x004d
    L_0x003f:
        java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0047 }
        java.lang.String r1 = "/proc/meminfo is empty!"
        r0.<init>(r1)     // Catch:{ all -> 0x0047 }
        throw r0     // Catch:{ all -> 0x0047 }
        goto L_0x004a
    L_0x0049:
        r2 = r1
    L_0x004a:
        if (r2 == 0) goto L_0x004d
        goto L_0x0039
    L_0x004d:
        long r0 = f1036q
        r2 = 0
        int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
        if (r4 <= 0) goto L_0x0056
        goto L_0x0058
    L_0x0056:
        r0 = 1
    L_0x0058:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0872i.m988s():long");
    }

    /* renamed from: t */
    public static long m989t() {
        StatFs statFs = new StatFs(Environment.getRootDirectory().getPath());
        return (((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount())) + m990u();
    }

    /* renamed from: u */
    public static long m990u() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
    }
}
