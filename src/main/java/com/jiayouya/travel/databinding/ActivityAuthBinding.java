package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.jiayouya.travel.module.common.data.User;
import ezy.p653ui.widget.round.RoundText;

public abstract class ActivityAuthBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundText f9846a;
    /* renamed from: b */
    public final RoundText f9847b;
    /* renamed from: c */
    public final View f9848c;
    /* renamed from: d */
    public final TextView f9849d;
    @Bindable
    /* renamed from: e */
    protected String f9850e;
    @Bindable
    /* renamed from: f */
    protected User f9851f;

    /* renamed from: a */
    public abstract void mo20076a(User user);

    /* renamed from: a */
    public abstract void mo20077a(String str);

    protected ActivityAuthBinding(Object obj, View view, int i, RoundText roundText, RoundText roundText2, View view2, TextView textView) {
        super(obj, view, i);
        this.f9846a = roundText;
        this.f9847b = roundText2;
        this.f9848c = view2;
        this.f9849d = textView;
    }
}
