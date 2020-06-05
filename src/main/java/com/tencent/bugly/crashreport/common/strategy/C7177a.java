package com.tencent.bugly.crashreport.common.strategy;

import android.content.Context;
import android.os.Parcelable;
import com.tencent.bugly.C8712a;
import com.tencent.bugly.crashreport.biz.C7170b;
import com.tencent.bugly.crashreport.common.info.C7174a;
import com.tencent.bugly.proguard.C7211ad;
import com.tencent.bugly.proguard.C7212ae;
import com.tencent.bugly.proguard.C7215ag;
import com.tencent.bugly.proguard.C7224am;
import com.tencent.bugly.proguard.C7226an;
import com.tencent.bugly.proguard.C7232aq;
import com.tencent.bugly.proguard.C7253bk;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.common.strategy.a */
public class C7177a {
    /* renamed from: a */
    public static int f24076a = 1000;
    /* renamed from: b */
    public static long f24077b = 259200000;
    /* renamed from: c */
    private static C7177a f24078c;
    /* access modifiers changed from: private|static */
    /* renamed from: i */
    public static String f24079i;
    /* renamed from: d */
    private final List<C8712a> f24080d;
    /* renamed from: e */
    private final C7224am f24081e;
    /* renamed from: f */
    private final StrategyBean f24082f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public StrategyBean f24083g = null;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public Context f24084h;

    protected C7177a(Context context, List<C8712a> list) {
        this.f24084h = context;
        this.f24082f = new StrategyBean();
        this.f24080d = list;
        this.f24081e = C7224am.m31132a();
    }

    /* renamed from: a */
    public static synchronized C7177a m30858a(Context context, List<C8712a> list) {
        C7177a aVar;
        synchronized (C7177a.class) {
            if (f24078c == null) {
                f24078c = new C7177a(context, list);
            }
            aVar = f24078c;
        }
        return aVar;
    }

    /* renamed from: a */
    public void mo34620a(long j) {
        this.f24081e.mo34833a(new Thread() {
            public void run() {
                try {
                    Map a = C7212ae.m31041a().mo34779a(C7177a.f24076a, (C7211ad) null, true);
                    if (a != null) {
                        byte[] bArr = (byte[]) a.get("device");
                        byte[] bArr2 = (byte[]) a.get("gateway");
                        if (bArr != null) {
                            C7174a.m30753a(C7177a.this.f24084h).mo34590e(new String(bArr));
                        }
                        if (bArr2 != null) {
                            C7174a.m30753a(C7177a.this.f24084h).mo34588d(new String(bArr2));
                        }
                    }
                    C7177a.this.f24083g = C7177a.this.mo34625d();
                    if (C7177a.this.f24083g != null && !C7232aq.m31196a(C7177a.f24079i) && C7232aq.m31221c(C7177a.f24079i)) {
                        C7177a.this.f24083g.f24068r = C7177a.f24079i;
                        C7177a.this.f24083g.f24069s = C7177a.f24079i;
                    }
                } catch (Throwable th) {
                    if (!C7226an.m31142a(th)) {
                        th.printStackTrace();
                    }
                }
                C7177a aVar = C7177a.this;
                aVar.mo34621a(aVar.f24083g, false);
            }
        }, j);
    }

    /* renamed from: a */
    public static synchronized C7177a m30857a() {
        C7177a aVar;
        synchronized (C7177a.class) {
            aVar = f24078c;
        }
        return aVar;
    }

    /* renamed from: b */
    public synchronized boolean mo34623b() {
        return this.f24083g != null;
    }

    /* renamed from: c */
    public StrategyBean mo34624c() {
        StrategyBean strategyBean = this.f24083g;
        if (strategyBean != null) {
            return strategyBean;
        }
        return this.f24082f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo34621a(StrategyBean strategyBean, boolean z) {
        String str = "[Strategy] Notify %s";
        C7226an.m31147c(str, C7170b.class.getName());
        C7170b.m30716a(strategyBean, z);
        for (C8712a aVar : this.f24080d) {
            try {
                C7226an.m31147c(str, aVar.getClass().getName());
                aVar.onServerStrategyChanged(strategyBean);
            } catch (Throwable th) {
                if (!C7226an.m31142a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    public static void m30859a(String str) {
        if (C7232aq.m31196a(str) || !C7232aq.m31221c(str)) {
            C7226an.m31148d("URL user set is invalid.", new Object[0]);
            return;
        }
        f24079i = str;
    }

    /* renamed from: a */
    public void mo34622a(C7253bk bkVar) {
        if (bkVar != null) {
            if (this.f24083g == null || bkVar.f24532h != this.f24083g.f24066p) {
                StrategyBean strategyBean = new StrategyBean();
                strategyBean.f24057g = bkVar.f24525a;
                strategyBean.f24059i = bkVar.f24527c;
                strategyBean.f24058h = bkVar.f24526b;
                if (C7232aq.m31196a(f24079i) || !C7232aq.m31221c(f24079i)) {
                    if (C7232aq.m31221c(bkVar.f24528d)) {
                        C7226an.m31147c("[Strategy] Upload url changes to %s", bkVar.f24528d);
                        strategyBean.f24068r = bkVar.f24528d;
                    }
                    if (C7232aq.m31221c(bkVar.f24529e)) {
                        C7226an.m31147c("[Strategy] Exception upload url changes to %s", bkVar.f24529e);
                        strategyBean.f24069s = bkVar.f24529e;
                    }
                }
                if (bkVar.f24530f != null && !C7232aq.m31196a(bkVar.f24530f.f24520a)) {
                    strategyBean.f24071u = bkVar.f24530f.f24520a;
                }
                if (bkVar.f24532h != 0) {
                    strategyBean.f24066p = bkVar.f24532h;
                }
                if (bkVar.f24531g != null && bkVar.f24531g.size() > 0) {
                    strategyBean.f24072v = bkVar.f24531g;
                    String str = (String) bkVar.f24531g.get("B11");
                    String str2 = "1";
                    if (str == null || !str.equals(str2)) {
                        strategyBean.f24060j = false;
                    } else {
                        strategyBean.f24060j = true;
                    }
                    String str3 = (String) bkVar.f24531g.get("B3");
                    if (str3 != null) {
                        strategyBean.f24075y = Long.valueOf(str3).longValue();
                    }
                    strategyBean.f24067q = (long) bkVar.f24536l;
                    strategyBean.f24074x = (long) bkVar.f24536l;
                    String str4 = (String) bkVar.f24531g.get("B27");
                    if (str4 != null && str4.length() > 0) {
                        try {
                            int parseInt = Integer.parseInt(str4);
                            if (parseInt > 0) {
                                strategyBean.f24073w = parseInt;
                            }
                        } catch (Exception e) {
                            if (!C7226an.m31142a(e)) {
                                e.printStackTrace();
                            }
                        }
                    }
                    String str5 = (String) bkVar.f24531g.get("B25");
                    if (str5 == null || !str5.equals(str2)) {
                        strategyBean.f24062l = false;
                    } else {
                        strategyBean.f24062l = true;
                    }
                }
                C7226an.m31141a("[Strategy] enableCrashReport:%b, enableQuery:%b, enableUserInfo:%b, enableAnr:%b, enableBlock:%b, enableSession:%b, enableSessionTimer:%b, sessionOverTime:%d, enableCocos:%b, strategyLastUpdateTime:%d", Boolean.valueOf(strategyBean.f24057g), Boolean.valueOf(strategyBean.f24059i), Boolean.valueOf(strategyBean.f24058h), Boolean.valueOf(strategyBean.f24060j), Boolean.valueOf(strategyBean.f24061k), Boolean.valueOf(strategyBean.f24064n), Boolean.valueOf(strategyBean.f24065o), Long.valueOf(strategyBean.f24067q), Boolean.valueOf(strategyBean.f24062l), Long.valueOf(strategyBean.f24066p));
                this.f24083g = strategyBean;
                C7212ae.m31041a().mo34786b(2);
                C7215ag agVar = new C7215ag();
                agVar.f24331b = 2;
                agVar.f24330a = strategyBean.f24055e;
                agVar.f24334e = strategyBean.f24056f;
                agVar.f24336g = C7232aq.m31199a((Parcelable) strategyBean);
                C7212ae.m31041a().mo34783a(agVar);
                mo34621a(strategyBean, true);
            }
        }
    }

    /* renamed from: d */
    public StrategyBean mo34625d() {
        List a = C7212ae.m31041a().mo34778a(2);
        if (a != null && a.size() > 0) {
            C7215ag agVar = (C7215ag) a.get(0);
            if (agVar.f24336g != null) {
                return (StrategyBean) C7232aq.m31177a(agVar.f24336g, StrategyBean.CREATOR);
            }
        }
        return null;
    }
}
