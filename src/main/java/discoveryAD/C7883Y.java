package discoveryAD;

import java.util.Arrays;

/* renamed from: discoveryAD.Y */
public class C7883Y {
    /* renamed from: W */
    public int f26807W;
    /* renamed from: Wd */
    public String f26808Wd;
    /* renamed from: Xd */
    public long f26809Xd;
    public byte[] context;
    public int index;
    public int positionId;
    public long timeStamp;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ActionModel [index=");
        sb.append(this.index);
        sb.append(", activityID=");
        sb.append(this.f26808Wd);
        sb.append(", positionID=");
        sb.append(this.positionId);
        sb.append(", context=");
        sb.append(Arrays.toString(this.context));
        sb.append(", timestamp=");
        sb.append(this.timeStamp);
        sb.append(", phase=");
        sb.append(this.f26807W);
        sb.append(", specialtime=");
        sb.append(this.f26809Xd);
        sb.append("]");
        return sb.toString();
    }
}
