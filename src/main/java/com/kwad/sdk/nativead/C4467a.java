package com.kwad.sdk.nativead;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.kwad.sdk.KsAdSDK;
import com.kwad.sdk.core.download.p323a.C4087a;
import com.kwad.sdk.core.download.p323a.C4087a.C4088a;
import com.kwad.sdk.core.download.p323a.C4089b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.p333g.C4143b;
import com.kwad.sdk.core.page.widget.C4248a;
import com.kwad.sdk.core.page.widget.C4248a.C4249a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4322a;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.export.config.KSAdVideoPlayConfig;
import com.kwad.sdk.export.config.KSAdVideoPlayConfig.Builder;
import com.kwad.sdk.export.p347i.KsNativeAd;
import com.kwad.sdk.export.p347i.KsNativeAd.AdInteractionListener;
import com.kwad.sdk.export.p347i.KsNativeAd.VideoPlayListener;
import com.kwad.sdk.p306a.C3803g.C3804a;
import com.kwad.sdk.p306a.C3807j;
import com.kwad.sdk.p306a.C3809l;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.nativead.a */
public class C4467a implements KsNativeAd {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public AdTemplate f14601a;
    /* renamed from: b */
    private AdInfo f14602b;
    /* renamed from: c */
    private C4089b f14603c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public AdInteractionListener f14604d;
    /* renamed from: e */
    private C4476b f14605e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public VideoPlayListener f14606f;
    /* renamed from: g */
    private VideoPlayListener f14607g = new VideoPlayListener() {
        public void onVideoPlayComplete() {
            if (C4467a.this.f14606f != null) {
                C4467a.this.f14606f.onVideoPlayComplete();
            }
        }

        public void onVideoPlayError(int i, int i2) {
            if (C4467a.this.f14606f != null) {
                C4467a.this.f14606f.onVideoPlayError(i, i2);
            }
        }

        public void onVideoPlayStart() {
            if (C4467a.this.f14606f != null) {
                C4467a.this.f14606f.onVideoPlayStart();
            }
        }
    };
    /* renamed from: h */
    private AdInteractionListener f14608h = new AdInteractionListener() {
        public void onAdClicked(View view, KsNativeAd ksNativeAd) {
            if (C4467a.this.f14604d != null) {
                C4467a.this.f14604d.onAdClicked(view, C4467a.this);
            }
        }

        public void onAdShow(KsNativeAd ksNativeAd) {
            if (C4467a.this.f14604d != null) {
                C4467a.this.f14604d.onAdShow(C4467a.this);
            }
        }
    };

    public C4467a(AdTemplate adTemplate) {
        this.f14601a = adTemplate;
        this.f14602b = C4324c.m17668e(this.f14601a);
        if (C4322a.m17651s(this.f14602b)) {
            this.f14603c = new C4089b(this.f14601a);
        }
        KSImageLoader.preloadImage(C4322a.m17635c(this.f14602b));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18192a(final View view, final C3804a aVar) {
        C4087a.m16967a(view.getContext(), this.f14601a, new C4088a() {
            /* renamed from: a */
            public void mo23360a() {
                C4143b.m17122a(C4467a.this.f14601a, aVar);
                if (C4467a.this.f14604d != null) {
                    C4467a.this.f14604d.onAdClicked(view, C4467a.this);
                }
            }
        }, this.f14603c);
    }

    /* renamed from: a */
    private void m18193a(ViewGroup viewGroup) {
        C4248a b = m18196b(viewGroup);
        if (b == null) {
            b = new C4248a(viewGroup.getContext(), viewGroup);
            viewGroup.addView(b);
        }
        b.setViewCallback(new C4249a() {
            /* renamed from: a */
            public void mo24349a() {
            }

            /* renamed from: a */
            public void mo24350a(View view) {
                if (!C4467a.this.f14601a.mPvReported && C4467a.this.f14604d != null) {
                    C4467a.this.f14604d.onAdShow(C4467a.this);
                }
                C4143b.m17123a(C4467a.this.f14601a, (JSONObject) null);
            }

            /* renamed from: a */
            public void mo24351a(boolean z) {
            }

            /* renamed from: b */
            public void mo24352b() {
            }
        });
        b.setNeedCheckingShow(true);
    }

    /* renamed from: a */
    private void m18194a(final ViewGroup viewGroup, List<View> list) {
        for (View view : list) {
            final C3804a aVar = new C3804a();
            view.setOnTouchListener(new OnTouchListener() {
                /* renamed from: d */
                private int[] f14612d = new int[2];

                public boolean onTouch(View view, MotionEvent motionEvent) {
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        aVar.mo23198a(viewGroup.getWidth(), viewGroup.getHeight());
                        viewGroup.getLocationOnScreen(this.f14612d);
                        aVar.mo23197a(Math.abs(motionEvent.getRawX() - ((float) this.f14612d[0])), Math.abs(motionEvent.getRawY() - ((float) this.f14612d[1])));
                    } else if (action == 1) {
                        aVar.mo23200b(Math.abs(motionEvent.getRawX() - ((float) this.f14612d[0])), Math.abs(motionEvent.getRawY() - ((float) this.f14612d[1])));
                    }
                    return false;
                }
            });
            view.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    C4467a.this.m18192a(view, aVar);
                }
            });
        }
    }

    /* renamed from: b */
    private C4248a m18196b(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof C4248a) {
                return (C4248a) childAt;
            }
        }
        return null;
    }

    /* renamed from: a */
    public AdTemplate mo24781a() {
        return this.f14601a;
    }

    public String getActionDescription() {
        return C4322a.m17650r(this.f14602b);
    }

    public String getAdDescription() {
        return C4322a.m17643k(this.f14602b);
    }

    public String getAdSource() {
        return C4322a.m17649q(this.f14602b);
    }

    public String getAppDownloadCountDes() {
        return C4322a.m17647o(this.f14602b);
    }

    public String getAppIconUrl() {
        return C4322a.m17644l(this.f14602b);
    }

    public String getAppName() {
        return C4322a.m17645m(this.f14602b);
    }

    public float getAppScore() {
        return C4322a.m17648p(this.f14602b);
    }

    public int getECPM() {
        return C4322a.m17653u(this.f14602b);
    }

    public List<KsImage> getImageList() {
        ArrayList arrayList = new ArrayList();
        AdInfo e = C4324c.m17668e(this.f14601a);
        int z = C4322a.m17658z(this.f14602b);
        if (z == 2 || z == 3) {
            for (MaterialFeature materialFeature : e.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                    arrayList.add(new KsImage(materialFeature.width, materialFeature.height, materialFeature.materialUrl));
                }
            }
        }
        return arrayList;
    }

    public int getInteractionType() {
        return C4322a.m17652t(this.f14602b);
    }

    public int getMaterialType() {
        return C4322a.m17658z(this.f14602b);
    }

    public Bitmap getSdkLogo() {
        Context context = KsAdSDK.getContext();
        if (context == null) {
            return null;
        }
        return BitmapFactory.decodeResource(context.getResources(), C3809l.m15795d(context, "ksad_sdk_logo"));
    }

    public KsImage getVideoCoverImage() {
        MaterialFeature w = C4322a.m17655w(this.f14602b);
        if (!TextUtils.isEmpty(w.coverUrl)) {
            return new KsImage(w.width, w.height, w.coverUrl);
        }
        return null;
    }

    public int getVideoDuration() {
        return C4322a.m17633b(this.f14602b);
    }

    public String getVideoUrl() {
        return C4322a.m17632a(this.f14602b);
    }

    public View getVideoView(Context context, KSAdVideoPlayConfig kSAdVideoPlayConfig) {
        if (TextUtils.isEmpty(getVideoUrl())) {
            C4065b.m16868c("KsNativeAdControl", "videoUrl is empty");
            return null;
        }
        if (this.f14605e == null) {
            this.f14605e = new C4476b(context);
            this.f14605e.setAdInteractionListener(this.f14608h);
            this.f14605e.setVideoPlayListener(this.f14607g);
            this.f14605e.mo24784a(this.f14601a, this.f14603c, kSAdVideoPlayConfig);
        }
        return this.f14605e;
    }

    public View getVideoView(Context context, boolean z) {
        return getVideoView(context, new Builder().setVideoSoundEnable(z).setDataFlowAutoStart(false).build());
    }

    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, AdInteractionListener adInteractionListener) {
        this.f14604d = adInteractionListener;
        C3807j.m15783a((Object) viewGroup, "container不能为null");
        C3807j.m15783a((Object) list, "clickViews不能为null");
        C3807j.m15782a(Boolean.valueOf(list.isEmpty()), "clickViews数量必须大于等于1");
        m18193a(viewGroup);
        m18194a(viewGroup, list);
    }

    public void setBidEcpm(int i) {
        AdTemplate adTemplate = this.f14601a;
        adTemplate.mBidEcpm = i;
        C4143b.m17150m(adTemplate);
    }

    public void setDownloadListener(KsAppDownloadListener ksAppDownloadListener) {
        C4089b bVar = this.f14603c;
        if (bVar != null && ksAppDownloadListener != null) {
            bVar.mo23770a(ksAppDownloadListener);
        }
    }

    public void setVideoPlayListener(VideoPlayListener videoPlayListener) {
        this.f14606f = videoPlayListener;
    }
}
