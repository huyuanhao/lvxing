package okhttp3;

import java.io.Closeable;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.C8504s.C8505a;

/* compiled from: Response */
/* renamed from: okhttp3.ab */
public final class C8362ab implements Closeable {
    /* renamed from: a */
    final C8518z f28214a;
    /* renamed from: b */
    final Protocol f28215b;
    /* renamed from: c */
    final int f28216c;
    /* renamed from: d */
    final String f28217d;
    @Nullable
    /* renamed from: e */
    final C8503r f28218e;
    /* renamed from: f */
    final C8504s f28219f;
    @Nullable
    /* renamed from: g */
    final C8364ac f28220g;
    @Nullable
    /* renamed from: h */
    final C8362ab f28221h;
    @Nullable
    /* renamed from: i */
    final C8362ab f28222i;
    @Nullable
    /* renamed from: j */
    final C8362ab f28223j;
    /* renamed from: k */
    final long f28224k;
    /* renamed from: l */
    final long f28225l;
    /* renamed from: m */
    private volatile C8377d f28226m;

    /* compiled from: Response */
    /* renamed from: okhttp3.ab$a */
    public static class C8363a {
        /* renamed from: a */
        C8518z f28227a;
        /* renamed from: b */
        Protocol f28228b;
        /* renamed from: c */
        int f28229c;
        /* renamed from: d */
        String f28230d;
        @Nullable
        /* renamed from: e */
        C8503r f28231e;
        /* renamed from: f */
        C8505a f28232f;
        /* renamed from: g */
        C8364ac f28233g;
        /* renamed from: h */
        C8362ab f28234h;
        /* renamed from: i */
        C8362ab f28235i;
        /* renamed from: j */
        C8362ab f28236j;
        /* renamed from: k */
        long f28237k;
        /* renamed from: l */
        long f28238l;

        public C8363a() {
            this.f28229c = -1;
            this.f28232f = new C8505a();
        }

        C8363a(C8362ab abVar) {
            this.f28229c = -1;
            this.f28227a = abVar.f28214a;
            this.f28228b = abVar.f28215b;
            this.f28229c = abVar.f28216c;
            this.f28230d = abVar.f28217d;
            this.f28231e = abVar.f28218e;
            this.f28232f = abVar.f28219f.mo40536b();
            this.f28233g = abVar.f28220g;
            this.f28234h = abVar.f28221h;
            this.f28235i = abVar.f28222i;
            this.f28236j = abVar.f28223j;
            this.f28237k = abVar.f28224k;
            this.f28238l = abVar.f28225l;
        }

        /* renamed from: a */
        public C8363a mo40114a(C8518z zVar) {
            this.f28227a = zVar;
            return this;
        }

        /* renamed from: a */
        public C8363a mo40109a(Protocol protocol) {
            this.f28228b = protocol;
            return this;
        }

        /* renamed from: a */
        public C8363a mo40105a(int i) {
            this.f28229c = i;
            return this;
        }

        /* renamed from: a */
        public C8363a mo40107a(String str) {
            this.f28230d = str;
            return this;
        }

        /* renamed from: a */
        public C8363a mo40112a(@Nullable C8503r rVar) {
            this.f28231e = rVar;
            return this;
        }

        /* renamed from: a */
        public C8363a mo40108a(String str, String str2) {
            this.f28232f.mo40547c(str, str2);
            return this;
        }

        /* renamed from: b */
        public C8363a mo40117b(String str, String str2) {
            this.f28232f.mo40542a(str, str2);
            return this;
        }

        /* renamed from: a */
        public C8363a mo40113a(C8504s sVar) {
            this.f28232f = sVar.mo40536b();
            return this;
        }

        /* renamed from: a */
        public C8363a mo40111a(@Nullable C8364ac acVar) {
            this.f28233g = acVar;
            return this;
        }

        /* renamed from: a */
        public C8363a mo40110a(@Nullable C8362ab abVar) {
            if (abVar != null) {
                m35798a("networkResponse", abVar);
            }
            this.f28234h = abVar;
            return this;
        }

        /* renamed from: b */
        public C8363a mo40118b(@Nullable C8362ab abVar) {
            if (abVar != null) {
                m35798a("cacheResponse", abVar);
            }
            this.f28235i = abVar;
            return this;
        }

        /* renamed from: a */
        private void m35798a(String str, C8362ab abVar) {
            if (abVar.f28220g != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(".body != null");
                throw new IllegalArgumentException(sb.toString());
            } else if (abVar.f28221h != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(".networkResponse != null");
                throw new IllegalArgumentException(sb2.toString());
            } else if (abVar.f28222i != null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(".cacheResponse != null");
                throw new IllegalArgumentException(sb3.toString());
            } else if (abVar.f28223j != null) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str);
                sb4.append(".priorResponse != null");
                throw new IllegalArgumentException(sb4.toString());
            }
        }

        /* renamed from: c */
        public C8363a mo40119c(@Nullable C8362ab abVar) {
            if (abVar != null) {
                m35799d(abVar);
            }
            this.f28236j = abVar;
            return this;
        }

        /* renamed from: d */
        private void m35799d(C8362ab abVar) {
            if (abVar.f28220g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        /* renamed from: a */
        public C8363a mo40106a(long j) {
            this.f28237k = j;
            return this;
        }

        /* renamed from: b */
        public C8363a mo40116b(long j) {
            this.f28238l = j;
            return this;
        }

        /* renamed from: a */
        public C8362ab mo40115a() {
            if (this.f28227a == null) {
                throw new IllegalStateException("request == null");
            } else if (this.f28228b == null) {
                throw new IllegalStateException("protocol == null");
            } else if (this.f28229c < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("code < 0: ");
                sb.append(this.f28229c);
                throw new IllegalStateException(sb.toString());
            } else if (this.f28230d != null) {
                return new C8362ab(this);
            } else {
                throw new IllegalStateException("message == null");
            }
        }
    }

    C8362ab(C8363a aVar) {
        this.f28214a = aVar.f28227a;
        this.f28215b = aVar.f28228b;
        this.f28216c = aVar.f28229c;
        this.f28217d = aVar.f28230d;
        this.f28218e = aVar.f28231e;
        this.f28219f = aVar.f28232f.mo40543a();
        this.f28220g = aVar.f28233g;
        this.f28221h = aVar.f28234h;
        this.f28222i = aVar.f28235i;
        this.f28223j = aVar.f28236j;
        this.f28224k = aVar.f28237k;
        this.f28225l = aVar.f28238l;
    }

    /* renamed from: a */
    public C8518z mo40088a() {
        return this.f28214a;
    }

    /* renamed from: b */
    public Protocol mo40090b() {
        return this.f28215b;
    }

    /* renamed from: c */
    public int mo40091c() {
        return this.f28216c;
    }

    /* renamed from: d */
    public boolean mo40093d() {
        int i = this.f28216c;
        return i >= 200 && i < 300;
    }

    /* renamed from: e */
    public String mo40094e() {
        return this.f28217d;
    }

    /* renamed from: f */
    public C8503r mo40095f() {
        return this.f28218e;
    }

    /* renamed from: a */
    public List<String> mo40087a(String str) {
        return this.f28219f.mo40535b(str);
    }

    @Nullable
    /* renamed from: b */
    public String mo40089b(String str) {
        return mo40086a(str, null);
    }

    @Nullable
    /* renamed from: a */
    public String mo40086a(String str, @Nullable String str2) {
        String a = this.f28219f.mo40533a(str);
        return a != null ? a : str2;
    }

    /* renamed from: g */
    public C8504s mo40096g() {
        return this.f28219f;
    }

    @Nullable
    /* renamed from: h */
    public C8364ac mo40097h() {
        return this.f28220g;
    }

    /* renamed from: i */
    public C8363a mo40098i() {
        return new C8363a(this);
    }

    @Nullable
    /* renamed from: j */
    public C8362ab mo40099j() {
        return this.f28221h;
    }

    @Nullable
    /* renamed from: k */
    public C8362ab mo40100k() {
        return this.f28223j;
    }

    /* renamed from: l */
    public C8377d mo40101l() {
        C8377d dVar = this.f28226m;
        if (dVar != null) {
            return dVar;
        }
        C8377d a = C8377d.m35861a(this.f28219f);
        this.f28226m = a;
        return a;
    }

    /* renamed from: m */
    public long mo40102m() {
        return this.f28224k;
    }

    /* renamed from: n */
    public long mo40103n() {
        return this.f28225l;
    }

    public void close() {
        C8364ac acVar = this.f28220g;
        if (acVar != null) {
            acVar.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Response{protocol=");
        sb.append(this.f28215b);
        sb.append(", code=");
        sb.append(this.f28216c);
        sb.append(", message=");
        sb.append(this.f28217d);
        sb.append(", url=");
        sb.append(this.f28214a.mo40645a());
        sb.append('}');
        return sb.toString();
    }
}
