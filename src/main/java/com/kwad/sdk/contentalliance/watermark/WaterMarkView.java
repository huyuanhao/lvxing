package com.kwad.sdk.contentalliance.watermark;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.sdk.p306a.C3809l;

public class WaterMarkView extends FrameLayout {
    /* renamed from: a */
    private ImageView f13613a;
    /* renamed from: b */
    private TextView f13614b;

    public WaterMarkView(Context context) {
        this(context, null);
    }

    public WaterMarkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m16803a();
    }

    /* renamed from: a */
    private void m16803a() {
        LayoutInflater.from(getContext()).inflate(C3809l.m15792b(getContext(), "ksad_video_water_mark"), this, true);
        this.f13613a = (ImageView) findViewById(C3809l.m15789a(getContext(), "ksad_video_water_mark_logo"));
        this.f13614b = (TextView) findViewById(C3809l.m15789a(getContext(), "ksad_video_water_mark_text"));
    }

    public void setAlignment(int i) {
        LayoutParams layoutParams = (LayoutParams) this.f13613a.getLayoutParams();
        LayoutParams layoutParams2 = (LayoutParams) this.f13614b.getLayoutParams();
        int i2 = i == 1 ? 5 : 3;
        layoutParams.gravity = i2;
        layoutParams2.gravity = i2;
        this.f13613a.setLayoutParams(layoutParams);
        this.f13614b.setLayoutParams(layoutParams2);
    }

    public void setAuthorId(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        TextView textView = this.f13614b;
        if (i == 0) {
            textView.setVisibility(4);
        } else {
            textView.setVisibility(0);
        }
        this.f13614b.setText(String.format("快手ID：%d", new Object[]{Long.valueOf(j)}));
    }
}
