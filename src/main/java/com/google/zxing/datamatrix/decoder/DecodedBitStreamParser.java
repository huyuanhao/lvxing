package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitSource;
import com.google.zxing.common.DecoderResult;
import com.tencent.p605ep.commonbase.utils.ScreenUtil;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;

final class DecodedBitStreamParser {
    private static final char[] C40_BASIC_SET_CHARS = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private static final char[] C40_SHIFT2_SET_CHARS = {'!', '\"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_'};
    private static final char[] TEXT_BASIC_SET_CHARS = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static final char[] TEXT_SHIFT2_SET_CHARS = C40_SHIFT2_SET_CHARS;
    private static final char[] TEXT_SHIFT3_SET_CHARS = {'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', 127};

    /* renamed from: com.google.zxing.datamatrix.decoder.DecodedBitStreamParser$1 */
    static /* synthetic */ class C27981 {
        /* renamed from: $SwitchMap$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode */
        static final /* synthetic */ int[] f9503xb73eb560 = new int[Mode.values().length];

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
            com.google.zxing.datamatrix.decoder.DecodedBitStreamParser$Mode[] r0 = com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.Mode.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f9503xb73eb560 = r0
            int[] r0 = f9503xb73eb560     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.google.zxing.datamatrix.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.Mode.C40_ENCODE     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f9503xb73eb560     // Catch:{ NoSuchFieldError -> 0x001f }
            com.google.zxing.datamatrix.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.Mode.TEXT_ENCODE     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            int[] r0 = f9503xb73eb560     // Catch:{ NoSuchFieldError -> 0x002a }
            com.google.zxing.datamatrix.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.Mode.ANSIX12_ENCODE     // Catch:{ NoSuchFieldError -> 0x002a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            int[] r0 = f9503xb73eb560     // Catch:{ NoSuchFieldError -> 0x0035 }
            com.google.zxing.datamatrix.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.Mode.EDIFACT_ENCODE     // Catch:{ NoSuchFieldError -> 0x0035 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            int[] r0 = f9503xb73eb560     // Catch:{ NoSuchFieldError -> 0x0040 }
            com.google.zxing.datamatrix.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.Mode.BASE256_ENCODE     // Catch:{ NoSuchFieldError -> 0x0040 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
            r2 = 5
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
        L_0x0040:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.C27981.m45184clinit():void");
        }
    }

    /* renamed from: com.google.zxing.datamatrix.decoder.DecodedBitStreamParser$Mode */
    private enum Mode {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE
    }

    private DecodedBitStreamParser() {
    }

    static DecoderResult decode(byte[] bArr) throws FormatException {
        BitSource bitSource = new BitSource(bArr);
        StringBuilder sb = new StringBuilder(100);
        StringBuilder sb2 = new StringBuilder(0);
        ArrayList arrayList = new ArrayList(1);
        Mode mode = Mode.ASCII_ENCODE;
        do {
            if (mode == Mode.ASCII_ENCODE) {
                mode = decodeAsciiSegment(bitSource, sb, sb2);
            } else {
                int i = C27981.f9503xb73eb560[mode.ordinal()];
                if (i == 1) {
                    decodeC40Segment(bitSource, sb);
                } else if (i == 2) {
                    decodeTextSegment(bitSource, sb);
                } else if (i == 3) {
                    decodeAnsiX12Segment(bitSource, sb);
                } else if (i == 4) {
                    decodeEdifactSegment(bitSource, sb);
                } else if (i == 5) {
                    decodeBase256Segment(bitSource, sb, arrayList);
                } else {
                    throw FormatException.getFormatInstance();
                }
                mode = Mode.ASCII_ENCODE;
            }
            if (mode == Mode.PAD_ENCODE) {
                break;
            }
        } while (bitSource.available() > 0);
        if (sb2.length() > 0) {
            sb.append(sb2);
        }
        String sb3 = sb.toString();
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return new DecoderResult(bArr, sb3, arrayList, null);
    }

    private static Mode decodeAsciiSegment(BitSource bitSource, StringBuilder sb, StringBuilder sb2) throws FormatException {
        boolean z = false;
        do {
            int readBits = bitSource.readBits(8);
            if (readBits == 0) {
                throw FormatException.getFormatInstance();
            } else if (readBits <= 128) {
                if (z) {
                    readBits += 128;
                }
                sb.append((char) (readBits - 1));
                return Mode.ASCII_ENCODE;
            } else if (readBits == 129) {
                return Mode.PAD_ENCODE;
            } else {
                if (readBits <= 229) {
                    int i = readBits - 130;
                    if (i < 10) {
                        sb.append('0');
                    }
                    sb.append(i);
                } else {
                    String str = "\u001e\u0004";
                    switch (readBits) {
                        case 230:
                            return Mode.C40_ENCODE;
                        case 231:
                            return Mode.BASE256_ENCODE;
                        case 232:
                            sb.append(29);
                            break;
                        case 233:
                        case 234:
                        case 241:
                            break;
                        case 235:
                            z = true;
                            break;
                        case 236:
                            sb.append("[)>\u001e05\u001d");
                            sb2.insert(0, str);
                            break;
                        case 237:
                            sb.append("[)>\u001e06\u001d");
                            sb2.insert(0, str);
                            break;
                        case 238:
                            return Mode.ANSIX12_ENCODE;
                        case 239:
                            return Mode.TEXT_ENCODE;
                        case ScreenUtil.G8_WIDTH /*240*/:
                            return Mode.EDIFACT_ENCODE;
                        default:
                            if (!(readBits == 254 && bitSource.available() == 0)) {
                                throw FormatException.getFormatInstance();
                            }
                    }
                }
            }
        } while (bitSource.available() > 0);
        return Mode.ASCII_ENCODE;
    }

    private static void decodeC40Segment(BitSource bitSource, StringBuilder sb) throws FormatException {
        int[] iArr = new int[3];
        boolean z = false;
        int i = 0;
        while (bitSource.available() != 8) {
            int readBits = bitSource.readBits(8);
            if (readBits != 254) {
                parseTwoBytes(readBits, bitSource.readBits(8), iArr);
                boolean z2 = z;
                for (int i2 = 0; i2 < 3; i2++) {
                    int i3 = iArr[i2];
                    if (i != 0) {
                        if (i != 1) {
                            if (i == 2) {
                                char[] cArr = C40_SHIFT2_SET_CHARS;
                                if (i3 < cArr.length) {
                                    char c = cArr[i3];
                                    if (z2) {
                                        sb.append((char) (c + 128));
                                    } else {
                                        sb.append(c);
                                    }
                                } else if (i3 == 27) {
                                    sb.append(29);
                                } else if (i3 == 30) {
                                    z2 = true;
                                } else {
                                    throw FormatException.getFormatInstance();
                                }
                                i = 0;
                            } else if (i != 3) {
                                throw FormatException.getFormatInstance();
                            } else if (z2) {
                                sb.append((char) (i3 + 224));
                            } else {
                                sb.append((char) (i3 + 96));
                                i = 0;
                            }
                        } else if (z2) {
                            sb.append((char) (i3 + 128));
                        } else {
                            sb.append((char) i3);
                            i = 0;
                        }
                        z2 = false;
                        i = 0;
                    } else if (i3 < 3) {
                        i = i3 + 1;
                    } else {
                        char[] cArr2 = C40_BASIC_SET_CHARS;
                        if (i3 < cArr2.length) {
                            char c2 = cArr2[i3];
                            if (z2) {
                                sb.append((char) (c2 + 128));
                                z2 = false;
                            } else {
                                sb.append(c2);
                            }
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                    }
                }
                if (bitSource.available() > 0) {
                    z = z2;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private static void decodeTextSegment(BitSource bitSource, StringBuilder sb) throws FormatException {
        int[] iArr = new int[3];
        boolean z = false;
        int i = 0;
        while (bitSource.available() != 8) {
            int readBits = bitSource.readBits(8);
            if (readBits != 254) {
                parseTwoBytes(readBits, bitSource.readBits(8), iArr);
                boolean z2 = z;
                for (int i2 = 0; i2 < 3; i2++) {
                    int i3 = iArr[i2];
                    if (i != 0) {
                        if (i != 1) {
                            if (i == 2) {
                                char[] cArr = TEXT_SHIFT2_SET_CHARS;
                                if (i3 < cArr.length) {
                                    char c = cArr[i3];
                                    if (z2) {
                                        sb.append((char) (c + 128));
                                    } else {
                                        sb.append(c);
                                    }
                                } else if (i3 == 27) {
                                    sb.append(29);
                                } else if (i3 == 30) {
                                    z2 = true;
                                } else {
                                    throw FormatException.getFormatInstance();
                                }
                                i = 0;
                            } else if (i == 3) {
                                char[] cArr2 = TEXT_SHIFT3_SET_CHARS;
                                if (i3 < cArr2.length) {
                                    char c2 = cArr2[i3];
                                    if (z2) {
                                        sb.append((char) (c2 + 128));
                                    } else {
                                        sb.append(c2);
                                        i = 0;
                                    }
                                } else {
                                    throw FormatException.getFormatInstance();
                                }
                            } else {
                                throw FormatException.getFormatInstance();
                            }
                        } else if (z2) {
                            sb.append((char) (i3 + 128));
                        } else {
                            sb.append((char) i3);
                            i = 0;
                        }
                        z2 = false;
                        i = 0;
                    } else if (i3 < 3) {
                        i = i3 + 1;
                    } else {
                        char[] cArr3 = TEXT_BASIC_SET_CHARS;
                        if (i3 < cArr3.length) {
                            char c3 = cArr3[i3];
                            if (z2) {
                                sb.append((char) (c3 + 128));
                                z2 = false;
                            } else {
                                sb.append(c3);
                            }
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                    }
                }
                if (bitSource.available() > 0) {
                    z = z2;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private static void decodeAnsiX12Segment(BitSource bitSource, StringBuilder sb) throws FormatException {
        int[] iArr = new int[3];
        while (bitSource.available() != 8) {
            int readBits = bitSource.readBits(8);
            if (readBits != 254) {
                parseTwoBytes(readBits, bitSource.readBits(8), iArr);
                for (int i = 0; i < 3; i++) {
                    int i2 = iArr[i];
                    if (i2 == 0) {
                        sb.append(13);
                    } else if (i2 == 1) {
                        sb.append('*');
                    } else if (i2 == 2) {
                        sb.append('>');
                    } else if (i2 == 3) {
                        sb.append(' ');
                    } else if (i2 < 14) {
                        sb.append((char) (i2 + 44));
                    } else if (i2 < 40) {
                        sb.append((char) (i2 + 51));
                    } else {
                        throw FormatException.getFormatInstance();
                    }
                }
                if (bitSource.available() <= 0) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private static void parseTwoBytes(int i, int i2, int[] iArr) {
        int i3 = ((i << 8) + i2) - 1;
        int i4 = i3 / 1600;
        iArr[0] = i4;
        int i5 = i3 - (i4 * 1600);
        int i6 = i5 / 40;
        iArr[1] = i6;
        iArr[2] = i5 - (i6 * 40);
    }

    private static void decodeEdifactSegment(BitSource bitSource, StringBuilder sb) {
        while (bitSource.available() > 16) {
            for (int i = 0; i < 4; i++) {
                int readBits = bitSource.readBits(6);
                if (readBits == 31) {
                    int bitOffset = 8 - bitSource.getBitOffset();
                    if (bitOffset != 8) {
                        bitSource.readBits(bitOffset);
                    }
                    return;
                }
                if ((readBits & 32) == 0) {
                    readBits |= 64;
                }
                sb.append((char) readBits);
            }
            if (bitSource.available() <= 0) {
                return;
            }
        }
    }

    private static void decodeBase256Segment(BitSource bitSource, StringBuilder sb, Collection<byte[]> collection) throws FormatException {
        int byteOffset = bitSource.getByteOffset() + 1;
        int i = byteOffset + 1;
        int unrandomize255State = unrandomize255State(bitSource.readBits(8), byteOffset);
        if (unrandomize255State == 0) {
            unrandomize255State = bitSource.available() / 8;
        } else if (unrandomize255State >= 250) {
            unrandomize255State = ((unrandomize255State - 249) * 250) + unrandomize255State(bitSource.readBits(8), i);
            i++;
        }
        if (unrandomize255State >= 0) {
            byte[] bArr = new byte[unrandomize255State];
            int i2 = 0;
            while (i2 < unrandomize255State) {
                if (bitSource.available() >= 8) {
                    int i3 = i + 1;
                    bArr[i2] = (byte) unrandomize255State(bitSource.readBits(8), i);
                    i2++;
                    i = i3;
                } else {
                    throw FormatException.getFormatInstance();
                }
            }
            collection.add(bArr);
            try {
                sb.append(new String(bArr, "ISO8859_1"));
            } catch (UnsupportedEncodingException e) {
                throw new IllegalStateException("Platform does not support required encoding: ".concat(String.valueOf(e)));
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }

    private static int unrandomize255State(int i, int i2) {
        int i3 = i - (((i2 * 149) % 255) + 1);
        return i3 >= 0 ? i3 : i3 + 256;
    }
}
