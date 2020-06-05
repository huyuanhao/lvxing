package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.jiayouya.travel.module.common.widget.round.widget.GeneralRoundLinearLayout;
import ezy.p653ui.widget.round.RoundText;

public abstract class DialogDoubleCoinBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundText f10370a;
    /* renamed from: b */
    public final TextView f10371b;
    /* renamed from: c */
    public final ImageView f10372c;
    /* renamed from: d */
    public final GeneralRoundLinearLayout f10373d;
    /* renamed from: e */
    public final TextView f10374e;
    @Bindable
    /* renamed from: f */
    protected boolean f10375f;

    /* renamed from: a */
    public abstract void mo20115a(boolean z);

    protected DialogDoubleCoinBinding(Object obj, View view, int i, RoundText roundText, TextView textView, ImageView imageView, GeneralRoundLinearLayout generalRoundLinearLayout, TextView textView2) {
        super(obj, view, i);
        this.f10370a = roundText;
        this.f10371b = textView;
        this.f10372c = imageView;
        this.f10373d = generalRoundLinearLayout;
        this.f10374e = textView2;
    }
}
