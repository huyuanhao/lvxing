package com.airbnb.lottie.p008a.p009a;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.model.content.GradientStroke;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.p008a.p010b.BaseKeyframeAnimation;
import com.airbnb.lottie.p008a.p010b.BaseKeyframeAnimation.C0925a;

/* renamed from: com.airbnb.lottie.a.a.h */
public class GradientStrokeContent extends BaseStrokeContent {
    /* renamed from: b */
    private final String f1332b;
    /* renamed from: c */
    private final LongSparseArray<LinearGradient> f1333c = new LongSparseArray<>();
    /* renamed from: d */
    private final LongSparseArray<RadialGradient> f1334d = new LongSparseArray<>();
    /* renamed from: e */
    private final RectF f1335e = new RectF();
    /* renamed from: f */
    private final GradientType f1336f;
    /* renamed from: g */
    private final int f1337g;
    /* renamed from: h */
    private final BaseKeyframeAnimation<GradientColor, GradientColor> f1338h;
    /* renamed from: i */
    private final BaseKeyframeAnimation<PointF, PointF> f1339i;
    /* renamed from: j */
    private final BaseKeyframeAnimation<PointF, PointF> f1340j;

    public GradientStrokeContent(LottieDrawable lottieDrawable, BaseLayer aVar, GradientStroke eVar) {
        super(lottieDrawable, aVar, eVar.mo10087h().toPaintCap(), eVar.mo10088i().toPaintJoin(), eVar.mo10091l(), eVar.mo10083d(), eVar.mo10086g(), eVar.mo10089j(), eVar.mo10090k());
        this.f1332b = eVar.mo10080a();
        this.f1336f = eVar.mo10081b();
        this.f1337g = (int) (lottieDrawable.mo9833r().mo9920c() / 32.0f);
        this.f1338h = eVar.mo10082c().mo10017a();
        this.f1338h.mo9865a((C0925a) this);
        aVar.mo10160a(this.f1338h);
        this.f1339i = eVar.mo10084e().mo10017a();
        this.f1339i.mo9865a((C0925a) this);
        aVar.mo10160a(this.f1339i);
        this.f1340j = eVar.mo10085f().mo10017a();
        this.f1340j.mo9865a((C0925a) this);
        aVar.mo10160a(this.f1340j);
    }

    /* renamed from: a */
    public void mo9847a(Canvas canvas, Matrix matrix, int i) {
        mo9848a(this.f1335e, matrix);
        if (this.f1336f == GradientType.Linear) {
            this.f1274a.setShader(m1195c());
        } else {
            this.f1274a.setShader(m1196d());
        }
        super.mo9847a(canvas, matrix, i);
    }

    /* renamed from: b */
    public String mo9852b() {
        return this.f1332b;
    }

    /* renamed from: c */
    private LinearGradient m1195c() {
        long e = (long) m1197e();
        LinearGradient linearGradient = (LinearGradient) this.f1333c.get(e);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointF = (PointF) this.f1339i.mo9870e();
        PointF pointF2 = (PointF) this.f1340j.mo9870e();
        GradientColor cVar = (GradientColor) this.f1338h.mo9870e();
        LinearGradient linearGradient2 = new LinearGradient((float) ((int) (this.f1335e.left + (this.f1335e.width() / 2.0f) + pointF.x)), (float) ((int) (this.f1335e.top + (this.f1335e.height() / 2.0f) + pointF.y)), (float) ((int) (this.f1335e.left + (this.f1335e.width() / 2.0f) + pointF2.x)), (float) ((int) (this.f1335e.top + (this.f1335e.height() / 2.0f) + pointF2.y)), cVar.mo10071b(), cVar.mo10070a(), TileMode.CLAMP);
        this.f1333c.put(e, linearGradient2);
        return linearGradient2;
    }

    /* renamed from: d */
    private RadialGradient m1196d() {
        long e = (long) m1197e();
        RadialGradient radialGradient = (RadialGradient) this.f1334d.get(e);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointF = (PointF) this.f1339i.mo9870e();
        PointF pointF2 = (PointF) this.f1340j.mo9870e();
        GradientColor cVar = (GradientColor) this.f1338h.mo9870e();
        int[] b = cVar.mo10071b();
        float[] a = cVar.mo10070a();
        int width = (int) (this.f1335e.left + (this.f1335e.width() / 2.0f) + pointF.x);
        int height = (int) (this.f1335e.top + (this.f1335e.height() / 2.0f) + pointF.y);
        float f = (float) width;
        float f2 = (float) height;
        RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot((double) (((int) ((this.f1335e.left + (this.f1335e.width() / 2.0f)) + pointF2.x)) - width), (double) (((int) ((this.f1335e.top + (this.f1335e.height() / 2.0f)) + pointF2.y)) - height)), b, a, TileMode.CLAMP);
        this.f1334d.put(e, radialGradient2);
        return radialGradient2;
    }

    /* renamed from: e */
    private int m1197e() {
        int round = Math.round(this.f1339i.mo9871f() * ((float) this.f1337g));
        int round2 = Math.round(this.f1340j.mo9871f() * ((float) this.f1337g));
        int round3 = Math.round(this.f1338h.mo9871f() * ((float) this.f1337g));
        int i = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i = i * 31 * round2;
        }
        return round3 != 0 ? i * 31 * round3 : i;
    }
}
