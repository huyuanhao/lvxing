package com.kwad.sdk.contentalliance.detail.photo.p314c;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.sdk.p306a.C3809l;
import com.kwad.sdk.p306a.C3811n;

/* renamed from: com.kwad.sdk.contentalliance.detail.photo.c.f */
public class C3942f extends LinearLayout {
    /* renamed from: a */
    private TextView f13290a;

    public C3942f(Context context) {
        this(context, null);
    }

    public C3942f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13290a = null;
        m16341a();
    }

    /* renamed from: a */
    private void m16341a() {
        LayoutInflater.from(getContext()).inflate(C3809l.m15792b(getContext(), "ksad_content_alliance_photo_comment_button"), this, true);
        this.f13290a = (TextView) findViewById(C3809l.m15789a(getContext(), "ksad_photo_comment_count_text"));
    }

    public void setCommentCount(long j) {
        this.f13290a.setText(C3811n.m15809a(j, "评论"));
    }
}
