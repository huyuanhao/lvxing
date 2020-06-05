package com.kwad.sdk.contentalliance.detail.photo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.p306a.C3809l;
import com.kwad.sdk.p306a.C3811n;

public class PhotoBottomView extends FrameLayout {
    /* renamed from: a */
    private ImageView f13161a;
    /* renamed from: b */
    private TextView f13162b;
    /* renamed from: c */
    private TextView f13163c;

    public PhotoBottomView(Context context) {
        this(context, null);
    }

    public PhotoBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m16151a();
    }

    /* renamed from: a */
    private void m16151a() {
        LayoutInflater.from(getContext()).inflate(C3809l.m15792b(getContext(), "ksad_content_alliance_detail_photo_bottom"), this, true);
        this.f13161a = (ImageView) findViewById(C3809l.m15789a(getContext(), "ksad_photo_bottom_author_icon"));
        this.f13162b = (TextView) findViewById(C3809l.m15789a(getContext(), "ksad_photo_bottom_author_name"));
        this.f13163c = (TextView) findViewById(C3809l.m15789a(getContext(), "ksad_photo_bottom_photo_describe"));
    }

    public void setAuthorIcon(String str) {
        KSImageLoader.loadAuthorCircleIcon(this.f13161a, str);
    }

    public void setAuthorName(String str) {
        TextView textView = this.f13162b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setPhotoDescribe(String str) {
        TextView textView = this.f13163c;
        if (textView != null) {
            textView.setText(C3811n.m15816c(str));
        }
    }
}
