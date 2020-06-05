package com.kwad.sdk.nativead.p349b;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.sdk.contentalliance.detail.video.C3989e;
import com.kwad.sdk.contentalliance.detail.video.C3990f;
import com.kwad.sdk.core.download.p323a.C4087a;
import com.kwad.sdk.core.download.p323a.C4087a.C4088a;
import com.kwad.sdk.core.download.p323a.C4089b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.p333g.C4143b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4322a;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.nativead.KsAppDownloadListener;
import com.kwad.sdk.nativead.p348a.C4474a;

/* renamed from: com.kwad.sdk.nativead.b.f */
public class C4488f extends C4474a implements OnClickListener {
    /* renamed from: b */
    private ViewGroup f14661b;
    /* renamed from: c */
    private ImageView f14662c;
    /* renamed from: d */
    private TextView f14663d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public TextView f14664e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public AdTemplate f14665f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public AdInfo f14666g;
    /* renamed from: h */
    private C4089b f14667h;
    /* renamed from: i */
    private C3989e f14668i = new C3990f() {
        /* renamed from: b */
        public void mo23346b() {
            C4488f.this.m18253g();
        }
    };
    /* renamed from: j */
    private KsAppDownloadListener f14669j = new KsAppDownloadListener() {
        public void onDownloadFinished() {
            C4488f.this.f14664e.setText("立即安装");
        }

        public void onIdle() {
            C4488f.this.f14664e.setText(C4322a.m17650r(C4488f.this.f14666g));
        }

        public void onInstalled() {
            C4488f.this.f14664e.setText("立即打开");
        }

        public void onProgressUpdate(int i) {
        }
    };

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m18253g() {
        KSImageLoader.loadAppIcon(this.f14662c, C4322a.m17644l(this.f14666g), 12);
        this.f14663d.setText(C4322a.m17645m(this.f14666g));
        this.f14664e.setText(C4322a.m17650r(this.f14666g));
        C4089b bVar = this.f14667h;
        if (bVar != null) {
            bVar.mo23770a(this.f14669j);
        }
        this.f14661b.setOnClickListener(this);
        this.f14661b.setVisibility(0);
    }

    /* renamed from: h */
    private void m18254h() {
        C4087a.m16967a(this.f14661b.getContext(), this.f14665f, new C4088a() {
            /* renamed from: a */
            public void mo23360a() {
                C4143b.m17117a(C4488f.this.f14665f, 2, C4488f.this.f14621a.f14624c.getTouchCoords());
            }
        }, this.f14667h);
    }

    /* renamed from: i */
    private void m18255i() {
        this.f14621a.f14622a.onAdClicked(this.f14661b, null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23338a() {
        super.mo23338a();
        this.f14665f = this.f14621a.f14625d;
        this.f14666g = C4324c.m17668e(this.f14665f);
        this.f14667h = this.f14621a.f14626e;
        this.f14621a.f14627f.mo24793a(this.f14668i);
        this.f14661b.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo23339b() {
        super.mo23339b();
        this.f14661b = (ViewGroup) mo24760a("ksad_video_complete_app_container");
        this.f14662c = (ImageView) mo24760a("ksad_app_icon");
        this.f14663d = (TextView) mo24760a("ksad_app_name");
        this.f14664e = (TextView) mo24760a("ksad_app_download");
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo23340c() {
        super.mo23340c();
        this.f14621a.f14627f.mo24795b(this.f14668i);
        C4089b bVar = this.f14667h;
        if (bVar != null) {
            bVar.mo23775b(this.f14669j);
        }
    }

    public void onClick(View view) {
        if (view == this.f14661b) {
            m18254h();
            m18255i();
        }
    }
}
