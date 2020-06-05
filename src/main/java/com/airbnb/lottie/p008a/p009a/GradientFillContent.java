package com.airbnb.lottie.p008a.p009a;

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
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.model.content.GradientFill;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.p008a.p010b.BaseKeyframeAnimation;
import com.airbnb.lottie.p008a.p010b.BaseKeyframeAnimation.C0925a;
import com.airbnb.lottie.p008a.p010b.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.p013d.MiscUtils;
import com.airbnb.lottie.p014e.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.airbnb.lottie.a.a.g */
public class GradientFillContent implements DrawingContent, KeyPathElementContent, C0925a {
    /* renamed from: a */
    private final String f1315a;
    /* renamed from: b */
    private final BaseLayer f1316b;
    /* renamed from: c */
    private final LongSparseArray<LinearGradient> f1317c = new LongSparseArray<>();
    /* renamed from: d */
    private final LongSparseArray<RadialGradient> f1318d = new LongSparseArray<>();
    /* renamed from: e */
    private final Matrix f1319e = new Matrix();
    /* renamed from: f */
    private final Path f1320f = new Path();
    /* renamed from: g */
    private final Paint f1321g = new Paint(1);
    /* renamed from: h */
    private final RectF f1322h = new RectF();
    /* renamed from: i */
    private final List<PathContent> f1323i = new ArrayList();
    /* renamed from: j */
    private final GradientType f1324j;
    /* renamed from: k */
    private final BaseKeyframeAnimation<GradientColor, GradientColor> f1325k;
    /* renamed from: l */
    private final BaseKeyframeAnimation<Integer, Integer> f1326l;
    /* renamed from: m */
    private final BaseKeyframeAnimation<PointF, PointF> f1327m;
    /* renamed from: n */
    private final BaseKeyframeAnimation<PointF, PointF> f1328n;
    /* renamed from: o */
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> f1329o;
    /* renamed from: p */
    private final LottieDrawable f1330p;
    /* renamed from: q */
    private final int f1331q;

    public GradientFillContent(LottieDrawable lottieDrawable, BaseLayer aVar, GradientFill dVar) {
        this.f1316b = aVar;
        this.f1315a = dVar.mo10073a();
        this.f1330p = lottieDrawable;
        this.f1324j = dVar.mo10074b();
        this.f1320f.setFillType(dVar.mo10075c());
        this.f1331q = (int) (lottieDrawable.mo9833r().mo9920c() / 32.0f);
        this.f1325k = dVar.mo10076d().mo10017a();
        this.f1325k.mo9865a((C0925a) this);
        aVar.mo10160a(this.f1325k);
        this.f1326l = dVar.mo10077e().mo10017a();
        this.f1326l.mo9865a((C0925a) this);
        aVar.mo10160a(this.f1326l);
        this.f1327m = dVar.mo10078f().mo10017a();
        this.f1327m.mo9865a((C0925a) this);
        aVar.mo10160a(this.f1327m);
        this.f1328n = dVar.mo10079g().mo10017a();
        this.f1328n.mo9865a((C0925a) this);
        aVar.mo10160a(this.f1328n);
    }

    /* renamed from: a */
    public void mo9846a() {
        this.f1330p.invalidateSelf();
    }

    /* renamed from: a */
    public void mo9851a(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list2.size(); i++) {
            Content bVar = (Content) list2.get(i);
            if (bVar instanceof PathContent) {
                this.f1323i.add((PathContent) bVar);
            }
        }
    }

    /* renamed from: a */
    public void mo9847a(Canvas canvas, Matrix matrix, int i) {
        Shader shader;
        String str = "GradientFillContent#draw";
        L.m1315c(str);
        this.f1320f.reset();
        for (int i2 = 0; i2 < this.f1323i.size(); i2++) {
            this.f1320f.addPath(((PathContent) this.f1323i.get(i2)).mo9855e(), matrix);
        }
        this.f1320f.computeBounds(this.f1322h, false);
        if (this.f1324j == GradientType.Linear) {
            shader = m1185c();
        } else {
            shader = m1186d();
        }
        this.f1319e.set(matrix);
        shader.setLocalMatrix(this.f1319e);
        this.f1321g.setShader(shader);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> aVar = this.f1329o;
        if (aVar != null) {
            this.f1321g.setColorFilter((ColorFilter) aVar.mo9870e());
        }
        this.f1321g.setAlpha(MiscUtils.m1444a((int) ((((((float) i) / 255.0f) * ((float) ((Integer) this.f1326l.mo9870e()).intValue())) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.f1320f, this.f1321g);
        L.m1316d(str);
    }

    /* renamed from: a */
    public void mo9848a(RectF rectF, Matrix matrix) {
        this.f1320f.reset();
        for (int i = 0; i < this.f1323i.size(); i++) {
            this.f1320f.addPath(((PathContent) this.f1323i.get(i)).mo9855e(), matrix);
        }
        this.f1320f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    /* renamed from: b */
    public String mo9852b() {
        return this.f1315a;
    }

    /* renamed from: c */
    private LinearGradient m1185c() {
        long e = (long) m1187e();
        LinearGradient linearGradient = (LinearGradient) this.f1317c.get(e);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointF = (PointF) this.f1327m.mo9870e();
        PointF pointF2 = (PointF) this.f1328n.mo9870e();
        GradientColor cVar = (GradientColor) this.f1325k.mo9870e();
        LinearGradient linearGradient2 = new LinearGradient(pointF.x, pointF.y, pointF2.x, pointF2.y, cVar.mo10071b(), cVar.mo10070a(), TileMode.CLAMP);
        this.f1317c.put(e, linearGradient2);
        return linearGradient2;
    }

    /* renamed from: d */
    private RadialGradient m1186d() {
        long e = (long) m1187e();
        RadialGradient radialGradient = (RadialGradient) this.f1318d.get(e);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointF = (PointF) this.f1327m.mo9870e();
        PointF pointF2 = (PointF) this.f1328n.mo9870e();
        GradientColor cVar = (GradientColor) this.f1325k.mo9870e();
        int[] b = cVar.mo10071b();
        float[] a = cVar.mo10070a();
        float f = pointF.x;
        float f2 = pointF.y;
        RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot((double) (pointF2.x - f), (double) (pointF2.y - f2)), b, a, TileMode.CLAMP);
        this.f1318d.put(e, radialGradient2);
        return radialGradient2;
    }

    /* renamed from: e */
    private int m1187e() {
        int round = Math.round(this.f1327m.mo9871f() * ((float) this.f1331q));
        int round2 = Math.round(this.f1328n.mo9871f() * ((float) this.f1331q));
        int round3 = Math.round(this.f1325k.mo9871f() * ((float) this.f1331q));
        int i = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i = i * 31 * round2;
        }
        return round3 != 0 ? i * 31 * round3 : i;
    }

    /* renamed from: a */
    public void mo9849a(KeyPath eVar, int i, List<KeyPath> list, KeyPath eVar2) {
        MiscUtils.m1447a(eVar, i, list, eVar2, this);
    }

    /* renamed from: a */
    public <T> void mo9850a(T t, LottieValueCallback<T> cVar) {
        if (t != LottieProperty.f1547x) {
            return;
        }
        if (cVar == null) {
            this.f1329o = null;
            return;
        }
        this.f1329o = new ValueCallbackKeyframeAnimation(cVar);
        this.f1329o.mo9865a((C0925a) this);
        this.f1316b.mo10160a(this.f1329o);
    }
}
