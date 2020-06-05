package mtopsdk.mtop.common;

/* renamed from: mtopsdk.mtop.common.b */
public class MtopCacheEvent extends MtopFinishEvent {
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("MtopCacheEvent [seqNo=");
        sb.append(this.f27913b);
        sb.append(", mtopResponse=");
        sb.append(this.f27912a);
        sb.append("]");
        return sb.toString();
    }
}
