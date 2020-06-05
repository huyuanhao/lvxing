package com.alipay.sdk.util;

import com.alipay.sdk.app.C1504k;
import com.alipay.sdk.app.statistic.C1505a;
import com.p522qq.p523e.comm.constants.Constants.KEYS;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.alipay.sdk.util.m */
public class C1551m {
    /* renamed from: a */
    public static Map<String, String> m4662a(String str) {
        Map<String, String> a = m4661a();
        try {
            a = m4663b(str);
            return a;
        } catch (Throwable th) {
            C1505a.m4453a(KEYS.BIZ, "FormatResultEx", th);
            return a;
        }
    }

    /* renamed from: a */
    private static Map<String, String> m4661a() {
        C1504k b = C1504k.m4445b(C1504k.CANCELED.mo12142a());
        HashMap hashMap = new HashMap();
        hashMap.put("resultStatus", Integer.toString(b.mo12142a()));
        hashMap.put("memo", b.mo12145b());
        hashMap.put(ArgKey.KEY_RESULT, "");
        return hashMap;
    }

    /* renamed from: b */
    public static Map<String, String> m4663b(String str) {
        String[] split = str.split(";");
        HashMap hashMap = new HashMap();
        for (String str2 : split) {
            String substring = str2.substring(0, str2.indexOf("={"));
            hashMap.put(substring, m4660a(str2, substring));
        }
        return hashMap;
    }

    /* renamed from: a */
    private static String m4660a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append("={");
        String sb2 = sb.toString();
        return str.substring(str.indexOf(sb2) + sb2.length(), str.lastIndexOf("}"));
    }
}
