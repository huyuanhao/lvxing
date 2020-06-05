package com.kwad.sdk.contentalliance.refreshview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.kwad.sdk.core.p319c.C4065b;
import java.util.List;

public abstract class RefreshLayout extends ViewGroup implements NestedScrollingChild, NestedScrollingParent {
    /* renamed from: A */
    private float f13529A;
    /* renamed from: B */
    private float f13530B;
    /* renamed from: C */
    private float f13531C;
    /* access modifiers changed from: private */
    /* renamed from: D */
    public float f13532D;
    /* renamed from: E */
    private float f13533E;
    /* renamed from: F */
    private float f13534F;
    /* renamed from: G */
    private View f13535G;
    /* renamed from: H */
    private boolean f13536H;
    /* renamed from: I */
    private boolean f13537I;
    /* renamed from: J */
    private boolean f13538J;
    /* access modifiers changed from: private */
    /* renamed from: K */
    public RefreshStyle f13539K;
    /* access modifiers changed from: private */
    /* renamed from: L */
    public View f13540L;
    /* renamed from: M */
    private ValueAnimator f13541M;
    /* renamed from: N */
    private C4050b f13542N;
    /* access modifiers changed from: private */
    /* renamed from: O */
    public C4042b f13543O;
    /* renamed from: P */
    private final AnimationListener f13544P;
    /* renamed from: Q */
    private C4044d f13545Q;
    /* access modifiers changed from: private */
    /* renamed from: R */
    public C4043c f13546R;
    /* access modifiers changed from: private */
    /* renamed from: S */
    public List<C4043c> f13547S;
    /* renamed from: T */
    private Interpolator f13548T;
    /* renamed from: U */
    private Interpolator f13549U;
    /* renamed from: V */
    private boolean f13550V;
    /* renamed from: W */
    private boolean f13551W;
    /* renamed from: a */
    protected int f13552a;
    /* renamed from: aa */
    private final Animation f13553aa;
    /* renamed from: ab */
    private final Animation f13554ab;
    /* renamed from: ac */
    private boolean f13555ac;
    /* renamed from: b */
    protected float f13556b;
    /* renamed from: c */
    protected float f13557c;
    /* renamed from: d */
    protected View f13558d;
    /* renamed from: e */
    protected C4052d f13559e;
    /* renamed from: f */
    protected final AnimationListener f13560f;
    /* renamed from: g */
    private final String f13561g;
    /* renamed from: h */
    private final int[] f13562h;
    /* renamed from: i */
    private final int[] f13563i;
    /* renamed from: j */
    private final NestedScrollingChildHelper f13564j;
    /* renamed from: k */
    private final NestedScrollingParentHelper f13565k;
    /* renamed from: l */
    private float f13566l;
    /* renamed from: m */
    private boolean f13567m;
    /* access modifiers changed from: private */
    /* renamed from: n */
    public boolean f13568n;
    /* renamed from: o */
    private boolean f13569o;
    /* renamed from: p */
    private boolean f13570p;
    /* renamed from: q */
    private boolean f13571q;
    /* access modifiers changed from: private */
    /* renamed from: r */
    public boolean f13572r;
    /* renamed from: s */
    private boolean f13573s;
    /* renamed from: t */
    private int f13574t;
    /* renamed from: u */
    private int f13575u;
    /* renamed from: v */
    private int f13576v;
    /* renamed from: w */
    private int f13577w;
    /* renamed from: x */
    private int f13578x;
    /* renamed from: y */
    private int f13579y;
    /* renamed from: z */
    private float f13580z;

    /* renamed from: com.kwad.sdk.contentalliance.refreshview.RefreshLayout$6 */
    static /* synthetic */ class C40406 {
        /* renamed from: a */
        static final /* synthetic */ int[] f13586a = new int[RefreshStyle.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
     */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
            com.kwad.sdk.contentalliance.refreshview.RefreshLayout$RefreshStyle[] r0 = com.kwad.sdk.contentalliance.refreshview.RefreshLayout.RefreshStyle.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f13586a = r0
            int[] r0 = f13586a     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.kwad.sdk.contentalliance.refreshview.RefreshLayout$RefreshStyle r1 = com.kwad.sdk.contentalliance.refreshview.RefreshLayout.RefreshStyle.FLOAT     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f13586a     // Catch:{ NoSuchFieldError -> 0x001f }
            com.kwad.sdk.contentalliance.refreshview.RefreshLayout$RefreshStyle r1 = com.kwad.sdk.contentalliance.refreshview.RefreshLayout.RefreshStyle.PINNED     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.contentalliance.refreshview.RefreshLayout.C40406.m47834clinit():void");
        }
    }

    /* renamed from: com.kwad.sdk.contentalliance.refreshview.RefreshLayout$RefreshStyle */
    public enum RefreshStyle {
        NORMAL,
        PINNED,
        FLOAT
    }

    /* renamed from: com.kwad.sdk.contentalliance.refreshview.RefreshLayout$a */
    public static class C4041a extends MarginLayoutParams {
        public C4041a(int i, int i2) {
            super(i, i2);
        }

        public C4041a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C4041a(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* renamed from: com.kwad.sdk.contentalliance.refreshview.RefreshLayout$b */
    public interface C4042b {
        /* renamed from: a */
        void mo23613a();
    }

    /* renamed from: com.kwad.sdk.contentalliance.refreshview.RefreshLayout$c */
    public interface C4043c {
        /* renamed from: a */
        void mo23689a();

        /* renamed from: a */
        void mo23690a(float f, float f2, boolean z);

        /* renamed from: b */
        void mo23691b();

        /* renamed from: c */
        void mo23692c();
    }

    /* renamed from: com.kwad.sdk.contentalliance.refreshview.RefreshLayout$d */
    public interface C4044d {
        /* renamed from: a */
        boolean mo23693a(float f, boolean z);
    }

    public RefreshLayout(Context context) {
        this(context, null);
    }

    public RefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        String str = "RefreshLayout";
        this.f13561g = str;
        this.f13562h = new int[2];
        this.f13563i = new int[2];
        this.f13574t = -1;
        this.f13575u = -1;
        this.f13576v = 300;
        this.f13577w = 500;
        this.f13536H = false;
        this.f13537I = false;
        this.f13538J = false;
        this.f13539K = RefreshStyle.NORMAL;
        this.f13541M = null;
        this.f13544P = new AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                if (RefreshLayout.this.f13572r && RefreshLayout.this.f13543O != null) {
                    RefreshLayout.this.f13543O.mo23613a();
                }
                RefreshLayout.this.f13568n = false;
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                RefreshLayout.this.f13568n = true;
                RefreshLayout.this.f13559e.mo23633b();
            }
        };
        this.f13560f = new AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                RefreshLayout.this.m16730b();
                if (RefreshLayout.this.f13546R != null) {
                    RefreshLayout.this.f13546R.mo23692c();
                }
                if (RefreshLayout.this.f13547S != null) {
                    for (int i = 0; i < RefreshLayout.this.f13547S.size(); i++) {
                        ((C4043c) RefreshLayout.this.f13547S.get(i)).mo23692c();
                    }
                }
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                RefreshLayout.this.f13568n = true;
            }
        };
        this.f13548T = new DecelerateInterpolator(2.0f);
        this.f13549U = new DecelerateInterpolator(2.0f);
        this.f13551W = true;
        this.f13553aa = new Animation() {
            /* access modifiers changed from: protected */
            public void applyTransformation(float f, Transformation transformation) {
                if (RefreshLayout.this.f13540L != null) {
                    if (C40406.f13586a[RefreshLayout.this.f13539K.ordinal()] != 1) {
                        RefreshLayout refreshLayout = RefreshLayout.this;
                        refreshLayout.m16717a(refreshLayout.f13557c, (float) RefreshLayout.this.f13540L.getTop(), f);
                    } else {
                        float h = RefreshLayout.this.f13557c + RefreshLayout.this.f13532D;
                        RefreshLayout refreshLayout2 = RefreshLayout.this;
                        refreshLayout2.m16717a(h, (float) refreshLayout2.f13558d.getTop(), f);
                    }
                }
            }
        };
        this.f13554ab = new Animation() {
            /* access modifiers changed from: protected */
            public void applyTransformation(float f, Transformation transformation) {
                RefreshLayout refreshLayout;
                float h;
                View view;
                if (RefreshLayout.this.f13540L != null) {
                    if (C40406.f13586a[RefreshLayout.this.f13539K.ordinal()] != 1) {
                        refreshLayout = RefreshLayout.this;
                        h = 0.0f;
                        view = refreshLayout.f13540L;
                    } else {
                        refreshLayout = RefreshLayout.this;
                        h = refreshLayout.f13532D;
                        view = RefreshLayout.this.f13558d;
                    }
                    refreshLayout.m16717a(h, (float) view.getTop(), f);
                }
            }
        };
        this.f13555ac = true;
        this.f13579y = ViewConfiguration.get(context).getScaledTouchSlop();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f13552a = (int) (displayMetrics.density * 70.0f);
        this.f13557c = displayMetrics.density * 70.0f;
        this.f13556b = 0.0f;
        StringBuilder sb = new StringBuilder();
        sb.append("constructor: ");
        sb.append(this.f13556b);
        C4065b.m16867b(str, sb.toString());
        this.f13532D = 0.0f;
        this.f13533E = 1.0f;
        this.f13565k = new NestedScrollingParentHelper(this);
        this.f13564j = new NestedScrollingChildHelper(this);
        mo23626a(attributeSet);
        m16740g();
        setNestedScrollingEnabled(true);
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
    }

    /* renamed from: a */
    private float m16714a(MotionEvent motionEvent, int i) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
        if (findPointerIndex < 0) {
            return -1.0f;
        }
        return MotionEventCompat.getY(motionEvent, findPointerIndex);
    }

    /* renamed from: a */
    private int m16715a(int i) {
        return C40406.f13586a[this.f13539K.ordinal()] != 1 ? i + ((int) this.f13556b) : i;
    }

    /* renamed from: a */
    private void m16716a(float f) {
        float f2 = f - this.f13580z;
        if (this.f13569o && (f2 > ((float) this.f13579y) || this.f13556b > 0.0f)) {
            this.f13571q = true;
            this.f13530B = this.f13580z + ((float) this.f13579y);
        } else if (!this.f13571q) {
            int i = this.f13579y;
            if (f2 > ((float) i)) {
                this.f13530B = this.f13580z + ((float) i);
                this.f13571q = true;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16717a(float f, float f2, float f3) {
        int i = this.f13578x;
        setTargetOrRefreshViewOffsetY((int) (((float) ((int) (((float) i) + ((f - ((float) i)) * f3)))) - f2));
    }

    /* renamed from: a */
    private void m16718a(float f, boolean z) {
        float f2;
        this.f13531C = f;
        C4044d dVar = this.f13545Q;
        int i = 0;
        if (dVar == null || !dVar.mo23693a(f, false)) {
            if (!this.f13569o) {
                f2 = C40406.f13586a[this.f13539K.ordinal()] != 1 ? this.f13542N.mo23630a(f, this.f13557c) : this.f13532D + this.f13542N.mo23630a(f, this.f13557c);
            } else {
                f2 = this.f13557c;
                if (f <= f2) {
                    f2 = f;
                }
                if (f2 < 0.0f) {
                    f2 = 0.0f;
                }
            }
            float f3 = this.f13557c;
            if (!this.f13569o) {
                if (f2 > f3 && !this.f13570p) {
                    this.f13570p = true;
                    this.f13559e.mo23635d();
                    C4043c cVar = this.f13546R;
                    if (cVar != null) {
                        cVar.mo23689a();
                    }
                    if (this.f13547S != null) {
                        while (i < this.f13547S.size()) {
                            ((C4043c) this.f13547S.get(i)).mo23689a();
                            i++;
                        }
                    }
                } else if (f2 <= f3 && this.f13570p) {
                    this.f13570p = false;
                    this.f13559e.mo23636e();
                    C4043c cVar2 = this.f13546R;
                    if (cVar2 != null) {
                        cVar2.mo23691b();
                    }
                    if (this.f13547S != null) {
                        while (i < this.f13547S.size()) {
                            ((C4043c) this.f13547S.get(i)).mo23691b();
                            i++;
                        }
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(f);
            String str = " -- ";
            sb.append(str);
            sb.append(f3);
            sb.append(str);
            sb.append(f2);
            sb.append(str);
            sb.append(this.f13556b);
            sb.append(str);
            sb.append(this.f13557c);
            C4065b.m16867b("RefreshLayout", sb.toString());
            m16720a((int) (f2 - this.f13556b), z);
        }
    }

    /* renamed from: a */
    private void m16719a(int i, int i2) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f13558d.getLayoutParams();
        this.f13558d.measure(marginLayoutParams.width == -1 ? MeasureSpec.makeMeasureSpec(Math.max(0, (((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin), 1073741824) : getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, marginLayoutParams.width), marginLayoutParams.height == -1 ? MeasureSpec.makeMeasureSpec(Math.max(0, (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin), 1073741824) : getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ce  */
    /* renamed from: a */
    private void m16720a(int r6, boolean r7) {
        /*
        r5 = this;
        android.view.View r0 = r5.f13540L
        if (r0 != 0) goto L_0x0005
        return
    L_0x0005:
        int[] r0 = com.kwad.sdk.contentalliance.refreshview.RefreshLayout.C40406.f13586a
        com.kwad.sdk.contentalliance.refreshview.RefreshLayout$RefreshStyle r1 = r5.f13539K
        int r1 = r1.ordinal()
        r0 = r0[r1]
        java.lang.String r1 = "RefreshLayout"
        r2 = 1
        if (r0 == r2) goto L_0x0064
        r3 = 2
        if (r0 == r3) goto L_0x0055
        android.view.View r0 = r5.f13540L
        r0.offsetTopAndBottom(r6)
        android.view.View r0 = r5.f13535G
        if (r0 == 0) goto L_0x0024
        r0.offsetTopAndBottom(r6)
        goto L_0x0035
    L_0x0024:
        float r6 = (float) r6
        float r0 = r5.f13533E
        float r6 = r6 / r0
        float r0 = r5.f13534F
        float r6 = r6 + r0
        int r0 = (int) r6
        float r3 = (float) r0
        float r6 = r6 - r3
        r5.f13534F = r6
        android.view.View r6 = r5.f13558d
        r6.offsetTopAndBottom(r0)
    L_0x0035:
        android.view.View r6 = r5.f13540L
        int r6 = r6.getTop()
        float r6 = (float) r6
        r5.f13556b = r6
        java.lang.StringBuilder r6 = new java.lang.StringBuilder
        r6.<init>()
        java.lang.String r0 = "refresh style"
        r6.append(r0)
        float r0 = r5.f13556b
        r6.append(r0)
        java.lang.String r6 = r6.toString()
        com.kwad.sdk.core.p319c.C4065b.m16867b(r1, r6)
        goto L_0x0072
    L_0x0055:
        android.view.View r0 = r5.f13540L
        r0.offsetTopAndBottom(r6)
        android.view.View r0 = r5.f13535G
        if (r0 == 0) goto L_0x0061
        r0.offsetTopAndBottom(r6)
    L_0x0061:
        android.view.View r6 = r5.f13540L
        goto L_0x006b
    L_0x0064:
        android.view.View r0 = r5.f13558d
        r0.offsetTopAndBottom(r6)
        android.view.View r6 = r5.f13558d
    L_0x006b:
        int r6 = r6.getTop()
        float r6 = (float) r6
        r5.f13556b = r6
    L_0x0072:
        java.lang.StringBuilder r6 = new java.lang.StringBuilder
        r6.<init>()
        java.lang.String r0 = "current offset"
        r6.append(r0)
        float r0 = r5.f13556b
        r6.append(r0)
        java.lang.String r6 = r6.toString()
        com.kwad.sdk.core.p319c.C4065b.m16867b(r1, r6)
        int[] r6 = com.kwad.sdk.contentalliance.refreshview.RefreshLayout.C40406.f13586a
        com.kwad.sdk.contentalliance.refreshview.RefreshLayout$RefreshStyle r0 = r5.f13539K
        int r0 = r0.ordinal()
        r6 = r6[r0]
        r0 = 0
        if (r6 == r2) goto L_0x00ce
        com.kwad.sdk.contentalliance.refreshview.d r6 = r5.f13559e
        float r1 = r5.f13556b
        float r2 = r5.f13557c
        float r2 = r1 / r2
        r6.mo23632a(r1, r2)
        com.kwad.sdk.contentalliance.refreshview.RefreshLayout$c r6 = r5.f13546R
        if (r6 == 0) goto L_0x00ad
        float r1 = r5.f13556b
        float r2 = r5.f13557c
        float r2 = r1 / r2
        r6.mo23690a(r1, r2, r7)
    L_0x00ad:
        java.util.List<com.kwad.sdk.contentalliance.refreshview.RefreshLayout$c> r6 = r5.f13547S
        if (r6 == 0) goto L_0x0110
        r6 = 0
    L_0x00b2:
        java.util.List<com.kwad.sdk.contentalliance.refreshview.RefreshLayout$c> r1 = r5.f13547S
        int r1 = r1.size()
        if (r6 >= r1) goto L_0x0110
        java.util.List<com.kwad.sdk.contentalliance.refreshview.RefreshLayout$c> r1 = r5.f13547S
        java.lang.Object r1 = r1.get(r6)
        com.kwad.sdk.contentalliance.refreshview.RefreshLayout$c r1 = (com.kwad.sdk.contentalliance.refreshview.RefreshLayout.C4043c) r1
        float r2 = r5.f13556b
        float r3 = r5.f13557c
        float r3 = r2 / r3
        r1.mo23690a(r2, r3, r7)
        int r6 = r6 + 1
        goto L_0x00b2
    L_0x00ce:
        com.kwad.sdk.contentalliance.refreshview.d r6 = r5.f13559e
        float r1 = r5.f13556b
        float r2 = r5.f13532D
        float r2 = r1 - r2
        float r3 = r5.f13557c
        float r2 = r2 / r3
        r6.mo23632a(r1, r2)
        com.kwad.sdk.contentalliance.refreshview.RefreshLayout$c r6 = r5.f13546R
        if (r6 == 0) goto L_0x00ec
        float r1 = r5.f13556b
        float r2 = r5.f13532D
        float r2 = r1 - r2
        float r3 = r5.f13557c
        float r2 = r2 / r3
        r6.mo23690a(r1, r2, r7)
    L_0x00ec:
        java.util.List<com.kwad.sdk.contentalliance.refreshview.RefreshLayout$c> r6 = r5.f13547S
        if (r6 == 0) goto L_0x0110
        r6 = 0
    L_0x00f1:
        java.util.List<com.kwad.sdk.contentalliance.refreshview.RefreshLayout$c> r1 = r5.f13547S
        int r1 = r1.size()
        if (r6 >= r1) goto L_0x0110
        java.util.List<com.kwad.sdk.contentalliance.refreshview.RefreshLayout$c> r1 = r5.f13547S
        java.lang.Object r1 = r1.get(r6)
        com.kwad.sdk.contentalliance.refreshview.RefreshLayout$c r1 = (com.kwad.sdk.contentalliance.refreshview.RefreshLayout.C4043c) r1
        float r2 = r5.f13556b
        float r3 = r5.f13532D
        float r3 = r2 - r3
        float r4 = r5.f13557c
        float r3 = r3 / r4
        r1.mo23690a(r2, r3, r7)
        int r6 = r6 + 1
        goto L_0x00f1
    L_0x0110:
        boolean r6 = r5.f13551W
        if (r6 == 0) goto L_0x0121
        android.view.View r6 = r5.f13558d
        int r6 = r6.getVisibility()
        if (r6 == 0) goto L_0x0121
        android.view.View r6 = r5.f13558d
        r6.setVisibility(r0)
    L_0x0121:
        r5.invalidate()
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.contentalliance.refreshview.RefreshLayout.m16720a(int, boolean):void");
    }

    /* renamed from: a */
    private void mo23708a(MotionEvent motionEvent) {
        this.f13575u = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
        this.f13530B = m16714a(motionEvent, this.f13575u) - this.f13531C;
        StringBuilder sb = new StringBuilder();
        sb.append(" onDown ");
        sb.append(this.f13530B);
        C4065b.m16867b("RefreshLayout", sb.toString());
    }

    /* renamed from: a */
    private void m16723a(boolean z, boolean z2) {
        if (this.f13569o != z) {
            this.f13572r = z2;
            this.f13569o = z;
            if (z) {
                m16731b((int) this.f13556b, this.f13544P);
                return;
            }
            this.f13559e.mo23634c();
            postDelayed(new Runnable() {
                public void run() {
                    RefreshLayout refreshLayout = RefreshLayout.this;
                    refreshLayout.mo23625a((int) refreshLayout.f13556b, RefreshLayout.this.f13560f);
                }
            }, (long) this.f13559e.mo23637f());
        }
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v2, types: [int] */
    /* JADX WARNING: type inference failed for: r0v3, types: [int] */
    /* JADX WARNING: type inference failed for: r0v4, types: [boolean] */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v6
  assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], ?[boolean, int, float, short, byte, char]]
  uses: [?[int, byte, short, char], int, boolean]
	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:231)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:95)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:88)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:30)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
	at jadx.core.ProcessClass.process(ProcessClass.java:35)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* renamed from: a */
    private boolean m16724a(android.view.View r6) {
        /*
        r5 = this;
        r0 = 0
        if (r6 != 0) goto L_0x0004
        return r0
    L_0x0004:
        int r1 = android.os.Build.VERSION.SDK_INT
        r2 = 14
        r3 = 1
        if (r1 >= r2) goto L_0x002d
        boolean r1 = r6 instanceof android.widget.AbsListView
        if (r1 == 0) goto L_0x002d
        android.widget.AbsListView r6 = (android.widget.AbsListView) r6
        int r1 = r6.getChildCount()
        if (r1 <= 0) goto L_0x002c
        int r1 = r6.getFirstVisiblePosition()
        if (r1 > 0) goto L_0x002b
        android.view.View r1 = r6.getChildAt(r0)
        int r1 = r1.getTop()
        int r6 = r6.getPaddingTop()
        if (r1 >= r6) goto L_0x002c
    L_0x002b:
        r0 = 1
    L_0x002c:
        return r0
    L_0x002d:
        boolean r1 = r6 instanceof android.view.ViewGroup
        if (r1 == 0) goto L_0x0048
        r1 = r6
        android.view.ViewGroup r1 = (android.view.ViewGroup) r1
        int r2 = r1.getChildCount()
    L_0x0038:
        if (r0 >= r2) goto L_0x0048
        android.view.View r4 = r1.getChildAt(r0)
        boolean r4 = r5.m16724a(r4)
        if (r4 == 0) goto L_0x0045
        return r3
    L_0x0045:
        int r0 = r0 + 1
        goto L_0x0038
    L_0x0048:
        r0 = -1
        boolean r6 = androidx.core.view.ViewCompat.canScrollVertically(r6, r0)
        return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.contentalliance.refreshview.RefreshLayout.m16724a(android.view.View):boolean");
    }

    /* renamed from: b */
    private int m16727b(float f) {
        StringBuilder sb = new StringBuilder();
        sb.append("from -- refreshing ");
        sb.append(f);
        C4065b.m16867b("RefreshLayout", sb.toString());
        if (C40406.f13586a[this.f13539K.ordinal()] == 1) {
            f -= this.f13532D;
        }
        return (int) (Math.max(0.0f, Math.min(1.0f, Math.abs(f - this.f13557c) / this.f13557c)) * ((float) this.f13577w));
    }

    /* renamed from: b */
    private int m16728b(int i) {
        return C40406.f13586a[this.f13539K.ordinal()] != 1 ? i : i + ((int) this.f13556b);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m16730b() {
        m16738f();
        this.f13531C = 0.0f;
        this.f13534F = 0.0f;
        this.f13559e.mo23631a();
        this.f13558d.setVisibility(8);
        this.f13569o = false;
        this.f13568n = false;
        C4065b.m16867b("RefreshLayout", "reset");
    }

    /* renamed from: b */
    private void m16731b(int i, AnimationListener animationListener) {
        clearAnimation();
        float f = (float) i;
        if (m16727b(f) <= 0) {
            animationListener.onAnimationStart(null);
            animationListener.onAnimationEnd(null);
            return;
        }
        this.f13578x = i;
        this.f13553aa.reset();
        this.f13553aa.setDuration((long) m16727b(f));
        this.f13553aa.setInterpolator(this.f13549U);
        if (animationListener != null) {
            this.f13553aa.setAnimationListener(animationListener);
        }
        startAnimation(this.f13553aa);
    }

    /* renamed from: b */
    private void mo23709b(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.f13575u) {
            this.f13575u = MotionEventCompat.getPointerId(motionEvent, actionIndex == 0 ? 1 : 0);
        }
        this.f13530B = m16714a(motionEvent, this.f13575u) - this.f13531C;
        StringBuilder sb = new StringBuilder();
        sb.append(" onUp ");
        sb.append(this.f13530B);
        C4065b.m16867b("RefreshLayout", sb.toString());
    }

    /* renamed from: c */
    private int m16733c(float f) {
        StringBuilder sb = new StringBuilder();
        sb.append("from -- start ");
        sb.append(f);
        C4065b.m16867b("RefreshLayout", sb.toString());
        if (f < this.f13532D) {
            return 0;
        }
        if (C40406.f13586a[this.f13539K.ordinal()] == 1) {
            f -= this.f13532D;
        }
        return (int) (Math.max(0.0f, Math.min(1.0f, Math.abs(f) / this.f13557c)) * ((float) this.f13576v));
    }

    /* renamed from: f */
    private void m16738f() {
        setTargetOrRefreshViewOffsetY((int) ((C40406.f13586a[this.f13539K.ordinal()] != 1 ? 0.0f : this.f13532D) - this.f13556b));
    }

    /* renamed from: g */
    private void m16740g() {
        this.f13542N = mo23624a();
    }

    private int getTargetOrRefreshViewTop() {
        return (C40406.f13586a[this.f13539K.ordinal()] != 1 ? this.f13540L : this.f13558d).getTop();
    }

    /* renamed from: h */
    private void m16742h() {
        this.f13540L.measure(MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
    }

    /* renamed from: i */
    private void m16743i() {
        this.f13529A = 0.0f;
        this.f13571q = false;
        this.f13573s = false;
        this.f13575u = -1;
    }

    /* renamed from: j */
    private void m16744j() {
        if (!this.f13569o && !this.f13568n) {
            C4044d dVar = this.f13545Q;
            if (dVar != null && dVar.mo23693a(this.f13531C, true)) {
                return;
            }
            if (mo23647c()) {
                m16723a(true, true);
            } else {
                this.f13569o = false;
                mo23625a((int) this.f13556b, this.f13560f);
            }
        }
    }

    /* renamed from: k */
    private void m16745k() {
        View view = this.f13535G;
        if (view != null) {
            view.measure(MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        }
    }

    /* renamed from: l */
    private void m16746l() {
        if (!m16747m()) {
            int i = 0;
            while (i < getChildCount()) {
                View childAt = getChildAt(i);
                if (childAt.equals(this.f13558d) || childAt.equals(this.f13535G)) {
                    i++;
                } else {
                    this.f13540L = childAt;
                    return;
                }
            }
        }
    }

    /* renamed from: m */
    private boolean m16747m() {
        for (int i = 0; i < getChildCount(); i++) {
            if (this.f13540L == getChildAt(i)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C4041a generateLayoutParams(LayoutParams layoutParams) {
        return new C4041a(layoutParams);
    }

    /* renamed from: a */
    public abstract C4050b mo23624a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23625a(int i, AnimationListener animationListener) {
        clearAnimation();
        float f = (float) i;
        if (m16733c(f) <= 0) {
            animationListener.onAnimationStart(null);
            animationListener.onAnimationEnd(null);
            return;
        }
        this.f13578x = i;
        this.f13554ab.reset();
        this.f13554ab.setDuration((long) m16733c(f));
        this.f13554ab.setInterpolator(this.f13548T);
        if (animationListener != null) {
            this.f13554ab.setAnimationListener(animationListener);
        }
        startAnimation(this.f13554ab);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23626a(AttributeSet attributeSet) {
        this.f13558d = mo23645b(attributeSet);
        this.f13558d.setVisibility(8);
        View view = this.f13558d;
        if (view instanceof C4052d) {
            this.f13559e = (C4052d) view;
            C4041a c = mo23646c(attributeSet);
            if (c == null) {
                int i = this.f13552a;
                c = new C4041a(i, i);
            }
            addView(this.f13558d, c);
            return;
        }
        throw new ClassCastException("the refreshView must implement the interface IRefreshStatus");
    }

    /* renamed from: b */
    public abstract View mo23645b(AttributeSet attributeSet);

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public C4041a mo23646c(AttributeSet attributeSet) {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo23647c() {
        return !this.f13550V && ((float) getTargetOrRefreshViewOffset()) > this.f13557c;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof C4041a;
    }

    /* renamed from: d */
    public C4041a generateLayoutParams(AttributeSet attributeSet) {
        return new C4041a(getContext(), attributeSet);
    }

    /* renamed from: d */
    public boolean mo23650d() {
        return this.f13569o;
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f13564j.dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f13564j.dispatchNestedPreFling(f, f2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f13564j.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f13564j.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f13555ac) {
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            if (actionMasked == 1 || actionMasked == 3) {
                onStopNestedScroll(this);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("dispatch ");
        sb.append(this.f13573s);
        sb.append(" isRefreshing");
        sb.append(this.f13569o);
        C4065b.m16867b("RefreshLayout", sb.toString());
        return super.dispatchTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public C4041a generateDefaultLayoutParams() {
        return new C4041a(-2, -2);
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i, int i2) {
        if (C40406.f13586a[this.f13539K.ordinal()] != 1) {
            int i3 = this.f13574t;
            if (i3 < 0) {
                return i2;
            }
            if (i2 == 0) {
                return i3;
            }
            if (i2 <= i3) {
                i2--;
            }
            return i2;
        }
        int i4 = this.f13574t;
        if (i4 < 0) {
            return i2;
        }
        if (i2 == i - 1) {
            return i4;
        }
        if (i2 >= i4) {
            i2++;
        }
        return i2;
    }

    public int getNestedScrollAxes() {
        return this.f13565k.getNestedScrollAxes();
    }

    public float getRefreshTargetOffset() {
        return this.f13557c;
    }

    public View getStateView() {
        return this.f13535G;
    }

    public int getTargetOrRefreshViewOffset() {
        if (C40406.f13586a[this.f13539K.ordinal()] == 1) {
            return (int) (((float) this.f13558d.getTop()) - this.f13532D);
        }
        View view = this.f13540L;
        return view == null ? 0 : view.getTop();
    }

    public boolean hasNestedScrollingParent() {
        return this.f13564j.hasNestedScrollingParent();
    }

    public boolean isNestedScrollingEnabled() {
        return this.f13564j.isNestedScrollingEnabled();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        m16730b();
        this.f13543O = null;
        clearAnimation();
        super.onDetachedFromWindow();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        m16746l();
        View view = this.f13540L;
        if (view == null) {
            return false;
        }
        if ((view instanceof C4051c) && !((C4051c) view).mo23707a()) {
            return false;
        }
        if (C40406.f13586a[this.f13539K.ordinal()] != 1) {
            if (!isEnabled() || (m16724a(this.f13540L) && !this.f13573s)) {
                return false;
            }
        } else if (!isEnabled() || m16724a(this.f13540L) || this.f13569o || this.f13567m) {
            return false;
        }
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i = this.f13575u;
                    if (i == -1) {
                        return false;
                    }
                    float a = m16714a(motionEvent, i);
                    if (a == -1.0f) {
                        return false;
                    }
                    m16716a(a);
                    ValueAnimator valueAnimator = this.f13541M;
                    if (valueAnimator != null && valueAnimator.isRunning()) {
                        this.f13541M.cancel();
                        this.f13559e.mo23634c();
                        mo23625a((int) this.f13556b, this.f13560f);
                    }
                } else if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        mo23709b(motionEvent);
                    }
                }
            }
            this.f13571q = false;
            this.f13575u = -1;
        } else {
            this.f13575u = motionEvent.getPointerId(0);
            this.f13571q = false;
            float a2 = m16714a(motionEvent, this.f13575u);
            if (a2 == -1.0f) {
                return false;
            }
            if (this.f13553aa.hasEnded() && this.f13554ab.hasEnded()) {
                this.f13568n = false;
            }
            this.f13580z = a2;
            this.f13529A = this.f13556b;
            this.f13573s = false;
        }
        return this.f13571q;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0029, code lost:
            if (r5.getVisibility() != 8) goto L_0x002b;
     */
    public void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
        /*
        r2 = this;
        int r3 = r2.getChildCount()
        if (r3 != 0) goto L_0x0007
        return
    L_0x0007:
        r2.m16746l()
        android.view.View r3 = r2.f13540L
        if (r3 != 0) goto L_0x000f
        return
    L_0x000f:
        int r3 = r2.getMeasuredWidth()
        int r4 = r2.getMeasuredHeight()
        android.view.View r5 = r2.f13540L
        int r5 = r5.getVisibility()
        r6 = 8
        if (r5 != r6) goto L_0x002b
        android.view.View r5 = r2.f13535G
        if (r5 == 0) goto L_0x006a
        int r5 = r5.getVisibility()
        if (r5 == r6) goto L_0x006a
    L_0x002b:
        int r5 = r2.getPaddingTop()
        int r5 = r2.m16715a(r5)
        int r7 = r2.getPaddingLeft()
        int r0 = r7 + r3
        int r1 = r2.getPaddingLeft()
        int r0 = r0 - r1
        int r1 = r2.getPaddingRight()
        int r0 = r0 - r1
        int r4 = r4 + r5
        int r1 = r2.getPaddingTop()
        int r4 = r4 - r1
        int r1 = r2.getPaddingBottom()
        int r4 = r4 - r1
        android.view.View r1 = r2.f13540L
        int r1 = r1.getVisibility()
        if (r1 == r6) goto L_0x005b
        android.view.View r1 = r2.f13540L
        r1.layout(r7, r5, r0, r4)
    L_0x005b:
        android.view.View r1 = r2.f13535G
        if (r1 == 0) goto L_0x006a
        int r1 = r1.getVisibility()
        if (r1 == r6) goto L_0x006a
        android.view.View r6 = r2.f13535G
        r6.layout(r7, r5, r0, r4)
    L_0x006a:
        android.view.View r4 = r2.f13558d
        android.view.ViewGroup$LayoutParams r4 = r4.getLayoutParams()
        android.view.ViewGroup$MarginLayoutParams r4 = (android.view.ViewGroup.MarginLayoutParams) r4
        android.view.View r5 = r2.f13558d
        int r5 = r5.getMeasuredWidth()
        int r5 = r3 - r5
        int r5 = r5 / 2
        float r6 = r2.f13532D
        int r6 = (int) r6
        int r6 = r2.m16728b(r6)
        int r7 = r4.topMargin
        int r6 = r6 + r7
        int r4 = r4.bottomMargin
        int r6 = r6 - r4
        android.view.View r4 = r2.f13558d
        int r4 = r4.getMeasuredWidth()
        int r3 = r3 + r4
        int r3 = r3 / 2
        android.view.View r4 = r2.f13558d
        int r4 = r4.getMeasuredHeight()
        int r4 = r4 + r6
        android.view.View r7 = r2.f13558d
        r7.layout(r5, r6, r3, r4)
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.contentalliance.refreshview.RefreshLayout.onLayout(boolean, int, int, int, int):void");
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        m16746l();
        if (this.f13540L != null) {
            m16742h();
            m16745k();
            m16719a(i, i2);
            if (!this.f13538J && !this.f13537I) {
                int i3 = C40406.f13586a[this.f13539K.ordinal()];
                if (i3 == 1) {
                    float f = (float) (-this.f13558d.getMeasuredHeight());
                    this.f13532D = f;
                    this.f13556b = f;
                } else if (i3 != 2) {
                    this.f13556b = 0.0f;
                    this.f13532D = (float) (-this.f13558d.getMeasuredHeight());
                } else {
                    this.f13532D = 0.0f;
                    this.f13556b = 0.0f;
                }
            }
            if (!this.f13538J && !this.f13536H && this.f13557c < ((float) this.f13558d.getMeasuredHeight())) {
                this.f13557c = (float) this.f13558d.getMeasuredHeight();
            }
            this.f13538J = true;
            this.f13574t = -1;
            int i4 = 0;
            while (true) {
                if (i4 >= getChildCount()) {
                    break;
                } else if (getChildAt(i4) == this.f13558d) {
                    this.f13574t = i4;
                    break;
                } else {
                    i4++;
                }
            }
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return dispatchNestedFling(f, f2, z);
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0) {
            float f = this.f13566l;
            if (f > 0.0f) {
                float f2 = (float) i2;
                if (f2 > f) {
                    iArr[1] = i2 - ((int) f);
                    this.f13566l = 0.0f;
                } else {
                    this.f13566l = f - f2;
                    iArr[1] = i2;
                }
                C4065b.m16867b("RefreshLayout", "pre scroll");
                m16718a(this.f13566l, false);
            }
        }
        int[] iArr2 = this.f13562h;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        dispatchNestedScroll(i, i2, i3, i4, this.f13563i);
        int i5 = i4 + this.f13563i[1];
        if (i5 < 0) {
            this.f13566l += (float) Math.abs(i5);
            C4065b.m16867b("RefreshLayout", "nested scroll");
            m16718a(this.f13566l, true);
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f13565k.onNestedScrollAccepted(view, view2, i);
        startNestedScroll(i & 2);
        this.f13566l = 0.0f;
        this.f13567m = true;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        boolean z = false;
        if (C40406.f13586a[this.f13539K.ordinal()] != 1) {
            if (isEnabled() && m16724a(this.f13540L) && (i & 2) != 0) {
                z = true;
            }
            return z;
        }
        if (isEnabled() && m16724a(this.f13540L) && !this.f13569o && (i & 2) != 0) {
            z = true;
        }
        return z;
    }

    public void onStopNestedScroll(View view) {
        this.f13565k.onStopNestedScroll(view);
        this.f13567m = false;
        if (this.f13566l > 0.0f) {
            m16744j();
            this.f13566l = 0.0f;
        }
        stopNestedScroll();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f;
        StringBuilder sb;
        float f2;
        m16746l();
        if (this.f13540L == null) {
            return false;
        }
        if (C40406.f13586a[this.f13539K.ordinal()] != 1) {
            if (!isEnabled() || (m16724a(this.f13540L) && !this.f13573s)) {
                return false;
            }
        } else if (!isEnabled() || m16724a(this.f13540L) || this.f13567m) {
            return false;
        }
        if (this.f13539K == RefreshStyle.FLOAT && (m16724a(this.f13540L) || this.f13567m)) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int i = this.f13575u;
                    if (i == -1) {
                        return false;
                    }
                    float a = m16714a(motionEvent, i);
                    if (a == -1.0f) {
                        return false;
                    }
                    String str = " -- ";
                    String str2 = "RefreshLayout";
                    if (this.f13568n) {
                        f2 = (float) getTargetOrRefreshViewTop();
                        this.f13530B = a;
                        this.f13529A = f2;
                        sb = new StringBuilder();
                        sb.append("animatetostart overscrolly ");
                        sb.append(f2);
                        sb.append(str);
                        f = this.f13530B;
                    } else {
                        f2 = (a - this.f13530B) + this.f13529A;
                        sb = new StringBuilder();
                        sb.append("overscrolly ");
                        sb.append(f2);
                        sb.append(" --");
                        sb.append(this.f13530B);
                        sb.append(str);
                        f = this.f13529A;
                    }
                    sb.append(f);
                    C4065b.m16867b(str2, sb.toString());
                    if (this.f13569o) {
                        if (f2 > 0.0f) {
                            if (f2 > 0.0f && f2 < this.f13557c && this.f13573s) {
                                motionEvent = MotionEvent.obtain(motionEvent);
                                motionEvent.setAction(3);
                                this.f13573s = false;
                            }
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("moveSpinner refreshing -- ");
                            sb2.append(this.f13529A);
                            sb2.append(str);
                            sb2.append(a - this.f13530B);
                            C4065b.m16867b(str2, sb2.toString());
                            m16718a(f2, true);
                        } else if (!this.f13573s) {
                            motionEvent = MotionEvent.obtain(motionEvent);
                            motionEvent.setAction(0);
                            this.f13573s = true;
                        }
                        this.f13540L.dispatchTouchEvent(motionEvent);
                        StringBuilder sb22 = new StringBuilder();
                        sb22.append("moveSpinner refreshing -- ");
                        sb22.append(this.f13529A);
                        sb22.append(str);
                        sb22.append(a - this.f13530B);
                        C4065b.m16867b(str2, sb22.toString());
                        m16718a(f2, true);
                    } else if (!this.f13571q) {
                        C4065b.m16867b(str2, "is not Being Dragged, init drag status");
                        m16716a(a);
                    } else if (f2 > 0.0f) {
                        m16718a(f2, true);
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("moveSpinner not refreshing -- ");
                        sb3.append(this.f13529A);
                        sb3.append(str);
                        sb3.append(a - this.f13530B);
                        C4065b.m16867b(str2, sb3.toString());
                    } else {
                        C4065b.m16867b(str2, "is Being Dragged, but over scroll Y < 0");
                        return false;
                    }
                } else if (action != 3) {
                    if (action == 5) {
                        mo23708a(motionEvent);
                    } else if (action == 6) {
                        mo23709b(motionEvent);
                    }
                }
            }
            int i2 = this.f13575u;
            if (i2 == -1 || m16714a(motionEvent, i2) == -1.0f) {
                m16743i();
                return false;
            } else if (this.f13569o || this.f13568n) {
                if (this.f13573s) {
                    this.f13540L.dispatchTouchEvent(motionEvent);
                }
                m16743i();
                return false;
            } else {
                m16743i();
                m16744j();
                return false;
            }
        } else {
            this.f13575u = MotionEventCompat.getPointerId(motionEvent, 0);
            this.f13571q = false;
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (VERSION.SDK_INT >= 21 || !(this.f13540L instanceof AbsListView)) {
            View view = this.f13540L;
            if (view == null || ViewCompat.isNestedScrollingEnabled(view)) {
                super.requestDisallowInterceptTouchEvent(z);
            }
        }
    }

    public void setAnimateToRefreshDuration(int i) {
        this.f13577w = i;
    }

    public void setAnimateToRefreshInterpolator(Interpolator interpolator) {
        this.f13549U = interpolator;
    }

    public void setAnimateToStartDuration(int i) {
        this.f13576v = i;
    }

    public void setAnimateToStartInterpolator(Interpolator interpolator) {
        this.f13548T = interpolator;
    }

    public void setDragDistanceConverter(C4050b bVar) {
        if (bVar != null) {
            this.f13542N = bVar;
            return;
        }
        throw new NullPointerException("the dragDistanceConverter can't be null");
    }

    public void setIsStopNestScrollWhenUpOrCancel(boolean z) {
        this.f13555ac = z;
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f13564j.setNestedScrollingEnabled(z);
    }

    public void setOnRefreshListener(C4042b bVar) {
        this.f13543O = bVar;
    }

    public void setOnRefreshStatusListener(C4043c cVar) {
        this.f13546R = cVar;
    }

    public void setOnScrollInterceptor(C4044d dVar) {
        this.f13545Q = dVar;
    }

    public void setOnlySupportPull(boolean z) {
        this.f13550V = z;
    }

    public void setRefreshInitialOffset(float f) {
        this.f13532D = f;
        this.f13537I = true;
        requestLayout();
    }

    public void setRefreshStyle(RefreshStyle refreshStyle) {
        this.f13539K = refreshStyle;
    }

    public void setRefreshTargetOffset(float f) {
        this.f13557c = f;
        this.f13536H = true;
        requestLayout();
    }

    public void setRefreshing(boolean z) {
        if (this.f13569o != z) {
            if (z) {
                if (getAnimation() != null && !getAnimation().hasEnded()) {
                    getAnimation().setAnimationListener(null);
                    clearAnimation();
                    m16730b();
                }
                this.f13569o = z;
                this.f13572r = false;
                m16731b((int) this.f13556b, this.f13544P);
            } else {
                m16723a(z, false);
            }
        }
    }

    public void setShowRefreshView(boolean z) {
        setOnlySupportPull(!z);
        this.f13551W = z;
    }

    public void setTargetOrRefreshViewOffsetY(int i) {
        m16720a(i, false);
    }

    public boolean startNestedScroll(int i) {
        return this.f13564j.startNestedScroll(i);
    }

    public void stopNestedScroll() {
        this.f13564j.stopNestedScroll();
    }
}
