package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.jiayouya.travel.module.group.data.TargetRewards;
import ezy.p653ui.widget.round.RoundText;

public abstract class DialogAchieveGoalBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundText f10255a;
    /* renamed from: b */
    public final ImageView f10256b;
    @Bindable
    /* renamed from: c */
    protected TargetRewards f10257c;

    /* renamed from: a */
    public abstract void mo20104a(TargetRewards targetRewards);

    protected DialogAchieveGoalBinding(Object obj, View view, int i, RoundText roundText, ImageView imageView) {
        super(obj, view, i);
        this.f10255a = roundText;
        this.f10256b = imageView;
    }
}
