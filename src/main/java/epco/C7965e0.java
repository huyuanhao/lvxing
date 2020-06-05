package epco;

/* renamed from: epco.e0 */
public class C7965e0 {
    /* renamed from: a */
    private long[] f27068a;
    /* renamed from: b */
    private String f27069b;
    /* renamed from: c */
    private short f27070c;

    public C7965e0(C7968f0 f0Var) {
        this.f27070c = f0Var.mo38335f();
    }

    /* renamed from: a */
    public void mo38317a(String str) {
        this.f27069b = str;
    }

    /* renamed from: a */
    public void mo38318a(short s) {
        this.f27070c = s;
    }

    /* renamed from: a */
    public void mo38319a(long[] jArr) {
        this.f27068a = jArr;
    }

    /* renamed from: a */
    public boolean mo38320a(int i) {
        return i < this.f27068a.length;
    }

    /* renamed from: a */
    public long[] mo38321a() {
        return this.f27068a;
    }

    /* renamed from: b */
    public short mo38322b() {
        return this.f27070c;
    }

    /* renamed from: c */
    public String mo38323c() {
        return this.f27069b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TypeSpec{name='");
        sb.append(this.f27069b);
        sb.append('\'');
        sb.append(", id=");
        sb.append(this.f27070c);
        sb.append('}');
        return sb.toString();
    }
}
