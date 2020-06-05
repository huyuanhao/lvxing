package com.p368pw.inner.appwall;

import android.content.Context;
import com.p368pw.inner.appwall.C4970aa.C4978a;
import com.p368pw.inner.base.p384a.C5125f;
import com.p368pw.inner.base.p385b.C5131a.C5134a;
import com.p368pw.inner.base.p385b.C5138c;
import com.p368pw.inner.base.p387d.C5187e;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.C5206p;
import com.p368pw.inner.base.p387d.C5207q;
import com.p368pw.inner.base.p387d.C5211s;
import com.p368pw.inner.base.p387d.p391d.C5183b;
import com.p368pw.inner.base.stat.C5224e;
import com.p368pw.inner.p369a.p370a.p371a.C4827e;
import com.p368pw.inner.p369a.p370a.p373c.C4850h;
import com.p368pw.inner.p369a.p379e.C4933e.C4940a;
import com.p368pw.inner.p369a.p379e.C4958h;
import com.p368pw.inner.p369a.p379e.C4960j;
import com.p368pw.p392us.DownloadNotifyManager;
import com.p368pw.p392us.Setting;
import com.tencent.p605ep.shanhuad.adpublic.models.AdMetaInfo;
import com.tmsdk.module.coin.CoinTask;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* renamed from: com.pw.inner.appwall.b */
public class C4990b {
    /* renamed from: a */
    private boolean f16229a = false;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public int f16230b = 399;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public int f16231c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public int f16232d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public int f16233e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public Setting f16234f;
    /* renamed from: g */
    private C4850h f16235g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public HashSet<String> f16236h;
    /* renamed from: i */
    private HashSet<String> f16237i;
    /* renamed from: j */
    private HashMap<C5034m, AdMetaInfo> f16238j;
    /* renamed from: k */
    private HashMap<C5034m, AdMetaInfo> f16239k;
    /* renamed from: l */
    private HashSet<String> f16240l;
    /* renamed from: m */
    private boolean f16241m = false;

    /* renamed from: com.pw.inner.appwall.b$a */
    private static class C4995a {
        /* access modifiers changed from: private|static */
        /* renamed from: a */
        public static C4990b f16253a = new C4990b();
    }

    /* renamed from: a */
    public static long m20865a(Context context, String str) {
        return C5206p.m21468a(context, str);
    }

    /* renamed from: a */
    static C4958h m20866a(C5138c cVar) {
        String str = "";
        C4958h hVar = new C4958h();
        try {
            hVar.mo26224e(str).mo26212a(str).mo26228g(cVar.f16772a).mo26230h(cVar.f16773b).mo26226f(cVar.f16774c).mo26219c(cVar.f16777f).mo26222d(cVar.mo26743a()).mo26213a(true);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
        return hVar;
    }

    /* renamed from: a */
    public static C4990b m20867a() {
        return C4995a.f16253a;
    }

    /* renamed from: a */
    private void m20869a(Context context) {
        try {
            if (!this.f16229a) {
                C5030k e = C5125f.m21216a().mo26728e();
                if (e != null) {
                    this.f16230b = 399;
                    this.f16231c = e.mo26434a();
                    this.f16232d = e.mo26435b();
                    this.f16233e = e.mo26436c();
                    this.f16229a = true;
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static void m20870a(Context context, String str, long j) {
        C5206p.m21470a(context, str, j);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m20871a(Context context, boolean z) {
        C5030k e = C5125f.m21216a().mo26728e();
        String str = "waw_ht_ct";
        int a = (int) m20865a(context, str);
        String str2 = "waw_ht_tm";
        long a2 = m20865a(context, str2);
        int i = (a2 > 0 ? 1 : (a2 == 0 ? 0 : -1));
        if (i == 0 || (i > 0 && !C5187e.m21371a(a2))) {
            a2 = System.currentTimeMillis();
            m20870a(context, str2, a2);
        }
        if (a2 <= 0 || !C5187e.m21371a(a2)) {
            C5205o.m21462a("ht download limit error");
        } else if (a >= e.mo26449p()) {
            C5205o.m21462a("ht download limit full");
            return true;
        } else if (z) {
            m20870a(context, str, Long.valueOf((long) (a + 1)).longValue());
        }
        return false;
    }

    /* renamed from: a */
    public List<C5034m> mo26374a(Context context, String str, String str2) {
        return new ArrayList();
    }

    /* renamed from: a */
    public void mo26375a(Context context, C5034m mVar) {
        C5034m mVar2 = mVar;
        C5138c a = mVar.mo26466a();
        HashMap<C5034m, AdMetaInfo> hashMap = this.f16238j;
        if (hashMap != null) {
            if (((AdMetaInfo) hashMap.get(mVar2)) == null) {
                if (!a.f16793v) {
                    C5005h.m20951a().mo26401a(context, 3, mVar.mo26467b(), mVar.mo26468c(), "");
                }
                C5205o.m21462a("ht sh n ck");
                C5005h.m20951a().mo26401a(context, 4, mVar.mo26467b(), mVar.mo26468c(), "");
                this.f16238j.put(mVar2, mVar.mo26467b());
            } else {
                C5205o.m21462a("ht sh has ck");
            }
        }
        C5224e.m21525a().mo26908a(5, 1, "", a.f16785n, a.f16786o, this.f16234f.getPlacementId(), this.f16230b, this.f16231c, this.f16232d, this.f16233e, 0, a.f16795x, a.f16788q, a.f16789r, 2, a.f16790s, "", "", a.f16792u, 0.0d, a.mo26743a(), a.f16772a, a.f16783l, a.f16784m, a.f16791t);
    }

    /* renamed from: a */
    public void mo26376a(Context context, C5034m mVar, C5138c cVar) {
        Context context2 = context;
        C5034m mVar2 = mVar;
        C5138c cVar2 = cVar;
        C5205o.m21462a("ht active");
        HashMap<C5034m, AdMetaInfo> hashMap = this.f16239k;
        if (hashMap != null) {
            if (((AdMetaInfo) hashMap.get(mVar2)) == null) {
                C5205o.m21462a("ht sh n active");
                C5005h.m20951a().mo26401a(context, 2, mVar.mo26467b(), mVar.mo26468c(), "");
                this.f16239k.put(mVar2, mVar.mo26467b());
            } else {
                C5205o.m21462a("ht sh has active");
            }
        }
        cVar2.f16781j = 2;
        cVar2.f16782k = 1;
        C5005h.m20951a().mo26405a(mVar.mo26467b(), mVar.mo26468c(), cVar2.f16772a, cVar2.f16773b, cVar2.f16774c, cVar.mo26743a(), cVar2.f16776e, 2, 1, cVar2.f16785n, cVar2.f16786o, this.f16234f.getPlacementId(), String.valueOf(this.f16234f.getAdType()), cVar2.f16789r, cVar2.f16790s, cVar2.f16791t, 106, null);
        C4970aa.m20784a().mo26314a(context2, mVar2, 1);
        C4970aa.m20784a().mo26317a(context2, cVar.mo26743a());
    }

    /* renamed from: a */
    public void mo26377a(final Context context, C5047t tVar, C4978a aVar) {
        try {
            final C5034m d = tVar.mo26542d();
            final C5138c a = d.mo26466a();
            C4958h a2 = m20866a(a);
            StringBuilder sb = new StringBuilder();
            sb.append("ht tasksource2 = ");
            sb.append(a.f16792u);
            C5205o.m21462a(sb.toString());
            if (m20871a(context, false)) {
                C5211s.m21484a(context, "当天下载次数已用完，明天继续", 0);
                return;
            }
            final Context context2 = context;
            final C5138c cVar = a;
            final C4978a aVar2 = aVar;
            final C5047t tVar2 = tVar;
            C49911 r0 = new C4827e() {
                /* renamed from: a */
                public void mo25787a() {
                }

                /* renamed from: a */
                public void mo25788a(int i) {
                }

                /* renamed from: a */
                public void mo25789a(int i, C5183b bVar) {
                }

                /* renamed from: a */
                public void mo25790a(String str) {
                    C5205o.m21462a("ht download start");
                    C5005h.m20951a().mo26401a(context2, 5, d.mo26467b(), d.mo26468c(), "");
                }

                /* renamed from: a */
                public void mo25791a(String str, String str2) {
                    String str3 = str;
                    C5205o.m21462a("ht download finish");
                    try {
                        int i = cVar.f16785n;
                        String str4 = cVar.f16786o;
                        String placementId = C4990b.this.f16234f.getPlacementId();
                        int b = C4990b.this.f16230b;
                        int c = C4990b.this.f16231c;
                        int d = C4990b.this.f16232d;
                        int e = C4990b.this.f16233e;
                        String str5 = cVar.f16795x;
                        String str6 = cVar.f16788q;
                        int i2 = cVar.f16789r;
                        String str7 = cVar.f16790s;
                        int i3 = i;
                        String str8 = str4;
                        String str9 = str5;
                        String str10 = str6;
                        int i4 = i2;
                        String str11 = str7;
                        C5224e.m21525a().mo26908a(6, 1, "", i3, str8, placementId, b, c, d, e, 0, str9, str10, i4, 2, str11, "", "", cVar.f16792u, 0.0d, cVar.mo26743a(), cVar.f16772a, cVar.f16783l, cVar.f16784m, cVar.f16791t);
                        C5005h.m20951a().mo26401a(context2, 6, d.mo26467b(), d.mo26468c(), str2);
                        cVar.f16776e = str2;
                        cVar.mo26742a(str3);
                        C5005h a = C5005h.m20951a();
                        AdMetaInfo b2 = d.mo26467b();
                        CoinTask c2 = d.mo26468c();
                        String str12 = cVar.f16772a;
                        String str13 = cVar.f16773b;
                        String str14 = cVar.f16774c;
                        int i5 = cVar.f16785n;
                        String str15 = cVar.f16786o;
                        String placementId2 = C4990b.this.f16234f.getPlacementId();
                        String valueOf = String.valueOf(C4990b.this.f16234f.getAdType());
                        int i6 = cVar.f16789r;
                        String str16 = cVar.f16790s;
                        String str17 = str16;
                        int i7 = i6;
                        a.mo26405a(b2, c2, str12, str13, str14, str, str2, 1, 0, i5, str15, placementId2, valueOf, i7, str17, cVar.f16791t, 106, new C5134a() {
                            /* renamed from: a */
                            public void mo26382a() {
                                if (aVar2 != null) {
                                    aVar2.onRefresh();
                                }
                            }
                        });
                        String str18 = str;
                        C5005h.m20951a().mo26400a(context2, cVar.f16785n, C4990b.this.f16234f.getAdType(), str18, cVar.f16772a, cVar.f16773b, cVar.f16774c, "", "", cVar.f16777f, d.mo26467b(), d.mo26468c());
                        if (C4990b.this.f16236h != null) {
                            C4990b.this.f16236h.add(str);
                        }
                        C4990b.this.m20871a(context2, true);
                    } catch (Throwable unused) {
                    }
                }

                /* renamed from: b */
                public void mo25792b() {
                }

                /* renamed from: b */
                public void mo25793b(int i) {
                }

                /* renamed from: b */
                public void mo25794b(String str) {
                }

                /* renamed from: b */
                public void mo25795b(String str, String str2) {
                    C5004g.m20946a().mo26397b(d, 2);
                    C4978a aVar = aVar2;
                    if (aVar != null) {
                        aVar.onInstalled();
                    }
                    C5205o.m21462a("ht install finish");
                    if (C4990b.this.f16234f != null) {
                        C5224e.m21525a().mo26908a(7, 1, "", cVar.f16785n, cVar.f16786o, C4990b.this.f16234f.getPlacementId(), C4990b.this.f16230b, C4990b.this.f16231c, C4990b.this.f16232d, C4990b.this.f16233e, 0, cVar.f16795x, cVar.f16788q, cVar.f16789r, 2, cVar.f16790s, "", "", cVar.f16792u, 0.0d, cVar.mo26743a(), cVar.f16772a, cVar.f16783l, cVar.f16784m, cVar.f16791t);
                    }
                    C5005h.m20951a().mo26401a(context2, 1, d.mo26467b(), d.mo26468c(), "");
                    cVar.f16781j = 2;
                    C5005h a = C5005h.m20951a();
                    AdMetaInfo b = d.mo26467b();
                    CoinTask c = d.mo26468c();
                    String str3 = cVar.f16772a;
                    String str4 = cVar.f16773b;
                    String str5 = cVar.f16774c;
                    int i = cVar.f16785n;
                    String str6 = cVar.f16786o;
                    String placementId = C4990b.this.f16234f.getPlacementId();
                    String valueOf = String.valueOf(C4990b.this.f16234f.getAdType());
                    int i2 = cVar.f16789r;
                    String str7 = cVar.f16790s;
                    String str8 = cVar.f16791t;
                    C49932 r22 = r1;
                    C49932 r1 = new C5134a() {
                        /* renamed from: a */
                        public void mo26382a() {
                            if (aVar2 != null) {
                                aVar2.onRefresh();
                            }
                        }
                    };
                    a.mo26405a(b, c, str3, str4, str5, str, str2, 2, 0, i, str6, placementId, valueOf, i2, str7, str8, 106, r22);
                }

                /* renamed from: c */
                public void mo25796c() {
                }

                /* renamed from: c */
                public void mo25797c(int i) {
                }

                /* renamed from: d */
                public void mo25798d() {
                    C5205o.m21462a("ht install start");
                    C5211s.m21484a(context2.getApplicationContext(), C5207q.m21474a(C5125f.m21216a().mo26728e().mo26457x(), "应用下载成功，官方已验证，请放心安装"), 1);
                    C4978a aVar = aVar2;
                    if (aVar != null) {
                        aVar.onInstallStart(tVar2);
                    }
                    C5224e.m21525a().mo26908a(9, 1, "", cVar.f16785n, cVar.f16786o, C4990b.this.f16234f.getPlacementId(), C4990b.this.f16230b, C4990b.this.f16231c, C4990b.this.f16232d, C4990b.this.f16233e, 0, cVar.f16795x, cVar.f16788q, cVar.f16789r, 2, cVar.f16790s, "", "", cVar.f16792u, 0.0d, cVar.mo26743a(), cVar.f16772a, cVar.f16783l, cVar.f16784m, cVar.f16791t);
                }

                /* renamed from: d */
                public void mo25799d(int i) {
                }

                /* renamed from: e */
                public void mo25800e() {
                }

                /* renamed from: f */
                public void mo25801f() {
                }

                /* renamed from: g */
                public void mo25802g() {
                }

                /* renamed from: h */
                public void mo25803h() {
                }

                /* renamed from: i */
                public void mo25804i() {
                }

                /* renamed from: j */
                public void mo25805j() {
                    C5004g.m20946a().mo26395a(d, 2);
                }

                /* renamed from: k */
                public void mo25806k() {
                }

                /* renamed from: l */
                public void mo25807l() {
                }
            };
            C4960j.m20728a(context, a2, null, r0, new C4940a() {
                /* renamed from: a */
                public void mo26162a(int i) {
                    DownloadNotifyManager.showNotify(context.getApplicationContext(), a.mo26743a(), a.f16774c, a.f16772a, i, false);
                }

                /* renamed from: a */
                public void mo26163a(String str, String str2) {
                }

                /* renamed from: b */
                public void mo26164b(String str, String str2) {
                    DownloadNotifyManager.showNotify(context.getApplicationContext(), a.mo26743a(), a.f16774c, a.f16772a, 100, true);
                }
            });
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: a */
    public void mo26378a(Context context, Setting setting) {
        m20869a(context);
        this.f16234f = setting;
        if (this.f16238j == null) {
            this.f16238j = new HashMap<>();
        }
        if (this.f16239k == null) {
            this.f16239k = new HashMap<>();
        }
        this.f16236h = new HashSet<>();
        this.f16240l = new HashSet<>();
    }

    /* renamed from: a */
    public void mo26379a(Context context, List<C5034m> list) {
        List<C5034m> list2 = list;
        if (list2 != null && list.size() > 0) {
            int d = C5125f.m21216a().mo26728e().mo26437d();
            int size = list.size();
            int round = Math.round(((float) size) * (((float) d) / 10.0f));
            StringBuilder sb = new StringBuilder();
            sb.append("ht ads size = ");
            sb.append(size);
            C5205o.m21462a(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ht sh dpy = ");
            sb2.append(round);
            C5205o.m21462a(sb2.toString());
            for (int i = 0; i < size; i++) {
                C5034m mVar = (C5034m) list2.get(i);
                C5138c a = mVar.mo26466a();
                HashSet<String> hashSet = this.f16240l;
                if (hashSet == null || hashSet.add(a.mo26743a())) {
                    C5224e.m21525a().mo26908a(1, 1, "", a.f16785n, a.f16786o, this.f16234f.getPlacementId(), this.f16230b, this.f16231c, this.f16232d, this.f16233e, 0, a.f16795x, a.f16788q, a.f16789r, 2, a.f16790s, "", "", a.f16792u, 0.0d, a.mo26743a(), a.f16772a, a.f16783l, 0, a.f16791t);
                    C5224e.m21525a().mo26908a(2, 1, "", a.f16785n, a.f16786o, this.f16234f.getPlacementId(), this.f16230b, this.f16231c, this.f16232d, this.f16233e, 0, a.f16795x, a.f16788q, a.f16789r, 2, a.f16790s, "", "", a.f16792u, 0.0d, a.mo26743a(), a.f16772a, a.f16783l, 0, a.f16791t);
                    C5224e.m21525a().mo26908a(3, 1, "", a.f16785n, a.f16786o, this.f16234f.getPlacementId(), this.f16230b, this.f16231c, this.f16232d, this.f16233e, 0, a.f16795x, a.f16788q, a.f16789r, 2, a.f16790s, "", "", a.f16792u, 0.0d, a.mo26743a(), a.f16772a, a.f16783l, a.f16784m, a.f16791t);
                    if (i < round && !a.f16793v) {
                        C5005h.m20951a().mo26401a(context, 3, mVar.mo26467b(), mVar.mo26468c(), "");
                        a.f16793v = true;
                        mVar.mo26463a(a);
                    }
                }
            }
            this.f16241m = true;
        }
    }

    /* renamed from: a */
    public void mo26380a(String str) {
        if (this.f16237i == null) {
            this.f16237i = new HashSet<>();
        }
        this.f16237i.add(str);
    }

    /* renamed from: b */
    public void mo26381b() {
        this.f16235g = null;
        this.f16234f = null;
        this.f16236h = null;
        this.f16237i = null;
        this.f16238j = null;
        this.f16239k = null;
        this.f16241m = false;
        this.f16240l = null;
    }
}
