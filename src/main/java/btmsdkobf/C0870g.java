package btmsdkobf;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: btmsdkobf.g */
public class C0870g {
    /* renamed from: o */
    private static final char[] f1034o = "0123456789abcdef".toCharArray();

    /* renamed from: c */
    public static byte[] m964c(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            return instance.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: d */
    public static String m965d(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 3);
        for (byte b : bArr) {
            byte b2 = b & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
            sb.append(f1034o[b2 >> 4]);
            sb.append(f1034o[b2 & 15]);
        }
        return sb.toString().toUpperCase();
    }

    /* renamed from: e */
    public static String m966e(byte[] bArr) {
        return m965d(m964c(bArr));
    }
}
