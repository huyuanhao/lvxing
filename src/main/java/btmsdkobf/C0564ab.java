package btmsdkobf;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;

/* renamed from: btmsdkobf.ab */
public final class C0564ab extends JceStruct implements Cloneable {
    /* renamed from: az */
    static final /* synthetic */ boolean f48az = (!C0564ab.class.desiredAssertionStatus());
    /* renamed from: ae */
    public int f49ae = 0;
    /* renamed from: ay */
    public long f50ay = 0;

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f48az) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display(this.f49ae, "product_id");
        jceDisplayer.display(this.f50ay, "ts");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.f49ae, true);
        jceDisplayer.displaySimple(this.f50ay, false);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        C0564ab abVar = (C0564ab) obj;
        if (JceUtil.equals(this.f49ae, abVar.f49ae) && JceUtil.equals(this.f50ay, abVar.f50ay)) {
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
        this.f49ae = jceInputStream.read(this.f49ae, 0, true);
        this.f50ay = jceInputStream.read(this.f50ay, 1, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f49ae, 0);
        jceOutputStream.write(this.f50ay, 1);
    }
}
