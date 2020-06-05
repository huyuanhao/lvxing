package com.kingja.loadsir.callback;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProgressCallback extends Callback {
    private String subTitle;
    private int subTitleStyleRes;
    private String title;
    private int titleStyleRes;

    /* renamed from: com.kingja.loadsir.callback.ProgressCallback$a */
    public static class C3597a {
        /* access modifiers changed from: private */
        /* renamed from: a */
        public String f12339a;
        /* access modifiers changed from: private */
        /* renamed from: b */
        public String f12340b;
        /* access modifiers changed from: private */
        /* renamed from: c */
        public int f12341c;
        /* access modifiers changed from: private */
        /* renamed from: d */
        public int f12342d;
        /* access modifiers changed from: private */
        /* renamed from: e */
        public boolean f12343e;
    }

    /* access modifiers changed from: protected */
    public int onCreateView() {
        return 0;
    }

    private ProgressCallback(C3597a aVar) {
        this.subTitleStyleRes = -1;
        this.titleStyleRes = -1;
        this.title = aVar.f12339a;
        this.subTitle = aVar.f12340b;
        this.subTitleStyleRes = aVar.f12341c;
        this.titleStyleRes = aVar.f12342d;
        setSuccessVisible(aVar.f12343e);
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
        linearLayout.addView(new ProgressBar(context), layoutParams);
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
                textView2.setTextAppearance(context, 16973892);
            } else {
                textView2.setTextAppearance(context, i2);
            }
            linearLayout.addView(textView2, layoutParams);
        }
    }
}
