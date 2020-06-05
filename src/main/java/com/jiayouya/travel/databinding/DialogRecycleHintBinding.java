package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import ezy.p653ui.widget.round.RoundText;

public abstract class DialogRecycleHintBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundText f10590a;
    /* renamed from: b */
    public final ImageView f10591b;
    @Bindable
    /* renamed from: c */
    protected int f10592c;
    @Bindable
    /* renamed from: d */
    protected String f10593d;

    /* renamed from: a */
    public abstract void mo20137a(int i);

    /* renamed from: a */
    public abstract void mo20138a(String str);

    protected DialogRecycleHintBinding(Object obj, View view, int i, RoundText roundText, ImageView imageView) {
        super(obj, view, i);
        this.f10590a = roundText;
        this.f10591b = imageView;
    }
}
