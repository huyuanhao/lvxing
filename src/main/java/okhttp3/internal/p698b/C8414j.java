package okhttp3.internal.p698b;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.C8357a;
import okhttp3.C8358aa;
import okhttp3.C8362ab;
import okhttp3.C8367ad;
import okhttp3.C8382g;
import okhttp3.C8506t;
import okhttp3.C8508u;
import okhttp3.C8513x;
import okhttp3.C8518z;
import okhttp3.C8518z.C8519a;
import okhttp3.internal.connection.C8434f;

/* compiled from: RetryAndFollowUpInterceptor */
/* renamed from: okhttp3.internal.b.j */
public final class C8414j implements C8508u {
    /* renamed from: a */
    private final C8513x f28520a;
    /* renamed from: b */
    private final boolean f28521b;
    /* renamed from: c */
    private volatile C8434f f28522c;
    /* renamed from: d */
    private Object f28523d;
    /* renamed from: e */
    private volatile boolean f28524e;

    public C8414j(C8513x xVar, boolean z) {
        this.f28520a = xVar;
        this.f28521b = z;
    }

    /* renamed from: a */
    public void mo40255a() {
        this.f28524e = true;
        C8434f fVar = this.f28522c;
        if (fVar != null) {
            fVar.mo40309f();
        }
    }

    /* renamed from: b */
    public boolean mo40257b() {
        return this.f28524e;
    }

    /* renamed from: a */
    public void mo40256a(Object obj) {
        this.f28523d = obj;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [okhttp3.z] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v4, types: [okhttp3.ab] */
    /* JADX WARNING: type inference failed for: r0v1, types: [okhttp3.z] */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v4, types: [okhttp3.z] */
    /* JADX WARNING: type inference failed for: r0v5, types: [okhttp3.z] */
    /* JADX WARNING: type inference failed for: r0v6, types: [okhttp3.ab] */
    /* JADX WARNING: type inference failed for: r0v7, types: [okhttp3.ab, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r12v0, types: [okhttp3.z] */
    /* JADX WARNING: type inference failed for: r1v15 */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: type inference failed for: r0v16, types: [okhttp3.ab] */
    /* JADX WARNING: type inference failed for: r0v17 */
    /* JADX WARNING: type inference failed for: r1v24 */
    /* JADX WARNING: type inference failed for: r0v18 */
    /* JADX WARNING: type inference failed for: r1v25 */
    /* JADX WARNING: type inference failed for: r0v19 */
    /* JADX WARNING: type inference failed for: r0v20 */
    /* JADX WARNING: type inference failed for: r0v21 */
    /* JADX WARNING: type inference failed for: r0v22 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r1v5
  assigns: []
  uses: []
	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:231)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:95)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:88)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:30)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
    /* JADX WARNING: Unknown variable types count: 8 */
    public okhttp3.C8362ab intercept(okhttp3.C8508u.C8509a r15) throws java.io.IOException {
        /*
        r14 = this;
        okhttp3.z r0 = r15.mo40246a()
        okhttp3.internal.b.g r15 = (okhttp3.internal.p698b.C8411g) r15
        okhttp3.e r7 = r15.mo40253h()
        okhttp3.p r8 = r15.mo40254i()
        okhttp3.internal.connection.f r9 = new okhttp3.internal.connection.f
        okhttp3.x r1 = r14.f28520a
        okhttp3.j r2 = r1.mo40612p()
        okhttp3.t r1 = r0.mo40645a()
        okhttp3.a r3 = r14.m36013a(r1)
        java.lang.Object r6 = r14.f28523d
        r1 = r9
        r4 = r7
        r5 = r8
        r1.m55430init(r2, r3, r4, r5, r6)
        r14.f28522c = r9
        r10 = 0
        r11 = 0
        r1 = r11
        r2 = 0
    L_0x002c:
        boolean r3 = r14.f28524e
        if (r3 != 0) goto L_0x011d
        okhttp3.ab r0 = r15.mo40245a(r0, r9, r11, r11)     // Catch:{ RouteException -> 0x0104, IOException -> 0x00f3 }
        if (r1 == 0) goto L_0x004e
        okhttp3.ab$a r0 = r0.mo40098i()
        okhttp3.ab$a r1 = r1.mo40098i()
        okhttp3.ab$a r1 = r1.mo40111a(r11)
        okhttp3.ab r1 = r1.mo40115a()
        okhttp3.ab$a r0 = r0.mo40119c(r1)
        okhttp3.ab r0 = r0.mo40115a()
    L_0x004e:
        okhttp3.ad r1 = r9.mo40305b()     // Catch:{ IOException -> 0x00ec }
        okhttp3.z r12 = r14.m36014a(r0, r1)     // Catch:{ IOException -> 0x00ec }
        if (r12 != 0) goto L_0x0060
        boolean r15 = r14.f28521b
        if (r15 != 0) goto L_0x005f
        r9.mo40307d()
    L_0x005f:
        return r0
    L_0x0060:
        okhttp3.ac r1 = r0.mo40097h()
        okhttp3.internal.C8417c.m36040a(r1)
        int r13 = r2 + 1
        r1 = 20
        if (r13 > r1) goto L_0x00d2
        okhttp3.aa r1 = r12.mo40649d()
        boolean r1 = r1 instanceof okhttp3.internal.p698b.C8416l
        if (r1 != 0) goto L_0x00c3
        okhttp3.t r1 = r12.mo40645a()
        boolean r1 = r14.m36017a(r0, r1)
        if (r1 != 0) goto L_0x009d
        r9.mo40307d()
        okhttp3.internal.connection.f r9 = new okhttp3.internal.connection.f
        okhttp3.x r1 = r14.f28520a
        okhttp3.j r2 = r1.mo40612p()
        okhttp3.t r1 = r12.mo40645a()
        okhttp3.a r3 = r14.m36013a(r1)
        java.lang.Object r6 = r14.f28523d
        r1 = r9
        r4 = r7
        r5 = r8
        r1.m55430init(r2, r3, r4, r5, r6)
        r14.f28522c = r9
        goto L_0x00a3
    L_0x009d:
        okhttp3.internal.b.c r1 = r9.mo40300a()
        if (r1 != 0) goto L_0x00a7
    L_0x00a3:
        r1 = r0
        r0 = r12
        r2 = r13
        goto L_0x002c
    L_0x00a7:
        java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        java.lang.String r2 = "Closing the body of "
        r1.append(r2)
        r1.append(r0)
        java.lang.String r0 = " didn't close its backing stream. Bad interceptor?"
        r1.append(r0)
        java.lang.String r0 = r1.toString()
        r15.<init>(r0)
        throw r15
    L_0x00c3:
        r9.mo40307d()
        java.net.HttpRetryException r15 = new java.net.HttpRetryException
        int r0 = r0.mo40091c()
        java.lang.String r1 = "Cannot retry streamed HTTP body"
        r15.<init>(r1, r0)
        throw r15
    L_0x00d2:
        r9.mo40307d()
        java.net.ProtocolException r15 = new java.net.ProtocolException
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r1 = "Too many follow-up requests: "
        r0.append(r1)
        r0.append(r13)
        java.lang.String r0 = r0.toString()
        r15.<init>(r0)
        throw r15
    L_0x00ec:
        r15 = move-exception
        r9.mo40307d()
        throw r15
    L_0x00f1:
        r15 = move-exception
        goto L_0x0116
    L_0x00f3:
        r3 = move-exception
        boolean r4 = r3 instanceof okhttp3.internal.http2.ConnectionShutdownException     // Catch:{ all -> 0x00f1 }
        if (r4 != 0) goto L_0x00fa
        r4 = 1
        goto L_0x00fb
    L_0x00fa:
        r4 = 0
    L_0x00fb:
        boolean r4 = r14.m36015a(r3, r9, r4, r0)     // Catch:{ all -> 0x00f1 }
        if (r4 == 0) goto L_0x0103
        goto L_0x002c
    L_0x0103:
        throw r3     // Catch:{ all -> 0x00f1 }
    L_0x0104:
        r3 = move-exception
        java.io.IOException r4 = r3.getLastConnectException()     // Catch:{ all -> 0x00f1 }
        boolean r4 = r14.m36015a(r4, r9, r10, r0)     // Catch:{ all -> 0x00f1 }
        if (r4 == 0) goto L_0x0111
        goto L_0x002c
    L_0x0111:
        java.io.IOException r15 = r3.getFirstConnectException()     // Catch:{ all -> 0x00f1 }
        throw r15     // Catch:{ all -> 0x00f1 }
    L_0x0116:
        r9.mo40302a(r11)
        r9.mo40307d()
        throw r15
    L_0x011d:
        r9.mo40307d()
        java.io.IOException r15 = new java.io.IOException
        java.lang.String r0 = "Canceled"
        r15.<init>(r0)
        throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.p698b.C8414j.intercept(okhttp3.u$a):okhttp3.ab");
    }

    /* renamed from: a */
    private C8357a m36013a(C8506t tVar) {
        C8382g gVar;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        if (tVar.mo40551c()) {
            SSLSocketFactory k = this.f28520a.mo40607k();
            hostnameVerifier = this.f28520a.mo40608l();
            sSLSocketFactory = k;
            gVar = this.f28520a.mo40609m();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            gVar = null;
        }
        C8357a aVar = new C8357a(tVar.mo40556f(), tVar.mo40557g(), this.f28520a.mo40605i(), this.f28520a.mo40606j(), sSLSocketFactory, hostnameVerifier, gVar, this.f28520a.mo40611o(), this.f28520a.mo40601e(), this.f28520a.mo40617u(), this.f28520a.mo40618v(), this.f28520a.mo40602f());
        return aVar;
    }

    /* renamed from: a */
    private boolean m36015a(IOException iOException, C8434f fVar, boolean z, C8518z zVar) {
        fVar.mo40302a(iOException);
        if (!this.f28520a.mo40615s()) {
            return false;
        }
        if ((!z || !(zVar.mo40649d() instanceof C8416l)) && m36016a(iOException, z) && fVar.mo40310g()) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private boolean m36016a(IOException iOException, boolean z) {
        boolean z2 = false;
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            if ((iOException instanceof SocketTimeoutException) && !z) {
                z2 = true;
            }
            return z2;
        } else if ((!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException)) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: a */
    private C8518z m36014a(C8362ab abVar, C8367ad adVar) throws IOException {
        Proxy proxy;
        if (abVar != null) {
            int c = abVar.mo40091c();
            String b = abVar.mo40088a().mo40646b();
            String str = "GET";
            C8358aa aaVar = null;
            if (c == 307 || c == 308) {
                if (!b.equals(str) && !b.equals("HEAD")) {
                    return null;
                }
            } else if (c == 401) {
                return this.f28520a.mo40610n().mo20012a(adVar, abVar);
            } else {
                if (c != 503) {
                    if (c == 407) {
                        if (adVar != null) {
                            proxy = adVar.mo40131b();
                        } else {
                            proxy = this.f28520a.mo40601e();
                        }
                        if (proxy.type() == Type.HTTP) {
                            return this.f28520a.mo40611o().mo20012a(adVar, abVar);
                        }
                        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                    } else if (c != 408) {
                        switch (c) {
                            case 300:
                            case 301:
                            case 302:
                            case 303:
                                break;
                            default:
                                return null;
                        }
                    } else if (!this.f28520a.mo40615s() || (abVar.mo40088a().mo40649d() instanceof C8416l)) {
                        return null;
                    } else {
                        if ((abVar.mo40100k() == null || abVar.mo40100k().mo40091c() != 408) && m36012a(abVar, 0) <= 0) {
                            return abVar.mo40088a();
                        }
                        return null;
                    }
                } else if ((abVar.mo40100k() == null || abVar.mo40100k().mo40091c() != 503) && m36012a(abVar, (int) ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) == 0) {
                    return abVar.mo40088a();
                } else {
                    return null;
                }
            }
            if (!this.f28520a.mo40614r()) {
                return null;
            }
            String b2 = abVar.mo40089b("Location");
            if (b2 == null) {
                return null;
            }
            C8506t c2 = abVar.mo40088a().mo40645a().mo40550c(b2);
            if (c2 == null) {
                return null;
            }
            if (!c2.mo40549b().equals(abVar.mo40088a().mo40645a().mo40549b()) && !this.f28520a.mo40613q()) {
                return null;
            }
            C8519a e = abVar.mo40088a().mo40650e();
            if (C8410f.m35992c(b)) {
                boolean d = C8410f.m35993d(b);
                if (C8410f.m35994e(b)) {
                    e.mo40657a(str, (C8358aa) null);
                } else {
                    if (d) {
                        aaVar = abVar.mo40088a().mo40649d();
                    }
                    e.mo40657a(b, aaVar);
                }
                if (!d) {
                    e.mo40661b("Transfer-Encoding");
                    e.mo40661b("Content-Length");
                    e.mo40661b("Content-Type");
                }
            }
            if (!m36017a(abVar, c2)) {
                e.mo40661b("Authorization");
            }
            return e.mo40660a(c2).mo40663b();
        }
        throw new IllegalStateException();
    }

    /* renamed from: a */
    private int m36012a(C8362ab abVar, int i) {
        String b = abVar.mo40089b("Retry-After");
        if (b == null) {
            return i;
        }
        return b.matches("\\d+") ? Integer.valueOf(b).intValue() : ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    }

    /* renamed from: a */
    private boolean m36017a(C8362ab abVar, C8506t tVar) {
        C8506t a = abVar.mo40088a().mo40645a();
        return a.mo40556f().equals(tVar.mo40556f()) && a.mo40557g() == tVar.mo40557g() && a.mo40549b().equals(tVar.mo40549b());
    }
}
