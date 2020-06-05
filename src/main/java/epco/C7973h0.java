package epco;

/* renamed from: epco.h0 */
public class C7973h0 {
    /* renamed from: a */
    private final C7970g0[] f27091a;

    public C7973h0(int i) {
        this.f27091a = new C7970g0[i];
    }

    /* renamed from: a */
    public int mo38351a() {
        return this.f27091a.length;
    }

    /* renamed from: a */
    public String mo38352a(String str) {
        C7970g0[] g0VarArr;
        for (C7970g0 g0Var : this.f27091a) {
            if (g0Var.mo38339a().equals(str)) {
                return g0Var.mo38349e();
            }
        }
        return null;
    }

    /* renamed from: a */
    public void mo38353a(int i, C7970g0 g0Var) {
        this.f27091a[i] = g0Var;
    }

    /* renamed from: a */
    public boolean mo38354a(String str, boolean z) {
        String a = mo38352a(str);
        return a == null ? z : Boolean.parseBoolean(a);
    }

    /* renamed from: b */
    public Integer mo38355b(String str) {
        String a = mo38352a(str);
        if (a == null) {
            return null;
        }
        return Integer.valueOf(a);
    }

    /* renamed from: b */
    public C7970g0[] mo38356b() {
        return this.f27091a;
    }

    /* renamed from: c */
    public Long mo38357c(String str) {
        String a = mo38352a(str);
        if (a == null) {
            return null;
        }
        return Long.valueOf(a);
    }
}
