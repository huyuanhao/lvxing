package okhttp3.internal.p701e;

import android.os.Build.VERSION;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import okhttp3.internal.C8417c;
import okhttp3.internal.p702f.C8450c;
import okhttp3.internal.p702f.C8452e;

/* compiled from: AndroidPlatform */
/* renamed from: okhttp3.internal.e.a */
class C8439a extends C8447f {
    /* renamed from: a */
    private final Class<?> f28621a;
    /* renamed from: b */
    private final C8446e<Socket> f28622b;
    /* renamed from: c */
    private final C8446e<Socket> f28623c;
    /* renamed from: d */
    private final C8446e<Socket> f28624d;
    /* renamed from: e */
    private final C8446e<Socket> f28625e;
    /* renamed from: f */
    private final C8442c f28626f = C8442c.m36172a();

    /* compiled from: AndroidPlatform */
    /* renamed from: okhttp3.internal.e.a$a */
    static final class C8440a extends C8450c {
        /* renamed from: a */
        private final Object f28627a;
        /* renamed from: b */
        private final Method f28628b;

        public int hashCode() {
            return 0;
        }

        C8440a(Object obj, Method method) {
            this.f28627a = obj;
            this.f28628b = method;
        }

        /* renamed from: a */
        public List<Certificate> mo40330a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                X509Certificate[] x509CertificateArr = (X509Certificate[]) list.toArray(new X509Certificate[list.size()]);
                return (List) this.f28628b.invoke(this.f28627a, new Object[]{x509CertificateArr, "RSA", str});
            } catch (InvocationTargetException e) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e.getMessage());
                sSLPeerUnverifiedException.initCause(e);
                throw sSLPeerUnverifiedException;
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof C8440a;
        }
    }

    /* compiled from: AndroidPlatform */
    /* renamed from: okhttp3.internal.e.a$b */
    static final class C8441b implements C8452e {
        /* renamed from: a */
        private final X509TrustManager f28629a;
        /* renamed from: b */
        private final Method f28630b;

        C8441b(X509TrustManager x509TrustManager, Method method) {
            this.f28630b = method;
            this.f28629a = x509TrustManager;
        }

        /* renamed from: a */
        public X509Certificate mo40333a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f28630b.invoke(this.f28629a, new Object[]{x509Certificate});
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
                return null;
            } catch (IllegalAccessException e) {
                throw C8417c.m36028a("unable to get issues and signature", (Exception) e);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C8441b)) {
                return false;
            }
            C8441b bVar = (C8441b) obj;
            if (!this.f28629a.equals(bVar.f28629a) || !this.f28630b.equals(bVar.f28630b)) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            return this.f28629a.hashCode() + (this.f28630b.hashCode() * 31);
        }
    }

    /* compiled from: AndroidPlatform */
    /* renamed from: okhttp3.internal.e.a$c */
    static final class C8442c {
        /* renamed from: a */
        private final Method f28631a;
        /* renamed from: b */
        private final Method f28632b;
        /* renamed from: c */
        private final Method f28633c;

        C8442c(Method method, Method method2, Method method3) {
            this.f28631a = method;
            this.f28632b = method2;
            this.f28633c = method3;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public Object mo40336a(String str) {
            Method method = this.f28631a;
            if (method != null) {
                try {
                    Object invoke = method.invoke(null, new Object[0]);
                    this.f28632b.invoke(invoke, new Object[]{str});
                    return invoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo40337a(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                this.f28633c.invoke(obj, new Object[0]);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        /* renamed from: a */
        static C8442c m36172a() {
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
            return new C8442c(method3, method, method2);
        }
    }

    C8439a(Class<?> cls, C8446e<Socket> eVar, C8446e<Socket> eVar2, C8446e<Socket> eVar3, C8446e<Socket> eVar4) {
        this.f28621a = cls;
        this.f28622b = eVar;
        this.f28623c = eVar2;
        this.f28624d = eVar3;
        this.f28625e = eVar4;
    }

    /* renamed from: a */
    public void mo40325a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        String str = "Exception in connect";
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e) {
            if (C8417c.m36043a(e)) {
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
    public void mo40326a(SSLSocket sSLSocket, String str, List<Protocol> list) {
        if (str != null) {
            this.f28622b.mo40343b(sSLSocket, Boolean.valueOf(true));
            this.f28623c.mo40343b(sSLSocket, str);
        }
        C8446e<Socket> eVar = this.f28625e;
        if (eVar != null && eVar.mo40342a(sSLSocket)) {
            this.f28625e.mo40345d(sSLSocket, m36197b(list));
        }
    }

    @Nullable
    /* renamed from: a */
    public String mo40321a(SSLSocket sSLSocket) {
        C8446e<Socket> eVar = this.f28624d;
        String str = null;
        if (eVar == null || !eVar.mo40342a(sSLSocket)) {
            return null;
        }
        byte[] bArr = (byte[]) this.f28624d.mo40345d(sSLSocket, new Object[0]);
        if (bArr != null) {
            str = new String(bArr, C8417c.f28532e);
        }
        return str;
    }

    /* renamed from: a */
    public void mo40323a(int i, String str, Throwable th) {
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
    public Object mo40320a(String str) {
        return this.f28626f.mo40336a(str);
    }

    /* renamed from: a */
    public void mo40324a(String str, Object obj) {
        if (!this.f28626f.mo40337a(obj)) {
            mo40323a(5, str, (Throwable) null);
        }
    }

    /* renamed from: b */
    public boolean mo40329b(String str) {
        try {
            r5 = str;
            Class cls = Class.forName("android.security.NetworkSecurityPolicy");
            r5 = m36157a(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
            r5 = r5;
            return r5;
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.mo40329b(r5);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            throw C8417c.m36028a("unable to determine cleartext support", e);
        }
    }

    /* renamed from: a */
    private boolean m36157a(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            r6 = str;
            r6 = ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[]{String.class}).invoke(obj, new Object[]{str})).booleanValue();
            r6 = r6;
            return r6;
        } catch (NoSuchMethodException unused) {
            return m36158b(r6, cls, obj);
        }
    }

    /* renamed from: b */
    private boolean m36158b(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            r4 = str;
            r4 = ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
            r4 = r4;
            return r4;
        } catch (NoSuchMethodException unused) {
            return super.mo40329b(r4);
        }
    }

    /* renamed from: f */
    private static boolean m36159f() {
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
    public C8450c mo40322a(X509TrustManager x509TrustManager) {
        try {
            Class cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C8440a(cls.getConstructor(new Class[]{X509TrustManager.class}).newInstance(new Object[]{x509TrustManager}), cls.getMethod("checkServerTrusted", new Class[]{X509Certificate[].class, String.class, String.class}));
        } catch (Exception unused) {
            return super.mo40322a(x509TrustManager);
        }
    }

    /* renamed from: a */
    public static C8447f m36156a() {
        Class cls;
        C8446e eVar;
        C8446e eVar2;
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
        C8446e eVar3 = new C8446e(null, "setUseSessionTickets", Boolean.TYPE);
        C8446e eVar4 = new C8446e(null, "setHostname", String.class);
        if (m36159f()) {
            C8446e eVar5 = new C8446e(cls2, "getAlpnSelectedProtocol", new Class[0]);
            eVar = new C8446e(null, "setAlpnProtocols", cls2);
            eVar2 = eVar5;
        } else {
            eVar2 = null;
            eVar = null;
        }
        C8439a aVar = new C8439a(cls3, eVar3, eVar4, eVar2, eVar);
        return aVar;
    }

    /* renamed from: b */
    public C8452e mo40328b(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[]{X509Certificate.class});
            declaredMethod.setAccessible(true);
            return new C8441b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.mo40328b(x509TrustManager);
        }
    }

    /* renamed from: b */
    public SSLContext mo40327b() {
        if (VERSION.SDK_INT >= 16 && VERSION.SDK_INT < 22) {
            try {
                return SSLContext.getInstance("TLSv1.2");
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No TLS provider", e);
        }
    }
}
