package com.bytedance.sdk.adnet.core;

import android.text.TextUtils;
import com.bytedance.sdk.adnet.AdNetSdk;
import com.bytedance.sdk.adnet.err.AuthFailureError;
import com.bytedance.sdk.adnet.p161d.TLSSocketFactory;
import com.bytedance.sdk.adnet.p162e.IHttpStack;
import com.bytedance.sdk.p145a.p147b.C1918ab.C1919a;
import com.bytedance.sdk.p145a.p147b.C1935u;
import com.bytedance.sdk.p145a.p147b.MediaType;
import com.bytedance.sdk.p145a.p147b.OkHttpClient;
import com.bytedance.sdk.p145a.p147b.OkHttpClient.C1941a;
import com.bytedance.sdk.p145a.p147b.RequestBody;
import com.bytedance.sdk.p145a.p147b.ResponseBody;
import com.bytedance.sdk.p145a.p147b.p148a.p157i.OkHostnameVerifier;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.bytedance.sdk.adnet.core.m */
public class OkStack implements IHttpStack {
    /* renamed from: a */
    private final OkHttpClient f6280a;

    /* compiled from: OkStack */
    /* renamed from: com.bytedance.sdk.adnet.core.m$a */
    static class C1979a extends FilterInputStream {
        /* renamed from: a */
        private final ResponseBody f6281a;

        C1979a(ResponseBody cVar) {
            super(OkStack.m7899b(cVar));
            this.f6281a = cVar;
        }

        public void close() throws IOException {
            super.close();
            try {
                this.f6281a.close();
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    private static boolean m7898a(int i, int i2) {
        return (i == 4 || (100 <= i2 && i2 < 200) || i2 == 204 || i2 == 304) ? false : true;
    }

    public OkStack() {
        this.f6280a = new C1941a().mo14144a(10000, TimeUnit.MILLISECONDS).mo14149b(10000, TimeUnit.MILLISECONDS).mo14151c(10000, TimeUnit.MILLISECONDS).mo14148a();
    }

    public OkStack(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager, HostnameVerifier hostnameVerifier) {
        C1941a c = new C1941a().mo14144a(10000, TimeUnit.MILLISECONDS).mo14149b(10000, TimeUnit.MILLISECONDS).mo14151c(10000, TimeUnit.MILLISECONDS);
        if (hostnameVerifier == null) {
            hostnameVerifier = OkHostnameVerifier.f5699a;
        }
        C1941a a = c.mo14145a(hostnameVerifier);
        if (sSLSocketFactory == null) {
            sSLSocketFactory = new TLSSocketFactory();
        }
        if (x509TrustManager == null) {
            x509TrustManager = TLSSocketFactory.f6318a;
        }
        this.f6280a = a.mo14146a(sSLSocketFactory, x509TrustManager).mo14148a();
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0104  */
    /* renamed from: a */
    public com.bytedance.sdk.adnet.core.HttpResponse mo14352a(com.bytedance.sdk.adnet.core.Request<?> r8, java.util.Map<java.lang.String, java.lang.String> r9) throws java.io.IOException, com.bytedance.sdk.adnet.err.VAdError {
        /*
        r7 = this;
        int r0 = r8.getTimeoutMs()
        com.bytedance.sdk.a.b.z r1 = r7.f6280a
        com.bytedance.sdk.a.b.z$a r1 = r1.mo14143y()
        long r2 = (long) r0
        java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.MILLISECONDS
        com.bytedance.sdk.a.b.z$a r0 = r1.mo14144a(r2, r0)
        java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.MILLISECONDS
        com.bytedance.sdk.a.b.z$a r0 = r0.mo14149b(r2, r1)
        java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.MILLISECONDS
        com.bytedance.sdk.a.b.z$a r0 = r0.mo14151c(r2, r1)
        r1 = 1
        com.bytedance.sdk.a.b.z$a r0 = r0.mo14150b(r1)
        com.bytedance.sdk.a.b.z$a r0 = r0.mo14147a(r1)
        com.bytedance.sdk.a.b.z r0 = r0.mo14148a()
        com.bytedance.sdk.a.b.ab$a r2 = r7.m7901c(r8)
        if (r2 == 0) goto L_0x0108
        r7.m7897a(r8)
        java.lang.String r3 = r8.getUserAgent()
        boolean r3 = android.text.TextUtils.isEmpty(r3)
        if (r3 != 0) goto L_0x0062
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>()
        java.lang.String r4 = r8.getUserAgent()
        r3.append(r4)
        java.lang.String r4 = " "
        r3.append(r4)
        java.lang.String r4 = com.bytedance.sdk.p145a.p147b.p148a.Version.m7030a()
        r3.append(r4)
        java.lang.String r3 = r3.toString()
        java.lang.String r4 = "User-Agent"
        com.bytedance.sdk.a.b.ab$a r5 = r2.mo13923a(r4)
        r5.mo13929b(r4, r3)
    L_0x0062:
        java.util.Map r3 = r8.getHeaders()
        if (r3 == 0) goto L_0x0086
        java.util.Set r4 = r3.keySet()
        java.util.Iterator r4 = r4.iterator()
    L_0x0070:
        boolean r5 = r4.hasNext()
        if (r5 == 0) goto L_0x0086
        java.lang.Object r5 = r4.next()
        java.lang.String r5 = (java.lang.String) r5
        java.lang.Object r6 = r3.get(r5)
        java.lang.String r6 = (java.lang.String) r6
        r2.mo13929b(r5, r6)
        goto L_0x0070
    L_0x0086:
        if (r9 == 0) goto L_0x00a6
        java.util.Set r3 = r9.keySet()
        java.util.Iterator r3 = r3.iterator()
    L_0x0090:
        boolean r4 = r3.hasNext()
        if (r4 == 0) goto L_0x00a6
        java.lang.Object r4 = r3.next()
        java.lang.String r4 = (java.lang.String) r4
        java.lang.Object r5 = r9.get(r4)
        java.lang.String r5 = (java.lang.String) r5
        r2.mo13925a(r4, r5)
        goto L_0x0090
    L_0x00a6:
        m7896a(r2, r8)
        com.bytedance.sdk.a.b.ab r9 = r2.mo13933d()
        com.bytedance.sdk.a.b.h r9 = r0.mo14119a(r9)
        com.bytedance.sdk.a.b.b r9 = r9.mo13902a()
        com.bytedance.sdk.a.b.a.c.k r0 = com.bytedance.sdk.p145a.p147b.p148a.p151c.StatusLine.m7028a(r9)
        com.bytedance.sdk.a.b.c r2 = r9.mo13946g()
        r3 = 0
        int r0 = r0.f5446b     // Catch:{ all -> 0x0101 }
        r4 = -1
        if (r0 == r4) goto L_0x00f9
        int r8 = r8.getMethod()     // Catch:{ all -> 0x0101 }
        boolean r8 = m7898a(r8, r0)     // Catch:{ all -> 0x0101 }
        if (r8 != 0) goto L_0x00de
        com.bytedance.sdk.adnet.core.b r8 = new com.bytedance.sdk.adnet.core.b     // Catch:{ all -> 0x0101 }
        com.bytedance.sdk.a.b.u r9 = r9.mo13945f()     // Catch:{ all -> 0x0101 }
        java.util.List r9 = m7895a(r9)     // Catch:{ all -> 0x0101 }
        r8.m43141init(r0, r9)     // Catch:{ all -> 0x0101 }
        r2.close()
        return r8
    L_0x00de:
        com.bytedance.sdk.adnet.core.b r8 = new com.bytedance.sdk.adnet.core.b     // Catch:{ all -> 0x00f6 }
        com.bytedance.sdk.a.b.u r9 = r9.mo13945f()     // Catch:{ all -> 0x00f6 }
        java.util.List r9 = m7895a(r9)     // Catch:{ all -> 0x00f6 }
        long r3 = r2.mo13744a()     // Catch:{ all -> 0x00f6 }
        int r4 = (int) r3     // Catch:{ all -> 0x00f6 }
        com.bytedance.sdk.adnet.core.m$a r3 = new com.bytedance.sdk.adnet.core.m$a     // Catch:{ all -> 0x00f6 }
        r3.m43175init(r2)     // Catch:{ all -> 0x00f6 }
        r8.m43142init(r0, r9, r4, r3)     // Catch:{ all -> 0x00f6 }
        return r8
    L_0x00f6:
        r8 = move-exception
        r3 = 1
        goto L_0x0102
    L_0x00f9:
        java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x0101 }
        java.lang.String r9 = "Could not retrieve response code from HttpUrlConnection."
        r8.<init>(r9)     // Catch:{ all -> 0x0101 }
        throw r8     // Catch:{ all -> 0x0101 }
    L_0x0101:
        r8 = move-exception
    L_0x0102:
        if (r3 != 0) goto L_0x0107
        r2.close()
    L_0x0107:
        throw r8
    L_0x0108:
        java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
        java.lang.String r9 = "request params maybe null"
        r8.<init>(r9)
        throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.adnet.core.OkStack.mo14352a(com.bytedance.sdk.adnet.core.Request, java.util.Map):com.bytedance.sdk.adnet.core.b");
    }

    /* renamed from: a */
    private void m7897a(Request<?> request) {
        if (request != null) {
            request.setIpAddrStr(m7900b(request));
        }
    }

    /* renamed from: b */
    private String m7900b(Request<?> request) {
        String str = "";
        if (request == null || request.getUrl() == null) {
            return str;
        }
        try {
            str = InetAddress.getByName(new URL(request.getUrl()).getHost()).getHostAddress();
            return str;
        } catch (Exception unused) {
            return str;
        }
    }

    /* renamed from: c */
    private C1919a m7901c(Request request) throws IOException {
        String str = null;
        if (request == null || request.getUrl() == null) {
            return null;
        }
        C1919a aVar = new C1919a();
        URL url = new URL(request.getUrl());
        String host = url.getHost();
        if (AdNetSdk.f6053a != null) {
            str = AdNetSdk.f6053a.mo14375a(host);
        }
        boolean z = false;
        if (!TextUtils.isEmpty(str)) {
            try {
                aVar.mo13926a(new URL(url.toString().replaceFirst(host, str))).mo13929b("Host", host);
                z = true;
            } catch (Exception unused) {
            }
        }
        if (!z) {
            aVar.mo13926a(url);
        }
        return aVar;
    }

    /* renamed from: a */
    private static List<C1969a> m7895a(C1935u uVar) {
        if (uVar == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(uVar.mo14069a());
        int a = uVar.mo14069a();
        for (int i = 0; i < a; i++) {
            String a2 = uVar.mo14070a(i);
            String b = uVar.mo14073b(i);
            if (a2 != null) {
                arrayList.add(new C1969a(a2, b));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static void m7896a(C1919a aVar, Request<?> request) throws IOException, AuthFailureError {
        switch (request.getMethod()) {
            case -1:
                byte[] postBody = request.getPostBody();
                if (postBody != null) {
                    aVar.mo13920a(RequestBody.m7367a(MediaType.m7593a(request.getBodyContentType()), postBody));
                    return;
                }
                return;
            case 0:
                aVar.mo13919a();
                return;
            case 1:
                aVar.mo13920a(m7902d(request));
                return;
            case 2:
                aVar.mo13931c(m7902d(request));
                return;
            case 3:
                aVar.mo13930c();
                return;
            case 4:
                aVar.mo13927b();
                return;
            case 5:
                aVar.mo13924a("OPTIONS", (RequestBody) null);
                return;
            case 6:
                aVar.mo13924a("TRACE", (RequestBody) null);
                return;
            case 7:
                aVar.mo13932d(m7902d(request));
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    /* renamed from: d */
    private static RequestBody m7902d(Request request) throws AuthFailureError {
        byte[] body = request.getBody();
        if (body == null) {
            if (request.getMethod() != 1) {
                return null;
            }
            body = "".getBytes();
        }
        return RequestBody.m7367a(MediaType.m7593a(request.getBodyContentType()), body);
    }

    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static InputStream m7899b(ResponseBody cVar) {
        if (cVar == null) {
            return null;
        }
        return cVar.mo13967c();
    }
}
