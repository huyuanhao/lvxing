package okhttp3.internal.p699c;

import android.support.p000v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.C8362ab;
import okhttp3.C8362ab.C8363a;
import okhttp3.C8364ac;
import okhttp3.C8504s;
import okhttp3.C8504s.C8505a;
import okhttp3.C8506t;
import okhttp3.C8513x;
import okhttp3.C8518z;
import okhttp3.internal.C8388a;
import okhttp3.internal.C8417c;
import okhttp3.internal.connection.C8430c;
import okhttp3.internal.connection.C8434f;
import okhttp3.internal.p698b.C8406c;
import okhttp3.internal.p698b.C8409e;
import okhttp3.internal.p698b.C8412h;
import okhttp3.internal.p698b.C8413i;
import okhttp3.internal.p698b.C8415k;
import okio.C8525c;
import okio.C8528d;
import okio.C8529e;
import okio.C8532h;
import okio.C8535k;
import okio.C8546q;
import okio.C8547r;
import okio.C8548s;

/* compiled from: Http1Codec */
/* renamed from: okhttp3.internal.c.a */
public final class C8420a implements C8406c {
    /* renamed from: a */
    final C8513x f28549a;
    /* renamed from: b */
    final C8434f f28550b;
    /* renamed from: c */
    final C8529e f28551c;
    /* renamed from: d */
    final C8528d f28552d;
    /* renamed from: e */
    int f28553e = 0;
    /* renamed from: f */
    private long f28554f = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;

    /* compiled from: Http1Codec */
    /* renamed from: okhttp3.internal.c.a$a */
    private abstract class C8422a implements C8547r {
        /* renamed from: a */
        protected final C8532h f28555a;
        /* renamed from: b */
        protected boolean f28556b;
        /* renamed from: c */
        protected long f28557c;

        private C8422a() {
            this.f28555a = new C8532h(C8420a.this.f28551c.mo40203a());
            this.f28557c = 0;
        }

        /* renamed from: a */
        public C8548s mo40203a() {
            return this.f28555a;
        }

        /* renamed from: a */
        public long mo40202a(C8525c cVar, long j) throws IOException {
            try {
                long a = C8420a.this.f28551c.mo40202a(cVar, j);
                if (a > 0) {
                    this.f28557c += a;
                }
                return a;
            } catch (IOException e) {
                mo40270a(false, e);
                throw e;
            }
        }

        /* access modifiers changed from: protected|final */
        /* renamed from: a */
        public final void mo40270a(boolean z, IOException iOException) throws IOException {
            if (C8420a.this.f28553e != 6) {
                if (C8420a.this.f28553e == 5) {
                    C8420a.this.mo40265a(this.f28555a);
                    C8420a aVar = C8420a.this;
                    aVar.f28553e = 6;
                    if (aVar.f28550b != null) {
                        C8420a.this.f28550b.mo40304a(!z, C8420a.this, this.f28557c, iOException);
                    }
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("state: ");
                sb.append(C8420a.this.f28553e);
                throw new IllegalStateException(sb.toString());
            }
        }
    }

    /* compiled from: Http1Codec */
    /* renamed from: okhttp3.internal.c.a$b */
    private final class C8423b implements C8546q {
        /* renamed from: b */
        private final C8532h f28560b = new C8532h(C8420a.this.f28552d.mo40271a());
        /* renamed from: c */
        private boolean f28561c;

        C8423b() {
        }

        /* renamed from: a */
        public C8548s mo40271a() {
            return this.f28560b;
        }

        /* renamed from: a_ */
        public void mo40231a_(C8525c cVar, long j) throws IOException {
            if (this.f28561c) {
                throw new IllegalStateException("closed");
            } else if (j != 0) {
                C8420a.this.f28552d.mo40770k(j);
                String str = "\r\n";
                C8420a.this.f28552d.mo40738b(str);
                C8420a.this.f28552d.mo40231a_(cVar, j);
                C8420a.this.f28552d.mo40738b(str);
            }
        }

        public synchronized void flush() throws IOException {
            if (!this.f28561c) {
                C8420a.this.f28552d.flush();
            }
        }

        public synchronized void close() throws IOException {
            if (!this.f28561c) {
                this.f28561c = true;
                C8420a.this.f28552d.mo40738b("0\r\n\r\n");
                C8420a.this.mo40265a(this.f28560b);
                C8420a.this.f28553e = 3;
            }
        }
    }

    /* compiled from: Http1Codec */
    /* renamed from: okhttp3.internal.c.a$c */
    private class C8424c extends C8422a {
        /* renamed from: f */
        private final C8506t f28563f;
        /* renamed from: g */
        private long f28564g = -1;
        /* renamed from: h */
        private boolean f28565h = true;

        C8424c(C8506t tVar) {
            super();
            this.f28563f = tVar;
        }

        /* renamed from: a */
        public long mo40202a(C8525c cVar, long j) throws IOException {
            if (j < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("byteCount < 0: ");
                sb.append(j);
                throw new IllegalArgumentException(sb.toString());
            } else if (this.f28556b) {
                throw new IllegalStateException("closed");
            } else if (!this.f28565h) {
                return -1;
            } else {
                long j2 = this.f28564g;
                if (j2 == 0 || j2 == -1) {
                    m36079b();
                    if (!this.f28565h) {
                        return -1;
                    }
                }
                long a = super.mo40202a(cVar, Math.min(j, this.f28564g));
                if (a != -1) {
                    this.f28564g -= a;
                    return a;
                }
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                mo40270a(false, (IOException) protocolException);
                throw protocolException;
            }
        }

        /* renamed from: b */
        private void m36079b() throws IOException {
            if (this.f28564g != -1) {
                C8420a.this.f28551c.mo40778r();
            }
            try {
                this.f28564g = C8420a.this.f28551c.mo40775o();
                String trim = C8420a.this.f28551c.mo40778r().trim();
                if (this.f28564g < 0 || (!trim.isEmpty() && !trim.startsWith(";"))) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("expected chunk size and optional extensions but was \"");
                    sb.append(this.f28564g);
                    sb.append(trim);
                    sb.append("\"");
                    throw new ProtocolException(sb.toString());
                } else if (this.f28564g == 0) {
                    this.f28565h = false;
                    C8409e.m35981a(C8420a.this.f28549a.mo40603g(), this.f28563f, C8420a.this.mo40267d());
                    mo40270a(true, (IOException) null);
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        public void close() throws IOException {
            if (!this.f28556b) {
                if (this.f28565h && !C8417c.m36046a((C8547r) this, 100, TimeUnit.MILLISECONDS)) {
                    mo40270a(false, (IOException) null);
                }
                this.f28556b = true;
            }
        }
    }

    /* compiled from: Http1Codec */
    /* renamed from: okhttp3.internal.c.a$d */
    private final class C8425d implements C8546q {
        /* renamed from: b */
        private final C8532h f28567b = new C8532h(C8420a.this.f28552d.mo40271a());
        /* renamed from: c */
        private boolean f28568c;
        /* renamed from: d */
        private long f28569d;

        C8425d(long j) {
            this.f28569d = j;
        }

        /* renamed from: a */
        public C8548s mo40271a() {
            return this.f28567b;
        }

        /* renamed from: a_ */
        public void mo40231a_(C8525c cVar, long j) throws IOException {
            if (!this.f28568c) {
                C8417c.m36039a(cVar.mo40734b(), 0, j);
                if (j <= this.f28569d) {
                    C8420a.this.f28552d.mo40231a_(cVar, j);
                    this.f28569d -= j;
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("expected ");
                sb.append(this.f28569d);
                sb.append(" bytes but received ");
                sb.append(j);
                throw new ProtocolException(sb.toString());
            }
            throw new IllegalStateException("closed");
        }

        public void flush() throws IOException {
            if (!this.f28568c) {
                C8420a.this.f28552d.flush();
            }
        }

        public void close() throws IOException {
            if (!this.f28568c) {
                this.f28568c = true;
                if (this.f28569d <= 0) {
                    C8420a.this.mo40265a(this.f28567b);
                    C8420a.this.f28553e = 3;
                    return;
                }
                throw new ProtocolException("unexpected end of stream");
            }
        }
    }

    /* compiled from: Http1Codec */
    /* renamed from: okhttp3.internal.c.a$e */
    private class C8426e extends C8422a {
        /* renamed from: f */
        private long f28571f;

        C8426e(long j) throws IOException {
            super();
            this.f28571f = j;
            if (this.f28571f == 0) {
                mo40270a(true, (IOException) null);
            }
        }

        /* renamed from: a */
        public long mo40202a(C8525c cVar, long j) throws IOException {
            if (j < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("byteCount < 0: ");
                sb.append(j);
                throw new IllegalArgumentException(sb.toString());
            } else if (!this.f28556b) {
                long j2 = this.f28571f;
                if (j2 == 0) {
                    return -1;
                }
                long a = super.mo40202a(cVar, Math.min(j2, j));
                if (a != -1) {
                    this.f28571f -= a;
                    if (this.f28571f == 0) {
                        mo40270a(true, (IOException) null);
                    }
                    return a;
                }
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                mo40270a(false, (IOException) protocolException);
                throw protocolException;
            } else {
                throw new IllegalStateException("closed");
            }
        }

        public void close() throws IOException {
            if (!this.f28556b) {
                if (this.f28571f != 0 && !C8417c.m36046a((C8547r) this, 100, TimeUnit.MILLISECONDS)) {
                    mo40270a(false, (IOException) null);
                }
                this.f28556b = true;
            }
        }
    }

    /* compiled from: Http1Codec */
    /* renamed from: okhttp3.internal.c.a$f */
    private class C8427f extends C8422a {
        /* renamed from: f */
        private boolean f28573f;

        C8427f() {
            super();
        }

        /* renamed from: a */
        public long mo40202a(C8525c cVar, long j) throws IOException {
            if (j < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("byteCount < 0: ");
                sb.append(j);
                throw new IllegalArgumentException(sb.toString());
            } else if (this.f28556b) {
                throw new IllegalStateException("closed");
            } else if (this.f28573f) {
                return -1;
            } else {
                long a = super.mo40202a(cVar, j);
                if (a != -1) {
                    return a;
                }
                this.f28573f = true;
                mo40270a(true, (IOException) null);
                return -1;
            }
        }

        public void close() throws IOException {
            if (!this.f28556b) {
                if (!this.f28573f) {
                    mo40270a(false, (IOException) null);
                }
                this.f28556b = true;
            }
        }
    }

    public C8420a(C8513x xVar, C8434f fVar, C8529e eVar, C8528d dVar) {
        this.f28549a = xVar;
        this.f28550b = fVar;
        this.f28551c = eVar;
        this.f28552d = dVar;
    }

    /* renamed from: a */
    public C8546q mo40237a(C8518z zVar, long j) {
        if ("chunked".equalsIgnoreCase(zVar.mo40644a("Transfer-Encoding"))) {
            return mo40268e();
        }
        if (j != -1) {
            return mo40262a(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    /* renamed from: c */
    public void mo40241c() {
        C8430c c = this.f28550b.mo40306c();
        if (c != null) {
            c.mo40285b();
        }
    }

    /* renamed from: a */
    public void mo40239a(C8518z zVar) throws IOException {
        mo40264a(zVar.mo40648c(), C8413i.m36010a(zVar, this.f28550b.mo40306c().mo40277a().mo40131b().type()));
    }

    /* renamed from: a */
    public C8364ac mo40236a(C8362ab abVar) throws IOException {
        this.f28550b.f28607c.mo40514f(this.f28550b.f28606b);
        String b = abVar.mo40089b("Content-Type");
        if (!C8409e.m35988d(abVar)) {
            return new C8412h(b, 0, C8535k.m36849a(mo40266b(0)));
        }
        if ("chunked".equalsIgnoreCase(abVar.mo40089b("Transfer-Encoding"))) {
            return new C8412h(b, -1, C8535k.m36849a(mo40263a(abVar.mo40088a().mo40645a())));
        }
        long a = C8409e.m35978a(abVar);
        if (a != -1) {
            return new C8412h(b, a, C8535k.m36849a(mo40266b(a)));
        }
        return new C8412h(b, -1, C8535k.m36849a(mo40269f()));
    }

    /* renamed from: a */
    public void mo40238a() throws IOException {
        this.f28552d.flush();
    }

    /* renamed from: b */
    public void mo40240b() throws IOException {
        this.f28552d.flush();
    }

    /* renamed from: a */
    public void mo40264a(C8504s sVar, String str) throws IOException {
        if (this.f28553e == 0) {
            String str2 = "\r\n";
            this.f28552d.mo40738b(str).mo40738b(str2);
            int a = sVar.mo40531a();
            for (int i = 0; i < a; i++) {
                this.f28552d.mo40738b(sVar.mo40532a(i)).mo40738b(": ").mo40738b(sVar.mo40534b(i)).mo40738b(str2);
            }
            this.f28552d.mo40738b(str2);
            this.f28553e = 1;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("state: ");
        sb.append(this.f28553e);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: a */
    public C8363a mo40235a(boolean z) throws IOException {
        int i = this.f28553e;
        if (i == 1 || i == 3) {
            try {
                C8415k a = C8415k.m36021a(m36058g());
                C8363a a2 = new C8363a().mo40109a(a.f28525a).mo40105a(a.f28526b).mo40107a(a.f28527c).mo40113a(mo40267d());
                if (z && a.f28526b == 100) {
                    return null;
                }
                if (a.f28526b == 100) {
                    this.f28553e = 3;
                    return a2;
                }
                this.f28553e = 4;
                return a2;
            } catch (EOFException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("unexpected end of stream on ");
                sb.append(this.f28550b);
                IOException iOException = new IOException(sb.toString());
                iOException.initCause(e);
                throw iOException;
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("state: ");
            sb2.append(this.f28553e);
            throw new IllegalStateException(sb2.toString());
        }
    }

    /* renamed from: g */
    private String m36058g() throws IOException {
        String e = this.f28551c.mo40749e(this.f28554f);
        this.f28554f -= (long) e.length();
        return e;
    }

    /* renamed from: d */
    public C8504s mo40267d() throws IOException {
        C8505a aVar = new C8505a();
        while (true) {
            String g = m36058g();
            if (g.length() == 0) {
                return aVar.mo40543a();
            }
            C8388a.f28432a.mo40197a(aVar, g);
        }
    }

    /* renamed from: e */
    public C8546q mo40268e() {
        if (this.f28553e == 1) {
            this.f28553e = 2;
            return new C8423b();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("state: ");
        sb.append(this.f28553e);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: a */
    public C8546q mo40262a(long j) {
        if (this.f28553e == 1) {
            this.f28553e = 2;
            return new C8425d(j);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("state: ");
        sb.append(this.f28553e);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: b */
    public C8547r mo40266b(long j) throws IOException {
        if (this.f28553e == 4) {
            this.f28553e = 5;
            return new C8426e(j);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("state: ");
        sb.append(this.f28553e);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: a */
    public C8547r mo40263a(C8506t tVar) throws IOException {
        if (this.f28553e == 4) {
            this.f28553e = 5;
            return new C8424c(tVar);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("state: ");
        sb.append(this.f28553e);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: f */
    public C8547r mo40269f() throws IOException {
        if (this.f28553e == 4) {
            C8434f fVar = this.f28550b;
            if (fVar != null) {
                this.f28553e = 5;
                fVar.mo40308e();
                return new C8427f();
            }
            throw new IllegalStateException("streamAllocation == null");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("state: ");
        sb.append(this.f28553e);
        throw new IllegalStateException(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo40265a(C8532h hVar) {
        C8548s a = hVar.mo40802a();
        hVar.mo40801a(C8548s.f29055c);
        a.mo40806f();
        a.mo40810p_();
    }
}
