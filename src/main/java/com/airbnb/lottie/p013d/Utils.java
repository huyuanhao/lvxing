package com.airbnb.lottie.p013d;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.airbnb.lottie.L;
import com.airbnb.lottie.p008a.p009a.TrimPathContent;
import java.io.Closeable;

/* renamed from: com.airbnb.lottie.d.f */
public final class Utils {
    /* renamed from: a */
    private static final PathMeasure f1481a = new PathMeasure();
    /* renamed from: b */
    private static final Path f1482b = new Path();
    /* renamed from: c */
    private static final Path f1483c = new Path();
    /* renamed from: d */
    private static final float[] f1484d = new float[4];
    /* renamed from: e */
    private static final float f1485e = ((float) Math.sqrt(2.0d));
    /* renamed from: f */
    private static float f1486f = -1.0f;

    /* renamed from: a */
    public static int m1453a(float f, float f2, float f3, float f4) {
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
    public static boolean m1458a(int i, int i2, int i3, int i4, int i5, int i6) {
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

    /* renamed from: a */
    public static Path m1454a(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
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
    public static void m1457a(Closeable closeable) {
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
    public static float m1452a(Matrix matrix) {
        float[] fArr = f1484d;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f = f1485e;
        fArr[2] = f;
        fArr[3] = f;
        matrix.mapPoints(fArr);
        float[] fArr2 = f1484d;
        return ((float) Math.hypot((double) (fArr2[2] - fArr2[0]), (double) (fArr2[3] - fArr2[1]))) / 2.0f;
    }

    /* renamed from: a */
    public static void m1456a(Path path, TrimPathContent rVar) {
        if (rVar != null) {
            m1455a(path, ((Float) rVar.mo9859d().mo9870e()).floatValue() / 100.0f, ((Float) rVar.mo9860e().mo9870e()).floatValue() / 100.0f, ((Float) rVar.mo9861f().mo9870e()).floatValue() / 360.0f);
        }
    }

    /* renamed from: a */
    public static void m1455a(Path path, float f, float f2, float f3) {
        String str = "applyTrimPathIfNeeded";
        L.m1315c(str);
        f1481a.setPath(path, false);
        float length = f1481a.getLength();
        if (f == 1.0f && f2 == 0.0f) {
            L.m1316d(str);
        } else if (length < 1.0f || ((double) Math.abs((f2 - f) - 1.0f)) < 0.01d) {
            L.m1316d(str);
        } else {
            float f4 = f * length;
            float f5 = f2 * length;
            float f6 = f3 * length;
            float min = Math.min(f4, f5) + f6;
            float max = Math.max(f4, f5) + f6;
            if (min >= length && max >= length) {
                min = (float) MiscUtils.m1441a(min, length);
                max = (float) MiscUtils.m1441a(max, length);
            }
            if (min < 0.0f) {
                min = (float) MiscUtils.m1441a(min, length);
            }
            if (max < 0.0f) {
                max = (float) MiscUtils.m1441a(max, length);
            }
            int i = (min > max ? 1 : (min == max ? 0 : -1));
            if (i == 0) {
                path.reset();
                L.m1316d(str);
                return;
            }
            if (i >= 0) {
                min -= length;
            }
            f1482b.reset();
            f1481a.getSegment(min, max, f1482b, true);
            if (max > length) {
                f1483c.reset();
                f1481a.getSegment(0.0f, max % length, f1483c, true);
                f1482b.addPath(f1483c);
            } else if (min < 0.0f) {
                f1483c.reset();
                f1481a.getSegment(min + length, length, f1483c, true);
                f1482b.addPath(f1483c);
            }
            path.set(f1482b);
            L.m1316d(str);
        }
    }

    /* renamed from: a */
    public static float m1451a() {
        if (f1486f == -1.0f) {
            f1486f = Resources.getSystem().getDisplayMetrics().density;
        }
        return f1486f;
    }
}
