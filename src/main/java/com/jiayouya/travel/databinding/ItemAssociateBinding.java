package com.jiayouya.travel.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;

public abstract class ItemAssociateBinding extends ViewDataBinding {
    /* renamed from: a */
    public final TextView f10910a;
    @Bindable
    /* renamed from: b */
    protected OnClickListener f10911b;
    @Bindable
    /* renamed from: c */
    protected String f10912c;

    protected ItemAssociateBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.f10910a = textView;
    }
}
