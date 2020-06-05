package com.qiyukf.nimlib.p488k.p492d;

import android.text.TextUtils;
import com.qiyukf.basesdk.p393a.C5264a;
import java.lang.reflect.Method;

/* renamed from: com.qiyukf.nimlib.k.d.a */
public final class C5947a {
    /* renamed from: a */
    public static Object m23844a(Object obj, String str) {
        if (obj != null && !TextUtils.isEmpty(str)) {
            try {
                Method method = obj.getClass().getMethod(str, null);
                method.setAccessible(true);
                obj = method.invoke(obj, null);
                return obj;
            } catch (NoSuchMethodException unused) {
                StringBuilder sb = new StringBuilder("method ");
                sb.append(str);
                sb.append(" not found in ");
                sb.append(obj.getClass().getName());
                C5264a.m21617a("reflect", sb.toString());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }
}
