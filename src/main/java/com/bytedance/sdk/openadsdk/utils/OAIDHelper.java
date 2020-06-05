package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.embedapplog.AppLog;
import com.bytedance.embedapplog.IOaidObserver;
import com.bytedance.embedapplog.IOaidObserver.Oaid;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.core.AdPreference;
import com.bytedance.sdk.openadsdk.core.GlobalInfo;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.p198i.TTExecutor;

/* renamed from: com.bytedance.sdk.openadsdk.utils.x */
public class OAIDHelper {
    /* access modifiers changed from: private|static|volatile */
    /* renamed from: a */
    public static volatile String f9194a = "";
    /* access modifiers changed from: private|static|volatile */
    /* renamed from: b */
    public static volatile boolean f9195b = false;

    /* compiled from: OAIDHelper */
    /* renamed from: com.bytedance.sdk.openadsdk.utils.x$a */
    private static class C2568a implements Runnable {
        /* renamed from: a */
        String f9196a;

        C2568a(String str) {
            this.f9196a = str;
        }

        public void run() {
            if (!TextUtils.isEmpty(this.f9196a)) {
                AdPreference.m9212a(InternalContainer.m10059a()).mo15322a("oaid", this.f9196a);
                StringBuilder sb = new StringBuilder();
                sb.append("oaid=");
                sb.append(this.f9196a);
                C2564t.m12220b("OAIDHelper", sb.toString());
            }
        }
    }

    static {
        try {
            if (TextUtils.isEmpty(f9194a)) {
                f9194a = AdPreference.m9212a(InternalContainer.m10059a()).mo15327b("oaid", "");
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static void m12250a(Context context) {
        try {
            AppLog.setOaidObserver(new IOaidObserver() {
                public void onOaidLoaded(Oaid oaid) {
                    try {
                        if (!TextUtils.isEmpty(oaid.f5008id)) {
                            OAIDHelper.f9195b = true;
                            OAIDHelper.f9194a = oaid.f5008id;
                            OAIDHelper.m12253c();
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static String m12248a() {
        if (TextUtils.isEmpty(f9194a) && !f9195b) {
            TTCustomController d = GlobalInfo.m9616c().mo15672d();
            if (d != null && !TextUtils.isEmpty(d.getDevOaid())) {
                f9194a = d.getDevOaid();
                m12253c();
            }
        }
        return f9194a == null ? "" : f9194a;
    }

    /* access modifiers changed from: private|static */
    /* renamed from: c */
    public static void m12253c() {
        if (!TextUtils.isEmpty(f9194a)) {
            TTExecutor.m11692a().mo16808c(new C2568a(f9194a), 5);
        }
    }
}
