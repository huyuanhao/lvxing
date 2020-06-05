package com.jiayouya.travel.databinding;

import android.view.View;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.jiayouya.travel.module.answer.data.AnswerErrorItem;

public abstract class ItemAnswerWrongBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RecyclerView f10898a;
    @Bindable
    /* renamed from: b */
    protected AnswerErrorItem f10899b;

    protected ItemAnswerWrongBinding(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f10898a = recyclerView;
    }
}
