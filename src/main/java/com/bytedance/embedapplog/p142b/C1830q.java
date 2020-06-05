package com.bytedance.embedapplog.p142b;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.p605ep.commonbase.api.ConfigManager.OEM;
import org.json.JSONObject;

/* renamed from: com.bytedance.embedapplog.b.q */
class C1830q extends C1816c {
    C1830q() {
        super(true, false);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo13364a(JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder(16);
        if (m6420a()) {
            sb.append("MIUI-");
        } else if (m6422b()) {
            sb.append("FLYME-");
        } else {
            String d = m6424d();
            if (m6421a(d)) {
                sb.append("EMUI-");
            }
            if (!TextUtils.isEmpty(d)) {
                sb.append(d);
                sb.append("-");
            }
        }
        sb.append(VERSION.INCREMENTAL);
        jSONObject.put("rom", sb.toString());
        return true;
    }

    /* renamed from: a */
    private boolean m6420a() {
        try {
            if (Class.forName("miui.os.Build").getName().length() > 0) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: b */
    private boolean m6422b() {
        if (TextUtils.isEmpty(Build.DISPLAY) || !Build.DISPLAY.contains("Flyme")) {
            if (!"flyme".equals(Build.USER)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    private boolean m6423c() {
        boolean isEmpty = TextUtils.isEmpty(Build.BRAND);
        String str = OEM.HUAWEI;
        return (!isEmpty && Build.BRAND.toLowerCase().startsWith(str)) || (!TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase().startsWith(str));
    }

    /* renamed from: a */
    private boolean m6421a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = m6424d();
        }
        if (TextUtils.isEmpty(str) || !str.toLowerCase().startsWith("emotionui")) {
            return m6423c();
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002f A[SYNTHETIC, Splitter:B:15:0x002f] */
    /* renamed from: d */
    private java.lang.String m6424d() {
        /*
        r4 = this;
        r0 = 0
        java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ all -> 0x0028 }
        java.lang.String r2 = "getprop ro.build.version.emui"
        java.lang.Process r1 = r1.exec(r2)     // Catch:{ all -> 0x0028 }
        java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x0028 }
        java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x0028 }
        java.io.InputStream r1 = r1.getInputStream()     // Catch:{ all -> 0x0028 }
        r3.<init>(r1)     // Catch:{ all -> 0x0028 }
        r1 = 1024(0x400, float:1.435E-42)
        r2.<init>(r3, r1)     // Catch:{ all -> 0x0028 }
        java.lang.String r0 = r2.readLine()     // Catch:{ all -> 0x0026 }
        r2.close()     // Catch:{ all -> 0x0026 }
        r2.close()     // Catch:{ IOException -> 0x0025 }
    L_0x0025:
        return r0
    L_0x0026:
        r1 = move-exception
        goto L_0x002a
    L_0x0028:
        r1 = move-exception
        r2 = r0
    L_0x002a:
        com.bytedance.embedapplog.util.C1856h.m6582a(r1)     // Catch:{ all -> 0x0033 }
        if (r2 == 0) goto L_0x0032
        r2.close()     // Catch:{ IOException -> 0x0032 }
    L_0x0032:
        return r0
    L_0x0033:
        r0 = move-exception
        if (r2 == 0) goto L_0x0039
        r2.close()     // Catch:{ IOException -> 0x0039 }
    L_0x0039:
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.p142b.C1830q.m6424d():java.lang.String");
    }
}
