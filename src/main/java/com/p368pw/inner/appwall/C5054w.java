package com.p368pw.inner.appwall;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.p368pw.inner.base.p387d.C5191i;
import com.pw.R;

/* renamed from: com.pw.inner.appwall.w */
public class C5054w extends FrameLayout {
    /* renamed from: a */
    private TextView f16538a;

    public C5054w(Context context) {
        this(context, null);
    }

    public C5054w(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C5054w(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m21086a(context);
    }

    /* renamed from: a */
    private void m21086a(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.win_sdk_refresh);
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(context);
        textView.setTextSize(15.0f);
        String str = "#666666";
        textView.setTextColor(Color.parseColor(str));
        textView.setText("网络开小差了，请重试");
        LayoutParams layoutParams2 = new LayoutParams(-2, -2);
        layoutParams2.topMargin = C5191i.m21391b(context, 11);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        this.f16538a = new TextView(context);
        this.f16538a.setTextSize(14.0f);
        this.f16538a.setTextColor(Color.parseColor(str));
        this.f16538a.setBackgroundResource(R.drawable.win_sdk_bg_refresh);
        this.f16538a.setText("刷新");
        this.f16538a.setGravity(17);
        LayoutParams layoutParams3 = new LayoutParams(C5191i.m21391b(context, 80), C5191i.m21391b(context, 26));
        layoutParams3.topMargin = C5191i.m21391b(context, 14);
        layoutParams3.gravity = 1;
        linearLayout.addView(this.f16538a, layoutParams3);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 17;
        addView(linearLayout, layoutParams4);
    }

    public void setOnRefreshOnClickListener(OnClickListener onClickListener) {
        this.f16538a.setOnClickListener(onClickListener);
    }
}
