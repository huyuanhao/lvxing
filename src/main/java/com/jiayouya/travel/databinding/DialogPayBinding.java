package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class DialogPayBinding extends ViewDataBinding {
    /* renamed from: a */
    public final ImageView f10552a;
    /* renamed from: b */
    public final RecyclerView f10553b;
    /* renamed from: c */
    public final LinearLayout f10554c;
    @Bindable
    /* renamed from: d */
    protected String f10555d;

    protected DialogPayBinding(Object obj, View view, int i, ImageView imageView, RecyclerView recyclerView, LinearLayout linearLayout) {
        super(obj, view, i);
        this.f10552a = imageView;
        this.f10553b = recyclerView;
        this.f10554c = linearLayout;
    }
}
