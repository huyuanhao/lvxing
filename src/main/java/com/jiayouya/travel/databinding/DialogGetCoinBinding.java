package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.jiayouya.travel.module.common.widget.round.widget.GeneralRoundLinearLayout;
import com.jiayouya.travel.module.travel.data.GetCoinItem;
import ezy.p653ui.widget.round.RoundText;

public abstract class DialogGetCoinBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundText f10398a;
    /* renamed from: b */
    public final TextView f10399b;
    /* renamed from: c */
    public final ImageView f10400c;
    /* renamed from: d */
    public final GeneralRoundLinearLayout f10401d;
    /* renamed from: e */
    public final LinearLayout f10402e;
    /* renamed from: f */
    public final LinearLayout f10403f;
    @Bindable
    /* renamed from: g */
    protected GetCoinItem f10404g;
    @Bindable
    /* renamed from: h */
    protected boolean f10405h;

    /* renamed from: a */
    public abstract void mo20116a(GetCoinItem getCoinItem);

    /* renamed from: a */
    public abstract void mo20117a(boolean z);

    protected DialogGetCoinBinding(Object obj, View view, int i, RoundText roundText, TextView textView, ImageView imageView, GeneralRoundLinearLayout generalRoundLinearLayout, LinearLayout linearLayout, LinearLayout linearLayout2) {
        super(obj, view, i);
        this.f10398a = roundText;
        this.f10399b = textView;
        this.f10400c = imageView;
        this.f10401d = generalRoundLinearLayout;
        this.f10402e = linearLayout;
        this.f10403f = linearLayout2;
    }
}
