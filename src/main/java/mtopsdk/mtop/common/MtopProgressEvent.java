package mtopsdk.mtop.common;

@Deprecated
/* renamed from: mtopsdk.mtop.common.h */
public class MtopProgressEvent extends MtopEvent {
    /* renamed from: a */
    String f27917a;
    /* renamed from: b */
    int f27918b;
    /* renamed from: c */
    int f27919c;
    /* renamed from: d */
    public String f27920d;

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("MtopProgressEvent [seqNo=");
        sb.append(this.f27920d);
        sb.append(", desc=");
        sb.append(this.f27917a);
        sb.append(", size=");
        sb.append(this.f27918b);
        sb.append(", total=");
        sb.append(this.f27919c);
        sb.append("]");
        return sb.toString();
    }
}
