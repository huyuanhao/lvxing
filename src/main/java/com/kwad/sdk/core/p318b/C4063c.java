package com.kwad.sdk.core.p318b;

import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

/* renamed from: com.kwad.sdk.core.b.c */
public class C4063c {
    /* renamed from: a */
    private static int m16854a(KeyFactory keyFactory, Key key) {
        try {
            return (((RSAPublicKeySpec) keyFactory.getKeySpec(key, RSAPublicKeySpec.class)).getModulus().bitLength() / 8) - 11;
        } catch (Exception unused) {
            return 117;
        }
    }

    /* renamed from: a */
    public static byte[] m16855a(byte[] bArr, String str) {
        return m16856a(bArr, str, "RSA/ECB/PKCS1Padding");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0056 A[SYNTHETIC, Splitter:B:25:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005d A[SYNTHETIC, Splitter:B:30:0x005d] */
    /* renamed from: a */
    public static byte[] m16856a(byte[] r5, java.lang.String r6, java.lang.String r7) {
        /*
        com.kwad.sdk.core.b.a$a r0 = com.kwad.sdk.core.p318b.C4059a.m16841b()
        byte[] r6 = r0.mo23720a(r6)
        java.security.spec.X509EncodedKeySpec r0 = new java.security.spec.X509EncodedKeySpec
        r0.<init>(r6)
        java.lang.String r6 = "RSA"
        java.security.KeyFactory r6 = java.security.KeyFactory.getInstance(r6)
        java.security.PublicKey r0 = r6.generatePublic(r0)
        javax.crypto.Cipher r7 = javax.crypto.Cipher.getInstance(r7)
        r1 = 1
        r7.init(r1, r0)
        int r6 = m16854a(r6, r0)
        r0 = 0
        java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x004f, all -> 0x004c }
        r1.<init>()     // Catch:{ Exception -> 0x004f, all -> 0x004c }
        int r2 = r5.length     // Catch:{ Exception -> 0x004a }
        r3 = 0
    L_0x002b:
        int r4 = r5.length     // Catch:{ Exception -> 0x004a }
        if (r3 >= r4) goto L_0x003d
        int r4 = r2 - r3
        if (r4 >= r6) goto L_0x0033
        goto L_0x0034
    L_0x0033:
        r4 = r6
    L_0x0034:
        byte[] r4 = r7.doFinal(r5, r3, r4)     // Catch:{ Exception -> 0x004a }
        r1.write(r4)     // Catch:{ Exception -> 0x004a }
        int r3 = r3 + r6
        goto L_0x002b
    L_0x003d:
        byte[] r0 = r1.toByteArray()     // Catch:{ Exception -> 0x004a }
        r1.close()     // Catch:{ Exception -> 0x0045 }
        goto L_0x0059
    L_0x0045:
        r5 = move-exception
        com.kwad.sdk.core.p319c.C4065b.m16865a(r5)
        goto L_0x0059
    L_0x004a:
        r5 = move-exception
        goto L_0x0051
    L_0x004c:
        r5 = move-exception
        r1 = r0
        goto L_0x005b
    L_0x004f:
        r5 = move-exception
        r1 = r0
    L_0x0051:
        com.kwad.sdk.core.p319c.C4065b.m16865a(r5)     // Catch:{ all -> 0x005a }
        if (r1 == 0) goto L_0x0059
        r1.close()     // Catch:{ Exception -> 0x0045 }
    L_0x0059:
        return r0
    L_0x005a:
        r5 = move-exception
    L_0x005b:
        if (r1 == 0) goto L_0x0065
        r1.close()     // Catch:{ Exception -> 0x0061 }
        goto L_0x0065
    L_0x0061:
        r6 = move-exception
        com.kwad.sdk.core.p319c.C4065b.m16865a(r6)
    L_0x0065:
        throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.p318b.C4063c.m16856a(byte[], java.lang.String, java.lang.String):byte[]");
    }

    /* renamed from: b */
    private static int m16857b(KeyFactory keyFactory, Key key) {
        try {
            return ((RSAPrivateKeySpec) keyFactory.getKeySpec(key, RSAPrivateKeySpec.class)).getModulus().bitLength() / 8;
        } catch (Exception unused) {
            return 128;
        }
    }

    /* renamed from: b */
    public static String m16858b(byte[] bArr, String str) {
        return new String(m16859b(bArr, str, "RSA/ECB/PKCS1Padding"), "UTF-8");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0055 A[SYNTHETIC, Splitter:B:24:0x0055] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x005c A[SYNTHETIC, Splitter:B:29:0x005c] */
    /* renamed from: b */
    public static byte[] m16859b(byte[] r5, java.lang.String r6, java.lang.String r7) {
        /*
        com.kwad.sdk.core.b.a$a r0 = com.kwad.sdk.core.p318b.C4059a.m16841b()
        byte[] r6 = r0.mo23720a(r6)
        java.security.spec.PKCS8EncodedKeySpec r0 = new java.security.spec.PKCS8EncodedKeySpec
        r0.<init>(r6)
        java.lang.String r6 = "RSA"
        java.security.KeyFactory r6 = java.security.KeyFactory.getInstance(r6)
        java.security.PrivateKey r0 = r6.generatePrivate(r0)
        javax.crypto.Cipher r7 = javax.crypto.Cipher.getInstance(r7)
        r1 = 2
        r7.init(r1, r0)
        int r6 = m16857b(r6, r0)
        r0 = 0
        java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x004e, all -> 0x004b }
        r1.<init>()     // Catch:{ Exception -> 0x004e, all -> 0x004b }
        int r2 = r5.length     // Catch:{ Exception -> 0x0049 }
        r3 = 0
    L_0x002b:
        if (r3 >= r2) goto L_0x003c
        int r4 = r2 - r3
        if (r4 >= r6) goto L_0x0032
        goto L_0x0033
    L_0x0032:
        r4 = r6
    L_0x0033:
        byte[] r4 = r7.doFinal(r5, r3, r4)     // Catch:{ Exception -> 0x0049 }
        r1.write(r4)     // Catch:{ Exception -> 0x0049 }
        int r3 = r3 + r6
        goto L_0x002b
    L_0x003c:
        byte[] r0 = r1.toByteArray()     // Catch:{ Exception -> 0x0049 }
        r1.close()     // Catch:{ Exception -> 0x0044 }
        goto L_0x0058
    L_0x0044:
        r5 = move-exception
        com.kwad.sdk.core.p319c.C4065b.m16865a(r5)
        goto L_0x0058
    L_0x0049:
        r5 = move-exception
        goto L_0x0050
    L_0x004b:
        r5 = move-exception
        r1 = r0
        goto L_0x005a
    L_0x004e:
        r5 = move-exception
        r1 = r0
    L_0x0050:
        com.kwad.sdk.core.p319c.C4065b.m16865a(r5)     // Catch:{ all -> 0x0059 }
        if (r1 == 0) goto L_0x0058
        r1.close()     // Catch:{ Exception -> 0x0044 }
    L_0x0058:
        return r0
    L_0x0059:
        r5 = move-exception
    L_0x005a:
        if (r1 == 0) goto L_0x0064
        r1.close()     // Catch:{ Exception -> 0x0060 }
        goto L_0x0064
    L_0x0060:
        r6 = move-exception
        com.kwad.sdk.core.p319c.C4065b.m16865a(r6)
    L_0x0064:
        throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.p318b.C4063c.m16859b(byte[], java.lang.String, java.lang.String):byte[]");
    }
}
