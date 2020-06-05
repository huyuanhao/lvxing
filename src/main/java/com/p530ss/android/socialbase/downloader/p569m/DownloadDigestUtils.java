package com.p530ss.android.socialbase.downloader.p569m;

import com.tencent.bigdata.dataacquisition.DeviceInfos;

/* renamed from: com.ss.android.socialbase.downloader.m.b */
public class DownloadDigestUtils {
    /* renamed from: a */
    static final char[] f22366a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: a */
    public static String m28742a(byte[] bArr) {
        if (bArr != null) {
            return m28743a(bArr, 0, bArr.length);
        }
        throw new NullPointerException("bytes is null");
    }

    /* renamed from: a */
    public static String m28743a(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        } else if (i < 0 || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        } else {
            int i3 = i2 * 2;
            char[] cArr = new char[i3];
            int i4 = 0;
            for (int i5 = 0; i5 < i2; i5++) {
                byte b = bArr[i5 + i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
                int i6 = i4 + 1;
                char[] cArr2 = f22366a;
                cArr[i4] = cArr2[b >> 4];
                i4 = i6 + 1;
                cArr[i6] = cArr2[b & 15];
            }
            return new String(cArr, 0, i3);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0036 A[SYNTHETIC, Splitter:B:22:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0042 A[SYNTHETIC, Splitter:B:31:0x0042] */
    /* renamed from: a */
    public static java.lang.String m28741a(java.io.File r5) {
        /*
        r0 = 0
        java.lang.String r1 = "MD5"
        java.security.MessageDigest r1 = java.security.MessageDigest.getInstance(r1)     // Catch:{ Exception -> 0x003f, all -> 0x0032 }
        if (r1 != 0) goto L_0x000a
        return r0
    L_0x000a:
        java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x003f, all -> 0x0032 }
        r2.<init>(r5)     // Catch:{ Exception -> 0x003f, all -> 0x0032 }
        r5 = 8192(0x2000, float:1.14794E-41)
        byte[] r5 = new byte[r5]     // Catch:{ Exception -> 0x0040, all -> 0x0030 }
    L_0x0013:
        int r3 = r5.length     // Catch:{ Exception -> 0x0040, all -> 0x0030 }
        r4 = 0
        int r3 = r2.read(r5, r4, r3)     // Catch:{ Exception -> 0x0040, all -> 0x0030 }
        if (r3 <= 0) goto L_0x001f
        r1.update(r5, r4, r3)     // Catch:{ Exception -> 0x0040, all -> 0x0030 }
        goto L_0x0013
    L_0x001f:
        byte[] r5 = r1.digest()     // Catch:{ Exception -> 0x0040, all -> 0x0030 }
        java.lang.String r5 = m28742a(r5)     // Catch:{ Exception -> 0x0040, all -> 0x0030 }
        r2.close()     // Catch:{ IOException -> 0x002b }
        goto L_0x002f
    L_0x002b:
        r0 = move-exception
        r0.printStackTrace()
    L_0x002f:
        return r5
    L_0x0030:
        r5 = move-exception
        goto L_0x0034
    L_0x0032:
        r5 = move-exception
        r2 = r0
    L_0x0034:
        if (r2 == 0) goto L_0x003e
        r2.close()     // Catch:{ IOException -> 0x003a }
        goto L_0x003e
    L_0x003a:
        r0 = move-exception
        r0.printStackTrace()
    L_0x003e:
        throw r5
    L_0x003f:
        r2 = r0
    L_0x0040:
        if (r2 == 0) goto L_0x004a
        r2.close()     // Catch:{ IOException -> 0x0046 }
        goto L_0x004a
    L_0x0046:
        r5 = move-exception
        r5.printStackTrace()
    L_0x004a:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.downloader.p569m.DownloadDigestUtils.m28741a(java.io.File):java.lang.String");
    }
}
