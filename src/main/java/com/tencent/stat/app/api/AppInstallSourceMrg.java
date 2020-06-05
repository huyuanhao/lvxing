package com.tencent.stat.app.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.stat.StatServiceImpl;
import com.tencent.stat.app.p610a.C7584a;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatLogger;

public class AppInstallSourceMrg {
    /* renamed from: a */
    private static Context f25598a;
    /* renamed from: b */
    private static AppInstallSourceMrg f25599b;
    /* renamed from: c */
    private static StatLogger f25600c = StatCommonHelper.getLogger();
    /* renamed from: d */
    private static boolean f25601d = false;

    private AppInstallSourceMrg(Context context) {
        f25598a = context;
    }

    public static boolean isEnable() {
        return f25601d;
    }

    public static void setEnable(boolean z) {
        f25601d = z;
    }

    public static AppInstallSourceMrg getInstance(Context context) {
        if (f25599b == null) {
            synchronized (AppInstallSourceMrg.class) {
                if (f25599b == null) {
                    f25599b = new AppInstallSourceMrg(context);
                }
            }
        }
        return f25599b;
    }

    public void reportAppOpenEvent(Intent intent) {
        if (intent != null) {
            m32707a(intent);
        }
    }

    public void reportInstallEvent() {
        m32707a(null);
    }

    /* renamed from: a */
    private void m32707a(Intent intent) {
        try {
            if (!f25601d) {
                f25600c.warn("App install tracking is disable.");
                return;
            }
            C7584a aVar = new C7584a(f25598a, null);
            if (intent != null) {
                aVar.mo37085a(2);
                intent.getScheme();
            }
            StatServiceImpl.reportEvent(f25598a, aVar, null);
        } catch (Throwable th) {
            StatLogger statLogger = f25600c;
            StringBuilder sb = new StringBuilder();
            sb.append("report installed error");
            sb.append(th.toString());
            statLogger.mo37103e((Object) sb.toString());
        }
    }
}
