package com.kwad.sdk.contentalliance;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.kwad.sdk.contentalliance.detail.C3849a;
import com.kwad.sdk.core.p320d.C4067b;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.p306a.C3809l;

/* renamed from: com.kwad.sdk.contentalliance.a */
public abstract class C3827a<T extends C4067b> extends Fragment {
    /* renamed from: a */
    protected Presenter f12959a;
    /* renamed from: b */
    protected T f12960b;
    /* renamed from: c */
    protected View f12961c;

    /* access modifiers changed from: protected */
    /* renamed from: a_ */
    public void mo23226a_() {
        Presenter presenter = this.f12959a;
        if (presenter != null) {
            presenter.mo24765k();
        }
    }

    /* renamed from: b_ */
    public abstract String mo23227b_();

    /* renamed from: c */
    public abstract T mo23228c();

    /* renamed from: d */
    public abstract Presenter mo23229d();

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f12960b = mo23228c();
        if (this.f12959a == null) {
            this.f12959a = mo23229d();
            this.f12959a.mo24761a(this.f12961c);
        }
        this.f12959a.mo24763a((Object) this.f12960b);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f12961c == null) {
            this.f12961c = layoutInflater.inflate(C3809l.m15792b(getContext(), mo23227b_()), viewGroup, false);
        }
        return this.f12961c;
    }

    public void onDestroyView() {
        super.onDestroyView();
        T t = this.f12960b;
        if (t != null) {
            t.mo23367a();
        }
        if (!(this instanceof C3849a)) {
            mo23226a_();
        }
    }

    public void onPause() {
        super.onPause();
        Presenter presenter = this.f12959a;
        if (presenter != null) {
            presenter.mo23343e();
        }
    }

    public void onResume() {
        super.onResume();
        Presenter presenter = this.f12959a;
        if (presenter != null) {
            presenter.mo23342d();
        }
    }

    public void onStop() {
        super.onStop();
        Presenter presenter = this.f12959a;
        if (presenter != null) {
            presenter.mo24766l();
        }
    }
}
