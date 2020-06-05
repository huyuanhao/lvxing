package com.qiyukf.nimlib.p488k.p490b;

import android.opengl.GLES10;

/* renamed from: com.qiyukf.nimlib.k.b.c */
public final class C5942c {
    /* renamed from: a */
    private static int f18759a;

    /* renamed from: a */
    public static final int m23818a() {
        int i = f18759a;
        if (i > 0) {
            return i;
        }
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        int i2 = iArr[0];
        f18759a = i2;
        return i2;
    }

    /* renamed from: a */
    public static final int m23819a(int i, int i2, int i3) {
        int a = m23818a();
        if (a <= 0) {
            return i;
        }
        if (i2 <= i && i3 <= i) {
            return i;
        }
        while (true) {
            float f = (float) i;
            float f2 = (float) a;
            if (((float) i2) / f <= f2 && ((float) i3) / f <= f2) {
                break;
            }
            i++;
        }
        if (((i - 1) & i) == 0) {
            return i;
        }
        int i4 = 0;
        while (i > 0) {
            i >>= 1;
            i4++;
        }
        return 1 << i4;
    }

    /* renamed from: a */
    public static int m23820a(int i, int i2, int i3, int i4) {
        int i5 = 1;
        if (i > 0 && i2 > 0) {
            if (i3 <= 0 && i4 <= 0) {
                return 1;
            }
            if (i3 <= 0) {
                i3 = (int) ((((float) (i * i4)) / ((float) i2)) + 0.5f);
            } else if (i4 <= 0) {
                i4 = (int) ((((float) (i2 * i3)) / ((float) i)) + 0.5f);
            }
            if (i2 > i4 || i > i3) {
                int round = Math.round(((float) i2) / ((float) i4));
                int round2 = Math.round(((float) i) / ((float) i3));
                if (round >= round2) {
                    round = round2;
                }
                if (round == 0) {
                    round = 1;
                }
                float f = (float) (i * i2);
                i5 = round;
                while (f / ((float) (i5 * i5)) > ((float) ((i3 * i4) << 1))) {
                    i5++;
                }
            }
        }
        return i5;
    }

    /* renamed from: a */
    public static int m23821a(String str) {
        int[] a = C5939a.m23806a(str);
        int i = a[0];
        int i2 = a[1];
        if (i <= 0 || i2 <= 0) {
            return 1;
        }
        int sqrt = (int) Math.sqrt((double) (((float) (i * i2)) / 1166400.0f));
        if (sqrt <= 0) {
            return 1;
        }
        return sqrt;
    }
}
