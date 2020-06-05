package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.L;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.p013d.MiscUtils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.airbnb.lottie.model.content.h */
public class ShapeData {
    /* renamed from: a */
    private final List<CubicCurveData> f1665a = new ArrayList();
    /* renamed from: b */
    private PointF f1666b;
    /* renamed from: c */
    private boolean f1667c;

    public ShapeData(PointF pointF, boolean z, List<CubicCurveData> list) {
        this.f1666b = pointF;
        this.f1667c = z;
        this.f1665a.addAll(list);
    }

    public ShapeData() {
    }

    /* renamed from: a */
    private void m1624a(float f, float f2) {
        if (this.f1666b == null) {
            this.f1666b = new PointF();
        }
        this.f1666b.set(f, f2);
    }

    /* renamed from: a */
    public PointF mo10101a() {
        return this.f1666b;
    }

    /* renamed from: b */
    public boolean mo10103b() {
        return this.f1667c;
    }

    /* renamed from: c */
    public List<CubicCurveData> mo10104c() {
        return this.f1665a;
    }

    /* renamed from: a */
    public void mo10102a(ShapeData hVar, ShapeData hVar2, float f) {
        if (this.f1666b == null) {
            this.f1666b = new PointF();
        }
        boolean z = hVar.mo10103b() || hVar2.mo10103b();
        this.f1667c = z;
        if (hVar.mo10104c().size() != hVar2.mo10104c().size()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Curves must have the same number of control points. Shape 1: ");
            sb.append(hVar.mo10104c().size());
            sb.append("\tShape 2: ");
            sb.append(hVar2.mo10104c().size());
            L.m1314b(sb.toString());
        }
        if (this.f1665a.isEmpty()) {
            int min = Math.min(hVar.mo10104c().size(), hVar2.mo10104c().size());
            for (int i = 0; i < min; i++) {
                this.f1665a.add(new CubicCurveData());
            }
        }
        PointF a = hVar.mo10101a();
        PointF a2 = hVar2.mo10101a();
        m1624a(MiscUtils.m1440a(a.x, a2.x, f), MiscUtils.m1440a(a.y, a2.y, f));
        for (int size = this.f1665a.size() - 1; size >= 0; size--) {
            CubicCurveData aVar = (CubicCurveData) hVar.mo10104c().get(size);
            CubicCurveData aVar2 = (CubicCurveData) hVar2.mo10104c().get(size);
            PointF a3 = aVar.mo10011a();
            PointF b = aVar.mo10013b();
            PointF c = aVar.mo10015c();
            PointF a4 = aVar2.mo10011a();
            PointF b2 = aVar2.mo10013b();
            PointF c2 = aVar2.mo10015c();
            ((CubicCurveData) this.f1665a.get(size)).mo10012a(MiscUtils.m1440a(a3.x, a4.x, f), MiscUtils.m1440a(a3.y, a4.y, f));
            ((CubicCurveData) this.f1665a.get(size)).mo10014b(MiscUtils.m1440a(b.x, b2.x, f), MiscUtils.m1440a(b.y, b2.y, f));
            ((CubicCurveData) this.f1665a.get(size)).mo10016c(MiscUtils.m1440a(c.x, c2.x, f), MiscUtils.m1440a(c.y, c2.y, f));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ShapeData{numCurves=");
        sb.append(this.f1665a.size());
        sb.append("closed=");
        sb.append(this.f1667c);
        sb.append('}');
        return sb.toString();
    }
}
