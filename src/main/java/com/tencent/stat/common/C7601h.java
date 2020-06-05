package com.tencent.stat.common;

/* renamed from: com.tencent.stat.common.h */
public class C7601h {

    /* renamed from: com.tencent.stat.common.h$a */
    static abstract class C7602a {
        /* renamed from: a */
        public byte[] f25682a;
        /* renamed from: b */
        public int f25683b;

        C7602a() {
        }
    }

    /* renamed from: com.tencent.stat.common.h$b */
    static class C7603b extends C7602a {
        /* renamed from: c */
        private static final int[] f25684c = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        /* renamed from: d */
        private static final int[] f25685d = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        /* renamed from: e */
        private int f25686e;
        /* renamed from: f */
        private int f25687f;
        /* renamed from: g */
        private final int[] f25688g;

        public C7603b(int i, byte[] bArr) {
            this.f25682a = bArr;
            this.f25688g = (i & 8) == 0 ? f25684c : f25685d;
            this.f25686e = 0;
            this.f25687f = 0;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c0, code lost:
            return false;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x00f1, code lost:
            if (r20 != false) goto L_0x00fa;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x00f3, code lost:
            r0.f25686e = r5;
            r0.f25687f = r8;
            r0.f25683b = r9;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x00f9, code lost:
            return true;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x00fa, code lost:
            if (r5 == 0) goto L_0x0123;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x00fc, code lost:
            if (r5 == 1) goto L_0x0120;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x00fe, code lost:
            if (r5 == 2) goto L_0x0117;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x0100, code lost:
            if (r5 == 3) goto L_0x0108;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x0102, code lost:
            if (r5 == 4) goto L_0x0105;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x0105, code lost:
            r0.f25686e = 6;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x0108, code lost:
            r1 = r9 + 1;
            r6[r9] = (byte) (r8 >> 10);
            r9 = r1 + 1;
            r6[r1] = (byte) (r8 >> 2);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x0117, code lost:
            r1 = r9 + 1;
            r6[r9] = (byte) (r8 >> 4);
            r9 = r1;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x0120, code lost:
            r0.f25686e = 6;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x0123, code lost:
            r0.f25686e = r5;
            r0.f25683b = r9;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x0127, code lost:
            return true;
     */
        /* renamed from: a */
        public boolean mo37122a(byte[] r17, int r18, int r19, boolean r20) {
            /*
            r16 = this;
            r0 = r16
            int r1 = r0.f25686e
            r2 = 0
            r3 = 6
            if (r1 != r3) goto L_0x0009
            return r2
        L_0x0009:
            int r4 = r19 + r18
            int r5 = r0.f25687f
            byte[] r6 = r0.f25682a
            int[] r7 = r0.f25688g
            r8 = r5
            r9 = 0
            r5 = r1
            r1 = r18
        L_0x0016:
            r10 = 3
            r11 = 4
            r12 = 2
            r13 = 1
            if (r1 >= r4) goto L_0x00f1
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
            goto L_0x00f1
        L_0x0063:
            int r14 = r1 + 1
            byte r1 = r17[r1]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r1 = r7[r1]
            r15 = 5
            r2 = -1
            if (r5 == 0) goto L_0x00e1
            if (r5 == r13) goto L_0x00d5
            r13 = -2
            if (r5 == r12) goto L_0x00c1
            if (r5 == r10) goto L_0x008e
            if (r5 == r11) goto L_0x0082
            if (r5 == r15) goto L_0x007c
            goto L_0x00ed
        L_0x007c:
            if (r1 == r2) goto L_0x00ed
            r0.f25686e = r3
        L_0x0080:
            r10 = 0
            return r10
        L_0x0082:
            r10 = 0
            if (r1 != r13) goto L_0x0089
            int r5 = r5 + 1
            goto L_0x00ed
        L_0x0089:
            if (r1 == r2) goto L_0x00ed
            r0.f25686e = r3
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
            goto L_0x00ed
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
            goto L_0x00ed
        L_0x00bb:
            if (r1 == r2) goto L_0x00ed
            r0.f25686e = r3
        L_0x00bf:
            r1 = 0
            return r1
        L_0x00c1:
            if (r1 < 0) goto L_0x00c4
            goto L_0x00d8
        L_0x00c4:
            if (r1 != r13) goto L_0x00d0
            int r1 = r9 + 1
            int r2 = r8 >> 4
            byte r2 = (byte) r2
            r6[r9] = r2
            r9 = r1
            r5 = 4
            goto L_0x00ed
        L_0x00d0:
            if (r1 == r2) goto L_0x00ed
            r0.f25686e = r3
            goto L_0x0080
        L_0x00d5:
            r10 = 0
            if (r1 < 0) goto L_0x00dc
        L_0x00d8:
            int r2 = r8 << 6
            r1 = r1 | r2
            goto L_0x00e4
        L_0x00dc:
            if (r1 == r2) goto L_0x00ed
            r0.f25686e = r3
            return r10
        L_0x00e1:
            r10 = 0
            if (r1 < 0) goto L_0x00e8
        L_0x00e4:
            int r5 = r5 + 1
            r8 = r1
            goto L_0x00ed
        L_0x00e8:
            if (r1 == r2) goto L_0x00ed
            r0.f25686e = r3
            return r10
        L_0x00ed:
            r1 = r14
            r2 = 0
            goto L_0x0016
        L_0x00f1:
            if (r20 != 0) goto L_0x00fa
            r0.f25686e = r5
            r0.f25687f = r8
            r0.f25683b = r9
            return r13
        L_0x00fa:
            if (r5 == 0) goto L_0x0123
            if (r5 == r13) goto L_0x0120
            if (r5 == r12) goto L_0x0117
            if (r5 == r10) goto L_0x0108
            if (r5 == r11) goto L_0x0105
            goto L_0x0123
        L_0x0105:
            r0.f25686e = r3
            goto L_0x00bf
        L_0x0108:
            int r1 = r9 + 1
            int r2 = r8 >> 10
            byte r2 = (byte) r2
            r6[r9] = r2
            int r9 = r1 + 1
            int r2 = r8 >> 2
            byte r2 = (byte) r2
            r6[r1] = r2
            goto L_0x0123
        L_0x0117:
            int r1 = r9 + 1
            int r2 = r8 >> 4
            byte r2 = (byte) r2
            r6[r9] = r2
            r9 = r1
            goto L_0x0123
        L_0x0120:
            r0.f25686e = r3
            goto L_0x00bf
        L_0x0123:
            r0.f25686e = r5
            r0.f25683b = r9
            return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.common.C7601h.C7603b.mo37122a(byte[], int, int, boolean):boolean");
        }
    }

    /* renamed from: com.tencent.stat.common.h$c */
    static class C7604c extends C7602a {
        /* renamed from: g */
        private static final byte[] f25689g = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        /* renamed from: h */
        private static final byte[] f25690h = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        /* renamed from: c */
        int f25691c;
        /* renamed from: d */
        public final boolean f25692d;
        /* renamed from: e */
        public final boolean f25693e;
        /* renamed from: f */
        public final boolean f25694f;
        /* renamed from: i */
        private final byte[] f25695i;
        /* renamed from: j */
        private int f25696j;
        /* renamed from: k */
        private final byte[] f25697k;

        public C7604c(int i, byte[] bArr) {
            this.f25682a = bArr;
            boolean z = true;
            this.f25692d = (i & 1) == 0;
            this.f25693e = (i & 2) == 0;
            if ((i & 4) == 0) {
                z = false;
            }
            this.f25694f = z;
            this.f25697k = (i & 8) == 0 ? f25689g : f25690h;
            this.f25695i = new byte[2];
            this.f25691c = 0;
            this.f25696j = this.f25693e ? 19 : -1;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Regions count limit reached
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:89)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
            	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
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
            	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
            	at java.util.ArrayList.forEach(ArrayList.java:1249)
            	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
            	at jadx.core.ProcessClass.process(ProcessClass.java:35)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0097  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x00eb  */
        /* JADX WARNING: Removed duplicated region for block: B:80:0x01bc  */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x00e9 A[SYNTHETIC] */
        /* renamed from: a */
        public boolean mo37123a(byte[] r18, int r19, int r20, boolean r21) {
            /*
            r17 = this;
            r0 = r17
            byte[] r1 = r0.f25697k
            byte[] r2 = r0.f25682a
            int r3 = r0.f25696j
            int r4 = r20 + r19
            int r5 = r0.f25691c
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
            byte[] r10 = r0.f25695i
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
            r0.f25691c = r7
            r11 = r5
            r5 = r10
            goto L_0x0056
        L_0x0034:
            int r5 = r19 + 2
            if (r5 > r4) goto L_0x0053
            byte[] r5 = r0.f25695i
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
            r0.f25691c = r7
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
            boolean r3 = r0.f25694f
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
            boolean r3 = r0.f25694f
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
            if (r21 == 0) goto L_0x01bc
            int r6 = r0.f25691c
            int r10 = r11 - r6
            int r15 = r4 + -1
            if (r10 != r15) goto L_0x013a
            if (r6 <= 0) goto L_0x00fb
            byte[] r4 = r0.f25695i
            byte r4 = r4[r7]
            r7 = 1
            goto L_0x00fd
        L_0x00fb:
            byte r4 = r18[r11]
        L_0x00fd:
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r4 = r4 << r12
            int r6 = r0.f25691c
            int r6 = r6 - r7
            r0.f25691c = r6
            int r6 = r5 + 1
            int r7 = r4 >> 6
            r7 = r7 & 63
            byte r7 = r1[r7]
            r2[r5] = r7
            int r5 = r6 + 1
            r4 = r4 & 63
            byte r1 = r1[r4]
            r2[r6] = r1
            boolean r1 = r0.f25692d
            if (r1 == 0) goto L_0x0125
            int r1 = r5 + 1
            r4 = 61
            r2[r5] = r4
            int r5 = r1 + 1
            r2[r1] = r4
        L_0x0125:
            boolean r1 = r0.f25693e
            if (r1 == 0) goto L_0x01e7
            boolean r1 = r0.f25694f
            if (r1 == 0) goto L_0x0132
            int r1 = r5 + 1
            r2[r5] = r13
            goto L_0x0133
        L_0x0132:
            r1 = r5
        L_0x0133:
            int r4 = r1 + 1
            r2[r1] = r14
        L_0x0137:
            r5 = r4
            goto L_0x01e7
        L_0x013a:
            int r10 = r11 - r6
            int r4 = r4 - r8
            if (r10 != r4) goto L_0x01a3
            if (r6 <= r9) goto L_0x0147
            byte[] r4 = r0.f25695i
            byte r4 = r4[r7]
            r7 = 1
            goto L_0x014d
        L_0x0147:
            int r4 = r11 + 1
            byte r6 = r18[r11]
            r11 = r4
            r4 = r6
        L_0x014d:
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r4 = r4 << r14
            int r6 = r0.f25691c
            if (r6 <= 0) goto L_0x015c
            byte[] r6 = r0.f25695i
            int r10 = r7 + 1
            byte r6 = r6[r7]
            r7 = r10
            goto L_0x015e
        L_0x015c:
            byte r6 = r18[r11]
        L_0x015e:
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r6 = r6 << r8
            r4 = r4 | r6
            int r6 = r0.f25691c
            int r6 = r6 - r7
            r0.f25691c = r6
            int r6 = r5 + 1
            int r7 = r4 >> 12
            r7 = r7 & 63
            byte r7 = r1[r7]
            r2[r5] = r7
            int r5 = r6 + 1
            int r7 = r4 >> 6
            r7 = r7 & 63
            byte r7 = r1[r7]
            r2[r6] = r7
            int r6 = r5 + 1
            r4 = r4 & 63
            byte r1 = r1[r4]
            r2[r5] = r1
            boolean r1 = r0.f25692d
            if (r1 == 0) goto L_0x018e
            int r1 = r6 + 1
            r4 = 61
            r2[r6] = r4
            goto L_0x018f
        L_0x018e:
            r1 = r6
        L_0x018f:
            boolean r4 = r0.f25693e
            if (r4 == 0) goto L_0x01a1
            boolean r4 = r0.f25694f
            if (r4 == 0) goto L_0x019c
            int r4 = r1 + 1
            r2[r1] = r13
            r1 = r4
        L_0x019c:
            int r4 = r1 + 1
            r2[r1] = r14
            goto L_0x0137
        L_0x01a1:
            r5 = r1
            goto L_0x01e7
        L_0x01a3:
            boolean r1 = r0.f25693e
            if (r1 == 0) goto L_0x01e7
            if (r5 <= 0) goto L_0x01e7
            r1 = 19
            if (r3 == r1) goto L_0x01e7
            boolean r1 = r0.f25694f
            if (r1 == 0) goto L_0x01b6
            int r1 = r5 + 1
            r2[r5] = r13
            goto L_0x01b7
        L_0x01b6:
            r1 = r5
        L_0x01b7:
            int r5 = r1 + 1
            r2[r1] = r14
            goto L_0x01e7
        L_0x01bc:
            int r1 = r4 + -1
            if (r11 != r1) goto L_0x01cd
            byte[] r1 = r0.f25695i
            int r2 = r0.f25691c
            int r4 = r2 + 1
            r0.f25691c = r4
            byte r4 = r18[r11]
            r1[r2] = r4
            goto L_0x01e7
        L_0x01cd:
            int r4 = r4 - r8
            if (r11 != r4) goto L_0x01e7
            byte[] r1 = r0.f25695i
            int r2 = r0.f25691c
            int r4 = r2 + 1
            r0.f25691c = r4
            byte r4 = r18[r11]
            r1[r2] = r4
            int r2 = r0.f25691c
            int r4 = r2 + 1
            r0.f25691c = r4
            int r11 = r11 + r9
            byte r4 = r18[r11]
            r1[r2] = r4
        L_0x01e7:
            r0.f25683b = r5
            r0.f25696j = r3
            return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.common.C7601h.C7604c.mo37123a(byte[], int, int, boolean):boolean");
        }
    }

    /* renamed from: a */
    public static byte[] m32774a(byte[] bArr, int i) {
        return m32775a(bArr, 0, bArr.length, i);
    }

    /* renamed from: a */
    public static byte[] m32775a(byte[] bArr, int i, int i2, int i3) {
        C7603b bVar = new C7603b(i3, new byte[((i2 * 3) / 4)]);
        if (!bVar.mo37122a(bArr, i, i2, true)) {
            try {
                throw new IllegalArgumentException("bad base-64");
            } catch (Exception unused) {
            }
        }
        if (bVar.f25683b == bVar.f25682a.length) {
            return bVar.f25682a;
        }
        byte[] bArr2 = new byte[bVar.f25683b];
        System.arraycopy(bVar.f25682a, 0, bArr2, 0, bVar.f25683b);
        return bArr2;
    }

    /* renamed from: b */
    public static byte[] m32776b(byte[] bArr, int i) {
        return m32777b(bArr, 0, bArr.length, i);
    }

    /* renamed from: b */
    public static byte[] m32777b(byte[] bArr, int i, int i2, int i3) {
        C7604c cVar = new C7604c(i3, null);
        int i4 = (i2 / 3) * 4;
        int i5 = 2;
        if (!cVar.f25692d) {
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
        if (cVar.f25693e && i2 > 0) {
            int i7 = ((i2 - 1) / 57) + 1;
            if (!cVar.f25694f) {
                i5 = 1;
            }
            i4 += i7 * i5;
        }
        cVar.f25682a = new byte[i4];
        cVar.mo37123a(bArr, i, i2, true);
        return cVar.f25682a;
    }
}
