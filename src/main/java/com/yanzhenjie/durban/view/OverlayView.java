package com.yanzhenjie.durban.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.yanzhenjie.durban.R;
import com.yanzhenjie.durban.p630a.OverlayViewChangeListener;
import com.yanzhenjie.durban.p632c.RectUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class OverlayView extends View {
    /* renamed from: A */
    private OverlayViewChangeListener f26556A;
    /* renamed from: B */
    private boolean f26557B;
    /* renamed from: a */
    protected int f26558a;
    /* renamed from: b */
    protected int f26559b;
    /* renamed from: c */
    protected float[] f26560c;
    /* renamed from: d */
    protected float[] f26561d;
    /* renamed from: e */
    private final RectF f26562e;
    /* renamed from: f */
    private final RectF f26563f;
    /* renamed from: g */
    private int f26564g;
    /* renamed from: h */
    private int f26565h;
    /* renamed from: i */
    private float f26566i;
    /* renamed from: j */
    private float[] f26567j;
    /* renamed from: k */
    private boolean f26568k;
    /* renamed from: l */
    private boolean f26569l;
    /* renamed from: m */
    private boolean f26570m;
    /* renamed from: n */
    private int f26571n;
    /* renamed from: o */
    private Path f26572o;
    /* renamed from: p */
    private Paint f26573p;
    /* renamed from: q */
    private Paint f26574q;
    /* renamed from: r */
    private Paint f26575r;
    /* renamed from: s */
    private Paint f26576s;
    /* renamed from: t */
    private int f26577t;
    /* renamed from: u */
    private float f26578u;
    /* renamed from: v */
    private float f26579v;
    /* renamed from: w */
    private int f26580w;
    /* renamed from: x */
    private int f26581x;
    /* renamed from: y */
    private int f26582y;
    /* renamed from: z */
    private int f26583z;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.yanzhenjie.durban.view.OverlayView$FreestyleMode */
    public @interface FreestyleMode {
    }

    public OverlayView(Context context) {
        this(context, null);
    }

    public OverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f26562e = new RectF();
        this.f26563f = new RectF();
        this.f26567j = null;
        this.f26572o = new Path();
        this.f26573p = new Paint(1);
        this.f26574q = new Paint(1);
        this.f26575r = new Paint(1);
        this.f26576s = new Paint(1);
        this.f26577t = 0;
        this.f26578u = -1.0f;
        this.f26579v = -1.0f;
        this.f26580w = -1;
        mo37907a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo37907a() {
        this.f26581x = getResources().getDimensionPixelSize(R.dimen.durban_dp_30);
        this.f26582y = getResources().getDimensionPixelSize(R.dimen.durban_dp_100);
        this.f26583z = getResources().getDimensionPixelSize(R.dimen.durban_dp_10);
        if (VERSION.SDK_INT < 18 && VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
    }

    public void setOverlayViewChangeListener(OverlayViewChangeListener dVar) {
        this.f26556A = dVar;
    }

    public RectF getCropViewRect() {
        return this.f26562e;
    }

    @Deprecated
    public void setFreestyleCropEnabled(boolean z) {
        this.f26577t = z;
    }

    public int getFreestyleCropMode() {
        return this.f26577t;
    }

    public void setFreestyleCropMode(int i) {
        this.f26577t = i;
        postInvalidate();
    }

    public void setCircleDimmedLayer(boolean z) {
        this.f26570m = z;
    }

    public void setCropGridRowCount(int i) {
        this.f26564g = i;
        this.f26567j = null;
    }

    public void setCropGridColumnCount(int i) {
        this.f26565h = i;
        this.f26567j = null;
    }

    public void setShowCropFrame(boolean z) {
        this.f26568k = z;
    }

    public void setShowCropGrid(boolean z) {
        this.f26569l = z;
    }

    public void setDimmedColor(int i) {
        this.f26571n = i;
    }

    public void setCropFrameStrokeWidth(int i) {
        this.f26575r.setStrokeWidth((float) i);
    }

    public void setCropGridStrokeWidth(int i) {
        this.f26574q.setStrokeWidth((float) i);
    }

    public void setCropFrameColor(int i) {
        this.f26575r.setColor(i);
    }

    public void setCropGridColor(int i) {
        this.f26574q.setColor(i);
    }

    public void setTargetAspectRatio(float f) {
        this.f26566i = f;
        if (this.f26558a > 0) {
            mo37910b();
            postInvalidate();
            return;
        }
        this.f26557B = true;
    }

    /* renamed from: b */
    public void mo37910b() {
        int i = this.f26558a;
        float f = (float) i;
        float f2 = this.f26566i;
        int i2 = (int) (f / f2);
        int i3 = this.f26559b;
        if (i2 > i3) {
            int i4 = (int) (((float) i3) * f2);
            int i5 = (i - i4) / 2;
            this.f26562e.set((float) (getPaddingLeft() + i5), (float) getPaddingTop(), (float) (getPaddingLeft() + i4 + i5), (float) (getPaddingTop() + this.f26559b));
        } else {
            int i6 = (i3 - i2) / 2;
            this.f26562e.set((float) getPaddingLeft(), (float) (getPaddingTop() + i6), (float) (getPaddingLeft() + this.f26558a), (float) (getPaddingTop() + i2 + i6));
        }
        OverlayViewChangeListener dVar = this.f26556A;
        if (dVar != null) {
            dVar.mo37813a(this.f26562e);
        }
        m33905c();
    }

    /* renamed from: c */
    private void m33905c() {
        this.f26560c = RectUtils.m33851a(this.f26562e);
        this.f26561d = RectUtils.m33854b(this.f26562e);
        this.f26567j = null;
        this.f26572o.reset();
        this.f26572o.addCircle(this.f26562e.centerX(), this.f26562e.centerY(), Math.min(this.f26562e.width(), this.f26562e.height()) / 2.0f, Direction.CW);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int height = getHeight() - getPaddingBottom();
            this.f26558a = (getWidth() - getPaddingRight()) - paddingLeft;
            this.f26559b = height - paddingTop;
            if (this.f26557B) {
                this.f26557B = false;
                setTargetAspectRatio(this.f26566i);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mo37909a(canvas);
        mo37911b(canvas);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!this.f26562e.isEmpty() && this.f26577t != 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if ((motionEvent.getAction() & 255) == 0) {
                this.f26580w = m33903b(x, y);
                if (this.f26580w != -1) {
                    z = true;
                }
                if (!z) {
                    this.f26578u = -1.0f;
                    this.f26579v = -1.0f;
                } else if (this.f26578u < 0.0f) {
                    this.f26578u = x;
                    this.f26579v = y;
                }
                return z;
            } else if ((motionEvent.getAction() & 255) == 2 && motionEvent.getPointerCount() == 1 && this.f26580w != -1) {
                float min = Math.min(Math.max(x, (float) getPaddingLeft()), (float) (getWidth() - getPaddingRight()));
                float min2 = Math.min(Math.max(y, (float) getPaddingTop()), (float) (getHeight() - getPaddingBottom()));
                m33902a(min, min2);
                this.f26578u = min;
                this.f26579v = min2;
                return true;
            } else if ((motionEvent.getAction() & 255) == 1) {
                this.f26578u = -1.0f;
                this.f26579v = -1.0f;
                this.f26580w = -1;
                OverlayViewChangeListener dVar = this.f26556A;
                if (dVar != null) {
                    dVar.mo37813a(this.f26562e);
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m33902a(float f, float f2) {
        this.f26563f.set(this.f26562e);
        int i = this.f26580w;
        if (i == 0) {
            this.f26563f.set(f, f2, this.f26562e.right, this.f26562e.bottom);
        } else if (i == 1) {
            this.f26563f.set(this.f26562e.left, f2, f, this.f26562e.bottom);
        } else if (i == 2) {
            this.f26563f.set(this.f26562e.left, this.f26562e.top, f, f2);
        } else if (i == 3) {
            this.f26563f.set(f, this.f26562e.top, this.f26562e.right, f2);
        } else if (i == 4) {
            this.f26563f.offset(f - this.f26578u, f2 - this.f26579v);
            if (this.f26563f.left > ((float) getLeft()) && this.f26563f.top > ((float) getTop()) && this.f26563f.right < ((float) getRight()) && this.f26563f.bottom < ((float) getBottom())) {
                this.f26562e.set(this.f26563f);
                m33905c();
                postInvalidate();
            }
            return;
        }
        boolean z = false;
        boolean z2 = this.f26563f.height() >= ((float) this.f26582y);
        if (this.f26563f.width() >= ((float) this.f26582y)) {
            z = true;
        }
        RectF rectF = this.f26562e;
        rectF.set(z ? this.f26563f.left : rectF.left, (z2 ? this.f26563f : this.f26562e).top, (z ? this.f26563f : this.f26562e).right, (z2 ? this.f26563f : this.f26562e).bottom);
        if (z2 || z) {
            m33905c();
            postInvalidate();
        }
    }

    /* renamed from: b */
    private int m33903b(float f, float f2) {
        double d = (double) this.f26581x;
        int i = -1;
        for (int i2 = 0; i2 < 8; i2 += 2) {
            double sqrt = Math.sqrt(Math.pow((double) (f - this.f26560c[i2]), 2.0d) + Math.pow((double) (f2 - this.f26560c[i2 + 1]), 2.0d));
            if (sqrt < d) {
                i = i2 / 2;
                d = sqrt;
            }
        }
        if (this.f26577t != 1 || i >= 0 || !this.f26562e.contains(f, f2)) {
            return i;
        }
        return 4;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo37909a(Canvas canvas) {
        canvas.save();
        if (this.f26570m) {
            canvas.clipPath(this.f26572o, Op.DIFFERENCE);
        } else {
            canvas.clipRect(this.f26562e, Op.DIFFERENCE);
        }
        canvas.drawColor(this.f26571n);
        canvas.restore();
        if (this.f26570m) {
            canvas.drawCircle(this.f26562e.centerX(), this.f26562e.centerY(), Math.min(this.f26562e.width(), this.f26562e.height()) / 2.0f, this.f26573p);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo37911b(Canvas canvas) {
        if (this.f26569l) {
            if (this.f26567j == null && !this.f26562e.isEmpty()) {
                this.f26567j = new float[((this.f26564g * 4) + (this.f26565h * 4))];
                int i = 0;
                int i2 = 0;
                while (i < this.f26564g) {
                    int i3 = i2 + 1;
                    this.f26567j[i2] = this.f26562e.left;
                    int i4 = i3 + 1;
                    float f = ((float) i) + 1.0f;
                    this.f26567j[i3] = (this.f26562e.height() * (f / ((float) (this.f26564g + 1)))) + this.f26562e.top;
                    int i5 = i4 + 1;
                    this.f26567j[i4] = this.f26562e.right;
                    int i6 = i5 + 1;
                    this.f26567j[i5] = (this.f26562e.height() * (f / ((float) (this.f26564g + 1)))) + this.f26562e.top;
                    i++;
                    i2 = i6;
                }
                for (int i7 = 0; i7 < this.f26565h; i7++) {
                    int i8 = i2 + 1;
                    float f2 = ((float) i7) + 1.0f;
                    this.f26567j[i2] = (this.f26562e.width() * (f2 / ((float) (this.f26565h + 1)))) + this.f26562e.left;
                    int i9 = i8 + 1;
                    this.f26567j[i8] = this.f26562e.top;
                    int i10 = i9 + 1;
                    this.f26567j[i9] = (this.f26562e.width() * (f2 / ((float) (this.f26565h + 1)))) + this.f26562e.left;
                    i2 = i10 + 1;
                    this.f26567j[i10] = this.f26562e.bottom;
                }
            }
            float[] fArr = this.f26567j;
            if (fArr != null) {
                canvas.drawLines(fArr, this.f26574q);
            }
        }
        if (this.f26568k) {
            canvas.drawRect(this.f26562e, this.f26575r);
        }
        if (this.f26577t != 0) {
            canvas.save();
            this.f26563f.set(this.f26562e);
            RectF rectF = this.f26563f;
            int i11 = this.f26583z;
            rectF.inset((float) i11, (float) (-i11));
            canvas.clipRect(this.f26563f, Op.DIFFERENCE);
            this.f26563f.set(this.f26562e);
            RectF rectF2 = this.f26563f;
            int i12 = this.f26583z;
            rectF2.inset((float) (-i12), (float) i12);
            canvas.clipRect(this.f26563f, Op.DIFFERENCE);
            canvas.drawRect(this.f26562e, this.f26576s);
            canvas.restore();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo37908a(TypedArray typedArray) {
        this.f26570m = typedArray.getBoolean(R.styleable.durban_CropView_durban_circle_dimmed_layer, false);
        this.f26571n = typedArray.getColor(R.styleable.durban_CropView_durban_dimmed_color, ContextCompat.getColor(getContext(), R.color.durban_CropDimmed));
        this.f26573p.setColor(this.f26571n);
        this.f26573p.setStyle(Style.STROKE);
        this.f26573p.setStrokeWidth(1.0f);
        m33904b(typedArray);
        this.f26568k = typedArray.getBoolean(R.styleable.durban_CropView_durban_show_frame, true);
        m33906c(typedArray);
        this.f26569l = typedArray.getBoolean(R.styleable.durban_CropView_durban_show_grid, true);
    }

    /* renamed from: b */
    private void m33904b(TypedArray typedArray) {
        int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.durban_CropView_durban_frame_stroke_size, getResources().getDimensionPixelSize(R.dimen.durban_dp_1));
        int color = typedArray.getColor(R.styleable.durban_CropView_durban_frame_color, ContextCompat.getColor(getContext(), R.color.durban_CropFrameLine));
        this.f26575r.setStrokeWidth((float) dimensionPixelSize);
        this.f26575r.setColor(color);
        this.f26575r.setStyle(Style.STROKE);
        this.f26576s.setStrokeWidth((float) (dimensionPixelSize * 3));
        this.f26576s.setColor(color);
        this.f26576s.setStyle(Style.STROKE);
    }

    /* renamed from: c */
    private void m33906c(TypedArray typedArray) {
        int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.durban_CropView_durban_grid_stroke_size, getResources().getDimensionPixelSize(R.dimen.durban_dp_1));
        int color = typedArray.getColor(R.styleable.durban_CropView_durban_grid_color, ContextCompat.getColor(getContext(), R.color.durban_CropGridLine));
        this.f26574q.setStrokeWidth((float) dimensionPixelSize);
        this.f26574q.setColor(color);
        this.f26564g = typedArray.getInt(R.styleable.durban_CropView_durban_grid_row_count, 2);
        this.f26565h = typedArray.getInt(R.styleable.durban_CropView_durban_grid_column_count, 2);
    }
}
