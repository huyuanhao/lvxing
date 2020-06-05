package com.jiayouya.travel.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.jiayouya.travel.module.p281tb.widget.CircleProgressBar;
import p641de.hdodenhof.circleimageview.CircleImageView;

public abstract class ItemOrderCoinBinding extends ViewDataBinding {
    /* renamed from: a */
    public final CircleImageView f11126a;
    /* renamed from: b */
    public final ImageView f11127b;
    /* renamed from: c */
    public final CircleProgressBar f11128c;
    /* renamed from: d */
    public final TextView f11129d;
    @Bindable
    /* renamed from: e */
    protected OnClickListener f11130e;

    protected ItemOrderCoinBinding(Object obj, View view, int i, CircleImageView circleImageView, ImageView imageView, CircleProgressBar circleProgressBar, TextView textView) {
        super(obj, view, i);
        this.f11126a = circleImageView;
        this.f11127b = imageView;
        this.f11128c = circleProgressBar;
        this.f11129d = textView;
    }
}
