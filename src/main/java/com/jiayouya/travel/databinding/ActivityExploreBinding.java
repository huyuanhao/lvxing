package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.jiayouya.travel.common.widget.countdownview.CountdownView;
import com.jiayouya.travel.module.explore.data.ExploreIndex;
import com.jiayouya.travel.module.explore.widget.ShakeLayout;
import ezy.p653ui.widget.CenteredTitleBar;
import ezy.p653ui.widget.round.RoundLayout;
import ezy.p653ui.widget.round.RoundText;

public abstract class ActivityExploreBinding extends ViewDataBinding {
    /* renamed from: a */
    public final ImageView f9976a;
    /* renamed from: b */
    public final ImageView f9977b;
    /* renamed from: c */
    public final ImageView f9978c;
    /* renamed from: d */
    public final RoundLayout f9979d;
    /* renamed from: e */
    public final RoundText f9980e;
    /* renamed from: f */
    public final CountdownView f9981f;
    /* renamed from: g */
    public final RecyclerView f9982g;
    /* renamed from: h */
    public final HorizontalScrollView f9983h;
    /* renamed from: i */
    public final RecyclerView f9984i;
    /* renamed from: j */
    public final ShakeLayout f9985j;
    /* renamed from: k */
    public final HorizontalScrollView f9986k;
    /* renamed from: l */
    public final HorizontalScrollView f9987l;
    /* renamed from: m */
    public final NestedScrollView f9988m;
    /* renamed from: n */
    public final RecyclerView f9989n;
    /* renamed from: o */
    public final CenteredTitleBar f9990o;
    /* renamed from: p */
    public final TextView f9991p;
    /* renamed from: q */
    public final TextView f9992q;
    @Bindable
    /* renamed from: r */
    protected ExploreIndex f9993r;

    /* renamed from: a */
    public abstract void mo20086a(ExploreIndex exploreIndex);

    protected ActivityExploreBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, RoundLayout roundLayout, RoundText roundText, CountdownView countdownView, RecyclerView recyclerView, HorizontalScrollView horizontalScrollView, RecyclerView recyclerView2, ShakeLayout shakeLayout, HorizontalScrollView horizontalScrollView2, HorizontalScrollView horizontalScrollView3, NestedScrollView nestedScrollView, RecyclerView recyclerView3, CenteredTitleBar centeredTitleBar, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f9976a = imageView;
        this.f9977b = imageView2;
        this.f9978c = imageView3;
        this.f9979d = roundLayout;
        this.f9980e = roundText;
        this.f9981f = countdownView;
        this.f9982g = recyclerView;
        this.f9983h = horizontalScrollView;
        this.f9984i = recyclerView2;
        this.f9985j = shakeLayout;
        this.f9986k = horizontalScrollView2;
        this.f9987l = horizontalScrollView3;
        this.f9988m = nestedScrollView;
        this.f9989n = recyclerView3;
        this.f9990o = centeredTitleBar;
        this.f9991p = textView;
        this.f9992q = textView2;
    }

    /* renamed from: a */
    public ExploreIndex mo20085a() {
        return this.f9993r;
    }
}
