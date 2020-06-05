package com.jiayouya.travel.databinding;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import net.lucode.hackware.magicindicator.MagicIndicator;

public abstract class ActivityOrderBinding extends ViewDataBinding {
    /* renamed from: a */
    public final MagicIndicator f10103a;
    /* renamed from: b */
    public final ViewPager f10104b;

    protected ActivityOrderBinding(Object obj, View view, int i, MagicIndicator magicIndicator, ViewPager viewPager) {
        super(obj, view, i);
        this.f10103a = magicIndicator;
        this.f10104b = viewPager;
    }
}
