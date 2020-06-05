package com.ksad.lottie.p298a.p299a;

import android.graphics.Path;
import android.graphics.PointF;
import com.ksad.lottie.C3721f;
import com.ksad.lottie.model.content.PolystarShape;
import com.ksad.lottie.model.content.PolystarShape.Type;
import com.ksad.lottie.model.content.ShapeTrimPath;
import com.ksad.lottie.model.layer.C3774a;
import com.ksad.lottie.p298a.p300b.C3646a;
import com.ksad.lottie.p298a.p300b.C3646a.C3647a;
import com.ksad.lottie.p303d.C3709f;
import java.util.List;

/* renamed from: com.ksad.lottie.a.a.m */
public class C3639m implements C3635j, C3638l, C3647a {
    /* renamed from: a */
    private final Path f12481a = new Path();
    /* renamed from: b */
    private final String f12482b;
    /* renamed from: c */
    private final C3721f f12483c;
    /* renamed from: d */
    private final Type f12484d;
    /* renamed from: e */
    private final C3646a<?, Float> f12485e;
    /* renamed from: f */
    private final C3646a<?, PointF> f12486f;
    /* renamed from: g */
    private final C3646a<?, Float> f12487g;
    /* renamed from: h */
    private final C3646a<?, Float> f12488h;
    /* renamed from: i */
    private final C3646a<?, Float> f12489i;
    /* renamed from: j */
    private final C3646a<?, Float> f12490j;
    /* renamed from: k */
    private final C3646a<?, Float> f12491k;
    /* renamed from: l */
    private C3645r f12492l;
    /* renamed from: m */
    private boolean f12493m;

    /* renamed from: com.ksad.lottie.a.a.m$1 */
    static /* synthetic */ class C36401 {
        /* renamed from: a */
        static final /* synthetic */ int[] f12494a = new int[Type.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
     */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
            com.ksad.lottie.model.content.PolystarShape$Type[] r0 = com.ksad.lottie.model.content.PolystarShape.Type.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f12494a = r0
            int[] r0 = f12494a     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.ksad.lottie.model.content.PolystarShape$Type r1 = com.ksad.lottie.model.content.PolystarShape.Type.Star     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f12494a     // Catch:{ NoSuchFieldError -> 0x001f }
            com.ksad.lottie.model.content.PolystarShape$Type r1 = com.ksad.lottie.model.content.PolystarShape.Type.Polygon     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ksad.lottie.p298a.p299a.C3639m.C36401.m47408clinit():void");
        }
    }

    public C3639m(C3721f fVar, C3774a aVar, PolystarShape polystarShape) {
        C3646a<?, Float> aVar2;
        this.f12483c = fVar;
        this.f12482b = polystarShape.mo23058a();
        this.f12484d = polystarShape.mo23059b();
        this.f12485e = polystarShape.mo23060c().mo23036a();
        this.f12486f = polystarShape.mo23061d().mo23036a();
        this.f12487g = polystarShape.mo23062e().mo23036a();
        this.f12489i = polystarShape.mo23064g().mo23036a();
        this.f12491k = polystarShape.mo23066i().mo23036a();
        if (this.f12484d == Type.Star) {
            this.f12488h = polystarShape.mo23063f().mo23036a();
            aVar2 = polystarShape.mo23065h().mo23036a();
        } else {
            aVar2 = null;
            this.f12488h = null;
        }
        this.f12490j = aVar2;
        aVar.mo23169a(this.f12485e);
        aVar.mo23169a(this.f12486f);
        aVar.mo23169a(this.f12487g);
        aVar.mo23169a(this.f12489i);
        aVar.mo23169a(this.f12491k);
        if (this.f12484d == Type.Star) {
            aVar.mo23169a(this.f12488h);
            aVar.mo23169a(this.f12490j);
        }
        this.f12485e.mo22827a((C3647a) this);
        this.f12486f.mo22827a((C3647a) this);
        this.f12487g.mo22827a((C3647a) this);
        this.f12489i.mo22827a((C3647a) this);
        this.f12491k.mo22827a((C3647a) this);
        if (this.f12484d == Type.Star) {
            this.f12488h.mo22827a((C3647a) this);
            this.f12490j.mo22827a((C3647a) this);
        }
    }

    /* renamed from: b */
    private void m15164b() {
        this.f12493m = false;
        this.f12483c.invalidateSelf();
    }

    /* renamed from: c */
    private void m15165c() {
        double d;
        int i;
        float f;
        float f2;
        float f3;
        double d2;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float floatValue = ((Float) this.f12485e.mo22831e()).floatValue();
        C3646a<?, Float> aVar = this.f12487g;
        double radians = Math.toRadians((aVar == null ? 0.0d : (double) ((Float) aVar.mo22831e()).floatValue()) - 90.0d);
        double d3 = (double) floatValue;
        float f13 = (float) (6.283185307179586d / d3);
        float f14 = f13 / 2.0f;
        float f15 = floatValue - ((float) ((int) floatValue));
        int i2 = (f15 > 0.0f ? 1 : (f15 == 0.0f ? 0 : -1));
        if (i2 != 0) {
            radians += (double) ((1.0f - f15) * f14);
        }
        float floatValue2 = ((Float) this.f12489i.mo22831e()).floatValue();
        float floatValue3 = ((Float) this.f12488h.mo22831e()).floatValue();
        C3646a<?, Float> aVar2 = this.f12490j;
        float floatValue4 = aVar2 != null ? ((Float) aVar2.mo22831e()).floatValue() / 100.0f : 0.0f;
        C3646a<?, Float> aVar3 = this.f12491k;
        float floatValue5 = aVar3 != null ? ((Float) aVar3.mo22831e()).floatValue() / 100.0f : 0.0f;
        if (i2 != 0) {
            f = ((floatValue2 - floatValue3) * f15) + floatValue3;
            i = i2;
            double d4 = (double) f;
            d = d3;
            f3 = (float) (d4 * Math.cos(radians));
            f2 = (float) (d4 * Math.sin(radians));
            this.f12481a.moveTo(f3, f2);
            d2 = radians + ((double) ((f13 * f15) / 2.0f));
        } else {
            d = d3;
            i = i2;
            double d5 = (double) floatValue2;
            float cos = (float) (Math.cos(radians) * d5);
            float sin = (float) (d5 * Math.sin(radians));
            this.f12481a.moveTo(cos, sin);
            d2 = radians + ((double) f14);
            f3 = cos;
            f2 = sin;
            f = 0.0f;
        }
        double ceil = Math.ceil(d) * 2.0d;
        boolean z = false;
        double d6 = d2;
        float f16 = f14;
        int i3 = 0;
        while (true) {
            double d7 = (double) i3;
            if (d7 < ceil) {
                float f17 = z ? floatValue2 : floatValue3;
                int i4 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
                if (i4 == 0 || d7 != ceil - 2.0d) {
                    f4 = f16;
                } else {
                    f4 = f16;
                    f16 = (f13 * f15) / 2.0f;
                }
                if (i4 == 0 || d7 != ceil - 1.0d) {
                    f6 = f13;
                    f5 = floatValue3;
                    f8 = f17;
                    f7 = floatValue2;
                } else {
                    f6 = f13;
                    f7 = floatValue2;
                    f5 = floatValue3;
                    f8 = f;
                }
                double d8 = (double) f8;
                float f18 = f16;
                float cos2 = (float) (d8 * Math.cos(d6));
                float sin2 = (float) (d8 * Math.sin(d6));
                if (floatValue4 == 0.0f && floatValue5 == 0.0f) {
                    this.f12481a.lineTo(cos2, sin2);
                    f12 = sin2;
                    f9 = floatValue4;
                    f10 = floatValue5;
                    f11 = f;
                } else {
                    f9 = floatValue4;
                    f10 = floatValue5;
                    double atan2 = (double) ((float) (Math.atan2((double) f2, (double) f3) - 1.5707963267948966d));
                    float cos3 = (float) Math.cos(atan2);
                    float sin3 = (float) Math.sin(atan2);
                    f11 = f;
                    f12 = sin2;
                    float f19 = f3;
                    double atan22 = (double) ((float) (Math.atan2((double) sin2, (double) cos2) - 1.5707963267948966d));
                    float cos4 = (float) Math.cos(atan22);
                    float sin4 = (float) Math.sin(atan22);
                    float f20 = z ? f9 : f10;
                    float f21 = (z ? f5 : f7) * f20 * 0.47829f;
                    float f22 = cos3 * f21;
                    float f23 = f21 * sin3;
                    float f24 = (z ? f7 : f5) * (z ? f10 : f9) * 0.47829f;
                    float f25 = cos4 * f24;
                    float f26 = f24 * sin4;
                    if (i != 0) {
                        if (i3 == 0) {
                            f22 *= f15;
                            f23 *= f15;
                        } else if (d7 == ceil - 1.0d) {
                            f25 *= f15;
                            f26 *= f15;
                        }
                    }
                    this.f12481a.cubicTo(f19 - f22, f2 - f23, cos2 + f25, f12 + f26, cos2, f12);
                }
                d6 += (double) f18;
                z = !z;
                i3++;
                f3 = cos2;
                f = f11;
                floatValue2 = f7;
                f13 = f6;
                f16 = f4;
                floatValue3 = f5;
                floatValue4 = f9;
                floatValue5 = f10;
                f2 = f12;
            } else {
                PointF pointF = (PointF) this.f12486f.mo22831e();
                this.f12481a.offset(pointF.x, pointF.y);
                this.f12481a.close();
                return;
            }
        }
    }

    /* renamed from: e */
    private void m15166e() {
        double d;
        double d2;
        double d3;
        int i;
        int floor = (int) Math.floor((double) ((Float) this.f12485e.mo22831e()).floatValue());
        C3646a<?, Float> aVar = this.f12487g;
        double radians = Math.toRadians((aVar == null ? 0.0d : (double) ((Float) aVar.mo22831e()).floatValue()) - 90.0d);
        double d4 = (double) floor;
        float f = (float) (6.283185307179586d / d4);
        float floatValue = ((Float) this.f12491k.mo22831e()).floatValue() / 100.0f;
        float floatValue2 = ((Float) this.f12489i.mo22831e()).floatValue();
        double d5 = (double) floatValue2;
        float cos = (float) (Math.cos(radians) * d5);
        float sin = (float) (Math.sin(radians) * d5);
        this.f12481a.moveTo(cos, sin);
        double d6 = (double) f;
        double d7 = radians + d6;
        double ceil = Math.ceil(d4);
        int i2 = 0;
        while (((double) i2) < ceil) {
            float cos2 = (float) (Math.cos(d7) * d5);
            double d8 = ceil;
            float sin2 = (float) (d5 * Math.sin(d7));
            if (floatValue != 0.0f) {
                d3 = d5;
                i = i2;
                d2 = d7;
                double atan2 = (double) ((float) (Math.atan2((double) sin, (double) cos) - 1.5707963267948966d));
                d = d6;
                double atan22 = (double) ((float) (Math.atan2((double) sin2, (double) cos2) - 1.5707963267948966d));
                float f2 = floatValue2 * floatValue * 0.25f;
                this.f12481a.cubicTo(cos - (((float) Math.cos(atan2)) * f2), sin - (((float) Math.sin(atan2)) * f2), cos2 + (((float) Math.cos(atan22)) * f2), sin2 + (f2 * ((float) Math.sin(atan22))), cos2, sin2);
            } else {
                d2 = d7;
                d3 = d5;
                d = d6;
                i = i2;
                this.f12481a.lineTo(cos2, sin2);
            }
            d7 = d2 + d;
            i2 = i + 1;
            sin = sin2;
            cos = cos2;
            ceil = d8;
            d5 = d3;
            d6 = d;
        }
        PointF pointF = (PointF) this.f12486f.mo22831e();
        this.f12481a.offset(pointF.x, pointF.y);
        this.f12481a.close();
    }

    /* renamed from: a */
    public void mo22811a() {
        m15164b();
    }

    /* renamed from: a */
    public void mo22814a(List<C3627b> list, List<C3627b> list2) {
        for (int i = 0; i < list.size(); i++) {
            C3627b bVar = (C3627b) list.get(i);
            if (bVar instanceof C3645r) {
                C3645r rVar = (C3645r) bVar;
                if (rVar.mo22820b() == ShapeTrimPath.Type.Simultaneously) {
                    this.f12492l = rVar;
                    this.f12492l.mo22819a(this);
                }
            }
        }
    }

    /* renamed from: d */
    public Path mo22817d() {
        if (this.f12493m) {
            return this.f12481a;
        }
        this.f12481a.reset();
        int i = C36401.f12494a[this.f12484d.ordinal()];
        if (i == 1) {
            m15165c();
        } else if (i == 2) {
            m15166e();
        }
        this.f12481a.close();
        C3709f.m15392a(this.f12481a, this.f12492l);
        this.f12493m = true;
        return this.f12481a;
    }
}
