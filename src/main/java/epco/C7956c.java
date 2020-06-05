package epco;

/* renamed from: epco.c */
public class C7956c {
    /* renamed from: a */
    public final String f27036a;
    /* renamed from: b */
    public final byte[] f27037b;

    public C7956c(String str, byte[] bArr) {
        this.f27036a = str;
        this.f27037b = bArr;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Icon{path='");
        sb.append(this.f27036a);
        sb.append('\'');
        sb.append(", size=");
        byte[] bArr = this.f27037b;
        sb.append(bArr == null ? 0 : bArr.length);
        sb.append('}');
        return sb.toString();
    }
}
