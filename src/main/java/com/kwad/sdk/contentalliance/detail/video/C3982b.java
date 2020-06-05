package com.kwad.sdk.contentalliance.detail.video;

import android.content.Context;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.kwad.sdk.contentalliance.p308a.C3828a;
import com.kwad.sdk.contentalliance.p308a.C3830c;
import com.kwad.sdk.contentalliance.p308a.C3831d;
import com.kwad.sdk.core.p317a.C4057a;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.p333g.C4160k;
import com.kwad.sdk.core.p334h.p335a.C4174c;
import com.kwad.sdk.core.p334h.p335a.C4174c.C4179e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4322a;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.core.response.p342b.C4325d;
import com.kwad.sdk.core.videocache.p345c.C4347a;
import com.kwad.sdk.p306a.C3817t;
import com.kwad.sdk.p306a.C3818u;
import com.kwad.sdk.p306a.C3818u.C3819a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.kwad.sdk.contentalliance.detail.video.b */
public class C3982b implements C3819a, C3828a {
    /* renamed from: j */
    private static boolean f13398j = false;
    /* renamed from: a */
    private C3818u f13399a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public ViewGroup f13400b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean f13401c;
    /* renamed from: d */
    private String f13402d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public C3971a f13403e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public Fragment f13404f;
    /* renamed from: g */
    private Context f13405g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public long f13406h;
    /* access modifiers changed from: private */
    /* renamed from: i */
    public long f13407i = -1;
    /* renamed from: k */
    private C3830c f13408k = new C3831d() {
        /* renamed from: a */
        public void mo23234a() {
        }

        /* renamed from: b */
        public void mo23235b() {
            C3982b.this.mo23566h();
        }

        /* renamed from: c */
        public void mo23236c() {
            C3982b.this.m16492r();
            C3982b.this.f13403e.mo23541m();
        }

        /* renamed from: d */
        public void mo23237d() {
            C3982b.this.m16492r();
            C3982b.this.f13403e.mo23541m();
        }
    };
    /* renamed from: l */
    private List<C3986a> f13409l = new ArrayList();
    /* renamed from: m */
    private List<C3987c> f13410m = new ArrayList();

    /* renamed from: com.kwad.sdk.contentalliance.detail.video.b$a */
    public interface C3986a {
        /* renamed from: a */
        boolean mo23435a();
    }

    public C3982b(Fragment fragment, DetailVideoView detailVideoView, AdTemplate adTemplate) {
        this.f13404f = fragment;
        this.f13405g = this.f13404f.getContext();
        this.f13402d = C4324c.m17664a(adTemplate) ? C4322a.m17632a(C4324c.m17668e(adTemplate)) : C4325d.m17672a(C4324c.m17669f(adTemplate));
        this.f13403e = new C3971a(detailVideoView);
        m16489o();
        this.f13403e.mo23526a((C4179e) new C4179e() {
            /* renamed from: a */
            public void mo23545a(C4174c cVar) {
                if (C3982b.this.f13401c && C3982b.this.f13404f.isResumed() && C3817t.m15867a((View) C3982b.this.f13400b, 70)) {
                    C3982b.this.f13407i = SystemClock.elapsedRealtime() - C3982b.this.f13406h;
                    C3982b.this.f13403e.mo23535g();
                }
            }
        });
        this.f13403e.mo23525a((C3989e) new C3990f() {
        });
        this.f13400b = (ViewGroup) detailVideoView.getParent().getParent();
    }

    /* renamed from: a */
    private void m16481a(boolean z) {
        if (z) {
            for (C3987c a : this.f13410m) {
                a.mo23348a();
            }
            return;
        }
        for (C3987c b : this.f13410m) {
            b.mo23349b();
        }
    }

    /* renamed from: a */
    private boolean m16482a(Fragment fragment) {
        Fragment parentFragment = fragment.getParentFragment();
        boolean isHidden = fragment.isHidden();
        if (parentFragment == null) {
            return isHidden;
        }
        boolean z = isHidden || m16482a(parentFragment);
        return z;
    }

    /* renamed from: o */
    private void m16489o() {
        this.f13403e.mo23528b();
        this.f13403e.mo23527a(m16490p());
        this.f13403e.mo23534f();
    }

    /* renamed from: p */
    private String m16490p() {
        return C4057a.m16833j() ? C4347a.m17748a(this.f13405g.getApplicationContext()).mo24506a(this.f13402d) : this.f13402d;
    }

    /* renamed from: q */
    private void m16491q() {
        if (this.f13399a == null) {
            this.f13399a = new C3818u(this);
        }
        this.f13399a.sendEmptyMessage(1);
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public void m16492r() {
        C3818u uVar = this.f13399a;
        if (uVar != null) {
            uVar.removeCallbacksAndMessages(null);
            this.f13399a = null;
        }
    }

    /* renamed from: a */
    public void mo23230a() {
        m16492r();
        this.f13401c = false;
        this.f13403e.mo23541m();
    }

    /* renamed from: a */
    public void mo23214a(Message message) {
        if (message.what == 1) {
            Fragment fragment = this.f13404f;
            if (fragment != null) {
                boolean z = !fragment.isResumed() || m16482a(this.f13404f) || !this.f13404f.isVisible();
                String str = "DetailPlayModule";
                if (!C3817t.m15868a((View) this.f13400b, 70, false) || z) {
                    if (!f13398j) {
                        C4065b.m16863a(str, "sendEmptyMessageDelayed(MSG_UPDATE_SESSION_ID)");
                        this.f13399a.sendEmptyMessageDelayed(2, 300000);
                        f13398j = true;
                    }
                    m16481a(false);
                    if (this.f13403e.mo23539k()) {
                        mo23566h();
                    }
                } else {
                    if (f13398j) {
                        C4065b.m16863a(str, "removeMessages(MSG_UPDATE_SESSION_ID)");
                        this.f13399a.removeMessages(2);
                        f13398j = false;
                    }
                    m16481a(true);
                    if (!this.f13403e.mo23539k()) {
                        mo23564f();
                    }
                }
                this.f13399a.sendEmptyMessageDelayed(1, 500);
            }
        } else if (message.what == 2) {
            C4160k.m17223a();
            f13398j = false;
        }
    }

    /* renamed from: a */
    public void mo23555a(C3986a aVar) {
        this.f13409l.add(aVar);
    }

    /* renamed from: a */
    public void mo23556a(C3987c cVar) {
        this.f13410m.add(cVar);
    }

    /* renamed from: a */
    public void mo23557a(C3989e eVar) {
        this.f13403e.mo23525a(eVar);
    }

    /* renamed from: b */
    public void mo23231b() {
        StringBuilder sb = new StringBuilder();
        sb.append("becomesAttachedOnPageSelected ");
        sb.append(this);
        String str = "DetailPlayModule";
        C4065b.m16863a(str, sb.toString());
        this.f13406h = SystemClock.elapsedRealtime();
        m16491q();
        this.f13401c = true;
        if (this.f13403e.mo23520a() == null) {
            C4065b.m16863a(str, "becomesAttachedOnPageSelected createPlayerAndPrepare");
            m16489o();
        }
        if (this.f13403e.mo23532d()) {
            C4065b.m16863a(str, "becomesAttachedOnPageSelected play start");
            this.f13407i = SystemClock.elapsedRealtime() - this.f13406h;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("becomesAttachedOnPageSelected mStartPlayDuration= ");
            sb2.append(this.f13407i);
            C4065b.m16863a(str, sb2.toString());
            this.f13403e.mo23535g();
        }
    }

    /* renamed from: b */
    public void mo23558b(C3986a aVar) {
        this.f13409l.remove(aVar);
    }

    /* renamed from: b */
    public void mo23559b(C3987c cVar) {
        this.f13410m.remove(cVar);
    }

    /* renamed from: b */
    public void mo23560b(C3989e eVar) {
        this.f13403e.mo23529b(eVar);
    }

    /* renamed from: c */
    public boolean mo23561c() {
        return this.f13403e.mo23539k();
    }

    /* renamed from: d */
    public boolean mo23562d() {
        return this.f13403e.mo23533e();
    }

    /* renamed from: e */
    public C3830c mo23563e() {
        return this.f13408k;
    }

    /* renamed from: f */
    public void mo23564f() {
        boolean z;
        if (this.f13401c && this.f13404f.isResumed()) {
            Iterator it = this.f13409l.iterator();
            loop0:
            while (true) {
                z = false;
                while (true) {
                    if (!it.hasNext()) {
                        break loop0;
                    }
                    C3986a aVar = (C3986a) it.next();
                    if (z || aVar.mo23435a()) {
                        z = true;
                    }
                }
            }
            if (!z) {
                this.f13403e.mo23537i();
            }
        }
    }

    /* renamed from: g */
    public void mo23565g() {
        this.f13403e.mo23530b(m16490p());
    }

    /* renamed from: h */
    public void mo23566h() {
        if (this.f13401c) {
            this.f13403e.mo23540l();
        }
    }

    /* renamed from: i */
    public void mo23567i() {
        this.f13403e.mo23536h();
    }

    /* renamed from: j */
    public long mo23568j() {
        return this.f13403e.mo23542n();
    }

    /* renamed from: k */
    public long mo23569k() {
        return this.f13407i;
    }

    /* renamed from: l */
    public void mo23570l() {
        m16492r();
        C3971a aVar = this.f13403e;
        if (aVar != null) {
            aVar.mo23541m();
        }
    }

    /* renamed from: m */
    public void mo23232m() {
    }

    /* renamed from: n */
    public void mo23233n() {
    }
}
