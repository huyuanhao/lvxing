package epco;

/* renamed from: epco.m0 */
public class C7985m0 {
    /* renamed from: a */
    private String f27115a;
    /* renamed from: b */
    private String f27116b;

    /* renamed from: a */
    public String mo38386a() {
        return this.f27116b;
    }

    /* renamed from: a */
    public void mo38387a(String str) {
        this.f27116b = str;
    }

    /* renamed from: b */
    public String mo38388b() {
        return this.f27115a;
    }

    /* renamed from: b */
    public void mo38389b(String str) {
        this.f27115a = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("</");
        String str = this.f27115a;
        if (str != null) {
            sb.append(str);
            sb.append(":");
        }
        sb.append(this.f27116b);
        sb.append('>');
        return sb.toString();
    }
}
