package epco;

import java.util.Arrays;
import java.util.Locale;

/* renamed from: epco.x */
public class C8008x extends C8006w {
    /* renamed from: g */
    private long f27236g;
    /* renamed from: h */
    private long f27237h;
    /* renamed from: i */
    private C7952b0[] f27238i;

    public C8008x(C8006w wVar) {
        mo38498b(wVar.mo38499c());
        mo38494a(wVar.mo38492a());
        mo38496a(wVar.mo38497b());
    }

    /* renamed from: a */
    public String mo38493a(C8012z zVar, Locale locale) {
        C7952b0[] b0VarArr = this.f27238i;
        if (b0VarArr.length > 0) {
            return b0VarArr[0].toString();
        }
        return null;
    }

    /* renamed from: a */
    public void mo38502a(long j) {
        this.f27237h = j;
    }

    /* renamed from: a */
    public void mo38503a(C7952b0[] b0VarArr) {
        this.f27238i = b0VarArr;
    }

    /* renamed from: b */
    public void mo38504b(long j) {
        this.f27236g = j;
    }

    /* renamed from: e */
    public long mo38505e() {
        return this.f27237h;
    }

    /* renamed from: f */
    public long mo38506f() {
        return this.f27236g;
    }

    /* renamed from: g */
    public C7952b0[] mo38507g() {
        return this.f27238i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ResourceMapEntry{parent=");
        sb.append(this.f27236g);
        sb.append(", count=");
        sb.append(this.f27237h);
        sb.append(", resourceTableMaps=");
        sb.append(Arrays.toString(this.f27238i));
        sb.append('}');
        return sb.toString();
    }
}
