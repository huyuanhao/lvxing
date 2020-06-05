package com.jiayouya.travel.databinding;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public abstract class ActivityHandbookBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RecyclerView f10006a;
    /* renamed from: b */
    public final SmartRefreshLayout f10007b;

    protected ActivityHandbookBinding(Object obj, View view, int i, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout) {
        super(obj, view, i);
        this.f10006a = recyclerView;
        this.f10007b = smartRefreshLayout;
    }
}
