package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class DialogDogShopBinding extends ViewDataBinding {
    /* renamed from: a */
    public final ImageView f10349a;
    /* renamed from: b */
    public final RecyclerView f10350b;
    /* renamed from: c */
    public final TextView f10351c;

    protected DialogDogShopBinding(Object obj, View view, int i, ImageView imageView, RecyclerView recyclerView, TextView textView) {
        super(obj, view, i);
        this.f10349a = imageView;
        this.f10350b = recyclerView;
        this.f10351c = textView;
    }
}
