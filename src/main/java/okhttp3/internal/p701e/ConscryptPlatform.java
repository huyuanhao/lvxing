package okhttp3.internal.p701e;

import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Protocol;
import org.conscrypt.Conscrypt;
import org.conscrypt.OpenSSLProvider;

/* renamed from: okhttp3.internal.e.b */
public class ConscryptPlatform extends C8447f {
    private ConscryptPlatform() {
    }

    /* renamed from: f */
    private Provider m36176f() {
        return new OpenSSLProvider();
    }

    /* renamed from: a */
    public void mo40326a(SSLSocket sSLSocket, String str, List<Protocol> list) {
        if (Conscrypt.isConscrypt(sSLSocket)) {
            if (str != null) {
                Conscrypt.setUseSessionTickets(sSLSocket, true);
                Conscrypt.setHostname(sSLSocket, str);
            }
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) C8447f.m36195a(list).toArray(new String[0]));
            return;
        }
        super.mo40326a(sSLSocket, str, list);
    }

    @Nullable
    /* renamed from: a */
    public String mo40321a(SSLSocket sSLSocket) {
        if (Conscrypt.isConscrypt(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return super.mo40321a(sSLSocket);
    }

    /* renamed from: b */
    public SSLContext mo40327b() {
        try {
            return SSLContext.getInstance("TLS", m36176f());
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No TLS provider", e);
        }
    }

    /* renamed from: a */
    public static C8447f m36175a() {
        try {
            Class.forName("org.conscrypt.ConscryptEngineSocket");
            if (!Conscrypt.isAvailable()) {
                return null;
            }
            return new ConscryptPlatform();
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public void mo40338a(SSLSocketFactory sSLSocketFactory) {
        if (Conscrypt.isConscrypt(sSLSocketFactory)) {
            Conscrypt.setUseEngineSocket(sSLSocketFactory, true);
        }
    }
}
