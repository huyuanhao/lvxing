package com.bumptech.glide.load.p135a;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.p135a.DataFetcher.C1623a;
import com.bumptech.glide.util.ContentLengthInputStream;
import com.bumptech.glide.util.LogTime;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.bumptech.glide.load.a.j */
public class HttpUrlFetcher implements DataFetcher<InputStream> {
    /* renamed from: a */
    static final C1628b f4413a = new C1627a();
    /* renamed from: b */
    private final GlideUrl f4414b;
    /* renamed from: c */
    private final int f4415c;
    /* renamed from: d */
    private final C1628b f4416d;
    /* renamed from: e */
    private HttpURLConnection f4417e;
    /* renamed from: f */
    private InputStream f4418f;
    /* renamed from: g */
    private volatile boolean f4419g;

    /* compiled from: HttpUrlFetcher */
    /* renamed from: com.bumptech.glide.load.a.j$a */
    private static class C1627a implements C1628b {
        C1627a() {
        }

        /* renamed from: a */
        public HttpURLConnection mo12658a(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    /* compiled from: HttpUrlFetcher */
    /* renamed from: com.bumptech.glide.load.a.j$b */
    interface C1628b {
        /* renamed from: a */
        HttpURLConnection mo12658a(URL url) throws IOException;
    }

    public HttpUrlFetcher(GlideUrl gVar, int i) {
        this(gVar, i, f4413a);
    }

    HttpUrlFetcher(GlideUrl gVar, int i, C1628b bVar) {
        this.f4414b = gVar;
        this.f4415c = i;
        this.f4416d = bVar;
    }

    /* renamed from: a */
    public void mo12626a(Priority priority, C1623a<? super InputStream> aVar) {
        StringBuilder sb;
        String str = "Finished http url fetcher fetch in ";
        String str2 = "HttpUrlFetcher";
        long a = LogTime.m6125a();
        try {
            aVar.mo12641a(m5350a(this.f4414b.mo12957a(), 0, null, this.f4414b.mo12959c()));
            if (Log.isLoggable(str2, 2)) {
                sb = new StringBuilder();
                sb.append(str);
                sb.append(LogTime.m6124a(a));
                Log.v(str2, sb.toString());
            }
        } catch (IOException e) {
            if (Log.isLoggable(str2, 3)) {
                Log.d(str2, "Failed to load data for url", e);
            }
            aVar.mo12640a((Exception) e);
            if (Log.isLoggable(str2, 2)) {
                sb = new StringBuilder();
            }
        } catch (Throwable th) {
            if (Log.isLoggable(str2, 2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(LogTime.m6124a(a));
                Log.v(str2, sb2.toString());
            }
            throw th;
        }
    }

    /* renamed from: a */
    private InputStream m5350a(URL url, int i, URL url2, Map<String, String> map) throws IOException {
        if (i < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new HttpException("In re-direct loop");
                    }
                } catch (URISyntaxException unused) {
                }
            }
            this.f4417e = this.f4416d.mo12658a(url);
            for (Entry entry : map.entrySet()) {
                this.f4417e.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            this.f4417e.setConnectTimeout(this.f4415c);
            this.f4417e.setReadTimeout(this.f4415c);
            this.f4417e.setUseCaches(false);
            this.f4417e.setDoInput(true);
            this.f4417e.setInstanceFollowRedirects(false);
            this.f4417e.connect();
            this.f4418f = this.f4417e.getInputStream();
            if (this.f4419g) {
                return null;
            }
            int responseCode = this.f4417e.getResponseCode();
            if (m5351a(responseCode)) {
                return m5349a(this.f4417e);
            }
            if (m5352b(responseCode)) {
                String headerField = this.f4417e.getHeaderField("Location");
                if (!TextUtils.isEmpty(headerField)) {
                    URL url3 = new URL(url, headerField);
                    mo12627b();
                    return m5350a(url3, i + 1, url, map);
                }
                throw new HttpException("Received empty or null redirect url");
            } else if (responseCode == -1) {
                throw new HttpException(responseCode);
            } else {
                throw new HttpException(this.f4417e.getResponseMessage(), responseCode);
            }
        } else {
            throw new HttpException("Too many (> 5) redirects!");
        }
    }

    /* renamed from: a */
    private static boolean m5351a(int i) {
        return i / 100 == 2;
    }

    /* renamed from: b */
    private static boolean m5352b(int i) {
        return i / 100 == 3;
    }

    /* renamed from: a */
    private InputStream m5349a(HttpURLConnection httpURLConnection) throws IOException {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.f4418f = ContentLengthInputStream.m6117a(httpURLConnection.getInputStream(), (long) httpURLConnection.getContentLength());
        } else {
            String str = "HttpUrlFetcher";
            if (Log.isLoggable(str, 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Got non empty content encoding: ");
                sb.append(httpURLConnection.getContentEncoding());
                Log.d(str, sb.toString());
            }
            this.f4418f = httpURLConnection.getInputStream();
        }
        return this.f4418f;
    }

    /* renamed from: b */
    public void mo12627b() {
        InputStream inputStream = this.f4418f;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f4417e;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f4417e = null;
    }

    /* renamed from: c */
    public void mo12628c() {
        this.f4419g = true;
    }

    /* renamed from: a */
    public Class<InputStream> mo12619a() {
        return InputStream.class;
    }

    /* renamed from: d */
    public DataSource mo12629d() {
        return DataSource.REMOTE;
    }
}
