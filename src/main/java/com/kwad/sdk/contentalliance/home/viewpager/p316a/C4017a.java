package com.kwad.sdk.contentalliance.home.viewpager.p316a;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.kwad.sdk.contentalliance.home.C3991a;
import com.kwad.sdk.contentalliance.home.C4010b;
import com.kwad.sdk.contentalliance.home.viewpager.C4026b.C4027a;
import com.kwad.sdk.contentalliance.home.viewpager.C4028c;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.contentalliance.refreshview.C4053e;
import com.kwad.sdk.contentalliance.refreshview.RefreshLayout.C4042b;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.p306a.C3801f;

/* renamed from: com.kwad.sdk.contentalliance.home.viewpager.a.a */
public class C4017a extends C4028c {
    /* renamed from: b */
    private volatile boolean f13482b;
    /* access modifiers changed from: private|volatile */
    /* renamed from: c */
    public volatile boolean f13483c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public int f13484d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public SlidePlayViewPager f13485e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public C3991a f13486f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public C4053e f13487g;
    /* renamed from: h */
    private C4042b f13488h = new C4042b() {
        /* renamed from: a */
        public void mo23613a() {
            C4017a.this.m16665i();
        }
    };
    /* renamed from: i */
    private C4027a f13489i = new C4027a() {
        /* renamed from: a */
        public void mo23581a() {
        }

        /* renamed from: b */
        public void mo23582b() {
            C4017a.this.m16664h();
        }
    };
    /* renamed from: j */
    private OnPageChangeListener f13490j = new OnPageChangeListener() {
        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append("onPageSelected position:");
            sb.append(i);
            C4065b.m16867b("ViewPagerDataFetcherPresenter", sb.toString());
            C4017a.this.m16651a(i);
            C4017a.this.f13484d = i;
        }
    };
    /* renamed from: k */
    private C4010b f13491k = new C4010b() {
        /* renamed from: a */
        public void mo23583a() {
        }

        /* renamed from: a */
        public void mo23584a(int i, String str) {
            if (C4017a.this.f13483c && i == 100006) {
                C3801f.m15757a(C4017a.this.mo24770p(), str);
            }
            if (C4017a.this.f13487g != null) {
                C4017a.this.f13487g.setRefreshing(false);
            }
            C4017a.this.m16666q();
        }

        /* renamed from: a */
        public void mo23585a(boolean z) {
            if (z) {
                if (C4017a.this.f13487g != null) {
                    C4017a.this.f13487g.setRefreshing(false);
                }
                C4017a.this.f13485e.postDelayed(new Runnable() {
                    public void run() {
                        C4017a.this.f13485e.mo23607b(C4017a.this.f13486f.mo23575b());
                        C4017a.this.m16666q();
                    }
                }, 300);
                return;
            }
            C4017a.this.f13485e.mo23605a(C4017a.this.f13486f.mo23575b());
            C4017a.this.m16666q();
        }
    };

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16651a(int i) {
        if (!this.f13482b && this.f13484d < i && i >= this.f13485e.getAdapter().getCount() - 3) {
            m16654a(false, false);
        }
    }

    /* renamed from: a */
    private void m16654a(boolean z, boolean z2) {
        this.f13483c = z2;
        this.f13482b = this.f13486f.mo23574a(z);
    }

    /* renamed from: g */
    private void m16661g() {
        if (!this.f13482b) {
            m16654a(false, false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m16664h() {
        if (!this.f13482b) {
            m16654a(false, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m16665i() {
        if (!this.f13482b) {
            m16654a(true, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public void m16666q() {
        this.f13483c = false;
        this.f13482b = false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23338a() {
        super.mo23338a();
        this.f13486f = this.f13512a.f13513a;
        this.f13485e = this.f13512a.f13515c;
        this.f13485e.mo23259a(this.f13490j);
        this.f13486f.mo23572a(this.f13491k);
        this.f13487g = this.f13512a.f13516d;
        C4053e eVar = this.f13487g;
        if (eVar != null) {
            eVar.setOnRefreshListener(this.f13488h);
        }
        this.f13485e.mo23616a(this.f13489i);
        m16661g();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo23340c() {
        super.mo23340c();
        this.f13486f.mo23576b(this.f13491k);
    }
}
