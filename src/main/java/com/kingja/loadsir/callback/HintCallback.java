package com.kingja.loadsir.callback;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class HintCallback extends Callback {
    private int imgResId;
    private String subTitle;
    private int subTitleStyleRes;
    private String title;
    private int titleStyleRes;

    /* renamed from: com.kingja.loadsir.callback.HintCallback$a */
    public static class C3595a {
        /* access modifiers changed from: private */
        /* renamed from: a */
        public String f12334a;
        /* access modifiers changed from: private */
        /* renamed from: b */
        public String f12335b;
        /* access modifiers changed from: private */
        /* renamed from: c */
        public int f12336c;
        /* access modifiers changed from: private */
        /* renamed from: d */
        public int f12337d;
        /* access modifiers changed from: private */
        /* renamed from: e */
        public int f12338e;
    }

    /* access modifiers changed from: protected */
    public int onCreateView() {
        return 0;
    }

    public HintCallback(C3595a aVar) {
        this.title = aVar.f12334a;
        this.subTitle = aVar.f12335b;
        this.imgResId = aVar.f12336c;
        this.subTitleStyleRes = aVar.f12337d;
        this.titleStyleRes = aVar.f12338e;
    }

    /* access modifiers changed from: protected */
    public View onBuildView(Context context) {
        return new LinearLayout(context);
    }

    /* access modifiers changed from: protected */
    public void onViewCreate(Context context, View view) {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        LinearLayout linearLayout = (LinearLayout) view;
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        if (this.imgResId != -1) {
            ImageView imageView = new ImageView(context);
            imageView.setBackgroundResource(this.imgResId);
            linearLayout.addView(imageView, layoutParams);
        }
        if (!TextUtils.isEmpty(this.title)) {
            TextView textView = new TextView(context);
            textView.setText(this.title);
            int i = this.titleStyleRes;
            if (i == -1) {
                textView.setTextAppearance(context, 16973890);
            } else {
                textView.setTextAppearance(context, i);
            }
            linearLayout.addView(textView, layoutParams);
        }
        if (!TextUtils.isEmpty(this.subTitle)) {
            TextView textView2 = new TextView(context);
            textView2.setText(this.subTitle);
            int i2 = this.subTitleStyleRes;
            if (i2 == -1) {
                textView2.setTextAppearance(context, 16973894);
            } else {
                textView2.setTextAppearance(context, i2);
            }
            linearLayout.addView(textView2, layoutParams);
        }
    }
}
