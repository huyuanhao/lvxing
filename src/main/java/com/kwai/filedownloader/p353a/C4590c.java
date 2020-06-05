package com.kwai.filedownloader.p353a;

import com.kwai.filedownloader.p358f.C4654c.C4656b;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/* renamed from: com.kwai.filedownloader.a.c */
public class C4590c implements C4589b {
    /* renamed from: a */
    protected URLConnection f14956a;

    /* renamed from: com.kwai.filedownloader.a.c$a */
    public static class C4591a {
        /* access modifiers changed from: private */
        /* renamed from: a */
        public Proxy f14957a;
        /* access modifiers changed from: private */
        /* renamed from: b */
        public Integer f14958b;
        /* access modifiers changed from: private */
        /* renamed from: c */
        public Integer f14959c;
    }

    /* renamed from: com.kwai.filedownloader.a.c$b */
    public static class C4592b implements C4656b {
        /* renamed from: a */
        private final C4591a f14960a;

        public C4592b() {
            this(null);
        }

        public C4592b(C4591a aVar) {
            this.f14960a = aVar;
        }

        /* renamed from: a */
        public C4589b mo22748a(String str) {
            return new C4590c(str, this.f14960a);
        }
    }

    public C4590c(String str, C4591a aVar) {
        this(new URL(str), aVar);
    }

    public C4590c(URL url, C4591a aVar) {
        URLConnection openConnection = (aVar == null || aVar.f14957a == null) ? url.openConnection() : url.openConnection(aVar.f14957a);
        this.f14956a = openConnection;
        if (aVar != null) {
            if (aVar.f14958b != null) {
                this.f14956a.setReadTimeout(aVar.f14958b.intValue());
            }
            if (aVar.f14959c != null) {
                this.f14956a.setConnectTimeout(aVar.f14959c.intValue());
            }
        }
    }

    /* renamed from: a */
    public InputStream mo22739a() {
        return this.f14956a.getInputStream();
    }

    /* renamed from: a */
    public String mo22740a(String str) {
        return this.f14956a.getHeaderField(str);
    }

    /* renamed from: a */
    public void mo22741a(String str, String str2) {
        this.f14956a.addRequestProperty(str, str2);
    }

    /* renamed from: a */
    public boolean mo22742a(String str, long j) {
        return false;
    }

    /* renamed from: b */
    public Map<String, List<String>> mo22743b() {
        return this.f14956a.getRequestProperties();
    }

    /* renamed from: c */
    public Map<String, List<String>> mo22744c() {
        return this.f14956a.getHeaderFields();
    }

    /* renamed from: d */
    public void mo22745d() {
        this.f14956a.connect();
    }

    /* renamed from: e */
    public int mo22746e() {
        URLConnection uRLConnection = this.f14956a;
        if (uRLConnection instanceof HttpURLConnection) {
            return ((HttpURLConnection) uRLConnection).getResponseCode();
        }
        return 0;
    }

    /* renamed from: f */
    public void mo22747f() {
    }
}
