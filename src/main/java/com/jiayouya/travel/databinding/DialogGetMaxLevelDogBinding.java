package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import ezy.p653ui.widget.round.RoundText;

public abstract class DialogGetMaxLevelDogBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundText f10427a;
    /* renamed from: b */
    public final ImageView f10428b;
    @Bindable
    /* renamed from: c */
    protected int f10429c;
    @Bindable
    /* renamed from: d */
    protected String f10430d;
    @Bindable
    /* renamed from: e */
    protected String f10431e;

    /* renamed from: a */
    public abstract void mo20119a(int i);

    /* renamed from: a */
    public abstract void mo20120a(String str);

    /* renamed from: b */
    public abstract void mo20121b(String str);

    protected DialogGetMaxLevelDogBinding(Object obj, View view, int i, RoundText roundText, ImageView imageView) {
        super(obj, view, i);
        this.f10427a = roundText;
        this.f10428b = imageView;
    }
}
