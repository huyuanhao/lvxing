package btmsdkobf;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;

/* renamed from: btmsdkobf.w */
public final class C0888w extends JceStruct implements Cloneable {
    /* renamed from: az */
    static final /* synthetic */ boolean f1080az = (!C0888w.class.desiredAssertionStatus());
    /* renamed from: ae */
    public int f1081ae = 0;
    /* renamed from: aq */
    public String f1082aq;
    /* renamed from: as */
    public String f1083as;
    /* renamed from: av */
    public int f1084av = 0;
    /* renamed from: aw */
    public int f1085aw = 0;
    /* renamed from: ax */
    public int f1086ax = 0;
    /* renamed from: ay */
    public long f1087ay = 0;

    public C0888w() {
        String str = "";
        this.f1082aq = str;
        this.f1083as = str;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f1080az) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display(this.f1081ae, "product_id");
        jceDisplayer.display(this.f1084av, "page");
        jceDisplayer.display(this.f1085aw, "page_size");
        jceDisplayer.display(this.f1086ax, "split_section");
        jceDisplayer.display(this.f1087ay, "ts");
        jceDisplayer.display(this.f1082aq, "account_id");
        jceDisplayer.display(this.f1083as, "guid");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.f1081ae, true);
        jceDisplayer.displaySimple(this.f1084av, true);
        jceDisplayer.displaySimple(this.f1085aw, true);
        jceDisplayer.displaySimple(this.f1086ax, true);
        jceDisplayer.displaySimple(this.f1087ay, true);
        jceDisplayer.displaySimple(this.f1082aq, true);
        jceDisplayer.displaySimple(this.f1083as, false);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        C0888w wVar = (C0888w) obj;
        if (JceUtil.equals(this.f1081ae, wVar.f1081ae) && JceUtil.equals(this.f1084av, wVar.f1084av) && JceUtil.equals(this.f1085aw, wVar.f1085aw) && JceUtil.equals(this.f1086ax, wVar.f1086ax) && JceUtil.equals(this.f1087ay, wVar.f1087ay) && JceUtil.equals((Object) this.f1082aq, (Object) wVar.f1082aq) && JceUtil.equals((Object) this.f1083as, (Object) wVar.f1083as)) {
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
        this.f1081ae = jceInputStream.read(this.f1081ae, 0, true);
        this.f1084av = jceInputStream.read(this.f1084av, 1, false);
        this.f1085aw = jceInputStream.read(this.f1085aw, 2, false);
        this.f1086ax = jceInputStream.read(this.f1086ax, 3, false);
        this.f1087ay = jceInputStream.read(this.f1087ay, 4, false);
        this.f1082aq = jceInputStream.readString(5, false);
        this.f1083as = jceInputStream.readString(6, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f1081ae, 0);
        jceOutputStream.write(this.f1084av, 1);
        jceOutputStream.write(this.f1085aw, 2);
        jceOutputStream.write(this.f1086ax, 3);
        jceOutputStream.write(this.f1087ay, 4);
        String str = this.f1082aq;
        if (str != null) {
            jceOutputStream.write(str, 5);
        }
        String str2 = this.f1083as;
        if (str2 != null) {
            jceOutputStream.write(str2, 6);
        }
    }
}
