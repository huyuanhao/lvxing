package com.scwang.smartrefresh.header.internal.pathview;

import android.graphics.Matrix;
import android.graphics.Path;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PathParser */
/* renamed from: com.scwang.smartrefresh.header.internal.pathview.a */
class C6472a {

    /* compiled from: PathParser */
    /* renamed from: com.scwang.smartrefresh.header.internal.pathview.a$a */
    private static class C6474a {
        /* renamed from: a */
        int f20659a;
        /* renamed from: b */
        boolean f20660b;

        private C6474a() {
        }
    }

    /* compiled from: PathParser */
    /* renamed from: com.scwang.smartrefresh.header.internal.pathview.a$b */
    public static class C6475b {
        /* renamed from: a */
        char f20661a;
        /* renamed from: b */
        float[] f20662b;

        C6475b(char c, float[] fArr) {
            this.f20661a = c;
            this.f20662b = fArr;
        }

        /* renamed from: a */
        public static void m25438a(C6475b[] bVarArr, Path path) {
            float[] fArr = new float[6];
            char c = 'm';
            for (C6475b bVar : bVarArr) {
                m25437a(path, fArr, c, bVar.f20661a, bVar.f20662b);
                c = bVar.f20661a;
            }
        }

        /* renamed from: a */
        private static void m25437a(Path path, float[] fArr, char c, char c2, float[] fArr2) {
            int i;
            int i2;
            float f;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            float f10;
            float f11;
            float f12;
            float f13;
            float f14;
            float f15;
            Path path2 = path;
            char c3 = c2;
            float[] fArr3 = fArr2;
            float f16 = fArr[0];
            float f17 = fArr[1];
            float f18 = fArr[2];
            float f19 = fArr[3];
            float f20 = fArr[4];
            float f21 = fArr[5];
            switch (c3) {
                case 'A':
                case 'a':
                    i = 7;
                    break;
                case 'C':
                case 'c':
                    i = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i = 1;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path2.moveTo(f20, f21);
                    f16 = f20;
                    f18 = f16;
                    f17 = f21;
                    f19 = f17;
                    break;
            }
            i = 2;
            float f22 = f16;
            float f23 = f17;
            float f24 = f20;
            float f25 = f21;
            int i3 = 0;
            char c4 = c;
            while (i3 < fArr3.length) {
                if (c3 != 'A') {
                    if (c3 == 'C') {
                        i2 = i3;
                        int i4 = i2 + 2;
                        int i5 = i2 + 3;
                        int i6 = i2 + 4;
                        int i7 = i2 + 5;
                        path.cubicTo(fArr3[i2 + 0], fArr3[i2 + 1], fArr3[i4], fArr3[i5], fArr3[i6], fArr3[i7]);
                        f22 = fArr3[i6];
                        float f26 = fArr3[i7];
                        float f27 = fArr3[i4];
                        float f28 = fArr3[i5];
                        f23 = f26;
                        f19 = f28;
                        f18 = f27;
                    } else if (c3 == 'H') {
                        i2 = i3;
                        int i8 = i2 + 0;
                        path2.lineTo(fArr3[i8], f23);
                        f22 = fArr3[i8];
                    } else if (c3 == 'Q') {
                        i2 = i3;
                        int i9 = i2 + 0;
                        int i10 = i2 + 1;
                        int i11 = i2 + 2;
                        int i12 = i2 + 3;
                        path2.quadTo(fArr3[i9], fArr3[i10], fArr3[i11], fArr3[i12]);
                        float f29 = fArr3[i9];
                        float f30 = fArr3[i10];
                        f22 = fArr3[i11];
                        f23 = fArr3[i12];
                        f18 = f29;
                        f19 = f30;
                    } else if (c3 == 'V') {
                        i2 = i3;
                        int i13 = i2 + 0;
                        path2.lineTo(f22, fArr3[i13]);
                        f23 = fArr3[i13];
                    } else if (c3 != 'a') {
                        if (c3 == 'c') {
                            int i14 = i3 + 2;
                            int i15 = i3 + 3;
                            int i16 = i3 + 4;
                            int i17 = i3 + 5;
                            path.rCubicTo(fArr3[i3 + 0], fArr3[i3 + 1], fArr3[i14], fArr3[i15], fArr3[i16], fArr3[i17]);
                            f4 = fArr3[i14] + f22;
                            f3 = fArr3[i15] + f23;
                            f5 = f22 + fArr3[i16];
                            f6 = fArr3[i17];
                            f7 = f23 + f6;
                            f18 = f4;
                            f19 = f3;
                        } else if (c3 != 'h') {
                            if (c3 != 'q') {
                                if (c3 == 'v') {
                                    int i18 = i3 + 0;
                                    path2.rLineTo(0.0f, fArr3[i18]);
                                    f8 = fArr3[i18];
                                } else if (c3 != 'L') {
                                    if (c3 == 'M') {
                                        int i19 = i3 + 0;
                                        f22 = fArr3[i19];
                                        int i20 = i3 + 1;
                                        f23 = fArr3[i20];
                                        if (i3 > 0) {
                                            path2.lineTo(fArr3[i19], fArr3[i20]);
                                        } else {
                                            path2.moveTo(fArr3[i19], fArr3[i20]);
                                        }
                                    } else if (c3 == 'S') {
                                        if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                                            f9 = (f22 * 2.0f) - f18;
                                            f10 = (f23 * 2.0f) - f19;
                                        }
                                        float f31 = f10;
                                        int i21 = i3 + 0;
                                        int i22 = i3 + 1;
                                        int i23 = i3 + 2;
                                        int i24 = i3 + 3;
                                        path.cubicTo(f9, f31, fArr3[i21], fArr3[i22], fArr3[i23], fArr3[i24]);
                                        f4 = fArr3[i21];
                                        f3 = fArr3[i22];
                                        f5 = fArr3[i23];
                                        f7 = fArr3[i24];
                                        f18 = f4;
                                        f19 = f3;
                                    } else if (c3 == 'T') {
                                        if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                                            f11 = (f22 * 2.0f) - f18;
                                            f23 = (f23 * 2.0f) - f19;
                                        }
                                        int i25 = i3 + 0;
                                        int i26 = i3 + 1;
                                        path2.quadTo(f11, f23, fArr3[i25], fArr3[i26]);
                                        float f32 = fArr3[i25];
                                        float f33 = fArr3[i26];
                                        f19 = f23;
                                        f18 = f11;
                                        i2 = i3;
                                        f22 = f32;
                                        f23 = f33;
                                    } else if (c3 == 'l') {
                                        int i27 = i3 + 0;
                                        int i28 = i3 + 1;
                                        path2.rLineTo(fArr3[i27], fArr3[i28]);
                                        f22 += fArr3[i27];
                                        f8 = fArr3[i28];
                                    } else if (c3 == 'm') {
                                        int i29 = i3 + 0;
                                        f22 += fArr3[i29];
                                        int i30 = i3 + 1;
                                        f23 += fArr3[i30];
                                        if (i3 > 0) {
                                            path2.rLineTo(fArr3[i29], fArr3[i30]);
                                        } else {
                                            path2.rMoveTo(fArr3[i29], fArr3[i30]);
                                        }
                                    } else if (c3 == 's') {
                                        if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                                            float f34 = f22 - f18;
                                            f12 = f23 - f19;
                                            f13 = f34;
                                        } else {
                                            f13 = 0.0f;
                                            f12 = 0.0f;
                                        }
                                        int i31 = i3 + 0;
                                        int i32 = i3 + 1;
                                        int i33 = i3 + 2;
                                        int i34 = i3 + 3;
                                        path.rCubicTo(f13, f12, fArr3[i31], fArr3[i32], fArr3[i33], fArr3[i34]);
                                        f4 = fArr3[i31] + f22;
                                        f3 = fArr3[i32] + f23;
                                        f5 = f22 + fArr3[i33];
                                        f6 = fArr3[i34];
                                    } else if (c3 == 't') {
                                        if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                                            f14 = f22 - f18;
                                            f15 = f23 - f19;
                                        } else {
                                            f15 = 0.0f;
                                            f14 = 0.0f;
                                        }
                                        int i35 = i3 + 0;
                                        int i36 = i3 + 1;
                                        path2.rQuadTo(f14, f15, fArr3[i35], fArr3[i36]);
                                        float f35 = f14 + f22;
                                        float f36 = f15 + f23;
                                        f22 += fArr3[i35];
                                        f23 += fArr3[i36];
                                        f19 = f36;
                                        f18 = f35;
                                    }
                                    f25 = f23;
                                    f24 = f22;
                                } else {
                                    int i37 = i3 + 0;
                                    int i38 = i3 + 1;
                                    path2.lineTo(fArr3[i37], fArr3[i38]);
                                    f22 = fArr3[i37];
                                    f23 = fArr3[i38];
                                }
                                f23 += f8;
                            } else {
                                int i39 = i3 + 0;
                                int i40 = i3 + 1;
                                int i41 = i3 + 2;
                                int i42 = i3 + 3;
                                path2.rQuadTo(fArr3[i39], fArr3[i40], fArr3[i41], fArr3[i42]);
                                f4 = fArr3[i39] + f22;
                                f3 = fArr3[i40] + f23;
                                f5 = f22 + fArr3[i41];
                                f6 = fArr3[i42];
                            }
                            f7 = f23 + f6;
                            f18 = f4;
                            f19 = f3;
                        } else {
                            int i43 = i3 + 0;
                            path2.rLineTo(fArr3[i43], 0.0f);
                            f22 += fArr3[i43];
                        }
                        i2 = i3;
                    } else {
                        int i44 = i3 + 5;
                        float f37 = fArr3[i44] + f22;
                        int i45 = i3 + 6;
                        float f38 = fArr3[i45] + f23;
                        float f39 = fArr3[i3 + 0];
                        float f40 = fArr3[i3 + 1];
                        float f41 = f23;
                        float f42 = f22;
                        i2 = i3;
                        m25436a(path, f22, f23, f37, f38, f39, f40, fArr3[i3 + 2], fArr3[i3 + 3] != 0.0f, fArr3[i3 + 4] != 0.0f);
                        f = f42 + fArr3[i44];
                        f2 = f41 + fArr3[i45];
                    }
                    i3 = i2 + i;
                    c4 = c2;
                    c3 = c4;
                } else {
                    i2 = i3;
                    int i46 = i2 + 5;
                    int i47 = i2 + 6;
                    m25436a(path, f22, f23, fArr3[i46], fArr3[i47], fArr3[i2 + 0], fArr3[i2 + 1], fArr3[i2 + 2], fArr3[i2 + 3] != 0.0f, fArr3[i2 + 4] != 0.0f);
                    f = fArr3[i46];
                    f2 = fArr3[i47];
                }
                f19 = f23;
                f18 = f22;
                i3 = i2 + i;
                c4 = c2;
                c3 = c4;
            }
            float f43 = f23;
            fArr[0] = f22;
            fArr[1] = f43;
            fArr[2] = f18;
            fArr[3] = f19;
            fArr[4] = f24;
            fArr[5] = f25;
        }

        /* renamed from: a */
        private static void m25436a(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
            double d;
            double d2;
            float f8 = f;
            float f9 = f3;
            float f10 = f5;
            float f11 = f6;
            boolean z3 = z2;
            double radians = Math.toRadians((double) f7);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d3 = (double) f8;
            double d4 = d3 * cos;
            double d5 = d3;
            double d6 = (double) f2;
            double d7 = (double) f10;
            double d8 = (d4 + (d6 * sin)) / d7;
            double d9 = (((double) (-f8)) * sin) + (d6 * cos);
            double d10 = d6;
            double d11 = (double) f11;
            double d12 = d9 / d11;
            double d13 = (double) f4;
            double d14 = ((((double) f9) * cos) + (d13 * sin)) / d7;
            double d15 = d7;
            double d16 = ((((double) (-f9)) * sin) + (d13 * cos)) / d11;
            double d17 = d8 - d14;
            double d18 = d12 - d16;
            double d19 = (d8 + d14) / 2.0d;
            double d20 = (d12 + d16) / 2.0d;
            double d21 = (d17 * d17) + (d18 * d18);
            if (d21 != 0.0d) {
                double d22 = (1.0d / d21) - 0.25d;
                if (d22 < 0.0d) {
                    float sqrt = (float) (Math.sqrt(d21) / 1.99999d);
                    m25436a(path, f, f2, f3, f4, f10 * sqrt, f6 * sqrt, f7, z, z2);
                    return;
                }
                double sqrt2 = Math.sqrt(d22);
                double d23 = d17 * sqrt2;
                double d24 = sqrt2 * d18;
                boolean z4 = z2;
                if (z == z4) {
                    d2 = d19 - d24;
                    d = d20 + d23;
                } else {
                    d2 = d19 + d24;
                    d = d20 - d23;
                }
                double d25 = d12 - d;
                double d26 = sin;
                double atan2 = Math.atan2(d25, d8 - d2);
                double atan22 = Math.atan2(d16 - d, d14 - d2) - atan2;
                int i = (atan22 > 0.0d ? 1 : (atan22 == 0.0d ? 0 : -1));
                if (z4 != (i >= 0)) {
                    atan22 = i > 0 ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
                }
                double d27 = d2 * d15;
                double d28 = d * d11;
                m25435a(path, (d27 * cos) - (d28 * d26), (d27 * d26) + (d28 * cos), d15, d11, d5, d10, radians, atan2, atan22);
            }
        }

        /* renamed from: a */
        private static void m25435a(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
            double d10 = d3;
            int ceil = (int) Math.ceil(Math.abs((d9 * 4.0d) / 3.141592653589793d));
            double cos = Math.cos(d7);
            double sin = Math.sin(d7);
            double cos2 = Math.cos(d8);
            double sin2 = Math.sin(d8);
            double d11 = -d10;
            double d12 = d11 * cos;
            double d13 = d4 * sin;
            double d14 = (d12 * sin2) - (d13 * cos2);
            double d15 = d11 * sin;
            double d16 = d4 * cos;
            double d17 = (sin2 * d15) + (cos2 * d16);
            double d18 = d9 / ((double) ceil);
            double d19 = d5;
            double d20 = d6;
            double d21 = d17;
            double d22 = d14;
            int i = 0;
            double d23 = d8;
            while (i < ceil) {
                double d24 = d23 + d18;
                double sin3 = Math.sin(d24);
                double cos3 = Math.cos(d24);
                double d25 = (d + ((d10 * cos) * cos3)) - (d13 * sin3);
                double d26 = d2 + (d10 * sin * cos3) + (d16 * sin3);
                double d27 = (d12 * sin3) - (d13 * cos3);
                double d28 = (sin3 * d15) + (cos3 * d16);
                double d29 = d24 - d23;
                double tan = Math.tan(d29 / 2.0d);
                double sin4 = (Math.sin(d29) * (Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
                int i2 = ceil;
                double d30 = cos;
                double d31 = d19 + (d22 * sin4);
                double d32 = sin;
                double d33 = d20 + (d21 * sin4);
                double d34 = d18;
                double d35 = d25 - (sin4 * d27);
                int i3 = i2;
                double d36 = d15;
                double d37 = d26 - (sin4 * d28);
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) d31, (float) d33, (float) d35, (float) d37, (float) d25, (float) d26);
                i++;
                d18 = d34;
                ceil = i3;
                sin = d32;
                d20 = d26;
                d15 = d36;
                d23 = d24;
                d21 = d28;
                d22 = d27;
                cos = d30;
                d10 = d3;
                d19 = d25;
            }
        }
    }

    /* renamed from: a */
    static float[] m25432a(float[] fArr, int i, int i2) {
        int i3 = i2 - i;
        int min = Math.min(i3, fArr.length - i);
        float[] fArr2 = new float[i3];
        System.arraycopy(fArr, i, fArr2, 0, min);
        return fArr2;
    }

    /* renamed from: a */
    public static List<Path> m25427a(float f, float f2, List<Path> list, List<String> list2) {
        Matrix matrix = new Matrix();
        matrix.setScale(f, f2);
        ArrayList arrayList = new ArrayList();
        if (VERSION.SDK_INT > 16) {
            for (Path path : list) {
                Path path2 = new Path();
                path.transform(matrix, path2);
                arrayList.add(path2);
            }
        } else {
            for (String str : list2) {
                Path path3 = new Path();
                C6475b[] b = m25433b(str);
                m25429a(f, f2, b);
                C6475b.m25438a(b, path3);
                arrayList.add(path3);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static void m25429a(float f, float f2, C6475b[] bVarArr) {
        for (C6475b bVar : bVarArr) {
            m25428a(f, f2, bVar.f20661a, bVar.f20662b);
        }
    }

    /* renamed from: a */
    private static void m25428a(float f, float f2, char c, float[] fArr) {
        int i = 2;
        switch (c) {
            case 'A':
            case 'a':
                i = 7;
                break;
            case 'C':
            case 'c':
                i = 6;
                break;
            case 'H':
            case 'V':
            case 'h':
            case 'v':
                i = 1;
                break;
            case 'Q':
            case 'S':
            case 'q':
            case 's':
                i = 4;
                break;
        }
        for (int i2 = 0; i2 < fArr.length; i2 += i) {
            if (c != 'A') {
                if (c != 'C') {
                    if (c != 'H') {
                        if (c != 'Q') {
                            if (c != 'V') {
                                if (c != 'a') {
                                    if (c != 'c') {
                                        if (c != 'h') {
                                            if (c != 'q') {
                                                if (c != 'v') {
                                                    if (!(c == 'L' || c == 'M')) {
                                                        if (c != 'S') {
                                                            if (!(c == 'T' || c == 'l' || c == 'm')) {
                                                                if (c != 's') {
                                                                    if (c != 't') {
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    fArr[i2] = fArr[i2] * f;
                                                    int i3 = i2 + 1;
                                                    fArr[i3] = fArr[i3] * f2;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            fArr[i2] = fArr[i2] * f2;
                        }
                        fArr[i2] = fArr[i2] * f;
                        int i4 = i2 + 1;
                        fArr[i4] = fArr[i4] * f2;
                        int i5 = i2 + 2;
                        fArr[i5] = fArr[i5] * f;
                        int i6 = i2 + 3;
                        fArr[i6] = fArr[i6] * f2;
                    }
                    fArr[i2] = fArr[i2] * f;
                }
                fArr[i2] = fArr[i2] * f;
                int i7 = i2 + 1;
                fArr[i7] = fArr[i7] * f2;
                int i8 = i2 + 2;
                fArr[i8] = fArr[i8] * f;
                int i9 = i2 + 3;
                fArr[i9] = fArr[i9] * f2;
                int i10 = i2 + 4;
                fArr[i10] = fArr[i10] * f;
                int i11 = i2 + 5;
                fArr[i11] = fArr[i11] * f2;
            }
            fArr[i2] = fArr[i2] * f;
            int i12 = i2 + 1;
            fArr[i12] = fArr[i12] * f2;
            int i13 = i2 + 5;
            fArr[i13] = fArr[i13] * f;
            int i14 = i2 + 6;
            fArr[i14] = fArr[i14] * f2;
        }
    }

    /* renamed from: a */
    public static Path m25426a(String str) {
        Path path = new Path();
        C6475b[] b = m25433b(str);
        if (b == null) {
            return null;
        }
        try {
            C6475b.m25438a(b, path);
            return path;
        } catch (RuntimeException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error in parsing ");
            sb.append(str);
            throw new RuntimeException(sb.toString(), e);
        }
    }

    /* renamed from: b */
    public static C6475b[] m25433b(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 0;
        while (i < str.length()) {
            int a = m25425a(str, i);
            String trim = str.substring(i2, a).trim();
            if (trim.length() > 0) {
                m25431a((List<C6475b>) arrayList, trim.charAt(0), m25434c(trim));
            }
            i2 = a;
            i = a + 1;
        }
        if (i - i2 == 1 && i2 < str.length()) {
            m25431a((List<C6475b>) arrayList, str.charAt(i2), new float[0]);
        }
        return (C6475b[]) arrayList.toArray(new C6475b[arrayList.size()]);
    }

    /* renamed from: a */
    private static int m25425a(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                return i;
            }
            i++;
        }
        return i;
    }

    /* renamed from: a */
    private static void m25431a(List<C6475b> list, char c, float[] fArr) {
        list.add(new C6475b(c, fArr));
    }

    /* renamed from: c */
    private static float[] m25434c(String str) {
        int i = 1;
        if ((str.charAt(0) == 'z') || (str.charAt(0) == 'Z')) {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            C6474a aVar = new C6474a();
            int length = str.length();
            int i2 = 0;
            while (i < length) {
                m25430a(str, i, aVar);
                int i3 = aVar.f20659a;
                if (i < i3) {
                    int i4 = i2 + 1;
                    fArr[i2] = Float.parseFloat(str.substring(i, i3));
                    i2 = i4;
                }
                i = aVar.f20660b ? i3 : i3 + 1;
            }
            return m25432a(fArr, 0, i2);
        } catch (NumberFormatException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("error in parsing \"");
            sb.append(str);
            sb.append("\"");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
            r2 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003a A[LOOP:0: B:1:0x0007->B:20:0x003a, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003d A[SYNTHETIC] */
    /* renamed from: a */
    private static void m25430a(java.lang.String r8, int r9, com.scwang.smartrefresh.header.internal.pathview.C6472a.C6474a r10) {
        /*
        r0 = 0
        r10.f20660b = r0
        r1 = r9
        r2 = 0
        r3 = 0
        r4 = 0
    L_0x0007:
        int r5 = r8.length()
        if (r1 >= r5) goto L_0x003d
        char r5 = r8.charAt(r1)
        r6 = 32
        r7 = 1
        if (r5 == r6) goto L_0x0035
        r6 = 69
        if (r5 == r6) goto L_0x0033
        r6 = 101(0x65, float:1.42E-43)
        if (r5 == r6) goto L_0x0033
        switch(r5) {
            case 44: goto L_0x0035;
            case 45: goto L_0x002a;
            case 46: goto L_0x0022;
            default: goto L_0x0021;
        }
    L_0x0021:
        goto L_0x0031
    L_0x0022:
        if (r3 != 0) goto L_0x0027
        r2 = 0
        r3 = 1
        goto L_0x0037
    L_0x0027:
        r10.f20660b = r7
        goto L_0x0035
    L_0x002a:
        if (r1 == r9) goto L_0x0031
        if (r2 != 0) goto L_0x0031
        r10.f20660b = r7
        goto L_0x0035
    L_0x0031:
        r2 = 0
        goto L_0x0037
    L_0x0033:
        r2 = 1
        goto L_0x0037
    L_0x0035:
        r2 = 0
        r4 = 1
    L_0x0037:
        if (r4 == 0) goto L_0x003a
        goto L_0x003d
    L_0x003a:
        int r1 = r1 + 1
        goto L_0x0007
    L_0x003d:
        r10.f20659a = r1
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.header.internal.pathview.C6472a.m25430a(java.lang.String, int, com.scwang.smartrefresh.header.internal.pathview.a$a):void");
    }
}
