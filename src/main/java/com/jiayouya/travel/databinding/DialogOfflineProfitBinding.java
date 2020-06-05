package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.jiayouya.travel.module.common.widget.round.widget.GeneralRoundLinearLayout;
import com.jiayouya.travel.module.travel.data.OfflineProfit;
import ezy.p653ui.widget.round.RoundLayout;

public abstract class DialogOfflineProfitBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundLayout f10535a;
    /* renamed from: b */
    public final TextView f10536b;
    /* renamed from: c */
    public final ImageView f10537c;
    /* renamed from: d */
    public final ImageView f10538d;
    /* renamed from: e */
    public final GeneralRoundLinearLayout f10539e;
    /* renamed from: f */
    public final LinearLayout f10540f;
    /* renamed from: g */
    public final LinearLayout f10541g;
    @Bindable
    /* renamed from: h */
    protected OfflineProfit f10542h;
    @Bindable
    /* renamed from: i */
    protected boolean f10543i;

    /* renamed from: a */
    public abstract void mo20133a(OfflineProfit offlineProfit);

    /* renamed from: a */
    public abstract void mo20134a(boolean z);

    protected DialogOfflineProfitBinding(Object obj, View view, int i, RoundLayout roundLayout, TextView textView, ImageView imageView, ImageView imageView2, GeneralRoundLinearLayout generalRoundLinearLayout, LinearLayout linearLayout, LinearLayout linearLayout2) {
        super(obj, view, i);
        this.f10535a = roundLayout;
        this.f10536b = textView;
        this.f10537c = imageView;
        this.f10538d = imageView2;
        this.f10539e = generalRoundLinearLayout;
        this.f10540f = linearLayout;
        this.f10541g = linearLayout2;
    }
}
