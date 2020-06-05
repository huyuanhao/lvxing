package com.p368pw.inner;

import android.text.TextUtils;
import com.p368pw.inner.base.C5130b;
import com.p368pw.inner.base.p384a.C5119a;
import com.p368pw.inner.base.p384a.C5120b;
import com.p368pw.inner.base.p384a.C5123d;
import com.p368pw.inner.base.p384a.C5125f;
import com.p368pw.inner.base.p387d.C5187e;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.C5208r;
import com.p368pw.inner.base.stat.C5224e;
import com.p368pw.inner.p369a.C4819a;
import com.p368pw.inner.p369a.C4819a.C4820a;
import com.p368pw.inner.p369a.C4875b;
import com.p368pw.inner.p369a.C4894c;
import com.p368pw.inner.p369a.C4911e;
import com.p368pw.inner.p369a.C4967g;
import com.p368pw.inner.p369a.p370a.p371a.C4822b;
import com.p368pw.inner.p369a.p370a.p371a.C4828f;
import com.p368pw.inner.p369a.p370a.p371a.C4831i;
import com.p368pw.inner.p369a.p370a.p372b.C4836a;
import com.p368pw.inner.p369a.p370a.p373c.C4857j;
import com.p368pw.p392us.AdInfo;
import com.p368pw.p392us.Setting;
import com.tencent.mid.core.Constants.ERROR;
import java.util.UUID;

/* renamed from: com.pw.inner.d */
public class C5229d {
    /* renamed from: a */
    private int f17032a = 343;
    /* renamed from: b */
    private int f17033b;
    /* renamed from: c */
    private int f17034c;
    /* renamed from: d */
    private int f17035d;

    /* renamed from: com.pw.inner.d$a */
    private static class C5232a {
        /* access modifiers changed from: private|static */
        /* renamed from: a */
        public static C5229d f17040a = new C5229d();
    }

    /* renamed from: a */
    private C4967g m21540a(C4967g gVar, C5123d dVar) {
        C4967g b = C4894c.m20178a().mo25974b();
        b.mo26304d(gVar.mo26307f());
        b.mo26306e(gVar.mo26308g());
        b.mo26302c(dVar.mo26689Q());
        return b;
    }

    /* renamed from: a */
    public static C5229d m21541a() {
        return C5232a.f17040a;
    }

    /* renamed from: a */
    private void m21544a(Setting setting, int i, int i2) {
        try {
            C5205o.m21462a("native reg view");
            if (i == 5) {
                C4857j.m19935a().mo25871a(setting, i2);
                return;
            }
            if (!(i == 3 || i == 4 || i == 6)) {
                if (i != 8) {
                    mo26918a(setting, "unkown ads source.");
                    return;
                }
            }
            C4831i.m19800a(setting, i2);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21545a(Setting setting, C4875b bVar, int i, C4820a aVar) {
        String str;
        int i2;
        Setting setting2 = setting;
        int i3 = i;
        C4820a aVar2 = aVar;
        try {
            C4967g a = C4894c.m20178a().mo25972a(C5233e.m21559b(), bVar, setting.getAdType(), setting.getPlacementId(), i);
            C5123d d = C5125f.m21216a().mo26727d();
            if (mo26919b() == 1) {
                a = m21540a(a, d);
            }
            C4911e a2 = mo26916a(a);
            a2.f15875f = i3;
            a2.f15872c = mo26915a(setting);
            if (setting.getAdType() == 3) {
                a2.f15873d = C4822b.m19709a();
                a2.f15874e = C4822b.m19713b();
            }
            a.mo26296a(a2);
            setting2.setThPlacementBean(a);
            setting2.setUuid(UUID.randomUUID().toString());
            if (a2.f15870a != 8 || (C5237f.m21598i(C5233e.m21559b()) != 0 && System.currentTimeMillis() - C5237f.m21598i(C5233e.m21559b()) <= ((long) (d.mo26685M() * 86400000)))) {
                if (setting.getAdType() == 1) {
                    a2.f15872c = 300;
                } else {
                    if (setting.getAdType() == 3) {
                        i2 = d.mo26702f();
                    } else if (setting.getAdType() == 2) {
                        i2 = d.mo26703g();
                    } else if (setting.getAdType() == 4) {
                        i2 = d.mo26705i();
                    } else if (setting.getAdType() != 5 && setting.getAdType() == 106) {
                        a2.f15872c = 0;
                        a2.f15870a = 8;
                        a2.f15876g = -2;
                    } else {
                        a2.f15872c = 0;
                    }
                    a2.f15872c = i2;
                }
                if (a2.f15870a == 8) {
                    a2.f15876g = -2;
                }
                if (!(a2.f15870a == 6 || a2.f15870a == 8 || a2.f15870a == 4)) {
                    if (a2.f15870a != 3) {
                        str = "";
                        if (a2.f15870a > 0 || TextUtils.isEmpty(a2.f15871b)) {
                            int i4 = a2.f15870a;
                            String str2 = a2.f15871b;
                            String placementId = setting.getPlacementId();
                            String uuid = setting.getUuid();
                            String valueOf = String.valueOf(setting.getAdType());
                            int i5 = a2.f15872c;
                            int i6 = i5;
                            C5224e.m21525a().mo26909a(1, 0, "", i4, str2, placementId, 0, 0, 0, 0, 0, uuid, valueOf, i6, 0, "", String.valueOf(a2.f15873d), String.valueOf(a2.f15874e), a2.f15876g, "", "", "", str, 0, 0);
                            C5205o.m21462a("need setting source");
                            mo26918a(setting2, "no offer,no ad configs");
                            return;
                        }
                        if (setting.getAdType() != 106) {
                            int i7 = a2.f15870a;
                            String str3 = a2.f15871b;
                            String placementId2 = setting.getPlacementId();
                            int i8 = this.f17032a;
                            int i9 = this.f17033b;
                            int i10 = this.f17034c;
                            int i11 = this.f17035d;
                            String uuid2 = setting.getUuid();
                            String valueOf2 = String.valueOf(setting.getAdType());
                            int i12 = a2.f15872c;
                            int i13 = i8;
                            int i14 = i9;
                            int i15 = i10;
                            int i16 = i11;
                            int i17 = i12;
                            C5224e.m21525a().mo26909a(1, 1, "", i7, str3, placementId2, i13, i14, i15, i16, 0, uuid2, valueOf2, i17, 0, "", String.valueOf(a2.f15873d), String.valueOf(a2.f15874e), a2.f15876g, "", "", "", str, 0, 0);
                        }
                        C5187e.m21369a();
                        C4819a.m19687a().mo25758a(setting, a2.f15870a, a2.f15871b, a2.f15872c, aVar);
                        return;
                    }
                }
                str = ERROR.CMD_FORMAT_ERROR;
                if (a2.f15870a > 0) {
                }
                int i42 = a2.f15870a;
                String str22 = a2.f15871b;
                String placementId3 = setting.getPlacementId();
                String uuid3 = setting.getUuid();
                String valueOf3 = String.valueOf(setting.getAdType());
                int i52 = a2.f15872c;
                int i62 = i52;
                C5224e.m21525a().mo26909a(1, 0, "", i42, str22, placementId3, 0, 0, 0, 0, 0, uuid3, valueOf3, i62, 0, "", String.valueOf(a2.f15873d), String.valueOf(a2.f15874e), a2.f15876g, "", "", "", str, 0, 0);
                C5205o.m21462a("need setting source");
                mo26918a(setting2, "no offer,no ad configs");
                return;
            }
            if (aVar2 != null) {
                aVar2.mo25759a(i3, aVar2);
            }
            C5205o.m21462a("wm no up s data");
        } catch (Throwable th) {
            C5205o.m21464a(th);
            StringBuilder sb = new StringBuilder();
            sb.append("error,");
            sb.append(th.getMessage());
            mo26918a(setting2, sb.toString());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m21546c() {
        C5123d d = C5125f.m21216a().mo26727d();
        if (d != null) {
            this.f17032a = 343;
            this.f17033b = d.mo26711o();
            this.f17034c = d.mo26712p();
            this.f17035d = d.mo26713q();
        }
    }

    /* renamed from: a */
    public int mo26915a(Setting setting) {
        C5123d d = C5125f.m21216a().mo26727d();
        if (setting.getAdType() == 1) {
            return (setting.getObject3() == null || !(setting.getObject3() instanceof AdInfo) || TextUtils.isEmpty(((AdInfo) setting.getObject3()).getImageUrl())) ? 300 : 0;
        }
        if (setting.getAdType() == 3) {
            return d.mo26702f();
        }
        if (setting.getAdType() == 2) {
            return d.mo26703g();
        }
        if (setting.getAdType() == 4) {
            return d.mo26705i();
        }
        if (setting.getAdType() == 5) {
            return d.mo26706j();
        }
        return 0;
    }

    /* renamed from: a */
    public C4911e mo26916a(C4967g gVar) {
        C4911e eVar = new C4911e();
        if (gVar != null) {
            eVar.f15870a = gVar.mo26305e();
            eVar.f15871b = gVar.mo26298b();
            if (eVar.f15871b == null) {
                eVar.f15871b = "";
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("check，adsource = ");
        sb.append(eVar.f15870a);
        sb.append(", th placement id = ");
        sb.append(eVar.f15871b);
        C5205o.m21462a(sb.toString());
        return eVar;
    }

    /* renamed from: a */
    public void mo26917a(Setting setting, int i, String str, int i2) {
        C5205o.m21461a();
        if (i == 3 || i == 4 || i == 6 || i == 8) {
            C4831i.m19801a(setting, i, str, i2);
        } else if (i == 5) {
            C4857j.m19935a().mo25872a(setting, i, str, i2);
        } else if (i == 7) {
            C4836a.m19858a().mo25841a(setting, i, str, i2);
        } else {
            mo26918a(setting, "unkown ads source.");
        }
    }

    /* renamed from: a */
    public void mo26918a(Setting setting, String str) {
        if (setting.getAdType() == 1) {
            setting.getAdListener().onError(str);
        }
        if (setting.getAdType() == 3) {
            setting.getIRewardAdListener().onError(str);
        }
        if (setting.getAdType() == 2 || setting.getAdType() == 4) {
            setting.getInterstitialListener().onError(str);
        }
        if (setting.getAdType() == 5) {
            setting.getSplashAdListener().onError(str);
        }
        if (setting.getAdType() == 106) {
            setting.getAppwallListener().onError(str);
        }
    }

    /* renamed from: b */
    public int mo26919b() {
        return (C5125f.m21216a().mo26727d().mo26716t() == 1 || C5233e.m21558a().mo26929d()) ? 1 : 0;
    }

    /* renamed from: b */
    public void mo26920b(final Setting setting) {
        C5208r.m21482b(new Runnable() {
            public void run() {
                C5229d.this.m21546c();
                Setting setting = setting;
                if (setting == null) {
                    C5205o.m21465b("setting is null");
                } else if (!C5238g.m21606a(setting.getPlacementId())) {
                    C5205o.m21465b("placementId is illegal");
                } else {
                    C5119a aVar = (C5119a) new C5120b(setting.getAdType(), setting.getPlacementId(), String.valueOf(C5237f.m21590e(C5233e.m21559b()))).mo26659b();
                    if (C5229d.this.mo26919b() == 1) {
                        C5229d.this.m21545a(setting, aVar.mo26664a(), 1, (C4820a) null);
                        return;
                    }
                    if (aVar != null) {
                        try {
                            if (aVar.mo26665b() != null) {
                                String str = "request too frequent.";
                                if (aVar.mo26665b().mo26668a() == 0) {
                                    C5205o.m21462a("wm req ctrl not fill(switch)");
                                    C5229d.this.mo26918a(setting, str);
                                    return;
                                } else if (!C5130b.m21234a(C5233e.m21559b()).mo26732a(aVar.mo26665b().mo26669b(), setting.getAdType(), setting.getPlacementId())) {
                                    C5205o.m21462a("wm req ctrl not fill(fre)");
                                    C5229d.this.mo26918a(setting, str);
                                    return;
                                } else {
                                    final C4875b a = aVar.mo26664a();
                                    C5229d.this.m21545a(setting, a, 1, (C4820a) new C4820a() {
                                        /* renamed from: a */
                                        public void mo25759a(int i, C4820a aVar) {
                                            int i2 = i + 1;
                                            if (C4894c.m20178a().mo25973a(C5233e.m21559b(), a, setting.getPlacementId(), i2)) {
                                                C5205o.m21462a("请求下一个广告源");
                                                C5229d.this.m21545a(setting, a, i2, aVar);
                                                return;
                                            }
                                            C5205o.m21462a("没有别的广告源了");
                                            C5229d.this.mo26918a(setting, "no offers");
                                        }
                                    });
                                    return;
                                }
                            }
                        } catch (Throwable th) {
                            C5205o.m21464a(th);
                            C5229d dVar = C5229d.this;
                            Setting setting2 = setting;
                            StringBuilder sb = new StringBuilder();
                            sb.append("error,");
                            sb.append(th.getMessage());
                            dVar.mo26918a(setting2, sb.toString());
                        }
                    }
                    C5205o.m21462a("没有获取到频次控制数据");
                    C5229d.this.mo26918a(setting, "no offers,server busy.");
                }
            }
        });
    }

    /* renamed from: b */
    public void mo26921b(Setting setting, int i, String str, int i2) {
        C5205o.m21461a();
        if (i == 3 || i == 4 || i == 6 || i == 8) {
            C4831i.m19806b(setting, i, str, i2);
        } else if (i == 5) {
            C4857j.m19935a().mo25876b(setting, i, str, i2);
        } else {
            mo26918a(setting, "unkown ads source.");
        }
    }

    /* renamed from: c */
    public void mo26922c(Setting setting) {
        if (setting == null) {
            C5205o.m21465b("setting can not be null.");
            return;
        }
        try {
            if (setting.getAdType() == 3) {
                C4911e a = mo26916a(setting.getThPlacementBean());
                a.f15872c = mo26915a(setting);
                mo26917a(setting, a.f15870a, a.f15871b, a.f15872c);
                return;
            }
            if (setting.getAdType() != 2) {
                if (setting.getAdType() != 4) {
                    C5205o.m21467d(String.format("adType[%d] unsupport show", new Object[]{Integer.valueOf(setting.getAdType())}));
                    return;
                }
            }
            C4911e a2 = mo26916a(setting.getThPlacementBean());
            a2.f15872c = mo26915a(setting);
            mo26921b(setting, a2.f15870a, a2.f15871b, a2.f15872c);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: d */
    public void mo26923d(Setting setting) {
        String str;
        int i;
        int i2;
        int i3;
        try {
            if (setting.getAdType() == 1) {
                C4911e a = mo26916a(setting.getThPlacementBean());
                a.f15872c = mo26915a(setting);
                AdInfo adInfo = (AdInfo) setting.getObject3();
                int i4 = a.f15870a;
                String str2 = "";
                int i5 = 2;
                if (setting.getAdObject() instanceof C4828f) {
                    C4828f fVar = (C4828f) setting.getAdObject();
                    int x = fVar.mo25831x();
                    String y = fVar.mo25832y();
                    int q = fVar.mo25824q();
                    if (!TextUtils.isEmpty(fVar.mo25815h())) {
                        i5 = 1;
                    }
                    i3 = x;
                    str = y;
                    i = q;
                    i2 = i5;
                } else {
                    i3 = i4;
                    str = str2;
                    i2 = 2;
                    i = -1;
                }
                String str3 = a.f15871b;
                String placementId = setting.getPlacementId();
                int i6 = this.f17032a;
                int i7 = this.f17033b;
                int i8 = this.f17034c;
                int i9 = this.f17035d;
                int i10 = i6;
                int i11 = i7;
                int i12 = i8;
                int i13 = i9;
                C5224e.m21525a().mo26909a(3, 1, "", i3, str3, placementId, i10, i11, i12, i13, 0, setting.getUuid(), String.valueOf(setting.getAdType()), a.f15872c, i2, "", "", "", i, adInfo.getPkgName(), adInfo.getTitle(), adInfo.getImageUrl(), str, 0, 0);
                m21544a(setting, a.f15870a, a.f15872c);
                return;
            }
            C5205o.m21465b("regView只支持原生广告");
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }
}
