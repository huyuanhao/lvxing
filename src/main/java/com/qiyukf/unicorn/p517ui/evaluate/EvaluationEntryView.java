package com.qiyukf.unicorn.p517ui.evaluate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.qiyukf.basesdk.p412c.p417d.C5412d;
import com.qiyukf.unicorn.C5961R;

/* renamed from: com.qiyukf.unicorn.ui.evaluate.EvaluationEntryView */
public class EvaluationEntryView extends LinearLayout {
    /* renamed from: a */
    private ImageView f19697a;
    /* renamed from: b */
    private TextView f19698b;

    public EvaluationEntryView(Context context) {
        this(context, null);
    }

    public EvaluationEntryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setGravity(1);
        setOrientation(1);
        this.f19697a = new ImageView(getContext());
        this.f19697a.setPadding(0, C5412d.m22146a(5.0f), 0, C5412d.m22146a(5.0f));
        this.f19697a.setScaleType(ScaleType.CENTER_INSIDE);
        addView(this.f19697a, new LayoutParams(-2, -2));
        this.f19698b = new TextView(getContext());
        this.f19698b.setBackgroundResource(C5961R.C5962drawable.ysf_evaluation_dialog_select_text_bg_selector);
        this.f19698b.setPadding(C5412d.m22146a(5.0f), C5412d.m22146a(3.0f), C5412d.m22146a(5.0f), C5412d.m22146a(3.0f));
        this.f19698b.setTextColor(getResources().getColorStateList(C5961R.color.ysf_evaluation_dialog_select_text_selector));
        this.f19698b.setTextSize(9.0f);
        addView(this.f19698b, new LayoutParams(-2, -2));
    }

    /* renamed from: a */
    public final void mo29514a() {
        this.f19697a.clearAnimation();
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.2f, 1.0f, 1.2f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(250);
        scaleAnimation.setFillAfter(true);
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.2f, 1.0f, 1.2f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(250);
        scaleAnimation2.setFillAfter(true);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(scaleAnimation2);
        this.f19697a.startAnimation(animationSet);
    }

    /* renamed from: a */
    public final void mo29515a(int i) {
        this.f19697a.setImageResource(i);
    }

    /* renamed from: a */
    public final void mo29516a(String str) {
        this.f19698b.setText(str);
    }
}
