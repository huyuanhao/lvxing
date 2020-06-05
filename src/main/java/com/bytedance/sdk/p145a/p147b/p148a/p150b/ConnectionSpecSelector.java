package com.bytedance.sdk.p145a.p147b.p148a.p150b;

import com.bytedance.sdk.p145a.p147b.ConnectionSpec;
import com.bytedance.sdk.p145a.p147b.p148a.Internal;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

/* renamed from: com.bytedance.sdk.a.b.a.b.b */
public final class ConnectionSpecSelector {
    /* renamed from: a */
    private final List<ConnectionSpec> f5351a;
    /* renamed from: b */
    private int f5352b = 0;
    /* renamed from: c */
    private boolean f5353c;
    /* renamed from: d */
    private boolean f5354d;

    public ConnectionSpecSelector(List<ConnectionSpec> list) {
        this.f5351a = list;
    }

    /* renamed from: a */
    public ConnectionSpec mo13686a(SSLSocket sSLSocket) throws IOException {
        ConnectionSpec nVar;
        int i = this.f5352b;
        int size = this.f5351a.size();
        while (true) {
            if (i >= size) {
                nVar = null;
                break;
            }
            nVar = (ConnectionSpec) this.f5351a.get(i);
            if (nVar.mo14017a(sSLSocket)) {
                this.f5352b = i + 1;
                break;
            }
            i++;
        }
        if (nVar != null) {
            this.f5353c = m6893b(sSLSocket);
            Internal.f5302a.mo13659a(nVar, sSLSocket, this.f5354d);
            return nVar;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to find acceptable protocols. isFallback=");
        sb.append(this.f5354d);
        sb.append(", modes=");
        sb.append(this.f5351a);
        sb.append(", supported protocols=");
        sb.append(Arrays.toString(sSLSocket.getEnabledProtocols()));
        throw new UnknownServiceException(sb.toString());
    }

    /* renamed from: a */
    public boolean mo13687a(IOException iOException) {
        boolean z = true;
        this.f5354d = true;
        if (!this.f5353c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z2 = iOException instanceof SSLHandshakeException;
        if ((z2 && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        if (!z2 && !(iOException instanceof SSLProtocolException)) {
            z = false;
        }
        return z;
    }

    /* renamed from: b */
    private boolean m6893b(SSLSocket sSLSocket) {
        for (int i = this.f5352b; i < this.f5351a.size(); i++) {
            if (((ConnectionSpec) this.f5351a.get(i)).mo14017a(sSLSocket)) {
                return true;
            }
        }
        return false;
    }
}
