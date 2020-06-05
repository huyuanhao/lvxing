package com.kwad.sdk.contentalliance.detail.photo.p313b;

import android.widget.ProgressBar;
import com.kwad.sdk.contentalliance.detail.C3872b;
import com.kwad.sdk.contentalliance.detail.video.C3982b;
import com.kwad.sdk.contentalliance.detail.video.C3989e;
import com.kwad.sdk.contentalliance.detail.video.C3990f;
import com.kwad.sdk.contentalliance.p308a.C3828a;
import com.kwad.sdk.contentalliance.p308a.C3829b;
import com.kwad.sdk.core.p317a.C4057a;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.core.response.p342b.C4325d;

/* renamed from: com.kwad.sdk.contentalliance.detail.photo.b.e */
public class C3919e extends C3872b {
    /* access modifiers changed from: private */
    /* renamed from: c */
    public ProgressBar f13252c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public C3982b f13253d;
    /* renamed from: e */
    private C3828a f13254e = new C3829b() {
        /* renamed from: a */
        public void mo23230a() {
            super.mo23230a();
            C3919e.this.f13252c.setVisibility(8);
        }

        /* renamed from: b */
        public void mo23231b() {
            super.mo23231b();
        }
    };
    /* renamed from: f */
    private C3989e f13255f = new C3990f() {
        /* renamed from: a */
        public void mo23345a(long j, long j2) {
            long j3 = C3919e.this.f13253d.mo23568j();
            C3919e.this.f13252c.setProgress(j3 != 0 ? (int) ((((float) j2) * 100.0f) / ((float) j3)) : 0);
        }

        /* renamed from: c */
        public void mo23347c() {
            C3919e.this.f13252c.setProgress(0);
            C3919e.this.f13252c.setVisibility(0);
        }
    };

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23338a() {
        super.mo23338a();
        this.f13253d = this.f13125b.f13135i;
        PhotoInfo f = C4324c.m17669f(this.f13125b.f13133g);
        int i = C4057a.m16832i();
        if (i != 0 && C4325d.m17673b(f).longValue() >= ((long) (i * 1000))) {
            this.f13125b.f13127a.add(this.f13254e);
            this.f13253d.mo23557a(this.f13255f);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo23339b() {
        super.mo23339b();
        this.f13252c = (ProgressBar) mo24760a("ksad_video_progress_bar");
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo23340c() {
        super.mo23340c();
        this.f13125b.f13127a.remove(this.f13254e);
        this.f13253d.mo23560b(this.f13255f);
        this.f13252c.setVisibility(8);
    }
}
