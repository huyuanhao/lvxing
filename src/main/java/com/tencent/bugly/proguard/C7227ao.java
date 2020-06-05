package com.tencent.bugly.proguard;

import android.text.TextUtils;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.ao */
public class C7227ao {
    /* renamed from: a */
    private static Proxy f24398a;

    /* renamed from: a */
    public static void m31152a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            f24398a = null;
        } else {
            f24398a = new Proxy(Type.HTTP, new InetSocketAddress(str, i));
        }
    }

    /* renamed from: a */
    public static void m31153a(InetAddress inetAddress, int i) {
        if (inetAddress == null) {
            f24398a = null;
        } else {
            f24398a = new Proxy(Type.HTTP, new InetSocketAddress(inetAddress, i));
        }
    }

    /* renamed from: a */
    public static Proxy m31151a() {
        return f24398a;
    }
}
