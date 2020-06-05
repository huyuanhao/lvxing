package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;

public abstract class LayoutTabBinding extends ViewDataBinding {
    /* renamed from: a */
    public final TextView f11202a;
    @Bindable
    /* renamed from: b */
    protected int f11203b;
    @Bindable
    /* renamed from: c */
    protected String f11204c;

    /* renamed from: a */
    public abstract void mo20207a(String str);

    protected LayoutTabBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.f11202a = textView;
    }
}
