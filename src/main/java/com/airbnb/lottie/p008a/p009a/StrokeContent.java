package com.airbnb.lottie.p008a.p009a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.p008a.p010b.BaseKeyframeAnimation;
import com.airbnb.lottie.p008a.p010b.BaseKeyframeAnimation.C0925a;
import com.airbnb.lottie.p008a.p010b.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.p014e.LottieValueCallback;

/* renamed from: com.airbnb.lottie.a.a.q */
public class StrokeContent extends BaseStrokeContent {
    /* renamed from: b */
    private final BaseLayer f1386b;
    /* renamed from: c */
    private final String f1387c;
    /* renamed from: d */
    private final BaseKeyframeAnimation<Integer, Integer> f1388d;
    /* renamed from: e */
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> f1389e;

    public StrokeContent(LottieDrawable lottieDrawable, BaseLayer aVar, ShapeStroke shapeStroke) {
        super(lottieDrawable, aVar, shapeStroke.mo10054g().toPaintCap(), shapeStroke.mo10055h().toPaintJoin(), shapeStroke.mo10056i(), shapeStroke.mo10050c(), shapeStroke.mo10051d(), shapeStroke.mo10052e(), shapeStroke.mo10053f());
        this.f1386b = aVar;
        this.f1387c = shapeStroke.mo10048a();
        this.f1388d = shapeStroke.mo10049b().mo10017a();
        this.f1388d.mo9865a((C0925a) this);
        aVar.mo10160a(this.f1388d);
    }

    /* renamed from: a */
    public void mo9847a(Canvas canvas, Matrix matrix, int i) {
        this.f1274a.setColor(((Integer) this.f1388d.mo9870e()).intValue());
        if (this.f1389e != null) {
            this.f1274a.setColorFilter((ColorFilter) this.f1389e.mo9870e());
        }
        super.mo9847a(canvas, matrix, i);
    }

    /* renamed from: b */
    public String mo9852b() {
        return this.f1387c;
    }

    /* renamed from: a */
    public <T> void mo9850a(T t, LottieValueCallback<T> cVar) {
        super.mo9850a(t, cVar);
        if (t == LottieProperty.f1525b) {
            this.f1388d.mo9866a(cVar);
        } else if (t != LottieProperty.f1547x) {
        } else {
            if (cVar == null) {
                this.f1389e = null;
                return;
            }
            this.f1389e = new ValueCallbackKeyframeAnimation(cVar);
            this.f1389e.mo9865a((C0925a) this);
            this.f1386b.mo10160a(this.f1388d);
        }
    }
}
