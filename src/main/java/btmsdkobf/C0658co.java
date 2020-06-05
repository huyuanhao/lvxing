package btmsdkobf;

import java.lang.reflect.Array;
import java.security.SecureRandom;

/* renamed from: btmsdkobf.co */
public class C0658co {
    /* renamed from: gr */
    private int f436gr;
    /* renamed from: gs */
    private long f437gs;
    /* renamed from: gt */
    private long f438gt;

    C0658co(boolean z) {
        int nextInt;
        SecureRandom secureRandom = new SecureRandom();
        do {
            nextInt = secureRandom.nextInt(900) + 101;
        } while (m116e(nextInt));
        this.f436gr = nextInt;
        int i = this.f436gr;
        int i2 = 100;
        int[] iArr = new int[100];
        double sqrt = Math.sqrt((double) i);
        int i3 = 1;
        int i4 = ((int) sqrt) - 1;
        while (true) {
            int i5 = i4 + 1;
            if (i5 * i5 > i) {
                break;
            }
            i4 = i5;
        }
        iArr[0] = i4;
        if (i4 * i4 != i) {
            int[] iArr2 = new int[5];
            iArr2[1] = 1;
            char c = 2;
            iArr2[2] = 0;
            iArr2[3] = -iArr[0];
            char c2 = 4;
            iArr2[4] = 1;
            int[][] iArr3 = (int[][]) Array.newInstance(int.class, new int[]{100, 5});
            int i6 = 1;
            int i7 = 0;
            int i8 = 0;
            while (i6 < i2) {
                if (iArr2[1] < 0) {
                    iArr2[1] = -iArr2[1];
                    iArr2[c] = -iArr2[c];
                    iArr2[3] = -iArr2[3];
                    iArr2[c2] = -iArr2[c2];
                }
                int c3 = m115c(m115c(m115c(iArr2[1], Math.abs(iArr2[c])), Math.abs(iArr2[3])), Math.abs(iArr2[c2]));
                if (c3 > 1) {
                    iArr2[1] = iArr2[1] / c3;
                    iArr2[c] = iArr2[c] / c3;
                    iArr2[3] = iArr2[3] / c3;
                    iArr2[c2] = iArr2[c2] / c3;
                }
                i7 = 0;
                while (i7 < i8) {
                    int[] iArr4 = iArr3[i7];
                    if (iArr4[1] == iArr2[1] && iArr4[c] == iArr2[c] && iArr4[3] == iArr2[3] && iArr4[4] == iArr2[4]) {
                        break;
                    }
                    i7++;
                }
                if (i7 < i8) {
                    break;
                }
                iArr3[i8][1] = iArr2[1];
                iArr3[i8][c] = iArr2[c];
                iArr3[i8][3] = iArr2[3];
                iArr3[i8][4] = iArr2[4];
                i8++;
                iArr[i6] = (int) Math.floor(m113a(sqrt, iArr2));
                m114a(i, iArr2, iArr[i6]);
                i6++;
                i2 = 100;
                c = 2;
                c2 = 4;
            }
            int i9 = i6 - 1;
            int i10 = 1;
            long j = 1;
            long j2 = 0;
            boolean z2 = false;
            while (true) {
                if (j2 < 200 || !z2) {
                    int i11 = i10 + i3;
                    int i12 = i11 - 1;
                    long j3 = 1;
                    j2 = 0;
                    while (i12 >= 0) {
                        int i13 = i11 <= i9 ? iArr[i12] : iArr[((i12 - i7) % i9) + i7];
                        i12--;
                        long j4 = j3 + (((long) i13) * j2);
                        j3 = j2;
                        j2 = j4;
                    }
                    if (j2 < 1000000) {
                        long j5 = j2 * j2;
                        int i14 = i11;
                        int[] iArr5 = iArr;
                        long j6 = ((long) i) * j3 * j3;
                        long j7 = 1000 * j5;
                        if (j2 >= 200 && 999 * j6 < j7 && j7 < 1001 * j6 && !z2 && ((z && j5 < j6) || (!z && j5 > j6))) {
                            z2 = true;
                        }
                        iArr = iArr5;
                        j = j3;
                        i10 = i14;
                        i3 = 1;
                    } else {
                        throw new RuntimeException();
                    }
                } else {
                    mo9180a(j2, j);
                    return;
                }
            }
        }
    }

    /* renamed from: N */
    private void m112N() {
        long j = (long) this.f436gr;
        long j2 = this.f437gs;
        long j3 = this.f438gt;
        if (j2 >= 200) {
            long j4 = j * j3 * j3;
            long j5 = j4 * 1000;
            long j6 = j2 * j2 * 1000;
            if (j6 <= j5 - j4 || j6 >= j5 + j4) {
                throw new RuntimeException();
            }
            return;
        }
        throw new RuntimeException();
    }

    /* renamed from: a */
    private static final double m113a(double d, int[] iArr) {
        return (((double) iArr[1]) + (((double) iArr[2]) * d)) / (((double) iArr[3]) + (((double) iArr[4]) * d));
    }

    /* renamed from: a */
    private static final void m114a(int i, int[] iArr, int i2) {
        iArr[1] = iArr[1] - (iArr[3] * i2);
        iArr[2] = iArr[2] - (iArr[4] * i2);
        int i3 = (iArr[1] * iArr[4]) - (iArr[2] * iArr[3]);
        int i4 = (iArr[1] * iArr[1]) - ((iArr[2] * iArr[2]) * i);
        iArr[1] = (iArr[1] * iArr[3]) - ((iArr[2] * iArr[4]) * i);
        iArr[2] = i3;
        iArr[3] = i4;
        iArr[4] = 0;
    }

    /* renamed from: c */
    private static final int m115c(int i, int i2) {
        if (i == 0) {
            return i2;
        }
        if (i2 == 0) {
            return i;
        }
        if (i < i2) {
            return m115c(i2, i);
        }
        while (true) {
            int i3 = i % i2;
            if (i3 == 0) {
                return i2;
            }
            int i4 = i2;
            i2 = i3;
            i = i4;
        }
    }

    /* renamed from: e */
    private static final boolean m116e(int i) {
        int sqrt = ((int) Math.sqrt((double) i)) - 1;
        while (true) {
            int i2 = sqrt + 1;
            if (i2 * i2 > i) {
                break;
            }
            sqrt = i2;
        }
        return sqrt * sqrt == i;
    }

    /* access modifiers changed from: final */
    /* renamed from: a */
    public final void mo9180a(long j, long j2) {
        this.f437gs = j;
        this.f438gt = j2;
        m112N();
    }
}
