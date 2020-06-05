package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public abstract class ActivityOrderDetailsBinding extends ViewDataBinding {
    /* renamed from: a */
    public final ImageView f10109a;
    /* renamed from: b */
    public final SmartRefreshLayout f10110b;
    /* renamed from: c */
    public final TextView f10111c;
    /* renamed from: d */
    public final TextView f10112d;
    /* renamed from: e */
    public final TextView f10113e;

    protected ActivityOrderDetailsBinding(Object obj, View view, int i, ImageView imageView, SmartRefreshLayout smartRefreshLayout, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.f10109a = imageView;
        this.f10110b = smartRefreshLayout;
        this.f10111c = textView;
        this.f10112d = textView2;
        this.f10113e = textView3;
    }
}
