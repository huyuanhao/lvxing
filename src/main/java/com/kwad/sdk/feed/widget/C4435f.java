package com.kwad.sdk.feed.widget;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.sdk.core.download.p323a.C4092c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.page.AdWebViewActivity;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4322a;
import com.kwad.sdk.feed.FeedDownloadActivity;
import com.kwad.sdk.feed.widget.base.C4419a;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.p306a.C3809l;
import java.util.List;

/* renamed from: com.kwad.sdk.feed.widget.f */
public class C4435f extends C4419a implements OnClickListener {
    /* renamed from: f */
    private TextView f14531f;
    /* renamed from: g */
    private ImageView f14532g;
    /* renamed from: h */
    private ImageView f14533h;

    public C4435f(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo24712a() {
        ((RatioFrameLayout) findViewById(C3809l.m15789a(this.f14495d, "ksad_container"))).setRatio(0.56f);
        this.f14531f = (TextView) findViewById(C3809l.m15789a(this.f14495d, "ksad_ad_desc"));
        this.f14532g = (ImageView) findViewById(C3809l.m15789a(this.f14495d, "ksad_ad_image"));
        this.f14533h = (ImageView) findViewById(C3809l.m15789a(this.f14495d, "ksad_ad_dislike"));
    }

    /* renamed from: a */
    public void mo24713a(AdTemplate adTemplate) {
        super.mo24713a(adTemplate);
        this.f14531f.setText(C4322a.m17643k(this.f14493b));
        List x = C4322a.m17656x(this.f14493b);
        if (x.size() >= 1) {
            KSImageLoader.loadFeeImage(this.f14532g, (String) x.get(0));
        } else {
            C4065b.m16869d("FeedTextImmerseImageView", "getImageUrlList size less than one");
        }
        this.f14533h.setOnClickListener(this);
        setOnClickListener(this);
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return C3809l.m15792b(this.f14495d, "ksad_feed_text_immerse_image");
    }

    public void onClick(View view) {
        if (view == this.f14533h) {
            mo24721d();
        } else if (C4092c.m16996a(getContext(), this.f14492a) == 1) {
            mo24720c();
        } else if (C4322a.m17651s(this.f14493b)) {
            FeedDownloadActivity.m17995a(this.f14495d, this.f14492a, this.f14494c);
        } else {
            mo24720c();
            AdWebViewActivity.m17486a((Activity) getContext(), this.f14492a);
        }
    }
}
