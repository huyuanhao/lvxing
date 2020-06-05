package btmsdkobf;

import com.p522qq.p523e.comm.constants.Constants.KEYS;
import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;

/* renamed from: btmsdkobf.ad */
public final class C0566ad extends JceStruct implements Cloneable {
    /* renamed from: az */
    static final /* synthetic */ boolean f55az = (!C0566ad.class.desiredAssertionStatus());
    /* renamed from: W */
    public int f56W = 0;
    /* renamed from: aR */
    public int f57aR = 0;
    /* renamed from: aS */
    public int f58aS = 0;
    /* renamed from: aT */
    public int f59aT = 0;
    /* renamed from: aU */
    public String f60aU = "";

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f55az) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display(this.f56W, KEYS.RET);
        jceDisplayer.display(this.f57aR, "last_cnt");
        jceDisplayer.display(this.f58aS, "left_point");
        jceDisplayer.display(this.f59aT, "record_id");
        jceDisplayer.display(this.f60aU, "award");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.f56W, true);
        jceDisplayer.displaySimple(this.f57aR, true);
        jceDisplayer.displaySimple(this.f58aS, true);
        jceDisplayer.displaySimple(this.f59aT, true);
        jceDisplayer.displaySimple(this.f60aU, false);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        C0566ad adVar = (C0566ad) obj;
        if (JceUtil.equals(this.f56W, adVar.f56W) && JceUtil.equals(this.f57aR, adVar.f57aR) && JceUtil.equals(this.f58aS, adVar.f58aS) && JceUtil.equals(this.f59aT, adVar.f59aT) && JceUtil.equals((Object) this.f60aU, (Object) adVar.f60aU)) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f56W = jceInputStream.read(this.f56W, 0, true);
        this.f57aR = jceInputStream.read(this.f57aR, 1, false);
        this.f58aS = jceInputStream.read(this.f58aS, 2, false);
        this.f59aT = jceInputStream.read(this.f59aT, 3, false);
        this.f60aU = jceInputStream.readString(4, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f56W, 0);
        jceOutputStream.write(this.f57aR, 1);
        jceOutputStream.write(this.f58aS, 2);
        jceOutputStream.write(this.f59aT, 3);
        String str = this.f60aU;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
    }
}
