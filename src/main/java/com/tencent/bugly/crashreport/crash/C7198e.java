package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.crashreport.common.info.C7174a;
import com.tencent.bugly.crashreport.common.info.C7175b;
import com.tencent.bugly.crashreport.common.strategy.C7177a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.C7226an;
import com.tencent.bugly.proguard.C7228ap;
import com.tencent.bugly.proguard.C7232aq;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashMap;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.crash.e */
public class C7198e implements UncaughtExceptionHandler {
    /* renamed from: h */
    private static String f24233h;
    /* renamed from: i */
    private static final Object f24234i = new Object();
    /* renamed from: a */
    protected final Context f24235a;
    /* renamed from: b */
    protected final C7190b f24236b;
    /* renamed from: c */
    protected final C7177a f24237c;
    /* renamed from: d */
    protected final C7174a f24238d;
    /* renamed from: e */
    protected UncaughtExceptionHandler f24239e;
    /* renamed from: f */
    protected UncaughtExceptionHandler f24240f;
    /* renamed from: g */
    protected boolean f24241g = false;
    /* renamed from: j */
    private int f24242j;

    public C7198e(Context context, C7190b bVar, C7177a aVar, C7174a aVar2) {
        this.f24235a = context;
        this.f24236b = bVar;
        this.f24237c = aVar;
        this.f24238d = aVar2;
    }

    /* renamed from: a */
    public synchronized void mo34710a() {
        if (this.f24242j >= 10) {
            C7226an.m31141a("java crash handler over %d, no need set.", Integer.valueOf(10));
            return;
        }
        this.f24241g = true;
        UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            if (!getClass().getName().equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                if ("com.android.internal.os.RuntimeInit$UncaughtHandler".equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                    C7226an.m31141a("backup system java handler: %s", defaultUncaughtExceptionHandler.toString());
                    this.f24240f = defaultUncaughtExceptionHandler;
                    this.f24239e = defaultUncaughtExceptionHandler;
                } else {
                    C7226an.m31141a("backup java handler: %s", defaultUncaughtExceptionHandler.toString());
                    this.f24239e = defaultUncaughtExceptionHandler;
                }
            } else {
                return;
            }
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.f24242j++;
        C7226an.m31141a("registered java monitor: %s", toString());
    }

    /* renamed from: b */
    public synchronized void mo34713b() {
        this.f24241g = false;
        C7226an.m31141a("close java monitor!", new Object[0]);
        if (Thread.getDefaultUncaughtExceptionHandler().getClass().getName().contains("bugly")) {
            C7226an.m31141a("Java monitor to unregister: %s", toString());
            Thread.setDefaultUncaughtExceptionHandler(this.f24239e);
            this.f24242j--;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo34712a(Thread thread, Throwable th) {
        C7226an.m31149e("current process die", new Object[0]);
        Process.killProcess(Process.myPid());
        System.exit(1);
    }

    /* renamed from: a */
    public CrashDetailBean mo34709a(Thread thread, Throwable th, boolean z, String str, byte[] bArr) {
        String str2;
        Throwable th2 = th;
        String str3 = str;
        byte[] bArr2 = bArr;
        boolean z2 = false;
        if (th2 == null) {
            C7226an.m31148d("We can do nothing with a null throwable.", new Object[0]);
            return null;
        }
        boolean l = C7192c.m30937a().mo34702l();
        String str4 = "";
        String str5 = (!l || !z) ? str4 : " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]";
        if (l && z) {
            C7226an.m31149e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.f24095C = C7175b.m30833i();
        crashDetailBean.f24096D = C7175b.m30829g();
        crashDetailBean.f24097E = C7175b.m30837k();
        crashDetailBean.f24098F = this.f24238d.mo34603p();
        crashDetailBean.f24099G = this.f24238d.mo34602o();
        crashDetailBean.f24100H = this.f24238d.mo34604q();
        crashDetailBean.f24138w = C7232aq.m31180a(this.f24235a, C7192c.f24191e, C7192c.f24194h);
        crashDetailBean.f24140y = C7228ap.m31160a();
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(crashDetailBean.f24140y == null ? 0 : crashDetailBean.f24140y.length);
        C7226an.m31141a("user log size:%d", objArr);
        crashDetailBean.f24117b = z ? 0 : 2;
        crashDetailBean.f24120e = this.f24238d.mo34595h();
        crashDetailBean.f24121f = this.f24238d.f24035p;
        crashDetailBean.f24122g = this.f24238d.mo34610w();
        crashDetailBean.f24128m = this.f24238d.mo34593g();
        String name = th.getClass().getName();
        String b = m30970b(th2, 1000);
        if (b == null) {
            b = str4;
        }
        Object[] objArr2 = new Object[2];
        objArr2[0] = Integer.valueOf(th.getStackTrace().length);
        objArr2[1] = Boolean.valueOf(th.getCause() != null);
        C7226an.m31149e("stack frame :%d, has cause %b", objArr2);
        String stackTraceElement = th.getStackTrace().length > 0 ? th.getStackTrace()[0].toString() : str4;
        Throwable th3 = th2;
        while (th3 != null && th3.getCause() != null) {
            th3 = th3.getCause();
        }
        if (th3 == null || th3 == th2) {
            crashDetailBean.f24129n = name;
            StringBuilder sb = new StringBuilder();
            sb.append(b);
            sb.append(str4);
            sb.append(str5);
            crashDetailBean.f24130o = sb.toString();
            if (crashDetailBean.f24130o == null) {
                crashDetailBean.f24130o = str4;
            }
            crashDetailBean.f24131p = stackTraceElement;
            str2 = m30967a(th2, C7192c.f24192f);
            crashDetailBean.f24132q = str2;
        } else {
            crashDetailBean.f24129n = th3.getClass().getName();
            crashDetailBean.f24130o = m30970b(th3, 1000);
            if (crashDetailBean.f24130o == null) {
                crashDetailBean.f24130o = str4;
            }
            if (th3.getStackTrace().length > 0) {
                crashDetailBean.f24131p = th3.getStackTrace()[0].toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(name);
            String str6 = ":";
            sb2.append(str6);
            sb2.append(b);
            String str7 = "\n";
            sb2.append(str7);
            sb2.append(stackTraceElement);
            sb2.append("\n......");
            sb2.append("\nCaused by:\n");
            sb2.append(crashDetailBean.f24129n);
            sb2.append(str6);
            sb2.append(crashDetailBean.f24130o);
            sb2.append(str7);
            str2 = m30967a(th3, C7192c.f24192f);
            sb2.append(str2);
            crashDetailBean.f24132q = sb2.toString();
        }
        crashDetailBean.f24133r = System.currentTimeMillis();
        crashDetailBean.f24136u = C7232aq.m31207b(crashDetailBean.f24132q.getBytes());
        try {
            crashDetailBean.f24141z = C7232aq.m31188a(C7192c.f24192f, false);
            crashDetailBean.f24093A = this.f24238d.f24024e;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(thread.getName());
            sb3.append("(");
            sb3.append(thread.getId());
            sb3.append(")");
            crashDetailBean.f24094B = sb3.toString();
            crashDetailBean.f24141z.put(crashDetailBean.f24094B, str2);
            crashDetailBean.f24101I = this.f24238d.mo34612y();
            crashDetailBean.f24123h = this.f24238d.mo34609v();
            crashDetailBean.f24124i = this.f24238d.mo34564J();
            crashDetailBean.f24106N = this.f24238d.f23989a;
            crashDetailBean.f24107O = this.f24238d.mo34579a();
            crashDetailBean.f24109Q = this.f24238d.mo34562H();
            crashDetailBean.f24110R = this.f24238d.mo34563I();
            crashDetailBean.f24111S = this.f24238d.mo34556B();
            crashDetailBean.f24112T = this.f24238d.mo34561G();
        } catch (Throwable th4) {
            C7226an.m31149e("handle crash error %s", th4.toString());
        }
        if (z) {
            this.f24236b.mo34682c(crashDetailBean);
        } else {
            boolean z3 = str3 != null && str.length() > 0;
            if (bArr2 != null && bArr2.length > 0) {
                z2 = true;
            }
            if (z3) {
                crashDetailBean.f24108P = new HashMap(1);
                crashDetailBean.f24108P.put("UserData", str3);
            }
            if (z2) {
                crashDetailBean.f24113U = bArr2;
            }
        }
        return crashDetailBean;
    }

    /* renamed from: a */
    private boolean m30969a(Thread thread) {
        synchronized (f24234i) {
            if (f24233h != null) {
                if (thread.getName().equals(f24233h)) {
                    return true;
                }
            }
            f24233h = thread.getName();
            return false;
        }
    }

    /* renamed from: b */
    public void mo34714b(Thread thread, Throwable th, boolean z, String str, byte[] bArr) {
        Thread thread2 = thread;
        Throwable th2 = th;
        boolean z2 = z;
        String str2 = "sys default last handle end!";
        String str3 = "sys default last handle start!";
        String str4 = "system handle end!";
        String str5 = "system handle start!";
        String str6 = "crashreport last handle end!";
        String str7 = "crashreport last handle start!";
        if (z2) {
            C7226an.m31149e("Java Crash Happen cause by %s(%d)", thread.getName(), Long.valueOf(thread.getId()));
            if (m30969a(thread)) {
                C7226an.m31141a("this class has handled this exception", new Object[0]);
                if (this.f24240f != null) {
                    C7226an.m31141a("call system handler", new Object[0]);
                    this.f24240f.uncaughtException(thread2, th2);
                } else {
                    mo34712a(thread, th);
                }
            }
        } else {
            C7226an.m31149e("Java Catch Happen", new Object[0]);
        }
        try {
            if (!this.f24241g) {
                C7226an.m31147c("Java crash handler is disable. Just return.", new Object[0]);
                if (z2) {
                    UncaughtExceptionHandler uncaughtExceptionHandler = this.f24239e;
                    if (uncaughtExceptionHandler != null && m30968a(uncaughtExceptionHandler)) {
                        C7226an.m31149e(str3, new Object[0]);
                        this.f24239e.uncaughtException(thread2, th2);
                        C7226an.m31149e(str2, new Object[0]);
                    } else if (this.f24240f != null) {
                        C7226an.m31149e(str5, new Object[0]);
                        this.f24240f.uncaughtException(thread2, th2);
                        C7226an.m31149e(str4, new Object[0]);
                    } else {
                        C7226an.m31149e(str7, new Object[0]);
                        mo34712a(thread, th);
                        C7226an.m31149e(str6, new Object[0]);
                    }
                }
                return;
            }
            if (!this.f24237c.mo34623b()) {
                C7226an.m31148d("no remote but still store!", new Object[0]);
            }
            String str8 = "JAVA_CRASH";
            String str9 = "JAVA_CATCH";
            if (!this.f24237c.mo34624c().f24057g) {
                if (this.f24237c.mo34623b()) {
                    C7226an.m31149e("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                    C7190b.m30914a(z2 ? str8 : str9, C7232aq.m31178a(), this.f24238d.f24024e, thread.getName(), C7232aq.m31183a(th), null);
                    if (z2) {
                        UncaughtExceptionHandler uncaughtExceptionHandler2 = this.f24239e;
                        if (uncaughtExceptionHandler2 != null && m30968a(uncaughtExceptionHandler2)) {
                            C7226an.m31149e(str3, new Object[0]);
                            this.f24239e.uncaughtException(thread2, th2);
                            C7226an.m31149e(str2, new Object[0]);
                        } else if (this.f24240f != null) {
                            C7226an.m31149e(str5, new Object[0]);
                            this.f24240f.uncaughtException(thread2, th2);
                            C7226an.m31149e(str4, new Object[0]);
                        } else {
                            C7226an.m31149e(str7, new Object[0]);
                            mo34712a(thread, th);
                            C7226an.m31149e(str6, new Object[0]);
                        }
                    }
                    return;
                }
            }
            CrashDetailBean a = mo34709a(thread, th, z, str, bArr);
            if (a == null) {
                C7226an.m31149e("pkg crash datas fail!", new Object[0]);
                if (z2) {
                    UncaughtExceptionHandler uncaughtExceptionHandler3 = this.f24239e;
                    if (uncaughtExceptionHandler3 != null && m30968a(uncaughtExceptionHandler3)) {
                        C7226an.m31149e(str3, new Object[0]);
                        this.f24239e.uncaughtException(thread2, th2);
                        C7226an.m31149e(str2, new Object[0]);
                    } else if (this.f24240f != null) {
                        C7226an.m31149e(str5, new Object[0]);
                        this.f24240f.uncaughtException(thread2, th2);
                        C7226an.m31149e(str4, new Object[0]);
                    } else {
                        C7226an.m31149e(str7, new Object[0]);
                        mo34712a(thread, th);
                        C7226an.m31149e(str6, new Object[0]);
                    }
                }
                return;
            }
            if (!z2) {
                str8 = str9;
            }
            C7190b.m30914a(str8, C7232aq.m31178a(), this.f24238d.f24024e, thread.getName(), C7232aq.m31183a(th), a);
            if (!this.f24236b.mo34676a(a)) {
                this.f24236b.mo34673a(a, 3000, z2);
            }
            if (z2) {
                this.f24236b.mo34681b(a);
            }
            if (z2) {
                UncaughtExceptionHandler uncaughtExceptionHandler4 = this.f24239e;
                if (uncaughtExceptionHandler4 != null && m30968a(uncaughtExceptionHandler4)) {
                    C7226an.m31149e(str3, new Object[0]);
                    this.f24239e.uncaughtException(thread2, th2);
                    C7226an.m31149e(str2, new Object[0]);
                } else if (this.f24240f != null) {
                    C7226an.m31149e(str5, new Object[0]);
                    this.f24240f.uncaughtException(thread2, th2);
                    C7226an.m31149e(str4, new Object[0]);
                } else {
                    C7226an.m31149e(str7, new Object[0]);
                    mo34712a(thread, th);
                    C7226an.m31149e(str6, new Object[0]);
                }
            }
        } catch (Throwable th3) {
            if (z2) {
                UncaughtExceptionHandler uncaughtExceptionHandler5 = this.f24239e;
                if (uncaughtExceptionHandler5 != null && m30968a(uncaughtExceptionHandler5)) {
                    C7226an.m31149e(str3, new Object[0]);
                    this.f24239e.uncaughtException(thread2, th2);
                    C7226an.m31149e(str2, new Object[0]);
                } else if (this.f24240f != null) {
                    C7226an.m31149e(str5, new Object[0]);
                    this.f24240f.uncaughtException(thread2, th2);
                    C7226an.m31149e(str4, new Object[0]);
                } else {
                    C7226an.m31149e(str7, new Object[0]);
                    mo34712a(thread, th);
                    C7226an.m31149e(str6, new Object[0]);
                }
            }
            throw th3;
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        synchronized (f24234i) {
            mo34714b(thread, th, true, null, null);
        }
    }

    /* renamed from: a */
    private boolean m30968a(UncaughtExceptionHandler uncaughtExceptionHandler) {
        StackTraceElement[] stackTrace;
        if (uncaughtExceptionHandler == null) {
            return true;
        }
        String name = uncaughtExceptionHandler.getClass().getName();
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            if (name.equals(className) && "uncaughtException".equals(methodName)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public synchronized void mo34711a(StrategyBean strategyBean) {
        if (strategyBean != null) {
            if (strategyBean.f24057g != this.f24241g) {
                C7226an.m31141a("java changed to %b", Boolean.valueOf(strategyBean.f24057g));
                if (strategyBean.f24057g) {
                    mo34710a();
                } else {
                    mo34713b();
                }
            }
        }
    }

    /* renamed from: a */
    public static String m30967a(Throwable th, int i) {
        if (th == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            if (th.getStackTrace() != null) {
                StackTraceElement[] stackTrace = th.getStackTrace();
                int length = stackTrace.length;
                int i2 = 0;
                while (i2 < length) {
                    StackTraceElement stackTraceElement = stackTrace[i2];
                    if (i <= 0 || sb.length() < i) {
                        sb.append(stackTraceElement.toString());
                        sb.append("\n");
                        i2++;
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("\n[Stack over limit size :");
                        sb2.append(i);
                        sb2.append(" , has been cutted !]");
                        sb.append(sb2.toString());
                        return sb.toString();
                    }
                }
            }
        } catch (Throwable th2) {
            C7226an.m31149e("gen stack error %s", th2.toString());
        }
        return sb.toString();
    }

    /* renamed from: b */
    public static String m30970b(Throwable th, int i) {
        if (th.getMessage() == null) {
            return "";
        }
        if (i < 0 || th.getMessage().length() <= i) {
            return th.getMessage();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(th.getMessage().substring(0, i));
        sb.append("\n[Message over limit size:");
        sb.append(i);
        sb.append(", has been cutted!]");
        return sb.toString();
    }
}
