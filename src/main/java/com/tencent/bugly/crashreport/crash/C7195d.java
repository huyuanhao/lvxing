package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.crashreport.common.info.C7174a;
import com.tencent.bugly.crashreport.common.info.C7175b;
import com.tencent.bugly.crashreport.common.strategy.C7177a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.C7224am;
import com.tencent.bugly.proguard.C7226an;
import com.tencent.bugly.proguard.C7228ap;
import com.tencent.bugly.proguard.C7232aq;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.crash.d */
public class C7195d {
    /* access modifiers changed from: private|static */
    /* renamed from: a */
    public static C7195d f24221a;
    /* renamed from: b */
    private C7177a f24222b;
    /* renamed from: c */
    private C7174a f24223c;
    /* renamed from: d */
    private C7190b f24224d;
    /* renamed from: e */
    private Context f24225e;

    private C7195d(Context context) {
        C7192c a = C7192c.m30937a();
        if (a != null) {
            this.f24222b = C7177a.m30857a();
            this.f24223c = C7174a.m30753a(context);
            this.f24224d = a.f24203p;
            this.f24225e = context;
            C7224am.m31132a().mo34832a(new Runnable() {
                public void run() {
                    C7195d.this.m30965b();
                }
            });
        }
    }

    /* renamed from: a */
    public static C7195d m30960a(Context context) {
        if (f24221a == null) {
            f24221a = new C7195d(context);
        }
        return f24221a;
    }

    /* renamed from: a */
    public static void m30963a(Thread thread, int i, String str, String str2, String str3, Map<String, String> map) {
        C7224am a = C7224am.m31132a();
        final Thread thread2 = thread;
        final int i2 = i;
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        final Map<String, String> map2 = map;
        C71972 r1 = new Runnable() {
            public void run() {
                try {
                    if (C7195d.f24221a == null) {
                        C7226an.m31149e("[ExtraCrashManager] Extra crash manager has not been initialized.", new Object[0]);
                    } else {
                        C7195d.f24221a.m30966c(thread2, i2, str4, str5, str6, map2);
                    }
                } catch (Throwable th) {
                    if (!C7226an.m31145b(th)) {
                        th.printStackTrace();
                    }
                    C7226an.m31149e("[ExtraCrashManager] Crash error %s %s %s", str4, str5, str6);
                }
            }
        };
        a.mo34832a(r1);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m30965b() {
        C7226an.m31147c("[ExtraCrashManager] Trying to notify Bugly agents.", new Object[0]);
        try {
            this.f24223c.getClass();
            C7232aq.m31192a(Class.forName("com.tencent.bugly.proguard.o"), "sdkPackageName", (Object) "com.tencent.bugly", (Object) null);
            C7226an.m31147c("[ExtraCrashManager] Bugly game agent has been notified.", new Object[0]);
        } catch (Throwable unused) {
            C7226an.m31141a("[ExtraCrashManager] no game agent", new Object[0]);
        }
    }

    /* renamed from: b */
    private CrashDetailBean m30964b(Thread thread, int i, String str, String str2, String str3, Map<String, String> map) {
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.f24095C = C7175b.m30833i();
        crashDetailBean.f24096D = C7175b.m30829g();
        crashDetailBean.f24097E = C7175b.m30837k();
        crashDetailBean.f24098F = this.f24223c.mo34603p();
        crashDetailBean.f24099G = this.f24223c.mo34602o();
        crashDetailBean.f24100H = this.f24223c.mo34604q();
        crashDetailBean.f24138w = C7232aq.m31180a(this.f24225e, C7192c.f24191e, C7192c.f24194h);
        crashDetailBean.f24117b = i;
        crashDetailBean.f24120e = this.f24223c.mo34595h();
        crashDetailBean.f24121f = this.f24223c.f24035p;
        crashDetailBean.f24122g = this.f24223c.mo34610w();
        crashDetailBean.f24128m = this.f24223c.mo34593g();
        StringBuilder sb = new StringBuilder();
        String str4 = "";
        sb.append(str4);
        sb.append(str);
        crashDetailBean.f24129n = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str4);
        sb2.append(str2);
        crashDetailBean.f24130o = sb2.toString();
        if (str3 != null) {
            String[] split = str3.split("\n");
            if (split.length > 0) {
                str4 = split[0];
            }
        } else {
            str3 = str4;
        }
        crashDetailBean.f24131p = str4;
        crashDetailBean.f24132q = str3;
        crashDetailBean.f24133r = System.currentTimeMillis();
        crashDetailBean.f24136u = C7232aq.m31207b(crashDetailBean.f24132q.getBytes());
        crashDetailBean.f24141z = C7232aq.m31188a(C7192c.f24192f, false);
        crashDetailBean.f24093A = this.f24223c.f24024e;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(thread.getName());
        sb3.append("(");
        sb3.append(thread.getId());
        sb3.append(")");
        crashDetailBean.f24094B = sb3.toString();
        crashDetailBean.f24101I = this.f24223c.mo34612y();
        crashDetailBean.f24123h = this.f24223c.mo34609v();
        crashDetailBean.f24106N = this.f24223c.f23989a;
        crashDetailBean.f24107O = this.f24223c.mo34579a();
        crashDetailBean.f24109Q = this.f24223c.mo34562H();
        crashDetailBean.f24110R = this.f24223c.mo34563I();
        crashDetailBean.f24111S = this.f24223c.mo34556B();
        crashDetailBean.f24112T = this.f24223c.mo34561G();
        this.f24224d.mo34682c(crashDetailBean);
        crashDetailBean.f24140y = C7228ap.m31160a();
        if (crashDetailBean.f24108P == null) {
            crashDetailBean.f24108P = new LinkedHashMap();
        }
        if (map != null) {
            crashDetailBean.f24108P.putAll(map);
        }
        return crashDetailBean;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m30966c(Thread thread, int i, String str, String str2, String str3, Map<String, String> map) {
        Thread thread2;
        String str4;
        int i2 = i;
        String str5 = str;
        String str6 = str2;
        String str7 = str3;
        String str8 = "[ExtraCrashManager] Successfully handled.";
        if (thread == null) {
            thread2 = Thread.currentThread();
        } else {
            thread2 = thread;
        }
        if (i2 == 4) {
            str4 = "Unity";
        } else if (i2 == 5 || i2 == 6) {
            str4 = "Cocos";
        } else if (i2 != 8) {
            C7226an.m31148d("[ExtraCrashManager] Unknown extra crash type: %d", Integer.valueOf(i));
            return;
        } else {
            str4 = "H5";
        }
        String str9 = str4;
        C7226an.m31149e("[ExtraCrashManager] %s Crash Happen", str9);
        try {
            if (!this.f24222b.mo34623b()) {
                C7226an.m31148d("[ExtraCrashManager] There is no remote strategy, but still store it.", new Object[0]);
            }
            StrategyBean c = this.f24222b.mo34624c();
            String str10 = "\n";
            if (!c.f24057g) {
                if (this.f24222b.mo34623b()) {
                    C7226an.m31149e("[ExtraCrashManager] Crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                    String a = C7232aq.m31178a();
                    String str11 = this.f24223c.f24024e;
                    String name = thread2.getName();
                    StringBuilder sb = new StringBuilder();
                    sb.append(str5);
                    sb.append(str10);
                    sb.append(str6);
                    sb.append(str10);
                    sb.append(str7);
                    C7190b.m30914a(str9, a, str11, name, sb.toString(), null);
                    C7226an.m31149e(str8, new Object[0]);
                    return;
                }
            }
            if (i2 != 4) {
                String str12 = "[ExtraCrashManager] %s report is disabled.";
                if (i2 == 5 || i2 == 6) {
                    if (!c.f24062l) {
                        C7226an.m31149e(str12, str9);
                        C7226an.m31149e(str8, new Object[0]);
                        return;
                    }
                } else if (i2 == 8) {
                    if (!c.f24063m) {
                        C7226an.m31149e(str12, str9);
                        C7226an.m31149e(str8, new Object[0]);
                        return;
                    }
                }
            }
            int i3 = i2 == 8 ? 5 : i2;
            String str13 = str10;
            CrashDetailBean b = m30964b(thread2, i3, str, str2, str3, map);
            if (b == null) {
                C7226an.m31149e("[ExtraCrashManager] Failed to package crash data.", new Object[0]);
                C7226an.m31149e(str8, new Object[0]);
                return;
            }
            String a2 = C7232aq.m31178a();
            String str14 = this.f24223c.f24024e;
            String name2 = thread2.getName();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str5);
            sb2.append(str13);
            sb2.append(str6);
            sb2.append(str13);
            sb2.append(str7);
            C7190b.m30914a(str9, a2, str14, name2, sb2.toString(), b);
            if (!this.f24224d.mo34676a(b)) {
                this.f24224d.mo34673a(b, 3000, false);
            }
            C7226an.m31149e(str8, new Object[0]);
        } catch (Throwable th) {
            C7226an.m31149e(str8, new Object[0]);
            throw th;
        }
    }
}
