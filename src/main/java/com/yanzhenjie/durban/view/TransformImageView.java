package com.yanzhenjie.durban.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView.ScaleType;
import androidx.appcompat.widget.AppCompatImageView;
import com.yanzhenjie.durban.model.ExifInfo;
import com.yanzhenjie.durban.p630a.BitmapLoadCallback;
import com.yanzhenjie.durban.p631b.BitmapLoadTask;
import com.yanzhenjie.durban.p632c.BitmapLoadUtils;
import com.yanzhenjie.durban.p632c.FastBitmapDrawable;
import com.yanzhenjie.durban.p632c.RectUtils;

public class TransformImageView extends AppCompatImageView {
    /* renamed from: a */
    protected final float[] f26584a;
    /* renamed from: b */
    protected final float[] f26585b;
    /* renamed from: c */
    protected Matrix f26586c;
    /* renamed from: d */
    protected int f26587d;
    /* renamed from: e */
    protected int f26588e;
    /* renamed from: f */
    protected C7808a f26589f;
    /* renamed from: g */
    protected boolean f26590g;
    /* renamed from: h */
    protected boolean f26591h;
    /* renamed from: i */
    private final float[] f26592i;
    /* renamed from: j */
    private float[] f26593j;
    /* renamed from: k */
    private float[] f26594k;
    /* renamed from: l */
    private int f26595l;
    /* renamed from: m */
    private String f26596m;
    /* renamed from: n */
    private String f26597n;
    /* access modifiers changed from: private */
    /* renamed from: o */
    public ExifInfo f26598o;

    /* renamed from: com.yanzhenjie.durban.view.TransformImageView$a */
    public interface C7808a {
        /* renamed from: a */
        void mo37800a();

        /* renamed from: a */
        void mo37801a(float f);

        /* renamed from: b */
        void mo37802b();

        /* renamed from: b */
        void mo37803b(float f);
    }

    public TransformImageView(Context context) {
        this(context, null);
    }

    public TransformImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TransformImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f26584a = new float[8];
        this.f26585b = new float[2];
        this.f26592i = new float[9];
        this.f26586c = new Matrix();
        this.f26590g = false;
        this.f26591h = false;
        this.f26595l = 0;
        mo37897e();
    }

    public void setTransformImageListener(C7808a aVar) {
        this.f26589f = aVar;
    }

    public void setScaleType(ScaleType scaleType) {
        if (scaleType == ScaleType.MATRIX) {
            super.setScaleType(scaleType);
        } else {
            Log.w("TransformImageView", "Invalid ScaleType. Only ScaleType.MATRIX can be used");
        }
    }

    public void setMaxBitmapSize(int i) {
        this.f26595l = i;
    }

    public int getMaxBitmapSize() {
        if (this.f26595l <= 0) {
            this.f26595l = BitmapLoadUtils.m33814a(getContext());
        }
        return this.f26595l;
    }

    public void setImageBitmap(Bitmap bitmap) {
        setImageDrawable(new FastBitmapDrawable(bitmap));
    }

    public String getImagePath() {
        return this.f26596m;
    }

    public String getOutputDirectory() {
        return this.f26597n;
    }

    public ExifInfo getExifInfo() {
        return this.f26598o;
    }

    public void setOutputDirectory(String str) {
        this.f26597n = str;
    }

    public void setImagePath(String str) throws Exception {
        this.f26596m = str;
        int maxBitmapSize = getMaxBitmapSize();
        new BitmapLoadTask(getContext(), maxBitmapSize, maxBitmapSize, new BitmapLoadCallback() {
            /* renamed from: a */
            public void mo37811a(Bitmap bitmap, ExifInfo bVar) {
                TransformImageView.this.f26598o = bVar;
                TransformImageView transformImageView = TransformImageView.this;
                transformImageView.f26590g = true;
                transformImageView.setImageBitmap(bitmap);
            }

            /* renamed from: a */
            public void mo37810a() {
                if (TransformImageView.this.f26589f != null) {
                    TransformImageView.this.f26589f.mo37802b();
                }
            }
        }).execute(new String[]{str});
    }

    public float getCurrentScale() {
        return mo37931a(this.f26586c);
    }

    /* renamed from: a */
    public float mo37931a(Matrix matrix) {
        return (float) Math.sqrt(Math.pow((double) mo37932a(matrix, 0), 2.0d) + Math.pow((double) mo37932a(matrix, 3), 2.0d));
    }

    public float getCurrentAngle() {
        return mo37934b(this.f26586c);
    }

    /* renamed from: b */
    public float mo37934b(Matrix matrix) {
        return (float) (-(Math.atan2((double) mo37932a(matrix, 1), (double) mo37932a(matrix, 0)) * 57.29577951308232d));
    }

    public void setImageMatrix(Matrix matrix) {
        super.setImageMatrix(matrix);
        this.f26586c.set(matrix);
        mo37866a();
    }

    public Bitmap getViewBitmap() {
        if (getDrawable() == null || !(getDrawable() instanceof FastBitmapDrawable)) {
            return null;
        }
        return ((FastBitmapDrawable) getDrawable()).mo37824a();
    }

    /* renamed from: a */
    public void mo37933a(float f, float f2) {
        if (f != 0.0f || f2 != 0.0f) {
            this.f26586c.postTranslate(f, f2);
            setImageMatrix(this.f26586c);
        }
    }

    /* renamed from: c */
    public void mo37878c(float f, float f2, float f3) {
        if (f != 0.0f) {
            this.f26586c.postScale(f, f, f2, f3);
            setImageMatrix(this.f26586c);
            C7808a aVar = this.f26589f;
            if (aVar != null) {
                aVar.mo37803b(mo37931a(this.f26586c));
            }
        }
    }

    /* renamed from: d */
    public void mo37935d(float f, float f2, float f3) {
        if (f != 0.0f) {
            this.f26586c.postRotate(f, f2, f3);
            setImageMatrix(this.f26586c);
            C7808a aVar = this.f26589f;
            if (aVar != null) {
                aVar.mo37801a(mo37934b(this.f26586c));
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo37897e() {
        setScaleType(ScaleType.MATRIX);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z || (this.f26590g && !this.f26591h)) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int height = getHeight() - getPaddingBottom();
            this.f26587d = (getWidth() - getPaddingRight()) - paddingLeft;
            this.f26588e = height - paddingTop;
            mo37876c();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo37876c() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            float intrinsicWidth = (float) drawable.getIntrinsicWidth();
            float intrinsicHeight = (float) drawable.getIntrinsicHeight();
            Log.d("TransformImageView", String.format("Image size: [%d:%d]", new Object[]{Integer.valueOf((int) intrinsicWidth), Integer.valueOf((int) intrinsicHeight)}));
            RectF rectF = new RectF(0.0f, 0.0f, intrinsicWidth, intrinsicHeight);
            this.f26593j = RectUtils.m33851a(rectF);
            this.f26594k = RectUtils.m33854b(rectF);
            this.f26591h = true;
            C7808a aVar = this.f26589f;
            if (aVar != null) {
                aVar.mo37800a();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public float mo37932a(Matrix matrix, int i) {
        matrix.getValues(this.f26592i);
        return this.f26592i[i];
    }

    /* renamed from: a */
    private void mo37866a() {
        this.f26586c.mapPoints(this.f26584a, this.f26593j);
        this.f26586c.mapPoints(this.f26585b, this.f26594k);
    }
}
