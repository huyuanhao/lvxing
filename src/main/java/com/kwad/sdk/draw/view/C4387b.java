package com.kwad.sdk.draw.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ksad.download.p297c.C3607b;
import com.kwad.sdk.core.p334h.p336b.C4195c;
import com.kwad.sdk.core.p334h.p336b.C4198d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.p306a.C3809l;

/* renamed from: com.kwad.sdk.draw.view.b */
public class C4387b extends C4195c {
    /* renamed from: b */
    private Context f14376b;
    /* renamed from: c */
    private AdTemplate f14377c;
    /* renamed from: d */
    private TextView f14378d;
    /* renamed from: e */
    private LinearLayout f14379e;
    /* renamed from: f */
    private C4388a f14380f;

    /* renamed from: com.kwad.sdk.draw.view.b$a */
    public interface C4388a {
        /* renamed from: a */
        void mo24592a();

        /* renamed from: a */
        void mo24593a(long j);

        /* renamed from: b */
        void mo24594b();
    }

    public C4387b(Context context, AdTemplate adTemplate, C4198d dVar) {
        super(context, dVar);
        this.f14376b = context;
        this.f14377c = adTemplate;
        m17898j();
    }

    /* renamed from: j */
    private void m17898j() {
        LayoutInflater.from(this.f14376b).inflate(C3809l.m15792b(this.f14376b, "ksad_draw_video_palyer_controller"), this, true);
        this.f14378d = (TextView) findViewById(C3809l.m15789a(this.f14376b, "ksad_video_network_unavailable"));
        this.f14379e = (LinearLayout) findViewById(C3809l.m15789a(this.f14376b, "ksad_video_error_container"));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo24586a() {
        this.f14378d.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23931a(int i) {
        if (i == -1) {
            mo23970i();
            this.f14378d.setVisibility(8);
            this.f14379e.setVisibility(0);
        } else if (i == 0) {
        } else {
            if (i == 1) {
                this.f14378d.setVisibility(8);
                this.f14379e.setVisibility(8);
            } else if (i == 2) {
                C4388a aVar = this.f14380f;
                if (aVar != null) {
                    aVar.mo24592a();
                }
                mo23969h();
            } else if (i == 7) {
                C4388a aVar2 = this.f14380f;
                if (aVar2 != null) {
                    aVar2.mo24594b();
                }
                mo23970i();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo24587b() {
        this.f14378d.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo23933c() {
        mo23970i();
        this.f14378d.setVisibility(8);
        this.f14379e.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo24588d() {
        if (this.f13964a.mo23947d()) {
            if (!C3607b.m15045a(this.f14376b)) {
                mo24586a();
                return;
            }
            mo24587b();
            this.f13964a.mo23943a();
        } else if (this.f13964a.mo23956h() || this.f13964a.mo23949f()) {
            this.f13964a.mo23945b();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo24589e() {
        this.f13964a.mo23946c();
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo24590f() {
        this.f13964a.mo23959k();
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public void mo23937g() {
        long currentPosition = this.f13964a.getCurrentPosition();
        this.f13964a.getDuration();
        C4388a aVar = this.f14380f;
        if (aVar != null) {
            aVar.mo24593a(currentPosition);
        }
    }

    public void setVideoPlayCallback(C4388a aVar) {
        this.f14380f = aVar;
    }
}
