package com.tencent.p605ep.commonbase.utils;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.tencent.ep.commonbase.utils.XxteaCryptor */
public class XxteaCryptor {
    private static final String key = "DFG#$%^#%$RGHR(&*M<><";

    private XxteaCryptor() {
    }

    public static int EndianSwap(int i) {
        return (i >>> 24) | (i << 24) | ((65280 & i) << 8) | ((16711680 & i) >>> 8);
    }

    public static byte[] MakePassword(byte[] bArr) {
        if (bArr == null || bArr.length <= 16) {
            return bArr;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            return instance.digest();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    @Deprecated
    public static byte[] decryptV1(byte[] bArr, byte[] bArr2) {
        byte[] MakePassword = MakePassword(bArr2);
        if (bArr == null || MakePassword == null || bArr.length == 0) {
            return bArr;
        }
        if (bArr.length % 4 == 0 && bArr.length >= 8) {
            int[] iArr = new int[(bArr.length >>> 2)];
            toIntArray(bArr, iArr);
            int length = MakePassword.length % 4 == 0 ? MakePassword.length >>> 2 : (MakePassword.length >>> 2) + 1;
            if (length < 4) {
                length = 4;
            }
            int[] iArr2 = new int[length];
            for (int i = 0; i < length; i++) {
                iArr2[i] = 0;
            }
            toIntArray(MakePassword, iArr2);
            int length2 = iArr.length - 1;
            int i2 = iArr[length2];
            int i3 = iArr[0];
            for (int i4 = ((52 / (length2 + 1)) + 6) * -1640531527; i4 != 0; i4 -= -1640531527) {
                int i5 = (i4 >>> 2) & 3;
                int i6 = i3;
                int i7 = length2;
                while (i7 > 0) {
                    int i8 = iArr[i7 - 1];
                    i6 = iArr[i7] - (((i6 ^ i4) + (i8 ^ iArr2[(i7 & 3) ^ i5])) ^ (((i8 >>> 5) ^ (i6 << 2)) + ((i6 >>> 3) ^ (i8 << 4))));
                    iArr[i7] = i6;
                    i7--;
                }
                int i9 = iArr[length2];
                i3 = iArr[0] - ((((i9 >>> 5) ^ (i6 << 2)) + ((i6 >>> 3) ^ (i9 << 4))) ^ ((i6 ^ i4) + (iArr2[(i7 & 3) ^ i5] ^ i9)));
                iArr[0] = i3;
            }
            int i10 = iArr[iArr.length - 1];
            if (i10 >= 0 && i10 <= ((iArr.length - 1) << 2)) {
                byte[] bArr3 = new byte[i10];
                toByteArray(iArr, iArr.length - 1, bArr3);
                return bArr3;
            }
        }
        return null;
    }

    public static byte[] decryptV2(byte[] bArr, byte[] bArr2) {
        if (bArr2 == null) {
            bArr2 = getKey();
        }
        return decryptV1(bArr, bArr2);
    }

    @Deprecated
    public static byte[] encryptV1(byte[] bArr, byte[] bArr2) {
        byte[] MakePassword = MakePassword(bArr2);
        if (bArr == null || MakePassword == null || bArr.length == 0) {
            return bArr;
        }
        int length = bArr.length % 4 == 0 ? (bArr.length >>> 2) + 1 : (bArr.length >>> 2) + 2;
        int[] iArr = new int[length];
        toIntArray(bArr, iArr);
        iArr[length - 1] = bArr.length;
        int length2 = MakePassword.length % 4 == 0 ? MakePassword.length >>> 2 : (MakePassword.length >>> 2) + 1;
        if (length2 < 4) {
            length2 = 4;
        }
        int[] iArr2 = new int[length2];
        for (int i = 0; i < length2; i++) {
            iArr2[i] = 0;
        }
        toIntArray(MakePassword, iArr2);
        int length3 = iArr.length - 1;
        int i2 = iArr[length3];
        int i3 = iArr[0];
        int i4 = (52 / (length3 + 1)) + 6;
        int i5 = i2;
        int i6 = 0;
        while (true) {
            int i7 = i4 - 1;
            if (i4 > 0) {
                i6 -= 1640531527;
                int i8 = (i6 >>> 2) & 3;
                int i9 = i5;
                int i10 = 0;
                while (i10 < length3) {
                    int i11 = i10 + 1;
                    int i12 = iArr[i11];
                    i9 = ((((i9 >>> 5) ^ (i12 << 2)) + ((i12 >>> 3) ^ (i9 << 4))) ^ ((i12 ^ i6) + (i9 ^ iArr2[(i10 & 3) ^ i8]))) + iArr[i10];
                    iArr[i10] = i9;
                    i10 = i11;
                }
                int i13 = iArr[0];
                i5 = ((((i9 >>> 5) ^ (i13 << 2)) + ((i13 >>> 3) ^ (i9 << 4))) ^ ((i13 ^ i6) + (iArr2[(i10 & 3) ^ i8] ^ i9))) + iArr[length3];
                iArr[length3] = i5;
                i4 = i7;
            } else {
                byte[] bArr3 = new byte[(iArr.length << 2)];
                toByteArray(iArr, iArr.length, bArr3);
                return bArr3;
            }
        }
    }

    public static byte[] encryptV2(byte[] bArr, byte[] bArr2) {
        if (bArr2 == null) {
            bArr2 = getKey();
        }
        return encryptV1(bArr, bArr2);
    }

    public static byte[] getKey() {
        try {
            return key.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void toByteArray(int[] iArr, int i, byte[] bArr) {
        int i2;
        int length = bArr.length >> 2;
        if (length > i) {
            length = i;
        }
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i2 = 8;
            if (i3 >= length) {
                break;
            }
            int i5 = i4 + 1;
            bArr[i4] = (byte) (iArr[i3] & 255);
            int i6 = i5 + 1;
            bArr[i5] = (byte) ((iArr[i3] >>> 8) & 255);
            int i7 = i6 + 1;
            bArr[i6] = (byte) ((iArr[i3] >>> 16) & 255);
            i4 = i7 + 1;
            bArr[i7] = (byte) ((iArr[i3] >>> 24) & 255);
            i3++;
        }
        if (i > length && i4 < bArr.length) {
            int i8 = i4 + 1;
            bArr[i4] = (byte) (iArr[i3] & 255);
            while (i2 <= 24 && i8 < bArr.length) {
                int i9 = i8 + 1;
                bArr[i8] = (byte) ((iArr[i3] >>> i2) & 255);
                i2 += 8;
                i8 = i9;
            }
        }
    }

    private static void toIntArray(byte[] bArr, int[] iArr) {
        int length = bArr.length >> 2;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i2 + 1;
            iArr[i] = bArr[i2] & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
            int i4 = i3 + 1;
            iArr[i] = iArr[i] | ((bArr[i3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8);
            int i5 = i4 + 1;
            iArr[i] = iArr[i] | ((bArr[i4] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 16);
            int i6 = i5 + 1;
            iArr[i] = iArr[i] | ((bArr[i5] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 24);
            i++;
            i2 = i6;
        }
        if (i2 < bArr.length) {
            int i7 = i2 + 1;
            iArr[i] = bArr[i2] & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
            int i8 = 8;
            while (i7 < bArr.length) {
                iArr[i] = iArr[i] | ((bArr[i7] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << i8);
                i7++;
                i8 += 8;
            }
        }
    }
}
