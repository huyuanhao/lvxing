package com.jiayouya.travel.databinding;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public abstract class FragmentInviteLogsBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RecyclerView f10745a;
    /* renamed from: b */
    public final SmartRefreshLayout f10746b;

    protected FragmentInviteLogsBinding(Object obj, View view, int i, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout) {
        super(obj, view, i);
        this.f10745a = recyclerView;
        this.f10746b = smartRefreshLayout;
    }
}
