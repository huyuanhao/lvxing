package com.kwad.sdk.reward.widget.tailframe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.kwad.sdk.core.download.p323a.C4087a;
import com.kwad.sdk.core.download.p323a.C4087a.C4088a;
import com.kwad.sdk.core.download.p323a.C4089b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4322a;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.nativead.KsAppDownloadListener;
import com.kwad.sdk.p306a.C3809l;
import com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitVertical;
import com.kwad.sdk.reward.widget.tailframe.h5bar.TailFrameBarH5PortraitVertical;
import org.json.JSONObject;

public class TailFramePortraitVertical extends LinearLayout implements OnClickListener {
    /* renamed from: a */
    private ImageView f14890a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public TailFrameBarAppPortraitVertical f14891b;
    /* renamed from: c */
    private TailFrameBarH5PortraitVertical f14892c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public C4568a f14893d;
    /* renamed from: e */
    private AdTemplate f14894e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public AdInfo f14895f;
    /* renamed from: g */
    private JSONObject f14896g;
    /* renamed from: h */
    private C4089b f14897h;
    /* access modifiers changed from: private */
    /* renamed from: i */
    public TextProgressBar f14898i;

    /* renamed from: com.kwad.sdk.reward.widget.tailframe.TailFramePortraitVertical$a */
    public interface C4568a {
        /* renamed from: a */
        void mo24755a();
    }

    public TailFramePortraitVertical(Context context) {
        this(context, null);
    }

    public TailFramePortraitVertical(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFramePortraitVertical(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18518b();
    }

    /* renamed from: b */
    private void m18518b() {
        inflate(getContext(), C3809l.m15792b(getContext(), "ksad_video_tf_view_portrait_vertical"), this);
        this.f14890a = (ImageView) findViewById(C3809l.m15789a(getContext(), "ksad_video_thumb_img"));
    }

    /* renamed from: c */
    private void m18520c() {
        if (C4322a.m17651s(this.f14895f)) {
            this.f14891b = (TailFrameBarAppPortraitVertical) findViewById(C3809l.m15789a(getContext(), "ksad_video_app_tail_frame"));
            this.f14891b.mo24863a(this.f14894e);
            this.f14891b.setVisibility(0);
            this.f14898i = this.f14891b.getTextProgressBar();
            m18522d();
            return;
        }
        this.f14892c = (TailFrameBarH5PortraitVertical) findViewById(C3809l.m15789a(getContext(), "ksad_video_h5_tail_frame"));
        this.f14892c.mo24873a(this.f14894e);
        this.f14892c.setVisibility(0);
    }

    /* renamed from: d */
    private void m18522d() {
        this.f14897h = new C4089b(this.f14894e, this.f14896g, new KsAppDownloadListener() {
            public void onDownloadFinished() {
                TailFramePortraitVertical.this.f14891b.mo24862a(TailFramePortraitVertical.this.f14895f);
                TailFramePortraitVertical.this.f14898i.mo24328a(C4322a.m17630a(), 0);
            }

            public void onIdle() {
                TailFramePortraitVertical.this.f14891b.mo24862a(TailFramePortraitVertical.this.f14895f);
                TailFramePortraitVertical.this.f14898i.mo24328a(C4322a.m17650r(TailFramePortraitVertical.this.f14895f), 0);
            }

            public void onInstalled() {
                TailFramePortraitVertical.this.f14891b.mo24862a(TailFramePortraitVertical.this.f14895f);
                TailFramePortraitVertical.this.f14898i.mo24328a(C4322a.m17634b(), 0);
            }

            public void onProgressUpdate(int i) {
                TailFramePortraitVertical.this.f14891b.mo24862a(TailFramePortraitVertical.this.f14895f);
                TailFramePortraitVertical.this.f14898i.mo24328a(C4322a.m17631a(i), i);
            }
        });
    }

    /* renamed from: e */
    private void m18523e() {
        setOnClickListener(null);
        this.f14897h = null;
    }

    /* renamed from: a */
    public void mo24848a() {
        TailFrameBarAppPortraitVertical tailFrameBarAppPortraitVertical = this.f14891b;
        if (tailFrameBarAppPortraitVertical != null) {
            tailFrameBarAppPortraitVertical.mo24861a();
            this.f14891b.setVisibility(8);
        }
        TailFrameBarH5PortraitVertical tailFrameBarH5PortraitVertical = this.f14892c;
        if (tailFrameBarH5PortraitVertical != null) {
            tailFrameBarH5PortraitVertical.mo24872a();
            this.f14892c.setVisibility(8);
        }
        m18523e();
    }

    /* renamed from: a */
    public void mo24849a(AdTemplate adTemplate, JSONObject jSONObject, C4568a aVar) {
        this.f14894e = adTemplate;
        this.f14895f = C4324c.m17668e(adTemplate);
        this.f14896g = jSONObject;
        this.f14893d = aVar;
        KSImageLoader.loadImage(this.f14890a, C4322a.m17638f(this.f14895f));
        m18520c();
        setOnClickListener(this);
    }

    public void onClick(View view) {
        C4087a.m16967a(view.getContext(), this.f14894e, new C4088a() {
            /* renamed from: a */
            public void mo23360a() {
                if (TailFramePortraitVertical.this.f14893d != null) {
                    TailFramePortraitVertical.this.f14893d.mo24755a();
                }
            }
        }, this.f14897h);
    }
}
