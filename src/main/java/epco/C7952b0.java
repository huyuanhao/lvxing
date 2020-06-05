package epco;

/* renamed from: epco.b0 */
public class C7952b0 {
    /* renamed from: a */
    private long f27009a;
    /* renamed from: b */
    private C7996r f27010b;
    /* renamed from: c */
    private String f27011c;

    /* renamed from: epco.b0$a */
    public static class C7953a {
        /* renamed from: a */
        public static final int f27012a = 65535;
        /* renamed from: b */
        public static final int f27013b = 1;
        /* renamed from: c */
        public static final int f27014c = 2;
        /* renamed from: d */
        public static final int f27015d = 4;
        /* renamed from: e */
        public static final int f27016e = 8;
        /* renamed from: f */
        public static final int f27017f = 16;
        /* renamed from: g */
        public static final int f27018g = 32;
        /* renamed from: h */
        public static final int f27019h = 64;
        /* renamed from: i */
        public static final int f27020i = 128;
        /* renamed from: j */
        public static final int f27021j = 65536;
        /* renamed from: k */
        public static final int f27022k = 131072;
    }

    /* renamed from: epco.b0$b */
    public static class C7954b {
        /* renamed from: a */
        public static final int f27023a = 16777216;
        /* renamed from: b */
        public static final int f27024b = 16777217;
        /* renamed from: c */
        public static final int f27025c = 16777218;
        /* renamed from: d */
        public static final int f27026d = 16777219;
        /* renamed from: e */
        public static final int f27027e = 16777220;
        /* renamed from: f */
        public static final int f27028f = 16777221;
        /* renamed from: g */
        public static final int f27029g = 16777222;
        /* renamed from: h */
        public static final int f27030h = 16777223;
        /* renamed from: i */
        public static final int f27031i = 16777224;
        /* renamed from: j */
        public static final int f27032j = 16777225;

        /* renamed from: a */
        public static int m34404a(int i) {
            return (i & 65535) | 33554432;
        }
    }

    /* renamed from: a */
    public String mo38266a() {
        return this.f27011c;
    }

    /* renamed from: a */
    public void mo38267a(long j) {
        this.f27009a = j;
    }

    /* renamed from: a */
    public void mo38268a(C7996r rVar) {
        this.f27010b = rVar;
    }

    /* renamed from: a */
    public void mo38269a(String str) {
        this.f27011c = str;
    }

    /* renamed from: b */
    public long mo38270b() {
        return this.f27009a;
    }

    /* renamed from: c */
    public C7996r mo38271c() {
        return this.f27010b;
    }

    public String toString() {
        return this.f27011c;
    }
}
