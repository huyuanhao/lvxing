package org.apache.thrift;

import com.tencent.bigdata.dataacquisition.DeviceInfos;

/* renamed from: org.apache.thrift.a */
public class EncodingUtils {
    /* renamed from: a */
    public static final boolean m36971a(int i, int i2) {
        return (i & (1 << i2)) != 0;
    }

    /* renamed from: b */
    public static final int m36973b(int i, int i2) {
        return i & (~(1 << i2));
    }

    /* renamed from: a */
    public static final int m36968a(byte[] bArr) {
        return m36969a(bArr, 0);
    }

    /* renamed from: a */
    public static final int m36969a(byte[] bArr, int i) {
        return (bArr[i + 3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) | ((bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 24) | ((bArr[i + 1] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 16) | ((bArr[i + 2] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8);
    }

    /* renamed from: a */
    public static final boolean m36970a(byte b, int i) {
        return m36971a((int) b, i);
    }

    /* renamed from: b */
    public static final byte m36972b(byte b, int i) {
        return (byte) m36973b((int) b, i);
    }

    /* renamed from: a */
    public static final byte m36966a(byte b, int i, boolean z) {
        return (byte) m36967a((int) b, i, z);
    }

    /* renamed from: a */
    public static final int m36967a(int i, int i2, boolean z) {
        return z ? i | (1 << i2) : m36973b(i, i2);
    }
}
