package com.p368pw.inner.p369a.p370a.p373c;

import com.p368pw.inner.base.p387d.C5188f;
import com.p368pw.inner.base.p387d.C5205o;
import com.p522qq.p523e.ads.nativ.NativeUnifiedADData;
import com.tencent.p605ep.shanhuad.adpublic.models.AdMetaInfo;
import com.tmsdk.module.coin.CoinTask;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.pw.inner.a.a.c.h */
public class C4850h {
    /* renamed from: a */
    public boolean f15619a;
    /* renamed from: b */
    public List<AdMetaInfo> f15620b;
    /* renamed from: c */
    public Map<AdMetaInfo, CoinTask> f15621c;
    /* renamed from: d */
    public Object f15622d;
    /* renamed from: e */
    public boolean f15623e;
    /* renamed from: f */
    public boolean f15624f;
    /* renamed from: g */
    public boolean f15625g;
    /* renamed from: h */
    public AtomicBoolean f15626h = new AtomicBoolean(false);
    /* renamed from: i */
    public Map<String, String> f15627i = new HashMap();
    /* renamed from: j */
    private C4847e f15628j;
    /* renamed from: k */
    private C4848f f15629k;
    /* access modifiers changed from: private */
    /* renamed from: l */
    public List<C4847e> f15630l;
    /* access modifiers changed from: private */
    /* renamed from: m */
    public List<C4848f> f15631m;

    /* renamed from: a */
    public C4847e mo25861a() {
        if (this.f15628j == null) {
            this.f15628j = new C4847e() {
                /* renamed from: a */
                public void mo25854a() {
                    C5205o.m21461a();
                    if (C5188f.m21379b(C4850h.this.f15630l)) {
                        for (C4847e a : C4850h.this.f15630l) {
                            a.mo25854a();
                        }
                    }
                }

                /* renamed from: a */
                public void mo25855a(NativeUnifiedADData nativeUnifiedADData) {
                    C5205o.m21461a();
                    if (C5188f.m21379b(C4850h.this.f15630l)) {
                        for (C4847e a : C4850h.this.f15630l) {
                            a.mo25855a(nativeUnifiedADData);
                        }
                    }
                }
            };
        }
        return this.f15628j;
    }

    /* renamed from: a */
    public void mo25862a(C4847e eVar) {
        if (eVar != null) {
            if (this.f15630l == null) {
                this.f15630l = new ArrayList();
            }
            this.f15630l.add(eVar);
        }
    }

    /* renamed from: b */
    public C4848f mo25863b() {
        if (this.f15629k == null) {
            this.f15629k = new C4848f() {
                /* renamed from: a */
                public void mo25856a() {
                    if (C5188f.m21379b(C4850h.this.f15631m)) {
                        for (C4848f a : C4850h.this.f15631m) {
                            a.mo25856a();
                        }
                    }
                }

                /* renamed from: b */
                public void mo25857b() {
                    if (C5188f.m21379b(C4850h.this.f15631m)) {
                        for (C4848f b : C4850h.this.f15631m) {
                            b.mo25857b();
                        }
                    }
                }

                /* renamed from: c */
                public void mo25858c() {
                    if (C5188f.m21379b(C4850h.this.f15631m)) {
                        for (C4848f c : C4850h.this.f15631m) {
                            c.mo25858c();
                        }
                    }
                }

                /* renamed from: d */
                public void mo25859d() {
                    if (C5188f.m21379b(C4850h.this.f15631m)) {
                        for (C4848f d : C4850h.this.f15631m) {
                            d.mo25859d();
                        }
                    }
                }
            };
        }
        return this.f15629k;
    }
}
