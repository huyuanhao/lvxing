package com.airbnb.lottie.p008a.p010b;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.model.p015a.AnimatableTransform;
import com.airbnb.lottie.p008a.p010b.BaseKeyframeAnimation.C0925a;
import com.airbnb.lottie.p014e.LottieValueCallback;
import com.airbnb.lottie.p014e.ScaleXY;

/* renamed from: com.airbnb.lottie.a.b.o */
public class TransformKeyframeAnimation {
    /* renamed from: a */
    private final Matrix f1417a = new Matrix();
    /* renamed from: b */
    private final BaseKeyframeAnimation<PointF, PointF> f1418b;
    /* renamed from: c */
    private final BaseKeyframeAnimation<?, PointF> f1419c;
    /* renamed from: d */
    private final BaseKeyframeAnimation<ScaleXY, ScaleXY> f1420d;
    /* renamed from: e */
    private final BaseKeyframeAnimation<Float, Float> f1421e;
    /* renamed from: f */
    private final BaseKeyframeAnimation<Integer, Integer> f1422f;
    /* renamed from: g */
    private final BaseKeyframeAnimation<?, Float> f1423g;
    /* renamed from: h */
    private final BaseKeyframeAnimation<?, Float> f1424h;

    public TransformKeyframeAnimation(AnimatableTransform lVar) {
        this.f1418b = lVar.mo10021a().mo10017a();
        this.f1419c = lVar.mo10022b().mo10017a();
        this.f1420d = lVar.mo10023c().mo10017a();
        this.f1421e = lVar.mo10024d().mo10017a();
        this.f1422f = lVar.mo10025e().mo10017a();
        if (lVar.mo10026f() != null) {
            this.f1423g = lVar.mo10026f().mo10017a();
        } else {
            this.f1423g = null;
        }
        if (lVar.mo10027g() != null) {
            this.f1424h = lVar.mo10027g().mo10017a();
        } else {
            this.f1424h = null;
        }
    }

    /* renamed from: a */
    public void mo9890a(BaseLayer aVar) {
        aVar.mo10160a(this.f1418b);
        aVar.mo10160a(this.f1419c);
        aVar.mo10160a(this.f1420d);
        aVar.mo10160a(this.f1421e);
        aVar.mo10160a(this.f1422f);
        BaseKeyframeAnimation<?, Float> aVar2 = this.f1423g;
        if (aVar2 != null) {
            aVar.mo10160a(aVar2);
        }
        BaseKeyframeAnimation<?, Float> aVar3 = this.f1424h;
        if (aVar3 != null) {
            aVar.mo10160a(aVar3);
        }
    }

    /* renamed from: a */
    public void mo9889a(C0925a aVar) {
        this.f1418b.mo9865a(aVar);
        this.f1419c.mo9865a(aVar);
        this.f1420d.mo9865a(aVar);
        this.f1421e.mo9865a(aVar);
        this.f1422f.mo9865a(aVar);
        BaseKeyframeAnimation<?, Float> aVar2 = this.f1423g;
        if (aVar2 != null) {
            aVar2.mo9865a(aVar);
        }
        BaseKeyframeAnimation<?, Float> aVar3 = this.f1424h;
        if (aVar3 != null) {
            aVar3.mo9865a(aVar);
        }
    }

    /* renamed from: a */
    public void mo9888a(float f) {
        this.f1418b.mo9864a(f);
        this.f1419c.mo9864a(f);
        this.f1420d.mo9864a(f);
        this.f1421e.mo9864a(f);
        this.f1422f.mo9864a(f);
        BaseKeyframeAnimation<?, Float> aVar = this.f1423g;
        if (aVar != null) {
            aVar.mo9864a(f);
        }
        BaseKeyframeAnimation<?, Float> aVar2 = this.f1424h;
        if (aVar2 != null) {
            aVar2.mo9864a(f);
        }
    }

    /* renamed from: a */
    public BaseKeyframeAnimation<?, Integer> mo9887a() {
        return this.f1422f;
    }

    /* renamed from: b */
    public BaseKeyframeAnimation<?, Float> mo9893b() {
        return this.f1423g;
    }

    /* renamed from: c */
    public BaseKeyframeAnimation<?, Float> mo9894c() {
        return this.f1424h;
    }

    /* renamed from: d */
    public Matrix mo9895d() {
        this.f1417a.reset();
        PointF pointF = (PointF) this.f1419c.mo9870e();
        if (!(pointF.x == 0.0f && pointF.y == 0.0f)) {
            this.f1417a.preTranslate(pointF.x, pointF.y);
        }
        float floatValue = ((Float) this.f1421e.mo9870e()).floatValue();
        if (floatValue != 0.0f) {
            this.f1417a.preRotate(floatValue);
        }
        ScaleXY dVar = (ScaleXY) this.f1420d.mo9870e();
        if (!(dVar.mo9988a() == 1.0f && dVar.mo9989b() == 1.0f)) {
            this.f1417a.preScale(dVar.mo9988a(), dVar.mo9989b());
        }
        PointF pointF2 = (PointF) this.f1418b.mo9870e();
        if (!(pointF2.x == 0.0f && pointF2.y == 0.0f)) {
            this.f1417a.preTranslate(-pointF2.x, -pointF2.y);
        }
        return this.f1417a;
    }

    /* renamed from: b */
    public Matrix mo9892b(float f) {
        PointF pointF = (PointF) this.f1419c.mo9870e();
        PointF pointF2 = (PointF) this.f1418b.mo9870e();
        ScaleXY dVar = (ScaleXY) this.f1420d.mo9870e();
        float floatValue = ((Float) this.f1421e.mo9870e()).floatValue();
        this.f1417a.reset();
        this.f1417a.preTranslate(pointF.x * f, pointF.y * f);
        double d = (double) f;
        this.f1417a.preScale((float) Math.pow((double) dVar.mo9988a(), d), (float) Math.pow((double) dVar.mo9989b(), d));
        this.f1417a.preRotate(floatValue * f, pointF2.x, pointF2.y);
        return this.f1417a;
    }

    /* renamed from: a */
    public <T> boolean mo9891a(T t, LottieValueCallback<T> cVar) {
        if (t == LottieProperty.f1528e) {
            this.f1418b.mo9866a(cVar);
        } else if (t == LottieProperty.f1529f) {
            this.f1419c.mo9866a(cVar);
        } else if (t == LottieProperty.f1532i) {
            this.f1420d.mo9866a(cVar);
        } else if (t == LottieProperty.f1533j) {
            this.f1421e.mo9866a(cVar);
        } else if (t == LottieProperty.f1526c) {
            this.f1422f.mo9866a(cVar);
        } else {
            if (t == LottieProperty.f1544u) {
                BaseKeyframeAnimation<?, Float> aVar = this.f1423g;
                if (aVar != null) {
                    aVar.mo9866a(cVar);
                }
            }
            if (t == LottieProperty.f1545v) {
                BaseKeyframeAnimation<?, Float> aVar2 = this.f1424h;
                if (aVar2 != null) {
                    aVar2.mo9866a(cVar);
                }
            }
            return false;
        }
        return true;
    }
}
