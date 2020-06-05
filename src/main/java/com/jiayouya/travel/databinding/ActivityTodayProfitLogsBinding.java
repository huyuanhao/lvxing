package com.jiayouya.travel.databinding;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public abstract class ActivityTodayProfitLogsBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RecyclerView f10233a;
    /* renamed from: b */
    public final SmartRefreshLayout f10234b;

    protected ActivityTodayProfitLogsBinding(Object obj, View view, int i, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout) {
        super(obj, view, i);
        this.f10233a = recyclerView;
        this.f10234b = smartRefreshLayout;
    }
}
