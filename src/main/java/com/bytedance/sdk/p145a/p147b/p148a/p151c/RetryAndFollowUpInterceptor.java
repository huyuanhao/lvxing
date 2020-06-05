package com.bytedance.sdk.p145a.p147b.p148a.p151c;

import com.bytedance.sdk.p145a.p147b.Address;
import com.bytedance.sdk.p145a.p147b.C1918ab;
import com.bytedance.sdk.p145a.p147b.C1918ab.C1919a;
import com.bytedance.sdk.p145a.p147b.CertificatePinner;
import com.bytedance.sdk.p145a.p147b.HttpUrl;
import com.bytedance.sdk.p145a.p147b.Interceptor;
import com.bytedance.sdk.p145a.p147b.OkHttpClient;
import com.bytedance.sdk.p145a.p147b.RequestBody;
import com.bytedance.sdk.p145a.p147b.Response;
import com.bytedance.sdk.p145a.p147b.Route;
import com.bytedance.sdk.p145a.p147b.p148a.p150b.RealConnection;
import com.bytedance.sdk.p145a.p147b.p148a.p150b.StreamAllocation;
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

/* renamed from: com.bytedance.sdk.a.b.a.c.j */
public final class RetryAndFollowUpInterceptor implements Interceptor {
    /* renamed from: a */
    private final OkHttpClient f5440a;
    /* renamed from: b */
    private final boolean f5441b;
    /* renamed from: c */
    private StreamAllocation f5442c;
    /* renamed from: d */
    private Object f5443d;
    /* renamed from: e */
    private volatile boolean f5444e;

    public RetryAndFollowUpInterceptor(OkHttpClient zVar, boolean z) {
        this.f5440a = zVar;
        this.f5441b = z;
    }

    /* renamed from: a */
    public boolean mo13747a() {
        return this.f5444e;
    }

    /* renamed from: a */
    public void mo13746a(Object obj) {
        this.f5443d = obj;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [com.bytedance.sdk.a.b.ab] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v4, types: [com.bytedance.sdk.a.b.b] */
    /* JADX WARNING: type inference failed for: r0v1, types: [com.bytedance.sdk.a.b.ab] */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v4, types: [com.bytedance.sdk.a.b.ab] */
    /* JADX WARNING: type inference failed for: r0v5, types: [com.bytedance.sdk.a.b.ab] */
    /* JADX WARNING: type inference failed for: r0v8, types: [com.bytedance.sdk.a.b.b] */
    /* JADX WARNING: type inference failed for: r0v9, types: [com.bytedance.sdk.a.b.b, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r11v0, types: [com.bytedance.sdk.a.b.ab] */
    /* JADX WARNING: type inference failed for: r1v14 */
    /* JADX WARNING: type inference failed for: r0v13 */
    /* JADX WARNING: type inference failed for: r0v18, types: [com.bytedance.sdk.a.b.b] */
    /* JADX WARNING: type inference failed for: r0v19 */
    /* JADX WARNING: type inference failed for: r1v25 */
    /* JADX WARNING: type inference failed for: r0v20 */
    /* JADX WARNING: type inference failed for: r1v26 */
    /* JADX WARNING: type inference failed for: r0v21 */
    /* JADX WARNING: type inference failed for: r0v22 */
    /* JADX WARNING: type inference failed for: r0v23 */
    /* JADX WARNING: type inference failed for: r0v24 */
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
    /* renamed from: a */
    public com.bytedance.sdk.p145a.p147b.Response mo13664a(com.bytedance.sdk.p145a.p147b.Interceptor.C1939a r15) throws java.io.IOException {
        /*
        r14 = this;
        com.bytedance.sdk.a.b.ab r0 = r15.mo13743i()
        com.bytedance.sdk.a.b.a.c.g r15 = (com.bytedance.sdk.p145a.p147b.p148a.p151c.RealInterceptorChain) r15
        com.bytedance.sdk.a.b.h r7 = r15.mo13741g()
        com.bytedance.sdk.a.b.s r8 = r15.mo13742h()
        com.bytedance.sdk.a.b.a.b.g r9 = new com.bytedance.sdk.a.b.a.b.g
        com.bytedance.sdk.a.b.z r1 = r14.f5440a
        com.bytedance.sdk.a.b.m r2 = r1.mo14133o()
        com.bytedance.sdk.a.b.v r1 = r0.mo13910a()
        com.bytedance.sdk.a.b.a r3 = r14.m7020a(r1)
        java.lang.Object r6 = r14.f5443d
        r1 = r9
        r4 = r7
        r5 = r8
        r1.m42936init(r2, r3, r4, r5, r6)
        r14.f5442c = r9
        r9 = 0
        r10 = 0
        r1 = r10
        r2 = 0
    L_0x002c:
        boolean r3 = r14.f5444e
        if (r3 != 0) goto L_0x0124
        com.bytedance.sdk.a.b.a.b.g r3 = r14.f5442c     // Catch:{ e -> 0x0107, IOException -> 0x00f6 }
        com.bytedance.sdk.a.b.b r0 = r15.mo13734a(r0, r3, r10, r10)     // Catch:{ e -> 0x0107, IOException -> 0x00f6 }
        if (r1 == 0) goto L_0x0050
        com.bytedance.sdk.a.b.b$a r0 = r0.mo13947h()
        com.bytedance.sdk.a.b.b$a r1 = r1.mo13947h()
        com.bytedance.sdk.a.b.b$a r1 = r1.mo13957a(r10)
        com.bytedance.sdk.a.b.b r1 = r1.mo13963a()
        com.bytedance.sdk.a.b.b$a r0 = r0.mo13966c(r1)
        com.bytedance.sdk.a.b.b r0 = r0.mo13963a()
    L_0x0050:
        com.bytedance.sdk.a.b.ab r11 = r14.m7021a(r0)
        if (r11 != 0) goto L_0x0060
        boolean r15 = r14.f5441b
        if (r15 != 0) goto L_0x005f
        com.bytedance.sdk.a.b.a.b.g r15 = r14.f5442c
        r15.mo13718c()
    L_0x005f:
        return r0
    L_0x0060:
        com.bytedance.sdk.a.b.c r1 = r0.mo13946g()
        com.bytedance.sdk.p145a.p147b.p148a.C1876c.m6961a(r1)
        int r12 = r2 + 1
        r1 = 20
        if (r12 > r1) goto L_0x00d8
        com.bytedance.sdk.a.b.ac r1 = r11.mo13914d()
        boolean r1 = r1 instanceof com.bytedance.sdk.p145a.p147b.p148a.p151c.UnrepeatableRequestBody
        if (r1 != 0) goto L_0x00c7
        com.bytedance.sdk.a.b.v r1 = r11.mo13910a()
        boolean r1 = r14.m7022a(r0, r1)
        if (r1 != 0) goto L_0x009f
        com.bytedance.sdk.a.b.a.b.g r1 = r14.f5442c
        r1.mo13718c()
        com.bytedance.sdk.a.b.a.b.g r13 = new com.bytedance.sdk.a.b.a.b.g
        com.bytedance.sdk.a.b.z r1 = r14.f5440a
        com.bytedance.sdk.a.b.m r2 = r1.mo14133o()
        com.bytedance.sdk.a.b.v r1 = r11.mo13910a()
        com.bytedance.sdk.a.b.a r3 = r14.m7020a(r1)
        java.lang.Object r6 = r14.f5443d
        r1 = r13
        r4 = r7
        r5 = r8
        r1.m42936init(r2, r3, r4, r5, r6)
        r14.f5442c = r13
        goto L_0x00a7
    L_0x009f:
        com.bytedance.sdk.a.b.a.b.g r1 = r14.f5442c
        com.bytedance.sdk.a.b.a.c.c r1 = r1.mo13711a()
        if (r1 != 0) goto L_0x00ab
    L_0x00a7:
        r1 = r0
        r0 = r11
        r2 = r12
        goto L_0x002c
    L_0x00ab:
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
    L_0x00c7:
        com.bytedance.sdk.a.b.a.b.g r15 = r14.f5442c
        r15.mo13718c()
        java.net.HttpRetryException r15 = new java.net.HttpRetryException
        int r0 = r0.mo13941c()
        java.lang.String r1 = "Cannot retry streamed HTTP body"
        r15.<init>(r1, r0)
        throw r15
    L_0x00d8:
        com.bytedance.sdk.a.b.a.b.g r15 = r14.f5442c
        r15.mo13718c()
        java.net.ProtocolException r15 = new java.net.ProtocolException
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r1 = "Too many follow-up requests: "
        r0.append(r1)
        r0.append(r12)
        java.lang.String r0 = r0.toString()
        r15.<init>(r0)
        throw r15
    L_0x00f4:
        r15 = move-exception
        goto L_0x0119
    L_0x00f6:
        r3 = move-exception
        boolean r4 = r3 instanceof com.bytedance.sdk.p145a.p147b.p148a.p153e.ConnectionShutdownException     // Catch:{ all -> 0x00f4 }
        if (r4 != 0) goto L_0x00fd
        r4 = 1
        goto L_0x00fe
    L_0x00fd:
        r4 = 0
    L_0x00fe:
        boolean r4 = r14.m7024a(r3, r4, r0)     // Catch:{ all -> 0x00f4 }
        if (r4 == 0) goto L_0x0106
        goto L_0x002c
    L_0x0106:
        throw r3     // Catch:{ all -> 0x00f4 }
    L_0x0107:
        r3 = move-exception
        java.io.IOException r4 = r3.mo13703a()     // Catch:{ all -> 0x00f4 }
        boolean r4 = r14.m7024a(r4, r9, r0)     // Catch:{ all -> 0x00f4 }
        if (r4 == 0) goto L_0x0114
        goto L_0x002c
    L_0x0114:
        java.io.IOException r15 = r3.mo13703a()     // Catch:{ all -> 0x00f4 }
        throw r15     // Catch:{ all -> 0x00f4 }
    L_0x0119:
        com.bytedance.sdk.a.b.a.b.g r0 = r14.f5442c
        r0.mo13715a(r10)
        com.bytedance.sdk.a.b.a.b.g r0 = r14.f5442c
        r0.mo13718c()
        throw r15
    L_0x0124:
        com.bytedance.sdk.a.b.a.b.g r15 = r14.f5442c
        r15.mo13718c()
        java.io.IOException r15 = new java.io.IOException
        java.lang.String r0 = "Canceled"
        r15.<init>(r0)
        throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.p145a.p147b.p148a.p151c.RetryAndFollowUpInterceptor.mo13664a(com.bytedance.sdk.a.b.x$a):com.bytedance.sdk.a.b.b");
    }

    /* renamed from: a */
    private Address m7020a(HttpUrl vVar) {
        CertificatePinner jVar;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        if (vVar.mo14087c()) {
            SSLSocketFactory j = this.f5440a.mo14128j();
            hostnameVerifier = this.f5440a.mo14129k();
            sSLSocketFactory = j;
            jVar = this.f5440a.mo14130l();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            jVar = null;
        }
        Address aVar = new Address(vVar.mo14092f(), vVar.mo14093g(), this.f5440a.mo14126h(), this.f5440a.mo14127i(), sSLSocketFactory, hostnameVerifier, jVar, this.f5440a.mo14132n(), this.f5440a.mo14122d(), this.f5440a.mo14138t(), this.f5440a.mo14139u(), this.f5440a.mo14123e());
        return aVar;
    }

    /* renamed from: a */
    private boolean m7024a(IOException iOException, boolean z, C1918ab abVar) {
        this.f5442c.mo13715a(iOException);
        if (!this.f5440a.mo14136r()) {
            return false;
        }
        if ((!z || !(abVar.mo13914d() instanceof UnrepeatableRequestBody)) && m7023a(iOException, z) && this.f5442c.mo13720e()) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private boolean m7023a(IOException iOException, boolean z) {
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
    private C1918ab m7021a(Response bVar) throws IOException {
        Proxy proxy;
        if (bVar != null) {
            RealConnection b = this.f5442c.mo13717b();
            RequestBody acVar = null;
            Route a = b != null ? b.mo13689a() : null;
            int c = bVar.mo13941c();
            String b2 = bVar.mo13937a().mo13912b();
            String str = "GET";
            if (c == 307 || c == 308) {
                if (!b2.equals(str) && !b2.equals("HEAD")) {
                    return null;
                }
            } else if (c == 401) {
                return this.f5440a.mo14131m().mo13976a(a, bVar);
            } else {
                if (c == 407) {
                    if (a != null) {
                        proxy = a.mo13970b();
                    } else {
                        proxy = this.f5440a.mo14122d();
                    }
                    if (proxy.type() == Type.HTTP) {
                        return this.f5440a.mo14132n().mo13976a(a, bVar);
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
                } else if (!this.f5440a.mo14136r() || (bVar.mo13937a().mo13914d() instanceof UnrepeatableRequestBody)) {
                    return null;
                } else {
                    if (bVar.mo13948i() == null || bVar.mo13948i().mo13941c() != 408) {
                        return bVar.mo13937a();
                    }
                    return null;
                }
            }
            if (!this.f5440a.mo14135q()) {
                return null;
            }
            String a2 = bVar.mo13938a("Location");
            if (a2 == null) {
                return null;
            }
            HttpUrl c2 = bVar.mo13937a().mo13910a().mo14086c(a2);
            if (c2 == null) {
                return null;
            }
            if (!c2.mo14085b().equals(bVar.mo13937a().mo13910a().mo14085b()) && !this.f5440a.mo14134p()) {
                return null;
            }
            C1919a e = bVar.mo13937a().mo13915e();
            if (HttpMethod.m7001c(b2)) {
                boolean d = HttpMethod.m7002d(b2);
                if (HttpMethod.m7003e(b2)) {
                    e.mo13924a(str, (RequestBody) null);
                } else {
                    if (d) {
                        acVar = bVar.mo13937a().mo13914d();
                    }
                    e.mo13924a(b2, acVar);
                }
                if (!d) {
                    e.mo13923a("Transfer-Encoding");
                    e.mo13923a("Content-Length");
                    e.mo13923a("Content-Type");
                }
            }
            if (!m7022a(bVar, c2)) {
                e.mo13923a("Authorization");
            }
            return e.mo13922a(c2).mo13933d();
        }
        throw new IllegalStateException();
    }

    /* renamed from: a */
    private boolean m7022a(Response bVar, HttpUrl vVar) {
        HttpUrl a = bVar.mo13937a().mo13910a();
        return a.mo14092f().equals(vVar.mo14092f()) && a.mo14093g() == vVar.mo14093g() && a.mo14085b().equals(vVar.mo14085b());
    }
}
