package com.pgl.sys.ces.p365a;

import com.tencent.android.tpush.common.MessageKey;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* renamed from: com.pgl.sys.ces.a.b */
public class C4797b {
    /* renamed from: a */
    private static final FileFilter f15445a = new FileFilter() {
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    };

    /* renamed from: a */
    public static String m19638a() {
        JSONObject jSONObject = new JSONObject();
        try {
            HashMap b = m19641b();
            jSONObject.put("core", m19642c());
            jSONObject.put("hw", m19640a(b, "Hardware"));
            jSONObject.put("max", m19639a("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"));
            jSONObject.put(MessageKey.MSG_ACCEPT_TIME_MIN, m19639a("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq"));
            jSONObject.put("ft", m19640a(b, "Features"));
        } catch (Throwable unused) {
        }
        String jSONObject2 = jSONObject.toString();
        return jSONObject2 == null ? "{}" : jSONObject2.trim();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0025, code lost:
            if (r1 == null) goto L_0x0028;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0020 A[SYNTHETIC, Splitter:B:18:0x0020] */
    /* renamed from: a */
    private static java.lang.String m19639a(java.lang.String r2) {
        /*
        r0 = 0
        java.io.FileReader r1 = new java.io.FileReader     // Catch:{ all -> 0x001c }
        r1.<init>(r2)     // Catch:{ all -> 0x001c }
        java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x001a }
        r2.<init>(r1)     // Catch:{ all -> 0x001a }
        java.lang.String r0 = r2.readLine()     // Catch:{ all -> 0x0018 }
        r2.close()     // Catch:{ all -> 0x0012 }
    L_0x0012:
        r1.close()     // Catch:{ all -> 0x0016 }
        goto L_0x0028
        goto L_0x0028
        goto L_0x001e
    L_0x001a:
        r2 = r0
        goto L_0x001e
    L_0x001c:
        r2 = r0
        r1 = r2
    L_0x001e:
        if (r2 == 0) goto L_0x0025
        r2.close()     // Catch:{ all -> 0x0024 }
        goto L_0x0025
    L_0x0025:
        if (r1 == 0) goto L_0x0028
        goto L_0x0012
    L_0x0028:
        if (r0 != 0) goto L_0x002d
        java.lang.String r2 = "0"
        goto L_0x0031
    L_0x002d:
        java.lang.String r2 = r0.trim()
    L_0x0031:
        return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pgl.sys.ces.p365a.C4797b.m19639a(java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    private static String m19640a(HashMap<String, String> hashMap, String str) {
        String str2;
        try {
            str2 = (String) hashMap.get(str);
        } catch (Throwable unused) {
            str2 = null;
        }
        return str2 == null ? "" : str2.trim();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:8|9|10|11|32) */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0050, code lost:
            if (r2 == null) goto L_0x0053;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001b */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x004b A[SYNTHETIC, Splitter:B:28:0x004b] */
    /* renamed from: b */
    private static java.util.HashMap<java.lang.String, java.lang.String> m19641b() {
        /*
        java.util.HashMap r0 = new java.util.HashMap
        r0.<init>()
        r1 = 0
        java.io.FileReader r2 = new java.io.FileReader     // Catch:{ all -> 0x0047 }
        java.lang.String r3 = "/proc/cpuinfo"
        r2.<init>(r3)     // Catch:{ all -> 0x0047 }
        java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ all -> 0x0045 }
        r3.<init>(r2)     // Catch:{ all -> 0x0045 }
    L_0x0012:
        java.lang.String r1 = r3.readLine()     // Catch:{ all -> 0x0043 }
        if (r1 != 0) goto L_0x001f
        r3.close()     // Catch:{ all -> 0x001b }
    L_0x001b:
        r2.close()     // Catch:{ all -> 0x0053 }
        goto L_0x0053
    L_0x001f:
        java.lang.String r4 = ":"
        r5 = 2
        java.lang.String[] r1 = r1.split(r4, r5)     // Catch:{ all -> 0x0043 }
        int r4 = r1.length     // Catch:{ all -> 0x0043 }
        if (r4 >= r5) goto L_0x002a
        goto L_0x0012
    L_0x002a:
        r4 = 0
        r4 = r1[r4]     // Catch:{ all -> 0x0043 }
        java.lang.String r4 = r4.trim()     // Catch:{ all -> 0x0043 }
        r5 = 1
        r1 = r1[r5]     // Catch:{ all -> 0x0043 }
        java.lang.String r1 = r1.trim()     // Catch:{ all -> 0x0043 }
        java.lang.Object r5 = r0.get(r4)     // Catch:{ all -> 0x0043 }
        if (r5 == 0) goto L_0x003f
        goto L_0x0012
    L_0x003f:
        r0.put(r4, r1)     // Catch:{ all -> 0x0043 }
        goto L_0x0012
        goto L_0x0049
    L_0x0045:
        r3 = r1
        goto L_0x0049
    L_0x0047:
        r2 = r1
        r3 = r2
    L_0x0049:
        if (r3 == 0) goto L_0x0050
        r3.close()     // Catch:{ all -> 0x004f }
        goto L_0x0050
    L_0x0050:
        if (r2 == 0) goto L_0x0053
        goto L_0x001b
    L_0x0053:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pgl.sys.ces.p365a.C4797b.m19641b():java.util.HashMap");
    }

    /* renamed from: c */
    private static int m19642c() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(f15445a).length;
        } catch (Throwable unused) {
            return -1;
        }
    }
}
