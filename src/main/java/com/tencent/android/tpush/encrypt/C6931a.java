package com.tencent.android.tpush.encrypt;

import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.encrypt.a */
public class C6931a {
    /* renamed from: a */
    public static String m29598a(String str) {
        String str2;
        String str3 = "md5 encrypt:";
        String str4 = Constants.LogTag;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            str = m29599a(instance.digest());
            return str;
        } catch (NoSuchAlgorithmException e) {
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            sb.append(str2);
            C6864a.m29302d(str4, sb.toString(), e);
            return "";
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str3);
            sb2.append(str);
            C6864a.m29302d(str4, sb2.toString(), e2);
            return "";
        }
    }

    /* renamed from: a */
    public static String m29599a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(Integer.toHexString(b & DeviceInfos.NETWORK_TYPE_UNCONNECTED));
        }
        return sb.toString();
    }
}
