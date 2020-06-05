package com.bytedance.sdk.openadsdk.component.reward.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.utils.UIUtils;

public class RewardDislikeToast extends FrameLayout {
    /* renamed from: a */
    private Handler f7046a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public TextView f7047b;

    public RewardDislikeToast(Context context) {
        this(context, null);
    }

    public RewardDislikeToast(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RewardDislikeToast(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7046a = new Handler(Looper.getMainLooper());
        setVisibility(8);
        setClickable(false);
        setFocusable(false);
        m8863a(context);
    }

    /* renamed from: a */
    private void m8863a(Context context) {
        this.f7047b = new TextView(context);
        this.f7047b.setClickable(false);
        this.f7047b.setFocusable(false);
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        int a = (int) UIUtils.m12048a(InternalContainer.m10059a(), 20.0f);
        int a2 = (int) UIUtils.m12048a(InternalContainer.m10059a(), 12.0f);
        this.f7047b.setPadding(a, a2, a, a2);
        this.f7047b.setLayoutParams(layoutParams);
        this.f7047b.setTextColor(-1);
        this.f7047b.setTextSize(16.0f);
        this.f7047b.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#CC000000"));
        gradientDrawable.setCornerRadius(UIUtils.m12048a(InternalContainer.m10059a(), 6.0f));
        this.f7047b.setBackgroundDrawable(gradientDrawable);
        addView(this.f7047b);
    }

    /* renamed from: a */
    public void mo15199a(final String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f7046a.removeCallbacksAndMessages(null);
            this.f7046a.post(new Runnable() {
                public void run() {
                    if (RewardDislikeToast.this.f7047b != null) {
                        RewardDislikeToast.this.f7047b.setText(String.valueOf(str));
                    }
                    RewardDislikeToast.this.setVisibility(0);
                }
            });
            this.f7046a.postDelayed(new Runnable() {
                public void run() {
                    RewardDislikeToast.this.setVisibility(8);
                }
            }, 2000);
        }
    }

    /* renamed from: a */
    public void mo15198a() {
        setVisibility(8);
        this.f7046a.removeCallbacksAndMessages(null);
    }

    /* renamed from: b */
    public void mo15200b() {
        setVisibility(8);
        this.f7046a.removeCallbacksAndMessages(null);
    }
}
