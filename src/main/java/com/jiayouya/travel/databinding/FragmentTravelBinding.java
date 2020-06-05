package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.jiayouya.travel.common.widget.RiseText;
import com.jiayouya.travel.common.widget.RndCornerProgressBar;
import com.jiayouya.travel.common.widget.countdownview.CountdownView;
import com.jiayouya.travel.module.travel.data.DogHomeRsp;
import com.jiayouya.travel.module.travel.data.GameIndex;
import com.jiayouya.travel.module.travel.data.SuggestBuyItem;
import com.jiayouya.travel.module.travel.widget.FloatImageView;
import com.jiayouya.travel.module.travel.widget.GradientText;
import com.jiayouya.travel.module.travel.widget.ScaleLayout;
import com.jiayouya.travel.module.travel.widget.merge.MergeLayout;

public abstract class FragmentTravelBinding extends ViewDataBinding {
    /* renamed from: A */
    public final HorizontalScrollView f10836A;
    /* renamed from: B */
    public final HorizontalScrollView f10837B;
    /* renamed from: C */
    public final RndCornerProgressBar f10838C;
    /* renamed from: D */
    public final View f10839D;
    /* renamed from: E */
    public final View f10840E;
    /* renamed from: F */
    public final GradientText f10841F;
    /* renamed from: G */
    public final TextView f10842G;
    /* renamed from: H */
    public final TextView f10843H;
    /* renamed from: I */
    public final RiseText f10844I;
    /* renamed from: J */
    public final TextView f10845J;
    /* renamed from: K */
    public final TextView f10846K;
    /* renamed from: L */
    public final LottieAnimationView f10847L;
    @Bindable
    /* renamed from: M */
    protected SuggestBuyItem f10848M;
    @Bindable
    /* renamed from: N */
    protected String f10849N;
    @Bindable
    /* renamed from: O */
    protected long f10850O;
    @Bindable
    /* renamed from: P */
    protected DogHomeRsp f10851P;
    @Bindable
    /* renamed from: Q */
    protected GameIndex f10852Q;
    /* renamed from: a */
    public final View f10853a;
    /* renamed from: b */
    public final ImageView f10854b;
    /* renamed from: c */
    public final ImageView f10855c;
    /* renamed from: d */
    public final ImageView f10856d;
    /* renamed from: e */
    public final ImageView f10857e;
    /* renamed from: f */
    public final ImageView f10858f;
    /* renamed from: g */
    public final ImageView f10859g;
    /* renamed from: h */
    public final CountdownView f10860h;
    /* renamed from: i */
    public final CountdownView f10861i;
    /* renamed from: j */
    public final HorizontalScrollView f10862j;
    /* renamed from: k */
    public final ImageView f10863k;
    /* renamed from: l */
    public final FloatImageView f10864l;
    /* renamed from: m */
    public final ImageView f10865m;
    /* renamed from: n */
    public final ImageView f10866n;
    /* renamed from: o */
    public final LottieAnimationView f10867o;
    /* renamed from: p */
    public final ScaleLayout f10868p;
    /* renamed from: q */
    public final LinearLayout f10869q;
    /* renamed from: r */
    public final FrameLayout f10870r;
    /* renamed from: s */
    public final FrameLayout f10871s;
    /* renamed from: t */
    public final LinearLayout f10872t;
    /* renamed from: u */
    public final FrameLayout f10873u;
    /* renamed from: v */
    public final FrameLayout f10874v;
    /* renamed from: w */
    public final MergeLayout f10875w;
    /* renamed from: x */
    public final LinearLayout f10876x;
    /* renamed from: y */
    public final LinearLayout f10877y;
    /* renamed from: z */
    public final FrameLayout f10878z;

    /* renamed from: a */
    public abstract void mo20156a(long j);

    /* renamed from: a */
    public abstract void mo20157a(DogHomeRsp dogHomeRsp);

    /* renamed from: a */
    public abstract void mo20158a(GameIndex gameIndex);

    /* renamed from: a */
    public abstract void mo20159a(SuggestBuyItem suggestBuyItem);

    /* renamed from: a */
    public abstract void mo20160a(String str);

    protected FragmentTravelBinding(Object obj, View view, int i, View view2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, CountdownView countdownView, CountdownView countdownView2, HorizontalScrollView horizontalScrollView, ImageView imageView7, FloatImageView floatImageView, ImageView imageView8, ImageView imageView9, LottieAnimationView lottieAnimationView, ScaleLayout scaleLayout, LinearLayout linearLayout, FrameLayout frameLayout, FrameLayout frameLayout2, LinearLayout linearLayout2, FrameLayout frameLayout3, FrameLayout frameLayout4, MergeLayout mergeLayout, LinearLayout linearLayout3, LinearLayout linearLayout4, FrameLayout frameLayout5, HorizontalScrollView horizontalScrollView2, HorizontalScrollView horizontalScrollView3, RndCornerProgressBar rndCornerProgressBar, View view3, View view4, GradientText gradientText, TextView textView, TextView textView2, RiseText riseText, TextView textView3, TextView textView4, LottieAnimationView lottieAnimationView2) {
        super(obj, view, i);
        this.f10853a = view2;
        this.f10854b = imageView;
        this.f10855c = imageView2;
        this.f10856d = imageView3;
        this.f10857e = imageView4;
        this.f10858f = imageView5;
        this.f10859g = imageView6;
        this.f10860h = countdownView;
        this.f10861i = countdownView2;
        this.f10862j = horizontalScrollView;
        this.f10863k = imageView7;
        this.f10864l = floatImageView;
        this.f10865m = imageView8;
        this.f10866n = imageView9;
        this.f10867o = lottieAnimationView;
        this.f10868p = scaleLayout;
        this.f10869q = linearLayout;
        this.f10870r = frameLayout;
        this.f10871s = frameLayout2;
        this.f10872t = linearLayout2;
        this.f10873u = frameLayout3;
        this.f10874v = frameLayout4;
        this.f10875w = mergeLayout;
        this.f10876x = linearLayout3;
        this.f10877y = linearLayout4;
        this.f10878z = frameLayout5;
        this.f10836A = horizontalScrollView2;
        this.f10837B = horizontalScrollView3;
        this.f10838C = rndCornerProgressBar;
        this.f10839D = view3;
        this.f10840E = view4;
        this.f10841F = gradientText;
        this.f10842G = textView;
        this.f10843H = textView2;
        this.f10844I = riseText;
        this.f10845J = textView3;
        this.f10846K = textView4;
        this.f10847L = lottieAnimationView2;
    }

    /* renamed from: a */
    public SuggestBuyItem mo20155a() {
        return this.f10848M;
    }

    /* renamed from: b */
    public DogHomeRsp mo20161b() {
        return this.f10851P;
    }
}
