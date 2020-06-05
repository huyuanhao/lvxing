package com.kwad.sdk.core.page.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.ProgressBar;
import com.kwad.sdk.KsAdSDK;
import com.kwad.sdk.p306a.C3817t;

public class TextProgressBar extends ProgressBar {
    /* renamed from: a */
    private static final boolean f14046a = KsAdSDK.isDebugLogEnable();
    /* renamed from: b */
    private String f14047b;
    /* renamed from: c */
    private Paint f14048c;
    /* renamed from: d */
    private LinearGradient f14049d;
    /* renamed from: e */
    private Matrix f14050e;
    /* renamed from: f */
    private boolean f14051f;
    /* renamed from: g */
    private boolean f14052g = false;
    /* renamed from: h */
    private boolean f14053h = true;
    /* renamed from: i */
    private int f14054i;
    /* renamed from: j */
    private int f14055j;
    /* renamed from: k */
    private Drawable f14056k;
    /* renamed from: l */
    private int f14057l;
    /* renamed from: m */
    private Rect f14058m = new Rect();
    /* renamed from: n */
    private int[] f14059n;

    public TextProgressBar(Context context) {
        super(context);
        m17487a();
    }

    public TextProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m17487a();
    }

    public TextProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m17487a();
    }

    /* renamed from: a */
    private void m17487a() {
        this.f14048c = new Paint();
        this.f14048c.setAntiAlias(true);
        this.f14048c.setColor(-1);
        this.f14048c.setTextSize((float) C3817t.m15862a(getContext(), 12.0f));
        this.f14057l = C3817t.m15862a(getContext(), 2.0f);
    }

    private void setProgressText(int i) {
        int max = (int) (((((float) i) * 1.0f) / ((float) getMax())) * 100.0f);
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(max));
        sb.append("%");
        this.f14047b = sb.toString();
    }

    /* renamed from: a */
    public void mo24328a(String str, int i) {
        this.f14047b = str;
        this.f14051f = true;
        setProgress(i);
        invalidate();
    }

    /* access modifiers changed from: protected|declared_synchronized */
    public synchronized void onDraw(Canvas canvas) {
        int i;
        Canvas canvas2 = canvas;
        synchronized (this) {
            if (this.f14052g) {
                canvas.save();
                canvas2.rotate(90.0f);
                canvas2.translate(0.0f, (float) (-getWidth()));
                super.onDraw(canvas);
                canvas.restore();
            } else {
                super.onDraw(canvas);
            }
            if (!TextUtils.isEmpty(this.f14047b)) {
                this.f14048c.getTextBounds(this.f14047b, 0, this.f14047b.length(), this.f14058m);
            }
            int height = (getHeight() / 2) - this.f14058m.centerY();
            if (this.f14056k != null) {
                int intrinsicWidth = this.f14056k.getIntrinsicWidth();
                int intrinsicHeight = this.f14056k.getIntrinsicHeight();
                int width = (((getWidth() - this.f14058m.width()) - intrinsicWidth) - this.f14057l) / 2;
                int i2 = intrinsicWidth + width;
                this.f14056k.setBounds(width, (getHeight() - intrinsicHeight) / 2, i2, (getHeight() + intrinsicHeight) / 2);
                this.f14056k.draw(canvas2);
                i = i2 + this.f14057l;
            } else {
                i = (getWidth() / 2) - this.f14058m.centerX();
            }
            if (this.f14059n != null) {
                float progress = ((((float) getProgress()) * 1.0f) / ((float) getMax())) * ((float) getWidth());
                float f = (float) i;
                if (progress >= f) {
                    if (this.f14049d == null) {
                        LinearGradient linearGradient = r7;
                        LinearGradient linearGradient2 = new LinearGradient(f, 0.0f, (float) (this.f14058m.width() + i), 0.0f, this.f14059n, null, TileMode.CLAMP);
                        this.f14049d = linearGradient;
                        this.f14050e = new Matrix();
                        this.f14049d.setLocalMatrix(this.f14050e);
                    }
                    this.f14048c.setShader(this.f14049d);
                    this.f14050e.setScale(((progress - f) * 1.0f) / ((float) this.f14058m.width()), 1.0f, f, 0.0f);
                    this.f14049d.setLocalMatrix(this.f14050e);
                } else {
                    this.f14048c.setShader(null);
                }
            }
            canvas2.drawText(this.f14047b, (float) i, (float) height, this.f14048c);
        }
    }

    /* access modifiers changed from: protected|declared_synchronized */
    public synchronized void onMeasure(int i, int i2) {
        LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null && !TextUtils.isEmpty(this.f14047b)) {
            Rect rect = new Rect();
            this.f14048c.getTextBounds(this.f14047b, 0, this.f14047b.length(), rect);
            if (layoutParams.width == -2) {
                layoutParams.width = rect.width() + this.f14054i + this.f14055j;
                i = MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
            }
            if (layoutParams.height == -2) {
                layoutParams.height = rect.height();
                i2 = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            }
        }
        if (this.f14052g) {
            super.onMeasure(i2, i);
            setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
        } else {
            super.onMeasure(i, i2);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        if (this.f14052g) {
            super.onSizeChanged(i2, i, i3, i4);
        } else {
            super.onSizeChanged(i, i2, i3, i4);
        }
    }

    public void setDrawableLeft(Drawable drawable) {
        this.f14056k = drawable;
    }

    public void setDrawablePadding(int i) {
        this.f14057l = i;
    }

    public void setHasProgress(boolean z) {
        this.f14053h = z;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.f14054i = i;
        this.f14055j = i3;
    }

    public void setProgress(int i) {
        if (!this.f14053h) {
            i = 0;
        }
        super.setProgress(i);
    }

    public void setTextColor(int i) {
        this.f14048c.setColor(i);
    }

    public void setTextDimen(float f) {
        this.f14048c.setTextSize(f);
    }

    public void setTextDimenSp(int i) {
        this.f14048c.setTextSize(TypedValue.applyDimension(2, (float) i, getResources().getDisplayMetrics()));
    }

    public void setVertical(boolean z) {
        this.f14052g = z;
    }
}
