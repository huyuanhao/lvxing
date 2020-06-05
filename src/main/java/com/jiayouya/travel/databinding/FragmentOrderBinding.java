package com.jiayouya.travel.databinding;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public abstract class FragmentOrderBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RecyclerView f10767a;
    /* renamed from: b */
    public final SmartRefreshLayout f10768b;

    protected FragmentOrderBinding(Object obj, View view, int i, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout) {
        super(obj, view, i);
        this.f10767a = recyclerView;
        this.f10768b = smartRefreshLayout;
    }
}
