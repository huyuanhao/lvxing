package com.tencent.p605ep.commonbase.utils;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.tencent.ep.commonbase.utils.MD5Util */
public class MD5Util {
    private static final char[] HEXDIGITS = "0123456789abcdef".toCharArray();

    public static String byteArrayToHex(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] cArr2 = new char[(bArr.length * 2)];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            cArr2[i] = cArr[(b >>> 4) & 15];
            i = i2 + 1;
            cArr2[i2] = cArr[b & 15];
        }
        return new String(cArr2);
    }

    public static byte[] encrypt(String str) {
        return encrypt(str.getBytes());
    }

    public static byte[] encrypt(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            return instance.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encrypt_bytes(byte[] bArr) {
        return encrypt_string(encrypt(bArr));
    }

    public static String encrypt_string(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 3);
        for (byte b : bArr) {
            byte b2 = b & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
            sb.append(HEXDIGITS[b2 >> 4]);
            sb.append(HEXDIGITS[b2 & 15]);
        }
        return sb.toString().toUpperCase();
    }

    public static String encyptToSubHexString(String str) {
        byte[] encrypt = encrypt(str);
        if (encrypt == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(encrypt.length * 2);
        for (byte b : encrypt) {
            sb.append(Integer.toHexString(b & DeviceInfos.NETWORK_TYPE_UNCONNECTED).substring(0, 1));
        }
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0018, code lost:
            r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0019, code lost:
            r2.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001c, code lost:
            return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0014 */
    public static java.lang.String fileMD5(java.lang.String r2) {
        /*
        r0 = 0
        java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x0013 }
        r1.<init>(r2)     // Catch:{ all -> 0x0013 }
        java.lang.String r2 = getMd5(r1)     // Catch:{ all -> 0x0014 }
        r1.close()     // Catch:{ Exception -> 0x000e }
        goto L_0x0012
    L_0x000e:
        r0 = move-exception
        r0.printStackTrace()
    L_0x0012:
        return r2
    L_0x0013:
        r1 = r0
    L_0x0014:
        r1.close()     // Catch:{ Exception -> 0x0018 }
        goto L_0x001c
    L_0x0018:
        r2 = move-exception
        r2.printStackTrace()
    L_0x001c:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.utils.MD5Util.fileMD5(java.lang.String):java.lang.String");
    }

    public static String getByteMd5(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            return ConvertUtil.bytesToHexString(instance.digest());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
            r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0039, code lost:
            r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003a, code lost:
            r1.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0041, code lost:
            r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0042, code lost:
            r4.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0045, code lost:
            return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0035 */
    public static java.lang.String getMd5(java.io.InputStream r4) {
        /*
        r0 = 0
        java.lang.String r1 = "MD5"
        java.security.MessageDigest r1 = java.security.MessageDigest.getInstance(r1)     // Catch:{ all -> 0x0034 }
        java.security.DigestInputStream r2 = new java.security.DigestInputStream     // Catch:{ all -> 0x0034 }
        r2.<init>(r4, r1)     // Catch:{ all -> 0x0034 }
        r1 = 262144(0x40000, float:3.67342E-40)
        byte[] r1 = new byte[r1]     // Catch:{ all -> 0x0035 }
    L_0x0010:
        int r3 = r2.read(r1)     // Catch:{ all -> 0x0035 }
        if (r3 <= 0) goto L_0x0017
        goto L_0x0010
    L_0x0017:
        java.security.MessageDigest r1 = r2.getMessageDigest()     // Catch:{ all -> 0x0035 }
        byte[] r1 = r1.digest()     // Catch:{ all -> 0x0035 }
        java.lang.String r0 = byteArrayToHex(r1)     // Catch:{ all -> 0x0035 }
        r2.close()     // Catch:{ Exception -> 0x0027 }
        goto L_0x002b
    L_0x0027:
        r1 = move-exception
        r1.printStackTrace()
    L_0x002b:
        r4.close()     // Catch:{ Exception -> 0x002f }
        goto L_0x0033
    L_0x002f:
        r4 = move-exception
        r4.printStackTrace()
    L_0x0033:
        return r0
    L_0x0034:
        r2 = r0
    L_0x0035:
        r2.close()     // Catch:{ Exception -> 0x0039 }
        goto L_0x003d
    L_0x0039:
        r1 = move-exception
        r1.printStackTrace()
    L_0x003d:
        r4.close()     // Catch:{ Exception -> 0x0041 }
        goto L_0x0045
    L_0x0041:
        r4 = move-exception
        r4.printStackTrace()
    L_0x0045:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.utils.MD5Util.getMd5(java.io.InputStream):java.lang.String");
    }

    public static byte[] intToByteArray(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }
}
