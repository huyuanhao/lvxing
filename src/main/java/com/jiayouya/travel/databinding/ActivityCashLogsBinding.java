package com.jiayouya.travel.databinding;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public abstract class ActivityCashLogsBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RecyclerView f9944a;
    /* renamed from: b */
    public final SmartRefreshLayout f9945b;

    protected ActivityCashLogsBinding(Object obj, View view, int i, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout) {
        super(obj, view, i);
        this.f9944a = recyclerView;
        this.f9945b = smartRefreshLayout;
    }
}
