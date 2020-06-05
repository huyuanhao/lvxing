package com.kwad.sdk.contentalliance.home.viewpager;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.kwad.sdk.contentalliance.detail.C3849a;
import com.kwad.sdk.contentalliance.detail.p310ad.C3850a;
import com.kwad.sdk.contentalliance.detail.photo.C3885a;
import com.kwad.sdk.contentalliance.p309b.C3834a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4324c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kwad.sdk.contentalliance.home.viewpager.a */
public class C4016a extends C3834a {
    /* renamed from: c */
    private final SparseArray<Fragment> f13479c = new SparseArray<>();
    /* renamed from: d */
    private boolean f13480d;
    /* renamed from: e */
    private List<AdTemplate> f13481e = new ArrayList();

    public C4016a(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    /* renamed from: b */
    private void m16639b(int i, boolean z) {
        for (int i2 = 0; i2 < this.f13479c.size(); i2++) {
            Fragment fragment = (Fragment) this.f13479c.valueAt(i2);
            if (this.f13479c.keyAt(i2) != i && (fragment instanceof C3849a)) {
                C3849a aVar = (C3849a) fragment;
                if (aVar.mo23335j()) {
                    if (z) {
                        aVar.mo23333h();
                    } else {
                        aVar.mo23331f();
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private void m16640b(boolean z) {
        for (int i = 0; i < this.f13479c.size(); i++) {
            Fragment fragment = (Fragment) this.f13479c.valueAt(i);
            if (fragment instanceof C3849a) {
                C3849a aVar = (C3849a) fragment;
                aVar.mo23331f();
                aVar.mo23333h();
                if (z) {
                    aVar.mo23226a_();
                }
            }
        }
    }

    /* renamed from: c */
    private void m16641c(int i, boolean z) {
        Fragment fragment = (Fragment) this.f13479c.get(i);
        if (fragment instanceof C3849a) {
            C3849a aVar = (C3849a) fragment;
            if (!aVar.mo23335j()) {
                return;
            }
            if (z) {
                aVar.mo23332g();
            } else {
                aVar.mo23330e();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo23241a(int i) {
        AdTemplate adTemplate = (AdTemplate) this.f13481e.get(i);
        if (adTemplate != null) {
            return C4324c.m17664a(adTemplate) ? 0 : 100;
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo23242a(Fragment fragment) {
        if (fragment instanceof C3850a) {
            return 0;
        }
        return fragment instanceof C3885a ? 100 : -1;
    }

    /* renamed from: a */
    public Fragment mo23609a() {
        return this.f12964b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Fragment mo23243a(int i, int i2) {
        return i2 != 0 ? i2 != 100 ? new Fragment() : new C3885a() : new C3850a();
    }

    /* renamed from: a */
    public void mo23610a(int i, boolean z) {
        if (!this.f13480d) {
            m16639b(i, z);
            m16641c(i, z);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23244a(Fragment fragment, int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("KEY_INDEX_IN_VIEW_PAGER", i);
        bundle.putSerializable("key_template", (Serializable) this.f13481e.get(i));
        if (fragment.getArguments() != null) {
            fragment.getArguments().clear();
            fragment.getArguments().putAll(bundle);
            return;
        }
        fragment.setArguments(bundle);
    }

    /* renamed from: a */
    public void mo23611a(List<AdTemplate> list) {
        if (list != null && !list.isEmpty()) {
            this.f13481e.clear();
            this.f13481e.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* renamed from: a */
    public void mo23612a(boolean z) {
        m16640b(z);
        this.f13480d = true;
        this.f13479c.clear();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo23246b(Fragment fragment) {
        return fragment instanceof C3849a;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        super.destroyItem(viewGroup, i, obj);
        this.f13479c.remove(i);
    }

    public int getCount() {
        return this.f13481e.size();
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        Fragment fragment = (Fragment) super.instantiateItem(viewGroup, i);
        this.f13479c.put(i, fragment);
        return fragment;
    }
}
