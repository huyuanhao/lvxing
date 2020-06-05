package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.p008a.p010b.BaseKeyframeAnimation;
import com.airbnb.lottie.p008a.p010b.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.p014e.LottieValueCallback;

/* renamed from: com.airbnb.lottie.model.layer.f */
public class SolidLayer extends BaseLayer {
    /* renamed from: e */
    private final RectF f1747e = new RectF();
    /* renamed from: f */
    private final Paint f1748f = new Paint();
    /* renamed from: g */
    private final float[] f1749g = new float[8];
    /* renamed from: h */
    private final Path f1750h = new Path();
    /* renamed from: i */
    private final Layer f1751i;
    /* renamed from: j */
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> f1752j;

    SolidLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        this.f1751i = layer;
        this.f1748f.setAlpha(0);
        this.f1748f.setStyle(Style.FILL);
        this.f1748f.setColor(layer.mo10152p());
    }

    /* renamed from: b */
    public void mo10162b(Canvas canvas, Matrix matrix, int i) {
        int alpha = Color.alpha(this.f1751i.mo10152p());
        if (alpha != 0) {
            int intValue = (int) ((((float) i) / 255.0f) * (((((float) alpha) / 255.0f) * ((float) ((Integer) this.f1714d.mo9887a().mo9870e()).intValue())) / 100.0f) * 255.0f);
            this.f1748f.setAlpha(intValue);
            BaseKeyframeAnimation<ColorFilter, ColorFilter> aVar = this.f1752j;
            if (aVar != null) {
                this.f1748f.setColorFilter((ColorFilter) aVar.mo9870e());
            }
            if (intValue > 0) {
                float[] fArr = this.f1749g;
                fArr[0] = 0.0f;
                fArr[1] = 0.0f;
                fArr[2] = (float) this.f1751i.mo10154r();
                float[] fArr2 = this.f1749g;
                fArr2[3] = 0.0f;
                fArr2[4] = (float) this.f1751i.mo10154r();
                this.f1749g[5] = (float) this.f1751i.mo10153q();
                float[] fArr3 = this.f1749g;
                fArr3[6] = 0.0f;
                fArr3[7] = (float) this.f1751i.mo10153q();
                matrix.mapPoints(this.f1749g);
                this.f1750h.reset();
                Path path = this.f1750h;
                float[] fArr4 = this.f1749g;
                path.moveTo(fArr4[0], fArr4[1]);
                Path path2 = this.f1750h;
                float[] fArr5 = this.f1749g;
                path2.lineTo(fArr5[2], fArr5[3]);
                Path path3 = this.f1750h;
                float[] fArr6 = this.f1749g;
                path3.lineTo(fArr6[4], fArr6[5]);
                Path path4 = this.f1750h;
                float[] fArr7 = this.f1749g;
                path4.lineTo(fArr7[6], fArr7[7]);
                Path path5 = this.f1750h;
                float[] fArr8 = this.f1749g;
                path5.lineTo(fArr8[0], fArr8[1]);
                this.f1750h.close();
                canvas.drawPath(this.f1750h, this.f1748f);
            }
        }
    }

    /* renamed from: a */
    public void mo9848a(RectF rectF, Matrix matrix) {
        super.mo9848a(rectF, matrix);
        this.f1747e.set(0.0f, 0.0f, (float) this.f1751i.mo10154r(), (float) this.f1751i.mo10153q());
        this.f1711a.mapRect(this.f1747e);
        rectF.set(this.f1747e);
    }

    /* renamed from: a */
    public <T> void mo9850a(T t, LottieValueCallback<T> cVar) {
        super.mo9850a(t, cVar);
        if (t != LottieProperty.f1547x) {
            return;
        }
        if (cVar == null) {
            this.f1752j = null;
        } else {
            this.f1752j = new ValueCallbackKeyframeAnimation(cVar);
        }
    }
}
