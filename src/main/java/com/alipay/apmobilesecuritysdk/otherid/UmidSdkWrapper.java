package com.alipay.apmobilesecuritysdk.otherid;

import android.content.Context;
import com.alipay.p109b.p110a.p111a.p112a.C1460a;
import com.alipay.p109b.p110a.p111a.p114b.C1468d;

public class UmidSdkWrapper {
    private static final String UMIDTOKEN_FILE_NAME = "xxxwww_v2";
    private static final String UMIDTOKEN_KEY_NAME = "umidtk";
    private static volatile String cachedUmidToken = "";
    private static volatile boolean initUmidFinished = false;

    private static String compatUmidBug(Context context, String str) {
        if (!C1460a.m4260a(str) && !C1460a.m4261a(str, "000000000000000000000000")) {
            return str;
        }
        String utdid = UtdidWrapper.getUtdid(context);
        String str2 = "";
        if (utdid != null && utdid.contains("?")) {
            utdid = str2;
        }
        if (C1460a.m4260a(utdid)) {
            utdid = str2;
        }
        return utdid;
    }

    public static synchronized String getSecurityToken(Context context) {
        String str;
        synchronized (UmidSdkWrapper.class) {
            str = cachedUmidToken;
        }
        return str;
    }

    public static String startUmidTaskSync(Context context, int i) {
        return "";
    }

    private static synchronized void updateLocalUmidToken(Context context, String str) {
        synchronized (UmidSdkWrapper.class) {
            if (C1460a.m4263b(str)) {
                C1468d.m4285a(context, UMIDTOKEN_FILE_NAME, UMIDTOKEN_KEY_NAME, str);
                cachedUmidToken = str;
            }
        }
    }
}
