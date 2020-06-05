package com.tencent.qqpim.discovery.internal.model;

/* renamed from: com.tencent.qqpim.discovery.internal.model.a */
public class C7486a {
    /* renamed from: W */
    public int f25062W;
    /* renamed from: Wb */
    public int f25063Wb = -1;
    /* renamed from: Xb */
    public int f25064Xb = -1;
    /* renamed from: te */
    public C7491f f25065te;
    public int weight;

    public boolean isExpired() {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        C7491f fVar = this.f25065te;
        return fVar != null && fVar.f25098rc < currentTimeMillis;
    }

    /* renamed from: kb */
    public boolean mo36515kb() {
        return (this.f25063Wb == 0 || this.f25064Xb == 0) ? false : true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DbUnifiedData [phase=");
        sb.append(this.f25062W);
        sb.append(", displayMaxTimes=");
        sb.append(this.f25063Wb);
        sb.append(", clickMaxTimes=");
        sb.append(this.f25064Xb);
        sb.append(", weight=");
        sb.append(this.weight);
        sb.append(", unifiedAdData=");
        sb.append(this.f25065te);
        sb.append("]");
        return sb.toString();
    }
}
