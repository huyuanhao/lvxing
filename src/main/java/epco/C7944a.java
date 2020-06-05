package epco;

import java.util.ArrayList;
import java.util.List;

/* renamed from: epco.a */
public class C7944a {
    /* renamed from: a */
    public final String f26980a;
    /* renamed from: b */
    public final String f26981b;
    /* renamed from: c */
    public final String f26982c;
    /* renamed from: d */
    public final String f26983d;
    /* renamed from: e */
    public final Long f26984e;
    /* renamed from: f */
    public final List<String> f26985f;

    /* renamed from: epco.a$b */
    public static final class C7946b {
        /* access modifiers changed from: private */
        /* renamed from: a */
        public String f26986a;
        /* access modifiers changed from: private */
        /* renamed from: b */
        public String f26987b;
        /* access modifiers changed from: private */
        /* renamed from: c */
        public String f26988c;
        /* access modifiers changed from: private */
        /* renamed from: d */
        public String f26989d;
        /* access modifiers changed from: private */
        /* renamed from: e */
        public Long f26990e;
        /* access modifiers changed from: private */
        /* renamed from: f */
        public List<String> f26991f;

        private C7946b() {
            this.f26991f = new ArrayList();
        }

        /* renamed from: a */
        public C7946b mo38248a(Long l) {
            this.f26990e = l;
            return this;
        }

        /* renamed from: a */
        public C7946b mo38249a(String str) {
            this.f26991f.add(str);
            return this;
        }

        /* renamed from: a */
        public C7944a mo38250a() {
            return new C7944a(this);
        }

        /* renamed from: b */
        public C7946b mo38251b(String str) {
            this.f26988c = str;
            return this;
        }

        /* renamed from: c */
        public C7946b mo38252c(String str) {
            this.f26987b = str;
            return this;
        }

        /* renamed from: d */
        public C7946b mo38253d(String str) {
            this.f26986a = str;
            return this;
        }

        /* renamed from: e */
        public C7946b mo38254e(String str) {
            this.f26989d = str;
            return this;
        }
    }

    private C7944a(C7946b bVar) {
        this.f26980a = bVar.f26986a;
        this.f26981b = bVar.f26987b;
        this.f26982c = bVar.f26988c;
        this.f26983d = bVar.f26989d;
        this.f26984e = bVar.f26990e;
        this.f26985f = bVar.f26991f;
    }

    /* renamed from: a */
    public static C7946b m34364a() {
        return new C7946b();
    }
}
