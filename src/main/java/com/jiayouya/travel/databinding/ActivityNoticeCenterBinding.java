package com.jiayouya.travel.databinding;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public abstract class ActivityNoticeCenterBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RecyclerView f10091a;
    /* renamed from: b */
    public final SmartRefreshLayout f10092b;

    protected ActivityNoticeCenterBinding(Object obj, View view, int i, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout) {
        super(obj, view, i);
        this.f10091a = recyclerView;
        this.f10092b = smartRefreshLayout;
    }
}
