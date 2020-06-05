package com.jiayouya.travel.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.akexorcist.roundcornerprogressbar.common.BaseRoundCornerProgressBar;
import com.elvishew.xlog.XLog;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p244b.GloblaEx;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0002JH\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0015J\b\u0010\u0019\u001a\u00020\bH\u0014J\u001c\u0010\u001a\u001a\u00020\r2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\u001c\u001a\u00020\rH\u0014J\b\u0010\u001d\u001a\u00020\rH\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo39189d2 = {"Lcom/jiayouya/travel/common/widget/RndCornerProgressBar;", "Lcom/akexorcist/roundcornerprogressbar/common/BaseRoundCornerProgressBar;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "endColor", "", "startColor", "createGradientDrawable", "Landroid/graphics/drawable/GradientDrawable;", "drawProgress", "", "layoutProgress", "Landroid/widget/LinearLayout;", "max", "", "progress", "totalWidth", "radius", "padding", "colorProgress", "isReverse", "", "initLayout", "initStyleable", "attrs", "initView", "onViewDraw", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: RndCornerProgressBar.kt */
public final class RndCornerProgressBar extends BaseRoundCornerProgressBar {
    /* renamed from: a */
    private int f9668a = GloblaEx.m12811a((int) R.color.green_36AE55);
    /* renamed from: b */
    private int f9669b = GloblaEx.m12811a((int) R.color.green_36AE55);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo10176a() {
        return R.layout.layout_rnd_corner_progress_bar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo10177a(Context context, AttributeSet attributeSet) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo10179b() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo10180c() {
    }

    public RndCornerProgressBar(Context context, AttributeSet attributeSet) {
        C8271i.m35386b(context, "context");
        C8271i.m35386b(attributeSet, "attributeSet");
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RndCornerProgressBar);
        this.f9668a = obtainStyledAttributes.getColor(2, this.f9668a);
        this.f9669b = obtainStyledAttributes.getColor(1, this.f9669b);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo10178a(LinearLayout linearLayout, float f, float f2, float f3, int i, int i2, int i3, boolean z) {
        C8271i.m35386b(linearLayout, "layoutProgress");
        int i4 = i - (i2 / 2);
        if (linearLayout.getBackground() == null) {
            GradientDrawable f4 = m13101f();
            float f5 = (float) i4;
            f4.setCornerRadii(new float[]{f5, f5, f5, f5, f5, f5, f5, f5});
            linearLayout.setBackground(f4);
        }
        int i5 = (int) ((f3 - ((float) (i2 * 2))) / (f / f2));
        LayoutParams layoutParams = linearLayout.getLayoutParams();
        layoutParams.width = i5;
        linearLayout.setLayoutParams(layoutParams);
        StringBuilder sb = new StringBuilder();
        sb.append("progress==");
        sb.append(f2);
        sb.append("  width==");
        sb.append(i5);
        XLog.m12691a(sb.toString());
    }

    /* renamed from: f */
    private final GradientDrawable m13101f() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColors(new int[]{this.f9668a, this.f9669b});
        return gradientDrawable;
    }
}
