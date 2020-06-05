package com.tencent.android.tpush.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.android.tpush.p580b.C6864a;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.common.a */
public class C6896a {
    /* renamed from: a */
    private static volatile C6899b f22969a;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.common.a$a */
    private static class C6898a implements Runnable {
        /* renamed from: a */
        private Context f22970a = null;
        /* renamed from: b */
        private Intent f22971b = null;

        public C6898a(Context context, Intent intent) {
            this.f22970a = context;
            this.f22971b = intent;
        }

        public void run() {
            String action = this.f22971b.getAction();
            if (action != null && !"android.intent.action.PACKAGE_ADDED".equals(action) && !"android.intent.action.PACKAGE_REPLACED".equals(action)) {
                "android.intent.action.PACKAGE_REMOVED".equals(action);
            }
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.common.a$b */
    private static class C6899b extends BroadcastReceiver {
        private C6899b() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && context != null) {
                C6901c.m29459a().mo33104a((Runnable) new C6898a(context, intent));
            }
        }
    }

    /* renamed from: a */
    public static void m29454a(Context context) {
        try {
            if (f22969a == null) {
                synchronized (C6896a.class) {
                    if (f22969a == null) {
                        f22969a = new C6899b();
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addDataScheme("package");
                        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
                        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
                        context.getApplicationContext().registerReceiver(f22969a, intentFilter);
                    }
                }
            }
        } catch (Exception e) {
            C6864a.m29302d(Constants.LogTag, "AppChangesHandler setupHandler error", e);
        }
    }
}
