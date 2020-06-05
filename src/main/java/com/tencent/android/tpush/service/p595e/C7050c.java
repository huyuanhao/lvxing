package com.tencent.android.tpush.service.p595e;

import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.service.C6973b;
import com.tencent.android.tpush.service.channel.security.TpnsSecurity;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.service.e.c */
public class C7050c {
    /* renamed from: a */
    public static String m30146a() {
        String str = null;
        if (C6973b.m29776f() != null) {
            try {
                str = TpnsSecurity.getBusinessDeviceId(C6973b.m29776f());
            } catch (Exception e) {
                C6864a.m29302d("ServiceLogTag", ">>get deviceid err", e);
            }
            if (str == null || str.trim().length() == 0) {
                return "";
            }
            return str;
        }
        C6864a.m29308i(Constants.ServiceLogTag, ">>> getDeviceId() > context == null");
        return null;
    }
}
