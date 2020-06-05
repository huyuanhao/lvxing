package com.kwad.sdk.draw.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.sdk.core.download.p323a.C4087a;
import com.kwad.sdk.core.download.p323a.C4087a.C4088a;
import com.kwad.sdk.core.download.p323a.C4089b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.p333g.C4143b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4322a;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.nativead.KsAppDownloadListener;
import com.kwad.sdk.p306a.C3809l;
import com.kwad.sdk.p306a.C3817t;
import com.kwad.sdk.reward.widget.AppScoreView;

public class DrawVideoTailFrame extends FrameLayout implements OnClickListener {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public AdBaseFrameLayout f14355a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public AdTemplate f14356b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public AdInfo f14357c;
    /* renamed from: d */
    private C4089b f14358d;
    /* renamed from: e */
    private KsAppDownloadListener f14359e;
    /* renamed from: f */
    private ImageView f14360f;
    /* renamed from: g */
    private ViewGroup f14361g;
    /* renamed from: h */
    private ImageView f14362h;
    /* renamed from: i */
    private TextView f14363i;
    /* renamed from: j */
    private AppScoreView f14364j;
    /* renamed from: k */
    private TextView f14365k;
    /* renamed from: l */
    private TextView f14366l;
    /* access modifiers changed from: private */
    /* renamed from: m */
    public DrawDownloadProgressBar f14367m;
    /* renamed from: n */
    private ViewGroup f14368n;
    /* renamed from: o */
    private TextView f14369o;
    /* renamed from: p */
    private TextView f14370p;

    public DrawVideoTailFrame(Context context) {
        super(context);
        m17883a(context);
    }

    public DrawVideoTailFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m17883a(context);
    }

    public DrawVideoTailFrame(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m17883a(context);
    }

    /* renamed from: a */
    private void m17883a(Context context) {
        inflate(context, C3809l.m15792b(context, "ksad_draw_video_tailframe"), this);
        this.f14360f = (ImageView) findViewById(C3809l.m15789a(context, "ksad_video_cover"));
        this.f14361g = (ViewGroup) findViewById(C3809l.m15789a(context, "ksad_app_container"));
        this.f14362h = (ImageView) findViewById(C3809l.m15789a(context, "ksad_app_icon"));
        this.f14363i = (TextView) findViewById(C3809l.m15789a(context, "ksad_app_name"));
        this.f14364j = (AppScoreView) findViewById(C3809l.m15789a(context, "ksad_app_score"));
        this.f14365k = (TextView) findViewById(C3809l.m15789a(context, "ksad_app_download_count"));
        this.f14366l = (TextView) findViewById(C3809l.m15789a(context, "ksad_app_ad_desc"));
        this.f14367m = (DrawDownloadProgressBar) findViewById(C3809l.m15789a(context, "ksad_app_download_btn"));
        this.f14367m.setTextSize(15);
        this.f14368n = (ViewGroup) findViewById(C3809l.m15789a(context, "ksad_h5_container"));
        this.f14369o = (TextView) findViewById(C3809l.m15789a(context, "ksad_h5_ad_desc"));
        this.f14370p = (TextView) findViewById(C3809l.m15789a(context, "ksad_h5_open_btn"));
    }

    private KsAppDownloadListener getAppDownloadListener() {
        return new KsAppDownloadListener() {
            public void onDownloadFinished() {
                DrawVideoTailFrame.this.f14367m.mo24567a(C4322a.m17630a(), DrawVideoTailFrame.this.f14367m.getMax());
            }

            public void onIdle() {
                DrawVideoTailFrame.this.f14367m.mo24567a(C4322a.m17650r(DrawVideoTailFrame.this.f14357c), DrawVideoTailFrame.this.f14367m.getMax());
            }

            public void onInstalled() {
                DrawVideoTailFrame.this.f14367m.mo24567a(C4322a.m17634b(), DrawVideoTailFrame.this.f14367m.getMax());
            }

            public void onProgressUpdate(int i) {
                DrawDownloadProgressBar b = DrawVideoTailFrame.this.f14367m;
                StringBuilder sb = new StringBuilder();
                sb.append(i);
                sb.append("%");
                b.mo24567a(sb.toString(), i);
            }
        };
    }

    /* renamed from: a */
    public void mo24572a() {
        C4089b bVar = this.f14358d;
        if (bVar != null) {
            KsAppDownloadListener ksAppDownloadListener = this.f14359e;
            if (ksAppDownloadListener != null) {
                bVar.mo23779c(ksAppDownloadListener);
                return;
            }
            this.f14359e = getAppDownloadListener();
            this.f14358d.mo23770a(this.f14359e);
        }
    }

    /* renamed from: a */
    public void mo24573a(AdTemplate adTemplate) {
        this.f14356b = adTemplate;
        this.f14357c = C4324c.m17668e(adTemplate);
        MaterialFeature w = C4322a.m17655w(this.f14357c);
        String str = w.coverUrl;
        if (!TextUtils.isEmpty(str)) {
            int i = w.width;
            int i2 = w.height;
            if (i > 0 && i > i2) {
                int c = C3817t.m15872c(getContext());
                if (getWidth() != 0) {
                    c = getWidth();
                }
                int i3 = (int) (((float) c) * (((float) i2) / ((float) i)));
                LayoutParams layoutParams = this.f14360f.getLayoutParams();
                layoutParams.width = c;
                layoutParams.height = i3;
            }
            KSImageLoader.loadImage(this.f14360f, str);
        }
        if (C4322a.m17651s(this.f14357c)) {
            KSImageLoader.loadAppIcon(this.f14362h, C4322a.m17644l(this.f14357c), 11);
            this.f14363i.setText(C4322a.m17645m(this.f14357c));
            float p = C4322a.m17648p(this.f14357c);
            if (p >= 3.0f) {
                this.f14364j.setScore(p);
                this.f14364j.setVisibility(0);
            }
            this.f14365k.setText(C4322a.m17647o(this.f14357c));
            this.f14366l.setText(C4322a.m17643k(this.f14357c));
            this.f14361g.setVisibility(0);
            this.f14368n.setVisibility(8);
        } else {
            this.f14369o.setText(C4322a.m17643k(this.f14357c));
            this.f14370p.setText(C4322a.m17650r(this.f14357c));
            this.f14361g.setVisibility(8);
            this.f14368n.setVisibility(0);
        }
        this.f14367m.setOnClickListener(this);
        setOnClickListener(this);
    }

    /* renamed from: b */
    public void mo24574b() {
        C4089b bVar = this.f14358d;
        if (bVar != null) {
            KsAppDownloadListener ksAppDownloadListener = this.f14359e;
            if (ksAppDownloadListener != null) {
                bVar.mo23775b(ksAppDownloadListener);
            }
        }
    }

    public void onClick(View view) {
        C4087a.m16967a(getContext(), this.f14356b, new C4088a() {
            /* renamed from: a */
            public void mo23360a() {
                C4143b.m17117a(DrawVideoTailFrame.this.f14356b, 2, DrawVideoTailFrame.this.f14355a.getTouchCoords());
            }
        }, this.f14358d);
    }

    public void setAdBaseFrameLayout(AdBaseFrameLayout adBaseFrameLayout) {
        this.f14355a = adBaseFrameLayout;
    }

    public void setApkDownloadHelper(C4089b bVar) {
        this.f14358d = bVar;
    }
}
