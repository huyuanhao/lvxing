package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.jiayouya.travel.module.travel.data.LuckPoolRsp;
import com.jiayouya.travel.module.travel.widget.LuckDrawView;
import ezy.p653ui.widget.round.RoundText;

public abstract class DialogLuckyDrawBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundText f10483a;
    /* renamed from: b */
    public final LuckDrawView f10484b;
    /* renamed from: c */
    public final ImageView f10485c;
    /* renamed from: d */
    public final TextView f10486d;
    @Bindable
    /* renamed from: e */
    protected LuckPoolRsp f10487e;

    /* renamed from: a */
    public abstract void mo20129a(LuckPoolRsp luckPoolRsp);

    protected DialogLuckyDrawBinding(Object obj, View view, int i, RoundText roundText, LuckDrawView luckDrawView, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.f10483a = roundText;
        this.f10484b = luckDrawView;
        this.f10485c = imageView;
        this.f10486d = textView;
    }

    /* renamed from: a */
    public LuckPoolRsp mo20128a() {
        return this.f10487e;
    }
}
