package okhttp3.internal.p701e;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.C8513x;
import okhttp3.Protocol;
import okhttp3.internal.p702f.C8448a;
import okhttp3.internal.p702f.C8449b;
import okhttp3.internal.p702f.C8450c;
import okhttp3.internal.p702f.C8452e;
import okio.C8525c;

/* compiled from: Platform */
/* renamed from: okhttp3.internal.e.f */
public class C8447f {
    /* renamed from: a */
    private static final C8447f f28647a = m36196a();
    /* renamed from: b */
    private static final Logger f28648b = Logger.getLogger(C8513x.class.getName());

    @Nullable
    /* renamed from: a */
    public String mo40321a(SSLSocket sSLSocket) {
        return null;
    }

    /* renamed from: a */
    public void mo40326a(SSLSocket sSLSocket, String str, List<Protocol> list) {
    }

    /* renamed from: a */
    public void mo40338a(SSLSocketFactory sSLSocketFactory) {
    }

    /* renamed from: b */
    public void mo40339b(SSLSocket sSLSocket) {
    }

    /* renamed from: b */
    public boolean mo40329b(String str) {
        return true;
    }

    /* renamed from: d */
    public String mo40346d() {
        return "OkHttp";
    }

    /* renamed from: c */
    public static C8447f m36198c() {
        return f28647a;
    }

    /* renamed from: a */
    public void mo40325a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    /* renamed from: a */
    public void mo40323a(int i, String str, Throwable th) {
        f28648b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    /* renamed from: a */
    public Object mo40320a(String str) {
        if (f28648b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    /* renamed from: a */
    public void mo40324a(String str, Object obj) {
        if (obj == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
            str = sb.toString();
        }
        mo40323a(5, str, (Throwable) obj);
    }

    /* renamed from: a */
    public static List<String> m36195a(List<Protocol> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = (Protocol) list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                arrayList.add(protocol.toString());
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public C8450c mo40322a(X509TrustManager x509TrustManager) {
        return new C8448a(mo40328b(x509TrustManager));
    }

    /* renamed from: e */
    public static boolean m36199e() {
        if ("conscrypt".equals(System.getProperty("okhttp.platform"))) {
            return true;
        }
        return "Conscrypt".equals(Security.getProviders()[0].getName());
    }

    /* renamed from: a */
    private static C8447f m36196a() {
        C8447f a = C8439a.m36156a();
        if (a != null) {
            return a;
        }
        if (m36199e()) {
            C8447f a2 = ConscryptPlatform.m36175a();
            if (a2 != null) {
                return a2;
            }
        }
        C8443c a3 = C8443c.m36181a();
        if (a3 != null) {
            return a3;
        }
        C8447f a4 = C8444d.m36184a();
        if (a4 != null) {
            return a4;
        }
        return new C8447f();
    }

    /* renamed from: b */
    static byte[] m36197b(List<Protocol> list) {
        C8525c cVar = new C8525c();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = (Protocol) list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                cVar.mo40765i(protocol.toString().length());
                cVar.mo40738b(protocol.toString());
            }
        }
        return cVar.mo40780s();
    }

    /* renamed from: b */
    public SSLContext mo40327b() {
        if ("1.7".equals(System.getProperty("java.specification.version"))) {
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

    /* renamed from: b */
    public C8452e mo40328b(X509TrustManager x509TrustManager) {
        return new C8449b(x509TrustManager.getAcceptedIssuers());
    }
}
