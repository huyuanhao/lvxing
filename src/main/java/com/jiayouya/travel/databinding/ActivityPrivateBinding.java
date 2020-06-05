package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.jiayouya.travel.module.common.data.UserPrivacyRsp;

public abstract class ActivityPrivateBinding extends ViewDataBinding {
    /* renamed from: a */
    public final LinearLayout f10142a;
    /* renamed from: b */
    public final Switch f10143b;
    /* renamed from: c */
    public final Switch f10144c;
    @Bindable
    /* renamed from: d */
    protected UserPrivacyRsp f10145d;

    /* renamed from: a */
    public abstract void mo20098a(UserPrivacyRsp userPrivacyRsp);

    protected ActivityPrivateBinding(Object obj, View view, int i, LinearLayout linearLayout, Switch switchR, Switch switchR2) {
        super(obj, view, i);
        this.f10142a = linearLayout;
        this.f10143b = switchR;
        this.f10144c = switchR2;
    }
}
