package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import ezy.p653ui.widget.round.RoundLayout;

public abstract class ActivityLoginBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundLayout f10036a;
    /* renamed from: b */
    public final ImageView f10037b;
    /* renamed from: c */
    public final View f10038c;
    /* renamed from: d */
    public final TextView f10039d;
    /* renamed from: e */
    public final TextView f10040e;
    /* renamed from: f */
    public final TextView f10041f;
    @Bindable
    /* renamed from: g */
    protected int f10042g;

    /* renamed from: a */
    public abstract void mo20089a(int i);

    protected ActivityLoginBinding(Object obj, View view, int i, RoundLayout roundLayout, ImageView imageView, View view2, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.f10036a = roundLayout;
        this.f10037b = imageView;
        this.f10038c = view2;
        this.f10039d = textView;
        this.f10040e = textView2;
        this.f10041f = textView3;
    }
}
