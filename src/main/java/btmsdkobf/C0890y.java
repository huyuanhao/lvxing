package btmsdkobf;

import com.p522qq.p523e.comm.constants.Constants.KEYS;
import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: btmsdkobf.y */
public final class C0890y extends JceStruct implements Cloneable {
    /* renamed from: aI */
    static ArrayList<C0889x> f1096aI = new ArrayList<>();
    /* renamed from: az */
    static final /* synthetic */ boolean f1097az = (!C0890y.class.desiredAssertionStatus());
    /* renamed from: W */
    public int f1098W = 0;
    /* renamed from: aH */
    public ArrayList<C0889x> f1099aH = null;

    static {
        f1096aI.add(new C0889x());
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f1097az) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display(this.f1098W, KEYS.RET);
        jceDisplayer.display((Collection<T>) this.f1099aH, "act_block");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.f1098W, true);
        jceDisplayer.displaySimple((Collection<T>) this.f1099aH, false);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        C0890y yVar = (C0890y) obj;
        if (JceUtil.equals(this.f1098W, yVar.f1098W) && JceUtil.equals((Object) this.f1099aH, (Object) yVar.f1099aH)) {
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
        this.f1098W = jceInputStream.read(this.f1098W, 0, true);
        this.f1099aH = (ArrayList) jceInputStream.read(f1096aI, 1, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f1098W, 0);
        ArrayList<C0889x> arrayList = this.f1099aH;
        if (arrayList != null) {
            jceOutputStream.write((Collection<T>) arrayList, 1);
        }
    }
}
