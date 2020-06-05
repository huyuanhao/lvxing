package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import ezy.p653ui.widget.round.RoundText;

public abstract class DialogTaobaoAuthBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundText f10632a;
    /* renamed from: b */
    public final ImageView f10633b;
    /* renamed from: c */
    public final LinearLayout f10634c;

    protected DialogTaobaoAuthBinding(Object obj, View view, int i, RoundText roundText, ImageView imageView, LinearLayout linearLayout) {
        super(obj, view, i);
        this.f10632a = roundText;
        this.f10633b = imageView;
        this.f10634c = linearLayout;
    }
}
