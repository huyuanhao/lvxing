package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.jiayouya.travel.module.common.data.InviteDataRsp;
import ezy.p653ui.widget.round.RoundText;

public abstract class ActivityInviteCodeBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundText f10012a;
    /* renamed from: b */
    public final RoundText f10013b;
    /* renamed from: c */
    public final FrameLayout f10014c;
    /* renamed from: d */
    public final NestedScrollView f10015d;
    /* renamed from: e */
    public final TextView f10016e;
    /* renamed from: f */
    public final TextView f10017f;
    @Bindable
    /* renamed from: g */
    protected InviteDataRsp f10018g;

    /* renamed from: a */
    public abstract void mo20088a(InviteDataRsp inviteDataRsp);

    protected ActivityInviteCodeBinding(Object obj, View view, int i, RoundText roundText, RoundText roundText2, FrameLayout frameLayout, NestedScrollView nestedScrollView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f10012a = roundText;
        this.f10013b = roundText2;
        this.f10014c = frameLayout;
        this.f10015d = nestedScrollView;
        this.f10016e = textView;
        this.f10017f = textView2;
    }

    /* renamed from: a */
    public InviteDataRsp mo20087a() {
        return this.f10018g;
    }
}
