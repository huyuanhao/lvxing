package epco;

/* renamed from: epco.o0 */
public class C7989o0 {
    /* renamed from: a */
    private String f27133a;
    /* renamed from: b */
    private String f27134b;
    /* renamed from: c */
    private C7973h0 f27135c;

    /* renamed from: a */
    public C7973h0 mo38402a() {
        return this.f27135c;
    }

    /* renamed from: a */
    public void mo38403a(C7973h0 h0Var) {
        this.f27135c = h0Var;
    }

    /* renamed from: a */
    public void mo38404a(String str) {
        this.f27134b = str;
    }

    /* renamed from: b */
    public String mo38405b() {
        return this.f27134b;
    }

    /* renamed from: b */
    public void mo38406b(String str) {
        this.f27133a = str;
    }

    /* renamed from: c */
    public String mo38407c() {
        return this.f27133a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('<');
        String str = this.f27133a;
        if (str != null) {
            sb.append(str);
            sb.append(":");
        }
        sb.append(this.f27134b);
        sb.append('>');
        return sb.toString();
    }
}
