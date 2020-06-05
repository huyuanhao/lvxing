package com.kwad.sdk.core.diskcache.p322b;

import android.text.TextUtils;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.Closeable;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.kwad.sdk.core.diskcache.b.d */
class C4085d {
    /* renamed from: a */
    static String m16963a(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            str = m16964a(instance.digest());
            return str;
        } catch (NoSuchAlgorithmException unused) {
            return String.valueOf(str.hashCode());
        }
    }

    /* renamed from: a */
    private static String m16964a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    /* renamed from: a */
    static void m16965a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: a */
    static void m16966a(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        } else if ((obj instanceof String) && TextUtils.isEmpty((String) obj)) {
            throw new NullPointerException(str);
        }
    }
}
