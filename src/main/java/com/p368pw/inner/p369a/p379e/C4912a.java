package com.p368pw.inner.p369a.p379e;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.p368pw.inner.base.p387d.C5191i;
import com.p368pw.inner.base.p387d.C5214u;
import com.p368pw.view.SquareImageView;

/* renamed from: com.pw.inner.a.e.a */
public class C4912a extends RelativeLayout {
    /* renamed from: a */
    private SquareImageView f15877a;
    /* renamed from: b */
    private TextView f15878b;
    /* renamed from: c */
    private TextView f15879c;
    /* renamed from: d */
    private TextView f15880d;
    /* renamed from: e */
    private FrameLayout f15881e;
    /* renamed from: f */
    private ImageView f15882f;

    public C4912a(Context context) {
        this(context, null);
    }

    public C4912a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C4912a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20307a(context);
    }

    /* renamed from: a */
    private void m20307a(Context context) {
        int b = C5191i.m21391b(context, 13);
        this.f15877a = new SquareImageView(context);
        this.f15877a.setId(C5214u.m21488a());
        this.f15877a.setBackgroundColor(0);
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        layoutParams.topMargin = b;
        layoutParams.leftMargin = b;
        layoutParams.bottomMargin = b;
        addView(this.f15877a, layoutParams);
        this.f15880d = new TextView(context);
        this.f15880d.setId(C5214u.m21488a());
        this.f15880d.setTextSize(2, 18.0f);
        this.f15880d.setTextColor(Color.parseColor("#ffffffff"));
        this.f15880d.setGravity(17);
        this.f15880d.setText("下载");
        LayoutParams layoutParams2 = new LayoutParams(-2, -2);
        layoutParams2.rightMargin = b;
        layoutParams2.addRule(11);
        layoutParams2.addRule(15);
        this.f15881e = new FrameLayout(context);
        this.f15881e.setId(C5214u.m21488a());
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(100.0f);
        gradientDrawable.setColors(new int[]{Color.parseColor("#ffFF3D32"), Color.parseColor("#ffFF8132")});
        gradientDrawable.setGradientType(0);
        this.f15881e.setBackground(gradientDrawable);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 17;
        this.f15881e.addView(this.f15880d, layoutParams3);
        addView(this.f15881e, layoutParams2);
        this.f15879c = new TextView(context);
        this.f15879c.setId(C5214u.m21488a());
        this.f15879c.setTextSize(2, 18.0f);
        this.f15879c.setTextColor(Color.parseColor("#393939"));
        this.f15879c.setText("app");
        LayoutParams layoutParams4 = new LayoutParams(-2, -2);
        layoutParams4.leftMargin = b;
        layoutParams4.topMargin = C5191i.m21391b(context, 18);
        layoutParams4.addRule(1, this.f15877a.getId());
        layoutParams4.addRule(0, this.f15881e.getId());
        addView(this.f15879c, layoutParams4);
        this.f15878b = new TextView(context);
        this.f15878b.setId(C5214u.m21488a());
        this.f15878b.setTextSize(2, 13.0f);
        this.f15878b.setTextColor(Color.parseColor("#ff7a7a7a"));
        this.f15878b.setEllipsize(TruncateAt.END);
        this.f15878b.setMaxLines(1);
        this.f15878b.setText("~~~");
        LayoutParams layoutParams5 = new LayoutParams(-2, -2);
        layoutParams5.leftMargin = b;
        layoutParams5.rightMargin = b;
        layoutParams5.topMargin = b / 3;
        layoutParams5.addRule(3, this.f15879c.getId());
        layoutParams5.addRule(0, this.f15881e.getId());
        layoutParams5.addRule(1, this.f15877a.getId());
        addView(this.f15878b, layoutParams5);
        this.f15882f = new ImageView(context);
        int i = (b * 3) / 4;
        LayoutParams layoutParams6 = new LayoutParams(i, i);
        layoutParams6.addRule(12);
        layoutParams6.addRule(11);
        layoutParams6.rightMargin = b / 2;
        layoutParams6.bottomMargin = i / 2;
        addView(this.f15882f, layoutParams6);
        setLayoutParams(new LayoutParams(-1, C5191i.m21391b(context, 80)));
        setBackgroundColor(Color.parseColor("#e6ffffff"));
    }

    public ImageView getAdChoiceView() {
        return this.f15882f;
    }

    public TextView getButtonView() {
        return this.f15880d;
    }

    public FrameLayout getButtonViewGroup() {
        return this.f15881e;
    }

    public TextView getDescView() {
        return this.f15878b;
    }

    public SquareImageView getIconView() {
        return this.f15877a;
    }

    public TextView getTitleView() {
        return this.f15879c;
    }

    public void setBannerStyle(int i) {
        if (i == 2) {
            this.f15880d.setTextSize(2, 14.0f);
            this.f15880d.setText("立即下载");
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius((float) C5191i.m21391b(getContext(), 4));
            String str = "#ff4990e2";
            gradientDrawable.setColors(new int[]{Color.parseColor(str), Color.parseColor(str)});
            gradientDrawable.setGradientType(0);
            this.f15880d.setBackground(gradientDrawable);
            this.f15879c.setTextColor(Color.parseColor("#232323"));
            this.f15878b.setTextColor(Color.parseColor("#999999"));
        }
    }
}
