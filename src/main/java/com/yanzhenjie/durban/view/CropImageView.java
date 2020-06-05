package com.yanzhenjie.durban.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.yanzhenjie.durban.R;
import com.yanzhenjie.durban.model.CropParameters;
import com.yanzhenjie.durban.model.ImageState;
import com.yanzhenjie.durban.p630a.BitmapCropCallback;
import com.yanzhenjie.durban.p630a.CropBoundsChangeListener;
import com.yanzhenjie.durban.p631b.BitmapCropTask;
import com.yanzhenjie.durban.p632c.CubicEasing;
import com.yanzhenjie.durban.p632c.RectUtils;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class CropImageView extends TransformImageView {
    /* access modifiers changed from: private|final */
    /* renamed from: i */
    public final RectF f26512i;
    /* renamed from: j */
    private final Matrix f26513j;
    /* renamed from: k */
    private float f26514k;
    /* renamed from: l */
    private float f26515l;
    /* renamed from: m */
    private CropBoundsChangeListener f26516m;
    /* renamed from: n */
    private Runnable f26517n;
    /* renamed from: o */
    private Runnable f26518o;
    /* renamed from: p */
    private float f26519p;
    /* renamed from: q */
    private float f26520q;
    /* renamed from: r */
    private int f26521r;
    /* renamed from: s */
    private int f26522s;
    /* renamed from: t */
    private long f26523t;

    /* renamed from: com.yanzhenjie.durban.view.CropImageView$a */
    private static class C7799a implements Runnable {
        /* renamed from: a */
        private final WeakReference<CropImageView> f26524a;
        /* renamed from: b */
        private final long f26525b;
        /* renamed from: c */
        private final long f26526c = System.currentTimeMillis();
        /* renamed from: d */
        private final float f26527d;
        /* renamed from: e */
        private final float f26528e;
        /* renamed from: f */
        private final float f26529f;
        /* renamed from: g */
        private final float f26530g;
        /* renamed from: h */
        private final float f26531h;
        /* renamed from: i */
        private final float f26532i;
        /* renamed from: j */
        private final boolean f26533j;

        public C7799a(CropImageView cropImageView, long j, float f, float f2, float f3, float f4, float f5, float f6, boolean z) {
            this.f26524a = new WeakReference<>(cropImageView);
            this.f26525b = j;
            this.f26527d = f;
            this.f26528e = f2;
            this.f26529f = f3;
            this.f26530g = f4;
            this.f26531h = f5;
            this.f26532i = f6;
            this.f26533j = z;
        }

        public void run() {
            CropImageView cropImageView = (CropImageView) this.f26524a.get();
            if (cropImageView != null) {
                float min = (float) Math.min(this.f26525b, System.currentTimeMillis() - this.f26526c);
                float a = CubicEasing.m33819a(min, 0.0f, this.f26529f, (float) this.f26525b);
                float a2 = CubicEasing.m33819a(min, 0.0f, this.f26530g, (float) this.f26525b);
                float b = CubicEasing.m33820b(min, 0.0f, this.f26532i, (float) this.f26525b);
                if (min < ((float) this.f26525b)) {
                    cropImageView.mo37933a(a - (cropImageView.f26585b[0] - this.f26527d), a2 - (cropImageView.f26585b[1] - this.f26528e));
                    if (!this.f26533j) {
                        cropImageView.mo37875b(this.f26531h + b, cropImageView.f26512i.centerX(), cropImageView.f26512i.centerY());
                    }
                    if (!cropImageView.mo37879d()) {
                        cropImageView.post(this);
                    }
                }
            }
        }
    }

    /* renamed from: com.yanzhenjie.durban.view.CropImageView$b */
    private static class C7800b implements Runnable {
        /* renamed from: a */
        private final WeakReference<CropImageView> f26534a;
        /* renamed from: b */
        private final long f26535b;
        /* renamed from: c */
        private final long f26536c = System.currentTimeMillis();
        /* renamed from: d */
        private final float f26537d;
        /* renamed from: e */
        private final float f26538e;
        /* renamed from: f */
        private final float f26539f;
        /* renamed from: g */
        private final float f26540g;

        public C7800b(CropImageView cropImageView, long j, float f, float f2, float f3, float f4) {
            this.f26534a = new WeakReference<>(cropImageView);
            this.f26535b = j;
            this.f26537d = f;
            this.f26538e = f2;
            this.f26539f = f3;
            this.f26540g = f4;
        }

        public void run() {
            CropImageView cropImageView = (CropImageView) this.f26534a.get();
            if (cropImageView != null) {
                float min = (float) Math.min(this.f26535b, System.currentTimeMillis() - this.f26536c);
                float b = CubicEasing.m33820b(min, 0.0f, this.f26538e, (float) this.f26535b);
                if (min < ((float) this.f26535b)) {
                    cropImageView.mo37875b(this.f26537d + b, this.f26539f, this.f26540g);
                    cropImageView.post(this);
                } else {
                    cropImageView.mo37873b();
                }
            }
        }
    }

    public CropImageView(Context context) {
        this(context, null);
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CropImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f26512i = new RectF();
        this.f26513j = new Matrix();
        this.f26515l = 10.0f;
        this.f26518o = null;
        this.f26521r = 0;
        this.f26522s = 0;
        this.f26523t = 500;
    }

    /* renamed from: a */
    public void mo37871a(CompressFormat compressFormat, int i, BitmapCropCallback aVar) {
        mo37866a();
        setImageToWrapCropBounds(false);
        ImageState cVar = new ImageState(this.f26512i, RectUtils.m33853b(this.f26584a), getCurrentScale(), getCurrentAngle());
        CropParameters aVar2 = new CropParameters(this.f26521r, this.f26522s, compressFormat, i, getImagePath(), getOutputDirectory(), getExifInfo());
        BitmapCropTask aVar3 = new BitmapCropTask(getContext(), getViewBitmap(), cVar, aVar2, aVar);
        aVar3.execute(new Void[0]);
    }

    public float getMaxScale() {
        return this.f26519p;
    }

    public float getMinScale() {
        return this.f26520q;
    }

    public float getTargetAspectRatio() {
        return this.f26514k;
    }

    public void setCropRect(RectF rectF) {
        this.f26514k = rectF.width() / rectF.height();
        this.f26512i.set(rectF.left - ((float) getPaddingLeft()), rectF.top - ((float) getPaddingTop()), rectF.right - ((float) getPaddingRight()), rectF.bottom - ((float) getPaddingBottom()));
        m33877g();
        mo37873b();
    }

    public void setTargetAspectRatio(float f) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            this.f26514k = f;
            return;
        }
        if (f == 0.0f) {
            this.f26514k = ((float) drawable.getIntrinsicWidth()) / ((float) drawable.getIntrinsicHeight());
        } else {
            this.f26514k = f;
        }
        CropBoundsChangeListener cVar = this.f26516m;
        if (cVar != null) {
            cVar.mo37812a(this.f26514k);
        }
    }

    public CropBoundsChangeListener getCropBoundsChangeListener() {
        return this.f26516m;
    }

    public void setCropBoundsChangeListener(CropBoundsChangeListener cVar) {
        this.f26516m = cVar;
    }

    public void setMaxResultImageSizeX(int i) {
        this.f26521r = i;
    }

    public void setMaxResultImageSizeY(int i) {
        this.f26522s = i;
    }

    public void setImageToWrapCropBoundsAnimDuration(long j) {
        if (j > 0) {
            this.f26523t = j;
            return;
        }
        throw new IllegalArgumentException("Animation duration cannot be negative value.");
    }

    public void setMaxScaleMultiplier(float f) {
        this.f26515l = f;
    }

    /* renamed from: a */
    public void mo37867a(float f) {
        mo37868a(f, this.f26512i.centerX(), this.f26512i.centerY());
    }

    /* renamed from: a */
    public void mo37868a(float f, float f2, float f3) {
        if (f >= getMinScale()) {
            mo37878c(f / getCurrentScale(), f2, f3);
        }
    }

    /* renamed from: b */
    public void mo37874b(float f) {
        mo37875b(f, this.f26512i.centerX(), this.f26512i.centerY());
    }

    /* renamed from: b */
    public void mo37875b(float f, float f2, float f3) {
        if (f <= getMaxScale()) {
            mo37878c(f / getCurrentScale(), f2, f3);
        }
    }

    /* renamed from: c */
    public void mo37878c(float f, float f2, float f3) {
        if (f > 1.0f && getCurrentScale() * f <= getMaxScale()) {
            super.mo37878c(f, f2, f3);
        } else if (f < 1.0f && getCurrentScale() * f >= getMinScale()) {
            super.mo37878c(f, f2, f3);
        }
    }

    /* renamed from: c */
    public void mo37877c(float f) {
        mo37935d(f, this.f26512i.centerX(), this.f26512i.centerY());
    }

    /* renamed from: a */
    public void mo37866a() {
        removeCallbacks(this.f26517n);
        removeCallbacks(this.f26518o);
    }

    /* renamed from: b */
    public void mo37873b() {
        setImageToWrapCropBounds(true);
    }

    public void setImageToWrapCropBounds(boolean z) {
        float f;
        float f2;
        float f3;
        if (this.f26591h && !mo37879d()) {
            float f4 = this.f26585b[0];
            float f5 = this.f26585b[1];
            float currentScale = getCurrentScale();
            float centerX = this.f26512i.centerX() - f4;
            float centerY = this.f26512i.centerY() - f5;
            this.f26513j.reset();
            this.f26513j.setTranslate(centerX, centerY);
            float[] copyOf = Arrays.copyOf(this.f26584a, this.f26584a.length);
            this.f26513j.mapPoints(copyOf);
            boolean a = mo37872a(copyOf);
            if (a) {
                float[] f6 = m33876f();
                f2 = -(f6[1] + f6[3]);
                f3 = -(f6[0] + f6[2]);
                f = 0.0f;
            } else {
                RectF rectF = new RectF(this.f26512i);
                this.f26513j.reset();
                this.f26513j.setRotate(getCurrentAngle());
                this.f26513j.mapRect(rectF);
                float[] a2 = RectUtils.m33852a(this.f26584a);
                f3 = centerX;
                f = (Math.max(rectF.width() / a2[0], rectF.height() / a2[1]) * currentScale) - currentScale;
                f2 = centerY;
            }
            if (z) {
                C7799a aVar = new C7799a(this, this.f26523t, f4, f5, f3, f2, currentScale, f, a);
                this.f26517n = aVar;
                post(aVar);
                return;
            }
            mo37933a(f3, f2);
            if (!a) {
                mo37875b(currentScale + f, this.f26512i.centerX(), this.f26512i.centerY());
            }
        }
    }

    /* renamed from: f */
    private float[] m33876f() {
        this.f26513j.reset();
        this.f26513j.setRotate(-getCurrentAngle());
        float[] copyOf = Arrays.copyOf(this.f26584a, this.f26584a.length);
        float[] a = RectUtils.m33851a(this.f26512i);
        this.f26513j.mapPoints(copyOf);
        this.f26513j.mapPoints(a);
        RectF b = RectUtils.m33853b(copyOf);
        RectF b2 = RectUtils.m33853b(a);
        float f = b.left - b2.left;
        float f2 = b.top - b2.top;
        float f3 = b.right - b2.right;
        float f4 = b.bottom - b2.bottom;
        float[] fArr = new float[4];
        if (f <= 0.0f) {
            f = 0.0f;
        }
        fArr[0] = f;
        if (f2 <= 0.0f) {
            f2 = 0.0f;
        }
        fArr[1] = f2;
        if (f3 >= 0.0f) {
            f3 = 0.0f;
        }
        fArr[2] = f3;
        if (f4 >= 0.0f) {
            f4 = 0.0f;
        }
        fArr[3] = f4;
        this.f26513j.reset();
        this.f26513j.setRotate(getCurrentAngle());
        this.f26513j.mapPoints(fArr);
        return fArr;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo37876c() {
        super.mo37876c();
        Drawable drawable = getDrawable();
        if (drawable != null) {
            float intrinsicWidth = (float) drawable.getIntrinsicWidth();
            float intrinsicHeight = (float) drawable.getIntrinsicHeight();
            if (this.f26514k == 0.0f) {
                this.f26514k = intrinsicWidth / intrinsicHeight;
            }
            int i = (int) (((float) this.f26587d) / this.f26514k);
            if (i > this.f26588e) {
                int i2 = (int) (((float) this.f26588e) * this.f26514k);
                int i3 = (this.f26587d - i2) / 2;
                this.f26512i.set((float) i3, 0.0f, (float) (i2 + i3), (float) this.f26588e);
            } else {
                int i4 = (this.f26588e - i) / 2;
                this.f26512i.set(0.0f, (float) i4, (float) this.f26587d, (float) (i + i4));
            }
            m33874b(intrinsicWidth, intrinsicHeight);
            m33875c(intrinsicWidth, intrinsicHeight);
            CropBoundsChangeListener cVar = this.f26516m;
            if (cVar != null) {
                cVar.mo37812a(this.f26514k);
            }
            if (this.f26589f != null) {
                this.f26589f.mo37803b(getCurrentScale());
                this.f26589f.mo37801a(getCurrentAngle());
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public boolean mo37879d() {
        return mo37872a(this.f26584a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo37872a(float[] fArr) {
        this.f26513j.reset();
        this.f26513j.setRotate(-getCurrentAngle());
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        this.f26513j.mapPoints(copyOf);
        float[] a = RectUtils.m33851a(this.f26512i);
        this.f26513j.mapPoints(a);
        return RectUtils.m33853b(copyOf).contains(RectUtils.m33853b(a));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo37869a(float f, float f2, float f3, long j) {
        if (f > getMaxScale()) {
            f = getMaxScale();
        }
        float currentScale = getCurrentScale();
        C7800b bVar = new C7800b(this, j, currentScale, f - currentScale, f2, f3);
        this.f26518o = bVar;
        post(bVar);
    }

    /* renamed from: g */
    private void m33877g() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            m33874b((float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
        }
    }

    /* renamed from: b */
    private void m33874b(float f, float f2) {
        this.f26520q = Math.min(Math.min(this.f26512i.width() / f, this.f26512i.width() / f2), Math.min(this.f26512i.height() / f2, this.f26512i.height() / f));
        this.f26519p = this.f26520q * this.f26515l;
    }

    /* renamed from: c */
    private void m33875c(float f, float f2) {
        float width = this.f26512i.width();
        float height = this.f26512i.height();
        float max = Math.max(this.f26512i.width() / f, this.f26512i.height() / f2);
        float f3 = ((width - (f * max)) / 2.0f) + this.f26512i.left;
        float f4 = ((height - (f2 * max)) / 2.0f) + this.f26512i.top;
        this.f26586c.reset();
        this.f26586c.postScale(max, max);
        this.f26586c.postTranslate(f3, f4);
        setImageMatrix(this.f26586c);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo37870a(TypedArray typedArray) {
        float abs = Math.abs(typedArray.getFloat(R.styleable.durban_CropView_durban_aspect_ratio_x, 0.0f));
        float abs2 = Math.abs(typedArray.getFloat(R.styleable.durban_CropView_durban_aspect_ratio_y, 0.0f));
        if (abs == 0.0f || abs2 == 0.0f) {
            this.f26514k = 0.0f;
        } else {
            this.f26514k = abs / abs2;
        }
    }
}
