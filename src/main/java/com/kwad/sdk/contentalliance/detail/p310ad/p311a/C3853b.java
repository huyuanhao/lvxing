package com.kwad.sdk.contentalliance.detail.p310ad.p311a;

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
import com.kwad.sdk.core.p333g.C4143b;
import com.kwad.sdk.core.p333g.C4145c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4322a;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.p306a.C3813p;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.kwad.sdk.contentalliance.detail.ad.a.b */
public class C3853b extends C3872b {
    /* renamed from: c */
    private AdTemplate f13061c;
    /* renamed from: d */
    private AdInfo f13062d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public long f13063e;
    /* renamed from: f */
    private boolean f13064f = false;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public boolean f13065g = false;
    /* renamed from: h */
    private boolean f13066h = false;
    /* renamed from: i */
    private boolean f13067i = false;
    /* access modifiers changed from: private */
    /* renamed from: j */
    public boolean f13068j = false;
    /* access modifiers changed from: private */
    /* renamed from: k */
    public long f13069k;
    /* access modifiers changed from: private */
    /* renamed from: l */
    public long f13070l = 0;
    /* renamed from: m */
    private long f13071m = 0;
    /* access modifiers changed from: private */
    /* renamed from: n */
    public C3813p f13072n = new C3813p();
    /* access modifiers changed from: private */
    /* renamed from: o */
    public boolean f13073o = false;
    /* renamed from: p */
    private C3989e f13074p = new C3990f() {
        /* renamed from: a */
        public void mo23345a(long j, long j2) {
            C3853b.this.m16016b(j2);
            C3853b.this.f13069k = j2;
        }

        /* renamed from: b */
        public void mo23346b() {
            C3853b.this.m16031r();
            C3853b.this.f13073o = true;
        }

        /* renamed from: c */
        public void mo23347c() {
            C3853b.this.m16030q();
            C3853b.this.f13069k = 0;
            if (!C3853b.this.f13073o) {
                C3853b.this.f13070l = SystemClock.elapsedRealtime();
                C3853b.this.f13068j = true;
                C3853b.this.m16029i();
            }
        }
    };
    /* renamed from: q */
    private C3828a f13075q = new C3829b() {
        /* renamed from: a */
        public void mo23230a() {
            C3853b.this.f13065g = false;
            C3873c.f13126j = C3853b.this.f13063e;
            C3853b.this.f13072n.mo23209d();
            C3853b bVar = C3853b.this;
            bVar.m16011a(bVar.f13069k);
            C3853b.this.m16027h();
        }

        /* renamed from: b */
        public void mo23231b() {
            super.mo23231b();
            C3853b.this.f13065g = true;
            C3853b.this.m16029i();
        }
    };
    /* renamed from: r */
    private C3987c f13076r = new C3988d() {
        /* renamed from: a */
        public void mo23348a() {
            if (!C3872b.f13124a) {
                C3872b.f13124a = true;
                StringBuilder sb = new StringBuilder();
                sb.append("onPageVisible position=");
                sb.append(C3853b.this.f13063e);
                C4065b.m16863a("AdLogPresenter", sb.toString());
                C3853b.this.m16029i();
            }
        }

        /* renamed from: b */
        public void mo23349b() {
            C3872b.f13124a = false;
            StringBuilder sb = new StringBuilder();
            sb.append("HomeFragment onInvisible position=");
            sb.append(C3853b.this.f13063e);
            C4065b.m16863a("AdLogPresenter", sb.toString());
        }
    };

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16011a(long j) {
        if (this.f13066h) {
            this.f13070l = 0;
            long f = this.f13072n.mo23211f();
            StringBuilder sb = new StringBuilder();
            sb.append("position = ");
            sb.append(this.f13063e);
            sb.append(" stayDuration = ");
            sb.append(f);
            C4065b.m16863a("AdLogPresenter", sb.toString());
            C4145c.m17160a(this.f13061c, this.f13063e, j, 2, f);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m16016b(long j) {
        if (C4324c.m17664a(this.f13061c)) {
            int ceil = (int) Math.ceil((double) (((float) j) / 1000.0f));
            List A = C4322a.m17625A(this.f13062d);
            if (A != null) {
                Iterator it = A.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (String.valueOf(ceil).equals((String) it.next())) {
                        C4143b.m17116a(this.f13061c, ceil);
                        break;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m16027h() {
        StringBuilder sb = new StringBuilder();
        sb.append("resetParams position=");
        sb.append(this.f13063e);
        C4065b.m16863a("AdLogPresenter", sb.toString());
        this.f13064f = false;
        this.f13066h = false;
        this.f13067i = false;
        this.f13068j = false;
        this.f13069k = 0;
        this.f13073o = false;
        this.f13070l = 0;
        this.f13071m = 0;
        this.f13072n.mo23210e();
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m16029i() {
        mo23344g();
        mo23341c_();
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public void m16030q() {
        C4143b.m17136e(this.f13061c);
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public void m16031r() {
        C4143b.m17138f(this.f13061c);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23338a() {
        super.mo23338a();
        this.f13061c = this.f13125b.f13133g;
        this.f13062d = C4324c.m17668e(this.f13061c);
        this.f13063e = (long) this.f13125b.f13132f;
        this.f13125b.f13135i.mo23557a(this.f13074p);
        this.f13125b.f13135i.mo23556a(this.f13076r);
        this.f13125b.f13127a.add(this.f13075q);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo23340c() {
        super.mo23340c();
        this.f13125b.f13135i.mo23560b(this.f13074p);
        this.f13125b.f13135i.mo23559b(this.f13076r);
        this.f13125b.f13127a.remove(this.f13075q);
    }

    /* renamed from: c_ */
    public void mo23341c_() {
        if (this.f13066h && this.f13068j && !this.f13067i) {
            long k = this.f13125b.f13135i.mo23569k();
            if (k < 0) {
                k = this.f13070l - this.f13071m;
            }
            C4145c.m17159a(this.f13061c, this.f13063e, k);
            this.f13067i = true;
        }
    }

    /* renamed from: d */
    public void mo23342d() {
        super.mo23342d();
        this.f13072n.mo23208c();
    }

    /* renamed from: e */
    public void mo23343e() {
        super.mo23343e();
        this.f13072n.mo23207b();
    }

    /* renamed from: g */
    public void mo23344g() {
        if (f13124a && this.f13065g && !this.f13066h) {
            this.f13071m = SystemClock.elapsedRealtime();
            this.f13072n.mo23206a();
            int i = this.f13063e > C3873c.f13126j ? 1 : this.f13063e < C3873c.f13126j ? 2 : 3;
            StringBuilder sb = new StringBuilder();
            sb.append("position = ");
            sb.append(this.f13063e);
            sb.append(" enterType = ");
            sb.append(i);
            C4065b.m16863a("AdLogPresenter", sb.toString());
            C4145c.m17157a(this.f13061c, this.f13063e, i);
            this.f13066h = true;
        }
    }
}
