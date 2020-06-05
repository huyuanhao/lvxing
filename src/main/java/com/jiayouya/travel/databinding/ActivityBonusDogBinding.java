package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.jiayouya.travel.module.p276me.data.DogAnalysisRsp;
import com.jiayouya.travel.module.p276me.widget.ScoreView;

public abstract class ActivityBonusDogBinding extends ViewDataBinding {
    /* renamed from: a */
    public final ImageView f9885a;
    /* renamed from: b */
    public final ImageView f9886b;
    /* renamed from: c */
    public final ImageView f9887c;
    /* renamed from: d */
    public final ScoreView f9888d;
    /* renamed from: e */
    public final ScrollView f9889e;
    /* renamed from: f */
    public final TextView f9890f;
    /* renamed from: g */
    public final TextView f9891g;
    /* renamed from: h */
    public final TextView f9892h;
    /* renamed from: i */
    public final TextView f9893i;
    /* renamed from: j */
    public final TextView f9894j;
    /* renamed from: k */
    public final TextView f9895k;
    @Bindable
    /* renamed from: l */
    protected DogAnalysisRsp f9896l;

    /* renamed from: a */
    public abstract void mo20079a(DogAnalysisRsp dogAnalysisRsp);

    protected ActivityBonusDogBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, ScoreView scoreView, ScrollView scrollView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        super(obj, view, i);
        this.f9885a = imageView;
        this.f9886b = imageView2;
        this.f9887c = imageView3;
        this.f9888d = scoreView;
        this.f9889e = scrollView;
        this.f9890f = textView;
        this.f9891g = textView2;
        this.f9892h = textView3;
        this.f9893i = textView4;
        this.f9894j = textView5;
        this.f9895k = textView6;
    }
}
