package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.jiayouya.travel.module.common.data.AdRsp;
import ezy.p653ui.widget.round.RoundLayout;

public abstract class DialogLuckTicketBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundLayout f10475a;
    /* renamed from: b */
    public final ImageView f10476b;
    @Bindable
    /* renamed from: c */
    protected AdRsp f10477c;

    /* renamed from: a */
    public abstract void mo20127a(AdRsp adRsp);

    protected DialogLuckTicketBinding(Object obj, View view, int i, RoundLayout roundLayout, ImageView imageView) {
        super(obj, view, i);
        this.f10475a = roundLayout;
        this.f10476b = imageView;
    }

    /* renamed from: a */
    public AdRsp mo20126a() {
        return this.f10477c;
    }
}
