package okhttp3.internal.connection;

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
import okhttp3.C8490k;
import okhttp3.internal.C8388a;

/* compiled from: ConnectionSpecSelector */
/* renamed from: okhttp3.internal.connection.b */
public final class C8429b {
    /* renamed from: a */
    private final List<C8490k> f28575a;
    /* renamed from: b */
    private int f28576b = 0;
    /* renamed from: c */
    private boolean f28577c;
    /* renamed from: d */
    private boolean f28578d;

    public C8429b(List<C8490k> list) {
        this.f28575a = list;
    }

    /* renamed from: a */
    public C8490k mo40275a(SSLSocket sSLSocket) throws IOException {
        C8490k kVar;
        int i = this.f28576b;
        int size = this.f28575a.size();
        while (true) {
            if (i >= size) {
                kVar = null;
                break;
            }
            kVar = (C8490k) this.f28575a.get(i);
            if (kVar.mo40468a(sSLSocket)) {
                this.f28576b = i + 1;
                break;
            }
            i++;
        }
        if (kVar != null) {
            this.f28577c = m36085b(sSLSocket);
            C8388a.f28432a.mo40196a(kVar, sSLSocket, this.f28578d);
            return kVar;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to find acceptable protocols. isFallback=");
        sb.append(this.f28578d);
        sb.append(", modes=");
        sb.append(this.f28575a);
        sb.append(", supported protocols=");
        sb.append(Arrays.toString(sSLSocket.getEnabledProtocols()));
        throw new UnknownServiceException(sb.toString());
    }

    /* renamed from: a */
    public boolean mo40276a(IOException iOException) {
        boolean z = true;
        this.f28578d = true;
        if (!this.f28577c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
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
    private boolean m36085b(SSLSocket sSLSocket) {
        for (int i = this.f28576b; i < this.f28575a.size(); i++) {
            if (((C8490k) this.f28575a.get(i)).mo40468a(sSLSocket)) {
                return true;
            }
        }
        return false;
    }
}
