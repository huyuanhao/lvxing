package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import ezy.p653ui.widget.round.RoundText;

public abstract class DialogGetDogBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundText f10417a;
    /* renamed from: b */
    public final RoundText f10418b;
    /* renamed from: c */
    public final ImageView f10419c;
    @Bindable
    /* renamed from: d */
    protected int f10420d;

    /* renamed from: a */
    public abstract void mo20118a(int i);

    protected DialogGetDogBinding(Object obj, View view, int i, RoundText roundText, RoundText roundText2, ImageView imageView) {
        super(obj, view, i);
        this.f10417a = roundText;
        this.f10418b = roundText2;
        this.f10419c = imageView;
    }
}
