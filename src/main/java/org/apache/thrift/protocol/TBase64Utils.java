package org.apache.thrift.protocol;

import com.p522qq.taf.jce.JceStruct;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import com.tencent.p605ep.commonbase.utils.ScreenUtil;

/* renamed from: org.apache.thrift.protocol.a */
class TBase64Utils {
    /* renamed from: a */
    private static final byte[] f29145a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, JceStruct.STRUCT_END, JceStruct.ZERO_TAG, JceStruct.SIMPLE_LIST, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    /* renamed from: a */
    static final void m37196a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        byte[] bArr3 = f29145a;
        int i4 = i + 1;
        bArr2[i3] = (byte) ((bArr3[bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED] << 2) | (bArr3[bArr[i4] & DeviceInfos.NETWORK_TYPE_UNCONNECTED] >> 4));
        if (i2 > 2) {
            int i5 = i + 2;
            bArr2[i3 + 1] = (byte) (((bArr3[bArr[i4] & DeviceInfos.NETWORK_TYPE_UNCONNECTED] << 4) & ScreenUtil.G8_WIDTH) | (bArr3[bArr[i5] & DeviceInfos.NETWORK_TYPE_UNCONNECTED] >> 2));
            if (i2 > 3) {
                bArr2[i3 + 2] = (byte) (bArr3[bArr[i + 3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED] | ((bArr3[bArr[i5] & DeviceInfos.NETWORK_TYPE_UNCONNECTED] << 6) & -64));
            }
        }
    }
}
