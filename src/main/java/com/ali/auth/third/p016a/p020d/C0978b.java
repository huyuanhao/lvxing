package com.ali.auth.third.p016a.p020d;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.text.TextUtils;
import androidx.core.view.ViewCompat;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.lang.reflect.Method;
import java.util.HashMap;

/* renamed from: com.ali.auth.third.a.d.b */
public class C0978b {
    /* renamed from: a */
    private static Class f1879a;
    /* renamed from: b */
    private static Method f1880b;
    /* renamed from: c */
    private static Method f1881c;
    /* renamed from: d */
    private static Object f1882d;
    /* renamed from: e */
    private static Object f1883e;

    static {
        try {
            f1882d = m1856a("com.google.zxing.BarcodeFormat", "QR_CODE");
            f1883e = m1856a("com.google.zxing.EncodeHintType", "MARGIN");
            f1879a = Class.forName("com.google.zxing.qrcode.QRCodeWriter");
            int i = 0;
            f1880b = Class.forName("com.google.zxing.common.BitMatrix").getMethod("get", new Class[]{Integer.TYPE, Integer.TYPE});
            Method[] declaredMethods = f1879a.getDeclaredMethods();
            int length = declaredMethods.length;
            while (i < length) {
                Method method = declaredMethods[i];
                if (!method.getName().equals("encode") || method.getParameterTypes().length != 5) {
                    i++;
                } else {
                    f1881c = method;
                    return;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    public static Bitmap m1854a(String str, int i, int i2, String str2) {
        return m1855a(str, i, i2, "UTF-8", str2, "0", ViewCompat.MEASURED_STATE_MASK, -1);
    }

    /* renamed from: a */
    public static Bitmap m1855a(String str, int i, int i2, String str2, String str3, String str4, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        if (TextUtils.isEmpty(str) || i5 < 0 || i6 < 0) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(str4)) {
                hashMap.put(f1883e, str4);
            }
            Object newInstance = f1879a.newInstance();
            Object invoke = f1881c.invoke(newInstance, new Object[]{str, f1882d, Integer.valueOf(i), Integer.valueOf(i2), hashMap});
            int[] iArr = new int[(i5 * i6)];
            for (int i7 = 0; i7 < i6; i7++) {
                for (int i8 = 0; i8 < i5; i8++) {
                    if (((Boolean) f1880b.invoke(invoke, new Object[]{Integer.valueOf(i8), Integer.valueOf(i7)})).booleanValue()) {
                        iArr[(i7 * i5) + i8] = i3;
                    } else {
                        iArr[(i7 * i5) + i8] = i4;
                    }
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
            createBitmap.setPixels(iArr, 0, i, 0, 0, i, i2);
            return createBitmap;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    private static Object m1856a(String str, String str2) {
        Object[] enumConstants;
        Method method = Enum.class.getMethod(ArgKey.KEY_NAME, new Class[0]);
        for (Object obj : Class.forName(str).getEnumConstants()) {
            if (str2.equals(method.invoke(obj, new Object[0]))) {
                return obj;
            }
        }
        return null;
    }
}
