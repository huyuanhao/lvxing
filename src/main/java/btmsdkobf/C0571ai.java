package btmsdkobf;

import com.p522qq.p523e.comm.constants.Constants.KEYS;
import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: btmsdkobf.ai */
public final class C0571ai extends JceStruct implements Cloneable {
    /* renamed from: az */
    static final /* synthetic */ boolean f92az = (!C0571ai.class.desiredAssertionStatus());
    /* renamed from: bn */
    static ArrayList<C0573ak> f93bn = new ArrayList<>();
    /* renamed from: W */
    public int f94W = 0;
    /* renamed from: bm */
    public ArrayList<C0573ak> f95bm = null;

    static {
        f93bn.add(new C0573ak());
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f92az) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display(this.f94W, KEYS.RET);
        jceDisplayer.display((Collection<T>) this.f95bm, "mall_sections");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.f94W, true);
        jceDisplayer.displaySimple((Collection<T>) this.f95bm, false);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        C0571ai aiVar = (C0571ai) obj;
        if (JceUtil.equals(this.f94W, aiVar.f94W) && JceUtil.equals((Object) this.f95bm, (Object) aiVar.f95bm)) {
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
        this.f94W = jceInputStream.read(this.f94W, 0, true);
        this.f95bm = (ArrayList) jceInputStream.read(f93bn, 1, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f94W, 0);
        ArrayList<C0573ak> arrayList = this.f95bm;
        if (arrayList != null) {
            jceOutputStream.write((Collection<T>) arrayList, 1);
        }
    }
}
