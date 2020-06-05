package com.ksad.lottie.p298a.p299a;

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
import com.ksad.lottie.C3665c;
import com.ksad.lottie.C3721f;
import com.ksad.lottie.model.content.ShapeTrimPath.Type;
import com.ksad.lottie.model.layer.C3774a;
import com.ksad.lottie.model.p305a.C3744b;
import com.ksad.lottie.model.p305a.C3746d;
import com.ksad.lottie.p298a.p300b.C3646a;
import com.ksad.lottie.p298a.p300b.C3646a.C3647a;
import com.ksad.lottie.p303d.C3708e;
import com.ksad.lottie.p303d.C3709f;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.ksad.lottie.a.a.a */
public abstract class C3624a implements C3629d, C3635j, C3647a {
    /* renamed from: a */
    final Paint f12407a = new Paint(1);
    /* renamed from: b */
    private final PathMeasure f12408b = new PathMeasure();
    /* renamed from: c */
    private final Path f12409c = new Path();
    /* renamed from: d */
    private final Path f12410d = new Path();
    /* renamed from: e */
    private final RectF f12411e = new RectF();
    /* renamed from: f */
    private final C3721f f12412f;
    /* renamed from: g */
    private final C3774a f12413g;
    /* renamed from: h */
    private final List<C3626a> f12414h = new ArrayList();
    /* renamed from: i */
    private final float[] f12415i;
    /* renamed from: j */
    private final C3646a<?, Float> f12416j;
    /* renamed from: k */
    private final C3646a<?, Integer> f12417k;
    /* renamed from: l */
    private final List<C3646a<?, Float>> f12418l;
    /* renamed from: m */
    private final C3646a<?, Float> f12419m;
    /* renamed from: n */
    private C3646a<ColorFilter, ColorFilter> f12420n;

    /* renamed from: com.ksad.lottie.a.a.a$a */
    private static final class C3626a {
        /* access modifiers changed from: private|final */
        /* renamed from: a */
        public final List<C3638l> f12421a;
        /* access modifiers changed from: private|final */
        /* renamed from: b */
        public final C3645r f12422b;

        private C3626a(C3645r rVar) {
            this.f12421a = new ArrayList();
            this.f12422b = rVar;
        }
    }

    C3624a(C3721f fVar, C3774a aVar, Cap cap, Join join, float f, C3746d dVar, C3744b bVar, List<C3744b> list, C3744b bVar2) {
        this.f12412f = fVar;
        this.f12413g = aVar;
        this.f12407a.setStyle(Style.STROKE);
        this.f12407a.setStrokeCap(cap);
        this.f12407a.setStrokeJoin(join);
        this.f12407a.setStrokeMiter(f);
        this.f12417k = dVar.mo23036a();
        this.f12416j = bVar.mo23036a();
        this.f12419m = bVar2 == null ? null : bVar2.mo23036a();
        this.f12418l = new ArrayList(list.size());
        this.f12415i = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.f12418l.add(((C3744b) list.get(i)).mo23036a());
        }
        aVar.mo23169a(this.f12417k);
        aVar.mo23169a(this.f12416j);
        for (int i2 = 0; i2 < this.f12418l.size(); i2++) {
            aVar.mo23169a((C3646a) this.f12418l.get(i2));
        }
        C3646a<?, Float> aVar2 = this.f12419m;
        if (aVar2 != null) {
            aVar.mo23169a(aVar2);
        }
        this.f12417k.mo22827a((C3647a) this);
        this.f12416j.mo22827a((C3647a) this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            ((C3646a) this.f12418l.get(i3)).mo22827a((C3647a) this);
        }
        C3646a<?, Float> aVar3 = this.f12419m;
        if (aVar3 != null) {
            aVar3.mo22827a((C3647a) this);
        }
    }

    /* renamed from: a */
    private void m15118a(Canvas canvas, C3626a aVar, Matrix matrix) {
        float f;
        String str = "StrokeContent#applyTrimPath";
        C3665c.m15252c(str);
        if (aVar.f12422b == null) {
            C3665c.m15253d(str);
            return;
        }
        this.f12409c.reset();
        for (int size = aVar.f12421a.size() - 1; size >= 0; size--) {
            this.f12409c.addPath(((C3638l) aVar.f12421a.get(size)).mo22817d(), matrix);
        }
        this.f12408b.setPath(this.f12409c, false);
        float length = this.f12408b.getLength();
        while (this.f12408b.nextContour()) {
            length += this.f12408b.getLength();
        }
        float floatValue = (((Float) aVar.f12422b.mo22823e().mo22831e()).floatValue() * length) / 360.0f;
        float floatValue2 = ((((Float) aVar.f12422b.mo22821c().mo22831e()).floatValue() * length) / 100.0f) + floatValue;
        float floatValue3 = ((((Float) aVar.f12422b.mo22822d().mo22831e()).floatValue() * length) / 100.0f) + floatValue;
        float f2 = 0.0f;
        for (int size2 = aVar.f12421a.size() - 1; size2 >= 0; size2--) {
            this.f12410d.set(((C3638l) aVar.f12421a.get(size2)).mo22817d());
            this.f12410d.transform(matrix);
            this.f12408b.setPath(this.f12410d, false);
            float length2 = this.f12408b.getLength();
            float f3 = 1.0f;
            if (floatValue3 > length) {
                float f4 = floatValue3 - length;
                if (f4 < f2 + length2 && f2 < f4) {
                    f = floatValue2 > length ? (floatValue2 - length) / length2 : 0.0f;
                    f3 = Math.min(f4 / length2, 1.0f);
                    C3709f.m15391a(this.f12410d, f, f3, 0.0f);
                    canvas.drawPath(this.f12410d, this.f12407a);
                    f2 += length2;
                }
            }
            float f5 = f2 + length2;
            if (f5 >= floatValue2 && f2 <= floatValue3) {
                if (f5 > floatValue3 || floatValue2 >= f2) {
                    f = floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2;
                    if (floatValue3 <= f5) {
                        f3 = (floatValue3 - f2) / length2;
                    }
                    C3709f.m15391a(this.f12410d, f, f3, 0.0f);
                }
                canvas.drawPath(this.f12410d, this.f12407a);
            }
            f2 += length2;
        }
        C3665c.m15253d(str);
    }

    /* renamed from: a */
    private void m15119a(Matrix matrix) {
        String str = "StrokeContent#applyDashPattern";
        C3665c.m15252c(str);
        if (this.f12418l.isEmpty()) {
            C3665c.m15253d(str);
            return;
        }
        float a = C3709f.m15388a(matrix);
        for (int i = 0; i < this.f12418l.size(); i++) {
            this.f12415i[i] = ((Float) ((C3646a) this.f12418l.get(i)).mo22831e()).floatValue();
            if (i % 2 == 0) {
                float[] fArr = this.f12415i;
                if (fArr[i] < 1.0f) {
                    fArr[i] = 1.0f;
                }
            } else {
                float[] fArr2 = this.f12415i;
                if (fArr2[i] < 0.1f) {
                    fArr2[i] = 0.1f;
                }
            }
            float[] fArr3 = this.f12415i;
            fArr3[i] = fArr3[i] * a;
        }
        C3646a<?, Float> aVar = this.f12419m;
        this.f12407a.setPathEffect(new DashPathEffect(this.f12415i, aVar == null ? 0.0f : ((Float) aVar.mo22831e()).floatValue()));
        C3665c.m15253d(str);
    }

    /* renamed from: a */
    public void mo22811a() {
        this.f12412f.invalidateSelf();
    }

    /* renamed from: a */
    public void mo22812a(Canvas canvas, Matrix matrix, int i) {
        String str = "StrokeContent#draw";
        C3665c.m15252c(str);
        this.f12407a.setAlpha(C3708e.m15381a((int) ((((((float) i) / 255.0f) * ((float) ((Integer) this.f12417k.mo22831e()).intValue())) / 100.0f) * 255.0f), 0, 255));
        this.f12407a.setStrokeWidth(((Float) this.f12416j.mo22831e()).floatValue() * C3709f.m15388a(matrix));
        if (this.f12407a.getStrokeWidth() <= 0.0f) {
            C3665c.m15253d(str);
            return;
        }
        m15119a(matrix);
        C3646a<ColorFilter, ColorFilter> aVar = this.f12420n;
        if (aVar != null) {
            this.f12407a.setColorFilter((ColorFilter) aVar.mo22831e());
        }
        for (int i2 = 0; i2 < this.f12414h.size(); i2++) {
            C3626a aVar2 = (C3626a) this.f12414h.get(i2);
            if (aVar2.f12422b != null) {
                m15118a(canvas, aVar2, matrix);
            } else {
                String str2 = "StrokeContent#buildPath";
                C3665c.m15252c(str2);
                this.f12409c.reset();
                for (int size = aVar2.f12421a.size() - 1; size >= 0; size--) {
                    this.f12409c.addPath(((C3638l) aVar2.f12421a.get(size)).mo22817d(), matrix);
                }
                C3665c.m15253d(str2);
                String str3 = "StrokeContent#drawPath";
                C3665c.m15252c(str3);
                canvas.drawPath(this.f12409c, this.f12407a);
                C3665c.m15253d(str3);
            }
        }
        C3665c.m15253d(str);
    }

    /* renamed from: a */
    public void mo22813a(RectF rectF, Matrix matrix) {
        String str = "StrokeContent#getBounds";
        C3665c.m15252c(str);
        this.f12409c.reset();
        for (int i = 0; i < this.f12414h.size(); i++) {
            C3626a aVar = (C3626a) this.f12414h.get(i);
            for (int i2 = 0; i2 < aVar.f12421a.size(); i2++) {
                this.f12409c.addPath(((C3638l) aVar.f12421a.get(i2)).mo22817d(), matrix);
            }
        }
        this.f12409c.computeBounds(this.f12411e, false);
        float floatValue = ((Float) this.f12416j.mo22831e()).floatValue();
        RectF rectF2 = this.f12411e;
        float f = floatValue / 2.0f;
        rectF2.set(rectF2.left - f, this.f12411e.top - f, this.f12411e.right + f, this.f12411e.bottom + f);
        rectF.set(this.f12411e);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        C3665c.m15253d(str);
    }

    /* renamed from: a */
    public void mo22814a(List<C3627b> list, List<C3627b> list2) {
        C3645r rVar = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            C3627b bVar = (C3627b) list.get(size);
            if (bVar instanceof C3645r) {
                C3645r rVar2 = (C3645r) bVar;
                if (rVar2.mo22820b() == Type.Individually) {
                    rVar = rVar2;
                }
            }
        }
        if (rVar != null) {
            rVar.mo22819a(this);
        }
        C3626a aVar = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            C3627b bVar2 = (C3627b) list2.get(size2);
            if (bVar2 instanceof C3645r) {
                C3645r rVar3 = (C3645r) bVar2;
                if (rVar3.mo22820b() == Type.Individually) {
                    if (aVar != null) {
                        this.f12414h.add(aVar);
                    }
                    aVar = new C3626a(rVar3);
                    rVar3.mo22819a(this);
                }
            }
            if (bVar2 instanceof C3638l) {
                if (aVar == null) {
                    aVar = new C3626a(rVar);
                }
                aVar.f12421a.add((C3638l) bVar2);
            }
        }
        if (aVar != null) {
            this.f12414h.add(aVar);
        }
    }
}
