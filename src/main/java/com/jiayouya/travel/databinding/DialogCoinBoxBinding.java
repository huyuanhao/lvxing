package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.jiayouya.travel.module.common.data.AdRsp;
import ezy.p653ui.widget.round.RoundLayout;

public abstract class DialogCoinBoxBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundLayout f10308a;
    /* renamed from: b */
    public final ImageView f10309b;
    @Bindable
    /* renamed from: c */
    protected AdRsp f10310c;
    @Bindable
    /* renamed from: d */
    protected boolean f10311d;

    /* renamed from: a */
    public abstract void mo20108a(AdRsp adRsp);

    /* renamed from: a */
    public abstract void mo20109a(boolean z);

    protected DialogCoinBoxBinding(Object obj, View view, int i, RoundLayout roundLayout, ImageView imageView) {
        super(obj, view, i);
        this.f10308a = roundLayout;
        this.f10309b = imageView;
    }
}
