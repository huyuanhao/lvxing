package com.tencent.android.tpush.service;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.common.C6901c;
import com.tencent.android.tpush.common.C6908h;
import com.tencent.android.tpush.common.C6914l;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.service.p594d.C7046a;
import com.tencent.android.tpush.service.p595e.C7055h;
import com.tencent.android.tpush.service.p595e.C7056i;
import com.tencent.android.tpush.stat.XGPatchMonitor;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class XGPushServiceV4 extends Service {
    /* renamed from: a */
    public static long f23078a;
    /* renamed from: b */
    public static int f23079b;
    /* renamed from: c */
    public static JSONArray f23080c;
    /* renamed from: d */
    private static Boolean f23081d;
    /* renamed from: e */
    private static Service f23082e;

    public IBinder onBind(Intent intent) {
        return null;
    }

    /* renamed from: c */
    private void m29692c() {
        C6901c.m29459a().mo33104a((Runnable) new Runnable() {
            public void run() {
                Context applicationContext = XGPushServiceV4.this.getApplicationContext();
                StringBuilder sb = new StringBuilder();
                sb.append("com.tencent.android.tpush.debug,");
                sb.append(XGPushServiceV4.this.getApplicationContext().getPackageName());
                boolean z = false;
                if (C6908h.m29480a(applicationContext, sb.toString(), 0) == 1) {
                    z = true;
                }
                XGPushConfig.enableDebug = true;
                if (z) {
                    C6864a.m29282a(2);
                } else {
                    C6864a.m29282a(3);
                }
            }
        });
    }

    public void onCreate() {
        super.onCreate();
        f23078a = System.currentTimeMillis();
        f23082e = this;
        Context applicationContext = getApplicationContext();
        C6958a.m29694a().mo33264b(applicationContext);
        if (VERSION.SDK_INT < 18) {
            startForeground(-1998, new Notification());
        }
        C7046a.m30121a(applicationContext);
        C6973b.m29774d(applicationContext);
        m29692c();
        if (XGPushConfig.enableDebug) {
            StringBuilder sb = new StringBuilder();
            sb.append("Service onCreate() : ");
            sb.append(getPackageName());
            C6864a.m29305f("XGPushService", sb.toString());
        }
        C6973b.m29763a().mo33287b();
        mo33256a();
        try {
            XGPatchMonitor.onConfigAction(applicationContext, XGPushConfig.getAccessId(applicationContext), XGPatchMonitor.TypeTryDyLoad, XGPatchMonitor.ActionReadyPatch, 0, "XGPushServiceV4 load Start", null);
            Class cls = Class.forName("com.tencent.xg.trydyload_api.TryDyLoader");
            Object invoke = cls.getMethod("getInstance", new Class[]{Context.class}).invoke(null, new Object[]{applicationContext});
            cls.getMethod("doSomething", new Class[]{String.class}).invoke(invoke, new Object[]{"XGPushServiceV4 register"});
            XGPatchMonitor.onConfigAction(applicationContext, XGPushConfig.getAccessId(applicationContext), XGPatchMonitor.TypeTryDyLoad, XGPatchMonitor.ActionParsePatch, 0, "XGPushServiceV4 loaded", null);
        } catch (Throwable unused) {
            XGPatchMonitor.onConfigAction(applicationContext, XGPushConfig.getAccessId(applicationContext), XGPatchMonitor.TypeTryDyLoad, XGPatchMonitor.ActionParsePatch, 1803, "XGPushServiceV4 load failed", null);
        }
    }

    /* renamed from: a */
    public void mo33256a() {
        String str = "";
        String str2 = "XGPushService";
        String str3 = "service_state";
        try {
            String a = C7055h.m30169a(C6973b.m29776f(), str3, str);
            StringBuilder sb = new StringBuilder();
            sb.append("reportLastServiceState ");
            sb.append(a);
            C6864a.m29298c(str2, sb.toString());
            if (!C7056i.m30194b(a)) {
                C7046a.m30125a(getApplicationContext(), "SdkService", new JSONObject(a));
                C7055h.m30172b(C6973b.m29776f(), str3, str);
            }
        } catch (Throwable th) {
            C6864a.m29302d(str2, "reportLastServiceState", th);
        }
    }

    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
    }

    /* renamed from: b */
    public static Service m29691b() {
        return f23082e;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, 1, i2);
        f23079b++;
        if (f23081d == null) {
            f23081d = Boolean.valueOf(true);
        } else {
            f23081d = Boolean.valueOf(false);
        }
        if (C6914l.m29505a(getApplicationContext()) > 0) {
            C7056i.m30227u(getApplicationContext());
            return 2;
        }
        if (intent != null) {
            if (f23080c == null) {
                f23080c = new JSONArray();
            }
            String action = intent.getAction();
            if (!C7056i.m30194b(action)) {
                JSONArray jSONArray = f23080c;
                if (jSONArray != null && jSONArray.length() < 10) {
                    try {
                        action = action.replace(Constants.ACTION_PREFFIX, "");
                    } catch (Throwable unused) {
                    }
                    f23080c.put(action);
                }
            }
        }
        m29692c();
        C6973b.m29763a().mo33286a(intent);
        return 1;
    }

    public void onDestroy() {
        C6973b.m29763a().mo33288c();
        super.onDestroy();
    }
}
