package com.kwad.sdk.contentalliance.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.kwad.sdk.contentalliance.detail.C3872b;
import com.kwad.sdk.contentalliance.home.p315a.C3995a;
import com.kwad.sdk.contentalliance.home.p315a.C3996b;
import com.kwad.sdk.contentalliance.home.p315a.C4000c;
import com.kwad.sdk.contentalliance.home.p315a.C4002d;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.p333g.C4149f;
import com.kwad.sdk.core.p333g.C4156i.C4158b;
import com.kwad.sdk.core.scene.C4331a;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.p306a.C3809l;
import com.kwad.sdk.p306a.C3810m;
import com.kwad.sdk.protocol.model.AdScene;

/* renamed from: com.kwad.sdk.contentalliance.home.f */
public class C4014f extends Fragment {
    /* renamed from: a */
    public AdScene f13470a;
    /* renamed from: b */
    protected Presenter f13471b;
    /* renamed from: c */
    protected View f13472c;

    /* renamed from: a */
    public static Fragment m16629a(AdScene adScene) {
        C4014f fVar = new C4014f();
        Bundle bundle = new Bundle();
        bundle.putSerializable("key_AdScene", adScene);
        fVar.setArguments(bundle);
        return fVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C4013e mo23601a() {
        C4013e eVar = new C4013e();
        eVar.f13466a = this;
        eVar.f13468c = (SlidePlayViewPager) this.f13472c.findViewById(C3809l.m15789a(getContext(), "ksad_slide_play_view_pager"));
        eVar.f13467b = new C3991a(this.f13470a);
        eVar.f13469d = this.f13470a;
        return eVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Presenter mo23602b() {
        Presenter presenter = new Presenter();
        presenter.mo24762a((Presenter) new C3996b());
        presenter.mo24762a((Presenter) new C3995a());
        presenter.mo24762a((Presenter) new C4000c());
        if (C3810m.m15804c(getContext())) {
            presenter.mo24762a((Presenter) new C4002d());
        }
        return presenter;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        C4065b.m16867b("HomeFragment", "onActivityCreated");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C4065b.m16867b("HomeFragment", "onCreateView");
        if (this.f13472c == null) {
            this.f13472c = layoutInflater.inflate(C3809l.m15792b(getContext(), "ksad_content_alliance_home_fragment"), viewGroup, false);
        }
        this.f13472c.post(new Runnable() {
            public void run() {
                C4158b.m17213a(C4014f.this.f13472c.getWidth());
                C4158b.m17215b(C4014f.this.f13472c.getHeight());
            }
        });
        return this.f13472c;
    }

    public void onDestroy() {
        super.onDestroy();
        C4065b.m16867b("HomeFragment", "onDestroy");
    }

    public void onDestroyView() {
        super.onDestroyView();
        C4065b.m16867b("HomeFragment", "onDestroyView");
        C4149f.m17180a();
        C3872b.f13124a = false;
        Presenter presenter = this.f13471b;
        if (presenter != null) {
            presenter.mo24765k();
        }
        C4331a.m17707a().mo24481a(String.valueOf(hashCode()));
    }

    public void onPause() {
        super.onPause();
        C4065b.m16867b("HomeFragment", "onPause");
    }

    public void onResume() {
        super.onResume();
        C4065b.m16867b("HomeFragment", "onResume");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x003b, code lost:
            if (getActivity() != null) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0047, code lost:
            if (getActivity() != null) goto L_0x0049;
     */
    public void onViewCreated(android.view.View r3, android.os.Bundle r4) {
        /*
        r2 = this;
        super.onViewCreated(r3, r4)
        java.lang.String r3 = "HomeFragment"
        java.lang.String r4 = "onViewCreated"
        com.kwad.sdk.core.p319c.C4065b.m16867b(r3, r4)
        android.os.Bundle r4 = r2.getArguments()
        if (r4 == 0) goto L_0x003e
        java.lang.String r0 = "key_AdScene"
        java.io.Serializable r4 = r4.getSerializable(r0)
        boolean r0 = r4 instanceof com.kwad.sdk.protocol.model.AdScene
        if (r0 == 0) goto L_0x0032
        com.kwad.sdk.protocol.model.AdScene r4 = (com.kwad.sdk.protocol.model.AdScene) r4
        r2.f13470a = r4
        com.kwad.sdk.core.scene.a r3 = com.kwad.sdk.core.scene.C4331a.m17707a()
        com.kwad.sdk.protocol.model.AdScene r4 = r2.f13470a
        com.kwad.sdk.core.scene.PageScene$PageSource r0 = com.kwad.sdk.core.scene.PageScene.PageSource.HOMETAB
        int r1 = r2.hashCode()
        java.lang.String r1 = java.lang.String.valueOf(r1)
        r3.mo24480a(r4, r0, r1)
        goto L_0x0050
    L_0x0032:
        java.lang.String r4 = "mAdScene is null"
        com.kwad.sdk.core.p319c.C4065b.m16869d(r3, r4)
        androidx.fragment.app.FragmentActivity r3 = r2.getActivity()
        if (r3 == 0) goto L_0x0050
        goto L_0x0049
    L_0x003e:
        java.lang.String r4 = "bundle is null"
        com.kwad.sdk.core.p319c.C4065b.m16869d(r3, r4)
        androidx.fragment.app.FragmentActivity r3 = r2.getActivity()
        if (r3 == 0) goto L_0x0050
    L_0x0049:
        androidx.fragment.app.FragmentActivity r3 = r2.getActivity()
        r3.finish()
    L_0x0050:
        com.kwad.sdk.mvp.Presenter r3 = r2.mo23602b()
        r2.f13471b = r3
        com.kwad.sdk.mvp.Presenter r3 = r2.f13471b
        android.view.View r4 = r2.f13472c
        r3.mo24761a(r4)
        com.kwad.sdk.mvp.Presenter r3 = r2.f13471b
        com.kwad.sdk.contentalliance.home.e r4 = r2.mo23601a()
        r3.mo24763a(r4)
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.contentalliance.home.C4014f.onViewCreated(android.view.View, android.os.Bundle):void");
    }
}
