package com.alipay.p109b.p110a.p111a.p114b;

import com.alipay.p109b.p110a.p111a.p112a.C1460a;
import java.io.File;

/* renamed from: com.alipay.b.a.a.b.b */
public final class C1466b {
    /* renamed from: a */
    public static String m4282a(String str) {
        String str2;
        try {
            str2 = C1470f.m4288a(str);
        } catch (Throwable unused) {
            str2 = "";
        }
        if (!C1460a.m4260a(str2)) {
            return str2;
        }
        StringBuilder sb = new StringBuilder(".SystemConfig");
        sb.append(File.separator);
        sb.append(str);
        return C1467c.m4283a(sb.toString());
    }
}
