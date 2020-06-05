package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.jiayouya.travel.common.widget.countdownview.CountdownView;
import com.jiayouya.travel.module.travel.data.PositionItem;

public abstract class ItemMergeBinding extends ViewDataBinding {
    /* renamed from: a */
    public final CountdownView f11095a;
    /* renamed from: b */
    public final ImageView f11096b;
    /* renamed from: c */
    public final ImageView f11097c;
    /* renamed from: d */
    public final ImageView f11098d;
    /* renamed from: e */
    public final LinearLayout f11099e;
    /* renamed from: f */
    public final FrameLayout f11100f;
    /* renamed from: g */
    public final FrameLayout f11101g;
    /* renamed from: h */
    public final LinearLayout f11102h;
    /* renamed from: i */
    public final TextView f11103i;
    @Bindable
    /* renamed from: j */
    protected PositionItem f11104j;
    @Bindable
    /* renamed from: k */
    protected int f11105k;

    /* renamed from: a */
    public abstract void mo20195a(int i);

    /* renamed from: a */
    public abstract void mo20196a(PositionItem positionItem);

    protected ItemMergeBinding(Object obj, View view, int i, CountdownView countdownView, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, FrameLayout frameLayout, FrameLayout frameLayout2, LinearLayout linearLayout2, TextView textView) {
        super(obj, view, i);
        this.f11095a = countdownView;
        this.f11096b = imageView;
        this.f11097c = imageView2;
        this.f11098d = imageView3;
        this.f11099e = linearLayout;
        this.f11100f = frameLayout;
        this.f11101g = frameLayout2;
        this.f11102h = linearLayout2;
        this.f11103i = textView;
    }

    /* renamed from: a */
    public PositionItem mo20194a() {
        return this.f11104j;
    }
}
