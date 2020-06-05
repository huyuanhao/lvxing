package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.jiayouya.travel.common.widget.RndCornerProgressBar;
import com.jiayouya.travel.module.group.data.GroupIndexRsp;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import ezy.p653ui.widget.round.RoundText;

public abstract class FragmentTourGroupBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundText f10789a;
    /* renamed from: b */
    public final RoundText f10790b;
    /* renamed from: c */
    public final LinearLayout f10791c;
    /* renamed from: d */
    public final RndCornerProgressBar f10792d;
    /* renamed from: e */
    public final SmartRefreshLayout f10793e;
    /* renamed from: f */
    public final Space f10794f;
    /* renamed from: g */
    public final View f10795g;
    /* renamed from: h */
    public final TextView f10796h;
    /* renamed from: i */
    public final TextView f10797i;
    /* renamed from: j */
    public final TextView f10798j;
    /* renamed from: k */
    public final TextView f10799k;
    /* renamed from: l */
    public final TextView f10800l;
    /* renamed from: m */
    public final TextView f10801m;
    /* renamed from: n */
    public final TextView f10802n;
    /* renamed from: o */
    public final TextView f10803o;
    /* renamed from: p */
    public final TextView f10804p;
    @Bindable
    /* renamed from: q */
    protected GroupIndexRsp f10805q;

    /* renamed from: a */
    public abstract void mo20154a(GroupIndexRsp groupIndexRsp);

    protected FragmentTourGroupBinding(Object obj, View view, int i, RoundText roundText, RoundText roundText2, LinearLayout linearLayout, RndCornerProgressBar rndCornerProgressBar, SmartRefreshLayout smartRefreshLayout, Space space, View view2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9) {
        super(obj, view, i);
        this.f10789a = roundText;
        this.f10790b = roundText2;
        this.f10791c = linearLayout;
        this.f10792d = rndCornerProgressBar;
        this.f10793e = smartRefreshLayout;
        this.f10794f = space;
        this.f10795g = view2;
        this.f10796h = textView;
        this.f10797i = textView2;
        this.f10798j = textView3;
        this.f10799k = textView4;
        this.f10800l = textView5;
        this.f10801m = textView6;
        this.f10802n = textView7;
        this.f10803o = textView8;
        this.f10804p = textView9;
    }

    /* renamed from: a */
    public GroupIndexRsp mo20153a() {
        return this.f10805q;
    }
}
