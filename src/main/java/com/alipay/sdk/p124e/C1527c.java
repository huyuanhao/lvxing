package com.alipay.sdk.p124e;

import com.alipay.sdk.p120a.C1489a;
import com.alipay.sdk.p122c.C1515c;
import com.alipay.sdk.p122c.C1516d;
import com.alipay.sdk.p122c.C1517e;
import com.alipay.sdk.util.C1553o;
import java.util.Locale;

/* renamed from: com.alipay.sdk.e.c */
public final class C1527c {
    /* renamed from: a */
    private boolean f3897a;
    /* renamed from: b */
    private String f3898b = C1553o.m4669a(24);

    public C1527c(boolean z) {
        this.f3897a = z;
    }

    /* renamed from: a */
    public C1528d mo12181a(C1526b bVar, boolean z) {
        byte[] bArr;
        if (bVar == null) {
            return null;
        }
        byte[] bytes = bVar.mo12176a().getBytes();
        byte[] bytes2 = bVar.mo12177b().getBytes();
        if (z) {
            try {
                bytes2 = C1515c.m4514a(bytes2);
            } catch (Exception unused) {
                z = false;
            }
        }
        if (this.f3897a) {
            bArr = m4549a(bytes, m4547a(this.f3898b, C1489a.f3787b), m4548a(this.f3898b, bytes2));
        } else {
            bArr = m4549a(bytes, bytes2);
        }
        return new C1528d(z, bArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0069 A[SYNTHETIC, Splitter:B:30:0x0069] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006f A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x007b A[SYNTHETIC, Splitter:B:41:0x007b] */
    /* renamed from: a */
    public com.alipay.sdk.p124e.C1526b mo12180a(com.alipay.sdk.p124e.C1528d r6) {
        /*
        r5 = this;
        r0 = 0
        java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x0061, all -> 0x005e }
        byte[] r2 = r6.mo12183b()     // Catch:{ Exception -> 0x0061, all -> 0x005e }
        r1.<init>(r2)     // Catch:{ Exception -> 0x0061, all -> 0x005e }
        r2 = 5
        byte[] r3 = new byte[r2]     // Catch:{ Exception -> 0x005b }
        r1.read(r3)     // Catch:{ Exception -> 0x005b }
        java.lang.String r4 = new java.lang.String     // Catch:{ Exception -> 0x005b }
        r4.<init>(r3)     // Catch:{ Exception -> 0x005b }
        int r3 = m4545a(r4)     // Catch:{ Exception -> 0x005b }
        byte[] r3 = new byte[r3]     // Catch:{ Exception -> 0x005b }
        r1.read(r3)     // Catch:{ Exception -> 0x005b }
        java.lang.String r4 = new java.lang.String     // Catch:{ Exception -> 0x005b }
        r4.<init>(r3)     // Catch:{ Exception -> 0x005b }
        byte[] r2 = new byte[r2]     // Catch:{ Exception -> 0x0059 }
        r1.read(r2)     // Catch:{ Exception -> 0x0059 }
        java.lang.String r3 = new java.lang.String     // Catch:{ Exception -> 0x0059 }
        r3.<init>(r2)     // Catch:{ Exception -> 0x0059 }
        int r2 = m4545a(r3)     // Catch:{ Exception -> 0x0059 }
        if (r2 <= 0) goto L_0x0052
        byte[] r2 = new byte[r2]     // Catch:{ Exception -> 0x0059 }
        r1.read(r2)     // Catch:{ Exception -> 0x0059 }
        boolean r3 = r5.f3897a     // Catch:{ Exception -> 0x0059 }
        if (r3 == 0) goto L_0x0042
        java.lang.String r3 = r5.f3898b     // Catch:{ Exception -> 0x0059 }
        byte[] r2 = m4550b(r3, r2)     // Catch:{ Exception -> 0x0059 }
    L_0x0042:
        boolean r6 = r6.mo12182a()     // Catch:{ Exception -> 0x0059 }
        if (r6 == 0) goto L_0x004c
        byte[] r2 = com.alipay.sdk.p122c.C1515c.m4515b(r2)     // Catch:{ Exception -> 0x0059 }
    L_0x004c:
        java.lang.String r6 = new java.lang.String     // Catch:{ Exception -> 0x0059 }
        r6.<init>(r2)     // Catch:{ Exception -> 0x0059 }
        goto L_0x0053
    L_0x0052:
        r6 = r0
    L_0x0053:
        r1.close()     // Catch:{ Exception -> 0x0057 }
        goto L_0x006d
        goto L_0x006d
    L_0x0059:
        r6 = move-exception
        goto L_0x0064
    L_0x005b:
        r6 = move-exception
        r4 = r0
        goto L_0x0064
    L_0x005e:
        r6 = move-exception
        r1 = r0
        goto L_0x0079
    L_0x0061:
        r6 = move-exception
        r1 = r0
        r4 = r1
    L_0x0064:
        com.alipay.sdk.util.C1542e.m4633a(r6)     // Catch:{ all -> 0x0078 }
        if (r1 == 0) goto L_0x006c
        r1.close()     // Catch:{ Exception -> 0x006c }
    L_0x006c:
        r6 = r0
    L_0x006d:
        if (r4 != 0) goto L_0x0072
        if (r6 != 0) goto L_0x0072
        return r0
    L_0x0072:
        com.alipay.sdk.e.b r0 = new com.alipay.sdk.e.b
        r0.m42154init(r4, r6)
        return r0
    L_0x0078:
        r6 = move-exception
    L_0x0079:
        if (r1 == 0) goto L_0x007e
        r1.close()     // Catch:{ Exception -> 0x007e }
    L_0x007e:
        throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.p124e.C1527c.mo12180a(com.alipay.sdk.e.d):com.alipay.sdk.e.b");
    }

    /* renamed from: a */
    private static byte[] m4547a(String str, String str2) {
        return C1516d.m4516a(str, str2);
    }

    /* renamed from: a */
    private static byte[] m4548a(String str, byte[] bArr) {
        return C1517e.m4519a(str, bArr);
    }

    /* renamed from: b */
    private static byte[] m4550b(String str, byte[] bArr) {
        return C1517e.m4521b(str, bArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0051, code lost:
            if (r2 == null) goto L_0x0054;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0034 */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x004c A[SYNTHETIC, Splitter:B:29:0x004c] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0058 A[SYNTHETIC, Splitter:B:37:0x0058] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x005f A[SYNTHETIC, Splitter:B:41:0x005f] */
    /* renamed from: a */
    private static byte[] m4549a(byte[]... r7) {
        /*
        r0 = 0
        if (r7 == 0) goto L_0x0063
        int r1 = r7.length
        if (r1 != 0) goto L_0x0008
        goto L_0x0063
    L_0x0008:
        java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0044, all -> 0x0040 }
        r1.<init>()     // Catch:{ Exception -> 0x0044, all -> 0x0040 }
        java.io.DataOutputStream r2 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x003d, all -> 0x003a }
        r2.<init>(r1)     // Catch:{ Exception -> 0x003d, all -> 0x003a }
        int r3 = r7.length     // Catch:{ Exception -> 0x0038 }
        r4 = 0
    L_0x0014:
        if (r4 >= r3) goto L_0x002a
        r5 = r7[r4]     // Catch:{ Exception -> 0x0038 }
        int r6 = r5.length     // Catch:{ Exception -> 0x0038 }
        java.lang.String r6 = m4546a(r6)     // Catch:{ Exception -> 0x0038 }
        byte[] r6 = r6.getBytes()     // Catch:{ Exception -> 0x0038 }
        r2.write(r6)     // Catch:{ Exception -> 0x0038 }
        r2.write(r5)     // Catch:{ Exception -> 0x0038 }
        int r4 = r4 + 1
        goto L_0x0014
    L_0x002a:
        r2.flush()     // Catch:{ Exception -> 0x0038 }
        byte[] r0 = r1.toByteArray()     // Catch:{ Exception -> 0x0038 }
        r1.close()     // Catch:{ Exception -> 0x0034 }
    L_0x0034:
        r2.close()     // Catch:{ Exception -> 0x0054 }
        goto L_0x0054
    L_0x0038:
        r7 = move-exception
        goto L_0x0047
    L_0x003a:
        r7 = move-exception
        r2 = r0
        goto L_0x0056
    L_0x003d:
        r7 = move-exception
        r2 = r0
        goto L_0x0047
    L_0x0040:
        r7 = move-exception
        r1 = r0
        r2 = r1
        goto L_0x0056
    L_0x0044:
        r7 = move-exception
        r1 = r0
        r2 = r1
    L_0x0047:
        com.alipay.sdk.util.C1542e.m4633a(r7)     // Catch:{ all -> 0x0055 }
        if (r1 == 0) goto L_0x0051
        r1.close()     // Catch:{ Exception -> 0x0050 }
        goto L_0x0051
    L_0x0051:
        if (r2 == 0) goto L_0x0054
        goto L_0x0034
    L_0x0054:
        return r0
    L_0x0055:
        r7 = move-exception
    L_0x0056:
        if (r1 == 0) goto L_0x005d
        r1.close()     // Catch:{ Exception -> 0x005c }
        goto L_0x005d
    L_0x005d:
        if (r2 == 0) goto L_0x0062
        r2.close()     // Catch:{ Exception -> 0x0062 }
    L_0x0062:
        throw r7
    L_0x0063:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.p124e.C1527c.m4549a(byte[][]):byte[]");
    }

    /* renamed from: a */
    private static String m4546a(int i) {
        return String.format(Locale.getDefault(), "%05d", new Object[]{Integer.valueOf(i)});
    }

    /* renamed from: a */
    private static int m4545a(String str) {
        return Integer.parseInt(str);
    }
}
