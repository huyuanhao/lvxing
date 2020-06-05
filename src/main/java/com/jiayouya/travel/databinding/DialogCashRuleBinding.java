package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import ezy.p653ui.widget.round.RoundText;

public abstract class DialogCashRuleBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundText f10290a;
    /* renamed from: b */
    public final ImageView f10291b;
    /* renamed from: c */
    public final RecyclerView f10292c;

    protected DialogCashRuleBinding(Object obj, View view, int i, RoundText roundText, ImageView imageView, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f10290a = roundText;
        this.f10291b = imageView;
        this.f10292c = recyclerView;
    }
}
