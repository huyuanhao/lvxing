package com.tencent.dynamicbundle.local;

import android.content.Context;
import com.tencent.dynamicbundle.DynamicBundleConfig;
import com.tencent.dynamicbundle.DynamicBundleStatus;
import com.tencent.dynamicbundle.p604a.C7285b;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.dynamicbundle.local.c */
public class C7288c {
    /* renamed from: a */
    private static C7288c f24687a;

    /* renamed from: a */
    public static synchronized C7288c m31459a() {
        C7288c cVar;
        synchronized (C7288c.class) {
            if (f24687a == null) {
                f24687a = new C7288c();
            }
            cVar = f24687a;
        }
        return cVar;
    }

    /* renamed from: a */
    public boolean mo35001a(String str) {
        Context context = DynamicBundleStatus.getInstance().AppContext;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_ccConfig");
        String a = C7285b.m31451a(context, sb.toString(), (String) null);
        if (a != null) {
            try {
                return new JSONObject(a).getBoolean("enable");
            } catch (Exception unused) {
            }
        }
        return true;
    }

    /* renamed from: b */
    public boolean mo35002b(String str) {
        if (C7285b.m31449a(DynamicBundleStatus.getInstance().AppContext, str, 0) <= DynamicBundleConfig.retryLoadDexNum) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public void mo35003c(String str) {
        Context context = DynamicBundleStatus.getInstance().AppContext;
        C7285b.m31452b(context, str, C7285b.m31449a(context, str, 0) + 1);
    }
}
