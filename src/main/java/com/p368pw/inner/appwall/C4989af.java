package com.p368pw.inner.appwall;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.p368pw.inner.base.p387d.C5191i;
import com.pw.R;

/* renamed from: com.pw.inner.appwall.af */
public class C4989af extends FrameLayout {
    /* renamed from: a */
    private TextView f16226a;
    /* renamed from: b */
    private TextView f16227b;
    /* renamed from: c */
    private GradientDrawable f16228c;

    public C4989af(Context context) {
        this(context, null);
    }

    public C4989af(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C4989af(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.win_sdk_app_wall_banner);
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        layoutParams.topMargin = C5191i.m21391b(context, 3);
        addView(imageView, layoutParams);
        this.f16226a = new TextView(context);
        this.f16226a.setTextColor(Color.parseColor("#FFFCE6A8"));
        this.f16226a.setTextSize(26.0f);
        this.f16226a.setTypeface(Typeface.DEFAULT_BOLD);
        LayoutParams layoutParams2 = new LayoutParams(-2, -2);
        layoutParams2.topMargin = C5191i.m21391b(context, 28);
        layoutParams2.leftMargin = C5191i.m21391b(context, 21);
        addView(this.f16226a, layoutParams2);
        this.f16227b = new TextView(context);
        this.f16227b.setTextColor(Color.parseColor("#FFFFFFFF"));
        this.f16227b.setTextSize(14.0f);
        LayoutParams layoutParams3 = new LayoutParams(-2, -2);
        layoutParams3.topMargin = C5191i.m21391b(context, 70);
        layoutParams3.leftMargin = C5191i.m21391b(context, 21);
        addView(this.f16227b, layoutParams3);
        setLayoutParams(new ViewGroup.LayoutParams(-1, C5191i.m21391b(context, 167)));
        this.f16228c = new GradientDrawable();
        int b = C5191i.m21391b(context, 6);
        float f = (float) b;
        this.f16228c.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, f, f, f, f});
        setBackground(this.f16228c);
    }

    public void setColor(int i) {
        this.f16228c.setColor(i);
        invalidate();
    }

    public void setDescText(CharSequence charSequence) {
        this.f16227b.setText(charSequence);
    }

    public void setTitleText(CharSequence charSequence) {
        this.f16226a.setText(charSequence);
    }
}
