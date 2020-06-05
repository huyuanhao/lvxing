package com.airbnb.lottie.p013d;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.p008a.p009a.KeyPathElementContent;
import java.util.List;

/* renamed from: com.airbnb.lottie.d.e */
public class MiscUtils {
    /* renamed from: a */
    public static double m1439a(double d, double d2, double d3) {
        return d + (d3 * (d2 - d));
    }

    /* renamed from: a */
    public static float m1440a(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }

    /* renamed from: a */
    public static int m1443a(int i, int i2, float f) {
        return (int) (((float) i) + (f * ((float) (i2 - i))));
    }

    /* renamed from: c */
    public static boolean m1450c(float f, float f2, float f3) {
        return f >= f2 && f <= f3;
    }

    /* renamed from: a */
    public static PointF m1445a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    /* renamed from: a */
    public static void m1446a(ShapeData hVar, Path path) {
        path.reset();
        PointF a = hVar.mo10101a();
        path.moveTo(a.x, a.y);
        PointF pointF = new PointF(a.x, a.y);
        for (int i = 0; i < hVar.mo10104c().size(); i++) {
            CubicCurveData aVar = (CubicCurveData) hVar.mo10104c().get(i);
            PointF a2 = aVar.mo10011a();
            PointF b = aVar.mo10013b();
            PointF c = aVar.mo10015c();
            if (!a2.equals(pointF) || !b.equals(c)) {
                path.cubicTo(a2.x, a2.y, b.x, b.y, c.x, c.y);
            } else {
                path.lineTo(c.x, c.y);
            }
            pointF.set(c.x, c.y);
        }
        if (hVar.mo10103b()) {
            path.close();
        }
    }

    /* renamed from: a */
    static int m1441a(float f, float f2) {
        return m1442a((int) f, (int) f2);
    }

    /* renamed from: a */
    private static int m1442a(int i, int i2) {
        return i - (i2 * m1449b(i, i2));
    }

    /* renamed from: b */
    private static int m1449b(int i, int i2) {
        int i3 = i / i2;
        return (((i ^ i2) >= 0) || i % i2 == 0) ? i3 : i3 - 1;
    }

    /* renamed from: a */
    public static int m1444a(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    /* renamed from: b */
    public static float m1448b(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    /* renamed from: a */
    public static void m1447a(KeyPath eVar, int i, List<KeyPath> list, KeyPath eVar2, KeyPathElementContent jVar) {
        if (eVar.mo10125c(jVar.mo9852b(), i)) {
            list.add(eVar2.mo10121a(jVar.mo9852b()).mo10120a((KeyPathElement) jVar));
        }
    }
}
