package com.p522qq.p523e.comm.util;

import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import java.security.MessageDigest;

/* renamed from: com.qq.e.comm.util.Md5Util */
public class Md5Util {
    /* renamed from: a */
    private static final String[] f20320a = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public static String byteArrayToHexString(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            int i2 = b < 0 ? b + 256 : b;
            int i3 = i2 / 16;
            int i4 = i2 % 16;
            StringBuilder sb = new StringBuilder();
            sb.append(f20320a[i3]);
            sb.append(f20320a[i4]);
            stringBuffer.append(sb.toString());
        }
        return stringBuffer.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0034 A[SYNTHETIC, Splitter:B:23:0x0034] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x003b A[SYNTHETIC, Splitter:B:29:0x003b] */
    public static java.lang.String encode(java.io.File r5) {
        /*
        java.lang.String r0 = ""
        if (r5 != 0) goto L_0x0005
        return r0
    L_0x0005:
        r1 = 0
        java.lang.String r2 = "MD5"
        java.security.MessageDigest r2 = java.security.MessageDigest.getInstance(r2)     // Catch:{ Exception -> 0x0038, all -> 0x0030 }
        java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0038, all -> 0x0030 }
        r3.<init>(r5)     // Catch:{ Exception -> 0x0038, all -> 0x0030 }
        r5 = 1024(0x400, float:1.435E-42)
        byte[] r5 = new byte[r5]     // Catch:{ Exception -> 0x002e, all -> 0x002c }
    L_0x0015:
        int r1 = r3.read(r5)     // Catch:{ Exception -> 0x002e, all -> 0x002c }
        if (r1 <= 0) goto L_0x0020
        r4 = 0
        r2.update(r5, r4, r1)     // Catch:{ Exception -> 0x002e, all -> 0x002c }
        goto L_0x0015
    L_0x0020:
        byte[] r5 = r2.digest()     // Catch:{ Exception -> 0x002e, all -> 0x002c }
        java.lang.String r5 = byteArrayToHexString(r5)     // Catch:{ Exception -> 0x002e, all -> 0x002c }
        r3.close()     // Catch:{ Exception -> 0x002b }
    L_0x002b:
        return r5
    L_0x002c:
        r5 = move-exception
        goto L_0x0032
    L_0x002e:
        r1 = r3
        goto L_0x0039
    L_0x0030:
        r5 = move-exception
        r3 = r1
    L_0x0032:
        if (r3 == 0) goto L_0x0037
        r3.close()     // Catch:{ Exception -> 0x0037 }
    L_0x0037:
        throw r5
    L_0x0039:
        if (r1 == 0) goto L_0x003e
        r1.close()     // Catch:{ Exception -> 0x003e }
    L_0x003e:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p522qq.p523e.comm.util.Md5Util.encode(java.io.File):java.lang.String");
    }

    public static String encode(String str) {
        String str2;
        try {
            str2 = new String(str);
            try {
                return byteArrayToHexString(MessageDigest.getInstance("MD5").digest(str2.getBytes("UTF-8")));
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            str2 = null;
            return str2;
        }
    }

    public static String encodeBase64String(String str) {
        try {
            return byteArrayToHexString(MessageDigest.getInstance("MD5").digest(Base64.decode(str, 0)));
        } catch (Exception e) {
            GDTLogger.m25261e("Exception while md5 base64String", e);
            return null;
        }
    }

    public static byte[] hexStringtoByteArray(String str) {
        if (str.length() % 2 != 0) {
            return null;
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < str.length() - 1; i += 2) {
            char charAt = str.charAt(i);
            char charAt2 = str.charAt(i + 1);
            char lowerCase = Character.toLowerCase(charAt);
            char lowerCase2 = Character.toLowerCase(charAt2);
            int i2 = ((lowerCase <= '9' ? lowerCase - '0' : (lowerCase - 'a') + 10) << 4) + (lowerCase2 <= '9' ? lowerCase2 - '0' : (lowerCase2 - 'a') + 10);
            if (i2 > 127) {
                i2 += InputDeviceCompat.SOURCE_ANY;
            }
            bArr[i / 2] = (byte) i2;
        }
        return bArr;
    }
}
