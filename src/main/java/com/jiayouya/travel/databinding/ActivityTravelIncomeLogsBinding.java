package com.jiayouya.travel.databinding;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public abstract class ActivityTravelIncomeLogsBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RecyclerView f10240a;
    /* renamed from: b */
    public final SmartRefreshLayout f10241b;

    protected ActivityTravelIncomeLogsBinding(Object obj, View view, int i, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout) {
        super(obj, view, i);
        this.f10240a = recyclerView;
        this.f10241b = smartRefreshLayout;
    }
}
