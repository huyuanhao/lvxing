package com.bytedance.sdk.openadsdk.core.widget.webview.p179a;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.p170d.TempPkgModel;
import com.bytedance.sdk.openadsdk.core.p170d.TempPkgModel.C2228a;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.DigestUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: Version */
/* renamed from: com.bytedance.sdk.openadsdk.core.widget.webview.a.f */
public class C2373f {
    /* renamed from: a */
    private static TempPkgModel f8413a;

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0081 A[SYNTHETIC, Splitter:B:27:0x0081] */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    public static void m10913a() {
        /*
        java.lang.String r0 = "Version"
        r1 = 0
        java.io.File r2 = com.bytedance.sdk.openadsdk.core.widget.webview.p179a.TemplateManager.m10879e()     // Catch:{ all -> 0x0077 }
        java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0077 }
        java.lang.String r4 = "temp_pkg_info.json"
        r3.<init>(r2, r4)     // Catch:{ all -> 0x0077 }
        long r4 = r3.length()     // Catch:{ all -> 0x0077 }
        java.lang.Long r2 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0077 }
        long r4 = r2.longValue()     // Catch:{ all -> 0x0077 }
        r6 = 0
        int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
        if (r8 <= 0) goto L_0x006c
        boolean r4 = r3.exists()     // Catch:{ all -> 0x0077 }
        if (r4 == 0) goto L_0x006c
        boolean r4 = r3.isFile()     // Catch:{ all -> 0x0077 }
        if (r4 == 0) goto L_0x006c
        int r2 = r2.intValue()     // Catch:{ all -> 0x0077 }
        byte[] r2 = new byte[r2]     // Catch:{ all -> 0x0077 }
        java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ all -> 0x0077 }
        r4.<init>(r3)     // Catch:{ all -> 0x0077 }
        r4.read(r2)     // Catch:{ all -> 0x006a }
        java.lang.String r1 = new java.lang.String     // Catch:{ all -> 0x006a }
        java.lang.String r3 = "utf-8"
        r1.<init>(r2, r3)     // Catch:{ all -> 0x006a }
        org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x006a }
        r2.<init>(r1)     // Catch:{ all -> 0x006a }
        com.bytedance.sdk.openadsdk.core.d.o r1 = com.bytedance.sdk.openadsdk.core.p170d.TempPkgModel.m9469a(r2)     // Catch:{ all -> 0x006a }
        if (r1 == 0) goto L_0x0068
        f8413a = r1     // Catch:{ all -> 0x006a }
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x006a }
        r1.<init>()     // Catch:{ all -> 0x006a }
        java.lang.String r2 = "old version read success: "
        r1.append(r2)     // Catch:{ all -> 0x006a }
        com.bytedance.sdk.openadsdk.core.d.o r2 = f8413a     // Catch:{ all -> 0x006a }
        java.lang.String r2 = r2.mo15553b()     // Catch:{ all -> 0x006a }
        r1.append(r2)     // Catch:{ all -> 0x006a }
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x006a }
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r0, r1)     // Catch:{ all -> 0x006a }
    L_0x0068:
        r1 = r4
        goto L_0x0071
    L_0x006a:
        r1 = move-exception
        goto L_0x007a
    L_0x006c:
        java.lang.String r2 = "version pkg json file does not exist"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r0, r2)     // Catch:{ all -> 0x0077 }
    L_0x0071:
        if (r1 == 0) goto L_0x0084
        r1.close()     // Catch:{ IOException -> 0x0084 }
        goto L_0x0084
    L_0x0077:
        r2 = move-exception
        r4 = r1
        r1 = r2
    L_0x007a:
        java.lang.String r2 = "version init error"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12223c(r0, r2, r1)     // Catch:{ all -> 0x0085 }
        if (r4 == 0) goto L_0x0084
        r4.close()     // Catch:{ IOException -> 0x0084 }
    L_0x0084:
        return
    L_0x0085:
        r0 = move-exception
        if (r4 == 0) goto L_0x008b
        r4.close()     // Catch:{ IOException -> 0x008b }
    L_0x008b:
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.widget.webview.p179a.C2373f.m10913a():void");
    }

    /* renamed from: b */
    public static synchronized TempPkgModel m10915b() {
        TempPkgModel oVar;
        synchronized (C2373f.class) {
            oVar = f8413a;
        }
        return oVar;
    }

    /* renamed from: a */
    public static synchronized void m10914a(TempPkgModel oVar) {
        synchronized (C2373f.class) {
            if (oVar != null) {
                if (oVar.mo15558e()) {
                    f8413a = oVar;
                }
            }
        }
    }

    /* renamed from: c */
    public static void m10917c() {
        FileOutputStream fileOutputStream;
        TempPkgModel oVar = f8413a;
        String str = "Version";
        if (oVar == null) {
            C2564t.m12220b(str, "version save error1");
            return;
        }
        String f = oVar.mo15559f();
        if (TextUtils.isEmpty(f)) {
            C2564t.m12220b(str, "version save error2");
            return;
        }
        File file = new File(TemplateManager.m10879e(), "temp_pkg_info.json");
        StringBuilder sb = new StringBuilder();
        sb.append(file);
        sb.append(".tmp");
        File file2 = new File(sb.toString());
        if (file2.exists()) {
            file2.delete();
        }
        try {
            fileOutputStream = new FileOutputStream(file2);
            try {
                fileOutputStream.write(f.getBytes("utf-8"));
                if (file.exists()) {
                    file.delete();
                }
                file2.renameTo(file);
            } catch (Throwable th) {
                th = th;
                try {
                    C2564t.m12223c(str, "version save error3", th);
                } finally {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            C2564t.m12223c(str, "version save error3", th);
        }
        try {
            fileOutputStream.close();
        } catch (IOException unused2) {
        }
    }

    /* renamed from: a */
    public static C2228a m10912a(String str) {
        if (!TextUtils.isEmpty(str) && m10915b() != null && m10915b().mo15557d() != null && m10915b().mo15558e()) {
            for (C2228a aVar : m10915b().mo15557d()) {
                if (aVar.mo15560a() != null && aVar.mo15560a().equals(str)) {
                    return aVar;
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    public static boolean m10916b(String str) {
        String str2 = "\\.";
        boolean z = false;
        try {
            if (m10915b() != null) {
                if (!TextUtils.isEmpty(m10915b().mo15553b())) {
                    if (TextUtils.isEmpty(str)) {
                        return false;
                    }
                    String b = m10915b().mo15553b();
                    String[] split = str.split(str2);
                    String[] split2 = b.split(str2);
                    int min = Math.min(split.length, split2.length);
                    int i = 0;
                    while (i < min) {
                        int length = split[i].length() - split2[i].length();
                        if (length == 0) {
                            int compareTo = split[i].compareTo(split2[i]);
                            if (compareTo > 0) {
                                return true;
                            }
                            if (compareTo < 0) {
                                return false;
                            }
                            if (i == min - 1) {
                                if (split.length > split2.length) {
                                    z = true;
                                }
                                return z;
                            }
                            i++;
                        } else {
                            if (length > 0) {
                                z = true;
                            }
                            return z;
                        }
                    }
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
        }
    }

    /* renamed from: d */
    public static void m10918d() {
        TempPkgModel b = m10915b();
        if (b != null) {
            File e = TemplateManager.m10879e();
            try {
                new File(e, "temp_pkg_info.json").delete();
            } catch (Throwable unused) {
            }
            if (b.mo15557d() != null) {
                for (C2228a a : b.mo15557d()) {
                    try {
                        new File(e, DigestUtils.m12169a(a.mo15560a())).delete();
                    } catch (Throwable unused2) {
                    }
                }
            }
            f8413a = null;
        }
    }
}
