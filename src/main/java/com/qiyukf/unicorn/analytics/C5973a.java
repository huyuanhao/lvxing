package com.qiyukf.unicorn.analytics;

import android.content.Context;
import android.util.Log;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p393a.C5268c;
import com.qiyukf.basesdk.p412c.C5366b;
import com.qiyukf.basesdk.p412c.p416c.C5405c;
import com.qiyukf.nimlib.C5743d;
import com.qiyukf.unicorn.p503f.C6168c;
import com.tencent.stat.common.DeviceInfo;
import java.io.File;
import org.json.JSONObject;

/* renamed from: com.qiyukf.unicorn.analytics.a */
public final class C5973a {
    /* renamed from: a */
    static final String f18807a;
    /* renamed from: b */
    private static Context f18808b;

    /* renamed from: com.qiyukf.unicorn.analytics.a$a */
    private static abstract class C5976a implements Runnable {
        private C5976a() {
        }

        /* synthetic */ C5976a(byte b) {
            this();
        }

        /* renamed from: a */
        public abstract void mo28539a();

        public final void run() {
            try {
                mo28539a();
            } catch (Throwable th) {
                C5264a.m21621b("Analytics", "run is error", th);
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.qiyukf.unicorn.analytics.a$b */
    enum C5977b {
        invite,
        crash,
        exception
    }

    static {
        String str = C5743d.m23121f() ? DeviceInfo.TAG_IMEI : C5743d.m23122g() ? "core" : null;
        StringBuilder sb = new StringBuilder("Analytics-");
        sb.append(str);
        f18807a = sb.toString();
    }

    /* renamed from: a */
    public static void m23882a(Context context) {
        try {
            if (!m23886a()) {
                f18808b = context.getApplicationContext();
                C5264a.m21617a(f18807a, "init");
                if (C5743d.m23122g()) {
                    C5978b.m23896a(f18808b);
                    String str = f18807a;
                    StringBuilder sb = new StringBuilder("log analytics switch is ");
                    sb.append(C5978b.m23898a() ? "on" : "off");
                    C5264a.m21617a(str, sb.toString());
                    if (C5978b.m23901b()) {
                        m23883a((Runnable) new C5976a() {
                            /* renamed from: a */
                            public final void mo28539a() {
                                C5973a.m23890c();
                            }
                        });
                    }
                    AnalyticsService.m23880a(context);
                }
            }
        } catch (Throwable th) {
            C5264a.m21621b("Analytics", "init is error", th);
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    private static void m23883a(Runnable runnable) {
        new Thread(runnable).start();
    }

    /* renamed from: a */
    public static void m23884a(Throwable th) {
        m23889b(th, C5977b.exception);
    }

    /* renamed from: a */
    static void m23885a(Throwable th, C5977b bVar) {
        C5268c a = C5264a.m21615a();
        if (a != null) {
            String a2 = a.mo27108a();
            String a3 = C5405c.m22113a(Log.getStackTraceString(th).trim());
            StringBuilder sb = new StringBuilder();
            sb.append(a2);
            sb.append("analytics/");
            sb.append(a3);
            sb.append("/");
            String sb2 = sb.toString();
            File file = new File(sb2);
            if (!file.exists()) {
                file.mkdirs();
            }
            C5979c.m23909a(sb2, th, bVar);
        }
    }

    /* renamed from: a */
    static boolean m23886a() {
        return f18808b != null;
    }

    /* renamed from: b */
    public static void m23887b() {
        try {
            if (C5743d.m23121f()) {
                m23883a((Runnable) new C5976a() {
                    /* renamed from: a */
                    public final void mo28539a() {
                        C5979c.m23910b();
                    }
                });
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C5264a.m21621b("Analytics", "inviteUpload is error", th);
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    public static void m23888b(Throwable th) {
        m23889b(th, C5977b.crash);
    }

    /* renamed from: b */
    private static void m23889b(Throwable th, C5977b bVar) {
        try {
            if (m23886a()) {
                if (!C5743d.m23122g() || bVar != C5977b.crash) {
                    if (C5743d.m23121f() || (C5743d.m23122g() && bVar != C5977b.crash)) {
                        AnalyticsService.m23881a(f18808b, th, bVar);
                    }
                    return;
                }
                m23885a(th, bVar);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
            C5264a.m21621b("Analytics", "error", th2);
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m23890c() {
        JSONObject a = C6168c.m24476a();
        if (a != null) {
            long c = C5366b.m22037c(a, "distinctPeriod");
            float d = (float) C5366b.m22038d(a, "samplingRate");
            String str = f18807a;
            StringBuilder sb = new StringBuilder("fetch config: ");
            sb.append(a.toString());
            C5264a.m21617a(str, sb.toString());
            C5978b.m23895a(c);
            C5978b.m23894a(d);
            C5978b.m23902c();
        }
    }
}
