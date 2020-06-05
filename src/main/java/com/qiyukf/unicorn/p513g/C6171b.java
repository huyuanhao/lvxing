package com.qiyukf.unicorn.p513g;

import android.text.TextUtils;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.RequestCallbackWrapper;
import com.qiyukf.nimlib.sdk.auth.AuthService;
import com.qiyukf.unicorn.p499b.C6014b;
import com.qiyukf.unicorn.p503f.p504a.p511e.C6153i;
import com.qiyukf.unicorn.p503f.p504a.p511e.C6161q;
import com.qiyukf.unicorn.p514h.C6185c;

/* renamed from: com.qiyukf.unicorn.g.b */
public final class C6171b {
    /* renamed from: a */
    public static void m24486a() {
        if (!C6014b.m23973n()) {
            String m = C6014b.m23970m();
            if (!TextUtils.isEmpty(m)) {
                C6153i iVar = new C6153i();
                iVar.mo29202a(m);
                C6185c.m24532a(iVar, C6185c.m24533a(), true).setCallback(new RequestCallbackWrapper<Void>() {
                    public final /* synthetic */ void onResult(int i, Object obj, Throwable th) {
                        if (i == 200) {
                            C6014b.m23946c(true);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: a */
    public static void m24487a(final boolean z) {
        C6161q qVar = new C6161q();
        qVar.mo29228a(z);
        C6185c.m24532a(qVar, C6185c.m24533a(), true).setCallback(new RequestCallbackWrapper<Void>() {
            public final /* synthetic */ void onResult(int i, Object obj, Throwable th) {
                if (i == 200 && z) {
                    ((AuthService) NIMClient.getService(AuthService.class)).changeSaverMode(2);
                }
            }
        });
    }
}
