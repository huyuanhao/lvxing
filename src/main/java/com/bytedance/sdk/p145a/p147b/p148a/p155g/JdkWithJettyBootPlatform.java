package com.bytedance.sdk.p145a.p147b.p148a.p155g;

import com.bytedance.sdk.p145a.p147b.Protocol;
import com.bytedance.sdk.p145a.p147b.p148a.C1876c;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* renamed from: com.bytedance.sdk.a.b.a.g.c */
class JdkWithJettyBootPlatform extends Platform {
    /* renamed from: a */
    private final Method f5669a;
    /* renamed from: b */
    private final Method f5670b;
    /* renamed from: c */
    private final Method f5671c;
    /* renamed from: d */
    private final Class<?> f5672d;
    /* renamed from: e */
    private final Class<?> f5673e;

    /* compiled from: JdkWithJettyBootPlatform */
    /* renamed from: com.bytedance.sdk.a.b.a.g.c$a */
    private static class C1916a implements InvocationHandler {
        /* renamed from: a */
        boolean f5674a;
        /* renamed from: b */
        String f5675b;
        /* renamed from: c */
        private final List<String> f5676c;

        C1916a(List<String> list) {
            this.f5676c = list;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<String> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = C1876c.f5399b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.valueOf(true);
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f5674a = true;
                return null;
            } else if (name.equals("protocols") && objArr.length == 0) {
                return this.f5676c;
            } else {
                if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                    List list = (List) objArr[0];
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        if (this.f5676c.contains(list.get(i))) {
                            String str = (String) list.get(i);
                            this.f5675b = str;
                            return str;
                        }
                    }
                    String str2 = (String) this.f5676c.get(0);
                    this.f5675b = str2;
                    return str2;
                } else if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                    return method.invoke(this, objArr);
                } else {
                    this.f5675b = (String) objArr[0];
                    return null;
                }
            }
        }
    }

    JdkWithJettyBootPlatform(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f5669a = method;
        this.f5670b = method2;
        this.f5671c = method3;
        this.f5672d = cls;
        this.f5673e = cls2;
    }

    /* renamed from: a */
    public void mo13875a(SSLSocket sSLSocket, String str, List<Protocol> list) {
        List a = m7294a(list);
        try {
            Object newProxyInstance = Proxy.newProxyInstance(Platform.class.getClassLoader(), new Class[]{this.f5672d, this.f5673e}, new C1916a(a));
            this.f5669a.invoke(null, new Object[]{sSLSocket, newProxyInstance});
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw C1876c.m6952a("unable to set alpn", (Exception) e);
        }
    }

    /* renamed from: b */
    public void mo13886b(SSLSocket sSLSocket) {
        try {
            this.f5671c.invoke(null, new Object[]{sSLSocket});
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw C1876c.m6952a("unable to remove alpn", (Exception) e);
        }
    }

    /* renamed from: a */
    public String mo13871a(SSLSocket sSLSocket) {
        try {
            Object[] objArr = {sSLSocket};
            String str = null;
            C1916a aVar = (C1916a) Proxy.getInvocationHandler(this.f5670b.invoke(null, objArr));
            if (aVar.f5674a || aVar.f5675b != null) {
                if (!aVar.f5674a) {
                    str = aVar.f5675b;
                }
                return str;
            }
            Platform.m7295b().mo13872a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
            return null;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw C1876c.m6952a("unable to get selected protocol", (Exception) e);
        }
    }

    /* renamed from: a */
    public static Platform m7282a() {
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
            JdkWithJettyBootPlatform cVar = new JdkWithJettyBootPlatform(method2, cls.getMethod("get", new Class[]{SSLSocket.class}), cls.getMethod("remove", new Class[]{SSLSocket.class}), cls3, cls4);
            return cVar;
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }
}
