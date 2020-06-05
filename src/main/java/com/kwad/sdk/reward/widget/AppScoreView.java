package com.kwad.sdk.reward.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.kwad.sdk.p306a.C3809l;

public class AppScoreView extends LinearLayout {
    /* renamed from: a */
    private ImageView f14786a;
    /* renamed from: b */
    private ImageView f14787b;

    public AppScoreView(Context context) {
        this(context, null);
    }

    public AppScoreView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppScoreView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18437a();
    }

    /* renamed from: a */
    private void m18437a() {
        inflate(getContext(), C3809l.m15792b(getContext(), "ksad_app_score"), this);
        this.f14786a = (ImageView) findViewById(C3809l.m15789a(getContext(), "ksad_score_fourth"));
        this.f14787b = (ImageView) findViewById(C3809l.m15789a(getContext(), "ksad_score_fifth"));
    }

    public void setScore(float f) {
        ImageView imageView;
        int d;
        ImageView imageView2;
        int d2;
        String str = "ksad_app_score_yellow";
        if (f >= 5.0f) {
            this.f14786a.setImageResource(C3809l.m15795d(getContext(), str));
            imageView2 = this.f14787b;
            d2 = C3809l.m15795d(getContext(), str);
        } else {
            double d3 = (double) f;
            String str2 = "ksad_app_score_half";
            if (d3 >= 4.5d) {
                this.f14786a.setImageResource(C3809l.m15795d(getContext(), str));
                this.f14787b.setImageResource(C3809l.m15795d(getContext(), str2));
                return;
            }
            String str3 = "ksad_app_score_gray";
            if (d3 >= 4.0d) {
                imageView = this.f14786a;
                d = C3809l.m15795d(getContext(), str);
            } else if (d3 >= 3.5d) {
                this.f14786a.setImageResource(C3809l.m15795d(getContext(), str2));
                imageView2 = this.f14787b;
                d2 = C3809l.m15795d(getContext(), str3);
            } else if (d3 >= 3.0d) {
                imageView = this.f14786a;
                d = C3809l.m15795d(getContext(), str3);
            } else {
                return;
            }
            imageView.setImageResource(d);
            imageView2 = this.f14787b;
            d2 = C3809l.m15795d(getContext(), str3);
        }
        imageView2.setImageResource(d2);
    }

    public void setScore(int i) {
        if (i < 0) {
            i = 0;
        }
        setScore(((float) i) / 10.0f);
    }
}
