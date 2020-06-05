package com.bytedance.sdk.p145a.p147b;

import com.bytedance.sdk.p145a.p147b.C1935u.C1936a;
import com.bytedance.sdk.p145a.p147b.p148a.C1876c;
import com.bytedance.sdk.p145a.p147b.p148a.p151c.HttpMethod;
import java.net.URL;

/* compiled from: Request */
/* renamed from: com.bytedance.sdk.a.b.ab */
public final class C1918ab {
    /* renamed from: a */
    final HttpUrl f5708a;
    /* renamed from: b */
    final String f5709b;
    /* renamed from: c */
    final C1935u f5710c;
    /* renamed from: d */
    final RequestBody f5711d;
    /* renamed from: e */
    final Object f5712e;
    /* renamed from: f */
    private volatile CacheControl f5713f;

    /* compiled from: Request */
    /* renamed from: com.bytedance.sdk.a.b.ab$a */
    public static class C1919a {
        /* renamed from: a */
        HttpUrl f5714a;
        /* renamed from: b */
        String f5715b;
        /* renamed from: c */
        C1936a f5716c;
        /* renamed from: d */
        RequestBody f5717d;
        /* renamed from: e */
        Object f5718e;

        public C1919a() {
            this.f5715b = "GET";
            this.f5716c = new C1936a();
        }

        C1919a(C1918ab abVar) {
            this.f5714a = abVar.f5708a;
            this.f5715b = abVar.f5709b;
            this.f5717d = abVar.f5711d;
            this.f5718e = abVar.f5712e;
            this.f5716c = abVar.f5710c.mo14072b();
        }

        /* renamed from: a */
        public C1919a mo13922a(HttpUrl vVar) {
            if (vVar != null) {
                this.f5714a = vVar;
                return this;
            }
            throw new NullPointerException("url == null");
        }

        /* renamed from: a */
        public C1919a mo13926a(URL url) {
            if (url != null) {
                HttpUrl a = HttpUrl.m7537a(url);
                if (a != null) {
                    return mo13922a(a);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("unexpected url: ");
                sb.append(url);
                throw new IllegalArgumentException(sb.toString());
            }
            throw new NullPointerException("url == null");
        }

        /* renamed from: a */
        public C1919a mo13925a(String str, String str2) {
            this.f5716c.mo14083c(str, str2);
            return this;
        }

        /* renamed from: b */
        public C1919a mo13929b(String str, String str2) {
            this.f5716c.mo14079a(str, str2);
            return this;
        }

        /* renamed from: a */
        public C1919a mo13923a(String str) {
            this.f5716c.mo14081b(str);
            return this;
        }

        /* renamed from: a */
        public C1919a mo13921a(C1935u uVar) {
            this.f5716c = uVar.mo14072b();
            return this;
        }

        /* renamed from: a */
        public C1919a mo13919a() {
            return mo13924a("GET", (RequestBody) null);
        }

        /* renamed from: b */
        public C1919a mo13927b() {
            return mo13924a("HEAD", (RequestBody) null);
        }

        /* renamed from: a */
        public C1919a mo13920a(RequestBody acVar) {
            return mo13924a("POST", acVar);
        }

        /* renamed from: b */
        public C1919a mo13928b(RequestBody acVar) {
            return mo13924a("DELETE", acVar);
        }

        /* renamed from: c */
        public C1919a mo13930c() {
            return mo13928b(C1876c.f5401d);
        }

        /* renamed from: c */
        public C1919a mo13931c(RequestBody acVar) {
            return mo13924a("PUT", acVar);
        }

        /* renamed from: d */
        public C1919a mo13932d(RequestBody acVar) {
            return mo13924a("PATCH", acVar);
        }

        /* renamed from: a */
        public C1919a mo13924a(String str, RequestBody acVar) {
            if (str == null) {
                throw new NullPointerException("method == null");
            } else if (str.length() != 0) {
                String str2 = "method ";
                if (acVar != null && !HttpMethod.m7001c(str)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(str);
                    sb.append(" must not have a request body.");
                    throw new IllegalArgumentException(sb.toString());
                } else if (acVar != null || !HttpMethod.m7000b(str)) {
                    this.f5715b = str;
                    this.f5717d = acVar;
                    return this;
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str2);
                    sb2.append(str);
                    sb2.append(" must have a request body.");
                    throw new IllegalArgumentException(sb2.toString());
                }
            } else {
                throw new IllegalArgumentException("method.length() == 0");
            }
        }

        /* renamed from: d */
        public C1918ab mo13933d() {
            if (this.f5714a != null) {
                return new C1918ab(this);
            }
            throw new IllegalStateException("url == null");
        }
    }

    C1918ab(C1919a aVar) {
        this.f5708a = aVar.f5714a;
        this.f5709b = aVar.f5715b;
        this.f5710c = aVar.f5716c.mo14080a();
        this.f5711d = aVar.f5717d;
        this.f5712e = aVar.f5718e != null ? aVar.f5718e : this;
    }

    /* renamed from: a */
    public HttpUrl mo13910a() {
        return this.f5708a;
    }

    /* renamed from: b */
    public String mo13912b() {
        return this.f5709b;
    }

    /* renamed from: c */
    public C1935u mo13913c() {
        return this.f5710c;
    }

    /* renamed from: a */
    public String mo13911a(String str) {
        return this.f5710c.mo14071a(str);
    }

    /* renamed from: d */
    public RequestBody mo13914d() {
        return this.f5711d;
    }

    /* renamed from: e */
    public C1919a mo13915e() {
        return new C1919a(this);
    }

    /* renamed from: f */
    public CacheControl mo13916f() {
        CacheControl gVar = this.f5713f;
        if (gVar != null) {
            return gVar;
        }
        CacheControl a = CacheControl.m7420a(this.f5710c);
        this.f5713f = a;
        return a;
    }

    /* renamed from: g */
    public boolean mo13917g() {
        return this.f5708a.mo14087c();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.f5709b);
        sb.append(", url=");
        sb.append(this.f5708a);
        sb.append(", tag=");
        Object obj = this.f5712e;
        if (obj == this) {
            obj = null;
        }
        sb.append(obj);
        sb.append('}');
        return sb.toString();
    }
}
