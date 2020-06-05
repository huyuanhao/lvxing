package com.jiayouya.travel.databinding;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public abstract class FragmentCoinRankListBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RecyclerView f10733a;
    /* renamed from: b */
    public final SmartRefreshLayout f10734b;

    protected FragmentCoinRankListBinding(Object obj, View view, int i, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout) {
        super(obj, view, i);
        this.f10733a = recyclerView;
        this.f10734b = smartRefreshLayout;
    }
}
