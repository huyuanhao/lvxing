package p706pl.droidsonroids.gif;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.widget.ImageView.ScaleType;
import com.tencent.android.tpush.SettingsContentProvider;
import java.io.IOException;
import java.lang.ref.WeakReference;
import p706pl.droidsonroids.gif.InputSource.C8598a;
import p706pl.droidsonroids.gif.InputSource.C8599b;

/* renamed from: pl.droidsonroids.gif.GifTextureView */
public class GifTextureView extends TextureView {
    /* renamed from: a */
    private static final ScaleType[] f29243a = {ScaleType.MATRIX, ScaleType.FIT_XY, ScaleType.FIT_START, ScaleType.FIT_CENTER, ScaleType.FIT_END, ScaleType.CENTER, ScaleType.CENTER_CROP, ScaleType.CENTER_INSIDE};
    /* renamed from: b */
    private ScaleType f29244b = ScaleType.FIT_CENTER;
    /* renamed from: c */
    private final Matrix f29245c = new Matrix();
    /* access modifiers changed from: private */
    /* renamed from: d */
    public InputSource f29246d;
    /* renamed from: e */
    private boolean f29247e;
    /* renamed from: f */
    private C8587b f29248f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public float f29249g = 1.0f;

    /* renamed from: pl.droidsonroids.gif.GifTextureView$1 */
    static /* synthetic */ class C85851 {
        /* renamed from: a */
        static final /* synthetic */ int[] f29250a = new int[ScaleType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|(3:15|16|18)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
            android.widget.ImageView$ScaleType[] r0 = android.widget.ImageView.ScaleType.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f29250a = r0
            int[] r0 = f29250a     // Catch:{ NoSuchFieldError -> 0x0014 }
            android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f29250a     // Catch:{ NoSuchFieldError -> 0x001f }
            android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            int[] r0 = f29250a     // Catch:{ NoSuchFieldError -> 0x002a }
            android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER_INSIDE     // Catch:{ NoSuchFieldError -> 0x002a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            int[] r0 = f29250a     // Catch:{ NoSuchFieldError -> 0x0035 }
            android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x0035 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            int[] r0 = f29250a     // Catch:{ NoSuchFieldError -> 0x0040 }
            android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_END     // Catch:{ NoSuchFieldError -> 0x0040 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
            r2 = 5
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
        L_0x0040:
            int[] r0 = f29250a     // Catch:{ NoSuchFieldError -> 0x004b }
            android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x004b }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
            r2 = 6
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004b }
        L_0x004b:
            int[] r0 = f29250a     // Catch:{ NoSuchFieldError -> 0x0056 }
            android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x0056 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
            r2 = 7
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0056 }
        L_0x0056:
            int[] r0 = f29250a     // Catch:{ NoSuchFieldError -> 0x0062 }
            android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.MATRIX     // Catch:{ NoSuchFieldError -> 0x0062 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
            r2 = 8
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0062 }
        L_0x0062:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: p706pl.droidsonroids.gif.GifTextureView.C85851.m55802clinit():void");
        }
    }

    /* renamed from: pl.droidsonroids.gif.GifTextureView$a */
    public interface C8586a {
        /* renamed from: a */
        void mo41202a(Canvas canvas);
    }

    /* renamed from: pl.droidsonroids.gif.GifTextureView$b */
    private static class C8587b extends Thread implements SurfaceTextureListener {
        /* renamed from: a */
        final ConditionVariable f29251a = new ConditionVariable();
        /* renamed from: b */
        long[] f29252b;
        /* access modifiers changed from: private */
        /* renamed from: c */
        public GifInfoHandle f29253c = new GifInfoHandle();
        /* access modifiers changed from: private */
        /* renamed from: d */
        public IOException f29254d;
        /* renamed from: e */
        private final WeakReference<GifTextureView> f29255e;

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        C8587b(GifTextureView gifTextureView) {
            super("GifRenderThread");
            this.f29255e = new WeakReference<>(gifTextureView);
        }

        public void run() {
            try {
                GifTextureView gifTextureView = (GifTextureView) this.f29255e.get();
                if (gifTextureView != null) {
                    this.f29253c = gifTextureView.f29246d.mo41261a();
                    this.f29253c.mo41155a(1, gifTextureView.isOpaque());
                    final GifTextureView gifTextureView2 = (GifTextureView) this.f29255e.get();
                    if (gifTextureView2 == null) {
                        this.f29253c.mo41154a();
                        return;
                    }
                    gifTextureView2.setSuperSurfaceTextureListener(this);
                    boolean isAvailable = gifTextureView2.isAvailable();
                    this.f29251a.mo41220a(isAvailable);
                    if (isAvailable) {
                        gifTextureView2.post(new Runnable() {
                            public void run() {
                                gifTextureView2.m37402a(C8587b.this.f29253c);
                            }
                        });
                    }
                    this.f29253c.mo41156a(gifTextureView2.f29249g);
                    while (!isInterrupted()) {
                        try {
                            this.f29251a.mo41222c();
                            SurfaceTexture surfaceTexture = gifTextureView2.getSurfaceTexture();
                            if (surfaceTexture != null) {
                                Surface surface = new Surface(surfaceTexture);
                                try {
                                    this.f29253c.mo41158a(surface, this.f29252b);
                                } finally {
                                    surface.release();
                                    surfaceTexture.release();
                                }
                            }
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    this.f29253c.mo41154a();
                    this.f29253c = new GifInfoHandle();
                }
            } catch (IOException e) {
                this.f29254d = e;
            }
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            GifTextureView gifTextureView = (GifTextureView) this.f29255e.get();
            if (gifTextureView != null) {
                gifTextureView.m37402a(this.f29253c);
            }
            this.f29251a.mo41219a();
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.f29251a.mo41221b();
            this.f29253c.mo41172n();
            return false;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo41203a(GifTextureView gifTextureView, C8586a aVar) {
            this.f29251a.mo41221b();
            gifTextureView.setSuperSurfaceTextureListener(aVar != null ? new PlaceholderDrawingSurfaceTextureListener(aVar) : null);
            this.f29253c.mo41172n();
            interrupt();
        }
    }

    public SurfaceTextureListener getSurfaceTextureListener() {
        return null;
    }

    public GifTextureView(Context context) {
        super(context);
        m37401a(null, 0, 0);
    }

    public GifTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m37401a(attributeSet, 0, 0);
    }

    public GifTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m37401a(attributeSet, i, 0);
    }

    /* renamed from: a */
    private void m37401a(AttributeSet attributeSet, int i, int i2) {
        if (attributeSet != null) {
            int attributeIntValue = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "scaleType", -1);
            if (attributeIntValue >= 0) {
                ScaleType[] scaleTypeArr = f29243a;
                if (attributeIntValue < scaleTypeArr.length) {
                    this.f29244b = scaleTypeArr[attributeIntValue];
                }
            }
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.GifTextureView, i, i2);
            this.f29246d = m37399a(obtainStyledAttributes);
            super.setOpaque(obtainStyledAttributes.getBoolean(R.styleable.GifTextureView_isOpaque, false));
            obtainStyledAttributes.recycle();
            this.f29247e = GifViewUtils.m37438a((View) this, attributeSet, i, i2);
        } else {
            super.setOpaque(false);
        }
        if (!isInEditMode()) {
            this.f29248f = new C8587b(this);
            if (this.f29246d != null) {
                this.f29248f.start();
            }
        }
    }

    public void setSurfaceTextureListener(SurfaceTextureListener surfaceTextureListener) {
        throw new UnsupportedOperationException("Changing SurfaceTextureListener is not supported");
    }

    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        throw new UnsupportedOperationException("Changing SurfaceTexture is not supported");
    }

    /* renamed from: a */
    private static InputSource m37399a(TypedArray typedArray) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(R.styleable.GifTextureView_gifSource, typedValue)) {
            return null;
        }
        if (typedValue.resourceId != 0) {
            String resourceTypeName = typedArray.getResources().getResourceTypeName(typedValue.resourceId);
            if (GifViewUtils.f29283a.contains(resourceTypeName)) {
                return new C8599b(typedArray.getResources(), typedValue.resourceId);
            }
            if (!SettingsContentProvider.STRING_TYPE.equals(resourceTypeName)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Expected string, drawable, mipmap or raw resource type. '");
                sb.append(resourceTypeName);
                sb.append("' is not supported");
                throw new IllegalArgumentException(sb.toString());
            }
        }
        return new C8598a(typedArray.getResources().getAssets(), typedValue.string.toString());
    }

    /* access modifiers changed from: private */
    public void setSuperSurfaceTextureListener(SurfaceTextureListener surfaceTextureListener) {
        super.setSurfaceTextureListener(surfaceTextureListener);
    }

    public void setOpaque(boolean z) {
        if (z != isOpaque()) {
            super.setOpaque(z);
            setInputSource(this.f29246d);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.f29248f.mo41203a(this, null);
        super.onDetachedFromWindow();
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
    }

    public synchronized void setInputSource(InputSource fVar) {
        mo41185a(fVar, (C8586a) null);
    }

    /* renamed from: a */
    public synchronized void mo41185a(InputSource fVar, C8586a aVar) {
        this.f29248f.mo41203a(this, aVar);
        this.f29246d = fVar;
        this.f29248f = new C8587b(this);
        if (fVar != null) {
            this.f29248f.start();
        }
    }

    public void setSpeed(float f) {
        this.f29249g = f;
        this.f29248f.f29253c.mo41156a(f);
    }

    public IOException getIOException() {
        if (this.f29248f.f29254d != null) {
            return this.f29248f.f29254d;
        }
        return GifIOException.fromCode(this.f29248f.f29253c.mo41163f());
    }

    public void setScaleType(ScaleType scaleType) {
        this.f29244b = scaleType;
        m37402a(this.f29248f.f29253c);
    }

    public ScaleType getScaleType() {
        return this.f29244b;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m37402a(GifInfoHandle gifInfoHandle) {
        Matrix matrix = new Matrix();
        float width = (float) getWidth();
        float height = (float) getHeight();
        float p = ((float) gifInfoHandle.mo41174p()) / width;
        float q = ((float) gifInfoHandle.mo41175q()) / height;
        RectF rectF = new RectF(0.0f, 0.0f, (float) gifInfoHandle.mo41174p(), (float) gifInfoHandle.mo41175q());
        RectF rectF2 = new RectF(0.0f, 0.0f, width, height);
        float f = 1.0f;
        switch (C85851.f29250a[this.f29244b.ordinal()]) {
            case 1:
                matrix.setScale(p, q, width / 2.0f, height / 2.0f);
                break;
            case 2:
                float min = 1.0f / Math.min(p, q);
                matrix.setScale(p * min, min * q, width / 2.0f, height / 2.0f);
                break;
            case 3:
                if (((float) gifInfoHandle.mo41174p()) > width || ((float) gifInfoHandle.mo41175q()) > height) {
                    f = Math.min(1.0f / p, 1.0f / q);
                }
                matrix.setScale(p * f, f * q, width / 2.0f, height / 2.0f);
                break;
            case 4:
                matrix.setRectToRect(rectF, rectF2, ScaleToFit.CENTER);
                matrix.preScale(p, q);
                break;
            case 5:
                matrix.setRectToRect(rectF, rectF2, ScaleToFit.END);
                matrix.preScale(p, q);
                break;
            case 6:
                matrix.setRectToRect(rectF, rectF2, ScaleToFit.START);
                matrix.preScale(p, q);
                break;
            case 7:
                return;
            case 8:
                matrix.set(this.f29245c);
                matrix.preScale(p, q);
                break;
        }
        super.setTransform(matrix);
    }

    public void setImageMatrix(Matrix matrix) {
        setTransform(matrix);
    }

    public void setTransform(Matrix matrix) {
        this.f29245c.set(matrix);
        m37402a(this.f29248f.f29253c);
    }

    public Matrix getTransform(Matrix matrix) {
        if (matrix == null) {
            matrix = new Matrix();
        }
        matrix.set(this.f29245c);
        return matrix;
    }

    public Parcelable onSaveInstanceState() {
        C8587b bVar = this.f29248f;
        bVar.f29252b = bVar.f29253c.mo41173o();
        return new GifViewSavedState(super.onSaveInstanceState(), this.f29247e ? this.f29248f.f29252b : null);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof GifViewSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        GifViewSavedState gifViewSavedState = (GifViewSavedState) parcelable;
        super.onRestoreInstanceState(gifViewSavedState.getSuperState());
        this.f29248f.f29252b = gifViewSavedState.f29258a[0];
    }

    public void setFreezesAnimation(boolean z) {
        this.f29247e = z;
    }
}
