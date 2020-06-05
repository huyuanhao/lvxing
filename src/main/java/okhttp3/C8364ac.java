package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import javax.annotation.Nullable;
import okhttp3.internal.C8417c;
import okio.C8525c;
import okio.C8529e;

/* compiled from: ResponseBody */
/* renamed from: okhttp3.ac */
public abstract class C8364ac implements Closeable {
    /* renamed from: a */
    private Reader f28239a;

    /* compiled from: ResponseBody */
    /* renamed from: okhttp3.ac$a */
    static final class C8366a extends Reader {
        /* renamed from: a */
        private final C8529e f28243a;
        /* renamed from: b */
        private final Charset f28244b;
        /* renamed from: c */
        private boolean f28245c;
        /* renamed from: d */
        private Reader f28246d;

        C8366a(C8529e eVar, Charset charset) {
            this.f28243a = eVar;
            this.f28244b = charset;
        }

        public int read(char[] cArr, int i, int i2) throws IOException {
            if (!this.f28245c) {
                Reader reader = this.f28246d;
                if (reader == null) {
                    Reader inputStreamReader = new InputStreamReader(this.f28243a.mo40756g(), C8417c.m36033a(this.f28243a, this.f28244b));
                    this.f28246d = inputStreamReader;
                    reader = inputStreamReader;
                }
                return reader.read(cArr, i, i2);
            }
            throw new IOException("Stream closed");
        }

        public void close() throws IOException {
            this.f28245c = true;
            Reader reader = this.f28246d;
            if (reader != null) {
                reader.close();
            } else {
                this.f28243a.close();
            }
        }
    }

    @Nullable
    /* renamed from: a */
    public abstract C8510v mo40120a();

    /* renamed from: b */
    public abstract long mo40121b();

    /* renamed from: c */
    public abstract C8529e mo40122c();

    /* renamed from: d */
    public final InputStream mo40124d() {
        return mo40122c().mo40756g();
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: e */
    public final byte[] mo40125e() throws IOException {
        long b = mo40121b();
        if (b <= 2147483647L) {
            C8529e c = mo40122c();
            try {
                byte[] s = c.mo40780s();
                C8417c.m36040a((Closeable) c);
                if (b == -1 || b == ((long) s.length)) {
                    return s;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Content-Length (");
                sb.append(b);
                sb.append(") and stream length (");
                sb.append(s.length);
                sb.append(") disagree");
                throw new IOException(sb.toString());
            } catch (Throwable th) {
                C8417c.m36040a((Closeable) c);
                throw th;
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Cannot buffer entire body for content length: ");
            sb2.append(b);
            throw new IOException(sb2.toString());
        }
    }

    /* renamed from: f */
    public final Reader mo40126f() {
        Reader reader = this.f28239a;
        if (reader != null) {
            return reader;
        }
        C8366a aVar = new C8366a(mo40122c(), mo41303h());
        this.f28239a = aVar;
        return aVar;
    }

    /* renamed from: g */
    public final String mo40127g() throws IOException {
        C8529e c = mo40122c();
        try {
            return c.mo40721a(C8417c.m36033a(c, mo41303h()));
        } finally {
            C8417c.m36040a((Closeable) c);
        }
    }

    /* renamed from: h */
    private Charset mo41303h() {
        C8510v a = mo40120a();
        return a != null ? a.mo40588a(C8417c.f28532e) : C8417c.f28532e;
    }

    public void close() {
        C8417c.m36040a((Closeable) mo40122c());
    }

    /* renamed from: a */
    public static C8364ac m35816a(@Nullable C8510v vVar, String str) {
        Charset charset = C8417c.f28532e;
        if (vVar != null) {
            charset = vVar.mo40589b();
            if (charset == null) {
                charset = C8417c.f28532e;
                StringBuilder sb = new StringBuilder();
                sb.append(vVar);
                sb.append("; charset=utf-8");
                vVar = C8510v.m36598b(sb.toString());
            }
        }
        C8525c a = new C8525c().mo40726a(str, charset);
        return m35815a(vVar, a.mo40734b(), a);
    }

    /* renamed from: a */
    public static C8364ac m35817a(@Nullable C8510v vVar, byte[] bArr) {
        return m35815a(vVar, (long) bArr.length, new C8525c().mo40743c(bArr));
    }

    /* renamed from: a */
    public static C8364ac m35815a(@Nullable final C8510v vVar, final long j, final C8529e eVar) {
        if (eVar != null) {
            return new C8364ac() {
                @Nullable
                /* renamed from: a */
                public C8510v mo40120a() {
                    return C8510v.this;
                }

                /* renamed from: b */
                public long mo40121b() {
                    return j;
                }

                /* renamed from: c */
                public C8529e mo40122c() {
                    return eVar;
                }
            };
        }
        throw new NullPointerException("source == null");
    }
}
