package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;

/* renamed from: com.airbnb.lottie.model.layer.d */
public class NullLayer extends BaseLayer {
    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo10162b(Canvas canvas, Matrix matrix, int i) {
    }

    NullLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
    }

    /* renamed from: a */
    public void mo9848a(RectF rectF, Matrix matrix) {
        super.mo9848a(rectF, matrix);
        rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
    }
}
