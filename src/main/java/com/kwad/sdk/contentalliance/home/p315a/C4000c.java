package com.kwad.sdk.contentalliance.home.p315a;

import com.kwad.sdk.contentalliance.home.C4012d;
import com.kwad.sdk.contentalliance.home.viewpager.C4026b.C4027a;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.contentalliance.refreshview.KsAdHotRefreshView;
import com.kwad.sdk.core.p319c.C4065b;

/* renamed from: com.kwad.sdk.contentalliance.home.a.c */
public class C4000c extends C4012d {
    /* renamed from: b */
    private KsAdHotRefreshView f13439b;
    /* renamed from: c */
    private SlidePlayViewPager f13440c;
    /* renamed from: d */
    private C4027a f13441d;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23338a() {
        super.mo23338a();
        C4065b.m16867b("HomeViewPagerPresenter", "onBind");
        this.f13440c = this.f13465a.f13468c;
        this.f13440c.mo23604a(this.f13465a, this.f13439b);
        this.f13441d = new C4027a() {
            /* renamed from: a */
            public void mo23581a() {
                C4065b.m16867b("HomeViewPagerPresenter", "downTouchOnTopBound");
            }

            /* renamed from: b */
            public void mo23582b() {
                C4065b.m16867b("HomeViewPagerPresenter", "upTouchOnBottomBound");
            }
        };
        this.f13440c.mo23616a(this.f13441d);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo23339b() {
        super.mo23339b();
        this.f13439b = (KsAdHotRefreshView) mo24760a("ksad_refresh_layout");
        this.f13439b.setRefreshInitialOffset(0.0f);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo23340c() {
        super.mo23340c();
        C4065b.m16867b("HomeViewPagerPresenter", "onUnbind");
        this.f13440c.mo23618b(this.f13441d);
        this.f13440c.mo23608e();
    }
}
