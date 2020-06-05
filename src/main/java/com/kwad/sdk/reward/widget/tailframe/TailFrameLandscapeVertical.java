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
import com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppLandscape;
import com.kwad.sdk.reward.widget.tailframe.h5bar.TailFrameBarH5Landscape;
import org.json.JSONObject;

public class TailFrameLandscapeVertical extends LinearLayout implements OnClickListener {
    /* renamed from: a */
    private ImageView f14866a;
    /* renamed from: b */
    private ImageView f14867b;
    /* renamed from: c */
    private ImageView f14868c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public TailFrameBarAppLandscape f14869d;
    /* renamed from: e */
    private TailFrameBarH5Landscape f14870e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public C4562a f14871f;
    /* renamed from: g */
    private AdTemplate f14872g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public AdInfo f14873h;
    /* renamed from: i */
    private JSONObject f14874i;
    /* renamed from: j */
    private C4089b f14875j;
    /* access modifiers changed from: private */
    /* renamed from: k */
    public TextProgressBar f14876k;

    /* renamed from: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeVertical$a */
    public interface C4562a {
        /* renamed from: a */
        void mo24757a();
    }

    public TailFrameLandscapeVertical(Context context) {
        this(context, null);
    }

    public TailFrameLandscapeVertical(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameLandscapeVertical(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18492b();
    }

    /* renamed from: b */
    private void m18492b() {
        inflate(getContext(), C3809l.m15792b(getContext(), "ksad_video_tf_view_landscape_vertical"), this);
        this.f14866a = (ImageView) findViewById(C3809l.m15789a(getContext(), "ksad_video_thumb_left"));
        this.f14867b = (ImageView) findViewById(C3809l.m15789a(getContext(), "ksad_video_thumb_mid"));
        this.f14868c = (ImageView) findViewById(C3809l.m15789a(getContext(), "ksad_video_thumb_right"));
    }

    /* renamed from: c */
    private void m18494c() {
        KSImageLoader.loadImage(this.f14866a, C4322a.m17638f(this.f14873h));
        KSImageLoader.loadImage(this.f14867b, C4322a.m17638f(this.f14873h));
        KSImageLoader.loadImage(this.f14868c, C4322a.m17638f(this.f14873h));
    }

    /* renamed from: d */
    private void m18496d() {
        if (C4322a.m17651s(this.f14873h)) {
            this.f14869d = (TailFrameBarAppLandscape) findViewById(C3809l.m15789a(getContext(), "ksad_video_app_tail_frame"));
            this.f14869d.setModel(this.f14872g);
            this.f14869d.setVisibility(0);
            this.f14876k = this.f14869d.getTextProgressBar();
            m18497e();
            return;
        }
        this.f14870e = (TailFrameBarH5Landscape) findViewById(C3809l.m15789a(getContext(), "ksad_video_h5_tail_frame"));
        this.f14870e.setModel(this.f14872g);
        this.f14870e.setVisibility(0);
    }

    /* renamed from: e */
    private void m18497e() {
        this.f14875j = new C4089b(this.f14872g, this.f14874i, new KsAppDownloadListener() {
            public void onDownloadFinished() {
                TailFrameLandscapeVertical.this.f14869d.mo24852a(TailFrameLandscapeVertical.this.f14873h);
                TailFrameLandscapeVertical.this.f14876k.mo24328a(C4322a.m17630a(), 0);
            }

            public void onIdle() {
                TailFrameLandscapeVertical.this.f14869d.mo24852a(TailFrameLandscapeVertical.this.f14873h);
                TailFrameLandscapeVertical.this.f14876k.mo24328a(C4322a.m17650r(TailFrameLandscapeVertical.this.f14873h), 0);
            }

            public void onInstalled() {
                TailFrameLandscapeVertical.this.f14869d.mo24852a(TailFrameLandscapeVertical.this.f14873h);
                TailFrameLandscapeVertical.this.f14876k.mo24328a(C4322a.m17634b(), 0);
            }

            public void onProgressUpdate(int i) {
                TailFrameLandscapeVertical.this.f14869d.mo24852a(TailFrameLandscapeVertical.this.f14873h);
                TailFrameLandscapeVertical.this.f14876k.mo24328a(C4322a.m17631a(i), i);
            }
        });
    }

    /* renamed from: f */
    private void m18498f() {
        setOnClickListener(null);
        this.f14875j = null;
    }

    /* renamed from: a */
    public void mo24842a() {
        TailFrameBarAppLandscape tailFrameBarAppLandscape = this.f14869d;
        if (tailFrameBarAppLandscape != null) {
            tailFrameBarAppLandscape.mo24851a();
            this.f14869d.setVisibility(8);
        }
        TailFrameBarH5Landscape tailFrameBarH5Landscape = this.f14870e;
        if (tailFrameBarH5Landscape != null) {
            tailFrameBarH5Landscape.mo24866a();
            this.f14870e.setVisibility(8);
        }
        m18498f();
    }

    /* renamed from: a */
    public void mo24843a(AdTemplate adTemplate, JSONObject jSONObject, C4562a aVar) {
        this.f14872g = adTemplate;
        this.f14873h = C4324c.m17668e(adTemplate);
        this.f14874i = jSONObject;
        this.f14871f = aVar;
        m18494c();
        m18496d();
        setOnClickListener(this);
    }

    public void onClick(View view) {
        C4087a.m16967a(view.getContext(), this.f14872g, new C4088a() {
            /* renamed from: a */
            public void mo23360a() {
                if (TailFrameLandscapeVertical.this.f14871f != null) {
                    TailFrameLandscapeVertical.this.f14871f.mo24757a();
                }
            }
        }, this.f14875j);
    }
}
