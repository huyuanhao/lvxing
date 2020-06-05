package epco;

import java.util.Locale;

/* renamed from: epco.w */
public class C8006w {
    /* renamed from: e */
    public static final int f27230e = 1;
    /* renamed from: f */
    public static final int f27231f = 2;
    /* renamed from: a */
    private int f27232a;
    /* renamed from: b */
    private int f27233b;
    /* renamed from: c */
    private String f27234c;
    /* renamed from: d */
    private C7996r f27235d;

    /* renamed from: a */
    public int mo38492a() {
        return this.f27233b;
    }

    /* renamed from: a */
    public String mo38493a(C8012z zVar, Locale locale) {
        C7996r rVar = this.f27235d;
        return rVar != null ? rVar.mo38419a(zVar, locale) : "null";
    }

    /* renamed from: a */
    public void mo38494a(int i) {
        this.f27233b = i;
    }

    /* renamed from: a */
    public void mo38495a(C7996r rVar) {
        this.f27235d = rVar;
    }

    /* renamed from: a */
    public void mo38496a(String str) {
        this.f27234c = str;
    }

    /* renamed from: b */
    public String mo38497b() {
        return this.f27234c;
    }

    /* renamed from: b */
    public void mo38498b(int i) {
        this.f27232a = i;
    }

    /* renamed from: c */
    public int mo38499c() {
        return this.f27232a;
    }

    /* renamed from: d */
    public C7996r mo38500d() {
        return this.f27235d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ResourceEntry{size=");
        sb.append(this.f27232a);
        sb.append(", flags=");
        sb.append(this.f27233b);
        sb.append(", key='");
        sb.append(this.f27234c);
        sb.append('\'');
        sb.append(", value=");
        sb.append(this.f27235d);
        sb.append('}');
        return sb.toString();
    }
}
