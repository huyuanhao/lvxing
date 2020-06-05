package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.jiayouya.travel.module.travel.data.TempBonusItem;

public abstract class DialogTempBonusBinding extends ViewDataBinding {
    /* renamed from: a */
    public final ImageView f10643a;
    /* renamed from: b */
    public final TextView f10644b;
    @Bindable
    /* renamed from: c */
    protected TempBonusItem f10645c;

    /* renamed from: a */
    public abstract void mo20142a(TempBonusItem tempBonusItem);

    protected DialogTempBonusBinding(Object obj, View view, int i, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.f10643a = imageView;
        this.f10644b = textView;
    }
}
