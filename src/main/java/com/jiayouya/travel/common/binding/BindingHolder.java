package com.jiayouya.travel.common.binding;

import android.view.View;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import ezy.p653ui.widget.recyclerview.holder.ItemHolder;

public class BindingHolder<Binding extends ViewDataBinding> extends ItemHolder {
    public final Binding binding;

    public BindingHolder(View view) {
        super(view);
        this.binding = DataBindingUtil.bind(view);
    }
}
