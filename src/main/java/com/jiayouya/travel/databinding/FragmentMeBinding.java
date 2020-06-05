package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.jiayouya.travel.common.widget.RndCornerProgressBar;
import com.jiayouya.travel.module.common.data.User;
import com.jiayouya.travel.module.p276me.data.DogProgressRsp;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public abstract class FragmentMeBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RecyclerView f10751a;
    /* renamed from: b */
    public final FrameLayout f10752b;
    /* renamed from: c */
    public final RndCornerProgressBar f10753c;
    /* renamed from: d */
    public final SmartRefreshLayout f10754d;
    /* renamed from: e */
    public final View f10755e;
    /* renamed from: f */
    public final TextView f10756f;
    @Bindable
    /* renamed from: g */
    protected User f10757g;
    @Bindable
    /* renamed from: h */
    protected DogProgressRsp f10758h;

    /* renamed from: a */
    public abstract void mo20151a(User user);

    /* renamed from: a */
    public abstract void mo20152a(DogProgressRsp dogProgressRsp);

    protected FragmentMeBinding(Object obj, View view, int i, RecyclerView recyclerView, FrameLayout frameLayout, RndCornerProgressBar rndCornerProgressBar, SmartRefreshLayout smartRefreshLayout, View view2, TextView textView) {
        super(obj, view, i);
        this.f10751a = recyclerView;
        this.f10752b = frameLayout;
        this.f10753c = rndCornerProgressBar;
        this.f10754d = smartRefreshLayout;
        this.f10755e = view2;
        this.f10756f = textView;
    }

    /* renamed from: a */
    public DogProgressRsp mo20150a() {
        return this.f10758h;
    }
}
