package com.p368pw.inner.appwall;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.p368pw.inner.base.p387d.C5191i;
import com.pw.R;

/* renamed from: com.pw.inner.appwall.q */
public class C5043q extends FrameLayout {
    /* renamed from: a */
    private ImageView f16472a;
    /* renamed from: b */
    private TextView f16473b;
    /* renamed from: c */
    private TextView f16474c;

    public C5043q(Context context) {
        this(context, null);
    }

    public C5043q(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C5043q(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m21054a(context);
    }

    /* renamed from: a */
    private void m21054a(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        this.f16472a = new ImageView(context);
        this.f16472a.setImageResource(R.drawable.win_sdk_empty);
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        linearLayout.addView(this.f16472a, layoutParams);
        this.f16473b = new TextView(context);
        this.f16473b.setTextSize(15.0f);
        String str = "#666666";
        this.f16473b.setTextColor(Color.parseColor(str));
        this.f16473b.setText("当前暂无任务，建议先前往其他任务场景赚取金币");
        this.f16473b.setLineSpacing(2.0f, 1.3f);
        LayoutParams layoutParams2 = new LayoutParams(-2, -2);
        layoutParams2.topMargin = C5191i.m21391b(context, 11);
        layoutParams2.gravity = 1;
        linearLayout.addView(this.f16473b, layoutParams2);
        this.f16474c = new TextView(context);
        this.f16474c.setVisibility(8);
        this.f16474c.setTextSize(14.0f);
        this.f16474c.setTextSize(15.0f);
        this.f16474c.setTextColor(Color.parseColor(str));
        this.f16474c.setText("去做任务");
        int b = C5191i.m21391b(context, 11);
        int b2 = C5191i.m21391b(context, 3);
        this.f16474c.setPadding(b, b2, b, b2);
        this.f16474c.setBackground(ContextCompat.getDrawable(context, R.drawable.win_sdk_signin_empty_btn));
        LayoutParams layoutParams3 = new LayoutParams(-2, -2);
        layoutParams3.topMargin = C5191i.m21391b(context, 25);
        layoutParams3.gravity = 1;
        linearLayout.addView(this.f16474c, layoutParams3);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 17;
        layoutParams4.bottomMargin = C5191i.m21391b(context, 20);
        addView(linearLayout, layoutParams4);
    }
}
