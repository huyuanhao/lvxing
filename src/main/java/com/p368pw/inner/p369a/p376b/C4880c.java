package com.p368pw.inner.p369a.p376b;

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
import com.p368pw.inner.p369a.p379e.C4958h;
import com.p368pw.inner.p369a.p379e.C4960j;
import com.p368pw.p392us.Setting;
import com.tencent.p605ep.shanhuad.adpublic.models.AdMetaInfo;
import com.tmsdk.module.coin.CoinTask;
import com.tmsdk.module.coin.ErrorCode;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* renamed from: com.pw.inner.a.b.c */
public class C4880c {
    /* renamed from: a */
    private boolean f15778a = false;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public int f15779b = 343;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public int f15780c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public int f15781d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public int f15782e;
    /* renamed from: f */
    private HashMap<Integer, SoftReference<AdMetaInfo>> f15783f = new HashMap<>();
    /* renamed from: g */
    private HashMap<String, Setting> f15784g = new HashMap<>();

    /* renamed from: com.pw.inner.a.b.c$a */
    public interface C4885a {
        void onDownloadFinished();

        void onInstalled();

        void onLandPageClose();
    }

    /* renamed from: com.pw.inner.a.b.c$b */
    private static class C4886b {
        /* access modifiers changed from: private|static */
        /* renamed from: a */
        public static C4880c f15798a = new C4880c();
    }

    /* renamed from: a */
    public static C4880c m20089a() {
        return C4886b.f15798a;
    }

    /* renamed from: a */
    private C4958h m20090a(C4850h hVar, C4879b bVar) {
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
    private C4958h m20091a(C4879b bVar) {
        C4958h hVar = new C4958h();
        try {
            hVar.mo26224e(bVar.mo25922h()).mo26212a("").mo26238l(bVar.mo25907b()).mo26228g(bVar.mo25916e()).mo26230h(bVar.mo25913d()).mo26226f(bVar.mo25920g()).mo26219c(bVar.mo25924i()).mo26222d(bVar.mo25904a()).mo26232i(bVar.mo25926j()).mo26234j(bVar.mo25944s()).mo26236k(bVar.mo25918f()).mo26216b(bVar.mo25935o());
            C4960j.m20737a(hVar, C5183b.m21360a(), false);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
        return hVar;
    }

    /* renamed from: b */
    private void m20093b() {
        try {
            if (!this.f15778a) {
                new C4876a(null);
                new C4889f(null);
                C5123d d = C5125f.m21216a().mo26727d();
                if (d != null) {
                    this.f15779b = 343;
                    this.f15780c = d.mo26711o();
                    this.f15781d = d.mo26712p();
                    this.f15782e = d.mo26713q();
                    this.f15778a = true;
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public void mo25949a(Context context, C4879b bVar) {
        Toast makeText;
        Context context2 = context;
        C4879b bVar2 = bVar;
        C5205o.m21461a();
        try {
            final Setting setting = (Setting) this.f15784g.get(bVar.mo25930l());
            final Object adObject = setting.getAdObject();
            C4958h hVar = new C4958h();
            if (bVar.mo25935o() == 5) {
                hVar = m20090a((C4850h) adObject, bVar2);
                if (this.f15783f != null) {
                    if (((SoftReference) this.f15783f.get(Integer.valueOf(System.identityHashCode(setting)))) == null) {
                        C5205o.m21462a("s sh ins no ck");
                        this.f15783f.put(Integer.valueOf(System.identityHashCode(setting)), new SoftReference(C4857j.m19935a().mo25869a((C4850h) adObject, bVar2)));
                    } else {
                        C5205o.m21462a("s sh ins has ck");
                    }
                }
                if (hVar == null) {
                    C5205o.m21462a("广点通广告，下载链接为空，广点通已经自己处理了，不需要我们自己下载");
                    if (!bVar2.f15752a) {
                        bVar2.f15752a = true;
                        int o = bVar.mo25935o();
                        String p = bVar.mo25938p();
                        String m = bVar.mo25932m();
                        int i = this.f15779b;
                        int i2 = this.f15780c;
                        int i3 = this.f15781d;
                        C5224e.m21525a().mo26909a(5, 1, "", o, p, m, i, i2, i3, this.f15782e, 0, bVar.mo25930l(), String.valueOf(bVar.mo25933n()), bVar.mo25939q(), bVar.mo25941r(), bVar.mo25910c(), "", "", -1, bVar.mo25904a(), bVar.mo25913d(), bVar.mo25928k(), bVar.mo25907b(), 0, 0);
                    }
                    if (setting.getSplashAdListener() != null) {
                        setting.getSplashAdListener().onClicked();
                    }
                    return;
                }
            }
            C4958h hVar2 = hVar;
            final C4879b bVar3 = bVar;
            final Context context3 = context;
            C48811 r1 = new C4827e() {
                /* renamed from: a */
                public void mo25787a() {
                }

                /* renamed from: a */
                public void mo25788a(int i) {
                }

                /* renamed from: a */
                public void mo25789a(int i, C5183b bVar) {
                    if (!bVar3.f15752a) {
                        bVar3.f15752a = true;
                        C5224e.m21525a().mo26909a(5, 1, "", bVar3.mo25935o(), bVar3.mo25938p(), bVar3.mo25932m(), C4880c.this.f15779b, C4880c.this.f15780c, C4880c.this.f15781d, C4880c.this.f15782e, 0, bVar3.mo25930l(), String.valueOf(bVar3.mo25933n()), bVar3.mo25939q(), bVar3.mo25941r(), bVar3.mo25910c(), "", "", -1, bVar3.mo25904a(), bVar3.mo25913d(), bVar3.mo25928k(), bVar3.mo25907b(), 0, 0);
                    }
                    if (i == 2) {
                        C5224e.m21525a().mo26909a((int) ErrorCode.ERC_TASK_INVALID, 1, "", bVar3.mo25935o(), bVar3.mo25938p(), bVar3.mo25932m(), C4880c.this.f15779b, C4880c.this.f15780c, C4880c.this.f15781d, C4880c.this.f15782e, 0, bVar3.mo25930l(), String.valueOf(bVar3.mo25933n()), bVar3.mo25939q(), bVar3.mo25941r(), bVar3.mo25910c(), "", "", -1, bVar3.mo25904a(), bVar3.mo25913d(), bVar3.mo25928k(), bVar3.mo25907b(), 0, 0);
                    }
                }

                /* renamed from: a */
                public void mo25790a(String str) {
                    C5205o.m21462a("ins start download");
                    if (setting.getInterstitialListener() != null) {
                        setting.getInterstitialListener().onDownloadStarted(str);
                    }
                    if (bVar3.mo25935o() == 5) {
                        C4857j.m19935a().mo25870a(5, C4857j.m19935a().mo25869a((C4850h) adObject, bVar3), "", (C4850h) adObject);
                    }
                    Object obj = adObject;
                    if (obj instanceof C4826d) {
                        C4960j.m20735a(context3, ((C4826d) obj).mo25783o());
                    }
                }

                /* renamed from: a */
                public void mo25791a(String str, String str2) {
                    String str3 = str2;
                    C5205o.m21462a("ins download finish");
                    Object obj = adObject;
                    if (obj instanceof C4826d) {
                        C4960j.m20735a(context3, ((C4826d) obj).mo25784p());
                    }
                    C5224e.m21525a().mo26909a(6, 1, "", bVar3.mo25935o(), bVar3.mo25938p(), setting.getPlacementId(), C4880c.this.f15779b, C4880c.this.f15780c, C4880c.this.f15781d, C4880c.this.f15782e, 0, setting.getUuid(), String.valueOf(setting.getAdType()), bVar3.mo25939q(), bVar3.mo25941r(), bVar3.mo25910c(), "", "", -1, bVar3.mo25904a(), bVar3.mo25913d(), bVar3.mo25928k(), bVar3.mo25907b(), 0, 0);
                    if (setting.getInterstitialListener() != null) {
                        setting.getInterstitialListener().onDownloadFinished(str, str3);
                    } else {
                        String str4 = str;
                    }
                    if (bVar3.mo25935o() == 5) {
                        AdMetaInfo a = C4857j.m19935a().mo25869a((C4850h) adObject, bVar3);
                        AdMetaInfo adMetaInfo = a;
                        C4857j.m19935a().mo25870a(6, a, str3, (C4850h) adObject);
                        AdMetaInfo adMetaInfo2 = a;
                        C5005h.m20951a().mo26405a(adMetaInfo, (CoinTask) ((C4850h) adObject).f15621c.get(a), bVar3.mo25913d(), bVar3.mo25916e(), bVar3.mo25920g(), str, str2, 1, 0, bVar3.mo25935o(), bVar3.mo25938p(), setting.getPlacementId(), String.valueOf(setting.getAdType()), bVar3.mo25939q(), C4839a.m19865a(adMetaInfo2), bVar3.mo25907b(), 2, null);
                        AdMetaInfo adMetaInfo3 = adMetaInfo2;
                        String str5 = str;
                        C5005h.m20951a().mo26400a(context3, bVar3.mo25935o(), setting.getAdType(), str5, bVar3.mo25913d(), bVar3.mo25916e(), bVar3.mo25920g(), "", "", bVar3.mo25924i(), adMetaInfo3, (CoinTask) ((C4850h) adObject).f15621c.get(adMetaInfo3));
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
                    C5205o.m21462a("ins install finish");
                    Object obj = adObject;
                    if (obj instanceof C4826d) {
                        C4960j.m20735a(context3, ((C4826d) obj).mo25782n());
                    }
                    C5224e.m21525a().mo26909a(7, 1, "", bVar3.mo25935o(), bVar3.mo25938p(), setting.getPlacementId(), C4880c.this.f15779b, C4880c.this.f15780c, C4880c.this.f15781d, C4880c.this.f15782e, 0, setting.getUuid(), String.valueOf(setting.getAdType()), bVar3.mo25939q(), bVar3.mo25941r(), bVar3.mo25910c(), "", "", -1, bVar3.mo25904a(), bVar3.mo25913d(), bVar3.mo25928k(), bVar3.mo25907b(), 0, 0);
                    if (setting.getInterstitialListener() != null) {
                        setting.getInterstitialListener().onInstalled(str, str3);
                    } else {
                        String str4 = str;
                    }
                    if (bVar3.mo25935o() == 5) {
                        AdMetaInfo a = C4857j.m19935a().mo25869a((C4850h) adObject, bVar3);
                        AdMetaInfo adMetaInfo = a;
                        C4857j.m19935a().mo25870a(7, a, str3, (C4850h) adObject);
                        String str5 = str;
                        String str6 = str2;
                        C5005h.m20951a().mo26405a(adMetaInfo, (CoinTask) ((C4850h) adObject).f15621c.get(a), bVar3.mo25913d(), bVar3.mo25916e(), bVar3.mo25920g(), str5, str6, 2, 0, bVar3.mo25935o(), bVar3.mo25938p(), setting.getPlacementId(), String.valueOf(setting.getAdType()), bVar3.mo25939q(), C4839a.m19865a(a), bVar3.mo25907b(), 2, null);
                    }
                    C5005h.m20951a().mo26406a(bVar3.mo25904a(), 2, 0, (C5134a) null);
                    C5208r.m21483b(new Runnable() {
                        public void run() {
                            if (bVar3.mo25935o() == 5 && !bVar3.f15753b && C4857j.m19935a().mo25874a(context3)) {
                                bVar3.f15753b = true;
                                C4857j.m19935a().mo25870a(8, C4857j.m19935a().mo25869a((C4850h) adObject, bVar3), "", (C4850h) adObject);
                                C5224e.m21525a().mo26909a(8001, 1, "", bVar3.mo25935o(), bVar3.mo25938p(), setting.getPlacementId(), C4880c.this.f15779b, C4880c.this.f15780c, C4880c.this.f15781d, C4880c.this.f15782e, 0, setting.getUuid(), String.valueOf(setting.getAdType()), bVar3.mo25939q(), bVar3.mo25941r(), bVar3.mo25910c(), "", "", -1, bVar3.mo25904a(), bVar3.mo25913d(), bVar3.mo25928k(), bVar3.mo25907b(), 0, 0);
                                C5005h.m20951a().mo26406a(bVar3.mo25904a(), 2, 1, (C5134a) null);
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
                    Object obj = adObject;
                    if (obj instanceof C4826d) {
                        C4960j.m20735a(context3, ((C4826d) obj).mo25781m());
                    }
                    C5224e.m21525a().mo26909a(9, 1, "", bVar3.mo25935o(), bVar3.mo25938p(), setting.getPlacementId(), C4880c.this.f15779b, C4880c.this.f15780c, C4880c.this.f15781d, C4880c.this.f15782e, 0, setting.getUuid(), String.valueOf(setting.getAdType()), bVar3.mo25939q(), bVar3.mo25941r(), bVar3.mo25910c(), "", "", -1, bVar3.mo25904a(), bVar3.mo25913d(), bVar3.mo25928k(), bVar3.mo25907b(), 0, 0);
                }

                /* renamed from: d */
                public void mo25799d(int i) {
                    if (i == 1) {
                        C4880c.this.mo25954d(context3, bVar3);
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
                    C5224e.m21525a().mo26909a(8, 1, "", bVar3.mo25935o(), bVar3.mo25938p(), setting.getPlacementId(), C4880c.this.f15779b, C4880c.this.f15780c, C4880c.this.f15781d, C4880c.this.f15782e, 0, setting.getUuid(), String.valueOf(setting.getAdType()), bVar3.mo25939q(), bVar3.mo25941r(), bVar3.mo25910c(), "", "", -1, bVar3.mo25904a(), bVar3.mo25913d(), bVar3.mo25928k(), bVar3.mo25907b(), 0, 0);
                    if (bVar3.mo25935o() == 5 && !bVar3.f15753b) {
                        C5205o.m21462a("ins active");
                        bVar3.f15753b = true;
                        C4857j.m19935a().mo25870a(8, C4857j.m19935a().mo25869a((C4850h) adObject, bVar3), "", (C4850h) adObject);
                        C5005h.m20951a().mo26406a(bVar3.mo25904a(), 2, 1, (C5134a) null);
                    }
                }

                /* renamed from: k */
                public void mo25806k() {
                }

                /* renamed from: l */
                public void mo25807l() {
                }
            };
            int a = C4960j.m20728a(context2, hVar2, null, r1, null);
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

    /* renamed from: a */
    public void mo25950a(Context context, C4879b bVar, int i, C5183b bVar2, C4885a aVar) {
        Toast makeText;
        try {
            final WeakReference weakReference = new WeakReference(aVar);
            final Setting setting = (Setting) this.f15784g.get(bVar.mo25930l());
            final Object adObject = setting.getAdObject();
            C4958h hVar = new C4958h();
            if (bVar.mo25935o() == 5) {
                hVar = m20090a((C4850h) adObject, bVar);
                if (this.f15783f != null) {
                    if (((SoftReference) this.f15783f.get(Integer.valueOf(System.identityHashCode(setting)))) == null) {
                        C5205o.m21462a("s sh ins no ck");
                        this.f15783f.put(Integer.valueOf(System.identityHashCode(setting)), new SoftReference(C4857j.m19935a().mo25869a((C4850h) adObject, bVar)));
                    } else {
                        C5205o.m21462a("s sh ins has ck");
                    }
                }
            }
            if (i == 6 || bVar.mo25935o() == 8) {
                hVar = m20091a(bVar);
            }
            final C4879b bVar3 = bVar;
            final Context context2 = context;
            C48832 r0 = new C4827e() {
                /* renamed from: a */
                public void mo25787a() {
                }

                /* renamed from: a */
                public void mo25788a(int i) {
                }

                /* renamed from: a */
                public void mo25789a(int i, C5183b bVar) {
                    if (!bVar3.f15752a) {
                        bVar3.f15752a = true;
                        C5224e.m21525a().mo26909a(5, 1, "", bVar3.mo25935o(), bVar3.mo25938p(), bVar3.mo25932m(), C4880c.this.f15779b, C4880c.this.f15780c, C4880c.this.f15781d, C4880c.this.f15782e, 0, bVar3.mo25930l(), String.valueOf(bVar3.mo25933n()), bVar3.mo25939q(), bVar3.mo25941r(), bVar3.mo25910c(), "", "", -1, bVar3.mo25904a(), bVar3.mo25913d(), bVar3.mo25928k(), bVar3.mo25907b(), 0, 0);
                    }
                    if (i == 2) {
                        C5224e.m21525a().mo26909a((int) ErrorCode.ERC_TASK_INVALID, 1, "", bVar3.mo25935o(), bVar3.mo25938p(), bVar3.mo25932m(), C4880c.this.f15779b, C4880c.this.f15780c, C4880c.this.f15781d, C4880c.this.f15782e, 0, bVar3.mo25930l(), String.valueOf(bVar3.mo25933n()), bVar3.mo25939q(), bVar3.mo25941r(), bVar3.mo25910c(), "", "", -1, bVar3.mo25904a(), bVar3.mo25913d(), bVar3.mo25928k(), bVar3.mo25907b(), 0, 0);
                    }
                    Object obj = adObject;
                    if (obj instanceof C4826d) {
                        C4960j.m20736a(context2, ((C4826d) obj).mo25780l(), bVar, true);
                    }
                }

                /* renamed from: a */
                public void mo25790a(String str) {
                    C5205o.m21462a("ins start download");
                    if (setting.getInterstitialListener() != null) {
                        setting.getInterstitialListener().onDownloadStarted(str);
                    }
                    if (bVar3.mo25935o() == 5) {
                        C4857j.m19935a().mo25870a(5, C4857j.m19935a().mo25869a((C4850h) adObject, bVar3), "", (C4850h) adObject);
                    }
                    Object obj = adObject;
                    if (obj instanceof C4826d) {
                        C4960j.m20735a(context2, ((C4826d) obj).mo25783o());
                    }
                }

                /* renamed from: a */
                public void mo25791a(String str, String str2) {
                    String str3 = str2;
                    C5205o.m21462a("ins download finish");
                    Object obj = adObject;
                    if (obj instanceof C4826d) {
                        C4960j.m20735a(context2, ((C4826d) obj).mo25784p());
                    }
                    C5224e.m21525a().mo26909a(6, 1, "", bVar3.mo25935o(), bVar3.mo25938p(), setting.getPlacementId(), C4880c.this.f15779b, C4880c.this.f15780c, C4880c.this.f15781d, C4880c.this.f15782e, 0, setting.getUuid(), String.valueOf(setting.getAdType()), bVar3.mo25939q(), bVar3.mo25941r(), bVar3.mo25910c(), "", "", -1, bVar3.mo25904a(), bVar3.mo25913d(), bVar3.mo25928k(), bVar3.mo25907b(), 0, 0);
                    if (setting.getInterstitialListener() != null) {
                        setting.getInterstitialListener().onDownloadFinished(str, str3);
                    } else {
                        String str4 = str;
                    }
                    if (bVar3.mo25935o() == 5) {
                        AdMetaInfo a = C4857j.m19935a().mo25869a((C4850h) adObject, bVar3);
                        AdMetaInfo adMetaInfo = a;
                        C4857j.m19935a().mo25870a(6, a, str3, (C4850h) adObject);
                        AdMetaInfo adMetaInfo2 = a;
                        C5005h.m20951a().mo26405a(adMetaInfo, (CoinTask) ((C4850h) adObject).f15621c.get(a), bVar3.mo25913d(), bVar3.mo25916e(), bVar3.mo25920g(), str, str2, 1, 0, bVar3.mo25935o(), bVar3.mo25938p(), setting.getPlacementId(), String.valueOf(setting.getAdType()), bVar3.mo25939q(), C4839a.m19865a(adMetaInfo2), bVar3.mo25907b(), 2, null);
                        AdMetaInfo adMetaInfo3 = adMetaInfo2;
                        String str5 = str;
                        C5005h.m20951a().mo26400a(context2, bVar3.mo25935o(), setting.getAdType(), str5, bVar3.mo25913d(), bVar3.mo25916e(), bVar3.mo25920g(), "", "", bVar3.mo25924i(), adMetaInfo3, (CoinTask) ((C4850h) adObject).f15621c.get(adMetaInfo3));
                    }
                    C4885a aVar = (C4885a) weakReference.get();
                    if (aVar != null) {
                        aVar.onDownloadFinished();
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
                    C5205o.m21462a("ins install finish");
                    Object obj = adObject;
                    if (obj instanceof C4826d) {
                        C4960j.m20735a(context2, ((C4826d) obj).mo25782n());
                    }
                    C5224e.m21525a().mo26909a(7, 1, "", bVar3.mo25935o(), bVar3.mo25938p(), setting.getPlacementId(), C4880c.this.f15779b, C4880c.this.f15780c, C4880c.this.f15781d, C4880c.this.f15782e, 0, setting.getUuid(), String.valueOf(setting.getAdType()), bVar3.mo25939q(), bVar3.mo25941r(), bVar3.mo25910c(), "", "", -1, bVar3.mo25904a(), bVar3.mo25913d(), bVar3.mo25928k(), bVar3.mo25907b(), 0, 0);
                    if (setting.getInterstitialListener() != null) {
                        setting.getInterstitialListener().onInstalled(str, str3);
                    } else {
                        String str4 = str;
                    }
                    if (bVar3.mo25935o() == 5) {
                        AdMetaInfo a = C4857j.m19935a().mo25869a((C4850h) adObject, bVar3);
                        AdMetaInfo adMetaInfo = a;
                        C4857j.m19935a().mo25870a(7, a, str3, (C4850h) adObject);
                        String str5 = str;
                        String str6 = str2;
                        C5005h.m20951a().mo26405a(adMetaInfo, (CoinTask) ((C4850h) adObject).f15621c.get(a), bVar3.mo25913d(), bVar3.mo25916e(), bVar3.mo25920g(), str5, str6, 2, 0, bVar3.mo25935o(), bVar3.mo25938p(), setting.getPlacementId(), String.valueOf(setting.getAdType()), bVar3.mo25939q(), C4839a.m19865a(a), bVar3.mo25907b(), 2, null);
                    }
                    C4885a aVar = (C4885a) weakReference.get();
                    if (aVar != null) {
                        aVar.onInstalled();
                    }
                    C5005h.m20951a().mo26406a(bVar3.mo25904a(), 2, 0, (C5134a) null);
                    C5208r.m21483b(new Runnable() {
                        public void run() {
                            if (bVar3.mo25935o() == 5 && !bVar3.f15753b && C4857j.m19935a().mo25874a(context2)) {
                                bVar3.f15753b = true;
                                C4857j.m19935a().mo25870a(8, C4857j.m19935a().mo25869a((C4850h) adObject, bVar3), "", (C4850h) adObject);
                                C5224e.m21525a().mo26909a(8001, 1, "", bVar3.mo25935o(), bVar3.mo25938p(), setting.getPlacementId(), C4880c.this.f15779b, C4880c.this.f15780c, C4880c.this.f15781d, C4880c.this.f15782e, 0, setting.getUuid(), String.valueOf(setting.getAdType()), bVar3.mo25939q(), bVar3.mo25941r(), bVar3.mo25910c(), "", "", -1, bVar3.mo25904a(), bVar3.mo25913d(), bVar3.mo25928k(), bVar3.mo25907b(), 0, 0);
                                C5005h.m20951a().mo26406a(bVar3.mo25904a(), 2, 1, (C5134a) null);
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
                    Object obj = adObject;
                    if (obj instanceof C4826d) {
                        C4960j.m20735a(context2, ((C4826d) obj).mo25781m());
                    }
                    C5224e.m21525a().mo26909a(9, 1, "", bVar3.mo25935o(), bVar3.mo25938p(), setting.getPlacementId(), C4880c.this.f15779b, C4880c.this.f15780c, C4880c.this.f15781d, C4880c.this.f15782e, 0, setting.getUuid(), String.valueOf(setting.getAdType()), bVar3.mo25939q(), bVar3.mo25941r(), bVar3.mo25910c(), "", "", -1, bVar3.mo25904a(), bVar3.mo25913d(), bVar3.mo25928k(), bVar3.mo25907b(), 0, 0);
                }

                /* renamed from: d */
                public void mo25799d(int i) {
                    if (i == 1) {
                        C4880c.this.mo25954d(context2, bVar3);
                        C4885a aVar = (C4885a) weakReference.get();
                        if (aVar != null) {
                            aVar.onLandPageClose();
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
                    C5224e.m21525a().mo26909a(8, 1, "", bVar3.mo25935o(), bVar3.mo25938p(), setting.getPlacementId(), C4880c.this.f15779b, C4880c.this.f15780c, C4880c.this.f15781d, C4880c.this.f15782e, 0, setting.getUuid(), String.valueOf(setting.getAdType()), bVar3.mo25939q(), bVar3.mo25941r(), bVar3.mo25910c(), "", "", -1, bVar3.mo25904a(), bVar3.mo25913d(), bVar3.mo25928k(), bVar3.mo25907b(), 0, 0);
                    if (bVar3.mo25935o() == 5 && !bVar3.f15753b) {
                        C5205o.m21462a("ins active");
                        bVar3.f15753b = true;
                        C4857j.m19935a().mo25870a(8, C4857j.m19935a().mo25869a((C4850h) adObject, bVar3), "", (C4850h) adObject);
                        C5005h.m20951a().mo26406a(bVar3.mo25904a(), 2, 1, (C5134a) null);
                    }
                }

                /* renamed from: k */
                public void mo25806k() {
                }

                /* renamed from: l */
                public void mo25807l() {
                    C4885a aVar = (C4885a) weakReference.get();
                    if (aVar != null) {
                        aVar.onLandPageClose();
                    }
                }
            };
            int a = C4960j.m20728a(context, hVar, bVar2, r0, null);
            if (a == 1) {
                makeText = Toast.makeText(context, "开始下载", 0);
            } else if (a == 2) {
                makeText = Toast.makeText(context, "正在下载，请稍后", 0);
            } else if (a == 3) {
                makeText = Toast.makeText(context, "已经下载，开始安装", 0);
            } else if (a == 4) {
                makeText = Toast.makeText(context, "已经安装，打开该应用", 0);
            } else {
                return;
            }
            makeText.show();
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0131 A[Catch:{ all -> 0x0139 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    public void mo25951a(com.p368pw.p392us.Setting r32, com.p368pw.inner.p369a.p376b.C4879b r33, int r34, java.lang.String r35, int r36) {
        /*
        r31 = this;
        r1 = r31
        r0 = r33
        r2 = r34
        com.pw.inner.a.g r3 = r32.getThPlacementBean()     // Catch:{ all -> 0x0139 }
        java.lang.String r4 = r32.getUuid()     // Catch:{ all -> 0x0139 }
        com.pw.inner.a.b.b r4 = r0.mo25929l(r4)     // Catch:{ all -> 0x0139 }
        java.lang.String r5 = r32.getPlacementId()     // Catch:{ all -> 0x0139 }
        com.pw.inner.a.b.b r4 = r4.mo25931m(r5)     // Catch:{ all -> 0x0139 }
        int r5 = r32.getAdType()     // Catch:{ all -> 0x0139 }
        com.pw.inner.a.b.b r4 = r4.mo25905b(r5)     // Catch:{ all -> 0x0139 }
        r10 = r35
        com.pw.inner.a.b.b r4 = r4.mo25934n(r10)     // Catch:{ all -> 0x0139 }
        r15 = r36
        r4.mo25911d(r15)     // Catch:{ all -> 0x0139 }
        r31.m20093b()     // Catch:{ all -> 0x0139 }
        com.pw.inner.base.a.f r4 = com.p368pw.inner.base.p384a.C5125f.m21216a()     // Catch:{ all -> 0x0139 }
        com.pw.inner.base.a.d r4 = r4.mo26727d()     // Catch:{ all -> 0x0139 }
        java.util.HashMap<java.lang.String, com.pw.us.Setting> r5 = r1.f15784g     // Catch:{ all -> 0x0139 }
        java.lang.String r6 = r33.mo25930l()     // Catch:{ all -> 0x0139 }
        r14 = r32
        r5.put(r6, r14)     // Catch:{ all -> 0x0139 }
        int r5 = r32.getAdType()     // Catch:{ all -> 0x0139 }
        r6 = 2
        java.lang.String r7 = "ins_source"
        java.lang.String r8 = "ins_data"
        if (r5 != r6) goto L_0x00ad
        java.lang.Object r5 = r32.getAdObject()     // Catch:{ all -> 0x0139 }
        boolean r5 = r5 instanceof com.p368pw.inner.p369a.p370a.p373c.C4850h     // Catch:{ all -> 0x0139 }
        if (r5 == 0) goto L_0x0080
        java.lang.Object r5 = r32.getAdObject()     // Catch:{ all -> 0x0139 }
        com.pw.inner.a.a.c.h r5 = (com.p368pw.inner.p369a.p370a.p373c.C4850h) r5     // Catch:{ all -> 0x0139 }
        java.lang.Object r5 = r5.f15622d     // Catch:{ all -> 0x0139 }
        boolean r5 = r5 instanceof com.tencent.p605ep.shanhuad.adpublic.adbuilder.ADDownLoad     // Catch:{ all -> 0x0139 }
        if (r5 == 0) goto L_0x0080
        android.content.Context r2 = com.p368pw.inner.C5233e.m21559b()     // Catch:{ all -> 0x0139 }
        java.lang.Class<com.pw.inner.a.b.a> r3 = com.p368pw.inner.p369a.p376b.C4876a.class
        android.content.Intent r2 = com.p368pw.view.InterstitialActivity.getIntent(r2, r3)     // Catch:{ all -> 0x0139 }
        r2.putExtra(r8, r0)     // Catch:{ all -> 0x0139 }
        java.lang.String r3 = "win_setting_identity"
        int r4 = com.p368pw.inner.p369a.p376b.C4893g.m20176a(r32)     // Catch:{ all -> 0x0139 }
        r2.putExtra(r3, r4)     // Catch:{ all -> 0x0139 }
        android.content.Context r3 = com.p368pw.inner.C5233e.m21559b()     // Catch:{ all -> 0x0139 }
        r3.startActivity(r2)     // Catch:{ all -> 0x0139 }
        goto L_0x00da
    L_0x0080:
        int r4 = r4.mo26703g()     // Catch:{ all -> 0x0139 }
        int r5 = r32.getOrientation()     // Catch:{ all -> 0x0139 }
        int r3 = r3.mo26307f()     // Catch:{ all -> 0x0139 }
        com.pw.inner.a.b.d r3 = com.p368pw.inner.p369a.p376b.C4888e.m20152a(r4, r0, r5, r3)     // Catch:{ all -> 0x0139 }
        android.content.Context r4 = com.p368pw.inner.C5233e.m21559b()     // Catch:{ all -> 0x0139 }
        java.lang.Class<com.pw.inner.a.b.f> r5 = com.p368pw.inner.p369a.p376b.C4889f.class
        android.content.Intent r4 = com.p368pw.view.InterstitialActivity.getIntent(r4, r5)     // Catch:{ all -> 0x0139 }
        r4.putExtra(r8, r0)     // Catch:{ all -> 0x0139 }
        java.lang.String r5 = "ins_temp"
        r4.putExtra(r5, r3)     // Catch:{ all -> 0x0139 }
        r4.putExtra(r7, r2)     // Catch:{ all -> 0x0139 }
        android.content.Context r2 = com.p368pw.inner.C5233e.m21559b()     // Catch:{ all -> 0x0139 }
    L_0x00a9:
        r2.startActivity(r4)     // Catch:{ all -> 0x0139 }
        goto L_0x00da
    L_0x00ad:
        int r3 = r32.getAdType()     // Catch:{ all -> 0x0139 }
        r4 = 4
        if (r3 != r4) goto L_0x00da
        java.lang.String r3 = "https://adx-api.zzpolarb.com/static/adtemp/interstitial_f0.html"
        java.lang.String r3 = com.p368pw.inner.base.p387d.C5194l.m21428a(r3)     // Catch:{ all -> 0x0139 }
        android.content.Intent r4 = new android.content.Intent     // Catch:{ all -> 0x0139 }
        android.content.Context r5 = com.p368pw.inner.C5233e.m21559b()     // Catch:{ all -> 0x0139 }
        java.lang.Class<com.pw.view.FullInterstitialActivity> r6 = com.p368pw.view.FullInterstitialActivity.class
        r4.<init>(r5, r6)     // Catch:{ all -> 0x0139 }
        r4.putExtra(r8, r0)     // Catch:{ all -> 0x0139 }
        java.lang.String r5 = "ins_url"
        r4.putExtra(r5, r3)     // Catch:{ all -> 0x0139 }
        r4.putExtra(r7, r2)     // Catch:{ all -> 0x0139 }
        r2 = 268435456(0x10000000, float:2.5243549E-29)
        r4.setFlags(r2)     // Catch:{ all -> 0x0139 }
        android.content.Context r2 = com.p368pw.inner.C5233e.m21559b()     // Catch:{ all -> 0x0139 }
        goto L_0x00a9
    L_0x00da:
        com.pw.inner.base.stat.e r5 = com.p368pw.inner.base.stat.C5224e.m21525a()     // Catch:{ all -> 0x0139 }
        r6 = 4
        r7 = 1
        java.lang.String r8 = ""
        int r9 = r33.mo25935o()     // Catch:{ all -> 0x0139 }
        java.lang.String r11 = r32.getPlacementId()     // Catch:{ all -> 0x0139 }
        int r12 = r1.f15779b     // Catch:{ all -> 0x0139 }
        int r13 = r1.f15780c     // Catch:{ all -> 0x0139 }
        int r2 = r1.f15781d     // Catch:{ all -> 0x0139 }
        int r3 = r1.f15782e     // Catch:{ all -> 0x0139 }
        r16 = 0
        java.lang.String r17 = r32.getUuid()     // Catch:{ all -> 0x0139 }
        int r4 = r32.getAdType()     // Catch:{ all -> 0x0139 }
        java.lang.String r18 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x0139 }
        int r20 = r33.mo25941r()     // Catch:{ all -> 0x0139 }
        java.lang.String r21 = r33.mo25910c()     // Catch:{ all -> 0x0139 }
        java.lang.String r22 = ""
        java.lang.String r23 = ""
        r24 = -1
        java.lang.String r25 = r33.mo25904a()     // Catch:{ all -> 0x0139 }
        java.lang.String r26 = r33.mo25913d()     // Catch:{ all -> 0x0139 }
        java.lang.String r27 = r33.mo25928k()     // Catch:{ all -> 0x0139 }
        java.lang.String r28 = r33.mo25907b()     // Catch:{ all -> 0x0139 }
        r29 = 0
        r30 = 0
        r10 = r35
        r14 = r2
        r15 = r3
        r19 = r36
        r5.mo26909a(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)     // Catch:{ all -> 0x0139 }
        com.pw.us.IInterstitialAdListener r0 = r32.getInterstitialListener()     // Catch:{ all -> 0x0139 }
        if (r0 == 0) goto L_0x013d
        com.pw.us.IInterstitialAdListener r0 = r32.getInterstitialListener()     // Catch:{ all -> 0x0139 }
        r0.onShowed()     // Catch:{ all -> 0x0139 }
        goto L_0x013d
    L_0x0139:
        r0 = move-exception
        com.p368pw.inner.base.p387d.C5205o.m21464a(r0)
    L_0x013d:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p368pw.inner.p369a.p376b.C4880c.mo25951a(com.pw.us.Setting, com.pw.inner.a.b.b, int, java.lang.String, int):void");
    }

    /* renamed from: b */
    public void mo25952b(Context context, C4879b bVar) {
        try {
            mo25953c(context, bVar);
            C5224e.m21525a().mo26909a(5007, 1, "", bVar.mo25935o(), bVar.mo25938p(), bVar.mo25932m(), this.f15779b, this.f15780c, this.f15781d, this.f15782e, 0, bVar.mo25930l(), String.valueOf(bVar.mo25933n()), bVar.mo25939q(), bVar.mo25941r(), bVar.mo25910c(), "", "", -1, bVar.mo25904a(), bVar.mo25913d(), bVar.mo25928k(), bVar.mo25907b(), 0, 0);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: c */
    public void mo25953c(Context context, C4879b bVar) {
        if (this.f15784g.get(bVar.mo25930l()) != null) {
            ((Setting) this.f15784g.get(bVar.mo25930l())).getInterstitialListener().onClosed();
        }
        this.f15784g.remove(bVar.mo25930l());
    }

    /* renamed from: d */
    public void mo25954d(Context context, C4879b bVar) {
        try {
            C5224e.m21525a().mo26909a(5008, 1, "", bVar.mo25935o(), bVar.mo25938p(), bVar.mo25932m(), this.f15779b, this.f15780c, this.f15781d, this.f15782e, 0, bVar.mo25930l(), String.valueOf(bVar.mo25933n()), bVar.mo25939q(), bVar.mo25941r(), bVar.mo25910c(), "", "", -1, bVar.mo25904a(), bVar.mo25913d(), bVar.mo25928k(), bVar.mo25907b(), 0, 0);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }
}
