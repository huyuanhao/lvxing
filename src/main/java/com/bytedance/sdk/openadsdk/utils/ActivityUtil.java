package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/* renamed from: com.bytedance.sdk.openadsdk.utils.b */
public class ActivityUtil {

    /* compiled from: ActivityUtil */
    /* renamed from: com.bytedance.sdk.openadsdk.utils.b$a */
    public interface C2540a {
        /* renamed from: a */
        void mo14890a();

        /* renamed from: a */
        void mo14891a(Throwable th);
    }

    /* renamed from: a */
    public static void m12108a(Context context, Intent intent, C2540a aVar) {
        if (context != null && intent != null) {
            try {
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                context.startActivity(intent);
                if (aVar != null) {
                    aVar.mo14890a();
                }
            } catch (Throwable th) {
                if (aVar != null) {
                    aVar.mo14891a(th);
                }
            }
        }
    }
}
