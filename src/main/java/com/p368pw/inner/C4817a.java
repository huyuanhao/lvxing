package com.p368pw.inner;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.p368pw.inner.appwall.C4970aa;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.p369a.p370a.p371a.C4827e;
import com.p368pw.inner.p369a.p379e.C4933e.C4940a;
import com.p368pw.inner.p369a.p379e.C4958h;
import java.util.HashMap;

/* renamed from: com.pw.inner.a */
public class C4817a {
    /* access modifiers changed from: private|static|final */
    /* renamed from: a */
    public static final HashMap<String, BroadcastReceiver> f15481a = new HashMap<>();

    /* renamed from: a */
    public static void m19685a(Context context, final String str, final C4958h hVar, final C4827e eVar, final C4940a aVar) {
        try {
            if (f15481a.get(str) != null) {
                C5205o.m21462a("bm had rg bd");
                return;
            }
            IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
            intentFilter.addDataScheme("package");
            C48181 r1 = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    try {
                        if (!C4970aa.m20784a().mo26329b() || hVar.mo26247s()) {
                            if ("android.intent.action.PACKAGE_ADDED".equals(intent.getAction())) {
                                String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                                StringBuilder sb = new StringBuilder();
                                sb.append("listen installed pkgname = ");
                                sb.append(schemeSpecificPart);
                                sb.append(", param pkgname = ");
                                sb.append(str);
                                C5205o.m21462a(sb.toString());
                                if (str.equals(schemeSpecificPart) || str.contains(schemeSpecificPart)) {
                                    C5069b.m21115a().mo26582a(schemeSpecificPart);
                                    String str = "";
                                    if (eVar != null) {
                                        eVar.mo25795b(schemeSpecificPart, str);
                                    }
                                    if (aVar != null) {
                                        aVar.mo26163a(schemeSpecificPart, str);
                                    }
                                    context.getApplicationContext().unregisterReceiver(this);
                                    C4817a.f15481a.remove(str);
                                }
                            }
                            return;
                        }
                        C5205o.m21462a("app wall is open, other no listener ins");
                    } catch (Throwable th) {
                        C5205o.m21464a(th);
                    }
                }
            };
            context.getApplicationContext().registerReceiver(r1, intentFilter);
            f15481a.put(str, r1);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: a */
    public static void m19686a(String str) {
        BroadcastReceiver broadcastReceiver = (BroadcastReceiver) f15481a.remove(str);
        if (broadcastReceiver != null) {
            C5233e.m21559b().unregisterReceiver(broadcastReceiver);
        }
    }
}
