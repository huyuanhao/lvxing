package com.kwad.sdk.core.p334h.p336b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.ksad.download.p297c.C3607b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4322a;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.p306a.C3809l;

/* renamed from: com.kwad.sdk.core.h.b.a */
public class C4185a extends C4195c implements OnClickListener {
    /* renamed from: b */
    private Context f13921b;
    /* renamed from: c */
    private AdTemplate f13922c;
    /* renamed from: d */
    private AdInfo f13923d;
    /* renamed from: e */
    private boolean f13924e;
    /* renamed from: f */
    private LinearLayout f13925f;
    /* renamed from: g */
    private TextView f13926g;
    /* renamed from: h */
    private TextView f13927h;
    /* renamed from: i */
    private LinearLayout f13928i;
    /* renamed from: j */
    private ProgressBar f13929j;
    /* renamed from: k */
    private ImageView f13930k;
    /* renamed from: l */
    private ViewGroup f13931l;
    /* renamed from: m */
    private C4186a f13932m;

    /* renamed from: com.kwad.sdk.core.h.b.a$a */
    public interface C4186a {
        /* renamed from: a */
        void mo23940a();

        /* renamed from: a */
        void mo23941a(long j);

        /* renamed from: b */
        void mo23942b();
    }

    public C4185a(Context context, AdTemplate adTemplate, C4198d dVar) {
        super(context, dVar);
        this.f13921b = context;
        this.f13922c = adTemplate;
        this.f13923d = C4324c.m17668e(adTemplate);
        m17346j();
    }

    /* renamed from: j */
    private void m17346j() {
        LayoutInflater.from(this.f13921b).inflate(C3809l.m15792b(this.f13921b, "ksad_feed_video_palyer_controller"), this, true);
        this.f13925f = (LinearLayout) findViewById(C3809l.m15789a(this.f13921b, "ksad_data_flow_container"));
        this.f13926g = (TextView) findViewById(C3809l.m15789a(this.f13921b, "ksad_data_flow_play"));
        this.f13926g.setOnClickListener(this);
        this.f13927h = (TextView) findViewById(C3809l.m15789a(this.f13921b, "ksad_video_network_unavailable"));
        this.f13928i = (LinearLayout) findViewById(C3809l.m15789a(this.f13921b, "ksad_video_error_container"));
        this.f13929j = (ProgressBar) findViewById(C3809l.m15789a(this.f13921b, "ksad_video_progress"));
        this.f13930k = (ImageView) findViewById(C3809l.m15789a(this.f13921b, "ksad_video_thumb_image"));
    }

    /* renamed from: k */
    private void m17347k() {
        ViewGroup viewGroup = this.f13931l;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    /* renamed from: l */
    private void m17348l() {
        LinearLayout linearLayout;
        if (C4322a.m17651s(this.f13923d)) {
            linearLayout = (LinearLayout) findViewById(C3809l.m15789a(this.f13921b, "ksad_video_complete_app_container"));
            TextView textView = (TextView) findViewById(C3809l.m15789a(this.f13921b, "ksad_app_name"));
            TextView textView2 = (TextView) findViewById(C3809l.m15789a(this.f13921b, "ksad_app_download"));
            KSImageLoader.loadAppIcon((ImageView) findViewById(C3809l.m15789a(this.f13921b, "ksad_app_icon")), C4322a.m17644l(this.f13923d), 12);
            textView.setText(C4322a.m17645m(this.f13923d));
            textView2.setText(C4322a.m17650r(this.f13923d));
        } else {
            linearLayout = (LinearLayout) findViewById(C3809l.m15789a(this.f13921b, "ksad_video_complete_h5_container"));
            ((TextView) findViewById(C3809l.m15789a(this.f13921b, "ksad_h5_open"))).setText(C4322a.m17650r(this.f13923d));
        }
        this.f13931l = linearLayout;
        this.f13931l.setVisibility(0);
    }

    /* renamed from: m */
    private void m17349m() {
        this.f13925f.setVisibility(0);
    }

    /* renamed from: n */
    private void m17350n() {
        this.f13925f.setVisibility(8);
    }

    private void setTopBottomVisible(boolean z) {
        this.f13929j.setVisibility(z ? 0 : 8);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23930a() {
        this.f13927h.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23931a(int i) {
        if (i == -1) {
            mo23970i();
            setTopBottomVisible(false);
            this.f13927h.setVisibility(8);
            this.f13928i.setVisibility(0);
        } else if (i == 0) {
        } else {
            if (i == 1) {
                m17350n();
                this.f13927h.setVisibility(8);
                this.f13928i.setVisibility(8);
                this.f13929j.setVisibility(8);
                this.f13930k.setVisibility(8);
                m17347k();
            } else if (i == 2) {
                C4186a aVar = this.f13932m;
                if (aVar != null) {
                    aVar.mo23940a();
                }
                setTopBottomVisible(true);
                mo23969h();
            } else if (i == 7) {
                C4186a aVar2 = this.f13932m;
                if (aVar2 != null) {
                    aVar2.mo23942b();
                }
                mo23970i();
                setTopBottomVisible(false);
                KSImageLoader.loadImage(this.f13930k, C4322a.m17638f(this.f13923d));
                this.f13930k.setVisibility(0);
                m17348l();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo23932b() {
        this.f13927h.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo23933c() {
        mo23970i();
        this.f13929j.setProgress(0);
        this.f13929j.setSecondaryProgress(0);
        m17350n();
        this.f13927h.setVisibility(8);
        this.f13928i.setVisibility(8);
        this.f13929j.setVisibility(8);
        this.f13930k.setVisibility(8);
        m17347k();
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo23934d() {
        if (this.f13964a.mo23947d()) {
            if (!C3607b.m15045a(this.f13921b)) {
                mo23930a();
                return;
            }
            mo23932b();
            if (!C3607b.m15046b(this.f13921b) && !this.f13924e) {
                m17349m();
            } else {
                this.f13964a.mo23943a();
            }
        } else if (this.f13964a.mo23956h() || this.f13964a.mo23949f()) {
            this.f13964a.mo23945b();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo23935e() {
        this.f13964a.mo23946c();
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo23936f() {
        this.f13964a.mo23959k();
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public void mo23937g() {
        long currentPosition = this.f13964a.getCurrentPosition();
        long duration = this.f13964a.getDuration();
        this.f13929j.setSecondaryProgress(this.f13964a.getBufferPercentage());
        this.f13929j.setProgress((int) ((((float) currentPosition) * 100.0f) / ((float) duration)));
        C4186a aVar = this.f13932m;
        if (aVar != null) {
            aVar.mo23941a(currentPosition);
        }
    }

    public void onClick(View view) {
        if (view == this.f13926g) {
            this.f13924e = true;
            mo23934d();
        }
    }

    public void setVideoPlayCallback(C4186a aVar) {
        this.f13932m = aVar;
    }
}
