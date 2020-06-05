package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.jiayouya.travel.module.common.data.User;
import com.jiayouya.travel.module.p276me.data.VoiceStatus;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import ezy.p653ui.widget.CenteredTitleBar;
import ezy.p653ui.widget.round.RoundText;

public abstract class ActivitySettingBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundText f10197a;
    /* renamed from: b */
    public final LinearLayout f10198b;
    /* renamed from: c */
    public final LinearLayout f10199c;
    /* renamed from: d */
    public final LinearLayout f10200d;
    /* renamed from: e */
    public final SmartRefreshLayout f10201e;
    /* renamed from: f */
    public final Switch f10202f;
    /* renamed from: g */
    public final CenteredTitleBar f10203g;
    @Bindable
    /* renamed from: h */
    protected User f10204h;
    @Bindable
    /* renamed from: i */
    protected VoiceStatus f10205i;
    @Bindable
    /* renamed from: j */
    protected String f10206j;

    /* renamed from: a */
    public abstract void mo20101a(User user);

    /* renamed from: a */
    public abstract void mo20102a(VoiceStatus voiceStatus);

    /* renamed from: a */
    public abstract void mo20103a(String str);

    protected ActivitySettingBinding(Object obj, View view, int i, RoundText roundText, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, SmartRefreshLayout smartRefreshLayout, Switch switchR, CenteredTitleBar centeredTitleBar) {
        super(obj, view, i);
        this.f10197a = roundText;
        this.f10198b = linearLayout;
        this.f10199c = linearLayout2;
        this.f10200d = linearLayout3;
        this.f10201e = smartRefreshLayout;
        this.f10202f = switchR;
        this.f10203g = centeredTitleBar;
    }

    /* renamed from: a */
    public User mo20100a() {
        return this.f10204h;
    }
}
