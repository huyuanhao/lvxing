package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import ezy.p653ui.widget.round.RoundText;

public abstract class DialogWarehouseBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundText f10711a;
    /* renamed from: b */
    public final RoundText f10712b;
    /* renamed from: c */
    public final FrameLayout f10713c;
    /* renamed from: d */
    public final ImageView f10714d;
    /* renamed from: e */
    public final RecyclerView f10715e;
    /* renamed from: f */
    public final ConstraintLayout f10716f;
    @Bindable
    /* renamed from: g */
    protected String f10717g;

    /* renamed from: a */
    public abstract void mo20148a(String str);

    protected DialogWarehouseBinding(Object obj, View view, int i, RoundText roundText, RoundText roundText2, FrameLayout frameLayout, ImageView imageView, RecyclerView recyclerView, ConstraintLayout constraintLayout) {
        super(obj, view, i);
        this.f10711a = roundText;
        this.f10712b = roundText2;
        this.f10713c = frameLayout;
        this.f10714d = imageView;
        this.f10715e = recyclerView;
        this.f10716f = constraintLayout;
    }
}
