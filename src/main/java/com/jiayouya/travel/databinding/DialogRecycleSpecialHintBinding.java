package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import ezy.p653ui.widget.round.RoundText;

public abstract class DialogRecycleSpecialHintBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundText f10600a;
    /* renamed from: b */
    public final ImageView f10601b;
    @Bindable
    /* renamed from: c */
    protected String f10602c;
    @Bindable
    /* renamed from: d */
    protected int f10603d;

    protected DialogRecycleSpecialHintBinding(Object obj, View view, int i, RoundText roundText, ImageView imageView) {
        super(obj, view, i);
        this.f10600a = roundText;
        this.f10601b = imageView;
    }
}
