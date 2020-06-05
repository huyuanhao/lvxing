package com.jiayouya.travel.databinding;

import android.view.View;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import ezy.p653ui.widget.round.RoundText;

public abstract class DialogRealNameAuthFailBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundText f10577a;
    @Bindable
    /* renamed from: b */
    protected String f10578b;

    /* renamed from: a */
    public abstract void mo20136a(String str);

    protected DialogRealNameAuthFailBinding(Object obj, View view, int i, RoundText roundText) {
        super(obj, view, i);
        this.f10577a = roundText;
    }
}
