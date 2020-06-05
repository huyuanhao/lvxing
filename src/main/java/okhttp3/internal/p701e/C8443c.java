package okhttp3.internal.p701e;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;
import okhttp3.internal.C8417c;

/* compiled from: Jdk9Platform */
/* renamed from: okhttp3.internal.e.c */
final class C8443c extends C8447f {
    /* renamed from: a */
    final Method f28634a;
    /* renamed from: b */
    final Method f28635b;

    C8443c(Method method, Method method2) {
        this.f28634a = method;
        this.f28635b = method2;
    }

    /* renamed from: a */
    public void mo40326a(SSLSocket sSLSocket, String str, List<Protocol> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List a = m36195a(list);
            this.f28634a.invoke(sSLParameters, new Object[]{a.toArray(new String[a.size()])});
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw C8417c.m36028a("unable to set ssl parameters", (Exception) e);
        }
    }

    @Nullable
    /* renamed from: a */
    public String mo40321a(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f28635b.invoke(sSLSocket, new Object[0]);
            if (str == null || str.equals("")) {
                return null;
            }
            return str;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw C8417c.m36028a("unable to get selected protocols", (Exception) e);
        }
    }

    /* renamed from: a */
    public static C8443c m36181a() {
        try {
            return new C8443c(SSLParameters.class.getMethod("setApplicationProtocols", new Class[]{String[].class}), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }
}
