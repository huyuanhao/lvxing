package com.ksad.lottie.p298a.p299a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import androidx.collection.LongSparseArray;
import com.ksad.lottie.C3665c;
import com.ksad.lottie.C3721f;
import com.ksad.lottie.model.content.C3762c;
import com.ksad.lottie.model.content.C3763d;
import com.ksad.lottie.model.content.GradientType;
import com.ksad.lottie.model.layer.C3774a;
import com.ksad.lottie.p298a.p300b.C3646a;
import com.ksad.lottie.p298a.p300b.C3646a.C3647a;
import com.ksad.lottie.p303d.C3708e;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.ksad.lottie.a.a.g */
public class C3632g implements C3629d, C3635j, C3647a {
    /* renamed from: a */
    private final String f12448a;
    /* renamed from: b */
    private final C3774a f12449b;
    /* renamed from: c */
    private final LongSparseArray<LinearGradient> f12450c = new LongSparseArray<>();
    /* renamed from: d */
    private final LongSparseArray<RadialGradient> f12451d = new LongSparseArray<>();
    /* renamed from: e */
    private final Matrix f12452e = new Matrix();
    /* renamed from: f */
    private final Path f12453f = new Path();
    /* renamed from: g */
    private final Paint f12454g = new Paint(1);
    /* renamed from: h */
    private final RectF f12455h = new RectF();
    /* renamed from: i */
    private final List<C3638l> f12456i = new ArrayList();
    /* renamed from: j */
    private final GradientType f12457j;
    /* renamed from: k */
    private final C3646a<C3762c, C3762c> f12458k;
    /* renamed from: l */
    private final C3646a<Integer, Integer> f12459l;
    /* renamed from: m */
    private final C3646a<PointF, PointF> f12460m;
    /* renamed from: n */
    private final C3646a<PointF, PointF> f12461n;
    /* renamed from: o */
    private C3646a<ColorFilter, ColorFilter> f12462o;
    /* renamed from: p */
    private final C3721f f12463p;
    /* renamed from: q */
    private final int f12464q;

    public C3632g(C3721f fVar, C3774a aVar, C3763d dVar) {
        this.f12449b = aVar;
        this.f12448a = dVar.mo23092a();
        this.f12463p = fVar;
        this.f12457j = dVar.mo23093b();
        this.f12453f.setFillType(dVar.mo23094c());
        this.f12464q = (int) (fVar.mo22998r().mo22880c() / 32.0f);
        this.f12458k = dVar.mo23095d().mo23036a();
        this.f12458k.mo22827a((C3647a) this);
        aVar.mo23169a(this.f12458k);
        this.f12459l = dVar.mo23096e().mo23036a();
        this.f12459l.mo22827a((C3647a) this);
        aVar.mo23169a(this.f12459l);
        this.f12460m = dVar.mo23097f().mo23036a();
        this.f12460m.mo22827a((C3647a) this);
        aVar.mo23169a(this.f12460m);
        this.f12461n = dVar.mo23098g().mo23036a();
        this.f12461n.mo22827a((C3647a) this);
        aVar.mo23169a(this.f12461n);
    }

    /* renamed from: b */
    private LinearGradient m15146b() {
        long d = (long) m15148d();
        LinearGradient linearGradient = (LinearGradient) this.f12450c.get(d);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointF = (PointF) this.f12460m.mo22831e();
        PointF pointF2 = (PointF) this.f12461n.mo22831e();
        C3762c cVar = (C3762c) this.f12458k.mo22831e();
        LinearGradient linearGradient2 = new LinearGradient(pointF.x, pointF.y, pointF2.x, pointF2.y, cVar.mo23090b(), cVar.mo23089a(), TileMode.CLAMP);
        this.f12450c.put(d, linearGradient2);
        return linearGradient2;
    }

    /* renamed from: c */
    private RadialGradient m15147c() {
        long d = (long) m15148d();
        RadialGradient radialGradient = (RadialGradient) this.f12451d.get(d);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointF = (PointF) this.f12460m.mo22831e();
        PointF pointF2 = (PointF) this.f12461n.mo22831e();
        C3762c cVar = (C3762c) this.f12458k.mo22831e();
        int[] b = cVar.mo23090b();
        float[] a = cVar.mo23089a();
        float f = pointF.x;
        float f2 = pointF.y;
        RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot((double) (pointF2.x - f), (double) (pointF2.y - f2)), b, a, TileMode.CLAMP);
        this.f12451d.put(d, radialGradient2);
        return radialGradient2;
    }

    /* renamed from: d */
    private int m15148d() {
        int round = Math.round(this.f12460m.mo22832f() * ((float) this.f12464q));
        int round2 = Math.round(this.f12461n.mo22832f() * ((float) this.f12464q));
        int round3 = Math.round(this.f12458k.mo22832f() * ((float) this.f12464q));
        int i = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i = i * 31 * round2;
        }
        return round3 != 0 ? i * 31 * round3 : i;
    }

    /* renamed from: a */
    public void mo22811a() {
        this.f12463p.invalidateSelf();
    }

    /* renamed from: a */
    public void mo22812a(Canvas canvas, Matrix matrix, int i) {
        String str = "GradientFillContent#draw";
        C3665c.m15252c(str);
        this.f12453f.reset();
        for (int i2 = 0; i2 < this.f12456i.size(); i2++) {
            this.f12453f.addPath(((C3638l) this.f12456i.get(i2)).mo22817d(), matrix);
        }
        this.f12453f.computeBounds(this.f12455h, false);
        Shader b = this.f12457j == GradientType.Linear ? m15146b() : m15147c();
        this.f12452e.set(matrix);
        b.setLocalMatrix(this.f12452e);
        this.f12454g.setShader(b);
        C3646a<ColorFilter, ColorFilter> aVar = this.f12462o;
        if (aVar != null) {
            this.f12454g.setColorFilter((ColorFilter) aVar.mo22831e());
        }
        this.f12454g.setAlpha(C3708e.m15381a((int) ((((((float) i) / 255.0f) * ((float) ((Integer) this.f12459l.mo22831e()).intValue())) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.f12453f, this.f12454g);
        C3665c.m15253d(str);
    }

    /* renamed from: a */
    public void mo22813a(RectF rectF, Matrix matrix) {
        this.f12453f.reset();
        for (int i = 0; i < this.f12456i.size(); i++) {
            this.f12453f.addPath(((C3638l) this.f12456i.get(i)).mo22817d(), matrix);
        }
        this.f12453f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    /* renamed from: a */
    public void mo22814a(List<C3627b> list, List<C3627b> list2) {
        for (int i = 0; i < list2.size(); i++) {
            C3627b bVar = (C3627b) list2.get(i);
            if (bVar instanceof C3638l) {
                this.f12456i.add((C3638l) bVar);
            }
        }
    }
}
