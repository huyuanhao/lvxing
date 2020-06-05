package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;

final class BitMatrixParser {
    private final BitMatrix mappingBitMatrix;
    private final BitMatrix readMappingMatrix;
    private final Version version;

    BitMatrixParser(BitMatrix bitMatrix) throws FormatException {
        int height = bitMatrix.getHeight();
        if (height < 8 || height > 144 || (height & 1) != 0) {
            throw FormatException.getFormatInstance();
        }
        this.version = readVersion(bitMatrix);
        this.mappingBitMatrix = extractDataRegion(bitMatrix);
        this.readMappingMatrix = new BitMatrix(this.mappingBitMatrix.getWidth(), this.mappingBitMatrix.getHeight());
    }

    /* access modifiers changed from: 0000 */
    public Version getVersion() {
        return this.version;
    }

    private static Version readVersion(BitMatrix bitMatrix) throws FormatException {
        return Version.getVersionForDimensions(bitMatrix.getHeight(), bitMatrix.getWidth());
    }

    /* access modifiers changed from: 0000 */
    public byte[] readCodewords() throws FormatException {
        byte[] bArr = new byte[this.version.getTotalCodewords()];
        int height = this.mappingBitMatrix.getHeight();
        int width = this.mappingBitMatrix.getWidth();
        int i = 4;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        while (true) {
            if (i == height && i2 == 0 && !z) {
                int i4 = i3 + 1;
                bArr[i3] = (byte) readCorner1(height, width);
                i -= 2;
                i2 += 2;
                i3 = i4;
                z = true;
            } else {
                int i5 = height - 2;
                if (i == i5 && i2 == 0 && (width & 3) != 0 && !z2) {
                    int i6 = i3 + 1;
                    bArr[i3] = (byte) readCorner2(height, width);
                    i -= 2;
                    i2 += 2;
                    i3 = i6;
                    z2 = true;
                } else if (i == height + 4 && i2 == 2 && (width & 7) == 0 && !z3) {
                    int i7 = i3 + 1;
                    bArr[i3] = (byte) readCorner3(height, width);
                    i -= 2;
                    i2 += 2;
                    i3 = i7;
                    z3 = true;
                } else if (i == i5 && i2 == 0 && (width & 7) == 4 && !z4) {
                    int i8 = i3 + 1;
                    bArr[i3] = (byte) readCorner4(height, width);
                    i -= 2;
                    i2 += 2;
                    i3 = i8;
                    z4 = true;
                } else {
                    do {
                        if (i < height && i2 >= 0 && !this.readMappingMatrix.get(i2, i)) {
                            int i9 = i3 + 1;
                            bArr[i3] = (byte) readUtah(i, i2, height, width);
                            i3 = i9;
                        }
                        i -= 2;
                        i2 += 2;
                        if (i < 0) {
                            break;
                        }
                    } while (i2 < width);
                    int i10 = i + 1;
                    int i11 = i2 + 3;
                    do {
                        if (i10 >= 0 && i11 < width && !this.readMappingMatrix.get(i11, i10)) {
                            int i12 = i3 + 1;
                            bArr[i3] = (byte) readUtah(i10, i11, height, width);
                            i3 = i12;
                        }
                        i10 += 2;
                        i11 -= 2;
                        if (i10 >= height) {
                            break;
                        }
                    } while (i11 >= 0);
                    i = i10 + 3;
                    i2 = i11 + 1;
                }
            }
            if (i >= height && i2 >= width) {
                break;
            }
        }
        if (i3 == this.version.getTotalCodewords()) {
            return bArr;
        }
        throw FormatException.getFormatInstance();
    }

    private boolean readModule(int i, int i2, int i3, int i4) {
        if (i < 0) {
            i += i3;
            i2 += 4 - ((i3 + 4) & 7);
        }
        if (i2 < 0) {
            i2 += i4;
            i += 4 - ((i4 + 4) & 7);
        }
        this.readMappingMatrix.set(i2, i);
        return this.mappingBitMatrix.get(i2, i);
    }

    private int readUtah(int i, int i2, int i3, int i4) {
        int i5 = i - 2;
        int i6 = i2 - 2;
        int readModule = readModule(i5, i6, i3, i4) << true;
        int i7 = i2 - 1;
        if (readModule(i5, i7, i3, i4)) {
            readModule |= 1;
        }
        int i8 = readModule << 1;
        int i9 = i - 1;
        if (readModule(i9, i6, i3, i4)) {
            i8 |= 1;
        }
        int i10 = i8 << 1;
        if (readModule(i9, i7, i3, i4)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        if (readModule(i9, i2, i3, i4)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (readModule(i, i6, i3, i4)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (readModule(i, i7, i3, i4)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        return readModule(i, i2, i3, i4) ? i14 | 1 : i14;
    }

    private int readCorner1(int i, int i2) {
        int i3 = i - 1;
        int readModule = readModule(i3, 0, i, i2) << true;
        if (readModule(i3, 1, i, i2)) {
            readModule |= 1;
        }
        int i4 = readModule << 1;
        if (readModule(i3, 2, i, i2)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (readModule(0, i2 - 2, i, i2)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        int i7 = i2 - 1;
        if (readModule(0, i7, i, i2)) {
            i6 |= 1;
        }
        int i8 = i6 << 1;
        if (readModule(1, i7, i, i2)) {
            i8 |= 1;
        }
        int i9 = i8 << 1;
        if (readModule(2, i7, i, i2)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        return readModule(3, i7, i, i2) ? i10 | 1 : i10;
    }

    private int readCorner2(int i, int i2) {
        int readModule = readModule(i - 3, 0, i, i2) << true;
        if (readModule(i - 2, 0, i, i2)) {
            readModule |= 1;
        }
        int i3 = readModule << 1;
        if (readModule(i - 1, 0, i, i2)) {
            i3 |= 1;
        }
        int i4 = i3 << 1;
        if (readModule(0, i2 - 4, i, i2)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (readModule(0, i2 - 3, i, i2)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (readModule(0, i2 - 2, i, i2)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        int i8 = i2 - 1;
        if (readModule(0, i8, i, i2)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        return readModule(1, i8, i, i2) ? i9 | 1 : i9;
    }

    private int readCorner3(int i, int i2) {
        int i3 = i - 1;
        int readModule = readModule(i3, 0, i, i2) << true;
        int i4 = i2 - 1;
        if (readModule(i3, i4, i, i2)) {
            readModule |= 1;
        }
        int i5 = readModule << 1;
        int i6 = i2 - 3;
        if (readModule(0, i6, i, i2)) {
            i5 |= 1;
        }
        int i7 = i5 << 1;
        int i8 = i2 - 2;
        if (readModule(0, i8, i, i2)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        if (readModule(0, i4, i, i2)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        if (readModule(1, i6, i, i2)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        if (readModule(1, i8, i, i2)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        return readModule(1, i4, i, i2) ? i12 | 1 : i12;
    }

    private int readCorner4(int i, int i2) {
        int readModule = readModule(i - 3, 0, i, i2) << true;
        if (readModule(i - 2, 0, i, i2)) {
            readModule |= 1;
        }
        int i3 = readModule << 1;
        if (readModule(i - 1, 0, i, i2)) {
            i3 |= 1;
        }
        int i4 = i3 << 1;
        if (readModule(0, i2 - 2, i, i2)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        int i6 = i2 - 1;
        if (readModule(0, i6, i, i2)) {
            i5 |= 1;
        }
        int i7 = i5 << 1;
        if (readModule(1, i6, i, i2)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        if (readModule(2, i6, i, i2)) {
            i8 |= 1;
        }
        int i9 = i8 << 1;
        return readModule(3, i6, i, i2) ? i9 | 1 : i9;
    }

    private BitMatrix extractDataRegion(BitMatrix bitMatrix) {
        int symbolSizeRows = this.version.getSymbolSizeRows();
        int symbolSizeColumns = this.version.getSymbolSizeColumns();
        if (bitMatrix.getHeight() == symbolSizeRows) {
            int dataRegionSizeRows = this.version.getDataRegionSizeRows();
            int dataRegionSizeColumns = this.version.getDataRegionSizeColumns();
            int i = symbolSizeRows / dataRegionSizeRows;
            int i2 = symbolSizeColumns / dataRegionSizeColumns;
            BitMatrix bitMatrix2 = new BitMatrix(i2 * dataRegionSizeColumns, i * dataRegionSizeRows);
            for (int i3 = 0; i3 < i; i3++) {
                int i4 = i3 * dataRegionSizeRows;
                for (int i5 = 0; i5 < i2; i5++) {
                    int i6 = i5 * dataRegionSizeColumns;
                    for (int i7 = 0; i7 < dataRegionSizeRows; i7++) {
                        int i8 = ((dataRegionSizeRows + 2) * i3) + 1 + i7;
                        int i9 = i4 + i7;
                        for (int i10 = 0; i10 < dataRegionSizeColumns; i10++) {
                            if (bitMatrix.get(((dataRegionSizeColumns + 2) * i5) + 1 + i10, i8)) {
                                bitMatrix2.set(i6 + i10, i9);
                            }
                        }
                        BitMatrix bitMatrix3 = bitMatrix;
                    }
                    BitMatrix bitMatrix4 = bitMatrix;
                }
                BitMatrix bitMatrix5 = bitMatrix;
            }
            return bitMatrix2;
        }
        throw new IllegalArgumentException("Dimension of bitMatrix must match the version size");
    }
}
