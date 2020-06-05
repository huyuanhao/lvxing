package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;

public abstract class ActivityAboutUsBinding extends ViewDataBinding {
    /* renamed from: a */
    public final LinearLayout f9809a;
    /* renamed from: b */
    public final LinearLayout f9810b;
    /* renamed from: c */
    public final LinearLayout f9811c;
    @Bindable
    /* renamed from: d */
    protected String f9812d;
    @Bindable
    /* renamed from: e */
    protected int f9813e;

    /* renamed from: a */
    public abstract void mo20068a(int i);

    /* renamed from: a */
    public abstract void mo20069a(String str);

    protected ActivityAboutUsBinding(Object obj, View view, int i, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3) {
        super(obj, view, i);
        this.f9809a = linearLayout;
        this.f9810b = linearLayout2;
        this.f9811c = linearLayout3;
    }
}
