package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.jiayouya.travel.module.travel.data.UnlockCity;
import ezy.p653ui.widget.round.RoundText;

public abstract class DialogUnlockCityBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundText f10691a;
    /* renamed from: b */
    public final ImageView f10692b;
    @Bindable
    /* renamed from: c */
    protected UnlockCity f10693c;

    /* renamed from: a */
    public abstract void mo20146a(UnlockCity unlockCity);

    protected DialogUnlockCityBinding(Object obj, View view, int i, RoundText roundText, ImageView imageView) {
        super(obj, view, i);
        this.f10691a = roundText;
        this.f10692b = imageView;
    }
}
