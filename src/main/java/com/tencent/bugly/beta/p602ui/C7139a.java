package com.tencent.bugly.beta.p602ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.global.C7127a;
import com.tencent.bugly.beta.global.C7129c;
import com.tencent.bugly.beta.global.ResBean;
import com.tencent.bugly.beta.utils.C7159e;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.ui.a */
public abstract class C7139a extends C7143b {
    /* renamed from: a */
    protected Context f23759a;
    /* renamed from: b */
    protected View f23760b;
    /* renamed from: c */
    protected FrameLayout f23761c;
    /* renamed from: d */
    protected LinearLayout f23762d;
    /* renamed from: e */
    protected ImageView f23763e;
    /* renamed from: f */
    protected TextView f23764f;
    /* renamed from: g */
    protected TextView f23765g;
    /* renamed from: h */
    protected TextView f23766h;
    /* renamed from: i */
    protected LinearLayout f23767i;
    /* renamed from: j */
    protected ResBean f23768j;
    /* renamed from: k */
    protected int f23769k;
    /* renamed from: l */
    protected int f23770l;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f23759a = getActivity();
        this.f23768j = ResBean.f23687a;
        int i = this.f23770l;
        String str = Beta.TAG_CONFIRM_BUTTON;
        String str2 = Beta.TAG_CANCEL_BUTTON;
        String str3 = Beta.TAG_TITLE;
        if (i == 0) {
            this.f23760b = new RelativeLayout(this.f23759a);
            ((RelativeLayout) this.f23760b).setGravity(17);
            this.f23760b.setBackgroundColor(Color.argb(100, 0, 0, 0));
            this.f23761c = new FrameLayout(this.f23759a);
            this.f23761c.setLayoutParams(new LayoutParams(-2, -2));
            this.f23762d = new LinearLayout(this.f23759a);
            this.f23762d.setBackgroundColor(-1);
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            this.f23762d.setGravity(17);
            this.f23762d.setLayoutParams(layoutParams);
            this.f23762d.setMinimumWidth(C7127a.m30540a(this.f23759a, 280.0f));
            this.f23762d.setOrientation(1);
            if (this.f23769k == 2) {
                float a = (float) C7127a.m30540a(this.f23759a, 6.0f);
                ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{a, a, a, a, a, a, a, a}, null, null));
                shapeDrawable.getPaint().setColor(-1);
                shapeDrawable.getPaint().setStyle(Style.FILL_AND_STROKE);
                this.f23762d.setBackgroundDrawable(shapeDrawable);
            }
            this.f23764f = new TextView(this.f23759a);
            this.f23764f.setGravity(16);
            this.f23764f.setSingleLine();
            TextView textView = this.f23764f;
            this.f23768j.getClass();
            textView.setTextColor(Color.parseColor("#273238"));
            this.f23764f.setTextSize(18.0f);
            this.f23764f.setLayoutParams(layoutParams);
            this.f23764f.setOnClickListener(null);
            this.f23764f.setEllipsize(TruncateAt.END);
            int a2 = C7127a.m30540a(this.f23759a, 16.0f);
            this.f23764f.setPadding(a2, 0, a2, 0);
            this.f23764f.setTypeface(null, 1);
            this.f23764f.setHeight(C7127a.m30540a(this.f23759a, 42.0f));
            this.f23764f.setTag(str3);
            TextView textView2 = new TextView(this.f23759a);
            textView2.setBackgroundColor(-3355444);
            textView2.setHeight(1);
            ScrollView scrollView = new ScrollView(this.f23759a);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.setMargins(0, 0, 0, C7127a.m30540a(this.f23759a, 52.0f));
            scrollView.setLayoutParams(layoutParams2);
            scrollView.setFillViewport(true);
            scrollView.setVerticalScrollBarEnabled(false);
            scrollView.setHorizontalScrollBarEnabled(false);
            this.f23767i = new LinearLayout(this.f23759a);
            this.f23767i.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.f23767i.setOrientation(1);
            this.f23767i.setPadding(a2, C7127a.m30540a(this.f23759a, 10.0f), a2, 0);
            LinearLayout linearLayout = new LinearLayout(this.f23759a);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setGravity(17);
            linearLayout.setOrientation(0);
            int i2 = a2 / 2;
            linearLayout.setPadding(i2, a2, i2, a2);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams3.gravity = 80;
            linearLayout.setLayoutParams(layoutParams3);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -2, 1.0f);
            layoutParams4.setMargins(i2, 0, i2, 0);
            this.f23765g = new TextView(this.f23759a);
            this.f23765g.setSingleLine();
            this.f23765g.setGravity(17);
            this.f23765g.setTag(str2);
            new RelativeLayout.LayoutParams(-2, -2);
            int a3 = C7127a.m30540a(this.f23759a, 30.0f);
            if (this.f23769k == 2) {
                FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(a3, a3);
                layoutParams5.gravity = 53;
                this.f23765g.setLayoutParams(layoutParams5);
                this.f23765g.setTextSize((float) (((double) a3) * 0.3d));
            } else {
                this.f23765g.setLayoutParams(layoutParams4);
                this.f23765g.setTextSize((float) 16);
                TextView textView3 = this.f23765g;
                this.f23768j.getClass();
                textView3.setTextColor(Color.parseColor("#757575"));
                this.f23765g.setPadding(C7127a.m30540a(this.f23759a, 10.0f), C7127a.m30540a(this.f23759a, 5.0f), C7127a.m30540a(this.f23759a, 10.0f), C7127a.m30540a(this.f23759a, 5.0f));
            }
            this.f23766h = new TextView(this.f23759a);
            this.f23766h.setLayoutParams(layoutParams4);
            this.f23766h.setGravity(17);
            this.f23766h.setTextSize((float) 16);
            TextView textView4 = this.f23766h;
            this.f23768j.getClass();
            textView4.setTextColor(Color.parseColor("#273238"));
            this.f23766h.setSingleLine();
            this.f23766h.setPadding(C7127a.m30540a(this.f23759a, 10.0f), C7127a.m30540a(this.f23759a, 5.0f), C7127a.m30540a(this.f23759a, 10.0f), C7127a.m30540a(this.f23759a, 5.0f));
            this.f23766h.setTypeface(null, 1);
            this.f23766h.setTag(str);
            int a4 = C7127a.m30540a(this.f23759a, 40.0f);
            scrollView.addView(this.f23767i);
            if (this.f23769k == 2) {
                FrameLayout frameLayout = new FrameLayout(this.f23759a);
                frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
                int i3 = a3 / 2;
                int i4 = i3 - 5;
                this.f23761c.setPadding(i3, i4, i4, i3);
                frameLayout.addView(this.f23761c);
                frameLayout.addView(this.f23765g);
                ((RelativeLayout) this.f23760b).addView(frameLayout);
            } else {
                this.f23760b.setPadding(a4, a4, a4, a4);
                ((RelativeLayout) this.f23760b).addView(this.f23761c);
                linearLayout.addView(this.f23765g);
            }
            this.f23762d.addView(this.f23764f);
            this.f23762d.addView(textView2);
            this.f23762d.addView(scrollView);
            this.f23761c.addView(this.f23762d);
            linearLayout.addView(this.f23766h);
            this.f23761c.addView(linearLayout);
            if (this.f23769k == 2) {
                Paint paint = new Paint();
                paint.setStyle(Style.FILL);
                paint.setAntiAlias(true);
                Bitmap createBitmap = Bitmap.createBitmap(a3, a3, Config.ARGB_8888);
                int i5 = a3 / 2;
                Canvas canvas = new Canvas(createBitmap);
                paint.setColor(-3355444);
                float f = (float) i5;
                canvas.drawCircle(f, f, f, paint);
                canvas.rotate(45.0f, f, f);
                paint.setColor(-7829368);
                int a5 = C7127a.m30540a(this.f23759a, 0.8f);
                float f2 = f * 0.4f;
                float f3 = (float) (i5 - a5);
                float f4 = f * 1.6f;
                float f5 = (float) (i5 + a5);
                Canvas canvas2 = canvas;
                Paint paint2 = paint;
                canvas2.drawRect(f2, f3, f4, f5, paint2);
                canvas2.drawRect(f3, f2, f5, f4, paint2);
                canvas.rotate(-45.0f);
                Bitmap createBitmap2 = Bitmap.createBitmap(a3, a3, Config.ARGB_8888);
                Canvas canvas3 = new Canvas(createBitmap2);
                paint.setColor(-7829368);
                canvas3.drawCircle(f, f, f, paint);
                canvas3.rotate(45.0f, f, f);
                paint.setColor(-3355444);
                Canvas canvas4 = canvas3;
                canvas4.drawRect(f2, f3, f4, f5, paint2);
                canvas4.drawRect(f3, f2, f5, f4, paint2);
                canvas3.rotate(-45.0f);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
                BitmapDrawable bitmapDrawable2 = new BitmapDrawable(createBitmap2);
                this.f23765g.setBackgroundDrawable(bitmapDrawable);
                this.f23765g.setOnTouchListener(new C7129c(1, bitmapDrawable2, bitmapDrawable));
            }
            this.f23760b.setOnClickListener(null);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(300);
            this.f23760b.startAnimation(alphaAnimation);
        } else {
            this.f23760b = layoutInflater.inflate(i, null);
            this.f23763e = (ImageView) this.f23760b.findViewWithTag(Beta.TAG_IMG_BANNER);
            this.f23764f = (TextView) this.f23760b.findViewWithTag(str3);
            this.f23765g = (TextView) this.f23760b.findViewWithTag(str2);
            this.f23766h = (TextView) this.f23760b.findViewWithTag(str);
        }
        this.f23765g.setVisibility(8);
        this.f23766h.setVisibility(8);
        this.f23765g.setFocusable(true);
        this.f23766h.setFocusable(true);
        this.f23766h.requestFocus();
        return this.f23760b;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f23759a = null;
        this.f23760b = null;
        this.f23761c = null;
        this.f23762d = null;
        this.f23764f = null;
        this.f23763e = null;
        this.f23765g = null;
        this.f23766h = null;
        this.f23767i = null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo34435a(String str, OnClickListener onClickListener, String str2, OnClickListener onClickListener2) {
        final String str3 = str;
        final OnClickListener onClickListener3 = onClickListener;
        final String str4 = str2;
        final OnClickListener onClickListener4 = onClickListener2;
        C71401 r0 = new Runnable() {
            public void run() {
                if (C7139a.this.f23765g != null && C7139a.this.f23766h != null) {
                    if (str3 != null) {
                        C7139a.this.f23765g.setVisibility(0);
                        if (C7139a.this.f23769k != 2) {
                            C7139a.this.f23765g.setText(str3);
                            if (C7139a.this.f23770l == 0) {
                                C7139a.this.f23765g.getViewTreeObserver().addOnPreDrawListener(new C7145d(2, Integer.valueOf(C7139a.this.f23769k), C7139a.this.f23765g, Integer.valueOf(1)));
                            }
                        }
                        C7139a.this.f23765g.setOnClickListener(onClickListener3);
                    }
                    if (str4 != null) {
                        C7139a.this.f23766h.setVisibility(0);
                        C7139a.this.f23766h.setText(str4);
                        C7139a.this.f23766h.setOnClickListener(onClickListener4);
                        if (C7139a.this.f23770l == 0) {
                            C7139a.this.f23766h.getViewTreeObserver().addOnPreDrawListener(new C7145d(2, Integer.valueOf(C7139a.this.f23769k), C7139a.this.f23766h, Integer.valueOf(1)));
                        }
                        C7139a.this.f23766h.requestFocus();
                    }
                }
            }
        };
        C7159e.m30681a(r0);
    }

    /* renamed from: a */
    public void mo34434a() {
        if (this.f23760b == null) {
            super.mo34434a();
            return;
        }
        final AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(200);
        C7159e.m30681a(new Runnable() {
            public void run() {
                if (C7139a.this.f23760b != null) {
                    C7139a.this.f23760b.startAnimation(alphaAnimation);
                }
            }
        });
        alphaAnimation.setAnimationListener(new AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                if (C7139a.this.f23760b != null) {
                    C7139a.this.f23760b.setVisibility(8);
                }
                C7139a.super.mo34434a();
            }
        });
    }
}
