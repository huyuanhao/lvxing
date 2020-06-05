package com.jiayouya.travel.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.jiayouya.travel.module.answer.data.AnswerItem;

public abstract class ItemAnswerBinding extends ViewDataBinding {
    @Bindable
    /* renamed from: a */
    protected AnswerItem f10890a;
    @Bindable
    /* renamed from: b */
    protected OnClickListener f10891b;

    protected ItemAnswerBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }
}
