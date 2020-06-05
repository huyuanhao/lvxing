package com.jiayouya.travel.databinding;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import ezy.p653ui.widget.CenteredTitleBar;
import ezy.p653ui.widget.round.RoundText;
import net.lucode.hackware.magicindicator.MagicIndicator;

public abstract class ActivityRankingListBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundText f10151a;
    /* renamed from: b */
    public final MagicIndicator f10152b;
    /* renamed from: c */
    public final CenteredTitleBar f10153c;
    /* renamed from: d */
    public final ViewPager f10154d;

    protected ActivityRankingListBinding(Object obj, View view, int i, RoundText roundText, MagicIndicator magicIndicator, CenteredTitleBar centeredTitleBar, ViewPager viewPager) {
        super(obj, view, i);
        this.f10151a = roundText;
        this.f10152b = magicIndicator;
        this.f10153c = centeredTitleBar;
        this.f10154d = viewPager;
    }
}
