package com.tencent.mid.core;

import com.tencent.bugly.BuglyStrategy.C7120a;
import com.tencent.mid.util.Logger;
import com.tencent.mid.util.RSAHelper;
import com.tencent.mid.util.Util;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

public class HttpConnectClient {
    private static final String HEADER_CONTENT_ENCODING = "Content-Encoding";
    private String addr;
    private DefaultHttpClient client;
    private Map<String, String> httpParamsMap;
    private Logger logger;
    private HttpHost proxy;
    private int timeout;

    public HttpResponseResult httpPost(String str, byte[] bArr, String str2, int i) throws Exception {
        String httpFullUrl = getHttpFullUrl(str);
        Logger logger2 = this.logger;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(httpFullUrl);
        sb.append("]Send request(");
        sb.append(bArr.length);
        sb.append("bytes):");
        sb.append(bArr);
        logger2.mo35700i(sb.toString());
        HttpPost httpPost = new HttpPost(httpFullUrl);
        httpPost.setHeader("Connection", "Keep-Alive");
        httpPost.removeHeaders("Cache-Control");
        httpPost.removeHeaders("User-Agent");
        if (this.proxy != null) {
            httpPost.addHeader("X-Online-Host", this.addr);
            httpPost.addHeader("Accept", "*/*");
            httpPost.addHeader("Content-Type", "json");
        } else {
            this.client.getParams().removeParameter("http.route.default-proxy");
        }
        HttpHost httpHost = this.proxy;
        String str3 = HEADER_CONTENT_ENCODING;
        if (httpHost == null) {
            httpPost.addHeader(str3, str2);
        } else {
            httpPost.addHeader("X-Content-Encoding", str2);
        }
        httpPost.setEntity(new ByteArrayEntity(bArr));
        HttpResponse execute = this.client.execute(httpPost);
        HttpEntity entity = execute.getEntity();
        int statusCode = execute.getStatusLine().getStatusCode();
        long contentLength = entity.getContentLength();
        Logger logger3 = this.logger;
        StringBuilder sb2 = new StringBuilder();
        String str4 = "recv response status code:";
        sb2.append(str4);
        sb2.append(statusCode);
        sb2.append(", content length:");
        sb2.append(contentLength);
        logger3.mo35700i(sb2.toString());
        byte[] byteArray = EntityUtils.toByteArray(entity);
        String str5 = "";
        Header firstHeader = execute.getFirstHeader(str3);
        if (firstHeader != null) {
            String str6 = "UTF-8";
            if (firstHeader.getValue().toUpperCase().contains("AES")) {
                str5 = new String(HttpManager.getInstance(HttpManager.getApplicationContext()).getAesHelper(i).decrypt(byteArray), str6);
            }
            if (firstHeader.getValue().toUpperCase().contains("RSA")) {
                str5 = RSAHelper.decrypt(byteArray);
            }
            if (firstHeader.getValue().toUpperCase().contains("IDENTITY")) {
                str5 = new String(byteArray, str6);
            }
        }
        Logger logger4 = this.logger;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str4);
        sb3.append(statusCode);
        sb3.append(", content :");
        sb3.append(str5);
        logger4.mo35700i(sb3.toString());
        return new HttpResponseResult(statusCode, str5);
    }

    public HttpConnectClient(String str, Map<String, String> map) {
        this.proxy = null;
        this.client = null;
        this.addr = null;
        this.httpParamsMap = null;
        this.logger = null;
        this.timeout = C7120a.MAX_USERDATA_VALUE_LENGTH;
        this.logger = Util.getLogger();
        this.proxy = Util.getHttpProxy();
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, this.timeout);
        HttpConnectionParams.setSoTimeout(basicHttpParams, this.timeout);
        this.client = new DefaultHttpClient(basicHttpParams);
        Logger logger2 = this.logger;
        StringBuilder sb = new StringBuilder();
        sb.append("proxy==");
        HttpHost httpHost = this.proxy;
        sb.append(httpHost == null ? "null" : httpHost.getHostName());
        logger2.mo35700i(sb.toString());
        if (this.proxy != null) {
            this.client.getParams().setParameter("http.route.default-proxy", this.proxy);
        }
        HttpHost httpHost2 = this.proxy;
        if (httpHost2 != null && httpHost2.getHostName().equals("10.0.0.200")) {
            this.client.getCredentialsProvider().setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("ctwap@mycdma.cn", "vnet.mobi"));
        }
        java.util.logging.Logger.getLogger("org.apache.http.wire").setLevel(Level.FINEST);
        java.util.logging.Logger.getLogger("org.apache.http.headers").setLevel(Level.FINEST);
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
        System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");
        String str2 = "debug";
        System.setProperty("org.apache.commons.logging.simplelog.log.httpclient.wire", str2);
        System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http", str2);
        System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http.headers", str2);
        this.client.setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy() {
            public long getKeepAliveDuration(HttpResponse httpResponse, HttpContext httpContext) {
                long keepAliveDuration = HttpConnectClient.super.getKeepAliveDuration(httpResponse, httpContext);
                if (keepAliveDuration == -1) {
                    return 20000;
                }
                return keepAliveDuration;
            }
        });
        this.addr = str;
        this.httpParamsMap = map;
    }

    public void shutdown() {
        DefaultHttpClient defaultHttpClient = this.client;
        if (defaultHttpClient != null) {
            defaultHttpClient.getConnectionManager().shutdown();
            this.client = null;
            this.addr = null;
            this.httpParamsMap = null;
            this.proxy = null;
        }
    }

    private String getHttpParams() {
        StringBuilder sb = new StringBuilder();
        Map<String, String> map = this.httpParamsMap;
        if (!(map == null || map.size() == 0)) {
            int i = 0;
            for (Entry entry : this.httpParamsMap.entrySet()) {
                String str = i == 0 ? "?" : "&";
                i++;
                sb.append(str);
                sb.append((String) entry.getKey());
                sb.append("=");
                sb.append((String) entry.getValue());
            }
        }
        return sb.toString();
    }

    public String getHttpFullUrl(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.addr);
        sb.append(str);
        sb.append(getHttpParams());
        return sb.toString();
    }

    public HttpHost getProxy() {
        return this.proxy;
    }

    public void setProxy(HttpHost httpHost) {
        this.proxy = httpHost;
    }

    public DefaultHttpClient getClient() {
        return this.client;
    }

    public void setClient(DefaultHttpClient defaultHttpClient) {
        this.client = defaultHttpClient;
    }

    public Map<String, String> getHttpParamsMap() {
        return this.httpParamsMap;
    }

    public void setHttpParamsMap(Map<String, String> map) {
        this.httpParamsMap = map;
    }
}
