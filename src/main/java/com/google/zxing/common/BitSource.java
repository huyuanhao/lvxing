package com.google.zxing.common;

import com.tencent.bigdata.dataacquisition.DeviceInfos;

public final class BitSource {
    private int bitOffset;
    private int byteOffset;
    private final byte[] bytes;

    public BitSource(byte[] bArr) {
        this.bytes = bArr;
    }

    public int getBitOffset() {
        return this.bitOffset;
    }

    public int getByteOffset() {
        return this.byteOffset;
    }

    public int readBits(int i) {
        byte b;
        if (i <= 0 || i > 32 || i > available()) {
            throw new IllegalArgumentException(String.valueOf(i));
        }
        int i2 = this.bitOffset;
        if (i2 > 0) {
            int i3 = 8 - i2;
            int i4 = i < i3 ? i : i3;
            int i5 = i3 - i4;
            int i6 = (255 >> (8 - i4)) << i5;
            byte[] bArr = this.bytes;
            int i7 = this.byteOffset;
            b = (i6 & bArr[i7]) >> i5;
            i -= i4;
            this.bitOffset += i4;
            if (this.bitOffset == 8) {
                this.bitOffset = 0;
                this.byteOffset = i7 + 1;
            }
        } else {
            b = 0;
        }
        if (i <= 0) {
            return b;
        }
        while (i >= 8) {
            int i8 = b << 8;
            byte[] bArr2 = this.bytes;
            int i9 = this.byteOffset;
            b = i8 | (bArr2[i9] & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
            this.byteOffset = i9 + 1;
            i -= 8;
        }
        if (i <= 0) {
            return b;
        }
        int i10 = 8 - i;
        int i11 = (b << i) | ((((255 >> i10) << i10) & this.bytes[this.byteOffset]) >> i10);
        this.bitOffset += i;
        return i11;
    }

    public int available() {
        return ((this.bytes.length - this.byteOffset) * 8) - this.bitOffset;
    }
}
