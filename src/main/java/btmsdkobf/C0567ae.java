package btmsdkobf;

import com.p522qq.p523e.comm.constants.Constants.KEYS;
import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;

/* renamed from: btmsdkobf.ae */
public final class C0567ae extends JceStruct implements Cloneable {
    /* renamed from: az */
    static final /* synthetic */ boolean f61az = (!C0567ae.class.desiredAssertionStatus());
    /* renamed from: W */
    public int f62W = 0;
    /* renamed from: aV */
    public int f63aV = 0;
    /* renamed from: aW */
    public int f64aW = 0;

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f61az) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display(this.f62W, KEYS.RET);
        jceDisplayer.display(this.f63aV, "stock_full");
        jceDisplayer.display(this.f64aW, "exc_limit");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.f62W, true);
        jceDisplayer.displaySimple(this.f63aV, true);
        jceDisplayer.displaySimple(this.f64aW, false);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        C0567ae aeVar = (C0567ae) obj;
        if (JceUtil.equals(this.f62W, aeVar.f62W) && JceUtil.equals(this.f63aV, aeVar.f63aV) && JceUtil.equals(this.f64aW, aeVar.f64aW)) {
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
        this.f62W = jceInputStream.read(this.f62W, 0, true);
        this.f63aV = jceInputStream.read(this.f63aV, 1, false);
        this.f64aW = jceInputStream.read(this.f64aW, 2, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f62W, 0);
        jceOutputStream.write(this.f63aV, 1);
        jceOutputStream.write(this.f64aW, 2);
    }
}
