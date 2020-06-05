package com.jiayouya.travel.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.jiayouya.travel.module.group.data.RewardItem;

public abstract class ItemMapBinding extends ViewDataBinding {
    /* renamed from: a */
    public final TextView f11055a;
    @Bindable
    /* renamed from: b */
    protected RewardItem f11056b;
    @Bindable
    /* renamed from: c */
    protected OnClickListener f11057c;

    protected ItemMapBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.f11055a = textView;
    }
}
