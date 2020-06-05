package okhttp3;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.C8417c;

/* compiled from: ConnectionSpec */
/* renamed from: okhttp3.k */
public final class C8490k {
    /* renamed from: a */
    public static final C8490k f28837a = new C8491a(true).mo40478a(f28841i).mo40477a(TlsVersion.TLS_1_2).mo40475a(true).mo40479a();
    /* renamed from: b */
    public static final C8490k f28838b = new C8491a(true).mo40478a(f28842j).mo40477a(TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0).mo40475a(true).mo40479a();
    /* renamed from: c */
    public static final C8490k f28839c = new C8491a(f28838b).mo40477a(TlsVersion.TLS_1_0).mo40475a(true).mo40479a();
    /* renamed from: d */
    public static final C8490k f28840d = new C8491a(false).mo40479a();
    /* renamed from: i */
    private static final C8385h[] f28841i = {C8385h.f28366aX, C8385h.f28397bb, C8385h.f28367aY, C8385h.f28398bc, C8385h.f28404bi, C8385h.f28403bh};
    /* renamed from: j */
    private static final C8385h[] f28842j = {C8385h.f28366aX, C8385h.f28397bb, C8385h.f28367aY, C8385h.f28398bc, C8385h.f28404bi, C8385h.f28403bh, C8385h.f28351aI, C8385h.f28352aJ, C8385h.f28375ag, C8385h.f28376ah, C8385h.f28320E, C8385h.f28324I, C8385h.f28413i};
    /* renamed from: e */
    final boolean f28843e;
    /* renamed from: f */
    final boolean f28844f;
    @Nullable
    /* renamed from: g */
    final String[] f28845g;
    @Nullable
    /* renamed from: h */
    final String[] f28846h;

    /* compiled from: ConnectionSpec */
    /* renamed from: okhttp3.k$a */
    public static final class C8491a {
        /* renamed from: a */
        boolean f28847a;
        @Nullable
        /* renamed from: b */
        String[] f28848b;
        @Nullable
        /* renamed from: c */
        String[] f28849c;
        /* renamed from: d */
        boolean f28850d;

        C8491a(boolean z) {
            this.f28847a = z;
        }

        public C8491a(C8490k kVar) {
            this.f28847a = kVar.f28843e;
            this.f28848b = kVar.f28845g;
            this.f28849c = kVar.f28846h;
            this.f28850d = kVar.f28844f;
        }

        /* renamed from: a */
        public C8491a mo40478a(C8385h... hVarArr) {
            if (this.f28847a) {
                String[] strArr = new String[hVarArr.length];
                for (int i = 0; i < hVarArr.length; i++) {
                    strArr[i] = hVarArr[i].f28431bk;
                }
                return mo40476a(strArr);
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        /* renamed from: a */
        public C8491a mo40476a(String... strArr) {
            if (!this.f28847a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            } else if (strArr.length != 0) {
                this.f28848b = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
        }

        /* renamed from: a */
        public C8491a mo40477a(TlsVersion... tlsVersionArr) {
            if (this.f28847a) {
                String[] strArr = new String[tlsVersionArr.length];
                for (int i = 0; i < tlsVersionArr.length; i++) {
                    strArr[i] = tlsVersionArr[i].javaName;
                }
                return mo40480b(strArr);
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        /* renamed from: b */
        public C8491a mo40480b(String... strArr) {
            if (!this.f28847a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            } else if (strArr.length != 0) {
                this.f28849c = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
        }

        /* renamed from: a */
        public C8491a mo40475a(boolean z) {
            if (this.f28847a) {
                this.f28850d = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        /* renamed from: a */
        public C8490k mo40479a() {
            return new C8490k(this);
        }
    }

    C8490k(C8491a aVar) {
        this.f28843e = aVar.f28847a;
        this.f28845g = aVar.f28848b;
        this.f28846h = aVar.f28849c;
        this.f28844f = aVar.f28850d;
    }

    /* renamed from: a */
    public boolean mo40467a() {
        return this.f28843e;
    }

    @Nullable
    /* renamed from: b */
    public List<C8385h> mo40469b() {
        String[] strArr = this.f28845g;
        if (strArr != null) {
            return C8385h.m35892a(strArr);
        }
        return null;
    }

    @Nullable
    /* renamed from: c */
    public List<TlsVersion> mo40470c() {
        String[] strArr = this.f28846h;
        if (strArr != null) {
            return TlsVersion.forJavaNames(strArr);
        }
        return null;
    }

    /* renamed from: d */
    public boolean mo40471d() {
        return this.f28844f;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo40466a(SSLSocket sSLSocket, boolean z) {
        C8490k b = m36435b(sSLSocket, z);
        String[] strArr = b.f28846h;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = b.f28845g;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    /* renamed from: b */
    private C8490k m36435b(SSLSocket sSLSocket, boolean z) {
        String[] strArr;
        String[] strArr2;
        if (this.f28845g != null) {
            strArr = C8417c.m36047a(C8385h.f28342a, sSLSocket.getEnabledCipherSuites(), this.f28845g);
        } else {
            strArr = sSLSocket.getEnabledCipherSuites();
        }
        if (this.f28846h != null) {
            strArr2 = C8417c.m36047a(C8417c.f28535h, sSLSocket.getEnabledProtocols(), this.f28846h);
        } else {
            strArr2 = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int a = C8417c.m36027a(C8385h.f28342a, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && a != -1) {
            strArr = C8417c.m36048a(strArr, supportedCipherSuites[a]);
        }
        return new C8491a(this).mo40476a(strArr).mo40480b(strArr2).mo40479a();
    }

    /* renamed from: a */
    public boolean mo40468a(SSLSocket sSLSocket) {
        if (!this.f28843e) {
            return false;
        }
        if (this.f28846h != null && !C8417c.m36051b(C8417c.f28535h, this.f28846h, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        if (this.f28845g == null || C8417c.m36051b(C8385h.f28342a, this.f28845g, sSLSocket.getEnabledCipherSuites())) {
            return true;
        }
        return false;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof C8490k)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        C8490k kVar = (C8490k) obj;
        boolean z = this.f28843e;
        if (z != kVar.f28843e) {
            return false;
        }
        return !z || (Arrays.equals(this.f28845g, kVar.f28845g) && Arrays.equals(this.f28846h, kVar.f28846h) && this.f28844f == kVar.f28844f);
    }

    public int hashCode() {
        if (this.f28843e) {
            return ((((527 + Arrays.hashCode(this.f28845g)) * 31) + Arrays.hashCode(this.f28846h)) * 31) + (!this.f28844f);
        }
        return 17;
    }

    public String toString() {
        if (!this.f28843e) {
            return "ConnectionSpec()";
        }
        String str = "[all enabled]";
        String obj = this.f28845g != null ? mo40469b().toString() : str;
        if (this.f28846h != null) {
            str = mo40470c().toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("ConnectionSpec(cipherSuites=");
        sb.append(obj);
        sb.append(", tlsVersions=");
        sb.append(str);
        sb.append(", supportsTlsExtensions=");
        sb.append(this.f28844f);
        sb.append(")");
        return sb.toString();
    }
}
