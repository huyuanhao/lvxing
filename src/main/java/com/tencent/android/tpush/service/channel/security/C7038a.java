package com.tencent.android.tpush.service.channel.security;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.service.channel.security.a */
public class C7038a {
    /* renamed from: a */
    static final /* synthetic */ boolean f23405a = (!C7038a.class.desiredAssertionStatus());

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.service.channel.security.a$a */
    static abstract class C7039a {
        /* renamed from: a */
        public byte[] f23406a;
        /* renamed from: b */
        public int f23407b;

        C7039a() {
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.service.channel.security.a$b */
    static class C7040b extends C7039a {
        /* renamed from: c */
        private static final int[] f23408c = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        /* renamed from: d */
        private static final int[] f23409d = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        /* renamed from: e */
        private int f23410e;
        /* renamed from: f */
        private int f23411f;
        /* renamed from: g */
        private final int[] f23412g;

        public C7040b(int i, byte[] bArr) {
            this.f23406a = bArr;
            this.f23412g = (i & 8) == 0 ? f23408c : f23409d;
            this.f23410e = 0;
            this.f23411f = 0;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c0, code lost:
            return false;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x00f1, code lost:
            if (r20 != false) goto L_0x00fa;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x00f3, code lost:
            r0.f23410e = r5;
            r0.f23411f = r8;
            r0.f23407b = r9;
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
            r0.f23410e = 6;
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
            r0.f23410e = 6;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x0123, code lost:
            r0.f23410e = r5;
            r0.f23407b = r9;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x0127, code lost:
            return true;
     */
        /* renamed from: a */
        public boolean mo34137a(byte[] r17, int r18, int r19, boolean r20) {
            /*
            r16 = this;
            r0 = r16
            int r1 = r0.f23410e
            r2 = 0
            r3 = 6
            if (r1 != r3) goto L_0x0009
            return r2
        L_0x0009:
            int r4 = r19 + r18
            int r5 = r0.f23411f
            byte[] r6 = r0.f23406a
            int[] r7 = r0.f23412g
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
            r0.f23410e = r3
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
            r0.f23410e = r3
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
            r0.f23410e = r3
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
            r0.f23410e = r3
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
            r0.f23410e = r3
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
            r0.f23410e = r3
            return r10
        L_0x00ed:
            r1 = r14
            r2 = 0
            goto L_0x0016
        L_0x00f1:
            if (r20 != 0) goto L_0x00fa
            r0.f23410e = r5
            r0.f23411f = r8
            r0.f23407b = r9
            return r13
        L_0x00fa:
            if (r5 == 0) goto L_0x0123
            if (r5 == r13) goto L_0x0120
            if (r5 == r12) goto L_0x0117
            if (r5 == r10) goto L_0x0108
            if (r5 == r11) goto L_0x0105
            goto L_0x0123
        L_0x0105:
            r0.f23410e = r3
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
            r0.f23410e = r3
            goto L_0x00bf
        L_0x0123:
            r0.f23410e = r5
            r0.f23407b = r9
            return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.service.channel.security.C7038a.C7040b.mo34137a(byte[], int, int, boolean):boolean");
        }
    }

    /* renamed from: a */
    public static byte[] m30101a(String str, int i) {
        return m30102a(str.getBytes(), i);
    }

    /* renamed from: a */
    public static byte[] m30102a(byte[] bArr, int i) {
        return m30103a(bArr, 0, bArr.length, i);
    }

    /* renamed from: a */
    public static byte[] m30103a(byte[] bArr, int i, int i2, int i3) {
        C7040b bVar = new C7040b(i3, new byte[((i2 * 3) / 4)]);
        if (!bVar.mo34137a(bArr, i, i2, true)) {
            throw new IllegalArgumentException("bad base-64");
        } else if (bVar.f23407b == bVar.f23406a.length) {
            return bVar.f23406a;
        } else {
            byte[] bArr2 = new byte[bVar.f23407b];
            System.arraycopy(bVar.f23406a, 0, bArr2, 0, bVar.f23407b);
            return bArr2;
        }
    }

    private C7038a() {
    }
}
