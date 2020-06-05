package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.EditText;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import ezy.p653ui.widget.round.RoundText;

public abstract class ActivityPhoneLoginBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundText f10130a;
    /* renamed from: b */
    public final RoundText f10131b;
    /* renamed from: c */
    public final EditText f10132c;
    /* renamed from: d */
    public final EditText f10133d;
    @Bindable
    /* renamed from: e */
    protected int f10134e;

    /* renamed from: a */
    public abstract void mo20097a(int i);

    protected ActivityPhoneLoginBinding(Object obj, View view, int i, RoundText roundText, RoundText roundText2, EditText editText, EditText editText2) {
        super(obj, view, i);
        this.f10130a = roundText;
        this.f10131b = roundText2;
        this.f10132c = editText;
        this.f10133d = editText2;
    }

    /* renamed from: a */
    public int mo20096a() {
        return this.f10134e;
    }
}
