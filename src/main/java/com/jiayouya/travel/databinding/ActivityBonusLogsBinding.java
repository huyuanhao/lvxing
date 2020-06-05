package com.jiayouya.travel.databinding;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public abstract class ActivityBonusLogsBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RecyclerView f9910a;
    /* renamed from: b */
    public final SmartRefreshLayout f9911b;

    protected ActivityBonusLogsBinding(Object obj, View view, int i, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout) {
        super(obj, view, i);
        this.f9910a = recyclerView;
        this.f9911b = smartRefreshLayout;
    }
}
