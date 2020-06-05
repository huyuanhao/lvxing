package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.videocache.p344b.C4345b;
import com.kwad.sdk.core.videocache.p346d.C4350b;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map.Entry;

/* renamed from: com.kwad.sdk.core.videocache.h */
public class C4360h implements C4367m {
    /* renamed from: a */
    private final C4350b f14290a;
    /* renamed from: b */
    private final C4345b f14291b;
    /* renamed from: c */
    private C4368n f14292c;
    /* renamed from: d */
    private HttpURLConnection f14293d;
    /* renamed from: e */
    private InputStream f14294e;

    public C4360h(C4360h hVar) {
        this.f14292c = hVar.f14292c;
        this.f14290a = hVar.f14290a;
        this.f14291b = hVar.f14291b;
    }

    public C4360h(String str, C4350b bVar, C4345b bVar2) {
        this.f14290a = (C4350b) C4362j.m17805a(bVar);
        this.f14291b = (C4345b) C4362j.m17805a(bVar2);
        C4368n a = bVar.mo24499a(str);
        if (a == null) {
            a = new C4368n(str, -2147483648L, C4366l.m17824a(str));
        }
        this.f14292c = a;
    }

    /* renamed from: a */
    private long m17793a(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (headerField == null) {
            return -1;
        }
        return Long.parseLong(headerField);
    }

    /* renamed from: a */
    private long m17794a(HttpURLConnection httpURLConnection, long j, int i) {
        long a = m17793a(httpURLConnection);
        return i == 200 ? a : i == 206 ? a + j : this.f14292c.f14309b;
    }

    /* renamed from: a */
    private HttpURLConnection m17795a(long j, int i) {
        String str;
        HttpURLConnection httpURLConnection;
        boolean z;
        String str2 = this.f14292c.f14308a;
        int i2 = 0;
        do {
            StringBuilder sb = new StringBuilder();
            sb.append("Open connection ");
            int i3 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i3 > 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(" with offset ");
                sb2.append(j);
                str = sb2.toString();
            } else {
                str = "";
            }
            sb.append(str);
            sb.append(" to ");
            sb.append(str2);
            C4065b.m16863a("HttpUrlSource", sb.toString());
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            m17796a(httpURLConnection, str2);
            if (i3 > 0) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("bytes=");
                sb3.append(j);
                sb3.append("-");
                httpURLConnection.setRequestProperty("Range", sb3.toString());
            }
            if (i > 0) {
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.setReadTimeout(i);
            }
            int responseCode = httpURLConnection.getResponseCode();
            z = responseCode == 301 || responseCode == 302 || responseCode == 303;
            if (z) {
                str2 = httpURLConnection.getHeaderField("Location");
                i2++;
                httpURLConnection.disconnect();
            }
            if (i2 > 5) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Too many redirects: ");
                sb4.append(i2);
                throw new ProxyCacheException(sb4.toString());
            }
        } while (z);
        return httpURLConnection;
    }

    /* renamed from: a */
    private void m17796a(HttpURLConnection httpURLConnection, String str) {
        for (Entry entry : this.f14291b.mo24496a(str).entrySet()) {
            httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:12|13|14|(1:23)) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            r2 = new java.lang.StringBuilder();
            r2.append("Error fetching info from ");
            r2.append(r8.f14292c.f14308a);
            com.kwad.sdk.core.p319c.C4065b.m16869d(r1, r2.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x007f, code lost:
            com.kwad.sdk.core.videocache.C4366l.m17826a((java.io.Closeable) r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0082, code lost:
            if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x008d, code lost:
            r0.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0061, code lost:
            r1 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0067 */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x008d  */
    /* renamed from: e */
    private void m17797e() {
        /*
        r8 = this;
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r1 = "Read content info from "
        r0.append(r1)
        com.kwad.sdk.core.videocache.n r1 = r8.f14292c
        java.lang.String r1 = r1.f14308a
        r0.append(r1)
        java.lang.String r0 = r0.toString()
        java.lang.String r1 = "HttpUrlSource"
        com.kwad.sdk.core.p319c.C4065b.m16863a(r1, r0)
        r2 = 0
        r0 = 10000(0x2710, float:1.4013E-41)
        r4 = 0
        java.net.HttpURLConnection r0 = r8.m17795a(r2, r0)     // Catch:{ IOException -> 0x0066, all -> 0x0063 }
        long r2 = r8.m17793a(r0)     // Catch:{ IOException -> 0x0067 }
        java.lang.String r5 = r0.getContentType()     // Catch:{ IOException -> 0x0067 }
        java.io.InputStream r4 = r0.getInputStream()     // Catch:{ IOException -> 0x0067 }
        com.kwad.sdk.core.videocache.n r6 = new com.kwad.sdk.core.videocache.n     // Catch:{ IOException -> 0x0067 }
        com.kwad.sdk.core.videocache.n r7 = r8.f14292c     // Catch:{ IOException -> 0x0067 }
        java.lang.String r7 = r7.f14308a     // Catch:{ IOException -> 0x0067 }
        r6.m48321init(r7, r2, r5)     // Catch:{ IOException -> 0x0067 }
        r8.f14292c = r6     // Catch:{ IOException -> 0x0067 }
        com.kwad.sdk.core.videocache.d.b r2 = r8.f14290a     // Catch:{ IOException -> 0x0067 }
        com.kwad.sdk.core.videocache.n r3 = r8.f14292c     // Catch:{ IOException -> 0x0067 }
        java.lang.String r3 = r3.f14308a     // Catch:{ IOException -> 0x0067 }
        com.kwad.sdk.core.videocache.n r5 = r8.f14292c     // Catch:{ IOException -> 0x0067 }
        r2.mo24500a(r3, r5)     // Catch:{ IOException -> 0x0067 }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0067 }
        r2.<init>()     // Catch:{ IOException -> 0x0067 }
        java.lang.String r3 = "Source info fetched: "
        r2.append(r3)     // Catch:{ IOException -> 0x0067 }
        com.kwad.sdk.core.videocache.n r3 = r8.f14292c     // Catch:{ IOException -> 0x0067 }
        r2.append(r3)     // Catch:{ IOException -> 0x0067 }
        java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x0067 }
        com.kwad.sdk.core.p319c.C4065b.m16863a(r1, r2)     // Catch:{ IOException -> 0x0067 }
        com.kwad.sdk.core.videocache.C4366l.m17826a(r4)
        if (r0 == 0) goto L_0x0087
        goto L_0x0084
    L_0x0061:
        r1 = move-exception
        goto L_0x0088
    L_0x0063:
        r1 = move-exception
        r0 = r4
        goto L_0x0088
    L_0x0066:
        r0 = r4
    L_0x0067:
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0061 }
        r2.<init>()     // Catch:{ all -> 0x0061 }
        java.lang.String r3 = "Error fetching info from "
        r2.append(r3)     // Catch:{ all -> 0x0061 }
        com.kwad.sdk.core.videocache.n r3 = r8.f14292c     // Catch:{ all -> 0x0061 }
        java.lang.String r3 = r3.f14308a     // Catch:{ all -> 0x0061 }
        r2.append(r3)     // Catch:{ all -> 0x0061 }
        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0061 }
        com.kwad.sdk.core.p319c.C4065b.m16869d(r1, r2)     // Catch:{ all -> 0x0061 }
        com.kwad.sdk.core.videocache.C4366l.m17826a(r4)
        if (r0 == 0) goto L_0x0087
    L_0x0084:
        r0.disconnect()
    L_0x0087:
        return
    L_0x0088:
        com.kwad.sdk.core.videocache.C4366l.m17826a(r4)
        if (r0 == 0) goto L_0x0090
        r0.disconnect()
    L_0x0090:
        throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.videocache.C4360h.m17797e():void");
    }

    /* renamed from: a */
    public int mo24516a(byte[] bArr) {
        InputStream inputStream = this.f14294e;
        String str = "Error reading data from ";
        if (inputStream != null) {
            try {
                return inputStream.read(bArr, 0, bArr.length);
            } catch (InterruptedIOException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Reading source ");
                sb.append(this.f14292c.f14308a);
                sb.append(" is interrupted");
                throw new InterruptedProxyCacheException(sb.toString(), e);
            } catch (IOException e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(this.f14292c.f14308a);
                throw new ProxyCacheException(sb2.toString(), e2);
            }
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append(this.f14292c.f14308a);
            sb3.append(": connection is absent!");
            throw new ProxyCacheException(sb3.toString());
        }
    }

    /* renamed from: a */
    public synchronized long mo24517a() {
        if (this.f14292c.f14309b == -2147483648L) {
            m17797e();
        }
        return this.f14292c.f14309b;
    }

    /* renamed from: a */
    public void mo24518a(long j) {
        try {
            this.f14293d = m17795a(j, -1);
            String contentType = this.f14293d.getContentType();
            this.f14294e = new BufferedInputStream(this.f14293d.getInputStream(), 8192);
            this.f14292c = new C4368n(this.f14292c.f14308a, m17794a(this.f14293d, j, this.f14293d.getResponseCode()), contentType);
            this.f14290a.mo24500a(this.f14292c.f14308a, this.f14292c);
        } catch (IOException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error opening connection for ");
            sb.append(this.f14292c.f14308a);
            sb.append(" with offset ");
            sb.append(j);
            throw new ProxyCacheException(sb.toString(), e);
        }
    }

    /* renamed from: b */
    public void mo24519b() {
        HttpURLConnection httpURLConnection = this.f14293d;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (IllegalArgumentException | NullPointerException e) {
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            } catch (ArrayIndexOutOfBoundsException unused) {
                C4065b.m16869d("HttpUrlSource", "Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit https://github.com/danikula/AndroidVideoCache/issues/88. Until good solution is not know, just ignore this issue.");
            }
        }
    }

    /* renamed from: c */
    public synchronized String mo24520c() {
        if (TextUtils.isEmpty(this.f14292c.f14310c)) {
            m17797e();
        }
        return this.f14292c.f14310c;
    }

    /* renamed from: d */
    public String mo24521d() {
        return this.f14292c.f14308a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HttpUrlSource{sourceInfo='");
        sb.append(this.f14292c);
        sb.append("}");
        return sb.toString();
    }
}
