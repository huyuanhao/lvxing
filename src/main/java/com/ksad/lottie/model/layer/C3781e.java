package com.ksad.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.ksad.lottie.C3721f;
import com.ksad.lottie.model.content.C3769j;
import com.ksad.lottie.p298a.p299a.C3628c;
import java.util.Collections;

/* renamed from: com.ksad.lottie.model.layer.e */
public class C3781e extends C3774a {
    /* renamed from: e */
    private final C3628c f12883e;

    C3781e(C3721f fVar, Layer layer) {
        super(fVar, layer);
        this.f12883e = new C3628c(fVar, this, new C3769j("__container", layer.mo23159n()));
        this.f12883e.mo22814a(Collections.emptyList(), Collections.emptyList());
    }

    /* renamed from: a */
    public void mo22813a(RectF rectF, Matrix matrix) {
        super.mo22813a(rectF, matrix);
        this.f12883e.mo22813a(rectF, this.f12848a);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo23172b(Canvas canvas, Matrix matrix, int i) {
        this.f12883e.mo22812a(canvas, matrix, i);
    }
}
