package com.ksad.lottie.p303d;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.ksad.lottie.C3665c;
import com.ksad.lottie.p298a.p299a.C3645r;
import java.io.Closeable;

/* renamed from: com.ksad.lottie.d.f */
public final class C3709f {
    /* renamed from: a */
    private static final PathMeasure f12613a = new PathMeasure();
    /* renamed from: b */
    private static final Path f12614b = new Path();
    /* renamed from: c */
    private static final Path f12615c = new Path();
    /* renamed from: d */
    private static final float[] f12616d = new float[4];
    /* renamed from: e */
    private static final float f12617e = ((float) Math.sqrt(2.0d));
    /* renamed from: f */
    private static float f12618f = -1.0f;

    /* renamed from: a */
    public static float m15387a() {
        if (f12618f == -1.0f) {
            f12618f = Resources.getSystem().getDisplayMetrics().density;
        }
        return f12618f;
    }

    /* renamed from: a */
    public static float m15388a(Matrix matrix) {
        float[] fArr = f12616d;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f = f12617e;
        fArr[2] = f;
        fArr[3] = f;
        matrix.mapPoints(fArr);
        float[] fArr2 = f12616d;
        return ((float) Math.hypot((double) (fArr2[2] - fArr2[0]), (double) (fArr2[3] - fArr2[1]))) / 2.0f;
    }

    /* renamed from: a */
    public static int m15389a(float f, float f2, float f3, float f4) {
        int i = f != 0.0f ? (int) (((float) 527) * f) : 17;
        if (f2 != 0.0f) {
            i = (int) (((float) (i * 31)) * f2);
        }
        if (f3 != 0.0f) {
            i = (int) (((float) (i * 31)) * f3);
        }
        return f4 != 0.0f ? (int) (((float) (i * 31)) * f4) : i;
    }

    /* renamed from: a */
    public static Path m15390a(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 == null || pointF4 == null || (pointF3.length() == 0.0f && pointF4.length() == 0.0f)) {
            path.lineTo(pointF2.x, pointF2.y);
        } else {
            Path path2 = path;
            path2.cubicTo(pointF3.x + pointF.x, pointF.y + pointF3.y, pointF2.x + pointF4.x, pointF2.y + pointF4.y, pointF2.x, pointF2.y);
        }
        return path;
    }

    /* renamed from: a */
    public static void m15391a(Path path, float f, float f2, float f3) {
        String str = "applyTrimPathIfNeeded";
        C3665c.m15252c(str);
        f12613a.setPath(path, false);
        float length = f12613a.getLength();
        if (f == 1.0f && f2 == 0.0f) {
            C3665c.m15253d(str);
        } else if (length < 1.0f || ((double) Math.abs((f2 - f) - 1.0f)) < 0.01d) {
            C3665c.m15253d(str);
        } else {
            float f4 = f * length;
            float f5 = f2 * length;
            float f6 = f3 * length;
            float min = Math.min(f4, f5) + f6;
            float max = Math.max(f4, f5) + f6;
            if (min >= length && max >= length) {
                min = (float) C3708e.m15378a(min, length);
                max = (float) C3708e.m15378a(max, length);
            }
            if (min < 0.0f) {
                min = (float) C3708e.m15378a(min, length);
            }
            if (max < 0.0f) {
                max = (float) C3708e.m15378a(max, length);
            }
            int i = (min > max ? 1 : (min == max ? 0 : -1));
            if (i == 0) {
                path.reset();
            } else {
                if (i >= 0) {
                    min -= length;
                }
                f12614b.reset();
                f12613a.getSegment(min, max, f12614b, true);
                if (max > length) {
                    f12615c.reset();
                    f12613a.getSegment(0.0f, max % length, f12615c, true);
                } else {
                    if (min < 0.0f) {
                        f12615c.reset();
                        f12613a.getSegment(min + length, length, f12615c, true);
                    }
                    path.set(f12614b);
                }
                f12614b.addPath(f12615c);
                path.set(f12614b);
            }
            C3665c.m15253d(str);
        }
    }

    /* renamed from: a */
    public static void m15392a(Path path, C3645r rVar) {
        if (rVar != null) {
            m15391a(path, ((Float) rVar.mo22821c().mo22831e()).floatValue() / 100.0f, ((Float) rVar.mo22822d().mo22831e()).floatValue() / 100.0f, ((Float) rVar.mo22823e().mo22831e()).floatValue() / 360.0f);
        }
    }

    /* renamed from: a */
    public static void m15393a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public static boolean m15394a(int i, int i2, int i3, int i4, int i5, int i6) {
        boolean z = false;
        if (i < i4) {
            return false;
        }
        if (i > i4) {
            return true;
        }
        if (i2 < i5) {
            return false;
        }
        if (i2 > i5) {
            return true;
        }
        if (i3 >= i6) {
            z = true;
        }
        return z;
    }
}
