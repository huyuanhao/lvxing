package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.jiayouya.travel.module.travel.data.MergeBonusDogItem;

public abstract class DialogMergeBonusDogBinding extends ViewDataBinding {
    /* renamed from: a */
    public final FrameLayout f10494a;
    /* renamed from: b */
    public final ImageView f10495b;
    @Bindable
    /* renamed from: c */
    protected MergeBonusDogItem f10496c;

    /* renamed from: a */
    public abstract void mo20130a(MergeBonusDogItem mergeBonusDogItem);

    protected DialogMergeBonusDogBinding(Object obj, View view, int i, FrameLayout frameLayout, ImageView imageView) {
        super(obj, view, i);
        this.f10494a = frameLayout;
        this.f10495b = imageView;
    }
}
