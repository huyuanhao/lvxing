package com.google.zxing.oned;

import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.BitArray;

final class UPCEANExtensionSupport {
    private static final int[] EXTENSION_START_PATTERN = {1, 1, 2};
    private final UPCEANExtension5Support fiveSupport = new UPCEANExtension5Support();
    private final UPCEANExtension2Support twoSupport = new UPCEANExtension2Support();

    UPCEANExtensionSupport() {
    }

    /* access modifiers changed from: 0000 */
    public Result decodeRow(int i, BitArray bitArray, int i2) throws NotFoundException {
        int[] findGuardPattern = UPCEANReader.findGuardPattern(bitArray, i2, false, EXTENSION_START_PATTERN);
        try {
            r3 = i;
            r3 = this.fiveSupport.decodeRow(i, bitArray, findGuardPattern);
            r3 = r3;
            return r3;
        } catch (ReaderException unused) {
            return this.twoSupport.decodeRow(r3, bitArray, findGuardPattern);
        }
    }
}
