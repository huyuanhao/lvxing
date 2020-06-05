package com.ksad.lottie.p298a.p299a;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import androidx.collection.LongSparseArray;
import com.ksad.lottie.C3721f;
import com.ksad.lottie.model.content.C3762c;
import com.ksad.lottie.model.content.C3764e;
import com.ksad.lottie.model.content.GradientType;
import com.ksad.lottie.model.layer.C3774a;
import com.ksad.lottie.p298a.p300b.C3646a;
import com.ksad.lottie.p298a.p300b.C3646a.C3647a;

/* renamed from: com.ksad.lottie.a.a.h */
public class C3633h extends C3624a {
    /* renamed from: b */
    private final String f12465b;
    /* renamed from: c */
    private final LongSparseArray<LinearGradient> f12466c = new LongSparseArray<>();
    /* renamed from: d */
    private final LongSparseArray<RadialGradient> f12467d = new LongSparseArray<>();
    /* renamed from: e */
    private final RectF f12468e = new RectF();
    /* renamed from: f */
    private final GradientType f12469f;
    /* renamed from: g */
    private final int f12470g;
    /* renamed from: h */
    private final C3646a<C3762c, C3762c> f12471h;
    /* renamed from: i */
    private final C3646a<PointF, PointF> f12472i;
    /* renamed from: j */
    private final C3646a<PointF, PointF> f12473j;

    public C3633h(C3721f fVar, C3774a aVar, C3764e eVar) {
        super(fVar, aVar, eVar.mo23106h().toPaintCap(), eVar.mo23107i().toPaintJoin(), eVar.mo23110l(), eVar.mo23102d(), eVar.mo23105g(), eVar.mo23108j(), eVar.mo23109k());
        this.f12465b = eVar.mo23099a();
        this.f12469f = eVar.mo23100b();
        this.f12470g = (int) (fVar.mo22998r().mo22880c() / 32.0f);
        this.f12471h = eVar.mo23101c().mo23036a();
        this.f12471h.mo22827a((C3647a) this);
        aVar.mo23169a(this.f12471h);
        this.f12472i = eVar.mo23103e().mo23036a();
        this.f12472i.mo22827a((C3647a) this);
        aVar.mo23169a(this.f12472i);
        this.f12473j = eVar.mo23104f().mo23036a();
        this.f12473j.mo22827a((C3647a) this);
        aVar.mo23169a(this.f12473j);
    }

    /* renamed from: b */
    private LinearGradient m15153b() {
        long d = (long) m15155d();
        LinearGradient linearGradient = (LinearGradient) this.f12466c.get(d);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointF = (PointF) this.f12472i.mo22831e();
        PointF pointF2 = (PointF) this.f12473j.mo22831e();
        C3762c cVar = (C3762c) this.f12471h.mo22831e();
        LinearGradient linearGradient2 = new LinearGradient((float) ((int) (this.f12468e.left + (this.f12468e.width() / 2.0f) + pointF.x)), (float) ((int) (this.f12468e.top + (this.f12468e.height() / 2.0f) + pointF.y)), (float) ((int) (this.f12468e.left + (this.f12468e.width() / 2.0f) + pointF2.x)), (float) ((int) (this.f12468e.top + (this.f12468e.height() / 2.0f) + pointF2.y)), cVar.mo23090b(), cVar.mo23089a(), TileMode.CLAMP);
        this.f12466c.put(d, linearGradient2);
        return linearGradient2;
    }

    /* renamed from: c */
    private RadialGradient m15154c() {
        long d = (long) m15155d();
        RadialGradient radialGradient = (RadialGradient) this.f12467d.get(d);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointF = (PointF) this.f12472i.mo22831e();
        PointF pointF2 = (PointF) this.f12473j.mo22831e();
        C3762c cVar = (C3762c) this.f12471h.mo22831e();
        int[] b = cVar.mo23090b();
        float[] a = cVar.mo23089a();
        int width = (int) (this.f12468e.left + (this.f12468e.width() / 2.0f) + pointF.x);
        int height = (int) (this.f12468e.top + (this.f12468e.height() / 2.0f) + pointF.y);
        float f = (float) width;
        float f2 = (float) height;
        RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot((double) (((int) ((this.f12468e.left + (this.f12468e.width() / 2.0f)) + pointF2.x)) - width), (double) (((int) ((this.f12468e.top + (this.f12468e.height() / 2.0f)) + pointF2.y)) - height)), b, a, TileMode.CLAMP);
        this.f12467d.put(d, radialGradient2);
        return radialGradient2;
    }

    /* renamed from: d */
    private int m15155d() {
        int round = Math.round(this.f12472i.mo22832f() * ((float) this.f12470g));
        int round2 = Math.round(this.f12473j.mo22832f() * ((float) this.f12470g));
        int round3 = Math.round(this.f12471h.mo22832f() * ((float) this.f12470g));
        int i = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i = i * 31 * round2;
        }
        return round3 != 0 ? i * 31 * round3 : i;
    }

    /* renamed from: a */
    public void mo22812a(Canvas canvas, Matrix matrix, int i) {
        Shader shader;
        Paint paint;
        mo22813a(this.f12468e, matrix);
        if (this.f12469f == GradientType.Linear) {
            paint = this.f12407a;
            shader = m15153b();
        } else {
            paint = this.f12407a;
            shader = m15154c();
        }
        paint.setShader(shader);
        super.mo22812a(canvas, matrix, i);
    }
}
