package com.p368pw.inner.appwall;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.util.AttributeSet;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.p368pw.inner.base.p387d.C5191i;
import com.pw.R;

/* renamed from: com.pw.inner.appwall.ae */
public class C4988ae extends FrameLayout {
    /* renamed from: a */
    private TextView f16223a;
    /* renamed from: b */
    private TextView f16224b;
    /* renamed from: c */
    private GradientDrawable f16225c;

    public C4988ae(Context context) {
        this(context, null);
    }

    public C4988ae(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C4988ae(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.win_sdk_app_wall_sign_title);
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 21;
        addView(imageView, layoutParams);
        this.f16223a = new TextView(context);
        this.f16223a.setTextColor(Color.parseColor("#FF303430"));
        this.f16223a.setTextSize(16.0f);
        this.f16223a.setTypeface(Typeface.DEFAULT_BOLD);
        LayoutParams layoutParams2 = new LayoutParams(-2, -2);
        layoutParams2.topMargin = C5191i.m21391b(context, 16);
        layoutParams2.leftMargin = C5191i.m21391b(context, 24);
        addView(this.f16223a, layoutParams2);
        this.f16224b = new TextView(context);
        this.f16224b.setTextColor(Color.parseColor("#FF8F8F8F"));
        this.f16224b.setTextSize(12.0f);
        LayoutParams layoutParams3 = new LayoutParams(-2, -2);
        layoutParams3.gravity = 80;
        layoutParams3.bottomMargin = C5191i.m21391b(context, 13);
        layoutParams3.leftMargin = C5191i.m21391b(context, 24);
        addView(this.f16224b, layoutParams3);
        setLayoutParams(new MarginLayoutParams(-1, C5191i.m21391b(context, 71)));
        this.f16225c = new GradientDrawable();
        this.f16225c.setCornerRadius((float) C5191i.m21391b(context, 100));
        this.f16225c.setColors(new int[]{Color.parseColor("#FFFFDDD0"), Color.parseColor("#FFFFB194")});
        this.f16225c.setOrientation(Orientation.LEFT_RIGHT);
        setBackground(this.f16225c);
    }

    public void setDescText(CharSequence charSequence) {
        this.f16224b.setText(charSequence);
    }

    public void setTitleText(CharSequence charSequence) {
        this.f16223a.setText(charSequence);
    }
}
