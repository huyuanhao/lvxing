package com.bytedance.sdk.p145a.p147b.p148a.p155g;

import com.bytedance.sdk.p145a.p147b.Protocol;
import com.bytedance.sdk.p145a.p147b.p148a.C1876c;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* renamed from: com.bytedance.sdk.a.b.a.g.b */
final class Jdk9Platform extends Platform {
    /* renamed from: a */
    final Method f5667a;
    /* renamed from: b */
    final Method f5668b;

    Jdk9Platform(Method method, Method method2) {
        this.f5667a = method;
        this.f5668b = method2;
    }

    /* renamed from: a */
    public void mo13875a(SSLSocket sSLSocket, String str, List<Protocol> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List a = m7294a(list);
            this.f5667a.invoke(sSLParameters, new Object[]{a.toArray(new String[a.size()])});
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw C1876c.m6952a("unable to set ssl parameters", (Exception) e);
        }
    }

    /* renamed from: a */
    public String mo13871a(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f5668b.invoke(sSLSocket, new Object[0]);
            if (str == null || str.equals("")) {
                return null;
            }
            return str;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw C1876c.m6952a("unable to get selected protocols", (Exception) e);
        }
    }

    /* renamed from: a */
    public static Jdk9Platform m7279a() {
        try {
            return new Jdk9Platform(SSLParameters.class.getMethod("setApplicationProtocols", new Class[]{String[].class}), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }
}
