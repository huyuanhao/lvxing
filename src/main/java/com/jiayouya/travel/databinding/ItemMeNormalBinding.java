package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.jiayouya.travel.module.p276me.data.MeItem;

public abstract class ItemMeNormalBinding extends ViewDataBinding {
    /* renamed from: a */
    public final View f11075a;
    /* renamed from: b */
    public final TextView f11076b;
    @Bindable
    /* renamed from: c */
    protected MeItem f11077c;

    protected ItemMeNormalBinding(Object obj, View view, int i, View view2, TextView textView) {
        super(obj, view, i);
        this.f11075a = view2;
        this.f11076b = textView;
    }
}
