package com.bytedance.sdk.p145a.p147b.p148a.p155g;

import com.bytedance.sdk.p145a.p146a.Buffer;
import com.bytedance.sdk.p145a.p147b.OkHttpClient;
import com.bytedance.sdk.p145a.p147b.Protocol;
import com.bytedance.sdk.p145a.p147b.p148a.p157i.BasicCertificateChainCleaner;
import com.bytedance.sdk.p145a.p147b.p148a.p157i.BasicTrustRootIndex;
import com.bytedance.sdk.p145a.p147b.p148a.p157i.CertificateChainCleaner;
import com.bytedance.sdk.p145a.p147b.p148a.p157i.TrustRootIndex;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.bytedance.sdk.a.b.a.g.e */
public class Platform {
    /* renamed from: a */
    private static final Platform f5680a = m7293a();
    /* renamed from: b */
    private static final Logger f5681b = Logger.getLogger(OkHttpClient.class.getName());

    /* renamed from: a */
    public String mo13871a(SSLSocket sSLSocket) {
        return null;
    }

    /* renamed from: a */
    public void mo13875a(SSLSocket sSLSocket, String str, List<Protocol> list) {
    }

    /* renamed from: b */
    public void mo13886b(SSLSocket sSLSocket) {
    }

    /* renamed from: b */
    public boolean mo13877b(String str) {
        return true;
    }

    /* renamed from: b */
    public static Platform m7295b() {
        return f5680a;
    }

    /* renamed from: a */
    public void mo13874a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    /* renamed from: a */
    public void mo13872a(int i, String str, Throwable th) {
        f5681b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    /* renamed from: a */
    public Object mo13870a(String str) {
        if (f5681b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    /* renamed from: a */
    public void mo13873a(String str, Object obj) {
        if (obj == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
            str = sb.toString();
        }
        mo13872a(5, str, (Throwable) obj);
    }

    /* renamed from: a */
    public static List<String> m7294a(List<Protocol> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol wVar = (Protocol) list.get(i);
            if (wVar != Protocol.HTTP_1_0) {
                arrayList.add(wVar.toString());
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public CertificateChainCleaner mo13869a(X509TrustManager x509TrustManager) {
        return new BasicCertificateChainCleaner(mo13876b(x509TrustManager));
    }

    /* renamed from: a */
    private static Platform m7293a() {
        Platform a = AndroidPlatform.m7261a();
        if (a != null) {
            return a;
        }
        Jdk9Platform a2 = Jdk9Platform.m7279a();
        if (a2 != null) {
            return a2;
        }
        Platform a3 = JdkWithJettyBootPlatform.m7282a();
        if (a3 != null) {
            return a3;
        }
        return new Platform();
    }

    /* renamed from: b */
    static byte[] m7296b(List<Protocol> list) {
        Buffer cVar = new Buffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol wVar = (Protocol) list.get(i);
            if (wVar != Protocol.HTTP_1_0) {
                cVar.mo13559i(wVar.toString().length());
                cVar.mo13534b(wVar.toString());
            }
        }
        return cVar.mo13572q();
    }

    /* renamed from: b */
    public TrustRootIndex mo13876b(X509TrustManager x509TrustManager) {
        return new BasicTrustRootIndex(x509TrustManager.getAcceptedIssuers());
    }
}
