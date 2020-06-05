package com.tencent.p605ep.commonbase.utils;

import java.io.UnsupportedEncodingException;

/* renamed from: com.tencent.ep.commonbase.utils.Base64 */
public class Base64 {
    static final /* synthetic */ boolean $assertionsDisabled = (!Base64.class.desiredAssertionStatus());
    public static final int CRLF = 4;
    public static final int DEFAULT = 0;
    public static final int NO_CLOSE = 16;
    public static final int NO_PADDING = 1;
    public static final int NO_WRAP = 2;
    public static final int URL_SAFE = 8;

    /* renamed from: com.tencent.ep.commonbase.utils.Base64$Coder */
    static abstract class Coder {
        /* renamed from: op */
        public int f24749op;
        public byte[] output;

        Coder() {
        }

        public abstract int maxOutputSize(int i);

        public abstract boolean process(byte[] bArr, int i, int i2, boolean z);
    }

    /* renamed from: com.tencent.ep.commonbase.utils.Base64$Decoder */
    static class Decoder extends Coder {
        private static final int[] DECODE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int[] DECODE_WEBSAFE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int EQUALS = -2;
        private static final int SKIP = -1;
        private final int[] alphabet;
        private int state;
        private int value;

        public Decoder(int i, byte[] bArr) {
            this.output = bArr;
            this.alphabet = (i & 8) == 0 ? DECODE : DECODE_WEBSAFE;
            this.state = 0;
            this.value = 0;
        }

        public int maxOutputSize(int i) {
            return ((i * 3) / 4) + 10;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00bd, code lost:
            r0.state = 6;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c0, code lost:
            return false;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ec, code lost:
            if (r20 != false) goto L_0x00f5;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x00ee, code lost:
            r0.state = r5;
            r0.value = r8;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x00f2, code lost:
            r0.f24749op = r9;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x00f4, code lost:
            return true;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x00f5, code lost:
            if (r5 == 0) goto L_0x0117;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x00f7, code lost:
            if (r5 == 1) goto L_0x00bd;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x00f9, code lost:
            if (r5 == 2) goto L_0x010f;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x00fb, code lost:
            if (r5 == 3) goto L_0x0100;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x00fd, code lost:
            if (r5 == 4) goto L_0x00bd;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x0100, code lost:
            r1 = r9 + 1;
            r6[r9] = (byte) (r8 >> 10);
            r9 = r1 + 1;
            r6[r1] = (byte) (r8 >> 2);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x010f, code lost:
            r1 = r9 + 1;
            r6[r9] = (byte) (r8 >> 4);
            r9 = r1;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x0117, code lost:
            r0.state = r5;
     */
        public boolean process(byte[] r17, int r18, int r19, boolean r20) {
            /*
            r16 = this;
            r0 = r16
            int r1 = r0.state
            r2 = 0
            r3 = 6
            if (r1 != r3) goto L_0x0009
            return r2
        L_0x0009:
            int r4 = r19 + r18
            int r5 = r0.value
            byte[] r6 = r0.output
            int[] r7 = r0.alphabet
            r8 = r5
            r9 = 0
            r5 = r1
            r1 = r18
        L_0x0016:
            r10 = 3
            r11 = 4
            r12 = 2
            r13 = 1
            if (r1 >= r4) goto L_0x00ec
            if (r5 != 0) goto L_0x0063
        L_0x001e:
            int r14 = r1 + 4
            if (r14 > r4) goto L_0x005f
            byte r8 = r17[r1]
            r8 = r8 & 255(0xff, float:3.57E-43)
            r8 = r7[r8]
            int r8 = r8 << 18
            int r15 = r1 + 1
            byte r15 = r17[r15]
            r15 = r15 & 255(0xff, float:3.57E-43)
            r15 = r7[r15]
            int r15 = r15 << 12
            r8 = r8 | r15
            int r15 = r1 + 2
            byte r15 = r17[r15]
            r15 = r15 & 255(0xff, float:3.57E-43)
            r15 = r7[r15]
            int r15 = r15 << r3
            r8 = r8 | r15
            int r15 = r1 + 3
            byte r15 = r17[r15]
            r15 = r15 & 255(0xff, float:3.57E-43)
            r15 = r7[r15]
            r8 = r8 | r15
            if (r8 < 0) goto L_0x005f
            int r1 = r9 + 2
            byte r15 = (byte) r8
            r6[r1] = r15
            int r1 = r9 + 1
            int r15 = r8 >> 8
            byte r15 = (byte) r15
            r6[r1] = r15
            int r1 = r8 >> 16
            byte r1 = (byte) r1
            r6[r9] = r1
            int r9 = r9 + 3
            r1 = r14
            goto L_0x001e
        L_0x005f:
            if (r1 < r4) goto L_0x0063
            goto L_0x00ec
        L_0x0063:
            int r14 = r1 + 1
            byte r1 = r17[r1]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r1 = r7[r1]
            r15 = 5
            r2 = -1
            if (r5 == 0) goto L_0x00dc
            if (r5 == r13) goto L_0x00d3
            r13 = -2
            if (r5 == r12) goto L_0x00c1
            if (r5 == r10) goto L_0x008e
            if (r5 == r11) goto L_0x0082
            if (r5 == r15) goto L_0x007c
            goto L_0x00e8
        L_0x007c:
            if (r1 == r2) goto L_0x00e8
        L_0x007e:
            r0.state = r3
            r10 = 0
            return r10
        L_0x0082:
            r10 = 0
            if (r1 != r13) goto L_0x0089
            int r5 = r5 + 1
            goto L_0x00e8
        L_0x0089:
            if (r1 == r2) goto L_0x00e8
            r0.state = r3
            return r10
        L_0x008e:
            if (r1 < 0) goto L_0x00a9
            int r2 = r8 << 6
            r1 = r1 | r2
            int r2 = r9 + 2
            byte r5 = (byte) r1
            r6[r2] = r5
            int r2 = r9 + 1
            int r5 = r1 >> 8
            byte r5 = (byte) r5
            r6[r2] = r5
            int r2 = r1 >> 16
            byte r2 = (byte) r2
            r6[r9] = r2
            int r9 = r9 + 3
            r8 = r1
            r5 = 0
            goto L_0x00e8
        L_0x00a9:
            if (r1 != r13) goto L_0x00bb
            int r1 = r9 + 1
            int r2 = r8 >> 2
            byte r2 = (byte) r2
            r6[r1] = r2
            int r1 = r8 >> 10
            byte r1 = (byte) r1
            r6[r9] = r1
            int r9 = r9 + 2
            r5 = 5
            goto L_0x00e8
        L_0x00bb:
            if (r1 == r2) goto L_0x00e8
        L_0x00bd:
            r0.state = r3
            r1 = 0
            return r1
        L_0x00c1:
            if (r1 < 0) goto L_0x00c4
            goto L_0x00d5
        L_0x00c4:
            if (r1 != r13) goto L_0x00d0
            int r1 = r9 + 1
            int r2 = r8 >> 4
            byte r2 = (byte) r2
            r6[r9] = r2
            r9 = r1
            r5 = 4
            goto L_0x00e8
        L_0x00d0:
            if (r1 == r2) goto L_0x00e8
            goto L_0x00bd
        L_0x00d3:
            if (r1 < 0) goto L_0x00d9
        L_0x00d5:
            int r2 = r8 << 6
            r1 = r1 | r2
            goto L_0x00df
        L_0x00d9:
            if (r1 == r2) goto L_0x00e8
            goto L_0x007e
        L_0x00dc:
            r10 = 0
            if (r1 < 0) goto L_0x00e3
        L_0x00df:
            int r5 = r5 + 1
            r8 = r1
            goto L_0x00e8
        L_0x00e3:
            if (r1 == r2) goto L_0x00e8
            r0.state = r3
            return r10
        L_0x00e8:
            r1 = r14
            r2 = 0
            goto L_0x0016
        L_0x00ec:
            if (r20 != 0) goto L_0x00f5
            r0.state = r5
            r0.value = r8
        L_0x00f2:
            r0.f24749op = r9
            return r13
        L_0x00f5:
            if (r5 == 0) goto L_0x0117
            if (r5 == r13) goto L_0x00bd
            if (r5 == r12) goto L_0x010f
            if (r5 == r10) goto L_0x0100
            if (r5 == r11) goto L_0x00bd
            goto L_0x0117
        L_0x0100:
            int r1 = r9 + 1
            int r2 = r8 >> 10
            byte r2 = (byte) r2
            r6[r9] = r2
            int r9 = r1 + 1
            int r2 = r8 >> 2
            byte r2 = (byte) r2
            r6[r1] = r2
            goto L_0x0117
        L_0x010f:
            int r1 = r9 + 1
            int r2 = r8 >> 4
            byte r2 = (byte) r2
            r6[r9] = r2
            r9 = r1
        L_0x0117:
            r0.state = r5
            goto L_0x00f2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.utils.Base64.Decoder.process(byte[], int, int, boolean):boolean");
        }
    }

    /* renamed from: com.tencent.ep.commonbase.utils.Base64$Encoder */
    static class Encoder extends Coder {
        static final /* synthetic */ boolean $assertionsDisabled = (!Base64.class.desiredAssertionStatus());
        private static final byte[] ENCODE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        private static final byte[] ENCODE_WEBSAFE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        public static final int LINE_GROUPS = 19;
        private final byte[] alphabet;
        private int count;
        public final boolean do_cr;
        public final boolean do_newline;
        public final boolean do_padding;
        private final byte[] tail;
        int tailLen;

        public Encoder(int i, byte[] bArr) {
            this.output = bArr;
            boolean z = true;
            this.do_padding = (i & 1) == 0;
            this.do_newline = (i & 2) == 0;
            if ((i & 4) == 0) {
                z = false;
            }
            this.do_cr = z;
            this.alphabet = (i & 8) == 0 ? ENCODE : ENCODE_WEBSAFE;
            this.tail = new byte[2];
            this.tailLen = 0;
            this.count = this.do_newline ? 19 : -1;
        }

        public int maxOutputSize(int i) {
            return ((i * 8) / 5) + 10;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Regions count limit reached
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:89)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:689)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:689)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:689)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:689)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
            	at java.util.ArrayList.forEach(ArrayList.java:1249)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
            	at java.util.ArrayList.forEach(ArrayList.java:1249)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
            	at jadx.core.ProcessClass.process(ProcessClass.java:30)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            */
        /* JADX WARNING: Removed duplicated region for block: B:100:0x00e9 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0097  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x00eb  */
        /* JADX WARNING: Removed duplicated region for block: B:91:0x01de  */
        public boolean process(byte[] r18, int r19, int r20, boolean r21) {
            /*
            r17 = this;
            r0 = r17
            byte[] r1 = r0.alphabet
            byte[] r2 = r0.output
            int r3 = r0.count
            int r4 = r20 + r19
            int r5 = r0.tailLen
            r6 = -1
            r7 = 0
            r8 = 2
            r9 = 1
            if (r5 == 0) goto L_0x0053
            if (r5 == r9) goto L_0x0034
            if (r5 == r8) goto L_0x0017
            goto L_0x0053
        L_0x0017:
            int r5 = r19 + 1
            if (r5 > r4) goto L_0x0053
            byte[] r10 = r0.tail
            byte r11 = r10[r7]
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r11 = r11 << 16
            byte r10 = r10[r9]
            r10 = r10 & 255(0xff, float:3.57E-43)
            int r10 = r10 << 8
            r10 = r10 | r11
            byte r11 = r18[r19]
            r11 = r11 & 255(0xff, float:3.57E-43)
            r10 = r10 | r11
            r0.tailLen = r7
            r11 = r5
            r5 = r10
            goto L_0x0056
        L_0x0034:
            int r5 = r19 + 2
            if (r5 > r4) goto L_0x0053
            byte[] r5 = r0.tail
            byte r5 = r5[r7]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r5 = r5 << 16
            int r10 = r19 + 1
            byte r11 = r18[r19]
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r11 = r11 << 8
            r5 = r5 | r11
            int r11 = r10 + 1
            byte r10 = r18[r10]
            r10 = r10 & 255(0xff, float:3.57E-43)
            r5 = r5 | r10
            r0.tailLen = r7
            goto L_0x0056
        L_0x0053:
            r11 = r19
            r5 = -1
        L_0x0056:
            r12 = 4
            r13 = 13
            r14 = 10
            if (r5 == r6) goto L_0x0092
            int r6 = r5 >> 18
            r6 = r6 & 63
            byte r6 = r1[r6]
            r2[r7] = r6
            int r6 = r5 >> 12
            r6 = r6 & 63
            byte r6 = r1[r6]
            r2[r9] = r6
            int r6 = r5 >> 6
            r6 = r6 & 63
            byte r6 = r1[r6]
            r2[r8] = r6
            r5 = r5 & 63
            byte r5 = r1[r5]
            r6 = 3
            r2[r6] = r5
            int r3 = r3 + -1
            if (r3 != 0) goto L_0x0090
            boolean r3 = r0.do_cr
            if (r3 == 0) goto L_0x0088
            r3 = 5
            r2[r12] = r13
            goto L_0x0089
        L_0x0088:
            r3 = 4
        L_0x0089:
            int r5 = r3 + 1
            r2[r3] = r14
        L_0x008d:
            r3 = 19
            goto L_0x0093
        L_0x0090:
            r5 = 4
            goto L_0x0093
        L_0x0092:
            r5 = 0
        L_0x0093:
            int r6 = r11 + 3
            if (r6 > r4) goto L_0x00e9
            byte r15 = r18[r11]
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r15 = r15 << 16
            int r16 = r11 + 1
            byte r10 = r18[r16]
            r10 = r10 & 255(0xff, float:3.57E-43)
            int r10 = r10 << 8
            r10 = r10 | r15
            int r11 = r11 + 2
            byte r11 = r18[r11]
            r11 = r11 & 255(0xff, float:3.57E-43)
            r10 = r10 | r11
            int r11 = r10 >> 18
            r11 = r11 & 63
            byte r11 = r1[r11]
            r2[r5] = r11
            int r11 = r5 + 1
            int r15 = r10 >> 12
            r15 = r15 & 63
            byte r15 = r1[r15]
            r2[r11] = r15
            int r11 = r5 + 2
            int r15 = r10 >> 6
            r15 = r15 & 63
            byte r15 = r1[r15]
            r2[r11] = r15
            int r11 = r5 + 3
            r10 = r10 & 63
            byte r10 = r1[r10]
            r2[r11] = r10
            int r5 = r5 + 4
            int r3 = r3 + -1
            if (r3 != 0) goto L_0x00e7
            boolean r3 = r0.do_cr
            if (r3 == 0) goto L_0x00e0
            int r3 = r5 + 1
            r2[r5] = r13
            goto L_0x00e1
        L_0x00e0:
            r3 = r5
        L_0x00e1:
            int r5 = r3 + 1
            r2[r3] = r14
            r11 = r6
            goto L_0x008d
        L_0x00e7:
            r11 = r6
            goto L_0x0093
        L_0x00e9:
            if (r21 == 0) goto L_0x01de
            int r6 = r0.tailLen
            int r10 = r11 - r6
            int r15 = r4 + -1
            if (r10 != r15) goto L_0x013d
            if (r6 <= 0) goto L_0x00fb
            byte[] r6 = r0.tail
            byte r6 = r6[r7]
            r7 = 1
            goto L_0x0101
        L_0x00fb:
            int r6 = r11 + 1
            byte r8 = r18[r11]
            r11 = r6
            r6 = r8
        L_0x0101:
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r6 = r6 << r12
            int r8 = r0.tailLen
            int r8 = r8 - r7
            r0.tailLen = r8
            int r7 = r5 + 1
            int r8 = r6 >> 6
            r8 = r8 & 63
            byte r8 = r1[r8]
            r2[r5] = r8
            int r5 = r7 + 1
            r6 = r6 & 63
            byte r1 = r1[r6]
            r2[r7] = r1
            boolean r1 = r0.do_padding
            if (r1 == 0) goto L_0x0129
            int r1 = r5 + 1
            r6 = 61
            r2[r5] = r6
            int r5 = r1 + 1
            r2[r1] = r6
        L_0x0129:
            boolean r1 = r0.do_newline
            if (r1 == 0) goto L_0x01c2
            boolean r1 = r0.do_cr
            if (r1 == 0) goto L_0x0136
            int r1 = r5 + 1
            r2[r5] = r13
            goto L_0x0137
        L_0x0136:
            r1 = r5
        L_0x0137:
            int r5 = r1 + 1
            r2[r1] = r14
            goto L_0x01c2
        L_0x013d:
            int r12 = r4 + -2
            if (r10 != r12) goto L_0x01aa
            if (r6 <= r9) goto L_0x0149
            byte[] r6 = r0.tail
            byte r6 = r6[r7]
            r7 = 1
            goto L_0x014f
        L_0x0149:
            int r6 = r11 + 1
            byte r10 = r18[r11]
            r11 = r6
            r6 = r10
        L_0x014f:
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r6 = r6 << r14
            int r10 = r0.tailLen
            if (r10 <= 0) goto L_0x015f
            byte[] r10 = r0.tail
            int r12 = r7 + 1
            byte r7 = r10[r7]
            r10 = r11
            r11 = r7
            goto L_0x0164
        L_0x015f:
            int r10 = r11 + 1
            byte r11 = r18[r11]
            r12 = r7
        L_0x0164:
            r7 = r11 & 255(0xff, float:3.57E-43)
            int r7 = r7 << r8
            r6 = r6 | r7
            int r7 = r0.tailLen
            int r7 = r7 - r12
            r0.tailLen = r7
            int r7 = r5 + 1
            int r8 = r6 >> 12
            r8 = r8 & 63
            byte r8 = r1[r8]
            r2[r5] = r8
            int r5 = r7 + 1
            int r8 = r6 >> 6
            r8 = r8 & 63
            byte r8 = r1[r8]
            r2[r7] = r8
            int r7 = r5 + 1
            r6 = r6 & 63
            byte r1 = r1[r6]
            r2[r5] = r1
            boolean r1 = r0.do_padding
            if (r1 == 0) goto L_0x0194
            int r1 = r7 + 1
            r5 = 61
            r2[r7] = r5
            goto L_0x0195
        L_0x0194:
            r1 = r7
        L_0x0195:
            boolean r5 = r0.do_newline
            if (r5 == 0) goto L_0x01a7
            boolean r5 = r0.do_cr
            if (r5 == 0) goto L_0x01a2
            int r5 = r1 + 1
            r2[r1] = r13
            r1 = r5
        L_0x01a2:
            int r5 = r1 + 1
            r2[r1] = r14
            goto L_0x01a8
        L_0x01a7:
            r5 = r1
        L_0x01a8:
            r11 = r10
            goto L_0x01c2
        L_0x01aa:
            boolean r1 = r0.do_newline
            if (r1 == 0) goto L_0x01c2
            if (r5 <= 0) goto L_0x01c2
            r1 = 19
            if (r3 == r1) goto L_0x01c2
            boolean r1 = r0.do_cr
            if (r1 == 0) goto L_0x01bd
            int r1 = r5 + 1
            r2[r5] = r13
            goto L_0x01be
        L_0x01bd:
            r1 = r5
        L_0x01be:
            int r5 = r1 + 1
            r2[r1] = r14
        L_0x01c2:
            boolean r1 = $assertionsDisabled
            if (r1 != 0) goto L_0x01d1
            int r1 = r0.tailLen
            if (r1 != 0) goto L_0x01cb
            goto L_0x01d1
        L_0x01cb:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>()
            throw r1
        L_0x01d1:
            boolean r1 = $assertionsDisabled
            if (r1 != 0) goto L_0x0209
            if (r11 != r4) goto L_0x01d8
            goto L_0x0209
        L_0x01d8:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>()
            throw r1
        L_0x01de:
            int r1 = r4 + -1
            if (r11 != r1) goto L_0x01ef
            byte[] r1 = r0.tail
            int r2 = r0.tailLen
            int r4 = r2 + 1
            r0.tailLen = r4
            byte r4 = r18[r11]
            r1[r2] = r4
            goto L_0x0209
        L_0x01ef:
            int r4 = r4 - r8
            if (r11 != r4) goto L_0x0209
            byte[] r1 = r0.tail
            int r2 = r0.tailLen
            int r4 = r2 + 1
            r0.tailLen = r4
            byte r4 = r18[r11]
            r1[r2] = r4
            int r2 = r0.tailLen
            int r4 = r2 + 1
            r0.tailLen = r4
            int r11 = r11 + r9
            byte r4 = r18[r11]
            r1[r2] = r4
        L_0x0209:
            r0.f24749op = r5
            r0.count = r3
            return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.utils.Base64.Encoder.process(byte[], int, int, boolean):boolean");
        }
    }

    private Base64() {
    }

    public static byte[] decode(String str, int i) {
        return decode(str.getBytes(), i);
    }

    public static byte[] decode(byte[] bArr, int i) {
        return decode(bArr, 0, bArr.length, i);
    }

    public static byte[] decode(byte[] bArr, int i, int i2, int i3) {
        Decoder decoder = new Decoder(i3, new byte[((i2 * 3) / 4)]);
        if (decoder.process(bArr, i, i2, true)) {
            int i4 = decoder.f24749op;
            byte[] bArr2 = decoder.output;
            if (i4 == bArr2.length) {
                return bArr2;
            }
            byte[] bArr3 = new byte[i4];
            System.arraycopy(bArr2, 0, bArr3, 0, i4);
            return bArr3;
        }
        throw new IllegalArgumentException("bad base-64");
    }

    public static byte[] encode(byte[] bArr, int i) {
        return encode(bArr, 0, bArr.length, i);
    }

    public static byte[] encode(byte[] bArr, int i, int i2, int i3) {
        Encoder encoder = new Encoder(i3, null);
        int i4 = (i2 / 3) * 4;
        int i5 = 2;
        if (!encoder.do_padding) {
            int i6 = i2 % 3;
            if (i6 != 0) {
                if (i6 == 1) {
                    i4 += 2;
                } else if (i6 == 2) {
                    i4 += 3;
                }
            }
        } else if (i2 % 3 > 0) {
            i4 += 4;
        }
        if (encoder.do_newline && i2 > 0) {
            int i7 = ((i2 - 1) / 57) + 1;
            if (!encoder.do_cr) {
                i5 = 1;
            }
            i4 += i7 * i5;
        }
        encoder.output = new byte[i4];
        encoder.process(bArr, i, i2, true);
        if ($assertionsDisabled || encoder.f24749op == i4) {
            return encoder.output;
        }
        throw new AssertionError();
    }

    public static String encodeToString(byte[] bArr, int i) {
        try {
            return new String(encode(bArr, i), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public static String encodeToString(byte[] bArr, int i, int i2, int i3) {
        try {
            return new String(encode(bArr, i, i2, i3), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
