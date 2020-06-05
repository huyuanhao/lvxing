package com.alipay.sdk.p122c;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

/* renamed from: com.alipay.sdk.c.d */
public class C1516d {
    /* renamed from: b */
    private static PublicKey m4517b(String str, String str2) throws NoSuchAlgorithmException, Exception {
        return KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(C1513a.m4508a(str2)));
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARNING: type inference failed for: r0v2, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r2v0, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r2v3, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARNING: type inference failed for: r0v5, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v4
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d A[SYNTHETIC, Splitter:B:24:0x004d] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0055 A[SYNTHETIC, Splitter:B:30:0x0055] */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* renamed from: a */
    public static byte[] m4516a(java.lang.String r5, java.lang.String r6) {
        /*
        r0 = 0
        java.lang.String r1 = "RSA"
        java.security.PublicKey r6 = m4517b(r1, r6)     // Catch:{ Exception -> 0x0046, all -> 0x0044 }
        java.lang.String r1 = "RSA/ECB/PKCS1Padding"
        javax.crypto.Cipher r1 = javax.crypto.Cipher.getInstance(r1)     // Catch:{ Exception -> 0x0046, all -> 0x0044 }
        r2 = 1
        r1.init(r2, r6)     // Catch:{ Exception -> 0x0046, all -> 0x0044 }
        java.lang.String r6 = "UTF-8"
        byte[] r5 = r5.getBytes(r6)     // Catch:{ Exception -> 0x0046, all -> 0x0044 }
        int r6 = r1.getBlockSize()     // Catch:{ Exception -> 0x0046, all -> 0x0044 }
        java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0046, all -> 0x0044 }
        r2.<init>()     // Catch:{ Exception -> 0x0046, all -> 0x0044 }
        r3 = 0
    L_0x0021:
        int r4 = r5.length     // Catch:{ Exception -> 0x0042 }
        if (r3 >= r4) goto L_0x0035
        int r4 = r5.length     // Catch:{ Exception -> 0x0042 }
        int r4 = r4 - r3
        if (r4 >= r6) goto L_0x002b
        int r4 = r5.length     // Catch:{ Exception -> 0x0042 }
        int r4 = r4 - r3
        goto L_0x002c
    L_0x002b:
        r4 = r6
    L_0x002c:
        byte[] r4 = r1.doFinal(r5, r3, r4)     // Catch:{ Exception -> 0x0042 }
        r2.write(r4)     // Catch:{ Exception -> 0x0042 }
        int r3 = r3 + r6
        goto L_0x0021
    L_0x0035:
        byte[] r0 = r2.toByteArray()     // Catch:{ Exception -> 0x0042 }
        r2.close()     // Catch:{ IOException -> 0x003d }
        goto L_0x0050
    L_0x003d:
        r5 = move-exception
        com.alipay.sdk.util.C1542e.m4633a(r5)
        goto L_0x0050
    L_0x0042:
        r5 = move-exception
        goto L_0x0048
    L_0x0044:
        r5 = move-exception
        goto L_0x0053
    L_0x0046:
        r5 = move-exception
        r2 = r0
    L_0x0048:
        com.alipay.sdk.util.C1542e.m4633a(r5)     // Catch:{ all -> 0x0051 }
        if (r2 == 0) goto L_0x0050
        r2.close()     // Catch:{ IOException -> 0x003d }
    L_0x0050:
        return r0
    L_0x0051:
        r5 = move-exception
        r0 = r2
    L_0x0053:
        if (r0 == 0) goto L_0x005d
        r0.close()     // Catch:{ IOException -> 0x0059 }
        goto L_0x005d
    L_0x0059:
        r6 = move-exception
        com.alipay.sdk.util.C1542e.m4633a(r6)
    L_0x005d:
        throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.p122c.C1516d.m4516a(java.lang.String, java.lang.String):byte[]");
    }
}
