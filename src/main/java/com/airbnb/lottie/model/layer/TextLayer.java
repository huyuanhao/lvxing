package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.TextDelegate;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.model.p015a.AnimatableTextProperties;
import com.airbnb.lottie.p008a.p009a.ContentGroup;
import com.airbnb.lottie.p008a.p010b.BaseKeyframeAnimation;
import com.airbnb.lottie.p008a.p010b.BaseKeyframeAnimation.C0925a;
import com.airbnb.lottie.p008a.p010b.TextKeyframeAnimation;
import com.airbnb.lottie.p013d.Utils;
import com.airbnb.lottie.p014e.LottieValueCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.airbnb.lottie.model.layer.g */
public class TextLayer extends BaseLayer {
    /* renamed from: e */
    private final char[] f1753e = new char[1];
    /* renamed from: f */
    private final RectF f1754f = new RectF();
    /* renamed from: g */
    private final Matrix f1755g = new Matrix();
    /* renamed from: h */
    private final Paint f1756h = new Paint(1) {
        {
            setStyle(Style.FILL);
        }
    };
    /* renamed from: i */
    private final Paint f1757i = new Paint(1) {
        {
            setStyle(Style.STROKE);
        }
    };
    /* renamed from: j */
    private final Map<FontCharacter, List<ContentGroup>> f1758j = new HashMap();
    /* renamed from: k */
    private final TextKeyframeAnimation f1759k;
    /* renamed from: l */
    private final LottieDrawable f1760l;
    /* renamed from: m */
    private final LottieComposition f1761m;
    /* renamed from: n */
    private BaseKeyframeAnimation<Integer, Integer> f1762n;
    /* renamed from: o */
    private BaseKeyframeAnimation<Integer, Integer> f1763o;
    /* renamed from: p */
    private BaseKeyframeAnimation<Float, Float> f1764p;
    /* renamed from: q */
    private BaseKeyframeAnimation<Float, Float> f1765q;

    TextLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        this.f1760l = lottieDrawable;
        this.f1761m = layer.mo10136a();
        this.f1759k = layer.mo10155s().mo10017a();
        this.f1759k.mo9865a((C0925a) this);
        mo10160a((BaseKeyframeAnimation<?, ?>) this.f1759k);
        AnimatableTextProperties t = layer.mo10156t();
        if (!(t == null || t.f1573a == null)) {
            this.f1762n = t.f1573a.mo10017a();
            this.f1762n.mo9865a((C0925a) this);
            mo10160a(this.f1762n);
        }
        if (!(t == null || t.f1574b == null)) {
            this.f1763o = t.f1574b.mo10017a();
            this.f1763o.mo9865a((C0925a) this);
            mo10160a(this.f1763o);
        }
        if (!(t == null || t.f1575c == null)) {
            this.f1764p = t.f1575c.mo10017a();
            this.f1764p.mo9865a((C0925a) this);
            mo10160a(this.f1764p);
        }
        if (t != null && t.f1576d != null) {
            this.f1765q = t.f1576d.mo10017a();
            this.f1765q.mo9865a((C0925a) this);
            mo10160a(this.f1765q);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo10162b(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.f1760l.mo9831p()) {
            canvas.setMatrix(matrix);
        }
        DocumentData bVar = (DocumentData) this.f1759k.mo9870e();
        Font cVar = (Font) this.f1761m.mo9926i().get(bVar.f1586b);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        BaseKeyframeAnimation<Integer, Integer> aVar = this.f1762n;
        if (aVar != null) {
            this.f1756h.setColor(((Integer) aVar.mo9870e()).intValue());
        } else {
            this.f1756h.setColor(bVar.f1592h);
        }
        BaseKeyframeAnimation<Integer, Integer> aVar2 = this.f1763o;
        if (aVar2 != null) {
            this.f1757i.setColor(((Integer) aVar2.mo9870e()).intValue());
        } else {
            this.f1757i.setColor(bVar.f1593i);
        }
        int intValue = (((Integer) this.f1714d.mo9887a().mo9870e()).intValue() * 255) / 100;
        this.f1756h.setAlpha(intValue);
        this.f1757i.setAlpha(intValue);
        BaseKeyframeAnimation<Float, Float> aVar3 = this.f1764p;
        if (aVar3 != null) {
            this.f1757i.setStrokeWidth(((Float) aVar3.mo9870e()).floatValue());
        } else {
            this.f1757i.setStrokeWidth(((float) bVar.f1594j) * Utils.m1451a() * Utils.m1452a(matrix));
        }
        if (this.f1760l.mo9831p()) {
            m1733a(bVar, matrix, cVar, canvas);
        } else {
            m1734a(bVar, cVar, matrix, canvas);
        }
        canvas.restore();
    }

    /* renamed from: a */
    private void m1733a(DocumentData bVar, Matrix matrix, Font cVar, Canvas canvas) {
        float f = ((float) bVar.f1587c) / 100.0f;
        float a = Utils.m1452a(matrix);
        String str = bVar.f1585a;
        for (int i = 0; i < str.length(); i++) {
            FontCharacter dVar = (FontCharacter) this.f1761m.mo9925h().get(FontCharacter.m1640a(str.charAt(i), cVar.mo10030a(), cVar.mo10032c()));
            if (dVar != null) {
                m1735a(dVar, matrix, f, bVar, canvas);
                float b = ((float) dVar.mo10118b()) * f * Utils.m1451a() * a;
                float f2 = ((float) bVar.f1589e) / 10.0f;
                BaseKeyframeAnimation<Float, Float> aVar = this.f1765q;
                if (aVar != null) {
                    f2 += ((Float) aVar.mo9870e()).floatValue();
                }
                canvas.translate(b + (f2 * a), 0.0f);
            }
        }
    }

    /* renamed from: a */
    private void m1734a(DocumentData bVar, Font cVar, Matrix matrix, Canvas canvas) {
        float a = Utils.m1452a(matrix);
        Typeface a2 = this.f1760l.mo9786a(cVar.mo10030a(), cVar.mo10032c());
        if (a2 != null) {
            String str = bVar.f1585a;
            TextDelegate o = this.f1760l.mo9830o();
            if (o != null) {
                str = o.mo10010a(str);
            }
            this.f1756h.setTypeface(a2);
            this.f1756h.setTextSize((float) (bVar.f1587c * ((double) Utils.m1451a())));
            this.f1757i.setTypeface(this.f1756h.getTypeface());
            this.f1757i.setTextSize(this.f1756h.getTextSize());
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                m1731a(charAt, bVar, canvas);
                char[] cArr = this.f1753e;
                cArr[0] = charAt;
                float measureText = this.f1756h.measureText(cArr, 0, 1);
                float f = ((float) bVar.f1589e) / 10.0f;
                BaseKeyframeAnimation<Float, Float> aVar = this.f1765q;
                if (aVar != null) {
                    f += ((Float) aVar.mo9870e()).floatValue();
                }
                canvas.translate(measureText + (f * a), 0.0f);
            }
        }
    }

    /* renamed from: a */
    private void m1735a(FontCharacter dVar, Matrix matrix, float f, DocumentData bVar, Canvas canvas) {
        List a = m1730a(dVar);
        for (int i = 0; i < a.size(); i++) {
            Path e = ((ContentGroup) a.get(i)).mo9855e();
            e.computeBounds(this.f1754f, false);
            this.f1755g.set(matrix);
            this.f1755g.preTranslate(0.0f, ((float) (-bVar.f1591g)) * Utils.m1451a());
            this.f1755g.preScale(f, f);
            e.transform(this.f1755g);
            if (bVar.f1595k) {
                m1732a(e, this.f1756h, canvas);
                m1732a(e, this.f1757i, canvas);
            } else {
                m1732a(e, this.f1757i, canvas);
                m1732a(e, this.f1756h, canvas);
            }
        }
    }

    /* renamed from: a */
    private void m1732a(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawPath(path, paint);
            }
        }
    }

    /* renamed from: a */
    private void m1731a(char c, DocumentData bVar, Canvas canvas) {
        this.f1753e[0] = c;
        if (bVar.f1595k) {
            m1736a(this.f1753e, this.f1756h, canvas);
            m1736a(this.f1753e, this.f1757i, canvas);
            return;
        }
        m1736a(this.f1753e, this.f1757i, canvas);
        m1736a(this.f1753e, this.f1756h, canvas);
    }

    /* renamed from: a */
    private void m1736a(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
            }
        }
    }

    /* renamed from: a */
    private List<ContentGroup> m1730a(FontCharacter dVar) {
        if (this.f1758j.containsKey(dVar)) {
            return (List) this.f1758j.get(dVar);
        }
        List a = dVar.mo10117a();
        int size = a.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new ContentGroup(this.f1760l, this, (ShapeGroup) a.get(i)));
        }
        this.f1758j.put(dVar, arrayList);
        return arrayList;
    }

    /* renamed from: a */
    public <T> void mo9850a(T t, LottieValueCallback<T> cVar) {
        super.mo9850a(t, cVar);
        if (t == LottieProperty.f1524a) {
            BaseKeyframeAnimation<Integer, Integer> aVar = this.f1762n;
            if (aVar != null) {
                aVar.mo9866a(cVar);
                return;
            }
        }
        if (t == LottieProperty.f1525b) {
            BaseKeyframeAnimation<Integer, Integer> aVar2 = this.f1763o;
            if (aVar2 != null) {
                aVar2.mo9866a(cVar);
                return;
            }
        }
        if (t == LottieProperty.f1534k) {
            BaseKeyframeAnimation<Float, Float> aVar3 = this.f1764p;
            if (aVar3 != null) {
                aVar3.mo9866a(cVar);
                return;
            }
        }
        if (t == LottieProperty.f1535l) {
            BaseKeyframeAnimation<Float, Float> aVar4 = this.f1765q;
            if (aVar4 != null) {
                aVar4.mo9866a(cVar);
            }
        }
    }
}
