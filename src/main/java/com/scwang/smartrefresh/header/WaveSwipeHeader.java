package com.scwang.smartrefresh.header;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View.MeasureSpec;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import com.scwang.smartrefresh.header.waveswipe.WaveView;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.scwang.smartrefresh.layout.p527a.RefreshHeader;
import com.scwang.smartrefresh.layout.p527a.RefreshLayout;
import com.scwang.smartrefresh.layout.p529c.DensityUtil;

public class WaveSwipeHeader extends InternalAbstract implements RefreshHeader {
    /* renamed from: a */
    protected WaveView f20534a;
    /* renamed from: b */
    protected RefreshState f20535b;
    /* renamed from: c */
    protected MaterialProgressDrawable f20536c;
    /* renamed from: d */
    protected ProgressAnimationImageView f20537d;
    /* renamed from: e */
    protected float f20538e;

    /* renamed from: com.scwang.smartrefresh.header.WaveSwipeHeader$4 */
    static /* synthetic */ class C64664 {
        /* renamed from: a */
        static final /* synthetic */ int[] f20543a = new int[RefreshState.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
     */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
            com.scwang.smartrefresh.layout.constant.RefreshState[] r0 = com.scwang.smartrefresh.layout.constant.RefreshState.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f20543a = r0
            int[] r0 = f20543a     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.None     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f20543a     // Catch:{ NoSuchFieldError -> 0x001f }
            com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.PullDownToRefresh     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            int[] r0 = f20543a     // Catch:{ NoSuchFieldError -> 0x002a }
            com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.PullDownCanceled     // Catch:{ NoSuchFieldError -> 0x002a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            int[] r0 = f20543a     // Catch:{ NoSuchFieldError -> 0x0035 }
            com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.ReleaseToRefresh     // Catch:{ NoSuchFieldError -> 0x0035 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            int[] r0 = f20543a     // Catch:{ NoSuchFieldError -> 0x0040 }
            com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.Refreshing     // Catch:{ NoSuchFieldError -> 0x0040 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
            r2 = 5
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
        L_0x0040:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.header.WaveSwipeHeader.C64664.m51054clinit():void");
        }
    }

    /* renamed from: com.scwang.smartrefresh.header.WaveSwipeHeader$ProgressAnimationImageView */
    protected class ProgressAnimationImageView extends ImageView {
        /* renamed from: a */
        protected AnimationListener f20544a;

        public void setAnimationListener(AnimationListener animationListener) {
            this.f20544a = animationListener;
        }

        public void onAnimationStart() {
            super.onAnimationStart();
            AnimationListener animationListener = this.f20544a;
            if (animationListener != null) {
                animationListener.onAnimationStart(getAnimation());
            }
        }

        public void onAnimationEnd() {
            super.onAnimationEnd();
            AnimationListener animationListener = this.f20544a;
            if (animationListener != null) {
                animationListener.onAnimationEnd(getAnimation());
            }
        }

        public ProgressAnimationImageView(Context context) {
            super(context);
            WaveSwipeHeader.this.f20536c = new MaterialProgressDrawable(WaveSwipeHeader.this);
            WaveSwipeHeader.this.f20536c.mo30775b(0);
            if (WaveSwipeHeader.m25363a()) {
                WaveSwipeHeader.this.f20536c.mo30770a(0);
            }
            super.setImageDrawable(WaveSwipeHeader.this.f20536c);
        }

        public void setProgressColorSchemeColorsFromResource(int... iArr) {
            Resources resources = getResources();
            int[] iArr2 = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                iArr2[i] = resources.getColor(iArr[i]);
            }
            WaveSwipeHeader.this.setColorSchemeColors(iArr2);
        }
    }

    /* renamed from: com.scwang.smartrefresh.header.WaveSwipeHeader$VERTICAL_DRAG_THRESHOLD */
    protected enum VERTICAL_DRAG_THRESHOLD {
        FIRST(0.1f),
        SECOND(FIRST.val + 0.16f),
        THIRD(FIRST.val + 0.5f);
        
        final float val;

        private VERTICAL_DRAG_THRESHOLD(float f) {
            this.val = f;
        }
    }

    public WaveSwipeHeader(Context context) {
        this(context, null);
    }

    public WaveSwipeHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WaveSwipeHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20937ab = SpinnerStyle.MatchLayout;
        WaveView waveView = new WaveView(context);
        this.f20534a = waveView;
        addView(waveView);
        ProgressAnimationImageView progressAnimationImageView = new ProgressAnimationImageView(context);
        this.f20537d = progressAnimationImageView;
        addView(progressAnimationImageView);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.WaveSwipeHeader);
        int color = obtainStyledAttributes.getColor(R.styleable.WaveSwipeHeader_wshPrimaryColor, 0);
        int color2 = obtainStyledAttributes.getColor(R.styleable.WaveSwipeHeader_wshAccentColor, 0);
        if (color != 0) {
            this.f20534a.setWaveColor(color);
        }
        if (color2 != 0) {
            this.f20536c.mo30772a(color2);
        } else {
            this.f20536c.mo30772a(-1);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.WaveSwipeHeader_wshShadowRadius)) {
            this.f20534a.mo30835a(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.WaveSwipeHeader_wshShadowRadius, 0), obtainStyledAttributes.getColor(R.styleable.WaveSwipeHeader_wshShadowColor, ViewCompat.MEASURED_STATE_MASK));
        }
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.setMeasuredDimension(MeasureSpec.getSize(i), MeasureSpec.getSize(i2));
        WaveView waveView = this.f20534a;
        ProgressAnimationImageView progressAnimationImageView = this.f20537d;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f20536c.getIntrinsicWidth(), 1073741824);
        progressAnimationImageView.measure(makeMeasureSpec, makeMeasureSpec);
        waveView.measure(MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i), 1073741824), MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i2), 1073741824));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        WaveView waveView = this.f20534a;
        ProgressAnimationImageView progressAnimationImageView = this.f20537d;
        waveView.layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = progressAnimationImageView.getMeasuredWidth();
        progressAnimationImageView.layout((measuredWidth - measuredWidth2) / 2, -progressAnimationImageView.getMeasuredHeight(), (measuredWidth + measuredWidth2) / 2, 0);
        if (isInEditMode()) {
            mo30672a(true, 0.99f, DensityUtil.m25572a(99.0f), DensityUtil.m25572a(100.0f), DensityUtil.m25572a(100.0f));
        }
    }

    public void setColorSchemeColors(int... iArr) {
        this.f20536c.mo30772a(iArr);
    }

    /* renamed from: a */
    public void mo30672a(boolean z, float f, int i, int i2, int i3) {
        if (z && this.f20535b != RefreshState.Refreshing) {
            ProgressAnimationImageView progressAnimationImageView = this.f20537d;
            float max = (((float) Math.max(((double) Math.min(1.0f, f)) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
            float f2 = f > 3.0f ? 2.0f : f > 1.0f ? f - 1.0f : 0.0f;
            float f3 = ((4.0f - f2) * f2) / 8.0f;
            if (f < 1.0f) {
                this.f20536c.mo30768a(0.0f, Math.min(0.8f, max * 0.8f));
                this.f20536c.mo30767a(Math.min(1.0f, max));
            }
            this.f20536c.mo30773b((((max * 0.4f) - 16.0f) + (f3 * 2.0f)) * 0.5f);
            progressAnimationImageView.setTranslationY(this.f20534a.getCurrentCircleCenterY());
            float min = (((float) i) * 1.0f) / ((float) Math.min(getMeasuredWidth(), getMeasuredHeight()));
            float f4 = (min * (5.0f - (2.0f * min))) / 3.5f;
            float f5 = f4 - VERTICAL_DRAG_THRESHOLD.FIRST.val;
            float f6 = (f4 - VERTICAL_DRAG_THRESHOLD.SECOND.val) / 5.0f;
            this.f20538e = f4;
            if (f4 < VERTICAL_DRAG_THRESHOLD.FIRST.val) {
                this.f20534a.mo30831a(f4);
            } else if (f4 < VERTICAL_DRAG_THRESHOLD.SECOND.val) {
                this.f20534a.mo30832a(f4, f5);
            } else {
                this.f20534a.mo30833a(f4, f5, f6);
            }
        }
    }

    /* renamed from: a */
    public void mo30671a(RefreshLayout jVar, int i, int i2) {
        this.f20538e = 0.0f;
        this.f20534a.mo30841f();
        this.f20536c.setAlpha(255);
        this.f20536c.start();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 0.0f});
        ofFloat.setDuration(500);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ProgressAnimationImageView progressAnimationImageView = WaveSwipeHeader.this.f20537d;
                progressAnimationImageView.setTranslationY(WaveSwipeHeader.this.f20534a.getCurrentCircleCenterY() + (((float) progressAnimationImageView.getHeight()) / 2.0f));
            }
        });
        ofFloat.start();
    }

    /* renamed from: a */
    public void mo30678a(RefreshLayout jVar, RefreshState refreshState, RefreshState refreshState2) {
        ProgressAnimationImageView progressAnimationImageView = this.f20537d;
        this.f20535b = refreshState2;
        int i = C64664.f20543a[refreshState2.ordinal()];
        if (i == 1) {
            return;
        }
        if (i == 2) {
            this.f20536c.mo30771a(true);
            progressAnimationImageView.setScaleX(1.0f);
            progressAnimationImageView.setScaleY(1.0f);
            this.f20536c.setAlpha(255);
        } else if (i == 3) {
            this.f20536c.mo30771a(false);
            this.f20536c.mo30773b(0.0f);
            this.f20536c.mo30768a(0.0f, 0.0f);
            this.f20534a.mo30837b(this.f20538e);
            this.f20538e = 0.0f;
        }
    }

    /* renamed from: a */
    public int mo30670a(RefreshLayout jVar, boolean z) {
        final ProgressAnimationImageView progressAnimationImageView = this.f20537d;
        C64642 r4 = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                float f2 = 1.0f - f;
                progressAnimationImageView.setScaleX(f2);
                progressAnimationImageView.setScaleY(f2);
            }
        };
        r4.setDuration(200);
        this.f20537d.setAnimationListener(new AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                WaveSwipeHeader.this.f20536c.stop();
                WaveSwipeHeader.this.f20536c.setAlpha(255);
                WaveSwipeHeader.this.f20534a.mo30840e();
            }
        });
        progressAnimationImageView.clearAnimation();
        progressAnimationImageView.startAnimation(r4);
        return 0;
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0) {
            this.f20534a.setWaveColor(iArr[0]);
            if (iArr.length > 1) {
                this.f20536c.mo30772a(iArr[1]);
            }
        }
    }

    /* renamed from: a */
    public static boolean m25363a() {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        return ((float) displayMetrics.widthPixels) / displayMetrics.density >= 600.0f;
    }
}
