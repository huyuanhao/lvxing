package com.p368pw.inner.p369a;

import com.p368pw.inner.appwall.C4970aa;
import com.p368pw.inner.base.p386c.C5143a;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.p369a.p370a.p371a.C4831i;
import com.p368pw.inner.p369a.p370a.p372b.C4836a;
import com.p368pw.inner.p369a.p370a.p373c.C4857j;
import com.p368pw.p392us.Setting;

/* renamed from: com.pw.inner.a.a */
public class C4819a {
    /* renamed from: a */
    private static volatile C4819a f15486a;

    /* renamed from: com.pw.inner.a.a$a */
    public interface C4820a {
        /* renamed from: a */
        void mo25759a(int i, C4820a aVar);
    }

    private C4819a() {
    }

    /* renamed from: a */
    public static C4819a m19687a() {
        if (f15486a == null) {
            synchronized (C4819a.class) {
                if (f15486a == null) {
                    C4819a aVar = new C4819a();
                    return aVar;
                }
            }
        }
        return f15486a;
    }

    /* renamed from: a */
    private void m19688a(Setting setting, String str) {
        if (setting.getAdType() == 1 && setting.getAdListener() != null) {
            setting.getAdListener().onError(str);
        }
        if (setting.getAdType() == 3 && setting.getIRewardAdListener() != null) {
            setting.getIRewardAdListener().onError(str);
        }
        if ((setting.getAdType() == 2 || setting.getAdType() == 4) && setting.getInterstitialListener() != null) {
            setting.getInterstitialListener().onError(str);
        }
        if (setting.getAdType() == 5 && setting.getSplashAdListener() != null) {
            setting.getSplashAdListener().onError(str);
        }
        if (setting.getAdType() == 106 && setting.getAppwallListener() != null) {
            setting.getAppwallListener().onError(str);
        }
    }

    /* renamed from: b */
    private void m19689b(Setting setting, int i, String str, int i2, C4820a aVar) {
        C5205o.m21462a("app wall load");
        C4970aa.m20784a().mo26324a(setting, i, str, i2, aVar);
    }

    /* renamed from: c */
    private void m19690c(Setting setting, int i, String str, int i2, C4820a aVar) {
        C5205o.m21461a();
        if (i == 5) {
            C4857j.m19935a().mo25879d(setting, i, str, i2, aVar);
        } else if (i == 3 || i == 4 || i == 6 || i == 8) {
            C4831i.m19813d(setting, i, str, i2, aVar);
        } else {
            m19688a(setting, "unkown ads source.");
        }
    }

    /* renamed from: d */
    private void m19691d(Setting setting, int i, String str, int i2, C4820a aVar) {
        C5205o.m21462a("native load");
        if (i == 5) {
            C4857j.m19935a().mo25877b(setting, i, str, i2, aVar);
        } else if (i == 3 || i == 4 || i == 6 || i == 8) {
            C4831i.m19807b(setting, i, str, i2, aVar);
        } else if (i == 7) {
            C4836a.m19858a().mo25842a(setting, i, str, i2, aVar);
        } else {
            m19688a(setting, "unkown ads source.");
        }
    }

    /* renamed from: e */
    private void m19692e(Setting setting, int i, String str, int i2, C4820a aVar) {
        C5205o.m21462a("reward loadRewardVideo");
        if (i == 3 || i == 4 || i == 6 || i == 8) {
            C4831i.m19802a(setting, i, str, i2, aVar);
        } else if (i == 5) {
            C4857j.m19935a().mo25873a(setting, i, str, i2, aVar);
        } else if (i == 7) {
            C4836a.m19858a().mo25843b(setting, i, str, i2, aVar);
        } else {
            m19688a(setting, "unkown ads source.");
        }
    }

    /* renamed from: f */
    private void m19693f(Setting setting, int i, String str, int i2, C4820a aVar) {
        C5205o.m21461a();
        if (i == 5) {
            C4857j.m19935a().mo25878c(setting, i, str, i2, aVar);
        } else if (i == 3 || i == 4 || i == 6 || i == 8) {
            C4831i.m19810c(setting, i, str, i2, aVar);
        } else {
            m19688a(setting, "unkown ads source.");
        }
    }

    /* renamed from: a */
    public void mo25758a(Setting setting, int i, String str, int i2, C4820a aVar) {
        C5205o.m21461a();
        if (setting.getAdType() == 3) {
            m19692e(setting, i, str, i2, aVar);
        } else if (setting.getAdType() == 1) {
            m19691d(setting, i, str, i2, aVar);
        } else if (setting.getAdType() == 2 || setting.getAdType() == 4) {
            m19693f(setting, i, str, i2, aVar);
        } else if (setting.getAdType() == 5) {
            m19690c(setting, i, str, i2, aVar);
        } else if (setting.getAdType() == 106) {
            m19689b(setting, i, str, i2, aVar);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("unkown adType:");
            sb.append(setting.getAdType());
            throw new C5143a(sb.toString());
        }
    }
}
