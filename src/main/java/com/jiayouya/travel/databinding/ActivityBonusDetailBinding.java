package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.jiayouya.travel.module.p276me.data.BonusDetailRsp;

public abstract class ActivityBonusDetailBinding extends ViewDataBinding {
    /* renamed from: a */
    public final ScrollView f9865a;
    /* renamed from: b */
    public final TextView f9866b;
    @Bindable
    /* renamed from: c */
    protected BonusDetailRsp f9867c;

    /* renamed from: a */
    public abstract void mo20078a(BonusDetailRsp bonusDetailRsp);

    protected ActivityBonusDetailBinding(Object obj, View view, int i, ScrollView scrollView, TextView textView) {
        super(obj, view, i);
        this.f9865a = scrollView;
        this.f9866b = textView;
    }
}
