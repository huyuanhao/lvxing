package com.alipay.sdk.p122c;

/* renamed from: com.alipay.sdk.c.c */
public class C1515c {
    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: Can't wrap try/catch for region: R(10:8|9|(2:10|(1:12)(1:43))|13|14|15|16|17|(2:18|19)|20) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x002d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0030 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0045 A[SYNTHETIC, Splitter:B:31:0x0045] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x004c A[SYNTHETIC, Splitter:B:35:0x004c] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0053 A[SYNTHETIC, Splitter:B:39:0x0053] */
    /* renamed from: a */
    public static byte[] m4514a(byte[] r6) throws java.io.IOException {
        /*
        r0 = 0
        java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x003e }
        r1.<init>(r6)     // Catch:{ all -> 0x003e }
        java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x003b }
        r6.<init>()     // Catch:{ all -> 0x003b }
        java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x0036 }
        r2.<init>(r6)     // Catch:{ all -> 0x0036 }
        r0 = 4096(0x1000, float:5.74E-42)
        byte[] r0 = new byte[r0]     // Catch:{ all -> 0x0034 }
    L_0x0014:
        int r3 = r1.read(r0)     // Catch:{ all -> 0x0034 }
        r4 = -1
        if (r3 == r4) goto L_0x0020
        r4 = 0
        r2.write(r0, r4, r3)     // Catch:{ all -> 0x0034 }
        goto L_0x0014
    L_0x0020:
        r2.flush()     // Catch:{ all -> 0x0034 }
        r2.finish()     // Catch:{ all -> 0x0034 }
        byte[] r0 = r6.toByteArray()     // Catch:{ all -> 0x0034 }
        r1.close()     // Catch:{ Exception -> 0x002d }
    L_0x002d:
        r6.close()     // Catch:{ Exception -> 0x0030 }
    L_0x0030:
        r2.close()     // Catch:{ Exception -> 0x0033 }
    L_0x0033:
        return r0
    L_0x0034:
        r0 = move-exception
        goto L_0x0043
    L_0x0036:
        r2 = move-exception
        r5 = r2
        r2 = r0
        r0 = r5
        goto L_0x0043
    L_0x003b:
        r6 = move-exception
        r2 = r0
        goto L_0x0041
    L_0x003e:
        r6 = move-exception
        r1 = r0
        r2 = r1
    L_0x0041:
        r0 = r6
        r6 = r2
    L_0x0043:
        if (r1 == 0) goto L_0x004a
        r1.close()     // Catch:{ Exception -> 0x0049 }
        goto L_0x004a
    L_0x004a:
        if (r6 == 0) goto L_0x0051
        r6.close()     // Catch:{ Exception -> 0x0050 }
        goto L_0x0051
    L_0x0051:
        if (r2 == 0) goto L_0x0056
        r2.close()     // Catch:{ Exception -> 0x0056 }
    L_0x0056:
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.p122c.C1515c.m4514a(byte[]):byte[]");
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARNING: type inference failed for: r3v1 */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: Can't wrap try/catch for region: R(11:6|7|(3:8|9|(1:11)(1:37))|12|13|14|15|16|17|18|19) */
    /* JADX WARNING: Can't wrap try/catch for region: R(14:3|4|5|6|7|(3:8|9|(1:11)(1:37))|12|13|14|15|16|17|18|19) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:21|29|30|31|32|33|34|35) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x002b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x002e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0043 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0046 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: b */
    public static byte[] m4515b(byte[] r6) throws java.io.IOException {
        /*
        r0 = 0
        java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x003b }
        r1.<init>(r6)     // Catch:{ all -> 0x003b }
        java.util.zip.GZIPInputStream r6 = new java.util.zip.GZIPInputStream     // Catch:{ all -> 0x0038 }
        r6.<init>(r1)     // Catch:{ all -> 0x0038 }
        r2 = 4096(0x1000, float:5.74E-42)
        byte[] r2 = new byte[r2]     // Catch:{ all -> 0x0034 }
        java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0034 }
        r3.<init>()     // Catch:{ all -> 0x0034 }
    L_0x0014:
        int r0 = r2.length     // Catch:{ all -> 0x0032 }
        r4 = 0
        int r0 = r6.read(r2, r4, r0)     // Catch:{ all -> 0x0032 }
        r5 = -1
        if (r0 == r5) goto L_0x0021
        r3.write(r2, r4, r0)     // Catch:{ all -> 0x0032 }
        goto L_0x0014
    L_0x0021:
        r3.flush()     // Catch:{ all -> 0x0032 }
        byte[] r0 = r3.toByteArray()     // Catch:{ all -> 0x0032 }
        r3.close()     // Catch:{ Exception -> 0x002b }
    L_0x002b:
        r6.close()     // Catch:{ Exception -> 0x002e }
    L_0x002e:
        r1.close()     // Catch:{ Exception -> 0x0031 }
    L_0x0031:
        return r0
    L_0x0032:
        r0 = move-exception
        goto L_0x0040
    L_0x0034:
        r2 = move-exception
        r3 = r0
        r0 = r2
        goto L_0x0040
    L_0x0038:
        r6 = move-exception
        r3 = r0
        goto L_0x003e
    L_0x003b:
        r6 = move-exception
        r1 = r0
        r3 = r1
    L_0x003e:
        r0 = r6
        r6 = r3
    L_0x0040:
        r3.close()     // Catch:{ Exception -> 0x0043 }
    L_0x0043:
        r6.close()     // Catch:{ Exception -> 0x0046 }
    L_0x0046:
        r1.close()     // Catch:{ Exception -> 0x0049 }
    L_0x0049:
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.p122c.C1515c.m4515b(byte[]):byte[]");
    }
}
