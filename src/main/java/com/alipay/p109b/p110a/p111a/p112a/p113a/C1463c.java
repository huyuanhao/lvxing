package com.alipay.p109b.p110a.p111a.p112a.p113a;

import java.lang.reflect.Method;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.alipay.b.a.a.a.a.c */
public final class C1463c {
    /* renamed from: a */
    private static String f3738a = new String("idnjfhncnsfuobcnt847y929o449u474w7j3h22aoddc98euk#%&&)*&^%#");

    /* renamed from: a */
    public static String m4271a() {
        String str = new String();
        for (int i = 0; i < f3738a.length() - 1; i += 4) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(f3738a.charAt(i));
            str = sb.toString();
        }
        return str;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:3|4|5) */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0068, code lost:
            return m4277b(m4275a(m4274a(r7.getBytes()), r8.getBytes()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x006a, code lost:
            return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0054 */
    /* renamed from: a */
    public static java.lang.String m4272a(java.lang.String r7, java.lang.String r8) {
        /*
        javax.crypto.spec.PBEKeySpec r0 = m4273a(r7)     // Catch:{ Exception -> 0x0054 }
        byte[] r1 = r8.getBytes()     // Catch:{ Exception -> 0x0054 }
        java.lang.String r2 = "PBKDF2WithHmacSHA1"
        javax.crypto.SecretKeyFactory r2 = javax.crypto.SecretKeyFactory.getInstance(r2)     // Catch:{ Exception -> 0x0054 }
        javax.crypto.SecretKey r2 = r2.generateSecret(r0)     // Catch:{ Exception -> 0x0054 }
        byte[] r2 = r2.getEncoded()     // Catch:{ Exception -> 0x0054 }
        javax.crypto.spec.SecretKeySpec r3 = new javax.crypto.spec.SecretKeySpec     // Catch:{ Exception -> 0x0054 }
        java.lang.String r4 = "AES"
        r3.<init>(r2, r4)     // Catch:{ Exception -> 0x0054 }
        java.lang.String r2 = "AES/CBC/PKCS5Padding"
        javax.crypto.Cipher r2 = javax.crypto.Cipher.getInstance(r2)     // Catch:{ Exception -> 0x0054 }
        r4 = 1
        javax.crypto.spec.IvParameterSpec r5 = new javax.crypto.spec.IvParameterSpec     // Catch:{ Exception -> 0x0054 }
        int r6 = r2.getBlockSize()     // Catch:{ Exception -> 0x0054 }
        byte[] r6 = new byte[r6]     // Catch:{ Exception -> 0x0054 }
        r5.<init>(r6)     // Catch:{ Exception -> 0x0054 }
        r2.init(r4, r3, r5)     // Catch:{ Exception -> 0x0054 }
        byte[] r0 = r0.getSalt()     // Catch:{ Exception -> 0x0054 }
        int r3 = r0.length     // Catch:{ Exception -> 0x0054 }
        int r4 = r1.length     // Catch:{ Exception -> 0x0054 }
        int r4 = r2.getOutputSize(r4)     // Catch:{ Exception -> 0x0054 }
        int r3 = r3 + r4
        java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocate(r3)     // Catch:{ Exception -> 0x0054 }
        r3.put(r0)     // Catch:{ Exception -> 0x0054 }
        java.nio.ByteBuffer r0 = java.nio.ByteBuffer.wrap(r1)     // Catch:{ Exception -> 0x0054 }
        r2.doFinal(r0, r3)     // Catch:{ Exception -> 0x0054 }
        byte[] r0 = r3.array()     // Catch:{ Exception -> 0x0054 }
        java.lang.String r7 = m4277b(r0)     // Catch:{ Exception -> 0x0054 }
        return r7
    L_0x0054:
        byte[] r7 = r7.getBytes()     // Catch:{ Exception -> 0x0069 }
        byte[] r7 = m4274a(r7)     // Catch:{ Exception -> 0x0069 }
        byte[] r8 = r8.getBytes()     // Catch:{ Exception -> 0x0069 }
        byte[] r7 = m4275a(r7, r8)     // Catch:{ Exception -> 0x0069 }
        java.lang.String r7 = m4277b(r7)     // Catch:{ Exception -> 0x0069 }
        return r7
    L_0x0069:
        r7 = 0
        return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.p109b.p110a.p111a.p112a.p113a.C1463c.m4272a(java.lang.String, java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    private static PBEKeySpec m4273a(String str) {
        Class cls = Class.forName(new String(C1461a.m4269a("amF2YS5zZWN1cml0eS5TZWN1cmVSYW5kb20=")));
        Object newInstance = cls.newInstance();
        byte[] bArr = new byte[16];
        Method method = cls.getMethod("nextBytes", new Class[]{bArr.getClass()});
        method.setAccessible(true);
        method.invoke(newInstance, new Object[]{bArr});
        return new PBEKeySpec(str.toCharArray(), bArr, 10, 128);
    }

    /* renamed from: a */
    private static byte[] m4274a(byte[] bArr) {
        KeyGenerator instance = KeyGenerator.getInstance("AES");
        Class cls = Class.forName(new String(C1461a.m4269a("amF2YS5zZWN1cml0eS5TZWN1cmVSYW5kb20=")));
        Object invoke = cls.getMethod("getInstance", new Class[]{String.class, String.class}).invoke(null, new Object[]{"SHA1PRNG", "Crypto"});
        Method method = cls.getMethod("setSeed", new Class[]{bArr.getClass()});
        method.setAccessible(true);
        method.invoke(invoke, new Object[]{bArr});
        KeyGenerator.class.getMethod("init", new Class[]{Integer.TYPE, cls}).invoke(instance, new Object[]{Integer.valueOf(128), invoke});
        return instance.generateKey().getEncoded();
    }

    /* renamed from: a */
    private static byte[] m4275a(byte[] bArr, byte[] bArr2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(1, secretKeySpec, new IvParameterSpec(new byte[instance.getBlockSize()]));
            return instance.doFinal(bArr2);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:7|(1:9)|12|13|(1:15)(1:16)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0065 */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0097 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0098 A[RETURN] */
    /* renamed from: b */
    public static java.lang.String m4276b(java.lang.String r11, java.lang.String r12) {
        /*
        java.lang.String r0 = "AES/CBC/PKCS5Padding"
        java.lang.String r1 = "AES"
        r2 = 2
        r3 = 0
        javax.crypto.spec.PBEKeySpec r4 = m4273a(r11)     // Catch:{ Exception -> 0x0065 }
        byte[] r5 = m4278b(r12)     // Catch:{ Exception -> 0x0065 }
        int r6 = r5.length     // Catch:{ Exception -> 0x0065 }
        r7 = 16
        if (r6 > r7) goto L_0x0015
        r4 = r3
        goto L_0x0051
    L_0x0015:
        javax.crypto.spec.PBEKeySpec r6 = new javax.crypto.spec.PBEKeySpec     // Catch:{ Exception -> 0x0065 }
        char[] r4 = r4.getPassword()     // Catch:{ Exception -> 0x0065 }
        byte[] r8 = java.util.Arrays.copyOf(r5, r7)     // Catch:{ Exception -> 0x0065 }
        r9 = 10
        r10 = 128(0x80, float:1.794E-43)
        r6.<init>(r4, r8, r9, r10)     // Catch:{ Exception -> 0x0065 }
        java.lang.String r4 = "PBKDF2WithHmacSHA1"
        javax.crypto.SecretKeyFactory r4 = javax.crypto.SecretKeyFactory.getInstance(r4)     // Catch:{ Exception -> 0x0065 }
        javax.crypto.SecretKey r4 = r4.generateSecret(r6)     // Catch:{ Exception -> 0x0065 }
        byte[] r4 = r4.getEncoded()     // Catch:{ Exception -> 0x0065 }
        javax.crypto.spec.SecretKeySpec r6 = new javax.crypto.spec.SecretKeySpec     // Catch:{ Exception -> 0x0065 }
        r6.<init>(r4, r1)     // Catch:{ Exception -> 0x0065 }
        javax.crypto.Cipher r4 = javax.crypto.Cipher.getInstance(r0)     // Catch:{ Exception -> 0x0065 }
        javax.crypto.spec.IvParameterSpec r8 = new javax.crypto.spec.IvParameterSpec     // Catch:{ Exception -> 0x0065 }
        int r9 = r4.getBlockSize()     // Catch:{ Exception -> 0x0065 }
        byte[] r9 = new byte[r9]     // Catch:{ Exception -> 0x0065 }
        r8.<init>(r9)     // Catch:{ Exception -> 0x0065 }
        r4.init(r2, r6, r8)     // Catch:{ Exception -> 0x0065 }
        int r6 = r5.length     // Catch:{ Exception -> 0x0065 }
        int r6 = r6 - r7
        byte[] r4 = r4.doFinal(r5, r7, r6)     // Catch:{ Exception -> 0x0065 }
    L_0x0051:
        if (r4 == 0) goto L_0x005f
        java.lang.String r5 = new java.lang.String     // Catch:{ Exception -> 0x0065 }
        r5.<init>(r4)     // Catch:{ Exception -> 0x0065 }
        boolean r4 = com.alipay.p109b.p110a.p111a.p112a.C1460a.m4264c(r5)     // Catch:{ Exception -> 0x0065 }
        if (r4 == 0) goto L_0x0065
        return r5
    L_0x005f:
        java.lang.Exception r4 = new java.lang.Exception     // Catch:{ Exception -> 0x0065 }
        r4.<init>()     // Catch:{ Exception -> 0x0065 }
        throw r4     // Catch:{ Exception -> 0x0065 }
    L_0x0065:
        byte[] r11 = r11.getBytes()     // Catch:{ Exception -> 0x0098 }
        byte[] r11 = m4274a(r11)     // Catch:{ Exception -> 0x0098 }
        byte[] r12 = m4278b(r12)     // Catch:{ Exception -> 0x0098 }
        javax.crypto.spec.SecretKeySpec r4 = new javax.crypto.spec.SecretKeySpec     // Catch:{ Exception -> 0x0098 }
        r4.<init>(r11, r1)     // Catch:{ Exception -> 0x0098 }
        javax.crypto.Cipher r11 = javax.crypto.Cipher.getInstance(r0)     // Catch:{ Exception -> 0x0098 }
        javax.crypto.spec.IvParameterSpec r0 = new javax.crypto.spec.IvParameterSpec     // Catch:{ Exception -> 0x0098 }
        int r1 = r11.getBlockSize()     // Catch:{ Exception -> 0x0098 }
        byte[] r1 = new byte[r1]     // Catch:{ Exception -> 0x0098 }
        r0.<init>(r1)     // Catch:{ Exception -> 0x0098 }
        r11.init(r2, r4, r0)     // Catch:{ Exception -> 0x0098 }
        byte[] r11 = r11.doFinal(r12)     // Catch:{ Exception -> 0x0098 }
        java.lang.String r12 = new java.lang.String     // Catch:{ Exception -> 0x0098 }
        r12.<init>(r11)     // Catch:{ Exception -> 0x0098 }
        boolean r11 = com.alipay.p109b.p110a.p111a.p112a.C1460a.m4264c(r12)     // Catch:{ Exception -> 0x0098 }
        if (r11 == 0) goto L_0x0098
        return r12
    L_0x0098:
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.p109b.p110a.p111a.p112a.p113a.C1463c.m4276b(java.lang.String, java.lang.String):java.lang.String");
    }

    /* renamed from: b */
    private static String m4277b(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b : bArr) {
            String str = "0123456789ABCDEF";
            stringBuffer.append(str.charAt((b >> 4) & 15));
            stringBuffer.append(str.charAt(b & 15));
        }
        return stringBuffer.toString();
    }

    /* renamed from: b */
    private static byte[] m4278b(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = Integer.valueOf(str.substring(i2, i2 + 2), 16).byteValue();
        }
        return bArr;
    }
}
