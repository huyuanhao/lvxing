package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.jiayouya.travel.module.assets.data.CashConfig;
import ezy.p653ui.widget.round.RoundText;

public abstract class ActivityCashBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundText f9928a;
    /* renamed from: b */
    public final RecyclerView f9929b;
    /* renamed from: c */
    public final RecyclerView f9930c;
    /* renamed from: d */
    public final LinearLayout f9931d;
    /* renamed from: e */
    public final TextView f9932e;
    /* renamed from: f */
    public final TextView f9933f;
    @Bindable
    /* renamed from: g */
    protected CashConfig f9934g;

    /* renamed from: a */
    public abstract void mo20082a(CashConfig cashConfig);

    protected ActivityCashBinding(Object obj, View view, int i, RoundText roundText, RecyclerView recyclerView, RecyclerView recyclerView2, LinearLayout linearLayout, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f9928a = roundText;
        this.f9929b = recyclerView;
        this.f9930c = recyclerView2;
        this.f9931d = linearLayout;
        this.f9932e = textView;
        this.f9933f = textView2;
    }

    /* renamed from: a */
    public CashConfig mo20081a() {
        return this.f9934g;
    }
}
