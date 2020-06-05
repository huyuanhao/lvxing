package epco;

import android.util.SparseArray;
import java.util.Locale;

/* renamed from: epco.g0 */
public class C7970g0 {
    /* renamed from: a */
    private String f27084a;
    /* renamed from: b */
    private String f27085b;
    /* renamed from: c */
    private String f27086c;
    /* renamed from: d */
    private C7996r f27087d;
    /* renamed from: e */
    private String f27088e;

    /* renamed from: epco.g0$a */
    public static class C7971a {
        /* renamed from: a */
        private static final SparseArray<String> f27089a = C8005v0.m34685a();

        /* renamed from: a */
        public static String m34508a(long j) {
            String str = (String) f27089a.get((int) j);
            if (str != null) {
                return str;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("AttrId:0x");
            sb.append(Long.toHexString(j));
            return sb.toString();
        }
    }

    /* renamed from: a */
    public String mo38339a() {
        return this.f27085b;
    }

    /* renamed from: a */
    public String mo38340a(C8012z zVar, Locale locale) {
        String str = this.f27086c;
        if (str != null) {
            return str;
        }
        C7996r rVar = this.f27087d;
        return rVar != null ? rVar.mo38419a(zVar, locale) : "";
    }

    /* renamed from: a */
    public void mo38341a(C7996r rVar) {
        this.f27087d = rVar;
    }

    /* renamed from: a */
    public void mo38342a(String str) {
        this.f27085b = str;
    }

    /* renamed from: b */
    public String mo38343b() {
        return this.f27084a;
    }

    /* renamed from: b */
    public void mo38344b(String str) {
        this.f27084a = str;
    }

    /* renamed from: c */
    public String mo38345c() {
        return this.f27086c;
    }

    /* renamed from: c */
    public void mo38346c(String str) {
        this.f27086c = str;
    }

    /* renamed from: d */
    public C7996r mo38347d() {
        return this.f27087d;
    }

    /* renamed from: d */
    public void mo38348d(String str) {
        this.f27088e = str;
    }

    /* renamed from: e */
    public String mo38349e() {
        return this.f27088e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Attribute{name='");
        sb.append(this.f27085b);
        sb.append('\'');
        sb.append(", namespace='");
        sb.append(this.f27084a);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
