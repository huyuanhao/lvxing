package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.jiayouya.travel.module.travel.data.ExpandPrice;
import ezy.p653ui.widget.round.RoundText;

public abstract class DialogBuyCapacityBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundText f10282a;
    /* renamed from: b */
    public final ImageView f10283b;
    @Bindable
    /* renamed from: c */
    protected ExpandPrice f10284c;

    /* renamed from: a */
    public abstract void mo20107a(ExpandPrice expandPrice);

    protected DialogBuyCapacityBinding(Object obj, View view, int i, RoundText roundText, ImageView imageView) {
        super(obj, view, i);
        this.f10282a = roundText;
        this.f10283b = imageView;
    }

    /* renamed from: a */
    public ExpandPrice mo20106a() {
        return this.f10284c;
    }
}
