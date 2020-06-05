package com.scwang.smartrefresh.layout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import android.widget.TextView;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.scwang.smartrefresh.layout.constant.DimensionStatus;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;
import com.scwang.smartrefresh.layout.impl.RefreshContentWrapper;
import com.scwang.smartrefresh.layout.p527a.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.p527a.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.p527a.DefaultRefreshInitializer;
import com.scwang.smartrefresh.layout.p527a.RefreshContent;
import com.scwang.smartrefresh.layout.p527a.RefreshFooter;
import com.scwang.smartrefresh.layout.p527a.RefreshHeader;
import com.scwang.smartrefresh.layout.p527a.RefreshInternal;
import com.scwang.smartrefresh.layout.p527a.RefreshKernel;
import com.scwang.smartrefresh.layout.p527a.RefreshLayout;
import com.scwang.smartrefresh.layout.p527a.ScrollBoundaryDecider;
import com.scwang.smartrefresh.layout.p528b.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.p528b.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.p528b.OnRefreshListener;
import com.scwang.smartrefresh.layout.p529c.DelayedRunnable;
import com.scwang.smartrefresh.layout.p529c.DensityUtil;
import com.scwang.smartrefresh.layout.p529c.SmartUtil;
import com.scwang.smartrefresh.layout.p529c.ViscousFluidInterpolator;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class SmartRefreshLayout extends ViewGroup implements NestedScrollingParent, RefreshLayout {
    /* renamed from: aH */
    protected static DefaultRefreshFooterCreator f20719aH;
    /* renamed from: aI */
    protected static DefaultRefreshHeaderCreator f20720aI;
    /* renamed from: aJ */
    protected static DefaultRefreshInitializer f20721aJ;
    /* renamed from: A */
    protected boolean f20722A;
    /* renamed from: B */
    protected boolean f20723B;
    /* renamed from: C */
    protected boolean f20724C;
    /* renamed from: D */
    protected boolean f20725D;
    /* renamed from: E */
    protected boolean f20726E;
    /* renamed from: F */
    protected boolean f20727F;
    /* renamed from: G */
    protected boolean f20728G;
    /* renamed from: H */
    protected boolean f20729H;
    /* renamed from: I */
    protected boolean f20730I;
    /* renamed from: J */
    protected boolean f20731J;
    /* renamed from: K */
    protected boolean f20732K;
    /* renamed from: L */
    protected boolean f20733L;
    /* renamed from: M */
    protected boolean f20734M;
    /* renamed from: N */
    protected boolean f20735N;
    /* renamed from: O */
    protected boolean f20736O;
    /* renamed from: P */
    protected boolean f20737P;
    /* renamed from: Q */
    protected boolean f20738Q;
    /* renamed from: R */
    protected boolean f20739R;
    /* renamed from: S */
    protected boolean f20740S;
    /* renamed from: T */
    protected boolean f20741T;
    /* renamed from: U */
    protected boolean f20742U;
    /* renamed from: V */
    protected boolean f20743V;
    /* renamed from: W */
    protected OnRefreshListener f20744W;
    /* renamed from: a */
    protected int f20745a;
    /* renamed from: aA */
    protected RefreshState f20746aA;
    /* renamed from: aB */
    protected long f20747aB;
    /* renamed from: aC */
    protected int f20748aC;
    /* renamed from: aD */
    protected int f20749aD;
    /* renamed from: aE */
    protected boolean f20750aE;
    /* renamed from: aF */
    protected boolean f20751aF;
    /* renamed from: aG */
    protected boolean f20752aG;
    /* renamed from: aK */
    protected boolean f20753aK;
    /* renamed from: aL */
    protected MotionEvent f20754aL;
    /* renamed from: aM */
    protected Runnable f20755aM;
    /* renamed from: aN */
    protected ValueAnimator f20756aN;
    /* renamed from: aa */
    protected OnLoadMoreListener f20757aa;
    /* renamed from: ab */
    protected OnMultiPurposeListener f20758ab;
    /* renamed from: ac */
    protected ScrollBoundaryDecider f20759ac;
    /* renamed from: ad */
    protected int f20760ad;
    /* renamed from: ae */
    protected boolean f20761ae;
    /* renamed from: af */
    protected int[] f20762af;
    /* renamed from: ag */
    protected NestedScrollingChildHelper f20763ag;
    /* renamed from: ah */
    protected NestedScrollingParentHelper f20764ah;
    /* renamed from: ai */
    protected int f20765ai;
    /* renamed from: aj */
    protected DimensionStatus f20766aj;
    /* renamed from: ak */
    protected int f20767ak;
    /* renamed from: al */
    protected DimensionStatus f20768al;
    /* renamed from: am */
    protected int f20769am;
    /* renamed from: an */
    protected int f20770an;
    /* renamed from: ao */
    protected float f20771ao;
    /* renamed from: ap */
    protected float f20772ap;
    /* renamed from: aq */
    protected float f20773aq;
    /* renamed from: ar */
    protected float f20774ar;
    /* renamed from: as */
    protected RefreshInternal f20775as;
    /* renamed from: at */
    protected RefreshInternal f20776at;
    /* renamed from: au */
    protected RefreshContent f20777au;
    /* renamed from: av */
    protected Paint f20778av;
    /* renamed from: aw */
    protected Handler f20779aw;
    /* renamed from: ax */
    protected RefreshKernel f20780ax;
    /* renamed from: ay */
    protected List<DelayedRunnable> f20781ay;
    /* renamed from: az */
    protected RefreshState f20782az;
    /* renamed from: b */
    protected int f20783b;
    /* renamed from: c */
    protected int f20784c;
    /* renamed from: d */
    protected int f20785d;
    /* renamed from: e */
    protected int f20786e;
    /* renamed from: f */
    protected int f20787f;
    /* renamed from: g */
    protected int f20788g;
    /* renamed from: h */
    protected float f20789h;
    /* renamed from: i */
    protected float f20790i;
    /* renamed from: j */
    protected float f20791j;
    /* renamed from: k */
    protected float f20792k;
    /* renamed from: l */
    protected float f20793l;
    /* renamed from: m */
    protected char f20794m;
    /* renamed from: n */
    protected boolean f20795n;
    /* renamed from: o */
    protected boolean f20796o;
    /* renamed from: p */
    protected int f20797p;
    /* renamed from: q */
    protected int f20798q;
    /* renamed from: r */
    protected int f20799r;
    /* renamed from: s */
    protected int f20800s;
    /* renamed from: t */
    protected int f20801t;
    /* renamed from: u */
    protected int f20802u;
    /* renamed from: v */
    protected int f20803v;
    /* renamed from: w */
    protected Scroller f20804w;
    /* renamed from: x */
    protected VelocityTracker f20805x;
    /* renamed from: y */
    protected Interpolator f20806y;
    /* renamed from: z */
    protected int[] f20807z;

    /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$a */
    protected class C6494a implements Runnable {
        /* renamed from: a */
        int f20822a = 0;
        /* renamed from: b */
        int f20823b = 10;
        /* renamed from: c */
        int f20824c;
        /* renamed from: d */
        long f20825d;
        /* renamed from: e */
        float f20826e = 0.0f;
        /* renamed from: f */
        float f20827f;

        C6494a(float f, int i) {
            this.f20827f = f;
            this.f20824c = i;
            this.f20825d = AnimationUtils.currentAnimationTimeMillis();
            SmartRefreshLayout.this.postDelayed(this, (long) this.f20823b);
        }

        public void run() {
            if (SmartRefreshLayout.this.f20755aM == this && !SmartRefreshLayout.this.f20782az.isFinishing) {
                if (Math.abs(SmartRefreshLayout.this.f20783b) < Math.abs(this.f20824c)) {
                    double d = (double) this.f20827f;
                    int i = this.f20822a + 1;
                    this.f20822a = i;
                    this.f20827f = (float) (d * Math.pow(0.949999988079071d, (double) (i * 2)));
                } else if (this.f20824c != 0) {
                    double d2 = (double) this.f20827f;
                    int i2 = this.f20822a + 1;
                    this.f20822a = i2;
                    this.f20827f = (float) (d2 * Math.pow(0.44999998807907104d, (double) (i2 * 2)));
                } else {
                    double d3 = (double) this.f20827f;
                    int i3 = this.f20822a + 1;
                    this.f20822a = i3;
                    this.f20827f = (float) (d3 * Math.pow(0.8500000238418579d, (double) (i3 * 2)));
                }
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float f = this.f20827f * ((((float) (currentAnimationTimeMillis - this.f20825d)) * 1.0f) / 1000.0f);
                if (Math.abs(f) >= 1.0f) {
                    this.f20825d = currentAnimationTimeMillis;
                    this.f20826e += f;
                    SmartRefreshLayout.this.mo30873b(this.f20826e);
                    SmartRefreshLayout.this.postDelayed(this, (long) this.f20823b);
                    return;
                }
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                smartRefreshLayout.f20755aM = null;
                if (Math.abs(smartRefreshLayout.f20783b) >= Math.abs(this.f20824c)) {
                    int min = Math.min(Math.max((int) DensityUtil.m25571a(Math.abs(SmartRefreshLayout.this.f20783b - this.f20824c)), 30), 100) * 10;
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    smartRefreshLayout2.mo30853a(this.f20824c, 0, smartRefreshLayout2.f20806y, min);
                }
            }
        }
    }

    /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$b */
    protected class C6495b implements Runnable {
        /* renamed from: a */
        int f20829a;
        /* renamed from: b */
        int f20830b = 0;
        /* renamed from: c */
        int f20831c = 10;
        /* renamed from: d */
        float f20832d;
        /* renamed from: e */
        float f20833e = 0.98f;
        /* renamed from: f */
        long f20834f = 0;
        /* renamed from: g */
        long f20835g = AnimationUtils.currentAnimationTimeMillis();

        C6495b(float f) {
            this.f20832d = f;
            this.f20829a = SmartRefreshLayout.this.f20783b;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
            if (r0.mo30868a(r0.f20723B) != false) goto L_0x002e;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x004a, code lost:
            if (r0.mo30868a(r0.f20723B) != false) goto L_0x004c;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0055, code lost:
            if (r10.f20836h.f20783b >= (-r10.f20836h.f20767ak)) goto L_0x0057;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0067, code lost:
            if (r10.f20836h.f20783b > r10.f20836h.f20765ai) goto L_0x0069;
     */
        /* renamed from: a */
        public java.lang.Runnable mo30923a() {
            /*
            r10 = this;
            com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
            com.scwang.smartrefresh.layout.constant.RefreshState r0 = r0.f20782az
            boolean r0 = r0.isFinishing
            r1 = 0
            if (r0 == 0) goto L_0x000a
            return r1
        L_0x000a:
            com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
            int r0 = r0.f20783b
            if (r0 == 0) goto L_0x00ca
            com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
            com.scwang.smartrefresh.layout.constant.RefreshState r0 = r0.f20782az
            boolean r0 = r0.isOpening
            if (r0 != 0) goto L_0x002e
            com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
            boolean r0 = r0.f20739R
            if (r0 == 0) goto L_0x0069
            com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
            boolean r0 = r0.f20728G
            if (r0 == 0) goto L_0x0069
            com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
            boolean r2 = r0.f20723B
            boolean r0 = r0.mo30868a(r2)
            if (r0 == 0) goto L_0x0069
        L_0x002e:
            com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
            com.scwang.smartrefresh.layout.constant.RefreshState r0 = r0.f20782az
            com.scwang.smartrefresh.layout.constant.RefreshState r2 = com.scwang.smartrefresh.layout.constant.RefreshState.Loading
            if (r0 == r2) goto L_0x004c
            com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
            boolean r0 = r0.f20739R
            if (r0 == 0) goto L_0x0057
            com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
            boolean r0 = r0.f20728G
            if (r0 == 0) goto L_0x0057
            com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
            boolean r2 = r0.f20723B
            boolean r0 = r0.mo30868a(r2)
            if (r0 == 0) goto L_0x0057
        L_0x004c:
            com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
            int r0 = r0.f20783b
            com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
            int r2 = r2.f20767ak
            int r2 = -r2
            if (r0 < r2) goto L_0x0069
        L_0x0057:
            com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
            com.scwang.smartrefresh.layout.constant.RefreshState r0 = r0.f20782az
            com.scwang.smartrefresh.layout.constant.RefreshState r2 = com.scwang.smartrefresh.layout.constant.RefreshState.Refreshing
            if (r0 != r2) goto L_0x00ca
            com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
            int r0 = r0.f20783b
            com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
            int r2 = r2.f20765ai
            if (r0 <= r2) goto L_0x00ca
        L_0x0069:
            r0 = 0
            com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
            int r2 = r2.f20783b
            com.scwang.smartrefresh.layout.SmartRefreshLayout r3 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
            int r3 = r3.f20783b
            float r4 = r10.f20832d
        L_0x0074:
            int r5 = r3 * r2
            if (r5 <= 0) goto L_0x00ca
            double r4 = (double) r4
            float r6 = r10.f20833e
            double r6 = (double) r6
            int r0 = r0 + 1
            int r8 = r10.f20831c
            int r8 = r8 * r0
            int r8 = r8 / 10
            double r8 = (double) r8
            double r6 = java.lang.Math.pow(r6, r8)
            double r4 = r4 * r6
            float r4 = (float) r4
            int r5 = r10.f20831c
            float r5 = (float) r5
            r6 = 1065353216(0x3f800000, float:1.0)
            float r5 = r5 * r6
            r7 = 1148846080(0x447a0000, float:1000.0)
            float r5 = r5 / r7
            float r5 = r5 * r4
            float r7 = java.lang.Math.abs(r5)
            int r6 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
            if (r6 >= 0) goto L_0x00c6
            com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
            com.scwang.smartrefresh.layout.constant.RefreshState r0 = r0.f20782az
            boolean r0 = r0.isOpening
            if (r0 == 0) goto L_0x00c5
            com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
            com.scwang.smartrefresh.layout.constant.RefreshState r0 = r0.f20782az
            com.scwang.smartrefresh.layout.constant.RefreshState r3 = com.scwang.smartrefresh.layout.constant.RefreshState.Refreshing
            if (r0 != r3) goto L_0x00b6
            com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
            int r0 = r0.f20765ai
            if (r2 > r0) goto L_0x00c5
        L_0x00b6:
            com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
            com.scwang.smartrefresh.layout.constant.RefreshState r0 = r0.f20782az
            com.scwang.smartrefresh.layout.constant.RefreshState r3 = com.scwang.smartrefresh.layout.constant.RefreshState.Refreshing
            if (r0 == r3) goto L_0x00ca
            com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
            int r0 = r0.f20767ak
            int r0 = -r0
            if (r2 >= r0) goto L_0x00ca
        L_0x00c5:
            return r1
        L_0x00c6:
            float r2 = (float) r2
            float r2 = r2 + r5
            int r2 = (int) r2
            goto L_0x0074
        L_0x00ca:
            long r0 = android.view.animation.AnimationUtils.currentAnimationTimeMillis()
            r10.f20834f = r0
            com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
            int r1 = r10.f20831c
            long r1 = (long) r1
            r0.postDelayed(r10, r1)
            return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.C6495b.mo30923a():java.lang.Runnable");
        }

        public void run() {
            if (SmartRefreshLayout.this.f20755aM == this && !SmartRefreshLayout.this.f20782az.isFinishing) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                long j = currentAnimationTimeMillis - this.f20835g;
                this.f20832d = (float) (((double) this.f20832d) * Math.pow((double) this.f20833e, (double) ((currentAnimationTimeMillis - this.f20834f) / ((long) (1000 / this.f20831c)))));
                float f = this.f20832d * ((((float) j) * 1.0f) / 1000.0f);
                if (Math.abs(f) > 1.0f) {
                    this.f20835g = currentAnimationTimeMillis;
                    this.f20829a = (int) (((float) this.f20829a) + f);
                    if (SmartRefreshLayout.this.f20783b * this.f20829a > 0) {
                        SmartRefreshLayout.this.f20780ax.mo30926a(this.f20829a, true);
                        SmartRefreshLayout.this.postDelayed(this, (long) this.f20831c);
                        return;
                    }
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    smartRefreshLayout.f20755aM = null;
                    smartRefreshLayout.f20780ax.mo30926a(0, true);
                    SmartUtil.m25582a(SmartRefreshLayout.this.f20777au.mo30947b(), (int) (-this.f20832d));
                    if (SmartRefreshLayout.this.f20752aG && f > 0.0f) {
                        SmartRefreshLayout.this.f20752aG = false;
                        return;
                    }
                    return;
                }
                SmartRefreshLayout.this.f20755aM = null;
            }
        }
    }

    /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$c */
    public static class C6496c extends MarginLayoutParams {
        /* renamed from: a */
        public int f20837a = 0;
        /* renamed from: b */
        public SpinnerStyle f20838b = null;

        public C6496c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SmartRefreshLayout_Layout);
            this.f20837a = obtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_Layout_layout_srlBackgroundColor, this.f20837a);
            if (obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_Layout_layout_srlSpinnerStyle)) {
                this.f20838b = SpinnerStyle.values()[obtainStyledAttributes.getInt(R.styleable.SmartRefreshLayout_Layout_layout_srlSpinnerStyle, SpinnerStyle.Translate.ordinal())];
            }
            obtainStyledAttributes.recycle();
        }

        public C6496c(int i, int i2) {
            super(i, i2);
        }

        public C6496c(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$d */
    public class C6497d implements RefreshKernel {
        public C6497d() {
        }

        /* renamed from: a */
        public RefreshLayout mo30931a() {
            return SmartRefreshLayout.this;
        }

        /* renamed from: b */
        public RefreshContent mo30932b() {
            return SmartRefreshLayout.this.f20777au;
        }

        /* renamed from: a */
        public RefreshKernel mo30929a(RefreshState refreshState) {
            switch (refreshState) {
                case None:
                    SmartRefreshLayout.this.mo30883d();
                    break;
                case PullDownToRefresh:
                    if (!SmartRefreshLayout.this.f20782az.isOpening) {
                        SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                        if (smartRefreshLayout.mo30868a(smartRefreshLayout.f20722A)) {
                            SmartRefreshLayout.this.mo30865a(RefreshState.PullDownToRefresh);
                            break;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.PullDownToRefresh);
                    break;
                case PullUpToLoad:
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    if (smartRefreshLayout2.mo30868a(smartRefreshLayout2.f20723B) && !SmartRefreshLayout.this.f20782az.isOpening && !SmartRefreshLayout.this.f20782az.isFinishing && (!SmartRefreshLayout.this.f20739R || !SmartRefreshLayout.this.f20728G)) {
                        SmartRefreshLayout.this.mo30865a(RefreshState.PullUpToLoad);
                        break;
                    } else {
                        SmartRefreshLayout.this.setViceState(RefreshState.PullUpToLoad);
                        break;
                    }
                    break;
                case PullDownCanceled:
                    if (!SmartRefreshLayout.this.f20782az.isOpening) {
                        SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                        if (smartRefreshLayout3.mo30868a(smartRefreshLayout3.f20722A)) {
                            SmartRefreshLayout.this.mo30865a(RefreshState.PullDownCanceled);
                            SmartRefreshLayout.this.mo30883d();
                            break;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.PullDownCanceled);
                    break;
                case PullUpCanceled:
                    SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                    if (smartRefreshLayout4.mo30868a(smartRefreshLayout4.f20723B) && !SmartRefreshLayout.this.f20782az.isOpening && (!SmartRefreshLayout.this.f20739R || !SmartRefreshLayout.this.f20728G)) {
                        SmartRefreshLayout.this.mo30865a(RefreshState.PullUpCanceled);
                        SmartRefreshLayout.this.mo30883d();
                        break;
                    } else {
                        SmartRefreshLayout.this.setViceState(RefreshState.PullUpCanceled);
                        break;
                    }
                    break;
                case ReleaseToRefresh:
                    if (!SmartRefreshLayout.this.f20782az.isOpening) {
                        SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                        if (smartRefreshLayout5.mo30868a(smartRefreshLayout5.f20722A)) {
                            SmartRefreshLayout.this.mo30865a(RefreshState.ReleaseToRefresh);
                            break;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToRefresh);
                    break;
                case ReleaseToLoad:
                    SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                    if (smartRefreshLayout6.mo30868a(smartRefreshLayout6.f20723B) && !SmartRefreshLayout.this.f20782az.isOpening && !SmartRefreshLayout.this.f20782az.isFinishing && (!SmartRefreshLayout.this.f20739R || !SmartRefreshLayout.this.f20728G)) {
                        SmartRefreshLayout.this.mo30865a(RefreshState.ReleaseToLoad);
                        break;
                    } else {
                        SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToLoad);
                        break;
                    }
                case ReleaseToTwoLevel:
                    if (!SmartRefreshLayout.this.f20782az.isOpening) {
                        SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                        if (smartRefreshLayout7.mo30868a(smartRefreshLayout7.f20722A)) {
                            SmartRefreshLayout.this.mo30865a(RefreshState.ReleaseToTwoLevel);
                            break;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToTwoLevel);
                    break;
                case RefreshReleased:
                    if (!SmartRefreshLayout.this.f20782az.isOpening) {
                        SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                        if (smartRefreshLayout8.mo30868a(smartRefreshLayout8.f20722A)) {
                            SmartRefreshLayout.this.mo30865a(RefreshState.RefreshReleased);
                            break;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.RefreshReleased);
                    break;
                case LoadReleased:
                    if (!SmartRefreshLayout.this.f20782az.isOpening) {
                        SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                        if (smartRefreshLayout9.mo30868a(smartRefreshLayout9.f20723B)) {
                            SmartRefreshLayout.this.mo30865a(RefreshState.LoadReleased);
                            break;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.LoadReleased);
                    break;
                case Refreshing:
                    SmartRefreshLayout.this.mo30877c();
                    break;
                case Loading:
                    SmartRefreshLayout.this.mo30872b();
                    break;
                case RefreshFinish:
                    if (SmartRefreshLayout.this.f20782az == RefreshState.Refreshing) {
                        SmartRefreshLayout.this.mo30865a(RefreshState.RefreshFinish);
                        break;
                    }
                    break;
                case LoadFinish:
                    if (SmartRefreshLayout.this.f20782az == RefreshState.Loading) {
                        SmartRefreshLayout.this.mo30865a(RefreshState.LoadFinish);
                        break;
                    }
                    break;
                case TwoLevelReleased:
                    SmartRefreshLayout.this.mo30865a(RefreshState.TwoLevelReleased);
                    break;
                case TwoLevelFinish:
                    SmartRefreshLayout.this.mo30865a(RefreshState.TwoLevelFinish);
                    break;
                case TwoLevel:
                    SmartRefreshLayout.this.mo30865a(RefreshState.TwoLevel);
                    break;
            }
            return null;
        }

        /* renamed from: a */
        public RefreshKernel mo30930a(boolean z) {
            if (z) {
                C64981 r4 = new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        SmartRefreshLayout.this.f20780ax.mo30929a(RefreshState.TwoLevel);
                    }
                };
                ValueAnimator a = mo30925a(SmartRefreshLayout.this.getMeasuredHeight());
                if (a == null || a != SmartRefreshLayout.this.f20756aN) {
                    r4.onAnimationEnd(null);
                } else {
                    a.setDuration((long) SmartRefreshLayout.this.f20786e);
                    a.addListener(r4);
                }
            } else if (mo30925a(0) == null) {
                SmartRefreshLayout.this.mo30865a(RefreshState.None);
            }
            return this;
        }

        /* renamed from: c */
        public RefreshKernel mo30935c() {
            if (SmartRefreshLayout.this.f20782az == RefreshState.TwoLevel) {
                SmartRefreshLayout.this.f20780ax.mo30929a(RefreshState.TwoLevelFinish);
                if (SmartRefreshLayout.this.f20783b == 0) {
                    mo30926a(0, false);
                    SmartRefreshLayout.this.mo30865a(RefreshState.None);
                } else {
                    mo30925a(0).setDuration((long) SmartRefreshLayout.this.f20786e);
                }
            }
            return this;
        }

        /* renamed from: a */
        public RefreshKernel mo30926a(int i, boolean z) {
            int i2 = i;
            if (SmartRefreshLayout.this.f20783b == i2 && ((SmartRefreshLayout.this.f20775as == null || !SmartRefreshLayout.this.f20775as.mo30952f()) && (SmartRefreshLayout.this.f20776at == null || !SmartRefreshLayout.this.f20776at.mo30952f()))) {
                return this;
            }
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            int i3 = smartRefreshLayout.f20783b;
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            smartRefreshLayout2.f20783b = i2;
            if (z && smartRefreshLayout2.f20746aA.isDragging) {
                if (((float) SmartRefreshLayout.this.f20783b) > ((float) SmartRefreshLayout.this.f20765ai) * SmartRefreshLayout.this.f20773aq) {
                    if (SmartRefreshLayout.this.f20782az != RefreshState.ReleaseToTwoLevel) {
                        SmartRefreshLayout.this.f20780ax.mo30929a(RefreshState.ReleaseToRefresh);
                    }
                } else if (((float) (-SmartRefreshLayout.this.f20783b)) > ((float) SmartRefreshLayout.this.f20767ak) * SmartRefreshLayout.this.f20774ar && !SmartRefreshLayout.this.f20739R) {
                    SmartRefreshLayout.this.f20780ax.mo30929a(RefreshState.ReleaseToLoad);
                } else if (SmartRefreshLayout.this.f20783b < 0 && !SmartRefreshLayout.this.f20739R) {
                    SmartRefreshLayout.this.f20780ax.mo30929a(RefreshState.PullUpToLoad);
                } else if (SmartRefreshLayout.this.f20783b > 0) {
                    SmartRefreshLayout.this.f20780ax.mo30929a(RefreshState.PullDownToRefresh);
                }
            }
            int i4 = 1;
            if (SmartRefreshLayout.this.f20777au != null) {
                Integer num = null;
                if (i2 >= 0 && SmartRefreshLayout.this.f20775as != null) {
                    SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                    if (smartRefreshLayout3.mo30869a(smartRefreshLayout3.f20726E, SmartRefreshLayout.this.f20775as)) {
                        num = Integer.valueOf(i);
                    } else if (i3 < 0) {
                        num = Integer.valueOf(0);
                    }
                }
                if (i2 <= 0 && SmartRefreshLayout.this.f20776at != null) {
                    SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                    if (smartRefreshLayout4.mo30869a(smartRefreshLayout4.f20727F, SmartRefreshLayout.this.f20776at)) {
                        num = Integer.valueOf(i);
                    } else if (i3 > 0) {
                        num = Integer.valueOf(0);
                    }
                }
                if (num != null) {
                    SmartRefreshLayout.this.f20777au.mo30942a(num.intValue(), SmartRefreshLayout.this.f20799r, SmartRefreshLayout.this.f20800s);
                    boolean z2 = SmartRefreshLayout.this.f20724C && SmartRefreshLayout.this.f20775as != null && SmartRefreshLayout.this.f20775as.getSpinnerStyle() == SpinnerStyle.FixedBehind;
                    boolean z3 = z2 || SmartRefreshLayout.this.f20748aC != 0;
                    boolean z4 = SmartRefreshLayout.this.f20725D && SmartRefreshLayout.this.f20776at != null && SmartRefreshLayout.this.f20776at.getSpinnerStyle() == SpinnerStyle.FixedBehind;
                    boolean z5 = z4 || SmartRefreshLayout.this.f20749aD != 0;
                    if ((z3 && (num.intValue() >= 0 || i3 > 0)) || (z5 && (num.intValue() <= 0 || i3 < 0))) {
                        smartRefreshLayout.invalidate();
                    }
                }
            }
            if ((i2 >= 0 || i3 > 0) && SmartRefreshLayout.this.f20775as != null) {
                int max = Math.max(i2, 0);
                int i5 = SmartRefreshLayout.this.f20765ai;
                int i6 = (int) (((float) SmartRefreshLayout.this.f20765ai) * SmartRefreshLayout.this.f20771ao);
                float f = (((float) max) * 1.0f) / ((float) (SmartRefreshLayout.this.f20765ai == 0 ? 1 : SmartRefreshLayout.this.f20765ai));
                SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                if (smartRefreshLayout5.mo30868a(smartRefreshLayout5.f20722A) || (SmartRefreshLayout.this.f20782az == RefreshState.RefreshFinish && !z)) {
                    if (i3 != SmartRefreshLayout.this.f20783b) {
                        if (SmartRefreshLayout.this.f20775as.getSpinnerStyle() == SpinnerStyle.Translate) {
                            SmartRefreshLayout.this.f20775as.getView().setTranslationY((float) SmartRefreshLayout.this.f20783b);
                            if (!(SmartRefreshLayout.this.f20748aC == 0 || SmartRefreshLayout.this.f20778av == null)) {
                                SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                                if (!smartRefreshLayout6.mo30869a(smartRefreshLayout6.f20726E, SmartRefreshLayout.this.f20775as)) {
                                    smartRefreshLayout.invalidate();
                                }
                            }
                        } else if (SmartRefreshLayout.this.f20775as.getSpinnerStyle() == SpinnerStyle.Scale) {
                            SmartRefreshLayout.this.f20775as.getView().requestLayout();
                        }
                        SmartRefreshLayout.this.f20775as.mo30672a(z, f, max, i5, i6);
                    }
                    if (z && SmartRefreshLayout.this.f20775as.mo30952f()) {
                        int i7 = (int) SmartRefreshLayout.this.f20791j;
                        int width = smartRefreshLayout.getWidth();
                        SmartRefreshLayout.this.f20775as.mo30951a(SmartRefreshLayout.this.f20791j / ((float) (width == 0 ? 1 : width)), i7, width);
                    }
                }
                if (!(i3 == SmartRefreshLayout.this.f20783b || SmartRefreshLayout.this.f20758ab == null || !(SmartRefreshLayout.this.f20775as instanceof RefreshHeader))) {
                    SmartRefreshLayout.this.f20758ab.mo30964a((RefreshHeader) SmartRefreshLayout.this.f20775as, z, f, max, i5, i6);
                }
            }
            if ((i2 <= 0 || i3 < 0) && SmartRefreshLayout.this.f20776at != null) {
                int i8 = -Math.min(i2, 0);
                int i9 = SmartRefreshLayout.this.f20767ak;
                int i10 = (int) (((float) SmartRefreshLayout.this.f20767ak) * SmartRefreshLayout.this.f20772ap);
                float f2 = (((float) i8) * 1.0f) / ((float) (SmartRefreshLayout.this.f20767ak == 0 ? 1 : SmartRefreshLayout.this.f20767ak));
                SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                if (smartRefreshLayout7.mo30868a(smartRefreshLayout7.f20723B) || (SmartRefreshLayout.this.f20782az == RefreshState.LoadFinish && !z)) {
                    if (i3 != SmartRefreshLayout.this.f20783b) {
                        if (SmartRefreshLayout.this.f20776at.getSpinnerStyle() == SpinnerStyle.Translate) {
                            SmartRefreshLayout.this.f20776at.getView().setTranslationY((float) SmartRefreshLayout.this.f20783b);
                            if (!(SmartRefreshLayout.this.f20749aD == 0 || SmartRefreshLayout.this.f20778av == null)) {
                                SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                                if (!smartRefreshLayout8.mo30869a(smartRefreshLayout8.f20727F, SmartRefreshLayout.this.f20776at)) {
                                    smartRefreshLayout.invalidate();
                                }
                            }
                        } else if (SmartRefreshLayout.this.f20776at.getSpinnerStyle() == SpinnerStyle.Scale) {
                            SmartRefreshLayout.this.f20776at.getView().requestLayout();
                        }
                        SmartRefreshLayout.this.f20776at.mo30672a(z, f2, i8, i9, i10);
                    }
                    if (z && SmartRefreshLayout.this.f20776at.mo30952f()) {
                        int i11 = (int) SmartRefreshLayout.this.f20791j;
                        int width2 = smartRefreshLayout.getWidth();
                        float f3 = SmartRefreshLayout.this.f20791j;
                        if (width2 != 0) {
                            i4 = width2;
                        }
                        SmartRefreshLayout.this.f20776at.mo30951a(f3 / ((float) i4), i11, width2);
                    }
                }
                if (!(i3 == SmartRefreshLayout.this.f20783b || SmartRefreshLayout.this.f20758ab == null || !(SmartRefreshLayout.this.f20776at instanceof RefreshFooter))) {
                    SmartRefreshLayout.this.f20758ab.mo30961a((RefreshFooter) SmartRefreshLayout.this.f20776at, z, f2, i8, i9, i10);
                }
            }
            return this;
        }

        /* renamed from: a */
        public ValueAnimator mo30925a(int i) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            return smartRefreshLayout.mo30853a(i, 0, smartRefreshLayout.f20806y, SmartRefreshLayout.this.f20787f);
        }

        /* renamed from: a */
        public RefreshKernel mo30927a(RefreshInternal hVar, int i) {
            if (SmartRefreshLayout.this.f20778av == null && i != 0) {
                SmartRefreshLayout.this.f20778av = new Paint();
            }
            if (hVar.equals(SmartRefreshLayout.this.f20775as)) {
                SmartRefreshLayout.this.f20748aC = i;
            } else if (hVar.equals(SmartRefreshLayout.this.f20776at)) {
                SmartRefreshLayout.this.f20749aD = i;
            }
            return this;
        }

        /* renamed from: a */
        public RefreshKernel mo30928a(RefreshInternal hVar, boolean z) {
            if (hVar.equals(SmartRefreshLayout.this.f20775as)) {
                SmartRefreshLayout.this.f20750aE = z;
            } else if (hVar.equals(SmartRefreshLayout.this.f20776at)) {
                SmartRefreshLayout.this.f20751aF = z;
            }
            return this;
        }

        /* renamed from: b */
        public RefreshKernel mo30934b(RefreshInternal hVar, boolean z) {
            if (hVar.equals(SmartRefreshLayout.this.f20775as)) {
                if (!SmartRefreshLayout.this.f20742U) {
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    smartRefreshLayout.f20742U = true;
                    smartRefreshLayout.f20726E = z;
                }
            } else if (hVar.equals(SmartRefreshLayout.this.f20776at) && !SmartRefreshLayout.this.f20743V) {
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                smartRefreshLayout2.f20743V = true;
                smartRefreshLayout2.f20727F = z;
            }
            return this;
        }

        /* renamed from: b */
        public RefreshKernel mo30933b(int i) {
            SmartRefreshLayout.this.f20786e = i;
            return this;
        }
    }

    public SmartRefreshLayout getLayout() {
        return this;
    }

    public SmartRefreshLayout(Context context) {
        this(context, null);
    }

    public SmartRefreshLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SmartRefreshLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20786e = 250;
        this.f20787f = 250;
        this.f20793l = 0.5f;
        this.f20794m = 'n';
        this.f20797p = -1;
        this.f20798q = -1;
        this.f20799r = -1;
        this.f20800s = -1;
        this.f20722A = true;
        this.f20723B = false;
        this.f20724C = true;
        this.f20725D = true;
        this.f20726E = true;
        this.f20727F = true;
        this.f20728G = false;
        this.f20729H = true;
        this.f20730I = true;
        this.f20731J = false;
        this.f20732K = true;
        this.f20733L = false;
        this.f20734M = true;
        this.f20735N = true;
        this.f20736O = true;
        this.f20737P = false;
        this.f20738Q = false;
        this.f20739R = false;
        this.f20740S = false;
        this.f20741T = false;
        this.f20742U = false;
        this.f20743V = false;
        this.f20762af = new int[2];
        this.f20763ag = new NestedScrollingChildHelper(this);
        this.f20764ah = new NestedScrollingParentHelper(this);
        this.f20766aj = DimensionStatus.DefaultUnNotify;
        this.f20768al = DimensionStatus.DefaultUnNotify;
        this.f20771ao = 2.5f;
        this.f20772ap = 2.5f;
        this.f20773aq = 1.0f;
        this.f20774ar = 1.0f;
        this.f20780ax = new C6497d();
        this.f20782az = RefreshState.None;
        this.f20746aA = RefreshState.None;
        this.f20747aB = 0;
        this.f20748aC = 0;
        this.f20749aD = 0;
        this.f20752aG = false;
        this.f20753aK = false;
        this.f20754aL = null;
        super.setClipToPadding(false);
        DensityUtil bVar = new DensityUtil();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f20804w = new Scroller(context);
        this.f20805x = VelocityTracker.obtain();
        this.f20788g = context.getResources().getDisplayMetrics().heightPixels;
        this.f20806y = new ViscousFluidInterpolator();
        this.f20745a = viewConfiguration.getScaledTouchSlop();
        this.f20801t = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f20802u = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f20767ak = bVar.mo30968b(60.0f);
        this.f20765ai = bVar.mo30968b(100.0f);
        DefaultRefreshInitializer cVar = f20721aJ;
        if (cVar != null) {
            cVar.mo30938a(context, this);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SmartRefreshLayout);
        this.f20763ag.setNestedScrollingEnabled(obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableNestedScrolling, this.f20763ag.isNestedScrollingEnabled()));
        this.f20793l = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlDragRate, this.f20793l);
        this.f20771ao = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlHeaderMaxDragRate, this.f20771ao);
        this.f20772ap = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlFooterMaxDragRate, this.f20772ap);
        this.f20773aq = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlHeaderTriggerRate, this.f20773aq);
        this.f20774ar = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlFooterTriggerRate, this.f20774ar);
        this.f20722A = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableRefresh, this.f20722A);
        this.f20787f = obtainStyledAttributes.getInt(R.styleable.SmartRefreshLayout_srlReboundDuration, this.f20787f);
        this.f20723B = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableLoadMore, this.f20723B);
        this.f20765ai = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlHeaderHeight, this.f20765ai);
        this.f20767ak = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlFooterHeight, this.f20767ak);
        this.f20769am = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlHeaderInsetStart, this.f20769am);
        this.f20770an = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlFooterInsetStart, this.f20770an);
        this.f20737P = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlDisableContentWhenRefresh, this.f20737P);
        this.f20738Q = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlDisableContentWhenLoading, this.f20738Q);
        this.f20726E = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableHeaderTranslationContent, this.f20726E);
        this.f20727F = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableFooterTranslationContent, this.f20727F);
        this.f20729H = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnablePreviewInEditMode, this.f20729H);
        this.f20732K = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableAutoLoadMore, this.f20732K);
        this.f20730I = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableOverScrollBounce, this.f20730I);
        this.f20733L = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnablePureScrollMode, this.f20733L);
        this.f20734M = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableScrollContentWhenLoaded, this.f20734M);
        this.f20735N = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableScrollContentWhenRefreshed, this.f20735N);
        this.f20736O = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableLoadMoreWhenContentNotFull, this.f20736O);
        this.f20728G = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableFooterFollowWhenLoadFinished, this.f20728G);
        this.f20724C = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableClipHeaderWhenFixedBehind, this.f20724C);
        this.f20725D = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableClipFooterWhenFixedBehind, this.f20725D);
        this.f20731J = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableOverScrollDrag, this.f20731J);
        this.f20797p = obtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlFixedHeaderViewId, this.f20797p);
        this.f20798q = obtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlFixedFooterViewId, this.f20798q);
        this.f20799r = obtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlHeaderTranslationViewId, this.f20799r);
        this.f20800s = obtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlFooterTranslationViewId, this.f20800s);
        if (this.f20733L && !obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_srlEnableOverScrollDrag)) {
            this.f20731J = true;
        }
        boolean z = this.f20740S || obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_srlEnableLoadMore);
        this.f20740S = z;
        boolean z2 = this.f20742U || obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_srlEnableHeaderTranslationContent);
        this.f20742U = z2;
        boolean z3 = this.f20743V || obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_srlEnableFooterTranslationContent);
        this.f20743V = z3;
        boolean z4 = this.f20741T || obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_srlEnableNestedScrolling);
        this.f20741T = z4;
        this.f20766aj = obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_srlHeaderHeight) ? DimensionStatus.XmlLayoutUnNotify : this.f20766aj;
        this.f20768al = obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_srlFooterHeight) ? DimensionStatus.XmlLayoutUnNotify : this.f20768al;
        int color = obtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_srlAccentColor, 0);
        int color2 = obtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_srlPrimaryColor, 0);
        if (color2 != 0) {
            if (color != 0) {
                this.f20807z = new int[]{color2, color};
            } else {
                this.f20807z = new int[]{color2};
            }
        } else if (color != 0) {
            this.f20807z = new int[]{0, color};
        }
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0052  */
    public void onFinishInflate() {
        /*
        r11 = this;
        super.onFinishInflate()
        int r0 = super.getChildCount()
        r1 = 3
        if (r0 > r1) goto L_0x009e
        r2 = -1
        r3 = 0
        r4 = 0
        r5 = -1
        r6 = 0
    L_0x000f:
        r7 = 2
        r8 = 1
        if (r4 >= r0) goto L_0x0033
        android.view.View r9 = super.getChildAt(r4)
        boolean r10 = com.scwang.smartrefresh.layout.p529c.SmartUtil.m25585c(r9)
        if (r10 == 0) goto L_0x0024
        if (r6 < r7) goto L_0x0021
        if (r4 != r8) goto L_0x0024
    L_0x0021:
        r5 = r4
        r6 = 2
        goto L_0x0030
    L_0x0024:
        boolean r7 = r9 instanceof com.scwang.smartrefresh.layout.p527a.RefreshInternal
        if (r7 != 0) goto L_0x0030
        if (r6 >= r8) goto L_0x0030
        if (r4 <= 0) goto L_0x002d
        goto L_0x002e
    L_0x002d:
        r8 = 0
    L_0x002e:
        r5 = r4
        r6 = r8
    L_0x0030:
        int r4 = r4 + 1
        goto L_0x000f
    L_0x0033:
        if (r5 < 0) goto L_0x004d
        com.scwang.smartrefresh.layout.impl.a r4 = new com.scwang.smartrefresh.layout.impl.a
        android.view.View r6 = super.getChildAt(r5)
        r4.m51161init(r6)
        r11.f20777au = r4
        if (r5 != r8) goto L_0x0048
        if (r0 != r1) goto L_0x0046
        r1 = 0
        goto L_0x004f
    L_0x0046:
        r1 = 0
        goto L_0x004e
    L_0x0048:
        if (r0 != r7) goto L_0x004d
        r1 = -1
        r7 = 1
        goto L_0x004f
    L_0x004d:
        r1 = -1
    L_0x004e:
        r7 = -1
    L_0x004f:
        r4 = 0
    L_0x0050:
        if (r4 >= r0) goto L_0x009d
        android.view.View r5 = super.getChildAt(r4)
        if (r4 == r1) goto L_0x008b
        if (r4 == r7) goto L_0x0065
        if (r1 != r2) goto L_0x0065
        com.scwang.smartrefresh.layout.a.h r6 = r11.f20775as
        if (r6 != 0) goto L_0x0065
        boolean r6 = r5 instanceof com.scwang.smartrefresh.layout.p527a.RefreshHeader
        if (r6 == 0) goto L_0x0065
        goto L_0x008b
    L_0x0065:
        if (r4 == r7) goto L_0x006d
        if (r7 != r2) goto L_0x009a
        boolean r6 = r5 instanceof com.scwang.smartrefresh.layout.p527a.RefreshFooter
        if (r6 == 0) goto L_0x009a
    L_0x006d:
        boolean r6 = r11.f20723B
        if (r6 != 0) goto L_0x0078
        boolean r6 = r11.f20740S
        if (r6 != 0) goto L_0x0076
        goto L_0x0078
    L_0x0076:
        r6 = 0
        goto L_0x0079
    L_0x0078:
        r6 = 1
    L_0x0079:
        r11.f20723B = r6
        boolean r6 = r5 instanceof com.scwang.smartrefresh.layout.p527a.RefreshFooter
        if (r6 == 0) goto L_0x0082
        com.scwang.smartrefresh.layout.a.f r5 = (com.scwang.smartrefresh.layout.p527a.RefreshFooter) r5
        goto L_0x0088
    L_0x0082:
        com.scwang.smartrefresh.layout.impl.RefreshFooterWrapper r6 = new com.scwang.smartrefresh.layout.impl.RefreshFooterWrapper
        r6.m51159init(r5)
        r5 = r6
    L_0x0088:
        r11.f20776at = r5
        goto L_0x009a
    L_0x008b:
        boolean r6 = r5 instanceof com.scwang.smartrefresh.layout.p527a.RefreshHeader
        if (r6 == 0) goto L_0x0092
        com.scwang.smartrefresh.layout.a.g r5 = (com.scwang.smartrefresh.layout.p527a.RefreshHeader) r5
        goto L_0x0098
    L_0x0092:
        com.scwang.smartrefresh.layout.impl.RefreshHeaderWrapper r6 = new com.scwang.smartrefresh.layout.impl.RefreshHeaderWrapper
        r6.m51160init(r5)
        r5 = r6
    L_0x0098:
        r11.f20775as = r5
    L_0x009a:
        int r4 = r4 + 1
        goto L_0x0050
    L_0x009d:
        return
    L_0x009e:
        java.lang.RuntimeException r0 = new java.lang.RuntimeException
        java.lang.String r1 = "最多只支持3个子View，Most only support three sub view"
        r0.<init>(r1)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.onFinishInflate():void");
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            if (this.f20779aw == null) {
                this.f20779aw = new Handler();
            }
            List<DelayedRunnable> list = this.f20781ay;
            View view = null;
            if (list != null) {
                for (DelayedRunnable aVar : list) {
                    this.f20779aw.postDelayed(aVar, aVar.f20841a);
                }
                this.f20781ay.clear();
                this.f20781ay = null;
            }
            if (this.f20775as == null) {
                DefaultRefreshHeaderCreator bVar = f20720aI;
                if (bVar != null) {
                    mo30860a(bVar.mo19823a(getContext(), this));
                } else {
                    mo30860a((RefreshHeader) new BezierRadarHeader(getContext()));
                }
            }
            if (this.f20776at == null) {
                DefaultRefreshFooterCreator aVar2 = f20719aH;
                if (aVar2 != null) {
                    mo30858a(aVar2.mo30937a(getContext(), this));
                } else {
                    boolean z = this.f20723B;
                    mo30858a((RefreshFooter) new BallPulseFooter(getContext()));
                    this.f20723B = z;
                }
            } else {
                boolean z2 = this.f20723B || !this.f20740S;
                this.f20723B = z2;
            }
            if (this.f20777au == null) {
                int childCount = getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = getChildAt(i);
                    RefreshInternal hVar = this.f20775as;
                    if (hVar == null || childAt != hVar.getView()) {
                        RefreshInternal hVar2 = this.f20776at;
                        if (hVar2 == null || childAt != hVar2.getView()) {
                            this.f20777au = new RefreshContentWrapper(childAt);
                        }
                    }
                }
            }
            if (this.f20777au == null) {
                int a = DensityUtil.m25572a(20.0f);
                TextView textView = new TextView(getContext());
                textView.setTextColor(-39424);
                textView.setGravity(17);
                textView.setTextSize(20.0f);
                textView.setText(R.string.srl_content_empty);
                super.addView(textView, -1, -1);
                this.f20777au = new RefreshContentWrapper(textView);
                this.f20777au.mo30941a().setPadding(a, a, a, a);
            }
            int i2 = this.f20797p;
            View findViewById = i2 > 0 ? findViewById(i2) : null;
            int i3 = this.f20798q;
            if (i3 > 0) {
                view = findViewById(i3);
            }
            this.f20777au.mo30945a(this.f20759ac);
            this.f20777au.mo30946a(this.f20736O);
            this.f20777au.mo30944a(this.f20780ax, findViewById, view);
            if (this.f20783b != 0) {
                mo30865a(RefreshState.None);
                RefreshContent eVar = this.f20777au;
                this.f20783b = 0;
                eVar.mo30942a(0, this.f20799r, this.f20800s);
            }
            if (!this.f20741T && !isNestedScrollingEnabled()) {
                post(new Runnable() {
                    public void run() {
                        ViewParent parent = SmartRefreshLayout.this.getParent();
                        while (parent != null) {
                            if (parent instanceof NestedScrollingParent) {
                                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                                if (((NestedScrollingParent) parent).onStartNestedScroll(smartRefreshLayout, smartRefreshLayout, 2)) {
                                    SmartRefreshLayout.this.setNestedScrollingEnabled(true);
                                    SmartRefreshLayout.this.f20741T = false;
                                    return;
                                }
                            }
                            if (parent instanceof View) {
                                parent = ((View) parent).getParent();
                            } else {
                                return;
                            }
                        }
                    }
                });
            }
        }
        int[] iArr = this.f20807z;
        if (iArr != null) {
            RefreshInternal hVar3 = this.f20775as;
            if (hVar3 != null) {
                hVar3.setPrimaryColors(iArr);
            }
            RefreshInternal hVar4 = this.f20776at;
            if (hVar4 != null) {
                hVar4.setPrimaryColors(this.f20807z);
            }
        }
        RefreshContent eVar2 = this.f20777au;
        if (eVar2 != null) {
            super.bringChildToFront(eVar2.mo30941a());
        }
        RefreshInternal hVar5 = this.f20775as;
        if (!(hVar5 == null || hVar5.getSpinnerStyle() == SpinnerStyle.FixedBehind)) {
            super.bringChildToFront(this.f20775as.getView());
        }
        RefreshInternal hVar6 = this.f20776at;
        if (hVar6 != null && hVar6.getSpinnerStyle() != SpinnerStyle.FixedBehind) {
            super.bringChildToFront(this.f20776at.getView());
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x010b  */
    public void onMeasure(int r18, int r19) {
        /*
        r17 = this;
        r0 = r17
        r1 = r18
        r2 = r19
        boolean r3 = r17.isInEditMode()
        r5 = 0
        if (r3 == 0) goto L_0x0013
        boolean r3 = r0.f20729H
        if (r3 == 0) goto L_0x0013
        r3 = 1
        goto L_0x0014
    L_0x0013:
        r3 = 0
    L_0x0014:
        int r6 = super.getChildCount()
        r7 = 0
        r8 = 0
    L_0x001a:
        if (r7 >= r6) goto L_0x02d1
        android.view.View r9 = super.getChildAt(r7)
        com.scwang.smartrefresh.layout.a.h r10 = r0.f20775as
        r13 = -2
        if (r10 == 0) goto L_0x0131
        android.view.View r10 = r10.getView()
        if (r10 != r9) goto L_0x0131
        com.scwang.smartrefresh.layout.a.h r10 = r0.f20775as
        android.view.View r10 = r10.getView()
        android.view.ViewGroup$LayoutParams r15 = r10.getLayoutParams()
        com.scwang.smartrefresh.layout.SmartRefreshLayout$c r15 = (com.scwang.smartrefresh.layout.SmartRefreshLayout.C6496c) r15
        int r4 = r15.leftMargin
        int r12 = r15.rightMargin
        int r4 = r4 + r12
        int r12 = r15.width
        int r4 = android.view.ViewGroup.getChildMeasureSpec(r1, r4, r12)
        int r12 = r0.f20765ai
        com.scwang.smartrefresh.layout.constant.DimensionStatus r14 = r0.f20766aj
        int r14 = r14.ordinal()
        com.scwang.smartrefresh.layout.constant.DimensionStatus r16 = com.scwang.smartrefresh.layout.constant.DimensionStatus.XmlLayoutUnNotify
        int r11 = r16.ordinal()
        if (r14 >= r11) goto L_0x00c3
        int r11 = r15.height
        if (r11 <= 0) goto L_0x0078
        int r11 = r15.height
        int r12 = r15.bottomMargin
        int r11 = r11 + r12
        int r12 = r15.topMargin
        int r14 = r11 + r12
        com.scwang.smartrefresh.layout.constant.DimensionStatus r11 = r0.f20766aj
        com.scwang.smartrefresh.layout.constant.DimensionStatus r12 = com.scwang.smartrefresh.layout.constant.DimensionStatus.XmlExactUnNotify
        boolean r11 = r11.canReplaceWith(r12)
        if (r11 == 0) goto L_0x00c4
        int r11 = r15.height
        int r12 = r15.bottomMargin
        int r11 = r11 + r12
        int r12 = r15.topMargin
        int r11 = r11 + r12
        r0.f20765ai = r11
        com.scwang.smartrefresh.layout.constant.DimensionStatus r11 = com.scwang.smartrefresh.layout.constant.DimensionStatus.XmlExactUnNotify
        r0.f20766aj = r11
        goto L_0x00c4
    L_0x0078:
        int r11 = r15.height
        if (r11 != r13) goto L_0x00c3
        com.scwang.smartrefresh.layout.a.h r11 = r0.f20775as
        com.scwang.smartrefresh.layout.constant.SpinnerStyle r11 = r11.getSpinnerStyle()
        com.scwang.smartrefresh.layout.constant.SpinnerStyle r14 = com.scwang.smartrefresh.layout.constant.SpinnerStyle.MatchLayout
        if (r11 != r14) goto L_0x008c
        com.scwang.smartrefresh.layout.constant.DimensionStatus r11 = r0.f20766aj
        boolean r11 = r11.notified
        if (r11 != 0) goto L_0x00c3
    L_0x008c:
        int r11 = android.view.View.MeasureSpec.getSize(r19)
        int r14 = r15.bottomMargin
        int r11 = r11 - r14
        int r14 = r15.topMargin
        int r11 = r11 - r14
        int r11 = java.lang.Math.max(r11, r5)
        r14 = -2147483648(0xffffffff80000000, float:-0.0)
        int r13 = android.view.View.MeasureSpec.makeMeasureSpec(r11, r14)
        r10.measure(r4, r13)
        int r13 = r10.getMeasuredHeight()
        if (r13 <= 0) goto L_0x00c3
        if (r13 == r11) goto L_0x00c1
        com.scwang.smartrefresh.layout.constant.DimensionStatus r11 = r0.f20766aj
        com.scwang.smartrefresh.layout.constant.DimensionStatus r12 = com.scwang.smartrefresh.layout.constant.DimensionStatus.XmlWrapUnNotify
        boolean r11 = r11.canReplaceWith(r12)
        if (r11 == 0) goto L_0x00c1
        int r11 = r15.bottomMargin
        int r13 = r13 + r11
        int r11 = r15.topMargin
        int r13 = r13 + r11
        r0.f20765ai = r13
        com.scwang.smartrefresh.layout.constant.DimensionStatus r11 = com.scwang.smartrefresh.layout.constant.DimensionStatus.XmlWrapUnNotify
        r0.f20766aj = r11
    L_0x00c1:
        r14 = -1
        goto L_0x00c4
    L_0x00c3:
        r14 = r12
    L_0x00c4:
        com.scwang.smartrefresh.layout.a.h r11 = r0.f20775as
        com.scwang.smartrefresh.layout.constant.SpinnerStyle r11 = r11.getSpinnerStyle()
        com.scwang.smartrefresh.layout.constant.SpinnerStyle r12 = com.scwang.smartrefresh.layout.constant.SpinnerStyle.MatchLayout
        if (r11 != r12) goto L_0x00d3
        int r14 = android.view.View.MeasureSpec.getSize(r19)
        goto L_0x00ef
    L_0x00d3:
        com.scwang.smartrefresh.layout.a.h r11 = r0.f20775as
        com.scwang.smartrefresh.layout.constant.SpinnerStyle r11 = r11.getSpinnerStyle()
        com.scwang.smartrefresh.layout.constant.SpinnerStyle r12 = com.scwang.smartrefresh.layout.constant.SpinnerStyle.Scale
        if (r11 != r12) goto L_0x00ef
        if (r3 != 0) goto L_0x00ef
        boolean r11 = r0.f20722A
        boolean r11 = r0.mo30868a(r11)
        if (r11 == 0) goto L_0x00ea
        int r11 = r0.f20783b
        goto L_0x00eb
    L_0x00ea:
        r11 = 0
    L_0x00eb:
        int r14 = java.lang.Math.max(r5, r11)
    L_0x00ef:
        r11 = -1
        if (r14 == r11) goto L_0x0105
        int r11 = r15.bottomMargin
        int r14 = r14 - r11
        int r11 = r15.topMargin
        int r14 = r14 - r11
        int r11 = java.lang.Math.max(r14, r5)
        r12 = 1073741824(0x40000000, float:2.0)
        int r11 = android.view.View.MeasureSpec.makeMeasureSpec(r11, r12)
        r10.measure(r4, r11)
    L_0x0105:
        com.scwang.smartrefresh.layout.constant.DimensionStatus r4 = r0.f20766aj
        boolean r4 = r4.notified
        if (r4 != 0) goto L_0x0122
        com.scwang.smartrefresh.layout.constant.DimensionStatus r4 = r0.f20766aj
        com.scwang.smartrefresh.layout.constant.DimensionStatus r4 = r4.notified()
        r0.f20766aj = r4
        com.scwang.smartrefresh.layout.a.h r4 = r0.f20775as
        com.scwang.smartrefresh.layout.a.i r11 = r0.f20780ax
        int r12 = r0.f20765ai
        float r13 = r0.f20771ao
        float r14 = (float) r12
        float r13 = r13 * r14
        int r13 = (int) r13
        r4.mo30677a(r11, r12, r13)
    L_0x0122:
        if (r3 == 0) goto L_0x0131
        boolean r4 = r0.f20722A
        boolean r4 = r0.mo30868a(r4)
        if (r4 == 0) goto L_0x0131
        int r4 = r10.getMeasuredHeight()
        int r8 = r8 + r4
    L_0x0131:
        com.scwang.smartrefresh.layout.a.h r4 = r0.f20776at
        if (r4 == 0) goto L_0x0241
        android.view.View r4 = r4.getView()
        if (r4 != r9) goto L_0x0241
        com.scwang.smartrefresh.layout.a.h r4 = r0.f20776at
        android.view.View r4 = r4.getView()
        android.view.ViewGroup$LayoutParams r10 = r4.getLayoutParams()
        com.scwang.smartrefresh.layout.SmartRefreshLayout$c r10 = (com.scwang.smartrefresh.layout.SmartRefreshLayout.C6496c) r10
        int r11 = r10.leftMargin
        int r12 = r10.rightMargin
        int r11 = r11 + r12
        int r12 = r10.width
        int r11 = android.view.ViewGroup.getChildMeasureSpec(r1, r11, r12)
        int r14 = r0.f20767ak
        com.scwang.smartrefresh.layout.constant.DimensionStatus r12 = r0.f20768al
        int r12 = r12.ordinal()
        com.scwang.smartrefresh.layout.constant.DimensionStatus r13 = com.scwang.smartrefresh.layout.constant.DimensionStatus.XmlLayoutUnNotify
        int r13 = r13.ordinal()
        if (r12 >= r13) goto L_0x01d3
        int r12 = r10.height
        if (r12 <= 0) goto L_0x0188
        int r12 = r10.height
        int r13 = r10.topMargin
        int r12 = r12 + r13
        int r13 = r10.bottomMargin
        int r14 = r12 + r13
        com.scwang.smartrefresh.layout.constant.DimensionStatus r12 = r0.f20768al
        com.scwang.smartrefresh.layout.constant.DimensionStatus r13 = com.scwang.smartrefresh.layout.constant.DimensionStatus.XmlExactUnNotify
        boolean r12 = r12.canReplaceWith(r13)
        if (r12 == 0) goto L_0x01d3
        int r12 = r10.height
        int r13 = r10.topMargin
        int r12 = r12 + r13
        int r13 = r10.bottomMargin
        int r12 = r12 + r13
        r0.f20767ak = r12
        com.scwang.smartrefresh.layout.constant.DimensionStatus r12 = com.scwang.smartrefresh.layout.constant.DimensionStatus.XmlExactUnNotify
        r0.f20768al = r12
        goto L_0x01d3
    L_0x0188:
        int r12 = r10.height
        r13 = -2
        if (r12 != r13) goto L_0x01d3
        com.scwang.smartrefresh.layout.a.h r12 = r0.f20776at
        com.scwang.smartrefresh.layout.constant.SpinnerStyle r12 = r12.getSpinnerStyle()
        com.scwang.smartrefresh.layout.constant.SpinnerStyle r13 = com.scwang.smartrefresh.layout.constant.SpinnerStyle.MatchLayout
        if (r12 != r13) goto L_0x019d
        com.scwang.smartrefresh.layout.constant.DimensionStatus r12 = r0.f20768al
        boolean r12 = r12.notified
        if (r12 != 0) goto L_0x01d3
    L_0x019d:
        int r12 = android.view.View.MeasureSpec.getSize(r19)
        int r13 = r10.bottomMargin
        int r12 = r12 - r13
        int r13 = r10.topMargin
        int r12 = r12 - r13
        int r12 = java.lang.Math.max(r12, r5)
        r13 = -2147483648(0xffffffff80000000, float:-0.0)
        int r13 = android.view.View.MeasureSpec.makeMeasureSpec(r12, r13)
        r4.measure(r11, r13)
        int r13 = r4.getMeasuredHeight()
        if (r13 <= 0) goto L_0x01d3
        if (r13 == r12) goto L_0x01d2
        com.scwang.smartrefresh.layout.constant.DimensionStatus r12 = r0.f20768al
        com.scwang.smartrefresh.layout.constant.DimensionStatus r14 = com.scwang.smartrefresh.layout.constant.DimensionStatus.XmlWrapUnNotify
        boolean r12 = r12.canReplaceWith(r14)
        if (r12 == 0) goto L_0x01d2
        int r12 = r10.topMargin
        int r13 = r13 + r12
        int r12 = r10.bottomMargin
        int r13 = r13 + r12
        r0.f20767ak = r13
        com.scwang.smartrefresh.layout.constant.DimensionStatus r12 = com.scwang.smartrefresh.layout.constant.DimensionStatus.XmlWrapUnNotify
        r0.f20768al = r12
    L_0x01d2:
        r14 = -1
    L_0x01d3:
        com.scwang.smartrefresh.layout.a.h r12 = r0.f20776at
        com.scwang.smartrefresh.layout.constant.SpinnerStyle r12 = r12.getSpinnerStyle()
        com.scwang.smartrefresh.layout.constant.SpinnerStyle r13 = com.scwang.smartrefresh.layout.constant.SpinnerStyle.MatchLayout
        if (r12 != r13) goto L_0x01e2
        int r14 = android.view.View.MeasureSpec.getSize(r19)
        goto L_0x01ff
    L_0x01e2:
        com.scwang.smartrefresh.layout.a.h r12 = r0.f20776at
        com.scwang.smartrefresh.layout.constant.SpinnerStyle r12 = r12.getSpinnerStyle()
        com.scwang.smartrefresh.layout.constant.SpinnerStyle r13 = com.scwang.smartrefresh.layout.constant.SpinnerStyle.Scale
        if (r12 != r13) goto L_0x01ff
        if (r3 != 0) goto L_0x01ff
        boolean r12 = r0.f20723B
        boolean r12 = r0.mo30868a(r12)
        if (r12 == 0) goto L_0x01fa
        int r12 = r0.f20783b
        int r12 = -r12
        goto L_0x01fb
    L_0x01fa:
        r12 = 0
    L_0x01fb:
        int r14 = java.lang.Math.max(r5, r12)
    L_0x01ff:
        r12 = -1
        if (r14 == r12) goto L_0x0215
        int r12 = r10.bottomMargin
        int r14 = r14 - r12
        int r10 = r10.topMargin
        int r14 = r14 - r10
        int r10 = java.lang.Math.max(r14, r5)
        r12 = 1073741824(0x40000000, float:2.0)
        int r10 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r12)
        r4.measure(r11, r10)
    L_0x0215:
        com.scwang.smartrefresh.layout.constant.DimensionStatus r10 = r0.f20768al
        boolean r10 = r10.notified
        if (r10 != 0) goto L_0x0232
        com.scwang.smartrefresh.layout.constant.DimensionStatus r10 = r0.f20768al
        com.scwang.smartrefresh.layout.constant.DimensionStatus r10 = r10.notified()
        r0.f20768al = r10
        com.scwang.smartrefresh.layout.a.h r10 = r0.f20776at
        com.scwang.smartrefresh.layout.a.i r11 = r0.f20780ax
        int r12 = r0.f20767ak
        float r13 = r0.f20772ap
        float r14 = (float) r12
        float r13 = r13 * r14
        int r13 = (int) r13
        r10.mo30677a(r11, r12, r13)
    L_0x0232:
        if (r3 == 0) goto L_0x0241
        boolean r10 = r0.f20723B
        boolean r10 = r0.mo30868a(r10)
        if (r10 == 0) goto L_0x0241
        int r4 = r4.getMeasuredHeight()
        int r8 = r8 + r4
    L_0x0241:
        com.scwang.smartrefresh.layout.a.e r4 = r0.f20777au
        if (r4 == 0) goto L_0x02cd
        android.view.View r4 = r4.mo30941a()
        if (r4 != r9) goto L_0x02cd
        com.scwang.smartrefresh.layout.a.e r4 = r0.f20777au
        android.view.View r4 = r4.mo30941a()
        android.view.ViewGroup$LayoutParams r9 = r4.getLayoutParams()
        com.scwang.smartrefresh.layout.SmartRefreshLayout$c r9 = (com.scwang.smartrefresh.layout.SmartRefreshLayout.C6496c) r9
        com.scwang.smartrefresh.layout.a.h r10 = r0.f20775as
        if (r10 == 0) goto L_0x026f
        boolean r10 = r0.f20722A
        boolean r10 = r0.mo30868a(r10)
        if (r10 == 0) goto L_0x026f
        boolean r10 = r0.f20726E
        com.scwang.smartrefresh.layout.a.h r11 = r0.f20775as
        boolean r10 = r0.mo30869a(r10, r11)
        if (r10 == 0) goto L_0x026f
        r10 = 1
        goto L_0x0270
    L_0x026f:
        r10 = 0
    L_0x0270:
        com.scwang.smartrefresh.layout.a.h r11 = r0.f20776at
        if (r11 == 0) goto L_0x0288
        boolean r11 = r0.f20723B
        boolean r11 = r0.mo30868a(r11)
        if (r11 == 0) goto L_0x0288
        boolean r11 = r0.f20727F
        com.scwang.smartrefresh.layout.a.h r12 = r0.f20776at
        boolean r11 = r0.mo30869a(r11, r12)
        if (r11 == 0) goto L_0x0288
        r11 = 1
        goto L_0x0289
    L_0x0288:
        r11 = 0
    L_0x0289:
        int r12 = r17.getPaddingLeft()
        int r13 = r17.getPaddingRight()
        int r12 = r12 + r13
        int r13 = r9.leftMargin
        int r12 = r12 + r13
        int r13 = r9.rightMargin
        int r12 = r12 + r13
        int r13 = r9.width
        int r12 = android.view.ViewGroup.getChildMeasureSpec(r1, r12, r13)
        int r13 = r17.getPaddingTop()
        int r14 = r17.getPaddingBottom()
        int r13 = r13 + r14
        int r14 = r9.topMargin
        int r13 = r13 + r14
        int r14 = r9.bottomMargin
        int r13 = r13 + r14
        if (r3 == 0) goto L_0x02b4
        if (r10 == 0) goto L_0x02b4
        int r10 = r0.f20765ai
        goto L_0x02b5
    L_0x02b4:
        r10 = 0
    L_0x02b5:
        int r13 = r13 + r10
        if (r3 == 0) goto L_0x02bd
        if (r11 == 0) goto L_0x02bd
        int r10 = r0.f20767ak
        goto L_0x02be
    L_0x02bd:
        r10 = 0
    L_0x02be:
        int r13 = r13 + r10
        int r9 = r9.height
        int r9 = android.view.ViewGroup.getChildMeasureSpec(r2, r13, r9)
        r4.measure(r12, r9)
        int r4 = r4.getMeasuredHeight()
        int r8 = r8 + r4
    L_0x02cd:
        int r7 = r7 + 1
        goto L_0x001a
    L_0x02d1:
        int r3 = super.getSuggestedMinimumWidth()
        int r1 = android.view.View.resolveSize(r3, r1)
        int r2 = android.view.View.resolveSize(r8, r2)
        super.setMeasuredDimension(r1, r2)
        int r1 = r17.getMeasuredWidth()
        int r1 = r1 / 2
        float r1 = (float) r1
        r0.f20791j = r1
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        int childCount = super.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = super.getChildAt(i6);
            RefreshContent eVar = this.f20777au;
            boolean z2 = true;
            if (eVar != null && eVar.mo30941a() == childAt) {
                boolean z3 = isInEditMode() && this.f20729H && mo30868a(this.f20722A) && this.f20775as != null;
                View a = this.f20777au.mo30941a();
                C6496c cVar = (C6496c) a.getLayoutParams();
                int i7 = cVar.leftMargin + paddingLeft;
                int i8 = cVar.topMargin + paddingTop;
                int measuredWidth = a.getMeasuredWidth() + i7;
                int measuredHeight = a.getMeasuredHeight() + i8;
                if (z3 && mo30869a(this.f20726E, this.f20775as)) {
                    int i9 = this.f20765ai;
                    i8 += i9;
                    measuredHeight += i9;
                }
                a.layout(i7, i8, measuredWidth, measuredHeight);
            }
            RefreshInternal hVar = this.f20775as;
            if (hVar != null && hVar.getView() == childAt) {
                boolean z4 = isInEditMode() && this.f20729H && mo30868a(this.f20722A);
                View view = this.f20775as.getView();
                C6496c cVar2 = (C6496c) view.getLayoutParams();
                int i10 = cVar2.leftMargin;
                int i11 = cVar2.topMargin + this.f20769am;
                int measuredWidth2 = view.getMeasuredWidth() + i10;
                int measuredHeight2 = view.getMeasuredHeight() + i11;
                if (!z4 && this.f20775as.getSpinnerStyle() == SpinnerStyle.Translate) {
                    int i12 = this.f20765ai;
                    i11 -= i12;
                    measuredHeight2 -= i12;
                }
                view.layout(i10, i11, measuredWidth2, measuredHeight2);
            }
            RefreshInternal hVar2 = this.f20776at;
            if (hVar2 != null && hVar2.getView() == childAt) {
                if (!isInEditMode() || !this.f20729H || !mo30868a(this.f20723B)) {
                    z2 = false;
                }
                View view2 = this.f20776at.getView();
                C6496c cVar3 = (C6496c) view2.getLayoutParams();
                SpinnerStyle spinnerStyle = this.f20776at.getSpinnerStyle();
                int i13 = cVar3.leftMargin;
                int measuredHeight3 = (cVar3.topMargin + getMeasuredHeight()) - this.f20770an;
                if (spinnerStyle == SpinnerStyle.MatchLayout) {
                    measuredHeight3 = cVar3.topMargin - this.f20770an;
                } else {
                    if (z2 || spinnerStyle == SpinnerStyle.FixedFront || spinnerStyle == SpinnerStyle.FixedBehind) {
                        i5 = this.f20767ak;
                    } else if (spinnerStyle == SpinnerStyle.Scale && this.f20783b < 0) {
                        i5 = Math.max(mo30868a(this.f20723B) ? -this.f20783b : 0, 0);
                    }
                    measuredHeight3 -= i5;
                }
                view2.layout(i13, measuredHeight3, view2.getMeasuredWidth() + i13, view2.getMeasuredHeight() + measuredHeight3);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f20780ax.mo30926a(0, true);
        mo30865a(RefreshState.None);
        Handler handler = this.f20779aw;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f20779aw = null;
        }
        List<DelayedRunnable> list = this.f20781ay;
        if (list != null) {
            list.clear();
            this.f20781ay = null;
        }
        this.f20740S = true;
        this.f20741T = true;
        this.f20755aM = null;
        ValueAnimator valueAnimator = this.f20756aN;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.f20756aN.removeAllUpdateListeners();
            this.f20756aN.cancel();
            this.f20756aN = null;
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        RefreshContent eVar = this.f20777au;
        View a = eVar != null ? eVar.mo30941a() : null;
        RefreshInternal hVar = this.f20775as;
        if (hVar != null && hVar.getView() == view) {
            if (!mo30868a(this.f20722A) || (!this.f20729H && isInEditMode())) {
                return true;
            }
            if (a != null) {
                int max = Math.max(a.getTop() + a.getPaddingTop() + this.f20783b, view.getTop());
                int i = this.f20748aC;
                if (i != 0) {
                    Paint paint = this.f20778av;
                    if (paint != null) {
                        paint.setColor(i);
                        if (this.f20775as.getSpinnerStyle() == SpinnerStyle.Scale) {
                            max = view.getBottom();
                        } else if (this.f20775as.getSpinnerStyle() == SpinnerStyle.Translate) {
                            max = view.getBottom() + this.f20783b;
                        }
                        canvas.drawRect((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) max, this.f20778av);
                    }
                }
                if (this.f20724C && this.f20775as.getSpinnerStyle() == SpinnerStyle.FixedBehind) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), max);
                    boolean drawChild = super.drawChild(canvas, view, j);
                    canvas.restore();
                    return drawChild;
                }
            }
        }
        RefreshInternal hVar2 = this.f20776at;
        if (hVar2 != null && hVar2.getView() == view) {
            if (!mo30868a(this.f20723B) || (!this.f20729H && isInEditMode())) {
                return true;
            }
            if (a != null) {
                int min = Math.min((a.getBottom() - a.getPaddingBottom()) + this.f20783b, view.getBottom());
                int i2 = this.f20749aD;
                if (i2 != 0) {
                    Paint paint2 = this.f20778av;
                    if (paint2 != null) {
                        paint2.setColor(i2);
                        if (this.f20776at.getSpinnerStyle() == SpinnerStyle.Scale) {
                            min = view.getTop();
                        } else if (this.f20776at.getSpinnerStyle() == SpinnerStyle.Translate) {
                            min = view.getTop() + this.f20783b;
                        }
                        canvas.drawRect((float) view.getLeft(), (float) min, (float) view.getRight(), (float) view.getBottom(), this.f20778av);
                    }
                }
                if (this.f20725D && this.f20776at.getSpinnerStyle() == SpinnerStyle.FixedBehind) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), min, view.getRight(), view.getBottom());
                    boolean drawChild2 = super.drawChild(canvas, view, j);
                    canvas.restore();
                    return drawChild2;
                }
            }
        }
        return super.drawChild(canvas, view, j);
    }

    public void computeScroll() {
        this.f20804w.getCurrY();
        if (this.f20804w.computeScrollOffset()) {
            int finalY = this.f20804w.getFinalY();
            if ((finalY >= 0 || ((!this.f20731J && !mo30868a(this.f20722A)) || !this.f20777au.mo30948c())) && (finalY <= 0 || ((!this.f20731J && !mo30868a(this.f20723B)) || !this.f20777au.mo30949d()))) {
                this.f20753aK = true;
                invalidate();
                return;
            }
            if (this.f20753aK) {
                float f = VERSION.SDK_INT >= 14 ? finalY > 0 ? -this.f20804w.getCurrVelocity() : this.f20804w.getCurrVelocity() : (((float) (this.f20804w.getCurrY() - finalY)) * 1.0f) / ((float) Math.max(this.f20804w.getDuration() - this.f20804w.timePassed(), 1));
                mo30864a(f);
            }
            this.f20804w.forceFinished(true);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:90:0x011c, code lost:
            if (r6 != 3) goto L_0x033c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x02d1  */
    public boolean dispatchTouchEvent(android.view.MotionEvent r23) {
        /*
        r22 = this;
        r0 = r22
        r1 = r23
        int r6 = r23.getActionMasked()
        r2 = 6
        r10 = 0
        r11 = 1
        if (r6 != r2) goto L_0x000f
        r3 = 1
        goto L_0x0010
    L_0x000f:
        r3 = 0
    L_0x0010:
        if (r3 == 0) goto L_0x0017
        int r4 = r23.getActionIndex()
        goto L_0x0018
    L_0x0017:
        r4 = -1
    L_0x0018:
        int r5 = r23.getPointerCount()
        r7 = 0
        r8 = 0
        r9 = 0
        r12 = 0
    L_0x0020:
        if (r8 >= r5) goto L_0x0032
        if (r4 != r8) goto L_0x0025
        goto L_0x002f
    L_0x0025:
        float r13 = r1.getX(r8)
        float r9 = r9 + r13
        float r13 = r1.getY(r8)
        float r12 = r12 + r13
    L_0x002f:
        int r8 = r8 + 1
        goto L_0x0020
    L_0x0032:
        if (r3 == 0) goto L_0x0036
        int r5 = r5 + -1
    L_0x0036:
        float r3 = (float) r5
        float r9 = r9 / r3
        float r8 = r12 / r3
        r3 = 5
        if (r6 == r2) goto L_0x003f
        if (r6 != r3) goto L_0x004c
    L_0x003f:
        boolean r4 = r0.f20795n
        if (r4 == 0) goto L_0x004c
        float r4 = r0.f20790i
        float r5 = r0.f20792k
        float r5 = r8 - r5
        float r4 = r4 + r5
        r0.f20790i = r4
    L_0x004c:
        r0.f20791j = r9
        r0.f20792k = r8
        boolean r4 = r0.f20761ae
        r5 = 2
        if (r4 == 0) goto L_0x00a8
        int r2 = r0.f20760ad
        boolean r1 = super.dispatchTouchEvent(r23)
        if (r6 != r5) goto L_0x00a7
        int r3 = r0.f20760ad
        if (r2 != r3) goto L_0x00a7
        float r2 = r0.f20791j
        int r2 = (int) r2
        int r3 = r22.getWidth()
        float r4 = r0.f20791j
        if (r3 != 0) goto L_0x006d
        goto L_0x006e
    L_0x006d:
        r11 = r3
    L_0x006e:
        float r5 = (float) r11
        float r4 = r4 / r5
        boolean r5 = r0.f20722A
        boolean r5 = r0.mo30868a(r5)
        if (r5 == 0) goto L_0x008c
        int r5 = r0.f20783b
        if (r5 <= 0) goto L_0x008c
        com.scwang.smartrefresh.layout.a.h r5 = r0.f20775as
        if (r5 == 0) goto L_0x008c
        boolean r5 = r5.mo30952f()
        if (r5 == 0) goto L_0x008c
        com.scwang.smartrefresh.layout.a.h r5 = r0.f20775as
        r5.mo30951a(r4, r2, r3)
        goto L_0x00a7
    L_0x008c:
        boolean r5 = r0.f20723B
        boolean r5 = r0.mo30868a(r5)
        if (r5 == 0) goto L_0x00a7
        int r5 = r0.f20783b
        if (r5 >= 0) goto L_0x00a7
        com.scwang.smartrefresh.layout.a.h r5 = r0.f20776at
        if (r5 == 0) goto L_0x00a7
        boolean r5 = r5.mo30952f()
        if (r5 == 0) goto L_0x00a7
        com.scwang.smartrefresh.layout.a.h r5 = r0.f20776at
        r5.mo30951a(r4, r2, r3)
    L_0x00a7:
        return r1
    L_0x00a8:
        boolean r4 = r22.isEnabled()
        if (r4 == 0) goto L_0x0381
        boolean r4 = r0.f20722A
        boolean r4 = r0.mo30868a(r4)
        if (r4 != 0) goto L_0x00c2
        boolean r4 = r0.f20723B
        boolean r4 = r0.mo30868a(r4)
        if (r4 != 0) goto L_0x00c2
        boolean r4 = r0.f20731J
        if (r4 == 0) goto L_0x0381
    L_0x00c2:
        boolean r4 = r0.f20750aE
        if (r4 == 0) goto L_0x00d8
        com.scwang.smartrefresh.layout.constant.RefreshState r4 = r0.f20782az
        boolean r4 = r4.isOpening
        if (r4 != 0) goto L_0x00d2
        com.scwang.smartrefresh.layout.constant.RefreshState r4 = r0.f20782az
        boolean r4 = r4.isFinishing
        if (r4 == 0) goto L_0x00d8
    L_0x00d2:
        com.scwang.smartrefresh.layout.constant.RefreshState r4 = r0.f20782az
        boolean r4 = r4.isHeader
        if (r4 != 0) goto L_0x0381
    L_0x00d8:
        boolean r4 = r0.f20751aF
        if (r4 == 0) goto L_0x00f0
        com.scwang.smartrefresh.layout.constant.RefreshState r4 = r0.f20782az
        boolean r4 = r4.isOpening
        if (r4 != 0) goto L_0x00e8
        com.scwang.smartrefresh.layout.constant.RefreshState r4 = r0.f20782az
        boolean r4 = r4.isFinishing
        if (r4 == 0) goto L_0x00f0
    L_0x00e8:
        com.scwang.smartrefresh.layout.constant.RefreshState r4 = r0.f20782az
        boolean r4 = r4.isFooter
        if (r4 == 0) goto L_0x00f0
        goto L_0x0381
    L_0x00f0:
        boolean r4 = r0.mo30866a(r6)
        if (r4 != 0) goto L_0x0380
        com.scwang.smartrefresh.layout.constant.RefreshState r4 = r0.f20782az
        boolean r4 = r4.isFinishing
        if (r4 != 0) goto L_0x0380
        com.scwang.smartrefresh.layout.constant.RefreshState r4 = r0.f20782az
        com.scwang.smartrefresh.layout.constant.RefreshState r12 = com.scwang.smartrefresh.layout.constant.RefreshState.Loading
        if (r4 != r12) goto L_0x0106
        boolean r4 = r0.f20738Q
        if (r4 != 0) goto L_0x0380
    L_0x0106:
        com.scwang.smartrefresh.layout.constant.RefreshState r4 = r0.f20782az
        com.scwang.smartrefresh.layout.constant.RefreshState r12 = com.scwang.smartrefresh.layout.constant.RefreshState.Refreshing
        if (r4 != r12) goto L_0x0112
        boolean r4 = r0.f20737P
        if (r4 == 0) goto L_0x0112
        goto L_0x0380
    L_0x0112:
        r4 = 104(0x68, float:1.46E-43)
        if (r6 == 0) goto L_0x0341
        r2 = 0
        if (r6 == r11) goto L_0x02f3
        r3 = 3
        if (r6 == r5) goto L_0x0120
        if (r6 == r3) goto L_0x030e
        goto L_0x033c
    L_0x0120:
        float r5 = r0.f20789h
        float r9 = r9 - r5
        float r5 = r0.f20790i
        float r5 = r8 - r5
        android.view.VelocityTracker r6 = r0.f20805x
        r6.addMovement(r1)
        boolean r6 = r0.f20795n
        if (r6 != 0) goto L_0x01fe
        char r6 = r0.f20794m
        if (r6 == r4) goto L_0x01fe
        com.scwang.smartrefresh.layout.a.e r12 = r0.f20777au
        if (r12 == 0) goto L_0x01fe
        r12 = 118(0x76, float:1.65E-43)
        if (r6 == r12) goto L_0x0173
        float r6 = java.lang.Math.abs(r5)
        int r13 = r0.f20745a
        float r13 = (float) r13
        int r6 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
        if (r6 < 0) goto L_0x0154
        float r6 = java.lang.Math.abs(r9)
        float r13 = java.lang.Math.abs(r5)
        int r6 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
        if (r6 >= 0) goto L_0x0154
        goto L_0x0173
    L_0x0154:
        float r6 = java.lang.Math.abs(r9)
        int r13 = r0.f20745a
        float r13 = (float) r13
        int r6 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
        if (r6 < 0) goto L_0x01fe
        float r6 = java.lang.Math.abs(r9)
        float r13 = java.lang.Math.abs(r5)
        int r6 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
        if (r6 <= 0) goto L_0x01fe
        char r6 = r0.f20794m
        if (r6 == r12) goto L_0x01fe
        r0.f20794m = r4
        goto L_0x01fe
    L_0x0173:
        r0.f20794m = r12
        int r4 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
        if (r4 <= 0) goto L_0x019b
        int r4 = r0.f20783b
        if (r4 < 0) goto L_0x0191
        boolean r4 = r0.f20731J
        if (r4 != 0) goto L_0x0189
        boolean r4 = r0.f20722A
        boolean r4 = r0.mo30868a(r4)
        if (r4 == 0) goto L_0x019b
    L_0x0189:
        com.scwang.smartrefresh.layout.a.e r4 = r0.f20777au
        boolean r4 = r4.mo30948c()
        if (r4 == 0) goto L_0x019b
    L_0x0191:
        r0.f20795n = r11
        int r4 = r0.f20745a
        float r4 = (float) r4
        float r4 = r8 - r4
        r0.f20790i = r4
        goto L_0x01c9
    L_0x019b:
        int r4 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
        if (r4 >= 0) goto L_0x01c9
        int r4 = r0.f20783b
        if (r4 > 0) goto L_0x01c1
        boolean r4 = r0.f20731J
        if (r4 != 0) goto L_0x01af
        boolean r4 = r0.f20723B
        boolean r4 = r0.mo30868a(r4)
        if (r4 == 0) goto L_0x01c9
    L_0x01af:
        com.scwang.smartrefresh.layout.constant.RefreshState r4 = r0.f20782az
        com.scwang.smartrefresh.layout.constant.RefreshState r6 = com.scwang.smartrefresh.layout.constant.RefreshState.Loading
        if (r4 != r6) goto L_0x01b9
        boolean r4 = r0.f20752aG
        if (r4 != 0) goto L_0x01c1
    L_0x01b9:
        com.scwang.smartrefresh.layout.a.e r4 = r0.f20777au
        boolean r4 = r4.mo30949d()
        if (r4 == 0) goto L_0x01c9
    L_0x01c1:
        r0.f20795n = r11
        int r4 = r0.f20745a
        float r4 = (float) r4
        float r4 = r4 + r8
        r0.f20790i = r4
    L_0x01c9:
        boolean r4 = r0.f20795n
        if (r4 == 0) goto L_0x01fe
        float r4 = r0.f20790i
        float r5 = r8 - r4
        boolean r4 = r0.f20796o
        if (r4 == 0) goto L_0x01db
        r1.setAction(r3)
        super.dispatchTouchEvent(r23)
    L_0x01db:
        int r4 = r0.f20783b
        if (r4 > 0) goto L_0x01ee
        if (r4 != 0) goto L_0x01e6
        int r4 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
        if (r4 <= 0) goto L_0x01e6
        goto L_0x01ee
    L_0x01e6:
        com.scwang.smartrefresh.layout.a.i r4 = r0.f20780ax
        com.scwang.smartrefresh.layout.constant.RefreshState r6 = com.scwang.smartrefresh.layout.constant.RefreshState.PullUpToLoad
        r4.mo30929a(r6)
        goto L_0x01f5
    L_0x01ee:
        com.scwang.smartrefresh.layout.a.i r4 = r0.f20780ax
        com.scwang.smartrefresh.layout.constant.RefreshState r6 = com.scwang.smartrefresh.layout.constant.RefreshState.PullDownToRefresh
        r4.mo30929a(r6)
    L_0x01f5:
        android.view.ViewParent r4 = r22.getParent()
        if (r4 == 0) goto L_0x01fe
        r4.requestDisallowInterceptTouchEvent(r11)
    L_0x01fe:
        boolean r4 = r0.f20795n
        if (r4 == 0) goto L_0x02e1
        int r4 = (int) r5
        int r6 = r0.f20785d
        int r4 = r4 + r6
        com.scwang.smartrefresh.layout.constant.RefreshState r6 = r0.f20746aA
        boolean r6 = r6.isHeader
        if (r6 == 0) goto L_0x0212
        if (r4 < 0) goto L_0x021e
        int r6 = r0.f20784c
        if (r6 < 0) goto L_0x021e
    L_0x0212:
        com.scwang.smartrefresh.layout.constant.RefreshState r6 = r0.f20746aA
        boolean r6 = r6.isFooter
        if (r6 == 0) goto L_0x02dc
        if (r4 > 0) goto L_0x021e
        int r6 = r0.f20784c
        if (r6 <= 0) goto L_0x02dc
    L_0x021e:
        r0.f20784c = r4
        long r20 = r23.getEventTime()
        android.view.MotionEvent r1 = r0.f20754aL
        if (r1 != 0) goto L_0x0243
        r16 = 0
        float r1 = r0.f20789h
        float r17 = r1 + r9
        float r1 = r0.f20790i
        r19 = 0
        r12 = r20
        r14 = r20
        r18 = r1
        android.view.MotionEvent r1 = android.view.MotionEvent.obtain(r12, r14, r16, r17, r18, r19)
        r0.f20754aL = r1
        android.view.MotionEvent r1 = r0.f20754aL
        super.dispatchTouchEvent(r1)
    L_0x0243:
        r16 = 2
        float r1 = r0.f20789h
        float r17 = r1 + r9
        float r1 = r0.f20790i
        float r6 = (float) r4
        float r18 = r1 + r6
        r19 = 0
        r12 = r20
        r14 = r20
        android.view.MotionEvent r1 = android.view.MotionEvent.obtain(r12, r14, r16, r17, r18, r19)
        super.dispatchTouchEvent(r1)
        boolean r6 = r0.f20752aG
        if (r6 == 0) goto L_0x026c
        int r6 = r0.f20745a
        float r6 = (float) r6
        int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
        if (r5 <= 0) goto L_0x026c
        int r5 = r0.f20783b
        if (r5 >= 0) goto L_0x026c
        r0.f20752aG = r10
    L_0x026c:
        if (r4 <= 0) goto L_0x0291
        boolean r5 = r0.f20731J
        if (r5 != 0) goto L_0x027a
        boolean r5 = r0.f20722A
        boolean r5 = r0.mo30868a(r5)
        if (r5 == 0) goto L_0x0291
    L_0x027a:
        com.scwang.smartrefresh.layout.a.e r5 = r0.f20777au
        boolean r5 = r5.mo30948c()
        if (r5 == 0) goto L_0x0291
        r0.f20792k = r8
        r0.f20790i = r8
        r0.f20785d = r10
        com.scwang.smartrefresh.layout.a.i r4 = r0.f20780ax
        com.scwang.smartrefresh.layout.constant.RefreshState r5 = com.scwang.smartrefresh.layout.constant.RefreshState.PullDownToRefresh
        r4.mo30929a(r5)
    L_0x028f:
        r4 = 0
        goto L_0x02b5
    L_0x0291:
        if (r4 >= 0) goto L_0x02b5
        boolean r5 = r0.f20731J
        if (r5 != 0) goto L_0x029f
        boolean r5 = r0.f20723B
        boolean r5 = r0.mo30868a(r5)
        if (r5 == 0) goto L_0x02b5
    L_0x029f:
        com.scwang.smartrefresh.layout.a.e r5 = r0.f20777au
        boolean r5 = r5.mo30949d()
        if (r5 == 0) goto L_0x02b5
        r0.f20792k = r8
        r0.f20790i = r8
        r0.f20785d = r10
        com.scwang.smartrefresh.layout.a.i r4 = r0.f20780ax
        com.scwang.smartrefresh.layout.constant.RefreshState r5 = com.scwang.smartrefresh.layout.constant.RefreshState.PullUpToLoad
        r4.mo30929a(r5)
        goto L_0x028f
    L_0x02b5:
        com.scwang.smartrefresh.layout.constant.RefreshState r5 = r0.f20746aA
        boolean r5 = r5.isHeader
        if (r5 == 0) goto L_0x02bd
        if (r4 < 0) goto L_0x02c5
    L_0x02bd:
        com.scwang.smartrefresh.layout.constant.RefreshState r5 = r0.f20746aA
        boolean r5 = r5.isFooter
        if (r5 == 0) goto L_0x02cd
        if (r4 <= 0) goto L_0x02cd
    L_0x02c5:
        int r1 = r0.f20783b
        if (r1 == 0) goto L_0x02cc
        r0.mo30873b(r7)
    L_0x02cc:
        return r11
    L_0x02cd:
        android.view.MotionEvent r5 = r0.f20754aL
        if (r5 == 0) goto L_0x02d9
        r0.f20754aL = r2
        r1.setAction(r3)
        super.dispatchTouchEvent(r1)
    L_0x02d9:
        r1.recycle()
    L_0x02dc:
        float r1 = (float) r4
        r0.mo30873b(r1)
        return r11
    L_0x02e1:
        boolean r2 = r0.f20752aG
        if (r2 == 0) goto L_0x033c
        int r2 = r0.f20745a
        float r2 = (float) r2
        int r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
        if (r2 <= 0) goto L_0x033c
        int r2 = r0.f20783b
        if (r2 >= 0) goto L_0x033c
        r0.f20752aG = r10
        goto L_0x033c
    L_0x02f3:
        android.view.VelocityTracker r3 = r0.f20805x
        r3.addMovement(r1)
        android.view.VelocityTracker r3 = r0.f20805x
        r4 = 1000(0x3e8, float:1.401E-42)
        int r5 = r0.f20802u
        float r5 = (float) r5
        r3.computeCurrentVelocity(r4, r5)
        android.view.VelocityTracker r3 = r0.f20805x
        float r3 = r3.getYVelocity()
        int r3 = (int) r3
        r0.f20803v = r3
        r0.mo30867a(r2)
    L_0x030e:
        android.view.VelocityTracker r3 = r0.f20805x
        r3.clear()
        r3 = 110(0x6e, float:1.54E-43)
        r0.f20794m = r3
        android.view.MotionEvent r3 = r0.f20754aL
        if (r3 == 0) goto L_0x0332
        r3.recycle()
        r0.f20754aL = r2
        long r4 = r23.getEventTime()
        float r7 = r0.f20789h
        r9 = 0
        r2 = r4
        android.view.MotionEvent r2 = android.view.MotionEvent.obtain(r2, r4, r6, r7, r8, r9)
        super.dispatchTouchEvent(r2)
        r2.recycle()
    L_0x0332:
        r22.mo30887e()
        boolean r2 = r0.f20795n
        if (r2 == 0) goto L_0x033c
        r0.f20795n = r10
        return r11
    L_0x033c:
        boolean r1 = super.dispatchTouchEvent(r23)
        return r1
    L_0x0341:
        r0.f20803v = r10
        android.view.VelocityTracker r5 = r0.f20805x
        r5.addMovement(r1)
        android.widget.Scroller r5 = r0.f20804w
        r5.forceFinished(r11)
        r0.f20789h = r9
        r0.f20790i = r8
        r0.f20784c = r10
        int r5 = r0.f20783b
        r0.f20785d = r5
        r0.f20795n = r10
        boolean r5 = super.dispatchTouchEvent(r23)
        r0.f20796o = r5
        com.scwang.smartrefresh.layout.constant.RefreshState r5 = r0.f20782az
        com.scwang.smartrefresh.layout.constant.RefreshState r6 = com.scwang.smartrefresh.layout.constant.RefreshState.TwoLevel
        if (r5 != r6) goto L_0x0378
        float r5 = r0.f20790i
        int r6 = r22.getMeasuredHeight()
        int r6 = r6 * 5
        int r6 = r6 / r2
        float r2 = (float) r6
        int r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
        if (r2 >= 0) goto L_0x0378
        r0.f20794m = r4
        boolean r1 = r0.f20796o
        return r1
    L_0x0378:
        com.scwang.smartrefresh.layout.a.e r2 = r0.f20777au
        if (r2 == 0) goto L_0x037f
        r2.mo30943a(r1)
    L_0x037f:
        return r11
    L_0x0380:
        return r10
    L_0x0381:
        boolean r1 = super.dispatchTouchEvent(r23)
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo30867a(Float f) {
        float floatValue = f == null ? (float) this.f20803v : f.floatValue();
        if (Math.abs(floatValue) > ((float) this.f20801t)) {
            if (((float) this.f20783b) * floatValue < 0.0f) {
                if (!this.f20782az.isOpening) {
                    int i = this.f20783b;
                    if (((float) i) > ((float) this.f20765ai) * this.f20773aq || ((float) (-i)) > ((float) this.f20767ak) * this.f20774ar) {
                        return true;
                    }
                } else if (!(this.f20782az == RefreshState.TwoLevel || this.f20782az == this.f20746aA)) {
                    this.f20755aM = new C6495b(floatValue).mo30923a();
                    return true;
                }
            }
            if ((floatValue < 0.0f && ((this.f20730I && (this.f20731J || mo30868a(this.f20723B))) || ((this.f20782az == RefreshState.Loading && this.f20783b >= 0) || (this.f20732K && mo30868a(this.f20723B))))) || (floatValue > 0.0f && ((this.f20730I && (this.f20731J || mo30868a(this.f20722A))) || (this.f20782az == RefreshState.Refreshing && this.f20783b <= 0)))) {
                this.f20753aK = false;
                this.f20804w.fling(0, 0, 0, (int) (-floatValue), 0, 0, -2147483647, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                this.f20804w.computeScrollOffset();
                invalidate();
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo30866a(int i) {
        boolean z = true;
        if (i == 0) {
            if (this.f20756aN != null) {
                if (this.f20782az.isFinishing || this.f20782az == RefreshState.TwoLevelReleased) {
                    return true;
                }
                if (this.f20782az == RefreshState.PullDownCanceled) {
                    this.f20780ax.mo30929a(RefreshState.PullDownToRefresh);
                } else if (this.f20782az == RefreshState.PullUpCanceled) {
                    this.f20780ax.mo30929a(RefreshState.PullUpToLoad);
                }
                this.f20756aN.cancel();
                this.f20756aN = null;
            }
            this.f20755aM = null;
        }
        if (this.f20756aN == null) {
            z = false;
        }
        return z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo30865a(RefreshState refreshState) {
        RefreshState refreshState2 = this.f20782az;
        if (refreshState2 != refreshState) {
            this.f20782az = refreshState;
            this.f20746aA = refreshState;
            RefreshInternal hVar = this.f20775as;
            RefreshInternal hVar2 = this.f20776at;
            OnMultiPurposeListener cVar = this.f20758ab;
            if (hVar != null) {
                hVar.mo30678a(this, refreshState2, refreshState);
            }
            if (hVar2 != null) {
                hVar2.mo30678a(this, refreshState2, refreshState);
            }
            if (cVar != null) {
                cVar.mo30678a(this, refreshState2, refreshState);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo30863a() {
        if (this.f20782az != RefreshState.Loading) {
            this.f20747aB = System.currentTimeMillis();
            this.f20752aG = true;
            mo30865a(RefreshState.Loading);
            OnLoadMoreListener bVar = this.f20757aa;
            if (bVar != null) {
                bVar.mo30958a(this);
            } else if (this.f20758ab == null) {
                mo30875c(2000);
            }
            RefreshInternal hVar = this.f20776at;
            if (hVar != null) {
                int i = this.f20767ak;
                hVar.mo30679b(this, i, (int) (this.f20772ap * ((float) i)));
            }
            OnMultiPurposeListener cVar = this.f20758ab;
            if (cVar != null && (this.f20776at instanceof RefreshFooter)) {
                cVar.mo30958a(this);
                OnMultiPurposeListener cVar2 = this.f20758ab;
                RefreshFooter fVar = (RefreshFooter) this.f20776at;
                int i2 = this.f20767ak;
                cVar2.mo30965b(fVar, i2, (int) (this.f20772ap * ((float) i2)));
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo30872b() {
        C64863 r0 = new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                SmartRefreshLayout.this.mo30863a();
            }
        };
        mo30865a(RefreshState.LoadReleased);
        ValueAnimator a = this.f20780ax.mo30925a(-this.f20767ak);
        if (a != null) {
            a.addListener(r0);
        }
        RefreshInternal hVar = this.f20776at;
        if (hVar != null) {
            int i = this.f20767ak;
            hVar.mo30671a((RefreshLayout) this, i, (int) (this.f20772ap * ((float) i)));
        }
        OnMultiPurposeListener cVar = this.f20758ab;
        if (cVar != null) {
            RefreshInternal hVar2 = this.f20776at;
            if (hVar2 instanceof RefreshFooter) {
                RefreshFooter fVar = (RefreshFooter) hVar2;
                int i2 = this.f20767ak;
                cVar.mo30959a(fVar, i2, (int) (this.f20772ap * ((float) i2)));
            }
        }
        if (a == null) {
            r0.onAnimationEnd(null);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo30877c() {
        C64874 r0 = new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                SmartRefreshLayout.this.f20747aB = System.currentTimeMillis();
                SmartRefreshLayout.this.mo30865a(RefreshState.Refreshing);
                if (SmartRefreshLayout.this.f20744W != null) {
                    SmartRefreshLayout.this.f20744W.mo20372a_(SmartRefreshLayout.this);
                } else if (SmartRefreshLayout.this.f20758ab == null) {
                    SmartRefreshLayout.this.mo30882d((int) PathInterpolatorCompat.MAX_NUM_POINTS);
                }
                if (SmartRefreshLayout.this.f20775as != null) {
                    RefreshInternal hVar = SmartRefreshLayout.this.f20775as;
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    hVar.mo30679b(smartRefreshLayout, smartRefreshLayout.f20765ai, (int) (SmartRefreshLayout.this.f20771ao * ((float) SmartRefreshLayout.this.f20765ai)));
                }
                if (SmartRefreshLayout.this.f20758ab != null && (SmartRefreshLayout.this.f20775as instanceof RefreshHeader)) {
                    SmartRefreshLayout.this.f20758ab.mo20372a_(SmartRefreshLayout.this);
                    SmartRefreshLayout.this.f20758ab.mo30966b((RefreshHeader) SmartRefreshLayout.this.f20775as, SmartRefreshLayout.this.f20765ai, (int) (SmartRefreshLayout.this.f20771ao * ((float) SmartRefreshLayout.this.f20765ai)));
                }
            }
        };
        mo30865a(RefreshState.RefreshReleased);
        ValueAnimator a = this.f20780ax.mo30925a(this.f20765ai);
        if (a != null) {
            a.addListener(r0);
        }
        RefreshInternal hVar = this.f20775as;
        if (hVar != null) {
            int i = this.f20765ai;
            hVar.mo30671a((RefreshLayout) this, i, (int) (this.f20771ao * ((float) i)));
        }
        OnMultiPurposeListener cVar = this.f20758ab;
        if (cVar != null) {
            RefreshInternal hVar2 = this.f20775as;
            if (hVar2 instanceof RefreshHeader) {
                RefreshHeader gVar = (RefreshHeader) hVar2;
                int i2 = this.f20765ai;
                cVar.mo30962a(gVar, i2, (int) (this.f20771ao * ((float) i2)));
            }
        }
        if (a == null) {
            r0.onAnimationEnd(null);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo30883d() {
        if (this.f20782az != RefreshState.None && this.f20783b == 0) {
            mo30865a(RefreshState.None);
        }
        if (this.f20783b != 0) {
            this.f20780ax.mo30925a(0);
        }
    }

    /* access modifiers changed from: protected */
    public void setViceState(RefreshState refreshState) {
        if (this.f20782az.isDragging && this.f20782az.isHeader != refreshState.isHeader) {
            mo30865a(RefreshState.None);
        }
        if (this.f20746aA != refreshState) {
            this.f20746aA = refreshState;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo30869a(boolean z, RefreshInternal hVar) {
        return z || this.f20733L || hVar == null || hVar.getSpinnerStyle() == SpinnerStyle.FixedBehind;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo30868a(boolean z) {
        return z && !this.f20733L;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public ValueAnimator mo30853a(int i, int i2, Interpolator interpolator, int i3) {
        if (this.f20783b == i) {
            return null;
        }
        ValueAnimator valueAnimator = this.f20756aN;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.f20755aM = null;
        this.f20756aN = ValueAnimator.ofInt(new int[]{this.f20783b, i});
        this.f20756aN.setDuration((long) i3);
        this.f20756aN.setInterpolator(interpolator);
        this.f20756aN.addListener(new AnimatorListenerAdapter() {
            public void onAnimationCancel(Animator animator) {
                super.onAnimationEnd(animator);
            }

            public void onAnimationEnd(Animator animator) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                smartRefreshLayout.f20756aN = null;
                if (smartRefreshLayout.f20783b == 0) {
                    if (SmartRefreshLayout.this.f20782az != RefreshState.None && !SmartRefreshLayout.this.f20782az.isOpening) {
                        SmartRefreshLayout.this.mo30865a(RefreshState.None);
                    }
                } else if (SmartRefreshLayout.this.f20782az != SmartRefreshLayout.this.f20746aA) {
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    smartRefreshLayout2.setViceState(smartRefreshLayout2.f20782az);
                }
            }
        });
        this.f20756aN.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SmartRefreshLayout.this.f20780ax.mo30926a(((Integer) valueAnimator.getAnimatedValue()).intValue(), false);
            }
        });
        this.f20756aN.setStartDelay((long) i2);
        this.f20756aN.start();
        return this.f20756aN;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo30864a(float f) {
        if (this.f20756aN != null) {
            return;
        }
        if (f > 0.0f && (this.f20782az == RefreshState.Refreshing || this.f20782az == RefreshState.TwoLevel)) {
            this.f20755aM = new C6494a(f, this.f20765ai);
        } else if (f < 0.0f && (this.f20782az == RefreshState.Loading || ((this.f20728G && this.f20739R && mo30868a(this.f20723B)) || (this.f20732K && !this.f20739R && mo30868a(this.f20723B) && this.f20782az != RefreshState.Refreshing)))) {
            this.f20755aM = new C6494a(f, -this.f20767ak);
        } else if (this.f20783b == 0 && this.f20730I) {
            this.f20755aM = new C6494a(f, 0);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo30887e() {
        if (this.f20782az == RefreshState.TwoLevel) {
            if (this.f20803v > -1000 && this.f20783b > getMeasuredHeight() / 2) {
                ValueAnimator a = this.f20780ax.mo30925a(getMeasuredHeight());
                if (a != null) {
                    a.setDuration((long) this.f20786e);
                }
            } else if (this.f20795n) {
                this.f20780ax.mo30935c();
            }
        } else if (this.f20782az == RefreshState.Loading || (this.f20728G && this.f20739R && this.f20783b < 0 && mo30868a(this.f20723B))) {
            int i = this.f20783b;
            int i2 = this.f20767ak;
            if (i < (-i2)) {
                this.f20780ax.mo30925a(-i2);
            } else if (i > 0) {
                this.f20780ax.mo30925a(0);
            }
        } else if (this.f20782az == RefreshState.Refreshing) {
            int i3 = this.f20783b;
            int i4 = this.f20765ai;
            if (i3 > i4) {
                this.f20780ax.mo30925a(i4);
            } else if (i3 < 0) {
                this.f20780ax.mo30925a(0);
            }
        } else if (this.f20782az == RefreshState.PullDownToRefresh) {
            this.f20780ax.mo30929a(RefreshState.PullDownCanceled);
        } else if (this.f20782az == RefreshState.PullUpToLoad) {
            this.f20780ax.mo30929a(RefreshState.PullUpCanceled);
        } else if (this.f20782az == RefreshState.ReleaseToRefresh) {
            this.f20780ax.mo30929a(RefreshState.Refreshing);
        } else if (this.f20782az == RefreshState.ReleaseToLoad) {
            this.f20780ax.mo30929a(RefreshState.Loading);
        } else if (this.f20782az == RefreshState.ReleaseToTwoLevel) {
            this.f20780ax.mo30929a(RefreshState.TwoLevelReleased);
        } else if (this.f20782az == RefreshState.RefreshReleased) {
            if (this.f20756aN == null) {
                this.f20780ax.mo30925a(this.f20765ai);
            }
        } else if (this.f20782az == RefreshState.LoadReleased) {
            if (this.f20756aN == null) {
                this.f20780ax.mo30925a(-this.f20767ak);
            }
        } else if (this.f20783b != 0) {
            this.f20780ax.mo30925a(0);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo30873b(float f) {
        float f2 = f;
        if (this.f20782az == RefreshState.TwoLevel && f2 > 0.0f) {
            this.f20780ax.mo30926a(Math.min((int) f2, getMeasuredHeight()), true);
        } else if (this.f20782az == RefreshState.Refreshing && f2 >= 0.0f) {
            int i = this.f20765ai;
            if (f2 < ((float) i)) {
                this.f20780ax.mo30926a((int) f2, true);
            } else {
                double d = (double) ((this.f20771ao - 1.0f) * ((float) i));
                int max = Math.max((this.f20788g * 4) / 3, getHeight());
                int i2 = this.f20765ai;
                double d2 = (double) (max - i2);
                double max2 = (double) Math.max(0.0f, (f2 - ((float) i2)) * this.f20793l);
                double d3 = -max2;
                if (d2 == 0.0d) {
                    d2 = 1.0d;
                }
                this.f20780ax.mo30926a(((int) Math.min(d * (1.0d - Math.pow(100.0d, d3 / d2)), max2)) + this.f20765ai, true);
            }
        } else if (f2 < 0.0f && (this.f20782az == RefreshState.Loading || ((this.f20728G && this.f20739R && mo30868a(this.f20723B)) || (this.f20732K && !this.f20739R && mo30868a(this.f20723B))))) {
            int i3 = this.f20767ak;
            if (f2 > ((float) (-i3))) {
                this.f20780ax.mo30926a((int) f2, true);
            } else {
                double d4 = (double) ((this.f20772ap - 1.0f) * ((float) i3));
                int max3 = Math.max((this.f20788g * 4) / 3, getHeight());
                int i4 = this.f20767ak;
                double d5 = (double) (max3 - i4);
                double d6 = (double) (-Math.min(0.0f, (((float) i4) + f2) * this.f20793l));
                double d7 = -d6;
                if (d5 == 0.0d) {
                    d5 = 1.0d;
                }
                this.f20780ax.mo30926a(((int) (-Math.min(d4 * (1.0d - Math.pow(100.0d, d7 / d5)), d6))) - this.f20767ak, true);
            }
        } else if (f2 >= 0.0f) {
            double d8 = (double) (this.f20771ao * ((float) this.f20765ai));
            double max4 = (double) Math.max(this.f20788g / 2, getHeight());
            double max5 = (double) Math.max(0.0f, this.f20793l * f2);
            double d9 = -max5;
            if (max4 == 0.0d) {
                max4 = 1.0d;
            }
            this.f20780ax.mo30926a((int) Math.min(d8 * (1.0d - Math.pow(100.0d, d9 / max4)), max5), true);
        } else {
            double d10 = (double) (this.f20772ap * ((float) this.f20767ak));
            double max6 = (double) Math.max(this.f20788g / 2, getHeight());
            double d11 = (double) (-Math.min(0.0f, this.f20793l * f2));
            double d12 = -d11;
            if (max6 == 0.0d) {
                max6 = 1.0d;
            }
            this.f20780ax.mo30926a((int) (-Math.min(d10 * (1.0d - Math.pow(100.0d, d12 / max6)), d11)), true);
        }
        if (this.f20732K && !this.f20739R && mo30868a(this.f20723B) && f2 < 0.0f && this.f20782az != RefreshState.Refreshing && this.f20782az != RefreshState.Loading && this.f20782az != RefreshState.LoadFinish) {
            mo30863a();
            if (this.f20738Q) {
                this.f20755aM = null;
                this.f20780ax.mo30925a(-this.f20767ak);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof C6496c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public C6496c generateDefaultLayoutParams() {
        return new C6496c(-1, -1);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C6496c generateLayoutParams(LayoutParams layoutParams) {
        return new C6496c(layoutParams);
    }

    /* renamed from: a */
    public C6496c generateLayoutParams(AttributeSet attributeSet) {
        return new C6496c(getContext(), attributeSet);
    }

    public int getNestedScrollAxes() {
        return this.f20764ah.getNestedScrollAxes();
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        boolean z = isEnabled() && isNestedScrollingEnabled() && (i & 2) != 0;
        if (!z || (!this.f20731J && !mo30868a(this.f20722A) && !mo30868a(this.f20723B))) {
            return false;
        }
        return true;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f20764ah.onNestedScrollAccepted(view, view2, i);
        this.f20763ag.startNestedScroll(i & 2);
        this.f20760ad = this.f20783b;
        this.f20761ae = true;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        int i3;
        int i4 = this.f20760ad;
        if (i2 * i4 > 0) {
            if (Math.abs(i2) > Math.abs(this.f20760ad)) {
                i3 = this.f20760ad;
                this.f20760ad = 0;
            } else {
                this.f20760ad -= i2;
                i3 = i2;
            }
            mo30873b((float) this.f20760ad);
            if (this.f20746aA.isOpening || this.f20746aA == RefreshState.None) {
                if (this.f20783b > 0) {
                    this.f20780ax.mo30929a(RefreshState.PullDownToRefresh);
                } else {
                    this.f20780ax.mo30929a(RefreshState.PullUpToLoad);
                }
            }
        } else if (i2 <= 0 || !this.f20752aG) {
            i3 = 0;
        } else {
            this.f20760ad = i4 - i2;
            mo30873b((float) this.f20760ad);
            i3 = i2;
        }
        this.f20763ag.dispatchNestedPreScroll(i, i2 - i3, iArr, null);
        iArr[1] = iArr[1] + i3;
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.f20763ag.dispatchNestedScroll(i, i2, i3, i4, this.f20762af);
        int i5 = i4 + this.f20762af[1];
        if (i5 == 0) {
            return;
        }
        if (this.f20731J || ((i5 < 0 && mo30868a(this.f20722A)) || (i5 > 0 && mo30868a(this.f20723B)))) {
            if (this.f20746aA == RefreshState.None) {
                this.f20780ax.mo30929a(i5 > 0 ? RefreshState.PullUpToLoad : RefreshState.PullDownToRefresh);
            }
            int i6 = this.f20760ad - i5;
            this.f20760ad = i6;
            mo30873b((float) i6);
        }
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return (this.f20752aG && f2 > 0.0f) || mo30867a(Float.valueOf(-f2)) || this.f20763ag.dispatchNestedPreFling(f, f2);
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return this.f20763ag.dispatchNestedFling(f, f2, z);
    }

    public void onStopNestedScroll(View view) {
        this.f20764ah.onStopNestedScroll(view);
        this.f20761ae = false;
        this.f20760ad = 0;
        mo30887e();
        this.f20763ag.stopNestedScroll();
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f20741T = true;
        this.f20763ag.setNestedScrollingEnabled(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.f20763ag.isNestedScrollingEnabled();
    }

    /* renamed from: c */
    public SmartRefreshLayout mo30881d(float f) {
        this.f20771ao = f;
        RefreshInternal hVar = this.f20775as;
        if (hVar == null || this.f20779aw == null) {
            this.f20766aj = this.f20766aj.unNotify();
        } else {
            RefreshKernel iVar = this.f20780ax;
            int i = this.f20765ai;
            hVar.mo30677a(iVar, i, (int) (this.f20771ao * ((float) i)));
        }
        return this;
    }

    /* renamed from: b */
    public SmartRefreshLayout mo30900i(boolean z) {
        this.f20722A = z;
        return this;
    }

    /* renamed from: c */
    public SmartRefreshLayout mo30899h(boolean z) {
        this.f20732K = z;
        return this;
    }

    /* renamed from: d */
    public SmartRefreshLayout mo30891g(boolean z) {
        this.f20731J = z;
        return this;
    }

    /* renamed from: e */
    public RefreshLayout mo30886e(boolean z) {
        setNestedScrollingEnabled(z);
        return this;
    }

    /* renamed from: a */
    public SmartRefreshLayout mo30860a(RefreshHeader gVar) {
        return mo30861a(gVar, -1, -2);
    }

    /* renamed from: a */
    public SmartRefreshLayout mo30861a(RefreshHeader gVar, int i, int i2) {
        RefreshInternal hVar = this.f20775as;
        if (hVar != null) {
            super.removeView(hVar.getView());
        }
        this.f20775as = gVar;
        this.f20748aC = 0;
        this.f20750aE = false;
        this.f20766aj = this.f20766aj.unNotify();
        if (gVar.getSpinnerStyle() == SpinnerStyle.FixedBehind) {
            super.addView(this.f20775as.getView(), 0, new C6496c(i, i2));
        } else {
            super.addView(this.f20775as.getView(), i, i2);
        }
        return this;
    }

    /* renamed from: a */
    public SmartRefreshLayout mo30858a(RefreshFooter fVar) {
        return mo30859a(fVar, -1, -2);
    }

    /* renamed from: a */
    public SmartRefreshLayout mo30859a(RefreshFooter fVar, int i, int i2) {
        RefreshInternal hVar = this.f20776at;
        if (hVar != null) {
            super.removeView(hVar.getView());
        }
        this.f20776at = fVar;
        this.f20749aD = 0;
        this.f20751aF = false;
        this.f20768al = this.f20768al.unNotify();
        boolean z = !this.f20740S || this.f20723B;
        this.f20723B = z;
        if (this.f20776at.getSpinnerStyle() == SpinnerStyle.FixedBehind) {
            super.addView(this.f20776at.getView(), 0, new C6496c(i, i2));
        } else {
            super.addView(this.f20776at.getView(), i, i2);
        }
        return this;
    }

    public RefreshFooter getRefreshFooter() {
        RefreshInternal hVar = this.f20776at;
        if (hVar instanceof RefreshFooter) {
            return (RefreshFooter) hVar;
        }
        return null;
    }

    public RefreshHeader getRefreshHeader() {
        RefreshInternal hVar = this.f20775as;
        if (hVar instanceof RefreshHeader) {
            return (RefreshHeader) hVar;
        }
        return null;
    }

    public RefreshState getState() {
        return this.f20782az;
    }

    /* renamed from: a */
    public SmartRefreshLayout mo30862a(OnRefreshListener dVar) {
        this.f20744W = dVar;
        return this;
    }

    /* renamed from: f */
    public SmartRefreshLayout mo30889f(boolean z) {
        this.f20739R = z;
        RefreshInternal hVar = this.f20776at;
        if ((hVar instanceof RefreshFooter) && !((RefreshFooter) hVar).mo30950a(z)) {
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append("Footer:");
            sb.append(this.f20776at);
            sb.append(" NoMoreData is not supported.(不支持NoMoreData)");
            printStream.println(sb.toString());
        }
        return this;
    }

    /* renamed from: g */
    public SmartRefreshLayout mo30890g() {
        return mo30882d(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.f20747aB))), 300));
    }

    /* renamed from: b */
    public SmartRefreshLayout mo30882d(int i) {
        return mo30856a(i, true);
    }

    /* renamed from: a */
    public SmartRefreshLayout mo30856a(int i, final boolean z) {
        if (this.f20782az == RefreshState.Refreshing && z) {
            mo30889f(false);
        }
        postDelayed(new Runnable() {
            public void run() {
                if (SmartRefreshLayout.this.f20782az == RefreshState.Refreshing && SmartRefreshLayout.this.f20775as != null && SmartRefreshLayout.this.f20777au != null) {
                    SmartRefreshLayout.this.mo30865a(RefreshState.RefreshFinish);
                    int a = SmartRefreshLayout.this.f20775as.mo30670a(SmartRefreshLayout.this, z);
                    if (SmartRefreshLayout.this.f20758ab != null && (SmartRefreshLayout.this.f20775as instanceof RefreshHeader)) {
                        SmartRefreshLayout.this.f20758ab.mo30963a((RefreshHeader) SmartRefreshLayout.this.f20775as, z);
                    }
                    if (a < Integer.MAX_VALUE) {
                        if (SmartRefreshLayout.this.f20795n || SmartRefreshLayout.this.f20761ae) {
                            if (SmartRefreshLayout.this.f20795n) {
                                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                                smartRefreshLayout.f20790i = smartRefreshLayout.f20792k;
                                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                                smartRefreshLayout2.f20785d = 0;
                                smartRefreshLayout2.f20795n = false;
                            }
                            long currentTimeMillis = System.currentTimeMillis();
                            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                            long j = currentTimeMillis;
                            SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, j, 0, smartRefreshLayout3.f20791j, (SmartRefreshLayout.this.f20792k + ((float) SmartRefreshLayout.this.f20783b)) - ((float) (SmartRefreshLayout.this.f20745a * 2)), 0));
                            SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                            SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, j, 2, smartRefreshLayout4.f20791j, SmartRefreshLayout.this.f20792k + ((float) SmartRefreshLayout.this.f20783b), 0));
                            if (SmartRefreshLayout.this.f20761ae) {
                                SmartRefreshLayout.this.f20760ad = 0;
                            }
                        }
                        if (SmartRefreshLayout.this.f20783b > 0) {
                            AnimatorUpdateListener animatorUpdateListener = null;
                            SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                            ValueAnimator a2 = smartRefreshLayout5.mo30853a(0, a, smartRefreshLayout5.f20806y, SmartRefreshLayout.this.f20787f);
                            if (SmartRefreshLayout.this.f20735N) {
                                animatorUpdateListener = SmartRefreshLayout.this.f20777au.mo30940a(SmartRefreshLayout.this.f20783b);
                            }
                            if (a2 != null && animatorUpdateListener != null) {
                                a2.addUpdateListener(animatorUpdateListener);
                            }
                        } else if (SmartRefreshLayout.this.f20783b < 0) {
                            SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                            smartRefreshLayout6.mo30853a(0, a, smartRefreshLayout6.f20806y, SmartRefreshLayout.this.f20787f);
                        } else {
                            SmartRefreshLayout.this.f20780ax.mo30926a(0, false);
                            SmartRefreshLayout.this.mo30883d();
                        }
                    }
                }
            }
        }, i <= 0 ? 1 : (long) i);
        return this;
    }

    /* renamed from: c */
    public SmartRefreshLayout mo30875c(int i) {
        return mo30857a(i, true, false);
    }

    /* renamed from: a */
    public SmartRefreshLayout mo30857a(int i, final boolean z, final boolean z2) {
        postDelayed(new Runnable() {
            public void run() {
                boolean z = true;
                if (SmartRefreshLayout.this.f20782az == RefreshState.Loading && SmartRefreshLayout.this.f20776at != null && SmartRefreshLayout.this.f20777au != null) {
                    SmartRefreshLayout.this.mo30865a(RefreshState.LoadFinish);
                    int a = SmartRefreshLayout.this.f20776at.mo30670a(SmartRefreshLayout.this, z);
                    if (SmartRefreshLayout.this.f20758ab != null && (SmartRefreshLayout.this.f20776at instanceof RefreshFooter)) {
                        SmartRefreshLayout.this.f20758ab.mo30960a((RefreshFooter) SmartRefreshLayout.this.f20776at, z);
                    }
                    if (a < Integer.MAX_VALUE) {
                        if (!z2 || !SmartRefreshLayout.this.f20728G || SmartRefreshLayout.this.f20783b >= 0 || !SmartRefreshLayout.this.f20777au.mo30949d()) {
                            z = false;
                        }
                        final int max = SmartRefreshLayout.this.f20783b - (z ? Math.max(SmartRefreshLayout.this.f20783b, -SmartRefreshLayout.this.f20767ak) : 0);
                        if (SmartRefreshLayout.this.f20795n || SmartRefreshLayout.this.f20761ae) {
                            if (SmartRefreshLayout.this.f20795n) {
                                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                                smartRefreshLayout.f20790i = smartRefreshLayout.f20792k;
                                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                                smartRefreshLayout2.f20795n = false;
                                smartRefreshLayout2.f20785d = smartRefreshLayout2.f20783b - max;
                            }
                            long currentTimeMillis = System.currentTimeMillis();
                            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                            float f = (float) max;
                            long j = currentTimeMillis;
                            long j2 = currentTimeMillis;
                            float f2 = f;
                            SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(j, j2, 0, smartRefreshLayout3.f20791j, SmartRefreshLayout.this.f20792k + f + ((float) (SmartRefreshLayout.this.f20745a * 2)), 0));
                            SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                            SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(j, j2, 2, smartRefreshLayout4.f20791j, SmartRefreshLayout.this.f20792k + f2, 0));
                            if (SmartRefreshLayout.this.f20761ae) {
                                SmartRefreshLayout.this.f20760ad = 0;
                            }
                        }
                        SmartRefreshLayout.this.postDelayed(new Runnable() {
                            public void run() {
                                ValueAnimator valueAnimator;
                                AnimatorUpdateListener a = (!SmartRefreshLayout.this.f20734M || max >= 0) ? null : SmartRefreshLayout.this.f20777au.mo30940a(SmartRefreshLayout.this.f20783b);
                                if (a != null) {
                                    a.onAnimationUpdate(ValueAnimator.ofInt(new int[]{0, 0}));
                                }
                                C64931 r2 = new AnimatorListenerAdapter() {
                                    public void onAnimationCancel(Animator animator) {
                                        super.onAnimationEnd(animator);
                                    }

                                    public void onAnimationEnd(Animator animator) {
                                        SmartRefreshLayout.this.f20752aG = false;
                                        if (z2) {
                                            SmartRefreshLayout.this.mo30889f(true);
                                        }
                                        if (SmartRefreshLayout.this.f20782az == RefreshState.LoadFinish) {
                                            SmartRefreshLayout.this.mo30865a(RefreshState.None);
                                        }
                                    }
                                };
                                if (SmartRefreshLayout.this.f20783b > 0) {
                                    valueAnimator = SmartRefreshLayout.this.f20780ax.mo30925a(0);
                                } else {
                                    if (a != null || SmartRefreshLayout.this.f20783b == 0) {
                                        if (SmartRefreshLayout.this.f20756aN != null) {
                                            SmartRefreshLayout.this.f20756aN.cancel();
                                            SmartRefreshLayout.this.f20756aN = null;
                                        }
                                        SmartRefreshLayout.this.f20780ax.mo30926a(0, false);
                                        SmartRefreshLayout.this.mo30883d();
                                    } else if (!z2 || !SmartRefreshLayout.this.f20728G) {
                                        valueAnimator = SmartRefreshLayout.this.f20780ax.mo30925a(0);
                                    } else if (SmartRefreshLayout.this.f20783b >= (-SmartRefreshLayout.this.f20767ak)) {
                                        SmartRefreshLayout.this.mo30865a(RefreshState.None);
                                    } else {
                                        valueAnimator = SmartRefreshLayout.this.f20780ax.mo30925a(-SmartRefreshLayout.this.f20767ak);
                                    }
                                    valueAnimator = null;
                                }
                                if (valueAnimator != null) {
                                    valueAnimator.addListener(r2);
                                } else {
                                    r2.onAnimationEnd(null);
                                }
                            }
                        }, SmartRefreshLayout.this.f20783b < 0 ? (long) a : 0);
                    }
                } else if (z2) {
                    SmartRefreshLayout.this.mo30889f(true);
                }
            }
        }, i <= 0 ? 1 : (long) i);
        return this;
    }

    public static void setDefaultRefreshHeaderCreator(DefaultRefreshHeaderCreator bVar) {
        f20720aI = bVar;
    }

    public static void setDefaultRefreshFooterCreator(DefaultRefreshFooterCreator aVar) {
        f20719aH = aVar;
    }

    public static void setDefaultRefreshInitializer(DefaultRefreshInitializer cVar) {
        f20721aJ = cVar;
    }

    public boolean post(Runnable runnable) {
        Handler handler = this.f20779aw;
        if (handler != null) {
            return handler.post(new DelayedRunnable(runnable, 0));
        }
        List<DelayedRunnable> list = this.f20781ay;
        if (list == null) {
            list = new ArrayList<>();
        }
        this.f20781ay = list;
        this.f20781ay.add(new DelayedRunnable(runnable, 0));
        return false;
    }

    public boolean postDelayed(Runnable runnable, long j) {
        if (j == 0) {
            new DelayedRunnable(runnable, 0).run();
            return true;
        }
        Handler handler = this.f20779aw;
        if (handler != null) {
            return handler.postDelayed(new DelayedRunnable(runnable, 0), j);
        }
        List<DelayedRunnable> list = this.f20781ay;
        if (list == null) {
            list = new ArrayList<>();
        }
        this.f20781ay = list;
        this.f20781ay.add(new DelayedRunnable(runnable, j));
        return false;
    }
}
