package com.kwad.sdk.reward.widget.tailframe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.kwad.sdk.core.download.p323a.C4087a;
import com.kwad.sdk.core.download.p323a.C4087a.C4088a;
import com.kwad.sdk.core.download.p323a.C4089b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4322a;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.nativead.KsAppDownloadListener;
import com.kwad.sdk.p306a.C3809l;
import com.kwad.sdk.p306a.C3817t;
import com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitHorizontal;
import com.kwad.sdk.reward.widget.tailframe.h5bar.TailFrameBarH5PortraitHorizontal;
import org.json.JSONObject;

public class TailFramePortraitHorizontal extends LinearLayout implements OnClickListener {
    /* renamed from: a */
    private ImageView f14879a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public TailFrameBarAppPortraitHorizontal f14880b;
    /* renamed from: c */
    private TailFrameBarH5PortraitHorizontal f14881c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public C4565a f14882d;
    /* renamed from: e */
    private AdTemplate f14883e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public AdInfo f14884f;
    /* renamed from: g */
    private JSONObject f14885g;
    /* renamed from: h */
    private C4089b f14886h;
    /* access modifiers changed from: private */
    /* renamed from: i */
    public TextProgressBar f14887i;

    /* renamed from: com.kwad.sdk.reward.widget.tailframe.TailFramePortraitHorizontal$a */
    public interface C4565a {
        /* renamed from: a */
        void mo24756a();
    }

    public TailFramePortraitHorizontal(Context context) {
        this(context, null);
    }

    public TailFramePortraitHorizontal(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFramePortraitHorizontal(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18505b();
    }

    /* renamed from: b */
    private void m18505b() {
        inflate(getContext(), C3809l.m15792b(getContext(), "ksad_video_tf_view_portrait_horizontal"), this);
        this.f14879a = (ImageView) findViewById(C3809l.m15789a(getContext(), "ksad_video_thumb_img"));
    }

    /* renamed from: c */
    private void m18507c() {
        MaterialFeature w = C4322a.m17655w(this.f14884f);
        int i = w.width;
        int i2 = w.height;
        int c = C3817t.m15872c(getContext());
        int i3 = (int) (((float) c) * (((float) i2) / ((float) i)));
        LayoutParams layoutParams = this.f14879a.getLayoutParams();
        layoutParams.width = c;
        layoutParams.height = i3;
        KSImageLoader.loadImage(this.f14879a, w.coverUrl);
    }

    /* renamed from: d */
    private void m18509d() {
        if (C4322a.m17651s(this.f14884f)) {
            this.f14880b = (TailFrameBarAppPortraitHorizontal) findViewById(C3809l.m15789a(getContext(), "ksad_video_app_tail_frame"));
            this.f14880b.mo24858a(this.f14883e);
            this.f14880b.setVisibility(0);
            this.f14887i = this.f14880b.getTextProgressBar();
            m18510e();
            return;
        }
        this.f14881c = (TailFrameBarH5PortraitHorizontal) findViewById(C3809l.m15789a(getContext(), "ksad_video_h5_tail_frame"));
        this.f14881c.setModel(this.f14883e);
        this.f14881c.setVisibility(0);
    }

    /* renamed from: e */
    private void m18510e() {
        this.f14886h = new C4089b(this.f14883e, this.f14885g, new KsAppDownloadListener() {
            public void onDownloadFinished() {
                TailFramePortraitHorizontal.this.f14880b.mo24857a(TailFramePortraitHorizontal.this.f14884f);
                TailFramePortraitHorizontal.this.f14887i.mo24328a(C4322a.m17630a(), 0);
            }

            public void onIdle() {
                TailFramePortraitHorizontal.this.f14880b.mo24857a(TailFramePortraitHorizontal.this.f14884f);
                TailFramePortraitHorizontal.this.f14887i.mo24328a(C4322a.m17650r(TailFramePortraitHorizontal.this.f14884f), 0);
            }

            public void onInstalled() {
                TailFramePortraitHorizontal.this.f14880b.mo24857a(TailFramePortraitHorizontal.this.f14884f);
                TailFramePortraitHorizontal.this.f14887i.mo24328a(C4322a.m17634b(), 0);
            }

            public void onProgressUpdate(int i) {
                TailFramePortraitHorizontal.this.f14880b.mo24857a(TailFramePortraitHorizontal.this.f14884f);
                TailFramePortraitHorizontal.this.f14887i.mo24328a(C4322a.m17631a(i), i);
            }
        });
    }

    /* renamed from: f */
    private void m18511f() {
        setOnClickListener(null);
        this.f14886h = null;
    }

    /* renamed from: a */
    public void mo24845a() {
        TailFrameBarAppPortraitHorizontal tailFrameBarAppPortraitHorizontal = this.f14880b;
        if (tailFrameBarAppPortraitHorizontal != null) {
            tailFrameBarAppPortraitHorizontal.mo24856a();
            this.f14880b.setVisibility(8);
        }
        TailFrameBarH5PortraitHorizontal tailFrameBarH5PortraitHorizontal = this.f14881c;
        if (tailFrameBarH5PortraitHorizontal != null) {
            tailFrameBarH5PortraitHorizontal.mo24869a();
            this.f14881c.setVisibility(8);
        }
        m18511f();
    }

    /* renamed from: a */
    public void mo24846a(AdTemplate adTemplate, JSONObject jSONObject, C4565a aVar) {
        this.f14883e = adTemplate;
        this.f14884f = C4324c.m17668e(adTemplate);
        this.f14885g = jSONObject;
        this.f14882d = aVar;
        m18507c();
        m18509d();
        setOnClickListener(this);
    }

    public void onClick(View view) {
        C4087a.m16967a(view.getContext(), this.f14883e, new C4088a() {
            /* renamed from: a */
            public void mo23360a() {
                if (TailFramePortraitHorizontal.this.f14882d != null) {
                    TailFramePortraitHorizontal.this.f14882d.mo24756a();
                }
            }
        }, this.f14886h);
    }
}
