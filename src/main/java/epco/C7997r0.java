package epco;

import com.tencent.android.tpush.common.Constants;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.nio.ByteBuffer;

/* renamed from: epco.r0 */
public class C7997r0 {
    /* renamed from: a */
    public static short m34599a(ByteBuffer byteBuffer) {
        return (short) (byteBuffer.get() & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
    }

    /* renamed from: a */
    public static byte[] m34600a(ByteBuffer byteBuffer, int i) {
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        return bArr;
    }

    /* renamed from: b */
    public static long m34601b(ByteBuffer byteBuffer) {
        return ((long) byteBuffer.getInt()) & C7962d0.f27060j;
    }

    /* renamed from: b */
    public static String m34602b(ByteBuffer byteBuffer, int i) {
        StringBuilder sb = new StringBuilder(i);
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(byteBuffer.getChar());
        }
        return sb.toString();
    }

    /* renamed from: c */
    public static int m34603c(ByteBuffer byteBuffer) {
        return byteBuffer.getShort() & Constants.PROTOCOL_NONE;
    }

    /* renamed from: c */
    public static void m34604c(ByteBuffer byteBuffer, int i) {
        byteBuffer.position(byteBuffer.position() + i);
    }
}
