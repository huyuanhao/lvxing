package btmsdkobf;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: btmsdkobf.ak */
public final class C0573ak extends JceStruct implements Cloneable {
    /* renamed from: az */
    static final /* synthetic */ boolean f103az = (!C0573ak.class.desiredAssertionStatus());
    /* renamed from: bt */
    static ArrayList<C0568af> f104bt = new ArrayList<>();
    /* renamed from: bi */
    public int f105bi = 0;
    /* renamed from: br */
    public ArrayList<C0568af> f106br = null;
    /* renamed from: bs */
    public String f107bs = "";

    static {
        f104bt.add(new C0568af());
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f103az) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display(this.f105bi, "section_id");
        jceDisplayer.display((Collection<T>) this.f106br, "mall_items");
        jceDisplayer.display(this.f107bs, "section_name");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.f105bi, true);
        jceDisplayer.displaySimple((Collection<T>) this.f106br, true);
        jceDisplayer.displaySimple(this.f107bs, false);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        C0573ak akVar = (C0573ak) obj;
        if (JceUtil.equals(this.f105bi, akVar.f105bi) && JceUtil.equals((Object) this.f106br, (Object) akVar.f106br) && JceUtil.equals((Object) this.f107bs, (Object) akVar.f107bs)) {
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
        this.f105bi = jceInputStream.read(this.f105bi, 0, true);
        this.f106br = (ArrayList) jceInputStream.read(f104bt, 1, false);
        this.f107bs = jceInputStream.readString(2, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f105bi, 0);
        ArrayList<C0568af> arrayList = this.f106br;
        if (arrayList != null) {
            jceOutputStream.write((Collection<T>) arrayList, 1);
        }
        String str = this.f107bs;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }
}
