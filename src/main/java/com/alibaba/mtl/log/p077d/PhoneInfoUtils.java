package com.alibaba.mtl.log.p077d;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.Random;

/* renamed from: com.alibaba.mtl.log.d.m */
public class PhoneInfoUtils {
    /* renamed from: a */
    private static final Random f3415a = new Random();

    /* renamed from: a */
    public static final String m3852a() {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nanoTime = (int) System.nanoTime();
        int nextInt = f3415a.nextInt();
        int nextInt2 = f3415a.nextInt();
        byte[] a = IntUtils.m3820a(currentTimeMillis);
        byte[] a2 = IntUtils.m3820a(nanoTime);
        byte[] a3 = IntUtils.m3820a(nextInt);
        byte[] a4 = IntUtils.m3820a(nextInt2);
        byte[] bArr = new byte[16];
        System.arraycopy(a, 0, bArr, 0, 4);
        System.arraycopy(a2, 0, bArr, 4, 4);
        System.arraycopy(a3, 0, bArr, 8, 4);
        System.arraycopy(a4, 0, bArr, 12, 4);
        return Base64.m3802b(bArr, 2);
    }

    /* renamed from: a */
    public static String m3853a(Context context) {
        String str = "UTF-8";
        String str2 = "_ie";
        String str3 = "UTCommon";
        if (context != null) {
            try {
                String string = context.getSharedPreferences(str3, 0).getString(str2, "");
                if (!TextUtils.isEmpty(string)) {
                    String str4 = new String(Base64.m3800a(string.getBytes(), 2), str);
                    if (!TextUtils.isEmpty(str4)) {
                        return str4;
                    }
                }
            } catch (Exception unused) {
            }
        }
        String str5 = null;
        if (TextUtils.isEmpty(null)) {
            str5 = m3852a();
        }
        if (context != null) {
            try {
                Editor edit = context.getSharedPreferences(str3, 0).edit();
                edit.putString(str2, new String(Base64.m3804c(str5.getBytes(str), 2)));
                edit.commit();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return str5;
    }

    /* renamed from: b */
    public static String m3854b(Context context) {
        String str = "UTF-8";
        String str2 = "_is";
        String str3 = "UTCommon";
        if (context != null) {
            try {
                String string = context.getSharedPreferences(str3, 0).getString(str2, "");
                if (!TextUtils.isEmpty(string)) {
                    String str4 = new String(Base64.m3800a(string.getBytes(), 2), str);
                    if (!TextUtils.isEmpty(str4)) {
                        return str4;
                    }
                }
            } catch (Exception unused) {
            }
        }
        String str5 = null;
        if (TextUtils.isEmpty(null)) {
            str5 = m3852a();
        }
        if (context != null) {
            try {
                Editor edit = context.getSharedPreferences(str3, 0).edit();
                edit.putString(str2, new String(Base64.m3804c(str5.getBytes(str), 2)));
                edit.commit();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return str5;
    }
}
