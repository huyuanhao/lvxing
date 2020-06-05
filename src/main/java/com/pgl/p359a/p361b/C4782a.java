package com.pgl.p359a.p361b;

import com.tencent.bigdata.dataacquisition.DeviceInfos;

/* renamed from: com.pgl.a.b.a */
public class C4782a {
    /* renamed from: a */
    public static String m19607a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        char[] charArray = "0123456789abcdef".toCharArray();
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
            int i2 = i * 2;
            cArr[i2] = charArray[b >>> 4];
            cArr[i2 + 1] = charArray[b & 15];
        }
        return new String(cArr);
    }
}
