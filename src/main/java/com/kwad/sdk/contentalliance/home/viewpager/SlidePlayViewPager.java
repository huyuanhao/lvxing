package com.kwad.sdk.contentalliance.home.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.kwad.sdk.contentalliance.home.C3991a;
import com.kwad.sdk.contentalliance.home.C4013e;
import com.kwad.sdk.contentalliance.home.viewpager.p316a.C4017a;
import com.kwad.sdk.contentalliance.home.viewpager.p316a.C4023b;
import com.kwad.sdk.contentalliance.refreshview.C4053e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import java.util.List;

public class SlidePlayViewPager extends C4026b {
    /* renamed from: f */
    private Fragment f13474f;
    /* renamed from: g */
    private Presenter f13475g;
    /* renamed from: h */
    private C4029d f13476h;
    /* renamed from: i */
    private C4016a f13477i;
    /* renamed from: j */
    private C3991a f13478j;

    public SlidePlayViewPager(Context context) {
        this(context, null);
    }

    public SlidePlayViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* renamed from: n */
    private void m16632n() {
        this.f13476h = new C4029d();
        C4029d dVar = this.f13476h;
        dVar.f13513a = this.f13478j;
        dVar.f13514b = this.f13474f;
        dVar.f13515c = this;
        dVar.f13516d = this.f13505d;
    }

    /* renamed from: o */
    private void m16633o() {
        this.f13475g = new Presenter();
        this.f13475g.mo24762a((Presenter) new C4023b());
        this.f13475g.mo24762a((Presenter) new C4017a());
        this.f13475g.mo24761a((View) this);
    }

    /* renamed from: a */
    public void mo23604a(C4013e eVar, C4053e eVar2) {
        this.f13474f = eVar.f13466a;
        this.f13505d = eVar2;
        this.f13478j = eVar.f13467b;
        this.f13502a = true;
        this.f13503b = true;
        this.f13477i = new C4016a(this.f13474f.getChildFragmentManager());
        setAdapter(this.f13477i);
        m16632n();
        m16633o();
        this.f13475g.mo24763a((Object) this.f13476h);
    }

    /* renamed from: a */
    public void mo23605a(List<AdTemplate> list) {
        this.f13477i.mo23611a(list);
    }

    /* renamed from: a */
    public void mo23606a(boolean z) {
        int currentItem = this.f13476h.f13515c.getCurrentItem();
        if (currentItem > -1 && currentItem < getAdapter().getCount() - 1) {
            mo23255a(currentItem + 1, z);
        }
    }

    /* renamed from: b */
    public void mo23607b(List<AdTemplate> list) {
        C4016a aVar = this.f13477i;
        if (aVar != null) {
            aVar.mo23612a(false);
        }
        this.f13477i = new C4016a(this.f13474f.getChildFragmentManager());
        setAdapter(this.f13477i);
        this.f13477i.mo23611a(list);
    }

    /* renamed from: e */
    public void mo23608e() {
        this.f13475g.mo24765k();
    }

    public C4016a getAdapter() {
        return this.f13477i;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
