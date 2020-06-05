package com.p368pw.inner.appwall;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.p368pw.inner.C5233e;
import com.p368pw.inner.base.p387d.C5191i;
import com.pw.R;

/* renamed from: com.pw.inner.appwall.ac */
public class C4981ac extends Dialog {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public OnClickListener f16205a;

    public C4981ac(Context context) {
        super(context, R.style.win_sdk_no_dim_dialog);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(C5191i.m21391b(context, 25), C5191i.m21391b(context, 20), C5191i.m21391b(context, 25), 0);
        TextView textView = new TextView(context);
        textView.setTextSize(18.0f);
        String str = "#FF303430";
        textView.setTextColor(Color.parseColor(str));
        textView.setText("温馨提示");
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        linearLayout.addView(textView, layoutParams);
        TextView textView2 = new TextView(context);
        textView2.setText("检测到您当前应用可能无法获取奖励，请前往设置，允许当前应用查看应用使用情况已解决这个问题。");
        textView2.setTextSize(13.0f);
        textView2.setTextColor(Color.parseColor(str));
        LayoutParams layoutParams2 = new LayoutParams(-2, -2);
        layoutParams2.topMargin = C5191i.m21391b(context, 10);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView2, layoutParams2);
        TextView textView3 = new TextView(context);
        textView3.setText("点击下方按钮，前往设置页面。在设置页面中找到本应用，打开开关即可");
        textView3.setTextSize(12.0f);
        textView3.setTextColor(Color.parseColor("#FFA2A6A2"));
        LayoutParams layoutParams3 = new LayoutParams(-2, -2);
        layoutParams3.topMargin = C5191i.m21391b(context, 8);
        layoutParams3.gravity = 1;
        linearLayout.addView(textView3, layoutParams3);
        FrameLayout frameLayout = new FrameLayout(context);
        LayoutParams layoutParams4 = new LayoutParams(-1, C5191i.m21391b(context, 34));
        layoutParams4.topMargin = C5191i.m21391b(context, 10);
        linearLayout.addView(frameLayout, layoutParams4);
        ImageView imageView = new ImageView(context);
        Drawable h = C5191i.m21405h(C5233e.m21559b());
        if (h != null) {
            imageView.setImageDrawable(h);
        }
        frameLayout.addView(imageView, new FrameLayout.LayoutParams(C5191i.m21391b(context, 34), C5191i.m21391b(context, 34)));
        TextView textView4 = new TextView(context);
        textView4.setText(C5191i.m21406i(C5233e.m21559b()));
        textView4.setTextSize(13.0f);
        textView4.setTextColor(Color.parseColor(str));
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 16;
        layoutParams5.leftMargin = C5191i.m21391b(context, 44);
        frameLayout.addView(textView4, layoutParams5);
        C5068z zVar = new C5068z(context);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(C5191i.m21391b(context, 28), C5191i.m21391b(context, 14));
        layoutParams6.gravity = 21;
        frameLayout.addView(zVar, layoutParams6);
        TextView textView5 = new TextView(context);
        textView5.setTextSize(14.0f);
        textView5.setTextColor(Color.parseColor("#FFFFF6D1"));
        textView5.setText("去设置");
        textView5.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(200.0f);
        gradientDrawable.setColors(new int[]{Color.parseColor("#FFF14656"), Color.parseColor("#FFFE7B3F")});
        textView5.setBackground(gradientDrawable);
        LayoutParams layoutParams7 = new LayoutParams(C5191i.m21391b(context, 174), C5191i.m21391b(context, 38));
        layoutParams7.topMargin = C5191i.m21391b(context, 38);
        layoutParams7.gravity = 1;
        linearLayout.addView(textView5, layoutParams7);
        textView5.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C4981ac.this.dismiss();
                if (C4981ac.this.f16205a != null) {
                    C4981ac.this.f16205a.onClick(view);
                }
            }
        });
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(Color.parseColor("#FFFFFF"));
        gradientDrawable2.setCornerRadius((float) C5191i.m21391b(context, 25));
        linearLayout.setBackground(gradientDrawable2);
        addContentView(linearLayout, new ViewGroup.LayoutParams(C5191i.m21391b(context, 320), C5191i.m21391b(context, 282)));
    }

    /* renamed from: a */
    public C4981ac mo26354a(OnClickListener onClickListener) {
        this.f16205a = onClickListener;
        return this;
    }

    public void show() {
        Activity ownerActivity = getOwnerActivity();
        if (ownerActivity != null && !ownerActivity.isFinishing()) {
            super.show();
        }
    }
}
