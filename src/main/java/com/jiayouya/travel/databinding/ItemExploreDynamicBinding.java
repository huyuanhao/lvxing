package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.jiayouya.travel.module.explore.data.DynamicItem;

public abstract class ItemExploreDynamicBinding extends ViewDataBinding {
    /* renamed from: a */
    public final ImageView f10991a;
    /* renamed from: b */
    public final TextView f10992b;
    /* renamed from: c */
    public final TextView f10993c;
    @Bindable
    /* renamed from: d */
    protected DynamicItem f10994d;

    protected ItemExploreDynamicBinding(Object obj, View view, int i, ImageView imageView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f10991a = imageView;
        this.f10992b = textView;
        this.f10993c = textView2;
    }
}
