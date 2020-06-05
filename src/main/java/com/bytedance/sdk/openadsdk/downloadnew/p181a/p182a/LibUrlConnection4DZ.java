package com.bytedance.sdk.openadsdk.downloadnew.p181a.p182a;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.p161d.HTTPSTrustManager;
import com.p530ss.android.socialbase.downloader.p562g.HttpHeader;
import com.p530ss.android.socialbase.downloader.p564i.IDownloadHttpConnection;
import com.p530ss.android.socialbase.downloader.p564i.IDownloadHttpService;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* renamed from: com.bytedance.sdk.openadsdk.downloadnew.a.a.g */
public class LibUrlConnection4DZ implements IDownloadHttpService {
    /* renamed from: a */
    protected final WeakReference<Context> f8564a;

    public LibUrlConnection4DZ(Context context) {
        this.f8564a = new WeakReference<>(context);
    }

    /* renamed from: a */
    public IDownloadHttpConnection mo16498a(int i, String str, List<HttpHeader> list) throws IOException {
        final HttpURLConnection a = m11113a(str, list);
        C24071 r7 = null;
        if (a == null) {
            return null;
        }
        final int responseCode = a.getResponseCode();
        if (responseCode >= 200 && responseCode < 300) {
            final Map a2 = m11114a(a);
            InputStream inputStream = a.getInputStream();
            String contentEncoding = a.getContentEncoding();
            final InputStream gZIPInputStream = (TextUtils.isEmpty(contentEncoding) || !contentEncoding.contains("gzip")) ? inputStream : new GZIPInputStream(inputStream);
            r7 = new IDownloadHttpConnection() {
                /* renamed from: c */
                public void mo16502c() {
                }

                /* renamed from: a */
                public InputStream mo16499a() {
                    return gZIPInputStream;
                }

                /* renamed from: a */
                public String mo16500a(String str) {
                    return (String) a2.get(str);
                }

                /* renamed from: b */
                public int mo16501b() {
                    return responseCode;
                }

                /* renamed from: d */
                public void mo16503d() {
                    try {
                        a.disconnect();
                    } catch (Exception unused) {
                    }
                }
            };
        }
        return r7;
    }

    /* renamed from: a */
    private HttpURLConnection m11113a(String str, List<HttpHeader> list) {
        HttpURLConnection httpURLConnection;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (!TextUtils.isEmpty(str) && str.startsWith("https")) {
                HTTPSTrustManager.m7937a();
            }
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setRequestProperty("accept", "*/*");
                httpURLConnection.setRequestProperty("connection", "Keep-Alive");
                if (list != null && !list.isEmpty()) {
                    for (HttpHeader eVar : list) {
                        httpURLConnection.setRequestProperty(eVar.mo32429a(), eVar.mo32430b());
                    }
                }
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode >= 200 && responseCode < 300) {
                    return httpURLConnection;
                }
                if (responseCode >= 300 && responseCode < 400) {
                    return m11113a(httpURLConnection.getHeaderField("Location"), list);
                }
                return httpURLConnection;
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            httpURLConnection = null;
        }
    }

    /* renamed from: a */
    private Map<String, String> m11114a(HttpURLConnection httpURLConnection) {
        HashMap hashMap = new HashMap();
        int size = httpURLConnection.getHeaderFields().size();
        for (int i = 0; i < size; i++) {
            hashMap.put(httpURLConnection.getHeaderFieldKey(i), httpURLConnection.getHeaderField(i));
        }
        return hashMap;
    }
}
