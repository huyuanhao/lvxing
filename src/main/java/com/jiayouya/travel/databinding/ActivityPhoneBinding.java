package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.jiayouya.travel.module.common.data.User;
import ezy.p653ui.widget.round.RoundText;

public abstract class ActivityPhoneBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundText f10118a;
    /* renamed from: b */
    public final EditText f10119b;
    /* renamed from: c */
    public final EditText f10120c;
    /* renamed from: d */
    public final TextView f10121d;
    /* renamed from: e */
    public final TextView f10122e;
    @Bindable
    /* renamed from: f */
    protected User f10123f;
    @Bindable
    /* renamed from: g */
    protected int f10124g;

    /* renamed from: a */
    public abstract void mo20094a(int i);

    /* renamed from: a */
    public abstract void mo20095a(User user);

    protected ActivityPhoneBinding(Object obj, View view, int i, RoundText roundText, EditText editText, EditText editText2, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f10118a = roundText;
        this.f10119b = editText;
        this.f10120c = editText2;
        this.f10121d = textView;
        this.f10122e = textView2;
    }

    /* renamed from: a */
    public int mo20093a() {
        return this.f10124g;
    }
}
