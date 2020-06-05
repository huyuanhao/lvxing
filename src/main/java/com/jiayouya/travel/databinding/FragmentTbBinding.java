package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import ezy.p653ui.widget.round.RoundText;

public abstract class FragmentTbBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundText f10779a;
    /* renamed from: b */
    public final RecyclerView f10780b;
    /* renamed from: c */
    public final SmartRefreshLayout f10781c;
    /* renamed from: d */
    public final TextView f10782d;
    /* renamed from: e */
    public final TextView f10783e;

    protected FragmentTbBinding(Object obj, View view, int i, RoundText roundText, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f10779a = roundText;
        this.f10780b = recyclerView;
        this.f10781c = smartRefreshLayout;
        this.f10782d = textView;
        this.f10783e = textView2;
    }
}
