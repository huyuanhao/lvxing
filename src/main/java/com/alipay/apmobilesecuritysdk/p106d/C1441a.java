package com.alipay.apmobilesecuritysdk.p106d;

import android.content.Context;
import com.alipay.p109b.p110a.p111a.p112a.C1460a;
import com.alipay.p109b.p110a.p111a.p116d.C1475a;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.alipay.apmobilesecuritysdk.d.a */
public final class C1441a {
    /* renamed from: a */
    public static synchronized Map<String, String> m4173a(Context context, Map<String, String> map) {
        HashMap hashMap;
        synchronized (C1441a.class) {
            String a = C1460a.m4259a(map, "appchannel", "");
            hashMap = new HashMap();
            hashMap.put("AA1", context.getPackageName());
            hashMap.put("AA2", C1475a.m4297a().mo12032a(context));
            hashMap.put("AA3", "APPSecuritySDK-ALIPAYSDK");
            hashMap.put("AA4", "3.3.0.1905151001");
            hashMap.put("AA6", a);
        }
        return hashMap;
    }
}
