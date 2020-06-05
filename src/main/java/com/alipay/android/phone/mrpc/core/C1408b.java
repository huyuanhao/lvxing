package com.alipay.android.phone.mrpc.core;

import android.net.SSLCertificateSocketFactory;
import android.util.Base64;
import android.util.Log;
import com.kwad.sdk.core.imageloader.core.download.BaseImageDownloader;
import com.tencent.bugly.BuglyStrategy.C7120a;
import com.tencent.mid.core.Constants.ERROR;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.security.Security;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.RequestWrapper;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HttpContext;

/* renamed from: com.alipay.android.phone.mrpc.core.b */
public final class C1408b implements HttpClient {
    /* renamed from: a */
    public static long f3614a = 160;
    /* renamed from: b */
    private static String[] f3615b = {"text/", "application/xml", "application/json"};
    /* access modifiers changed from: private|static|final */
    /* renamed from: c */
    public static final HttpRequestInterceptor f3616c = new C1411c();
    /* renamed from: d */
    private final HttpClient f3617d;
    /* renamed from: e */
    private RuntimeException f3618e = new IllegalStateException("AndroidHttpClient created and never closed");
    /* access modifiers changed from: private|volatile */
    /* renamed from: f */
    public volatile C1410b f3619f;

    /* renamed from: com.alipay.android.phone.mrpc.core.b$a */
    private class C1409a implements HttpRequestInterceptor {
        private C1409a() {
        }

        /* synthetic */ C1409a(C1408b bVar, byte b) {
            this();
        }

        public final void process(HttpRequest httpRequest, HttpContext httpContext) {
            C1410b a = C1408b.this.f3619f;
            if (a != null && Log.isLoggable(a.f3621a, a.f3622b) && (httpRequest instanceof HttpUriRequest)) {
                Log.println(a.f3622b, a.f3621a, C1408b.m4081a((HttpUriRequest) httpRequest));
            }
        }
    }

    /* renamed from: com.alipay.android.phone.mrpc.core.b$b */
    private static class C1410b {
        /* renamed from: a */
        private final String f3621a;
        /* renamed from: b */
        private final int f3622b;
    }

    private C1408b(ClientConnectionManager clientConnectionManager, HttpParams httpParams) {
        this.f3617d = new C1412d(this, clientConnectionManager, httpParams);
    }

    /* renamed from: a */
    public static C1408b m4079a(String str) {
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setUseExpectContinue(basicHttpParams, false);
        HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, true);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT);
        HttpConnectionParams.setSoTimeout(basicHttpParams, C7120a.MAX_USERDATA_VALUE_LENGTH);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        HttpClientParams.setRedirecting(basicHttpParams, true);
        HttpClientParams.setAuthenticating(basicHttpParams, false);
        HttpProtocolParams.setUserAgent(basicHttpParams, str);
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLCertificateSocketFactory.getHttpSocketFactory(C7120a.MAX_USERDATA_VALUE_LENGTH, null), 443));
        ThreadSafeClientConnManager threadSafeClientConnManager = new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry);
        ConnManagerParams.setTimeout(basicHttpParams, 60000);
        ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(10));
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, 50);
        Security.setProperty("networkaddress.cache.ttl", ERROR.CMD_FORMAT_ERROR);
        HttpsURLConnection.setDefaultHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        return new C1408b(threadSafeClientConnManager, basicHttpParams);
    }

    /* renamed from: a */
    public static InputStream m4080a(HttpEntity httpEntity) {
        InputStream content = httpEntity.getContent();
        if (content == null) {
            return content;
        }
        Header contentEncoding = httpEntity.getContentEncoding();
        if (contentEncoding == null) {
            return content;
        }
        String value = contentEncoding.getValue();
        if (value == null) {
            return content;
        }
        return value.contains("gzip") ? new GZIPInputStream(content) : content;
    }

    /* renamed from: a */
    static /* synthetic */ String m4081a(HttpUriRequest httpUriRequest) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("curl ");
        Header[] allHeaders = httpUriRequest.getAllHeaders();
        int length = allHeaders.length;
        for (int i = 0; i < length; i++) {
            Header header = allHeaders[i];
            if (!header.getName().equals("Authorization") && !header.getName().equals("Cookie")) {
                sb.append("--header \"");
                sb.append(header.toString().trim());
                sb.append("\" ");
            }
        }
        URI uri = httpUriRequest.getURI();
        if (httpUriRequest instanceof RequestWrapper) {
            HttpUriRequest original = ((RequestWrapper) httpUriRequest).getOriginal();
            if (original instanceof HttpUriRequest) {
                uri = original.getURI();
            }
        }
        String str2 = "\"";
        sb.append(str2);
        sb.append(uri);
        sb.append(str2);
        if (httpUriRequest instanceof HttpEntityEnclosingRequest) {
            HttpEntity entity = ((HttpEntityEnclosingRequest) httpUriRequest).getEntity();
            if (entity != null && entity.isRepeatable()) {
                if (entity.getContentLength() < 1024) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    entity.writeTo(byteArrayOutputStream);
                    if (m4087b(httpUriRequest)) {
                        String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                        StringBuilder sb2 = new StringBuilder("echo '");
                        sb2.append(encodeToString);
                        sb2.append("' | base64 -d > /tmp/$$.bin; ");
                        sb.insert(0, sb2.toString());
                        str = " --data-binary @/tmp/$$.bin";
                    } else {
                        String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                        sb.append(" --data-ascii \"");
                        sb.append(byteArrayOutputStream2);
                        sb.append(str2);
                    }
                } else {
                    str = " [TOO MUCH DATA TO INCLUDE]";
                }
                sb.append(str);
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static AbstractHttpEntity m4083a(byte[] bArr) {
        if (((long) bArr.length) < f3614a) {
            return new ByteArrayEntity(bArr);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.close();
        ByteArrayEntity byteArrayEntity = new ByteArrayEntity(byteArrayOutputStream.toByteArray());
        byteArrayEntity.setContentEncoding("gzip");
        StringBuilder sb = new StringBuilder("gzip size:");
        sb.append(bArr.length);
        sb.append("->");
        sb.append(byteArrayEntity.getContentLength());
        return byteArrayEntity;
    }

    /* renamed from: a */
    public static void m4084a(HttpRequest httpRequest) {
        httpRequest.addHeader("Accept-Encoding", "gzip");
    }

    /* renamed from: b */
    public static long m4085b(String str) {
        return C1419k.m4102a(str);
    }

    /* renamed from: b */
    public static void m4086b(HttpRequest httpRequest) {
        httpRequest.addHeader("Connection", "Keep-Alive");
    }

    /* renamed from: b */
    private static boolean m4087b(HttpUriRequest httpUriRequest) {
        Header[] headers = httpUriRequest.getHeaders("content-encoding");
        if (headers != null) {
            for (Header value : headers) {
                if ("gzip".equalsIgnoreCase(value.getValue())) {
                    return true;
                }
            }
        }
        Header[] headers2 = httpUriRequest.getHeaders("content-type");
        if (headers2 != null) {
            for (Header header : headers2) {
                for (String startsWith : f3615b) {
                    if (header.getValue().startsWith(startsWith)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /* renamed from: a */
    public final void mo11943a(HttpRequestRetryHandler httpRequestRetryHandler) {
        this.f3617d.setHttpRequestRetryHandler(httpRequestRetryHandler);
    }

    public final <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) {
        return this.f3617d.execute(httpHost, httpRequest, responseHandler);
    }

    public final <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) {
        return this.f3617d.execute(httpHost, httpRequest, responseHandler, httpContext);
    }

    public final <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler) {
        return this.f3617d.execute(httpUriRequest, responseHandler);
    }

    public final <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) {
        return this.f3617d.execute(httpUriRequest, responseHandler, httpContext);
    }

    public final HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest) {
        return this.f3617d.execute(httpHost, httpRequest);
    }

    public final HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) {
        return this.f3617d.execute(httpHost, httpRequest, httpContext);
    }

    public final HttpResponse execute(HttpUriRequest httpUriRequest) {
        return this.f3617d.execute(httpUriRequest);
    }

    public final HttpResponse execute(HttpUriRequest httpUriRequest, HttpContext httpContext) {
        return this.f3617d.execute(httpUriRequest, httpContext);
    }

    public final ClientConnectionManager getConnectionManager() {
        return this.f3617d.getConnectionManager();
    }

    public final HttpParams getParams() {
        return this.f3617d.getParams();
    }
}
