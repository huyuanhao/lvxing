package com.alipay.sdk.p123d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.CookieManager;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.List;
import java.util.Map;
import p655io.reactivex.annotations.SchedulerSupport;

/* renamed from: com.alipay.sdk.d.a */
public final class C1518a {
    /* renamed from: a */
    private static final CookieManager f3888a = new CookieManager();

    /* renamed from: com.alipay.sdk.d.a$a */
    public static final class C1519a {
        /* renamed from: a */
        public final String f3889a;
        /* renamed from: b */
        public final byte[] f3890b;
        /* renamed from: c */
        public final Map<String, String> f3891c;

        public C1519a(String str, Map<String, String> map, byte[] bArr) {
            this.f3889a = str;
            this.f3890b = bArr;
            this.f3891c = map;
        }

        public String toString() {
            return String.format("<UrlConnectionConfigure url=%s requestBody=%s headers=%s>", new Object[]{this.f3889a, this.f3890b, this.f3891c});
        }
    }

    /* renamed from: com.alipay.sdk.d.a$b */
    public static final class C1520b {
        /* renamed from: a */
        public final Map<String, List<String>> f3892a;
        /* renamed from: b */
        public final String f3893b;
        /* renamed from: c */
        public final byte[] f3894c;

        public C1520b(Map<String, List<String>> map, String str, byte[] bArr) {
            this.f3892a = map;
            this.f3893b = str;
            this.f3894c = bArr;
        }
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v10, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r13v6, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r11v0 */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r0v12 */
    /* JADX WARNING: type inference failed for: r0v13, types: [java.io.OutputStream, java.io.BufferedOutputStream] */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r0v14 */
    /* JADX WARNING: type inference failed for: r0v19 */
    /* JADX WARNING: type inference failed for: r0v20 */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x0187 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01cc A[SYNTHETIC, Splitter:B:107:0x01cc] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c0 A[Catch:{ all -> 0x019c }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00fa A[Catch:{ all -> 0x019c }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0107 A[Catch:{ all -> 0x019c }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0119 A[Catch:{ all -> 0x0198 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x014b A[Catch:{ all -> 0x0192 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0184 A[SYNTHETIC, Splitter:B:63:0x0184] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x018e A[SYNTHETIC, Splitter:B:69:0x018e] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01a9 A[SYNTHETIC, Splitter:B:85:0x01a9] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01b0 A[SYNTHETIC, Splitter:B:89:0x01b0] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01b7 A[SYNTHETIC, Splitter:B:93:0x01b7] */
    /* JADX WARNING: Unknown variable types count: 7 */
    /* renamed from: a */
    public static com.alipay.sdk.p123d.C1518a.C1520b m4522a(android.content.Context r12, com.alipay.sdk.p123d.C1518a.C1519a r13) {
        /*
        java.lang.String r0 = "Keep-Alive"
        java.lang.String r1 = "msp"
        r2 = 0
        if (r12 != 0) goto L_0x0008
        return r2
    L_0x0008:
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x019f }
        r3.<init>()     // Catch:{ all -> 0x019f }
        java.lang.String r4 = "config : "
        r3.append(r4)     // Catch:{ all -> 0x019f }
        r3.append(r13)     // Catch:{ all -> 0x019f }
        java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x019f }
        com.alipay.sdk.util.C1542e.m4634b(r1, r3)     // Catch:{ all -> 0x019f }
        java.net.URL r3 = new java.net.URL     // Catch:{ all -> 0x019f }
        java.lang.String r4 = r13.f3889a     // Catch:{ all -> 0x019f }
        r3.<init>(r4)     // Catch:{ all -> 0x019f }
        java.net.Proxy r12 = m4523a(r12)     // Catch:{ all -> 0x019f }
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x019f }
        r4.<init>()     // Catch:{ all -> 0x019f }
        java.lang.String r5 = "proxy: "
        r4.append(r5)     // Catch:{ all -> 0x019f }
        r4.append(r12)     // Catch:{ all -> 0x019f }
        java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x019f }
        com.alipay.sdk.util.C1542e.m4634b(r1, r4)     // Catch:{ all -> 0x019f }
        if (r12 == 0) goto L_0x0044
        java.net.URLConnection r12 = r3.openConnection(r12)     // Catch:{ all -> 0x019f }
        java.net.HttpURLConnection r12 = (java.net.HttpURLConnection) r12     // Catch:{ all -> 0x019f }
        goto L_0x004a
    L_0x0044:
        java.net.URLConnection r12 = r3.openConnection()     // Catch:{ all -> 0x019f }
        java.net.HttpURLConnection r12 = (java.net.HttpURLConnection) r12     // Catch:{ all -> 0x019f }
    L_0x004a:
        java.lang.String r4 = "http.keepAlive"
        java.lang.String r5 = "false"
        java.lang.System.setProperty(r4, r5)     // Catch:{ all -> 0x019c }
        boolean r4 = r12 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ all -> 0x019c }
        if (r4 == 0) goto L_0x0058
        r4 = r12
        javax.net.ssl.HttpsURLConnection r4 = (javax.net.ssl.HttpsURLConnection) r4     // Catch:{ all -> 0x019c }
    L_0x0058:
        java.net.CookieManager r4 = f3888a     // Catch:{ all -> 0x019c }
        java.net.CookieStore r4 = r4.getCookieStore()     // Catch:{ all -> 0x019c }
        java.util.List r4 = r4.getCookies()     // Catch:{ all -> 0x019c }
        int r4 = r4.size()     // Catch:{ all -> 0x019c }
        if (r4 <= 0) goto L_0x007d
        java.lang.String r4 = "Cookie"
        java.lang.String r5 = ";"
        java.net.CookieManager r6 = f3888a     // Catch:{ all -> 0x019c }
        java.net.CookieStore r6 = r6.getCookieStore()     // Catch:{ all -> 0x019c }
        java.util.List r6 = r6.getCookies()     // Catch:{ all -> 0x019c }
        java.lang.String r5 = android.text.TextUtils.join(r5, r6)     // Catch:{ all -> 0x019c }
        r12.setRequestProperty(r4, r5)     // Catch:{ all -> 0x019c }
    L_0x007d:
        r4 = 20000(0x4e20, float:2.8026E-41)
        r12.setConnectTimeout(r4)     // Catch:{ all -> 0x019c }
        r4 = 30000(0x7530, float:4.2039E-41)
        r12.setReadTimeout(r4)     // Catch:{ all -> 0x019c }
        r4 = 1
        r12.setInstanceFollowRedirects(r4)     // Catch:{ all -> 0x019c }
        java.lang.String r5 = "User-Agent"
        r12.setRequestProperty(r5, r1)     // Catch:{ all -> 0x019c }
        byte[] r1 = r13.f3890b     // Catch:{ all -> 0x019c }
        java.lang.String r5 = "POST"
        if (r1 == 0) goto L_0x00b7
        byte[] r1 = r13.f3890b     // Catch:{ all -> 0x019c }
        int r1 = r1.length     // Catch:{ all -> 0x019c }
        if (r1 <= 0) goto L_0x00b7
        r12.setRequestMethod(r5)     // Catch:{ all -> 0x019c }
        java.lang.String r1 = "Content-Type"
        java.lang.String r6 = "application/octet-stream;binary/octet-stream"
        r12.setRequestProperty(r1, r6)     // Catch:{ all -> 0x019c }
        java.lang.String r1 = "Accept-Charset"
        java.lang.String r6 = "UTF-8"
        r12.setRequestProperty(r1, r6)     // Catch:{ all -> 0x019c }
        java.lang.String r1 = "Connection"
        r12.setRequestProperty(r1, r0)     // Catch:{ all -> 0x019c }
        java.lang.String r1 = "timeout=180, max=100"
        r12.setRequestProperty(r0, r1)     // Catch:{ all -> 0x019c }
        goto L_0x00bc
    L_0x00b7:
        java.lang.String r0 = "GET"
        r12.setRequestMethod(r0)     // Catch:{ all -> 0x019c }
    L_0x00bc:
        java.util.Map<java.lang.String, java.lang.String> r0 = r13.f3891c     // Catch:{ all -> 0x019c }
        if (r0 == 0) goto L_0x00ed
        java.util.Map<java.lang.String, java.lang.String> r0 = r13.f3891c     // Catch:{ all -> 0x019c }
        java.util.Set r0 = r0.entrySet()     // Catch:{ all -> 0x019c }
        java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x019c }
    L_0x00ca:
        boolean r1 = r0.hasNext()     // Catch:{ all -> 0x019c }
        if (r1 == 0) goto L_0x00ed
        java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x019c }
        java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ all -> 0x019c }
        java.lang.Object r6 = r1.getKey()     // Catch:{ all -> 0x019c }
        if (r6 != 0) goto L_0x00dd
        goto L_0x00ca
    L_0x00dd:
        java.lang.Object r6 = r1.getKey()     // Catch:{ all -> 0x019c }
        java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x019c }
        java.lang.Object r1 = r1.getValue()     // Catch:{ all -> 0x019c }
        java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x019c }
        r12.setRequestProperty(r6, r1)     // Catch:{ all -> 0x019c }
        goto L_0x00ca
    L_0x00ed:
        r12.setDoInput(r4)     // Catch:{ all -> 0x019c }
        java.lang.String r0 = r12.getRequestMethod()     // Catch:{ all -> 0x019c }
        boolean r0 = r5.equals(r0)     // Catch:{ all -> 0x019c }
        if (r0 == 0) goto L_0x00fd
        r12.setDoOutput(r4)     // Catch:{ all -> 0x019c }
    L_0x00fd:
        java.lang.String r0 = r12.getRequestMethod()     // Catch:{ all -> 0x019c }
        boolean r0 = r5.equals(r0)     // Catch:{ all -> 0x019c }
        if (r0 == 0) goto L_0x0119
        java.io.BufferedOutputStream r0 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x019c }
        java.io.OutputStream r1 = r12.getOutputStream()     // Catch:{ all -> 0x019c }
        r0.<init>(r1)     // Catch:{ all -> 0x019c }
        byte[] r13 = r13.f3890b     // Catch:{ all -> 0x0198 }
        r0.write(r13)     // Catch:{ all -> 0x0198 }
        r0.flush()     // Catch:{ all -> 0x0198 }
        goto L_0x011a
    L_0x0119:
        r0 = r2
    L_0x011a:
        java.io.BufferedInputStream r13 = new java.io.BufferedInputStream     // Catch:{ all -> 0x0198 }
        java.io.InputStream r1 = r12.getInputStream()     // Catch:{ all -> 0x0198 }
        r13.<init>(r1)     // Catch:{ all -> 0x0198 }
        byte[] r1 = m4524a(r13)     // Catch:{ all -> 0x0192 }
        java.util.Map r4 = r12.getHeaderFields()     // Catch:{ all -> 0x0192 }
        if (r4 == 0) goto L_0x0140
        java.lang.Object r5 = r4.get(r2)     // Catch:{ all -> 0x0192 }
        if (r5 == 0) goto L_0x0140
        java.lang.String r5 = ","
        java.lang.Object r6 = r4.get(r2)     // Catch:{ all -> 0x0192 }
        java.lang.Iterable r6 = (java.lang.Iterable) r6     // Catch:{ all -> 0x0192 }
        java.lang.String r5 = android.text.TextUtils.join(r5, r6)     // Catch:{ all -> 0x0192 }
        goto L_0x0141
    L_0x0140:
        r5 = r2
    L_0x0141:
        java.lang.String r6 = "Set-Cookie"
        java.lang.Object r6 = r4.get(r6)     // Catch:{ all -> 0x0192 }
        java.util.List r6 = (java.util.List) r6     // Catch:{ all -> 0x0192 }
        if (r6 == 0) goto L_0x017d
        java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0192 }
    L_0x014f:
        boolean r7 = r6.hasNext()     // Catch:{ all -> 0x0192 }
        if (r7 == 0) goto L_0x017d
        java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x0192 }
        java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x0192 }
        java.util.List r7 = java.net.HttpCookie.parse(r7)     // Catch:{ all -> 0x0192 }
        if (r7 == 0) goto L_0x014f
        boolean r8 = r7.isEmpty()     // Catch:{ all -> 0x0192 }
        if (r8 == 0) goto L_0x0168
        goto L_0x014f
    L_0x0168:
        java.net.CookieManager r8 = f3888a     // Catch:{ all -> 0x0192 }
        java.net.CookieStore r8 = r8.getCookieStore()     // Catch:{ all -> 0x0192 }
        java.net.URI r9 = r3.toURI()     // Catch:{ all -> 0x0192 }
        r10 = 0
        java.lang.Object r7 = r7.get(r10)     // Catch:{ all -> 0x0192 }
        java.net.HttpCookie r7 = (java.net.HttpCookie) r7     // Catch:{ all -> 0x0192 }
        r8.add(r9, r7)     // Catch:{ all -> 0x0192 }
        goto L_0x014f
    L_0x017d:
        com.alipay.sdk.d.a$b r3 = new com.alipay.sdk.d.a$b     // Catch:{ all -> 0x0192 }
        r3.m42149init(r4, r5, r1)     // Catch:{ all -> 0x0192 }
        if (r12 == 0) goto L_0x0187
        r12.disconnect()     // Catch:{ all -> 0x0187 }
    L_0x0187:
        r13.close()     // Catch:{ all -> 0x018b }
        goto L_0x018c
    L_0x018c:
        if (r0 == 0) goto L_0x0191
        r0.close()     // Catch:{ all -> 0x0191 }
    L_0x0191:
        return r3
    L_0x0192:
        r1 = move-exception
        r11 = r0
        r0 = r13
        r13 = r1
        r1 = r11
        goto L_0x01a4
    L_0x0198:
        r13 = move-exception
        r1 = r0
        r0 = r2
        goto L_0x01a4
    L_0x019c:
        r13 = move-exception
        r0 = r2
        goto L_0x01a3
    L_0x019f:
        r12 = move-exception
        r13 = r12
        r12 = r2
        r0 = r12
    L_0x01a3:
        r1 = r0
    L_0x01a4:
        com.alipay.sdk.util.C1542e.m4633a(r13)     // Catch:{ all -> 0x01bb }
        if (r12 == 0) goto L_0x01ae
        r12.disconnect()     // Catch:{ all -> 0x01ad }
        goto L_0x01ae
    L_0x01ae:
        if (r0 == 0) goto L_0x01b5
        r0.close()     // Catch:{ all -> 0x01b4 }
        goto L_0x01b5
    L_0x01b5:
        if (r1 == 0) goto L_0x01ba
        r1.close()     // Catch:{ all -> 0x01ba }
    L_0x01ba:
        return r2
    L_0x01bb:
        r13 = move-exception
        if (r12 == 0) goto L_0x01c3
        r12.disconnect()     // Catch:{ all -> 0x01c2 }
        goto L_0x01c3
    L_0x01c3:
        if (r0 == 0) goto L_0x01ca
        r0.close()     // Catch:{ all -> 0x01c9 }
        goto L_0x01ca
    L_0x01ca:
        if (r1 == 0) goto L_0x01cf
        r1.close()     // Catch:{ all -> 0x01cf }
    L_0x01cf:
        throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.p123d.C1518a.m4522a(android.content.Context, com.alipay.sdk.d.a$a):com.alipay.sdk.d.a$b");
    }

    /* renamed from: a */
    private static Proxy m4523a(Context context) {
        String c = m4526c(context);
        Proxy proxy = null;
        if (c != null && !c.contains("wap")) {
            return null;
        }
        try {
            String property = System.getProperty("https.proxyHost");
            String property2 = System.getProperty("https.proxyPort");
            if (!TextUtils.isEmpty(property)) {
                proxy = new Proxy(Type.HTTP, new InetSocketAddress(property, Integer.parseInt(property2)));
            }
        } catch (Throwable unused) {
        }
        return proxy;
    }

    /* renamed from: b */
    private static NetworkInfo m4525b(Context context) {
        NetworkInfo networkInfo = null;
        if (context == null) {
            return null;
        }
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
        }
        return networkInfo;
    }

    /* renamed from: c */
    private static String m4526c(Context context) {
        String str = SchedulerSupport.NONE;
        try {
            NetworkInfo b = m4525b(context);
            if (b != null && b.isAvailable()) {
                if (b.getType() == 1) {
                    return "wifi";
                }
                return b.getExtraInfo().toLowerCase();
            }
        } catch (Exception unused) {
        }
        return str;
    }

    /* renamed from: a */
    private static byte[] m4524a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, bArr.length);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
