package com.google.zxing.aztec.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.aztec.AztecDetectorResult;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.p522qq.p523e.comm.constants.Constants;
import com.tencent.mid.sotrage.StorageInterface;
import java.util.Arrays;
import org.slf4j.Marker;

public final class Decoder {
    private static final String[] DIGIT_TABLE = {"CTRL_PS", " ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", StorageInterface.KEY_SPLITER, ".", "CTRL_UL", "CTRL_US"};
    private static final String[] LOWER_TABLE = {"CTRL_PS", " ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", Constants.LANDSCAPE, "m", "n", "o", Constants.PORTRAIT, "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] MIXED_TABLE = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
    private static final String[] PUNCT_TABLE = {"", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", Marker.ANY_MARKER, Marker.ANY_NON_NULL_MARKER, StorageInterface.KEY_SPLITER, "-", ".", "/", ":", ";", "<", "=", ">", "?", "[", "]", "{", "}", "CTRL_UL"};
    private static final String[] UPPER_TABLE = {"CTRL_PS", " ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private AztecDetectorResult ddata;

    /* renamed from: com.google.zxing.aztec.decoder.Decoder$1 */
    static /* synthetic */ class C27961 {
        static final /* synthetic */ int[] $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table = new int[Table.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
     */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
            com.google.zxing.aztec.decoder.Decoder$Table[] r0 = com.google.zxing.aztec.decoder.Decoder.Table.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table = r0
            int[] r0 = $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.google.zxing.aztec.decoder.Decoder$Table r1 = com.google.zxing.aztec.decoder.Decoder.Table.UPPER     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table     // Catch:{ NoSuchFieldError -> 0x001f }
            com.google.zxing.aztec.decoder.Decoder$Table r1 = com.google.zxing.aztec.decoder.Decoder.Table.LOWER     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            int[] r0 = $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table     // Catch:{ NoSuchFieldError -> 0x002a }
            com.google.zxing.aztec.decoder.Decoder$Table r1 = com.google.zxing.aztec.decoder.Decoder.Table.MIXED     // Catch:{ NoSuchFieldError -> 0x002a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            int[] r0 = $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table     // Catch:{ NoSuchFieldError -> 0x0035 }
            com.google.zxing.aztec.decoder.Decoder$Table r1 = com.google.zxing.aztec.decoder.Decoder.Table.PUNCT     // Catch:{ NoSuchFieldError -> 0x0035 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            int[] r0 = $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table     // Catch:{ NoSuchFieldError -> 0x0040 }
            com.google.zxing.aztec.decoder.Decoder$Table r1 = com.google.zxing.aztec.decoder.Decoder.Table.DIGIT     // Catch:{ NoSuchFieldError -> 0x0040 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
            r2 = 5
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
        L_0x0040:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.aztec.decoder.Decoder.C27961.m45073clinit():void");
        }
    }

    /* renamed from: com.google.zxing.aztec.decoder.Decoder$Table */
    private enum Table {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    private static int totalBitsInLayer(int i, boolean z) {
        return ((z ? 88 : 112) + (i << 4)) * i;
    }

    public DecoderResult decode(AztecDetectorResult aztecDetectorResult) throws FormatException {
        this.ddata = aztecDetectorResult;
        boolean[] correctBits = correctBits(extractBits(aztecDetectorResult.getBits()));
        DecoderResult decoderResult = new DecoderResult(convertBoolArrayToByteArray(correctBits), getEncodedData(correctBits), null, null);
        decoderResult.setNumBits(correctBits.length);
        return decoderResult;
    }

    public static String highLevelDecode(boolean[] zArr) {
        return getEncodedData(zArr);
    }

    private static String getEncodedData(boolean[] zArr) {
        int length = zArr.length;
        Table table = Table.UPPER;
        Table table2 = Table.UPPER;
        StringBuilder sb = new StringBuilder(20);
        Table table3 = table;
        int i = 0;
        while (i < length) {
            if (table2 == Table.BINARY) {
                if (length - i < 5) {
                    break;
                }
                int readCode = readCode(zArr, i, 5);
                int i2 = i + 5;
                if (readCode == 0) {
                    if (length - i2 < 11) {
                        break;
                    }
                    readCode = readCode(zArr, i2, 11) + 31;
                    i2 += 11;
                }
                int i3 = i2;
                int i4 = 0;
                while (true) {
                    if (i4 >= readCode) {
                        i = i3;
                        break;
                    } else if (length - i3 < 8) {
                        i = length;
                        break;
                    } else {
                        sb.append((char) readCode(zArr, i3, 8));
                        i3 += 8;
                        i4++;
                    }
                }
            } else {
                int i5 = table2 == Table.DIGIT ? 4 : 5;
                if (length - i < i5) {
                    break;
                }
                int readCode2 = readCode(zArr, i, i5);
                i += i5;
                String character = getCharacter(table2, readCode2);
                if (character.startsWith("CTRL_")) {
                    table3 = getTable(character.charAt(5));
                    if (character.charAt(6) != 'L') {
                        Table table4 = table3;
                        table3 = table2;
                        table2 = table4;
                    }
                } else {
                    sb.append(character);
                }
            }
            table2 = table3;
        }
        return sb.toString();
    }

    private static Table getTable(char c) {
        if (c == 'B') {
            return Table.BINARY;
        }
        if (c == 'D') {
            return Table.DIGIT;
        }
        if (c == 'P') {
            return Table.PUNCT;
        }
        if (c == 'L') {
            return Table.LOWER;
        }
        if (c != 'M') {
            return Table.UPPER;
        }
        return Table.MIXED;
    }

    private static String getCharacter(Table table, int i) {
        int i2 = C27961.$SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[table.ordinal()];
        if (i2 == 1) {
            return UPPER_TABLE[i];
        }
        if (i2 == 2) {
            return LOWER_TABLE[i];
        }
        if (i2 == 3) {
            return MIXED_TABLE[i];
        }
        if (i2 == 4) {
            return PUNCT_TABLE[i];
        }
        if (i2 == 5) {
            return DIGIT_TABLE[i];
        }
        throw new IllegalStateException("Bad table");
    }

    private boolean[] correctBits(boolean[] zArr) throws FormatException {
        GenericGF genericGF;
        int i = 8;
        if (this.ddata.getNbLayers() <= 2) {
            i = 6;
            genericGF = GenericGF.AZTEC_DATA_6;
        } else if (this.ddata.getNbLayers() <= 8) {
            genericGF = GenericGF.AZTEC_DATA_8;
        } else if (this.ddata.getNbLayers() <= 22) {
            i = 10;
            genericGF = GenericGF.AZTEC_DATA_10;
        } else {
            i = 12;
            genericGF = GenericGF.AZTEC_DATA_12;
        }
        int nbDatablocks = this.ddata.getNbDatablocks();
        int length = zArr.length / i;
        if (length >= nbDatablocks) {
            int[] iArr = new int[length];
            int length2 = zArr.length % i;
            int i2 = 0;
            while (i2 < length) {
                iArr[i2] = readCode(zArr, length2, i);
                i2++;
                length2 += i;
            }
            try {
                new ReedSolomonDecoder(genericGF).decode(iArr, length - nbDatablocks);
                int i3 = (1 << i) - 1;
                int i4 = 0;
                for (int i5 = 0; i5 < nbDatablocks; i5++) {
                    int i6 = iArr[i5];
                    if (i6 == 0 || i6 == i3) {
                        throw FormatException.getFormatInstance();
                    }
                    if (i6 == 1 || i6 == i3 - 1) {
                        i4++;
                    }
                }
                boolean[] zArr2 = new boolean[((nbDatablocks * i) - i4)];
                int i7 = 0;
                for (int i8 = 0; i8 < nbDatablocks; i8++) {
                    int i9 = iArr[i8];
                    if (i9 == 1 || i9 == i3 - 1) {
                        Arrays.fill(zArr2, i7, (i7 + i) - 1, i9 > 1);
                        i7 += i - 1;
                    } else {
                        int i10 = i - 1;
                        while (i10 >= 0) {
                            int i11 = i7 + 1;
                            zArr2[i7] = ((1 << i10) & i9) != 0;
                            i10--;
                            i7 = i11;
                        }
                    }
                }
                return zArr2;
            } catch (ReedSolomonException e) {
                throw FormatException.getFormatInstance(e);
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }

    private boolean[] extractBits(BitMatrix bitMatrix) {
        BitMatrix bitMatrix2 = bitMatrix;
        boolean isCompact = this.ddata.isCompact();
        int nbLayers = this.ddata.getNbLayers();
        int i = (isCompact ? 11 : 14) + (nbLayers << 2);
        int[] iArr = new int[i];
        boolean[] zArr = new boolean[totalBitsInLayer(nbLayers, isCompact)];
        int i2 = 2;
        if (isCompact) {
            for (int i3 = 0; i3 < iArr.length; i3++) {
                iArr[i3] = i3;
            }
        } else {
            int i4 = i / 2;
            int i5 = ((i + 1) + (((i4 - 1) / 15) * 2)) / 2;
            for (int i6 = 0; i6 < i4; i6++) {
                int i7 = (i6 / 15) + i6;
                iArr[(i4 - i6) - 1] = (i5 - i7) - 1;
                iArr[i4 + i6] = i7 + i5 + 1;
            }
        }
        int i8 = 0;
        int i9 = 0;
        while (i8 < nbLayers) {
            int i10 = ((nbLayers - i8) << i2) + (isCompact ? 9 : 12);
            int i11 = i8 << 1;
            int i12 = (i - 1) - i11;
            int i13 = 0;
            while (i13 < i10) {
                int i14 = i13 << 1;
                int i15 = 0;
                for (i2 = 
/*
Method generation error in method: com.google.zxing.aztec.decoder.Decoder.extractBits(com.google.zxing.common.BitMatrix):boolean[], dex: classes.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r8v2 'i2' int) = (r8v1 'i2' int), (r8v5 'i2' int) binds: {(r8v1 'i2' int)=B:19:0x0062, (r8v5 'i2' int)=B:24:0x00c1} in method: com.google.zxing.aztec.decoder.Decoder.extractBits(com.google.zxing.common.BitMatrix):boolean[], dex: classes.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:238)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:192)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:227)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:227)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:193)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:324)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:261)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:224)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:111)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:77)
	at jadx.core.codegen.CodeGen.generate(CodeGen.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:36)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
Caused by: jadx.core.utils.exceptions.CodegenException: PHI can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:536)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:508)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:232)
	... 24 more

*/

    private static int readCode(boolean[] zArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            i3 <<= 1;
            if (zArr[i4]) {
                i3 |= 1;
            }
        }
        return i3;
    }

    private static byte readByte(boolean[] zArr, int i) {
        int readCode;
        int length = zArr.length - i;
        if (length >= 8) {
            readCode = readCode(zArr, i, 8);
        } else {
            readCode = readCode(zArr, i, length) << (8 - length);
        }
        return (byte) readCode;
    }

    static byte[] convertBoolArrayToByteArray(boolean[] zArr) {
        byte[] bArr = new byte[((zArr.length + 7) / 8)];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = readByte(zArr, i << 3);
        }
        return bArr;
    }
}
