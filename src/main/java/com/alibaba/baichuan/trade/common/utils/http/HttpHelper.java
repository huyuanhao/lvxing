package com.alibaba.baichuan.trade.common.utils.http;

import com.kwad.sdk.core.imageloader.core.download.BaseImageDownloader;
import com.tmsdk.module.coin.TMSDKContext;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Map.Entry;

public class HttpHelper {

    /* renamed from: com.alibaba.baichuan.trade.common.utils.http.HttpHelper$HttpHelperException */
    public static class HttpHelperException extends Exception {
        public int statusCode;

        HttpHelperException(Throwable th) {
            super(th);
        }
    }

    /* renamed from: a */
    private static int m2433a(int i) {
        return i;
    }

    /* renamed from: a */
    private static String m2434a() {
        return "UTF-8";
    }

    /* renamed from: a */
    private static String m2435a(InputStream inputStream, String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return new String(byteArrayOutputStream.toByteArray(), str);
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* renamed from: a */
    public static String m2436a(String str) {
        try {
            HttpURLConnection c = m2441c(str);
            m2442c(c.getResponseCode());
            return m2435a(c.getInputStream(), m2434a());
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    public static String m2437a(String str, Map<String, String> map) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            String str2 = "";
            sb.append(map == null ? str2 : "?");
            if (map != null) {
                str2 = m2438a(map);
            }
            sb.append(str2);
            return C1232a.m2443a(m2440b(sb.toString()), "UTF-8");
        } catch (Exception e) {
            if (e instanceof HttpHelperException) {
                throw e;
            }
            throw new HttpHelperException(e);
        }
    }

    /* renamed from: a */
    private static String m2438a(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (Entry entry : map.entrySet()) {
            if (z) {
                try {
                    sb.append("&");
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
            } else {
                z = true;
            }
            sb.append((String) entry.getKey());
            sb.append("=");
            sb.append(URLEncoder.encode((String) entry.getValue(), "UTF-8"));
        }
        return sb.toString();
    }

    /* renamed from: b */
    private static int m2439b(int i) {
        return i;
    }

    /* renamed from: b */
    private static InputStream m2440b(String str) {
        int i = TMSDKContext.S_ERR_UNKNOWN;
        try {
            HttpURLConnection c = m2441c(str);
            i = c.getResponseCode();
            m2442c(i);
            return c.getInputStream();
        } catch (Exception e) {
            HttpHelperException httpHelperException = new HttpHelperException(e);
            httpHelperException.statusCode = i;
            throw httpHelperException;
        }
    }

    /* renamed from: c */
    private static HttpURLConnection m2441c(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(m2433a((int) BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT));
            httpURLConnection.setReadTimeout(m2439b((int) BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT));
            return httpURLConnection;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: c */
    private static void m2442c(int i) {
        if (i != 200) {
            StringBuilder sb = new StringBuilder();
            sb.append("http request exception, response code: ");
            sb.append(i);
            throw new RuntimeException(sb.toString());
        }
    }
}
