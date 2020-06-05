package com.tencent.stat.common;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;

/* renamed from: com.tencent.stat.common.b */
public class C7595b {
    /* renamed from: a */
    private static StatLogger f25679a = StatCommonHelper.getLogger();

    /* renamed from: b */
    private static String m32755b(Context context, String str, String str2) {
        File dir = context.getDir(str, 0);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(dir.getAbsolutePath());
        sb.append("/");
        sb.append(str2);
        return sb.toString();
    }

    /* renamed from: a */
    public static void m32754a(Context context, String str, String str2, String str3) {
        FileOutputStream fileOutputStream;
        StatLogger statLogger = f25679a;
        StringBuilder sb = new StringBuilder();
        sb.append("enter writeFile fname:");
        sb.append(str2);
        statLogger.mo37101d(sb.toString());
        try {
            String b = m32755b(context, str, str2);
            fileOutputStream = new FileOutputStream(b);
            try {
                fileOutputStream.write(str3.getBytes());
                StatLogger statLogger2 = f25679a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("success writeFile fname:");
                sb2.append(b);
                sb2.append(",size:");
                sb2.append(str3.length());
                statLogger2.mo37101d(sb2.toString());
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            try {
                f25679a.mo37104e(th);
                StatCommonHelper.safeClose(fileOutputStream);
            } catch (Throwable th3) {
                StatCommonHelper.safeClose(fileOutputStream);
                throw th3;
            }
        }
        StatCommonHelper.safeClose(fileOutputStream);
    }

    /* renamed from: a */
    public static void m32753a(Context context, String str, String str2) {
        String b = m32755b(context, str, str2);
        new File(b).delete();
        StatLogger statLogger = f25679a;
        StringBuilder sb = new StringBuilder();
        sb.append("success deleteFile fname:");
        sb.append(b);
        statLogger.mo37101d(sb.toString());
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r2v0, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r3v1 */
    /* JADX WARNING: type inference failed for: r2v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r2v5, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r3v5, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r3v1
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
    /* JADX WARNING: Unknown variable types count: 6 */
    /* renamed from: a */
    public static java.lang.String m32752a(android.content.Context r5, java.lang.String r6) {
        /*
        com.tencent.stat.common.StatLogger r5 = f25679a
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r1 = "enter readFile fileFullPath:"
        r0.append(r1)
        r0.append(r6)
        java.lang.String r0 = r0.toString()
        r5.mo37101d(r0)
        r5 = 0
        java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ all -> 0x006d }
        r0.<init>(r6)     // Catch:{ all -> 0x006d }
        int r1 = r0.available()     // Catch:{ all -> 0x006a }
        byte[] r1 = new byte[r1]     // Catch:{ all -> 0x006a }
        java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x006a }
        r2.<init>()     // Catch:{ all -> 0x006a }
    L_0x0027:
        int r3 = r0.read(r1)     // Catch:{ all -> 0x0067 }
        r4 = -1
        if (r3 == r4) goto L_0x0032
        r2.write(r1)     // Catch:{ all -> 0x0067 }
        goto L_0x0027
    L_0x0032:
        byte[] r1 = r2.toByteArray()     // Catch:{ all -> 0x0067 }
        r2.close()     // Catch:{ all -> 0x0067 }
        java.lang.String r3 = new java.lang.String     // Catch:{ all -> 0x0067 }
        r3.<init>(r1)     // Catch:{ all -> 0x0067 }
        com.tencent.stat.common.StatLogger r5 = f25679a     // Catch:{ all -> 0x0065 }
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0065 }
        r1.<init>()     // Catch:{ all -> 0x0065 }
        java.lang.String r4 = "success readFile fname:"
        r1.append(r4)     // Catch:{ all -> 0x0065 }
        r1.append(r6)     // Catch:{ all -> 0x0065 }
        java.lang.String r6 = ",content length:"
        r1.append(r6)     // Catch:{ all -> 0x0065 }
        int r6 = r3.length()     // Catch:{ all -> 0x0065 }
        java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0065 }
        r1.append(r6)     // Catch:{ all -> 0x0065 }
        java.lang.String r6 = r1.toString()     // Catch:{ all -> 0x0065 }
        r5.mo37101d(r6)     // Catch:{ all -> 0x0065 }
        goto L_0x0076
    L_0x0065:
        r6 = move-exception
        goto L_0x0071
    L_0x0067:
        r6 = move-exception
        r3 = r5
        goto L_0x0071
    L_0x006a:
        r6 = move-exception
        r2 = r5
        goto L_0x0070
    L_0x006d:
        r6 = move-exception
        r0 = r5
        r2 = r0
    L_0x0070:
        r3 = r2
    L_0x0071:
        com.tencent.stat.common.StatLogger r5 = f25679a     // Catch:{ all -> 0x007d }
        r5.mo37104e(r6)     // Catch:{ all -> 0x007d }
    L_0x0076:
        com.tencent.stat.common.StatCommonHelper.safeClose(r0)
        com.tencent.stat.common.StatCommonHelper.safeClose(r2)
        return r3
    L_0x007d:
        r5 = move-exception
        com.tencent.stat.common.StatCommonHelper.safeClose(r0)
        com.tencent.stat.common.StatCommonHelper.safeClose(r2)
        throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.common.C7595b.m32752a(android.content.Context, java.lang.String):java.lang.String");
    }
}
