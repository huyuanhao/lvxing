package com.bytedance.sdk.adnet.p161d;

import android.os.Build.VERSION;
import android.util.Log;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.bytedance.sdk.adnet.d.h */
public class TLSSocketFactory extends SSLSocketFactory {
    /* renamed from: a */
    public static final X509TrustManager f6318a = new X509TrustManager() {
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    };
    /* renamed from: b */
    private static final String[] f6319b;
    /* renamed from: c */
    private SSLSocketFactory f6320c;

    static {
        String str = "TLSv1.2";
        String str2 = "TLSv1.1";
        String str3 = "TLSv1";
        if (VERSION.SDK_INT >= 26) {
            f6319b = new String[]{str3, str2, str};
        } else {
            String str4 = "SSLv3";
            if (VERSION.SDK_INT >= 16) {
                f6319b = new String[]{str4, str3, str2, str};
            } else {
                f6319b = new String[]{str4, str3};
            }
        }
    }

    /* renamed from: a */
    private static void m7959a(Socket socket) {
        if (socket instanceof SSLSocket) {
            ((SSLSocket) socket).setEnabledProtocols(f6319b);
        }
    }

    public TLSSocketFactory() {
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init(null, new TrustManager[]{f6318a}, new SecureRandom());
            this.f6320c = instance.getSocketFactory();
        } catch (Exception e) {
            Log.e("TLSSocketFactory", "TLSSocketFactory error: ", e);
        }
    }

    public String[] getDefaultCipherSuites() {
        SSLSocketFactory sSLSocketFactory = this.f6320c;
        if (sSLSocketFactory != null) {
            return sSLSocketFactory.getDefaultCipherSuites();
        }
        return null;
    }

    public String[] getSupportedCipherSuites() {
        SSLSocketFactory sSLSocketFactory = this.f6320c;
        if (sSLSocketFactory != null) {
            return sSLSocketFactory.getSupportedCipherSuites();
        }
        return null;
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        SSLSocketFactory sSLSocketFactory = this.f6320c;
        if (sSLSocketFactory == null) {
            return null;
        }
        Socket createSocket = sSLSocketFactory.createSocket(socket, str, i, z);
        m7959a(createSocket);
        return createSocket;
    }

    public Socket createSocket(String str, int i) throws IOException {
        SSLSocketFactory sSLSocketFactory = this.f6320c;
        if (sSLSocketFactory == null) {
            return null;
        }
        Socket createSocket = sSLSocketFactory.createSocket(str, i);
        m7959a(createSocket);
        return createSocket;
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        SSLSocketFactory sSLSocketFactory = this.f6320c;
        if (sSLSocketFactory == null) {
            return null;
        }
        Socket createSocket = sSLSocketFactory.createSocket(str, i, inetAddress, i2);
        m7959a(createSocket);
        return createSocket;
    }

    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        SSLSocketFactory sSLSocketFactory = this.f6320c;
        if (sSLSocketFactory == null) {
            return null;
        }
        Socket createSocket = sSLSocketFactory.createSocket(inetAddress, i);
        m7959a(createSocket);
        return createSocket;
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        SSLSocketFactory sSLSocketFactory = this.f6320c;
        if (sSLSocketFactory == null) {
            return null;
        }
        Socket createSocket = sSLSocketFactory.createSocket(inetAddress, i, inetAddress2, i2);
        m7959a(createSocket);
        return createSocket;
    }

    public Socket createSocket() throws IOException {
        SSLSocketFactory sSLSocketFactory = this.f6320c;
        if (sSLSocketFactory == null) {
            return null;
        }
        Socket createSocket = sSLSocketFactory.createSocket();
        m7959a(createSocket);
        return createSocket;
    }
}
