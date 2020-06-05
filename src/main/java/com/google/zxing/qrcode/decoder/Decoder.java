package com.google.zxing.qrcode.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.util.Map;

public final class Decoder {
    private final ReedSolomonDecoder rsDecoder = new ReedSolomonDecoder(GenericGF.QR_CODE_FIELD_256);

    public DecoderResult decode(boolean[][] zArr) throws ChecksumException, FormatException {
        return decode(zArr, null);
    }

    public DecoderResult decode(boolean[][] zArr, Map<DecodeHintType, ?> map) throws ChecksumException, FormatException {
        return decode(BitMatrix.parse(zArr), map);
    }

    public DecoderResult decode(BitMatrix bitMatrix) throws ChecksumException, FormatException {
        return decode(bitMatrix, null);
    }

    /* JADX WARNING: type inference failed for: r5v1 */
    /* JADX WARNING: type inference failed for: r5v2, types: [java.lang.Throwable] */
    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.Throwable] */
    /* JADX WARNING: type inference failed for: r5v3 */
    /* JADX WARNING: type inference failed for: r1v1, types: [com.google.zxing.FormatException] */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r5v4 */
    /* JADX WARNING: type inference failed for: r5v5 */
    /* JADX WARNING: type inference failed for: r1v3, types: [com.google.zxing.ChecksumException] */
    /* JADX WARNING: type inference failed for: r5v6, types: [com.google.zxing.common.DecoderResult] */
    /* JADX WARNING: type inference failed for: r5v7 */
    /* JADX WARNING: type inference failed for: r5v8 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r5v9 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r5v5
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
    /* JADX WARNING: Unknown variable types count: 9 */
    public com.google.zxing.common.DecoderResult decode(com.google.zxing.common.BitMatrix r5, java.util.Map<com.google.zxing.DecodeHintType, ?> r6) throws com.google.zxing.FormatException, com.google.zxing.ChecksumException {
        /*
        r4 = this;
        com.google.zxing.qrcode.decoder.BitMatrixParser r0 = new com.google.zxing.qrcode.decoder.BitMatrixParser
        r0.m45363init(r5)
        r5 = 0
        com.google.zxing.common.DecoderResult r5 = r4.decode(r0, r6)     // Catch:{ FormatException -> 0x000d, ChecksumException -> 0x000b }
        return r5
    L_0x000b:
        r1 = move-exception
        goto L_0x0011
    L_0x000d:
        r1 = move-exception
        r3 = r1
        r1 = r5
        r5 = r3
    L_0x0011:
        r0.remask()     // Catch:{ ChecksumException | FormatException -> 0x002e }
        r2 = 1
        r0.setMirror(r2)     // Catch:{ ChecksumException | FormatException -> 0x002e }
        r0.readVersion()     // Catch:{ ChecksumException | FormatException -> 0x002e }
        r0.readFormatInformation()     // Catch:{ ChecksumException | FormatException -> 0x002e }
        r0.mirror()     // Catch:{ ChecksumException | FormatException -> 0x002e }
        com.google.zxing.common.DecoderResult r6 = r4.decode(r0, r6)     // Catch:{ ChecksumException | FormatException -> 0x002e }
        com.google.zxing.qrcode.decoder.QRCodeDecoderMetaData r0 = new com.google.zxing.qrcode.decoder.QRCodeDecoderMetaData     // Catch:{ ChecksumException | FormatException -> 0x002e }
        r0.m45386init(r2)     // Catch:{ ChecksumException | FormatException -> 0x002e }
        r6.setOther(r0)     // Catch:{ ChecksumException | FormatException -> 0x002e }
        return r6
        if (r5 == 0) goto L_0x0032
        throw r5
    L_0x0032:
        throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.decoder.Decoder.decode(com.google.zxing.common.BitMatrix, java.util.Map):com.google.zxing.common.DecoderResult");
    }

    private DecoderResult decode(BitMatrixParser bitMatrixParser, Map<DecodeHintType, ?> map) throws FormatException, ChecksumException {
        Version readVersion = bitMatrixParser.readVersion();
        ErrorCorrectionLevel errorCorrectionLevel = bitMatrixParser.readFormatInformation().getErrorCorrectionLevel();
        DataBlock[] dataBlocks = DataBlock.getDataBlocks(bitMatrixParser.readCodewords(), readVersion, errorCorrectionLevel);
        int i = 0;
        for (DataBlock numDataCodewords : dataBlocks) {
            i += numDataCodewords.getNumDataCodewords();
        }
        byte[] bArr = new byte[i];
        int length = dataBlocks.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            DataBlock dataBlock = dataBlocks[i2];
            byte[] codewords = dataBlock.getCodewords();
            int numDataCodewords2 = dataBlock.getNumDataCodewords();
            correctErrors(codewords, numDataCodewords2);
            int i4 = i3;
            int i5 = 0;
            while (i5 < numDataCodewords2) {
                int i6 = i4 + 1;
                bArr[i4] = codewords[i5];
                i5++;
                i4 = i6;
            }
            i2++;
            i3 = i4;
        }
        return DecodedBitStreamParser.decode(bArr, readVersion, errorCorrectionLevel, map);
    }

    private void correctErrors(byte[] bArr, int i) throws ChecksumException {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
        }
        try {
            this.rsDecoder.decode(iArr, bArr.length - i);
            for (int i3 = 0; i3 < i; i3++) {
                bArr[i3] = (byte) iArr[i3];
            }
        } catch (ReedSolomonException unused) {
            throw ChecksumException.getChecksumInstance();
        }
    }
}
