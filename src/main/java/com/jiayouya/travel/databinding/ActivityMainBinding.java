package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.tabs.TabLayout;

public abstract class ActivityMainBinding extends ViewDataBinding {
    /* renamed from: a */
    public final FrameLayout f10048a;
    /* renamed from: b */
    public final TabLayout f10049b;

    protected ActivityMainBinding(Object obj, View view, int i, FrameLayout frameLayout, TabLayout tabLayout) {
        super(obj, view, i);
        this.f10048a = frameLayout;
        this.f10049b = tabLayout;
    }
}
