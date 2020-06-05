package mtopsdk.mtop.common;

import mtopsdk.mtop.domain.MtopResponse;

/* renamed from: mtopsdk.mtop.common.e */
public class MtopFinishEvent extends MtopEvent {
    /* renamed from: a */
    public MtopResponse f27912a;
    /* renamed from: b */
    public String f27913b;

    public MtopFinishEvent(MtopResponse mtopResponse) {
        this.f27912a = mtopResponse;
    }

    /* renamed from: a */
    public MtopResponse mo39769a() {
        return this.f27912a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("MtopFinishEvent [seqNo=");
        sb.append(this.f27913b);
        sb.append(", mtopResponse");
        sb.append(this.f27912a);
        sb.append("]");
        return sb.toString();
    }
}
