package com.airbnb.lottie.p008a.p009a;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.PolystarShape.Type;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.p008a.p010b.BaseKeyframeAnimation;
import com.airbnb.lottie.p008a.p010b.BaseKeyframeAnimation.C0925a;
import com.airbnb.lottie.p013d.MiscUtils;
import com.airbnb.lottie.p013d.Utils;
import com.airbnb.lottie.p014e.LottieValueCallback;
import java.util.List;

/* renamed from: com.airbnb.lottie.a.a.m */
public class PolystarContent implements KeyPathElementContent, PathContent, C0925a {
    /* renamed from: a */
    private final Path f1348a = new Path();
    /* renamed from: b */
    private final String f1349b;
    /* renamed from: c */
    private final LottieDrawable f1350c;
    /* renamed from: d */
    private final Type f1351d;
    /* renamed from: e */
    private final BaseKeyframeAnimation<?, Float> f1352e;
    /* renamed from: f */
    private final BaseKeyframeAnimation<?, PointF> f1353f;
    /* renamed from: g */
    private final BaseKeyframeAnimation<?, Float> f1354g;
    /* renamed from: h */
    private final BaseKeyframeAnimation<?, Float> f1355h;
    /* renamed from: i */
    private final BaseKeyframeAnimation<?, Float> f1356i;
    /* renamed from: j */
    private final BaseKeyframeAnimation<?, Float> f1357j;
    /* renamed from: k */
    private final BaseKeyframeAnimation<?, Float> f1358k;
    /* renamed from: l */
    private TrimPathContent f1359l;
    /* renamed from: m */
    private boolean f1360m;

    /* compiled from: PolystarContent */
    /* renamed from: com.airbnb.lottie.a.a.m$1 */
    static /* synthetic */ class C09241 {
        /* renamed from: a */
        static final /* synthetic */ int[] f1361a = new int[Type.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
     */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
            com.airbnb.lottie.model.content.PolystarShape$Type[] r0 = com.airbnb.lottie.model.content.PolystarShape.Type.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f1361a = r0
            int[] r0 = f1361a     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.airbnb.lottie.model.content.PolystarShape$Type r1 = com.airbnb.lottie.model.content.PolystarShape.Type.Star     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f1361a     // Catch:{ NoSuchFieldError -> 0x001f }
            com.airbnb.lottie.model.content.PolystarShape$Type r1 = com.airbnb.lottie.model.content.PolystarShape.Type.Polygon     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.p008a.p009a.PolystarContent.C09241.m40910clinit():void");
        }
    }

    public PolystarContent(LottieDrawable lottieDrawable, BaseLayer aVar, PolystarShape polystarShape) {
        this.f1350c = lottieDrawable;
        this.f1349b = polystarShape.mo10039a();
        this.f1351d = polystarShape.mo10040b();
        this.f1352e = polystarShape.mo10041c().mo10017a();
        this.f1353f = polystarShape.mo10042d().mo10017a();
        this.f1354g = polystarShape.mo10043e().mo10017a();
        this.f1356i = polystarShape.mo10045g().mo10017a();
        this.f1358k = polystarShape.mo10047i().mo10017a();
        if (this.f1351d == Type.Star) {
            this.f1355h = polystarShape.mo10044f().mo10017a();
            this.f1357j = polystarShape.mo10046h().mo10017a();
        } else {
            this.f1355h = null;
            this.f1357j = null;
        }
        aVar.mo10160a(this.f1352e);
        aVar.mo10160a(this.f1353f);
        aVar.mo10160a(this.f1354g);
        aVar.mo10160a(this.f1356i);
        aVar.mo10160a(this.f1358k);
        if (this.f1351d == Type.Star) {
            aVar.mo10160a(this.f1355h);
            aVar.mo10160a(this.f1357j);
        }
        this.f1352e.mo9865a((C0925a) this);
        this.f1353f.mo9865a((C0925a) this);
        this.f1354g.mo9865a((C0925a) this);
        this.f1356i.mo9865a((C0925a) this);
        this.f1358k.mo9865a((C0925a) this);
        if (this.f1351d == Type.Star) {
            this.f1355h.mo9865a((C0925a) this);
            this.f1357j.mo9865a((C0925a) this);
        }
    }

    /* renamed from: a */
    public void mo9846a() {
        m1208c();
    }

    /* renamed from: c */
    private void m1208c() {
        this.f1360m = false;
        this.f1350c.invalidateSelf();
    }

    /* renamed from: a */
    public void mo9851a(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list.size(); i++) {
            Content bVar = (Content) list.get(i);
            if (bVar instanceof TrimPathContent) {
                TrimPathContent rVar = (TrimPathContent) bVar;
                if (rVar.mo9858c() == ShapeTrimPath.Type.Simultaneously) {
                    this.f1359l = rVar;
                    this.f1359l.mo9857a(this);
                }
            }
        }
    }

    /* renamed from: e */
    public Path mo9855e() {
        if (this.f1360m) {
            return this.f1348a;
        }
        this.f1348a.reset();
        int i = C09241.f1361a[this.f1351d.ordinal()];
        if (i == 1) {
            m1209d();
        } else if (i == 2) {
            m1210f();
        }
        this.f1348a.close();
        Utils.m1456a(this.f1348a, this.f1359l);
        this.f1360m = true;
        return this.f1348a;
    }

    /* renamed from: b */
    public String mo9852b() {
        return this.f1349b;
    }

    /* renamed from: d */
    private void m1209d() {
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
        float floatValue = ((Float) this.f1352e.mo9870e()).floatValue();
        BaseKeyframeAnimation<?, Float> aVar = this.f1354g;
        double radians = Math.toRadians((aVar == null ? 0.0d : (double) ((Float) aVar.mo9870e()).floatValue()) - 90.0d);
        double d3 = (double) floatValue;
        float f13 = (float) (6.283185307179586d / d3);
        float f14 = f13 / 2.0f;
        float f15 = floatValue - ((float) ((int) floatValue));
        int i2 = (f15 > 0.0f ? 1 : (f15 == 0.0f ? 0 : -1));
        if (i2 != 0) {
            radians += (double) ((1.0f - f15) * f14);
        }
        float floatValue2 = ((Float) this.f1356i.mo9870e()).floatValue();
        float floatValue3 = ((Float) this.f1355h.mo9870e()).floatValue();
        BaseKeyframeAnimation<?, Float> aVar2 = this.f1357j;
        float floatValue4 = aVar2 != null ? ((Float) aVar2.mo9870e()).floatValue() / 100.0f : 0.0f;
        BaseKeyframeAnimation<?, Float> aVar3 = this.f1358k;
        float floatValue5 = aVar3 != null ? ((Float) aVar3.mo9870e()).floatValue() / 100.0f : 0.0f;
        if (i2 != 0) {
            f = ((floatValue2 - floatValue3) * f15) + floatValue3;
            i = i2;
            double d4 = (double) f;
            d = d3;
            f3 = (float) (d4 * Math.cos(radians));
            f2 = (float) (d4 * Math.sin(radians));
            this.f1348a.moveTo(f3, f2);
            d2 = radians + ((double) ((f13 * f15) / 2.0f));
        } else {
            d = d3;
            i = i2;
            double d5 = (double) floatValue2;
            float cos = (float) (Math.cos(radians) * d5);
            float sin = (float) (d5 * Math.sin(radians));
            this.f1348a.moveTo(cos, sin);
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
                    this.f1348a.lineTo(cos2, sin2);
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
                    this.f1348a.cubicTo(f19 - f22, f2 - f23, cos2 + f25, f12 + f26, cos2, f12);
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
                PointF pointF = (PointF) this.f1353f.mo9870e();
                this.f1348a.offset(pointF.x, pointF.y);
                this.f1348a.close();
                return;
            }
        }
    }

    /* renamed from: f */
    private void m1210f() {
        double d;
        double d2;
        double d3;
        int i;
        int floor = (int) Math.floor((double) ((Float) this.f1352e.mo9870e()).floatValue());
        BaseKeyframeAnimation<?, Float> aVar = this.f1354g;
        double radians = Math.toRadians((aVar == null ? 0.0d : (double) ((Float) aVar.mo9870e()).floatValue()) - 90.0d);
        double d4 = (double) floor;
        float f = (float) (6.283185307179586d / d4);
        float floatValue = ((Float) this.f1358k.mo9870e()).floatValue() / 100.0f;
        float floatValue2 = ((Float) this.f1356i.mo9870e()).floatValue();
        double d5 = (double) floatValue2;
        float cos = (float) (Math.cos(radians) * d5);
        float sin = (float) (Math.sin(radians) * d5);
        this.f1348a.moveTo(cos, sin);
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
                this.f1348a.cubicTo(cos - (((float) Math.cos(atan2)) * f2), sin - (((float) Math.sin(atan2)) * f2), cos2 + (((float) Math.cos(atan22)) * f2), sin2 + (f2 * ((float) Math.sin(atan22))), cos2, sin2);
            } else {
                d2 = d7;
                d3 = d5;
                d = d6;
                i = i2;
                this.f1348a.lineTo(cos2, sin2);
            }
            d7 = d2 + d;
            i2 = i + 1;
            sin = sin2;
            cos = cos2;
            ceil = d8;
            d5 = d3;
            d6 = d;
        }
        PointF pointF = (PointF) this.f1353f.mo9870e();
        this.f1348a.offset(pointF.x, pointF.y);
        this.f1348a.close();
    }

    /* renamed from: a */
    public void mo9849a(KeyPath eVar, int i, List<KeyPath> list, KeyPath eVar2) {
        MiscUtils.m1447a(eVar, i, list, eVar2, this);
    }

    /* renamed from: a */
    public <T> void mo9850a(T t, LottieValueCallback<T> cVar) {
        if (t == LottieProperty.f1538o) {
            this.f1352e.mo9866a(cVar);
        } else if (t == LottieProperty.f1539p) {
            this.f1354g.mo9866a(cVar);
        } else if (t == LottieProperty.f1531h) {
            this.f1353f.mo9866a(cVar);
        } else {
            if (t == LottieProperty.f1540q) {
                BaseKeyframeAnimation<?, Float> aVar = this.f1355h;
                if (aVar != null) {
                    aVar.mo9866a(cVar);
                    return;
                }
            }
            if (t == LottieProperty.f1541r) {
                this.f1356i.mo9866a(cVar);
                return;
            }
            if (t == LottieProperty.f1542s) {
                BaseKeyframeAnimation<?, Float> aVar2 = this.f1357j;
                if (aVar2 != null) {
                    aVar2.mo9866a(cVar);
                    return;
                }
            }
            if (t == LottieProperty.f1543t) {
                this.f1358k.mo9866a(cVar);
            }
        }
    }
}
