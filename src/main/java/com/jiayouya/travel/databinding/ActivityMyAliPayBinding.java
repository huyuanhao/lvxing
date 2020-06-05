package com.jiayouya.travel.databinding;

import android.view.View;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.jiayouya.travel.module.common.data.AliUserRsp;
import ezy.p653ui.widget.round.RoundText;

public abstract class ActivityMyAliPayBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundText f10075a;
    @Bindable
    /* renamed from: b */
    protected AliUserRsp f10076b;

    /* renamed from: a */
    public abstract void mo20092a(AliUserRsp aliUserRsp);

    protected ActivityMyAliPayBinding(Object obj, View view, int i, RoundText roundText) {
        super(obj, view, i);
        this.f10075a = roundText;
    }
}
