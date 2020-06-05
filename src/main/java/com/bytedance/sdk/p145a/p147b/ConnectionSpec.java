package com.bytedance.sdk.p145a.p147b;

import com.bytedance.sdk.p145a.p147b.p148a.C1876c;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* renamed from: com.bytedance.sdk.a.b.n */
public final class ConnectionSpec {
    /* renamed from: a */
    public static final ConnectionSpec f5919a = new C1929a(true).mo14026a(f5922h).mo14025a(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0).mo14024a(true).mo14028a();
    /* renamed from: b */
    public static final ConnectionSpec f5920b = new C1929a(f5919a).mo14025a(TlsVersion.TLS_1_0).mo14024a(true).mo14028a();
    /* renamed from: c */
    public static final ConnectionSpec f5921c = new C1929a(false).mo14028a();
    /* renamed from: h */
    private static final CipherSuite[] f5922h = {CipherSuite.f5845aX, CipherSuite.f5876bb, CipherSuite.f5846aY, CipherSuite.f5877bc, CipherSuite.f5883bi, CipherSuite.f5882bh, CipherSuite.f5872ay, CipherSuite.f5830aI, CipherSuite.f5873az, CipherSuite.f5831aJ, CipherSuite.f5854ag, CipherSuite.f5855ah, CipherSuite.f5799E, CipherSuite.f5803I, CipherSuite.f5891i};
    /* renamed from: d */
    final boolean f5923d;
    /* renamed from: e */
    final boolean f5924e;
    /* renamed from: f */
    final String[] f5925f;
    /* renamed from: g */
    final String[] f5926g;

    /* compiled from: ConnectionSpec */
    /* renamed from: com.bytedance.sdk.a.b.n$a */
    public static final class C1929a {
        /* renamed from: a */
        boolean f5927a;
        /* renamed from: b */
        String[] f5928b;
        /* renamed from: c */
        String[] f5929c;
        /* renamed from: d */
        boolean f5930d;

        C1929a(boolean z) {
            this.f5927a = z;
        }

        public C1929a(ConnectionSpec nVar) {
            this.f5927a = nVar.f5923d;
            this.f5928b = nVar.f5925f;
            this.f5929c = nVar.f5926g;
            this.f5930d = nVar.f5924e;
        }

        /* renamed from: a */
        public C1929a mo14026a(CipherSuite... kVarArr) {
            if (this.f5927a) {
                String[] strArr = new String[kVarArr.length];
                for (int i = 0; i < kVarArr.length; i++) {
                    strArr[i] = kVarArr[i].f5909bj;
                }
                return mo14027a(strArr);
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        /* renamed from: a */
        public C1929a mo14027a(String... strArr) {
            if (!this.f5927a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            } else if (strArr.length != 0) {
                this.f5928b = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
        }

        /* renamed from: a */
        public C1929a mo14025a(TlsVersion... adVarArr) {
            if (this.f5927a) {
                String[] strArr = new String[adVarArr.length];
                for (int i = 0; i < adVarArr.length; i++) {
                    strArr[i] = adVarArr[i].f5729f;
                }
                return mo14029b(strArr);
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        /* renamed from: b */
        public C1929a mo14029b(String... strArr) {
            if (!this.f5927a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            } else if (strArr.length != 0) {
                this.f5929c = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
        }

        /* renamed from: a */
        public C1929a mo14024a(boolean z) {
            if (this.f5927a) {
                this.f5930d = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        /* renamed from: a */
        public ConnectionSpec mo14028a() {
            return new ConnectionSpec(this);
        }
    }

    ConnectionSpec(C1929a aVar) {
        this.f5923d = aVar.f5927a;
        this.f5925f = aVar.f5928b;
        this.f5926g = aVar.f5929c;
        this.f5924e = aVar.f5930d;
    }

    /* renamed from: a */
    public boolean mo14016a() {
        return this.f5923d;
    }

    /* renamed from: b */
    public List<CipherSuite> mo14018b() {
        String[] strArr = this.f5925f;
        if (strArr != null) {
            return CipherSuite.m7449a(strArr);
        }
        return null;
    }

    /* renamed from: c */
    public List<TlsVersion> mo14019c() {
        String[] strArr = this.f5926g;
        if (strArr != null) {
            return TlsVersion.m7376a(strArr);
        }
        return null;
    }

    /* renamed from: d */
    public boolean mo14020d() {
        return this.f5924e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo14015a(SSLSocket sSLSocket, boolean z) {
        ConnectionSpec b = m7458b(sSLSocket, z);
        String[] strArr = b.f5926g;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = b.f5925f;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    /* renamed from: b */
    private ConnectionSpec m7458b(SSLSocket sSLSocket, boolean z) {
        String[] strArr;
        String[] strArr2;
        if (this.f5925f != null) {
            strArr = C1876c.m6967a(CipherSuite.f5821a, sSLSocket.getEnabledCipherSuites(), this.f5925f);
        } else {
            strArr = sSLSocket.getEnabledCipherSuites();
        }
        if (this.f5926g != null) {
            strArr2 = C1876c.m6967a(C1876c.f5405h, sSLSocket.getEnabledProtocols(), this.f5926g);
        } else {
            strArr2 = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int a = C1876c.m6951a(CipherSuite.f5821a, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && a != -1) {
            strArr = C1876c.m6968a(strArr, supportedCipherSuites[a]);
        }
        return new C1929a(this).mo14027a(strArr).mo14029b(strArr2).mo14028a();
    }

    /* renamed from: a */
    public boolean mo14017a(SSLSocket sSLSocket) {
        if (!this.f5923d) {
            return false;
        }
        if (this.f5926g != null && !C1876c.m6972b(C1876c.f5405h, this.f5926g, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        if (this.f5925f == null || C1876c.m6972b(CipherSuite.f5821a, this.f5925f, sSLSocket.getEnabledCipherSuites())) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ConnectionSpec)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        ConnectionSpec nVar = (ConnectionSpec) obj;
        boolean z = this.f5923d;
        if (z != nVar.f5923d) {
            return false;
        }
        return !z || (Arrays.equals(this.f5925f, nVar.f5925f) && Arrays.equals(this.f5926g, nVar.f5926g) && this.f5924e == nVar.f5924e);
    }

    public int hashCode() {
        if (this.f5923d) {
            return ((((527 + Arrays.hashCode(this.f5925f)) * 31) + Arrays.hashCode(this.f5926g)) * 31) + (!this.f5924e);
        }
        return 17;
    }

    public String toString() {
        if (!this.f5923d) {
            return "ConnectionSpec()";
        }
        String str = "[all enabled]";
        String obj = this.f5925f != null ? mo14018b().toString() : str;
        if (this.f5926g != null) {
            str = mo14019c().toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("ConnectionSpec(cipherSuites=");
        sb.append(obj);
        sb.append(", tlsVersions=");
        sb.append(str);
        sb.append(", supportsTlsExtensions=");
        sb.append(this.f5924e);
        sb.append(")");
        return sb.toString();
    }
}
