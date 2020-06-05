package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import ezy.p653ui.widget.round.RoundText;

public abstract class ActivityRealNameAuthBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundText f10159a;
    /* renamed from: b */
    public final FrameLayout f10160b;
    @Bindable
    /* renamed from: c */
    protected boolean f10161c;

    /* renamed from: a */
    public abstract void mo20099a(boolean z);

    protected ActivityRealNameAuthBinding(Object obj, View view, int i, RoundText roundText, FrameLayout frameLayout) {
        super(obj, view, i);
        this.f10159a = roundText;
        this.f10160b = frameLayout;
    }
}
