package com.qiyukf.unicorn.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qiyukf.basesdk.p412c.p417d.C5412d;
import com.qiyukf.nim.uikit.C5426a;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.p502e.C6047e;

public class BotActionItemView extends LinearLayout {
    /* renamed from: a */
    private C6047e f19792a;
    /* renamed from: b */
    private ValueAnimator f19793b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public float f19794c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public float f19795d;
    /* renamed from: e */
    private Long f19796e;
    /* renamed from: f */
    private Long f19797f;
    /* renamed from: g */
    private Boolean f19798g;
    /* renamed from: h */
    private View f19799h;
    /* renamed from: i */
    private Context f19800i;

    public BotActionItemView(Context context) {
        this(context, null);
    }

    public BotActionItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19794c = 0.1f;
        this.f19795d = (float) C5412d.m22146a(350.0f);
        this.f19796e = Long.valueOf(1000);
        this.f19797f = Long.valueOf(100);
        this.f19798g = Boolean.valueOf(false);
        this.f19800i = context;
        this.f19799h = LayoutInflater.from(this.f19800i).inflate(C5961R.C5964layout.ysf_message_quick_entry_item, this);
    }

    /* renamed from: a */
    public final void mo29551a(C6047e eVar) {
        this.f19792a = eVar;
        ImageView imageView = (ImageView) this.f19799h.findViewById(C5961R.C5963id.ysf_quick_entry_icon);
        TextView textView = (TextView) this.f19799h.findViewById(C5961R.C5963id.ysf_quick_entry_text);
        if (!TextUtils.isEmpty(eVar.getIconUrl())) {
            imageView.setVisibility(0);
            C5426a.m22178a(eVar.getIconUrl(), imageView);
        }
        textView.setText(eVar.getName());
    }

    /* renamed from: a */
    public final void mo29552a(Boolean bool) {
        this.f19798g = bool;
        if (bool.booleanValue() && VERSION.SDK_INT >= 11) {
            this.f19793b = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.f19793b.setDuration(this.f19796e.longValue());
            this.f19793b.setStartDelay(this.f19797f.longValue());
            this.f19793b.setInterpolator(new AccelerateDecelerateInterpolator());
            this.f19793b.setTarget(this);
            this.f19793b.addUpdateListener(new AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    BotActionItemView botActionItemView = BotActionItemView.this;
                    botActionItemView.setAlpha(botActionItemView.f19794c + ((1.0f - BotActionItemView.this.f19794c) * floatValue));
                    BotActionItemView botActionItemView2 = BotActionItemView.this;
                    botActionItemView2.setTranslationX(botActionItemView2.f19795d - (BotActionItemView.this.f19795d * floatValue));
                }
            });
        }
    }

    /* renamed from: a */
    public final void mo29553a(Long l) {
        this.f19797f = l;
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.f19798g.booleanValue()) {
            if (i == 0) {
                if (VERSION.SDK_INT >= 11) {
                    setAlpha(this.f19794c);
                    setTranslationX(this.f19795d);
                    this.f19793b.start();
                }
            } else if (VERSION.SDK_INT >= 11) {
                this.f19793b.end();
            }
        }
    }
}
