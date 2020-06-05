package btmsdkobf;

import com.p522qq.p523e.comm.constants.Constants.KEYS;
import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: btmsdkobf.aa */
public final class C0563aa extends JceStruct implements Cloneable {
    /* renamed from: aO */
    static ArrayList<C0891z> f44aO = new ArrayList<>();
    /* renamed from: az */
    static final /* synthetic */ boolean f45az = (!C0563aa.class.desiredAssertionStatus());
    /* renamed from: W */
    public int f46W = 0;
    /* renamed from: aN */
    public ArrayList<C0891z> f47aN = null;

    static {
        f44aO.add(new C0891z());
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f45az) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display(this.f46W, KEYS.RET);
        jceDisplayer.display((Collection<T>) this.f47aN, "banners");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.f46W, true);
        jceDisplayer.displaySimple((Collection<T>) this.f47aN, false);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        C0563aa aaVar = (C0563aa) obj;
        if (JceUtil.equals(this.f46W, aaVar.f46W) && JceUtil.equals((Object) this.f47aN, (Object) aaVar.f47aN)) {
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
        this.f46W = jceInputStream.read(this.f46W, 0, true);
        this.f47aN = (ArrayList) jceInputStream.read(f44aO, 1, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f46W, 0);
        ArrayList<C0891z> arrayList = this.f47aN;
        if (arrayList != null) {
            jceOutputStream.write((Collection<T>) arrayList, 1);
        }
    }
}
