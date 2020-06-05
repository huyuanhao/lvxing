package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import ezy.p653ui.widget.round.RoundText;

public abstract class DialogBindInviterBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundText f10266a;
    /* renamed from: b */
    public final EditText f10267b;
    /* renamed from: c */
    public final ImageView f10268c;
    /* renamed from: d */
    public final TextView f10269d;
    @Bindable
    /* renamed from: e */
    protected boolean f10270e;

    /* renamed from: a */
    public abstract void mo20105a(boolean z);

    protected DialogBindInviterBinding(Object obj, View view, int i, RoundText roundText, EditText editText, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.f10266a = roundText;
        this.f10267b = editText;
        this.f10268c = imageView;
        this.f10269d = textView;
    }
}
