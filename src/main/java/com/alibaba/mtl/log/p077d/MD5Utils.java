package com.alibaba.mtl.log.p077d;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.alibaba.mtl.log.d.j */
public class MD5Utils {
    /* renamed from: a */
    public static char[] f3407a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: a */
    public static String m3838a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            sb.append(f3407a[(bArr[i] & -16) >>> 4]);
            sb.append(f3407a[bArr[i] & 15]);
        }
        return sb.toString();
    }

    /* renamed from: b */
    public static String m3839b(byte[] bArr) {
        byte[] c = m3840c(bArr);
        return c != null ? m3838a(c) : "0000000000000000";
    }

    /* renamed from: c */
    public static byte[] m3840c(byte[] bArr) {
        if (bArr != null) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(bArr);
                return instance.digest();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
