package com.p368pw.inner.p369a.p370a.p371a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;
import com.p368pw.inner.C5229d;
import com.p368pw.inner.C5233e;
import com.p368pw.inner.C5237f;
import com.p368pw.inner.appwall.C5005h;
import com.p368pw.inner.base.p384a.C5123d;
import com.p368pw.inner.base.p384a.C5125f;
import com.p368pw.inner.base.p385b.C5131a.C5134a;
import com.p368pw.inner.base.p385b.C5131a.C5135b;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.C5207q;
import com.p368pw.inner.base.p387d.p391d.C5183b;
import com.p368pw.inner.base.stat.C5222c;
import com.p368pw.inner.base.stat.C5224e;
import com.p368pw.inner.p369a.C4819a.C4820a;
import com.p368pw.inner.p369a.C4911e;
import com.p368pw.inner.p369a.C4967g;
import com.p368pw.inner.p369a.p376b.C4879b;
import com.p368pw.inner.p369a.p376b.C4880c;
import com.p368pw.inner.p369a.p379e.C4931c;
import com.p368pw.inner.p369a.p379e.C4933e;
import com.p368pw.inner.p369a.p379e.C4958h;
import com.p368pw.inner.p369a.p379e.C4960j;
import com.p368pw.p392us.AdInfo;
import com.p368pw.p392us.Setting;
import com.tmsdk.module.coin.ErrorCode;

/* renamed from: com.pw.inner.a.a.a.i */
public class C4831i {
    /* access modifiers changed from: private|static */
    /* renamed from: a */
    public static int f15558a = 343;
    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static int f15559b;
    /* access modifiers changed from: private|static */
    /* renamed from: c */
    public static int f15560c;
    /* access modifiers changed from: private|static */
    /* renamed from: d */
    public static int f15561d;

    /* renamed from: a */
    private static C4879b m19796a(Context context, C4826d dVar, Setting setting) {
        C4879b bVar = new C4879b();
        try {
            int i = 1;
            if (C5229d.m21541a().mo26919b() == 1) {
                bVar.mo25921h("查看").mo25912d("全民K歌，你其实很会唱歌").mo25909c("精彩").mo25917f("http://pp.myapp.com/ma_icon/0/icon_10966186_1574236721/256").mo25923i("http://imtt.dd.qq.com/16891/apk/5669A73A7D616112929ADEC97C21E2CA.apk").mo25925j(setting.getAdType() == 4 ? "https://xj.gdt.qq.com/xjviewer/nemo/1428226" : "").mo25927k("https://cdn.zhizh.com/2/20191205/af5d180ef01b4f03948f705e7aa6e39d.png").mo25919g("com.tencent.karaoke");
            } else {
                bVar.mo25937p(dVar.mo25769a()).mo25936o(dVar.mo25778j()).mo25923i(dVar.mo25776h()).mo25925j(dVar.mo25777i()).mo25927k(dVar.mo25770b()).mo25909c(dVar.mo25771c()).mo25917f(dVar.mo25773e()).mo25912d(dVar.mo25774f()).mo25919g(dVar.mo25772d()).mo25915e(dVar.mo25775g()).mo25908c(dVar.mo25785q()).mo25903a(dVar.mo25786r());
                if (TextUtils.isEmpty(dVar.mo25778j())) {
                    if (TextUtils.isEmpty(dVar.mo25777i())) {
                        i = !TextUtils.isEmpty(dVar.mo25776h()) ? 2 : 0;
                    }
                }
                bVar.mo25914e(i);
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
        return bVar;
    }

    /* renamed from: a */
    private static C4958h m19797a(C4828f fVar) {
        C4958h hVar = new C4958h();
        try {
            hVar.mo26224e(fVar.mo25812e()).mo26212a("").mo26228g(fVar.mo25811d()).mo26230h(fVar.mo25810c()).mo26226f(fVar.mo25808a()).mo26219c(fVar.mo25813f()).mo26222d(fVar.mo25814g()).mo26234j(fVar.mo25817j()).mo26232i(fVar.mo25815h()).mo26238l(fVar.mo25832y());
            C4960j.m20737a(hVar, C5183b.m21360a(), false);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
        return hVar;
    }

    /* renamed from: a */
    private static void m19799a(C4830h hVar, Setting setting, int i, String str, boolean z, int i2, C4820a aVar) {
        Setting setting2 = setting;
        C4820a aVar2 = aVar;
        try {
            C4967g thPlacementBean = setting.getThPlacementBean();
            C4911e h = thPlacementBean.mo26309h();
            C5123d d = C5125f.m21216a().mo26727d();
            if (hVar.mo25836a() == 200) {
                if (z) {
                    C5237f.m21573a(C5233e.m21559b(), System.currentTimeMillis(), String.valueOf(setting.getAdType()));
                    C5237f.m21577a(C5233e.m21559b(), hVar.mo25838c(), String.valueOf(setting.getAdType()));
                }
                C5205o.m21462a("zz reward onAdLoaded");
                C4933e eVar = new C4933e(C5233e.m21559b());
                C4958h a = C4822b.m19711a(hVar, setting);
                a.mo26218c(h.f15873d).mo26221d(h.f15874e);
                C4960j.m20737a(a, C5183b.m21360a(), false);
                eVar.mo26147a(a, d.mo26689Q(), thPlacementBean.mo26307f(), thPlacementBean.mo26308g(), d.mo26696X());
                setting2.setAdObject(eVar);
                eVar.mo26145a(C5233e.m21559b(), (C4931c) null);
                C5224e.m21525a().mo26909a(2, 1, "", a.mo26249u(), str, setting.getPlacementId(), f15558a, f15559b, f15560c, f15561d, 0, setting.getUuid(), String.valueOf(setting.getAdType()), i2, 0, "", String.valueOf(h.f15873d), String.valueOf(h.f15874e), -1, a.mo26229g(), a.mo26235j(), "", C4822b.m19712a(hVar), 0, 0);
                if (setting.getIRewardAdListener() != null) {
                    setting.getIRewardAdListener().onLoaded(setting2);
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("zz reward error = ");
                sb.append(hVar.mo25836a());
                C5205o.m21462a(sb.toString());
                C5224e.m21525a().mo26909a(2, 0, "", i, str, setting.getPlacementId(), f15558a, f15559b, f15560c, f15561d, 0, setting.getUuid(), String.valueOf(setting.getAdType()), i2, 0, "", String.valueOf(h.f15873d), String.valueOf(h.f15874e), -1, "", "", "", "", 0, 0);
                if (aVar2 != null) {
                    aVar2.mo25759a(h.f15875f, aVar2);
                }
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: a */
    public static void m19800a(Setting setting, int i) {
        try {
            if (setting.getRegViewContainer() != null) {
                if (setting.getRegViewGroup() != null) {
                    C5205o.m21462a("z native registerAd");
                    C4911e a = C5229d.m21541a().mo26916a(setting.getThPlacementBean());
                    a.f15872c = C5229d.m21541a().mo26915a(setting);
                    C4828f fVar = (C4828f) setting.getAdObject();
                    a.f15870a = fVar.mo25831x();
                    int i2 = TextUtils.isEmpty(fVar.mo25815h()) ? 2 : 1;
                    int q = fVar.mo25824q() > 0 ? fVar.mo25824q() : -1;
                    setting.getRegViewContainer();
                    if (setting.getRegViewGroup() != null) {
                        ViewGroup regViewGroup = setting.getRegViewGroup();
                        final C4911e eVar = a;
                        final Setting setting2 = setting;
                        final int i3 = i;
                        final int i4 = i2;
                        final int i5 = q;
                        final C4828f fVar2 = fVar;
                        C48332 r2 = new OnClickListener() {
                            public void onClick(View view) {
                                C5205o.m21462a("z native clicks");
                                C5224e.m21525a().mo26909a(5, 1, "", eVar.f15870a, eVar.f15871b, setting2.getPlacementId(), C4831i.f15558a, C4831i.f15559b, C4831i.f15560c, C4831i.f15561d, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i3, i4, "", "", "", i5, fVar2.mo25814g(), fVar2.mo25810c(), fVar2.mo25809b(), fVar2.mo25832y(), 0, 0);
                                C4960j.m20736a(C5233e.m21559b(), ((C4828f) setting2.getAdObject()).mo25819l(), C5183b.m21360a(), false);
                                if (setting2.getAdListener() != null) {
                                    setting2.getAdListener().onClicked();
                                }
                                C4831i.m19804b(C5233e.m21559b(), setting2, eVar, i3, C5183b.m21360a(), i4);
                            }
                        };
                        regViewGroup.setOnClickListener(r2);
                    }
                    C5205o.m21462a("z native show");
                    C5224e.m21525a().mo26909a(4, 1, "", a.f15870a, a.f15871b, setting.getPlacementId(), f15558a, f15559b, f15560c, f15561d, 0, setting.getUuid(), String.valueOf(setting.getAdType()), i, i2, "", "", "", q, fVar.mo25814g(), fVar.mo25810c(), fVar.mo25809b(), fVar.mo25832y(), 0, 0);
                    C4960j.m20735a(C5233e.m21559b(), fVar.mo25818k());
                    if (setting.getAdListener() != null) {
                        setting.getAdListener().onShowed();
                    }
                    return;
                }
            }
            C5205o.m21462a("z native not set viewgroup or clickviewlist");
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: a */
    public static void m19801a(Setting setting, int i, String str, int i2) {
        C5205o.m21462a("zz reward show");
        C4933e eVar = (C4933e) setting.getAdObject();
        final C4958h c = eVar.mo26149c();
        final int i3 = TextUtils.isEmpty(eVar.mo26149c().mo26239l()) ? 2 : 1;
        final C4911e h = setting.getThPlacementBean().mo26309h();
        final String str2 = str;
        final Setting setting2 = setting;
        final int i4 = i2;
        final C4933e eVar2 = eVar;
        final int i5 = i;
        C48321 r1 = new C4827e() {
            /* renamed from: a */
            public void mo25787a() {
                C5205o.m21462a("zz reward showed");
                C5224e.m21525a().mo26909a(4, 1, "", c.mo26249u(), str2, setting2.getPlacementId(), C4831i.f15558a, C4831i.f15559b, C4831i.f15560c, C4831i.f15561d, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i4, i3, "", String.valueOf(h.f15873d), String.valueOf(h.f15874e), -1, c.mo26229g(), c.mo26235j(), "", c.mo26248t(), 0, 0);
                C4960j.m20735a(C5233e.m21559b(), eVar2.mo26149c().mo26242n());
                if (setting2.getIRewardAdListener() != null) {
                    setting2.getIRewardAdListener().onShowed();
                }
            }

            /* renamed from: a */
            public void mo25788a(int i) {
                int i2 = i;
                if (i2 == 1) {
                    C5224e.m21525a().mo26909a(5004, 1, "", c.mo26249u(), str2, setting2.getPlacementId(), C4831i.f15558a, C4831i.f15559b, C4831i.f15560c, C4831i.f15561d, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i4, i3, "", String.valueOf(h.f15873d), String.valueOf(h.f15874e), -1, c.mo26229g(), c.mo26235j(), "", c.mo26248t(), 0, 0);
                }
                if (i2 == 2) {
                    C5224e.m21525a().mo26909a(5006, 1, "", c.mo26249u(), str2, setting2.getPlacementId(), C4831i.f15558a, C4831i.f15559b, C4831i.f15560c, C4831i.f15561d, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i4, i3, "", String.valueOf(h.f15873d), String.valueOf(h.f15874e), -1, c.mo26229g(), c.mo26235j(), "", c.mo26248t(), 0, 0);
                }
            }

            /* renamed from: a */
            public void mo25789a(int i, C5183b bVar) {
                if (i == 2) {
                    C5224e.m21525a().mo26909a((int) ErrorCode.ERC_TASK_INVALID, 1, "", c.mo26249u(), str2, setting2.getPlacementId(), C4831i.f15558a, C4831i.f15559b, C4831i.f15560c, C4831i.f15561d, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i4, i3, "", String.valueOf(h.f15873d), String.valueOf(h.f15874e), -1, c.mo26229g(), c.mo26235j(), "", c.mo26248t(), 0, 0);
                }
                C4960j.m20736a(C5233e.m21559b(), eVar2.mo26149c().mo26243o(), bVar, true);
            }

            /* renamed from: a */
            public void mo25790a(String str) {
                C5205o.m21462a("zz reward download start");
                if (setting2.getIRewardAdListener() != null) {
                    setting2.getIRewardAdListener().onDownloadStarted(str);
                }
            }

            /* renamed from: a */
            public void mo25791a(String str, String str2) {
                C5205o.m21462a("zz reward download finish");
                C5224e.m21525a().mo26909a(6, 1, "", c.mo26249u(), str2, setting2.getPlacementId(), C4831i.f15558a, C4831i.f15559b, C4831i.f15560c, C4831i.f15561d, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i4, i3, "", String.valueOf(h.f15873d), String.valueOf(h.f15874e), -1, c.mo26229g(), c.mo26235j(), "", c.mo26248t(), 0, 0);
                if (setting2.getIRewardAdListener() != null) {
                    setting2.getIRewardAdListener().onDownloadFinished(str, str2);
                } else {
                    String str3 = str;
                    String str4 = str2;
                }
                if (C5229d.m21541a().mo26919b() == 1) {
                    String str5 = str;
                    String str6 = str2;
                    C5005h.m20951a().mo26405a(null, null, eVar2.mo26149c().mo26235j(), eVar2.mo26149c().mo26233i(), eVar2.mo26149c().mo26231h(), str5, str6, 1, 0, h.f15870a, h.f15871b, setting2.getPlacementId(), String.valueOf(setting2.getAdType()), i4, "", eVar2.mo26149c().mo26248t(), 3, null);
                }
            }

            /* renamed from: b */
            public void mo25792b() {
                C5205o.m21462a("zz reward close");
                if (setting2.getIRewardAdListener() != null) {
                    setting2.getIRewardAdListener().onClosed();
                }
            }

            /* renamed from: b */
            public void mo25793b(int i) {
                int i2 = i;
                if (i2 == 0 || i2 == 25 || i2 == 50 || i2 == 75 || i2 == 100) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("t percent = ");
                    sb.append(i2);
                    C5205o.m21462a(sb.toString());
                    int i3 = 0;
                    if (i2 == 0) {
                        i3 = 1100;
                    }
                    if (i2 == 25) {
                        i3 = 1101;
                    }
                    if (i2 == 50) {
                        i3 = 1102;
                    }
                    if (i2 == 75) {
                        i3 = 1103;
                    }
                    C5224e.m21525a().mo26909a(i2 == 100 ? 1104 : i3, 1, "", c.mo26249u(), str2, setting2.getPlacementId(), C4831i.f15558a, C4831i.f15559b, C4831i.f15560c, C4831i.f15561d, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i4, i3, "", String.valueOf(h.f15873d), String.valueOf(h.f15874e), -1, c.mo26229g(), c.mo26235j(), "", c.mo26248t(), 0, 0);
                }
            }

            /* renamed from: b */
            public void mo25794b(String str) {
                String str2 = str;
                StringBuilder sb = new StringBuilder();
                sb.append("zz pg pol: ");
                sb.append(str2);
                C5205o.m21462a(sb.toString());
                if (str2.startsWith("video://retain.close")) {
                    C5224e.m21525a().mo26909a(5006, 1, "", c.mo26249u(), str2, setting2.getPlacementId(), C4831i.f15558a, C4831i.f15559b, C4831i.f15560c, C4831i.f15561d, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i4, i3, "", String.valueOf(h.f15873d), String.valueOf(h.f15874e), -1, c.mo26229g(), c.mo26235j(), "", c.mo26248t(), 0, 0);
                }
                if (str2.startsWith("video://download") && !eVar2.f15966c) {
                    C5224e.m21525a().mo26909a(5003, 1, "", c.mo26249u(), str2, setting2.getPlacementId(), C4831i.f15558a, C4831i.f15559b, C4831i.f15560c, C4831i.f15561d, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i4, i3, "", String.valueOf(h.f15873d), String.valueOf(h.f15874e), -1, c.mo26229g(), c.mo26235j(), "", c.mo26248t(), 0, 0);
                    eVar2.f15966c = true;
                }
                if (str2.startsWith("video://retain.download") && !eVar2.f15967d) {
                    C5224e.m21525a().mo26909a(5005, 1, "", c.mo26249u(), str2, setting2.getPlacementId(), C4831i.f15558a, C4831i.f15559b, C4831i.f15560c, C4831i.f15561d, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i4, i3, "", String.valueOf(h.f15873d), String.valueOf(h.f15874e), -1, c.mo26229g(), c.mo26235j(), "", c.mo26248t(), 0, 0);
                    eVar2.f15967d = true;
                }
            }

            /* renamed from: b */
            public void mo25795b(String str, String str2) {
                C5205o.m21462a("zz reward installed");
                C5224e.m21525a().mo26909a(7, 1, "", c.mo26249u(), str2, setting2.getPlacementId(), C4831i.f15558a, C4831i.f15559b, C4831i.f15560c, C4831i.f15561d, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i4, i3, "", String.valueOf(h.f15873d), String.valueOf(h.f15874e), -1, c.mo26229g(), c.mo26235j(), "", c.mo26248t(), 0, 0);
                if (setting2.getIRewardAdListener() != null) {
                    setting2.getIRewardAdListener().onInstalled(str, str2);
                } else {
                    String str3 = str;
                    String str4 = str2;
                }
                C4960j.m20732a(C5233e.m21559b(), eVar2.mo26149c(), 12);
                if (C5229d.m21541a().mo26919b() == 1) {
                    String str5 = str;
                    String str6 = str2;
                    C5005h.m20951a().mo26405a(null, null, eVar2.mo26149c().mo26235j(), eVar2.mo26149c().mo26233i(), eVar2.mo26149c().mo26231h(), str5, str6, 2, 0, h.f15870a, h.f15871b, setting2.getPlacementId(), String.valueOf(setting2.getAdType()), i4, "", eVar2.mo26149c().mo26248t(), 3, null);
                }
            }

            /* renamed from: c */
            public void mo25796c() {
                C5205o.m21462a("zz reward vd complete");
                if (setting2.getIRewardAdListener() != null) {
                    setting2.getIRewardAdListener().onVideoComplete();
                }
            }

            /* renamed from: c */
            public void mo25797c(int i) {
                int i2 = i;
                long j = (long) i2;
                if (j >= 1000 && j < 2000 && !eVar2.f15968e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("zz pl ");
                    sb.append(i2);
                    C5205o.m21462a(sb.toString());
                    eVar2.f15968e = true;
                    C5224e.m21525a().mo26909a((int) ErrorCode.ERC_TASK_PARAM_INVALID, 1, "", c.mo26249u(), str2, setting2.getPlacementId(), C4831i.f15558a, C4831i.f15559b, C4831i.f15560c, C4831i.f15561d, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i4, i3, "", String.valueOf(h.f15873d), String.valueOf(h.f15874e), -1, c.mo26229g(), c.mo26235j(), "", c.mo26248t(), 0, 0);
                }
            }

            /* renamed from: d */
            public void mo25798d() {
                C4960j.m20732a(C5233e.m21559b(), eVar2.mo26149c(), 11);
                C5224e.m21525a().mo26909a(9, 1, "", c.mo26249u(), str2, setting2.getPlacementId(), C4831i.f15558a, C4831i.f15559b, C4831i.f15560c, C4831i.f15561d, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i4, i3, "", String.valueOf(h.f15873d), String.valueOf(h.f15874e), -1, c.mo26229g(), c.mo26235j(), "", c.mo26248t(), 0, 0);
            }

            /* renamed from: d */
            public void mo25799d(int i) {
                if (i == 1) {
                    C5205o.m21462a("zz dp close");
                    C5224e.m21525a().mo26909a(5008, 1, "", c.mo26249u(), str2, setting2.getPlacementId(), C4831i.f15558a, C4831i.f15559b, C4831i.f15560c, C4831i.f15561d, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i4, i3, "", String.valueOf(h.f15873d), String.valueOf(h.f15874e), -1, c.mo26229g(), c.mo26235j(), "", c.mo26248t(), 0, 0);
                }
            }

            /* renamed from: e */
            public void mo25800e() {
            }

            /* renamed from: f */
            public void mo25801f() {
                String str = "";
                String str2 = "";
                String str3 = "";
                C5224e.m21525a().mo26909a((int) ErrorCode.ERC_TASK_PRODUCT_INVALID, 1, str, c.mo26249u(), str2, setting2.getPlacementId(), C4831i.f15558a, C4831i.f15559b, C4831i.f15560c, C4831i.f15561d, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i4, i3, str2, String.valueOf(h.f15873d), String.valueOf(h.f15874e), -1, c.mo26229g(), c.mo26235j(), str3, c.mo26248t(), Math.round(((float) eVar2.mo26150d()) / 1000.0f), Math.round(((float) eVar2.mo26151e()) / 1000.0f));
                if (C5125f.m21216a().mo26727d().mo26697a() && C5207q.m21478b((CharSequence) setting2.getUserId())) {
                    new C5222c().mo26896d(c.mo26229g()).mo26894a(i5).mo26895c(setting2.getPlacementId()).mo26897e(setting2.getUserId()).mo26898f(setting2.getUuid()).mo26660c();
                }
            }

            /* renamed from: g */
            public void mo25802g() {
                C5224e.m21525a().mo26909a((int) ErrorCode.ERC_TASK_ACCOUNT_INVALID, 1, "", c.mo26249u(), str2, setting2.getPlacementId(), C4831i.f15558a, C4831i.f15559b, C4831i.f15560c, C4831i.f15561d, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i4, i3, "", String.valueOf(h.f15873d), String.valueOf(h.f15874e), -1, c.mo26229g(), c.mo26235j(), "", c.mo26248t(), 0, 0);
            }

            /* renamed from: h */
            public void mo25803h() {
                C5224e.m21525a().mo26909a(5002, 1, "", c.mo26249u(), str2, setting2.getPlacementId(), C4831i.f15558a, C4831i.f15559b, C4831i.f15560c, C4831i.f15561d, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i4, i3, "", String.valueOf(h.f15873d), String.valueOf(h.f15874e), -1, c.mo26229g(), c.mo26235j(), "", c.mo26248t(), 0, 0);
            }

            /* renamed from: i */
            public void mo25804i() {
            }

            /* renamed from: j */
            public void mo25805j() {
                C5205o.m21462a("zz reward active");
                C5224e.m21525a().mo26909a(8, 1, "", c.mo26249u(), str2, setting2.getPlacementId(), C4831i.f15558a, C4831i.f15559b, C4831i.f15560c, C4831i.f15561d, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i4, i3, "", String.valueOf(h.f15873d), String.valueOf(h.f15874e), -1, c.mo26229g(), c.mo26235j(), "", c.mo26248t(), 0, 0);
                if (C5229d.m21541a().mo26919b() == 1) {
                    C5005h.m20951a().mo26406a(eVar2.mo26149c().mo26229g(), 2, 1, (C5134a) null);
                }
            }

            /* renamed from: k */
            public void mo25806k() {
                if (!eVar2.f15965b) {
                    C5205o.m21462a("zz bn click");
                    C5224e.m21525a().mo26909a(5001, 1, "", c.mo26249u(), str2, setting2.getPlacementId(), C4831i.f15558a, C4831i.f15559b, C4831i.f15560c, C4831i.f15561d, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i4, i3, "", String.valueOf(h.f15873d), String.valueOf(h.f15874e), -1, c.mo26229g(), c.mo26235j(), "", c.mo26248t(), 0, 0);
                    eVar2.f15965b = true;
                }
            }

            /* renamed from: l */
            public void mo25807l() {
            }
        };
        eVar.mo26146a((C4827e) r1, setting.getOrientation());
    }

    /* renamed from: a */
    public static void m19802a(Setting setting, int i, String str, int i2, C4820a aVar) {
        try {
            m19814e();
            C5205o.m21462a("zz reward load");
            C5123d d = C5125f.m21216a().mo26727d();
            if (System.currentTimeMillis() - C5237f.m21592f(C5233e.m21559b(), String.valueOf(setting.getAdType())) < ((long) (d.mo26701e() * 60000))) {
                C5205o.m21462a("zz reward load local data");
                m19799a(new C4830h(C5237f.m21591e(C5233e.m21559b(), String.valueOf(setting.getAdType()))), setting, i, str, false, i2, aVar);
                return;
            }
            int b = C5229d.m21541a().mo26919b();
            C4821a aVar2 = new C4821a(1, 0, 0, 1, i, setting.getPlacementId());
            aVar2.mo25764a(d.mo26700d());
            aVar2.mo25766b(b);
            if (i == 8) {
                aVar2.mo25767c(2);
            }
            C4830h hVar = (C4830h) aVar2.mo26659b();
            C5205o.m21462a("zz reward load net data");
            m19799a(hVar, setting, i, str, true, i2, aVar);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static void m19804b(Context context, Setting setting, C4911e eVar, int i, C5183b bVar, int i2) {
        Toast makeText;
        try {
            final C4828f fVar = (C4828f) setting.getAdObject();
            C4958h a = m19797a(fVar);
            final int q = fVar.mo25824q() > 0 ? fVar.mo25824q() : -1;
            final Context context2 = context;
            final Setting setting2 = setting;
            final C4911e eVar2 = eVar;
            final int i3 = i;
            final int i4 = i2;
            C48343 r1 = new C4827e() {
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
                    C5205o.m21462a("z native start download");
                    C4960j.m20735a(context2, fVar.mo25822o());
                    if (setting2.getAdListener() != null) {
                        setting2.getAdListener().onDownloadStarted();
                    }
                }

                /* renamed from: a */
                public void mo25791a(String str, String str2) {
                    C5205o.m21462a("z native download finish");
                    C4960j.m20735a(context2, fVar.mo25823p());
                    C5224e.m21525a().mo26909a(6, 1, "", eVar2.f15870a, eVar2.f15871b, setting2.getPlacementId(), C4831i.f15558a, C4831i.f15559b, C4831i.f15560c, C4831i.f15561d, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i3, i4, "", "", "", q, fVar.mo25814g(), fVar.mo25810c(), fVar.mo25809b(), fVar.mo25832y(), 0, 0);
                    if (setting2.getAdListener() != null) {
                        setting2.getAdListener().onDownloadFinished(str2);
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
                    C5205o.m21462a("z native install finish");
                    C4960j.m20735a(context2, fVar.mo25821n());
                    C5224e.m21525a().mo26909a(7, 1, "", eVar2.f15870a, eVar2.f15871b, setting2.getPlacementId(), C4831i.f15558a, C4831i.f15559b, C4831i.f15560c, C4831i.f15561d, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i3, i4, "", "", "", q, fVar.mo25814g(), fVar.mo25810c(), fVar.mo25809b(), fVar.mo25832y(), 0, 0);
                    if (setting2.getAdListener() != null) {
                        setting2.getAdListener().onInstalled();
                    }
                    if (!TextUtils.isEmpty(fVar.mo25829v())) {
                        String str3 = str;
                        String str4 = str2;
                        C5005h.m20951a().mo26405a(null, null, fVar.mo25810c(), fVar.mo25811d(), fVar.mo25808a(), str3, str4, 2, 0, eVar2.f15870a, eVar2.f15871b, setting2.getPlacementId(), String.valueOf(setting2.getAdType()), i3, "", fVar.mo25832y(), 1, null);
                        C5005h.m20951a().mo26402a(context2, 1, fVar.mo25829v(), fVar.mo25830w(), "");
                    }
                }

                /* renamed from: c */
                public void mo25796c() {
                }

                /* renamed from: c */
                public void mo25797c(int i) {
                }

                /* renamed from: d */
                public void mo25798d() {
                    C5205o.m21462a("z native install start");
                    C4960j.m20735a(context2, fVar.mo25820m());
                    C5224e.m21525a().mo26909a(9, 1, "", eVar2.f15870a, eVar2.f15871b, setting2.getPlacementId(), C4831i.f15558a, C4831i.f15559b, C4831i.f15560c, C4831i.f15561d, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i3, i4, "", "", "", q, fVar.mo25814g(), fVar.mo25810c(), fVar.mo25809b(), fVar.mo25832y(), 0, 0);
                }

                /* renamed from: d */
                public void mo25799d(int i) {
                    if (i == 1) {
                        C5205o.m21462a("zz n dp close");
                        C5224e.m21525a().mo26909a(5008, 1, "", eVar2.f15870a, eVar2.f15871b, setting2.getPlacementId(), C4831i.f15558a, C4831i.f15559b, C4831i.f15560c, C4831i.f15561d, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i3, i4, "", "", "", q, fVar.mo25814g(), fVar.mo25810c(), fVar.mo25809b(), fVar.mo25832y(), 0, 0);
                    }
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
                    C5205o.m21462a("z native active");
                    C5224e.m21525a().mo26909a(8, 1, "", eVar2.f15870a, eVar2.f15871b, setting2.getPlacementId(), C4831i.f15558a, C4831i.f15559b, C4831i.f15560c, C4831i.f15561d, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), i3, i4, "", "", "", q, fVar.mo25814g(), fVar.mo25810c(), fVar.mo25809b(), fVar.mo25832y(), 0, 0);
                    if (!TextUtils.isEmpty(fVar.mo25829v())) {
                        C5005h.m20951a().mo26407a(fVar.mo25814g(), new C5135b() {
                            /* renamed from: a */
                            public void mo25840a(int i) {
                                if (i == 0) {
                                    C5005h.m20951a().mo26402a(context2, 2, fVar.mo25829v(), fVar.mo25830w(), "");
                                    C5005h.m20951a().mo26406a(fVar.mo25814g(), 2, 1, (C5134a) null);
                                }
                            }
                        });
                    }
                }

                /* renamed from: k */
                public void mo25806k() {
                }

                /* renamed from: l */
                public void mo25807l() {
                }
            };
            int a2 = C4960j.m20728a(context, a, bVar, r1, null);
            if (a2 == 1) {
                makeText = Toast.makeText(context, "开始下载", 0);
            } else if (a2 == 2) {
                makeText = Toast.makeText(context, "正在下载，请稍后", 0);
            } else if (a2 == 3) {
                makeText = Toast.makeText(context, "已经下载，开始安装", 0);
            } else if (a2 == 4) {
                makeText = Toast.makeText(context, "已经安装，打开该应用", 0);
            } else {
                return;
            }
            makeText.show();
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: b */
    private static void m19805b(C4830h hVar, Setting setting, int i, String str, boolean z, int i2, C4820a aVar) {
        Setting setting2 = setting;
        C4820a aVar2 = aVar;
        try {
            C4911e h = setting.getThPlacementBean().mo26309h();
            if (hVar.mo25836a() == 200) {
                if (z) {
                    C5237f.m21573a(C5233e.m21559b(), System.currentTimeMillis(), String.valueOf(setting.getAdType()));
                    C5237f.m21577a(C5233e.m21559b(), hVar.mo25838c(), String.valueOf(setting.getAdType()));
                }
                C4828f d = C4822b.m19716d(hVar);
                AdInfo adInfo = new AdInfo(d.mo25810c(), d.mo25811d(), d.mo25808a(), d.mo25814g(), d.mo25812e(), d.mo25816i(), d.mo25809b());
                int i3 = !TextUtils.isEmpty(d.mo25815h()) ? 1 : 2;
                int q = d.mo25824q() > 0 ? d.mo25824q() : -1;
                int i4 = !TextUtils.isEmpty(adInfo.getImageUrl()) ? 0 : i2;
                C5205o.m21462a("z native onAdLoaded");
                C5224e.m21525a().mo26909a(2, 1, "", d.mo25831x(), str, setting.getPlacementId(), f15558a, f15559b, f15560c, f15561d, 0, setting.getUuid(), String.valueOf(setting.getAdType()), i4, i3, "", "", "", q, adInfo.getPkgName(), adInfo.getTitle(), adInfo.getImageUrl(), C4822b.m19714b(hVar), 0, 0);
                setting2.setAdObject(d);
                setting2.setObject3(adInfo);
                if (setting.getAdListener() != null) {
                    setting.getAdListener().onLoaded(adInfo, setting2);
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("z native error = ");
                sb.append(hVar.mo25836a());
                C5205o.m21462a(sb.toString());
                C5224e.m21525a().mo26909a(2, 0, "", i, str, setting.getPlacementId(), f15558a, f15559b, f15560c, f15561d, 0, setting.getUuid(), String.valueOf(setting.getAdType()), i2, 2, "", "", "", -1, "", "", "", "", 0, 0);
                if (aVar2 != null) {
                    aVar2.mo25759a(h.f15875f, aVar2);
                }
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: b */
    public static void m19806b(Setting setting, int i, String str, int i2) {
        Setting setting2 = setting;
        try {
            C5205o.m21462a("zz ins show");
            if (setting2 != null) {
                C4826d dVar = (C4826d) setting.getAdObject();
                C4879b a = m19796a(C5233e.m21559b(), dVar, setting2);
                C4880c.m20089a().mo25951a(setting, a, i, str, i2);
                C4960j.m20735a(C5233e.m21559b(), dVar.mo25779k());
                C5224e.m21525a().mo26909a(3, 1, "", dVar.mo25785q(), str, setting.getPlacementId(), f15558a, f15559b, f15560c, f15561d, 0, setting.getUuid(), String.valueOf(setting.getAdType()), i2, a.mo25941r(), "", "", "", -1, dVar.mo25772d(), dVar.mo25771c(), a.mo25928k(), dVar.mo25786r(), 0, 0);
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: b */
    public static void m19807b(Setting setting, int i, String str, int i2, C4820a aVar) {
        C4830h hVar;
        boolean z;
        C5123d d = C5125f.m21216a().mo26727d();
        if (System.currentTimeMillis() - C5237f.m21592f(C5233e.m21559b(), String.valueOf(setting.getAdType())) < ((long) (d.mo26701e() * 60000))) {
            C5205o.m21462a("z native load local data");
            hVar = new C4830h(C5237f.m21591e(C5233e.m21559b(), String.valueOf(setting.getAdType())));
            z = false;
        } else {
            int b = C5229d.m21541a().mo26919b();
            C4821a aVar2 = new C4821a(1, 0, 0, 2, i, setting.getPlacementId());
            aVar2.mo25764a(d.mo26700d());
            aVar2.mo25766b(b);
            if (i == 8) {
                aVar2.mo25767c(2);
            }
            hVar = (C4830h) aVar2.mo26659b();
            C5205o.m21462a("z native load net data");
            z = true;
        }
        m19805b(hVar, setting, i, str, z, i2, aVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x00c0 A[Catch:{ all -> 0x0128 }] */
    /* renamed from: c */
    private static void m19809c(com.p368pw.inner.p369a.p370a.p371a.C4830h r30, com.p368pw.p392us.Setting r31, int r32, java.lang.String r33, boolean r34, int r35, com.p368pw.inner.p369a.C4819a.C4820a r36) {
        /*
        r0 = r31
        r1 = r36
        com.pw.inner.a.g r2 = r31.getThPlacementBean()     // Catch:{ all -> 0x0128 }
        com.pw.inner.a.e r2 = r2.mo26309h()     // Catch:{ all -> 0x0128 }
        int r3 = r30.mo25836a()     // Catch:{ all -> 0x0128 }
        r4 = 200(0xc8, float:2.8E-43)
        if (r3 != r4) goto L_0x00c8
        if (r34 == 0) goto L_0x003c
        android.content.Context r1 = com.p368pw.inner.C5233e.m21559b()     // Catch:{ all -> 0x0128 }
        long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0128 }
        int r4 = r31.getAdType()     // Catch:{ all -> 0x0128 }
        java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x0128 }
        com.p368pw.inner.C5237f.m21573a(r1, r2, r4)     // Catch:{ all -> 0x0128 }
        android.content.Context r1 = com.p368pw.inner.C5233e.m21559b()     // Catch:{ all -> 0x0128 }
        java.lang.String r2 = r30.mo25838c()     // Catch:{ all -> 0x0128 }
        int r3 = r31.getAdType()     // Catch:{ all -> 0x0128 }
        java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0128 }
        com.p368pw.inner.C5237f.m21577a(r1, r2, r3)     // Catch:{ all -> 0x0128 }
    L_0x003c:
        com.pw.inner.a.a.a.d r1 = com.p368pw.inner.p369a.p370a.p371a.C4822b.m19718f(r30)     // Catch:{ all -> 0x0128 }
        r2 = 0
        java.lang.String r3 = r1.mo25778j()     // Catch:{ all -> 0x0128 }
        boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0128 }
        if (r3 == 0) goto L_0x0067
        java.lang.String r3 = r1.mo25777i()     // Catch:{ all -> 0x0128 }
        boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0128 }
        if (r3 != 0) goto L_0x0056
        goto L_0x0067
    L_0x0056:
        java.lang.String r3 = r1.mo25776h()     // Catch:{ all -> 0x0128 }
        boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0128 }
        if (r3 != 0) goto L_0x0064
        r2 = 2
        r18 = 2
        goto L_0x006a
    L_0x0064:
        r18 = 0
        goto L_0x006a
    L_0x0067:
        r2 = 1
        r18 = 1
    L_0x006a:
        java.lang.String r2 = "zz ins onAdLoaded"
        com.p368pw.inner.base.p387d.C5205o.m21462a(r2)     // Catch:{ all -> 0x0128 }
        com.pw.inner.base.stat.e r3 = com.p368pw.inner.base.stat.C5224e.m21525a()     // Catch:{ all -> 0x0128 }
        r4 = 2
        r5 = 1
        java.lang.String r6 = ""
        int r7 = r1.mo25785q()     // Catch:{ all -> 0x0128 }
        java.lang.String r9 = r31.getPlacementId()     // Catch:{ all -> 0x0128 }
        int r10 = f15558a     // Catch:{ all -> 0x0128 }
        int r11 = f15559b     // Catch:{ all -> 0x0128 }
        int r12 = f15560c     // Catch:{ all -> 0x0128 }
        int r13 = f15561d     // Catch:{ all -> 0x0128 }
        r14 = 0
        java.lang.String r15 = r31.getUuid()     // Catch:{ all -> 0x0128 }
        int r2 = r31.getAdType()     // Catch:{ all -> 0x0128 }
        java.lang.String r16 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x0128 }
        java.lang.String r19 = ""
        java.lang.String r20 = ""
        java.lang.String r21 = ""
        r22 = -1
        java.lang.String r23 = r1.mo25772d()     // Catch:{ all -> 0x0128 }
        java.lang.String r24 = r1.mo25771c()     // Catch:{ all -> 0x0128 }
        java.lang.String r25 = r1.mo25770b()     // Catch:{ all -> 0x0128 }
        java.lang.String r26 = com.p368pw.inner.p369a.p370a.p371a.C4822b.m19715c(r30)     // Catch:{ all -> 0x0128 }
        r27 = 0
        r28 = 0
        r8 = r33
        r17 = r35
        r3.mo26909a(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)     // Catch:{ all -> 0x0128 }
        r0.setAdObject(r1)     // Catch:{ all -> 0x0128 }
        com.pw.us.IInterstitialAdListener r1 = r31.getInterstitialListener()     // Catch:{ all -> 0x0128 }
        if (r1 == 0) goto L_0x012c
        com.pw.us.IInterstitialAdListener r1 = r31.getInterstitialListener()     // Catch:{ all -> 0x0128 }
        r1.onLoaded(r0)     // Catch:{ all -> 0x0128 }
        goto L_0x012c
    L_0x00c8:
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0128 }
        r3.<init>()     // Catch:{ all -> 0x0128 }
        java.lang.String r4 = "zz ins error = "
        r3.append(r4)     // Catch:{ all -> 0x0128 }
        int r4 = r30.mo25836a()     // Catch:{ all -> 0x0128 }
        r3.append(r4)     // Catch:{ all -> 0x0128 }
        java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0128 }
        com.p368pw.inner.base.p387d.C5205o.m21462a(r3)     // Catch:{ all -> 0x0128 }
        com.pw.inner.base.stat.e r4 = com.p368pw.inner.base.stat.C5224e.m21525a()     // Catch:{ all -> 0x0128 }
        r5 = 2
        r6 = 0
        java.lang.String r7 = ""
        java.lang.String r10 = r31.getPlacementId()     // Catch:{ all -> 0x0128 }
        int r11 = f15558a     // Catch:{ all -> 0x0128 }
        int r12 = f15559b     // Catch:{ all -> 0x0128 }
        int r13 = f15560c     // Catch:{ all -> 0x0128 }
        int r14 = f15561d     // Catch:{ all -> 0x0128 }
        r15 = 0
        java.lang.String r16 = r31.getUuid()     // Catch:{ all -> 0x0128 }
        int r0 = r31.getAdType()     // Catch:{ all -> 0x0128 }
        java.lang.String r17 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0128 }
        r19 = 0
        java.lang.String r20 = ""
        java.lang.String r21 = ""
        java.lang.String r22 = ""
        r23 = -1
        java.lang.String r24 = ""
        java.lang.String r25 = ""
        java.lang.String r26 = ""
        java.lang.String r27 = ""
        r28 = 0
        r29 = 0
        r8 = r32
        r9 = r33
        r18 = r35
        r4.mo26909a(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)     // Catch:{ all -> 0x0128 }
        if (r1 == 0) goto L_0x012c
        int r0 = r2.f15875f     // Catch:{ all -> 0x0128 }
        r1.mo25759a(r0, r1)     // Catch:{ all -> 0x0128 }
        return
    L_0x0128:
        r0 = move-exception
        com.p368pw.inner.base.p387d.C5205o.m21464a(r0)
    L_0x012c:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p368pw.inner.p369a.p370a.p371a.C4831i.m19809c(com.pw.inner.a.a.a.h, com.pw.us.Setting, int, java.lang.String, boolean, int, com.pw.inner.a.a$a):void");
    }

    /* renamed from: c */
    public static void m19810c(Setting setting, int i, String str, int i2, C4820a aVar) {
        m19814e();
        C5205o.m21462a("zz ins load");
        C5123d d = C5125f.m21216a().mo26727d();
        if (System.currentTimeMillis() - C5237f.m21592f(C5233e.m21559b(), String.valueOf(setting.getAdType())) < ((long) (d.mo26701e() * 60000))) {
            C5205o.m21462a("zz ins load local data");
            m19809c(new C4830h(C5237f.m21591e(C5233e.m21559b(), String.valueOf(setting.getAdType()))), setting, i, str, false, i2, aVar);
            return;
        }
        int b = C5229d.m21541a().mo26919b();
        C4821a aVar2 = new C4821a(1, 0, 0, setting.getAdType() == 4 ? 4 : 5, i, setting.getPlacementId());
        aVar2.mo25764a(d.mo26700d());
        aVar2.mo25766b(b);
        if (i == 8) {
            aVar2.mo25767c(2);
        }
        C4830h hVar = (C4830h) aVar2.mo26659b();
        C5205o.m21462a("zz ins load net data");
        m19809c(hVar, setting, i, str, true, i2, aVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0131 A[Catch:{ all -> 0x019a }] */
    /* renamed from: d */
    private static void m19812d(com.p368pw.inner.p369a.p370a.p371a.C4830h r37, com.p368pw.p392us.Setting r38, int r39, java.lang.String r40, boolean r41, int r42, com.p368pw.inner.p369a.C4819a.C4820a r43) {
        /*
        r0 = r38
        r1 = r43
        com.pw.inner.a.g r2 = r38.getThPlacementBean()     // Catch:{ all -> 0x019a }
        com.pw.inner.a.e r3 = r2.mo26309h()     // Catch:{ all -> 0x019a }
        int r4 = r37.mo25836a()     // Catch:{ all -> 0x019a }
        r5 = 200(0xc8, float:2.8E-43)
        if (r4 != r5) goto L_0x0139
        if (r41 == 0) goto L_0x003c
        android.content.Context r1 = com.p368pw.inner.C5233e.m21559b()     // Catch:{ all -> 0x019a }
        long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x019a }
        int r5 = r38.getAdType()     // Catch:{ all -> 0x019a }
        java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x019a }
        com.p368pw.inner.C5237f.m21573a(r1, r3, r5)     // Catch:{ all -> 0x019a }
        android.content.Context r1 = com.p368pw.inner.C5233e.m21559b()     // Catch:{ all -> 0x019a }
        java.lang.String r3 = r37.mo25838c()     // Catch:{ all -> 0x019a }
        int r4 = r38.getAdType()     // Catch:{ all -> 0x019a }
        java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x019a }
        com.p368pw.inner.C5237f.m21577a(r1, r3, r4)     // Catch:{ all -> 0x019a }
    L_0x003c:
        com.pw.inner.a.a.a.d r9 = com.p368pw.inner.p369a.p370a.p371a.C4822b.m19718f(r37)     // Catch:{ all -> 0x019a }
        android.content.Context r1 = com.p368pw.inner.C5233e.m21559b()     // Catch:{ all -> 0x019a }
        com.pw.inner.a.b.b r10 = m19796a(r1, r9, r0)     // Catch:{ all -> 0x019a }
        java.lang.String r1 = r38.getUuid()     // Catch:{ all -> 0x019a }
        com.pw.inner.a.b.b r1 = r10.mo25929l(r1)     // Catch:{ all -> 0x019a }
        java.lang.String r3 = r38.getPlacementId()     // Catch:{ all -> 0x019a }
        com.pw.inner.a.b.b r1 = r1.mo25931m(r3)     // Catch:{ all -> 0x019a }
        int r3 = r10.mo25933n()     // Catch:{ all -> 0x019a }
        com.pw.inner.a.b.b r1 = r1.mo25905b(r3)     // Catch:{ all -> 0x019a }
        int r3 = r9.mo25785q()     // Catch:{ all -> 0x019a }
        com.pw.inner.a.b.b r1 = r1.mo25908c(r3)     // Catch:{ all -> 0x019a }
        r15 = r40
        r1.mo25934n(r15)     // Catch:{ all -> 0x019a }
        java.lang.String r1 = r10.mo25944s()     // Catch:{ all -> 0x019a }
        boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x019a }
        if (r1 == 0) goto L_0x0088
        java.lang.String r1 = r10.mo25926j()     // Catch:{ all -> 0x019a }
        boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x019a }
        if (r1 != 0) goto L_0x0082
        goto L_0x0088
    L_0x0082:
        r1 = 501(0x1f5, float:7.02E-43)
        r10.mo25911d(r1)     // Catch:{ all -> 0x019a }
        goto L_0x008d
    L_0x0088:
        r1 = 500(0x1f4, float:7.0E-43)
        r10.mo25911d(r1)     // Catch:{ all -> 0x019a }
    L_0x008d:
        com.pw.inner.base.a.f r1 = com.p368pw.inner.base.p384a.C5125f.m21216a()     // Catch:{ all -> 0x019a }
        com.pw.inner.base.a.d r1 = r1.mo26727d()     // Catch:{ all -> 0x019a }
        int r1 = r1.mo26706j()     // Catch:{ all -> 0x019a }
        r3 = 502(0x1f6, float:7.03E-43)
        if (r1 != r3) goto L_0x00aa
        java.lang.String r4 = r10.mo25928k()     // Catch:{ all -> 0x019a }
        boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x019a }
        if (r4 != 0) goto L_0x00aa
        r10.mo25911d(r3)     // Catch:{ all -> 0x019a }
    L_0x00aa:
        r3 = 503(0x1f7, float:7.05E-43)
        if (r1 != r3) goto L_0x00bb
        java.lang.String r1 = r10.mo25928k()     // Catch:{ all -> 0x019a }
        boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x019a }
        if (r1 != 0) goto L_0x00bb
        r10.mo25911d(r3)     // Catch:{ all -> 0x019a }
    L_0x00bb:
        com.pw.inner.a.d.a r14 = new com.pw.inner.a.d.a     // Catch:{ all -> 0x019a }
        android.content.Context r3 = com.p368pw.inner.C5233e.m21559b()     // Catch:{ all -> 0x019a }
        int r7 = r2.mo26307f()     // Catch:{ all -> 0x019a }
        r8 = 0
        r1 = r14
        r2 = r3
        r3 = r10
        r4 = r39
        r5 = r38
        r6 = r9
        r1.m48978init(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x019a }
        r0.setAdObject(r14)     // Catch:{ all -> 0x019a }
        java.lang.String r1 = "zz os onAdLoaded"
        com.p368pw.inner.base.p387d.C5205o.m21462a(r1)     // Catch:{ all -> 0x019a }
        com.pw.inner.base.stat.e r11 = com.p368pw.inner.base.stat.C5224e.m21525a()     // Catch:{ all -> 0x019a }
        r12 = 2
        r13 = 1
        java.lang.String r1 = ""
        int r2 = r9.mo25785q()     // Catch:{ all -> 0x019a }
        java.lang.String r17 = r38.getPlacementId()     // Catch:{ all -> 0x019a }
        int r18 = f15558a     // Catch:{ all -> 0x019a }
        int r19 = f15559b     // Catch:{ all -> 0x019a }
        int r20 = f15560c     // Catch:{ all -> 0x019a }
        int r21 = f15561d     // Catch:{ all -> 0x019a }
        r22 = 0
        java.lang.String r23 = r38.getUuid()     // Catch:{ all -> 0x019a }
        int r3 = r38.getAdType()     // Catch:{ all -> 0x019a }
        java.lang.String r24 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x019a }
        int r25 = r10.mo25939q()     // Catch:{ all -> 0x019a }
        int r26 = r10.mo25941r()     // Catch:{ all -> 0x019a }
        java.lang.String r27 = ""
        java.lang.String r28 = ""
        java.lang.String r29 = ""
        r30 = -1
        java.lang.String r31 = r9.mo25772d()     // Catch:{ all -> 0x019a }
        java.lang.String r32 = r9.mo25771c()     // Catch:{ all -> 0x019a }
        java.lang.String r33 = r9.mo25770b()     // Catch:{ all -> 0x019a }
        java.lang.String r34 = com.p368pw.inner.p369a.p370a.p371a.C4822b.m19715c(r37)     // Catch:{ all -> 0x019a }
        r35 = 0
        r36 = 0
        r3 = r14
        r14 = r1
        r15 = r2
        r16 = r40
        r11.mo26909a(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36)     // Catch:{ all -> 0x019a }
        com.pw.us.ISplashAdListener r1 = r38.getSplashAdListener()     // Catch:{ all -> 0x019a }
        if (r1 == 0) goto L_0x019e
        com.pw.us.ISplashAdListener r1 = r38.getSplashAdListener()     // Catch:{ all -> 0x019a }
        r1.onLoaded(r3, r0)     // Catch:{ all -> 0x019a }
        goto L_0x019e
    L_0x0139:
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x019a }
        r2.<init>()     // Catch:{ all -> 0x019a }
        java.lang.String r4 = "zz os error = "
        r2.append(r4)     // Catch:{ all -> 0x019a }
        int r4 = r37.mo25836a()     // Catch:{ all -> 0x019a }
        r2.append(r4)     // Catch:{ all -> 0x019a }
        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x019a }
        com.p368pw.inner.base.p387d.C5205o.m21462a(r2)     // Catch:{ all -> 0x019a }
        com.pw.inner.base.stat.e r11 = com.p368pw.inner.base.stat.C5224e.m21525a()     // Catch:{ all -> 0x019a }
        r12 = 2
        r13 = 0
        java.lang.String r14 = ""
        java.lang.String r17 = r38.getPlacementId()     // Catch:{ all -> 0x019a }
        int r18 = f15558a     // Catch:{ all -> 0x019a }
        int r19 = f15559b     // Catch:{ all -> 0x019a }
        int r20 = f15560c     // Catch:{ all -> 0x019a }
        int r21 = f15561d     // Catch:{ all -> 0x019a }
        r22 = 0
        java.lang.String r23 = r38.getUuid()     // Catch:{ all -> 0x019a }
        int r0 = r38.getAdType()     // Catch:{ all -> 0x019a }
        java.lang.String r24 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x019a }
        r26 = 0
        java.lang.String r27 = ""
        java.lang.String r28 = ""
        java.lang.String r29 = ""
        r30 = -1
        java.lang.String r31 = ""
        java.lang.String r32 = ""
        java.lang.String r33 = ""
        java.lang.String r34 = ""
        r35 = 0
        r36 = 0
        r15 = r39
        r16 = r40
        r25 = r42
        r11.mo26909a(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36)     // Catch:{ all -> 0x019a }
        if (r1 == 0) goto L_0x019e
        int r0 = r3.f15875f     // Catch:{ all -> 0x019a }
        r1.mo25759a(r0, r1)     // Catch:{ all -> 0x019a }
        return
    L_0x019a:
        r0 = move-exception
        com.p368pw.inner.base.p387d.C5205o.m21464a(r0)
    L_0x019e:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p368pw.inner.p369a.p370a.p371a.C4831i.m19812d(com.pw.inner.a.a.a.h, com.pw.us.Setting, int, java.lang.String, boolean, int, com.pw.inner.a.a$a):void");
    }

    /* renamed from: d */
    public static void m19813d(Setting setting, int i, String str, int i2, C4820a aVar) {
        C4830h hVar;
        boolean z;
        m19814e();
        C5205o.m21462a("zz os load");
        C5123d d = C5125f.m21216a().mo26727d();
        if (System.currentTimeMillis() - C5237f.m21592f(C5233e.m21559b(), String.valueOf(setting.getAdType())) < ((long) (d.mo26701e() * 60000))) {
            C5205o.m21462a("zz os load local data");
            hVar = new C4830h(C5237f.m21591e(C5233e.m21559b(), String.valueOf(setting.getAdType())));
            z = false;
        } else {
            int b = C5229d.m21541a().mo26919b();
            C4821a aVar2 = new C4821a(1, 0, 0, 6, i, setting.getPlacementId());
            aVar2.mo25764a(d.mo26700d());
            aVar2.mo25766b(b);
            if (i == 8) {
                aVar2.mo25767c(2);
            }
            hVar = (C4830h) aVar2.mo26659b();
            C5205o.m21462a("zz os load net data");
            z = true;
        }
        m19812d(hVar, setting, i, str, z, i2, aVar);
    }

    /* renamed from: e */
    private static void m19814e() {
        try {
            C5123d d = C5125f.m21216a().mo26727d();
            if (d != null) {
                f15558a = 343;
                f15559b = d.mo26711o();
                f15560c = d.mo26712p();
                f15561d = d.mo26713q();
            }
        } catch (Throwable unused) {
        }
    }
}
