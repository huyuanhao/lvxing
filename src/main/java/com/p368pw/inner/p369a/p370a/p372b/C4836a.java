package com.p368pw.inner.p369a.p370a.p372b;

import android.content.Context;
import android.text.TextUtils;
import com.mob68.ad.RewardVideoAd;
import com.mob68.ad.listener.IRewardVideoAdListener;
import com.p368pw.inner.C5233e;
import com.p368pw.inner.base.p384a.C5123d;
import com.p368pw.inner.base.p384a.C5125f;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.stat.C5224e;
import com.p368pw.inner.p369a.C4819a.C4820a;
import com.p368pw.inner.p369a.C4911e;
import com.p368pw.inner.p369a.C4967g;
import com.p368pw.p392us.Setting;

/* renamed from: com.pw.inner.a.a.b.a */
public class C4836a {
    /* renamed from: a */
    RewardVideoAd f15584a;
    /* renamed from: b */
    private int f15585b = 343;
    /* renamed from: c */
    private int f15586c;
    /* renamed from: d */
    private int f15587d;
    /* renamed from: e */
    private int f15588e;

    /* renamed from: com.pw.inner.a.a.b.a$a */
    private static class C4838a {
        /* access modifiers changed from: private|static */
        /* renamed from: a */
        public static C4836a f15596a = new C4836a();
    }

    /* renamed from: a */
    public static C4836a m19858a() {
        return C4838a.f15596a;
    }

    /* renamed from: b */
    private void m19859b() {
        try {
            C5123d d = C5125f.m21216a().mo26727d();
            if (d != null) {
                this.f15585b = 343;
                this.f15586c = d.mo26711o();
                this.f15587d = d.mo26712p();
                this.f15588e = d.mo26713q();
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public void mo25841a(Setting setting, int i, String str, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("fa video show thPlacementId = ");
        sb.append(str);
        C5205o.m21462a(sb.toString());
        C5205o.m21462a("fa video show");
        C4967g thPlacementBean = setting.getThPlacementBean();
        C4911e h = thPlacementBean.mo26309h();
        RewardVideoAd rewardVideoAd = this.f15584a;
        if (rewardVideoAd != null) {
            rewardVideoAd.showAd(thPlacementBean.mo26298b());
            int i3 = i;
            String str2 = str;
            int i4 = i2;
            C5224e.m21525a().mo26909a(4, 1, "", i3, str2, setting.getPlacementId(), this.f15585b, this.f15586c, this.f15587d, this.f15588e, 0, setting.getUuid(), String.valueOf(setting.getAdType()), i4, 2, "", String.valueOf(h.f15873d), String.valueOf(h.f15874e), -1, "", "", "", "", 0, 0);
            if (setting.getIRewardAdListener() != null) {
                setting.getIRewardAdListener().onShowed();
            }
        }
    }

    /* renamed from: a */
    public void mo25842a(Setting setting, int i, String str, int i2, C4820a aVar) {
        C5205o.m21462a("fa native load");
        if (aVar != null) {
            aVar.mo25759a(setting.getThPlacementBean().mo26309h().f15875f, aVar);
        }
    }

    /* renamed from: b */
    public void mo25843b(Setting setting, int i, String str, int i2, C4820a aVar) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("fa video load th placementid = ");
            sb.append(str);
            C5205o.m21462a(sb.toString());
            m19859b();
            C5205o.m21462a("fa video load");
            if (setting != null) {
                C4967g thPlacementBean = setting.getThPlacementBean();
                final C4911e h = thPlacementBean.mo26309h();
                String c = TextUtils.isEmpty(thPlacementBean.mo26301c()) ? "lHjoJjxz" : thPlacementBean.mo26301c();
                Context b = C5233e.m21559b();
                String a = thPlacementBean.mo26294a();
                String b2 = thPlacementBean.mo26298b();
                final int i3 = i;
                final String str2 = str;
                final Setting setting2 = setting;
                final int i4 = i2;
                final C4820a aVar2 = aVar;
                C48371 r2 = new IRewardVideoAdListener() {
                };
                RewardVideoAd rewardVideoAd = new RewardVideoAd(b, a, b2, c, r2);
                try {
                    this.f15584a = rewardVideoAd;
                } catch (Throwable th) {
                    th = th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            C5205o.m21464a(th);
        }
    }
}
