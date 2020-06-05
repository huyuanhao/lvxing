package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.jiayouya.travel.module.travel.data.Extra;
import ezy.p653ui.widget.round.RoundText;

public abstract class DialogTempBonusDogBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundText f10654a;
    /* renamed from: b */
    public final TextView f10655b;
    @Bindable
    /* renamed from: c */
    protected Extra f10656c;

    /* renamed from: a */
    public abstract void mo20143a(Extra extra);

    protected DialogTempBonusDogBinding(Object obj, View view, int i, RoundText roundText, TextView textView) {
        super(obj, view, i);
        this.f10654a = roundText;
        this.f10655b = textView;
    }
}
