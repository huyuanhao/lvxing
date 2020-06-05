package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import ezy.p653ui.widget.round.RoundText;

public abstract class ActivityInviteLogsBinding extends ViewDataBinding {
    /* renamed from: a */
    public final LinearLayout f10026a;
    /* renamed from: b */
    public final RoundText f10027b;
    /* renamed from: c */
    public final TextView f10028c;
    /* renamed from: d */
    public final TextView f10029d;
    /* renamed from: e */
    public final ViewPager f10030e;

    protected ActivityInviteLogsBinding(Object obj, View view, int i, LinearLayout linearLayout, RoundText roundText, TextView textView, TextView textView2, ViewPager viewPager) {
        super(obj, view, i);
        this.f10026a = linearLayout;
        this.f10027b = roundText;
        this.f10028c = textView;
        this.f10029d = textView2;
        this.f10030e = viewPager;
    }
}
