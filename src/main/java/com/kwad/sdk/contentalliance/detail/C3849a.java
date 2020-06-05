package com.kwad.sdk.contentalliance.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.contentalliance.C3827a;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.contentalliance.p308a.C3828a;
import com.kwad.sdk.core.p320d.C4067b;

/* renamed from: com.kwad.sdk.contentalliance.detail.a */
public abstract class C3849a<T extends C4067b> extends C3827a<T> implements C3828a {
    /* renamed from: d */
    protected SlidePlayViewPager f13047d;
    /* renamed from: e */
    protected boolean f13048e;
    /* renamed from: f */
    protected boolean f13049f;
    /* renamed from: g */
    private boolean f13050g;

    /* renamed from: a_ */
    public void mo23226a_() {
        super.mo23226a_();
    }

    /* renamed from: e */
    public final void mo23330e() {
        if (mo23336k() && !this.f13048e) {
            this.f13048e = true;
            mo23231b();
        }
    }

    /* renamed from: f */
    public final void mo23331f() {
        if (mo23336k() && this.f13048e) {
            this.f13048e = false;
            mo23230a();
        }
    }

    /* renamed from: g */
    public final void mo23332g() {
        if (mo23336k() && !this.f13049f) {
            this.f13049f = true;
            mo23232m();
        }
    }

    /* renamed from: h */
    public final void mo23333h() {
        if (mo23336k() && this.f13049f) {
            this.f13049f = false;
            mo23233n();
        }
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: i */
    public final void mo23334i() {
        int i = getArguments() != null ? getArguments().getInt("KEY_INDEX_IN_VIEW_PAGER") : -1;
        SlidePlayViewPager slidePlayViewPager = this.f13047d;
        if (slidePlayViewPager != null && i == slidePlayViewPager.getCurrentItem()) {
            mo23330e();
            mo23332g();
        }
    }

    /* renamed from: j */
    public boolean mo23335j() {
        return this.f13050g;
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public boolean mo23336k() {
        return true;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f13050g = true;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (viewGroup instanceof SlidePlayViewPager) {
            this.f13047d = (SlidePlayViewPager) viewGroup;
        }
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f13050g = false;
        mo23331f();
        mo23333h();
    }
}
