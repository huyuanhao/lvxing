package com.jiayouya.travel.common.binding;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import ezy.p653ui.widget.recyclerview.holder.ItemHolder;

public class ClickableBindingHolder<Binding extends ViewDataBinding> extends ItemHolder implements OnClickListener {
    public final Binding binding;
    public OnItemClickListener onItemClick;

    public ClickableBindingHolder(View view) {
        super(view);
        this.binding = DataBindingUtil.bind(view);
        this.binding.setVariable(2, this);
    }

    public void onClick(View view) {
        OnItemClickListener bVar = this.onItemClick;
        if (bVar != null) {
            bVar.mo19912a(view, getLayoutPosition(), getItemId());
        }
    }
}
