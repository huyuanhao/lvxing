package com.kwad.sdk.core.p318b;

import com.p522qq.taf.jce.JceStruct;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.nio.charset.Charset;
import java.util.Arrays;

/* renamed from: com.kwad.sdk.core.b.a */
public class C4059a {
    /* access modifiers changed from: private|static|final */
    /* renamed from: a */
    public static final Charset f13647a = Charset.forName("ISO-8859-1");

    /* renamed from: com.kwad.sdk.core.b.a$a */
    public static class C4060a {
        /* renamed from: a */
        static final C4060a f13648a = new C4060a(false, false);
        /* renamed from: b */
        static final C4060a f13649b = new C4060a(true, false);
        /* renamed from: c */
        private static final int[] f13650c = new int[256];
        /* renamed from: d */
        private static final int[] f13651d = new int[256];
        /* renamed from: e */
        private final boolean f13652e;
        /* renamed from: f */
        private final boolean f13653f;

        static {
            Arrays.fill(f13650c, -1);
            for (int i = 0; i < C4061b.f13657d.length; i++) {
                f13650c[C4061b.f13657d[i]] = i;
            }
            f13650c[61] = -2;
            Arrays.fill(f13651d, -1);
            for (int i2 = 0; i2 < C4061b.f13658e.length; i2++) {
                f13651d[C4061b.f13658e[i2]] = i2;
            }
            f13651d[61] = -2;
        }

        private C4060a(boolean z, boolean z2) {
            this.f13652e = z;
            this.f13653f = z2;
        }

        /* renamed from: a */
        private int m16843a(byte[] bArr, int i, int i2) {
            int[] iArr = this.f13652e ? f13651d : f13650c;
            int i3 = i2 - i;
            int i4 = 0;
            if (i3 == 0) {
                return 0;
            }
            if (i3 >= 2) {
                if (this.f13653f) {
                    int i5 = 0;
                    while (true) {
                        if (i >= i2) {
                            break;
                        }
                        int i6 = i + 1;
                        byte b = bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
                        if (b == 61) {
                            i3 -= (i2 - i6) + 1;
                            break;
                        }
                        if (iArr[b] == -1) {
                            i5++;
                        }
                        i = i6;
                    }
                    i3 -= i5;
                } else if (bArr[i2 - 1] == 61) {
                    i4 = bArr[i2 - 2] == 61 ? 2 : 1;
                }
                if (i4 == 0) {
                    int i7 = i3 & 3;
                    if (i7 != 0) {
                        i4 = 4 - i7;
                    }
                }
                return (((i3 + 3) / 4) * 3) - i4;
            } else if (this.f13653f && iArr[0] == -1) {
                return 0;
            } else {
                throw new IllegalArgumentException("Input byte[] should at least have 2 bytes for base64 bytes");
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x002c, code lost:
            if (r11[r8] == 61) goto L_0x0030;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0030, code lost:
            if (r4 != 18) goto L_0x0080;
     */
        /* renamed from: a */
        private int m16844a(byte[] r11, int r12, int r13, byte[] r14) {
            /*
            r10 = this;
            boolean r0 = r10.f13652e
            if (r0 == 0) goto L_0x0007
            int[] r0 = f13651d
            goto L_0x0009
        L_0x0007:
            int[] r0 = f13650c
        L_0x0009:
            r1 = 18
            r2 = 0
            r3 = 0
            r4 = 18
            r5 = 0
        L_0x0010:
            r6 = 6
            r7 = 16
            if (r12 >= r13) goto L_0x0080
            int r8 = r12 + 1
            byte r12 = r11[r12]
            r12 = r12 & 255(0xff, float:3.57E-43)
            r12 = r0[r12]
            if (r12 >= 0) goto L_0x005f
            r9 = -2
            if (r12 != r9) goto L_0x003b
            if (r4 != r6) goto L_0x002f
            if (r8 == r13) goto L_0x0033
            int r12 = r8 + 1
            byte r2 = r11[r8]
            r8 = 61
            if (r2 != r8) goto L_0x0033
            goto L_0x0030
        L_0x002f:
            r12 = r8
        L_0x0030:
            if (r4 == r1) goto L_0x0033
            goto L_0x0080
        L_0x0033:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r12 = "Input byte array has wrong 4-byte ending unit"
            r11.<init>(r12)
            throw r11
        L_0x003b:
            boolean r12 = r10.f13653f
            if (r12 == 0) goto L_0x0040
            goto L_0x007e
        L_0x0040:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "Illegal base64 character "
            r13.append(r14)
            int r8 = r8 + -1
            byte r11 = r11[r8]
            java.lang.String r11 = java.lang.Integer.toString(r11, r7)
            r13.append(r11)
            java.lang.String r11 = r13.toString()
            r12.<init>(r11)
            throw r12
        L_0x005f:
            int r12 = r12 << r4
            r12 = r12 | r3
            int r4 = r4 + -6
            if (r4 >= 0) goto L_0x007d
            int r3 = r5 + 1
            int r4 = r12 >> 16
            byte r4 = (byte) r4
            r14[r5] = r4
            int r4 = r3 + 1
            int r5 = r12 >> 8
            byte r5 = (byte) r5
            r14[r3] = r5
            int r3 = r4 + 1
            byte r12 = (byte) r12
            r14[r4] = r12
            r5 = r3
            r3 = 0
            r4 = 18
            goto L_0x007e
        L_0x007d:
            r3 = r12
        L_0x007e:
            r12 = r8
            goto L_0x0010
        L_0x0080:
            if (r4 != r6) goto L_0x008b
            int r1 = r5 + 1
            int r2 = r3 >> 16
            byte r2 = (byte) r2
            r14[r5] = r2
            r5 = r1
            goto L_0x00a0
        L_0x008b:
            if (r4 != 0) goto L_0x009c
            int r1 = r5 + 1
            int r2 = r3 >> 16
            byte r2 = (byte) r2
            r14[r5] = r2
            int r5 = r1 + 1
            int r2 = r3 >> 8
            byte r2 = (byte) r2
            r14[r1] = r2
            goto L_0x00a0
        L_0x009c:
            r14 = 12
            if (r4 == r14) goto L_0x00c9
        L_0x00a0:
            if (r12 >= r13) goto L_0x00c8
            boolean r14 = r10.f13653f
            if (r14 == 0) goto L_0x00b1
            int r14 = r12 + 1
            byte r12 = r11[r12]
            r12 = r0[r12]
            if (r12 >= 0) goto L_0x00b0
            r12 = r14
            goto L_0x00a0
        L_0x00b0:
            r12 = r14
        L_0x00b1:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "Input byte array has incorrect ending byte at "
            r13.append(r14)
            r13.append(r12)
            java.lang.String r12 = r13.toString()
            r11.<init>(r12)
            throw r11
        L_0x00c8:
            return r5
        L_0x00c9:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r12 = "Last unit does not have enough valid bits"
            r11.<init>(r12)
            throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.p318b.C4059a.C4060a.m16844a(byte[], int, int, byte[]):int");
        }

        /* renamed from: a */
        public byte[] mo23720a(String str) {
            return mo23721a(str.getBytes(C4059a.f13647a));
        }

        /* renamed from: a */
        public byte[] mo23721a(byte[] bArr) {
            byte[] bArr2 = new byte[m16843a(bArr, 0, bArr.length)];
            int a = m16844a(bArr, 0, bArr.length, bArr2);
            return a != bArr2.length ? Arrays.copyOf(bArr2, a) : bArr2;
        }
    }

    /* renamed from: com.kwad.sdk.core.b.a$b */
    public static class C4061b {
        /* renamed from: a */
        static final C4061b f13654a = new C4061b(false, null, -1, true);
        /* renamed from: b */
        static final C4061b f13655b = new C4061b(true, null, -1, false);
        /* renamed from: c */
        static final C4061b f13656c = new C4061b(false, f13659f, 76, true);
        /* access modifiers changed from: private|static|final */
        /* renamed from: d */
        public static final char[] f13657d = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        /* access modifiers changed from: private|static|final */
        /* renamed from: e */
        public static final char[] f13658e = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_'};
        /* renamed from: f */
        private static final byte[] f13659f = {JceStruct.SIMPLE_LIST, 10};
        /* renamed from: g */
        private final byte[] f13660g;
        /* renamed from: h */
        private final int f13661h;
        /* renamed from: i */
        private final boolean f13662i;
        /* renamed from: j */
        private final boolean f13663j;

        private C4061b(boolean z, byte[] bArr, int i, boolean z2) {
            this.f13662i = z;
            this.f13660g = bArr;
            this.f13661h = i;
            this.f13663j = z2;
        }

        /* renamed from: a */
        private final int m16847a(int i) {
            int i2;
            if (this.f13663j) {
                i2 = ((i + 2) / 3) * 4;
            } else {
                int i3 = i % 3;
                i2 = ((i / 3) * 4) + (i3 == 0 ? 0 : i3 + 1);
            }
            int i4 = this.f13661h;
            return i4 > 0 ? i2 + (((i2 - 1) / i4) * this.f13660g.length) : i2;
        }

        /* renamed from: a */
        private int m16848a(byte[] bArr, int i, int i2, byte[] bArr2) {
            char[] cArr = this.f13662i ? f13658e : f13657d;
            int i3 = ((i2 - i) / 3) * 3;
            int i4 = i + i3;
            int i5 = this.f13661h;
            if (i5 > 0 && i3 > (i5 / 4) * 3) {
                i3 = (i5 / 4) * 3;
            }
            int i6 = 0;
            while (i < i4) {
                int min = Math.min(i + i3, i4);
                int i7 = i;
                int i8 = i6;
                while (i7 < min) {
                    int i9 = i7 + 1;
                    int i10 = i9 + 1;
                    byte b = ((bArr[i7] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 16) | ((bArr[i9] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8);
                    int i11 = i10 + 1;
                    byte b2 = b | (bArr[i10] & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
                    int i12 = i8 + 1;
                    bArr2[i8] = (byte) cArr[(b2 >>> 18) & 63];
                    int i13 = i12 + 1;
                    bArr2[i12] = (byte) cArr[(b2 >>> JceStruct.ZERO_TAG) & 63];
                    int i14 = i13 + 1;
                    bArr2[i13] = (byte) cArr[(b2 >>> 6) & 63];
                    i8 = i14 + 1;
                    bArr2[i14] = (byte) cArr[b2 & 63];
                    i7 = i11;
                }
                int i15 = ((min - i) / 3) * 4;
                i6 += i15;
                if (i15 == this.f13661h && min < i2) {
                    byte[] bArr3 = this.f13660g;
                    int length = bArr3.length;
                    int i16 = i6;
                    int i17 = 0;
                    while (i17 < length) {
                        int i18 = i16 + 1;
                        bArr2[i16] = bArr3[i17];
                        i17++;
                        i16 = i18;
                    }
                    i6 = i16;
                }
                i = min;
            }
            if (i >= i2) {
                return i6;
            }
            int i19 = i + 1;
            byte b3 = bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
            int i20 = i6 + 1;
            bArr2[i6] = (byte) cArr[b3 >> 2];
            if (i19 == i2) {
                int i21 = i20 + 1;
                bArr2[i20] = (byte) cArr[(b3 << 4) & 63];
                if (!this.f13663j) {
                    return i21;
                }
                int i22 = i21 + 1;
                bArr2[i21] = 61;
                int i23 = i22 + 1;
                bArr2[i22] = 61;
                return i23;
            }
            byte b4 = bArr[i19] & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
            int i24 = i20 + 1;
            bArr2[i20] = (byte) cArr[((b3 << 4) & 63) | (b4 >> 4)];
            int i25 = i24 + 1;
            bArr2[i24] = (byte) cArr[(b4 << 2) & 63];
            if (!this.f13663j) {
                return i25;
            }
            int i26 = i25 + 1;
            bArr2[i25] = 61;
            return i26;
        }

        /* renamed from: a */
        public byte[] mo23722a(byte[] bArr) {
            byte[] bArr2 = new byte[m16847a(bArr.length)];
            int a = m16848a(bArr, 0, bArr.length, bArr2);
            return a != bArr2.length ? Arrays.copyOf(bArr2, a) : bArr2;
        }
    }

    /* renamed from: a */
    public static C4061b m16840a() {
        return C4061b.f13654a;
    }

    /* renamed from: b */
    public static C4060a m16841b() {
        return C4060a.f13648a;
    }
}
