package com.ksad.lottie.p298a.p299a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import com.ksad.lottie.C3721f;
import com.ksad.lottie.model.content.ShapeStroke;
import com.ksad.lottie.model.layer.C3774a;
import com.ksad.lottie.p298a.p300b.C3646a;
import com.ksad.lottie.p298a.p300b.C3646a.C3647a;

/* renamed from: com.ksad.lottie.a.a.q */
public class C3644q extends C3624a {
    /* renamed from: b */
    private final C3774a f12519b;
    /* renamed from: c */
    private final String f12520c;
    /* renamed from: d */
    private final C3646a<Integer, Integer> f12521d;
    /* renamed from: e */
    private C3646a<ColorFilter, ColorFilter> f12522e;

    public C3644q(C3721f fVar, C3774a aVar, ShapeStroke shapeStroke) {
        super(fVar, aVar, shapeStroke.mo23073g().toPaintCap(), shapeStroke.mo23074h().toPaintJoin(), shapeStroke.mo23075i(), shapeStroke.mo23069c(), shapeStroke.mo23070d(), shapeStroke.mo23071e(), shapeStroke.mo23072f());
        this.f12519b = aVar;
        this.f12520c = shapeStroke.mo23067a();
        this.f12521d = shapeStroke.mo23068b().mo23036a();
        this.f12521d.mo22827a((C3647a) this);
        aVar.mo23169a(this.f12521d);
    }

    /* renamed from: a */
    public void mo22812a(Canvas canvas, Matrix matrix, int i) {
        this.f12407a.setColor(((Integer) this.f12521d.mo22831e()).intValue());
        if (this.f12522e != null) {
            this.f12407a.setColorFilter((ColorFilter) this.f12522e.mo22831e());
        }
        super.mo22812a(canvas, matrix, i);
    }
}
