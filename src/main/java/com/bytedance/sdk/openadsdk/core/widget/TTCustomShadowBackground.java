package com.bytedance.sdk.openadsdk.core.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.utils.ResourceHelp;

/* renamed from: com.bytedance.sdk.openadsdk.core.widget.c */
public class TTCustomShadowBackground extends Drawable {
    /* renamed from: a */
    private int f8316a;
    /* renamed from: b */
    private int f8317b;
    /* renamed from: c */
    private int[] f8318c;
    /* renamed from: d */
    private float[] f8319d;
    /* renamed from: e */
    private LinearGradient f8320e;
    /* renamed from: f */
    private int f8321f;
    /* renamed from: g */
    private int f8322g;
    /* renamed from: h */
    private int f8323h;
    /* renamed from: i */
    private int f8324i;
    /* renamed from: j */
    private RectF f8325j;
    /* renamed from: k */
    private Paint f8326k;

    /* compiled from: TTCustomShadowBackground */
    /* renamed from: com.bytedance.sdk.openadsdk.core.widget.c$a */
    public static class C2361a {
        /* renamed from: a */
        private int f8327a;
        /* renamed from: b */
        private int f8328b;
        /* renamed from: c */
        private int[] f8329c;
        /* renamed from: d */
        private float[] f8330d;
        /* renamed from: e */
        private LinearGradient f8331e;
        /* renamed from: f */
        private int f8332f;
        /* renamed from: g */
        private int f8333g;
        /* renamed from: h */
        private int f8334h;
        /* renamed from: i */
        private int f8335i;

        public C2361a() {
            this.f8334h = 0;
            this.f8335i = 0;
            this.f8327a = ResourceHelp.m11940j(InternalContainer.m10059a(), "tt_ssxinmian8");
            this.f8328b = ResourceHelp.m11940j(InternalContainer.m10059a(), "tt_ssxinxian3");
            this.f8332f = 10;
            this.f8333g = 16;
            this.f8334h = 0;
            this.f8335i = 0;
        }

        /* renamed from: a */
        public C2361a mo16309a(int i) {
            this.f8327a = i;
            return this;
        }

        /* renamed from: b */
        public C2361a mo16312b(int i) {
            this.f8328b = i;
            return this;
        }

        /* renamed from: a */
        public C2361a mo16310a(int[] iArr) {
            this.f8329c = iArr;
            return this;
        }

        /* renamed from: c */
        public C2361a mo16313c(int i) {
            this.f8332f = i;
            return this;
        }

        /* renamed from: d */
        public C2361a mo16314d(int i) {
            this.f8334h = i;
            return this;
        }

        /* renamed from: e */
        public C2361a mo16315e(int i) {
            this.f8335i = i;
            return this;
        }

        /* renamed from: a */
        public TTCustomShadowBackground mo16311a() {
            TTCustomShadowBackground cVar = new TTCustomShadowBackground(this.f8327a, this.f8329c, this.f8330d, this.f8328b, this.f8331e, this.f8332f, this.f8333g, this.f8334h, this.f8335i);
            return cVar;
        }
    }

    public int getOpacity() {
        return -3;
    }

    public TTCustomShadowBackground(int i, int[] iArr, float[] fArr, int i2, LinearGradient linearGradient, int i3, int i4, int i5, int i6) {
        this.f8316a = i;
        this.f8318c = iArr;
        this.f8319d = fArr;
        this.f8317b = i2;
        this.f8320e = linearGradient;
        this.f8321f = i3;
        this.f8322g = i4;
        this.f8323h = i5;
        this.f8324i = i6;
    }

    public void draw(Canvas canvas) {
        if (this.f8325j == null) {
            Rect bounds = getBounds();
            this.f8325j = new RectF((float) ((bounds.left + this.f8322g) - this.f8323h), (float) ((bounds.top + this.f8322g) - this.f8324i), (float) ((bounds.right - this.f8322g) - this.f8323h), (float) ((bounds.bottom - this.f8322g) - this.f8324i));
        }
        if (this.f8326k == null) {
            m10792a();
        }
        RectF rectF = this.f8325j;
        int i = this.f8321f;
        canvas.drawRoundRect(rectF, (float) i, (float) i, this.f8326k);
    }

    public void setAlpha(int i) {
        Paint paint = this.f8326k;
        if (paint != null) {
            paint.setAlpha(i);
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Paint paint = this.f8326k;
        if (paint != null) {
            paint.setColorFilter(colorFilter);
        }
    }

    /* renamed from: a */
    private void m10792a() {
        this.f8326k = new Paint();
        boolean z = true;
        this.f8326k.setAntiAlias(true);
        this.f8326k.setShadowLayer((float) this.f8322g, (float) this.f8323h, (float) this.f8324i, this.f8317b);
        if (this.f8325j != null) {
            int[] iArr = this.f8318c;
            if (iArr != null && iArr.length > 1) {
                float[] fArr = this.f8319d;
                if (fArr == null || fArr.length <= 0 || fArr.length != iArr.length) {
                    z = false;
                }
                Paint paint = this.f8326k;
                LinearGradient linearGradient = this.f8320e;
                if (linearGradient == null) {
                    linearGradient = new LinearGradient(this.f8325j.left, 0.0f, this.f8325j.right, 0.0f, this.f8318c, z ? this.f8319d : null, TileMode.CLAMP);
                }
                paint.setShader(linearGradient);
                return;
            }
        }
        this.f8326k.setColor(this.f8316a);
    }

    /* renamed from: a */
    public static void m10793a(View view, C2361a aVar) {
        if (view != null && aVar != null) {
            view.setLayerType(1, null);
            ViewCompat.setBackground(view, aVar.mo16311a());
        }
    }
}
