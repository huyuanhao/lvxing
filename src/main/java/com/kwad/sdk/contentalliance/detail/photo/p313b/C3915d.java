package com.kwad.sdk.contentalliance.detail.photo.p313b;

import android.os.SystemClock;
import com.kwad.sdk.contentalliance.detail.C3872b;
import com.kwad.sdk.contentalliance.detail.C3873c;
import com.kwad.sdk.contentalliance.detail.video.C3987c;
import com.kwad.sdk.contentalliance.detail.video.C3988d;
import com.kwad.sdk.contentalliance.detail.video.C3989e;
import com.kwad.sdk.contentalliance.detail.video.C3990f;
import com.kwad.sdk.contentalliance.p308a.C3828a;
import com.kwad.sdk.contentalliance.p308a.C3829b;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.p333g.C4145c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.core.response.p342b.C4325d;
import com.kwad.sdk.p306a.C3813p;

/* renamed from: com.kwad.sdk.contentalliance.detail.photo.b.d */
public class C3915d extends C3872b {
    /* access modifiers changed from: private */
    /* renamed from: c */
    public AdTemplate f13230c;
    /* renamed from: d */
    private PhotoInfo f13231d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public C3813p f13232e = new C3813p();
    /* access modifiers changed from: private */
    /* renamed from: f */
    public long f13233f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public long f13234g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public boolean f13235h = false;
    /* renamed from: i */
    private boolean f13236i = false;
    /* access modifiers changed from: private */
    /* renamed from: j */
    public boolean f13237j = false;
    /* renamed from: k */
    private boolean f13238k = false;
    /* access modifiers changed from: private */
    /* renamed from: l */
    public boolean f13239l = false;
    /* access modifiers changed from: private */
    /* renamed from: m */
    public boolean f13240m = false;
    /* access modifiers changed from: private */
    /* renamed from: n */
    public long f13241n;
    /* access modifiers changed from: private */
    /* renamed from: o */
    public long f13242o = 0;
    /* renamed from: p */
    private long f13243p = 0;
    /* access modifiers changed from: private */
    /* renamed from: q */
    public int f13244q;
    /* access modifiers changed from: private */
    /* renamed from: r */
    public boolean f13245r = false;
    /* renamed from: s */
    private C3989e f13246s = new C3990f() {
        /* renamed from: a */
        public void mo23373a() {
            C3915d.this.f13234g = SystemClock.elapsedRealtime();
            if (C3915d.this.f13235h && C3915d.this.f13239l) {
                C4145c.m17156a(C3915d.this.f13230c, C3915d.this.f13233f);
            }
            C3915d.this.f13235h = false;
        }

        /* renamed from: a */
        public void mo23345a(long j, long j2) {
            C3915d.this.f13241n = j2;
        }

        /* renamed from: b */
        public void mo23346b() {
            C3915d.this.f13245r = true;
            C3915d.this.f13241n = 0;
            C3915d.this.f13244q = C3915d.this.f13244q + 1;
        }

        /* renamed from: c */
        public void mo23347c() {
            C3915d.this.f13235h = false;
            C3915d.this.f13241n = 0;
            if (!C3915d.this.f13245r) {
                C3915d.this.f13242o = SystemClock.elapsedRealtime();
                C3915d.this.f13240m = true;
                C3915d.this.m16258q();
            }
        }

        /* renamed from: g */
        public void mo23431g() {
            C3915d.this.f13235h = true;
            if (C3915d.this.f13239l) {
                C4145c.m17166b(C3915d.this.f13230c, C3915d.this.f13233f, SystemClock.elapsedRealtime() - C3915d.this.f13234g);
            }
        }
    };
    /* renamed from: t */
    private C3828a f13247t = new C3829b() {
        /* renamed from: a */
        public void mo23230a() {
            C3915d.this.f13237j = false;
            C3873c.f13126j = C3915d.this.f13233f;
            C3915d.this.f13232e.mo23209d();
            C3915d.this.m16259r();
            C3915d.this.m16255i();
        }

        /* renamed from: b */
        public void mo23231b() {
            super.mo23231b();
            C3915d.this.f13237j = true;
            C3915d.this.m16258q();
        }
    };
    /* renamed from: u */
    private C3987c f13248u = new C3988d() {
        /* renamed from: a */
        public void mo23348a() {
            if (!C3872b.f13124a) {
                C3872b.f13124a = true;
                StringBuilder sb = new StringBuilder();
                sb.append("onPageVisible position=");
                sb.append(C3915d.this.f13233f);
                C4065b.m16863a("PhotoLogPresenter", sb.toString());
                C3915d.this.m16258q();
            }
        }

        /* renamed from: b */
        public void mo23349b() {
            C3872b.f13124a = false;
            StringBuilder sb = new StringBuilder();
            sb.append("HomeFragment onInvisible position=");
            sb.append(C3915d.this.f13233f);
            C4065b.m16863a("PhotoLogPresenter", sb.toString());
        }
    };

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m16255i() {
        StringBuilder sb = new StringBuilder();
        sb.append("resetParams position=");
        sb.append(this.f13233f);
        C4065b.m16863a("PhotoLogPresenter", sb.toString());
        this.f13236i = false;
        this.f13238k = false;
        this.f13239l = false;
        this.f13240m = false;
        this.f13244q = 0;
        this.f13241n = 0;
        this.f13245r = false;
        this.f13242o = 0;
        this.f13243p = 0;
        this.f13232e.mo23210e();
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public void m16258q() {
        mo23430h();
        mo23429g();
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public void m16259r() {
        if (this.f13238k) {
            long longValue = C4325d.m17673b(this.f13231d).longValue();
            int i = this.f13244q;
            long j = longValue * ((long) i);
            long j2 = this.f13241n;
            long j3 = j + j2;
            this.f13242o = 0;
            int i2 = (i <= 0 || j2 != 0) ? 2 : 1;
            long f = this.f13232e.mo23211f();
            StringBuilder sb = new StringBuilder();
            sb.append("position = ");
            sb.append(this.f13233f);
            sb.append(", stayDuration==");
            sb.append(f);
            C4065b.m16863a("PhotoLogPresenter", sb.toString());
            C4145c.m17160a(this.f13230c, this.f13233f, j3, i2, f);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23338a() {
        super.mo23338a();
        StringBuilder sb = new StringBuilder();
        sb.append("onBind position=");
        sb.append(this.f13233f);
        C4065b.m16863a("PhotoLogPresenter", sb.toString());
        m16255i();
        this.f13230c = this.f13125b.f13133g;
        this.f13231d = C4324c.m17669f(this.f13230c);
        this.f13233f = (long) this.f13125b.f13132f;
        this.f13125b.f13135i.mo23557a(this.f13246s);
        this.f13125b.f13135i.mo23556a(this.f13248u);
        this.f13125b.f13127a.add(this.f13247t);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo23340c() {
        super.mo23340c();
        StringBuilder sb = new StringBuilder();
        sb.append("onUnbind position=");
        sb.append(this.f13233f);
        C4065b.m16863a("PhotoLogPresenter", sb.toString());
        this.f13125b.f13135i.mo23560b(this.f13246s);
        this.f13125b.f13135i.mo23559b(this.f13248u);
        this.f13125b.f13127a.remove(this.f13247t);
    }

    /* renamed from: d */
    public void mo23342d() {
        super.mo23342d();
        this.f13232e.mo23208c();
    }

    /* renamed from: e */
    public void mo23343e() {
        super.mo23343e();
        this.f13232e.mo23207b();
    }

    /* renamed from: f */
    public void mo23421f() {
        super.mo23421f();
    }

    /* renamed from: g */
    public void mo23429g() {
        if (this.f13238k && this.f13240m && !this.f13239l) {
            long k = this.f13125b.f13135i.mo23569k();
            if (k < 0) {
                k = this.f13242o - this.f13243p;
            }
            C4145c.m17159a(this.f13230c, this.f13233f, k);
            this.f13239l = true;
        }
    }

    /* renamed from: h */
    public void mo23430h() {
        if (f13124a && this.f13237j && !this.f13238k) {
            this.f13243p = SystemClock.elapsedRealtime();
            this.f13232e.mo23206a();
            int i = this.f13233f > C3873c.f13126j ? 1 : this.f13233f < C3873c.f13126j ? 2 : 3;
            StringBuilder sb = new StringBuilder();
            sb.append("position = ");
            sb.append(this.f13233f);
            sb.append(" enterType = ");
            sb.append(i);
            sb.append(" sPrePosition = ");
            sb.append(C3873c.f13126j);
            C4065b.m16863a("PhotoLogPresenter", sb.toString());
            C4145c.m17157a(this.f13230c, this.f13233f, i);
            this.f13238k = true;
        }
    }
}
