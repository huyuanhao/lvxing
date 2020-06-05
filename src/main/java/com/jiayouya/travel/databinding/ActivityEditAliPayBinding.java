package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.jiayouya.travel.module.common.data.User;
import ezy.p653ui.widget.round.RoundText;

public abstract class ActivityEditAliPayBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundText f9966a;
    /* renamed from: b */
    public final EditText f9967b;
    /* renamed from: c */
    public final EditText f9968c;
    /* renamed from: d */
    public final TextView f9969d;
    /* renamed from: e */
    public final TextView f9970e;
    @Bindable
    /* renamed from: f */
    protected User f9971f;

    protected ActivityEditAliPayBinding(Object obj, View view, int i, RoundText roundText, EditText editText, EditText editText2, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f9966a = roundText;
        this.f9967b = editText;
        this.f9968c = editText2;
        this.f9969d = textView;
        this.f9970e = textView2;
    }
}
