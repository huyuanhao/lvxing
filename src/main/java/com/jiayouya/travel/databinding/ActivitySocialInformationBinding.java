package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import ezy.p653ui.widget.round.RoundText;

public abstract class ActivitySocialInformationBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundText f10220a;
    /* renamed from: b */
    public final EditText f10221b;
    /* renamed from: c */
    public final EditText f10222c;
    /* renamed from: d */
    public final RelativeLayout f10223d;

    protected ActivitySocialInformationBinding(Object obj, View view, int i, RoundText roundText, EditText editText, EditText editText2, RelativeLayout relativeLayout) {
        super(obj, view, i);
        this.f10220a = roundText;
        this.f10221b = editText;
        this.f10222c = editText2;
        this.f10223d = relativeLayout;
    }
}
