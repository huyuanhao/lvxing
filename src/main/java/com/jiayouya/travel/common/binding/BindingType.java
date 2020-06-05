package com.jiayouya.travel.common.binding;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import ezy.p653ui.widget.recyclerview.holder.ItemType;

public class BindingType extends ItemType<Object, ClickableBindingHolder> {
    private OnBindListener onBind;
    private OnItemClickListener onItemClick;

    public static BindingType create(Class cls, int i, int i2) {
        return new BindingType(cls, i, i2);
    }

    public static BindingType create(Class cls, int i) {
        return new BindingType(cls, i, i);
    }

    public BindingType(Class cls, Class cls2, int i) {
        super(cls, cls2, i, i);
    }

    public BindingType(Class cls, int i, int i2) {
        super(ClickableBindingHolder.class, cls, i, i2);
    }

    public BindingType setOnItemClick(OnItemClickListener bVar) {
        this.onItemClick = bVar;
        return this;
    }

    public BindingType setOnItemBind(OnBindListener aVar) {
        this.onBind = aVar;
        return this;
    }

    public ClickableBindingHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        ClickableBindingHolder clickableBindingHolder = (ClickableBindingHolder) super.create(layoutInflater, viewGroup);
        clickableBindingHolder.onItemClick = this.onItemClick;
        return clickableBindingHolder;
    }

    public void bind(ClickableBindingHolder clickableBindingHolder, Object obj) {
        OnBindListener aVar = this.onBind;
        if (aVar != null) {
            aVar.mo19911a(clickableBindingHolder, obj);
        }
        clickableBindingHolder.binding.setVariable(19, obj);
        clickableBindingHolder.binding.executePendingBindings();
    }
}
