package com.jiayouya.travel.databinding;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public abstract class FragmentProfitRankListBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RecyclerView f10773a;
    /* renamed from: b */
    public final SmartRefreshLayout f10774b;

    protected FragmentProfitRankListBinding(Object obj, View view, int i, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout) {
        super(obj, view, i);
        this.f10773a = recyclerView;
        this.f10774b = smartRefreshLayout;
    }
}
