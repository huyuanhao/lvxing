package com.bytedance.sdk.p145a.p147b;

import com.bytedance.sdk.p145a.p147b.C1935u.C1936a;
import java.io.Closeable;

/* renamed from: com.bytedance.sdk.a.b.b */
public final class Response implements Closeable {
    /* renamed from: a */
    final C1918ab f5730a;
    /* renamed from: b */
    final Protocol f5731b;
    /* renamed from: c */
    final int f5732c;
    /* renamed from: d */
    final String f5733d;
    /* renamed from: e */
    final Handshake f5734e;
    /* renamed from: f */
    final C1935u f5735f;
    /* renamed from: g */
    final ResponseBody f5736g;
    /* renamed from: h */
    final Response f5737h;
    /* renamed from: i */
    final Response f5738i;
    /* renamed from: j */
    final Response f5739j;
    /* renamed from: k */
    final long f5740k;
    /* renamed from: l */
    final long f5741l;
    /* renamed from: m */
    private volatile CacheControl f5742m;

    /* compiled from: Response */
    /* renamed from: com.bytedance.sdk.a.b.b$a */
    public static class C1921a {
        /* renamed from: a */
        C1918ab f5743a;
        /* renamed from: b */
        Protocol f5744b;
        /* renamed from: c */
        int f5745c;
        /* renamed from: d */
        String f5746d;
        /* renamed from: e */
        Handshake f5747e;
        /* renamed from: f */
        C1936a f5748f;
        /* renamed from: g */
        ResponseBody f5749g;
        /* renamed from: h */
        Response f5750h;
        /* renamed from: i */
        Response f5751i;
        /* renamed from: j */
        Response f5752j;
        /* renamed from: k */
        long f5753k;
        /* renamed from: l */
        long f5754l;

        public C1921a() {
            this.f5745c = -1;
            this.f5748f = new C1936a();
        }

        C1921a(Response bVar) {
            this.f5745c = -1;
            this.f5743a = bVar.f5730a;
            this.f5744b = bVar.f5731b;
            this.f5745c = bVar.f5732c;
            this.f5746d = bVar.f5733d;
            this.f5747e = bVar.f5734e;
            this.f5748f = bVar.f5735f.mo14072b();
            this.f5749g = bVar.f5736g;
            this.f5750h = bVar.f5737h;
            this.f5751i = bVar.f5738i;
            this.f5752j = bVar.f5739j;
            this.f5753k = bVar.f5740k;
            this.f5754l = bVar.f5741l;
        }

        /* renamed from: a */
        public C1921a mo13955a(C1918ab abVar) {
            this.f5743a = abVar;
            return this;
        }

        /* renamed from: a */
        public C1921a mo13960a(Protocol wVar) {
            this.f5744b = wVar;
            return this;
        }

        /* renamed from: a */
        public C1921a mo13953a(int i) {
            this.f5745c = i;
            return this;
        }

        /* renamed from: a */
        public C1921a mo13961a(String str) {
            this.f5746d = str;
            return this;
        }

        /* renamed from: a */
        public C1921a mo13958a(Handshake tVar) {
            this.f5747e = tVar;
            return this;
        }

        /* renamed from: a */
        public C1921a mo13962a(String str, String str2) {
            this.f5748f.mo14079a(str, str2);
            return this;
        }

        /* renamed from: a */
        public C1921a mo13959a(C1935u uVar) {
            this.f5748f = uVar.mo14072b();
            return this;
        }

        /* renamed from: a */
        public C1921a mo13957a(ResponseBody cVar) {
            this.f5749g = cVar;
            return this;
        }

        /* renamed from: a */
        public C1921a mo13956a(Response bVar) {
            if (bVar != null) {
                m7391a("networkResponse", bVar);
            }
            this.f5750h = bVar;
            return this;
        }

        /* renamed from: b */
        public C1921a mo13965b(Response bVar) {
            if (bVar != null) {
                m7391a("cacheResponse", bVar);
            }
            this.f5751i = bVar;
            return this;
        }

        /* renamed from: a */
        private void m7391a(String str, Response bVar) {
            if (bVar.f5736g != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(".body != null");
                throw new IllegalArgumentException(sb.toString());
            } else if (bVar.f5737h != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(".networkResponse != null");
                throw new IllegalArgumentException(sb2.toString());
            } else if (bVar.f5738i != null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(".cacheResponse != null");
                throw new IllegalArgumentException(sb3.toString());
            } else if (bVar.f5739j != null) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str);
                sb4.append(".priorResponse != null");
                throw new IllegalArgumentException(sb4.toString());
            }
        }

        /* renamed from: c */
        public C1921a mo13966c(Response bVar) {
            if (bVar != null) {
                m7392d(bVar);
            }
            this.f5752j = bVar;
            return this;
        }

        /* renamed from: d */
        private void m7392d(Response bVar) {
            if (bVar.f5736g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        /* renamed from: a */
        public C1921a mo13954a(long j) {
            this.f5753k = j;
            return this;
        }

        /* renamed from: b */
        public C1921a mo13964b(long j) {
            this.f5754l = j;
            return this;
        }

        /* renamed from: a */
        public Response mo13963a() {
            if (this.f5743a == null) {
                throw new IllegalStateException("request == null");
            } else if (this.f5744b == null) {
                throw new IllegalStateException("protocol == null");
            } else if (this.f5745c < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("code < 0: ");
                sb.append(this.f5745c);
                throw new IllegalStateException(sb.toString());
            } else if (this.f5746d != null) {
                return new Response(this);
            } else {
                throw new IllegalStateException("message == null");
            }
        }
    }

    Response(C1921a aVar) {
        this.f5730a = aVar.f5743a;
        this.f5731b = aVar.f5744b;
        this.f5732c = aVar.f5745c;
        this.f5733d = aVar.f5746d;
        this.f5734e = aVar.f5747e;
        this.f5735f = aVar.f5748f.mo14080a();
        this.f5736g = aVar.f5749g;
        this.f5737h = aVar.f5750h;
        this.f5738i = aVar.f5751i;
        this.f5739j = aVar.f5752j;
        this.f5740k = aVar.f5753k;
        this.f5741l = aVar.f5754l;
    }

    /* renamed from: a */
    public C1918ab mo13937a() {
        return this.f5730a;
    }

    /* renamed from: b */
    public Protocol mo13940b() {
        return this.f5731b;
    }

    /* renamed from: c */
    public int mo13941c() {
        return this.f5732c;
    }

    /* renamed from: d */
    public String mo13943d() {
        return this.f5733d;
    }

    /* renamed from: e */
    public Handshake mo13944e() {
        return this.f5734e;
    }

    /* renamed from: a */
    public String mo13938a(String str) {
        return mo13939a(str, null);
    }

    /* renamed from: a */
    public String mo13939a(String str, String str2) {
        String a = this.f5735f.mo14071a(str);
        return a != null ? a : str2;
    }

    /* renamed from: f */
    public C1935u mo13945f() {
        return this.f5735f;
    }

    /* renamed from: g */
    public ResponseBody mo13946g() {
        return this.f5736g;
    }

    /* renamed from: h */
    public C1921a mo13947h() {
        return new C1921a(this);
    }

    /* renamed from: i */
    public Response mo13948i() {
        return this.f5739j;
    }

    /* renamed from: j */
    public CacheControl mo13949j() {
        CacheControl gVar = this.f5742m;
        if (gVar != null) {
            return gVar;
        }
        CacheControl a = CacheControl.m7420a(this.f5735f);
        this.f5742m = a;
        return a;
    }

    /* renamed from: k */
    public long mo13950k() {
        return this.f5740k;
    }

    /* renamed from: l */
    public long mo13951l() {
        return this.f5741l;
    }

    public void close() {
        ResponseBody cVar = this.f5736g;
        if (cVar != null) {
            cVar.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Response{protocol=");
        sb.append(this.f5731b);
        sb.append(", code=");
        sb.append(this.f5732c);
        sb.append(", message=");
        sb.append(this.f5733d);
        sb.append(", url=");
        sb.append(this.f5730a.mo13910a());
        sb.append('}');
        return sb.toString();
    }
}
