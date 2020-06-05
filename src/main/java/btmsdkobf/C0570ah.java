package btmsdkobf;

import com.p522qq.p523e.comm.constants.Constants.KEYS;
import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;

/* renamed from: btmsdkobf.ah */
public final class C0570ah extends JceStruct implements Cloneable {
    /* renamed from: az */
    static final /* synthetic */ boolean f88az = (!C0570ah.class.desiredAssertionStatus());
    /* renamed from: bl */
    static C0568af f89bl = new C0568af();
    /* renamed from: W */
    public int f90W = 0;
    /* renamed from: bk */
    public C0568af f91bk = null;

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f88az) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display(this.f90W, KEYS.RET);
        jceDisplayer.display((JceStruct) this.f91bk, "mall_item");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.f90W, true);
        jceDisplayer.displaySimple((JceStruct) this.f91bk, false);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        C0570ah ahVar = (C0570ah) obj;
        if (JceUtil.equals(this.f90W, ahVar.f90W) && JceUtil.equals((Object) this.f91bk, (Object) ahVar.f91bk)) {
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
        this.f90W = jceInputStream.read(this.f90W, 0, true);
        this.f91bk = (C0568af) jceInputStream.read((JceStruct) f89bl, 1, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f90W, 0);
        C0568af afVar = this.f91bk;
        if (afVar != null) {
            jceOutputStream.write((JceStruct) afVar, 1);
        }
    }
}
