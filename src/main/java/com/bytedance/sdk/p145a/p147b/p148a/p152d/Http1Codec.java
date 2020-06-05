package com.bytedance.sdk.p145a.p147b.p148a.p152d;

import android.support.p000v4.media.session.PlaybackStateCompat;
import com.bytedance.sdk.p145a.p146a.Buffer;
import com.bytedance.sdk.p145a.p146a.BufferedSink;
import com.bytedance.sdk.p145a.p146a.BufferedSource;
import com.bytedance.sdk.p145a.p146a.ForwardingTimeout;
import com.bytedance.sdk.p145a.p146a.Okio;
import com.bytedance.sdk.p145a.p146a.Sink;
import com.bytedance.sdk.p145a.p146a.Source;
import com.bytedance.sdk.p145a.p146a.Timeout;
import com.bytedance.sdk.p145a.p147b.C1918ab;
import com.bytedance.sdk.p145a.p147b.C1935u;
import com.bytedance.sdk.p145a.p147b.C1935u.C1936a;
import com.bytedance.sdk.p145a.p147b.HttpUrl;
import com.bytedance.sdk.p145a.p147b.OkHttpClient;
import com.bytedance.sdk.p145a.p147b.Response;
import com.bytedance.sdk.p145a.p147b.Response.C1921a;
import com.bytedance.sdk.p145a.p147b.ResponseBody;
import com.bytedance.sdk.p145a.p147b.p148a.C1876c;
import com.bytedance.sdk.p145a.p147b.p148a.Internal;
import com.bytedance.sdk.p145a.p147b.p148a.p150b.StreamAllocation;
import com.bytedance.sdk.p145a.p147b.p148a.p151c.HttpCodec;
import com.bytedance.sdk.p145a.p147b.p148a.p151c.HttpHeaders;
import com.bytedance.sdk.p145a.p147b.p148a.p151c.RealResponseBody;
import com.bytedance.sdk.p145a.p147b.p148a.p151c.RequestLine;
import com.bytedance.sdk.p145a.p147b.p148a.p151c.StatusLine;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

/* renamed from: com.bytedance.sdk.a.b.a.d.a */
public final class Http1Codec implements HttpCodec {
    /* renamed from: a */
    final OkHttpClient f5448a;
    /* renamed from: b */
    final StreamAllocation f5449b;
    /* renamed from: c */
    final BufferedSource f5450c;
    /* renamed from: d */
    final BufferedSink f5451d;
    /* renamed from: e */
    int f5452e = 0;
    /* renamed from: f */
    private long f5453f = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;

    /* compiled from: Http1Codec */
    /* renamed from: com.bytedance.sdk.a.b.a.d.a$a */
    private abstract class C1882a implements Source {
        /* renamed from: a */
        protected final ForwardingTimeout f5454a;
        /* renamed from: b */
        protected boolean f5455b;
        /* renamed from: c */
        protected long f5456c;

        private C1882a() {
            this.f5454a = new ForwardingTimeout(Http1Codec.this.f5450c.mo13512a());
            this.f5456c = 0;
        }

        /* renamed from: a */
        public Timeout mo13512a() {
            return this.f5454a;
        }

        /* renamed from: a */
        public long mo13511a(Buffer cVar, long j) throws IOException {
            try {
                long a = Http1Codec.this.f5450c.mo13511a(cVar, j);
                if (a > 0) {
                    this.f5456c += a;
                }
                return a;
            } catch (IOException e) {
                mo13757a(false, e);
                throw e;
            }
        }

        /* access modifiers changed from: protected|final */
        /* renamed from: a */
        public final void mo13757a(boolean z, IOException iOException) throws IOException {
            if (Http1Codec.this.f5452e != 6) {
                if (Http1Codec.this.f5452e == 5) {
                    Http1Codec.this.mo13751a(this.f5454a);
                    Http1Codec aVar = Http1Codec.this;
                    aVar.f5452e = 6;
                    if (aVar.f5449b != null) {
                        Http1Codec.this.f5449b.mo13716a(!z, (HttpCodec) Http1Codec.this, this.f5456c, iOException);
                    }
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("state: ");
                sb.append(Http1Codec.this.f5452e);
                throw new IllegalStateException(sb.toString());
            }
        }
    }

    /* compiled from: Http1Codec */
    /* renamed from: com.bytedance.sdk.a.b.a.d.a$b */
    private final class C1883b implements Sink {
        /* renamed from: b */
        private final ForwardingTimeout f5459b = new ForwardingTimeout(Http1Codec.this.f5451d.mo13506a());
        /* renamed from: c */
        private boolean f5460c;

        C1883b() {
        }

        /* renamed from: a */
        public Timeout mo13506a() {
            return this.f5459b;
        }

        /* renamed from: a_ */
        public void mo13507a_(Buffer cVar, long j) throws IOException {
            if (this.f5460c) {
                throw new IllegalStateException("closed");
            } else if (j != 0) {
                Http1Codec.this.f5451d.mo13564k(j);
                String str = "\r\n";
                Http1Codec.this.f5451d.mo13534b(str);
                Http1Codec.this.f5451d.mo13507a_(cVar, j);
                Http1Codec.this.f5451d.mo13534b(str);
            }
        }

        public synchronized void flush() throws IOException {
            if (!this.f5460c) {
                Http1Codec.this.f5451d.flush();
            }
        }

        public synchronized void close() throws IOException {
            if (!this.f5460c) {
                this.f5460c = true;
                Http1Codec.this.f5451d.mo13534b("0\r\n\r\n");
                Http1Codec.this.mo13751a(this.f5459b);
                Http1Codec.this.f5452e = 3;
            }
        }
    }

    /* compiled from: Http1Codec */
    /* renamed from: com.bytedance.sdk.a.b.a.d.a$c */
    private class C1884c extends C1882a {
        /* renamed from: f */
        private final HttpUrl f5462f;
        /* renamed from: g */
        private long f5463g = -1;
        /* renamed from: h */
        private boolean f5464h = true;

        C1884c(HttpUrl vVar) {
            super();
            this.f5462f = vVar;
        }

        /* renamed from: a */
        public long mo13511a(Buffer cVar, long j) throws IOException {
            if (j < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("byteCount < 0: ");
                sb.append(j);
                throw new IllegalArgumentException(sb.toString());
            } else if (this.f5455b) {
                throw new IllegalStateException("closed");
            } else if (!this.f5464h) {
                return -1;
            } else {
                long j2 = this.f5463g;
                if (j2 == 0 || j2 == -1) {
                    m7051b();
                    if (!this.f5464h) {
                        return -1;
                    }
                }
                long a = super.mo13511a(cVar, Math.min(j, this.f5463g));
                if (a != -1) {
                    this.f5463g -= a;
                    return a;
                }
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                mo13757a(false, (IOException) protocolException);
                throw protocolException;
            }
        }

        /* renamed from: b */
        private void m7051b() throws IOException {
            if (this.f5463g != -1) {
                Http1Codec.this.f5450c.mo13571p();
            }
            try {
                this.f5463g = Http1Codec.this.f5450c.mo13568m();
                String trim = Http1Codec.this.f5450c.mo13571p().trim();
                if (this.f5463g < 0 || (!trim.isEmpty() && !trim.startsWith(";"))) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("expected chunk size and optional extensions but was \"");
                    sb.append(this.f5463g);
                    sb.append(trim);
                    sb.append("\"");
                    throw new ProtocolException(sb.toString());
                } else if (this.f5463g == 0) {
                    this.f5464h = false;
                    HttpHeaders.m6996a(Http1Codec.this.f5448a.mo14124f(), this.f5462f, Http1Codec.this.mo13754c());
                    mo13757a(true, (IOException) null);
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        public void close() throws IOException {
            if (!this.f5455b) {
                if (this.f5464h && !C1876c.m6963a((Source) this, 100, TimeUnit.MILLISECONDS)) {
                    mo13757a(false, (IOException) null);
                }
                this.f5455b = true;
            }
        }
    }

    /* compiled from: Http1Codec */
    /* renamed from: com.bytedance.sdk.a.b.a.d.a$d */
    private final class C1885d implements Sink {
        /* renamed from: b */
        private final ForwardingTimeout f5466b = new ForwardingTimeout(Http1Codec.this.f5451d.mo13506a());
        /* renamed from: c */
        private boolean f5467c;
        /* renamed from: d */
        private long f5468d;

        C1885d(long j) {
            this.f5468d = j;
        }

        /* renamed from: a */
        public Timeout mo13506a() {
            return this.f5466b;
        }

        /* renamed from: a_ */
        public void mo13507a_(Buffer cVar, long j) throws IOException {
            if (!this.f5467c) {
                C1876c.m6960a(cVar.mo13530b(), 0, j);
                if (j <= this.f5468d) {
                    Http1Codec.this.f5451d.mo13507a_(cVar, j);
                    this.f5468d -= j;
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("expected ");
                sb.append(this.f5468d);
                sb.append(" bytes but received ");
                sb.append(j);
                throw new ProtocolException(sb.toString());
            }
            throw new IllegalStateException("closed");
        }

        public void flush() throws IOException {
            if (!this.f5467c) {
                Http1Codec.this.f5451d.flush();
            }
        }

        public void close() throws IOException {
            if (!this.f5467c) {
                this.f5467c = true;
                if (this.f5468d <= 0) {
                    Http1Codec.this.mo13751a(this.f5466b);
                    Http1Codec.this.f5452e = 3;
                    return;
                }
                throw new ProtocolException("unexpected end of stream");
            }
        }
    }

    /* compiled from: Http1Codec */
    /* renamed from: com.bytedance.sdk.a.b.a.d.a$e */
    private class C1886e extends C1882a {
        /* renamed from: f */
        private long f5470f;

        C1886e(long j) throws IOException {
            super();
            this.f5470f = j;
            if (this.f5470f == 0) {
                mo13757a(true, (IOException) null);
            }
        }

        /* renamed from: a */
        public long mo13511a(Buffer cVar, long j) throws IOException {
            if (j < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("byteCount < 0: ");
                sb.append(j);
                throw new IllegalArgumentException(sb.toString());
            } else if (!this.f5455b) {
                long j2 = this.f5470f;
                if (j2 == 0) {
                    return -1;
                }
                long a = super.mo13511a(cVar, Math.min(j2, j));
                if (a != -1) {
                    this.f5470f -= a;
                    if (this.f5470f == 0) {
                        mo13757a(true, (IOException) null);
                    }
                    return a;
                }
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                mo13757a(false, (IOException) protocolException);
                throw protocolException;
            } else {
                throw new IllegalStateException("closed");
            }
        }

        public void close() throws IOException {
            if (!this.f5455b) {
                if (this.f5470f != 0 && !C1876c.m6963a((Source) this, 100, TimeUnit.MILLISECONDS)) {
                    mo13757a(false, (IOException) null);
                }
                this.f5455b = true;
            }
        }
    }

    /* compiled from: Http1Codec */
    /* renamed from: com.bytedance.sdk.a.b.a.d.a$f */
    private class C1887f extends C1882a {
        /* renamed from: f */
        private boolean f5472f;

        C1887f() {
            super();
        }

        /* renamed from: a */
        public long mo13511a(Buffer cVar, long j) throws IOException {
            if (j < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("byteCount < 0: ");
                sb.append(j);
                throw new IllegalArgumentException(sb.toString());
            } else if (this.f5455b) {
                throw new IllegalStateException("closed");
            } else if (this.f5472f) {
                return -1;
            } else {
                long a = super.mo13511a(cVar, j);
                if (a != -1) {
                    return a;
                }
                this.f5472f = true;
                mo13757a(true, (IOException) null);
                return -1;
            }
        }

        public void close() throws IOException {
            if (!this.f5455b) {
                if (!this.f5472f) {
                    mo13757a(false, (IOException) null);
                }
                this.f5455b = true;
            }
        }
    }

    public Http1Codec(OkHttpClient zVar, StreamAllocation gVar, BufferedSource eVar, BufferedSink dVar) {
        this.f5448a = zVar;
        this.f5449b = gVar;
        this.f5450c = eVar;
        this.f5451d = dVar;
    }

    /* renamed from: a */
    public Sink mo13725a(C1918ab abVar, long j) {
        if ("chunked".equalsIgnoreCase(abVar.mo13911a("Transfer-Encoding"))) {
            return mo13755d();
        }
        if (j != -1) {
            return mo13749a(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    /* renamed from: a */
    public void mo13729a(C1918ab abVar) throws IOException {
        mo13752a(abVar.mo13913c(), RequestLine.m7017a(abVar, this.f5449b.mo13717b().mo13689a().mo13970b().type()));
    }

    /* renamed from: a */
    public ResponseBody mo13727a(Response bVar) throws IOException {
        this.f5449b.f5385c.mo14062f(this.f5449b.f5384b);
        String a = bVar.mo13938a("Content-Type");
        if (!HttpHeaders.m6998b(bVar)) {
            return new RealResponseBody(a, 0, Okio.m6747a(mo13753b(0)));
        }
        if ("chunked".equalsIgnoreCase(bVar.mo13938a("Transfer-Encoding"))) {
            return new RealResponseBody(a, -1, Okio.m6747a(mo13750a(bVar.mo13937a().mo13910a())));
        }
        long a2 = HttpHeaders.m6993a(bVar);
        if (a2 != -1) {
            return new RealResponseBody(a, a2, Okio.m6747a(mo13753b(a2)));
        }
        return new RealResponseBody(a, -1, Okio.m6747a(mo13756e()));
    }

    /* renamed from: a */
    public void mo13728a() throws IOException {
        this.f5451d.flush();
    }

    /* renamed from: b */
    public void mo13730b() throws IOException {
        this.f5451d.flush();
    }

    /* renamed from: a */
    public void mo13752a(C1935u uVar, String str) throws IOException {
        if (this.f5452e == 0) {
            String str2 = "\r\n";
            this.f5451d.mo13534b(str).mo13534b(str2);
            int a = uVar.mo14069a();
            for (int i = 0; i < a; i++) {
                this.f5451d.mo13534b(uVar.mo14070a(i)).mo13534b(": ").mo13534b(uVar.mo14073b(i)).mo13534b(str2);
            }
            this.f5451d.mo13534b(str2);
            this.f5452e = 1;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("state: ");
        sb.append(this.f5452e);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: a */
    public C1921a mo13726a(boolean z) throws IOException {
        int i = this.f5452e;
        if (i == 1 || i == 3) {
            try {
                StatusLine a = StatusLine.m7029a(m7031f());
                C1921a a2 = new C1921a().mo13960a(a.f5445a).mo13953a(a.f5446b).mo13961a(a.f5447c).mo13959a(mo13754c());
                if (z && a.f5446b == 100) {
                    return null;
                }
                this.f5452e = 4;
                return a2;
            } catch (EOFException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("unexpected end of stream on ");
                sb.append(this.f5449b);
                IOException iOException = new IOException(sb.toString());
                iOException.initCause(e);
                throw iOException;
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("state: ");
            sb2.append(this.f5452e);
            throw new IllegalStateException(sb2.toString());
        }
    }

    /* renamed from: f */
    private String m7031f() throws IOException {
        String e = this.f5450c.mo13545e(this.f5453f);
        this.f5453f -= (long) e.length();
        return e;
    }

    /* renamed from: c */
    public C1935u mo13754c() throws IOException {
        C1936a aVar = new C1936a();
        while (true) {
            String f = m7031f();
            if (f.length() == 0) {
                return aVar.mo14080a();
            }
            Internal.f5302a.mo13660a(aVar, f);
        }
    }

    /* renamed from: d */
    public Sink mo13755d() {
        if (this.f5452e == 1) {
            this.f5452e = 2;
            return new C1883b();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("state: ");
        sb.append(this.f5452e);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: a */
    public Sink mo13749a(long j) {
        if (this.f5452e == 1) {
            this.f5452e = 2;
            return new C1885d(j);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("state: ");
        sb.append(this.f5452e);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: b */
    public Source mo13753b(long j) throws IOException {
        if (this.f5452e == 4) {
            this.f5452e = 5;
            return new C1886e(j);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("state: ");
        sb.append(this.f5452e);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: a */
    public Source mo13750a(HttpUrl vVar) throws IOException {
        if (this.f5452e == 4) {
            this.f5452e = 5;
            return new C1884c(vVar);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("state: ");
        sb.append(this.f5452e);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: e */
    public Source mo13756e() throws IOException {
        if (this.f5452e == 4) {
            StreamAllocation gVar = this.f5449b;
            if (gVar != null) {
                this.f5452e = 5;
                gVar.mo13719d();
                return new C1887f();
            }
            throw new IllegalStateException("streamAllocation == null");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("state: ");
        sb.append(this.f5452e);
        throw new IllegalStateException(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo13751a(ForwardingTimeout iVar) {
        Timeout a = iVar.mo13608a();
        iVar.mo13607a(Timeout.f5286c);
        a.mo13613f();
        a.mo13612e();
    }
}
