package btmsdkobf;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: btmsdkobf.cj */
public final class C0650cj extends JceStruct implements Cloneable {
    /* renamed from: az */
    static final /* synthetic */ boolean f404az = (!C0650cj.class.desiredAssertionStatus());
    /* renamed from: fQ */
    static ArrayList<C0649ci> f405fQ;
    /* renamed from: fP */
    public ArrayList<C0649ci> f406fP = null;

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f404az) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public void display(StringBuilder sb, int i) {
        new JceDisplayer(sb, i).display((Collection<T>) this.f406fP, "vctCommList");
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return JceUtil.equals((Object) this.f406fP, (Object) ((C0650cj) obj).f406fP);
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
        if (f405fQ == null) {
            f405fQ = new ArrayList<>();
            f405fQ.add(new C0649ci());
        }
        this.f406fP = (ArrayList) jceInputStream.read(f405fQ, 0, true);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection<T>) this.f406fP, 0);
    }
}
