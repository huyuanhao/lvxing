package com.qiyukf.unicorn.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.qiyukf.unicorn.C5961R;

public class MultipleStatusLayout extends FrameLayout {
    /* renamed from: a */
    private View f19806a;
    /* renamed from: b */
    private View f19807b;
    /* renamed from: c */
    private View f19808c;
    /* renamed from: d */
    private View f19809d;
    /* renamed from: e */
    private View f19810e;
    /* renamed from: f */
    private int f19811f;
    /* renamed from: g */
    private int f19812g;
    /* renamed from: h */
    private int f19813h;
    /* renamed from: i */
    private int f19814i;
    /* renamed from: j */
    private int f19815j;
    /* renamed from: k */
    private int f19816k;
    /* renamed from: l */
    private LayoutInflater f19817l;
    /* renamed from: m */
    private final LayoutParams f19818m;

    public MultipleStatusLayout(Context context) {
        this(context, null);
    }

    public MultipleStatusLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultipleStatusLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19818m = new LayoutParams(-1, -1);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C5961R.styleable.MultipleStatusLayout, i, 0);
        this.f19811f = obtainStyledAttributes.getResourceId(C5961R.styleable.MultipleStatusLayout_emptyView, C5961R.C5964layout.ysf_layout_msl_default_empty);
        this.f19812g = obtainStyledAttributes.getResourceId(C5961R.styleable.MultipleStatusLayout_errorView, C5961R.C5964layout.ysf_layout_msl_default_error);
        this.f19813h = obtainStyledAttributes.getResourceId(C5961R.styleable.MultipleStatusLayout_loadingView, C5961R.C5964layout.ysf_layout_msl_default_loading);
        this.f19814i = obtainStyledAttributes.getResourceId(C5961R.styleable.MultipleStatusLayout_noNetworkView, C5961R.C5964layout.ysf_layout_msl_default_no_network);
        this.f19815j = obtainStyledAttributes.getResourceId(C5961R.styleable.MultipleStatusLayout_customView, -1);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f19817l = LayoutInflater.from(getContext());
        int i = 0;
        this.f19816k = 0;
        int i2 = this.f19816k;
        View view = this.f19808c;
        if (view != null) {
            view.setVisibility(i2 == 1 ? 0 : 8);
        }
        View view2 = this.f19806a;
        if (view2 != null) {
            view2.setVisibility(i2 == 2 ? 0 : 8);
        }
        View view3 = this.f19807b;
        if (view3 != null) {
            view3.setVisibility(i2 == 3 ? 0 : 8);
        }
        View view4 = this.f19809d;
        if (view4 != null) {
            view4.setVisibility(i2 == 4 ? 0 : 8);
        }
        View view5 = this.f19810e;
        if (view5 != null) {
            if (i2 != 5) {
                i = 8;
            }
            view5.setVisibility(i);
        }
    }
}
