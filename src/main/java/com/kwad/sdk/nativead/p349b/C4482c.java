package com.kwad.sdk.nativead.p349b;

import com.kwad.sdk.contentalliance.detail.video.C3989e;
import com.kwad.sdk.contentalliance.detail.video.C3990f;
import com.kwad.sdk.core.p333g.C4143b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4322a;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.nativead.p348a.C4474a;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.nativead.b.c */
public class C4482c extends C4474a {
    /* access modifiers changed from: private */
    /* renamed from: b */
    public AdTemplate f14651b;
    /* renamed from: c */
    private AdInfo f14652c;
    /* renamed from: d */
    private C3989e f14653d = new C3990f() {
        /* renamed from: a */
        public void mo23345a(long j, long j2) {
            C4482c.this.m18227a(j2);
        }

        /* renamed from: b */
        public void mo23346b() {
            C4143b.m17138f(C4482c.this.f14651b);
        }

        /* renamed from: c */
        public void mo23347c() {
            if (!C4482c.this.f14651b.mPvReported) {
                C4482c.this.f14621a.f14622a.onAdShow(null);
            }
            C4143b.m17123a(C4482c.this.f14651b, (JSONObject) null);
            C4143b.m17136e(C4482c.this.f14651b);
        }
    };

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18227a(long j) {
        int ceil = (int) Math.ceil((double) (((float) j) / 1000.0f));
        List<String> A = C4322a.m17625A(this.f14652c);
        if (A != null) {
            for (String equals : A) {
                if (String.valueOf(ceil).equals(equals)) {
                    C4143b.m17116a(this.f14651b, ceil);
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23338a() {
        super.mo23338a();
        this.f14651b = this.f14621a.f14625d;
        this.f14652c = C4324c.m17668e(this.f14651b);
        this.f14621a.f14627f.mo24793a(this.f14653d);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo23340c() {
        super.mo23340c();
        this.f14621a.f14627f.mo24795b(this.f14653d);
    }
}
