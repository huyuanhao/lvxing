package okhttp3;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.internal.C8417c;
import okio.C8525c;
import okio.C8528d;

/* renamed from: okhttp3.q */
public final class FormBody extends C8358aa {
    /* renamed from: a */
    private static final C8510v f28875a = C8510v.m36597a("application/x-www-form-urlencoded");
    /* renamed from: b */
    private final List<String> f28876b;
    /* renamed from: c */
    private final List<String> f28877c;

    /* compiled from: FormBody */
    /* renamed from: okhttp3.q$a */
    public static final class C8502a {
        /* renamed from: a */
        private final List<String> f28878a;
        /* renamed from: b */
        private final List<String> f28879b;
        /* renamed from: c */
        private final Charset f28880c;

        public C8502a() {
            this(null);
        }

        public C8502a(Charset charset) {
            this.f28878a = new ArrayList();
            this.f28879b = new ArrayList();
            this.f28880c = charset;
        }

        /* renamed from: a */
        public C8502a mo40522a(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (str2 != null) {
                String str3 = str;
                this.f28878a.add(C8506t.m36536a(str3, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.f28880c));
                String str4 = str2;
                this.f28879b.add(C8506t.m36536a(str4, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.f28880c));
                return this;
            } else {
                throw new NullPointerException("value == null");
            }
        }

        /* renamed from: b */
        public C8502a mo40524b(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (str2 != null) {
                String str3 = str;
                this.f28878a.add(C8506t.m36536a(str3, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.f28880c));
                String str4 = str2;
                this.f28879b.add(C8506t.m36536a(str4, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.f28880c));
                return this;
            } else {
                throw new NullPointerException("value == null");
            }
        }

        /* renamed from: a */
        public FormBody mo40523a() {
            return new FormBody(this.f28878a, this.f28879b);
        }
    }

    FormBody(List<String> list, List<String> list2) {
        this.f28876b = C8417c.m36034a(list);
        this.f28877c = C8417c.m36034a(list2);
    }

    /* renamed from: a */
    public int mo40517a() {
        return this.f28876b.size();
    }

    /* renamed from: a */
    public String mo40518a(int i) {
        return (String) this.f28876b.get(i);
    }

    /* renamed from: b */
    public String mo40519b(int i) {
        return C8506t.m36537a(mo40518a(i), true);
    }

    /* renamed from: c */
    public String mo40520c(int i) {
        return (String) this.f28877c.get(i);
    }

    /* renamed from: d */
    public String mo40521d(int i) {
        return C8506t.m36537a(mo40520c(i), true);
    }

    /* renamed from: b */
    public C8510v mo40084b() {
        return f28875a;
    }

    /* renamed from: c */
    public long mo40085c() {
        return m36497a(null, true);
    }

    /* renamed from: a */
    public void mo40083a(C8528d dVar) throws IOException {
        m36497a(dVar, false);
    }

    /* renamed from: a */
    private long m36497a(@Nullable C8528d dVar, boolean z) {
        C8525c cVar;
        if (z) {
            cVar = new C8525c();
        } else {
            cVar = dVar.mo40741c();
        }
        int size = this.f28876b.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                cVar.mo40765i(38);
            }
            cVar.mo40738b((String) this.f28876b.get(i));
            cVar.mo40765i(61);
            cVar.mo40738b((String) this.f28877c.get(i));
        }
        if (!z) {
            return 0;
        }
        long b = cVar.mo40734b();
        cVar.mo40781t();
        return b;
    }
}
