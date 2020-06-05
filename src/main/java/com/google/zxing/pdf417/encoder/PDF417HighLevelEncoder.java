package com.google.zxing.pdf417.encoder;

import com.google.zxing.WriterException;
import com.google.zxing.common.CharacterSetECI;
import com.p522qq.taf.jce.JceStruct;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

final class PDF417HighLevelEncoder {
    private static final int BYTE_COMPACTION = 1;
    private static final Charset DEFAULT_ENCODING = StandardCharsets.ISO_8859_1;
    private static final int ECI_CHARSET = 927;
    private static final int ECI_GENERAL_PURPOSE = 926;
    private static final int ECI_USER_DEFINED = 925;
    private static final int LATCH_TO_BYTE = 924;
    private static final int LATCH_TO_BYTE_PADDED = 901;
    private static final int LATCH_TO_NUMERIC = 902;
    private static final int LATCH_TO_TEXT = 900;
    private static final byte[] MIXED = new byte[128];
    private static final int NUMERIC_COMPACTION = 2;
    private static final byte[] PUNCTUATION = new byte[128];
    private static final int SHIFT_TO_BYTE = 913;
    private static final int SUBMODE_ALPHA = 0;
    private static final int SUBMODE_LOWER = 1;
    private static final int SUBMODE_MIXED = 2;
    private static final int SUBMODE_PUNCTUATION = 3;
    private static final int TEXT_COMPACTION = 0;
    private static final byte[] TEXT_MIXED_RAW = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, JceStruct.SIMPLE_LIST, 9, 44, 58, 35, 45, 46, 36, 47, 43, 37, 42, 61, 94, 0, 32, 0, 0, 0};
    private static final byte[] TEXT_PUNCTUATION_RAW = {59, 60, 62, 64, 91, 92, 93, 95, 96, 126, 33, JceStruct.SIMPLE_LIST, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, 42, 40, 41, 63, 123, 125, 39, 0};

    /* renamed from: com.google.zxing.pdf417.encoder.PDF417HighLevelEncoder$1 */
    static /* synthetic */ class C28041 {
        static final /* synthetic */ int[] $SwitchMap$com$google$zxing$pdf417$encoder$Compaction = new int[Compaction.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
            com.google.zxing.pdf417.encoder.Compaction[] r0 = com.google.zxing.pdf417.encoder.Compaction.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            $SwitchMap$com$google$zxing$pdf417$encoder$Compaction = r0
            int[] r0 = $SwitchMap$com$google$zxing$pdf417$encoder$Compaction     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.google.zxing.pdf417.encoder.Compaction r1 = com.google.zxing.pdf417.encoder.Compaction.TEXT     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = $SwitchMap$com$google$zxing$pdf417$encoder$Compaction     // Catch:{ NoSuchFieldError -> 0x001f }
            com.google.zxing.pdf417.encoder.Compaction r1 = com.google.zxing.pdf417.encoder.Compaction.BYTE     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            int[] r0 = $SwitchMap$com$google$zxing$pdf417$encoder$Compaction     // Catch:{ NoSuchFieldError -> 0x002a }
            com.google.zxing.pdf417.encoder.Compaction r1 = com.google.zxing.pdf417.encoder.Compaction.NUMERIC     // Catch:{ NoSuchFieldError -> 0x002a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.encoder.PDF417HighLevelEncoder.C28041.m45359clinit():void");
        }
    }

    private static boolean isAlphaLower(char c) {
        return c == ' ' || (c >= 'a' && c <= 'z');
    }

    private static boolean isAlphaUpper(char c) {
        return c == ' ' || (c >= 'A' && c <= 'Z');
    }

    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private static boolean isText(char c) {
        return c == 9 || c == 10 || c == 13 || (c >= ' ' && c <= '~');
    }

    static {
        Arrays.fill(MIXED, -1);
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = TEXT_MIXED_RAW;
            if (i2 >= bArr.length) {
                break;
            }
            byte b = bArr[i2];
            if (b > 0) {
                MIXED[b] = (byte) i2;
            }
            i2++;
        }
        Arrays.fill(PUNCTUATION, -1);
        while (true) {
            byte[] bArr2 = TEXT_PUNCTUATION_RAW;
            if (i < bArr2.length) {
                byte b2 = bArr2[i];
                if (b2 > 0) {
                    PUNCTUATION[b2] = (byte) i;
                }
                i++;
            } else {
                return;
            }
        }
    }

    private PDF417HighLevelEncoder() {
    }

    static String encodeHighLevel(String str, Compaction compaction, Charset charset) throws WriterException {
        StringBuilder sb = new StringBuilder(str.length());
        if (charset == null) {
            charset = DEFAULT_ENCODING;
        } else if (!DEFAULT_ENCODING.equals(charset)) {
            CharacterSetECI characterSetECIByName = CharacterSetECI.getCharacterSetECIByName(charset.name());
            if (characterSetECIByName != null) {
                encodingECI(characterSetECIByName.getValue(), sb);
            }
        }
        int length = str.length();
        int i = C28041.$SwitchMap$com$google$zxing$pdf417$encoder$Compaction[compaction.ordinal()];
        if (i == 1) {
            encodeText(str, 0, length, sb, 0);
        } else if (i == 2) {
            byte[] bytes = str.getBytes(charset);
            encodeBinary(bytes, 0, bytes.length, 1, sb);
        } else if (i != 3) {
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (i2 < length) {
                int determineConsecutiveDigitCount = determineConsecutiveDigitCount(str, i2);
                if (determineConsecutiveDigitCount >= 13) {
                    sb.append(902);
                    encodeNumeric(str, i2, determineConsecutiveDigitCount, sb);
                    i2 += determineConsecutiveDigitCount;
                    i3 = 0;
                    i4 = 2;
                } else {
                    int determineConsecutiveTextCount = determineConsecutiveTextCount(str, i2);
                    if (determineConsecutiveTextCount >= 5 || determineConsecutiveDigitCount == length) {
                        if (i4 != 0) {
                            sb.append(900);
                            i3 = 0;
                            i4 = 0;
                        }
                        i3 = encodeText(str, i2, determineConsecutiveTextCount, sb, i3);
                        i2 += determineConsecutiveTextCount;
                    } else {
                        int determineConsecutiveBinaryCount = determineConsecutiveBinaryCount(str, i2, charset);
                        if (determineConsecutiveBinaryCount == 0) {
                            determineConsecutiveBinaryCount = 1;
                        }
                        int i5 = determineConsecutiveBinaryCount + i2;
                        byte[] bytes2 = str.substring(i2, i5).getBytes(charset);
                        if (bytes2.length == 1 && i4 == 0) {
                            encodeBinary(bytes2, 0, 1, 0, sb);
                        } else {
                            encodeBinary(bytes2, 0, bytes2.length, i4, sb);
                            i3 = 0;
                            i4 = 1;
                        }
                        i2 = i5;
                    }
                }
            }
        } else {
            sb.append(902);
            encodeNumeric(str, 0, length, sb);
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x00f6 A[EDGE_INSN: B:68:0x00f6->B:53:0x00f6 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0011 A[SYNTHETIC] */
    private static int encodeText(java.lang.CharSequence r16, int r17, int r18, java.lang.StringBuilder r19, int r20) {
        /*
        r0 = r16
        r1 = r18
        r2 = r19
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>(r1)
        r4 = 2
        r5 = 0
        r6 = 1
        r8 = r20
        r7 = 0
    L_0x0011:
        int r9 = r17 + r7
        char r10 = r0.charAt(r9)
        r11 = 26
        r12 = 32
        r13 = 28
        r14 = 27
        r15 = 29
        if (r8 == 0) goto L_0x00bc
        if (r8 == r6) goto L_0x0083
        if (r8 == r4) goto L_0x003c
        boolean r9 = isPunctuation(r10)
        if (r9 == 0) goto L_0x0037
        byte[] r9 = PUNCTUATION
        byte r9 = r9[r10]
        char r9 = (char) r9
        r3.append(r9)
        goto L_0x00f2
    L_0x0037:
        r3.append(r15)
    L_0x003a:
        r8 = 0
        goto L_0x0011
    L_0x003c:
        boolean r11 = isMixed(r10)
        if (r11 == 0) goto L_0x004c
        byte[] r9 = MIXED
        byte r9 = r9[r10]
        char r9 = (char) r9
        r3.append(r9)
        goto L_0x00f2
    L_0x004c:
        boolean r11 = isAlphaUpper(r10)
        if (r11 == 0) goto L_0x0056
        r3.append(r13)
        goto L_0x003a
    L_0x0056:
        boolean r11 = isAlphaLower(r10)
        if (r11 == 0) goto L_0x0061
        r3.append(r14)
        goto L_0x00d8
    L_0x0061:
        int r9 = r9 + 1
        if (r9 >= r1) goto L_0x0076
        char r9 = r0.charAt(r9)
        boolean r9 = isPunctuation(r9)
        if (r9 == 0) goto L_0x0076
        r8 = 3
        r9 = 25
        r3.append(r9)
        goto L_0x0011
    L_0x0076:
        r3.append(r15)
        byte[] r9 = PUNCTUATION
        byte r9 = r9[r10]
        char r9 = (char) r9
        r3.append(r9)
        goto L_0x00f2
    L_0x0083:
        boolean r9 = isAlphaLower(r10)
        if (r9 == 0) goto L_0x0096
        if (r10 != r12) goto L_0x008f
        r3.append(r11)
        goto L_0x00f2
    L_0x008f:
        int r10 = r10 + -97
        char r9 = (char) r10
        r3.append(r9)
        goto L_0x00f2
    L_0x0096:
        boolean r9 = isAlphaUpper(r10)
        if (r9 == 0) goto L_0x00a6
        r3.append(r14)
        int r10 = r10 + -65
        char r9 = (char) r10
        r3.append(r9)
        goto L_0x00f2
    L_0x00a6:
        boolean r9 = isMixed(r10)
        if (r9 == 0) goto L_0x00b0
        r3.append(r13)
        goto L_0x00e4
    L_0x00b0:
        r3.append(r15)
        byte[] r9 = PUNCTUATION
        byte r9 = r9[r10]
        char r9 = (char) r9
        r3.append(r9)
        goto L_0x00f2
    L_0x00bc:
        boolean r9 = isAlphaUpper(r10)
        if (r9 == 0) goto L_0x00cf
        if (r10 != r12) goto L_0x00c8
        r3.append(r11)
        goto L_0x00f2
    L_0x00c8:
        int r10 = r10 + -65
        char r9 = (char) r10
        r3.append(r9)
        goto L_0x00f2
    L_0x00cf:
        boolean r9 = isAlphaLower(r10)
        if (r9 == 0) goto L_0x00db
        r3.append(r14)
    L_0x00d8:
        r8 = 1
        goto L_0x0011
    L_0x00db:
        boolean r9 = isMixed(r10)
        if (r9 == 0) goto L_0x00e7
        r3.append(r13)
    L_0x00e4:
        r8 = 2
        goto L_0x0011
    L_0x00e7:
        r3.append(r15)
        byte[] r9 = PUNCTUATION
        byte r9 = r9[r10]
        char r9 = (char) r9
        r3.append(r9)
    L_0x00f2:
        int r7 = r7 + 1
        if (r7 < r1) goto L_0x0011
        int r0 = r3.length()
        r1 = 0
        r7 = 0
    L_0x00fc:
        if (r1 >= r0) goto L_0x011a
        int r9 = r1 % 2
        if (r9 == 0) goto L_0x0104
        r9 = 1
        goto L_0x0105
    L_0x0104:
        r9 = 0
    L_0x0105:
        if (r9 == 0) goto L_0x0113
        int r7 = r7 * 30
        char r9 = r3.charAt(r1)
        int r7 = r7 + r9
        char r7 = (char) r7
        r2.append(r7)
        goto L_0x0117
    L_0x0113:
        char r7 = r3.charAt(r1)
    L_0x0117:
        int r1 = r1 + 1
        goto L_0x00fc
    L_0x011a:
        int r0 = r0 % r4
        if (r0 == 0) goto L_0x0124
        int r7 = r7 * 30
        int r7 = r7 + r15
        char r0 = (char) r7
        r2.append(r0)
    L_0x0124:
        return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.encoder.PDF417HighLevelEncoder.encodeText(java.lang.CharSequence, int, int, java.lang.StringBuilder, int):int");
    }

    private static void encodeBinary(byte[] bArr, int i, int i2, int i3, StringBuilder sb) {
        int i4;
        if (i2 == 1 && i3 == 0) {
            sb.append(913);
        } else if (i2 % 6 == 0) {
            sb.append(924);
        } else {
            sb.append(901);
        }
        if (i2 >= 6) {
            char[] cArr = new char[5];
            i4 = i;
            while ((i + i2) - i4 >= 6) {
                long j = 0;
                for (int i5 = 0; i5 < 6; i5++) {
                    j = (j << 8) + ((long) (bArr[i4 + i5] & DeviceInfos.NETWORK_TYPE_UNCONNECTED));
                }
                for (int i6 = 0; i6 < 5; i6++) {
                    cArr[i6] = (char) ((int) (j % 900));
                    j /= 900;
                }
                for (int i7 = 4; i7 >= 0; i7--) {
                    sb.append(cArr[i7]);
                }
                i4 += 6;
            }
        } else {
            i4 = i;
        }
        for (i4 = 
/*
Method generation error in method: com.google.zxing.pdf417.encoder.PDF417HighLevelEncoder.encodeBinary(byte[], int, int, int, java.lang.StringBuilder):void, dex: classes.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r2v0 'i4' int) = (r2v3 'i4' int), (r2v5 'i4' int) binds: {(r2v3 'i4' int)=B:22:0x0057, (r2v5 'i4' int)=B:27:0x0058} in method: com.google.zxing.pdf417.encoder.PDF417HighLevelEncoder.encodeBinary(byte[], int, int, int, java.lang.StringBuilder):void, dex: classes.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:238)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:192)
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
	... 14 more

*/

    private static void encodeNumeric(String str, int i, int i2, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder((i2 / 3) + 1);
        BigInteger valueOf = BigInteger.valueOf(900);
        BigInteger valueOf2 = BigInteger.valueOf(0);
        int i3 = 0;
        while (i3 < i2) {
            sb2.setLength(0);
            int min = Math.min(44, i2 - i3);
            StringBuilder sb3 = new StringBuilder("1");
            int i4 = i + i3;
            sb3.append(str.substring(i4, i4 + min));
            BigInteger bigInteger = new BigInteger(sb3.toString());
            do {
                sb2.append((char) bigInteger.mod(valueOf).intValue());
                bigInteger = bigInteger.divide(valueOf);
            } while (!bigInteger.equals(valueOf2));
            for (int length = sb2.length() - 1; length >= 0; length--) {
                sb.append(sb2.charAt(length));
            }
            i3 += min;
        }
    }

    private static boolean isMixed(char c) {
        return MIXED[c] != -1;
    }

    private static boolean isPunctuation(char c) {
        return PUNCTUATION[c] != -1;
    }

    private static int determineConsecutiveDigitCount(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        if (i < length) {
            char charAt = charSequence.charAt(i);
            while (isDigit(charAt) && i < length) {
                i2++;
                i++;
                if (i < length) {
                    charAt = charSequence.charAt(i);
                }
            }
        }
        return i2;
    }

    private static int determineConsecutiveTextCount(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = i;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            int i3 = 0;
            while (i3 < 13 && isDigit(charAt) && i2 < length) {
                i3++;
                i2++;
                if (i2 < length) {
                    charAt = charSequence.charAt(i2);
                }
            }
            if (i3 < 13) {
                if (i3 <= 0) {
                    if (!isText(charSequence.charAt(i2))) {
                        break;
                    }
                    i2++;
                }
            } else {
                return (i2 - i) - i3;
            }
        }
        return i2 - i;
    }

    private static int determineConsecutiveBinaryCount(String str, int i, Charset charset) throws WriterException {
        CharsetEncoder newEncoder = charset.newEncoder();
        int length = str.length();
        int i2 = i;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            int i3 = 0;
            while (i3 < 13 && isDigit(charAt)) {
                i3++;
                int i4 = i2 + i3;
                if (i4 >= length) {
                    break;
                }
                charAt = str.charAt(i4);
            }
            if (i3 >= 13) {
                return i2 - i;
            }
            char charAt2 = str.charAt(i2);
            if (newEncoder.canEncode(charAt2)) {
                i2++;
            } else {
                StringBuilder sb = new StringBuilder("Non-encodable character detected: ");
                sb.append(charAt2);
                sb.append(" (Unicode: ");
                sb.append(charAt2);
                sb.append(')');
                throw new WriterException(sb.toString());
            }
        }
        return i2 - i;
    }

    private static void encodingECI(int i, StringBuilder sb) throws WriterException {
        if (i >= 0 && i < LATCH_TO_TEXT) {
            sb.append(927);
            sb.append((char) i);
        } else if (i < 810900) {
            sb.append(926);
            sb.append((char) ((i / LATCH_TO_TEXT) - 1));
            sb.append((char) (i % LATCH_TO_TEXT));
        } else if (i < 811800) {
            sb.append(925);
            sb.append((char) (810900 - i));
        } else {
            throw new WriterException("ECI number not in valid range from 0..811799, but was ".concat(String.valueOf(i)));
        }
    }
}
