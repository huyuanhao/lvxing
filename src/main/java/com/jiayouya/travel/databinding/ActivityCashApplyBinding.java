package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.ScrollView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.jiayouya.travel.module.assets.data.CashApplyRsp;
import ezy.p653ui.widget.CenteredTitleBar;
import ezy.p653ui.widget.round.RoundText;

public abstract class ActivityCashApplyBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundText f9916a;
    /* renamed from: b */
    public final ScrollView f9917b;
    /* renamed from: c */
    public final CenteredTitleBar f9918c;
    @Bindable
    /* renamed from: d */
    protected CashApplyRsp f9919d;

    /* renamed from: a */
    public abstract void mo20080a(CashApplyRsp cashApplyRsp);

    protected ActivityCashApplyBinding(Object obj, View view, int i, RoundText roundText, ScrollView scrollView, CenteredTitleBar centeredTitleBar) {
        super(obj, view, i);
        this.f9916a = roundText;
        this.f9917b = scrollView;
        this.f9918c = centeredTitleBar;
    }
}
