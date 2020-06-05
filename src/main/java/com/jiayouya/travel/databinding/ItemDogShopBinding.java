package com.jiayouya.travel.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.jiayouya.travel.module.travel.data.DogShopItem;

public abstract class ItemDogShopBinding extends ViewDataBinding {
    /* renamed from: a */
    public final LinearLayout f10962a;
    @Bindable
    /* renamed from: b */
    protected DogShopItem f10963b;
    @Bindable
    /* renamed from: c */
    protected OnClickListener f10964c;

    protected ItemDogShopBinding(Object obj, View view, int i, LinearLayout linearLayout) {
        super(obj, view, i);
        this.f10962a = linearLayout;
    }
}
