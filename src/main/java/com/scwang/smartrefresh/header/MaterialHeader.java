package com.scwang.smartrefresh.header;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import com.scwang.smartrefresh.header.material.CircleImageView;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.scwang.smartrefresh.layout.p527a.RefreshHeader;
import com.scwang.smartrefresh.layout.p527a.RefreshKernel;
import com.scwang.smartrefresh.layout.p527a.RefreshLayout;
import com.scwang.smartrefresh.layout.p529c.DensityUtil;

public class MaterialHeader extends InternalAbstract implements RefreshHeader {
    /* renamed from: a */
    protected boolean f20444a;
    /* renamed from: b */
    protected int f20445b;
    /* renamed from: c */
    protected ImageView f20446c;
    /* renamed from: d */
    protected MaterialProgressDrawable f20447d;
    /* renamed from: e */
    protected int f20448e;
    /* renamed from: f */
    protected int f20449f;
    /* renamed from: g */
    protected Path f20450g;
    /* renamed from: h */
    protected Paint f20451h;
    /* renamed from: i */
    protected boolean f20452i;
    /* renamed from: j */
    protected RefreshState f20453j;

    /* renamed from: com.scwang.smartrefresh.header.MaterialHeader$1 */
    static /* synthetic */ class C64531 {
        /* renamed from: a */
        static final /* synthetic */ int[] f20454a = new int[RefreshState.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
            com.scwang.smartrefresh.layout.constant.RefreshState[] r0 = com.scwang.smartrefresh.layout.constant.RefreshState.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f20454a = r0
            int[] r0 = f20454a     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.None     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f20454a     // Catch:{ NoSuchFieldError -> 0x001f }
            com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.PullDownToRefresh     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            int[] r0 = f20454a     // Catch:{ NoSuchFieldError -> 0x002a }
            com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.ReleaseToRefresh     // Catch:{ NoSuchFieldError -> 0x002a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            int[] r0 = f20454a     // Catch:{ NoSuchFieldError -> 0x0035 }
            com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.Refreshing     // Catch:{ NoSuchFieldError -> 0x0035 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.header.MaterialHeader.C64531.m51018clinit():void");
        }
    }

    public MaterialHeader(Context context) {
        this(context, null);
    }

    public MaterialHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaterialHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20452i = false;
        this.f20937ab = SpinnerStyle.MatchLayout;
        setMinimumHeight(DensityUtil.m25572a(100.0f));
        this.f20447d = new MaterialProgressDrawable(this);
        this.f20447d.mo30775b(-328966);
        this.f20447d.setAlpha(255);
        this.f20447d.mo30772a(-16737844, -48060, -10053376, -5609780, -30720);
        this.f20446c = new CircleImageView(context, -328966);
        this.f20446c.setImageDrawable(this.f20447d);
        addView(this.f20446c);
        this.f20445b = (int) (getResources().getDisplayMetrics().density * 40.0f);
        this.f20450g = new Path();
        this.f20451h = new Paint();
        this.f20451h.setAntiAlias(true);
        this.f20451h.setStyle(Style.FILL);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaterialHeader);
        this.f20452i = obtainStyledAttributes.getBoolean(R.styleable.MaterialHeader_mhShowBezierWave, this.f20452i);
        this.f20451h.setColor(obtainStyledAttributes.getColor(R.styleable.MaterialHeader_mhPrimaryColor, -15614977));
        if (obtainStyledAttributes.hasValue(R.styleable.MaterialHeader_mhShadowRadius)) {
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialHeader_mhShadowRadius, 0);
            this.f20451h.setShadowLayer((float) dimensionPixelOffset, 0.0f, 0.0f, obtainStyledAttributes.getColor(R.styleable.MaterialHeader_mhShadowColor, ViewCompat.MEASURED_STATE_MASK));
            setLayerType(1, null);
        }
        obtainStyledAttributes.recycle();
    }

    public void onMeasure(int i, int i2) {
        super.setMeasuredDimension(MeasureSpec.getSize(i), MeasureSpec.getSize(i2));
        this.f20446c.measure(MeasureSpec.makeMeasureSpec(this.f20445b, 1073741824), MeasureSpec.makeMeasureSpec(this.f20445b, 1073741824));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (getChildCount() != 0) {
            ImageView imageView = this.f20446c;
            int measuredWidth = getMeasuredWidth();
            int measuredWidth2 = imageView.getMeasuredWidth();
            int measuredHeight = imageView.getMeasuredHeight();
            if (isInEditMode()) {
                int i5 = this.f20449f;
                if (i5 > 0) {
                    int i6 = i5 - (measuredHeight / 2);
                    int i7 = measuredWidth / 2;
                    int i8 = measuredWidth2 / 2;
                    imageView.layout(i7 - i8, i6, i7 + i8, measuredHeight + i6);
                    this.f20447d.mo30771a(true);
                    this.f20447d.mo30768a(0.0f, 0.8f);
                    this.f20447d.mo30767a(1.0f);
                    imageView.setAlpha(1.0f);
                    imageView.setVisibility(0);
                }
            }
            int i9 = measuredWidth / 2;
            int i10 = measuredWidth2 / 2;
            int i11 = i9 - i10;
            int i12 = this.f20445b;
            imageView.layout(i11, -i12, i9 + i10, measuredHeight - i12);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (this.f20452i) {
            this.f20450g.reset();
            this.f20450g.lineTo(0.0f, (float) this.f20449f);
            this.f20450g.quadTo((float) (getMeasuredWidth() / 2), ((float) this.f20449f) + (((float) this.f20448e) * 1.9f), (float) getMeasuredWidth(), (float) this.f20449f);
            this.f20450g.lineTo((float) getMeasuredWidth(), 0.0f);
            canvas.drawPath(this.f20450g, this.f20451h);
        }
        super.dispatchDraw(canvas);
    }

    /* renamed from: a */
    public void mo30677a(RefreshKernel iVar, int i, int i2) {
        if (!this.f20452i) {
            iVar.mo30934b(this, false);
        }
        if (isInEditMode()) {
            int i3 = i / 2;
            this.f20449f = i3;
            this.f20448e = i3;
        }
    }

    /* renamed from: a */
    public void mo30672a(boolean z, float f, int i, int i2, int i3) {
        if (this.f20452i) {
            this.f20449f = Math.min(i, i2);
            this.f20448e = Math.max(0, i - i2);
            postInvalidate();
        }
        if (z || (!this.f20447d.isRunning() && !this.f20444a)) {
            ImageView imageView = this.f20446c;
            if (this.f20453j != RefreshState.Refreshing) {
                float f2 = (float) i2;
                float f3 = (((float) i) * 1.0f) / f2;
                float max = (((float) Math.max(((double) Math.min(1.0f, Math.abs(f3))) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
                double max2 = (double) (Math.max(0.0f, Math.min((float) (Math.abs(i) - i2), f2 * 2.0f) / f2) / 4.0f);
                float pow = ((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f;
                float f4 = max * 0.8f;
                this.f20447d.mo30771a(true);
                this.f20447d.mo30768a(0.0f, Math.min(0.8f, f4));
                this.f20447d.mo30767a(Math.min(1.0f, max));
                this.f20447d.mo30773b((((max * 0.4f) - 16.0f) + (pow * 2.0f)) * 0.5f);
                imageView.setAlpha(Math.min(1.0f, f3 * 2.0f));
            }
            imageView.setTranslationY(Math.min((float) i, (float) ((i / 2) + (this.f20445b / 2))));
        }
    }

    /* renamed from: a */
    public void mo30671a(RefreshLayout jVar, int i, int i2) {
        this.f20447d.start();
        ImageView imageView = this.f20446c;
        int i3 = i / 2;
        if (((int) imageView.getTranslationY()) != (this.f20445b / 2) + i3) {
            imageView.animate().translationY((float) (i3 + (this.f20445b / 2)));
        }
    }

    /* renamed from: a */
    public void mo30678a(RefreshLayout jVar, RefreshState refreshState, RefreshState refreshState2) {
        ImageView imageView = this.f20446c;
        this.f20453j = refreshState2;
        int i = C64531.f20454a[refreshState2.ordinal()];
        if (i == 1) {
            return;
        }
        if (i == 2) {
            this.f20444a = false;
            imageView.setVisibility(0);
            imageView.setTranslationY(0.0f);
            imageView.setScaleX(1.0f);
            imageView.setScaleY(1.0f);
        }
    }

    /* renamed from: a */
    public int mo30670a(RefreshLayout jVar, boolean z) {
        ImageView imageView = this.f20446c;
        this.f20447d.stop();
        imageView.animate().scaleX(0.0f).scaleY(0.0f);
        this.f20444a = true;
        return 0;
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0) {
            this.f20451h.setColor(iArr[0]);
        }
    }
}
