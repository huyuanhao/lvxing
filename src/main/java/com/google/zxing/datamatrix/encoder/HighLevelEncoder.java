package com.google.zxing.datamatrix.encoder;

import com.google.zxing.Dimension;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.util.Arrays;

public final class HighLevelEncoder {
    static final int ASCII_ENCODATION = 0;
    static final int BASE256_ENCODATION = 5;
    static final int C40_ENCODATION = 1;
    static final char C40_UNLATCH = 'þ';
    static final int EDIFACT_ENCODATION = 4;
    static final char LATCH_TO_ANSIX12 = 'î';
    static final char LATCH_TO_BASE256 = 'ç';
    static final char LATCH_TO_C40 = 'æ';
    static final char LATCH_TO_EDIFACT = 'ð';
    static final char LATCH_TO_TEXT = 'ï';
    private static final char MACRO_05 = 'ì';
    private static final String MACRO_05_HEADER = "[)>\u001e05\u001d";
    private static final char MACRO_06 = 'í';
    private static final String MACRO_06_HEADER = "[)>\u001e06\u001d";
    private static final String MACRO_TRAILER = "\u001e\u0004";
    private static final char PAD = '';
    static final int TEXT_ENCODATION = 2;
    static final char UPPER_SHIFT = 'ë';
    static final int X12_ENCODATION = 3;
    static final char X12_UNLATCH = 'þ';

    static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    static boolean isExtendedASCII(char c) {
        return c >= 128 && c <= 255;
    }

    private static boolean isNativeC40(char c) {
        return c == ' ' || (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z');
    }

    private static boolean isNativeEDIFACT(char c) {
        return c >= ' ' && c <= '^';
    }

    private static boolean isNativeText(char c) {
        return c == ' ' || (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z');
    }

    private static boolean isSpecialB256(char c) {
        return false;
    }

    private static boolean isX12TermSep(char c) {
        return c == 13 || c == '*' || c == '>';
    }

    private HighLevelEncoder() {
    }

    private static char randomize253State(char c, int i) {
        int i2 = c + ((i * 149) % TinkerReport.KEY_LOADED_EXCEPTION_DEX_CHECK) + 1;
        if (i2 > 254) {
            i2 -= 254;
        }
        return (char) i2;
    }

    public static String encodeHighLevel(String str) {
        return encodeHighLevel(str, SymbolShapeHint.FORCE_NONE, null, null);
    }

    public static String encodeHighLevel(String str, SymbolShapeHint symbolShapeHint, Dimension dimension, Dimension dimension2) {
        int i = 0;
        Encoder[] encoderArr = {new ASCIIEncoder(), new C40Encoder(), new TextEncoder(), new X12Encoder(), new EdifactEncoder(), new Base256Encoder()};
        EncoderContext encoderContext = new EncoderContext(str);
        encoderContext.setSymbolShape(symbolShapeHint);
        encoderContext.setSizeConstraints(dimension, dimension2);
        boolean startsWith = str.startsWith(MACRO_05_HEADER);
        String str2 = MACRO_TRAILER;
        if (startsWith && str.endsWith(str2)) {
            encoderContext.writeCodeword(MACRO_05);
            encoderContext.setSkipAtEnd(2);
            encoderContext.pos += 7;
        } else if (str.startsWith(MACRO_06_HEADER) && str.endsWith(str2)) {
            encoderContext.writeCodeword(MACRO_06);
            encoderContext.setSkipAtEnd(2);
            encoderContext.pos += 7;
        }
        while (encoderContext.hasMoreCharacters()) {
            encoderArr[i].encode(encoderContext);
            if (encoderContext.getNewEncoding() >= 0) {
                i = encoderContext.getNewEncoding();
                encoderContext.resetEncoderSignal();
            }
        }
        int codewordCount = encoderContext.getCodewordCount();
        encoderContext.updateSymbolInfo();
        int dataCapacity = encoderContext.getSymbolInfo().getDataCapacity();
        if (!(codewordCount >= dataCapacity || i == 0 || i == 5 || i == 4)) {
            encoderContext.writeCodeword(254);
        }
        StringBuilder codewords = encoderContext.getCodewords();
        if (codewords.length() < dataCapacity) {
            codewords.append(PAD);
        }
        while (codewords.length() < dataCapacity) {
            codewords.append(randomize253State(PAD, codewords.length() + 1));
        }
        return encoderContext.getCodewords().toString();
    }

    static int lookAheadTest(CharSequence charSequence, int i, int i2) {
        float[] fArr;
        char c;
        CharSequence charSequence2 = charSequence;
        int i3 = i;
        if (i3 >= charSequence.length()) {
            return i2;
        }
        if (i2 == 0) {
            fArr = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.25f};
        } else {
            fArr = new float[]{1.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.25f};
            fArr[i2] = 0.0f;
        }
        int i4 = 0;
        while (true) {
            int i5 = i3 + i4;
            if (i5 == charSequence.length()) {
                byte[] bArr = new byte[6];
                int[] iArr = new int[6];
                int findMinimums = findMinimums(fArr, iArr, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, bArr);
                int minimumCount = getMinimumCount(bArr);
                if (iArr[0] == findMinimums) {
                    return 0;
                }
                if (minimumCount == 1 && bArr[5] > 0) {
                    return 5;
                }
                if (minimumCount == 1 && bArr[4] > 0) {
                    return 4;
                }
                if (minimumCount != 1 || bArr[2] <= 0) {
                    return (minimumCount != 1 || bArr[3] <= 0) ? 1 : 3;
                }
                return 2;
            }
            char charAt = charSequence2.charAt(i5);
            i4++;
            if (isDigit(charAt)) {
                fArr[0] = fArr[0] + 0.5f;
            } else if (isExtendedASCII(charAt)) {
                fArr[0] = (float) Math.ceil((double) fArr[0]);
                fArr[0] = fArr[0] + 2.0f;
            } else {
                fArr[0] = (float) Math.ceil((double) fArr[0]);
                fArr[0] = fArr[0] + 1.0f;
            }
            if (isNativeC40(charAt)) {
                fArr[1] = fArr[1] + 0.6666667f;
            } else if (isExtendedASCII(charAt)) {
                fArr[1] = fArr[1] + 2.6666667f;
            } else {
                fArr[1] = fArr[1] + 1.3333334f;
            }
            if (isNativeText(charAt)) {
                fArr[2] = fArr[2] + 0.6666667f;
            } else if (isExtendedASCII(charAt)) {
                fArr[2] = fArr[2] + 2.6666667f;
            } else {
                fArr[2] = fArr[2] + 1.3333334f;
            }
            if (isNativeX12(charAt)) {
                fArr[3] = fArr[3] + 0.6666667f;
            } else if (isExtendedASCII(charAt)) {
                fArr[3] = fArr[3] + 4.3333335f;
            } else {
                fArr[3] = fArr[3] + 3.3333333f;
            }
            if (isNativeEDIFACT(charAt)) {
                fArr[4] = fArr[4] + 0.75f;
            } else if (isExtendedASCII(charAt)) {
                fArr[4] = fArr[4] + 4.25f;
            } else {
                fArr[4] = fArr[4] + 3.25f;
            }
            if (isSpecialB256(charAt)) {
                c = 5;
                fArr[5] = fArr[5] + 4.0f;
            } else {
                c = 5;
                fArr[5] = fArr[5] + 1.0f;
            }
            if (i4 >= 4) {
                int[] iArr2 = new int[6];
                byte[] bArr2 = new byte[6];
                findMinimums(fArr, iArr2, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, bArr2);
                int minimumCount2 = getMinimumCount(bArr2);
                if (iArr2[0] < iArr2[c] && iArr2[0] < iArr2[1] && iArr2[0] < iArr2[2] && iArr2[0] < iArr2[3] && iArr2[0] < iArr2[4]) {
                    return 0;
                }
                if (iArr2[5] >= iArr2[0] && bArr2[1] + bArr2[2] + bArr2[3] + bArr2[4] != 0) {
                    if (minimumCount2 == 1 && bArr2[4] > 0) {
                        return 4;
                    }
                    if (minimumCount2 == 1 && bArr2[2] > 0) {
                        return 2;
                    }
                    if (minimumCount2 == 1 && bArr2[3] > 0) {
                        return 3;
                    }
                    if (iArr2[1] + 1 < iArr2[0] && iArr2[1] + 1 < iArr2[5] && iArr2[1] + 1 < iArr2[4] && iArr2[1] + 1 < iArr2[2]) {
                        if (iArr2[1] < iArr2[3]) {
                            return 1;
                        }
                        if (iArr2[1] == iArr2[3]) {
                            int i6 = i3 + i4 + 1;
                            while (i6 < charSequence.length()) {
                                char charAt2 = charSequence2.charAt(i6);
                                if (!isX12TermSep(charAt2)) {
                                    if (!isNativeX12(charAt2)) {
                                        break;
                                    }
                                    i6++;
                                } else {
                                    return 3;
                                }
                            }
                            return 1;
                        }
                    }
                }
            }
        }
        return 5;
    }

    private static int findMinimums(float[] fArr, int[] iArr, int i, byte[] bArr) {
        Arrays.fill(bArr, 0);
        int i2 = i;
        for (int i3 = 0; i3 < 6; i3++) {
            iArr[i3] = (int) Math.ceil((double) fArr[i3]);
            int i4 = iArr[i3];
            if (i2 > i4) {
                Arrays.fill(bArr, 0);
                i2 = i4;
            }
            if (i2 == i4) {
                bArr[i3] = (byte) (bArr[i3] + 1);
            }
        }
        return i2;
    }

    private static int getMinimumCount(byte[] bArr) {
        int i = 0;
        for (int i2 = 0; i2 < 6; i2++) {
            i += bArr[i2];
        }
        return i;
    }

    private static boolean isNativeX12(char c) {
        return isX12TermSep(c) || c == ' ' || (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z');
    }

    public static int determineConsecutiveDigitCount(CharSequence charSequence, int i) {
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

    static void illegalCharacter(char c) {
        String hexString = Integer.toHexString(c);
        StringBuilder sb = new StringBuilder();
        sb.append("0000".substring(0, 4 - hexString.length()));
        sb.append(hexString);
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder("Illegal character: ");
        sb3.append(c);
        sb3.append(" (0x");
        sb3.append(sb2);
        sb3.append(')');
        throw new IllegalArgumentException(sb3.toString());
    }
}
