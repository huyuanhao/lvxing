package com.bytedance.sdk.adnet.core;

import android.text.TextUtils;
import com.bytedance.sdk.adnet.AdNetSdk;
import com.bytedance.sdk.adnet.err.AuthFailureError;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.p161d.HTTPSTrustManager;
import com.bytedance.sdk.adnet.p162e.IHttpStack;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: com.bytedance.sdk.adnet.core.j */
public class HurlStack implements IHttpStack {
    /* renamed from: a */
    private final C1978b f6266a;
    /* renamed from: b */
    private final SSLSocketFactory f6267b;

    /* compiled from: HurlStack */
    /* renamed from: com.bytedance.sdk.adnet.core.j$a */
    static class C1977a extends FilterInputStream {
        /* renamed from: a */
        private final HttpURLConnection f6268a;

        C1977a(HttpURLConnection httpURLConnection) {
            super(HurlStack.m7882c(httpURLConnection));
            this.f6268a = httpURLConnection;
        }

        public void close() throws IOException {
            super.close();
            this.f6268a.disconnect();
        }
    }

    /* compiled from: HurlStack */
    /* renamed from: com.bytedance.sdk.adnet.core.j$b */
    public interface C1978b {
        /* renamed from: a */
        String mo14356a(String str);
    }

    /* renamed from: a */
    private static boolean m7878a(int i, int i2) {
        return (i == 4 || (100 <= i2 && i2 < 200) || i2 == 204 || i2 == 304) ? false : true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo14354a(HttpURLConnection httpURLConnection) {
        return false;
    }

    public HurlStack() {
        this(null);
    }

    public HurlStack(C1978b bVar) {
        this(bVar, null);
    }

    public HurlStack(C1978b bVar, SSLSocketFactory sSLSocketFactory) {
        this.f6266a = bVar;
        this.f6267b = sSLSocketFactory;
    }

    /* renamed from: a */
    public HttpResponse mo14352a(Request<?> request, Map<String, String> map) throws IOException, VAdError {
        String str;
        String url = request.getUrl();
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(request.getUserAgent())) {
            hashMap.put("User-Agent", request.getUserAgent());
        }
        hashMap.putAll(map);
        hashMap.putAll(request.getHeaders());
        C1978b bVar = this.f6266a;
        if (bVar != null) {
            str = bVar.mo14356a(url);
            if (str == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("URL blocked by rewriter: ");
                sb.append(url);
                throw new IOException(sb.toString());
            }
        } else {
            str = url;
        }
        HttpURLConnection a = m7873a(new URL(str), request);
        boolean z = false;
        try {
            for (String str2 : hashMap.keySet()) {
                a.setRequestProperty(str2, (String) hashMap.get(str2));
            }
            m7876a(a, request);
            int responseCode = a.getResponseCode();
            if (responseCode == -1) {
                throw new IOException("Could not retrieve response code from HttpUrlConnection.");
            } else if (!m7878a(request.getMethod(), responseCode)) {
                HttpResponse bVar2 = new HttpResponse(responseCode, m7874a(a.getHeaderFields()));
                a.disconnect();
                return bVar2;
            } else {
                z = true;
                return new HttpResponse(responseCode, m7874a(a.getHeaderFields()), a.getContentLength(), new C1977a(a));
            }
        } catch (Throwable th) {
            if (!z) {
                a.disconnect();
            }
            throw th;
        }
    }

    /* renamed from: a */
    static List<C1969a> m7874a(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Entry entry : map.entrySet()) {
            if (entry.getKey() != null) {
                for (String aVar : (List) entry.getValue()) {
                    arrayList.add(new C1969a((String) entry.getKey(), aVar));
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* access modifiers changed from: private|static */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: c */
    public static java.io.InputStream m7882c(java.net.HttpURLConnection r0) {
        /*
        java.io.InputStream r0 = r0.getInputStream()     // Catch:{ IOException -> 0x0005 }
        goto L_0x0009
    L_0x0005:
        java.io.InputStream r0 = r0.getErrorStream()
    L_0x0009:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.adnet.core.HurlStack.m7882c(java.net.HttpURLConnection):java.io.InputStream");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public HttpURLConnection mo14353a(URL url) throws IOException {
        HttpURLConnection httpURLConnection;
        String str = null;
        if (url == null) {
            return null;
        }
        String host = url.getHost();
        if (AdNetSdk.f6053a != null) {
            str = AdNetSdk.f6053a.mo14375a(host);
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                httpURLConnection = (HttpURLConnection) new URL(url.toString().replaceFirst(host, str)).openConnection();
                httpURLConnection.setRequestProperty("Host", host);
                if (httpURLConnection == null) {
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                }
            } catch (Exception unused) {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        }
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return httpURLConnection;
    }

    /* renamed from: a */
    private HttpURLConnection m7873a(URL url, Request<?> request) throws IOException {
        HttpURLConnection a = mo14353a(url);
        m7875a(request);
        int timeoutMs = request.getTimeoutMs();
        a.setConnectTimeout(timeoutMs);
        a.setReadTimeout(timeoutMs);
        a.setUseCaches(false);
        a.setDoInput(true);
        if ("https".equals(url.getProtocol())) {
            if (mo14354a(a)) {
                VNetLog.m7928b("connection verify by inner", new Object[0]);
            } else {
                SSLSocketFactory sSLSocketFactory = this.f6267b;
                if (sSLSocketFactory == null) {
                    HTTPSTrustManager.m7937a();
                } else {
                    ((HttpsURLConnection) a).setSSLSocketFactory(sSLSocketFactory);
                }
            }
        }
        return a;
    }

    /* renamed from: a */
    private void m7875a(Request<?> request) {
        if (request != null) {
            request.setIpAddrStr(m7880b(request));
        }
    }

    /* renamed from: b */
    private String m7880b(Request<?> request) {
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

    /* renamed from: a */
    static void m7876a(HttpURLConnection httpURLConnection, Request<?> request) throws IOException, AuthFailureError {
        String str = "POST";
        switch (request.getMethod()) {
            case -1:
                byte[] postBody = request.getPostBody();
                if (postBody != null) {
                    httpURLConnection.setRequestMethod(str);
                    m7877a(httpURLConnection, request, postBody);
                    return;
                }
                return;
            case 0:
                httpURLConnection.setRequestMethod("GET");
                return;
            case 1:
                httpURLConnection.setRequestMethod(str);
                m7881b(httpURLConnection, request);
                return;
            case 2:
                httpURLConnection.setRequestMethod("PUT");
                m7881b(httpURLConnection, request);
                return;
            case 3:
                httpURLConnection.setRequestMethod("DELETE");
                return;
            case 4:
                httpURLConnection.setRequestMethod("HEAD");
                return;
            case 5:
                httpURLConnection.setRequestMethod("OPTIONS");
                return;
            case 6:
                httpURLConnection.setRequestMethod("TRACE");
                return;
            case 7:
                httpURLConnection.setRequestMethod("PATCH");
                m7881b(httpURLConnection, request);
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    /* renamed from: b */
    private static void m7881b(HttpURLConnection httpURLConnection, Request<?> request) throws IOException, AuthFailureError {
        byte[] body = request.getBody();
        if (body != null) {
            m7877a(httpURLConnection, request, body);
        }
    }

    /* renamed from: a */
    private static void m7877a(HttpURLConnection httpURLConnection, Request<?> request, byte[] bArr) throws IOException {
        httpURLConnection.setDoOutput(true);
        String str = "Content-Type";
        if (!httpURLConnection.getRequestProperties().containsKey(str)) {
            httpURLConnection.setRequestProperty(str, request.getBodyContentType());
        }
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.write(bArr);
        dataOutputStream.close();
    }
}
