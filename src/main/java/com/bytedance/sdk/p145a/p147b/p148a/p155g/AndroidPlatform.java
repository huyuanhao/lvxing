package com.bytedance.sdk.p145a.p147b.p148a.p155g;

import android.os.Build.VERSION;
import android.util.Log;
import com.bytedance.sdk.p145a.p147b.Protocol;
import com.bytedance.sdk.p145a.p147b.p148a.C1876c;
import com.bytedance.sdk.p145a.p147b.p148a.p157i.CertificateChainCleaner;
import com.bytedance.sdk.p145a.p147b.p148a.p157i.TrustRootIndex;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.bytedance.sdk.a.b.a.g.a */
class AndroidPlatform extends Platform {
    /* renamed from: a */
    private final Class<?> f5654a;
    /* renamed from: b */
    private final OptionalMethod<Socket> f5655b;
    /* renamed from: c */
    private final OptionalMethod<Socket> f5656c;
    /* renamed from: d */
    private final OptionalMethod<Socket> f5657d;
    /* renamed from: e */
    private final OptionalMethod<Socket> f5658e;
    /* renamed from: f */
    private final C1915c f5659f = C1915c.m7276a();

    /* compiled from: AndroidPlatform */
    /* renamed from: com.bytedance.sdk.a.b.a.g.a$a */
    static final class C1913a extends CertificateChainCleaner {
        /* renamed from: a */
        private final Object f5660a;
        /* renamed from: b */
        private final Method f5661b;

        public int hashCode() {
            return 0;
        }

        C1913a(Object obj, Method method) {
            this.f5660a = obj;
            this.f5661b = method;
        }

        /* renamed from: a */
        public List<Certificate> mo13878a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                X509Certificate[] x509CertificateArr = (X509Certificate[]) list.toArray(new X509Certificate[list.size()]);
                return (List) this.f5661b.invoke(this.f5660a, new Object[]{x509CertificateArr, "RSA", str});
            } catch (InvocationTargetException e) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e.getMessage());
                sSLPeerUnverifiedException.initCause(e);
                throw sSLPeerUnverifiedException;
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof C1913a;
        }
    }

    /* compiled from: AndroidPlatform */
    /* renamed from: com.bytedance.sdk.a.b.a.g.a$b */
    static final class C1914b implements TrustRootIndex {
        /* renamed from: a */
        private final X509TrustManager f5662a;
        /* renamed from: b */
        private final Method f5663b;

        C1914b(X509TrustManager x509TrustManager, Method method) {
            this.f5663b = method;
            this.f5662a = x509TrustManager;
        }

        /* renamed from: a */
        public X509Certificate mo13881a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f5663b.invoke(this.f5662a, new Object[]{x509Certificate});
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
                return null;
            } catch (IllegalAccessException e) {
                throw C1876c.m6952a("unable to get issues and signature", (Exception) e);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1914b)) {
                return false;
            }
            C1914b bVar = (C1914b) obj;
            if (!this.f5662a.equals(bVar.f5662a) || !this.f5663b.equals(bVar.f5663b)) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            return this.f5662a.hashCode() + (this.f5663b.hashCode() * 31);
        }
    }

    /* compiled from: AndroidPlatform */
    /* renamed from: com.bytedance.sdk.a.b.a.g.a$c */
    static final class C1915c {
        /* renamed from: a */
        private final Method f5664a;
        /* renamed from: b */
        private final Method f5665b;
        /* renamed from: c */
        private final Method f5666c;

        C1915c(Method method, Method method2, Method method3) {
            this.f5664a = method;
            this.f5665b = method2;
            this.f5666c = method3;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public Object mo13884a(String str) {
            Method method = this.f5664a;
            if (method != null) {
                try {
                    Object invoke = method.invoke(null, new Object[0]);
                    this.f5665b.invoke(invoke, new Object[]{str});
                    return invoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo13885a(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                this.f5666c.invoke(obj, new Object[0]);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        /* renamed from: a */
        static C1915c m7276a() {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", new Class[0]);
                method = cls.getMethod("open", new Class[]{String.class});
                method3 = cls.getMethod("warnIfOpen", new Class[0]);
                method2 = method3;
                method3 = method4;
            } catch (Exception unused) {
                method2 = method3;
                method = method2;
            }
            return new C1915c(method3, method, method2);
        }
    }

    AndroidPlatform(Class<?> cls, OptionalMethod<Socket> dVar, OptionalMethod<Socket> dVar2, OptionalMethod<Socket> dVar3, OptionalMethod<Socket> dVar4) {
        this.f5654a = cls;
        this.f5655b = dVar;
        this.f5656c = dVar2;
        this.f5657d = dVar3;
        this.f5658e = dVar4;
    }

    /* renamed from: a */
    public void mo13874a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        String str = "Exception in connect";
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e) {
            if (C1876c.m6964a(e)) {
                throw new IOException(e);
            }
            throw e;
        } catch (SecurityException e2) {
            IOException iOException = new IOException(str);
            iOException.initCause(e2);
            throw iOException;
        } catch (ClassCastException e3) {
            if (VERSION.SDK_INT == 26) {
                IOException iOException2 = new IOException(str);
                iOException2.initCause(e3);
                throw iOException2;
            }
            throw e3;
        }
    }

    /* renamed from: a */
    public void mo13875a(SSLSocket sSLSocket, String str, List<Protocol> list) {
        if (str != null) {
            this.f5655b.mo13890b(sSLSocket, Boolean.valueOf(true));
            this.f5656c.mo13890b(sSLSocket, str);
        }
        OptionalMethod<Socket> dVar = this.f5658e;
        if (dVar != null && dVar.mo13889a(sSLSocket)) {
            this.f5658e.mo13892d(sSLSocket, m7296b(list));
        }
    }

    /* renamed from: a */
    public String mo13871a(SSLSocket sSLSocket) {
        OptionalMethod<Socket> dVar = this.f5657d;
        String str = null;
        if (dVar == null || !dVar.mo13889a(sSLSocket)) {
            return null;
        }
        byte[] bArr = (byte[]) this.f5657d.mo13892d(sSLSocket, new Object[0]);
        if (bArr != null) {
            str = new String(bArr, C1876c.f5402e);
        }
        return str;
    }

    /* renamed from: a */
    public void mo13872a(int i, String str, Throwable th) {
        int min;
        int i2 = 5;
        if (i != 5) {
            i2 = 3;
        }
        if (th != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(10);
            sb.append(Log.getStackTraceString(th));
            str = sb.toString();
        }
        int i3 = 0;
        int length = str.length();
        while (i3 < length) {
            int indexOf = str.indexOf(10, i3);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i3 + 4000);
                Log.println(i2, "OkHttp", str.substring(i3, min));
                if (min >= indexOf) {
                    break;
                }
                i3 = min;
            }
            i3 = min + 1;
        }
    }

    /* renamed from: a */
    public Object mo13870a(String str) {
        return this.f5659f.mo13884a(str);
    }

    /* renamed from: a */
    public void mo13873a(String str, Object obj) {
        if (!this.f5659f.mo13885a(obj)) {
            mo13872a(5, str, (Throwable) null);
        }
    }

    /* renamed from: b */
    public boolean mo13877b(String str) {
        try {
            r5 = str;
            Class cls = Class.forName("android.security.NetworkSecurityPolicy");
            r5 = m7262a(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
            r5 = r5;
            return r5;
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.mo13877b(r5);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            throw C1876c.m6952a("unable to determine cleartext support", e);
        }
    }

    /* renamed from: a */
    private boolean m7262a(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            r6 = str;
            r6 = ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[]{String.class}).invoke(obj, new Object[]{str})).booleanValue();
            r6 = r6;
            return r6;
        } catch (NoSuchMethodException unused) {
            return m7263b(r6, cls, obj);
        }
    }

    /* renamed from: b */
    private boolean m7263b(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            r4 = str;
            r4 = ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
            r4 = r4;
            return r4;
        } catch (NoSuchMethodException unused) {
            return super.mo13877b(r4);
        }
    }

    /* renamed from: c */
    private static boolean m7264c() {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public CertificateChainCleaner mo13869a(X509TrustManager x509TrustManager) {
        try {
            Class cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C1913a(cls.getConstructor(new Class[]{X509TrustManager.class}).newInstance(new Object[]{x509TrustManager}), cls.getMethod("checkServerTrusted", new Class[]{X509Certificate[].class, String.class, String.class}));
        } catch (Exception unused) {
            return super.mo13869a(x509TrustManager);
        }
    }

    /* renamed from: a */
    public static Platform m7261a() {
        Class cls;
        OptionalMethod dVar;
        OptionalMethod dVar2;
        Class<byte[]> cls2 = byte[].class;
        try {
            cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
        } catch (ClassNotFoundException unused) {
            try {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            } catch (ClassNotFoundException unused2) {
                return null;
            }
        }
        Class cls3 = cls;
        OptionalMethod dVar3 = new OptionalMethod(null, "setUseSessionTickets", Boolean.TYPE);
        OptionalMethod dVar4 = new OptionalMethod(null, "setHostname", String.class);
        if (m7264c()) {
            OptionalMethod dVar5 = new OptionalMethod(cls2, "getAlpnSelectedProtocol", new Class[0]);
            dVar = new OptionalMethod(null, "setAlpnProtocols", cls2);
            dVar2 = dVar5;
        } else {
            dVar2 = null;
            dVar = null;
        }
        AndroidPlatform aVar = new AndroidPlatform(cls3, dVar3, dVar4, dVar2, dVar);
        return aVar;
    }

    /* renamed from: b */
    public TrustRootIndex mo13876b(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[]{X509Certificate.class});
            declaredMethod.setAccessible(true);
            return new C1914b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.mo13876b(x509TrustManager);
        }
    }
}
