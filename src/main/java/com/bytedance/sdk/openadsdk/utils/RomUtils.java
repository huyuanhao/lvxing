package com.bytedance.sdk.openadsdk.utils;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.multipro.MultiGlobalInfo;
import com.bytedance.sdk.openadsdk.multipro.p205d.SPMultiHelper;
import java.util.concurrent.Callable;

/* renamed from: com.bytedance.sdk.openadsdk.utils.ac */
public class RomUtils {
    /* renamed from: a */
    public static boolean f9111a = false;
    /* renamed from: b */
    public static boolean f9112b = false;
    /* renamed from: c */
    private static final CharSequence f9113c = "sony";
    /* renamed from: d */
    private static final CharSequence f9114d = "amigo";
    /* renamed from: e */
    private static final CharSequence f9115e = "funtouch";

    /* compiled from: RomUtils */
    /* renamed from: com.bytedance.sdk.openadsdk.utils.ac$a */
    public static class C2531a implements Callable<String> {
        /* renamed from: a */
        private String f9117a;

        public C2531a(String str) {
            this.f9117a = str;
        }

        /* renamed from: a */
        public String call() throws Exception {
            long currentTimeMillis = System.currentTimeMillis();
            String b = RomUtils.m11948c(this.f9117a);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            StringBuilder sb = new StringBuilder();
            sb.append("property:");
            sb.append(b);
            sb.append(",getSystemProperty use time :");
            sb.append(currentTimeMillis2);
            String str = "RomUtils";
            C2564t.m12220b(str, sb.toString());
            if (!TextUtils.isEmpty(b)) {
                try {
                    String str2 = "rom_property_info";
                    String str3 = "rom_info";
                    if (MultiGlobalInfo.m11808b()) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("SPMultiHelper-getPropertyFromSPMultiHelper:");
                        sb2.append(b);
                        C2564t.m12225d(str, sb2.toString());
                        SPMultiHelper.m11874a(str3, str2, b);
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("SP-getPropertyFromSP:");
                        sb3.append(b);
                        C2564t.m12225d(str, sb3.toString());
                        SPUtils.m11969a(str3, InternalContainer.m10059a()).mo16911a(str2, b);
                    }
                } catch (Throwable unused) {
                }
            }
            return b;
        }
    }

    /* renamed from: a */
    public static String m11943a() {
        if (m11961o()) {
            return m11962p();
        }
        if (m11951e()) {
            return m11958l();
        }
        if (m11946b()) {
            return m11963q();
        }
        if (m11964r()) {
            return m11965s();
        }
        String m = m11959m();
        if (!TextUtils.isEmpty(m)) {
            return m;
        }
        if (m11953g()) {
            return m11952f();
        }
        if (m11954h()) {
            return m11955i();
        }
        if (m11950d()) {
            return m11947c();
        }
        String j = m11956j();
        if (!TextUtils.isEmpty(j)) {
            return j;
        }
        return Build.DISPLAY;
    }

    /* renamed from: b */
    public static boolean m11946b() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    /* renamed from: c */
    public static String m11947c() {
        StringBuilder sb = new StringBuilder();
        sb.append(m11949d("ro.build.uiversion"));
        sb.append("_");
        sb.append(Build.DISPLAY);
        return sb.toString();
    }

    /* renamed from: d */
    public static boolean m11950d() {
        StringBuilder sb = new StringBuilder();
        sb.append(Build.MANUFACTURER);
        sb.append(Build.BRAND);
        String sb2 = sb.toString();
        boolean z = false;
        if (TextUtils.isEmpty(sb2)) {
            return false;
        }
        String lowerCase = sb2.toLowerCase();
        if (lowerCase.contains("360") || lowerCase.contains("qiku")) {
            z = true;
        }
        return z;
    }

    /* renamed from: e */
    public static boolean m11951e() {
        if (!f9112b) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    f9111a = true;
                    f9112b = true;
                    return f9111a;
                }
            } catch (Exception unused) {
            }
            f9112b = true;
        }
        return f9111a;
    }

    /* renamed from: f */
    public static String m11952f() {
        StringBuilder sb = new StringBuilder();
        sb.append(m11949d("ro.vivo.os.build.display.id"));
        sb.append("_");
        sb.append(m11949d("ro.vivo.product.version"));
        return sb.toString();
    }

    /* renamed from: g */
    public static boolean m11953g() {
        String d = m11949d("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(d) && d.toLowerCase().contains(f9115e);
    }

    /* renamed from: h */
    public static boolean m11954h() {
        return !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase().contains(f9114d);
    }

    /* renamed from: i */
    public static String m11955i() {
        StringBuilder sb = new StringBuilder();
        sb.append(Build.DISPLAY);
        sb.append("_");
        sb.append(m11949d("ro.gn.sv.version"));
        return sb.toString();
    }

    /* renamed from: j */
    public static String m11956j() {
        if (!m11957k()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("eui_");
        sb.append(m11949d("ro.letv.release.version"));
        sb.append("_");
        sb.append(Build.DISPLAY);
        return sb.toString();
    }

    /* renamed from: k */
    public static boolean m11957k() {
        return !TextUtils.isEmpty(m11949d("ro.letv.release.version"));
    }

    /* renamed from: l */
    public static String m11958l() {
        if (!m11951e()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("miui_");
        sb.append(m11949d("ro.miui.ui.version.name"));
        sb.append("_");
        sb.append(VERSION.INCREMENTAL);
        return sb.toString();
    }

    /* renamed from: m */
    public static String m11959m() {
        String n = m11960n();
        if (n == null || !n.toLowerCase().contains("emotionui")) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(n);
        sb.append("_");
        sb.append(Build.DISPLAY);
        return sb.toString();
    }

    /* renamed from: n */
    public static String m11960n() {
        return m11949d("ro.build.version.emui");
    }

    /* renamed from: o */
    public static boolean m11961o() {
        String str = "smartisan";
        return str.equalsIgnoreCase(Build.MANUFACTURER) || str.equalsIgnoreCase(Build.BRAND);
    }

    /* renamed from: p */
    public static String m11962p() {
        if (m11961o()) {
            try {
                String d = m11949d("ro.smartisan.version");
                StringBuilder sb = new StringBuilder();
                sb.append("smartisan_");
                sb.append(d);
                return sb.toString();
            } catch (Throwable unused) {
            }
        }
        return Build.DISPLAY;
    }

    /* renamed from: q */
    public static String m11963q() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains("flyme")) ? "" : str;
    }

    /* renamed from: r */
    public static boolean m11964r() {
        String str = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains("oppo");
    }

    /* renamed from: s */
    public static String m11965s() {
        if (!m11964r()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("coloros_");
        sb.append(m11949d("ro.build.version.opporom"));
        sb.append("_");
        sb.append(Build.DISPLAY);
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0015, code lost:
            if (android.os.Build.BRAND.toLowerCase().startsWith(r2) == false) goto L_0x0017;
     */
    /* renamed from: t */
    public static boolean m11966t() {
        /*
        r0 = 0
        java.lang.String r1 = android.os.Build.BRAND     // Catch:{ all -> 0x002c }
        boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x002c }
        java.lang.String r2 = "huawei"
        if (r1 != 0) goto L_0x0017
        java.lang.String r1 = android.os.Build.BRAND     // Catch:{ all -> 0x002c }
        java.lang.String r1 = r1.toLowerCase()     // Catch:{ all -> 0x002c }
        boolean r1 = r1.startsWith(r2)     // Catch:{ all -> 0x002c }
        if (r1 != 0) goto L_0x002b
    L_0x0017:
        java.lang.String r1 = android.os.Build.MANUFACTURER     // Catch:{ all -> 0x002c }
        boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x002c }
        if (r1 != 0) goto L_0x002c
        java.lang.String r1 = android.os.Build.MANUFACTURER     // Catch:{ all -> 0x002c }
        java.lang.String r1 = r1.toLowerCase()     // Catch:{ all -> 0x002c }
        boolean r1 = r1.startsWith(r2)     // Catch:{ all -> 0x002c }
        if (r1 == 0) goto L_0x002c
    L_0x002b:
        r0 = 1
    L_0x002c:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.RomUtils.m11966t():boolean");
    }

    /* renamed from: a */
    public static boolean m11944a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = m11960n();
        }
        return (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("emotionui")) || m11966t();
    }

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r5v0, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r3v2, types: [java.lang.Process] */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r5v1 */
    /* JADX WARNING: type inference failed for: r3v4, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r4v3, types: [java.lang.Process] */
    /* JADX WARNING: type inference failed for: r5v5 */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r5v6 */
    /* JADX WARNING: type inference failed for: r5v7, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: type inference failed for: r3v9 */
    /* JADX WARNING: type inference failed for: r5v8 */
    /* JADX WARNING: type inference failed for: r5v9 */
    /* access modifiers changed from: private|static */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0044, code lost:
            r5 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0047, code lost:
            r4 = th;
            r3 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
            r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0062, code lost:
            r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0063, code lost:
            com.bytedance.sdk.openadsdk.utils.C2564t.m12223c(r1, r0, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
            r5.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r5v5
  assigns: []
  uses: []
	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:231)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:95)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:88)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:30)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
	at jadx.core.ProcessClass.process(ProcessClass.java:35)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0047 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x0007] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005e A[SYNTHETIC, Splitter:B:21:0x005e] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0072 A[SYNTHETIC, Splitter:B:34:0x0072] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x007e A[SYNTHETIC, Splitter:B:41:0x007e] */
    /* JADX WARNING: Unknown variable types count: 7 */
    /* renamed from: c */
    public static java.lang.String m11948c(java.lang.String r8) {
        /*
        java.lang.String r0 = "Exception while closing InputStream"
        java.lang.String r1 = "ToolUtils"
        java.lang.String r2 = ""
        r3 = 0
        java.lang.Runtime r4 = java.lang.Runtime.getRuntime()     // Catch:{ IllegalThreadStateException -> 0x0069, all -> 0x0047 }
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IllegalThreadStateException -> 0x0069, all -> 0x0047 }
        r5.<init>()     // Catch:{ IllegalThreadStateException -> 0x0069, all -> 0x0047 }
        java.lang.String r6 = "getprop "
        r5.append(r6)     // Catch:{ IllegalThreadStateException -> 0x0069, all -> 0x0047 }
        r5.append(r8)     // Catch:{ IllegalThreadStateException -> 0x0069, all -> 0x0047 }
        java.lang.String r5 = r5.toString()     // Catch:{ IllegalThreadStateException -> 0x0069, all -> 0x0047 }
        java.lang.Process r4 = r4.exec(r5)     // Catch:{ IllegalThreadStateException -> 0x0069, all -> 0x0047 }
        java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ IllegalThreadStateException -> 0x0044, all -> 0x0047 }
        java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ IllegalThreadStateException -> 0x0044, all -> 0x0047 }
        java.io.InputStream r7 = r4.getInputStream()     // Catch:{ IllegalThreadStateException -> 0x0044, all -> 0x0047 }
        r6.<init>(r7)     // Catch:{ IllegalThreadStateException -> 0x0044, all -> 0x0047 }
        r7 = 1024(0x400, float:1.435E-42)
        r5.<init>(r6, r7)     // Catch:{ IllegalThreadStateException -> 0x0044, all -> 0x0047 }
        java.lang.String r2 = r5.readLine()     // Catch:{ IllegalThreadStateException -> 0x0045, all -> 0x0040 }
        r4.exitValue()     // Catch:{ IllegalThreadStateException -> 0x0045, all -> 0x0040 }
        r5.close()     // Catch:{ IOException -> 0x003b }
        goto L_0x0081
    L_0x003b:
        r8 = move-exception
        com.bytedance.sdk.openadsdk.utils.C2564t.m12223c(r1, r0, r8)
        goto L_0x0081
    L_0x0040:
        r3 = move-exception
        r4 = r3
        r3 = r5
        goto L_0x0048
    L_0x0044:
        r5 = r3
    L_0x0045:
        r3 = r4
        goto L_0x006a
    L_0x0047:
        r4 = move-exception
    L_0x0048:
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0067 }
        r5.<init>()     // Catch:{ all -> 0x0067 }
        java.lang.String r6 = "Unable to read sysprop "
        r5.append(r6)     // Catch:{ all -> 0x0067 }
        r5.append(r8)     // Catch:{ all -> 0x0067 }
        java.lang.String r8 = r5.toString()     // Catch:{ all -> 0x0067 }
        com.bytedance.sdk.openadsdk.utils.C2564t.m12223c(r1, r8, r4)     // Catch:{ all -> 0x0067 }
        if (r3 == 0) goto L_0x0066
        r3.close()     // Catch:{ IOException -> 0x0062 }
        goto L_0x0066
    L_0x0062:
        r8 = move-exception
        com.bytedance.sdk.openadsdk.utils.C2564t.m12223c(r1, r0, r8)
    L_0x0066:
        return r2
    L_0x0067:
        r8 = move-exception
        goto L_0x0070
    L_0x0069:
        r5 = r3
    L_0x006a:
        r3.destroy()     // Catch:{ Exception -> 0x007b, all -> 0x006e }
        goto L_0x007c
    L_0x006e:
        r8 = move-exception
        r3 = r5
    L_0x0070:
        if (r3 == 0) goto L_0x007a
        r3.close()     // Catch:{ IOException -> 0x0076 }
        goto L_0x007a
    L_0x0076:
        r2 = move-exception
        com.bytedance.sdk.openadsdk.utils.C2564t.m12223c(r1, r0, r2)
    L_0x007a:
        throw r8
    L_0x007c:
        if (r5 == 0) goto L_0x0081
        r5.close()     // Catch:{ IOException -> 0x003b }
    L_0x0081:
        return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.RomUtils.m11948c(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0035 A[RETURN] */
    /* renamed from: d */
    private static java.lang.String m11949d(java.lang.String r5) {
        /*
        java.lang.String r0 = ""
        java.lang.String r1 = m11967u()     // Catch:{ all -> 0x0031 }
        boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x002f }
        if (r2 == 0) goto L_0x002f
        com.bytedance.sdk.openadsdk.utils.ac$a r2 = new com.bytedance.sdk.openadsdk.utils.ac$a     // Catch:{ all -> 0x002f }
        r2.m44207init(r5)     // Catch:{ all -> 0x002f }
        com.bytedance.sdk.openadsdk.i.b r5 = new com.bytedance.sdk.openadsdk.i.b     // Catch:{ all -> 0x002f }
        r3 = 5
        r4 = 2
        r5.m44129init(r2, r3, r4)     // Catch:{ all -> 0x002f }
        com.bytedance.sdk.openadsdk.i.a r2 = com.bytedance.sdk.openadsdk.p198i.TTExecutor.m11692a()     // Catch:{ all -> 0x002f }
        com.bytedance.sdk.openadsdk.utils.ac$1 r3 = new com.bytedance.sdk.openadsdk.utils.ac$1     // Catch:{ all -> 0x002f }
        r3.m44206init(r5)     // Catch:{ all -> 0x002f }
        r2.mo16806b(r3)     // Catch:{ all -> 0x002f }
        r2 = 1
        java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x002f }
        java.lang.Object r5 = r5.get(r2, r4)     // Catch:{ all -> 0x002f }
        java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x002f }
        goto L_0x0032
    L_0x002f:
        r5 = r1
        goto L_0x0032
    L_0x0031:
        r5 = r0
    L_0x0032:
        if (r5 != 0) goto L_0x0035
        return r0
    L_0x0035:
        return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.RomUtils.m11949d(java.lang.String):java.lang.String");
    }

    /* renamed from: u */
    private static String m11967u() {
        String str = "";
        try {
            String str2 = "RomUtils";
            String str3 = "rom_property_info";
            String str4 = "rom_info";
            if (MultiGlobalInfo.m11808b()) {
                String b = SPMultiHelper.m11880b(str4, str3, str);
                StringBuilder sb = new StringBuilder();
                sb.append("get Property From SPMultiHelper...");
                sb.append(b);
                C2564t.m12222c(str2, sb.toString());
                return b;
            }
            String b2 = SPUtils.m11969a(str4, InternalContainer.m10059a()).mo16915b(str3, str);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("get Property From SP...=");
            sb2.append(b2);
            C2564t.m12222c(str2, sb2.toString());
            return b2;
        } catch (Throwable unused) {
            return str;
        }
    }
}
