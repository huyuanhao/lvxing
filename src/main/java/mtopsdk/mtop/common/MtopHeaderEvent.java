package mtopsdk.mtop.common;

import java.util.List;
import java.util.Map;

/* renamed from: mtopsdk.mtop.common.f */
public class MtopHeaderEvent extends MtopEvent {
    /* renamed from: a */
    public String f27914a;
    /* renamed from: b */
    private int f27915b;
    /* renamed from: c */
    private Map<String, List<String>> f27916c;

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("MtopHeaderEvent [seqNo=");
        sb.append(this.f27914a);
        sb.append(", code=");
        sb.append(this.f27915b);
        sb.append(", headers=");
        sb.append(this.f27916c);
        sb.append("]");
        return sb.toString();
    }
}
