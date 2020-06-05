package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.jiayouya.travel.module.common.data.User;
import ezy.p653ui.widget.round.RoundText;

public abstract class DialogInviterHintBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundText f10462a;
    /* renamed from: b */
    public final ImageView f10463b;
    @Bindable
    /* renamed from: c */
    protected User f10464c;

    /* renamed from: a */
    public abstract void mo20125a(User user);

    protected DialogInviterHintBinding(Object obj, View view, int i, RoundText roundText, ImageView imageView) {
        super(obj, view, i);
        this.f10462a = roundText;
        this.f10463b = imageView;
    }
}
