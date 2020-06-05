package com.google.zxing.oned.rss.expanded;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.oned.rss.AbstractRSSReader;
import com.google.zxing.oned.rss.DataCharacter;
import com.google.zxing.oned.rss.FinderPattern;
import com.google.zxing.oned.rss.RSSUtils;
import com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class RSSExpandedReader extends AbstractRSSReader {
    private static final int[] EVEN_TOTAL_SUBSET = {4, 20, 52, 104, 204};
    private static final int[][] FINDER_PATTERNS = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};
    private static final int[][] FINDER_PATTERN_SEQUENCES = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};
    private static final int FINDER_PAT_A = 0;
    private static final int FINDER_PAT_B = 1;
    private static final int FINDER_PAT_C = 2;
    private static final int FINDER_PAT_D = 3;
    private static final int FINDER_PAT_E = 4;
    private static final int FINDER_PAT_F = 5;
    private static final int[] GSUM = {0, 348, 1388, 2948, 3988};
    private static final int MAX_PAIRS = 11;
    private static final int[] SYMBOL_WIDEST = {7, 5, 4, 3, 1};
    private static final int[][] WEIGHTS = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, TinkerReport.KEY_APPLIED_VERSION_CHECK, 118, 143, 7, 21, 63}, new int[]{189, 145, 13, 39, 117, 140, TinkerReport.KEY_APPLIED_FAIL_COST_OTHER, 205}, new int[]{193, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META, 49, 147, 19, 57, 171, 91}, new int[]{62, 186, 136, 197, 169, 85, 44, 132}, new int[]{185, 133, 188, 142, 4, 12, 36, 108}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{TinkerReport.KEY_APPLIED_PACKAGE_CHECK_SIGNATURE, 28, 84, 41, 123, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT, 52, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL}, new int[]{46, 138, 203, 187, 139, 206, 196, 166}, new int[]{76, 17, 51, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, 37, 111, 122, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_META_NOT_FOUND}, new int[]{43, 129, 176, 106, 107, 110, 119, 146}, new int[]{16, 48, 144, 10, 30, 90, 59, 177}, new int[]{109, 116, 137, 200, 178, 112, 125, 164}, new int[]{70, 210, TinkerReport.KEY_APPLIED_FAIL_COST_60S_LESS, 202, TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, 130, 179, 115}, new int[]{134, 191, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_DEX_META, 31, 93, 68, 204, 190}, new int[]{148, 22, 66, 198, 172, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, 192, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND, 40}, new int[]{120, 149, 25, 75, 14, 42, 126, 167}, new int[]{79, 26, 78, 23, 69, 207, 199, 175}, new int[]{103, 98, 83, 38, 114, 131, TinkerReport.KEY_APPLIED_DEX_EXTRACT, 124}, new int[]{161, 61, TinkerReport.KEY_APPLIED_LIB_EXTRACT, 127, 170, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, 194, 160, 58, 174, 100, 89}};
    private final List<ExpandedPair> pairs = new ArrayList(11);
    private final List<ExpandedRow> rows = new ArrayList();
    private final int[] startEnd = new int[2];
    private boolean startFromEven;

    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        this.pairs.clear();
        this.startFromEven = false;
        try {
            r1 = i;
            r1 = constructResult(decodeRow2pairs(i, bitArray));
            r1 = r1;
            return r1;
        } catch (NotFoundException unused) {
            this.pairs.clear();
            this.startFromEven = true;
            return constructResult(decodeRow2pairs(r1, bitArray));
        }
    }

    public void reset() {
        this.pairs.clear();
        this.rows.clear();
    }

    /* access modifiers changed from: 0000 */
    public List<ExpandedPair> decodeRow2pairs(int i, BitArray bitArray) throws NotFoundException {
        boolean z = false;
        while (!z) {
            try {
                this.pairs.add(retrieveNextPair(bitArray, this.pairs, i));
            } catch (NotFoundException e) {
                if (!this.pairs.isEmpty()) {
                    z = true;
                } else {
                    throw e;
                }
            }
        }
        if (checkChecksum()) {
            return this.pairs;
        }
        boolean z2 = !this.rows.isEmpty();
        storeRow(i, false);
        if (z2) {
            List<ExpandedPair> checkRows = checkRows(false);
            if (checkRows != null) {
                return checkRows;
            }
            List<ExpandedPair> checkRows2 = checkRows(true);
            if (checkRows2 != null) {
                return checkRows2;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private List<ExpandedPair> checkRows(boolean z) {
        List<ExpandedPair> list = null;
        if (this.rows.size() > 25) {
            this.rows.clear();
            return null;
        }
        this.pairs.clear();
        if (z) {
            Collections.reverse(this.rows);
        }
        try {
            list = checkRows(new ArrayList(), 0);
        } catch (NotFoundException unused) {
        }
        if (z) {
            Collections.reverse(this.rows);
        }
        return list;
    }

    private List<ExpandedPair> checkRows(List<ExpandedRow> list, int i) throws NotFoundException {
        while (i < this.rows.size()) {
            ExpandedRow expandedRow = (ExpandedRow) this.rows.get(i);
            this.pairs.clear();
            for (ExpandedRow pairs2 : list) {
                this.pairs.addAll(pairs2.getPairs());
            }
            this.pairs.addAll(expandedRow.getPairs());
            if (!isValidSequence(this.pairs)) {
                i++;
            } else if (checkChecksum()) {
                return this.pairs;
            } else {
                ArrayList arrayList = new ArrayList(list);
                arrayList.add(expandedRow);
                try {
                    list = checkRows(arrayList, i + 1);
                    return list;
                } catch (NotFoundException unused) {
                    continue;
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static boolean isValidSequence(List<ExpandedPair> list) {
        int[][] iArr;
        boolean z;
        for (int[] iArr2 : FINDER_PATTERN_SEQUENCES) {
            if (list.size() <= iArr2.length) {
                int i = 0;
                while (true) {
                    if (i >= list.size()) {
                        z = true;
                        break;
                    } else if (((ExpandedPair) list.get(i)).getFinderPattern().getValue() != iArr2[i]) {
                        z = false;
                        break;
                    } else {
                        i++;
                    }
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    private void storeRow(int i, boolean z) {
        boolean z2 = false;
        int i2 = 0;
        boolean z3 = false;
        while (true) {
            if (i2 >= this.rows.size()) {
                break;
            }
            ExpandedRow expandedRow = (ExpandedRow) this.rows.get(i2);
            if (expandedRow.getRowNumber() > i) {
                z2 = expandedRow.isEquivalent(this.pairs);
                break;
            } else {
                z3 = expandedRow.isEquivalent(this.pairs);
                i2++;
            }
        }
        if (!z2 && !z3 && !isPartialRow(this.pairs, this.rows)) {
            this.rows.add(i2, new ExpandedRow(this.pairs, i, z));
            removePartialRows(this.pairs, this.rows);
        }
    }

    private static void removePartialRows(List<ExpandedPair> list, List<ExpandedRow> list2) {
        boolean z;
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            ExpandedRow expandedRow = (ExpandedRow) it.next();
            if (expandedRow.getPairs().size() != list.size()) {
                Iterator it2 = expandedRow.getPairs().iterator();
                while (true) {
                    z = false;
                    boolean z2 = true;
                    if (!it2.hasNext()) {
                        z = true;
                        break;
                    }
                    ExpandedPair expandedPair = (ExpandedPair) it2.next();
                    Iterator it3 = list.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            if (expandedPair.equals((ExpandedPair) it3.next())) {
                                continue;
                                break;
                            }
                        } else {
                            z2 = false;
                            continue;
                            break;
                        }
                    }
                    if (!z2) {
                        break;
                    }
                }
                if (z) {
                    it.remove();
                }
            }
        }
    }

    private static boolean isPartialRow(Iterable<ExpandedPair> iterable, Iterable<ExpandedRow> iterable2) {
        boolean z;
        boolean z2;
        Iterator it = iterable2.iterator();
        do {
            z = false;
            if (it.hasNext()) {
                ExpandedRow expandedRow = (ExpandedRow) it.next();
                Iterator it2 = iterable.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z = true;
                        continue;
                        break;
                    }
                    ExpandedPair expandedPair = (ExpandedPair) it2.next();
                    Iterator it3 = expandedRow.getPairs().iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            if (expandedPair.equals((ExpandedPair) it3.next())) {
                                z2 = true;
                                continue;
                                break;
                            }
                        } else {
                            z2 = false;
                            continue;
                            break;
                        }
                    }
                    if (!z2) {
                        continue;
                        break;
                    }
                }
            } else {
                return false;
            }
        } while (!z);
        return true;
    }

    /* access modifiers changed from: 0000 */
    public List<ExpandedRow> getRows() {
        return this.rows;
    }

    static Result constructResult(List<ExpandedPair> list) throws NotFoundException, FormatException {
        String parseInformation = AbstractExpandedDecoder.createDecoder(BitArrayBuilder.buildBitArray(list)).parseInformation();
        ResultPoint[] resultPoints = ((ExpandedPair) list.get(0)).getFinderPattern().getResultPoints();
        ResultPoint[] resultPoints2 = ((ExpandedPair) list.get(list.size() - 1)).getFinderPattern().getResultPoints();
        return new Result(parseInformation, null, new ResultPoint[]{resultPoints[0], resultPoints[1], resultPoints2[0], resultPoints2[1]}, BarcodeFormat.RSS_EXPANDED);
    }

    private boolean checkChecksum() {
        ExpandedPair expandedPair = (ExpandedPair) this.pairs.get(0);
        DataCharacter leftChar = expandedPair.getLeftChar();
        DataCharacter rightChar = expandedPair.getRightChar();
        if (rightChar == null) {
            return false;
        }
        int checksumPortion = rightChar.getChecksumPortion();
        int i = 2;
        for (int i2 = 1; i2 < this.pairs.size(); i2++) {
            ExpandedPair expandedPair2 = (ExpandedPair) this.pairs.get(i2);
            checksumPortion += expandedPair2.getLeftChar().getChecksumPortion();
            i++;
            DataCharacter rightChar2 = expandedPair2.getRightChar();
            if (rightChar2 != null) {
                checksumPortion += rightChar2.getChecksumPortion();
                i++;
            }
        }
        if (((i - 4) * 211) + (checksumPortion % 211) == leftChar.getValue()) {
            return true;
        }
        return false;
    }

    private static int getNextSecondBar(BitArray bitArray, int i) {
        if (bitArray.get(i)) {
            return bitArray.getNextSet(bitArray.getNextUnset(i));
        }
        return bitArray.getNextUnset(bitArray.getNextSet(i));
    }

    /* access modifiers changed from: 0000 */
    public ExpandedPair retrieveNextPair(BitArray bitArray, List<ExpandedPair> list, int i) throws NotFoundException {
        FinderPattern parseFoundFinderPattern;
        DataCharacter dataCharacter;
        boolean z = list.size() % 2 == 0;
        if (this.startFromEven) {
            z = !z;
        }
        int i2 = -1;
        boolean z2 = true;
        do {
            findNextPair(bitArray, list, i2);
            parseFoundFinderPattern = parseFoundFinderPattern(bitArray, i, z);
            if (parseFoundFinderPattern == null) {
                i2 = getNextSecondBar(bitArray, this.startEnd[0]);
                continue;
            } else {
                z2 = false;
                continue;
            }
        } while (z2);
        DataCharacter decodeDataCharacter = decodeDataCharacter(bitArray, parseFoundFinderPattern, z, true);
        if (list.isEmpty() || !((ExpandedPair) list.get(list.size() - 1)).mustBeLast()) {
            try {
                dataCharacter = decodeDataCharacter(bitArray, parseFoundFinderPattern, z, false);
            } catch (NotFoundException unused) {
                dataCharacter = null;
            }
            return new ExpandedPair(decodeDataCharacter, dataCharacter, parseFoundFinderPattern, true);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private void findNextPair(BitArray bitArray, List<ExpandedPair> list, int i) throws NotFoundException {
        int[] decodeFinderCounters = getDecodeFinderCounters();
        decodeFinderCounters[0] = 0;
        decodeFinderCounters[1] = 0;
        decodeFinderCounters[2] = 0;
        decodeFinderCounters[3] = 0;
        int size = bitArray.getSize();
        if (i < 0) {
            if (list.isEmpty()) {
                i = 0;
            } else {
                i = ((ExpandedPair) list.get(list.size() - 1)).getFinderPattern().getStartEnd()[1];
            }
        }
        boolean z = list.size() % 2 != 0;
        if (this.startFromEven) {
            z = !z;
        }
        boolean z2 = false;
        while (i < size) {
            z2 = !bitArray.get(i);
            if (!z2) {
                break;
            }
            i++;
        }
        int i2 = i;
        int i3 = 0;
        while (i < size) {
            if (bitArray.get(i) != z2) {
                decodeFinderCounters[i3] = decodeFinderCounters[i3] + 1;
            } else {
                if (i3 == 3) {
                    if (z) {
                        reverseCounters(decodeFinderCounters);
                    }
                    if (isFinderPattern(decodeFinderCounters)) {
                        int[] iArr = this.startEnd;
                        iArr[0] = i2;
                        iArr[1] = i;
                        return;
                    }
                    if (z) {
                        reverseCounters(decodeFinderCounters);
                    }
                    i2 += decodeFinderCounters[0] + decodeFinderCounters[1];
                    decodeFinderCounters[0] = decodeFinderCounters[2];
                    decodeFinderCounters[1] = decodeFinderCounters[3];
                    decodeFinderCounters[2] = 0;
                    decodeFinderCounters[3] = 0;
                    i3--;
                } else {
                    i3++;
                }
                decodeFinderCounters[i3] = 1;
                z2 = !z2;
            }
            i++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static void reverseCounters(int[] iArr) {
        int length = iArr.length;
        for (int i = 0; i < length / 2; i++) {
            int i2 = iArr[i];
            int i3 = (length - i) - 1;
            iArr[i] = iArr[i3];
            iArr[i3] = i2;
        }
    }

    private FinderPattern parseFoundFinderPattern(BitArray bitArray, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (z) {
            int i5 = this.startEnd[0] - 1;
            while (i5 >= 0 && !bitArray.get(i5)) {
                i5--;
            }
            int i6 = i5 + 1;
            int[] iArr = this.startEnd;
            int i7 = iArr[0] - i6;
            i3 = iArr[1];
            i4 = i6;
            i2 = i7;
        } else {
            int[] iArr2 = this.startEnd;
            int i8 = iArr2[0];
            int nextUnset = bitArray.getNextUnset(iArr2[1] + 1);
            i2 = nextUnset - this.startEnd[1];
            i3 = nextUnset;
            i4 = i8;
        }
        int[] decodeFinderCounters = getDecodeFinderCounters();
        System.arraycopy(decodeFinderCounters, 0, decodeFinderCounters, 1, decodeFinderCounters.length - 1);
        decodeFinderCounters[0] = i2;
        try {
            FinderPattern finderPattern = new FinderPattern(parseFinderValue(decodeFinderCounters, FINDER_PATTERNS), new int[]{i4, i3}, i4, i3, i);
            return finderPattern;
        } catch (NotFoundException unused) {
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    public DataCharacter decodeDataCharacter(BitArray bitArray, FinderPattern finderPattern, boolean z, boolean z2) throws NotFoundException {
        BitArray bitArray2 = bitArray;
        int[] dataCharacterCounters = getDataCharacterCounters();
        for (int i = 0; i < dataCharacterCounters.length; i++) {
            dataCharacterCounters[i] = 0;
        }
        if (z2) {
            recordPatternInReverse(bitArray, finderPattern.getStartEnd()[0], dataCharacterCounters);
        } else {
            recordPattern(bitArray, finderPattern.getStartEnd()[1], dataCharacterCounters);
            int i2 = 0;
            for (int length = dataCharacterCounters.length - 1; i2 < length; length--) {
                int i3 = dataCharacterCounters[i2];
                dataCharacterCounters[i2] = dataCharacterCounters[length];
                dataCharacterCounters[length] = i3;
                i2++;
            }
        }
        float sum = ((float) MathUtils.sum(dataCharacterCounters)) / 17.0f;
        float f = ((float) (finderPattern.getStartEnd()[1] - finderPattern.getStartEnd()[0])) / 15.0f;
        if (Math.abs(sum - f) / f <= 0.3f) {
            int[] oddCounts = getOddCounts();
            int[] evenCounts = getEvenCounts();
            float[] oddRoundingErrors = getOddRoundingErrors();
            float[] evenRoundingErrors = getEvenRoundingErrors();
            for (int i4 = 0; i4 < dataCharacterCounters.length; i4++) {
                float f2 = (((float) dataCharacterCounters[i4]) * 1.0f) / sum;
                int i5 = (int) (0.5f + f2);
                int i6 = 8;
                if (i5 <= 0) {
                    if (f2 >= 0.3f) {
                        i6 = 1;
                    } else {
                        throw NotFoundException.getNotFoundInstance();
                    }
                } else if (i5 <= 8) {
                    i6 = i5;
                } else if (f2 > 8.7f) {
                    throw NotFoundException.getNotFoundInstance();
                }
                int i7 = i4 / 2;
                if ((i4 & 1) == 0) {
                    oddCounts[i7] = i6;
                    oddRoundingErrors[i7] = f2 - ((float) i6);
                } else {
                    evenCounts[i7] = i6;
                    evenRoundingErrors[i7] = f2 - ((float) i6);
                }
            }
            adjustOddEvenCounts(17);
            int value = (((finderPattern.getValue() * 4) + (z ? 0 : 2)) + (!z2)) - 1;
            int i8 = 0;
            int i9 = 0;
            for (int length2 = oddCounts.length - 1; length2 >= 0; length2--) {
                if (isNotA1left(finderPattern, z, z2)) {
                    i8 += oddCounts[length2] * WEIGHTS[value][length2 * 2];
                }
                i9 += oddCounts[length2];
            }
            int i10 = 0;
            for (int length3 = evenCounts.length - 1; length3 >= 0; length3--) {
                if (isNotA1left(finderPattern, z, z2)) {
                    i10 += evenCounts[length3] * WEIGHTS[value][(length3 * 2) + 1];
                }
            }
            int i11 = i8 + i10;
            if ((i9 & 1) != 0 || i9 > 13 || i9 < 4) {
                throw NotFoundException.getNotFoundInstance();
            }
            int i12 = (13 - i9) / 2;
            int i13 = SYMBOL_WIDEST[i12];
            int i14 = 9 - i13;
            return new DataCharacter((RSSUtils.getRSSvalue(oddCounts, i13, true) * EVEN_TOTAL_SUBSET[i12]) + RSSUtils.getRSSvalue(evenCounts, i14, false) + GSUM[i12], i11);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static boolean isNotA1left(FinderPattern finderPattern, boolean z, boolean z2) {
        return finderPattern.getValue() != 0 || !z || !z2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0024  */
    private void adjustOddEvenCounts(int r11) throws com.google.zxing.NotFoundException {
        /*
        r10 = this;
        int[] r0 = r10.getOddCounts()
        int r0 = com.google.zxing.common.detector.MathUtils.sum(r0)
        int[] r1 = r10.getEvenCounts()
        int r1 = com.google.zxing.common.detector.MathUtils.sum(r1)
        r2 = 4
        r3 = 13
        r4 = 0
        r5 = 1
        if (r0 <= r3) goto L_0x0019
        r6 = 1
        goto L_0x001e
    L_0x0019:
        r6 = 0
        if (r0 >= r2) goto L_0x001e
        r7 = 1
        goto L_0x001f
    L_0x001e:
        r7 = 0
    L_0x001f:
        if (r1 <= r3) goto L_0x0024
        r2 = 0
        r3 = 1
        goto L_0x002a
    L_0x0024:
        if (r1 >= r2) goto L_0x0028
        r2 = 1
        goto L_0x0029
    L_0x0028:
        r2 = 0
    L_0x0029:
        r3 = 0
    L_0x002a:
        int r8 = r0 + r1
        int r8 = r8 - r11
        r11 = r0 & 1
        if (r11 != r5) goto L_0x0033
        r11 = 1
        goto L_0x0034
    L_0x0033:
        r11 = 0
    L_0x0034:
        r9 = r1 & 1
        if (r9 != 0) goto L_0x0039
        r4 = 1
    L_0x0039:
        if (r8 != r5) goto L_0x004f
        if (r11 == 0) goto L_0x0046
        if (r4 != 0) goto L_0x0041
    L_0x003f:
        r6 = 1
        goto L_0x0079
    L_0x0041:
        com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
        throw r11
    L_0x0046:
        if (r4 == 0) goto L_0x004a
        r3 = 1
        goto L_0x0079
    L_0x004a:
        com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
        throw r11
    L_0x004f:
        r9 = -1
        if (r8 != r9) goto L_0x0066
        if (r11 == 0) goto L_0x005d
        if (r4 != 0) goto L_0x0058
    L_0x0056:
        r7 = 1
        goto L_0x0079
    L_0x0058:
        com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
        throw r11
    L_0x005d:
        if (r4 == 0) goto L_0x0061
        r2 = 1
        goto L_0x0079
    L_0x0061:
        com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
        throw r11
    L_0x0066:
        if (r8 != 0) goto L_0x00c3
        if (r11 == 0) goto L_0x0077
        if (r4 == 0) goto L_0x0072
        if (r0 >= r1) goto L_0x0070
        r3 = 1
        goto L_0x0056
    L_0x0070:
        r2 = 1
        goto L_0x003f
    L_0x0072:
        com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
        throw r11
    L_0x0077:
        if (r4 != 0) goto L_0x00be
    L_0x0079:
        if (r7 == 0) goto L_0x008e
        if (r6 != 0) goto L_0x0089
        int[] r11 = r10.getOddCounts()
        float[] r0 = r10.getOddRoundingErrors()
        increment(r11, r0)
        goto L_0x008e
    L_0x0089:
        com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
        throw r11
    L_0x008e:
        if (r6 == 0) goto L_0x009b
        int[] r11 = r10.getOddCounts()
        float[] r0 = r10.getOddRoundingErrors()
        decrement(r11, r0)
    L_0x009b:
        if (r2 == 0) goto L_0x00b0
        if (r3 != 0) goto L_0x00ab
        int[] r11 = r10.getEvenCounts()
        float[] r0 = r10.getOddRoundingErrors()
        increment(r11, r0)
        goto L_0x00b0
    L_0x00ab:
        com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
        throw r11
    L_0x00b0:
        if (r3 == 0) goto L_0x00bd
        int[] r11 = r10.getEvenCounts()
        float[] r0 = r10.getEvenRoundingErrors()
        decrement(r11, r0)
    L_0x00bd:
        return
    L_0x00be:
        com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
        throw r11
    L_0x00c3:
        com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
        throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.rss.expanded.RSSExpandedReader.adjustOddEvenCounts(int):void");
    }
}
