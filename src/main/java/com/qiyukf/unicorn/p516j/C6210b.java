package com.qiyukf.unicorn.p516j;

import android.content.Context;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.unicorn.p499b.C6014b;
import java.io.UnsupportedEncodingException;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.qiyukf.unicorn.j.b */
public final class C6210b {
    /* renamed from: a */
    public static String m24634a(Context context, byte[] bArr, String str) {
        byte[] b = m24637b(context, bArr, str);
        if (b == null) {
            return null;
        }
        try {
            return new String(b, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static byte[] m24635a(Context context, String str) {
        String f = C6014b.m23956f();
        String string = Secure.getString(context.getContentResolver(), "android_id");
        String substring = str.substring(0, Math.min(8, str.length() - 1));
        StringBuilder sb = new StringBuilder();
        sb.append(substring);
        sb.append(f.substring(0, Math.min(8, f.length() - 1)));
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(sb2);
        sb3.append(string.substring(0, Math.min(8, string.length() - 1)));
        String sb4 = sb3.toString();
        if (sb4.length() != 24) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(sb4);
            sb5.append(str.substring(8, 24 - sb4.length()));
            sb4 = sb5.toString();
        }
        return sb4.getBytes();
    }

    /* renamed from: a */
    public static byte[] m24636a(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(m24635a(context, str2), "AES");
            Cipher instance = Cipher.getInstance("AES/ECB/NoPadding");
            instance.init(1, secretKeySpec);
            return instance.doFinal(str.getBytes("UTF-8"));
        } catch (Exception e) {
            C5264a.m21622c("ENC", "AES cipher error, enc failed");
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    private static byte[] m24637b(Context context, byte[] bArr, String str) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(m24635a(context, str), "AES");
        try {
            Cipher instance = Cipher.getInstance("AES/ECB/NoPadding");
            instance.init(2, secretKeySpec);
            return instance.doFinal(bArr);
        } catch (Exception e) {
            C5264a.m21622c("ENC", "AES cipher error, dec failed");
            e.printStackTrace();
            return null;
        }
    }
}
