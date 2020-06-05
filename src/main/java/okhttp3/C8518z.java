package okhttp3;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import okhttp3.C8504s.C8505a;
import okhttp3.internal.C8417c;
import okhttp3.internal.p698b.C8410f;

/* compiled from: Request */
/* renamed from: okhttp3.z */
public final class C8518z {
    /* renamed from: a */
    final C8506t f28993a;
    /* renamed from: b */
    final String f28994b;
    /* renamed from: c */
    final C8504s f28995c;
    @Nullable
    /* renamed from: d */
    final C8358aa f28996d;
    /* renamed from: e */
    final Map<Class<?>, Object> f28997e;
    /* renamed from: f */
    private volatile C8377d f28998f;

    /* compiled from: Request */
    /* renamed from: okhttp3.z$a */
    public static class C8519a {
        /* renamed from: a */
        C8506t f28999a;
        /* renamed from: b */
        String f29000b;
        /* renamed from: c */
        C8505a f29001c;
        /* renamed from: d */
        C8358aa f29002d;
        /* renamed from: e */
        Map<Class<?>, Object> f29003e;

        public C8519a() {
            this.f29003e = Collections.emptyMap();
            this.f29000b = "GET";
            this.f29001c = new C8505a();
        }

        C8519a(C8518z zVar) {
            Map<Class<?>, Object> map;
            this.f29003e = Collections.emptyMap();
            this.f28999a = zVar.f28993a;
            this.f29000b = zVar.f28994b;
            this.f29002d = zVar.f28996d;
            if (zVar.f28997e.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = new LinkedHashMap<>(zVar.f28997e);
            }
            this.f29003e = map;
            this.f29001c = zVar.f28995c.mo40536b();
        }

        /* renamed from: a */
        public C8519a mo40660a(C8506t tVar) {
            if (tVar != null) {
                this.f28999a = tVar;
                return this;
            }
            throw new NullPointerException("url == null");
        }

        /* renamed from: a */
        public C8519a mo40655a(String str) {
            if (str != null) {
                if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("http:");
                    sb.append(str.substring(3));
                    str = sb.toString();
                } else {
                    if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("https:");
                        sb2.append(str.substring(4));
                        str = sb2.toString();
                    }
                }
                return mo40660a(C8506t.m36546f(str));
            }
            throw new NullPointerException("url == null");
        }

        /* renamed from: a */
        public C8519a mo40656a(String str, String str2) {
            this.f29001c.mo40547c(str, str2);
            return this;
        }

        /* renamed from: b */
        public C8519a mo40662b(String str, String str2) {
            this.f29001c.mo40542a(str, str2);
            return this;
        }

        /* renamed from: b */
        public C8519a mo40661b(String str) {
            this.f29001c.mo40544b(str);
            return this;
        }

        /* renamed from: a */
        public C8519a mo40659a(C8504s sVar) {
            this.f29001c = sVar.mo40536b();
            return this;
        }

        /* renamed from: a */
        public C8519a mo40654a() {
            return mo40657a("HEAD", (C8358aa) null);
        }

        /* renamed from: a */
        public C8519a mo40658a(C8358aa aaVar) {
            return mo40657a("POST", aaVar);
        }

        /* renamed from: a */
        public C8519a mo40657a(String str, @Nullable C8358aa aaVar) {
            if (str == null) {
                throw new NullPointerException("method == null");
            } else if (str.length() != 0) {
                String str2 = "method ";
                if (aaVar != null && !C8410f.m35992c(str)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(str);
                    sb.append(" must not have a request body.");
                    throw new IllegalArgumentException(sb.toString());
                } else if (aaVar != null || !C8410f.m35991b(str)) {
                    this.f29000b = str;
                    this.f29002d = aaVar;
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

        /* renamed from: b */
        public C8518z mo40663b() {
            if (this.f28999a != null) {
                return new C8518z(this);
            }
            throw new IllegalStateException("url == null");
        }
    }

    C8518z(C8519a aVar) {
        this.f28993a = aVar.f28999a;
        this.f28994b = aVar.f29000b;
        this.f28995c = aVar.f29001c.mo40543a();
        this.f28996d = aVar.f29002d;
        this.f28997e = C8417c.m36036a(aVar.f29003e);
    }

    /* renamed from: a */
    public C8506t mo40645a() {
        return this.f28993a;
    }

    /* renamed from: b */
    public String mo40646b() {
        return this.f28994b;
    }

    /* renamed from: c */
    public C8504s mo40648c() {
        return this.f28995c;
    }

    @Nullable
    /* renamed from: a */
    public String mo40644a(String str) {
        return this.f28995c.mo40533a(str);
    }

    /* renamed from: b */
    public List<String> mo40647b(String str) {
        return this.f28995c.mo40535b(str);
    }

    @Nullable
    /* renamed from: d */
    public C8358aa mo40649d() {
        return this.f28996d;
    }

    /* renamed from: e */
    public C8519a mo40650e() {
        return new C8519a(this);
    }

    /* renamed from: f */
    public C8377d mo40651f() {
        C8377d dVar = this.f28998f;
        if (dVar != null) {
            return dVar;
        }
        C8377d a = C8377d.m35861a(this.f28995c);
        this.f28998f = a;
        return a;
    }

    /* renamed from: g */
    public boolean mo40652g() {
        return this.f28993a.mo40551c();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.f28994b);
        sb.append(", url=");
        sb.append(this.f28993a);
        sb.append(", tags=");
        sb.append(this.f28997e);
        sb.append('}');
        return sb.toString();
    }
}
