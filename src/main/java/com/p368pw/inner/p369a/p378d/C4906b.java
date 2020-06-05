package com.p368pw.inner.p369a.p378d;

import android.content.Context;
import android.widget.Toast;
import com.p368pw.inner.appwall.C5005h;
import com.p368pw.inner.base.p384a.C5123d;
import com.p368pw.inner.base.p384a.C5125f;
import com.p368pw.inner.base.p385b.C5131a.C5134a;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.C5207q;
import com.p368pw.inner.base.p387d.C5208r;
import com.p368pw.inner.base.p387d.C5213t;
import com.p368pw.inner.base.p387d.p391d.C5183b;
import com.p368pw.inner.base.stat.C5224e;
import com.p368pw.inner.p369a.p370a.p371a.C4826d;
import com.p368pw.inner.p369a.p370a.p371a.C4827e;
import com.p368pw.inner.p369a.p370a.p373c.C4839a;
import com.p368pw.inner.p369a.p370a.p373c.C4850h;
import com.p368pw.inner.p369a.p370a.p373c.C4857j;
import com.p368pw.inner.p369a.p376b.C4879b;
import com.p368pw.inner.p369a.p378d.C4898a.C4905a;
import com.p368pw.inner.p369a.p379e.C4958h;
import com.p368pw.inner.p369a.p379e.C4960j;
import com.p368pw.p392us.Setting;
import com.tencent.p605ep.shanhuad.adpublic.models.AdMetaInfo;
import com.tmsdk.module.coin.CoinTask;
import com.tmsdk.module.coin.ErrorCode;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.pw.inner.a.d.b */
public class C4906b {
    /* renamed from: a */
    private Map<Integer, SoftReference<AdMetaInfo>> f15855a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public int f15856b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public int f15857c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public int f15858d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public int f15859e;
    /* renamed from: f */
    private boolean f15860f;

    /* renamed from: com.pw.inner.a.d.b$a */
    private static class C4909a {
        /* access modifiers changed from: private|static|final */
        /* renamed from: a */
        public static final C4906b f15868a = new C4906b();
    }

    private C4906b() {
        this.f15855a = new HashMap();
        this.f15856b = 343;
        this.f15860f = false;
    }

    /* renamed from: a */
    public static C4906b m20273a() {
        return C4909a.f15868a;
    }

    /* renamed from: a */
    private C4958h m20274a(C4850h hVar, C4879b bVar) {
        C4958h hVar2;
        try {
            if (hVar.f15620b != null && hVar.f15620b.size() > 0) {
                int size = hVar.f15620b.size();
                int i = 0;
                while (i < size) {
                    AdMetaInfo adMetaInfo = (AdMetaInfo) hVar.f15620b.get(i);
                    if (!C5213t.m21487a(C4839a.m19870d(adMetaInfo), bVar.mo25904a()) || !C5213t.m21487a(adMetaInfo.icon, bVar.mo25920g()) || !C5207q.m21478b((CharSequence) adMetaInfo.getDownLoadUrl())) {
                        i++;
                    } else {
                        hVar2 = new C4958h();
                        try {
                            hVar2.mo26224e(adMetaInfo.cta).mo26212a(C4839a.m19867b(adMetaInfo)).mo26228g(adMetaInfo.desc).mo26230h(adMetaInfo.title).mo26226f(adMetaInfo.icon).mo26219c(adMetaInfo.getDownLoadUrl()).mo26222d(C4839a.m19870d(adMetaInfo)).mo26211a(System.identityHashCode(adMetaInfo)).mo26232i(C4839a.m19869c(adMetaInfo));
                            return hVar2;
                        } catch (Throwable th) {
                            th = th;
                        }
                    }
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            hVar2 = null;
            C5205o.m21464a(th);
            return hVar2;
        }
    }

    /* renamed from: a */
    private C4958h m20275a(C4879b bVar) {
        C4958h hVar = new C4958h();
        try {
            hVar.mo26224e(bVar.mo25922h()).mo26212a("").mo26228g(bVar.mo25916e()).mo26230h(bVar.mo25913d()).mo26226f(bVar.mo25920g()).mo26219c(bVar.mo25924i()).mo26222d(bVar.mo25904a()).mo26232i(bVar.mo25926j()).mo26234j(bVar.mo25944s()).mo26236k(bVar.mo25918f()).mo26238l(bVar.mo25907b());
            C4960j.m20737a(hVar, C5183b.m21360a(), false);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
        return hVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m20278b(Context context, C4879b bVar, Setting setting) {
        try {
            C5224e.m21525a().mo26909a(5008, 1, "", bVar.mo25935o(), bVar.mo25938p(), bVar.mo25932m(), this.f15856b, this.f15857c, this.f15858d, this.f15859e, 0, bVar.mo25930l(), String.valueOf(setting.getAdType()), bVar.mo25939q(), bVar.mo25941r(), bVar.mo25910c(), "", "", -1, bVar.mo25904a(), bVar.mo25913d(), bVar.mo25928k(), bVar.mo25907b(), 0, 0);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: a */
    public void mo26038a(Context context) {
        try {
            if (!this.f15860f) {
                C5123d d = C5125f.m21216a().mo26727d();
                if (d != null) {
                    this.f15856b = 343;
                    this.f15857c = d.mo26711o();
                    this.f15858d = d.mo26712p();
                    this.f15859e = d.mo26713q();
                    this.f15860f = true;
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public void mo26039a(Context context, C4879b bVar, Setting setting) {
        try {
            C5224e.m21525a().mo26909a(5007, 1, "", bVar.mo25935o(), bVar.mo25938p(), bVar.mo25932m(), this.f15856b, this.f15857c, this.f15858d, this.f15859e, 0, bVar.mo25930l(), String.valueOf(setting.getAdType()), bVar.mo25939q(), bVar.mo25941r(), bVar.mo25910c(), "", "", -1, bVar.mo25904a(), bVar.mo25913d(), bVar.mo25928k(), bVar.mo25907b(), 0, 0);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: a */
    public void mo26040a(Context context, C4879b bVar, Setting setting, C4898a aVar) {
        Context context2 = context;
        aVar.mo26024a();
        aVar.mo26025a(context2, setting);
        C5205o.m21462a("open show");
        C5224e.m21525a().mo26909a(3, 1, "", bVar.mo25935o(), bVar.mo25938p(), setting.getPlacementId(), this.f15856b, this.f15857c, this.f15858d, this.f15859e, 0, setting.getUuid(), String.valueOf(setting.getAdType()), bVar.mo25939q(), bVar.mo25941r(), bVar.mo25910c(), "", "", -1, bVar.mo25904a(), bVar.mo25913d(), bVar.mo25928k(), bVar.mo25907b(), 0, 0);
        C5224e.m21525a().mo26909a(4, 1, "", bVar.mo25935o(), bVar.mo25938p(), setting.getPlacementId(), this.f15856b, this.f15857c, this.f15858d, this.f15859e, 0, setting.getUuid(), String.valueOf(setting.getAdType()), bVar.mo25939q(), bVar.mo25941r(), bVar.mo25910c(), "", "", -1, bVar.mo25904a(), bVar.mo25913d(), bVar.mo25928k(), bVar.mo25907b(), 0, 0);
        Object originBean = aVar.getOriginBean();
        if (originBean instanceof C4826d) {
            C4960j.m20735a(context2, ((C4826d) originBean).mo25779k());
        }
        if (bVar.mo25935o() == 5) {
            C5205o.m21462a("s sh open no ck");
        }
        if (setting.getSplashAdListener() != null) {
            setting.getSplashAdListener().onShowed();
        }
    }

    /* renamed from: a */
    public void mo26041a(Context context, Setting setting, C4898a aVar, C4879b bVar, int i, C5183b bVar2, C4905a aVar2) {
        Toast makeText;
        Context context2 = context;
        C4879b bVar3 = bVar;
        try {
            final Object originBean = aVar.getOriginBean();
            C4958h hVar = new C4958h();
            if (bVar.mo25935o() == 5) {
                hVar = m20274a((C4850h) originBean, bVar3);
                if (this.f15855a != null) {
                    if (((SoftReference) this.f15855a.get(Integer.valueOf(System.identityHashCode(setting)))) == null) {
                        C5205o.m21462a("该广告未点击过");
                        this.f15855a.put(Integer.valueOf(System.identityHashCode(setting)), new SoftReference(C4857j.m19935a().mo25869a((C4850h) originBean, bVar3)));
                    } else {
                        C5205o.m21462a("该广告已点击，不再处理");
                    }
                }
                if (hVar == null) {
                    C5205o.m21462a("广点通广告，下载链接为空，广点通已经自己处理了，不需要我们自己下载");
                    if (!bVar3.f15752a) {
                        bVar3.f15752a = true;
                        int o = bVar.mo25935o();
                        String p = bVar.mo25938p();
                        String m = bVar.mo25932m();
                        int i2 = this.f15856b;
                        int i3 = this.f15857c;
                        int i4 = this.f15858d;
                        C5224e.m21525a().mo26909a(5, 1, "", o, p, m, i2, i3, i4, this.f15859e, 0, bVar.mo25930l(), String.valueOf(setting.getAdType()), bVar.mo25939q(), bVar.mo25941r(), bVar.mo25910c(), "", "", -1, bVar.mo25904a(), bVar.mo25913d(), bVar.mo25928k(), bVar.mo25907b(), 0, 0);
                    }
                    if (setting.getSplashAdListener() != null) {
                        setting.getSplashAdListener().onClicked();
                    }
                    return;
                }
            }
            if (i == 6 || bVar.mo25935o() == 8) {
                hVar = m20275a(bVar3);
            }
            C4958h hVar2 = hVar;
            final C4879b bVar4 = bVar;
            final Setting setting2 = setting;
            final Context context3 = context;
            final C4905a aVar3 = aVar2;
            C49071 r1 = new C4827e() {
                /* renamed from: a */
                public void mo25787a() {
                }

                /* renamed from: a */
                public void mo25788a(int i) {
                }

                /* renamed from: a */
                public void mo25789a(int i, C5183b bVar) {
                    if (!bVar4.f15752a) {
                        bVar4.f15752a = true;
                        C5224e.m21525a().mo26909a(5, 1, "", bVar4.mo25935o(), bVar4.mo25938p(), bVar4.mo25932m(), C4906b.this.f15856b, C4906b.this.f15857c, C4906b.this.f15858d, C4906b.this.f15859e, 0, bVar4.mo25930l(), String.valueOf(setting2.getAdType()), bVar4.mo25939q(), bVar4.mo25941r(), bVar4.mo25910c(), "", "", -1, bVar4.mo25904a(), bVar4.mo25913d(), bVar4.mo25928k(), bVar4.mo25907b(), 0, 0);
                    }
                    if (i == 2) {
                        C5224e.m21525a().mo26909a((int) ErrorCode.ERC_TASK_INVALID, 1, "", bVar4.mo25935o(), bVar4.mo25938p(), bVar4.mo25932m(), C4906b.this.f15856b, C4906b.this.f15857c, C4906b.this.f15858d, C4906b.this.f15859e, 0, bVar4.mo25930l(), String.valueOf(setting2.getAdType()), bVar4.mo25939q(), bVar4.mo25941r(), bVar4.mo25910c(), "", "", -1, bVar4.mo25904a(), bVar4.mo25913d(), bVar4.mo25928k(), bVar4.mo25907b(), 0, 0);
                    }
                    Object obj = originBean;
                    if (obj instanceof C4826d) {
                        C4960j.m20736a(context3, ((C4826d) obj).mo25780l(), bVar, false);
                    }
                    if (setting2.getSplashAdListener() != null) {
                        setting2.getSplashAdListener().onClicked();
                    }
                }

                /* renamed from: a */
                public void mo25790a(String str) {
                    C5205o.m21462a("open start download");
                    if (setting2.getInterstitialListener() != null) {
                        setting2.getInterstitialListener().onDownloadStarted(str);
                    }
                    if (bVar4.mo25935o() == 5) {
                        C4857j.m19935a().mo25870a(5, C4857j.m19935a().mo25869a((C4850h) originBean, bVar4), "", (C4850h) originBean);
                    }
                    Object obj = originBean;
                    if (obj instanceof C4826d) {
                        C4960j.m20735a(context3, ((C4826d) obj).mo25783o());
                    }
                }

                /* renamed from: a */
                public void mo25791a(String str, String str2) {
                    String str3 = str2;
                    C5205o.m21462a("open download finish");
                    Object obj = originBean;
                    if (obj instanceof C4826d) {
                        C4960j.m20735a(context3, ((C4826d) obj).mo25784p());
                    }
                    C5224e.m21525a().mo26909a(6, 1, "", bVar4.mo25935o(), bVar4.mo25938p(), setting2.getPlacementId(), C4906b.this.f15856b, C4906b.this.f15857c, C4906b.this.f15858d, C4906b.this.f15859e, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), bVar4.mo25939q(), bVar4.mo25941r(), bVar4.mo25910c(), "", "", -1, bVar4.mo25904a(), bVar4.mo25913d(), bVar4.mo25928k(), bVar4.mo25907b(), 0, 0);
                    if (setting2.getInterstitialListener() != null) {
                        setting2.getInterstitialListener().onDownloadFinished(str, str3);
                    } else {
                        String str4 = str;
                    }
                    if (bVar4.mo25935o() == 5) {
                        AdMetaInfo a = C4857j.m19935a().mo25869a((C4850h) originBean, bVar4);
                        AdMetaInfo adMetaInfo = a;
                        C4857j.m19935a().mo25870a(6, a, str3, (C4850h) originBean);
                        AdMetaInfo adMetaInfo2 = a;
                        C5005h.m20951a().mo26405a(adMetaInfo, (CoinTask) ((C4850h) originBean).f15621c.get(a), bVar4.mo25913d(), bVar4.mo25916e(), bVar4.mo25920g(), str, str2, 1, 0, bVar4.mo25935o(), bVar4.mo25938p(), setting2.getPlacementId(), String.valueOf(setting2.getAdType()), bVar4.mo25939q(), C4839a.m19865a(adMetaInfo2), bVar4.mo25907b(), 5, null);
                        AdMetaInfo adMetaInfo3 = adMetaInfo2;
                        String str5 = str;
                        C5005h.m20951a().mo26400a(context3, bVar4.mo25935o(), setting2.getAdType(), str5, bVar4.mo25913d(), bVar4.mo25916e(), bVar4.mo25920g(), "", "", bVar4.mo25924i(), adMetaInfo3, (CoinTask) ((C4850h) originBean).f15621c.get(adMetaInfo3));
                    }
                    C4905a aVar = aVar3;
                    if (aVar != null) {
                        aVar.mo26030a();
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
                    String str3 = str2;
                    C5205o.m21462a("open install finish");
                    Object obj = originBean;
                    if (obj instanceof C4826d) {
                        C4960j.m20735a(context3, ((C4826d) obj).mo25782n());
                    }
                    C5224e.m21525a().mo26909a(7, 1, "", bVar4.mo25935o(), bVar4.mo25938p(), setting2.getPlacementId(), C4906b.this.f15856b, C4906b.this.f15857c, C4906b.this.f15858d, C4906b.this.f15859e, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), bVar4.mo25939q(), bVar4.mo25941r(), bVar4.mo25910c(), "", "", -1, bVar4.mo25904a(), bVar4.mo25913d(), bVar4.mo25928k(), bVar4.mo25907b(), 0, 0);
                    if (setting2.getInterstitialListener() != null) {
                        setting2.getInterstitialListener().onInstalled(str, str3);
                    } else {
                        String str4 = str;
                    }
                    if (bVar4.mo25935o() == 5) {
                        AdMetaInfo a = C4857j.m19935a().mo25869a((C4850h) originBean, bVar4);
                        AdMetaInfo adMetaInfo = a;
                        C4857j.m19935a().mo25870a(7, a, str3, (C4850h) originBean);
                        String str5 = str;
                        String str6 = str2;
                        C5005h.m20951a().mo26405a(adMetaInfo, (CoinTask) ((C4850h) originBean).f15621c.get(a), bVar4.mo25913d(), bVar4.mo25916e(), bVar4.mo25920g(), str5, str6, 2, 0, bVar4.mo25935o(), bVar4.mo25938p(), setting2.getPlacementId(), String.valueOf(setting2.getAdType()), bVar4.mo25939q(), C4839a.m19865a(a), bVar4.mo25907b(), 5, null);
                    }
                    C4905a aVar = aVar3;
                    if (aVar != null) {
                        aVar.mo26031b();
                    }
                    C5005h.m20951a().mo26406a(bVar4.mo25904a(), 2, 0, (C5134a) null);
                    C5208r.m21483b(new Runnable() {
                        public void run() {
                            if (bVar4.mo25935o() == 5 && !bVar4.f15753b && C4857j.m19935a().mo25874a(context3)) {
                                bVar4.f15753b = true;
                                C4857j.m19935a().mo25870a(8, C4857j.m19935a().mo25869a((C4850h) originBean, bVar4), "", (C4850h) originBean);
                                C5224e.m21525a().mo26909a(8001, 1, "", bVar4.mo25935o(), bVar4.mo25938p(), setting2.getPlacementId(), C4906b.this.f15856b, C4906b.this.f15857c, C4906b.this.f15858d, C4906b.this.f15859e, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), bVar4.mo25939q(), bVar4.mo25941r(), bVar4.mo25910c(), "", "", -1, bVar4.mo25904a(), bVar4.mo25913d(), bVar4.mo25928k(), bVar4.mo25907b(), 0, 0);
                                C5005h.m20951a().mo26406a(bVar4.mo25904a(), 2, 1, (C5134a) null);
                            }
                        }
                    }, (long) (C5125f.m21216a().mo26727d().mo26681I() * 1000));
                }

                /* renamed from: c */
                public void mo25796c() {
                }

                /* renamed from: c */
                public void mo25797c(int i) {
                }

                /* renamed from: d */
                public void mo25798d() {
                    Object obj = originBean;
                    if (obj instanceof C4826d) {
                        C4960j.m20735a(context3, ((C4826d) obj).mo25781m());
                    }
                    C5224e.m21525a().mo26909a(9, 1, "", bVar4.mo25935o(), bVar4.mo25938p(), setting2.getPlacementId(), C4906b.this.f15856b, C4906b.this.f15857c, C4906b.this.f15858d, C4906b.this.f15859e, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), bVar4.mo25939q(), bVar4.mo25941r(), bVar4.mo25910c(), "", "", -1, bVar4.mo25904a(), bVar4.mo25913d(), bVar4.mo25928k(), bVar4.mo25907b(), 0, 0);
                }

                /* renamed from: d */
                public void mo25799d(int i) {
                    if (i == 1) {
                        C4906b.this.m20278b(context3, bVar4, setting2);
                        C4905a aVar = aVar3;
                        if (aVar != null) {
                            aVar.mo26032c();
                        }
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
                    C5224e.m21525a().mo26909a(8, 1, "", bVar4.mo25935o(), bVar4.mo25938p(), setting2.getPlacementId(), C4906b.this.f15856b, C4906b.this.f15857c, C4906b.this.f15858d, C4906b.this.f15859e, 0, setting2.getUuid(), String.valueOf(setting2.getAdType()), bVar4.mo25939q(), bVar4.mo25941r(), bVar4.mo25910c(), "", "", -1, bVar4.mo25904a(), bVar4.mo25913d(), bVar4.mo25928k(), bVar4.mo25907b(), 0, 0);
                    if (bVar4.mo25935o() == 5 && !bVar4.f15753b) {
                        C5205o.m21462a("open active");
                        bVar4.f15753b = true;
                        C4857j.m19935a().mo25870a(8, C4857j.m19935a().mo25869a((C4850h) originBean, bVar4), "", (C4850h) originBean);
                        C5005h.m20951a().mo26406a(bVar4.mo25904a(), 2, 1, (C5134a) null);
                    }
                }

                /* renamed from: k */
                public void mo25806k() {
                }

                /* renamed from: l */
                public void mo25807l() {
                    C4905a aVar = aVar3;
                    if (aVar != null) {
                        aVar.mo26032c();
                    }
                }
            };
            int a = C4960j.m20728a(context2, hVar2, bVar2, r1, null);
            if (a == 1) {
                makeText = Toast.makeText(context2, "开始下载", 0);
            } else if (a == 2) {
                makeText = Toast.makeText(context2, "正在下载，请稍后", 0);
            } else if (a == 3) {
                makeText = Toast.makeText(context2, "已经下载，开始安装", 0);
            } else {
                if (a == 4) {
                    makeText = Toast.makeText(context2, "已经安装，打开该应用", 0);
                }
            }
            makeText.show();
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }
}
