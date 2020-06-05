package btmsdkobf;

import com.p522qq.p523e.comm.constants.Constants.KEYS;
import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: btmsdkobf.ac */
public final class C0565ac extends JceStruct implements Cloneable {
    /* renamed from: aQ */
    static ArrayList<C0572aj> f51aQ = new ArrayList<>();
    /* renamed from: az */
    static final /* synthetic */ boolean f52az = (!C0565ac.class.desiredAssertionStatus());
    /* renamed from: W */
    public int f53W = 0;
    /* renamed from: aP */
    public ArrayList<C0572aj> f54aP = null;

    static {
        f51aQ.add(new C0572aj());
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f52az) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display(this.f53W, KEYS.RET);
        jceDisplayer.display((Collection<T>) this.f54aP, "mall_records");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.f53W, true);
        jceDisplayer.displaySimple((Collection<T>) this.f54aP, false);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        C0565ac acVar = (C0565ac) obj;
        if (JceUtil.equals(this.f53W, acVar.f53W) && JceUtil.equals((Object) this.f54aP, (Object) acVar.f54aP)) {
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
        this.f53W = jceInputStream.read(this.f53W, 0, true);
        this.f54aP = (ArrayList) jceInputStream.read(f51aQ, 1, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f53W, 0);
        ArrayList<C0572aj> arrayList = this.f54aP;
        if (arrayList != null) {
            jceOutputStream.write((Collection<T>) arrayList, 1);
        }
    }
}
