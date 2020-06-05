package com.kwad.sdk.contentalliance.detail;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.kwad.sdk.contentalliance.detail.photo.p312a.C3895e;
import com.kwad.sdk.contentalliance.detail.video.C3989e;
import com.kwad.sdk.contentalliance.detail.video.C3990f;
import com.kwad.sdk.contentalliance.p308a.C3828a;
import com.kwad.sdk.contentalliance.p308a.C3829b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.p333g.C4145c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.C4330e;
import com.kwad.sdk.core.response.p342b.C4322a;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.core.response.p342b.C4325d;
import com.kwad.sdk.p306a.C3810m;

/* renamed from: com.kwad.sdk.contentalliance.detail.d */
public class C3874d extends C3872b {
    /* access modifiers changed from: private */
    /* renamed from: c */
    public ImageView f13138c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public AdTemplate f13139d;
    /* renamed from: e */
    private Runnable f13140e = new Runnable() {
        public void run() {
            ScaleType scaleType;
            ImageView imageView;
            int width = C3874d.this.mo24768n().getWidth();
            C4330e a = C3874d.m16110b(C3874d.this.f13139d);
            LayoutParams layoutParams = C3874d.this.f13138c.getLayoutParams();
            int c = a.mo24476c();
            int b = a.mo24475b();
            if (c == 0 || b == 0) {
                layoutParams.width = -1;
                layoutParams.height = -1;
                C3874d.this.f13138c.setLayoutParams(layoutParams);
                imageView = C3874d.this.f13138c;
                scaleType = ScaleType.CENTER_CROP;
            } else {
                layoutParams.width = width;
                layoutParams.height = (int) ((((float) b) / (((float) c) * 1.0f)) * ((float) width));
                C3874d.this.f13138c.setLayoutParams(layoutParams);
                imageView = C3874d.this.f13138c;
                scaleType = ScaleType.FIT_CENTER;
            }
            imageView.setScaleType(scaleType);
            C3874d.this.f13138c.setImageDrawable(null);
            String str = "DetailFirstFramePresenter";
            if (!TextUtils.isEmpty(a.mo24474a())) {
                StringBuilder sb = new StringBuilder();
                sb.append("First Frame isCover=");
                sb.append(a.mo24478e());
                sb.append(" isAd=");
                sb.append(a.mo24477d());
                C4065b.m16867b(str, sb.toString());
                KSImageLoader.loadImage(C3874d.this.f13138c, a.mo24474a(), (ImageLoadingListener) new ImageLoadingListener() {
                    public void onLoadingCancelled(String str, View view) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("onLoadingCancelled position=");
                        sb.append(C3874d.this.f13125b.f13132f);
                        C4065b.m16863a("DetailFirstFramePresenter", sb.toString());
                        C4145c.m17161a(C3874d.this.f13125b.f13133g, (long) C3874d.this.f13125b.f13132f, str);
                    }

                    public void onLoadingComplete(String str, View view, Bitmap bitmap) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("onLoadingComplete position=");
                        sb.append(C3874d.this.f13125b.f13132f);
                        C4065b.m16863a("DetailFirstFramePresenter", sb.toString());
                    }

                    public void onLoadingFailed(String str, View view, FailReason failReason) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("onLoadingFailed position=");
                        sb.append(C3874d.this.f13125b.f13132f);
                        C4065b.m16863a("DetailFirstFramePresenter", sb.toString());
                        C4145c.m17161a(C3874d.this.f13125b.f13133g, (long) C3874d.this.f13125b.f13132f, str);
                    }

                    public void onLoadingStarted(String str, View view) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("onLoadingStarted position=");
                        sb.append(C3874d.this.f13125b.f13132f);
                        C4065b.m16863a("DetailFirstFramePresenter", sb.toString());
                    }
                });
                return;
            }
            C4065b.m16867b(str, "Video first frame url is null!");
            C4145c.m17161a(C3874d.this.f13125b.f13133g, (long) C3874d.this.f13125b.f13132f, "");
        }
    };
    /* renamed from: f */
    private C3828a f13141f = new C3829b() {
        /* renamed from: a */
        public void mo23230a() {
            super.mo23230a();
            C3874d.this.f13138c.setVisibility(0);
        }
    };
    /* renamed from: g */
    private C3989e f13142g = new C3990f() {
        /* renamed from: a */
        public void mo23373a() {
            super.mo23373a();
            if (C3874d.this.f13138c.getVisibility() == 0) {
                C3874d.this.f13138c.setVisibility(8);
            }
        }

        /* renamed from: b */
        public void mo23346b() {
            if (!C4324c.m17664a(C3874d.this.f13139d)) {
                if (C3874d.this.m16113g()) {
                    C3874d.this.f13125b.f13135i.mo23567i();
                } else {
                    C3874d.this.f13125b.f13134h.post(C3874d.this.f13143h);
                }
            }
        }
    };
    /* access modifiers changed from: private */
    /* renamed from: h */
    public Runnable f13143h = new Runnable() {
        public void run() {
            C3874d.this.f13125b.f13134h.mo23606a(true);
        }
    };

    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static C4330e m16110b(AdTemplate adTemplate) {
        return C4324c.m17664a(adTemplate) ? C4322a.m17629E(C4324c.m17668e(adTemplate)) : C4325d.m17690s(C4324c.m17669f(adTemplate));
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public boolean m16113g() {
        return C3895e.m16185a() || this.f13125b.f13131e || C3810m.m15807f(mo24770p());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23338a() {
        super.mo23338a();
        this.f13139d = this.f13125b.f13133g;
        mo24768n().post(this.f13140e);
        this.f13125b.f13127a.add(this.f13141f);
        this.f13125b.f13135i.mo23557a(this.f13142g);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo23339b() {
        super.mo23339b();
        this.f13138c = (ImageView) mo24760a("ksad_video_first_frame");
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo23340c() {
        super.mo23340c();
        mo24768n().removeCallbacks(this.f13140e);
        this.f13125b.f13134h.removeCallbacks(this.f13143h);
        this.f13125b.f13127a.remove(this.f13141f);
        this.f13125b.f13135i.mo23560b(this.f13142g);
    }
}
