package com.ksad.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import com.ksad.lottie.C3703d;
import com.ksad.lottie.C3721f;
import com.ksad.lottie.C3741m;
import com.ksad.lottie.model.C3757b;
import com.ksad.lottie.model.C3758c;
import com.ksad.lottie.model.C3771d;
import com.ksad.lottie.model.content.C3769j;
import com.ksad.lottie.model.p305a.C3753k;
import com.ksad.lottie.p298a.p299a.C3628c;
import com.ksad.lottie.p298a.p300b.C3646a;
import com.ksad.lottie.p298a.p300b.C3646a.C3647a;
import com.ksad.lottie.p298a.p300b.C3660n;
import com.ksad.lottie.p303d.C3709f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.ksad.lottie.model.layer.g */
public class C3783g extends C3774a {
    /* renamed from: e */
    private final char[] f12890e = new char[1];
    /* renamed from: f */
    private final RectF f12891f = new RectF();
    /* renamed from: g */
    private final Matrix f12892g = new Matrix();
    /* renamed from: h */
    private final Paint f12893h = new Paint(1) {
        {
            setStyle(Style.FILL);
        }
    };
    /* renamed from: i */
    private final Paint f12894i = new Paint(1) {
        {
            setStyle(Style.STROKE);
        }
    };
    /* renamed from: j */
    private final Map<C3771d, List<C3628c>> f12895j = new HashMap();
    /* renamed from: k */
    private final C3660n f12896k;
    /* renamed from: l */
    private final C3721f f12897l;
    /* renamed from: m */
    private final C3703d f12898m;
    /* renamed from: n */
    private C3646a<Integer, Integer> f12899n;
    /* renamed from: o */
    private C3646a<Integer, Integer> f12900o;
    /* renamed from: p */
    private C3646a<Float, Float> f12901p;
    /* renamed from: q */
    private C3646a<Float, Float> f12902q;

    C3783g(C3721f fVar, Layer layer) {
        super(fVar, layer);
        this.f12897l = fVar;
        this.f12898m = layer.mo23145a();
        this.f12896k = layer.mo23164s().mo23036a();
        this.f12896k.mo22827a((C3647a) this);
        mo23169a((C3646a<?, ?>) this.f12896k);
        C3753k t = layer.mo23165t();
        if (!(t == null || t.f12712a == null)) {
            this.f12899n = t.f12712a.mo23036a();
            this.f12899n.mo22827a((C3647a) this);
            mo23169a(this.f12899n);
        }
        if (!(t == null || t.f12713b == null)) {
            this.f12900o = t.f12713b.mo23036a();
            this.f12900o.mo22827a((C3647a) this);
            mo23169a(this.f12900o);
        }
        if (!(t == null || t.f12714c == null)) {
            this.f12901p = t.f12714c.mo23036a();
            this.f12901p.mo22827a((C3647a) this);
            mo23169a(this.f12901p);
        }
        if (t != null && t.f12715d != null) {
            this.f12902q = t.f12715d.mo23036a();
            this.f12902q.mo22827a((C3647a) this);
            mo23169a(this.f12902q);
        }
    }

    /* renamed from: a */
    private List<C3628c> m15702a(C3771d dVar) {
        if (this.f12895j.containsKey(dVar)) {
            return (List) this.f12895j.get(dVar);
        }
        List a = dVar.mo23136a();
        int size = a.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new C3628c(this.f12897l, this, (C3769j) a.get(i)));
        }
        this.f12895j.put(dVar, arrayList);
        return arrayList;
    }

    /* renamed from: a */
    private void m15703a(char c, C3757b bVar, Canvas canvas) {
        this.f12890e[0] = c;
        if (bVar.f12734k) {
            m15708a(this.f12890e, this.f12893h, canvas);
            m15708a(this.f12890e, this.f12894i, canvas);
            return;
        }
        m15708a(this.f12890e, this.f12894i, canvas);
        m15708a(this.f12890e, this.f12893h, canvas);
    }

    /* renamed from: a */
    private void m15704a(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawPath(path, paint);
            }
        }
    }

    /* renamed from: a */
    private void m15705a(C3757b bVar, Matrix matrix, C3758c cVar, Canvas canvas) {
        float f = ((float) bVar.f12726c) / 100.0f;
        float a = C3709f.m15388a(matrix);
        String str = bVar.f12724a;
        for (int i = 0; i < str.length(); i++) {
            C3771d dVar = (C3771d) this.f12898m.mo22885h().get(C3771d.m15634a(str.charAt(i), cVar.mo23049a(), cVar.mo23051c()));
            if (dVar != null) {
                m15707a(dVar, matrix, f, bVar, canvas);
                float b = ((float) dVar.mo23137b()) * f * C3709f.m15387a() * a;
                float f2 = ((float) bVar.f12728e) / 10.0f;
                C3646a<Float, Float> aVar = this.f12902q;
                if (aVar != null) {
                    f2 += ((Float) aVar.mo22831e()).floatValue();
                }
                canvas.translate(b + (f2 * a), 0.0f);
            }
        }
    }

    /* renamed from: a */
    private void m15706a(C3757b bVar, C3758c cVar, Matrix matrix, Canvas canvas) {
        float a = C3709f.m15388a(matrix);
        Typeface a2 = this.f12897l.mo22952a(cVar.mo23049a(), cVar.mo23051c());
        if (a2 != null) {
            String str = bVar.f12724a;
            C3741m o = this.f12897l.mo22995o();
            if (o != null) {
                str = o.mo23029a(str);
            }
            this.f12893h.setTypeface(a2);
            this.f12893h.setTextSize((float) (bVar.f12726c * ((double) C3709f.m15387a())));
            this.f12894i.setTypeface(this.f12893h.getTypeface());
            this.f12894i.setTextSize(this.f12893h.getTextSize());
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                m15703a(charAt, bVar, canvas);
                char[] cArr = this.f12890e;
                cArr[0] = charAt;
                float measureText = this.f12893h.measureText(cArr, 0, 1);
                float f = ((float) bVar.f12728e) / 10.0f;
                C3646a<Float, Float> aVar = this.f12902q;
                if (aVar != null) {
                    f += ((Float) aVar.mo22831e()).floatValue();
                }
                canvas.translate(measureText + (f * a), 0.0f);
            }
        }
    }

    /* renamed from: a */
    private void m15707a(C3771d dVar, Matrix matrix, float f, C3757b bVar, Canvas canvas) {
        Paint paint;
        List a = m15702a(dVar);
        for (int i = 0; i < a.size(); i++) {
            Path d = ((C3628c) a.get(i)).mo22817d();
            d.computeBounds(this.f12891f, false);
            this.f12892g.set(matrix);
            this.f12892g.preTranslate(0.0f, ((float) (-bVar.f12730g)) * C3709f.m15387a());
            this.f12892g.preScale(f, f);
            d.transform(this.f12892g);
            if (bVar.f12734k) {
                m15704a(d, this.f12893h, canvas);
                paint = this.f12894i;
            } else {
                m15704a(d, this.f12894i, canvas);
                paint = this.f12893h;
            }
            m15704a(d, paint, canvas);
        }
    }

    /* renamed from: a */
    private void m15708a(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo23172b(Canvas canvas, Matrix matrix, int i) {
        Paint paint;
        float f;
        canvas.save();
        if (!this.f12897l.mo22996p()) {
            canvas.setMatrix(matrix);
        }
        C3757b bVar = (C3757b) this.f12896k.mo22831e();
        C3758c cVar = (C3758c) this.f12898m.mo22886i().get(bVar.f12725b);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        C3646a<Integer, Integer> aVar = this.f12899n;
        if (aVar != null) {
            this.f12893h.setColor(((Integer) aVar.mo22831e()).intValue());
        } else {
            this.f12893h.setColor(bVar.f12731h);
        }
        C3646a<Integer, Integer> aVar2 = this.f12900o;
        if (aVar2 != null) {
            this.f12894i.setColor(((Integer) aVar2.mo22831e()).intValue());
        } else {
            this.f12894i.setColor(bVar.f12732i);
        }
        int intValue = (((Integer) this.f12851d.mo22848a().mo22831e()).intValue() * 255) / 100;
        this.f12893h.setAlpha(intValue);
        this.f12894i.setAlpha(intValue);
        C3646a<Float, Float> aVar3 = this.f12901p;
        if (aVar3 != null) {
            paint = this.f12894i;
            f = ((Float) aVar3.mo22831e()).floatValue();
        } else {
            float a = C3709f.m15388a(matrix);
            paint = this.f12894i;
            f = (float) (bVar.f12733j * ((double) C3709f.m15387a()) * ((double) a));
        }
        paint.setStrokeWidth(f);
        if (this.f12897l.mo22996p()) {
            m15705a(bVar, matrix, cVar, canvas);
        } else {
            m15706a(bVar, cVar, matrix, canvas);
        }
        canvas.restore();
    }
}
