package com.jiayouya.travel.databinding;

import android.view.View;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import ezy.p653ui.widget.round.RoundText;

public abstract class DialogTravelCityBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundText f10684a;
    @Bindable
    /* renamed from: b */
    protected String f10685b;

    /* renamed from: a */
    public abstract void mo20145a(String str);

    protected DialogTravelCityBinding(Object obj, View view, int i, RoundText roundText) {
        super(obj, view, i);
        this.f10684a = roundText;
    }
}
