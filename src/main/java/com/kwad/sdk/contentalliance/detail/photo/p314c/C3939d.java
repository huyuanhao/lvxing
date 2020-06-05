package com.kwad.sdk.contentalliance.detail.photo.p314c;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.kwad.sdk.p306a.C3809l;

/* renamed from: com.kwad.sdk.contentalliance.detail.photo.c.d */
public class C3939d extends LinearLayout {
    public C3939d(Context context) {
        this(context, null);
    }

    public C3939d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m16333a();
    }

    /* renamed from: a */
    private void m16333a() {
        LayoutInflater.from(getContext()).inflate(C3809l.m15792b(getContext(), "ksad_content_alliance_photo_more_button"), this, true);
    }
}
