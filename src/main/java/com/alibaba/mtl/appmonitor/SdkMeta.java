package com.alibaba.mtl.appmonitor;

import com.alibaba.mtl.log.UTDC;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.alibaba.mtl.appmonitor.e */
public class SdkMeta {
    /* renamed from: a */
    private static final Map<String, String> f3228a = new HashMap();

    /* renamed from: a */
    public static Map<String, String> m3582a() {
        UTDC.m3697c();
        String str = "sdk-version";
        if (!f3228a.containsKey(str)) {
            f3228a.put(str, "2.6.4.5_for_bc");
        }
        return f3228a;
    }

    static {
        f3228a.put("sdk-version", "2.6.4.5_for_bc");
    }
}
