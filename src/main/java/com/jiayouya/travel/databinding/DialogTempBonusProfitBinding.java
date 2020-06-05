package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.jiayouya.travel.module.travel.data.LuckDog;
import ezy.p653ui.widget.round.RoundText;

public abstract class DialogTempBonusProfitBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundText f10666a;
    /* renamed from: b */
    public final ImageView f10667b;
    /* renamed from: c */
    public final TextView f10668c;
    @Bindable
    /* renamed from: d */
    protected LuckDog f10669d;

    /* renamed from: a */
    public abstract void mo20144a(LuckDog luckDog);

    protected DialogTempBonusProfitBinding(Object obj, View view, int i, RoundText roundText, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.f10666a = roundText;
        this.f10667b = imageView;
        this.f10668c = textView;
    }
}
