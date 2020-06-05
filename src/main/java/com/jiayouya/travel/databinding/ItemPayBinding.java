package com.jiayouya.travel.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.jiayouya.travel.module.common.data.PayChannelItem;

public abstract class ItemPayBinding extends ViewDataBinding {
    @Bindable
    /* renamed from: a */
    protected PayChannelItem f11135a;
    @Bindable
    /* renamed from: b */
    protected OnClickListener f11136b;

    protected ItemPayBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }
}
