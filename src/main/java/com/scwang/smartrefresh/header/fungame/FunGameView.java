package com.scwang.smartrefresh.header.fungame;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import com.scwang.smartrefresh.header.R;
import com.scwang.smartrefresh.header.fungame.FunGameView;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.p527a.RefreshKernel;
import com.scwang.smartrefresh.layout.p527a.RefreshLayout;
import com.scwang.smartrefresh.layout.p529c.DensityUtil;
import com.tencent.bugly.beta.tinker.TinkerReport;

public abstract class FunGameView<T extends FunGameView> extends FunGameBase {
    /* renamed from: B */
    protected float f20591B = 1.0f;
    /* renamed from: C */
    protected View f20592C;
    /* renamed from: D */
    protected TextView f20593D;
    /* renamed from: E */
    protected TextView f20594E;
    /* renamed from: F */
    public String f20595F;
    /* renamed from: G */
    public String f20596G;
    /* renamed from: H */
    public String f20597H;
    /* renamed from: I */
    protected int f20598I;
    /* renamed from: J */
    public String f20599J;
    /* renamed from: K */
    public String f20600K;
    /* renamed from: L */
    public String f20601L;
    /* renamed from: M */
    public String f20602M;
    /* renamed from: N */
    protected Paint f20603N;
    /* renamed from: O */
    protected Paint f20604O;
    /* renamed from: P */
    protected float f20605P;
    /* renamed from: Q */
    protected int f20606Q;
    /* renamed from: R */
    protected int f20607R = 0;
    /* renamed from: S */
    protected int f20608S;
    /* renamed from: T */
    protected int f20609T;
    /* renamed from: U */
    protected int f20610U;
    /* renamed from: V */
    protected int f20611V;
    /* renamed from: W */
    protected int f20612W = -10461088;

    /* renamed from: com.scwang.smartrefresh.header.fungame.FunGameView$2 */
    static /* synthetic */ class C64682 {
        /* renamed from: a */
        static final /* synthetic */ int[] f20617a = new int[RefreshState.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
     */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
            com.scwang.smartrefresh.layout.constant.RefreshState[] r0 = com.scwang.smartrefresh.layout.constant.RefreshState.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f20617a = r0
            int[] r0 = f20617a     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.PullDownToRefresh     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f20617a     // Catch:{ NoSuchFieldError -> 0x001f }
            com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.ReleaseToRefresh     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.header.fungame.FunGameView.C64682.m51067clinit():void");
        }
    }

    /* renamed from: a */
    public abstract void mo30696a();

    /* renamed from: a */
    public abstract void mo30698a(Canvas canvas, int i, int i2);

    public FunGameView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FunGameView);
        this.f20595F = getResources().getString(R.string.fgh_mask_bottom);
        this.f20596G = getResources().getString(R.string.fgh_mask_top_pull);
        this.f20597H = getResources().getString(R.string.fgh_mask_top_release);
        if (obtainStyledAttributes.hasValue(R.styleable.FunGameView_fghMaskTextTop)) {
            String string = obtainStyledAttributes.getString(R.styleable.FunGameView_fghMaskTextTop);
            this.f20597H = string;
            this.f20596G = string;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.FunGameView_fghMaskTextTopPull)) {
            this.f20596G = obtainStyledAttributes.getString(R.styleable.FunGameView_fghMaskTextTopPull);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.FunGameView_fghMaskTextTopRelease)) {
            this.f20597H = obtainStyledAttributes.getString(R.styleable.FunGameView_fghMaskTextTopRelease);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.FunGameView_fghMaskTextBottom)) {
            this.f20595F = obtainStyledAttributes.getString(R.styleable.FunGameView_fghMaskTextBottom);
        }
        int applyDimension = (int) TypedValue.applyDimension(2, 16.0f, getResources().getDisplayMetrics());
        int i2 = (applyDimension * 14) / 16;
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FunGameView_fghMaskTextSizeTop, applyDimension);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FunGameView_fghMaskTextSizeBottom, i2);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.f20592C = new RelativeLayout(context);
        this.f20592C.setBackgroundColor(-12961222);
        this.f20593D = mo30762a(context, this.f20596G, dimensionPixelSize, 80);
        this.f20594E = mo30762a(context, this.f20595F, dimensionPixelSize2, 48);
        if (!isInEditMode()) {
            int a = DensityUtil.m25572a(100.0f);
            LayoutParams layoutParams = new LayoutParams(-1, a);
            addView(this.f20592C, layoutParams);
            addView(relativeLayout, layoutParams);
            this.f20598I = (int) (((float) a) * 0.5f);
            LayoutParams layoutParams2 = new LayoutParams(-1, this.f20598I);
            LayoutParams layoutParams3 = new LayoutParams(-1, this.f20598I);
            layoutParams3.topMargin = a - this.f20598I;
            relativeLayout.addView(this.f20593D, layoutParams2);
            relativeLayout.addView(this.f20594E, layoutParams3);
        }
        this.f20591B = (float) Math.max(1, DensityUtil.m25572a(0.5f));
        this.f20603N = new Paint(1);
        this.f20603N.setStrokeWidth(this.f20591B);
        this.f20605P = this.f20591B;
        this.f20604O = new TextPaint(1);
        this.f20604O.setColor(-4078910);
        this.f20599J = context.getString(R.string.fgh_text_game_over);
        this.f20600K = context.getString(R.string.fgh_text_loading);
        this.f20601L = context.getString(R.string.fgh_text_loading_finish);
        this.f20602M = context.getString(R.string.fgh_text_loading_failed);
        this.f20611V = obtainStyledAttributes.getColor(R.styleable.FunGameView_fghBackColor, 0);
        this.f20608S = obtainStyledAttributes.getColor(R.styleable.FunGameView_fghLeftColor, ViewCompat.MEASURED_STATE_MASK);
        this.f20610U = obtainStyledAttributes.getColor(R.styleable.FunGameView_fghMiddleColor, ViewCompat.MEASURED_STATE_MASK);
        this.f20609T = obtainStyledAttributes.getColor(R.styleable.FunGameView_fghRightColor, -5921371);
        if (obtainStyledAttributes.hasValue(R.styleable.FunGameView_fghTextGameOver)) {
            this.f20599J = obtainStyledAttributes.getString(R.styleable.FunGameView_fghTextGameOver);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.FunGameView_fghTextLoading)) {
            this.f20600K = obtainStyledAttributes.getString(R.styleable.FunGameView_fghTextLoading);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.FunGameView_fghTextLoadingFinished)) {
            this.f20601L = obtainStyledAttributes.getString(R.styleable.FunGameView_fghTextLoadingFinished);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.FunGameView_fghTextLoadingFailed)) {
            this.f20602M = obtainStyledAttributes.getString(R.styleable.FunGameView_fghTextLoadingFailed);
        }
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public TextView mo30762a(Context context, String str, int i, int i2) {
        TextView textView = new TextView(context);
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setGravity(i2 | 1);
        textView.setTextSize(0, (float) i);
        textView.setText(str);
        textView.setBackgroundColor(-1);
        return textView;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        int i = this.f20583s;
        m25388b(canvas, width, i);
        m25389c(canvas, width, i);
        mo30698a(canvas, width, i);
        super.dispatchDraw(canvas);
    }

    /* renamed from: b */
    private void m25388b(Canvas canvas, int i, int i2) {
        this.f20603N.setColor(this.f20611V);
        float f = (float) i2;
        Canvas canvas2 = canvas;
        float f2 = (float) i;
        canvas2.drawRect(0.0f, 0.0f, f2, f, this.f20603N);
        this.f20603N.setColor(this.f20612W);
        canvas2.drawLine(0.0f, 0.0f, f2, 0.0f, this.f20603N);
        float f3 = this.f20591B;
        canvas2.drawLine(0.0f, f - f3, f2, f - f3, this.f20603N);
    }

    /* renamed from: c */
    private void m25389c(Canvas canvas, int i, int i2) {
        int i3 = this.f20607R;
        if (i3 == 0 || i3 == 1) {
            this.f20604O.setTextSize((float) DensityUtil.m25572a(25.0f));
            m25387a(canvas, this.f20600K, i, i2);
        } else if (i3 == 2) {
            this.f20604O.setTextSize((float) DensityUtil.m25572a(25.0f));
            m25387a(canvas, this.f20599J, i, i2);
        } else if (i3 == 3) {
            this.f20604O.setTextSize((float) DensityUtil.m25572a(20.0f));
            m25387a(canvas, this.f20601L, i, i2);
        } else if (i3 == 4) {
            this.f20604O.setTextSize((float) DensityUtil.m25572a(20.0f));
            m25387a(canvas, this.f20602M, i, i2);
        }
    }

    /* renamed from: a */
    private void m25387a(Canvas canvas, String str, int i, int i2) {
        canvas.drawText(str, (((float) i) - this.f20604O.measureText(str)) * 0.5f, (((float) i2) * 0.5f) - ((this.f20604O.ascent() + this.f20604O.descent()) * 0.5f), this.f20604O);
    }

    /* renamed from: c */
    public void mo30763c(int i) {
        this.f20607R = i;
        if (i == 0) {
            mo30696a();
        }
        postInvalidate();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo30757a(float f, int i, int i2, int i3) {
        float max = (float) Math.max(i, 0);
        float f2 = (((float) this.f20583s) - (this.f20591B * 2.0f)) - ((float) this.f20606Q);
        if (max > f2) {
            max = f2;
        }
        this.f20605P = max;
        postInvalidate();
    }

    /* renamed from: a */
    public void mo30677a(RefreshKernel iVar, int i, int i2) {
        if (this.f20583s != i && !isInEditMode()) {
            TextView textView = this.f20593D;
            TextView textView2 = this.f20594E;
            this.f20598I = (int) (((float) i) * 0.5f);
            LayoutParams layoutParams = (LayoutParams) textView.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) textView2.getLayoutParams();
            int i3 = this.f20598I;
            layoutParams2.height = i3;
            layoutParams.height = i3;
            layoutParams2.topMargin = i - i3;
            textView.setLayoutParams(layoutParams);
            textView2.setLayoutParams(layoutParams2);
        }
        super.mo30677a(iVar, i, i2);
        mo30763c(0);
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        super.setPrimaryColors(iArr);
        if (iArr.length > 0) {
            this.f20593D.setTextColor(iArr[0]);
            this.f20594E.setTextColor(iArr[0]);
            int i = iArr[0];
            this.f20611V = i;
            this.f20612W = i;
            int i2 = this.f20611V;
            if (i2 == 0 || i2 == -1) {
                this.f20612W = -10461088;
            }
            if (iArr.length > 1) {
                TextView textView = this.f20593D;
                TextView textView2 = this.f20594E;
                this.f20592C.setBackgroundColor(iArr[1]);
                textView.setBackgroundColor(iArr[1]);
                textView2.setBackgroundColor(iArr[1]);
                this.f20610U = iArr[1];
                this.f20608S = ColorUtils.setAlphaComponent(iArr[1], 225);
                this.f20609T = ColorUtils.setAlphaComponent(iArr[1], 200);
                this.f20604O.setColor(ColorUtils.setAlphaComponent(iArr[1], TinkerReport.KEY_APPLIED_PACKAGE_CHECK_SIGNATURE));
            }
        }
    }

    /* renamed from: a */
    public void mo30678a(RefreshLayout jVar, RefreshState refreshState, RefreshState refreshState2) {
        super.mo30678a(jVar, refreshState, refreshState2);
        int i = C64682.f20617a[refreshState2.ordinal()];
        if (i == 1) {
            this.f20593D.setText(this.f20596G);
        } else if (i == 2) {
            this.f20593D.setText(this.f20597H);
        }
    }

    /* renamed from: b */
    public void mo30679b(RefreshLayout jVar, int i, int i2) {
        super.mo30679b(jVar, i, i2);
        final TextView textView = this.f20593D;
        final View view = this.f20592C;
        final TextView textView2 = this.f20594E;
        AnimatorSet animatorSet = new AnimatorSet();
        String str = "translationY";
        animatorSet.play(ObjectAnimator.ofFloat(textView, str, new float[]{textView.getTranslationY(), (float) (-this.f20598I)})).with(ObjectAnimator.ofFloat(textView2, str, new float[]{textView2.getTranslationY(), (float) this.f20598I})).with(ObjectAnimator.ofFloat(view, "alpha", new float[]{view.getAlpha(), 0.0f}));
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                textView.setVisibility(8);
                textView2.setVisibility(8);
                view.setVisibility(8);
                FunGameView.this.mo30763c(1);
            }
        });
        animatorSet.setDuration(800);
        animatorSet.setStartDelay(200);
        animatorSet.start();
    }

    /* renamed from: a */
    public int mo30670a(RefreshLayout jVar, boolean z) {
        if (this.f20588x) {
            mo30763c(z ? 3 : 4);
        } else {
            mo30763c(0);
            TextView textView = this.f20593D;
            TextView textView2 = this.f20594E;
            View view = this.f20592C;
            textView.setTranslationY(textView.getTranslationY() + ((float) this.f20598I));
            textView2.setTranslationY(textView2.getTranslationY() - ((float) this.f20598I));
            view.setAlpha(1.0f);
            textView.setVisibility(0);
            textView2.setVisibility(0);
            view.setVisibility(0);
        }
        return super.mo30670a(jVar, z);
    }
}
