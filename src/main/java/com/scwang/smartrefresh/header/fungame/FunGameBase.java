package com.scwang.smartrefresh.header.fungame;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.scwang.smartrefresh.layout.p527a.RefreshContent;
import com.scwang.smartrefresh.layout.p527a.RefreshHeader;
import com.scwang.smartrefresh.layout.p527a.RefreshInternal;
import com.scwang.smartrefresh.layout.p527a.RefreshKernel;
import com.scwang.smartrefresh.layout.p527a.RefreshLayout;
import com.scwang.smartrefresh.layout.p529c.DensityUtil;

public abstract class FunGameBase extends InternalAbstract implements RefreshHeader {
    /* renamed from: A */
    protected RefreshContent f20581A;
    /* renamed from: r */
    protected int f20582r;
    /* renamed from: s */
    protected int f20583s;
    /* renamed from: t */
    protected int f20584t;
    /* renamed from: u */
    protected float f20585u;
    /* renamed from: v */
    protected boolean f20586v;
    /* renamed from: w */
    protected boolean f20587w;
    /* renamed from: x */
    protected boolean f20588x;
    /* renamed from: y */
    protected RefreshState f20589y;
    /* renamed from: z */
    protected RefreshKernel f20590z;

    /* renamed from: a */
    public abstract void mo30757a(float f, int i, int i2, int i3);

    public FunGameBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setMinimumHeight(DensityUtil.m25572a(100.0f));
        this.f20584t = getResources().getDisplayMetrics().heightPixels;
        this.f20937ab = SpinnerStyle.MatchLayout;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f20589y == RefreshState.Refreshing || super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002b, code lost:
            if (r1 != 3) goto L_0x0090;
     */
    public boolean onTouchEvent(android.view.MotionEvent r17) {
        /*
        r16 = this;
        r0 = r16
        com.scwang.smartrefresh.layout.constant.RefreshState r1 = r0.f20589y
        com.scwang.smartrefresh.layout.constant.RefreshState r2 = com.scwang.smartrefresh.layout.constant.RefreshState.Refreshing
        if (r1 == r2) goto L_0x0014
        com.scwang.smartrefresh.layout.constant.RefreshState r1 = r0.f20589y
        com.scwang.smartrefresh.layout.constant.RefreshState r2 = com.scwang.smartrefresh.layout.constant.RefreshState.RefreshFinish
        if (r1 != r2) goto L_0x000f
        goto L_0x0014
    L_0x000f:
        boolean r1 = super.onTouchEvent(r17)
        return r1
    L_0x0014:
        boolean r1 = r0.f20588x
        if (r1 != 0) goto L_0x001b
        r16.mo30758d()
    L_0x001b:
        int r1 = r17.getAction()
        r1 = r1 & 255(0xff, float:3.57E-43)
        r2 = 0
        r3 = 1
        if (r1 == 0) goto L_0x0085
        if (r1 == r3) goto L_0x0072
        r4 = 3
        r5 = 2
        if (r1 == r5) goto L_0x002e
        if (r1 == r4) goto L_0x0072
        goto L_0x0090
    L_0x002e:
        float r1 = r17.getRawY()
        float r6 = r0.f20585u
        float r1 = r1 - r6
        r6 = 0
        int r6 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
        if (r6 < 0) goto L_0x006c
        int r6 = r0.f20583s
        int r6 = r6 * 2
        double r6 = (double) r6
        int r8 = r0.f20584t
        int r8 = r8 * 2
        int r8 = r8 / r4
        double r4 = (double) r8
        r8 = 0
        double r10 = (double) r1
        r12 = 4602678819172646912(0x3fe0000000000000, double:0.5)
        double r10 = r10 * r12
        double r8 = java.lang.Math.max(r8, r10)
        r10 = 4607182418800017408(0x3ff0000000000000, double:1.0)
        r12 = 4636737291354636288(0x4059000000000000, double:100.0)
        double r14 = -r8
        double r14 = r14 / r4
        double r4 = java.lang.Math.pow(r12, r14)
        double r10 = r10 - r4
        double r6 = r6 * r10
        double r4 = java.lang.Math.min(r6, r8)
        com.scwang.smartrefresh.layout.a.i r1 = r0.f20590z
        int r4 = (int) r4
        int r4 = java.lang.Math.max(r3, r4)
        r1.mo30926a(r4, r2)
        goto L_0x0090
    L_0x006c:
        com.scwang.smartrefresh.layout.a.i r1 = r0.f20590z
        r1.mo30926a(r3, r2)
        goto L_0x0090
    L_0x0072:
        r16.mo30759e()
        r1 = -1082130432(0xffffffffbf800000, float:-1.0)
        r0.f20585u = r1
        boolean r1 = r0.f20586v
        if (r1 == 0) goto L_0x0090
        com.scwang.smartrefresh.layout.a.i r1 = r0.f20590z
        int r2 = r0.f20583s
        r1.mo30926a(r2, r3)
        goto L_0x0090
    L_0x0085:
        float r1 = r17.getRawY()
        r0.f20585u = r1
        com.scwang.smartrefresh.layout.a.i r1 = r0.f20590z
        r1.mo30926a(r2, r3)
    L_0x0090:
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.header.fungame.FunGameBase.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo30758d() {
        if (!this.f20588x) {
            this.f20588x = true;
            this.f20581A = this.f20590z.mo30932b();
            View a = this.f20581A.mo30941a();
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) a.getLayoutParams();
            marginLayoutParams.topMargin += this.f20583s;
            a.setLayoutParams(marginLayoutParams);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo30759e() {
        if (this.f20586v) {
            this.f20588x = false;
            if (this.f20585u != -1.0f) {
                mo30670a(this.f20590z.mo30931a(), this.f20587w);
                this.f20590z.mo30929a(RefreshState.RefreshFinish);
                this.f20590z.mo30925a(0);
            } else {
                this.f20590z.mo30926a(this.f20583s, true);
            }
            View a = this.f20581A.mo30941a();
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) a.getLayoutParams();
            marginLayoutParams.topMargin -= this.f20583s;
            a.setLayoutParams(marginLayoutParams);
            return;
        }
        this.f20590z.mo30926a(0, true);
    }

    /* renamed from: a */
    public void mo30672a(boolean z, float f, int i, int i2, int i3) {
        if (this.f20588x) {
            mo30757a(f, i, i2, i3);
            return;
        }
        this.f20582r = i;
        setTranslationY((float) (this.f20582r - this.f20583s));
    }

    /* renamed from: b */
    public void mo30679b(RefreshLayout jVar, int i, int i2) {
        this.f20586v = false;
        setTranslationY(0.0f);
    }

    /* renamed from: a */
    public void mo30678a(RefreshLayout jVar, RefreshState refreshState, RefreshState refreshState2) {
        this.f20589y = refreshState2;
    }

    /* renamed from: a */
    public void mo30677a(RefreshKernel iVar, int i, int i2) {
        this.f20590z = iVar;
        this.f20583s = i;
        if (!isInEditMode()) {
            setTranslationY((float) (this.f20582r - this.f20583s));
            iVar.mo30928a((RefreshInternal) this, true);
        }
    }

    /* renamed from: a */
    public int mo30670a(RefreshLayout jVar, boolean z) {
        this.f20587w = z;
        if (!this.f20586v) {
            this.f20586v = true;
            if (this.f20588x) {
                if (this.f20585u != -1.0f) {
                    return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                }
                mo30759e();
                mo30670a(jVar, z);
                return 0;
            }
        }
        return 0;
    }
}
