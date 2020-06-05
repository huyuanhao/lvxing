package com.pgl.sys.p362a.p364b;

import com.kwad.sdk.core.imageloader.core.download.BaseImageDownloader;
import com.tencent.qqpim.discovery.internal.protocol.C7516p;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

/* renamed from: com.pgl.sys.a.b.c */
public class C4794c {
    /* renamed from: a */
    private static boolean f15443a = false;
    /* renamed from: b */
    private static HostnameVerifier f15444b = new C4792a();

    /* renamed from: a */
    public static String m19629a(String str, Map map, byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (Entry entry : map.entrySet()) {
            if (entry.getValue() != null) {
                try {
                    sb.append((String) entry.getKey());
                    sb.append("=");
                    sb.append(URLEncoder.encode((String) entry.getValue(), "utf-8"));
                    sb.append("&");
                } catch (Throwable unused) {
                }
            }
        }
        if (!map.isEmpty()) {
            sb.deleteCharAt(sb.length() - 1);
        }
        URL url = null;
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("?");
            sb2.append(sb.toString());
            url = new URL(sb2.toString());
        } catch (Throwable unused2) {
        }
        return m19630a(url, bArr, "application/octet-stream");
    }

    /* renamed from: a */
    private static String m19630a(URL url, byte[] bArr, String str) {
        HttpURLConnection httpURLConnection;
        TrustManager[] trustManagerArr = {new C4793b()};
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init(null, trustManagerArr, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(instance.getSocketFactory());
            if ("https".equals(url.getProtocol().toLowerCase())) {
                httpURLConnection = (HttpURLConnection) (f15443a ? url.openConnection(Proxy.NO_PROXY) : url.openConnection());
                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(f15444b);
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            httpURLConnection.setRequestProperty("Content-Type", str);
            httpURLConnection.setConnectTimeout(C7516p.f25219Cf);
            httpURLConnection.setReadTimeout(BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(bArr);
            outputStream.flush();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 200) {
                return String.format("{\"code\":%d}", new Object[]{Integer.valueOf(responseCode)});
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    inputStream.close();
                    outputStream.close();
                    return sb.toString();
                }
            }
        } catch (Throwable unused) {
            return "";
        }
    }
}
