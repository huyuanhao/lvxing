package com.kwad.sdk.core.view;

import android.os.Message;
import android.view.View;
import com.kwad.sdk.p306a.C3817t;
import com.kwad.sdk.p306a.C3818u;
import com.kwad.sdk.p306a.C3818u.C3819a;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.kwad.sdk.core.view.b */
public class C4371b implements C3819a {
    /* renamed from: a */
    private final C3818u f14314a = new C3818u(this);
    /* renamed from: b */
    private Set<C4372a> f14315b;
    /* renamed from: c */
    private View f14316c;
    /* renamed from: d */
    private int f14317d;

    /* renamed from: com.kwad.sdk.core.view.b$a */
    public interface C4372a {
        /* renamed from: a */
        void mo24547a(boolean z);
    }

    public C4371b(View view, int i) {
        this.f14316c = view;
        this.f14317d = i;
    }

    /* renamed from: a */
    private void m17841a(boolean z) {
        Set<C4372a> set = this.f14315b;
        if (set != null) {
            for (C4372a aVar : set) {
                if (aVar != null) {
                    aVar.mo24547a(z);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo24541a() {
        this.f14314a.sendEmptyMessage(1);
    }

    /* renamed from: a */
    public void mo23214a(Message message) {
        if (message.what == 1) {
            m17841a(mo24546d());
            this.f14314a.sendEmptyMessageDelayed(1, 500);
        }
    }

    /* renamed from: a */
    public void mo24542a(C4372a aVar) {
        if (aVar != null) {
            if (this.f14315b == null) {
                this.f14315b = new HashSet();
            }
            this.f14315b.add(aVar);
        }
    }

    /* renamed from: b */
    public void mo24543b() {
        this.f14314a.removeCallbacksAndMessages(null);
    }

    /* renamed from: b */
    public void mo24544b(C4372a aVar) {
        if (aVar != null) {
            Set<C4372a> set = this.f14315b;
            if (set != null) {
                set.remove(aVar);
            }
        }
    }

    /* renamed from: c */
    public void mo24545c() {
        mo24543b();
        Set<C4372a> set = this.f14315b;
        if (set != null) {
            set.clear();
        }
    }

    /* renamed from: d */
    public boolean mo24546d() {
        return C3817t.m15867a(this.f14316c, this.f14317d);
    }
}
