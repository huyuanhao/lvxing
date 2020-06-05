package mtopsdk.mtop.domain;

import java.util.Arrays;

/* renamed from: mtopsdk.mtop.domain.a */
public abstract class BaseOutDo {
    /* renamed from: a */
    private String f27922a;
    /* renamed from: b */
    private String f27923b;
    /* renamed from: c */
    private String[] f27924c;

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("BaseOutDo [api=");
        sb.append(this.f27922a);
        sb.append(", v=");
        sb.append(this.f27923b);
        sb.append(", ret=");
        sb.append(Arrays.toString(this.f27924c));
        sb.append("]");
        return sb.toString();
    }
}
