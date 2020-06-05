package com.kwad.sdk.contentalliance.home;

import android.os.Handler;
import android.os.Looper;
import com.kwad.sdk.core.p333g.C4160k;
import com.kwad.sdk.core.request.C4296i;
import com.kwad.sdk.core.request.C4296i.C4301a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.protocol.model.AdScene;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kwad.sdk.contentalliance.home.a */
public class C3991a {
    /* renamed from: a */
    private AdScene f13414a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public List<AdTemplate> f13415b = new ArrayList();
    /* renamed from: c */
    private List<C4010b> f13416c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public boolean f13417d = false;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean f13418e = false;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public boolean f13419f;

    public C3991a(AdScene adScene) {
        this.f13414a = adScene;
        this.f13416c = new ArrayList();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16545a(int i, String str) {
        for (C4010b a : this.f13416c) {
            a.mo23584a(i, str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m16548b(boolean z) {
        for (C4010b a : this.f13416c) {
            a.mo23585a(z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m16551c() {
        if (!this.f13419f) {
            C4296i.m17590a(this.f13414a, (C4301a) new C4301a() {
                /* renamed from: a */
                public void mo23578a(int i, String str) {
                    C3991a.this.f13419f = false;
                }

                /* renamed from: a */
                public void mo23579a(List<AdTemplate> list) {
                    C4011c.m16624a(list);
                    C3991a.this.f13419f = false;
                }
            });
        }
    }

    /* renamed from: d */
    private void m16554d() {
        for (C4010b a : this.f13416c) {
            a.mo23583a();
        }
    }

    /* renamed from: a */
    public void mo23572a(C4010b bVar) {
        this.f13416c.add(bVar);
    }

    /* renamed from: a */
    public boolean mo23573a() {
        List<AdTemplate> list = this.f13415b;
        return list != null && !list.isEmpty();
    }

    /* renamed from: a */
    public boolean mo23574a(final boolean z) {
        if (this.f13418e) {
            return false;
        }
        this.f13418e = true;
        m16554d();
        if (this.f13419f || !C4011c.m16625a()) {
            C4296i.m17590a(this.f13414a, (C4301a) new C4301a() {
                /* renamed from: a */
                public void mo23578a(int i, String str) {
                    C3991a.this.m16545a(i, str);
                    C3991a.this.f13418e = false;
                }

                /* renamed from: a */
                public void mo23579a(List<AdTemplate> list) {
                    if (z) {
                        C3991a.this.f13415b.clear();
                    }
                    if (C3991a.this.f13415b.isEmpty()) {
                        C4160k.m17229d();
                    }
                    C3991a.this.f13415b.addAll(list);
                    C3991a.this.m16548b(z);
                    C3991a.this.f13418e = false;
                    if (C3991a.this.f13417d) {
                        C3991a.this.m16551c();
                    }
                }
            });
            return true;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                if (z) {
                    C3991a.this.f13415b.clear();
                }
                if (C3991a.this.f13415b.isEmpty()) {
                    C4160k.m17229d();
                }
                C3991a.this.f13415b.addAll(C4011c.m16626b());
                C4011c.m16627c();
                C3991a.this.m16548b(z);
                if (C3991a.this.f13417d) {
                    C3991a.this.m16551c();
                }
                C3991a.this.f13418e = false;
            }
        });
        return true;
    }

    /* renamed from: b */
    public List<AdTemplate> mo23575b() {
        return this.f13415b;
    }

    /* renamed from: b */
    public void mo23576b(C4010b bVar) {
        this.f13416c.remove(bVar);
    }
}
