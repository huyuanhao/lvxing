package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import ezy.p653ui.widget.round.RoundText;

public abstract class DialogRecallBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundText f10584a;
    /* renamed from: b */
    public final ImageView f10585b;

    protected DialogRecallBinding(Object obj, View view, int i, RoundText roundText, ImageView imageView) {
        super(obj, view, i);
        this.f10584a = roundText;
        this.f10585b = imageView;
    }
}
