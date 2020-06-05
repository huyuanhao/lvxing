package okhttp3.internal.p701e;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;
import okhttp3.internal.C8417c;

/* compiled from: JdkWithJettyBootPlatform */
/* renamed from: okhttp3.internal.e.d */
class C8444d extends C8447f {
    /* renamed from: a */
    private final Method f28636a;
    /* renamed from: b */
    private final Method f28637b;
    /* renamed from: c */
    private final Method f28638c;
    /* renamed from: d */
    private final Class<?> f28639d;
    /* renamed from: e */
    private final Class<?> f28640e;

    /* compiled from: JdkWithJettyBootPlatform */
    /* renamed from: okhttp3.internal.e.d$a */
    private static class C8445a implements InvocationHandler {
        /* renamed from: a */
        boolean f28641a;
        /* renamed from: b */
        String f28642b;
        /* renamed from: c */
        private final List<String> f28643c;

        C8445a(List<String> list) {
            this.f28643c = list;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<String> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = C8417c.f28529b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.valueOf(true);
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f28641a = true;
                return null;
            } else if (name.equals("protocols") && objArr.length == 0) {
                return this.f28643c;
            } else {
                if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                    List list = (List) objArr[0];
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        if (this.f28643c.contains(list.get(i))) {
                            String str = (String) list.get(i);
                            this.f28642b = str;
                            return str;
                        }
                    }
                    String str2 = (String) this.f28643c.get(0);
                    this.f28642b = str2;
                    return str2;
                } else if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                    return method.invoke(this, objArr);
                } else {
                    this.f28642b = (String) objArr[0];
                    return null;
                }
            }
        }
    }

    C8444d(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f28636a = method;
        this.f28637b = method2;
        this.f28638c = method3;
        this.f28639d = cls;
        this.f28640e = cls2;
    }

    /* renamed from: a */
    public void mo40326a(SSLSocket sSLSocket, String str, List<Protocol> list) {
        List a = m36195a(list);
        try {
            Object newProxyInstance = Proxy.newProxyInstance(C8447f.class.getClassLoader(), new Class[]{this.f28639d, this.f28640e}, new C8445a(a));
            this.f28636a.invoke(null, new Object[]{sSLSocket, newProxyInstance});
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw C8417c.m36028a("unable to set alpn", (Exception) e);
        }
    }

    /* renamed from: b */
    public void mo40339b(SSLSocket sSLSocket) {
        try {
            this.f28638c.invoke(null, new Object[]{sSLSocket});
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw C8417c.m36028a("unable to remove alpn", (Exception) e);
        }
    }

    @Nullable
    /* renamed from: a */
    public String mo40321a(SSLSocket sSLSocket) {
        try {
            Object[] objArr = {sSLSocket};
            String str = null;
            C8445a aVar = (C8445a) Proxy.getInvocationHandler(this.f28637b.invoke(null, objArr));
            if (aVar.f28641a || aVar.f28642b != null) {
                if (!aVar.f28641a) {
                    str = aVar.f28642b;
                }
                return str;
            }
            C8447f.m36198c().mo40323a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
            return null;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw C8417c.m36028a("unable to get selected protocol", (Exception) e);
        }
    }

    /* renamed from: a */
    public static C8447f m36184a() {
        String str = "org.eclipse.jetty.alpn.ALPN";
        try {
            Class cls = Class.forName(str);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("$Provider");
            Class cls2 = Class.forName(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("$ClientProvider");
            Class cls3 = Class.forName(sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append("$ServerProvider");
            Class cls4 = Class.forName(sb3.toString());
            Method method = cls.getMethod("put", new Class[]{SSLSocket.class, cls2});
            Method method2 = method;
            C8444d dVar = new C8444d(method2, cls.getMethod("get", new Class[]{SSLSocket.class}), cls.getMethod("remove", new Class[]{SSLSocket.class}), cls3, cls4);
            return dVar;
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }
}
