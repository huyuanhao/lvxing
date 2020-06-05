package com.ksad.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import com.ksad.lottie.C3721f;
import com.ksad.lottie.p298a.p300b.C3646a;

/* renamed from: com.ksad.lottie.model.layer.f */
public class C3782f extends C3774a {
    /* renamed from: e */
    private final RectF f12884e = new RectF();
    /* renamed from: f */
    private final Paint f12885f = new Paint();
    /* renamed from: g */
    private final float[] f12886g = new float[8];
    /* renamed from: h */
    private final Path f12887h = new Path();
    /* renamed from: i */
    private final Layer f12888i;
    /* renamed from: j */
    private C3646a<ColorFilter, ColorFilter> f12889j;

    C3782f(C3721f fVar, Layer layer) {
        super(fVar, layer);
        this.f12888i = layer;
        this.f12885f.setAlpha(0);
        this.f12885f.setStyle(Style.FILL);
        this.f12885f.setColor(layer.mo23161p());
    }

    /* renamed from: a */
    public void mo22813a(RectF rectF, Matrix matrix) {
        super.mo22813a(rectF, matrix);
        this.f12884e.set(0.0f, 0.0f, (float) this.f12888i.mo23163r(), (float) this.f12888i.mo23162q());
        this.f12848a.mapRect(this.f12884e);
        rectF.set(this.f12884e);
    }

    /* renamed from: b */
    public void mo23172b(Canvas canvas, Matrix matrix, int i) {
        int alpha = Color.alpha(this.f12888i.mo23161p());
        if (alpha != 0) {
            int intValue = (int) ((((float) i) / 255.0f) * (((((float) alpha) / 255.0f) * ((float) ((Integer) this.f12851d.mo22848a().mo22831e()).intValue())) / 100.0f) * 255.0f);
            this.f12885f.setAlpha(intValue);
            C3646a<ColorFilter, ColorFilter> aVar = this.f12889j;
            if (aVar != null) {
                this.f12885f.setColorFilter((ColorFilter) aVar.mo22831e());
            }
            if (intValue > 0) {
                float[] fArr = this.f12886g;
                fArr[0] = 0.0f;
                fArr[1] = 0.0f;
                fArr[2] = (float) this.f12888i.mo23163r();
                float[] fArr2 = this.f12886g;
                fArr2[3] = 0.0f;
                fArr2[4] = (float) this.f12888i.mo23163r();
                this.f12886g[5] = (float) this.f12888i.mo23162q();
                float[] fArr3 = this.f12886g;
                fArr3[6] = 0.0f;
                fArr3[7] = (float) this.f12888i.mo23162q();
                matrix.mapPoints(this.f12886g);
                this.f12887h.reset();
                Path path = this.f12887h;
                float[] fArr4 = this.f12886g;
                path.moveTo(fArr4[0], fArr4[1]);
                Path path2 = this.f12887h;
                float[] fArr5 = this.f12886g;
                path2.lineTo(fArr5[2], fArr5[3]);
                Path path3 = this.f12887h;
                float[] fArr6 = this.f12886g;
                path3.lineTo(fArr6[4], fArr6[5]);
                Path path4 = this.f12887h;
                float[] fArr7 = this.f12886g;
                path4.lineTo(fArr7[6], fArr7[7]);
                Path path5 = this.f12887h;
                float[] fArr8 = this.f12886g;
                path5.lineTo(fArr8[0], fArr8[1]);
                this.f12887h.close();
                canvas.drawPath(this.f12887h, this.f12885f);
            }
        }
    }
}
