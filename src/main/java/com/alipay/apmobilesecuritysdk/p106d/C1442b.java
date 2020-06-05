package com.alipay.apmobilesecuritysdk.p106d;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.p107e.C1453h;
import com.alipay.p109b.p110a.p111a.p112a.C1460a;
import com.tencent.p605ep.commonbase.software.AppEntity;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.alipay.apmobilesecuritysdk.d.b */
public final class C1442b {
    /* renamed from: a */
    public static synchronized Map<String, String> m4174a(Context context, Map<String, String> map) {
        HashMap hashMap;
        synchronized (C1442b.class) {
            hashMap = new HashMap();
            String a = C1460a.m4259a(map, "tid", "");
            String a2 = C1460a.m4259a(map, "utdid", "");
            String a3 = C1460a.m4259a(map, "userId", "");
            String a4 = C1460a.m4259a(map, AppEntity.KEY_APP_NAME_STR, "");
            String a5 = C1460a.m4259a(map, "appKeyClient", "");
            String a6 = C1460a.m4259a(map, "tmxSessionId", "");
            String f = C1453h.m4225f(context);
            String a7 = C1460a.m4259a(map, "sessionId", "");
            hashMap.put("AC1", a);
            hashMap.put("AC2", a2);
            hashMap.put("AC3", "");
            hashMap.put("AC4", f);
            hashMap.put("AC5", a3);
            hashMap.put("AC6", a6);
            hashMap.put("AC7", "");
            hashMap.put("AC8", a4);
            hashMap.put("AC9", a5);
            if (C1460a.m4263b(a7)) {
                hashMap.put("AC10", a7);
            }
        }
        return hashMap;
    }
}
