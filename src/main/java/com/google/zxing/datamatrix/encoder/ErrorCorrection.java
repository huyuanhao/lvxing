package com.google.zxing.datamatrix.encoder;

import com.tencent.bugly.beta.tinker.TinkerReport;
import com.tencent.p605ep.commonbase.utils.ScreenUtil;

public final class ErrorCorrection {
    private static final int[] ALOG = new int[255];
    private static final int[][] FACTORS = {new int[]{228, 48, 15, 111, 62}, new int[]{23, 68, 144, 134, ScreenUtil.G8_WIDTH, 92, TinkerReport.KEY_LOADED_EXCEPTION_RESOURCE}, new int[]{28, 24, 185, 166, 223, 248, 116, 255, 110, 61}, new int[]{175, 138, 205, 12, 194, 168, 39, 245, 60, 97, 120}, new int[]{41, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT, 91, 61, 42, 142, ScreenUtil.N7_DENSITY, 97, 178, 100, 242}, new int[]{TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL, 97, 192, TinkerReport.KEY_LOADED_EXCEPTION_DEX, 95, 9, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META, 119, 138, 45, 18, 186, 83, 185}, new int[]{83, 195, 100, 39, 188, 75, 66, 61, 241, ScreenUtil.N7_DENSITY, 109, 129, 94, TinkerReport.KEY_LOADED_EXCEPTION_RESOURCE, 225, 48, 90, 188}, new int[]{15, 195, 244, 9, 233, 71, 168, 2, 188, 160, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, 145, TinkerReport.KEY_LOADED_EXCEPTION_DEX_CHECK, 79, 108, 82, 27, 174, 186, 172}, new int[]{52, 190, 88, 205, 109, 39, 176, 21, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_META_NOT_FOUND, 197, TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION, 223, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_META_NOT_FOUND, 21, 5, 172, TinkerReport.KEY_LOADED_EXCEPTION_RESOURCE, 124, 12, TinkerReport.KEY_APPLIED_PATCH_FILE_EXTRACT, TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, 96, 50, 193}, new int[]{211, 231, 43, 97, 71, 96, 103, 174, 37, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_DEX_META, 170, 53, 75, 34, 249, 121, 17, 138, 110, ScreenUtil.N7_DENSITY, 141, 136, 120, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_DEX_META, 233, 168, 93, 255}, new int[]{245, 127, 242, 218, 130, 250, 162, TinkerReport.KEY_APPLIED_PATCH_FILE_EXTRACT, 102, 120, 84, 179, 220, TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION, 80, TinkerReport.KEY_APPLIED_DEX_EXTRACT, 229, 18, 2, 4, 68, 33, 101, 137, 95, 119, 115, 44, 175, TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, 59, 25, 225, 98, 81, 112}, new int[]{77, 193, 137, 31, 19, 38, 22, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, 247, 105, 122, 2, 245, 133, 242, 8, 175, 95, 100, 9, 167, 105, 214, 111, 57, 121, 21, 1, TinkerReport.KEY_LOADED_EXCEPTION_DEX_CHECK, 57, 54, 101, 248, 202, 69, 50, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_SIGNATURE, 177, 226, 5, 9, 5}, new int[]{245, 132, 172, 223, 96, 32, 117, 22, 238, 133, 238, 231, 205, 188, 237, 87, 191, 106, 16, 147, 118, 23, 37, 90, 170, 205, 131, 88, 120, 100, 66, 138, 186, ScreenUtil.G8_WIDTH, 82, 44, 176, 87, 187, 147, 160, 175, 69, ScreenUtil.N7_DENSITY, 92, TinkerReport.KEY_LOADED_EXCEPTION_DEX_CHECK, 225, 19}, new int[]{175, 9, 223, 238, 12, 17, 220, TinkerReport.KEY_APPLIED_FAIL_COST_60S_LESS, 100, 29, 175, 170, 230, 192, 215, 235, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_SIGNATURE, 159, 36, 223, 38, 200, 132, 54, 228, 146, 218, 234, 117, 203, 29, 232, 144, 238, 22, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_SIGNATURE, 201, 117, 62, 207, 164, 13, 137, 245, 127, 67, 247, 28, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_META_NOT_FOUND, 43, 203, 107, 233, 53, 143, 46}, new int[]{242, 93, 169, 50, 144, 210, 39, 118, 202, 188, 201, 189, 143, 108, 196, 37, 185, 112, 134, 230, 245, 63, 197, 190, 250, 106, 185, 221, 175, 64, 114, 71, 161, 44, 147, 6, 27, 218, 51, 63, 87, 10, 40, 130, 188, 17, 163, 31, 176, 170, 4, 107, 232, 7, 94, 166, 224, 124, 86, 47, 11, 204}, new int[]{220, 228, 173, 89, TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION, 149, 159, 56, 89, 33, 147, 244, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND, 36, 73, 127, ScreenUtil.N7_DENSITY, 136, 248, TinkerReport.KEY_APPLIED_VERSION_CHECK, 234, 197, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT, 177, 68, 122, 93, ScreenUtil.N7_DENSITY, 15, 160, 227, 236, 66, 139, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, 185, 202, 167, 179, 25, 220, 232, 96, 210, 231, 136, 223, 239, TinkerReport.KEY_APPLIED_PATCH_FILE_EXTRACT, 241, 59, 52, 172, 25, 49, 232, 211, 189, 64, 54, 108, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, 132, 63, 96, 103, 82, 186}};
    private static final int[] FACTOR_SETS = {5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};
    private static final int[] LOG = new int[256];
    private static final int MODULO_VALUE = 301;

    static {
        int i = 1;
        for (int i2 = 0; i2 < 255; i2++) {
            ALOG[i2] = i;
            LOG[i] = i2;
            i <<= 1;
            if (i >= 256) {
                i ^= 301;
            }
        }
    }

    private ErrorCorrection() {
    }

    public static String encodeECC200(String str, SymbolInfo symbolInfo) {
        if (str.length() == symbolInfo.getDataCapacity()) {
            StringBuilder sb = new StringBuilder(symbolInfo.getDataCapacity() + symbolInfo.getErrorCodewords());
            sb.append(str);
            int interleavedBlockCount = symbolInfo.getInterleavedBlockCount();
            if (interleavedBlockCount == 1) {
                sb.append(createECCBlock(str, symbolInfo.getErrorCodewords()));
            } else {
                sb.setLength(sb.capacity());
                int[] iArr = new int[interleavedBlockCount];
                int[] iArr2 = new int[interleavedBlockCount];
                int[] iArr3 = new int[interleavedBlockCount];
                int i = 0;
                while (i < interleavedBlockCount) {
                    int i2 = i + 1;
                    iArr[i] = symbolInfo.getDataLengthForInterleavedBlock(i2);
                    iArr2[i] = symbolInfo.getErrorLengthForInterleavedBlock(i2);
                    iArr3[i] = 0;
                    if (i > 0) {
                        iArr3[i] = iArr3[i - 1] + iArr[i];
                    }
                    i = i2;
                }
                for (int i3 = 0; i3 < interleavedBlockCount; i3++) {
                    StringBuilder sb2 = new StringBuilder(iArr[i3]);
                    for (int i4 = i3; i4 < symbolInfo.getDataCapacity(); i4 += interleavedBlockCount) {
                        sb2.append(str.charAt(i4));
                    }
                    String createECCBlock = createECCBlock(sb2.toString(), iArr2[i3]);
                    int i5 = i3;
                    int i6 = 0;
                    while (i5 < iArr2[i3] * interleavedBlockCount) {
                        int i7 = i6 + 1;
                        sb.setCharAt(symbolInfo.getDataCapacity() + i5, createECCBlock.charAt(i6));
                        i5 += interleavedBlockCount;
                        i6 = i7;
                    }
                }
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
    }

    private static String createECCBlock(CharSequence charSequence, int i) {
        return createECCBlock(charSequence, 0, charSequence.length(), i);
    }

    private static String createECCBlock(CharSequence charSequence, int i, int i2, int i3) {
        int i4 = 0;
        while (true) {
            int[] iArr = FACTOR_SETS;
            if (i4 >= iArr.length) {
                i4 = -1;
                break;
            } else if (iArr[i4] == i3) {
                break;
            } else {
                i4++;
            }
        }
        if (i4 >= 0) {
            int[] iArr2 = FACTORS[i4];
            char[] cArr = new char[i3];
            for (int i5 = 0; i5 < i3; i5++) {
                cArr[i5] = 0;
            }
            for (int i6 = i; i6 < i + i2; i6++) {
                int i7 = i3 - 1;
                char charAt = cArr[i7] ^ charSequence.charAt(i6);
                while (i7 > 0) {
                    if (charAt == 0 || iArr2[i7] == 0) {
                        cArr[i7] = cArr[i7 - 1];
                    } else {
                        char c = cArr[i7 - 1];
                        int[] iArr3 = ALOG;
                        int[] iArr4 = LOG;
                        cArr[i7] = (char) (c ^ iArr3[(iArr4[charAt] + iArr4[iArr2[i7]]) % 255]);
                    }
                    i7--;
                }
                if (charAt == 0 || iArr2[0] == 0) {
                    cArr[0] = 0;
                } else {
                    int[] iArr5 = ALOG;
                    int[] iArr6 = LOG;
                    cArr[0] = (char) iArr5[(iArr6[charAt] + iArr6[iArr2[0]]) % 255];
                }
            }
            char[] cArr2 = new char[i3];
            for (int i8 = 0; i8 < i3; i8++) {
                cArr2[i8] = cArr[(i3 - i8) - 1];
            }
            return String.valueOf(cArr2);
        }
        throw new IllegalArgumentException("Illegal number of error correction codewords specified: ".concat(String.valueOf(i3)));
    }
}
