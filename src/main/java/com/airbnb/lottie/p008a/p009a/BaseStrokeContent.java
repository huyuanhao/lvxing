package com.airbnb.lottie.p008a.p009a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapeTrimPath.Type;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.model.p015a.AnimatableFloatValue;
import com.airbnb.lottie.model.p015a.AnimatableIntegerValue;
import com.airbnb.lottie.p008a.p010b.BaseKeyframeAnimation;
import com.airbnb.lottie.p008a.p010b.BaseKeyframeAnimation.C0925a;
import com.airbnb.lottie.p008a.p010b.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.p013d.MiscUtils;
import com.airbnb.lottie.p013d.Utils;
import com.airbnb.lottie.p014e.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.airbnb.lottie.a.a.a */
public abstract class BaseStrokeContent implements DrawingContent, KeyPathElementContent, C0925a {
    /* renamed from: a */
    final Paint f1274a = new Paint(1);
    /* renamed from: b */
    private final PathMeasure f1275b = new PathMeasure();
    /* renamed from: c */
    private final Path f1276c = new Path();
    /* renamed from: d */
    private final Path f1277d = new Path();
    /* renamed from: e */
    private final RectF f1278e = new RectF();
    /* renamed from: f */
    private final LottieDrawable f1279f;
    /* renamed from: g */
    private final BaseLayer f1280g;
    /* renamed from: h */
    private final List<C0922a> f1281h = new ArrayList();
    /* renamed from: i */
    private final float[] f1282i;
    /* renamed from: j */
    private final BaseKeyframeAnimation<?, Float> f1283j;
    /* renamed from: k */
    private final BaseKeyframeAnimation<?, Integer> f1284k;
    /* renamed from: l */
    private final List<BaseKeyframeAnimation<?, Float>> f1285l;
    /* renamed from: m */
    private final BaseKeyframeAnimation<?, Float> f1286m;
    /* renamed from: n */
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> f1287n;

    /* compiled from: BaseStrokeContent */
    /* renamed from: com.airbnb.lottie.a.a.a$a */
    private static final class C0922a {
        /* access modifiers changed from: private|final */
        /* renamed from: a */
        public final List<PathContent> f1288a;
        /* access modifiers changed from: private|final */
        /* renamed from: b */
        public final TrimPathContent f1289b;

        private C0922a(TrimPathContent rVar) {
            this.f1288a = new ArrayList();
            this.f1289b = rVar;
        }
    }

    BaseStrokeContent(LottieDrawable lottieDrawable, BaseLayer aVar, Cap cap, Join join, float f, AnimatableIntegerValue dVar, AnimatableFloatValue bVar, List<AnimatableFloatValue> list, AnimatableFloatValue bVar2) {
        this.f1279f = lottieDrawable;
        this.f1280g = aVar;
        this.f1274a.setStyle(Style.STROKE);
        this.f1274a.setStrokeCap(cap);
        this.f1274a.setStrokeJoin(join);
        this.f1274a.setStrokeMiter(f);
        this.f1284k = dVar.mo10017a();
        this.f1283j = bVar.mo10017a();
        if (bVar2 == null) {
            this.f1286m = null;
        } else {
            this.f1286m = bVar2.mo10017a();
        }
        this.f1285l = new ArrayList(list.size());
        this.f1282i = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.f1285l.add(((AnimatableFloatValue) list.get(i)).mo10017a());
        }
        aVar.mo10160a(this.f1284k);
        aVar.mo10160a(this.f1283j);
        for (int i2 = 0; i2 < this.f1285l.size(); i2++) {
            aVar.mo10160a((BaseKeyframeAnimation) this.f1285l.get(i2));
        }
        BaseKeyframeAnimation<?, Float> aVar2 = this.f1286m;
        if (aVar2 != null) {
            aVar.mo10160a(aVar2);
        }
        this.f1284k.mo9865a((C0925a) this);
        this.f1283j.mo9865a((C0925a) this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            ((BaseKeyframeAnimation) this.f1285l.get(i3)).mo9865a((C0925a) this);
        }
        BaseKeyframeAnimation<?, Float> aVar3 = this.f1286m;
        if (aVar3 != null) {
            aVar3.mo9865a((C0925a) this);
        }
    }

    /* renamed from: a */
    public void mo9846a() {
        this.f1279f.invalidateSelf();
    }

    /* renamed from: a */
    public void mo9851a(List<Content> list, List<Content> list2) {
        TrimPathContent rVar = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            Content bVar = (Content) list.get(size);
            if (bVar instanceof TrimPathContent) {
                TrimPathContent rVar2 = (TrimPathContent) bVar;
                if (rVar2.mo9858c() == Type.Individually) {
                    rVar = rVar2;
                }
            }
        }
        if (rVar != null) {
            rVar.mo9857a(this);
        }
        C0922a aVar = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            Content bVar2 = (Content) list2.get(size2);
            if (bVar2 instanceof TrimPathContent) {
                TrimPathContent rVar3 = (TrimPathContent) bVar2;
                if (rVar3.mo9858c() == Type.Individually) {
                    if (aVar != null) {
                        this.f1281h.add(aVar);
                    }
                    aVar = new C0922a(rVar3);
                    rVar3.mo9857a(this);
                }
            }
            if (bVar2 instanceof PathContent) {
                if (aVar == null) {
                    aVar = new C0922a(rVar);
                }
                aVar.f1288a.add((PathContent) bVar2);
            }
        }
        if (aVar != null) {
            this.f1281h.add(aVar);
        }
    }

    /* renamed from: a */
    public void mo9847a(Canvas canvas, Matrix matrix, int i) {
        String str = "StrokeContent#draw";
        L.m1315c(str);
        this.f1274a.setAlpha(MiscUtils.m1444a((int) ((((((float) i) / 255.0f) * ((float) ((Integer) this.f1284k.mo9870e()).intValue())) / 100.0f) * 255.0f), 0, 255));
        this.f1274a.setStrokeWidth(((Float) this.f1283j.mo9870e()).floatValue() * Utils.m1452a(matrix));
        if (this.f1274a.getStrokeWidth() <= 0.0f) {
            L.m1316d(str);
            return;
        }
        m1146a(matrix);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> aVar = this.f1287n;
        if (aVar != null) {
            this.f1274a.setColorFilter((ColorFilter) aVar.mo9870e());
        }
        for (int i2 = 0; i2 < this.f1281h.size(); i2++) {
            C0922a aVar2 = (C0922a) this.f1281h.get(i2);
            if (aVar2.f1289b != null) {
                m1145a(canvas, aVar2, matrix);
            } else {
                String str2 = "StrokeContent#buildPath";
                L.m1315c(str2);
                this.f1276c.reset();
                for (int size = aVar2.f1288a.size() - 1; size >= 0; size--) {
                    this.f1276c.addPath(((PathContent) aVar2.f1288a.get(size)).mo9855e(), matrix);
                }
                L.m1316d(str2);
                String str3 = "StrokeContent#drawPath";
                L.m1315c(str3);
                canvas.drawPath(this.f1276c, this.f1274a);
                L.m1316d(str3);
            }
        }
        L.m1316d(str);
    }

    /* renamed from: a */
    private void m1145a(Canvas canvas, C0922a aVar, Matrix matrix) {
        String str = "StrokeContent#applyTrimPath";
        L.m1315c(str);
        if (aVar.f1289b == null) {
            L.m1316d(str);
            return;
        }
        this.f1276c.reset();
        for (int size = aVar.f1288a.size() - 1; size >= 0; size--) {
            this.f1276c.addPath(((PathContent) aVar.f1288a.get(size)).mo9855e(), matrix);
        }
        this.f1275b.setPath(this.f1276c, false);
        float length = this.f1275b.getLength();
        while (this.f1275b.nextContour()) {
            length += this.f1275b.getLength();
        }
        float floatValue = (((Float) aVar.f1289b.mo9861f().mo9870e()).floatValue() * length) / 360.0f;
        float floatValue2 = ((((Float) aVar.f1289b.mo9859d().mo9870e()).floatValue() * length) / 100.0f) + floatValue;
        float floatValue3 = ((((Float) aVar.f1289b.mo9860e().mo9870e()).floatValue() * length) / 100.0f) + floatValue;
        float f = 0.0f;
        for (int size2 = aVar.f1288a.size() - 1; size2 >= 0; size2--) {
            this.f1277d.set(((PathContent) aVar.f1288a.get(size2)).mo9855e());
            this.f1277d.transform(matrix);
            this.f1275b.setPath(this.f1277d, false);
            float length2 = this.f1275b.getLength();
            float f2 = 1.0f;
            if (floatValue3 > length) {
                float f3 = floatValue3 - length;
                if (f3 < f + length2 && f < f3) {
                    Utils.m1455a(this.f1277d, floatValue2 > length ? (floatValue2 - length) / length2 : 0.0f, Math.min(f3 / length2, 1.0f), 0.0f);
                    canvas.drawPath(this.f1277d, this.f1274a);
                    f += length2;
                }
            }
            float f4 = f + length2;
            if (f4 >= floatValue2 && f <= floatValue3) {
                if (f4 > floatValue3 || floatValue2 >= f) {
                    float f5 = floatValue2 < f ? 0.0f : (floatValue2 - f) / length2;
                    if (floatValue3 <= f4) {
                        f2 = (floatValue3 - f) / length2;
                    }
                    Utils.m1455a(this.f1277d, f5, f2, 0.0f);
                    canvas.drawPath(this.f1277d, this.f1274a);
                } else {
                    canvas.drawPath(this.f1277d, this.f1274a);
                }
            }
            f += length2;
        }
        L.m1316d(str);
    }

    /* renamed from: a */
    public void mo9848a(RectF rectF, Matrix matrix) {
        String str = "StrokeContent#getBounds";
        L.m1315c(str);
        this.f1276c.reset();
        for (int i = 0; i < this.f1281h.size(); i++) {
            C0922a aVar = (C0922a) this.f1281h.get(i);
            for (int i2 = 0; i2 < aVar.f1288a.size(); i2++) {
                this.f1276c.addPath(((PathContent) aVar.f1288a.get(i2)).mo9855e(), matrix);
            }
        }
        this.f1276c.computeBounds(this.f1278e, false);
        float floatValue = ((Float) this.f1283j.mo9870e()).floatValue();
        RectF rectF2 = this.f1278e;
        float f = floatValue / 2.0f;
        rectF2.set(rectF2.left - f, this.f1278e.top - f, this.f1278e.right + f, this.f1278e.bottom + f);
        rectF.set(this.f1278e);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        L.m1316d(str);
    }

    /* renamed from: a */
    private void m1146a(Matrix matrix) {
        String str = "StrokeContent#applyDashPattern";
        L.m1315c(str);
        if (this.f1285l.isEmpty()) {
            L.m1316d(str);
            return;
        }
        float a = Utils.m1452a(matrix);
        for (int i = 0; i < this.f1285l.size(); i++) {
            this.f1282i[i] = ((Float) ((BaseKeyframeAnimation) this.f1285l.get(i)).mo9870e()).floatValue();
            if (i % 2 == 0) {
                float[] fArr = this.f1282i;
                if (fArr[i] < 1.0f) {
                    fArr[i] = 1.0f;
                }
            } else {
                float[] fArr2 = this.f1282i;
                if (fArr2[i] < 0.1f) {
                    fArr2[i] = 0.1f;
                }
            }
            float[] fArr3 = this.f1282i;
            fArr3[i] = fArr3[i] * a;
        }
        BaseKeyframeAnimation<?, Float> aVar = this.f1286m;
        this.f1274a.setPathEffect(new DashPathEffect(this.f1282i, aVar == null ? 0.0f : ((Float) aVar.mo9870e()).floatValue()));
        L.m1316d(str);
    }

    /* renamed from: a */
    public void mo9849a(KeyPath eVar, int i, List<KeyPath> list, KeyPath eVar2) {
        MiscUtils.m1447a(eVar, i, list, eVar2, this);
    }

    /* renamed from: a */
    public <T> void mo9850a(T t, LottieValueCallback<T> cVar) {
        if (t == LottieProperty.f1527d) {
            this.f1284k.mo9866a(cVar);
        } else if (t == LottieProperty.f1534k) {
            this.f1283j.mo9866a(cVar);
        } else if (t != LottieProperty.f1547x) {
        } else {
            if (cVar == null) {
                this.f1287n = null;
                return;
            }
            this.f1287n = new ValueCallbackKeyframeAnimation(cVar);
            this.f1287n.mo9865a((C0925a) this);
            this.f1280g.mo10160a(this.f1287n);
        }
    }
}
