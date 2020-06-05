package com.bytedance.sdk.adnet.core;

import com.bytedance.sdk.adnet.err.ServerError;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.p159b.FileRequest;
import com.bytedance.sdk.adnet.p161d.HttpHeaderParser;
import com.bytedance.sdk.adnet.p162e.ICache.C1994a;
import com.bytedance.sdk.adnet.p162e.IHttpStack;
import com.bytedance.sdk.adnet.p162e.INetwork;
import com.bytedance.sdk.adnet.p162e.IRetryPolicy;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;

/* renamed from: com.bytedance.sdk.adnet.core.c */
public class BasicNetwork implements INetwork {
    /* renamed from: a */
    protected static final boolean f6220a = VNetLog.f6301a;
    /* renamed from: b */
    protected final IHttpStack f6221b;
    /* renamed from: c */
    protected final ByteArrayPool f6222c;

    public BasicNetwork(IHttpStack aVar) {
        this(aVar, new ByteArrayPool(4096));
    }

    public BasicNetwork(IHttpStack aVar, ByteArrayPool dVar) {
        this.f6221b = aVar;
        this.f6222c = dVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:102:0x016c, code lost:
            if (r2.mo14314d() == null) goto L_0x0004;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x017c, code lost:
            throw new com.bytedance.sdk.adnet.err.NoConnectionError(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x01b2, code lost:
            if (r2.mo14314d() != null) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x01b4, code lost:
            r2.mo14314d().close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0077, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0078, code lost:
            r13 = null;
            r2 = r11;
            r17 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00c3, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00cd, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00ce, code lost:
            r1 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00d0, code lost:
            r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00d1, code lost:
            r2 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00d4, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00d5, code lost:
            r17 = r1;
            r13 = null;
            r2 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00da, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00db, code lost:
            r2 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00de, code lost:
            r2 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
            r0 = r2.mo14311a();
            com.bytedance.sdk.adnet.core.VNetLog.m7929c("Unexpected response code %d for %s", java.lang.Integer.valueOf(r0), r22.getUrl());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0104, code lost:
            if (r13 != null) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0106, code lost:
            r11 = new com.bytedance.sdk.adnet.core.NetworkResponse(r0, r13, false, android.os.SystemClock.elapsedRealtime() - r9, r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0116, code lost:
            if (r0 != 401) goto L_0x0118;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x011a, code lost:
            if (r0 == 403) goto L_0x011c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x011f, code lost:
            if (r0 >= 400) goto L_0x0121;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0123, code lost:
            if (r0 > 499) goto L_0x0125;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x012b, code lost:
            throw new com.bytedance.sdk.adnet.err.ClientError(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x012e, code lost:
            if (r0 < 500) goto L_0x014b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0138, code lost:
            if (r22.shouldRetryServerErrors() != false) goto L_0x013a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x013a, code lost:
            m7819a("server", r8, new com.bytedance.sdk.adnet.err.ServerError(r11));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x014a, code lost:
            throw new com.bytedance.sdk.adnet.err.ServerError(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0151, code lost:
            m7819a("auth", r8, new com.bytedance.sdk.adnet.err.AuthFailureError(r11));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x015c, code lost:
            m7819a("network", r8, new com.bytedance.sdk.adnet.err.NetworkError());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0166, code lost:
            if (r2 != null) goto L_0x0168;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0177 A[SYNTHETIC, Splitter:B:105:0x0177] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x01ae A[SYNTHETIC, Splitter:B:118:0x01ae] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00d0 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:5:0x001b] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00da A[ExcHandler: MalformedURLException (e java.net.MalformedURLException), Splitter:B:5:0x001b] */
    /* JADX WARNING: Removed duplicated region for block: B:66:? A[ExcHandler: SocketTimeoutException (unused java.net.SocketTimeoutException), SYNTHETIC, Splitter:B:5:0x001b] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00ea A[SYNTHETIC, Splitter:B:71:0x00ea] */
    /* renamed from: a */
    public com.bytedance.sdk.adnet.core.NetworkResponse mo14315a(com.bytedance.sdk.adnet.core.Request<?> r22) throws com.bytedance.sdk.adnet.err.VAdError {
        /*
        r21 = this;
        r7 = r21
        r8 = r22
    L_0x0004:
        long r9 = android.os.SystemClock.elapsedRealtime()
        java.util.List r1 = java.util.Collections.emptyList()
        r2 = 0
        com.bytedance.sdk.adnet.e.b$a r0 = r22.getCacheEntry()     // Catch:{ SocketTimeoutException -> 0x0199, MalformedURLException -> 0x017d, IOException -> 0x00e4 }
        java.util.Map r0 = r7.m7817a(r0)     // Catch:{ SocketTimeoutException -> 0x0199, MalformedURLException -> 0x017d, IOException -> 0x00e4 }
        com.bytedance.sdk.adnet.e.a r3 = r7.f6221b     // Catch:{ SocketTimeoutException -> 0x0199, MalformedURLException -> 0x017d, IOException -> 0x00e4 }
        com.bytedance.sdk.adnet.core.b r11 = r3.mo14352a(r8, r0)     // Catch:{ SocketTimeoutException -> 0x0199, MalformedURLException -> 0x017d, IOException -> 0x00e4 }
        int r13 = r11.mo14311a()     // Catch:{ SocketTimeoutException -> 0x00de, MalformedURLException -> 0x00da, IOException -> 0x00d4, all -> 0x00d0 }
        java.util.List r12 = r11.mo14312b()     // Catch:{ SocketTimeoutException -> 0x00de, MalformedURLException -> 0x00da, IOException -> 0x00d4, all -> 0x00d0 }
        r0 = 304(0x130, float:4.26E-43)
        if (r13 != r0) goto L_0x007e
        com.bytedance.sdk.adnet.e.b$a r0 = r22.getCacheEntry()     // Catch:{ SocketTimeoutException -> 0x00de, MalformedURLException -> 0x00da, IOException -> 0x0077, all -> 0x00d0 }
        if (r0 != 0) goto L_0x0051
        com.bytedance.sdk.adnet.core.l r0 = new com.bytedance.sdk.adnet.core.l     // Catch:{ SocketTimeoutException -> 0x00de, MalformedURLException -> 0x00da, IOException -> 0x0077, all -> 0x00d0 }
        r15 = 304(0x130, float:4.26E-43)
        r16 = 0
        r17 = 1
        long r3 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x00de, MalformedURLException -> 0x00da, IOException -> 0x0077, all -> 0x00d0 }
        long r18 = r3 - r9
        r14 = r0
        r20 = r12
        r14.m43171init(r15, r16, r17, r18, r20)     // Catch:{ SocketTimeoutException -> 0x00de, MalformedURLException -> 0x00da, IOException -> 0x0077, all -> 0x00d0 }
        if (r11 == 0) goto L_0x0050
        java.io.InputStream r1 = r11.mo14314d()     // Catch:{ all -> 0x0050 }
        if (r1 == 0) goto L_0x0050
        java.io.InputStream r1 = r11.mo14314d()     // Catch:{ all -> 0x0050 }
        r1.close()     // Catch:{ all -> 0x0050 }
    L_0x0050:
        return r0
    L_0x0051:
        java.util.List r19 = m7816a(r12, r0)     // Catch:{ SocketTimeoutException -> 0x00de, MalformedURLException -> 0x00da, IOException -> 0x0077, all -> 0x00d0 }
        com.bytedance.sdk.adnet.core.l r1 = new com.bytedance.sdk.adnet.core.l     // Catch:{ SocketTimeoutException -> 0x00de, MalformedURLException -> 0x00da, IOException -> 0x0077, all -> 0x00d0 }
        r14 = 304(0x130, float:4.26E-43)
        byte[] r15 = r0.f6325b     // Catch:{ SocketTimeoutException -> 0x00de, MalformedURLException -> 0x00da, IOException -> 0x0077, all -> 0x00d0 }
        r16 = 1
        long r3 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x00de, MalformedURLException -> 0x00da, IOException -> 0x0077, all -> 0x00d0 }
        long r17 = r3 - r9
        r13 = r1
        r13.m43171init(r14, r15, r16, r17, r19)     // Catch:{ SocketTimeoutException -> 0x00de, MalformedURLException -> 0x00da, IOException -> 0x0077, all -> 0x00d0 }
        if (r11 == 0) goto L_0x0076
        java.io.InputStream r0 = r11.mo14314d()     // Catch:{ all -> 0x0076 }
        if (r0 == 0) goto L_0x0076
        java.io.InputStream r0 = r11.mo14314d()     // Catch:{ all -> 0x0076 }
        r0.close()     // Catch:{ all -> 0x0076 }
    L_0x0076:
        return r1
    L_0x0077:
        r0 = move-exception
        r13 = r2
        r2 = r11
        r17 = r12
        goto L_0x00e8
    L_0x007e:
        byte[] r19 = r7.mo14316a(r8, r11)     // Catch:{ SocketTimeoutException -> 0x00de, MalformedURLException -> 0x00da, IOException -> 0x00cd, all -> 0x00d0 }
        long r0 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x00de, MalformedURLException -> 0x00da, IOException -> 0x00c5, all -> 0x00d0 }
        long r2 = r0 - r9
        r1 = r21
        r4 = r22
        r5 = r19
        r6 = r13
        r1.m7818a(r2, r4, r5, r6)     // Catch:{ SocketTimeoutException -> 0x00de, MalformedURLException -> 0x00da, IOException -> 0x00c5, all -> 0x00d0 }
        r0 = 200(0xc8, float:2.8E-43)
        if (r13 < r0) goto L_0x00bc
        r0 = 299(0x12b, float:4.19E-43)
        if (r13 > r0) goto L_0x00bc
        com.bytedance.sdk.adnet.core.l r0 = new com.bytedance.sdk.adnet.core.l     // Catch:{ SocketTimeoutException -> 0x00de, MalformedURLException -> 0x00da, IOException -> 0x00c5, all -> 0x00d0 }
        r15 = 0
        long r1 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x00de, MalformedURLException -> 0x00da, IOException -> 0x00c5, all -> 0x00d0 }
        long r16 = r1 - r9
        r1 = r12
        r12 = r0
        r14 = r19
        r18 = r1
        r12.m43171init(r13, r14, r15, r16, r18)     // Catch:{ SocketTimeoutException -> 0x00de, MalformedURLException -> 0x00da, IOException -> 0x00c3, all -> 0x00d0 }
        if (r11 == 0) goto L_0x00bb
        java.io.InputStream r1 = r11.mo14314d()     // Catch:{ all -> 0x00bb }
        if (r1 == 0) goto L_0x00bb
        java.io.InputStream r1 = r11.mo14314d()     // Catch:{ all -> 0x00bb }
        r1.close()     // Catch:{ all -> 0x00bb }
    L_0x00bb:
        return r0
    L_0x00bc:
        r1 = r12
        java.io.IOException r0 = new java.io.IOException     // Catch:{ SocketTimeoutException -> 0x00de, MalformedURLException -> 0x00da, IOException -> 0x00c3, all -> 0x00d0 }
        r0.<init>()     // Catch:{ SocketTimeoutException -> 0x00de, MalformedURLException -> 0x00da, IOException -> 0x00c3, all -> 0x00d0 }
        throw r0     // Catch:{ SocketTimeoutException -> 0x00de, MalformedURLException -> 0x00da, IOException -> 0x00c3, all -> 0x00d0 }
    L_0x00c3:
        r0 = move-exception
        goto L_0x00c7
    L_0x00c5:
        r0 = move-exception
        r1 = r12
    L_0x00c7:
        r17 = r1
        r2 = r11
        r13 = r19
        goto L_0x00e8
    L_0x00cd:
        r0 = move-exception
        r1 = r12
        goto L_0x00d5
    L_0x00d0:
        r0 = move-exception
        r2 = r11
        goto L_0x01ac
    L_0x00d4:
        r0 = move-exception
    L_0x00d5:
        r17 = r1
        r13 = r2
        r2 = r11
        goto L_0x00e8
    L_0x00da:
        r0 = move-exception
        r2 = r11
        goto L_0x017e
    L_0x00de:
        r2 = r11
        goto L_0x0199
    L_0x00e1:
        r0 = move-exception
        goto L_0x01ac
    L_0x00e4:
        r0 = move-exception
        r17 = r1
        r13 = r2
    L_0x00e8:
        if (r2 == 0) goto L_0x0177
        int r0 = r2.mo14311a()     // Catch:{ all -> 0x00e1 }
        java.lang.String r1 = "Unexpected response code %d for %s"
        r3 = 2
        java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x00e1 }
        r4 = 0
        java.lang.Integer r5 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x00e1 }
        r3[r4] = r5     // Catch:{ all -> 0x00e1 }
        r4 = 1
        java.lang.String r5 = r22.getUrl()     // Catch:{ all -> 0x00e1 }
        r3[r4] = r5     // Catch:{ all -> 0x00e1 }
        com.bytedance.sdk.adnet.core.VNetLog.m7929c(r1, r3)     // Catch:{ all -> 0x00e1 }
        if (r13 == 0) goto L_0x015c
        com.bytedance.sdk.adnet.core.l r1 = new com.bytedance.sdk.adnet.core.l     // Catch:{ all -> 0x00e1 }
        r14 = 0
        long r3 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x00e1 }
        long r15 = r3 - r9
        r11 = r1
        r12 = r0
        r11.m43171init(r12, r13, r14, r15, r17)     // Catch:{ all -> 0x00e1 }
        r3 = 401(0x191, float:5.62E-43)
        if (r0 == r3) goto L_0x0151
        r3 = 403(0x193, float:5.65E-43)
        if (r0 != r3) goto L_0x011d
        goto L_0x0151
    L_0x011d:
        r3 = 400(0x190, float:5.6E-43)
        if (r0 < r3) goto L_0x012c
        r3 = 499(0x1f3, float:6.99E-43)
        if (r0 <= r3) goto L_0x0126
        goto L_0x012c
    L_0x0126:
        com.bytedance.sdk.adnet.err.b r0 = new com.bytedance.sdk.adnet.err.b     // Catch:{ all -> 0x00e1 }
        r0.m43208init(r1)     // Catch:{ all -> 0x00e1 }
        throw r0     // Catch:{ all -> 0x00e1 }
    L_0x012c:
        r3 = 500(0x1f4, float:7.0E-43)
        if (r0 < r3) goto L_0x014b
        r3 = 599(0x257, float:8.4E-43)
        if (r0 > r3) goto L_0x014b
        boolean r0 = r22.shouldRetryServerErrors()     // Catch:{ all -> 0x00e1 }
        if (r0 == 0) goto L_0x0145
        java.lang.String r0 = "server"
        com.bytedance.sdk.adnet.err.f r3 = new com.bytedance.sdk.adnet.err.f     // Catch:{ all -> 0x00e1 }
        r3.m43217init(r1)     // Catch:{ all -> 0x00e1 }
        m7819a(r0, r8, r3)     // Catch:{ all -> 0x00e1 }
        goto L_0x0166
    L_0x0145:
        com.bytedance.sdk.adnet.err.f r0 = new com.bytedance.sdk.adnet.err.f     // Catch:{ all -> 0x00e1 }
        r0.m43217init(r1)     // Catch:{ all -> 0x00e1 }
        throw r0     // Catch:{ all -> 0x00e1 }
    L_0x014b:
        com.bytedance.sdk.adnet.err.f r0 = new com.bytedance.sdk.adnet.err.f     // Catch:{ all -> 0x00e1 }
        r0.m43217init(r1)     // Catch:{ all -> 0x00e1 }
        throw r0     // Catch:{ all -> 0x00e1 }
    L_0x0151:
        java.lang.String r0 = "auth"
        com.bytedance.sdk.adnet.err.a r3 = new com.bytedance.sdk.adnet.err.a     // Catch:{ all -> 0x00e1 }
        r3.m43206init(r1)     // Catch:{ all -> 0x00e1 }
        m7819a(r0, r8, r3)     // Catch:{ all -> 0x00e1 }
        goto L_0x0166
    L_0x015c:
        java.lang.String r0 = "network"
        com.bytedance.sdk.adnet.err.c r1 = new com.bytedance.sdk.adnet.err.c     // Catch:{ all -> 0x00e1 }
        r1.m43209init()     // Catch:{ all -> 0x00e1 }
        m7819a(r0, r8, r1)     // Catch:{ all -> 0x00e1 }
    L_0x0166:
        if (r2 == 0) goto L_0x0004
        java.io.InputStream r0 = r2.mo14314d()     // Catch:{ all -> 0x0004 }
        if (r0 == 0) goto L_0x0004
    L_0x016e:
        java.io.InputStream r0 = r2.mo14314d()     // Catch:{ all -> 0x0004 }
        r0.close()     // Catch:{ all -> 0x0004 }
        goto L_0x0004
    L_0x0177:
        com.bytedance.sdk.adnet.err.d r1 = new com.bytedance.sdk.adnet.err.d     // Catch:{ all -> 0x00e1 }
        r1.m43212init(r0)     // Catch:{ all -> 0x00e1 }
        throw r1     // Catch:{ all -> 0x00e1 }
    L_0x017d:
        r0 = move-exception
    L_0x017e:
        java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ all -> 0x00e1 }
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e1 }
        r3.<init>()     // Catch:{ all -> 0x00e1 }
        java.lang.String r4 = "Bad URL "
        r3.append(r4)     // Catch:{ all -> 0x00e1 }
        java.lang.String r4 = r22.getUrl()     // Catch:{ all -> 0x00e1 }
        r3.append(r4)     // Catch:{ all -> 0x00e1 }
        java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00e1 }
        r1.<init>(r3, r0)     // Catch:{ all -> 0x00e1 }
        throw r1     // Catch:{ all -> 0x00e1 }
    L_0x0199:
        java.lang.String r0 = "socket"
        com.bytedance.sdk.adnet.err.g r1 = new com.bytedance.sdk.adnet.err.g     // Catch:{ all -> 0x00e1 }
        r1.m43218init()     // Catch:{ all -> 0x00e1 }
        m7819a(r0, r8, r1)     // Catch:{ all -> 0x00e1 }
        if (r2 == 0) goto L_0x0004
        java.io.InputStream r0 = r2.mo14314d()     // Catch:{ all -> 0x0004 }
        if (r0 == 0) goto L_0x0004
        goto L_0x016e
    L_0x01ac:
        if (r2 == 0) goto L_0x01bb
        java.io.InputStream r1 = r2.mo14314d()     // Catch:{ all -> 0x01bb }
        if (r1 == 0) goto L_0x01bb
        java.io.InputStream r1 = r2.mo14314d()     // Catch:{ all -> 0x01bb }
        r1.close()     // Catch:{ all -> 0x01bb }
    L_0x01bb:
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.adnet.core.BasicNetwork.mo14315a(com.bytedance.sdk.adnet.core.Request):com.bytedance.sdk.adnet.core.l");
    }

    /* renamed from: a */
    private void m7818a(long j, Request<?> request, byte[] bArr, int i) {
        if (f6220a || j > 3000) {
            Object[] objArr = new Object[5];
            objArr[0] = request;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(i);
            objArr[4] = Integer.valueOf(request.getRetryPolicy().mo14332b());
            VNetLog.m7928b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    /* renamed from: a */
    private static void m7819a(String str, Request<?> request, VAdError vAdError) throws VAdError {
        IRetryPolicy retryPolicy = request.getRetryPolicy();
        int timeoutMs = request.getTimeoutMs();
        try {
            retryPolicy.mo14331a(vAdError);
            request.addMarker(String.format("%s-retry [timeout=%s]", new Object[]{str, Integer.valueOf(timeoutMs)}));
        } catch (VAdError e) {
            request.addMarker(String.format("%s-timeout-giveup [timeout=%s]", new Object[]{str, Integer.valueOf(timeoutMs)}));
            throw e;
        }
    }

    /* renamed from: a */
    private Map<String, String> m7817a(C1994a aVar) {
        if (aVar == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        if (aVar.f6326c != null) {
            hashMap.put("If-None-Match", aVar.f6326c);
        }
        if (aVar.f6328e > 0) {
            hashMap.put("If-Modified-Since", HttpHeaderParser.m7940a(aVar.f6328e));
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public byte[] mo14316a(Request<?> request, HttpResponse bVar) throws IOException, ServerError {
        if (request instanceof FileRequest) {
            return ((FileRequest) request).mo14191a(bVar);
        }
        InputStream d = bVar.mo14314d();
        return d != null ? m7820a(d, bVar.mo14313c()) : new byte[0];
    }

    /* renamed from: a */
    private byte[] m7820a(InputStream inputStream, int i) throws IOException, ServerError {
        ByteArrayPoolOutputStream eVar = new ByteArrayPoolOutputStream(this.f6222c, i);
        String str = "Error occurred when closing InputStream";
        byte[] bArr = null;
        if (inputStream != null) {
            try {
                bArr = this.f6222c.mo14318a(1024);
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    eVar.write(bArr, 0, read);
                }
                byte[] byteArray = eVar.toByteArray();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                        VNetLog.m7926a(str, new Object[0]);
                    }
                }
                return byteArray;
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                        VNetLog.m7926a(str, new Object[0]);
                    }
                }
                this.f6222c.mo14317a(bArr);
                eVar.close();
            }
        } else {
            throw new ServerError();
        }
    }

    /* renamed from: a */
    private static List<C1969a> m7816a(List<C1969a> list, C1994a aVar) {
        ArrayList arrayList = new ArrayList();
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (list != null && !list.isEmpty()) {
            for (C1969a aVar2 : list) {
                treeSet.add(aVar2.mo14306a());
                arrayList.add(aVar2);
            }
        }
        if (aVar != null) {
            if (aVar.f6332i != null) {
                if (!aVar.f6332i.isEmpty()) {
                    for (C1969a aVar3 : aVar.f6332i) {
                        if (!treeSet.contains(aVar3.mo14306a())) {
                            arrayList.add(aVar3);
                        }
                    }
                }
            } else if (!aVar.f6331h.isEmpty()) {
                for (Entry entry : aVar.f6331h.entrySet()) {
                    if (!treeSet.contains(entry.getKey())) {
                        arrayList.add(new C1969a((String) entry.getKey(), (String) entry.getValue()));
                    }
                }
            }
        }
        return arrayList;
    }
}
