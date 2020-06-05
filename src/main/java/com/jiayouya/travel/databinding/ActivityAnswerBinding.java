package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.jiayouya.travel.module.answer.data.Questions;
import ezy.p653ui.widget.round.RoundText;

public abstract class ActivityAnswerBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundText f9820a;
    /* renamed from: b */
    public final TextView f9821b;
    /* renamed from: c */
    public final RecyclerView f9822c;
    /* renamed from: d */
    public final LinearLayout f9823d;
    @Bindable
    /* renamed from: e */
    protected Questions f9824e;
    @Bindable
    /* renamed from: f */
    protected boolean f9825f;
    @Bindable
    /* renamed from: g */
    protected boolean f9826g;

    /* renamed from: a */
    public abstract void mo20071a(Questions questions);

    /* renamed from: a */
    public abstract void mo20072a(boolean z);

    /* renamed from: b */
    public abstract void mo20073b(boolean z);

    protected ActivityAnswerBinding(Object obj, View view, int i, RoundText roundText, TextView textView, RecyclerView recyclerView, LinearLayout linearLayout) {
        super(obj, view, i);
        this.f9820a = roundText;
        this.f9821b = textView;
        this.f9822c = recyclerView;
        this.f9823d = linearLayout;
    }

    /* renamed from: a */
    public Questions mo20070a() {
        return this.f9824e;
    }

    /* renamed from: b */
    public boolean mo20074b() {
        return this.f9826g;
    }
}
