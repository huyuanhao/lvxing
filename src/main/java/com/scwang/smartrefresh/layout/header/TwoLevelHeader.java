package com.scwang.smartrefresh.layout.header;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.scwang.smartrefresh.layout.p527a.OnTwoLevelListener;
import com.scwang.smartrefresh.layout.p527a.RefreshHeader;
import com.scwang.smartrefresh.layout.p527a.RefreshInternal;
import com.scwang.smartrefresh.layout.p527a.RefreshKernel;
import com.scwang.smartrefresh.layout.p527a.RefreshLayout;

public class TwoLevelHeader extends InternalAbstract implements RefreshHeader {
    /* renamed from: a */
    protected int f20910a;
    /* renamed from: b */
    protected float f20911b;
    /* renamed from: c */
    protected float f20912c;
    /* renamed from: d */
    protected float f20913d;
    /* renamed from: e */
    protected float f20914e;
    /* renamed from: f */
    protected boolean f20915f;
    /* renamed from: g */
    protected boolean f20916g;
    /* renamed from: h */
    protected int f20917h;
    /* renamed from: i */
    protected int f20918i;
    /* renamed from: j */
    protected RefreshHeader f20919j;
    /* renamed from: k */
    protected RefreshKernel f20920k;
    /* renamed from: l */
    protected OnTwoLevelListener f20921l;

    /* renamed from: com.scwang.smartrefresh.layout.header.TwoLevelHeader$1 */
    static /* synthetic */ class C65061 {
        /* renamed from: a */
        static final /* synthetic */ int[] f20922a = new int[RefreshState.values().length];
        /* renamed from: b */
        static final /* synthetic */ int[] f20923b = new int[SpinnerStyle.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|(2:1|2)|3|5|6|7|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|5|6|7|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0032 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0047 */
        static {
            /*
            com.scwang.smartrefresh.layout.constant.SpinnerStyle[] r0 = com.scwang.smartrefresh.layout.constant.SpinnerStyle.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f20923b = r0
            r0 = 1
            int[] r1 = f20923b     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.scwang.smartrefresh.layout.constant.SpinnerStyle r2 = com.scwang.smartrefresh.layout.constant.SpinnerStyle.Translate     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r1 = 2
            int[] r2 = f20923b     // Catch:{ NoSuchFieldError -> 0x001f }
            com.scwang.smartrefresh.layout.constant.SpinnerStyle r3 = com.scwang.smartrefresh.layout.constant.SpinnerStyle.Scale     // Catch:{ NoSuchFieldError -> 0x001f }
            int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            com.scwang.smartrefresh.layout.constant.RefreshState[] r2 = com.scwang.smartrefresh.layout.constant.RefreshState.values()
            int r2 = r2.length
            int[] r2 = new int[r2]
            f20922a = r2
            int[] r2 = f20922a     // Catch:{ NoSuchFieldError -> 0x0032 }
            com.scwang.smartrefresh.layout.constant.RefreshState r3 = com.scwang.smartrefresh.layout.constant.RefreshState.TwoLevelReleased     // Catch:{ NoSuchFieldError -> 0x0032 }
            int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
            r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0032 }
        L_0x0032:
            int[] r0 = f20922a     // Catch:{ NoSuchFieldError -> 0x003c }
            com.scwang.smartrefresh.layout.constant.RefreshState r2 = com.scwang.smartrefresh.layout.constant.RefreshState.TwoLevel     // Catch:{ NoSuchFieldError -> 0x003c }
            int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x003c }
            r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x003c }
        L_0x003c:
            int[] r0 = f20922a     // Catch:{ NoSuchFieldError -> 0x0047 }
            com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.TwoLevelFinish     // Catch:{ NoSuchFieldError -> 0x0047 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0047 }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0047 }
        L_0x0047:
            int[] r0 = f20922a     // Catch:{ NoSuchFieldError -> 0x0052 }
            com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.PullDownToRefresh     // Catch:{ NoSuchFieldError -> 0x0052 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0052 }
            r2 = 4
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0052 }
        L_0x0052:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.header.TwoLevelHeader.C65061.m51158clinit():void");
        }
    }

    public TwoLevelHeader(Context context) {
        this(context, null);
    }

    public TwoLevelHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TwoLevelHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20911b = 0.0f;
        this.f20912c = 2.5f;
        this.f20913d = 1.9f;
        this.f20914e = 1.0f;
        this.f20915f = true;
        this.f20916g = true;
        this.f20917h = 1000;
        this.f20937ab = SpinnerStyle.FixedBehind;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TwoLevelHeader);
        this.f20912c = obtainStyledAttributes.getFloat(R.styleable.TwoLevelHeader_srlMaxRage, this.f20912c);
        this.f20913d = obtainStyledAttributes.getFloat(R.styleable.TwoLevelHeader_srlFloorRage, this.f20913d);
        this.f20914e = obtainStyledAttributes.getFloat(R.styleable.TwoLevelHeader_srlRefreshRage, this.f20914e);
        this.f20917h = obtainStyledAttributes.getInt(R.styleable.TwoLevelHeader_srlFloorDuration, this.f20917h);
        this.f20915f = obtainStyledAttributes.getBoolean(R.styleable.TwoLevelHeader_srlEnableTwoLevel, this.f20915f);
        this.f20916g = obtainStyledAttributes.getBoolean(R.styleable.TwoLevelHeader_srlEnablePullToCloseTwoLevel, this.f20916g);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            }
            View childAt = getChildAt(i);
            if (childAt instanceof RefreshHeader) {
                this.f20919j = (RefreshHeader) childAt;
                this.f20938ac = (RefreshInternal) childAt;
                bringChildToFront(childAt);
                break;
            }
            i++;
        }
        if (this.f20919j == null) {
            mo30994a((RefreshHeader) new ClassicsHeader(getContext()));
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f20937ab = SpinnerStyle.MatchLayout;
        if (this.f20919j == null) {
            mo30994a((RefreshHeader) new ClassicsHeader(getContext()));
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f20937ab = SpinnerStyle.FixedBehind;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        RefreshHeader gVar = this.f20919j;
        if (gVar == null) {
            super.onMeasure(i, i2);
        } else if (MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
            gVar.getView().measure(i, i2);
            super.setMeasuredDimension(View.resolveSize(super.getSuggestedMinimumWidth(), i), gVar.getView().getMeasuredHeight());
        } else {
            super.onMeasure(i, i2);
        }
    }

    public boolean equals(Object obj) {
        RefreshHeader gVar = this.f20919j;
        return (gVar != null && gVar.equals(obj)) || super.equals(obj);
    }

    /* renamed from: a */
    public void mo30677a(RefreshKernel iVar, int i, int i2) {
        RefreshHeader gVar = this.f20919j;
        if (gVar != null) {
            if ((((float) (i2 + i)) * 1.0f) / ((float) i) != this.f20912c && this.f20918i == 0) {
                this.f20918i = i;
                this.f20919j = null;
                iVar.mo30931a().mo30881d(this.f20912c);
                this.f20919j = gVar;
            }
            if (this.f20920k == null && gVar.getSpinnerStyle() == SpinnerStyle.Translate && !isInEditMode()) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) gVar.getView().getLayoutParams();
                marginLayoutParams.topMargin -= i;
                gVar.getView().setLayoutParams(marginLayoutParams);
            }
            this.f20918i = i;
            this.f20920k = iVar;
            iVar.mo30933b(this.f20917h);
            iVar.mo30928a((RefreshInternal) this, !this.f20916g);
            gVar.mo30677a(iVar, i, i2);
        }
    }

    /* renamed from: a */
    public void mo30678a(RefreshLayout jVar, RefreshState refreshState, RefreshState refreshState2) {
        RefreshHeader gVar = this.f20919j;
        if (gVar != null) {
            gVar.mo30678a(jVar, refreshState, refreshState2);
            int i = C65061.f20922a[refreshState2.ordinal()];
            boolean z = true;
            if (i == 1) {
                if (gVar.getView() != this) {
                    gVar.getView().animate().alpha(0.0f).setDuration((long) (this.f20917h / 2));
                }
                RefreshKernel iVar = this.f20920k;
                if (iVar != null) {
                    OnTwoLevelListener dVar = this.f20921l;
                    if (dVar != null && !dVar.mo30939a(jVar)) {
                        z = false;
                    }
                    iVar.mo30930a(z);
                }
            } else if (i == 2) {
            } else {
                if (i != 3) {
                    if (i == 4 && gVar.getView().getAlpha() == 0.0f && gVar.getView() != this) {
                        gVar.getView().setAlpha(1.0f);
                    }
                } else if (gVar.getView() != this) {
                    gVar.getView().animate().alpha(1.0f).setDuration((long) (this.f20917h / 2));
                }
            }
        }
    }

    /* renamed from: a */
    public void mo30672a(boolean z, float f, int i, int i2, int i3) {
        mo30996a(i);
        RefreshHeader gVar = this.f20919j;
        RefreshKernel iVar = this.f20920k;
        if (gVar != null) {
            gVar.mo30672a(z, f, i, i2, i3);
        }
        if (z) {
            float f2 = this.f20911b;
            float f3 = this.f20913d;
            if (f2 < f3 && f >= f3 && this.f20915f) {
                iVar.mo30929a(RefreshState.ReleaseToTwoLevel);
            } else if (this.f20911b < this.f20913d || f >= this.f20914e) {
                float f4 = this.f20911b;
                float f5 = this.f20913d;
                if (f4 >= f5 && f < f5) {
                    iVar.mo30929a(RefreshState.ReleaseToRefresh);
                }
            } else {
                iVar.mo30929a(RefreshState.PullDownToRefresh);
            }
            this.f20911b = f;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo30996a(int i) {
        RefreshHeader gVar = this.f20919j;
        if (this.f20910a != i && gVar != null) {
            this.f20910a = i;
            int i2 = C65061.f20923b[gVar.getSpinnerStyle().ordinal()];
            if (i2 == 1) {
                gVar.getView().setTranslationY((float) i);
            } else if (i2 == 2) {
                View view = gVar.getView();
                view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getTop() + Math.max(0, i));
            }
        }
    }

    /* renamed from: a */
    public TwoLevelHeader mo30994a(RefreshHeader gVar) {
        return mo30995a(gVar, -1, -2);
    }

    /* renamed from: a */
    public TwoLevelHeader mo30995a(RefreshHeader gVar, int i, int i2) {
        if (gVar != null) {
            RefreshHeader gVar2 = this.f20919j;
            if (gVar2 != null) {
                removeView(gVar2.getView());
            }
            if (gVar.getSpinnerStyle() == SpinnerStyle.FixedBehind) {
                addView(gVar.getView(), 0, new LayoutParams(i, i2));
            } else {
                addView(gVar.getView(), i, i2);
            }
            this.f20919j = gVar;
            this.f20938ac = gVar;
        }
        return this;
    }
}
