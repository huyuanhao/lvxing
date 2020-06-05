package com.alipay.mobilesecuritysdk.face;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.face.APSecuritySdk;
import com.alipay.apmobilesecuritysdk.p103a.C1436a;
import com.alipay.p109b.p110a.p111a.p112a.C1460a;
import java.util.HashMap;
import java.util.Map;

public class SecurityClientMobile {
    public static synchronized String GetApdid(Context context, Map<String, String> map) {
        String a;
        synchronized (SecurityClientMobile.class) {
            HashMap hashMap = new HashMap();
            hashMap.put("utdid", C1460a.m4259a(map, "utdid", ""));
            hashMap.put("tid", C1460a.m4259a(map, "tid", ""));
            hashMap.put("userId", C1460a.m4259a(map, "userId", ""));
            APSecuritySdk.getInstance(context).initToken(0, hashMap, null);
            a = C1436a.m4156a(context);
        }
        return a;
    }
}
