package com.p368pw.inner.base.p387d;

import com.p368pw.inner.base.p386c.C5143a;
import java.io.InputStream;

/* renamed from: com.pw.inner.base.d.t */
public class C5213t {
    /* renamed from: a */
    public static String m21485a(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            return new String(bArr);
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return null;
        } finally {
            C5175d.m21353a(inputStream);
        }
    }

    /* renamed from: a */
    public static final void m21486a(String str) {
        if (C5207q.m21476a((CharSequence) str)) {
            throw new C5143a(2, "assertNotEmpty(string) fail.");
        }
    }

    /* renamed from: a */
    public static boolean m21487a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
