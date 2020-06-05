package com.jiayouya.travel.databinding;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import ezy.p653ui.widget.CenteredTitleBar;

public abstract class ActivityDynamicBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RecyclerView f9959a;
    /* renamed from: b */
    public final SmartRefreshLayout f9960b;
    /* renamed from: c */
    public final CenteredTitleBar f9961c;

    protected ActivityDynamicBinding(Object obj, View view, int i, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, CenteredTitleBar centeredTitleBar) {
        super(obj, view, i);
        this.f9959a = recyclerView;
        this.f9960b = smartRefreshLayout;
        this.f9961c = centeredTitleBar;
    }
}
