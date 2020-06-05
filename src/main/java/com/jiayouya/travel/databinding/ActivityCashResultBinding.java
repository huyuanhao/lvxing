package com.jiayouya.travel.databinding;

import android.view.View;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import ezy.p653ui.widget.round.RoundText;

public abstract class ActivityCashResultBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundText f9950a;
    @Bindable
    /* renamed from: b */
    protected boolean f9951b;

    /* renamed from: a */
    public abstract void mo20083a(boolean z);

    protected ActivityCashResultBinding(Object obj, View view, int i, RoundText roundText) {
        super(obj, view, i);
        this.f9950a = roundText;
    }
}
