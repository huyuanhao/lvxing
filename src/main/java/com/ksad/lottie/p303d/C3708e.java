package com.ksad.lottie.p303d;

import android.graphics.Path;
import android.graphics.PointF;
import com.ksad.lottie.model.C3742a;
import com.ksad.lottie.model.content.C3767h;

/* renamed from: com.ksad.lottie.d.e */
public class C3708e {
    /* renamed from: a */
    public static double m15376a(double d, double d2, double d3) {
        return d + (d3 * (d2 - d));
    }

    /* renamed from: a */
    public static float m15377a(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }

    /* renamed from: a */
    static int m15378a(float f, float f2) {
        return m15379a((int) f, (int) f2);
    }

    /* renamed from: a */
    private static int m15379a(int i, int i2) {
        return i - (i2 * m15385b(i, i2));
    }

    /* renamed from: a */
    public static int m15380a(int i, int i2, float f) {
        return (int) (((float) i) + (f * ((float) (i2 - i))));
    }

    /* renamed from: a */
    public static int m15381a(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    /* renamed from: a */
    public static PointF m15382a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    /* renamed from: a */
    public static void m15383a(C3767h hVar, Path path) {
        path.reset();
        PointF a = hVar.mo23120a();
        path.moveTo(a.x, a.y);
        PointF pointF = new PointF(a.x, a.y);
        for (int i = 0; i < hVar.mo23123c().size(); i++) {
            C3742a aVar = (C3742a) hVar.mo23123c().get(i);
            PointF a2 = aVar.mo23030a();
            PointF b = aVar.mo23032b();
            PointF c = aVar.mo23034c();
            if (!a2.equals(pointF) || !b.equals(c)) {
                path.cubicTo(a2.x, a2.y, b.x, b.y, c.x, c.y);
            } else {
                path.lineTo(c.x, c.y);
            }
            pointF.set(c.x, c.y);
        }
        if (hVar.mo23122b()) {
            path.close();
        }
    }

    /* renamed from: b */
    public static float m15384b(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    /* renamed from: b */
    private static int m15385b(int i, int i2) {
        int i3 = i / i2;
        return (((i ^ i2) >= 0) || i % i2 == 0) ? i3 : i3 - 1;
    }

    /* renamed from: c */
    public static boolean m15386c(float f, float f2, float f3) {
        return f >= f2 && f <= f3;
    }
}
