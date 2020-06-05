package com.kwad.sdk.contentalliance.detail.photo.p312a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.sdk.p306a.C3809l;

/* renamed from: com.kwad.sdk.contentalliance.detail.photo.a.f */
public class C3897f extends LinearLayout {
    /* renamed from: a */
    private ImageView f13190a;
    /* renamed from: b */
    private TextView f13191b;

    public C3897f(Context context) {
        this(context, null);
    }

    public C3897f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13190a = null;
        this.f13191b = null;
        m16188a();
    }

    /* renamed from: a */
    private void m16188a() {
        LayoutInflater.from(getContext()).inflate(C3809l.m15792b(getContext(), "ksad_content_alliance_func_button"), this, true);
        this.f13190a = (ImageView) findViewById(C3809l.m15789a(getContext(), "ksad_photo_func_button_image"));
        this.f13191b = (TextView) findViewById(C3809l.m15789a(getContext(), "ksad_photo_func_button_text"));
    }

    public void setButtonImageResource(String str) {
        this.f13190a.setImageResource(C3809l.m15795d(getContext(), str));
    }

    public void setButtonText(String str) {
        this.f13191b.setText(str);
    }
}
