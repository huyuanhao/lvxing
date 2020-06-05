package com.qiyukf.basesdk.p394b.p395a.p404c;

import android.text.TextUtils;
import com.qiyukf.basesdk.C5263a;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p394b.p395a.p397b.C5290a;
import com.qiyukf.basesdk.p394b.p395a.p404c.p405a.C5313a;
import com.tencent.bugly.BuglyStrategy.C7120a;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* renamed from: com.qiyukf.basesdk.b.a.c.b */
public final class C5314b {
    /* renamed from: a */
    private static HostnameVerifier f17217a = new HostnameVerifier() {
        public final boolean verify(String str, SSLSession sSLSession) {
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(C5263a.m21613f(), sSLSession);
        }
    };
    /* renamed from: b */
    private static HostnameVerifier f17218b = new HostnameVerifier() {
        public final boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    };

    /* renamed from: a */
    public static String m21842a(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } finally {
            m21846a((Closeable) inputStream);
            m21846a((Closeable) byteArrayOutputStream);
        }
    }

    /* renamed from: a */
    public static HttpURLConnection m21843a(String str, String str2) {
        HttpURLConnection a = m21845a(str, "POST", str2, C5290a.m21720c().mo27208a(), C5290a.m21720c().mo27209b());
        a.setRequestProperty("Host", C5263a.m21613f());
        if (a instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) a;
            httpsURLConnection.setSSLSocketFactory(C5313a.m21840a());
            httpsURLConnection.setHostnameVerifier(f17217a);
        }
        return a;
    }

    /* renamed from: a */
    public static HttpURLConnection m21844a(String str, String str2, String str3) {
        return m21845a(str, str2, str3, C7120a.MAX_USERDATA_VALUE_LENGTH, C7120a.MAX_USERDATA_VALUE_LENGTH);
    }

    /* renamed from: a */
    private static HttpURLConnection m21845a(String str, String str2, String str3, int i, int i2) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod(str2);
        StringBuilder sb = new StringBuilder("Qiyu-Android-");
        sb.append(str3);
        sb.append("-V1.0");
        httpURLConnection.setRequestProperty("User-Agent", sb.toString());
        httpURLConnection.setReadTimeout(i2);
        httpURLConnection.setConnectTimeout(i);
        httpURLConnection.setUseCaches(false);
        if ("POST".equals(httpURLConnection.getRequestMethod())) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
        }
        return httpURLConnection;
    }

    /* renamed from: a */
    public static void m21846a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static void m21847a(HttpURLConnection httpURLConnection, int i) {
        if ("POST".equals(httpURLConnection.getRequestMethod())) {
            if (i <= 0) {
                httpURLConnection.setChunkedStreamingMode(0);
                return;
            }
            httpURLConnection.setFixedLengthStreamingMode(i);
        }
    }

    /* renamed from: a */
    public static void m21848a(HttpURLConnection httpURLConnection, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            httpURLConnection.addRequestProperty(str, str2);
        }
    }

    /* renamed from: a */
    public static void m21849a(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            for (String str : map.keySet()) {
                m21848a(httpURLConnection, str, (String) map.get(str));
            }
        }
    }

    /* renamed from: a */
    public static void m21850a(HttpURLConnection httpURLConnection, byte[] bArr) {
        OutputStream outputStream = httpURLConnection.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        try {
            dataOutputStream.write(bArr);
            outputStream.flush();
        } finally {
            m21846a((Closeable) dataOutputStream);
        }
    }

    /* renamed from: b */
    public static String m21851b(String str, String str2, String str3) {
        HttpURLConnection a = m21844a(str, str2, str3);
        m21848a(a, "charset", "UTF-8");
        int responseCode = a.getResponseCode();
        if (responseCode == 200) {
            return m21842a(a.getInputStream());
        }
        StringBuilder sb = new StringBuilder("query url: ");
        sb.append(str);
        sb.append("failed: ");
        sb.append(responseCode);
        C5264a.m21617a("HttpUtil", sb.toString());
        throw new IOException("invalid response code");
    }

    /* renamed from: b */
    public static HttpURLConnection m21852b(String str, String str2) {
        HttpURLConnection a = m21845a(str, "GET", str2, C5290a.m21720c().mo27208a(), C5290a.m21720c().mo27209b());
        if (a instanceof HttpsURLConnection) {
            ((HttpsURLConnection) a).setSSLSocketFactory(C5313a.m21840a());
        }
        return a;
    }

    /* renamed from: c */
    public static HttpURLConnection m21853c(String str, String str2) {
        HttpURLConnection a = m21844a(str, "GET", str2);
        if (a instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) a;
            httpsURLConnection.setSSLSocketFactory(C5313a.m21840a());
            httpsURLConnection.setHostnameVerifier(f17218b);
        }
        return a;
    }
}
