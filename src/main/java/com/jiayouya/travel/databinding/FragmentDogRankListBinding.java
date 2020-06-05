package com.jiayouya.travel.databinding;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public abstract class FragmentDogRankListBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RecyclerView f10739a;
    /* renamed from: b */
    public final SmartRefreshLayout f10740b;

    protected FragmentDogRankListBinding(Object obj, View view, int i, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout) {
        super(obj, view, i);
        this.f10739a = recyclerView;
        this.f10740b = smartRefreshLayout;
    }
}
