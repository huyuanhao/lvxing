package com.qiyukf.nim.uikit.common.p424ui.imageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.nimlib.p488k.p490b.C5942c;

/* renamed from: com.qiyukf.nim.uikit.common.ui.imageview.BaseZoomableImageView */
public abstract class BaseZoomableImageView extends View {
    /* renamed from: a */
    protected Bitmap f17565a;
    /* renamed from: b */
    protected C5477a f17566b;
    /* renamed from: c */
    protected ViewPager f17567c;
    /* renamed from: d */
    private Matrix f17568d;
    /* renamed from: e */
    private Matrix f17569e;
    /* renamed from: f */
    private Matrix f17570f;
    /* renamed from: g */
    private Matrix f17571g;
    /* renamed from: h */
    private Paint f17572h;
    /* renamed from: i */
    private float[] f17573i;
    /* renamed from: j */
    private int f17574j;
    /* renamed from: k */
    private int f17575k;
    /* renamed from: l */
    private float f17576l;
    /* renamed from: m */
    private Runnable f17577m;
    /* renamed from: n */
    private Runnable f17578n;
    /* renamed from: o */
    private double f17579o;
    /* renamed from: p */
    private Runnable f17580p;
    /* access modifiers changed from: private */
    /* renamed from: q */
    public boolean f17581q;
    /* renamed from: r */
    private boolean f17582r;
    /* renamed from: s */
    private boolean f17583s;

    public BaseZoomableImageView(Context context) {
        super(context);
        this.f17568d = new Matrix();
        this.f17569e = new Matrix();
        this.f17570f = new Matrix();
        this.f17571g = new Matrix();
        this.f17573i = new float[9];
        this.f17574j = -1;
        this.f17575k = -1;
        this.f17577m = null;
        this.f17578n = null;
        this.f17579o = 0.0d;
        this.f17580p = null;
        this.f17581q = false;
        this.f17582r = false;
        this.f17583s = true;
        m22302a(context);
    }

    public BaseZoomableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17568d = new Matrix();
        this.f17569e = new Matrix();
        this.f17570f = new Matrix();
        this.f17571g = new Matrix();
        this.f17573i = new float[9];
        this.f17574j = -1;
        this.f17575k = -1;
        this.f17577m = null;
        this.f17578n = null;
        this.f17579o = 0.0d;
        this.f17580p = null;
        this.f17581q = false;
        this.f17582r = false;
        this.f17583s = true;
        m22302a(context);
    }

    public BaseZoomableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17568d = new Matrix();
        this.f17569e = new Matrix();
        this.f17570f = new Matrix();
        this.f17571g = new Matrix();
        this.f17573i = new float[9];
        this.f17574j = -1;
        this.f17575k = -1;
        this.f17577m = null;
        this.f17578n = null;
        this.f17579o = 0.0d;
        this.f17580p = null;
        this.f17581q = false;
        this.f17582r = false;
        this.f17583s = true;
        m22302a(context);
    }

    public BaseZoomableImageView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f17568d = new Matrix();
        this.f17569e = new Matrix();
        this.f17570f = new Matrix();
        this.f17571g = new Matrix();
        this.f17573i = new float[9];
        this.f17574j = -1;
        this.f17575k = -1;
        this.f17577m = null;
        this.f17578n = null;
        this.f17579o = 0.0d;
        this.f17580p = null;
        this.f17581q = false;
        this.f17582r = false;
        this.f17583s = true;
        m22302a(context);
    }

    /* renamed from: a */
    private float m22301a(Matrix matrix, int i) {
        matrix.getValues(this.f17573i);
        return this.f17573i[i];
    }

    /* renamed from: a */
    private void m22302a(Context context) {
        this.f17572h = new Paint();
        this.f17572h.setDither(true);
        this.f17572h.setFilterBitmap(true);
        this.f17572h.setAntiAlias(true);
        if (context.getResources().getConfiguration().orientation == 2) {
            this.f17582r = true;
        } else {
            this.f17582r = false;
        }
        this.f17578n = new Runnable() {
            public final void run() {
                BaseZoomableImageView.this.postInvalidate();
            }
        };
    }

    /* renamed from: a */
    private void m22303a(Matrix matrix) {
        if (matrix != null && matrix.isIdentity()) {
            matrix = null;
        }
        if ((matrix == null && !this.f17571g.isIdentity()) || (matrix != null && !this.f17571g.equals(matrix))) {
            this.f17571g.set(matrix);
            invalidate();
        }
    }

    /* renamed from: c */
    static /* synthetic */ float m22305c(float f, float f2, float f3) {
        float f4 = (f / f3) - 1.0f;
        return (f2 * ((f4 * f4 * f4) + 1.0f)) + 0.0f;
    }

    /* renamed from: h */
    private Matrix m22306h() {
        this.f17570f.set(this.f17568d);
        this.f17570f.postConcat(this.f17569e);
        return this.f17570f;
    }

    /* renamed from: a */
    public final Bitmap mo27505a() {
        return this.f17565a;
    }

    /* renamed from: a */
    public final void mo27506a(float f) {
        mo27507a(f, ((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f);
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo27507a(float f, float f2, float f3) {
        float f4 = this.f17576l;
        if (f > f4) {
            f = f4;
        }
        float d = f / mo27518d();
        this.f17569e.postScale(d, d, f2, f3);
        m22303a(m22306h());
        mo27517c();
    }

    /* renamed from: a */
    public final void mo27508a(Bitmap bitmap) {
        mo27509a(bitmap, true);
    }

    /* renamed from: a */
    public final void mo27509a(final Bitmap bitmap, final boolean z) {
        boolean z2 = true;
        if (VERSION.SDK_INT >= 14) {
            if (bitmap == null || (bitmap.getHeight() <= C5942c.m23818a() && bitmap.getWidth() <= C5942c.m23818a())) {
                setLayerType(2, null);
            } else {
                setLayerType(1, null);
            }
        }
        if (getWidth() <= 0) {
            this.f17577m = new Runnable() {
                public final void run() {
                    BaseZoomableImageView.this.mo27509a(bitmap, z);
                }
            };
            return;
        }
        Bitmap bitmap2 = this.f17565a;
        Matrix matrix = this.f17568d;
        if (bitmap != null) {
            float width = (float) getWidth();
            float height = (float) getHeight();
            matrix.reset();
            float min = Math.min(width / ((float) bitmap.getWidth()), 1.0f);
            float min2 = Math.min(height / ((float) bitmap.getHeight()), 1.0f);
            if (min > min2) {
                min = min2;
            }
            matrix.setScale(min, min);
            matrix.postTranslate((width - (((float) bitmap.getWidth()) * min)) / 2.0f, (height - (((float) bitmap.getHeight()) * min)) / 2.0f);
        } else {
            matrix.reset();
        }
        this.f17565a = bitmap;
        if (!(bitmap2 == null || bitmap2 == this.f17565a || bitmap2.isRecycled())) {
            bitmap2.recycle();
        }
        this.f17569e.reset();
        m22303a(m22306h());
        this.f17576l = mo27519e();
        if (z) {
            Bitmap bitmap3 = this.f17565a;
            if (bitmap3 != null) {
                float width2 = ((float) this.f17574j) / ((float) bitmap3.getWidth());
                if (!this.f17583s || (((float) this.f17565a.getHeight()) / ((float) this.f17565a.getWidth()) <= 5.0f && (!this.f17582r || ((float) this.f17565a.getHeight()) / ((float) this.f17565a.getWidth()) <= 2.0f))) {
                    width2 = 0.0f;
                    z2 = false;
                }
                if (z2) {
                    float d = width2 / mo27518d();
                    this.f17568d.reset();
                    this.f17569e.postScale(d, d, 0.0f, 0.0f);
                    m22303a(m22306h());
                    return;
                }
                mo27506a(mo27520f());
            }
        }
    }

    /* renamed from: a */
    public final void mo27510a(ViewPager viewPager) {
        this.f17567c = viewPager;
    }

    /* renamed from: a */
    public final void mo27511a(C5477a aVar) {
        this.f17566b = aVar;
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final boolean mo27512a(float f, float f2) {
        return this.f17569e.postTranslate(f, f2);
    }

    /* renamed from: b */
    public final void mo27513b() {
        Bitmap bitmap = this.f17565a;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f17565a.recycle();
        }
        this.f17565a = null;
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: b */
    public final void mo27514b(float f, float f2) {
        final long currentTimeMillis = System.currentTimeMillis();
        final float f3 = f;
        final float f4 = f2;
        C54734 r0 = new Runnable() {
            /* renamed from: a */
            float f17595a;
            /* renamed from: b */
            float f17596b;
            /* renamed from: c */
            final /* synthetic */ float f17597c = 300.0f;

            {
                this.f17595a = 0.0f;
                this.f17596b = 0.0f;
            }

            public final void run() {
                float min = Math.min(this.f17597c, (float) (System.currentTimeMillis() - currentTimeMillis));
                float c = BaseZoomableImageView.m22305c(min, f3, this.f17597c);
                float c2 = BaseZoomableImageView.m22305c(min, f4, this.f17597c);
                BaseZoomableImageView.this.mo27512a(c - this.f17595a, c2 - this.f17596b);
                BaseZoomableImageView.this.mo27517c();
                this.f17595a = c;
                this.f17596b = c2;
                if (min < this.f17597c) {
                    BaseZoomableImageView baseZoomableImageView = BaseZoomableImageView.this;
                    baseZoomableImageView.f17581q = baseZoomableImageView.post(this);
                    return;
                }
                BaseZoomableImageView.this.mo27521g();
            }
        };
        this.f17580p = r0;
        this.f17581q = post(this.f17580p);
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: b */
    public final void mo27515b(float f, float f2, float f3) {
        final float d = (f - mo27518d()) / 200.0f;
        final float d2 = mo27518d();
        final long currentTimeMillis = System.currentTimeMillis();
        final float f4 = f2;
        final float f5 = f3;
        C54723 r1 = new Runnable() {
            /* renamed from: a */
            final /* synthetic */ float f17588a = 200.0f;

            public final void run() {
                float min = Math.min(this.f17588a, (float) (System.currentTimeMillis() - currentTimeMillis));
                BaseZoomableImageView.this.mo27507a(d2 + (d * min), f4, f5);
                if (min < this.f17588a) {
                    BaseZoomableImageView.this.post(this);
                }
            }
        };
        post(r1);
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: b */
    public final boolean mo27516b(float f) {
        try {
            if (this.f17570f != null) {
                float a = m22301a(this.f17570f, 2);
                float width = ((float) getWidth()) - a;
                if ((a == 0.0f && f <= 0.0f) || (width == ((float) this.f17565a.getWidth()) * m22301a(this.f17570f, 0) && f >= 0.0f)) {
                    System.out.println("ScrollOver");
                    return true;
                }
            }
        } catch (IllegalArgumentException e) {
            C5264a.m21621b("BaseZoomableImageView is scrollover is error", "", e);
            e.printStackTrace();
        }
        return false;
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: c */
    public final void mo27517c() {
        float f;
        if (this.f17565a != null) {
            Matrix h = m22306h();
            float[] fArr = {0.0f, 0.0f};
            float[] fArr2 = {(float) this.f17565a.getWidth(), (float) this.f17565a.getHeight()};
            h.mapPoints(fArr);
            h.mapPoints(fArr2);
            float f2 = fArr2[1] - fArr[1];
            float f3 = fArr2[0] - fArr[0];
            float height = (float) getHeight();
            float f4 = 0.0f;
            float f5 = f2 < height ? ((height - f2) / 2.0f) - fArr[1] : fArr[1] > 0.0f ? -fArr[1] : fArr2[1] < height ? ((float) getHeight()) - fArr2[1] : 0.0f;
            float width = (float) getWidth();
            if (f3 < width) {
                width = (width - f3) / 2.0f;
                f = fArr[0];
            } else {
                if (fArr[0] > 0.0f) {
                    f4 = -fArr[0];
                } else if (fArr2[0] < width) {
                    f = fArr2[0];
                }
                mo27512a(f4, f5);
                m22303a(m22306h());
            }
            f4 = width - f;
            mo27512a(f4, f5);
            m22303a(m22306h());
        }
    }

    /* renamed from: d */
    public final float mo27518d() {
        Matrix matrix = this.f17569e;
        if (this.f17565a != null) {
            return m22301a(matrix, 0);
        }
        return 1.0f;
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: e */
    public final float mo27519e() {
        Bitmap bitmap = this.f17565a;
        if (bitmap == null) {
            return 1.0f;
        }
        float max = Math.max(((float) bitmap.getWidth()) / ((float) this.f17574j), ((float) this.f17565a.getHeight()) / ((float) this.f17575k)) * 16.0f;
        if (max < 1.0f) {
            max = 1.0f;
        }
        return max;
    }

    /* renamed from: f */
    public final float mo27520f() {
        Bitmap bitmap = this.f17565a;
        if (bitmap == null) {
            return 1.0f;
        }
        return Math.max(Math.min(((float) this.f17574j) / ((float) bitmap.getWidth()), ((float) this.f17575k) / ((float) this.f17565a.getHeight())), 1.0f);
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: g */
    public final void mo27521g() {
        removeCallbacks(this.f17580p);
        if (this.f17581q) {
            this.f17581q = false;
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Bitmap bitmap = this.f17565a;
        if (bitmap != null && !bitmap.isRecycled()) {
            if (VERSION.SDK_INT < 14 || getLayerType() != 2) {
                int i = ((((double) System.currentTimeMillis()) - this.f17579o) > 250.0d ? 1 : ((((double) System.currentTimeMillis()) - this.f17579o) == 250.0d ? 0 : -1));
                Bitmap bitmap2 = this.f17565a;
                Matrix matrix = this.f17571g;
                if (i > 0) {
                    canvas.drawBitmap(bitmap2, matrix, this.f17572h);
                    this.f17579o = (double) System.currentTimeMillis();
                    return;
                }
                canvas.drawBitmap(bitmap2, matrix, null);
                removeCallbacks(this.f17578n);
                postDelayed(this.f17578n, 250);
            } else {
                canvas.drawBitmap(this.f17565a, this.f17571g, null);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f17574j = i3 - i;
        this.f17575k = i4 - i2;
        Runnable runnable = this.f17577m;
        if (runnable != null) {
            this.f17577m = null;
            runnable.run();
        }
    }
}
