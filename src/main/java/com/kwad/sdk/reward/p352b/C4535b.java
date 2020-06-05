package com.kwad.sdk.reward.p352b;

import android.widget.FrameLayout;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4323b;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.p307b.C3823a;
import com.kwad.sdk.reward.C4536c;

/* renamed from: com.kwad.sdk.reward.b.b */
public class C4535b extends C4536c {
    /* renamed from: b */
    private AdBaseFrameLayout f14778b;
    /* renamed from: c */
    private FrameLayout f14779c;
    /* renamed from: d */
    private C3823a f14780d;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23338a() {
        super.mo23338a();
        AdTemplate adTemplate = this.f14781a.f14760d;
        if (C4323b.m17662d(adTemplate)) {
            this.f14780d = this.f14781a.f14763g;
            C3823a aVar = this.f14780d;
            if (aVar != null) {
                aVar.mo23218a(this.f14779c, this.f14778b, adTemplate, this.f14781a.f14762f, this.f14781a.f14761e);
                this.f14780d.mo23216a();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo23339b() {
        super.mo23339b();
        this.f14778b = (AdBaseFrameLayout) mo24760a("ksad_root_container");
        this.f14779c = (FrameLayout) mo24760a("ksad_web_card_container");
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo23340c() {
        super.mo23340c();
        C3823a aVar = this.f14780d;
        if (aVar != null) {
            aVar.mo23222d();
        }
    }
}
