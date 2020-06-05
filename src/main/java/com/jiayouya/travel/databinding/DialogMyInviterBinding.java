package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.jiayouya.travel.module.common.data.ParentRsp;
import ezy.p653ui.widget.round.RoundText;

public abstract class DialogMyInviterBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundText f10516a;
    /* renamed from: b */
    public final RoundText f10517b;
    /* renamed from: c */
    public final ImageView f10518c;
    /* renamed from: d */
    public final TextView f10519d;
    @Bindable
    /* renamed from: e */
    protected ParentRsp f10520e;
    @Bindable
    /* renamed from: f */
    protected int f10521f;

    /* renamed from: a */
    public abstract void mo20131a(int i);

    /* renamed from: a */
    public abstract void mo20132a(ParentRsp parentRsp);

    protected DialogMyInviterBinding(Object obj, View view, int i, RoundText roundText, RoundText roundText2, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.f10516a = roundText;
        this.f10517b = roundText2;
        this.f10518c = imageView;
        this.f10519d = textView;
    }
}
