package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.jiayouya.travel.module.travel.data.Extra;
import ezy.p653ui.widget.round.RoundText;

public abstract class DialogDogUpgradeBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundText f10356a;
    /* renamed from: b */
    public final ImageView f10357b;
    @Bindable
    /* renamed from: c */
    protected Extra f10358c;
    @Bindable
    /* renamed from: d */
    protected String f10359d;

    /* renamed from: a */
    public abstract void mo20113a(Extra extra);

    /* renamed from: a */
    public abstract void mo20114a(String str);

    protected DialogDogUpgradeBinding(Object obj, View view, int i, RoundText roundText, ImageView imageView) {
        super(obj, view, i);
        this.f10356a = roundText;
        this.f10357b = imageView;
    }
}
