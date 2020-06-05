package com.yanzhenjie.loading;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

public class LevelLoadingRenderer extends LoadingRenderer {
    private static final Interpolator ACCELERATE_INTERPOLATOR = new AccelerateInterpolator();
    private static final Interpolator DECELERATE_INTERPOLATOR = new DecelerateInterpolator();
    private static final float DEFAULT_CENTER_RADIUS = 12.5f;
    private static final int[] DEFAULT_LEVEL_COLORS = {Color.parseColor("#55ffffff"), Color.parseColor("#b1ffffff"), Color.parseColor("#ffffffff")};
    private static final float DEFAULT_STROKE_WIDTH = 2.5f;
    private static final int DEGREE_360 = 360;
    private static final float END_TRIM_DURATION_OFFSET = 1.0f;
    private static final float FULL_GROUP_ROTATION = 1080.0f;
    private static final float[] LEVEL_SWEEP_ANGLE_OFFSETS = {END_TRIM_DURATION_OFFSET, 0.875f, 0.625f};
    private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    private static final Interpolator MATERIAL_INTERPOLATOR = new FastOutSlowInInterpolator();
    private static final float MAX_SWIPE_DEGREES = 288.0f;
    private static final int NUM_POINTS = 5;
    private static final float START_TRIM_DURATION_OFFSET = 0.5f;
    private final AnimatorListener mAnimatorListener = new AnimatorListenerAdapter() {
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            LevelLoadingRenderer.this.storeOriginals();
            LevelLoadingRenderer levelLoadingRenderer = LevelLoadingRenderer.this;
            levelLoadingRenderer.mStartDegrees = levelLoadingRenderer.mEndDegrees;
            LevelLoadingRenderer levelLoadingRenderer2 = LevelLoadingRenderer.this;
            levelLoadingRenderer2.mRotationCount = (levelLoadingRenderer2.mRotationCount + LevelLoadingRenderer.END_TRIM_DURATION_OFFSET) % 5.0f;
        }

        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            LevelLoadingRenderer.this.mRotationCount = 0.0f;
        }
    };
    private float mCenterRadius;
    /* access modifiers changed from: private */
    public float mEndDegrees;
    private float mGroupRotation;
    private int[] mLevelColors;
    private float[] mLevelSwipeDegrees;
    private float mOriginEndDegrees;
    private float mOriginStartDegrees;
    private final Paint mPaint = new Paint();
    /* access modifiers changed from: private */
    public float mRotationCount;
    /* access modifiers changed from: private */
    public float mStartDegrees;
    private float mStrokeInset;
    private float mStrokeWidth;
    private final RectF mTempBounds = new RectF();

    /* renamed from: com.yanzhenjie.loading.LevelLoadingRenderer$Builder */
    public static class Builder {
        /* access modifiers changed from: private */
        public int mCenterRadius;
        private Context mContext;
        /* access modifiers changed from: private */
        public int mDuration;
        /* access modifiers changed from: private */
        public int mHeight;
        /* access modifiers changed from: private */
        public int[] mLevelColors;
        /* access modifiers changed from: private */
        public int mStrokeWidth;
        /* access modifiers changed from: private */
        public int mWidth;

        public Builder(Context context) {
            this.mContext = context;
        }

        public Builder setWidth(int i) {
            this.mWidth = i;
            return this;
        }

        public Builder setHeight(int i) {
            this.mHeight = i;
            return this;
        }

        public Builder setStrokeWidth(int i) {
            this.mStrokeWidth = i;
            return this;
        }

        public Builder setCenterRadius(int i) {
            this.mCenterRadius = i;
            return this;
        }

        public Builder setDuration(int i) {
            this.mDuration = i;
            return this;
        }

        public Builder setLevelColors(int[] iArr) {
            this.mLevelColors = iArr;
            return this;
        }

        public Builder setLevelColor(int i) {
            return setLevelColors(new int[]{oneThirdAlphaColor(i), twoThirdAlphaColor(i), i});
        }

        public LevelLoadingRenderer build() {
            LevelLoadingRenderer levelLoadingRenderer = new LevelLoadingRenderer(this.mContext);
            levelLoadingRenderer.apply(this);
            return levelLoadingRenderer;
        }

        private int oneThirdAlphaColor(int i) {
            return (i & 255) | ((((i >> 24) & 255) / 3) << 24) | (((i >> 16) & 255) << 16) | (((i >> 8) & 255) << 8);
        }

        private int twoThirdAlphaColor(int i) {
            return (i & 255) | (((((i >> 24) & 255) * 2) / 3) << 24) | (((i >> 16) & 255) << 16) | (((i >> 8) & 255) << 8);
        }
    }

    public LevelLoadingRenderer(Context context) {
        super(context);
        init(context);
        setupPaint();
        addRenderListener(this.mAnimatorListener);
    }

    private void init(Context context) {
        this.mStrokeWidth = Utils.dip2px(context, DEFAULT_STROKE_WIDTH);
        this.mCenterRadius = Utils.dip2px(context, DEFAULT_CENTER_RADIUS);
        this.mLevelSwipeDegrees = new float[3];
        this.mLevelColors = DEFAULT_LEVEL_COLORS;
    }

    private void setupPaint() {
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeWidth(this.mStrokeWidth);
        this.mPaint.setStyle(Style.STROKE);
        this.mPaint.setStrokeCap(Cap.ROUND);
        initStrokeInset((float) ((int) this.mWidth), (float) ((int) this.mHeight));
    }

    /* access modifiers changed from: protected */
    public void draw(Canvas canvas) {
        int save = canvas.save();
        this.mTempBounds.set(this.mBounds);
        RectF rectF = this.mTempBounds;
        float f = this.mStrokeInset;
        rectF.inset(f, f);
        canvas.rotate(this.mGroupRotation, this.mTempBounds.centerX(), this.mTempBounds.centerY());
        for (int i = 0; i < 3; i++) {
            if (this.mLevelSwipeDegrees[i] != 0.0f) {
                this.mPaint.setColor(this.mLevelColors[i]);
                canvas.drawArc(this.mTempBounds, this.mEndDegrees, this.mLevelSwipeDegrees[i], false, this.mPaint);
            }
        }
        canvas.restoreToCount(save);
    }

    /* access modifiers changed from: protected */
    public void computeRender(float f) {
        if (f <= START_TRIM_DURATION_OFFSET) {
            this.mStartDegrees = this.mOriginStartDegrees + (MATERIAL_INTERPOLATOR.getInterpolation(f / START_TRIM_DURATION_OFFSET) * MAX_SWIPE_DEGREES);
            float f2 = this.mEndDegrees - this.mStartDegrees;
            float abs = Math.abs(f2) / MAX_SWIPE_DEGREES;
            float interpolation = DECELERATE_INTERPOLATOR.getInterpolation(abs) - LINEAR_INTERPOLATOR.getInterpolation(abs);
            float interpolation2 = ACCELERATE_INTERPOLATOR.getInterpolation(abs) - LINEAR_INTERPOLATOR.getInterpolation(abs);
            float[] fArr = this.mLevelSwipeDegrees;
            float f3 = -f2;
            float[] fArr2 = LEVEL_SWEEP_ANGLE_OFFSETS;
            fArr[0] = fArr2[0] * f3 * (interpolation + END_TRIM_DURATION_OFFSET);
            fArr[1] = fArr2[1] * f3 * END_TRIM_DURATION_OFFSET;
            fArr[2] = f3 * fArr2[2] * (interpolation2 + END_TRIM_DURATION_OFFSET);
        }
        if (f > START_TRIM_DURATION_OFFSET) {
            this.mEndDegrees = this.mOriginEndDegrees + (MATERIAL_INTERPOLATOR.getInterpolation((f - START_TRIM_DURATION_OFFSET) / START_TRIM_DURATION_OFFSET) * MAX_SWIPE_DEGREES);
            float f4 = this.mEndDegrees - this.mStartDegrees;
            float abs2 = Math.abs(f4) / MAX_SWIPE_DEGREES;
            float[] fArr3 = LEVEL_SWEEP_ANGLE_OFFSETS;
            if (abs2 > fArr3[1]) {
                float[] fArr4 = this.mLevelSwipeDegrees;
                fArr4[0] = -f4;
                fArr4[1] = fArr3[1] * MAX_SWIPE_DEGREES;
                fArr4[2] = fArr3[2] * MAX_SWIPE_DEGREES;
            } else if (abs2 > fArr3[2]) {
                float[] fArr5 = this.mLevelSwipeDegrees;
                fArr5[0] = 0.0f;
                fArr5[1] = -f4;
                fArr5[2] = fArr3[2] * MAX_SWIPE_DEGREES;
            } else {
                float[] fArr6 = this.mLevelSwipeDegrees;
                fArr6[0] = 0.0f;
                fArr6[1] = 0.0f;
                fArr6[2] = -f4;
            }
        }
        this.mGroupRotation = (f * 216.0f) + ((this.mRotationCount / 5.0f) * FULL_GROUP_ROTATION);
    }

    /* access modifiers changed from: protected */
    public void setAlpha(int i) {
        this.mPaint.setAlpha(i);
    }

    /* access modifiers changed from: protected */
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    /* access modifiers changed from: protected */
    public void reset() {
        resetOriginals();
    }

    private void initStrokeInset(float f, float f2) {
        float min = (Math.min(f, f2) / 2.0f) - this.mCenterRadius;
        float ceil = (float) Math.ceil((double) (this.mStrokeWidth / 2.0f));
        if (min < ceil) {
            min = ceil;
        }
        this.mStrokeInset = min;
    }

    /* access modifiers changed from: private */
    public void storeOriginals() {
        float f = this.mEndDegrees;
        this.mOriginEndDegrees = f;
        this.mOriginStartDegrees = f;
    }

    private void resetOriginals() {
        this.mOriginEndDegrees = 0.0f;
        this.mOriginStartDegrees = 0.0f;
        this.mEndDegrees = 0.0f;
        this.mStartDegrees = 0.0f;
        float[] fArr = this.mLevelSwipeDegrees;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
    }

    /* access modifiers changed from: private */
    public void apply(Builder builder) {
        this.mWidth = builder.mWidth > 0 ? (float) builder.mWidth : this.mWidth;
        this.mHeight = builder.mHeight > 0 ? (float) builder.mHeight : this.mHeight;
        this.mStrokeWidth = builder.mStrokeWidth > 0 ? (float) builder.mStrokeWidth : this.mStrokeWidth;
        this.mCenterRadius = builder.mCenterRadius > 0 ? (float) builder.mCenterRadius : this.mCenterRadius;
        this.mDuration = builder.mDuration > 0 ? (long) builder.mDuration : this.mDuration;
        this.mLevelColors = builder.mLevelColors != null ? builder.mLevelColors : this.mLevelColors;
        setupPaint();
        initStrokeInset(this.mWidth, this.mHeight);
    }
}
