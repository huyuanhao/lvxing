package com.airbnb.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.p008a.p010b.BaseKeyframeAnimation;
import com.airbnb.lottie.p008a.p010b.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.p013d.Utils;
import com.airbnb.lottie.p014e.LottieValueCallback;

/* renamed from: com.airbnb.lottie.model.layer.c */
public class ImageLayer extends BaseLayer {
    /* renamed from: e */
    private final Paint f1742e = new Paint(3);
    /* renamed from: f */
    private final Rect f1743f = new Rect();
    /* renamed from: g */
    private final Rect f1744g = new Rect();
    /* renamed from: h */
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> f1745h;

    ImageLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
    }

    /* renamed from: b */
    public void mo10162b(Canvas canvas, Matrix matrix, int i) {
        Bitmap f = m1718f();
        if (f != null && !f.isRecycled()) {
            float a = Utils.m1451a();
            this.f1742e.setAlpha(i);
            BaseKeyframeAnimation<ColorFilter, ColorFilter> aVar = this.f1745h;
            if (aVar != null) {
                this.f1742e.setColorFilter((ColorFilter) aVar.mo9870e());
            }
            canvas.save();
            canvas.concat(matrix);
            this.f1743f.set(0, 0, f.getWidth(), f.getHeight());
            this.f1744g.set(0, 0, (int) (((float) f.getWidth()) * a), (int) (((float) f.getHeight()) * a));
            canvas.drawBitmap(f, this.f1743f, this.f1744g, this.f1742e);
            canvas.restore();
        }
    }

    /* renamed from: a */
    public void mo9848a(RectF rectF, Matrix matrix) {
        super.mo9848a(rectF, matrix);
        Bitmap f = m1718f();
        if (f != null) {
            rectF.set(rectF.left, rectF.top, Math.min(rectF.right, (float) f.getWidth()), Math.min(rectF.bottom, (float) f.getHeight()));
            this.f1711a.mapRect(rectF);
        }
    }

    /* renamed from: f */
    private Bitmap m1718f() {
        return this.f1712b.mo9799b(this.f1713c.mo10143g());
    }

    /* renamed from: a */
    public <T> void mo9850a(T t, LottieValueCallback<T> cVar) {
        super.mo9850a(t, cVar);
        if (t != LottieProperty.f1547x) {
            return;
        }
        if (cVar == null) {
            this.f1745h = null;
        } else {
            this.f1745h = new ValueCallbackKeyframeAnimation(cVar);
        }
    }
}
