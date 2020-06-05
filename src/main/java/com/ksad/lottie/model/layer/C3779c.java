package com.ksad.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.ksad.lottie.C3721f;
import com.ksad.lottie.p298a.p300b.C3646a;
import com.ksad.lottie.p303d.C3709f;

/* renamed from: com.ksad.lottie.model.layer.c */
public class C3779c extends C3774a {
    /* renamed from: e */
    private final Paint f12879e = new Paint(3);
    /* renamed from: f */
    private final Rect f12880f = new Rect();
    /* renamed from: g */
    private final Rect f12881g = new Rect();
    /* renamed from: h */
    private C3646a<ColorFilter, ColorFilter> f12882h;

    C3779c(C3721f fVar, Layer layer) {
        super(fVar, layer);
    }

    /* renamed from: e */
    private Bitmap m15693e() {
        return this.f12849b.mo22963b(this.f12850c.mo23152g());
    }

    /* renamed from: a */
    public void mo22813a(RectF rectF, Matrix matrix) {
        super.mo22813a(rectF, matrix);
        Bitmap e = m15693e();
        if (e != null) {
            rectF.set(rectF.left, rectF.top, Math.min(rectF.right, (float) e.getWidth()), Math.min(rectF.bottom, (float) e.getHeight()));
            this.f12848a.mapRect(rectF);
        }
    }

    /* renamed from: b */
    public void mo23172b(Canvas canvas, Matrix matrix, int i) {
        Bitmap e = m15693e();
        if (e != null && !e.isRecycled()) {
            float a = C3709f.m15387a();
            this.f12879e.setAlpha(i);
            C3646a<ColorFilter, ColorFilter> aVar = this.f12882h;
            if (aVar != null) {
                this.f12879e.setColorFilter((ColorFilter) aVar.mo22831e());
            }
            canvas.save();
            canvas.concat(matrix);
            this.f12880f.set(0, 0, e.getWidth(), e.getHeight());
            this.f12881g.set(0, 0, (int) (((float) e.getWidth()) * a), (int) (((float) e.getHeight()) * a));
            canvas.drawBitmap(e, this.f12880f, this.f12881g, this.f12879e);
            canvas.restore();
        }
    }
}
