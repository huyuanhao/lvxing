package com.qiyukf.basesdk.p412c.p416c;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/* renamed from: com.qiyukf.basesdk.c.c.c */
public final class C5405c {
    /* renamed from: a */
    public static String m22113a(String str) {
        if (str == null || str.trim().length() <= 0) {
            return null;
        }
        try {
            return m22114a(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /* renamed from: a */
    private static String m22114a(byte[] bArr) {
        try {
            return C5401a.m22109a(MessageDigest.getInstance("MD5").digest(bArr));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.io.BufferedInputStream] */
    /* JADX WARNING: type inference failed for: r1v2, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r3v0, types: [java.io.BufferedInputStream] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r3v1 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r3v2, types: [java.io.BufferedInputStream] */
    /* JADX WARNING: type inference failed for: r1v5, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r1v4
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
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003f A[SYNTHETIC, Splitter:B:19:0x003f] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0047 A[SYNTHETIC, Splitter:B:25:0x0047] */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* renamed from: b */
    public static java.lang.String m22115b(java.lang.String r5) {
        /*
        r0 = 4096(0x1000, float:5.74E-42)
        byte[] r0 = new byte[r0]
        r1 = 0
        java.lang.String r2 = "MD5"
        java.security.MessageDigest r2 = java.security.MessageDigest.getInstance(r2)     // Catch:{ Exception -> 0x0038, all -> 0x0036 }
        java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0038, all -> 0x0036 }
        java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0038, all -> 0x0036 }
        r4.<init>(r5)     // Catch:{ Exception -> 0x0038, all -> 0x0036 }
        r3.<init>(r4)     // Catch:{ Exception -> 0x0038, all -> 0x0036 }
    L_0x0015:
        int r5 = r3.read(r0)     // Catch:{ Exception -> 0x0034 }
        if (r5 <= 0) goto L_0x0020
        r4 = 0
        r2.update(r0, r4, r5)     // Catch:{ Exception -> 0x0034 }
        goto L_0x0015
    L_0x0020:
        r3.close()     // Catch:{ Exception -> 0x0034 }
        byte[] r5 = r2.digest()     // Catch:{ Exception -> 0x0034 }
        java.lang.String r1 = com.qiyukf.basesdk.p412c.p416c.C5401a.m22109a(r5)     // Catch:{ Exception -> 0x0034 }
        r3.close()     // Catch:{ Exception -> 0x002f }
        goto L_0x0042
    L_0x002f:
        r5 = move-exception
        r5.printStackTrace()
        goto L_0x0042
    L_0x0034:
        r5 = move-exception
        goto L_0x003a
    L_0x0036:
        r5 = move-exception
        goto L_0x0045
    L_0x0038:
        r5 = move-exception
        r3 = r1
    L_0x003a:
        r5.printStackTrace()     // Catch:{ all -> 0x0043 }
        if (r3 == 0) goto L_0x0042
        r3.close()     // Catch:{ Exception -> 0x002f }
    L_0x0042:
        return r1
    L_0x0043:
        r5 = move-exception
        r1 = r3
    L_0x0045:
        if (r1 == 0) goto L_0x004f
        r1.close()     // Catch:{ Exception -> 0x004b }
        goto L_0x004f
    L_0x004b:
        r0 = move-exception
        r0.printStackTrace()
    L_0x004f:
        throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.basesdk.p412c.p416c.C5405c.m22115b(java.lang.String):java.lang.String");
    }
}
