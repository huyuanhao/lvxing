package epco;

import java.util.Locale;

/* renamed from: epco.i0 */
public class C7975i0 {
    /* renamed from: d */
    public static final String f27096d = "<![CDATA[";
    /* renamed from: e */
    public static final String f27097e = "]]>";
    /* renamed from: a */
    private String f27098a;
    /* renamed from: b */
    private C7996r f27099b;
    /* renamed from: c */
    private String f27100c;

    /* renamed from: a */
    public String mo38361a() {
        return this.f27098a;
    }

    /* renamed from: a */
    public String mo38362a(C8012z zVar, Locale locale) {
        String str = this.f27098a;
        String str2 = f27097e;
        String str3 = f27096d;
        if (str != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            sb.append(this.f27098a);
            sb.append(str2);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str3);
        sb2.append(this.f27099b.mo38419a(zVar, locale));
        sb2.append(str2);
        return sb2.toString();
    }

    /* renamed from: a */
    public void mo38363a(C7996r rVar) {
        this.f27099b = rVar;
    }

    /* renamed from: a */
    public void mo38364a(String str) {
        this.f27098a = str;
    }

    /* renamed from: b */
    public C7996r mo38365b() {
        return this.f27099b;
    }

    /* renamed from: b */
    public void mo38366b(String str) {
        this.f27100c = str;
    }

    /* renamed from: c */
    public String mo38367c() {
        return this.f27100c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("XmlCData{data='");
        sb.append(this.f27098a);
        sb.append('\'');
        sb.append(", typedData=");
        sb.append(this.f27099b);
        sb.append('}');
        return sb.toString();
    }
}
