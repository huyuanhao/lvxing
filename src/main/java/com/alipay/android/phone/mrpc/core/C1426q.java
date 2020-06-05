package com.alipay.android.phone.mrpc.core;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.Callable;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

/* renamed from: com.alipay.android.phone.mrpc.core.q */
public final class C1426q implements Callable<C1430u> {
    /* renamed from: e */
    private static final HttpRequestRetryHandler f3660e = new C1407ad();
    /* renamed from: a */
    protected C1421l f3661a;
    /* renamed from: b */
    protected Context f3662b;
    /* renamed from: c */
    protected C1424o f3663c;
    /* renamed from: d */
    String f3664d;
    /* renamed from: f */
    private HttpUriRequest f3665f;
    /* renamed from: g */
    private HttpContext f3666g = new BasicHttpContext();
    /* renamed from: h */
    private CookieStore f3667h = new BasicCookieStore();
    /* renamed from: i */
    private CookieManager f3668i;
    /* renamed from: j */
    private AbstractHttpEntity f3669j;
    /* renamed from: k */
    private HttpHost f3670k;
    /* renamed from: l */
    private URL f3671l;
    /* renamed from: m */
    private int f3672m = 0;
    /* renamed from: n */
    private boolean f3673n = false;
    /* renamed from: o */
    private boolean f3674o = false;
    /* renamed from: p */
    private String f3675p = null;
    /* renamed from: q */
    private String f3676q;

    public C1426q(C1421l lVar, C1424o oVar) {
        this.f3661a = lVar;
        this.f3662b = this.f3661a.f3638a;
        this.f3663c = oVar;
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [int] */
    /* JADX WARNING: type inference failed for: r0v3, types: [int] */
    /* JADX WARNING: type inference failed for: r0v4, types: [int] */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v6, types: [long] */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v5
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
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
	at jadx.core.ProcessClass.process(ProcessClass.java:35)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
    /* JADX WARNING: Unknown variable types count: 6 */
    /* renamed from: a */
    private static long m4129a(java.lang.String[] r3) {
        /*
        r0 = 0
    L_0x0001:
        int r1 = r3.length
        if (r0 >= r1) goto L_0x001e
        r1 = r3[r0]
        java.lang.String r2 = "max-age"
        boolean r1 = r2.equalsIgnoreCase(r1)
        if (r1 == 0) goto L_0x001b
        int r1 = r0 + 1
        r2 = r3[r1]
        if (r2 == 0) goto L_0x001b
        r1 = r3[r1]     // Catch:{ Exception -> 0x001b }
        long r0 = java.lang.Long.parseLong(r1)     // Catch:{ Exception -> 0x001b }
        return r0
    L_0x001b:
        int r0 = r0 + 1
        goto L_0x0001
    L_0x001e:
        r0 = 0
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.android.phone.mrpc.core.C1426q.m4129a(java.lang.String[]):long");
    }

    /* renamed from: a */
    private static HttpUrlHeader m4130a(HttpResponse httpResponse) {
        Header[] allHeaders;
        HttpUrlHeader httpUrlHeader = new HttpUrlHeader();
        for (Header header : httpResponse.getAllHeaders()) {
            httpUrlHeader.setHead(header.getName(), header.getValue());
        }
        return httpUrlHeader;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00c0 A[SYNTHETIC, Splitter:B:23:0x00c0] */
    /* renamed from: a */
    private com.alipay.android.phone.mrpc.core.C1430u m4131a(org.apache.http.HttpResponse r10, int r11, java.lang.String r12) {
        /*
        r9 = this;
        java.lang.String r0 = "ArrayOutputStream close error!"
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        java.lang.String r2 = "开始handle，handleResponse-1,"
        r1.<init>(r2)
        java.lang.Thread r2 = java.lang.Thread.currentThread()
        long r2 = r2.getId()
        r1.append(r2)
        org.apache.http.HttpEntity r1 = r10.getEntity()
        r2 = 0
        if (r1 == 0) goto L_0x00d0
        org.apache.http.StatusLine r3 = r10.getStatusLine()
        int r3 = r3.getStatusCode()
        r4 = 200(0xc8, float:2.8E-43)
        if (r3 != r4) goto L_0x00d0
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        java.lang.String r4 = "200，开始处理，handleResponse-2,threadid = "
        r3.<init>(r4)
        java.lang.Thread r4 = java.lang.Thread.currentThread()
        long r4 = r4.getId()
        r3.append(r4)
        java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x00bc }
        r3.<init>()     // Catch:{ all -> 0x00bc }
        long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00ba }
        r9.m4133a(r1, r3)     // Catch:{ all -> 0x00ba }
        byte[] r1 = r3.toByteArray()     // Catch:{ all -> 0x00ba }
        r6 = 0
        r9.f3674o = r6     // Catch:{ all -> 0x00ba }
        com.alipay.android.phone.mrpc.core.l r6 = r9.f3661a     // Catch:{ all -> 0x00ba }
        long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00ba }
        long r7 = r7 - r4
        r6.mo11971c(r7)     // Catch:{ all -> 0x00ba }
        com.alipay.android.phone.mrpc.core.l r4 = r9.f3661a     // Catch:{ all -> 0x00ba }
        int r5 = r1.length     // Catch:{ all -> 0x00ba }
        long r5 = (long) r5     // Catch:{ all -> 0x00ba }
        r4.mo11969a(r5)     // Catch:{ all -> 0x00ba }
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ba }
        java.lang.String r5 = "res:"
        r4.<init>(r5)     // Catch:{ all -> 0x00ba }
        int r5 = r1.length     // Catch:{ all -> 0x00ba }
        r4.append(r5)     // Catch:{ all -> 0x00ba }
        com.alipay.android.phone.mrpc.core.p r4 = new com.alipay.android.phone.mrpc.core.p     // Catch:{ all -> 0x00ba }
        com.alipay.android.phone.mrpc.core.HttpUrlHeader r5 = m4130a(r10)     // Catch:{ all -> 0x00ba }
        r4.m42047init(r5, r11, r12, r1)     // Catch:{ all -> 0x00ba }
        long r11 = m4134b(r10)     // Catch:{ all -> 0x00ba }
        org.apache.http.HttpEntity r10 = r10.getEntity()     // Catch:{ all -> 0x00ba }
        org.apache.http.Header r10 = r10.getContentType()     // Catch:{ all -> 0x00ba }
        if (r10 == 0) goto L_0x0099
        java.lang.String r10 = r10.getValue()     // Catch:{ all -> 0x00ba }
        java.util.HashMap r10 = m4132a(r10)     // Catch:{ all -> 0x00ba }
        java.lang.String r1 = "charset"
        java.lang.Object r1 = r10.get(r1)     // Catch:{ all -> 0x00ba }
        r2 = r1
        java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x00ba }
        java.lang.String r1 = "Content-Type"
        java.lang.Object r10 = r10.get(r1)     // Catch:{ all -> 0x00ba }
        java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x00ba }
        goto L_0x009a
    L_0x0099:
        r10 = r2
    L_0x009a:
        r4.mo11997b(r10)     // Catch:{ all -> 0x00ba }
        r4.mo11990a(r2)     // Catch:{ all -> 0x00ba }
        long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00ba }
        r4.mo11989a(r1)     // Catch:{ all -> 0x00ba }
        r4.mo11991b(r11)     // Catch:{ all -> 0x00ba }
        r3.close()     // Catch:{ IOException -> 0x00af }
        r2 = r4
        goto L_0x00d9
    L_0x00af:
        r10 = move-exception
        java.lang.RuntimeException r11 = new java.lang.RuntimeException
        java.lang.Throwable r10 = r10.getCause()
        r11.<init>(r0, r10)
        throw r11
    L_0x00ba:
        r10 = move-exception
        goto L_0x00be
    L_0x00bc:
        r10 = move-exception
        r3 = r2
    L_0x00be:
        if (r3 == 0) goto L_0x00cf
        r3.close()     // Catch:{ IOException -> 0x00c4 }
        goto L_0x00cf
    L_0x00c4:
        r10 = move-exception
        java.lang.RuntimeException r11 = new java.lang.RuntimeException
        java.lang.Throwable r10 = r10.getCause()
        r11.<init>(r0, r10)
        throw r11
    L_0x00cf:
        throw r10
    L_0x00d0:
        if (r1 != 0) goto L_0x00d9
        org.apache.http.StatusLine r10 = r10.getStatusLine()
        r10.getStatusCode()
    L_0x00d9:
        return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.android.phone.mrpc.core.C1426q.m4131a(org.apache.http.HttpResponse, int, java.lang.String):com.alipay.android.phone.mrpc.core.u");
    }

    /* renamed from: a */
    private static HashMap<String, String> m4132a(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        String[] split = str.split(";");
        int length = split.length;
        for (int i = 0; i < length; i++) {
            String str2 = split[i];
            String[] split2 = str2.indexOf(61) == -1 ? new String[]{"Content-Type", str2} : str2.split("=");
            hashMap.put(split2[0], split2[1]);
        }
        return hashMap;
    }

    /* renamed from: a */
    private void m4133a(HttpEntity httpEntity, OutputStream outputStream) {
        InputStream a = C1408b.m4080a(httpEntity);
        long contentLength = httpEntity.getContentLength();
        try {
            byte[] bArr = new byte[2048];
            while (true) {
                int read = a.read(bArr);
                if (read == -1 || this.f3663c.mo11996h()) {
                    outputStream.flush();
                } else {
                    outputStream.write(bArr, 0, read);
                    if (this.f3663c.mo11994f() != null) {
                        int i = (contentLength > 0 ? 1 : (contentLength == 0 ? 0 : -1));
                    }
                }
            }
            outputStream.flush();
            C1427r.m4144a(a);
        } catch (Exception e) {
            e.getCause();
            StringBuilder sb = new StringBuilder("HttpWorker Request Error!");
            sb.append(e.getLocalizedMessage());
            throw new IOException(sb.toString());
        } catch (Throwable th) {
            C1427r.m4144a(a);
            throw th;
        }
    }

    /* renamed from: b */
    private static long m4134b(HttpResponse httpResponse) {
        Header firstHeader = httpResponse.getFirstHeader("Cache-Control");
        if (firstHeader != null) {
            String[] split = firstHeader.getValue().split("=");
            if (split.length >= 2) {
                try {
                    return m4129a(split);
                } catch (NumberFormatException unused) {
                }
            }
        }
        Header firstHeader2 = httpResponse.getFirstHeader("Expires");
        return firstHeader2 != null ? C1408b.m4085b(firstHeader2.getValue()) - System.currentTimeMillis() : 0;
    }

    /* renamed from: b */
    private URI m4135b() {
        String a = this.f3663c.mo11974a();
        String str = this.f3664d;
        if (str != null) {
            a = str;
        }
        if (a != null) {
            return new URI(a);
        }
        throw new RuntimeException("url should not be null");
    }

    /* renamed from: c */
    private HttpUriRequest m4136c() {
        HttpUriRequest httpUriRequest = this.f3665f;
        if (httpUriRequest != null) {
            return httpUriRequest;
        }
        if (this.f3669j == null) {
            byte[] b = this.f3663c.mo11981b();
            String b2 = this.f3663c.mo11980b("gzip");
            if (b != null) {
                if (TextUtils.equals(b2, "true")) {
                    this.f3669j = C1408b.m4083a(b);
                } else {
                    this.f3669j = new ByteArrayEntity(b);
                }
                this.f3669j.setContentType(this.f3663c.mo11982c());
            }
        }
        AbstractHttpEntity abstractHttpEntity = this.f3669j;
        if (abstractHttpEntity != null) {
            HttpPost httpPost = new HttpPost(m4135b());
            httpPost.setEntity(abstractHttpEntity);
            this.f3665f = httpPost;
        } else {
            this.f3665f = new HttpGet(m4135b());
        }
        return this.f3665f;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0284, code lost:
            r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0285, code lost:
            m4138e();
            r2 = r14.f3672m;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x028a, code lost:
            if (r2 <= 0) goto L_0x028c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x028c, code lost:
            r14.f3672m = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0292, code lost:
            new java.lang.StringBuilder().append(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x02a7, code lost:
            throw new com.alipay.android.phone.mrpc.core.HttpException(java.lang.Integer.valueOf(0), java.lang.String.valueOf(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x02a8, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x02a9, code lost:
            m4138e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x02b2, code lost:
            if (r14.f3663c.mo11994f() != null) goto L_0x02b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x02b4, code lost:
            new java.lang.StringBuilder().append(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x02bc, code lost:
            new java.lang.StringBuilder().append(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x02d1, code lost:
            throw new com.alipay.android.phone.mrpc.core.HttpException(java.lang.Integer.valueOf(6), java.lang.String.valueOf(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x02d2, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x02d3, code lost:
            m4138e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x02dc, code lost:
            if (r14.f3663c.mo11994f() != null) goto L_0x02de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x02de, code lost:
            new java.lang.StringBuilder().append(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x02e6, code lost:
            new java.lang.StringBuilder().append(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x02fd, code lost:
            throw new com.alipay.android.phone.mrpc.core.HttpException(java.lang.Integer.valueOf(9), java.lang.String.valueOf(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x02fe, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x02ff, code lost:
            m4138e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0308, code lost:
            if (r14.f3663c.mo11994f() != null) goto L_0x030a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x030a, code lost:
            new java.lang.StringBuilder().append(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0321, code lost:
            throw new com.alipay.android.phone.mrpc.core.HttpException(java.lang.Integer.valueOf(8), java.lang.String.valueOf(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0322, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0323, code lost:
            m4138e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x032c, code lost:
            if (r14.f3663c.mo11994f() != null) goto L_0x032e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x032e, code lost:
            new java.lang.StringBuilder().append(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0336, code lost:
            new java.lang.StringBuilder().append(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x034c, code lost:
            throw new com.alipay.android.phone.mrpc.core.HttpException(java.lang.Integer.valueOf(5), java.lang.String.valueOf(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x034d, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x034e, code lost:
            m4138e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0357, code lost:
            if (r14.f3663c.mo11994f() != null) goto L_0x0359;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0359, code lost:
            new java.lang.StringBuilder().append(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0361, code lost:
            new java.lang.StringBuilder().append(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0377, code lost:
            throw new com.alipay.android.phone.mrpc.core.HttpException(java.lang.Integer.valueOf(4), java.lang.String.valueOf(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0378, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0379, code lost:
            m4138e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0382, code lost:
            if (r14.f3663c.mo11994f() != null) goto L_0x0384;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0384, code lost:
            new java.lang.StringBuilder().append(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x038c, code lost:
            new java.lang.StringBuilder().append(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x03a1, code lost:
            throw new com.alipay.android.phone.mrpc.core.HttpException(java.lang.Integer.valueOf(3), java.lang.String.valueOf(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x03a2, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x03a3, code lost:
            m4138e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x03ac, code lost:
            if (r14.f3663c.mo11994f() != null) goto L_0x03ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x03ae, code lost:
            new java.lang.StringBuilder().append(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x03b6, code lost:
            new java.lang.StringBuilder().append(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x03cb, code lost:
            throw new com.alipay.android.phone.mrpc.core.HttpException(java.lang.Integer.valueOf(3), java.lang.String.valueOf(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x03cc, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x03cd, code lost:
            m4138e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x03d6, code lost:
            if (r14.f3663c.mo11994f() != null) goto L_0x03d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x03d8, code lost:
            new java.lang.StringBuilder().append(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x03e0, code lost:
            new java.lang.StringBuilder().append(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x03f5, code lost:
            throw new com.alipay.android.phone.mrpc.core.HttpException(java.lang.Integer.valueOf(6), java.lang.String.valueOf(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x03f6, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x03f7, code lost:
            m4138e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0400, code lost:
            if (r14.f3663c.mo11994f() != null) goto L_0x0402;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0402, code lost:
            new java.lang.StringBuilder().append(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x040a, code lost:
            new java.lang.StringBuilder().append(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x041f, code lost:
            throw new com.alipay.android.phone.mrpc.core.HttpException(java.lang.Integer.valueOf(2), java.lang.String.valueOf(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x0420, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x0421, code lost:
            m4138e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x042a, code lost:
            if (r14.f3663c.mo11994f() != null) goto L_0x042c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x042c, code lost:
            new java.lang.StringBuilder().append(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x0434, code lost:
            new java.lang.StringBuilder().append(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x0449, code lost:
            throw new com.alipay.android.phone.mrpc.core.HttpException(java.lang.Integer.valueOf(2), java.lang.String.valueOf(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x044a, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x0456, code lost:
            throw new java.lang.RuntimeException("Url parser error!", r0.getCause());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x0457, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x0458, code lost:
            m4138e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x0461, code lost:
            if (r14.f3663c.mo11994f() != null) goto L_0x0463;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x0463, code lost:
            r0.getCode();
            r0.getMsg();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x0469, code lost:
            new java.lang.StringBuilder().append(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0471, code lost:
            throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:85:0x022f */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0284 A[ExcHandler: NullPointerException (r1v46 'e' java.lang.NullPointerException A[CUSTOM_DECLARE]), Splitter:B:2:0x0006] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x02a8 A[ExcHandler: IOException (r0v22 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:2:0x0006] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x02d2 A[ExcHandler: UnknownHostException (r0v20 'e' java.net.UnknownHostException A[CUSTOM_DECLARE]), Splitter:B:2:0x0006] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02fe A[ExcHandler: HttpHostConnectException (r0v18 'e' org.apache.http.conn.HttpHostConnectException A[CUSTOM_DECLARE]), Splitter:B:2:0x0006] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0322 A[ExcHandler: NoHttpResponseException (r0v16 'e' org.apache.http.NoHttpResponseException A[CUSTOM_DECLARE]), Splitter:B:2:0x0006] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x034d A[ExcHandler: SocketTimeoutException (r0v14 'e' java.net.SocketTimeoutException A[CUSTOM_DECLARE]), Splitter:B:2:0x0006] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0378 A[ExcHandler: ConnectTimeoutException (r0v12 'e' org.apache.http.conn.ConnectTimeoutException A[CUSTOM_DECLARE]), Splitter:B:2:0x0006] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x03a2 A[ExcHandler: ConnectionPoolTimeoutException (r0v10 'e' org.apache.http.conn.ConnectionPoolTimeoutException A[CUSTOM_DECLARE]), Splitter:B:2:0x0006] */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x03cc A[ExcHandler: SSLException (r0v8 'e' javax.net.ssl.SSLException A[CUSTOM_DECLARE]), Splitter:B:2:0x0006] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x03f6 A[ExcHandler: SSLPeerUnverifiedException (r0v6 'e' javax.net.ssl.SSLPeerUnverifiedException A[CUSTOM_DECLARE]), Splitter:B:2:0x0006] */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0420 A[ExcHandler: SSLHandshakeException (r0v4 'e' javax.net.ssl.SSLHandshakeException A[CUSTOM_DECLARE]), Splitter:B:2:0x0006] */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x044a A[ExcHandler: URISyntaxException (r0v2 'e' java.net.URISyntaxException A[CUSTOM_DECLARE]), Splitter:B:2:0x0006] */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0457 A[ExcHandler: HttpException (r0v1 'e' com.alipay.android.phone.mrpc.core.HttpException A[CUSTOM_DECLARE]), Splitter:B:2:0x0006] */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0256 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0032 A[Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0109 A[Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0129 A[Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x015c A[Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0169 A[Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01de A[Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }] */
    /* renamed from: d */
    public com.alipay.android.phone.mrpc.core.C1430u call() {
        /*
        r14 = this;
        java.lang.String r0 = "connectivity"
    L_0x0002:
        r1 = 3
        r2 = 6
        r3 = 2
        r4 = 0
        android.content.Context r5 = r14.f3662b     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        java.lang.Object r5 = r5.getSystemService(r0)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        android.net.ConnectivityManager r5 = (android.net.ConnectivityManager) r5     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        android.net.NetworkInfo[] r5 = r5.getAllNetworkInfo()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        r6 = 1
        if (r5 != 0) goto L_0x0017
    L_0x0015:
        r5 = 0
        goto L_0x0030
    L_0x0017:
        int r7 = r5.length     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        r8 = 0
    L_0x0019:
        if (r8 >= r7) goto L_0x0015
        r9 = r5[r8]     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        if (r9 == 0) goto L_0x002d
        boolean r10 = r9.isAvailable()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        if (r10 == 0) goto L_0x002d
        boolean r9 = r9.isConnectedOrConnecting()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        if (r9 == 0) goto L_0x002d
        r5 = 1
        goto L_0x0030
    L_0x002d:
        int r8 = r8 + 1
        goto L_0x0019
    L_0x0030:
        if (r5 == 0) goto L_0x0256
        com.alipay.android.phone.mrpc.core.o r5 = r14.f3663c     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        java.util.ArrayList r5 = r5.mo11983d()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        if (r5 == 0) goto L_0x0058
        boolean r7 = r5.isEmpty()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        if (r7 != 0) goto L_0x0058
        java.util.Iterator r5 = r5.iterator()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
    L_0x0044:
        boolean r7 = r5.hasNext()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        if (r7 == 0) goto L_0x0058
        java.lang.Object r7 = r5.next()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        org.apache.http.Header r7 = (org.apache.http.Header) r7     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        org.apache.http.client.methods.HttpUriRequest r8 = r14.m4136c()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        r8.addHeader(r7)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        goto L_0x0044
    L_0x0058:
        org.apache.http.client.methods.HttpUriRequest r5 = r14.m4136c()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        com.alipay.android.phone.mrpc.core.C1408b.m4084a(r5)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        org.apache.http.client.methods.HttpUriRequest r5 = r14.m4136c()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        com.alipay.android.phone.mrpc.core.C1408b.m4086b(r5)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        org.apache.http.client.methods.HttpUriRequest r5 = r14.m4136c()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        java.lang.String r7 = "cookie"
        android.webkit.CookieManager r8 = r14.m4142i()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        com.alipay.android.phone.mrpc.core.o r9 = r14.f3663c     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        java.lang.String r9 = r9.mo11974a()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        java.lang.String r8 = r8.getCookie(r9)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        r5.addHeader(r7, r8)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        org.apache.http.protocol.HttpContext r5 = r14.f3666g     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        java.lang.String r7 = "http.cookie-store"
        org.apache.http.client.CookieStore r8 = r14.f3667h     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        r5.setAttribute(r7, r8)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        com.alipay.android.phone.mrpc.core.l r5 = r14.f3661a     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        com.alipay.android.phone.mrpc.core.b r5 = r5.mo11968a()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        org.apache.http.client.HttpRequestRetryHandler r7 = f3660e     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        r5.mo11943a(r7)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        long r7 = java.lang.System.currentTimeMillis()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        java.lang.String r9 = "By Http/Https to request. operationType="
        r5.<init>(r9)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        java.lang.String r9 = r14.m4139f()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        r5.append(r9)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        java.lang.String r9 = " url="
        r5.append(r9)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        org.apache.http.client.methods.HttpUriRequest r9 = r14.f3665f     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        java.net.URI r9 = r9.getURI()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        java.lang.String r9 = r9.toString()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        r5.append(r9)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        com.alipay.android.phone.mrpc.core.l r5 = r14.f3661a     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        com.alipay.android.phone.mrpc.core.b r5 = r5.mo11968a()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        org.apache.http.params.HttpParams r5 = r5.getParams()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        java.lang.String r9 = "http.route.default-proxy"
        android.content.Context r10 = r14.f3662b     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        java.lang.Object r10 = r10.getSystemService(r0)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        android.net.ConnectivityManager r10 = (android.net.ConnectivityManager) r10     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        android.net.NetworkInfo r10 = r10.getActiveNetworkInfo()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        r11 = 0
        if (r10 == 0) goto L_0x00e6
        boolean r10 = r10.isAvailable()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        if (r10 == 0) goto L_0x00e6
        java.lang.String r10 = android.net.Proxy.getDefaultHost()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        int r12 = android.net.Proxy.getDefaultPort()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        if (r10 == 0) goto L_0x00e6
        org.apache.http.HttpHost r13 = new org.apache.http.HttpHost     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        r13.<init>(r10, r12)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        goto L_0x00e7
    L_0x00e6:
        r13 = r11
    L_0x00e7:
        if (r13 == 0) goto L_0x00fe
        java.lang.String r10 = r13.getHostName()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        java.lang.String r12 = "127.0.0.1"
        boolean r10 = android.text.TextUtils.equals(r10, r12)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        if (r10 == 0) goto L_0x00fe
        int r10 = r13.getPort()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        r12 = 8087(0x1f97, float:1.1332E-41)
        if (r10 != r12) goto L_0x00fe
        goto L_0x00ff
    L_0x00fe:
        r11 = r13
    L_0x00ff:
        r5.setParameter(r9, r11)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        org.apache.http.HttpHost r5 = r14.f3670k     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        if (r5 == 0) goto L_0x0109
    L_0x0106:
        org.apache.http.HttpHost r5 = r14.f3670k     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        goto L_0x0121
    L_0x0109:
        java.net.URL r5 = r14.m4141h()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        org.apache.http.HttpHost r9 = new org.apache.http.HttpHost     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        java.lang.String r10 = r5.getHost()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        int r11 = r14.m4140g()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        java.lang.String r5 = r5.getProtocol()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        r9.<init>(r10, r11, r5)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        r14.f3670k = r9     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        goto L_0x0106
    L_0x0121:
        int r9 = r14.m4140g()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        r10 = 80
        if (r9 != r10) goto L_0x0136
        org.apache.http.HttpHost r5 = new org.apache.http.HttpHost     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        java.net.URL r9 = r14.m4141h()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        java.lang.String r9 = r9.getHost()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        r5.<init>(r9)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
    L_0x0136:
        com.alipay.android.phone.mrpc.core.l r9 = r14.f3661a     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        com.alipay.android.phone.mrpc.core.b r9 = r9.mo11968a()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        org.apache.http.client.methods.HttpUriRequest r10 = r14.f3665f     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        org.apache.http.protocol.HttpContext r11 = r14.f3666g     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        org.apache.http.HttpResponse r5 = r9.execute(r5, r10, r11)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        long r9 = java.lang.System.currentTimeMillis()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        com.alipay.android.phone.mrpc.core.l r11 = r14.f3661a     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        long r9 = r9 - r7
        r11.mo11970b(r9)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        org.apache.http.client.CookieStore r7 = r14.f3667h     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        java.util.List r7 = r7.getCookies()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        com.alipay.android.phone.mrpc.core.o r8 = r14.f3663c     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        boolean r8 = r8.mo11984e()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        if (r8 == 0) goto L_0x0163
        android.webkit.CookieManager r8 = r14.m4142i()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        r8.removeAllCookie()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
    L_0x0163:
        boolean r8 = r7.isEmpty()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        if (r8 != 0) goto L_0x01ca
        java.util.Iterator r7 = r7.iterator()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
    L_0x016d:
        boolean r8 = r7.hasNext()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        if (r8 == 0) goto L_0x01ca
        java.lang.Object r8 = r7.next()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        org.apache.http.cookie.Cookie r8 = (org.apache.http.cookie.Cookie) r8     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        java.lang.String r9 = r8.getDomain()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        if (r9 == 0) goto L_0x016d
        java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        r9.<init>()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        java.lang.String r10 = r8.getName()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        r9.append(r10)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        java.lang.String r10 = "="
        r9.append(r10)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        java.lang.String r10 = r8.getValue()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        r9.append(r10)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        java.lang.String r10 = "; domain="
        r9.append(r10)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        java.lang.String r10 = r8.getDomain()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        r9.append(r10)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        boolean r8 = r8.isSecure()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        if (r8 == 0) goto L_0x01ac
        java.lang.String r8 = "; Secure"
        goto L_0x01ae
    L_0x01ac:
        java.lang.String r8 = ""
    L_0x01ae:
        r9.append(r8)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        java.lang.String r8 = r9.toString()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        android.webkit.CookieManager r9 = r14.m4142i()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        com.alipay.android.phone.mrpc.core.o r10 = r14.f3663c     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        java.lang.String r10 = r10.mo11974a()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        r9.setCookie(r10, r8)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        android.webkit.CookieSyncManager r8 = android.webkit.CookieSyncManager.getInstance()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        r8.sync()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        goto L_0x016d
    L_0x01ca:
        org.apache.http.StatusLine r7 = r5.getStatusLine()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        int r7 = r7.getStatusCode()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        org.apache.http.StatusLine r8 = r5.getStatusLine()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        java.lang.String r8 = r8.getReasonPhrase()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        r9 = 200(0xc8, float:2.8E-43)
        if (r7 == r9) goto L_0x0201
        r9 = 304(0x130, float:4.26E-43)
        if (r7 != r9) goto L_0x01e3
        goto L_0x01e4
    L_0x01e3:
        r6 = 0
    L_0x01e4:
        if (r6 == 0) goto L_0x01e7
        goto L_0x0201
    L_0x01e7:
        com.alipay.android.phone.mrpc.core.HttpException r6 = new com.alipay.android.phone.mrpc.core.HttpException     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        org.apache.http.StatusLine r7 = r5.getStatusLine()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        int r7 = r7.getStatusCode()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        org.apache.http.StatusLine r5 = r5.getStatusLine()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        java.lang.String r5 = r5.getReasonPhrase()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        r6.m42014init(r7, r5)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        throw r6     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
    L_0x0201:
        com.alipay.android.phone.mrpc.core.u r5 = r14.m4131a(r5, r7, r8)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        r6 = -1
        if (r5 == 0) goto L_0x0216
        byte[] r8 = r5.mo11998b()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        if (r8 == 0) goto L_0x0216
        byte[] r8 = r5.mo11998b()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        int r8 = r8.length     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        long r8 = (long) r8     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        goto L_0x0217
    L_0x0216:
        r8 = r6
    L_0x0217:
        int r10 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
        if (r10 != 0) goto L_0x022f
        boolean r6 = r5 instanceof com.alipay.android.phone.mrpc.core.C1425p     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        if (r6 == 0) goto L_0x022f
        r6 = r5
        com.alipay.android.phone.mrpc.core.p r6 = (com.alipay.android.phone.mrpc.core.C1425p) r6     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        com.alipay.android.phone.mrpc.core.HttpUrlHeader r6 = r6.mo11988a()     // Catch:{ Exception -> 0x022f, HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284 }
        java.lang.String r7 = "Content-Length"
        java.lang.String r6 = r6.getHead(r7)     // Catch:{ Exception -> 0x022f, HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284 }
        java.lang.Long.parseLong(r6)     // Catch:{ Exception -> 0x022f, HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284 }
    L_0x022f:
        com.alipay.android.phone.mrpc.core.o r6 = r14.f3663c     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        java.lang.String r6 = r6.mo11974a()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        if (r6 == 0) goto L_0x0255
        java.lang.String r7 = r14.m4139f()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        if (r7 != 0) goto L_0x0255
        java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        r7.<init>()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        r7.append(r6)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        java.lang.String r6 = "#"
        r7.append(r6)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        java.lang.String r6 = r14.m4139f()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        r7.append(r6)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
    L_0x0255:
        return r5
    L_0x0256:
        com.alipay.android.phone.mrpc.core.HttpException r5 = new com.alipay.android.phone.mrpc.core.HttpException     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        java.lang.String r7 = "The network is not available"
        r5.m42014init(r6, r7)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        throw r5     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
    L_0x0262:
        r0 = move-exception
        r14.m4138e()
        com.alipay.android.phone.mrpc.core.o r1 = r14.f3663c
        com.alipay.android.phone.mrpc.core.ac r1 = r1.mo11994f()
        if (r1 == 0) goto L_0x0276
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        r1.append(r0)
    L_0x0276:
        com.alipay.android.phone.mrpc.core.HttpException r1 = new com.alipay.android.phone.mrpc.core.HttpException
        java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
        java.lang.String r0 = java.lang.String.valueOf(r0)
        r1.m42014init(r2, r0)
        throw r1
    L_0x0284:
        r1 = move-exception
        r14.m4138e()
        int r2 = r14.f3672m
        if (r2 > 0) goto L_0x0292
        int r2 = r2 + 1
        r14.f3672m = r2
        goto L_0x0002
    L_0x0292:
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        r0.append(r1)
        com.alipay.android.phone.mrpc.core.HttpException r0 = new com.alipay.android.phone.mrpc.core.HttpException
        java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
        java.lang.String r1 = java.lang.String.valueOf(r1)
        r0.m42014init(r2, r1)
        throw r0
    L_0x02a8:
        r0 = move-exception
        r14.m4138e()
        com.alipay.android.phone.mrpc.core.o r1 = r14.f3663c
        com.alipay.android.phone.mrpc.core.ac r1 = r1.mo11994f()
        if (r1 == 0) goto L_0x02bc
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        r1.append(r0)
    L_0x02bc:
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        r1.append(r0)
        com.alipay.android.phone.mrpc.core.HttpException r1 = new com.alipay.android.phone.mrpc.core.HttpException
        java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        java.lang.String r0 = java.lang.String.valueOf(r0)
        r1.m42014init(r2, r0)
        throw r1
    L_0x02d2:
        r0 = move-exception
        r14.m4138e()
        com.alipay.android.phone.mrpc.core.o r1 = r14.f3663c
        com.alipay.android.phone.mrpc.core.ac r1 = r1.mo11994f()
        if (r1 == 0) goto L_0x02e6
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        r1.append(r0)
    L_0x02e6:
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        r1.append(r0)
        com.alipay.android.phone.mrpc.core.HttpException r1 = new com.alipay.android.phone.mrpc.core.HttpException
        r2 = 9
        java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        java.lang.String r0 = java.lang.String.valueOf(r0)
        r1.m42014init(r2, r0)
        throw r1
    L_0x02fe:
        r0 = move-exception
        r14.m4138e()
        com.alipay.android.phone.mrpc.core.o r1 = r14.f3663c
        com.alipay.android.phone.mrpc.core.ac r1 = r1.mo11994f()
        if (r1 == 0) goto L_0x0312
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        r1.append(r0)
    L_0x0312:
        com.alipay.android.phone.mrpc.core.HttpException r1 = new com.alipay.android.phone.mrpc.core.HttpException
        r2 = 8
        java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        java.lang.String r0 = java.lang.String.valueOf(r0)
        r1.m42014init(r2, r0)
        throw r1
    L_0x0322:
        r0 = move-exception
        r14.m4138e()
        com.alipay.android.phone.mrpc.core.o r1 = r14.f3663c
        com.alipay.android.phone.mrpc.core.ac r1 = r1.mo11994f()
        if (r1 == 0) goto L_0x0336
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        r1.append(r0)
    L_0x0336:
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        r1.append(r0)
        com.alipay.android.phone.mrpc.core.HttpException r1 = new com.alipay.android.phone.mrpc.core.HttpException
        r2 = 5
        java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        java.lang.String r0 = java.lang.String.valueOf(r0)
        r1.m42014init(r2, r0)
        throw r1
    L_0x034d:
        r0 = move-exception
        r14.m4138e()
        com.alipay.android.phone.mrpc.core.o r1 = r14.f3663c
        com.alipay.android.phone.mrpc.core.ac r1 = r1.mo11994f()
        if (r1 == 0) goto L_0x0361
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        r1.append(r0)
    L_0x0361:
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        r1.append(r0)
        com.alipay.android.phone.mrpc.core.HttpException r1 = new com.alipay.android.phone.mrpc.core.HttpException
        r2 = 4
        java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        java.lang.String r0 = java.lang.String.valueOf(r0)
        r1.m42014init(r2, r0)
        throw r1
    L_0x0378:
        r0 = move-exception
        r14.m4138e()
        com.alipay.android.phone.mrpc.core.o r2 = r14.f3663c
        com.alipay.android.phone.mrpc.core.ac r2 = r2.mo11994f()
        if (r2 == 0) goto L_0x038c
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        r2.append(r0)
    L_0x038c:
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        r2.append(r0)
        com.alipay.android.phone.mrpc.core.HttpException r2 = new com.alipay.android.phone.mrpc.core.HttpException
        java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        java.lang.String r0 = java.lang.String.valueOf(r0)
        r2.m42014init(r1, r0)
        throw r2
    L_0x03a2:
        r0 = move-exception
        r14.m4138e()
        com.alipay.android.phone.mrpc.core.o r2 = r14.f3663c
        com.alipay.android.phone.mrpc.core.ac r2 = r2.mo11994f()
        if (r2 == 0) goto L_0x03b6
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        r2.append(r0)
    L_0x03b6:
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        r2.append(r0)
        com.alipay.android.phone.mrpc.core.HttpException r2 = new com.alipay.android.phone.mrpc.core.HttpException
        java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        java.lang.String r0 = java.lang.String.valueOf(r0)
        r2.m42014init(r1, r0)
        throw r2
    L_0x03cc:
        r0 = move-exception
        r14.m4138e()
        com.alipay.android.phone.mrpc.core.o r1 = r14.f3663c
        com.alipay.android.phone.mrpc.core.ac r1 = r1.mo11994f()
        if (r1 == 0) goto L_0x03e0
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        r1.append(r0)
    L_0x03e0:
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        r1.append(r0)
        com.alipay.android.phone.mrpc.core.HttpException r1 = new com.alipay.android.phone.mrpc.core.HttpException
        java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        java.lang.String r0 = java.lang.String.valueOf(r0)
        r1.m42014init(r2, r0)
        throw r1
    L_0x03f6:
        r0 = move-exception
        r14.m4138e()
        com.alipay.android.phone.mrpc.core.o r1 = r14.f3663c
        com.alipay.android.phone.mrpc.core.ac r1 = r1.mo11994f()
        if (r1 == 0) goto L_0x040a
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        r1.append(r0)
    L_0x040a:
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        r1.append(r0)
        com.alipay.android.phone.mrpc.core.HttpException r1 = new com.alipay.android.phone.mrpc.core.HttpException
        java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
        java.lang.String r0 = java.lang.String.valueOf(r0)
        r1.m42014init(r2, r0)
        throw r1
    L_0x0420:
        r0 = move-exception
        r14.m4138e()
        com.alipay.android.phone.mrpc.core.o r1 = r14.f3663c
        com.alipay.android.phone.mrpc.core.ac r1 = r1.mo11994f()
        if (r1 == 0) goto L_0x0434
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        r1.append(r0)
    L_0x0434:
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        r1.append(r0)
        com.alipay.android.phone.mrpc.core.HttpException r1 = new com.alipay.android.phone.mrpc.core.HttpException
        java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
        java.lang.String r0 = java.lang.String.valueOf(r0)
        r1.m42014init(r2, r0)
        throw r1
    L_0x044a:
        r0 = move-exception
        java.lang.RuntimeException r1 = new java.lang.RuntimeException
        java.lang.Throwable r0 = r0.getCause()
        java.lang.String r2 = "Url parser error!"
        r1.<init>(r2, r0)
        throw r1
    L_0x0457:
        r0 = move-exception
        r14.m4138e()
        com.alipay.android.phone.mrpc.core.o r1 = r14.f3663c
        com.alipay.android.phone.mrpc.core.ac r1 = r1.mo11994f()
        if (r1 == 0) goto L_0x0469
        r0.getCode()
        r0.getMsg()
    L_0x0469:
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        r1.append(r0)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.android.phone.mrpc.core.C1426q.call():com.alipay.android.phone.mrpc.core.u");
    }

    /* renamed from: e */
    private void m4138e() {
        HttpUriRequest httpUriRequest = this.f3665f;
        if (httpUriRequest != null) {
            httpUriRequest.abort();
        }
    }

    /* renamed from: f */
    private String m4139f() {
        if (!TextUtils.isEmpty(this.f3676q)) {
            return this.f3676q;
        }
        this.f3676q = this.f3663c.mo11980b("operationType");
        return this.f3676q;
    }

    /* renamed from: g */
    private int m4140g() {
        URL h = m4141h();
        return h.getPort() == -1 ? h.getDefaultPort() : h.getPort();
    }

    /* renamed from: h */
    private URL m4141h() {
        URL url = this.f3671l;
        if (url != null) {
            return url;
        }
        this.f3671l = new URL(this.f3663c.mo11974a());
        return this.f3671l;
    }

    /* renamed from: i */
    private CookieManager m4142i() {
        CookieManager cookieManager = this.f3668i;
        if (cookieManager != null) {
            return cookieManager;
        }
        this.f3668i = CookieManager.getInstance();
        return this.f3668i;
    }

    /* renamed from: a */
    public final C1424o mo11992a() {
        return this.f3663c;
    }
}
