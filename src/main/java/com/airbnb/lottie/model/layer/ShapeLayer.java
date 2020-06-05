package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.p008a.p009a.ContentGroup;
import java.util.Collections;
import java.util.List;

/* renamed from: com.airbnb.lottie.model.layer.e */
public class ShapeLayer extends BaseLayer {
    /* renamed from: e */
    private final ContentGroup f1746e;

    ShapeLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        this.f1746e = new ContentGroup(lottieDrawable, this, new ShapeGroup("__container", layer.mo10150n()));
        this.f1746e.mo9851a(Collections.emptyList(), Collections.emptyList());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo10162b(Canvas canvas, Matrix matrix, int i) {
        this.f1746e.mo9847a(canvas, matrix, i);
    }

    /* renamed from: a */
    public void mo9848a(RectF rectF, Matrix matrix) {
        super.mo9848a(rectF, matrix);
        this.f1746e.mo9848a(rectF, this.f1711a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo10163b(KeyPath eVar, int i, List<KeyPath> list, KeyPath eVar2) {
        this.f1746e.mo9849a(eVar, i, list, eVar2);
    }
}
