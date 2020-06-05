package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import ezy.p653ui.widget.round.RoundText;

public abstract class DialogUpgradeChannelBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundText f10703a;
    /* renamed from: b */
    public final ImageView f10704b;
    @Bindable
    /* renamed from: c */
    protected String f10705c;

    /* renamed from: a */
    public abstract void mo20147a(String str);

    protected DialogUpgradeChannelBinding(Object obj, View view, int i, RoundText roundText, ImageView imageView) {
        super(obj, view, i);
        this.f10703a = roundText;
        this.f10704b = imageView;
    }
}
