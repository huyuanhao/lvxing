package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class DialogShareBinding extends ViewDataBinding {
    /* renamed from: a */
    public final ImageView f10616a;
    /* renamed from: b */
    public final TextView f10617b;
    /* renamed from: c */
    public final TextView f10618c;
    /* renamed from: d */
    public final RecyclerView f10619d;

    protected DialogShareBinding(Object obj, View view, int i, ImageView imageView, TextView textView, TextView textView2, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f10616a = imageView;
        this.f10617b = textView;
        this.f10618c = textView2;
        this.f10619d = recyclerView;
    }
}
