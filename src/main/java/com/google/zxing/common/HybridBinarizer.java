package com.google.zxing.common;

import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.lang.reflect.Array;

public final class HybridBinarizer extends GlobalHistogramBinarizer {
    private static final int BLOCK_SIZE = 8;
    private static final int BLOCK_SIZE_MASK = 7;
    private static final int BLOCK_SIZE_POWER = 3;
    private static final int MINIMUM_DIMENSION = 40;
    private static final int MIN_DYNAMIC_RANGE = 24;
    private BitMatrix matrix;

    private static int cap(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    public HybridBinarizer(LuminanceSource luminanceSource) {
        super(luminanceSource);
    }

    public BitMatrix getBlackMatrix() throws NotFoundException {
        BitMatrix bitMatrix = this.matrix;
        if (bitMatrix != null) {
            return bitMatrix;
        }
        LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        int height = luminanceSource.getHeight();
        if (width < 40 || height < 40) {
            this.matrix = super.getBlackMatrix();
        } else {
            byte[] matrix2 = luminanceSource.getMatrix();
            int i = width >> 3;
            if ((width & 7) != 0) {
                i++;
            }
            int i2 = i;
            int i3 = height >> 3;
            if ((height & 7) != 0) {
                i3++;
            }
            int i4 = i3;
            int[][] calculateBlackPoints = calculateBlackPoints(matrix2, i2, i4, width, height);
            BitMatrix bitMatrix2 = new BitMatrix(width, height);
            calculateThresholdForBlock(matrix2, i2, i4, width, height, calculateBlackPoints, bitMatrix2);
            this.matrix = bitMatrix2;
        }
        return this.matrix;
    }

    public Binarizer createBinarizer(LuminanceSource luminanceSource) {
        return new HybridBinarizer(luminanceSource);
    }

    private static void calculateThresholdForBlock(byte[] bArr, int i, int i2, int i3, int i4, int[][] iArr, BitMatrix bitMatrix) {
        int i5 = i;
        int i6 = i2;
        int i7 = i4 - 8;
        int i8 = i3 - 8;
        for (int i9 = 0; i9 < i6; i9++) {
            int i10 = i9 << 3;
            int i11 = i10 > i7 ? i7 : i10;
            int cap = cap(i9, 2, i6 - 3);
            for (int i12 = 0; i12 < i5; i12++) {
                int i13 = i12 << 3;
                int i14 = i13 > i8 ? i8 : i13;
                int cap2 = cap(i12, 2, i5 - 3);
                int i15 = 0;
                for (int i16 = -2; i16 <= 2; i16++) {
                    int[] iArr2 = iArr[cap + i16];
                    i15 += iArr2[cap2 - 2] + iArr2[cap2 - 1] + iArr2[cap2] + iArr2[cap2 + 1] + iArr2[cap2 + 2];
                }
                thresholdBlock(bArr, i14, i11, i15 / 25, i3, bitMatrix);
            }
        }
    }

    private static void thresholdBlock(byte[] bArr, int i, int i2, int i3, int i4, BitMatrix bitMatrix) {
        int i5 = (i2 * i4) + i;
        int i6 = 0;
        while (i6 < 8) {
            for (int i7 = 0; i7 < 8; i7++) {
                if ((bArr[i5 + i7] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) <= i3) {
                    bitMatrix.set(i + i7, i2 + i6);
                }
            }
            i6++;
            i5 += i4;
        }
    }

    private static int[][] calculateBlackPoints(byte[] bArr, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = i;
        int i10 = i2;
        int i11 = 8;
        int i12 = i4 - 8;
        int i13 = i3 - 8;
        int[][] iArr = (int[][]) Array.newInstance(int.class, new int[]{i10, i9});
        for (int i14 = 0; i14 < i10; i14++) {
            int i15 = i14 << 3;
            if (i15 > i12) {
                i15 = i12;
            }
            int i16 = 0;
            while (i16 < i9) {
                int i17 = i16 << 3;
                if (i17 > i13) {
                    i17 = i13;
                }
                int i18 = (i15 * i3) + i17;
                int i19 = 0;
                int i20 = 0;
                byte b = 0;
                byte b2 = DeviceInfos.NETWORK_TYPE_UNCONNECTED;
                while (i7 < i5) {
                    int i21 = i20;
                    int i22 = 0;
                    while (i22 < i5) {
                        byte b3 = bArr[i6 + i22] & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
                        i21 += b3;
                        if (b3 < b2) {
                            b2 = b3;
                        }
                        if (b3 > b) {
                            b = b3;
                        }
                        i22++;
                        i5 = 8;
                    }
                    if (b - b2 > 24) {
                        i7++;
                        i6 += i3;
                        i5 = 8;
                        while (i7 < 8) {
                            for (int i23 = 0; i23 < 8; i23++) {
                                i21 += bArr[i6 + i23] & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
                            }
                            i7++;
                            i6 += i3;
                        }
                    } else {
                        i5 = 8;
                    }
                    i20 = i8;
                    i19 = i7 + 1;
                    i18 = i6 + i3;
                }
                int i24 = i20 >> 6;
                if (b - b2 <= 24) {
                    i24 = b2 / 2;
                    if (i14 > 0 && i16 > 0) {
                        int i25 = i14 - 1;
                        int i26 = i16 - 1;
                        int i27 = ((iArr[i25][i16] + (iArr[i14][i26] * 2)) + iArr[i25][i26]) / 4;
                        if (b2 < i27) {
                            i24 = i27;
                        }
                    }
                }
                iArr[i14][i16] = i24;
                i16++;
            }
        }
        return iArr;
    }
}
