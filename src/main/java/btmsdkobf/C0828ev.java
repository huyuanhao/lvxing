package btmsdkobf;

import java.io.UnsupportedEncodingException;

/* renamed from: btmsdkobf.ev */
public class C0828ev {
    /* renamed from: az */
    static final /* synthetic */ boolean f945az = (!C0828ev.class.desiredAssertionStatus());

    /* renamed from: btmsdkobf.ev$a */
    static abstract class C0829a {
        /* renamed from: nE */
        public byte[] f946nE;
        /* renamed from: nF */
        public int f947nF;

        C0829a() {
        }
    }

    /* renamed from: btmsdkobf.ev$b */
    static class C0830b extends C0829a {
        /* renamed from: nG */
        private static final int[] f948nG = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        /* renamed from: nH */
        private static final int[] f949nH = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        /* renamed from: nI */
        private final int[] f950nI;
        private int state;
        private int value;

        public C0830b(int i, byte[] bArr) {
            this.f946nE = bArr;
            this.f950nI = (i & 8) == 0 ? f948nG : f949nH;
            this.state = 0;
            this.value = 0;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00bd, code lost:
            r0.state = 6;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c0, code lost:
            return false;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ef, code lost:
            if (r20 != false) goto L_0x00f8;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x00f1, code lost:
            r0.state = r5;
            r0.value = r8;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x00f5, code lost:
            r0.f947nF = r9;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x00f7, code lost:
            return true;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x00f8, code lost:
            if (r5 == 0) goto L_0x011a;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x00fa, code lost:
            if (r5 == 1) goto L_0x00bd;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x00fc, code lost:
            if (r5 == 2) goto L_0x0112;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x00fe, code lost:
            if (r5 == 3) goto L_0x0103;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x0100, code lost:
            if (r5 == 4) goto L_0x00bd;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x0103, code lost:
            r1 = r9 + 1;
            r6[r9] = (byte) (r8 >> 10);
            r9 = r1 + 1;
            r6[r1] = (byte) (r8 >> 2);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x0112, code lost:
            r1 = r9 + 1;
            r6[r9] = (byte) (r8 >> 4);
            r9 = r1;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x011a, code lost:
            r0.state = r5;
     */
        /* renamed from: a */
        public boolean mo9532a(byte[] r17, int r18, int r19, boolean r20) {
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
            byte[] r6 = r0.f946nE
            int[] r7 = r0.f950nI
            r8 = r5
            r9 = 0
            r5 = r1
            r1 = r18
        L_0x0016:
            r10 = 3
            r11 = 4
            r12 = 2
            r13 = 1
            if (r1 >= r4) goto L_0x00ef
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
            goto L_0x00ef
        L_0x0063:
            int r14 = r1 + 1
            byte r1 = r17[r1]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r1 = r7[r1]
            r15 = 5
            r2 = -1
            if (r5 == 0) goto L_0x00df
            if (r5 == r13) goto L_0x00d3
            r13 = -2
            if (r5 == r12) goto L_0x00c1
            if (r5 == r10) goto L_0x008e
            if (r5 == r11) goto L_0x0082
            if (r5 == r15) goto L_0x007c
            goto L_0x00eb
        L_0x007c:
            if (r1 == r2) goto L_0x00eb
        L_0x007e:
            r0.state = r3
            r10 = 0
            return r10
        L_0x0082:
            r10 = 0
            if (r1 != r13) goto L_0x0089
            int r5 = r5 + 1
            goto L_0x00eb
        L_0x0089:
            if (r1 == r2) goto L_0x00eb
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
            goto L_0x00eb
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
            goto L_0x00eb
        L_0x00bb:
            if (r1 == r2) goto L_0x00eb
        L_0x00bd:
            r0.state = r3
            r1 = 0
            return r1
        L_0x00c1:
            if (r1 < 0) goto L_0x00c4
            goto L_0x00d6
        L_0x00c4:
            if (r1 != r13) goto L_0x00d0
            int r1 = r9 + 1
            int r2 = r8 >> 4
            byte r2 = (byte) r2
            r6[r9] = r2
            r9 = r1
            r5 = 4
            goto L_0x00eb
        L_0x00d0:
            if (r1 == r2) goto L_0x00eb
            goto L_0x007e
        L_0x00d3:
            r10 = 0
            if (r1 < 0) goto L_0x00da
        L_0x00d6:
            int r2 = r8 << 6
            r1 = r1 | r2
            goto L_0x00e2
        L_0x00da:
            if (r1 == r2) goto L_0x00eb
            r0.state = r3
            return r10
        L_0x00df:
            r10 = 0
            if (r1 < 0) goto L_0x00e6
        L_0x00e2:
            int r5 = r5 + 1
            r8 = r1
            goto L_0x00eb
        L_0x00e6:
            if (r1 == r2) goto L_0x00eb
            r0.state = r3
            return r10
        L_0x00eb:
            r1 = r14
            r2 = 0
            goto L_0x0016
        L_0x00ef:
            if (r20 != 0) goto L_0x00f8
            r0.state = r5
            r0.value = r8
        L_0x00f5:
            r0.f947nF = r9
            return r13
        L_0x00f8:
            if (r5 == 0) goto L_0x011a
            if (r5 == r13) goto L_0x00bd
            if (r5 == r12) goto L_0x0112
            if (r5 == r10) goto L_0x0103
            if (r5 == r11) goto L_0x00bd
            goto L_0x011a
        L_0x0103:
            int r1 = r9 + 1
            int r2 = r8 >> 10
            byte r2 = (byte) r2
            r6[r9] = r2
            int r9 = r1 + 1
            int r2 = r8 >> 2
            byte r2 = (byte) r2
            r6[r1] = r2
            goto L_0x011a
        L_0x0112:
            int r1 = r9 + 1
            int r2 = r8 >> 4
            byte r2 = (byte) r2
            r6[r9] = r2
            r9 = r1
        L_0x011a:
            r0.state = r5
            goto L_0x00f5
            */
            throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0828ev.C0830b.mo9532a(byte[], int, int, boolean):boolean");
        }
    }

    /* renamed from: btmsdkobf.ev$c */
    static class C0831c extends C0829a {
        /* renamed from: az */
        static final /* synthetic */ boolean f951az = (!C0828ev.class.desiredAssertionStatus());
        /* renamed from: nJ */
        private static final byte[] f952nJ = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        /* renamed from: nK */
        private static final byte[] f953nK = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        private int count;
        /* renamed from: nL */
        private final byte[] f954nL;
        /* renamed from: nM */
        int f955nM;
        /* renamed from: nN */
        public final boolean f956nN;
        /* renamed from: nO */
        public final boolean f957nO;
        /* renamed from: nP */
        public final boolean f958nP;
        /* renamed from: nQ */
        private final byte[] f959nQ;

        public C0831c(int i, byte[] bArr) {
            this.f946nE = bArr;
            boolean z = true;
            this.f956nN = (i & 1) == 0;
            this.f957nO = (i & 2) == 0;
            if ((i & 4) == 0) {
                z = false;
            }
            this.f958nP = z;
            this.f959nQ = (i & 8) == 0 ? f952nJ : f953nK;
            this.f954nL = new byte[2];
            this.f955nM = 0;
            this.count = this.f957nO ? 19 : -1;
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
            	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
            	at java.util.ArrayList.forEach(ArrayList.java:1249)
            	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
            	at jadx.core.ProcessClass.process(ProcessClass.java:35)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0097  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x00eb  */
        /* JADX WARNING: Removed duplicated region for block: B:90:0x01e0  */
        /* JADX WARNING: Removed duplicated region for block: B:99:0x00e9 A[SYNTHETIC] */
        /* renamed from: a */
        public boolean mo9533a(byte[] r18, int r19, int r20, boolean r21) {
            /*
            r17 = this;
            r0 = r17
            byte[] r1 = r0.f959nQ
            byte[] r2 = r0.f946nE
            int r3 = r0.count
            int r4 = r20 + r19
            int r5 = r0.f955nM
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
            byte[] r10 = r0.f954nL
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
            r0.f955nM = r7
            r11 = r5
            r5 = r10
            goto L_0x0056
        L_0x0034:
            int r5 = r19 + 2
            if (r5 > r4) goto L_0x0053
            byte[] r5 = r0.f954nL
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
            r0.f955nM = r7
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
            boolean r3 = r0.f958nP
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
            boolean r3 = r0.f958nP
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
            if (r21 == 0) goto L_0x01e0
            int r6 = r0.f955nM
            int r10 = r11 - r6
            int r15 = r4 + -1
            if (r10 != r15) goto L_0x013d
            if (r6 <= 0) goto L_0x00fb
            byte[] r6 = r0.f954nL
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
            int r8 = r0.f955nM
            int r8 = r8 - r7
            r0.f955nM = r8
            int r7 = r5 + 1
            int r8 = r6 >> 6
            r8 = r8 & 63
            byte r8 = r1[r8]
            r2[r5] = r8
            int r5 = r7 + 1
            r6 = r6 & 63
            byte r1 = r1[r6]
            r2[r7] = r1
            boolean r1 = r0.f956nN
            if (r1 == 0) goto L_0x0129
            int r1 = r5 + 1
            r6 = 61
            r2[r5] = r6
            int r5 = r1 + 1
            r2[r1] = r6
        L_0x0129:
            boolean r1 = r0.f957nO
            if (r1 == 0) goto L_0x01c4
            boolean r1 = r0.f958nP
            if (r1 == 0) goto L_0x0136
            int r1 = r5 + 1
            r2[r5] = r13
            goto L_0x0137
        L_0x0136:
            r1 = r5
        L_0x0137:
            int r5 = r1 + 1
            r2[r1] = r14
            goto L_0x01c4
        L_0x013d:
            int r10 = r11 - r6
            int r12 = r4 + -2
            if (r10 != r12) goto L_0x01ac
            if (r6 <= r9) goto L_0x014b
            byte[] r6 = r0.f954nL
            byte r6 = r6[r7]
            r7 = 1
            goto L_0x0151
        L_0x014b:
            int r6 = r11 + 1
            byte r10 = r18[r11]
            r11 = r6
            r6 = r10
        L_0x0151:
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r6 = r6 << r14
            int r10 = r0.f955nM
            if (r10 <= 0) goto L_0x0161
            byte[] r10 = r0.f954nL
            int r12 = r7 + 1
            byte r7 = r10[r7]
            r10 = r11
            r11 = r7
            goto L_0x0166
        L_0x0161:
            int r10 = r11 + 1
            byte r11 = r18[r11]
            r12 = r7
        L_0x0166:
            r7 = r11 & 255(0xff, float:3.57E-43)
            int r7 = r7 << r8
            r6 = r6 | r7
            int r7 = r0.f955nM
            int r7 = r7 - r12
            r0.f955nM = r7
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
            boolean r1 = r0.f956nN
            if (r1 == 0) goto L_0x0196
            int r1 = r7 + 1
            r5 = 61
            r2[r7] = r5
            goto L_0x0197
        L_0x0196:
            r1 = r7
        L_0x0197:
            boolean r5 = r0.f957nO
            if (r5 == 0) goto L_0x01a9
            boolean r5 = r0.f958nP
            if (r5 == 0) goto L_0x01a4
            int r5 = r1 + 1
            r2[r1] = r13
            r1 = r5
        L_0x01a4:
            int r5 = r1 + 1
            r2[r1] = r14
            r1 = r5
        L_0x01a9:
            r5 = r1
            r11 = r10
            goto L_0x01c4
        L_0x01ac:
            boolean r1 = r0.f957nO
            if (r1 == 0) goto L_0x01c4
            if (r5 <= 0) goto L_0x01c4
            r1 = 19
            if (r3 == r1) goto L_0x01c4
            boolean r1 = r0.f958nP
            if (r1 == 0) goto L_0x01bf
            int r1 = r5 + 1
            r2[r5] = r13
            goto L_0x01c0
        L_0x01bf:
            r1 = r5
        L_0x01c0:
            int r5 = r1 + 1
            r2[r1] = r14
        L_0x01c4:
            boolean r1 = f951az
            if (r1 != 0) goto L_0x01d3
            int r1 = r0.f955nM
            if (r1 != 0) goto L_0x01cd
            goto L_0x01d3
        L_0x01cd:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>()
            throw r1
        L_0x01d3:
            boolean r1 = f951az
            if (r1 != 0) goto L_0x020b
            if (r11 != r4) goto L_0x01da
            goto L_0x020b
        L_0x01da:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>()
            throw r1
        L_0x01e0:
            int r1 = r4 + -1
            if (r11 != r1) goto L_0x01f1
            byte[] r1 = r0.f954nL
            int r2 = r0.f955nM
            int r4 = r2 + 1
            r0.f955nM = r4
            byte r4 = r18[r11]
            r1[r2] = r4
            goto L_0x020b
        L_0x01f1:
            int r4 = r4 - r8
            if (r11 != r4) goto L_0x020b
            byte[] r1 = r0.f954nL
            int r2 = r0.f955nM
            int r4 = r2 + 1
            r0.f955nM = r4
            byte r4 = r18[r11]
            r1[r2] = r4
            int r2 = r0.f955nM
            int r4 = r2 + 1
            r0.f955nM = r4
            int r11 = r11 + r9
            byte r4 = r18[r11]
            r1[r2] = r4
        L_0x020b:
            r0.f947nF = r5
            r0.count = r3
            return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0828ev.C0831c.mo9533a(byte[], int, int, boolean):boolean");
        }
    }

    private C0828ev() {
    }

    public static byte[] decode(String str, int i) {
        return decode(str.getBytes(), i);
    }

    public static byte[] decode(byte[] bArr, int i) {
        return decode(bArr, 0, bArr.length, i);
    }

    public static byte[] decode(byte[] bArr, int i, int i2, int i3) {
        C0830b bVar = new C0830b(i3, new byte[((i2 * 3) / 4)]);
        if (!bVar.mo9532a(bArr, i, i2, true)) {
            throw new IllegalArgumentException("bad base-64");
        } else if (bVar.f947nF == bVar.f946nE.length) {
            return bVar.f946nE;
        } else {
            byte[] bArr2 = new byte[bVar.f947nF];
            System.arraycopy(bVar.f946nE, 0, bArr2, 0, bVar.f947nF);
            return bArr2;
        }
    }

    public static byte[] encode(byte[] bArr, int i) {
        return encode(bArr, 0, bArr.length, i);
    }

    public static byte[] encode(byte[] bArr, int i, int i2, int i3) {
        C0831c cVar = new C0831c(i3, null);
        int i4 = (i2 / 3) * 4;
        int i5 = 2;
        if (!cVar.f956nN) {
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
        if (cVar.f957nO && i2 > 0) {
            int i7 = ((i2 - 1) / 57) + 1;
            if (!cVar.f958nP) {
                i5 = 1;
            }
            i4 += i7 * i5;
        }
        cVar.f946nE = new byte[i4];
        cVar.mo9533a(bArr, i, i2, true);
        if (f945az || cVar.f947nF == i4) {
            return cVar.f946nE;
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
}
