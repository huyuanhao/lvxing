package com.alibaba.mtl.log.p077d;

import android.net.SSLCertificateSocketFactory;
import android.os.Build.VERSION;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.alibaba.mtl.log.d.u */
public class UtSslSocketFactory extends SSLSocketFactory {
    /* renamed from: a */
    private Method f3431a = null;
    /* renamed from: b */
    private String f3432b;

    /* compiled from: UtSslSocketFactory */
    /* renamed from: com.alibaba.mtl.log.d.u$a */
    public static class C1331a implements X509TrustManager {
        /* renamed from: a */
        TrustManager f3433a;

        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public C1331a(TrustManager trustManager) {
            this.f3433a = trustManager;
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            try {
                ((X509TrustManager) this.f3433a).checkServerTrusted(x509CertificateArr, str);
            } catch (CertificateException e) {
                Throwable th = e;
                while (th.getCause() != null) {
                    th = th.getCause();
                    if (!(th instanceof CertificateExpiredException)) {
                        if (th instanceof CertificateNotYetValidException) {
                        }
                    }
                    Logger.m3833a("", th);
                    return;
                }
                throw e;
            }
        }
    }

    public Socket createSocket() throws IOException {
        return null;
    }

    public Socket createSocket(String str, int i) throws IOException {
        return null;
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        return null;
    }

    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return null;
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return null;
    }

    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String[] getSupportedCipherSuites() {
        return new String[0];
    }

    public UtSslSocketFactory(String str) {
        this.f3432b = str;
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        if (this.f3432b == null) {
            this.f3432b = str;
        }
        String str2 = "";
        Logger.m3833a(str2, "host", this.f3432b, "port", Integer.valueOf(i), "autoClose", Boolean.valueOf(z));
        InetAddress inetAddress = socket.getInetAddress();
        if (z) {
            socket.close();
        }
        SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0);
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance("X509");
            instance.init(null);
            sSLCertificateSocketFactory.setTrustManagers(new TrustManager[]{new C1331a(instance.getTrustManagers()[0])});
        } catch (Exception e) {
            Logger.m3833a(str2, e);
        }
        SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(inetAddress, i);
        sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
        if (VERSION.SDK_INT >= 17) {
            sSLCertificateSocketFactory.setHostname(sSLSocket, this.f3432b);
        } else {
            try {
                if (this.f3431a == null) {
                    this.f3431a = sSLSocket.getClass().getMethod("setHostname", new Class[]{String.class});
                    this.f3431a.setAccessible(true);
                }
                this.f3431a.invoke(sSLSocket, new Object[]{this.f3432b});
            } catch (Exception e2) {
                Logger.m3833a(str2, "SNI not useable", null, e2);
            }
        }
        Logger.m3833a(str2, "SSLSession PeerHost", sSLSocket.getSession().getPeerHost());
        return sSLSocket;
    }
}
