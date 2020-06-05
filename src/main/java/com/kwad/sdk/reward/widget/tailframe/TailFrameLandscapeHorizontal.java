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

public class TailFrameLandscapeHorizontal extends LinearLayout implements OnClickListener {
    /* renamed from: a */
    private ImageView f14855a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public TailFrameBarAppLandscape f14856b;
    /* renamed from: c */
    private TailFrameBarH5Landscape f14857c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public C4559a f14858d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public AdTemplate f14859e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public AdInfo f14860f;
    /* renamed from: g */
    private JSONObject f14861g;
    /* renamed from: h */
    private C4089b f14862h;
    /* access modifiers changed from: private */
    /* renamed from: i */
    public TextProgressBar f14863i;

    /* renamed from: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeHorizontal$a */
    public interface C4559a {
        /* renamed from: a */
        void mo24758a();
    }

    public TailFrameLandscapeHorizontal(Context context) {
        this(context, null);
    }

    public TailFrameLandscapeHorizontal(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameLandscapeHorizontal(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18479b();
    }

    /* renamed from: b */
    private void m18479b() {
        inflate(getContext(), C3809l.m15792b(getContext(), "ksad_video_tf_view_landscape_horizontal"), this);
        this.f14855a = (ImageView) findViewById(C3809l.m15789a(getContext(), "ksad_video_thumb_img"));
    }

    /* renamed from: c */
    private void m18481c() {
        if (C4322a.m17651s(this.f14860f)) {
            this.f14856b = (TailFrameBarAppLandscape) findViewById(C3809l.m15789a(getContext(), "ksad_video_app_tail_frame"));
            this.f14856b.setModel(this.f14859e);
            this.f14856b.setVisibility(0);
            this.f14863i = this.f14856b.getTextProgressBar();
            m18483d();
            return;
        }
        this.f14857c = (TailFrameBarH5Landscape) findViewById(C3809l.m15789a(getContext(), "ksad_video_h5_tail_frame"));
        this.f14857c.setModel(this.f14859e);
        this.f14857c.setVisibility(0);
    }

    /* renamed from: d */
    private void m18483d() {
        this.f14862h = new C4089b(this.f14859e, this.f14861g, new KsAppDownloadListener() {
            public void onDownloadFinished() {
                TailFrameLandscapeHorizontal.this.f14856b.mo24852a(C4324c.m17668e(TailFrameLandscapeHorizontal.this.f14859e));
                TailFrameLandscapeHorizontal.this.f14863i.mo24328a(C4322a.m17630a(), 0);
            }

            public void onIdle() {
                TailFrameLandscapeHorizontal.this.f14856b.mo24852a(C4324c.m17668e(TailFrameLandscapeHorizontal.this.f14859e));
                TailFrameLandscapeHorizontal.this.f14863i.mo24328a(C4322a.m17650r(TailFrameLandscapeHorizontal.this.f14860f), 0);
            }

            public void onInstalled() {
                TailFrameLandscapeHorizontal.this.f14856b.mo24852a(C4324c.m17668e(TailFrameLandscapeHorizontal.this.f14859e));
                TailFrameLandscapeHorizontal.this.f14863i.mo24328a(C4322a.m17634b(), 0);
            }

            public void onProgressUpdate(int i) {
                TailFrameLandscapeHorizontal.this.f14856b.mo24852a(C4324c.m17668e(TailFrameLandscapeHorizontal.this.f14859e));
                TailFrameLandscapeHorizontal.this.f14863i.mo24328a(C4322a.m17631a(i), i);
            }
        });
    }

    /* renamed from: e */
    private void m18485e() {
        setOnClickListener(null);
        this.f14862h = null;
    }

    /* renamed from: a */
    public void mo24839a() {
        TailFrameBarAppLandscape tailFrameBarAppLandscape = this.f14856b;
        if (tailFrameBarAppLandscape != null) {
            tailFrameBarAppLandscape.mo24851a();
            this.f14856b.setVisibility(8);
        }
        TailFrameBarH5Landscape tailFrameBarH5Landscape = this.f14857c;
        if (tailFrameBarH5Landscape != null) {
            tailFrameBarH5Landscape.mo24866a();
            this.f14857c.setVisibility(8);
        }
        m18485e();
    }

    /* renamed from: a */
    public void mo24840a(AdTemplate adTemplate, JSONObject jSONObject, C4559a aVar) {
        this.f14859e = adTemplate;
        this.f14860f = C4324c.m17668e(adTemplate);
        this.f14861g = jSONObject;
        this.f14858d = aVar;
        KSImageLoader.loadImage(this.f14855a, C4322a.m17638f(this.f14860f));
        m18481c();
        setOnClickListener(this);
    }

    public void onClick(View view) {
        C4087a.m16967a(view.getContext(), this.f14859e, new C4088a() {
            /* renamed from: a */
            public void mo23360a() {
                if (TailFrameLandscapeHorizontal.this.f14858d != null) {
                    TailFrameLandscapeHorizontal.this.f14858d.mo24758a();
                }
            }
        }, this.f14862h);
    }
}
