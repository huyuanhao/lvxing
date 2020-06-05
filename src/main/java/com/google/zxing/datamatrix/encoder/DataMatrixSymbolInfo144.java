package com.google.zxing.datamatrix.encoder;

import com.tencent.bugly.beta.tinker.TinkerReport;

final class DataMatrixSymbolInfo144 extends SymbolInfo {
    public int getDataLengthForInterleavedBlock(int i) {
        return i <= 8 ? TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL : TinkerReport.KEY_APPLIED_PACKAGE_CHECK_META_NOT_FOUND;
    }

    public int getInterleavedBlockCount() {
        return 10;
    }

    DataMatrixSymbolInfo144() {
        super(false, 1558, 620, 22, 22, 36, -1, 62);
    }
}
