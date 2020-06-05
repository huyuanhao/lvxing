package com.bytedance.embedapplog.util;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.security.MessageDigest;

/* renamed from: com.bytedance.embedapplog.util.b */
public class C1850b {
    /* renamed from: a */
    private static final char[] f5219a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: a */
    public static String m6559a(byte[] bArr) {
        if (bArr != null) {
            return m6560a(bArr, 0, bArr.length);
        }
        throw new NullPointerException("bytes is null");
    }

    /* renamed from: a */
    public static String m6560a(byte[] bArr, int i, int i2) {
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
                char[] cArr2 = f5219a;
                cArr[i4] = cArr2[b >> 4];
                i4 = i6 + 1;
                cArr[i6] = cArr2[b & 15];
            }
            return new String(cArr, 0, i3);
        }
    }

    /* renamed from: b */
    public static String m6561b(byte[] bArr) {
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    MessageDigest instance = MessageDigest.getInstance("MD5");
                    instance.update(bArr);
                    return m6559a(instance.digest());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
