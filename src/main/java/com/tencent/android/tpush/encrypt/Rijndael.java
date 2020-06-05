package com.tencent.android.tpush.encrypt;

import com.tencent.android.tpush.service.channel.security.TpnsSecurity;
import com.tencent.android.tpush.service.p595e.C7056i;

/* compiled from: ProGuard */
public class Rijndael {
    public static String encrypt(String str) {
        if (!C7056i.m30194b(str)) {
            String oiSymmetryEncrypt2 = TpnsSecurity.oiSymmetryEncrypt2(str);
            for (int i = 0; i < 3; i++) {
                if (!"failed".equals(oiSymmetryEncrypt2)) {
                    return oiSymmetryEncrypt2;
                }
                oiSymmetryEncrypt2 = TpnsSecurity.oiSymmetryEncrypt2(str);
            }
        }
        return "";
    }

    public static String decrypt(String str) {
        if (!C7056i.m30194b(str)) {
            String oiSymmetryDecrypt2 = TpnsSecurity.oiSymmetryDecrypt2(str);
            for (int i = 0; i < 3; i++) {
                if (!"failed".equals(oiSymmetryDecrypt2)) {
                    return oiSymmetryDecrypt2;
                }
                oiSymmetryDecrypt2 = TpnsSecurity.oiSymmetryDecrypt2(str);
            }
        }
        return "";
    }
}
