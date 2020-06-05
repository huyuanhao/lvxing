package com.google.zxing.pdf417.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.pdf417.PDF417Common;
import com.google.zxing.pdf417.decoder.p240ec.ErrorCorrection;
import java.lang.reflect.Array;
import java.util.ArrayList;

public final class PDF417ScanningDecoder {
    private static final int CODEWORD_SKEW_SIZE = 2;
    private static final int MAX_EC_CODEWORDS = 512;
    private static final int MAX_ERRORS = 3;
    private static final ErrorCorrection errorCorrection = new ErrorCorrection();

    private static boolean checkCodewordSkew(int i, int i2, int i3) {
        return i2 + -2 <= i && i <= i3 + 2;
    }

    private static int getNumberOfECCodeWords(int i) {
        return 2 << i;
    }

    private PDF417ScanningDecoder() {
    }

    public static DecoderResult decode(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i, int i2) throws NotFoundException, FormatException, ChecksumException {
        DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn;
        DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2;
        DetectionResultColumn detectionResultColumn;
        int i3;
        int i4;
        int i5;
        BoundingBox boundingBox = new BoundingBox(bitMatrix, resultPoint, resultPoint2, resultPoint3, resultPoint4);
        DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn3 = null;
        DetectionResult detectionResult = null;
        DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn4 = null;
        BoundingBox boundingBox2 = boundingBox;
        int i6 = 0;
        while (true) {
            if (i6 >= 2) {
                detectionResultRowIndicatorColumn = detectionResultRowIndicatorColumn3;
                break;
            }
            if (resultPoint != null) {
                detectionResultRowIndicatorColumn3 = getRowIndicatorColumn(bitMatrix, boundingBox2, resultPoint, true, i, i2);
            }
            detectionResultRowIndicatorColumn = detectionResultRowIndicatorColumn3;
            if (resultPoint3 != null) {
                detectionResultRowIndicatorColumn4 = getRowIndicatorColumn(bitMatrix, boundingBox2, resultPoint3, false, i, i2);
            }
            detectionResult = merge(detectionResultRowIndicatorColumn, detectionResultRowIndicatorColumn4);
            if (detectionResult == null) {
                throw NotFoundException.getNotFoundInstance();
            } else if (i6 != 0 || detectionResult.getBoundingBox() == null || (detectionResult.getBoundingBox().getMinY() >= boundingBox2.getMinY() && detectionResult.getBoundingBox().getMaxY() <= boundingBox2.getMaxY())) {
                detectionResult.setBoundingBox(boundingBox2);
            } else {
                boundingBox2 = detectionResult.getBoundingBox();
                i6++;
                detectionResultRowIndicatorColumn3 = detectionResultRowIndicatorColumn;
            }
        }
        int barcodeColumnCount = detectionResult.getBarcodeColumnCount() + 1;
        detectionResult.setDetectionResultColumn(0, detectionResultRowIndicatorColumn);
        detectionResult.setDetectionResultColumn(barcodeColumnCount, detectionResultRowIndicatorColumn2);
        boolean z = detectionResultRowIndicatorColumn != null;
        int i7 = i;
        int i8 = i2;
        int i9 = 1;
        while (i9 <= barcodeColumnCount) {
            int i10 = z ? i9 : barcodeColumnCount - i9;
            if (detectionResult.getDetectionResultColumn(i10) == null) {
                if (i10 == 0 || i10 == barcodeColumnCount) {
                    detectionResultColumn = new DetectionResultRowIndicatorColumn(boundingBox2, i10 == 0);
                } else {
                    detectionResultColumn = new DetectionResultColumn(boundingBox2);
                }
                detectionResult.setDetectionResultColumn(i10, detectionResultColumn);
                int i11 = -1;
                int i12 = i8;
                int i13 = -1;
                int i14 = i7;
                int minY = boundingBox2.getMinY();
                while (minY <= boundingBox2.getMaxY()) {
                    int startColumn = getStartColumn(detectionResult, i10, minY, z);
                    if (startColumn >= 0 && startColumn <= boundingBox2.getMaxX()) {
                        i5 = startColumn;
                    } else if (i13 != i11) {
                        i5 = i13;
                    } else {
                        i3 = i13;
                        i4 = i12;
                        i12 = i4;
                        i13 = i3;
                        minY++;
                        i11 = -1;
                    }
                    i3 = i13;
                    int i15 = i12;
                    Codeword detectCodeword = detectCodeword(bitMatrix, boundingBox2.getMinX(), boundingBox2.getMaxX(), z, i5, minY, i14, i15);
                    if (detectCodeword != null) {
                        detectionResultColumn.setCodeword(minY, detectCodeword);
                        i14 = Math.min(i14, detectCodeword.getWidth());
                        i12 = Math.max(i15, detectCodeword.getWidth());
                        i13 = i5;
                        minY++;
                        i11 = -1;
                    } else {
                        i4 = i15;
                        i12 = i4;
                        i13 = i3;
                        minY++;
                        i11 = -1;
                    }
                }
                i7 = i14;
                i8 = i12;
            }
            i9++;
        }
        return createDecoderResult(detectionResult);
    }

    private static DetectionResult merge(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn, DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2) throws NotFoundException {
        if (detectionResultRowIndicatorColumn == null && detectionResultRowIndicatorColumn2 == null) {
            return null;
        }
        BarcodeMetadata barcodeMetadata = getBarcodeMetadata(detectionResultRowIndicatorColumn, detectionResultRowIndicatorColumn2);
        if (barcodeMetadata == null) {
            return null;
        }
        return new DetectionResult(barcodeMetadata, BoundingBox.merge(adjustBoundingBox(detectionResultRowIndicatorColumn), adjustBoundingBox(detectionResultRowIndicatorColumn2)));
    }

    private static BoundingBox adjustBoundingBox(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn) throws NotFoundException {
        if (detectionResultRowIndicatorColumn == null) {
            return null;
        }
        int[] rowHeights = detectionResultRowIndicatorColumn.getRowHeights();
        if (rowHeights == null) {
            return null;
        }
        int max = getMax(rowHeights);
        int i = 0;
        int i2 = 0;
        for (int i3 : rowHeights) {
            i2 += max - i3;
            if (i3 > 0) {
                break;
            }
        }
        Codeword[] codewords = detectionResultRowIndicatorColumn.getCodewords();
        int i4 = 0;
        while (i2 > 0 && codewords[i4] == null) {
            i2--;
            i4++;
        }
        for (int length = rowHeights.length - 1; length >= 0; length--) {
            i += max - rowHeights[length];
            if (rowHeights[length] > 0) {
                break;
            }
        }
        int length2 = codewords.length - 1;
        while (i > 0 && codewords[length2] == null) {
            i--;
            length2--;
        }
        return detectionResultRowIndicatorColumn.getBoundingBox().addMissingRows(i2, i, detectionResultRowIndicatorColumn.isLeft());
    }

    private static int getMax(int[] iArr) {
        int i = -1;
        for (int max : iArr) {
            i = Math.max(i, max);
        }
        return i;
    }

    private static BarcodeMetadata getBarcodeMetadata(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn, DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2) {
        if (detectionResultRowIndicatorColumn != null) {
            BarcodeMetadata barcodeMetadata = detectionResultRowIndicatorColumn.getBarcodeMetadata();
            if (barcodeMetadata != null) {
                if (detectionResultRowIndicatorColumn2 != null) {
                    BarcodeMetadata barcodeMetadata2 = detectionResultRowIndicatorColumn2.getBarcodeMetadata();
                    if (!(barcodeMetadata2 == null || barcodeMetadata.getColumnCount() == barcodeMetadata2.getColumnCount() || barcodeMetadata.getErrorCorrectionLevel() == barcodeMetadata2.getErrorCorrectionLevel() || barcodeMetadata.getRowCount() == barcodeMetadata2.getRowCount())) {
                        return null;
                    }
                }
                return barcodeMetadata;
            }
        }
        if (detectionResultRowIndicatorColumn2 == null) {
            return null;
        }
        return detectionResultRowIndicatorColumn2.getBarcodeMetadata();
    }

    private static DetectionResultRowIndicatorColumn getRowIndicatorColumn(BitMatrix bitMatrix, BoundingBox boundingBox, ResultPoint resultPoint, boolean z, int i, int i2) {
        boolean z2 = z;
        DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn = new DetectionResultRowIndicatorColumn(boundingBox, z2);
        int i3 = 0;
        while (i3 < 2) {
            int i4 = i3 == 0 ? 1 : -1;
            int x = (int) resultPoint.getX();
            int y = (int) resultPoint.getY();
            while (y <= boundingBox.getMaxY() && y >= boundingBox.getMinY()) {
                Codeword detectCodeword = detectCodeword(bitMatrix, 0, bitMatrix.getWidth(), z, x, y, i, i2);
                if (detectCodeword != null) {
                    detectionResultRowIndicatorColumn.setCodeword(y, detectCodeword);
                    if (z2) {
                        x = detectCodeword.getStartX();
                    } else {
                        x = detectCodeword.getEndX();
                    }
                }
                y += i4;
            }
            i3++;
        }
        return detectionResultRowIndicatorColumn;
    }

    private static void adjustCodewordCount(DetectionResult detectionResult, BarcodeValue[][] barcodeValueArr) throws NotFoundException {
        BarcodeValue barcodeValue = barcodeValueArr[0][1];
        int[] value = barcodeValue.getValue();
        int barcodeColumnCount = (detectionResult.getBarcodeColumnCount() * detectionResult.getBarcodeRowCount()) - getNumberOfECCodeWords(detectionResult.getBarcodeECLevel());
        if (value.length != 0) {
            if (value[0] != barcodeColumnCount) {
                barcodeValue.setValue(barcodeColumnCount);
            }
        } else if (barcodeColumnCount <= 0 || barcodeColumnCount > 928) {
            throw NotFoundException.getNotFoundInstance();
        } else {
            barcodeValue.setValue(barcodeColumnCount);
        }
    }

    private static DecoderResult createDecoderResult(DetectionResult detectionResult) throws FormatException, ChecksumException, NotFoundException {
        BarcodeValue[][] createBarcodeMatrix = createBarcodeMatrix(detectionResult);
        adjustCodewordCount(detectionResult, createBarcodeMatrix);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[(detectionResult.getBarcodeRowCount() * detectionResult.getBarcodeColumnCount())];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i = 0; i < detectionResult.getBarcodeRowCount(); i++) {
            int i2 = 0;
            while (i2 < detectionResult.getBarcodeColumnCount()) {
                int i3 = i2 + 1;
                int[] value = createBarcodeMatrix[i][i3].getValue();
                int barcodeColumnCount = (detectionResult.getBarcodeColumnCount() * i) + i2;
                if (value.length == 0) {
                    arrayList.add(Integer.valueOf(barcodeColumnCount));
                } else if (value.length == 1) {
                    iArr[barcodeColumnCount] = value[0];
                } else {
                    arrayList3.add(Integer.valueOf(barcodeColumnCount));
                    arrayList2.add(value);
                }
                i2 = i3;
            }
        }
        int[][] iArr2 = new int[arrayList2.size()][];
        for (int i4 = 0; i4 < iArr2.length; i4++) {
            iArr2[i4] = (int[]) arrayList2.get(i4);
        }
        return createDecoderResultFromAmbiguousValues(detectionResult.getBarcodeECLevel(), iArr, PDF417Common.toIntArray(arrayList), PDF417Common.toIntArray(arrayList3), iArr2);
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [int] */
    /* JADX WARNING: type inference failed for: r7v1, types: [int] */
    /* JADX WARNING: type inference failed for: r7v3 */
    /* JADX WARNING: type inference failed for: r7v6, types: [com.google.zxing.common.DecoderResult] */
    /* JADX WARNING: type inference failed for: r7v7 */
    /* JADX WARNING: type inference failed for: r7v8 */
    /* JADX WARNING: type inference failed for: r7v9 */
    /* JADX WARNING: type inference failed for: r7v10 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=null, for r7v0, types: [int] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r7v3
  assigns: []
  uses: []
	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:231)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:95)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:88)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:30)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
	at jadx.core.ProcessClass.process(ProcessClass.java:35)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
    /* JADX WARNING: Unknown variable types count: 4 */
    private static com.google.zxing.common.DecoderResult createDecoderResultFromAmbiguousValues(? r7, int[] r8, int[] r9, int[] r10, int[][] r11) throws com.google.zxing.FormatException, com.google.zxing.ChecksumException {
        /*
        int r0 = r10.length
        int[] r0 = new int[r0]
        r1 = 100
    L_0x0005:
        int r2 = r1 + -1
        if (r1 <= 0) goto L_0x004d
        r1 = 0
        r3 = 0
    L_0x000b:
        int r4 = r0.length
        if (r3 >= r4) goto L_0x001b
        r4 = r10[r3]
        r5 = r11[r3]
        r6 = r0[r3]
        r5 = r5[r6]
        r8[r4] = r5
        int r3 = r3 + 1
        goto L_0x000b
    L_0x001b:
        com.google.zxing.common.DecoderResult r7 = decodeCodewords(r8, r7, r9)     // Catch:{ ChecksumException -> 0x0020 }
        return r7
    L_0x0020:
        int r3 = r0.length
        if (r3 == 0) goto L_0x0048
        r3 = 0
    L_0x0024:
        int r4 = r0.length
        if (r3 >= r4) goto L_0x0046
        r4 = r0[r3]
        r5 = r11[r3]
        int r5 = r5.length
        int r5 = r5 + -1
        if (r4 >= r5) goto L_0x0037
        r1 = r0[r3]
        int r1 = r1 + 1
        r0[r3] = r1
        goto L_0x0046
    L_0x0037:
        r0[r3] = r1
        int r4 = r0.length
        int r4 = r4 + -1
        if (r3 == r4) goto L_0x0041
        int r3 = r3 + 1
        goto L_0x0024
    L_0x0041:
        com.google.zxing.ChecksumException r7 = com.google.zxing.ChecksumException.getChecksumInstance()
        throw r7
    L_0x0046:
        r1 = r2
        goto L_0x0005
    L_0x0048:
        com.google.zxing.ChecksumException r7 = com.google.zxing.ChecksumException.getChecksumInstance()
        throw r7
    L_0x004d:
        com.google.zxing.ChecksumException r7 = com.google.zxing.ChecksumException.getChecksumInstance()
        throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.PDF417ScanningDecoder.createDecoderResultFromAmbiguousValues(int, int[], int[], int[], int[][]):com.google.zxing.common.DecoderResult");
    }

    private static BarcodeValue[][] createBarcodeMatrix(DetectionResult detectionResult) {
        DetectionResultColumn[] detectionResultColumns;
        Codeword[] codewords;
        BarcodeValue[][] barcodeValueArr = (BarcodeValue[][]) Array.newInstance(BarcodeValue.class, new int[]{detectionResult.getBarcodeRowCount(), detectionResult.getBarcodeColumnCount() + 2});
        for (int i = 0; i < barcodeValueArr.length; i++) {
            for (int i2 = 0; i2 < barcodeValueArr[i].length; i2++) {
                barcodeValueArr[i][i2] = new BarcodeValue();
            }
        }
        int i3 = 0;
        for (DetectionResultColumn detectionResultColumn : detectionResult.getDetectionResultColumns()) {
            if (detectionResultColumn != null) {
                for (Codeword codeword : detectionResultColumn.getCodewords()) {
                    if (codeword != null) {
                        int rowNumber = codeword.getRowNumber();
                        if (rowNumber >= 0 && rowNumber < barcodeValueArr.length) {
                            barcodeValueArr[rowNumber][i3].setValue(codeword.getValue());
                        }
                    }
                }
            }
            i3++;
        }
        return barcodeValueArr;
    }

    private static boolean isValidBarcodeColumn(DetectionResult detectionResult, int i) {
        return i >= 0 && i <= detectionResult.getBarcodeColumnCount() + 1;
    }

    private static int getStartColumn(DetectionResult detectionResult, int i, int i2, boolean z) {
        int i3 = z ? 1 : -1;
        Codeword codeword = null;
        int i4 = i - i3;
        if (isValidBarcodeColumn(detectionResult, i4)) {
            codeword = detectionResult.getDetectionResultColumn(i4).getCodeword(i2);
        }
        if (codeword != null) {
            return z ? codeword.getEndX() : codeword.getStartX();
        }
        Codeword codewordNearby = detectionResult.getDetectionResultColumn(i).getCodewordNearby(i2);
        if (codewordNearby != null) {
            return z ? codewordNearby.getStartX() : codewordNearby.getEndX();
        }
        if (isValidBarcodeColumn(detectionResult, i4)) {
            codewordNearby = detectionResult.getDetectionResultColumn(i4).getCodewordNearby(i2);
        }
        if (codewordNearby != null) {
            return z ? codewordNearby.getEndX() : codewordNearby.getStartX();
        }
        int i5 = 0;
        while (true) {
            i -= i3;
            if (isValidBarcodeColumn(detectionResult, i)) {
                Codeword[] codewords = detectionResult.getDetectionResultColumn(i).getCodewords();
                int length = codewords.length;
                for (int i6 = 0; i6 < length; i6++) {
                    Codeword codeword2 = codewords[i6];
                    if (codeword2 != null) {
                        return (z ? codeword2.getEndX() : codeword2.getStartX()) + (i3 * i5 * (codeword2.getEndX() - codeword2.getStartX()));
                    }
                }
                i5++;
            } else {
                BoundingBox boundingBox = detectionResult.getBoundingBox();
                return z ? boundingBox.getMinX() : boundingBox.getMaxX();
            }
        }
    }

    private static Codeword detectCodeword(BitMatrix bitMatrix, int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
        int i7;
        int adjustCodewordStartColumn = adjustCodewordStartColumn(bitMatrix, i, i2, z, i3, i4);
        int[] moduleBitCount = getModuleBitCount(bitMatrix, i, i2, z, adjustCodewordStartColumn, i4);
        if (moduleBitCount == null) {
            return null;
        }
        int sum = MathUtils.sum(moduleBitCount);
        if (z) {
            int i8 = adjustCodewordStartColumn;
            adjustCodewordStartColumn += sum;
            i7 = i8;
        } else {
            for (int i9 = 0; i9 < moduleBitCount.length / 2; i9++) {
                int i10 = moduleBitCount[i9];
                moduleBitCount[i9] = moduleBitCount[(moduleBitCount.length - 1) - i9];
                moduleBitCount[(moduleBitCount.length - 1) - i9] = i10;
            }
            i7 = adjustCodewordStartColumn - sum;
        }
        if (!checkCodewordSkew(sum, i5, i6)) {
            return null;
        }
        int decodedValue = PDF417CodewordDecoder.getDecodedValue(moduleBitCount);
        int codeword = PDF417Common.getCodeword(decodedValue);
        if (codeword == -1) {
            return null;
        }
        return new Codeword(i7, adjustCodewordStartColumn, getCodewordBucketNumber(decodedValue), codeword);
    }

    private static int[] getModuleBitCount(BitMatrix bitMatrix, int i, int i2, boolean z, int i3, int i4) {
        int[] iArr = new int[8];
        int i5 = z ? 1 : -1;
        int i6 = 0;
        boolean z2 = z;
        while (true) {
            if (!z) {
                if (i3 < i) {
                    break;
                }
            } else if (i3 >= i2) {
                break;
            }
            if (i6 >= 8) {
                break;
            } else if (bitMatrix.get(i3, i4) == z2) {
                iArr[i6] = iArr[i6] + 1;
                i3 += i5;
            } else {
                i6++;
                z2 = !z2;
            }
        }
        if (i6 != 8) {
            if (z) {
                i = i2;
            }
            if (!(i3 == i && i6 == 7)) {
                return null;
            }
        }
        return iArr;
    }

    private static int adjustCodewordStartColumn(BitMatrix bitMatrix, int i, int i2, boolean z, int i3, int i4) {
        int i5 = z ? -1 : 1;
        boolean z2 = z;
        int i6 = i3;
        for (int i7 = 0; i7 < 2; i7++) {
            while (true) {
                if (!z2) {
                    if (i6 >= i2) {
                        continue;
                        break;
                    }
                } else if (i6 < i) {
                    continue;
                    break;
                }
                if (z2 != bitMatrix.get(i6, i4)) {
                    continue;
                    break;
                } else if (Math.abs(i3 - i6) > 2) {
                    return i3;
                } else {
                    i6 += i5;
                }
            }
            i5 = -i5;
            z2 = !z2;
        }
        return i6;
    }

    private static DecoderResult decodeCodewords(int[] iArr, int i, int[] iArr2) throws FormatException, ChecksumException {
        if (iArr.length != 0) {
            int i2 = 1 << (i + 1);
            int correctErrors = correctErrors(iArr, iArr2, i2);
            verifyCodewordCount(iArr, i2);
            DecoderResult decode = DecodedBitStreamParser.decode(iArr, String.valueOf(i));
            decode.setErrorsCorrected(Integer.valueOf(correctErrors));
            decode.setErasures(Integer.valueOf(iArr2.length));
            return decode;
        }
        throw FormatException.getFormatInstance();
    }

    private static int correctErrors(int[] iArr, int[] iArr2, int i) throws ChecksumException {
        if ((iArr2 == null || iArr2.length <= (i / 2) + 3) && i >= 0 && i <= 512) {
            return errorCorrection.decode(iArr, i, iArr2);
        }
        throw ChecksumException.getChecksumInstance();
    }

    private static void verifyCodewordCount(int[] iArr, int i) throws FormatException {
        if (iArr.length >= 4) {
            int i2 = iArr[0];
            if (i2 > iArr.length) {
                throw FormatException.getFormatInstance();
            } else if (i2 != 0) {
            } else {
                if (i < iArr.length) {
                    iArr[0] = iArr.length - i;
                    return;
                }
                throw FormatException.getFormatInstance();
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }

    private static int[] getBitCountForCodeword(int i) {
        int[] iArr = new int[8];
        int i2 = 0;
        int i3 = 7;
        while (true) {
            int i4 = i & 1;
            if (i4 != i2) {
                i3--;
                if (i3 < 0) {
                    return iArr;
                }
                i2 = i4;
            }
            iArr[i3] = iArr[i3] + 1;
            i >>= 1;
        }
    }

    private static int getCodewordBucketNumber(int i) {
        return getCodewordBucketNumber(getBitCountForCodeword(i));
    }

    private static int getCodewordBucketNumber(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0067, code lost:
            r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006c, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006d, code lost:
            r9.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0070, code lost:
            throw r1;
     */
    public static java.lang.String toString(com.google.zxing.pdf417.decoder.BarcodeValue[][] r9) {
        /*
        java.util.Formatter r0 = new java.util.Formatter
        r0.<init>()
        r1 = 0
        r2 = 0
    L_0x0007:
        int r3 = r9.length     // Catch:{ all -> 0x0065 }
        if (r2 >= r3) goto L_0x005d
        java.lang.String r3 = "Row %2d: "
        r4 = 1
        java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x0065 }
        java.lang.Integer r6 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0065 }
        r5[r1] = r6     // Catch:{ all -> 0x0065 }
        r0.format(r3, r5)     // Catch:{ all -> 0x0065 }
        r3 = 0
    L_0x0019:
        r5 = r9[r2]     // Catch:{ all -> 0x0065 }
        int r5 = r5.length     // Catch:{ all -> 0x0065 }
        if (r3 >= r5) goto L_0x0053
        r5 = r9[r2]     // Catch:{ all -> 0x0065 }
        r5 = r5[r3]     // Catch:{ all -> 0x0065 }
        int[] r6 = r5.getValue()     // Catch:{ all -> 0x0065 }
        int r6 = r6.length     // Catch:{ all -> 0x0065 }
        if (r6 != 0) goto L_0x0030
        java.lang.String r5 = "        "
        r6 = 0
        r0.format(r5, r6)     // Catch:{ all -> 0x0065 }
        goto L_0x0050
    L_0x0030:
        java.lang.String r6 = "%4d(%2d)"
        r7 = 2
        java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ all -> 0x0065 }
        int[] r8 = r5.getValue()     // Catch:{ all -> 0x0065 }
        r8 = r8[r1]     // Catch:{ all -> 0x0065 }
        java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0065 }
        r7[r1] = r8     // Catch:{ all -> 0x0065 }
        int[] r8 = r5.getValue()     // Catch:{ all -> 0x0065 }
        r8 = r8[r1]     // Catch:{ all -> 0x0065 }
        java.lang.Integer r5 = r5.getConfidence(r8)     // Catch:{ all -> 0x0065 }
        r7[r4] = r5     // Catch:{ all -> 0x0065 }
        r0.format(r6, r7)     // Catch:{ all -> 0x0065 }
    L_0x0050:
        int r3 = r3 + 1
        goto L_0x0019
    L_0x0053:
        java.lang.String r3 = "%n"
        java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ all -> 0x0065 }
        r0.format(r3, r4)     // Catch:{ all -> 0x0065 }
        int r2 = r2 + 1
        goto L_0x0007
    L_0x005d:
        java.lang.String r9 = r0.toString()     // Catch:{ all -> 0x0065 }
        r0.close()
        return r9
    L_0x0065:
        r9 = move-exception
        throw r9     // Catch:{ all -> 0x0067 }
    L_0x0067:
        r1 = move-exception
        r0.close()     // Catch:{ all -> 0x006c }
        goto L_0x0070
    L_0x006c:
        r0 = move-exception
        r9.addSuppressed(r0)
    L_0x0070:
        throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.PDF417ScanningDecoder.toString(com.google.zxing.pdf417.decoder.BarcodeValue[][]):java.lang.String");
    }
}
