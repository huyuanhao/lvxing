package com.scwang.smartrefresh.header;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.scwang.smartrefresh.header.p526a.StoreHouseBarItem;
import com.scwang.smartrefresh.header.p526a.StoreHousePath;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.scwang.smartrefresh.layout.p527a.RefreshHeader;
import com.scwang.smartrefresh.layout.p527a.RefreshInternal;
import com.scwang.smartrefresh.layout.p527a.RefreshKernel;
import com.scwang.smartrefresh.layout.p527a.RefreshLayout;
import com.scwang.smartrefresh.layout.p529c.DensityUtil;
import java.util.ArrayList;
import java.util.List;

public class StoreHouseHeader extends InternalAbstract implements RefreshHeader {
    /* renamed from: a */
    public List<StoreHouseBarItem> f20473a;
    /* renamed from: b */
    protected int f20474b;
    /* renamed from: c */
    protected float f20475c;
    /* renamed from: d */
    protected int f20476d;
    /* renamed from: e */
    protected int f20477e;
    /* renamed from: f */
    protected float f20478f;
    /* renamed from: g */
    protected int f20479g;
    /* renamed from: h */
    protected int f20480h;
    /* renamed from: i */
    protected int f20481i;
    /* renamed from: j */
    protected int f20482j;
    /* renamed from: k */
    protected int f20483k;
    /* renamed from: l */
    protected int f20484l;
    /* renamed from: m */
    protected int f20485m;
    /* renamed from: n */
    protected int f20486n;
    /* renamed from: o */
    protected boolean f20487o;
    /* renamed from: p */
    protected boolean f20488p;
    /* renamed from: q */
    protected Matrix f20489q;
    /* renamed from: r */
    protected RefreshKernel f20490r;
    /* renamed from: s */
    protected C6457a f20491s;
    /* renamed from: t */
    protected Transformation f20492t;

    /* renamed from: com.scwang.smartrefresh.header.StoreHouseHeader$a */
    private class C6457a implements Runnable {
        /* renamed from: a */
        int f20494a;
        /* renamed from: b */
        int f20495b;
        /* renamed from: c */
        int f20496c;
        /* renamed from: d */
        int f20497d;
        /* renamed from: e */
        boolean f20498e;

        private C6457a() {
            this.f20494a = 0;
            this.f20495b = 0;
            this.f20496c = 0;
            this.f20497d = 0;
            this.f20498e = true;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m25344a() {
            this.f20498e = true;
            this.f20494a = 0;
            this.f20497d = StoreHouseHeader.this.f20483k / StoreHouseHeader.this.f20473a.size();
            this.f20495b = StoreHouseHeader.this.f20484l / this.f20497d;
            this.f20496c = (StoreHouseHeader.this.f20473a.size() / this.f20495b) + 1;
            run();
        }

        public void run() {
            int i = this.f20494a % this.f20495b;
            for (int i2 = 0; i2 < this.f20496c; i2++) {
                int i3 = (this.f20495b * i2) + i;
                if (i3 <= this.f20494a) {
                    StoreHouseBarItem aVar = (StoreHouseBarItem) StoreHouseHeader.this.f20473a.get(i3 % StoreHouseHeader.this.f20473a.size());
                    aVar.setFillAfter(false);
                    aVar.setFillEnabled(true);
                    aVar.setFillBefore(false);
                    aVar.setDuration(400);
                    aVar.mo30747a(1.0f, 0.4f);
                }
            }
            this.f20494a++;
            if (this.f20498e && StoreHouseHeader.this.f20490r != null) {
                StoreHouseHeader.this.f20490r.mo30931a().getLayout().postDelayed(this, (long) this.f20497d);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public void m25346b() {
            this.f20498e = false;
            StoreHouseHeader.this.removeCallbacks(this);
        }
    }

    public StoreHouseHeader(Context context) {
        this(context, null);
    }

    public StoreHouseHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StoreHouseHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20473a = new ArrayList();
        this.f20474b = -1;
        this.f20475c = 1.0f;
        this.f20476d = -1;
        this.f20477e = -1;
        this.f20478f = 0.0f;
        this.f20479g = 0;
        this.f20480h = 0;
        this.f20481i = 0;
        this.f20482j = 0;
        this.f20483k = 1000;
        this.f20484l = 1000;
        this.f20485m = -1;
        this.f20486n = 0;
        this.f20487o = false;
        this.f20488p = false;
        this.f20489q = new Matrix();
        this.f20491s = new C6457a();
        this.f20492t = new Transformation();
        DensityUtil bVar = new DensityUtil();
        this.f20474b = bVar.mo30968b(1.0f);
        this.f20476d = bVar.mo30968b(40.0f);
        this.f20477e = Resources.getSystem().getDisplayMetrics().widthPixels / 2;
        this.f20486n = -13421773;
        mo30718a(-3355444);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StoreHouseHeader);
        this.f20474b = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.StoreHouseHeader_shhLineWidth, this.f20474b);
        this.f20476d = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.StoreHouseHeader_shhDropHeight, this.f20476d);
        this.f20488p = obtainStyledAttributes.getBoolean(R.styleable.StoreHouseHeader_shhEnableFadeAnimation, this.f20488p);
        if (obtainStyledAttributes.hasValue(R.styleable.StoreHouseHeader_shhText)) {
            mo30719a(obtainStyledAttributes.getString(R.styleable.StoreHouseHeader_shhText));
        } else {
            mo30719a("StoreHouse");
        }
        obtainStyledAttributes.recycle();
        setMinimumHeight(this.f20480h + DensityUtil.m25572a(40.0f));
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.setMeasuredDimension(View.resolveSize(super.getSuggestedMinimumWidth(), i), View.resolveSize(super.getSuggestedMinimumHeight(), i2));
        this.f20481i = (getMeasuredWidth() - this.f20479g) / 2;
        this.f20482j = (getMeasuredHeight() - this.f20480h) / 2;
        this.f20476d = getMeasuredHeight() / 2;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        int save = canvas.save();
        int size = this.f20473a.size();
        float f = isInEditMode() ? 1.0f : this.f20478f;
        for (int i = 0; i < size; i++) {
            canvas.save();
            StoreHouseBarItem aVar = (StoreHouseBarItem) this.f20473a.get(i);
            float f2 = ((float) this.f20481i) + aVar.f20546a.x;
            float f3 = ((float) this.f20482j) + aVar.f20546a.y;
            if (this.f20487o) {
                aVar.getTransformation(getDrawingTime(), this.f20492t);
                canvas.translate(f2, f3);
            } else {
                float f4 = 0.0f;
                if (f == 0.0f) {
                    aVar.mo30752c(this.f20477e);
                } else {
                    float f5 = (((float) i) * 0.3f) / ((float) size);
                    float f6 = 0.3f - f5;
                    if (f == 1.0f || f >= 1.0f - f6) {
                        canvas.translate(f2, f3);
                        aVar.mo30746a(0.4f);
                    } else {
                        if (f > f5) {
                            f4 = Math.min(1.0f, (f - f5) / 0.7f);
                        }
                        float f7 = 1.0f - f4;
                        float f8 = f2 + (aVar.f20547b * f7);
                        float f9 = f3 + (((float) (-this.f20476d)) * f7);
                        this.f20489q.reset();
                        this.f20489q.postRotate(360.0f * f4);
                        this.f20489q.postScale(f4, f4);
                        this.f20489q.postTranslate(f8, f9);
                        aVar.mo30746a(f4 * 0.4f);
                        canvas.concat(this.f20489q);
                    }
                }
            }
            aVar.mo30749a(canvas);
            canvas.restore();
        }
        if (this.f20487o) {
            invalidate();
        }
        canvas.restoreToCount(save);
        super.dispatchDraw(canvas);
    }

    /* renamed from: a */
    public StoreHouseHeader mo30718a(int i) {
        this.f20485m = i;
        for (int i2 = 0; i2 < this.f20473a.size(); i2++) {
            ((StoreHouseBarItem) this.f20473a.get(i2)).mo30751b(i);
        }
        return this;
    }

    /* renamed from: a */
    public StoreHouseHeader mo30719a(String str) {
        mo30720a(str, 25);
        return this;
    }

    /* renamed from: a */
    public StoreHouseHeader mo30720a(String str, int i) {
        mo30721a(StoreHousePath.m25374a(str, ((float) i) * 0.01f, 14));
        return this;
    }

    /* renamed from: a */
    public StoreHouseHeader mo30721a(List<float[]> list) {
        boolean z = this.f20473a.size() > 0;
        this.f20473a.clear();
        DensityUtil bVar = new DensityUtil();
        int i = 0;
        float f = 0.0f;
        float f2 = 0.0f;
        while (i < list.size()) {
            float[] fArr = (float[]) list.get(i);
            PointF pointF = new PointF(((float) bVar.mo30968b(fArr[0])) * this.f20475c, ((float) bVar.mo30968b(fArr[1])) * this.f20475c);
            PointF pointF2 = new PointF(((float) bVar.mo30968b(fArr[2])) * this.f20475c, ((float) bVar.mo30968b(fArr[3])) * this.f20475c);
            float max = Math.max(Math.max(f, pointF.x), pointF2.x);
            float max2 = Math.max(Math.max(f2, pointF.y), pointF2.y);
            StoreHouseBarItem aVar = new StoreHouseBarItem(i, pointF, pointF2, this.f20485m, this.f20474b);
            aVar.mo30752c(this.f20477e);
            this.f20473a.add(aVar);
            i++;
            f = max;
            f2 = max2;
        }
        this.f20479g = (int) Math.ceil((double) f);
        this.f20480h = (int) Math.ceil((double) f2);
        if (z) {
            requestLayout();
        }
        return this;
    }

    /* renamed from: a */
    public void mo30677a(RefreshKernel iVar, int i, int i2) {
        this.f20490r = iVar;
        this.f20490r.mo30927a((RefreshInternal) this, this.f20486n);
    }

    /* renamed from: a */
    public void mo30672a(boolean z, float f, int i, int i2, int i3) {
        this.f20478f = f * 0.8f;
        invalidate();
    }

    /* renamed from: a */
    public void mo30671a(RefreshLayout jVar, int i, int i2) {
        this.f20487o = true;
        this.f20491s.m25344a();
        invalidate();
    }

    /* renamed from: a */
    public int mo30670a(RefreshLayout jVar, boolean z) {
        this.f20487o = false;
        this.f20491s.m25346b();
        if (!z || !this.f20488p) {
            for (int i = 0; i < this.f20473a.size(); i++) {
                ((StoreHouseBarItem) this.f20473a.get(i)).mo30752c(this.f20477e);
            }
            return 0;
        }
        startAnimation(new Animation() {
            {
                super.setDuration(250);
                super.setInterpolator(new AccelerateInterpolator());
            }

            /* access modifiers changed from: protected */
            public void applyTransformation(float f, Transformation transformation) {
                StoreHouseHeader storeHouseHeader = StoreHouseHeader.this;
                storeHouseHeader.f20478f = 1.0f - f;
                storeHouseHeader.invalidate();
                if (f == 1.0f) {
                    for (int i = 0; i < StoreHouseHeader.this.f20473a.size(); i++) {
                        ((StoreHouseBarItem) StoreHouseHeader.this.f20473a.get(i)).mo30752c(StoreHouseHeader.this.f20477e);
                    }
                }
            }
        });
        return 250;
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0) {
            this.f20486n = iArr[0];
            RefreshKernel iVar = this.f20490r;
            if (iVar != null) {
                iVar.mo30927a((RefreshInternal) this, this.f20486n);
            }
            if (iArr.length > 1) {
                mo30718a(iArr[1]);
            }
        }
    }
}
