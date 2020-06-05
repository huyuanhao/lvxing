package com.google.zxing.datamatrix.decoder;

final class DataBlock {
    private final byte[] codewords;
    private final int numDataCodewords;

    private DataBlock(int i, byte[] bArr) {
        this.numDataCodewords = i;
        this.codewords = bArr;
    }

    static DataBlock[] getDataBlocks(byte[] bArr, Version version) {
        ECBlocks eCBlocks = version.getECBlocks();
        ECB[] eCBlocks2 = eCBlocks.getECBlocks();
        int i = 0;
        for (ECB count : eCBlocks2) {
            i += count.getCount();
        }
        DataBlock[] dataBlockArr = new DataBlock[i];
        int length = eCBlocks2.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            ECB ecb = eCBlocks2[i2];
            int i4 = i3;
            int i5 = 0;
            while (i5 < ecb.getCount()) {
                int dataCodewords = ecb.getDataCodewords();
                int i6 = i4 + 1;
                dataBlockArr[i4] = new DataBlock(dataCodewords, new byte[(eCBlocks.getECCodewords() + dataCodewords)]);
                i5++;
                i4 = i6;
            }
            i2++;
            i3 = i4;
        }
        int length2 = dataBlockArr[0].codewords.length - eCBlocks.getECCodewords();
        int i7 = length2 - 1;
        int i8 = 0;
        int i9 = 0;
        while (i8 < i7) {
            int i10 = i9;
            int i11 = 0;
            while (i11 < i3) {
                int i12 = i10 + 1;
                dataBlockArr[i11].codewords[i8] = bArr[i10];
                i11++;
                i10 = i12;
            }
            i8++;
            i9 = i10;
        }
        boolean z = version.getVersionNumber() == 24;
        int i13 = z ? 8 : i3;
        int i14 = i9;
        int i15 = 0;
        while (i15 < i13) {
            int i16 = i14 + 1;
            dataBlockArr[i15].codewords[i7] = bArr[i14];
            i15++;
            i14 = i16;
        }
        int length3 = dataBlockArr[0].codewords.length;
        while (length2 < length3) {
            int i17 = 0;
            while (i17 < i3) {
                int i18 = z ? (i17 + 8) % i3 : i17;
                int i19 = (!z || i18 <= 7) ? length2 : length2 - 1;
                int i20 = i14 + 1;
                dataBlockArr[i18].codewords[i19] = bArr[i14];
                i17++;
                i14 = i20;
            }
            length2++;
        }
        if (i14 == bArr.length) {
            return dataBlockArr;
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: 0000 */
    public int getNumDataCodewords() {
        return this.numDataCodewords;
    }

    /* access modifiers changed from: 0000 */
    public byte[] getCodewords() {
        return this.codewords;
    }
}
