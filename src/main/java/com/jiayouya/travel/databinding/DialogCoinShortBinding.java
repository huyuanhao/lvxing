package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.jiayouya.travel.module.common.widget.round.widget.GeneralRoundLinearLayout;
import com.jiayouya.travel.module.travel.data.BuyDogRsp;
import ezy.p653ui.widget.round.RoundLayout;

public abstract class DialogCoinShortBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundLayout f10320a;
    /* renamed from: b */
    public final TextView f10321b;
    /* renamed from: c */
    public final ImageView f10322c;
    /* renamed from: d */
    public final GeneralRoundLinearLayout f10323d;
    /* renamed from: e */
    public final LinearLayout f10324e;
    /* renamed from: f */
    public final LinearLayout f10325f;
    @Bindable
    /* renamed from: g */
    protected BuyDogRsp f10326g;
    @Bindable
    /* renamed from: h */
    protected boolean f10327h;

    /* renamed from: a */
    public abstract void mo20110a(BuyDogRsp buyDogRsp);

    /* renamed from: a */
    public abstract void mo20111a(boolean z);

    protected DialogCoinShortBinding(Object obj, View view, int i, RoundLayout roundLayout, TextView textView, ImageView imageView, GeneralRoundLinearLayout generalRoundLinearLayout, LinearLayout linearLayout, LinearLayout linearLayout2) {
        super(obj, view, i);
        this.f10320a = roundLayout;
        this.f10321b = textView;
        this.f10322c = imageView;
        this.f10323d = generalRoundLinearLayout;
        this.f10324e = linearLayout;
        this.f10325f = linearLayout2;
    }
}
