package btmsdkobf;

import com.tencent.bigdata.dataacquisition.DeviceInfos;

/* renamed from: btmsdkobf.d */
public class C0674d {
    /* renamed from: a */
    private static byte m217a(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    /* renamed from: a */
    public static final String m218a(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length);
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
            if (hexString.length() < 2) {
                stringBuffer.append(0);
            }
            stringBuffer.append(hexString.toUpperCase());
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static byte[] m219a(String str) {
        if (str == null || str.trim().length() <= 0) {
            return new byte[0];
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        char[] charArray = str.toCharArray();
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (m217a(charArray[i2 + 1]) | (m217a(charArray[i2]) << 4));
        }
        return bArr;
    }

    /* renamed from: b */
    public static int m220b(byte[] bArr) {
        if (bArr == null || bArr.length <= 0 || bArr.length != 4) {
            return 0;
        }
        return ((bArr[3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 24) | (bArr[0] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) | ((bArr[1] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8) | ((bArr[2] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 16);
    }
}
