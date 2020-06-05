package com.kwad.sdk.feed.widget;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.sdk.core.download.p323a.C4087a;
import com.kwad.sdk.core.download.p323a.C4087a.C4088a;
import com.kwad.sdk.core.download.p323a.C4089b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4322a;
import com.kwad.sdk.feed.widget.base.C4419a;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.nativead.KsAppDownloadListener;
import com.kwad.sdk.p306a.C3809l;
import com.kwad.sdk.p306a.C3817t;
import java.util.List;

/* renamed from: com.kwad.sdk.feed.widget.b */
public class C4416b extends C4419a implements OnClickListener {
    /* renamed from: f */
    private TextView f14482f;
    /* renamed from: g */
    private ImageView f14483g;
    /* renamed from: h */
    private ImageView f14484h;
    /* renamed from: i */
    private C4089b f14485i;
    /* access modifiers changed from: private */
    /* renamed from: j */
    public TextView f14486j;
    /* access modifiers changed from: private */
    /* renamed from: k */
    public TextProgressBar f14487k;
    /* renamed from: l */
    private KsAppDownloadListener f14488l = new KsAppDownloadListener() {
        public void onDownloadFinished() {
            C4416b.this.f14486j.setVisibility(8);
            C4416b.this.f14487k.setVisibility(0);
            C4416b.this.f14487k.mo24328a(C4322a.m17630a(), C4416b.this.f14487k.getMax());
        }

        public void onIdle() {
            C4416b.this.f14486j.setText(C4322a.m17650r(C4416b.this.f14493b));
        }

        public void onInstalled() {
            C4416b.this.f14486j.setVisibility(8);
            C4416b.this.f14487k.setVisibility(0);
            C4416b.this.f14487k.mo24328a(C4322a.m17634b(), C4416b.this.f14487k.getMax());
        }

        public void onProgressUpdate(int i) {
            C4416b.this.f14486j.setVisibility(8);
            C4416b.this.f14487k.setVisibility(0);
            C4416b.this.f14487k.mo24328a(C4322a.m17631a(i), i);
        }
    };

    public C4416b(Context context) {
        super(context);
    }

    /* renamed from: e */
    private void m18020e() {
        findViewById(C3809l.m15789a(getContext(), "ksad_ad_h5_container")).setVisibility(0);
        TextView textView = (TextView) findViewById(C3809l.m15789a(getContext(), "ksad_h5_open_btn"));
        ((TextView) findViewById(C3809l.m15789a(getContext(), "ksad_h5_desc"))).setText(C4322a.m17643k(this.f14493b));
        textView.setText(C4322a.m17650r(this.f14493b));
        findViewById(C3809l.m15789a(getContext(), "ksad_h5_open_cover")).setOnClickListener(this);
        textView.setOnClickListener(this);
    }

    /* renamed from: f */
    private void m18021f() {
        findViewById(C3809l.m15789a(getContext(), "ksad_ad_download_container")).setVisibility(0);
        ImageView imageView = (ImageView) findViewById(C3809l.m15789a(getContext(), "ksad_app_icon"));
        TextView textView = (TextView) findViewById(C3809l.m15789a(getContext(), "ksad_app_desc"));
        ((TextView) findViewById(C3809l.m15789a(getContext(), "ksad_app_title"))).setText(C4322a.m17645m(this.f14493b));
        KSImageLoader.loadAppIcon(imageView, C4322a.m17644l(this.f14493b), 8);
        textView.setText(C4322a.m17643k(this.f14493b));
        this.f14486j = (TextView) findViewById(C3809l.m15789a(this.f14495d, "ksad_app_download_before"));
        this.f14486j.setText(C4322a.m17650r(this.f14493b));
        this.f14486j.setVisibility(0);
        this.f14486j.setOnClickListener(this);
        this.f14487k = (TextProgressBar) findViewById(C3809l.m15789a(getContext(), "ksad_app_download_btn"));
        this.f14487k.setTextDimen((float) C3817t.m15862a(getContext(), 11.0f));
        this.f14487k.setTextColor(-1);
        this.f14487k.setVisibility(8);
        this.f14487k.setOnClickListener(this);
        findViewById(C3809l.m15789a(getContext(), "ksad_app_download_cover")).setOnClickListener(this);
        this.f14485i = new C4089b(this.f14492a, null, this.f14488l);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo24712a() {
        this.f14482f = (TextView) findViewById(C3809l.m15789a(this.f14495d, "ksad_ad_desc"));
        ((RatioFrameLayout) findViewById(C3809l.m15789a(this.f14495d, "ksad_image_container"))).setRatio(0.56f);
        this.f14483g = (ImageView) findViewById(C3809l.m15789a(this.f14495d, "ksad_ad_image"));
        this.f14484h = (ImageView) findViewById(C3809l.m15789a(this.f14495d, "ksad_ad_dislike"));
    }

    /* renamed from: a */
    public void mo24713a(AdTemplate adTemplate) {
        super.mo24713a(adTemplate);
        this.f14482f.setText(C4322a.m17643k(this.f14493b));
        List x = C4322a.m17656x(this.f14493b);
        if (x.size() >= 1) {
            KSImageLoader.loadFeeImage(this.f14483g, (String) x.get(0));
        } else {
            C4065b.m16869d("FeedTextAboveImageView", "getImageUrlList size less than one");
        }
        if (C4322a.m17651s(this.f14493b)) {
            m18021f();
        } else {
            m18020e();
        }
        this.f14484h.setOnClickListener(this);
        setOnClickListener(this);
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return C3809l.m15792b(this.f14495d, "ksad_feed_text_above_image");
    }

    public void onClick(View view) {
        if (view == this.f14484h) {
            mo24721d();
        } else {
            C4087a.m16967a(getContext(), this.f14492a, new C4088a() {
                /* renamed from: a */
                public void mo23360a() {
                    C4416b.this.mo24720c();
                }
            }, this.f14485i);
        }
    }
}
